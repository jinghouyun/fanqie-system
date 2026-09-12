package io.dcloud.p;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class x4 {
    private static x4 b;
    ThreadPoolExecutor a = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private x4() {
    }

    public static x4 a() {
        if (b == null) {
            synchronized (x4.class) {
                if (b == null) {
                    b = new x4();
                }
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
