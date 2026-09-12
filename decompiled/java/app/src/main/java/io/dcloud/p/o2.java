package io.dcloud.p;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class o2 implements q2, q2.a {
    private RectF a;
    private View b;
    private q2.a c;
    private boolean d = false;

    public o2(View view) {
        this.b = view;
    }

    @Override // io.dcloud.p.q2
    public boolean a() {
        return this.d;
    }

    @Override // io.dcloud.p.q2
    public boolean b() {
        if (a()) {
            return false;
        }
        this.d = true;
        a(this.b);
        return true;
    }

    public boolean c() {
        return b(this.b);
    }

    @Override // io.dcloud.p.q2
    public boolean dismiss() {
        if (!a()) {
            return false;
        }
        this.d = false;
        c(this.b);
        return true;
    }

    @Override // io.dcloud.p.q2
    public RectF getFrame() {
        if (this.a == null) {
            this.a = new RectF(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
            float x = this.b.getX() + this.b.getPivotX();
            float y = this.b.getY() + this.b.getPivotY();
            Matrix matrix = new Matrix();
            matrix.setTranslate(this.b.getX(), this.b.getY());
            matrix.postScale(this.b.getScaleX(), this.b.getScaleY(), x, y);
            matrix.mapRect(this.a);
        }
        return this.a;
    }

    @Override // io.dcloud.p.q2
    public void a(q2.a aVar) {
        this.c = aVar;
    }

    @Override // io.dcloud.p.q2.a
    public void c(View view) {
        this.a = null;
        view.invalidate();
        q2.a aVar = this.c;
        if (aVar != null) {
            aVar.c(view);
        }
    }

    @Override // io.dcloud.p.q2.a
    public void a(View view) {
        view.invalidate();
        q2.a aVar = this.c;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    @Override // io.dcloud.p.q2
    public void b(q2.a aVar) {
        this.c = null;
    }

    @Override // io.dcloud.p.q2.a
    public boolean b(View view) {
        q2.a aVar = this.c;
        return aVar != null && aVar.b(view);
    }
}
