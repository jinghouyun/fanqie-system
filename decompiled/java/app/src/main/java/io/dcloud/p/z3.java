package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class z3 extends y4 implements AOLLoader.RewVAOLInteractionListener {
    public z3(Activity activity) {
        super(activity, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JSONObject jSONObject) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.RewVAOLInteractionListener) {
            ((AOLLoader.RewVAOLInteractionListener) vAOLInteractionListener).onReward(jSONObject);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(final JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!jSONObject.has("provider")) {
            try {
                jSONObject.put("provider", e.b().c(this.t.getType()));
            } catch (Exception unused) {
            }
        }
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.z3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(jSONObject);
            }
        });
    }
}
