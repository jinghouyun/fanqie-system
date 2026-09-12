package com.dcloud.android.graphics;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class Region extends android.graphics.Region {
    private int HOLD_SCREEN_COUNT;
    int fillScreenCounter;

    public Region() {
        this(1);
    }

    public void count() {
        this.fillScreenCounter++;
    }

    public boolean fillWholeScreen() {
        return this.fillScreenCounter >= this.HOLD_SCREEN_COUNT;
    }

    public int getFillScreenCounter() {
        return this.fillScreenCounter;
    }

    public Region(int i) {
        this.fillScreenCounter = 1;
        this.HOLD_SCREEN_COUNT = i;
    }
}
