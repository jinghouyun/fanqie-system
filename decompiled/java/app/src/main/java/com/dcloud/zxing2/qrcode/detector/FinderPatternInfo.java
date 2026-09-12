package com.dcloud.zxing2.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class FinderPatternInfo {
    private final FinderPattern bottomLeft;
    private final FinderPattern topLeft;
    private final FinderPattern topRight;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.bottomLeft = finderPatternArr[0];
        this.topLeft = finderPatternArr[1];
        this.topRight = finderPatternArr[2];
    }

    public FinderPattern getBottomLeft() {
        return this.bottomLeft;
    }

    public FinderPattern getTopLeft() {
        return this.topLeft;
    }

    public FinderPattern getTopRight() {
        return this.topRight;
    }
}
