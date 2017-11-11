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

package li.klass.fhem.adapter.devices.core.generic.detail.actions;

import android.content.Context;

import com.google.common.base.Optional;

import java.util.List;

import li.klass.fhem.adapter.devices.core.deviceItems.DeviceViewItem;
import li.klass.fhem.adapter.devices.core.generic.detail.actions.action_card.ActionCardAction;
import li.klass.fhem.adapter.devices.core.generic.detail.actions.state.StateAttributeAction;
import li.klass.fhem.room.list.backend.xmllist.XmlListDevice;

public interface GenericDetailActionProvider {
    boolean supports(XmlListDevice xmlListDevice);

    /**
     * Actions that show up within the actions view.
     *
     * @param context context
     * @return list of actions
     */
    List<ActionCardAction> actionsFor(Context context);

    Optional<StateAttributeAction> stateAttributeActionFor(DeviceViewItem item);
}
