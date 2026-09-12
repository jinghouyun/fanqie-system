package io.dcloud.feature.gallery.imageedit.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import io.dcloud.p.g2;
import io.dcloud.p.h2;
import io.dcloud.p.j2;
import io.dcloud.p.k2;
import io.dcloud.p.l2;
import io.dcloud.p.m2;
import io.dcloud.p.p4;
import io.dcloud.p.q2;
import io.dcloud.p.r2;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class IMGView extends FrameLayout implements Runnable, ScaleGestureDetector.OnScaleGestureListener, ValueAnimator.AnimatorUpdateListener, q2.a, Animator.AnimatorListener {
    private k2 a;
    private j2 b;
    private GestureDetector c;
    private ScaleGestureDetector d;
    private h2 e;
    private c f;
    private int g;
    private Paint h;
    private Paint i;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements j2.c {
        a() {
        }

        @Override // io.dcloud.p.j2.c
        public void a() {
            IMGView.this.e();
            IMGView.this.b.b(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return IMGView.this.a(f, f2);
        }

        /* synthetic */ b(IMGView iMGView, a aVar) {
            this();
        }
    }

    public IMGView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        invalidate();
        j();
        a(this.b.c(getScrollX(), getScrollY()), this.b.b(getScrollX(), getScrollY()));
    }

    private boolean f(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return b(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                return c(motionEvent);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        return this.f.b(motionEvent.getPointerId(0)) && f();
    }

    private void j() {
        h2 h2Var = this.e;
        if (h2Var != null) {
            h2Var.cancel();
        }
    }

    public void c() {
        if (d()) {
            return;
        }
        this.b.a(-90);
        e();
    }

    boolean d() {
        h2 h2Var = this.e;
        return h2Var != null && h2Var.isRunning();
    }

    boolean g() {
        Log.d("IMGView", "onSteady: isHoming=" + d());
        if (d()) {
            return false;
        }
        this.b.e(getScrollX(), getScrollY());
        e();
        return true;
    }

    public k2 getMode() {
        return this.b.c();
    }

    public void h() {
        this.b.s();
        e();
    }

    public Bitmap i() {
        this.b.t();
        float fE = 1.0f / this.b.e();
        RectF rectF = new RectF(this.b.b());
        Matrix matrix = new Matrix();
        matrix.setRotate(this.b.d(), rectF.centerX(), rectF.centerY());
        matrix.mapRect(rectF);
        matrix.setScale(fE, fE, rectF.left, rectF.top);
        matrix.mapRect(rectF);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.round(rectF.width()), Math.round(rectF.height()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-rectF.left, -rectF.top);
        canvas.scale(fE, fE, rectF.left, rectF.top);
        a(canvas);
        return bitmapCreateBitmap;
    }

    public void k() {
        this.b.w();
        invalidate();
    }

    public void l() {
        this.b.x();
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Log.d("IMGView", "onAnimationCancel");
        this.b.a(this.e.a());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Log.d("IMGView", "onAnimationEnd");
        if (this.b.a(getScrollX(), getScrollY(), this.e.a())) {
            a(this.b.a(getScrollX(), getScrollY()));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Log.d("IMGView", "onAnimationStart");
        this.b.b(this.e.a());
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.a(valueAnimator.getAnimatedFraction());
        a((g2) valueAnimator.getAnimatedValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
        this.b.r();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return a(motionEvent) || super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.b.h(i3 - i, i4 - i2);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.g <= 1) {
            return false;
        }
        this.b.a(scaleGestureDetector.getScaleFactor(), getScrollX() + scaleGestureDetector.getFocusX(), getScrollY() + scaleGestureDetector.getFocusY());
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        if (this.g <= 1) {
            return false;
        }
        this.b.p();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.b.q();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            removeCallbacks(this);
        } else if (actionMasked == 1 || actionMasked == 3) {
            postDelayed(this, 1200L);
        }
        return d(motionEvent);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (g()) {
            return;
        }
        postDelayed(this, 500L);
    }

    public void setDoodleTouchListener(j2.b bVar) {
        this.b.a(bVar);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.b.a(bitmap);
        invalidate();
    }

    public void setMode(k2 k2Var) {
        this.a = this.b.c();
        this.b.a(k2Var);
        this.f.a(k2Var);
        if (this.b.j()) {
            e();
        } else {
            this.b.a(new a());
        }
    }

    public void setPenColor(int i) {
        this.f.a(i);
    }

    public IMGView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        this.b.a(getScrollX(), getScrollY());
        setMode(this.a);
        e();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static class c extends l2 {
        private int e;

        private c() {
            this.e = Integer.MIN_VALUE;
        }

        void a(float f, float f2) {
            this.a.lineTo(f, f2);
        }

        void b(float f, float f2) {
            this.a.reset();
            this.a.moveTo(f, f2);
            this.e = Integer.MIN_VALUE;
        }

        void c(int i) {
            this.e = i;
        }

        boolean e() {
            return this.a.isEmpty();
        }

        void f() {
            this.a.reset();
            this.e = Integer.MIN_VALUE;
        }

        l2 g() {
            if (b() == k2.DOODLE) {
                a(14.0f);
            } else {
                a(72.0f);
            }
            return new l2(new Path(this.a), b(), a(), d());
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        boolean b(int i) {
            return this.e == i;
        }
    }

    public IMGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = k2.NONE;
        this.b = new j2();
        this.f = new c(null);
        this.g = 0;
        this.h = new Paint(1);
        this.i = new Paint(1);
        Paint paint = this.h;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.h.setStrokeWidth(14.0f);
        this.h.setColor(-65536);
        this.h.setPathEffect(new CornerPathEffect(14.0f));
        Paint paint2 = this.h;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        Paint paint3 = this.h;
        Paint.Join join = Paint.Join.ROUND;
        paint3.setStrokeJoin(join);
        this.i.setStyle(style);
        this.i.setStrokeWidth(72.0f);
        this.i.setColor(-16777216);
        this.i.setPathEffect(new CornerPathEffect(72.0f));
        this.i.setStrokeCap(cap);
        this.i.setStrokeJoin(join);
        a(context);
        this.b.b(p4.a(getContext()));
    }

    private void a(Context context) {
        this.f.a(this.b.c());
        GestureDetector gestureDetector = new GestureDetector(context, new b(this, null));
        this.c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new ScaleGestureDetector(context, this);
    }

    boolean d(MotionEvent motionEvent) {
        boolean zE;
        if (d()) {
            return false;
        }
        this.g = motionEvent.getPointerCount();
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        k2 k2VarC = this.b.c();
        if (k2VarC != k2.NONE && k2VarC != k2.CLIP) {
            if (this.g > 1) {
                f();
                zE = e(motionEvent);
            } else {
                zE = f(motionEvent);
            }
        } else {
            zE = e(motionEvent);
        }
        boolean z = zOnTouchEvent | zE;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b.f(motionEvent.getX(), motionEvent.getY());
            if (this.b.c() == k2.CLIP) {
                invalidate();
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b.g(getScrollX(), getScrollY());
            e();
            return z;
        }
        return z;
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.f.b(motionEvent.getPointerId(0))) {
            return false;
        }
        this.f.a(motionEvent.getX(), motionEvent.getY());
        invalidate();
        return true;
    }

    public void b(int i, int i2) {
        j2 j2Var = this.b;
        if (j2Var != null) {
            j2Var.a(i, i2);
        }
    }

    private boolean e(MotionEvent motionEvent) {
        return this.c.onTouchEvent(motionEvent);
    }

    private void a(g2 g2Var, g2 g2Var2) {
        if (this.e == null) {
            h2 h2Var = new h2();
            this.e = h2Var;
            h2Var.addUpdateListener(this);
            this.e.addListener(this);
        }
        this.e.a(g2Var, g2Var2);
        this.e.start();
    }

    private boolean b(MotionEvent motionEvent) {
        this.f.b(motionEvent.getX(), motionEvent.getY());
        this.f.c(motionEvent.getPointerId(0));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public void c(View view) {
        this.b.d((m2) view);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public boolean b(View view) {
        j2 j2Var = this.b;
        if (j2Var != null) {
            j2Var.e((m2) view);
        }
        ((q2) view).b(this);
        ViewParent parent = view.getParent();
        if (parent == null) {
            return true;
        }
        ((ViewGroup) parent).removeView(view);
        return true;
    }

    private boolean f() {
        if (this.f.e()) {
            return false;
        }
        this.b.a(this.f.g(), getScrollX(), getScrollY());
        this.f.f();
        invalidate();
        return true;
    }

    public void a() {
        this.b.u();
        setMode(this.a);
    }

    private void a(Canvas canvas) {
        canvas.save();
        RectF rectFB = this.b.b();
        canvas.rotate(this.b.d(), rectFB.centerX(), rectFB.centerY());
        this.b.b(canvas);
        if (!this.b.k() || (this.b.c() == k2.MOSAIC && !this.f.e())) {
            int iC = this.b.c(canvas);
            if (this.b.c() == k2.MOSAIC && !this.f.e()) {
                this.h.setStrokeWidth(72.0f);
                canvas.save();
                RectF rectFB2 = this.b.b();
                canvas.rotate(-this.b.d(), rectFB2.centerX(), rectFB2.centerY());
                canvas.translate(getScrollX(), getScrollY());
                canvas.drawPath(this.f.c(), this.h);
                canvas.restore();
            }
            this.b.a(canvas, iC);
        }
        this.b.a(canvas);
        if (this.b.c() == k2.DOODLE && !this.f.e()) {
            this.h.setColor(this.f.a());
            this.h.setStrokeWidth(14.0f);
            canvas.save();
            RectF rectFB3 = this.b.b();
            canvas.rotate(-this.b.d(), rectFB3.centerX(), rectFB3.centerY());
            canvas.translate(getScrollX(), getScrollY());
            canvas.drawPath(this.f.c(), this.h);
            canvas.restore();
        }
        if (this.b.i()) {
            this.b.f(canvas);
        }
        this.b.d(canvas);
        canvas.restore();
        if (!this.b.i()) {
            this.b.e(canvas);
            this.b.f(canvas);
        }
        if (this.b.c() == k2.CLIP) {
            canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.b.a(canvas, getScrollX(), getScrollY());
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != 0) {
            addView(view, layoutParams);
            ((q2) view).a(this);
            this.b.a((m2) view);
        }
    }

    public void a(r2 r2Var) {
        IMGStickerTextView iMGStickerTextView = new IMGStickerTextView(getContext());
        iMGStickerTextView.setText(r2Var);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        iMGStickerTextView.setX(getScrollX());
        iMGStickerTextView.setY(getScrollY());
        a(iMGStickerTextView, layoutParams);
    }

    boolean a(MotionEvent motionEvent) {
        if (!d()) {
            return this.b.c() == k2.CLIP;
        }
        j();
        return true;
    }

    private void a(g2 g2Var) {
        this.b.d(g2Var.c);
        this.b.c(g2Var.d);
        if (a(Math.round(g2Var.a), Math.round(g2Var.b))) {
            return;
        }
        invalidate();
    }

    private boolean a(int i, int i2) {
        if (getScrollX() == i && getScrollY() == i2) {
            return false;
        }
        scrollTo(i, i2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public void a(View view) {
        this.b.f((m2) view);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2) {
        g2 g2VarA = this.b.a(getScrollX(), getScrollY(), -f, -f2);
        if (g2VarA != null) {
            a(g2VarA);
            return true;
        }
        return a(getScrollX() + Math.round(f), getScrollY() + Math.round(f2));
    }
}
