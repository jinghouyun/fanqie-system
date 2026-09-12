package com.dcloud.android.v4.view;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {
    WindowInsetsCompat() {
    }

    public WindowInsetsCompat consumeStableInsets() {
        return this;
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this;
    }

    public int getStableInsetBottom() {
        return 0;
    }

    public int getStableInsetLeft() {
        return 0;
    }

    public int getStableInsetRight() {
        return 0;
    }

    public int getStableInsetTop() {
        return 0;
    }

    public int getSystemWindowInsetBottom() {
        return 0;
    }

    public int getSystemWindowInsetLeft() {
        return 0;
    }

    public int getSystemWindowInsetRight() {
        return 0;
    }

    public int getSystemWindowInsetTop() {
        return 0;
    }

    public boolean hasInsets() {
        return false;
    }

    public boolean hasStableInsets() {
        return false;
    }

    public boolean hasSystemWindowInsets() {
        return false;
    }

    public boolean isConsumed() {
        return false;
    }

    public boolean isRound() {
        return false;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return this;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return this;
    }
}
