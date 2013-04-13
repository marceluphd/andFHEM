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

package li.klass.fhem.domain;

import li.klass.fhem.appwidget.annotation.ResourceIdMapper;
import li.klass.fhem.domain.core.Device;
import li.klass.fhem.domain.genericview.DetailOverviewViewSettings;
import li.klass.fhem.domain.genericview.ShowField;
import li.klass.fhem.util.ValueDescriptionUtil;
import li.klass.fhem.util.ValueExtractUtil;

@SuppressWarnings("unused")
@DetailOverviewViewSettings(showState = true, showMeasured = true)
public class FBDectDevice extends Device {
    @ShowField(description = ResourceIdMapper.energy)
    private String energy;

    @ShowField(description = ResourceIdMapper.power)
    private String power;

    @ShowField(description = ResourceIdMapper.voltage)
    private String voltage;

    @ShowField(description = ResourceIdMapper.cumulativeKwh)
    private String current;


    public void readENERGY(String value) {
        int numValue = ValueExtractUtil.extractLeadingInt(value);
        this.energy = ValueDescriptionUtil.append(numValue, "Wh");
    }

    public void readPOWER(String value) {
        double numValue = ValueExtractUtil.extractLeadingDouble(value);
        this.power = ValueDescriptionUtil.append(numValue, "W");
    }

    public void readVOLTAGE(String value) {
        double numValue = ValueExtractUtil.extractLeadingDouble(value);
        this.voltage = ValueDescriptionUtil.append(numValue, "V");
    }

    public void readCURRENT(String value) {
        double numValue = ValueExtractUtil.extractLeadingDouble(value);
        this.current = ValueDescriptionUtil.append(numValue, "A");
    }

    public String getEnergy() {
        return energy;
    }

    public String getPower() {
        return power;
    }

    public String getVoltage() {
        return voltage;
    }

    public String getCurrent() {
        return current;
    }
}
