package io.dcloud.p;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class z0 {
    private static z0 a;
    private static List b = new ArrayList();

    private z0() {
    }

    public static z0 a(Context context) {
        if (a == null) {
            synchronized (z0.class) {
                if (a == null) {
                    a = new z0();
                }
            }
        }
        return a;
    }

    public void b(y0 y0Var) {
        b.remove(y0Var);
    }

    public void a(y0 y0Var) {
        b.add(y0Var);
        x4.a().a(y0Var);
    }

    public List a() {
        return b;
    }
}
