package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class g3 implements u1, j, y {
    private z4 a;
    private x d;
    private int g;
    private j h;
    private int i;
    protected final DCloudAOLSlot n;
    protected final Activity o;
    private boolean b = false;
    private boolean c = false;
    private boolean e = false;
    private boolean f = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private final List p = new ArrayList();

    public g3(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        this.n = dCloudAOLSlot;
        this.o = activity;
    }

    private void m() {
        boolean z = this.e;
        if (z && this.b) {
            if (l()) {
                m.a aVarA = m.a(this.n.getCount(), this.d.e(), this.a.e());
                if (aVarA == null) {
                    n();
                    return;
                }
                this.k = true;
                for (DCBaseAOL dCBaseAOL : aVarA.d) {
                    if (dCBaseAOL.isSlotSupportBidding()) {
                        dCBaseAOL.biddingSuccess(aVarA.b, aVarA.c);
                    }
                }
                this.p.addAll(aVarA.d);
            } else if (this.d.a() >= this.a.a()) {
                this.j = true;
            } else {
                this.k = true;
                this.d.b(this.a.a());
            }
            o();
            return;
        }
        if (z && this.c) {
            this.j = true;
            this.p.addAll(this.d.e());
            o();
            return;
        }
        boolean z2 = this.f;
        if (z2 && this.b) {
            this.k = true;
            this.p.addAll(this.a.e());
            o();
        } else if (z2 && this.c) {
            n();
        }
    }

    @Override // io.dcloud.p.u1
    public void a(v4 v4Var) {
    }

    public void a(z4 z4Var) {
        this.a = z4Var;
    }

    @Override // io.dcloud.p.u1
    public boolean b() {
        return this.j;
    }

    @Override // io.dcloud.p.u1
    public void c(int i) {
    }

    @Override // io.dcloud.p.u1
    public void d(int i) {
        this.g = i;
    }

    @Override // io.dcloud.p.u1
    public boolean e(int i) {
        return true;
    }

    @Override // io.dcloud.p.y
    public void f() {
        if (b()) {
            this.d.f();
        }
    }

    @Override // io.dcloud.p.u1
    public boolean g() {
        z4 z4Var = this.a;
        return z4Var != null && this.d != null && z4Var.g() && this.d.g();
    }

    @Override // io.dcloud.p.u1
    public void h() {
        if (this.l) {
            n();
            return;
        }
        x xVar = this.d;
        if (xVar != null) {
            xVar.a(this);
            this.d.h();
        }
        z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(this);
            this.a.h();
        }
    }

    @Override // io.dcloud.p.j
    public DCBaseAOLLoader i() {
        return null;
    }

    @Override // io.dcloud.p.u1
    public void j() {
        if (this.j) {
            this.d.j();
        }
        if (this.k) {
            this.a.j();
        }
    }

    @Override // io.dcloud.p.u1
    public void k() {
        this.l = true;
        x xVar = this.d;
        if (xVar != null) {
            xVar.k();
        }
        z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.k();
        }
    }

    boolean l() {
        int i = this.i;
        return i == 10 || i == 4 || i == 5;
    }

    protected void n() {
        if (this.m) {
            return;
        }
        this.m = true;
        j jVar = this.h;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    protected void o() {
        if (this.m) {
            return;
        }
        this.m = true;
        j jVar = this.h;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    public String toString() {
        return "Bidding:" + this.d.toString() + ",Usual:" + this.a.toString();
    }

    public void a(x xVar) {
        this.d = xVar;
    }

    @Override // io.dcloud.p.j
    public void b(u1 u1Var) {
        if (u1Var == this.a) {
            this.c = true;
        } else if (u1Var == this.d) {
            this.f = true;
        }
        m();
    }

    @Override // io.dcloud.p.u1
    public int c() {
        return this.g;
    }

    @Override // io.dcloud.p.u1
    public List d() {
        ArrayList arrayList = new ArrayList();
        x xVar = this.d;
        if (xVar != null) {
            arrayList.addAll(xVar.d());
        }
        z4 z4Var = this.a;
        if (z4Var != null) {
            arrayList.addAll(z4Var.d());
        }
        return arrayList;
    }

    @Override // io.dcloud.p.u1
    public List e() {
        if (l()) {
            return this.p;
        }
        if (this.j) {
            return this.d.e();
        }
        if (this.k) {
            return this.a.e();
        }
        return null;
    }

    @Override // io.dcloud.p.u1
    public void a(j jVar) {
        this.h = jVar;
    }

    @Override // io.dcloud.p.u1
    public int a() {
        if (l()) {
            if (this.p.isEmpty()) {
                return -1;
            }
            m.a(this.p);
            List list = this.p;
            return ((DCBaseAOL) list.get(list.size() - 1)).getBiddingECPM();
        }
        if (this.j) {
            return this.d.a();
        }
        if (this.k) {
            return this.a.a();
        }
        return -1;
    }

    @Override // io.dcloud.p.y
    public void b(int i) {
        if (b()) {
            this.d.b(i);
        }
    }

    @Override // io.dcloud.p.u1
    public void a(int i) {
        this.i = i;
        x xVar = this.d;
        if (xVar != null) {
            xVar.a(i);
        }
        z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(i);
        }
    }

    @Override // io.dcloud.p.u1
    public void a(String str) {
        x xVar = this.d;
        if (xVar != null) {
            xVar.a(str);
        }
        z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(str);
        }
    }

    @Override // io.dcloud.p.j
    public void a(u1 u1Var) {
        if (u1Var == this.a) {
            this.b = true;
        } else if (u1Var == this.d) {
            this.e = true;
        }
        m();
    }
}
