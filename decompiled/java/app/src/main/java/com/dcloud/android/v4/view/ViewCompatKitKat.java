package com.dcloud.android.v4.view;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatKitKat {
    ViewCompatKitKat() {
    }

    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }
}
