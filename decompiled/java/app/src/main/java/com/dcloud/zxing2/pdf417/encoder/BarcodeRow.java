package com.dcloud.zxing2.pdf417.encoder;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    BarcodeRow(int i) {
        this.row = new byte[i];
    }

    void addBar(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            set(i3, z);
        }
    }

    byte[] getScaledRow(int i) {
        int length = this.row.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.row[i2 / i];
        }
        return bArr;
    }

    void set(int i, byte b) {
        this.row[i] = b;
    }

    void set(int i, boolean z) {
        this.row[i] = z ? (byte) 1 : (byte) 0;
    }
}
