package com.taobao.weex.utils;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXDeviceUtils {
    public static boolean isAutoResize(Context context) {
        if (context == null) {
            return false;
        }
        return isMateX(context) || isGalaxyFold(context);
    }

    public static boolean isGalaxyFold(Context context) {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-F9000".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMateX(Context context) {
        if (!"HUAWEI".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String str = Build.DEVICE;
        return "unknownRLI".equalsIgnoreCase(str) || "HWTAH".equalsIgnoreCase(str);
    }
}
