/*
 * AndFHEM - Open Source Android application to control a FHEM home automation
 * server.
 *
 * Copyright (c) 2011, Matthias Klass or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU GENERAL PUBLIC LICENSE, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU GENERAL PUBLIC LICENSE
 * for more details.
 *
 * You should have received a copy of the GNU GENERAL PUBLIC LICENSE
 * along with this distribution; if not, write to:
 *   Free Software Foundation, Inc.
 *   51 Franklin Street, Fifth Floor
 *   Boston, MA  02110-1301  USA
 */

package li.klass.fhem.service.room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import li.klass.fhem.AndFHEMApplication;
import li.klass.fhem.constants.Actions;
import li.klass.fhem.constants.BundleExtraKeys;
import li.klass.fhem.domain.Device;
import li.klass.fhem.domain.RoomDeviceList;
import li.klass.fhem.exception.AndFHEMException;
import li.klass.fhem.service.AbstractService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

import static li.klass.fhem.util.SharedPreferencesUtil.getSharedPreferences;
import static li.klass.fhem.util.SharedPreferencesUtil.getSharedPreferencesEditor;

public class RoomListService extends AbstractService {
    public static final RoomListService INSTANCE = new RoomListService();

    /**
     * Currently loaded device list map.
     */
    private volatile Map<String,RoomDeviceList> deviceListMap;

    /**
     * file name of the current cache object.
     */
    public static final String CACHE_FILENAME = "cache.obj";

    public static final String PREFERENCES_NAME = RoomListService.class.getName();
    public static final String LAST_UPDATE_PROPERTY = "LAST_UPDATE";

    public static final long NEVER_UPDATE_PERIOD = 0;
    public static final long ALWAYS_UPDATE_PERIOD = -1;

    private RoomListService() {
    }

    /**
     * Looks for a device with a given name.
     * @param deviceName name of the device
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return found device or null
     */
    public Device getDeviceForName(String deviceName, long updatePeriod) {
        return getAllRoomsDeviceList(updatePeriod).getDeviceFor(deviceName);
    }

    /**
     * Retrieves a list of all room names.
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return list of all room names
     */
    public ArrayList<String> getRoomNameList(long updatePeriod) {
        Map<String, RoomDeviceList> map = getRoomDeviceListMap(updatePeriod);
        ArrayList<String> roomNames = new ArrayList<String>(map.keySet());
        for (RoomDeviceList roomDeviceList : map.values()) {
            if (roomDeviceList.isOnlyLogDeviceRoom()) {
                roomNames.remove(roomDeviceList.getRoomName());
            } else if (roomDeviceList.getRoomName().equals(RoomDeviceList.ALL_DEVICES_ROOM)) {
                roomNames.remove(roomDeviceList.getRoomName());
            }
        }
        return roomNames;
    }

    /**
     * Gets or creates a new device list for a given room.
     * @param roomName room name used for searching
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return {@link RoomDeviceList} for a room
     */
    public RoomDeviceList getOrCreateRoomDeviceList(final String roomName, long updatePeriod) {
        Map<String, RoomDeviceList> map = getRoomDeviceListMap(updatePeriod);
        RoomDeviceList roomDeviceList = map.get(roomName);
        if (roomDeviceList == null) {
            roomDeviceList = new RoomDeviceList(roomName);
            map.put(roomName, roomDeviceList);
        }

        return roomDeviceList;
    }

    /**
     * Retrieves a {@link RoomDeviceList} containing all devices, not only the devices of a specific room.
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return {@link RoomDeviceList} containing all devices
     */
    public RoomDeviceList getAllRoomsDeviceList(long updatePeriod) {
        Map<String, RoomDeviceList> roomDeviceListMap = getRoomDeviceListMap(updatePeriod);
        RoomDeviceList allRoomsDeviceList = new RoomDeviceList(RoomDeviceList.ALL_DEVICES_ROOM);
        for (String room : roomDeviceListMap.keySet()) {
            for (Device device : roomDeviceListMap.get(room).getAllDevices()) {
                allRoomsDeviceList.addDevice(device);
            }
        }
        return allRoomsDeviceList;
    }

    /**
     * Retrieves the {@link RoomDeviceList} for a specific room name.
     * @param roomName room name used for searching.
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return found {@link RoomDeviceList} or null
     */
    public RoomDeviceList getDeviceListForRoom(String roomName, long updatePeriod) {
        return getRoomDeviceListMap(updatePeriod).get(roomName);
    }

    /**
     * Removes the {@link RoomDeviceList} being associated to the given room name.
     * @param roomName room name used for searching the room
     */
    public void removeDeviceListForRoom(String roomName) {
        getRoomDeviceListMap(NEVER_UPDATE_PERIOD).remove(roomName);
    }

    /**
     * Switch method deciding whether a FHEM has to be contacted, the cached list can be used or the map already has
     * been loaded to the deviceListMap attribute.
     * @param updatePeriod -1 if the underlying list should always be updated, otherwise do update if the last update is
     *                     longer ago than the given period
     * @return current room device list map
     */
    private Map<String, RoomDeviceList> getRoomDeviceListMap(long updatePeriod) {
        boolean refresh = shouldUpdate(updatePeriod);

        if (! refresh && deviceListMap == null) {
            deviceListMap = getCachedRoomDeviceListMap();
        }

        if (refresh || deviceListMap == null) {
            sendBroadcastWithAction(Actions.SHOW_UPDATING_DIALOG, null);
            try {
                deviceListMap = getRemoteRoomDeviceListMap();
            } catch (AndFHEMException e) {
                Bundle bundle = new Bundle();
                bundle.putInt(BundleExtraKeys.TOAST_STRING_ID, e.getErrorMessageStringId());
                sendBroadcastWithAction(Actions.SHOW_TOAST, bundle);

                Log.e(RoomListService.class.getName(), "error occurred", e);
            } finally {
                sendBroadcastWithAction(Actions.DISMISS_UPDATING_DIALOG, null);
            }
        }

        return deviceListMap;
    }

    /**
     * Loads the most current room device list map from FHEM and saves it to the cache.
     * @return remotely loaded room device list map
     */
    private Map<String, RoomDeviceList> getRemoteRoomDeviceListMap() {
        Map<String, RoomDeviceList> result = DeviceListParser.INSTANCE.listDevices();
        setLastUpdateToNow();
        return result;
    }

    /**
     * Stores the currently loaded room device list map to the cache file.
     */
    public void storeDeviceListMap() {
        Log.i(RoomListService.class.getName(), "storing device list to cache");
        Context context = AndFHEMApplication.getContext();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(CACHE_FILENAME, Context.MODE_PRIVATE));
            objectOutputStream.writeObject(deviceListMap);
        } catch (Exception e) {
            Log.e(RoomListService.class.getName(), "error occurred while serializing data", e);
        }
    }

    /**
     * Loads the currently cached room device list map data from the file storage.
     * @return cached room device list map
     */
    @SuppressWarnings("unchecked")
    private Map<String, RoomDeviceList> getCachedRoomDeviceListMap() {

        try {
            Log.i(RoomListService.class.getName(), "loading device list from cache");
            long startLoad = System.currentTimeMillis();

            ObjectInputStream objectInputStream = new ObjectInputStream(AndFHEMApplication.getContext().openFileInput(CACHE_FILENAME));
            Map<String, RoomDeviceList> roomDeviceListMap = (Map<String, RoomDeviceList>) objectInputStream.readObject();
            Log.i(RoomListService.class.getName(), "loading device list from cache completed after "
                    + ( System.currentTimeMillis() - startLoad) + "ms");

            return roomDeviceListMap;
        } catch (Exception e) {
            Log.d(RoomListService.class.getName(), "error occurred while de-serializing data", e);
            return null;
        }
    }

    private long getLastUpdate() {
        return getSharedPreferences(PREFERENCES_NAME).getLong(LAST_UPDATE_PROPERTY, 0L);
    }

    private void setLastUpdateToNow() {
        getSharedPreferencesEditor(PREFERENCES_NAME).putLong(LAST_UPDATE_PROPERTY, System.currentTimeMillis()).commit();
    }

    private boolean shouldUpdate(long updatePeriod) {
        if (updatePeriod == ALWAYS_UPDATE_PERIOD) return true;
        if (updatePeriod == NEVER_UPDATE_PERIOD) return false;

        long lastUpdate = getLastUpdate();
        return lastUpdate + updatePeriod < System.currentTimeMillis();
    }
}
