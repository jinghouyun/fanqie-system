package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class k1 extends y4 {
    protected z1 C;

    public k1(Activity activity, int i) {
        super(activity, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i, String str, JSONArray jSONArray) {
        z1 z1Var = this.C;
        if (z1Var != null) {
            z1Var.onError(i, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(List list) {
        z1 z1Var = this.C;
        if (z1Var != null) {
            z1Var.onLoaded(list);
        }
    }

    public void a(DCloudAOLSlot dCloudAOLSlot, z1 z1Var) {
        super.h();
        a(dCloudAOLSlot);
        this.C = z1Var;
        a3.a().post(this);
        this.w = true;
    }

    @Override // io.dcloud.p.y4
    protected void d(final int i, final String str, final JSONArray jSONArray) {
        c3.b("uniAd-loadError", "code:" + i + ";message:" + str + ";detail:" + String.valueOf(jSONArray));
        if (g()) {
            e();
        }
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.k1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(i, str, jSONArray);
            }
        });
    }

    protected List f(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new j1((DCBaseAOL) it.next(), a()));
            }
        }
        return arrayList;
    }

    @Override // io.dcloud.p.y4
    protected void e(List list) {
        if (g()) {
            e();
        }
        final List listF = f(list);
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.k1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g(listF);
            }
        });
    }
}
