package com.dcloud.android.v4.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class MotionEventCompatEclair {
    MotionEventCompatEclair() {
    }

    public static int findPointerIndex(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int getPointerCount(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int getPointerId(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float getX(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float getY(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
