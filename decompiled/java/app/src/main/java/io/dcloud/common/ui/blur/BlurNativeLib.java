package io.dcloud.common.ui.blur;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class BlurNativeLib {
    static {
        System.loadLibrary("dcblur");
    }

    public static native void blurBitmap(Bitmap bitmap, int i, int i2, int i3, int i4);
}
