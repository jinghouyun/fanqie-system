package io.dcloud.p;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends i4 implements j {
    private final List f;
    private final List g;
    private u1 h;
    private boolean i;
    private final Handler j;
    private final int k;
    private final int l;
    private long m;
    protected String n;
    private boolean o;
    private t0 p;
    private Set q;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface a {
        void a(DCBaseAOLLoader dCBaseAOLLoader, n1 n1Var);

        void a(DCBaseAOLLoader dCBaseAOLLoader, List list, n1 n1Var);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            w.this.k();
        }
    }

    public w(Activity activity) {
        super(activity);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = false;
        this.k = 3;
        this.l = 18000;
        this.m = 0L;
        this.n = "";
        this.o = false;
        this.q = new HashSet();
        this.j = new b(a3.a().getLooper());
    }

    private void c(int i, String str) {
        b(i, str, null);
    }

    private void h() {
        this.b.setRID(this.n);
        long jE = ((long) this.p.e()) - (SystemClock.elapsedRealtime() - this.m);
        if (jE <= 0) {
            c(-5005, AOLErrorUtil.getErrorMsg(-5018));
            return;
        }
        this.j.removeMessages(3);
        this.j.sendEmptyMessageDelayed(3, jE);
        if (this.d != this.p.f() && (this.d != 4 || this.p.f() != 5)) {
            c(-5011, AOLErrorUtil.getErrorMsg(-5011));
            return;
        }
        List listD = this.p.d();
        if (listD == null || listD.isEmpty()) {
            c(-5019, AOLErrorUtil.getErrorMsg(-5019));
            return;
        }
        if (a(this.p, listD)) {
            return;
        }
        c3.a("level load finish.total:" + this.f.size());
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            c3.a(((u1) it.next()).toString());
        }
        j();
    }

    private void j() {
        if (this.f.size() <= 0 || this.i) {
            if (this.h != null) {
                if (!g()) {
                    ((y) this.h).f();
                }
                b(this.h.e());
            }
            e();
            return;
        }
        u1 u1Var = (u1) this.f.remove(0);
        u1 u1Var2 = this.h;
        if (u1Var2 == null || u1Var2.a() <= 0) {
            this.g.add(u1Var);
            u1Var.a(this.n);
            u1Var.h();
            return;
        }
        c3.a("is necessary to load next:" + u1Var.e(this.h.a()) + ",next level:" + u1Var.c());
        if (!u1Var.e(this.h.a())) {
            j();
            return;
        }
        u1Var.c(this.h.a());
        this.g.add(u1Var);
        u1Var.a(this.n);
        u1Var.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.i = true;
        c3.b("this slot:time out");
        if (this.g.isEmpty()) {
            a(new JSONArray());
            return;
        }
        for (u1 u1Var : this.g) {
            if (!u1Var.g()) {
                u1Var.k();
            }
        }
    }

    protected abstract void a(int i, String str, JSONArray jSONArray);

    @Override // io.dcloud.p.y3
    protected boolean b() {
        return 1 == this.p.c();
    }

    protected abstract void c(List list);

    protected void e() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((u1) it.next()).d());
        }
        JSONArray jSONArray = new JSONArray();
        a(arrayList, jSONArray, jElapsedRealtime);
        a(jSONArray);
    }

    boolean f() {
        int i = this.d;
        return i == 10 || i == 4 || i == 5;
    }

    public boolean g() {
        return false;
    }

    public DCBaseAOLLoader i() {
        return null;
    }

    @Override // io.dcloud.p.i4, java.lang.Runnable
    public void run() {
        this.n = UUID.randomUUID().toString();
        this.g.clear();
        this.f.clear();
        this.q.clear();
        this.h = null;
        this.i = false;
        this.o = false;
        this.j.sendEmptyMessageDelayed(3, 18000L);
        this.m = SystemClock.elapsedRealtime();
        super.run();
    }

    @Override // io.dcloud.p.i4
    protected void a(t0 t0Var) {
        this.p = t0Var;
        this.b.setAdpid(t0Var.a());
        h();
    }

    @Override // io.dcloud.p.j
    public void b(u1 u1Var) {
        j();
    }

    private void b(int i, String str, JSONArray jSONArray) {
        if (this.o) {
            return;
        }
        this.o = true;
        c3.b("this slot:all fail");
        this.j.removeMessages(3);
        a(i, str, jSONArray);
    }

    @Override // io.dcloud.p.i4
    protected void a(int i, String str) {
        b(i, str, null);
    }

    private boolean a(t0 t0Var, List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        x xVar = null;
        while (it.hasNext()) {
            v4 v4Var = (v4) it.next();
            int iF = v4Var.f();
            if (v4Var.u()) {
                if (xVar == null) {
                    xVar = new x(this.b, this.c);
                    xVar.a(t0Var.f());
                    if (t0Var.g()) {
                        xVar.j();
                    }
                }
                xVar.d(iF);
                xVar.a(v4Var);
            } else {
                u1 u1Var = (u1) map.get(Integer.valueOf(iF));
                if (u1Var != null) {
                    u1Var.a(v4Var);
                } else {
                    z4 z4Var = new z4(this.b, this.c);
                    if (t0Var.g()) {
                        z4Var.j();
                    }
                    z4Var.a(t0Var.f());
                    z4Var.a(this);
                    z4Var.d(v4Var.f());
                    z4Var.a(v4Var);
                    map.put(Integer.valueOf(v4Var.f()), z4Var);
                }
            }
        }
        if (xVar != null) {
            if (map.containsKey(Integer.valueOf(xVar.c()))) {
                g3 g3Var = new g3(this.b, this.c);
                g3Var.a(xVar);
                g3Var.a((z4) map.get(Integer.valueOf(xVar.c())));
                g3Var.d(xVar.c());
                g3Var.a(this);
                g3Var.a(t0Var.f());
                if (t0Var.g()) {
                    g3Var.j();
                }
                map.put(Integer.valueOf(xVar.c()), g3Var);
            } else {
                xVar.a(this);
                map.put(Integer.valueOf(xVar.c()), xVar);
            }
        }
        this.f.addAll(map.values());
        if (this.f.size() > 1) {
            Collections.sort(this.f, new Comparator() { // from class: io.dcloud.p.w$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return w.a((u1) obj, (u1) obj2);
                }
            });
            return false;
        }
        if (map.size() == 1) {
            return false;
        }
        c(-5020, AOLErrorUtil.getErrorMsg(-5020));
        return true;
    }

    private void b(List list) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (w0.a) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                DCBaseAOL dCBaseAOL = (DCBaseAOL) it.next();
                c3.a("success!index:" + i + ";ad:" + dCBaseAOL.toString() + ";type:" + dCBaseAOL.getType() + ",id:" + dCBaseAOL.getSlotId() + ",isbid:" + dCBaseAOL.isSlotSupportBidding() + ",bidPrice:" + dCBaseAOL.getBiddingECPM());
                i++;
            }
        }
        this.j.removeMessages(3);
        a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(u1 u1Var, u1 u1Var2) {
        return Integer.compare(u1Var.c(), u1Var2.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.dcloud.p.y3
    public Activity a() {
        return this.c;
    }

    @Override // io.dcloud.p.j
    public void a(u1 u1Var) {
        c3.a("level load success.current:" + u1Var.c() + ",is bid:" + u1Var.b());
        if (u1Var.b()) {
            this.h = u1Var;
            j();
            return;
        }
        u1 u1Var2 = this.h;
        if (u1Var2 != null && (u1Var2 instanceof y)) {
            if (f()) {
                m.a aVarA = m.a(this.b.getCount(), this.h.e(), u1Var.e());
                if (aVarA == null) {
                    this.h = null;
                    j();
                    return;
                }
                if (!g()) {
                    for (DCBaseAOL dCBaseAOL : aVarA.d) {
                        if (dCBaseAOL.isSlotSupportBidding()) {
                            dCBaseAOL.biddingSuccess(aVarA.b, aVarA.c);
                        }
                    }
                }
                b(aVarA.d);
            } else if (u1Var.a() > this.h.a()) {
                ((y) this.h).b(u1Var.a());
                b(u1Var.e());
            } else {
                if (!g()) {
                    ((y) this.h).f();
                }
                b(this.h.e());
            }
        } else {
            b(u1Var.e());
        }
        e();
    }

    private void a(List list, JSONArray jSONArray, long j) {
        if (list.isEmpty()) {
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n1 n1Var = (n1) it.next();
            if (n1Var.e()) {
                if (this.q.contains(n1Var.c())) {
                    n1Var.f();
                }
                if (n1Var.d() == 0) {
                    jSONArray.put(n1Var.b());
                }
                jSONArray2.put(n1Var.g());
            }
        }
        c3.b("collection data:load time:" + j);
        a(this.p.f(), this.b.getAdpid(), this.p.g() ? "1" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, this.b.getEI(), jSONArray2, j);
    }

    private void a(JSONArray jSONArray) {
        if (this.i) {
            b(-5005, AOLErrorUtil.getErrorMsg(-5018), jSONArray);
        } else {
            b(-5005, AOLErrorUtil.getErrorMsg(-5005), jSONArray);
        }
    }

    private void a(List list) {
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.q.add(((DCBaseAOL) it.next()).getSlotId());
            }
        }
        c(list);
    }
}
