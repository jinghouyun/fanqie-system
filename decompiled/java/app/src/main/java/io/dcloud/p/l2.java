package io.dcloud.p;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class l2 {
    protected Path a;
    private int b;
    private float c;
    private k2 d;

    public l2() {
        this(new Path());
    }

    public int a() {
        return this.b;
    }

    public k2 b() {
        return this.d;
    }

    public Path c() {
        return this.a;
    }

    public float d() {
        return this.c;
    }

    public l2(Path path) {
        this(path, k2.DOODLE);
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(Canvas canvas, Paint paint) {
        if (this.d == k2.MOSAIC) {
            paint.setStrokeWidth(this.c);
            canvas.drawPath(this.a, paint);
        }
    }

    public l2(Path path, k2 k2Var) {
        this(path, k2Var, -65536);
    }

    public void a(k2 k2Var) {
        this.d = k2Var;
    }

    public l2(Path path, k2 k2Var, int i) {
        this(path, k2Var, i, 72.0f);
    }

    public void a(float f) {
        this.c = f;
    }

    public l2(Path path, k2 k2Var, int i, float f) {
        this.b = -65536;
        this.c = 72.0f;
        k2 k2Var2 = k2.NONE;
        this.a = path;
        this.d = k2Var;
        this.b = i;
        this.c = f;
        if (k2Var == k2.MOSAIC) {
            path.setFillType(Path.FillType.EVEN_ODD);
        }
    }

    public void a(Canvas canvas, Paint paint) {
        if (this.d == k2.DOODLE) {
            paint.setColor(this.b);
            paint.setStrokeWidth(this.c);
            canvas.drawPath(this.a, paint);
        }
    }

    public void a(Matrix matrix) {
        this.a.transform(matrix);
    }
}
