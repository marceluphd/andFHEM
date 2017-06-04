/*
 * AndFHEM - Open Source Android application to control a FHEM home automation
 *  server.
 *
 *  Copyright (c) 2012, Matthias Klass or third-party contributors as
 *  indicated by the @author tags or express copyright attribution
 *  statements applied by the authors.  All third-party contributions are
 *  distributed under license by Red Hat Inc.
 *
 *  This copyrighted material is made available to anyone wishing to use, modify,
 *  copy, or redistribute it subject to the terms and conditions of the GNU GENERAL PUBLICLICENSE, as published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU GENERAL PUBLIC LICENSE
 *  for more details.
 *
 *  You should have received a copy of the GNU GENERAL PUBLIC LICENSE
 *  along with this distribution; if not, write to:
 *    Free Software Foundation, Inc.
 *    51 Franklin Street, Fifth Floor
 */

package li.klass.fhem.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

public class DisplayUtil {
    public static int getLargestDimensionInDP(Context context) {
        return (int) dpToPx(getLargestDimensionInPx(context), context);
    }

    public static int getLargestDimensionInPx(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);

        return metrics.heightPixels > metrics.widthPixels ? metrics.heightPixels : metrics.widthPixels;
    }

    public static int getSmallestDimensionInPx(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);

        return metrics.heightPixels < metrics.widthPixels ? metrics.heightPixels : metrics.widthPixels;
    }

    public static int getWidthInDP(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);

        return metrics;
    }

    public static float dpToPx(int dp, Context context) {
        Resources resources = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }
}
