package io.dcloud.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import io.dcloud.common.util.net.NetWork;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class h3 implements t1 {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends ArrayList {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
            addAll(i != 1 ? r1.e : r1.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements q1.b {
        String[] a = new String[1];
        final /* synthetic */ t1.a[] b;
        final /* synthetic */ String c;
        final /* synthetic */ HashMap d;
        final /* synthetic */ Context e;

        b(t1.a[] aVarArr, String str, HashMap map, Context context) {
            this.b = aVarArr;
            this.c = str;
            this.d = map;
            this.e = context;
        }

        @Override // io.dcloud.p.q1.b
        public void a(q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(q1.a aVar) {
            byte[] bArrA = l3.a(aVar.a(), this.c, this.d, this.a);
            if (bArrA == null) {
                return false;
            }
            try {
                p0 p0Var = new p0(new String(bArrA));
                if (p0Var.has("7C61656D")) {
                    h3.this.a(p0Var, this.e);
                }
                if (!p0Var.has("6C697C69")) {
                    for (t1.a aVar2 : this.b) {
                        aVar2.a(-1, AOLErrorUtil.getErrorMsg(-5007));
                    }
                    return true;
                }
                p0Var.put("6C697C69", new p0(new String(d.a(Base64.decode(p0Var.getString("6C697C69"), 2), f1.b(), f1.a()))));
                for (t1.a aVar3 : this.b) {
                    aVar3.a(p0Var);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                for (t1.a aVar4 : this.b) {
                    aVar4.a(-1, AOLErrorUtil.getErrorMsg(-5007));
                }
                return true;
            }
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
            for (t1.a aVar : this.b) {
                aVar.a(-1, this.a[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Context context, int i, t1.a[] aVarArr) {
        String strEncode;
        String strEncodeToString = Base64.encodeToString(d.b(g5.a(new p0(x3.a(context)).toString()), f1.b(), f1.a()), 2);
        c3.c("uniAd-msg", strEncodeToString);
        try {
            strEncode = URLEncoder.encode(strEncodeToString, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            strEncode = null;
        }
        String str = "edata=" + strEncode;
        HashMap map = new HashMap();
        map.put(NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        q1.a().a(context, new a(i), i != 1 ? "ThirdConfig" : "Splash", new b(aVarArr, str, map, context));
    }

    @Override // io.dcloud.p.t1
    public void a(final Context context, final int i, final t1.a... aVarArr) {
        if (r0.d().b() != null && !TextUtils.isEmpty(r0.d().b().getAdId()) && !TextUtils.isEmpty(r0.d().b().getAppId())) {
            x4.a().a(new Runnable() { // from class: io.dcloud.p.h3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(context, i, aVarArr);
                }
            });
            return;
        }
        for (t1.a aVar : aVarArr) {
            aVar.a(-5016, AOLErrorUtil.getErrorMsg(-5016));
        }
    }

    protected void a(p0 p0Var, Context context) {
        long j;
        try {
            j = Long.parseLong(m.c(context));
        } catch (Exception unused) {
            j = 0;
        }
        long jOptLong = p0Var.optLong("7C61656D");
        if (j > 0 && jOptLong > 0 && !m.a(j * 1000, 1000 * jOptLong)) {
            m.a(context);
        }
        m.a(context, String.valueOf(jOptLong));
    }
}
