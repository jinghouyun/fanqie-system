package io.dcloud.p;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class p2 {
    private static final Matrix d = new Matrix();
    private View a;
    private float b;
    private float c;

    public p2(View view) {
        this.a = view;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            Matrix matrix = d;
            matrix.reset();
            matrix.setRotate(view.getRotation());
            return true;
        }
        if (actionMasked != 2) {
            return false;
        }
        float[] fArr = {motionEvent.getX() - this.b, motionEvent.getY() - this.c};
        d.mapPoints(fArr);
        view.setTranslationX(this.a.getTranslationX() + fArr[0]);
        view.setTranslationY(this.a.getTranslationY() + fArr[1]);
        return true;
    }
}
