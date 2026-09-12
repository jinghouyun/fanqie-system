package io.dcloud.feature.barcode2.decoding;

import android.graphics.Bitmap;
import com.dcloud.zxing2.LuminanceSource;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class BitmapLuminanceSource extends LuminanceSource {
    private byte[] bitmapPixels;

    protected BitmapLuminanceSource(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        this.bitmapPixels = new byte[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, getWidth(), 0, 0, getWidth(), getHeight());
        for (int i = 0; i < width; i++) {
            this.bitmapPixels[i] = (byte) iArr[i];
        }
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getMatrix() {
        return this.bitmapPixels;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        System.arraycopy(this.bitmapPixels, i * getWidth(), bArr, 0, getWidth());
        return bArr;
    }
}
