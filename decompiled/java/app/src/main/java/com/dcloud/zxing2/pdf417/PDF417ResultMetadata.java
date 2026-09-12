package com.dcloud.zxing2.pdf417;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417ResultMetadata {
    private String fileId;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentIndex;

    public String getFileId() {
        return this.fileId;
    }

    public int[] getOptionalData() {
        return this.optionalData;
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public void setSegmentIndex(int i) {
        this.segmentIndex = i;
    }
}
