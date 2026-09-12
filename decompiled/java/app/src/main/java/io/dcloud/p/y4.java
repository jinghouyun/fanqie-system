package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.adapter.IAdAdapter;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.IToggle;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.util.Const;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class y4 extends b5 implements w.a, IToggle {
    private IToggle.CADLoadListener A;
    private boolean B;
    private n1 x;
    protected boolean y;
    private List z;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends HashMap {
        a() {
            put(Const.DC_ADN, y4.this);
        }
    }

    public y4(Activity activity, int i) {
        super(activity, i);
        this.y = false;
        this.z = null;
        this.B = false;
    }

    private v4 b(t0 t0Var) {
        Iterator it = t0Var.d().iterator();
        while (it.hasNext()) {
            v4 v4Var = (v4) it.next();
            if (Const.TYPE_GM.equals(v4Var.l()) && v4Var.u()) {
                it.remove();
                return v4Var;
            }
        }
        return null;
    }

    private void c(t0 t0Var) {
        v4 v4VarB;
        IAdAdapter iAdAdapterB = e.b().b(Const.TYPE_GM);
        if (iAdAdapterB == null || !t0Var.b().contains(Const.TYPE_GM) || (v4VarB = b(t0Var)) == null) {
            return;
        }
        a(iAdAdapterB, v4VarB);
    }

    @Override // io.dcloud.p.w, io.dcloud.p.i4
    protected void a(t0 t0Var) {
        int i;
        if (m.f(a()) && (i = this.d) != 14 && i != 5 && i != 7 && i != 11) {
            c(t0Var);
        }
        super.a(t0Var);
    }

    protected void d(int i, String str, JSONArray jSONArray) {
        super.a(i, str, jSONArray);
        if (g()) {
            e();
        }
    }

    protected void e(List list) {
        super.c(list);
        if (g()) {
            e();
        }
    }

    @Override // io.dcloud.p.w
    public boolean g() {
        return this.y;
    }

    @Override // io.dcloud.sdk.core.interfaces.IToggle
    public List getSuccessAds() {
        return this.z;
    }

    protected void h() {
        this.B = false;
        this.x = null;
        this.y = false;
        this.z = null;
        this.A = null;
    }

    @Override // io.dcloud.sdk.core.interfaces.IToggle
    public void setCADLoadListener(IToggle.CADLoadListener cADLoadListener) {
        this.A = cADLoadListener;
    }

    private void a(IAdAdapter iAdAdapter, v4 v4Var) {
        this.y = true;
        DCBaseAOLLoader ad = iAdAdapter.getAd(a(), this.b);
        a0 a0VarA = b0.a().a(Const.TYPE_GM);
        if (a0VarA != null) {
            ad.a(a0VarA.a(), a0VarA.b());
        }
        ad.a(v4Var);
        ad.a(this);
        ad.d(this.n);
        this.b.setRID(this.n);
        ad.b(new a());
    }

    @Override // io.dcloud.p.b5, io.dcloud.p.w
    protected void c(List list) {
        if (this.y) {
            this.z = list;
            if (this.A != null) {
                if (list != null && !list.isEmpty()) {
                    this.A.onLoadSuccess(this.z);
                    return;
                } else {
                    this.A.onLoadFail(-5005, AOLErrorUtil.getErrorMsg(-5005));
                    return;
                }
            }
            return;
        }
        this.w = false;
        e(list);
    }

    @Override // io.dcloud.p.w.a
    public void a(DCBaseAOLLoader dCBaseAOLLoader, List list, n1 n1Var) {
        if (this.y) {
            this.x = n1Var;
            n1Var.f();
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                arrayList.add(dCBaseAOLLoader);
            } else {
                arrayList.addAll(list);
            }
            this.w = false;
            e(arrayList);
        }
    }

    @Override // io.dcloud.p.w.a
    public void a(DCBaseAOLLoader dCBaseAOLLoader, n1 n1Var) {
        if (this.y) {
            this.x = n1Var;
            this.w = false;
            d(-5005, AOLErrorUtil.getErrorMsg(-5005), new JSONArray().put(n1Var.b()));
        }
    }

    @Override // io.dcloud.p.b5, io.dcloud.p.w
    protected void a(int i, String str, JSONArray jSONArray) {
        if (this.y) {
            IToggle.CADLoadListener cADLoadListener = this.A;
            if (cADLoadListener != null) {
                cADLoadListener.onLoadFail(i, jSONArray.toString());
                return;
            }
            return;
        }
        this.w = false;
        d(i, str, jSONArray);
    }

    @Override // io.dcloud.p.y3
    protected void a(int i, String str, String str2, String str3, JSONArray jSONArray, long j) {
        if (this.y) {
            n1 n1Var = this.x;
            if (n1Var == null) {
                return;
            } else {
                jSONArray.put(n1Var.g());
            }
        }
        if (this.B) {
            return;
        }
        this.B = true;
        super.a(i, str, str2, str3, jSONArray, j);
    }

    @Override // io.dcloud.p.b5
    public void a(DCloudAOLSlot dCloudAOLSlot, w2 w2Var) {
        h();
        super.a(dCloudAOLSlot, w2Var);
        this.w = true;
    }
}
