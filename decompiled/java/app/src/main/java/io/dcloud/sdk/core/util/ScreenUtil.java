package io.dcloud.sdk.core.util;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class ScreenUtil {
    public static int dh(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int dw(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }
}
