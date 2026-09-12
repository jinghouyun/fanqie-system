package io.dcloud.p;

import com.taobao.weex.el.parse.Operators;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class g2 {
    public float a;
    public float b;
    public float c;
    public float d;

    public g2(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public String toString() {
        return "IMGHoming{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + Operators.BLOCK_END;
    }

    public void a(g2 g2Var) {
        this.c *= g2Var.c;
        this.a -= g2Var.a;
        this.b -= g2Var.b;
    }

    public static boolean a(g2 g2Var, g2 g2Var2) {
        return Float.compare(g2Var.d, g2Var2.d) != 0;
    }
}
