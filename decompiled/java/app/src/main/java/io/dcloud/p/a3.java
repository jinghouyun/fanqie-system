package io.dcloud.p;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a3 {
    private static volatile HandlerThread a = new HandlerThread("dcloud_thread", -19);
    private static volatile Handler b;

    static {
        a.start();
        b = new Handler(a.getLooper());
    }

    public static Handler a() {
        if (a == null || !a.isAlive()) {
            synchronized (a3.class) {
                if (a == null || !a.isAlive()) {
                    a = new HandlerThread("dcloud_thread", -19);
                    a.start();
                    b = new Handler(a.getLooper());
                }
            }
        }
        return b;
    }
}
