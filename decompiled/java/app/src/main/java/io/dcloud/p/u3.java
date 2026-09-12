package io.dcloud.p;

import android.content.Context;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.feature.gg.dcloud.ADHandler;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class u3 extends v {
    t1.a[] a;
    Context b;
    boolean c = false;
    JSONObject d = new JSONObject();

    public u3() {
        if (DHFile.hasFile()) {
            w0.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context) {
        ADHandler.pull(context, r0.d().b().getAppId());
    }

    @Override // io.dcloud.p.h3, io.dcloud.p.t1
    public void a(final Context context, int i, t1.a... aVarArr) {
        this.c = true;
        if (i != 1) {
            MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.u3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    u3.c(context);
                }
            });
        } else {
            this.a = aVarArr;
            this.b = context;
        }
    }

    public HashMap b(Context context) {
        return x3.a(context);
    }

    public void a(JSONObject jSONObject) {
        String[] strArr;
        Context context;
        JSONArray jSONArrayNames = jSONObject.names();
        p0 p0Var = null;
        if (jSONArrayNames != null) {
            strArr = new String[jSONArrayNames.length()];
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                strArr[i] = jSONArrayNames.optString(i);
            }
        } else {
            strArr = null;
        }
        if (strArr != null) {
            try {
                p0Var = new p0(jSONObject, strArr);
            } catch (JSONException unused) {
            }
        }
        if (p0Var != null && p0Var.has("7C61656D") && (context = this.b) != null) {
            a(p0Var, context);
        }
        t1.a[] aVarArr = this.a;
        if (aVarArr != null) {
            for (t1.a aVar : aVarArr) {
                if (p0Var == null) {
                    aVar.a(-5007, "数据解析异常");
                } else {
                    aVar.a(p0Var);
                }
            }
        }
    }

    public void a(int i, String str) {
        t1.a[] aVarArr = this.a;
        if (aVarArr != null) {
            for (t1.a aVar : aVarArr) {
                aVar.a(i, str);
            }
        }
    }
}
