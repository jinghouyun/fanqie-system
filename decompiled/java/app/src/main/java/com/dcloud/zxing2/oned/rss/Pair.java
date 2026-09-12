package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    int getCount() {
        return this.count;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    void incrementCount() {
        this.count++;
    }
}
