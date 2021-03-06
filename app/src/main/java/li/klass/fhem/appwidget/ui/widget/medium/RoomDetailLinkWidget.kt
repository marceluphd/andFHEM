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

package li.klass.fhem.appwidget.ui.widget.medium

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.RemoteViews
import li.klass.fhem.R
import li.klass.fhem.activities.AndFHEMMainActivity
import li.klass.fhem.appwidget.ui.widget.WidgetConfigurationCreatedCallback
import li.klass.fhem.appwidget.ui.widget.WidgetSize
import li.klass.fhem.appwidget.ui.widget.WidgetType
import li.klass.fhem.appwidget.ui.widget.base.RoomAppWidgetView
import li.klass.fhem.appwidget.update.WidgetConfiguration
import li.klass.fhem.constants.BundleExtraKeys
import li.klass.fhem.ui.FragmentType
import javax.inject.Inject

class RoomDetailLinkWidget @Inject constructor() : RoomAppWidgetView() {
    override fun createWidgetConfiguration(context: Context, appWidgetId: Int, callback: WidgetConfigurationCreatedCallback, vararg payload: String) {
        callback.widgetConfigurationCreated(WidgetConfiguration(appWidgetId, widgetType, null, payload.toList()))
    }

    override fun getWidgetName(): Int = R.string.widget_room_detail

    override fun getContentView(): Int = R.layout.appwidget_room_link

    override fun fillWidgetView(context: Context, view: RemoteViews, widgetConfiguration: WidgetConfiguration) {
        val roomName = widgetConfiguration.payload[0]

        view.setTextViewText(R.id.roomName, roomName)

        val openIntent = Intent(context, AndFHEMMainActivity::class.java)
        openIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        openIntent.putExtra(BundleExtraKeys.FRAGMENT, FragmentType.ROOM_DETAIL)
        openIntent.putExtra(BundleExtraKeys.ROOM_NAME, roomName)
        openIntent.putExtra("unique", "foobar://" + SystemClock.elapsedRealtime())

        view.setOnClickPendingIntent(R.id.layout, PendingIntent.getActivity(context,
                widgetConfiguration.widgetId, openIntent,
                PendingIntent.FLAG_UPDATE_CURRENT))
    }

    override val widgetSize = WidgetSize.MEDIUM

    override val widgetType = WidgetType.ROOM_DETAIL_LINK
}
