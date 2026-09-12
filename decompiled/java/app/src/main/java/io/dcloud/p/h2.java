package io.dcloud.p;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class h2 extends ValueAnimator {
    private boolean a = false;
    private i2 b;

    public h2() {
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void a(g2 g2Var, g2 g2Var2) {
        setObjectValues(g2Var, g2Var2);
        this.a = g2.a(g2Var, g2Var2);
    }

    @Override // android.animation.ValueAnimator
    public void setObjectValues(Object... objArr) {
        super.setObjectValues(objArr);
        if (this.b == null) {
            this.b = new i2();
        }
        setEvaluator(this.b);
    }

    public boolean a() {
        return this.a;
    }
}
