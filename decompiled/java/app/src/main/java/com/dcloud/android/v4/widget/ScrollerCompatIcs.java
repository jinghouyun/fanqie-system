package com.dcloud.android.v4.widget;

import android.widget.OverScroller;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class ScrollerCompatIcs {
    ScrollerCompatIcs() {
    }

    public static float getCurrVelocity(Object obj) {
        return ((OverScroller) obj).getCurrVelocity();
    }
}
