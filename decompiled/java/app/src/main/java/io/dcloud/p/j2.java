package io.dcloud.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class j2 {
    private static final Bitmap F = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    private Paint A;
    private Paint B;
    private Paint C;
    private Matrix D;
    private List E;
    private Bitmap a;
    private Bitmap b;
    private b c;
    private c2.a m;
    private k2 r;
    private boolean s;
    private RectF t;
    private boolean u;
    private boolean v;
    private m2 w;
    private List x;
    private List y;
    private List z;
    private RectF d = new RectF();
    private RectF e = new RectF();
    private RectF f = new RectF();
    private RectF g = new RectF();
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private boolean k = false;
    private boolean l = false;
    private boolean n = true;
    private Path o = new Path();
    private d2 p = new d2();
    private boolean q = false;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k2.values().length];
            a = iArr;
            try {
                iArr[k2.DOODLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k2.MOSAIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface c {
        void a();
    }

    public j2() {
        k2 k2Var = k2.NONE;
        this.r = k2Var;
        k2 k2Var2 = k2.CLIP;
        this.s = k2Var == k2Var2;
        this.t = new RectF();
        this.u = false;
        this.v = false;
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.D = new Matrix();
        this.o.setFillType(Path.FillType.WINDING);
        Paint paint = new Paint(1);
        this.A = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.A.setStrokeWidth(14.0f);
        this.A.setColor(-65536);
        this.A.setPathEffect(new CornerPathEffect(14.0f));
        this.A.setStrokeCap(Paint.Cap.ROUND);
        this.A.setStrokeJoin(Paint.Join.ROUND);
        this.E = new ArrayList();
        this.a = F;
        if (this.r == k2Var2) {
            g();
        }
    }

    private void b(float f) {
        this.D.setRotate(f, this.e.centerX(), this.e.centerY());
        for (m2 m2Var : this.x) {
            this.D.mapRect(m2Var.getFrame());
            m2Var.setRotation(m2Var.getRotation() + f);
            m2Var.setX(m2Var.getFrame().centerX() - m2Var.getPivotX());
            m2Var.setY(m2Var.getFrame().centerY() - m2Var.getPivotY());
        }
    }

    private void g() {
        if (this.C == null) {
            Paint paint = new Paint(1);
            this.C = paint;
            paint.setColor(-872415232);
            this.C.setStyle(Paint.Style.FILL);
        }
    }

    private void l() {
        Bitmap bitmap;
        if (this.b == null && (bitmap = this.a) != null && this.r == k2.MOSAIC) {
            int iRound = Math.round(bitmap.getWidth() / 64.0f);
            int iRound2 = Math.round(this.a.getHeight() / 64.0f);
            int iMax = Math.max(iRound, 8);
            int iMax2 = Math.max(iRound2, 8);
            if (this.B == null) {
                Paint paint = new Paint(1);
                this.B = paint;
                paint.setFilterBitmap(false);
                this.B.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            this.b = Bitmap.createScaledBitmap(this.a, iMax, iMax2, false);
        }
    }

    private void n() {
        this.u = false;
        h(this.t.width(), this.t.height());
        if (this.r == k2.CLIP) {
            this.p.a(this.e, f());
        }
    }

    private void o() {
        if (this.r == k2.CLIP) {
            this.p.a(this.e, f());
        }
    }

    private void v() {
        if (this.e.isEmpty()) {
            return;
        }
        float fMin = Math.min(this.t.width() / this.e.width(), this.t.height() / this.e.height());
        this.D.setScale(fMin, fMin, this.e.centerX(), this.e.centerY());
        this.D.postTranslate(this.t.centerX() - this.e.centerX(), this.t.centerY() - this.e.centerY());
        this.D.mapRect(this.d);
        this.D.mapRect(this.e);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a = bitmap;
        Bitmap bitmap2 = this.b;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.b = null;
        l();
        n();
    }

    public k2 c() {
        return this.r;
    }

    public void d(m2 m2Var) {
        b(m2Var);
    }

    public void e(m2 m2Var) {
        if (this.w == m2Var) {
            this.w = null;
        } else {
            this.x.remove(m2Var);
        }
    }

    public void f(m2 m2Var) {
        if (this.w != m2Var) {
            c(m2Var);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Bitmap bitmap = F;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public boolean h() {
        return this.y.isEmpty();
    }

    public boolean i() {
        return this.s;
    }

    public boolean j() {
        return this.v;
    }

    public boolean k() {
        return this.z.isEmpty();
    }

    public boolean m() {
        return this.p.b();
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
        Bitmap bitmap = this.a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a.recycle();
    }

    public void s() {
        e(d() - (d() % 360.0f));
        this.e.set(this.d);
        this.p.a(this.e, f());
    }

    public void t() {
        b(this.w);
    }

    public void u() {
        this.D.setScale(e(), e());
        Matrix matrix = this.D;
        RectF rectF = this.d;
        matrix.postTranslate(rectF.left, rectF.top);
        this.D.mapRect(this.e, this.g);
        float fD = d() % 360.0f;
        if (Math.abs(fD) >= 180.0f) {
            fD = 360.0f - Math.abs(fD);
        }
        c(fD);
        e(this.h);
        this.k = true;
    }

    public void w() {
        if (this.y.isEmpty()) {
            return;
        }
        List list = this.y;
        list.remove(list.size() - 1);
    }

    public void x() {
        if (this.z.isEmpty()) {
            return;
        }
        List list = this.z;
        list.remove(list.size() - 1);
    }

    private void d(float f, float f2) {
        this.d.set(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        this.e.set(this.d);
        this.p.d(f, f2);
        if (this.e.isEmpty()) {
            return;
        }
        v();
        this.u = true;
        o();
    }

    public g2 c(float f, float f2) {
        return new g2(f, f2, e(), d());
    }

    public void h(float f, float f2) {
        if (f == 0.0f || f2 == 0.0f) {
            return;
        }
        this.t.set(0.0f, 0.0f, f, f2);
        if (this.u) {
            this.D.setTranslate(this.t.centerX() - this.e.centerX(), this.t.centerY() - this.e.centerY());
            this.D.mapRect(this.d);
            this.D.mapRect(this.e);
        } else {
            d(f, f2);
        }
        this.p.d(f, f2);
        this.v = true;
        a();
    }

    private void c(m2 m2Var) {
        if (m2Var == null) {
            return;
        }
        b(this.w);
        if (m2Var.a()) {
            this.w = m2Var;
            this.x.remove(m2Var);
        } else {
            m2Var.b();
        }
    }

    public void f(Canvas canvas) {
        if (this.x.isEmpty()) {
            return;
        }
        canvas.save();
        for (m2 m2Var : this.x) {
            if (!m2Var.a()) {
                float x = m2Var.getX() + m2Var.getPivotX();
                float y = m2Var.getY() + m2Var.getPivotY();
                canvas.save();
                this.D.setTranslate(m2Var.getX(), m2Var.getY());
                this.D.postScale(m2Var.getScale(), m2Var.getScale(), x, y);
                this.D.postRotate(m2Var.getRotation(), x, y);
                canvas.concat(this.D);
                m2Var.a(canvas);
                canvas.restore();
            }
        }
        canvas.restore();
    }

    public void e(Canvas canvas) {
        this.D.setRotate(d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(this.f, this.p.c() ? this.d : this.e);
        canvas.clipRect(this.f);
    }

    public void g(float f, float f2) {
        b bVar;
        k2 k2Var = this.r;
        if ((k2Var == k2.DOODLE || k2Var == k2.MOSAIC) && (bVar = this.c) != null) {
            bVar.a();
        }
        if (this.m != null) {
            this.m = null;
        }
    }

    public RectF b() {
        return this.e;
    }

    public g2 b(float f, float f2) {
        g2 g2Var = new g2(f, f2, e(), f());
        if (this.r == k2.CLIP) {
            RectF rectF = new RectF(this.p.a());
            rectF.offset(f, f2);
            if (this.p.f()) {
                RectF rectF2 = new RectF();
                this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
                this.D.mapRect(rectF2, this.e);
                g2Var.a(s2.b(rectF, rectF2));
                return g2Var;
            }
            RectF rectF3 = new RectF();
            if (this.p.d()) {
                this.D.setRotate(f() - d(), this.e.centerX(), this.e.centerY());
                this.D.mapRect(rectF3, this.p.b(f, f2));
                g2Var.a(s2.b(rectF, rectF3, this.e.centerX(), this.e.centerY()));
                return g2Var;
            }
            this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
            this.D.mapRect(rectF3, this.d);
            g2Var.a(s2.a(rectF, rectF3, this.e.centerX(), this.e.centerY()));
            return g2Var;
        }
        RectF rectF4 = new RectF();
        this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(rectF4, this.e);
        RectF rectF5 = new RectF(this.t);
        rectF5.offset(f, f2);
        g2Var.a(s2.a(rectF5, rectF4, this.k));
        this.k = false;
        return g2Var;
    }

    public void e(float f, float f2) {
        this.n = true;
        m();
        this.p.d(true);
    }

    public int c(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(this.d, null, 31);
        if (!k()) {
            canvas.save();
            float fE = e();
            RectF rectF = this.d;
            canvas.translate(rectF.left, rectF.top);
            canvas.scale(fE, fE);
            Iterator it = this.z.iterator();
            while (it.hasNext()) {
                ((l2) it.next()).b(canvas, this.A);
            }
            canvas.restore();
        }
        return iSaveLayer;
    }

    public void e(float f) {
        this.j = f;
    }

    public float e() {
        return (this.d.width() * 1.0f) / this.a.getWidth();
    }

    public void d(Canvas canvas) {
        if (this.r == k2.CLIP && this.n) {
            this.o.reset();
            Path path = this.o;
            RectF rectF = this.d;
            path.addRect(rectF.left - 2.0f, rectF.top - 2.0f, rectF.right + 2.0f, rectF.bottom + 2.0f, Path.Direction.CW);
            this.o.addRect(this.e, Path.Direction.CCW);
            canvas.drawPath(this.o, this.C);
        }
    }

    public void a(k2 k2Var) {
        if (this.r == k2Var) {
            return;
        }
        b(this.w);
        k2 k2Var2 = k2.CLIP;
        if (k2Var == k2Var2) {
            c(true);
        }
        this.r = k2Var;
        if (k2Var == k2Var2) {
            g();
            this.h = d();
            this.g.set(this.e);
            float fE = 1.0f / e();
            Matrix matrix = this.D;
            RectF rectF = this.d;
            matrix.setTranslate(-rectF.left, -rectF.top);
            this.D.postScale(fE, fE);
            this.D.mapRect(this.g);
            this.p.a(this.e, f());
            return;
        }
        if (k2Var == k2.MOSAIC) {
            l();
        }
        this.p.a(false);
    }

    public void c(float f) {
        this.i = f;
    }

    public float d() {
        return this.i;
    }

    public void f(float f, float f2) {
        b bVar;
        this.n = false;
        b(this.w);
        k2 k2Var = this.r;
        if (k2Var == k2.CLIP) {
            this.m = this.p.a(f, f2);
            this.p.d(false);
        } else if ((k2Var == k2.DOODLE || k2Var == k2.MOSAIC) && (bVar = this.c) != null) {
            bVar.b();
        }
    }

    private void c(boolean z) {
        if (z != this.s) {
            b(z ? -d() : f());
            this.s = z;
        }
    }

    public void d(float f) {
        b(f, this.e.centerX(), this.e.centerY());
    }

    public float f() {
        return this.j;
    }

    public g2 a(float f, float f2) {
        RectF rectFB = this.p.b(f, f2);
        this.D.setRotate(-d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(this.e, rectFB);
        return new g2(f + (this.e.centerX() - rectFB.centerX()), f2 + (this.e.centerY() - rectFB.centerY()), e(), d());
    }

    private void b(m2 m2Var) {
        if (m2Var == null) {
            return;
        }
        if (!m2Var.a()) {
            if (!this.x.contains(m2Var)) {
                this.x.add(m2Var);
            }
            if (this.w == m2Var) {
                this.w = null;
                return;
            }
            return;
        }
        m2Var.dismiss();
    }

    public void a(m2 m2Var) {
        if (m2Var != null) {
            c(m2Var);
        }
    }

    public void a(l2 l2Var, float f, float f2) {
        if (l2Var == null) {
            return;
        }
        float fE = 1.0f / e();
        this.D.setTranslate(f, f2);
        this.D.postRotate(-d(), this.e.centerX(), this.e.centerY());
        Matrix matrix = this.D;
        RectF rectF = this.d;
        matrix.postTranslate(-rectF.left, -rectF.top);
        this.D.postScale(fE, fE);
        l2Var.a(this.D);
        int i = a.a[l2Var.b().ordinal()];
        if (i == 1) {
            l2Var.a(l2Var.d() * fE);
            this.y.add(l2Var);
        } else {
            if (i != 2) {
                return;
            }
            l2Var.a(l2Var.d() * fE);
            this.z.add(l2Var);
        }
    }

    public void b(c cVar) {
        List list = this.E;
        if (list != null) {
            list.remove(cVar);
        }
    }

    public void b(Canvas canvas) {
        canvas.clipRect(this.p.c() ? this.d : this.e);
        canvas.drawBitmap(this.a, (Rect) null, this.d, (Paint) null);
    }

    public void b(float f, float f2, float f3) {
        a(f / e(), f2, f3);
    }

    public void a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(cVar);
    }

    public void b(boolean z) {
        this.l = false;
        this.q = true;
    }

    public void b(int i) {
        this.p.a(i);
    }

    private void a() {
        List<c> list = this.E;
        if (list != null) {
            for (c cVar : list) {
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    public void a(Canvas canvas, int i) {
        canvas.drawBitmap(this.b, (Rect) null, this.d, this.B);
        canvas.restoreToCount(i);
    }

    public void a(Canvas canvas) {
        if (h()) {
            return;
        }
        canvas.save();
        float fE = e();
        RectF rectF = this.d;
        canvas.translate(rectF.left, rectF.top);
        canvas.scale(fE, fE);
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((l2) it.next()).a(canvas, this.A);
        }
        canvas.restore();
    }

    public void a(Canvas canvas, float f, float f2) {
        if (this.r == k2.CLIP) {
            this.p.a(canvas);
        }
    }

    public g2 a(float f, float f2, float f3, float f4) {
        if (this.r != k2.CLIP) {
            return null;
        }
        this.p.d(false);
        c2.a aVar = this.m;
        if (aVar == null) {
            return null;
        }
        this.p.a(aVar, f3, f4);
        RectF rectF = new RectF();
        this.D.setRotate(d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(rectF, this.d);
        RectF rectFB = this.p.b(f, f2);
        g2 g2Var = new g2(f, f2, e(), f());
        g2Var.a(s2.a(rectFB, rectF, this.e.centerX(), this.e.centerY()));
        return g2Var;
    }

    public void a(int i) {
        this.j = Math.round((this.i + i) / 90.0f) * 90;
        if (this.p.e()) {
            this.e.set(this.d);
        }
        this.p.a(this.e, f());
    }

    public void a(float f, float f2, float f3) {
        if (f == 1.0f) {
            return;
        }
        if (Math.max(this.e.width(), this.e.height()) >= 10000.0f || Math.min(this.e.width(), this.e.height()) <= 500.0f) {
            f += (1.0f - f) / 2.0f;
        }
        this.D.setScale(f, f, f2, f3);
        this.D.mapRect(this.d);
        this.D.mapRect(this.e);
        this.d.contains(this.e);
        for (m2 m2Var : this.x) {
            this.D.mapRect(m2Var.getFrame());
            float x = m2Var.getX() + m2Var.getPivotX();
            float y = m2Var.getY() + m2Var.getPivotY();
            m2Var.a(f);
            m2Var.setX((m2Var.getX() + m2Var.getFrame().centerX()) - x);
            m2Var.setY((m2Var.getY() + m2Var.getFrame().centerY()) - y);
        }
    }

    public void a(float f) {
        this.p.a(f);
    }

    public boolean a(float f, float f2, boolean z) {
        this.q = true;
        if (this.r == k2.CLIP) {
            boolean z2 = !this.l;
            this.p.b(false);
            this.p.a(true);
            this.p.c(false);
            return z2;
        }
        if (this.s && !this.l) {
            c(false);
        }
        return false;
    }

    public void a(boolean z) {
        this.l = true;
        Log.d("IMGImage", "Homing cancel");
    }

    public void a(int i, int i2) {
        d2 d2Var = this.p;
        if (d2Var != null) {
            d2Var.e(i, i2);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }
}
