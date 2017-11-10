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

package li.klass.fhem.fragments.weekprofile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.common.base.Optional
import com.google.common.base.Preconditions.checkArgument
import com.google.common.collect.Lists.newArrayList
import kotlinx.android.synthetic.main.weekprofile.*
import kotlinx.android.synthetic.main.weekprofile.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import li.klass.fhem.R
import li.klass.fhem.adapter.weekprofile.BaseWeekProfileAdapter
import li.klass.fhem.constants.Actions
import li.klass.fhem.constants.BundleExtraKeys
import li.klass.fhem.constants.BundleExtraKeys.*
import li.klass.fhem.constants.ResultCodes
import li.klass.fhem.domain.core.FhemDevice
import li.klass.fhem.domain.heating.schedule.WeekProfile
import li.klass.fhem.domain.heating.schedule.configuration.HeatingConfiguration
import li.klass.fhem.domain.heating.schedule.interval.BaseHeatingInterval
import li.klass.fhem.fragments.core.BaseFragment
import li.klass.fhem.service.intent.DeviceIntentService
import li.klass.fhem.service.room.RoomListService
import li.klass.fhem.service.room.RoomListUpdateService
import li.klass.fhem.util.DialogUtil
import li.klass.fhem.util.FhemResultReceiver
import org.jetbrains.anko.coroutines.experimental.bg
import org.slf4j.LoggerFactory
import javax.inject.Inject

abstract class BaseWeekProfileFragment<INTERVAL : BaseHeatingInterval<INTERVAL>> : BaseFragment() {

    private lateinit var deviceName: String
    private lateinit var heatingConfiguration: HeatingConfiguration<INTERVAL, *>
    private lateinit var weekProfile: WeekProfile<INTERVAL, *>

    @Inject lateinit var roomListService: RoomListService
    @Inject lateinit var roomListUpdateService: RoomListUpdateService

    override fun setArguments(args: Bundle) {
        super.setArguments(args)

        checkArgument(args.containsKey(DEVICE_NAME))
        checkArgument(args.containsKey(HEATING_CONFIGURATION))

        deviceName = args.getString(DEVICE_NAME)
        heatingConfiguration = args.getSerializable(HEATING_CONFIGURATION)!! as HeatingConfiguration<INTERVAL, *>
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val superView = super.onCreateView(inflater, container, savedInstanceState)
        if (superView != null) return superView

        beforeCreateView()
        return inflater!!.inflate(R.layout.weekprofile, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        update(false)

        getAdapter().registerWeekProfileChangedListener(object : BaseWeekProfileAdapter.WeekProfileChangedListener {
            override fun onWeekProfileChanged(weekProfile: WeekProfile<*, *>) {
                LOGGER.info("onWeekProfileChanged() - {}", weekProfile.toString())
                updateChangeButtonsHolderVisibility(weekProfile!! as WeekProfile<INTERVAL, *>)
            }
        })

        change_value_button_holder.save_weekprofile_button.setOnClickListener { onSave() }
        change_value_button_holder.reset_weekprofile_button.setOnClickListener { onReset() }
        weekprofile.adapter = getAdapter();
    }

    fun onSave() {
        val commands = newArrayList(weekProfile.getStatesToSet())
        activity.startService(Intent(Actions.DEVICE_SET_SUB_STATES)
                .setClass(activity, DeviceIntentService::class.java)
                .putExtra(DEVICE_NAME, deviceName)
                .putExtra(BundleExtraKeys.STATES, commands)
                .putExtra(RESULT_RECEIVER, object : FhemResultReceiver() {
                    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                        if (resultCode != ResultCodes.SUCCESS) return
                        backToDevice()
                        update(true)
                    }
                }))
    }

    fun onReset() {
        update(false)
    }

    private fun backToDevice() {
        DialogUtil.showAlertDialog(activity, R.string.doneTitle, R.string.switchDelayNotification) { back() }
    }

    override fun update(refresh: Boolean) {
        async(UI) {
            val device = bg {
                if (refresh) {
                    roomListUpdateService.updateSingleDevice(deviceName, Optional.absent(), activity)
                }
                roomListService.getDeviceForName<FhemDevice>(deviceName, Optional.absent(), activity)
            }.await()
            if (device.isPresent) {
                weekProfile = heatingConfiguration.fillWith(device.get().xmlListDevice)
                updateChangeButtonsHolderVisibility(weekProfile)
            }
        }
    }

    private fun updateChangeButtonsHolderVisibility(weekProfile: WeekProfile<INTERVAL, *>) {
        updateAdapterWith(weekProfile)

        change_value_button_holder.visibility = when {
            weekProfile.getChangedDayProfiles().isEmpty() -> View.GONE
            else -> View.VISIBLE
        }
    }

    protected abstract fun updateAdapterWith(weekProfile: WeekProfile<INTERVAL, *>)

    protected abstract fun getAdapter(): BaseWeekProfileAdapter<*>

    protected open fun beforeCreateView() {}

    override fun mayPullToRefresh(): Boolean {
        return false
    }

    override fun mayUpdateFromBroadcast(): Boolean {
        return false
    }

    override fun getTitle(context: Context) = deviceName

    companion object {

        private val LOGGER = LoggerFactory.getLogger(BaseWeekProfileFragment::class.java)
    }
}