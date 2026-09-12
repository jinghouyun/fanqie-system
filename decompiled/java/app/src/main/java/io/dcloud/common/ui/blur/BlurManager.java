package io.dcloud.common.ui.blur;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class BlurManager {
    private static BlurManager sInstance;
    private NativeBlurProcess nativeBlurProcess;

    private BlurManager() {
        if (this.nativeBlurProcess == null) {
            this.nativeBlurProcess = new NativeBlurProcess();
        }
    }

    public static BlurManager getInstance() {
        if (sInstance == null) {
            sInstance = new BlurManager();
        }
        return sInstance;
    }

    public Bitmap processNatively(Bitmap bitmap, int i, boolean z) {
        if (this.nativeBlurProcess == null) {
            this.nativeBlurProcess = new NativeBlurProcess();
        }
        if (bitmap == null) {
            return null;
        }
        return this.nativeBlurProcess.blur(bitmap, i, z);
    }
}
