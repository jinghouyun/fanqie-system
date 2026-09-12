package io.dcloud.common.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.alibaba.android.bindingx.core.internal.BindingXConstants;
import com.taobao.weex.common.Constants;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.view.gesture.WXGesture;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.INativeView;
import io.dcloud.common.adapter.util.DragBean;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.nineoldandroids.animation.Animator;
import io.dcloud.nineoldandroids.animation.ValueAnimator;
import io.dcloud.nineoldandroids.view.ViewHelper;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean j0 = false;
    private String A;
    private String C;
    private String D;
    private IFrameView J;
    private String K;
    private String L;
    private String M;
    private int N;
    private boolean O;
    private float P;
    private int Q;
    private int R;
    private int W;
    private DisplayMetrics X;
    private float Z;
    private float a0;
    private float b0;
    private float c0;
    private float d0;
    private float e0;
    private VelocityTracker f;
    boolean g0;
    private int h;
    private float i;
    private Pattern i0;
    private float j;
    private float k;
    private int l;
    private io.dcloud.common.core.ui.b q;
    private io.dcloud.common.core.ui.b r;
    private View t;
    private String w;
    private String y;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean g = true;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private View s = null;
    private boolean u = false;
    private int v = Integer.MAX_VALUE;
    private int x = Integer.MAX_VALUE;
    private int z = Integer.MAX_VALUE;
    private int B = Integer.MAX_VALUE;
    private boolean E = false;
    private boolean F = true;
    private boolean G = true;
    private boolean H = true;
    private int I = -1;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private int V = Integer.MAX_VALUE;
    private float Y = 20.0f;
    boolean f0 = true;
    private String h0 = "^([1-9]|[1-9]\\d|100)$";

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            g.this.t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            g gVar = g.this;
            boolean z = true;
            if (gVar.d(gVar.L)) {
                i = g.this.p;
            } else {
                g gVar2 = g.this;
                int iB = gVar2.b(gVar2.t) / 2;
                Rect rect = new Rect();
                g.this.t.getGlobalVisibleRect(rect);
                if (rect.right - rect.left >= iB) {
                    i = g.this.p;
                } else {
                    i = g.this.o;
                    z = false;
                }
            }
            g gVar3 = g.this;
            int iA = gVar3.a(gVar3.t);
            g gVar4 = g.this;
            ValueAnimator valueAnimatorA = gVar4.a(gVar4.t, iA, i, z);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:53:0x0166  */
        /* JADX WARN: Code duplicated, block: B:63:0x019c  */
        /* JADX WARN: Code duplicated, block: B:66:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:67:0x01ba  */
        /* JADX WARN: Code duplicated, block: B:70:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            boolean z;
            boolean z2;
            boolean z3;
            ValueAnimator valueAnimatorA;
            Rect rect;
            g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            g gVar = g.this;
            boolean z4 = true;
            if (!gVar.d(gVar.L)) {
                if (g.this.t != null) {
                    g gVar2 = g.this;
                    int iB = gVar2.b(gVar2.t) / 2;
                    Rect rect2 = new Rect();
                    g.this.t.getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    g.this.s.getGlobalVisibleRect(rect3);
                    int i2 = rect2.left;
                    if (i2 == 0) {
                        int i3 = rect3.left - i2;
                        if (!"right".equals(g.this.L)) {
                            if (!"left".equals(g.this.L)) {
                                i = 0;
                            } else if (i3 <= iB) {
                                i = g.this.n;
                            } else {
                                i = g.this.m;
                            }
                            z = false;
                        } else if (i3 >= iB) {
                            i = g.this.n;
                        } else {
                            i = g.this.m;
                            z = false;
                        }
                    } else {
                        if (rect2.right == g.this.Q) {
                            int i4 = rect2.right - rect3.right;
                            if ("right".equals(g.this.L)) {
                                if (i4 <= iB) {
                                    i = g.this.n;
                                } else {
                                    i = g.this.m;
                                }
                            } else if (!"left".equals(g.this.L)) {
                                i = 0;
                            } else if (i4 >= iB) {
                                i = g.this.n;
                            } else {
                                i = g.this.m;
                            }
                        } else {
                            i = 0;
                        }
                        z = false;
                    }
                } else {
                    Rect rect4 = new Rect();
                    g.this.s.getGlobalVisibleRect(rect4);
                    int i5 = rect4.right - rect4.left;
                    int width = g.this.s.getWidth() / 2;
                    if (!"right".equals(g.this.L) || g.this.m >= 0) {
                        if (!"left".equals(g.this.L) || g.this.n < 0) {
                            if (i5 <= width) {
                                i = g.this.n;
                            } else {
                                i = g.this.m;
                                z = false;
                            }
                        } else if (i5 >= width) {
                            i = g.this.n;
                        } else {
                            i = g.this.m;
                            z = false;
                        }
                    } else if (i5 >= width) {
                        i = g.this.n;
                    } else {
                        i = g.this.m;
                        z = false;
                    }
                }
                if (g.this.t != null) {
                    rect = new Rect();
                    g.this.t.getGlobalVisibleRect(rect);
                    if (rect.left == 0 ? rect.right != g.this.Q || !"right".equals(g.this.L) : !"left".equals(g.this.L)) {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                if ("bounce".equalsIgnoreCase(g.this.D)) {
                    i = g.this.m;
                    g.this.D = null;
                    z3 = false;
                    z2 = false;
                } else {
                    z2 = z4;
                    z3 = z;
                }
                int i6 = i;
                g gVar3 = g.this;
                int iA = gVar3.a(gVar3.s);
                g gVar4 = g.this;
                valueAnimatorA = gVar4.a(gVar4.s, iA, i6, z3, z2);
                if (valueAnimatorA != null) {
                    valueAnimatorA.start();
                }
            }
            i = g.this.n;
            z = true;
            if (g.this.t != null) {
                rect = new Rect();
                g.this.t.getGlobalVisibleRect(rect);
                if (rect.left == 0) {
                    z4 = false;
                } else {
                    z4 = false;
                }
            } else {
                z4 = false;
            }
            if ("bounce".equalsIgnoreCase(g.this.D)) {
                i = g.this.m;
                g.this.D = null;
                z3 = false;
                z2 = false;
            } else {
                z2 = z4;
                z3 = z;
            }
            int i7 = i;
            g gVar5 = g.this;
            int iA2 = gVar5.a(gVar5.s);
            g gVar6 = g.this;
            valueAnimatorA = gVar6.a(gVar6.s, iA2, i7, z3, z2);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            g gVar = g.this;
            boolean z = true;
            int i6 = 0;
            if (gVar.d(gVar.L)) {
                int i7 = g.this.n;
                int i8 = g.this.p;
                if ("bounce".equalsIgnoreCase(g.this.D)) {
                    i4 = g.this.m;
                    i5 = g.this.o;
                    g.this.D = null;
                    i6 = i4;
                    i3 = i5;
                    z = false;
                } else {
                    i6 = i7;
                    i3 = i8;
                }
            } else if ("bounce".equalsIgnoreCase(g.this.D)) {
                i4 = g.this.m;
                i5 = g.this.o;
                g.this.D = null;
                i6 = i4;
                i3 = i5;
                z = false;
            } else {
                int i9 = g.this.Q;
                g gVar2 = g.this;
                int iA = gVar2.a(gVar2.t);
                g gVar3 = g.this;
                int iB = gVar3.b(gVar3.t) + iA;
                g gVar4 = g.this;
                gVar4.a(gVar4.s);
                g.this.s.getWidth();
                if (g.this.s.getWidth() >= g.this.Q) {
                    if (iA <= 0 && iB > 0) {
                        if (iB > 0) {
                            g gVar5 = g.this;
                            if (iB < gVar5.b(gVar5.t)) {
                                g gVar6 = g.this;
                                if (iB >= gVar6.b(gVar6.t) / 2) {
                                    i6 = g.this.n;
                                    i3 = g.this.p;
                                } else {
                                    i = g.this.m;
                                    i2 = g.this.o;
                                    i6 = i;
                                    i3 = i2;
                                    z = false;
                                }
                            }
                        }
                        g gVar7 = g.this;
                        if (iB == gVar7.b(gVar7.t)) {
                            g.this.b(true);
                            g gVar8 = g.this;
                            gVar8.a(gVar8.s, g.this.n);
                            g gVar9 = g.this;
                            gVar9.a(gVar9.t, g.this.p);
                            boolean unused = g.j0 = false;
                            return;
                        }
                        g.this.b(false);
                        g gVar10 = g.this;
                        gVar10.a(gVar10.s, g.this.m);
                        g gVar11 = g.this;
                        gVar11.a(gVar11.t, g.this.o);
                        boolean unused2 = g.j0 = false;
                        return;
                    }
                    if (iA >= i9 || i9 > iB) {
                        g.this.b(false);
                        g gVar12 = g.this;
                        gVar12.a(gVar12.s, g.this.m);
                        g gVar13 = g.this;
                        gVar13.a(gVar13.t, g.this.o);
                        boolean unused3 = g.j0 = false;
                        return;
                    }
                    int i10 = i9 - iA;
                    if (i10 > 0) {
                        g gVar14 = g.this;
                        if (i10 < gVar14.b(gVar14.t)) {
                            g gVar15 = g.this;
                            if (i10 >= gVar15.b(gVar15.t) / 2) {
                                i6 = g.this.n;
                                i3 = g.this.p;
                            } else {
                                i = g.this.m;
                                i2 = g.this.o;
                                i6 = i;
                                i3 = i2;
                                z = false;
                            }
                        }
                    }
                    g gVar16 = g.this;
                    if (i10 == gVar16.b(gVar16.t)) {
                        g.this.b(true);
                        g gVar17 = g.this;
                        gVar17.a(gVar17.s, g.this.n);
                        g gVar18 = g.this;
                        gVar18.a(gVar18.t, g.this.p);
                        boolean unused4 = g.j0 = false;
                        return;
                    }
                    g.this.b(false);
                    g gVar19 = g.this;
                    gVar19.a(gVar19.s, g.this.m);
                    g gVar20 = g.this;
                    gVar20.a(gVar20.t, g.this.o);
                    boolean unused5 = g.j0 = false;
                    return;
                }
                Rect rect = new Rect();
                g.this.s.getGlobalVisibleRect(rect);
                int i11 = rect.right - rect.left;
                int width = g.this.s.getWidth() / 2;
                if (rect.left == 0) {
                    if (i11 <= width) {
                        i6 = g.this.n;
                        i3 = g.this.p;
                    } else {
                        i = g.this.m;
                        i2 = g.this.o;
                        i6 = i;
                        i3 = i2;
                        z = false;
                    }
                } else if (g.this.Q != rect.right) {
                    i3 = 0;
                    z = false;
                } else if (i11 <= width) {
                    i6 = g.this.n;
                    i3 = g.this.p;
                } else {
                    i = g.this.m;
                    i2 = g.this.o;
                    i6 = i;
                    i3 = i2;
                    z = false;
                }
            }
            g gVar21 = g.this;
            int iA2 = gVar21.a(gVar21.s);
            g gVar22 = g.this;
            ValueAnimator valueAnimatorA = gVar22.a(gVar22.s, iA2, i6, z);
            if (valueAnimatorA != null) {
                valueAnimatorA.start();
            }
            g gVar23 = g.this;
            int iA3 = gVar23.a(gVar23.t);
            if (g.this.t != null) {
                g gVar24 = g.this;
                ValueAnimator valueAnimatorA2 = gVar24.a(gVar24.t, iA3, i3, z);
                if (valueAnimatorA2 != null) {
                    valueAnimatorA2.start();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements Animator.AnimatorListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ View c;
        final /* synthetic */ int d;

        d(boolean z, boolean z2, View view, int i) {
            this.a = z;
            this.b = z2;
            this.c = view;
            this.d = i;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        /* JADX WARN: Code duplicated, block: B:57:0x0137  */
        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            io.dcloud.common.core.ui.b bVar;
            String str;
            if (g.this.S) {
                g.this.S = false;
                g gVar = g.this;
                boolean z = this.a;
                gVar.a("end", z, this.b, z ? "100" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            if (this.a) {
                if (this.c == g.this.s && g.this.q != null) {
                    g gVar2 = g.this;
                    int iA = gVar2.a(gVar2.s);
                    if (iA <= (-g.this.s.getWidth()) || iA >= g.this.Q) {
                        g.this.q.popFromViewStack();
                    }
                }
            } else if (this.c == g.this.t) {
                g gVar3 = g.this;
                int iA2 = gVar3.a(gVar3.t);
                if (iA2 <= (-g.this.Q) || iA2 >= g.this.Q) {
                    if (Integer.MAX_VALUE != g.this.V && g.this.V != iA2) {
                        g gVar4 = g.this;
                        gVar4.b(gVar4.t, g.this.V);
                    }
                    g.this.V = Integer.MAX_VALUE;
                }
                if (!(this.c instanceof INativeView) && g.this.r != null) {
                    g gVar5 = g.this;
                    int iA3 = gVar5.a(gVar5.t);
                    g gVar6 = g.this;
                    if (iA3 <= (-gVar6.b(gVar6.t)) || iA3 >= g.this.Q) {
                        g.this.r.popFromViewStack();
                    }
                }
            }
            g.this.a(this.c, this.d);
            View view = this.c;
            if (view != null) {
                if (this.b) {
                    bVar = null;
                    str = null;
                } else if (view == g.this.s) {
                    bVar = g.this.q;
                    str = this.a ? g.this.w : g.this.y;
                } else if (this.c == g.this.t) {
                    bVar = g.this.r;
                    str = this.a ? g.this.A : g.this.C;
                } else {
                    bVar = null;
                    str = null;
                }
                if ("hide".equalsIgnoreCase(str) || AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(str)) {
                    KeyEvent.Callback callback = this.c;
                    if (callback instanceof INativeView) {
                        String viewId = ((INativeView) callback).getViewId();
                        String viewUUId = ((INativeView) this.c).getViewUUId();
                        if (str.equalsIgnoreCase(AbsoluteConst.EVENTS_CLOSE)) {
                            str = "view_close";
                        }
                        g.this.q.obtainWindowMgr().processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{g.this.q.obtainWebView(), "nativeobj", str, JSONUtil.createJSONArray("['" + viewId + "','" + viewUUId + "']")});
                    } else if (bVar != null) {
                        bVar.obtainWindowMgr().processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{bVar.obtainWebView(), AbsoluteConst.F_UI, "execMethod", JSONUtil.createJSONArray("[\"NWindow\",\"" + str + "\",[\"" + bVar.obtainWebView().getWebviewUUID() + "\",[null,null,null]]]")});
                    }
                }
            }
            if (g.this.W <= 1) {
                boolean unused = g.j0 = false;
                g.this.t = null;
            }
            if (g.this.W >= 1) {
                g.h(g.this);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.g(g.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        e(View view) {
            this.a = view;
        }

        @Override // io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            View view = this.a;
            if (view instanceof INativeView) {
                g.this.b(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                this.a.requestLayout();
                this.a.invalidate();
            } else {
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ViewHelper.setX(view, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    return;
                }
                if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
                    try {
                        ViewHelper.setX(this.a, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    } catch (Exception unused) {
                        ViewHelper.setX(this.a, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                    this.a.requestLayout();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f implements ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iB;
            int i;
            boolean z;
            int iB2;
            g.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            g gVar = g.this;
            int iB3 = 0;
            if (gVar.d(gVar.L)) {
                if ("right".equals(g.this.L)) {
                    i = g.this.Q;
                    iB3 = i;
                } else if ("left".equals(g.this.L)) {
                    g gVar2 = g.this;
                    iB2 = gVar2.b(gVar2.t);
                    i = -iB2;
                    iB3 = i;
                }
                iB = 0;
                z = true;
            } else {
                View view = (View) g.this.s.getParent();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr);
                g.this.s.getLocationOnScreen(new int[2]);
                g.this.t.getLocationOnScreen(iArr2);
                int width = iArr[0] + view.getWidth();
                g.this.s.getWidth();
                int i2 = iArr2[0];
                g gVar3 = g.this;
                int iB4 = i2 + gVar3.b(gVar3.t);
                int i3 = iArr2[0];
                int i4 = iArr[0];
                if (i3 <= i4 && i4 < iB4) {
                    int i5 = iB4 - i4;
                    if (i5 > 0) {
                        g gVar4 = g.this;
                        if (i5 < gVar4.b(gVar4.t)) {
                            g gVar5 = g.this;
                            if (i5 <= gVar5.b(gVar5.t) / 2) {
                                g gVar6 = g.this;
                                iB2 = gVar6.b(gVar6.t);
                                i = -iB2;
                                iB3 = i;
                                iB = 0;
                                z = true;
                            } else {
                                g gVar7 = g.this;
                                iB = gVar7.b(gVar7.t);
                            }
                        }
                    }
                    g gVar8 = g.this;
                    if (i5 == gVar8.b(gVar8.t)) {
                        g.this.a(false, true);
                        g gVar9 = g.this;
                        View view2 = gVar9.s;
                        g gVar10 = g.this;
                        gVar9.a(view2, gVar10.b(gVar10.t));
                        g gVar11 = g.this;
                        gVar11.a(gVar11.t, 0);
                        boolean unused = g.j0 = false;
                        return;
                    }
                    g.this.a(true, true);
                    g gVar12 = g.this;
                    gVar12.a(gVar12.s, 0);
                    g gVar13 = g.this;
                    View view3 = gVar13.t;
                    g gVar14 = g.this;
                    gVar13.a(view3, -gVar14.b(gVar14.t));
                    boolean unused2 = g.j0 = false;
                    return;
                }
                if (i3 >= width || width > iB4) {
                    g.this.a(true, true);
                    g gVar15 = g.this;
                    gVar15.a(gVar15.s, 0);
                    g gVar16 = g.this;
                    gVar16.a(gVar16.t, g.this.Q);
                    boolean unused3 = g.j0 = false;
                    return;
                }
                int i6 = width - i3;
                if (i6 > 0) {
                    g gVar17 = g.this;
                    if (i6 < gVar17.b(gVar17.t)) {
                        g gVar18 = g.this;
                        if (i6 <= gVar18.b(gVar18.t) / 2) {
                            i = g.this.Q;
                            iB3 = i;
                            iB = 0;
                            z = true;
                        } else {
                            g gVar19 = g.this;
                            int i7 = -gVar19.b(gVar19.t);
                            int i8 = g.this.Q;
                            g gVar20 = g.this;
                            iB = i7;
                            iB3 = i8 - gVar20.b(gVar20.t);
                        }
                    }
                }
                g gVar21 = g.this;
                if (i6 != gVar21.b(gVar21.t)) {
                    g.this.a(true, true);
                    g gVar22 = g.this;
                    gVar22.a(gVar22.s, 0);
                    g gVar23 = g.this;
                    gVar23.a(gVar23.t, g.this.Q);
                    boolean unused4 = g.j0 = false;
                    return;
                }
                g.this.a(false, true);
                g gVar24 = g.this;
                View view4 = gVar24.s;
                g gVar25 = g.this;
                gVar24.a(view4, -gVar25.b(gVar25.t));
                g gVar26 = g.this;
                View view5 = gVar26.t;
                int i9 = g.this.Q;
                g gVar27 = g.this;
                gVar26.a(view5, i9 - gVar27.b(gVar27.t));
                boolean unused5 = g.j0 = false;
                return;
                z = false;
            }
            g gVar28 = g.this;
            int iA = gVar28.a(gVar28.s);
            if (iA != 0) {
                g gVar29 = g.this;
                ValueAnimator valueAnimatorA = gVar29.a(gVar29.s, iA, iB, z, true);
                if (valueAnimatorA != null) {
                    valueAnimatorA.start();
                }
            }
            g gVar30 = g.this;
            int iA2 = gVar30.a(gVar30.t);
            g gVar31 = g.this;
            ValueAnimator valueAnimatorA2 = gVar31.a(gVar31.t, iA2, iB3, z, true);
            if (valueAnimatorA2 != null) {
                valueAnimatorA2.start();
            }
        }
    }

    public g(IFrameView iFrameView, Context context) {
        j0 = false;
        this.W = 0;
        if (iFrameView instanceof io.dcloud.common.core.ui.b) {
            this.q = (io.dcloud.common.core.ui.b) iFrameView;
            if (this.X == null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.X = displayMetrics;
                int i = displayMetrics.widthPixels;
                this.Q = i;
                this.R = i;
            }
        }
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.i0 = Pattern.compile(this.h0);
    }

    static /* synthetic */ int g(g gVar) {
        int i = gVar.W;
        gVar.W = i + 1;
        return i;
    }

    static /* synthetic */ int h(g gVar) {
        int i = gVar.W;
        gVar.W = i - 1;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048 A[PHI: r2
  0x0048: PHI (r2v16 int) = (r2v15 int), (r2v19 int) binds: [B:12:0x003e, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[PHI: r2
  0x0072: PHI (r2v9 int) = (r2v8 int), (r2v12 int) binds: [B:26:0x0068, B:29:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0082 A[PHI: r0 r2
  0x0082: PHI (r0v8 float) = (r0v7 float), (r0v7 float), (r0v13 float), (r0v13 float) binds: [B:32:0x0078, B:35:0x0080, B:18:0x004e, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]
  0x0082: PHI (r2v13 int) = (r2v10 int), (r2v11 int), (r2v17 int), (r2v18 int) binds: [B:32:0x0078, B:35:0x0080, B:18:0x004e, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r5 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(MotionEvent motionEvent) {
        int i;
        float rawX = motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f2 = (int) (rawX - this.i);
                this.i = rawX;
                float fA = a(f2);
                float fA2 = a(this.s) + fA;
                float fA3 = fA + a(this.t);
                if ("right".equals(this.L)) {
                    int i2 = this.n;
                    if (fA2 >= i2) {
                        fA2 = i2;
                    } else {
                        i2 = this.m;
                        if (fA2 <= i2) {
                            fA2 = i2;
                        }
                    }
                    i = this.p;
                    if (fA3 >= i) {
                        fA3 = i;
                    } else {
                        i = this.o;
                        if (fA3 <= i) {
                            fA3 = i;
                        }
                    }
                } else if ("left".equals(this.L)) {
                    int i3 = this.m;
                    if (fA2 >= i3) {
                        fA2 = i3;
                    } else {
                        i3 = this.n;
                        if (fA2 <= i3) {
                            fA2 = i3;
                        }
                    }
                    i = this.o;
                    if (fA3 >= i) {
                        fA3 = i;
                    } else {
                        i = this.p;
                        if (fA3 <= i) {
                            fA3 = i;
                        }
                    }
                }
                b(this.s, (int) fA2);
                b(this.t, (int) fA3);
            }
            return true;
        }
        this.g = false;
        if (this.H) {
            a();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[PHI: r4
  0x0053: PHI (r4v11 int) = (r4v9 int), (r4v10 int), (r4v13 int), (r4v14 int) binds: [B:20:0x0049, B:23:0x0051, B:12:0x002f, B:15:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r4 != 3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f(MotionEvent motionEvent) {
        int i;
        float rawX = motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f2 = rawX - this.i;
                this.i = rawX;
                float fA = a(this.t) + f2;
                if ("right".equals(this.L)) {
                    i = this.p;
                    if (fA > i) {
                        fA = i;
                    } else {
                        i = this.o;
                        if (fA < i) {
                            fA = i;
                        }
                    }
                } else if ("left".equals(this.L)) {
                    i = this.o;
                    if (fA > i) {
                        fA = i;
                    } else {
                        i = this.p;
                        if (fA < i) {
                            fA = i;
                        }
                    }
                }
                b(this.t, (int) fA);
            }
            return true;
        }
        this.g = false;
        if (this.H) {
            c();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0057 A[PHI: r4
  0x0057: PHI (r4v12 int) = (r4v10 int), (r4v11 int), (r4v14 int), (r4v15 int) binds: [B:20:0x004d, B:23:0x0055, B:12:0x0033, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r4 != 3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        int i;
        float rawX = motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f2 = rawX - this.i;
                this.i = rawX;
                float fA = a(this.s) + a(f2);
                if ("right".equals(this.L)) {
                    i = this.n;
                    if (fA > i) {
                        fA = i;
                    } else {
                        i = this.m;
                        if (fA < i) {
                            fA = i;
                        }
                    }
                } else if ("left".equals(this.L)) {
                    i = this.m;
                    if (fA > i) {
                        fA = i;
                    } else {
                        i = this.n;
                        if (fA < i) {
                            fA = i;
                        }
                    }
                }
                b(this.s, (int) fA);
            }
            return true;
        }
        this.g = false;
        if (this.H) {
            d();
        }
        return false;
    }

    private boolean h() {
        this.m = a(this.s);
        if ("right".equals(this.L)) {
            int i = this.v;
            if (Integer.MAX_VALUE != i) {
                this.n = i;
                return this.m != i;
            }
            this.n = this.Q;
            View view = this.t;
            if (view == null) {
                if (view != null || this.m >= 0) {
                    return true;
                }
                this.n = 0;
                return true;
            }
            if ("bounce".equalsIgnoreCase(this.D)) {
                this.n = this.m + (b(this.s) / 2);
                return true;
            }
            if (b(this.t) >= this.Q) {
                return true;
            }
            int iA = a(this.s);
            int iA2 = a(this.t);
            int iA3 = a(this.t) + b(this.t);
            if (iA2 == 0 && iA3 == iA) {
                return false;
            }
            boolean z = this.G;
            if (!z && iA2 == 0) {
                this.n = b(this.t);
                return true;
            }
            if (z && iA3 == 0) {
                this.n = b(this.t);
                return true;
            }
            if (this.Q != iA3) {
                return true;
            }
            this.n = 0;
            return true;
        }
        if (!"left".equals(this.L)) {
            return true;
        }
        int i2 = this.v;
        if (Integer.MAX_VALUE != i2) {
            this.n = i2;
            return this.m != i2;
        }
        this.n = -b(this.s);
        View view2 = this.t;
        if (view2 == null) {
            if (view2 != null || this.m <= 0) {
                return true;
            }
            this.n = 0;
            return true;
        }
        if ("bounce".equalsIgnoreCase(this.D)) {
            this.n = this.m - (b(this.s) / 2);
            return true;
        }
        if (b(this.t) >= this.Q) {
            return true;
        }
        int iA4 = a(this.s) + b(this.s);
        int iA5 = a(this.t);
        int iA6 = a(this.t) + b(this.t);
        int i3 = this.Q;
        if (i3 == iA6 && iA5 == iA4) {
            return false;
        }
        boolean z2 = this.G;
        if (!z2 && i3 == iA6) {
            this.n = -b(this.t);
            return true;
        }
        if (z2 && i3 == iA5) {
            this.n = -b(this.t);
            return true;
        }
        if (iA5 != 0) {
            return true;
        }
        this.n = 0;
        return true;
    }

    private void i() {
        float f2 = this.m;
        this.Z = f2;
        float f3 = this.n;
        this.a0 = f3;
        this.c0 = f2;
        this.b0 = f2;
        float fAbs = Math.abs(f3 - f2);
        this.d0 = fAbs;
        this.e0 = (fAbs * this.Y) / 100.0f;
        this.f0 = true;
        this.g0 = false;
    }

    private boolean j() {
        if ("right".equals(this.L)) {
            return a(this.t) != 0;
        }
        return ("left".equals(this.L) && a(this.t) + b(this.t) == this.Q) ? false : true;
    }

    private void k() {
        float fA = a(this.s);
        this.c0 = fA;
        if (this.f0) {
            float f2 = this.Z;
            if (fA == f2) {
                this.g0 = true;
                this.f0 = false;
                this.b0 = f2;
                a(WXGesture.MOVE, false, WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return;
            }
        }
        if (Math.abs(fA - this.b0) >= this.e0) {
            this.f0 = true;
            this.g0 = true;
            a(WXGesture.MOVE, false, "" + ((int) ((Math.abs(this.c0 - this.Z) / this.d0) * 100.0f)));
            this.b0 = this.c0;
            return;
        }
        if (this.g0) {
            float f3 = this.c0;
            float f4 = this.a0;
            if (f3 == f4) {
                this.g0 = false;
                this.f0 = true;
                this.b0 = f4;
                a(WXGesture.MOVE, false, "100");
            }
        }
    }

    public HashMap e() {
        io.dcloud.common.core.ui.b bVar = this.q;
        if (bVar == null || bVar.obtainFrameOptions() == null) {
            return null;
        }
        return this.q.obtainFrameOptions().dragData;
    }

    public void c(boolean z) {
        this.a = z;
    }

    public boolean c(MotionEvent motionEvent) {
        View view;
        View view2;
        if (!this.g) {
            return false;
        }
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        if (BaseInfo.sDoingAnimation) {
            if (this.U) {
                return false;
            }
            this.U = true;
            motionEvent.setAction(3);
        }
        if (this.a && !this.g) {
            return true;
        }
        if (this.f == null) {
            this.f = VelocityTracker.obtain();
        }
        if (this.I == -1 || j0) {
            return false;
        }
        if (2 == motionEvent.getAction()) {
            k();
            if ("left".equals(this.L)) {
                if (motionEvent.getRawX() < this.i) {
                    this.f.addMovement(motionEvent);
                }
            } else if ("right".equals(this.L) && motionEvent.getRawX() > this.i) {
                this.f.addMovement(motionEvent);
            }
        }
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.f.addMovement(motionEvent);
        }
        if (this.T) {
            return e(motionEvent);
        }
        boolean z = this.E;
        if (z && this.F && this.G) {
            if ((!a(this.q) && !a(this.r)) || ((view2 = this.t) != null && (view2 instanceof INativeView))) {
                return d(motionEvent);
            }
        } else if (z && !this.F && this.G) {
            if ((!a(this.q) && !a(this.r)) || ((view = this.t) != null && (view instanceof INativeView))) {
                return f(motionEvent);
            }
        } else if (z && !this.G && this.F) {
            if (!a(this.q) && !a(this.r)) {
                return g(motionEvent);
            }
        } else if (!z && this.F && !a(this.q)) {
            return g(motionEvent);
        }
        return true;
    }

    private boolean e(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        this.s = this.q.obtainMainView();
        this.v = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.w = null;
        this.y = null;
        HashMap mapE = e();
        if (mapE == null || !mapE.containsKey(str)) {
            return false;
        }
        DragBean dragBean = (DragBean) mapE.get(str);
        if (dragBean != null) {
            this.K = dragBean.dragCbId;
            this.J = dragBean.dragCallBackWebView;
            JSONObject jSONObject3 = dragBean.dragCurrentViewOp;
            try {
                this.M = JSONUtil.getString(jSONObject3, "direction");
                if (jSONObject3.has("moveMode")) {
                    String string = JSONUtil.getString(jSONObject3, "moveMode");
                    this.D = string;
                    this.F = "followFinger".equalsIgnoreCase(string) || "follow".equalsIgnoreCase(this.D) || "bounce".equalsIgnoreCase(this.D);
                }
                this.Y = 20.0f;
                if (jSONObject3.has("callbackStep")) {
                    try {
                        String string2 = jSONObject3.getString("callbackStep");
                        if (this.i0.matcher(string2).find()) {
                            this.Y = Integer.valueOf(string2).intValue();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (jSONObject3.has("over") && (jSONObject2 = JSONUtil.getJSONObject(jSONObject3, "over")) != null) {
                    if (jSONObject2.has("left")) {
                        this.v = PdrUtil.parseInt(JSONUtil.getString(jSONObject2, "left"), this.Q, Integer.MAX_VALUE);
                    }
                    if (jSONObject2.has("action")) {
                        this.w = JSONUtil.getString(jSONObject2, "action");
                    }
                }
                if (jSONObject3.has(BindingXConstants.STATE_CANCEL) && (jSONObject = JSONUtil.getJSONObject(jSONObject3, BindingXConstants.STATE_CANCEL)) != null) {
                    if (jSONObject.has("left")) {
                        this.x = PdrUtil.parseInt(JSONUtil.getString(jSONObject, "left"), this.Q, Integer.MAX_VALUE);
                    }
                    if (jSONObject.has("action")) {
                        this.y = JSONUtil.getString(jSONObject, "action");
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void b(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.X;
        if (displayMetrics != null) {
            this.Q = displayMetrics.widthPixels;
        }
        this.P = motionEvent.getRawX();
        float rawX = motionEvent.getRawX();
        this.i = rawX;
        this.k = rawX;
        this.j = motionEvent.getRawY();
        this.g = false;
        this.E = false;
        this.u = false;
        this.U = false;
        this.I = -1;
        this.q.obtainWebView().loadUrl("javascript:window.__needNotifyNative__=true;");
        this.q.obtainWebView().setWebviewProperty("needTouchEvent", AbsoluteConst.FALSE);
        this.O = false;
        this.N = this.q.obtainWebView().obtainWindowView().getScrollY();
        if (this.f == null) {
            this.f = VelocityTracker.obtain();
        }
        this.f.addMovement(motionEvent);
    }

    public boolean a(MotionEvent motionEvent) {
        View view;
        View view2;
        String str;
        if (this.a) {
            return true;
        }
        if (e() != null && !BaseInfo.sDoingAnimation && !j0) {
            int actionMasked = motionEvent.getActionMasked();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (actionMasked == 0 && motionEvent.getEdgeFlags() != 0) {
                return false;
            }
            if (actionMasked == 0) {
                b(motionEvent);
            } else if (actionMasked == 1) {
                this.u = false;
                this.I = -1;
            } else if (actionMasked == 2) {
                if (this.N != this.q.obtainWebView().obtainWindowView().getScrollY()) {
                    this.O = true;
                }
                if (this.O) {
                    return false;
                }
                float f2 = rawX - this.i;
                if (Math.abs(f2) >= Math.abs(rawY - this.j)) {
                    if (this.h * 3 <= Math.abs(motionEvent.getRawX() - this.P) && AbsoluteConst.FALSE.equals(this.q.obtainWebView().getWebviewProperty("needTouchEvent"))) {
                        if (f2 >= 0.0f) {
                            str = "right";
                            if (!this.u && e("right")) {
                                this.L = "right";
                                this.g = true;
                                this.u = true;
                            }
                        } else {
                            str = "left";
                            if (!this.u && e("left")) {
                                this.L = "left";
                                this.g = true;
                                this.u = true;
                            }
                        }
                        if (-1 == this.I) {
                            this.i = rawX;
                            View viewA = a(str);
                            if (viewA != null) {
                                HashMap mapE = e();
                                String strC = c(str);
                                if (mapE != null && mapE.containsKey(strC)) {
                                    a(((DragBean) mapE.get(strC)).dragBindViewOp);
                                }
                                this.L = str;
                                this.g = true;
                                this.t = viewA;
                                this.T = true;
                                this.I = 1;
                            } else {
                                b(this.L);
                            }
                        }
                    }
                }
            }
            if (this.g) {
                if (this.T) {
                    this.g = j();
                } else {
                    boolean z = this.E;
                    if (z && this.F && this.G) {
                        if ((!a(this.q) && !a(this.r)) || ((view2 = this.t) != null && (view2 instanceof INativeView))) {
                            this.g = g();
                        }
                    } else if (z && !this.F && this.G) {
                        if ((!a(this.q) && !a(this.r)) || ((view = this.t) != null && (view instanceof INativeView))) {
                            this.g = f();
                        }
                    } else if (!z && this.F) {
                        if (!a(this.q)) {
                            h();
                        }
                    } else if (z && !this.G && this.F) {
                        if (!a(this.q) && !a(this.r)) {
                            this.g = h();
                        }
                    } else {
                        this.g = false;
                    }
                }
            }
            if (this.g) {
                if (!a(this.q)) {
                    this.b = this.q.obtainWebView().obtainWindowView().isVerticalScrollBarEnabled();
                    this.c = this.q.obtainWebView().obtainWindowView().isHorizontalScrollBarEnabled();
                    this.q.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(false);
                    this.q.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(false);
                }
                View view3 = this.t;
                if (view3 != null && (view3 instanceof com.dcloud.android.widget.AbsoluteLayout)) {
                    ((com.dcloud.android.widget.AbsoluteLayout) view3).getDrag().c(true);
                    if (!a(this.r)) {
                        this.d = this.r.obtainWebView().obtainWindowView().isVerticalScrollBarEnabled();
                        this.e = this.r.obtainWebView().obtainWindowView().isHorizontalScrollBarEnabled();
                        this.r.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(false);
                        this.r.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(false);
                    }
                }
                a("start", false, WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                i();
            }
            return this.g;
        }
        this.g = false;
        return false;
    }

    private int b(String str) {
        View view;
        DragBean dragBean;
        int i = this.I;
        if (i != -1) {
            return i;
        }
        this.r = null;
        this.t = null;
        HashMap mapE = e();
        if (mapE != null && mapE.containsKey(str) && (dragBean = (DragBean) mapE.get(str)) != null) {
            a(dragBean.dragBindViewOp);
            IFrameView iFrameView = dragBean.dragBindWebView;
            if (iFrameView != null && (iFrameView instanceof io.dcloud.common.core.ui.b)) {
                this.E = true;
                io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) iFrameView;
                this.r = bVar;
                this.t = bVar.obtainMainView();
            } else {
                View view2 = dragBean.nativeView;
                this.t = view2;
                if (view2 != null) {
                    this.E = true;
                }
            }
        }
        if (a(this.r) && ((view = this.t) == null || !(view instanceof INativeView))) {
            this.I = 0;
        } else {
            if (this.t.getVisibility() != 0) {
                this.r = null;
                this.t = null;
                return 0;
            }
            if (this.t.getParent() == null && (this.s.getParent() instanceof FrameLayout) && !(this.t instanceof INativeView)) {
                this.r.pushToViewStack();
            }
            if (!a(this.s, this.t) && !(this.t instanceof INativeView)) {
                this.r = null;
                this.t = null;
                return 0;
            }
            if (!(this.t instanceof INativeView) && this.G && this.s.getParent() != this.t.getParent()) {
                this.I = 0;
                return 0;
            }
            View view3 = this.t;
            if (view3 instanceof INativeView) {
                view3.bringToFront();
            }
            int iA = a(this.t);
            int iA2 = a(this.s);
            if (iA2 == 0) {
                int width = this.s.getWidth();
                int i2 = this.Q;
                if (width == i2 && (iA >= i2 || iA <= (-b(this.t)))) {
                    this.V = iA;
                    boolean z = this.F;
                    if (z && this.G) {
                        if ("right".equals(str)) {
                            this.l = iA2 - b(this.t);
                        } else if ("left".equals(str)) {
                            this.l = iA2 + this.s.getWidth();
                        }
                        b(this.t, this.l);
                    } else if (!z && this.G) {
                        if ("right".equals(str)) {
                            this.l = -b(this.t);
                        } else if ("left".equals(str)) {
                            this.l = this.s.getWidth();
                        }
                        b(this.t, this.l);
                    }
                }
            }
            this.I = 1;
        }
        return this.I;
    }

    private boolean f() {
        this.o = a(this.t);
        if ("right".equals(this.L)) {
            int i = this.z;
            if (Integer.MAX_VALUE != i) {
                this.p = i;
                return this.o != i;
            }
            this.p = b(this.t);
            int i2 = this.o;
            if (i2 == 0 || i2 == this.Q) {
                return false;
            }
            if ("bounce".equalsIgnoreCase(this.D)) {
                this.p = this.o + (b(this.s) / 2);
                return true;
            }
            if (this.o >= 0) {
                return true;
            }
            this.p = 0;
            return true;
        }
        if (!"left".equals(this.L)) {
            return true;
        }
        int i3 = this.z;
        if (Integer.MAX_VALUE != i3) {
            this.p = i3;
            return this.o != i3;
        }
        int iB = b(this.t);
        this.p = -iB;
        if ("bounce".equalsIgnoreCase(this.D)) {
            this.p = this.o - (b(this.s) / 2);
            return true;
        }
        int i4 = this.Q;
        if (iB < i4) {
            int iA = a(this.t) + b(this.t);
            if (iA == this.Q || iA == 0) {
                return false;
            }
            Rect rect = new Rect();
            this.t.getGlobalVisibleRect(rect);
            int i5 = this.Q;
            if (i5 == rect.left) {
                this.p = i5 - iB;
                return true;
            }
            if (rect.right != 0) {
                return true;
            }
            this.p = 0;
            return true;
        }
        if (iB != i4 || this.o <= 0) {
            return true;
        }
        this.p = 0;
        return true;
    }

    private boolean g() {
        return h() && f();
    }

    private void d() {
        this.S = true;
        j0 = true;
        this.s.requestLayout();
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str) {
        VelocityTracker velocityTracker = this.f;
        if (velocityTracker == null) {
            return false;
        }
        velocityTracker.computeCurrentVelocity(1000, 1000.0f);
        float xVelocity = velocityTracker.getXVelocity();
        this.f.clear();
        this.f.recycle();
        this.f = null;
        return Math.abs(xVelocity) >= 200.0f;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x009d  */
    /* JADX WARN: Code duplicated, block: B:45:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b1 A[PHI: r10 r12
  0x00b1: PHI (r10v12 int) = (r10v11 int), (r10v19 int) binds: [B:46:0x00af, B:38:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x00b1: PHI (r12v1 int) = (r12v0 int), (r12v3 int) binds: [B:46:0x00af, B:38:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x010c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110  */
    /* JADX WARN: Code duplicated, block: B:72:0x0123  */
    /* JADX WARN: Code duplicated, block: B:73:0x0133  */
    /* JADX WARN: Code duplicated, block: B:75:0x0137  */
    /* JADX WARN: Code duplicated, block: B:76:0x0140  */
    /* JADX WARN: Code duplicated, block: B:78:0x0144  */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != 3) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(MotionEvent motionEvent) {
        float x;
        float x2;
        int iA;
        int iB;
        View view;
        float f2;
        float f3;
        int iB2;
        float f4;
        int i;
        int width;
        float f5;
        int i2;
        float f6;
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f7 = rawX - this.i;
                    this.i = rawX;
                    ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
                    boolean z = layoutParams instanceof FrameLayout.LayoutParams;
                    if (z) {
                        x = ViewHelper.getX(this.s);
                    } else {
                        x = layoutParams instanceof AbsoluteLayout.LayoutParams ? ((AbsoluteLayout.LayoutParams) layoutParams).x : 0.0f;
                    }
                    View view2 = this.t;
                    if (view2 != null) {
                        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                        View view3 = this.t;
                        if (view3 instanceof INativeView) {
                            iA = a(view3);
                        } else {
                            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                x2 = ViewHelper.getX(view3);
                            } else if (layoutParams2 instanceof AbsoluteLayout.LayoutParams) {
                                iA = ((AbsoluteLayout.LayoutParams) layoutParams2).x;
                            } else {
                                x2 = 0.0f;
                            }
                            if (0.0f != x) {
                                if ("right".equals(this.L)) {
                                    if (x + f7 >= 0.0f) {
                                        f7 = -x;
                                    } else {
                                        width = (int) (this.s.getWidth() + x);
                                        f6 = width + f7;
                                        i2 = this.Q;
                                        if (f6 >= i2) {
                                            f7 = i2 - width;
                                        }
                                    }
                                } else if ("left".equals(this.L)) {
                                    if (x + f7 <= 0.0f) {
                                        f7 = -x;
                                    } else {
                                        width = (int) (this.s.getWidth() + x);
                                        f5 = width + f7;
                                        i2 = this.Q;
                                        if (f5 <= i2) {
                                            f7 = i2 - width;
                                        }
                                    }
                                }
                            }
                            if ("right".equals(this.L)) {
                                f2 = x2 + f7;
                                f3 = this.Q;
                                if (f2 >= f3) {
                                    f7 = f3 - x2;
                                } else {
                                    iB2 = (int) (x2 + b(this.t));
                                    f4 = iB2 + f7;
                                    i = this.Q;
                                    if (f4 <= i) {
                                        f7 = i - iB2;
                                    }
                                }
                            } else if ("left".equals(this.L)) {
                                iB = (int) (b(this.t) + x2);
                                if (iB + f7 <= 0.0f) {
                                    f7 = -iB;
                                } else if (x2 + f7 >= 0.0f) {
                                    f7 = -x2;
                                }
                            }
                            if (0.0f != x) {
                                if (z) {
                                    View view4 = this.s;
                                    ViewHelper.setX(view4, ViewHelper.getX(view4) + f7);
                                } else if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
                                    ((AbsoluteLayout.LayoutParams) layoutParams).x += (int) f7;
                                    this.s.requestLayout();
                                }
                            }
                            view = this.t;
                            if (view instanceof INativeView) {
                                b(view, (int) (x + f7));
                                this.t.requestLayout();
                                this.t.invalidate();
                            } else if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                ViewHelper.setX(view, ViewHelper.getX(view) + f7);
                            } else if (layoutParams2 instanceof AbsoluteLayout.LayoutParams) {
                                ((AbsoluteLayout.LayoutParams) layoutParams2).x += (int) f7;
                                view.requestLayout();
                            }
                        }
                        x2 = iA;
                        if (0.0f != x) {
                            if ("right".equals(this.L)) {
                                if (x + f7 >= 0.0f) {
                                    f7 = -x;
                                } else {
                                    width = (int) (this.s.getWidth() + x);
                                    f6 = width + f7;
                                    i2 = this.Q;
                                    if (f6 >= i2) {
                                        f7 = i2 - width;
                                    }
                                }
                            } else if ("left".equals(this.L)) {
                                if (x + f7 <= 0.0f) {
                                    f7 = -x;
                                } else {
                                    width = (int) (this.s.getWidth() + x);
                                    f5 = width + f7;
                                    i2 = this.Q;
                                    if (f5 <= i2) {
                                        f7 = i2 - width;
                                    }
                                }
                            }
                        }
                        if ("right".equals(this.L)) {
                            f2 = x2 + f7;
                            f3 = this.Q;
                            if (f2 >= f3) {
                                f7 = f3 - x2;
                            } else {
                                iB2 = (int) (x2 + b(this.t));
                                f4 = iB2 + f7;
                                i = this.Q;
                                if (f4 <= i) {
                                    f7 = i - iB2;
                                }
                            }
                        } else if ("left".equals(this.L)) {
                            iB = (int) (b(this.t) + x2);
                            if (iB + f7 <= 0.0f) {
                                f7 = -iB;
                            } else if (x2 + f7 >= 0.0f) {
                                f7 = -x2;
                            }
                        }
                        if (0.0f != x) {
                            if (z) {
                                View view5 = this.s;
                                ViewHelper.setX(view5, ViewHelper.getX(view5) + f7);
                            } else if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
                                ((AbsoluteLayout.LayoutParams) layoutParams).x += (int) f7;
                                this.s.requestLayout();
                            }
                        }
                        view = this.t;
                        if (view instanceof INativeView) {
                            b(view, (int) (x + f7));
                            this.t.requestLayout();
                            this.t.invalidate();
                        } else if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ViewHelper.setX(view, ViewHelper.getX(view) + f7);
                        } else if (layoutParams2 instanceof AbsoluteLayout.LayoutParams) {
                            ((AbsoluteLayout.LayoutParams) layoutParams2).x += (int) f7;
                            view.requestLayout();
                        }
                    }
                }
            }
            this.T = false;
            this.g = false;
            if (this.H) {
                b();
            }
            return false;
        }
        this.i = rawX;
        this.j = rawY;
        return true;
    }

    private void c() {
        this.S = true;
        j0 = true;
        View view = this.t;
        if (view != null) {
            view.requestLayout();
            this.t.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    private String c(String str) {
        if ("left".equals(str)) {
            return "right";
        }
        if ("right".equals(str)) {
            return "left";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.S) {
            this.S = false;
            a("end", z, z ? "100" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void b() {
        this.S = true;
        j0 = true;
        if (this.t != null) {
            this.s.requestLayout();
            this.s.getViewTreeObserver().addOnGlobalLayoutListener(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int b(View view) {
        if (view == 0) {
            return 0;
        }
        if (view instanceof INativeView) {
            return ((INativeView) view).getStyleWidth();
        }
        return view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view, int i) {
        if (view != 0) {
            if (view instanceof INativeView) {
                ((INativeView) view).setStyleLeft(i);
                return;
            }
            if (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams) {
                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                layoutParams.height = view.getHeight();
                layoutParams.width = view.getWidth();
                ViewHelper.setX(view, i);
                view.requestLayout();
                return;
            }
            if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ViewHelper.setX(view, i);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (jSONObject != null) {
            this.z = Integer.MAX_VALUE;
            this.B = Integer.MAX_VALUE;
            this.A = null;
            this.C = null;
            this.G = "follow".equalsIgnoreCase(JSONUtil.getString(jSONObject, "moveMode"));
            if (jSONObject.has("over") && (jSONObject3 = JSONUtil.getJSONObject(jSONObject, "over")) != null) {
                if (jSONObject3.has("left")) {
                    this.z = PdrUtil.parseInt(JSONUtil.getString(jSONObject3, "left"), this.Q, Integer.MAX_VALUE);
                }
                if (jSONObject3.has("action")) {
                    this.A = JSONUtil.getString(jSONObject3, "action");
                }
            }
            if (!jSONObject.has(BindingXConstants.STATE_CANCEL) || (jSONObject2 = JSONUtil.getJSONObject(jSONObject, BindingXConstants.STATE_CANCEL)) == null) {
                return;
            }
            if (jSONObject2.has("left")) {
                this.B = PdrUtil.parseInt(JSONUtil.getString(jSONObject2, "left"), this.Q, Integer.MAX_VALUE);
            }
            if (jSONObject2.has("action")) {
                this.C = JSONUtil.getString(jSONObject2, "action");
            }
        }
    }

    private boolean a(View view, View view2) {
        if (view != null && view2 != null) {
            ViewParent parent = view2.getParent();
            for (ViewParent parent2 = view.getParent(); parent2 != null && parent2 != view2; parent2 = parent2.getParent()) {
                while (parent != null) {
                    if (parent == view) {
                        return false;
                    }
                    if (parent2 == parent) {
                        return true;
                    }
                    parent = parent.getParent();
                }
                parent = view2.getParent();
            }
            return false;
        }
        return false;
    }

    private void a() {
        this.S = true;
        j0 = true;
        this.s.requestLayout();
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.S) {
            this.S = false;
            a("end", z, z2, z ? "100" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        io.dcloud.common.core.ui.b bVar;
        io.dcloud.common.core.ui.b bVar2;
        if (view != null) {
            if (view == this.s && (bVar2 = this.q) != null) {
                bVar2.obtainFrameOptions().left = i;
                this.q.obtainFrameOptions().checkValueIsPercentage("left", i, this.Q, true, true);
            } else {
                if (view != this.t || (bVar = this.r) == null) {
                    return;
                }
                bVar.obtainFrameOptions().left = i;
                this.r.obtainFrameOptions().checkValueIsPercentage("left", i, this.Q, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator a(View view, int i, int i2, boolean z) {
        return a(view, i, i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator a(View view, int i, int i2, boolean z, boolean z2) {
        ValueAnimator valueAnimatorOfFloat = null;
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((view instanceof INativeView) || (layoutParams instanceof AbsoluteLayout.LayoutParams)) {
            valueAnimatorOfFloat = ValueAnimator.ofInt(i, i2);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        }
        valueAnimatorOfFloat.setDuration(Math.min(Math.max(new BigDecimal(450).multiply(new BigDecimal(Math.abs(i2 - i)).divide(new BigDecimal(this.Q), 4, 4)).longValue(), 200L), 250L));
        valueAnimatorOfFloat.addListener(new d(z, z2, view, i2));
        valueAnimatorOfFloat.addUpdateListener(new e(view));
        return valueAnimatorOfFloat;
    }

    private void a(String str, boolean z, String str2) {
        a(str, z, false, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    public void a(String str, boolean z, boolean z2, String str2) {
        String strObtainFrameId;
        String str3;
        if ("end".equals(str)) {
            if (!a(this.q)) {
                this.q.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(this.b);
                this.q.obtainWebView().obtainWindowView().setHorizontalScrollBarEnabled(this.c);
            }
            View view = this.t;
            if (view != null && (view instanceof com.dcloud.android.widget.AbsoluteLayout)) {
                ((com.dcloud.android.widget.AbsoluteLayout) view).getDrag().c(false);
                if (!a(this.r)) {
                    this.r.obtainWebView().obtainWindowView().setVerticalScrollBarEnabled(this.d);
                    WebView webViewObtainWebview = this.r.obtainWebView().obtainWebview();
                    if (webViewObtainWebview != null) {
                        webViewObtainWebview.setHorizontalScrollbarOverlay(this.e);
                    }
                }
            }
        }
        if (this.J == null || TextUtils.isEmpty(this.K) || TextUtils.isEmpty(str)) {
            return;
        }
        KeyEvent.Callback callback = this.t;
        String strObtainFrameId2 = null;
        if (callback == null) {
            strObtainFrameId = null;
        } else if (callback instanceof INativeView) {
            strObtainFrameId = ((INativeView) callback).getViewId();
        } else {
            io.dcloud.common.core.ui.b bVar = this.r;
            if (bVar == null || bVar.obtainWebView() == null) {
                strObtainFrameId = null;
            } else {
                strObtainFrameId = this.r.obtainWebView().obtainFrameId();
            }
        }
        io.dcloud.common.core.ui.b bVar2 = this.q;
        if (bVar2 != null && bVar2.obtainWebView() != null) {
            strObtainFrameId2 = this.q.obtainWebView().obtainFrameId();
        }
        String str4 = (!z ? z2 : !z2) ? strObtainFrameId2 : strObtainFrameId;
        if (!a(this.r) && this.r.isWebviewCovered()) {
            if (!a(this.q) && !this.q.isWebviewCovered()) {
                str4 = strObtainFrameId2;
            }
        } else if (!a(this.q) && this.q.isWebviewCovered() && !a(this.r) && !this.r.isWebviewCovered()) {
            str4 = strObtainFrameId;
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = Constants.Name.UNDEFINED;
        }
        String str5 = "";
        if (TextUtils.isEmpty(strObtainFrameId2)) {
            strObtainFrameId2 = "";
        }
        if (TextUtils.isEmpty(strObtainFrameId)) {
            strObtainFrameId = "";
        }
        if ("left".equals(this.L)) {
            str5 = Constants.Name.RTL;
        } else if ("right".equals(this.L)) {
            str5 = "ltr";
        }
        if (this.J.obtainWebView() != null) {
            if ("end".equals(str)) {
                str3 = StringUtil.format("{\"type\":\"%s\",\"result\":%b,\"id\":\"%s\",\"targetId\":\"%s\",\"otherId\":\"%s\",\"direction\":\"%s\",\"progress\":\"%s\"}", str, Boolean.valueOf(z), str4, strObtainFrameId2, strObtainFrameId, str5, str2);
            } else {
                str3 = StringUtil.format("{\"type\":\"%s\",\"id\":\"%s\",\"targetId\":\"%s\",\"otherId\":\"%s\",\"direction\":\"%s\",\"progress\":\"%s\"}", str, str4, strObtainFrameId2, strObtainFrameId, str5, str2);
            }
            Deprecated_JSUtil.execCallback(this.J.obtainWebView(), this.K, str3, JSUtil.OK, true, true);
        }
    }

    public View a(String str) {
        DragBean dragBean;
        IFrameView iFrameView;
        View viewObtainMainView;
        String strC = c(str);
        HashMap<String, DragBean> map = this.q.obtainFrameOptions().dragData;
        if (map == null || !map.containsKey(strC) || (dragBean = map.get(strC)) == null || (iFrameView = dragBean.dragBindWebView) == null || !"follow".equalsIgnoreCase(JSONUtil.getString(dragBean.dragBindViewOp, "moveMode")) || (viewObtainMainView = iFrameView.obtainMainView()) == null || viewObtainMainView.getVisibility() != 0 || viewObtainMainView.getWidth() >= this.Q) {
            return null;
        }
        int iA = a(viewObtainMainView);
        int width = viewObtainMainView.getWidth() + iA;
        if ((iA < 0 || iA >= this.Q) && (width <= 0 || width > this.Q)) {
            return null;
        }
        return viewObtainMainView;
    }

    private float a(float f2) {
        if (!"bounce".equalsIgnoreCase(this.D) || 0.0f == f2) {
            return f2;
        }
        boolean z = f2 < 0.0f;
        float fFloatValue = new BigDecimal(f2).multiply(new BigDecimal(Math.abs(this.n - a(this.s))).divide(new BigDecimal(this.n - this.m), 4, 4)).floatValue();
        if (z) {
            fFloatValue = -fFloatValue;
        }
        if (z) {
            return Math.min(fFloatValue, -2.0f);
        }
        return Math.max(fFloatValue, 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int a(View view) {
        if (view == 0) {
            return 0;
        }
        if (view instanceof INativeView) {
            return ((INativeView) view).getStyleLeft();
        }
        if (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams) {
            return (int) ViewHelper.getX(view);
        }
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            return (int) ViewHelper.getX(view);
        }
        return 0;
    }

    private boolean a(io.dcloud.common.core.ui.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar != null && bVar.obtainWebView() == null) {
            return true;
        }
        if (bVar == null || bVar.obtainMainView() != null) {
            return bVar != null && bVar.obtainWebView() == null && bVar.obtainMainView() == null;
        }
        return true;
    }
}
