package io.dcloud.sdk.core.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class MainHandlerUtil {
    private static volatile Handler a = new Handler(Looper.getMainLooper());

    public static Handler getMainHandler() {
        if (a == null) {
            synchronized (MainHandlerUtil.class) {
                if (a == null) {
                    a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return a;
    }
}
