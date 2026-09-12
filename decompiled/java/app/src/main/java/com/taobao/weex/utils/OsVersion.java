package com.taobao.weex.utils;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class OsVersion {
    private static boolean sIsAtLeastJB_MR2;

    static {
        sIsAtLeastJB_MR2 = getApiVersion() >= 18;
    }

    public static int getApiVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isAtLeastJB_MR2() {
        return sIsAtLeastJB_MR2;
    }
}
