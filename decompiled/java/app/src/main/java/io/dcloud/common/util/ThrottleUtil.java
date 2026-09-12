package io.dcloud.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ThrottleUtil {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable readyToRun;

    public void throttlePost(final Runnable runnable, long j) {
        Runnable runnable2 = this.readyToRun;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        Runnable runnable3 = new Runnable() { // from class: io.dcloud.common.util.ThrottleUtil.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        };
        this.readyToRun = runnable3;
        this.handler.postDelayed(runnable3, j);
    }
}
