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
 * copy, or redistribute it subject to the terms and conditions of the GNU GENERAL PUBLICLICENSE, as published by the Free Software Foundation.
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

package li.klass.fhem.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import li.klass.fhem.R;
import li.klass.fhem.adapter.rooms.RoomListAdapter;
import li.klass.fhem.constants.Actions;
import li.klass.fhem.constants.BundleExtraKeys;
import li.klass.fhem.constants.ResultCodes;
import li.klass.fhem.fragments.core.ActionBarShowTabs;
import li.klass.fhem.fragments.core.BaseFragment;
import li.klass.fhem.fragments.core.TopLevelFragment;
import li.klass.fhem.util.advertisement.AdvertisementUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomListFragment extends BaseFragment implements ActionBarShowTabs, TopLevelFragment {

    private transient RoomListAdapter adapter;

    @SuppressWarnings("unused")
    public RoomListFragment(Bundle bundle) {
        super(bundle);
    }

    @SuppressWarnings("unused")
    public RoomListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View superView = super.onCreateView(inflater, container, savedInstanceState);
        if (superView != null) return superView;

        adapter = new RoomListAdapter(getActivity(), R.layout.room_list_name, new ArrayList<String>());
        View layout = inflater.inflate(R.layout.room_list, container, false);
        AdvertisementUtil.addAd(layout, getActivity());

        ListView roomList = (ListView) layout.findViewById(R.id.roomList);
        roomList.setAdapter(adapter);

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String roomName = String.valueOf(view.getTag());
                onClick(roomName);
            }
        });

        return layout;
    }

    protected void onClick(String roomName) {
        Intent intent = new Intent(Actions.SHOW_FRAGMENT);
        intent.putExtra(BundleExtraKeys.FRAGMENT, FragmentType.ROOM_DETAIL);
        intent.putExtra(BundleExtraKeys.ROOM_NAME, roomName);

        getActivity().sendBroadcast(intent);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(boolean doUpdate) {
        Intent intent = new Intent(Actions.GET_ROOM_NAME_LIST);
        intent.putExtras(new Bundle());
        intent.putExtra(BundleExtraKeys.DO_REFRESH, doUpdate);
        intent.putExtra(BundleExtraKeys.RESULT_RECEIVER, new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == ResultCodes.SUCCESS) {
                    super.onReceiveResult(resultCode, resultData);
                    List<String> roomList = (ArrayList<String>) resultData.getSerializable(BundleExtraKeys.ROOM_LIST);

                    String selectedRoom = (String) creationAttributes.get(BundleExtraKeys.ROOM_NAME);
                    adapter.updateData(roomList, selectedRoom);
                    scrollToSelectedRoom(selectedRoom, adapter.getData());
                }
            }
        });
        getActivity().startService(intent);
    }

    private void scrollToSelectedRoom(String selectedRoom, List<String> roomList) {
        if (selectedRoom == null) return;

        View view = getView();
        if (view == null) return;

        ListView roomListView = (ListView) view.findViewById(R.id.roomList);
        if (roomListView == null) return;

        for (int i = 0; i < roomList.size(); i++) {
            String roomName = roomList.get(i);
            if (roomName.equals(selectedRoom)) {
                roomListView.setSelection(i);
                return;
            }
        }
    }

    @Override
    protected void onContentChanged(Map<String, Serializable> oldCreationAttributes, Map<String, Serializable> newCreationAttributes) {
        super.onContentChanged(oldCreationAttributes, newCreationAttributes);
        if (oldCreationAttributes != null && ! doContentChangedAttributesMatch(oldCreationAttributes, newCreationAttributes, BundleExtraKeys.ROOM_NAME)) {
            update(false);
        }
    }
}
