package io.dcloud.p;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class a1 extends y4 implements AOLLoader.RewVAOLInteractionListener {
    public a1(Activity activity, int i) {
        super(activity, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JSONObject jSONObject) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.RewVAOLInteractionListener) {
            ((AOLLoader.RewVAOLInteractionListener) vAOLInteractionListener).onReward(jSONObject);
        }
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.b5
    public void a(DCloudAOLSlot dCloudAOLSlot, w2 w2Var) {
        try {
            Class.forName("com.bytedance.sdk.djx.DJXSdk");
            super.a(dCloudAOLSlot, w2Var);
        } catch (ClassNotFoundException unused) {
            if (w2Var != null) {
                w2Var.onError(-5051, "当前环境没有穿山甲内容联盟SDK", null);
            }
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(final JSONObject jSONObject) {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.a1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(jSONObject);
            }
        });
    }

    public Fragment s() {
        DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            try {
                return (Fragment) dCBaseAOL.getClass().getDeclaredMethod("getDramaPage", null).invoke(this.t, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void a(int i) {
        DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            try {
                dCBaseAOL.getClass().getDeclaredMethod("setLockCount", Integer.TYPE).invoke(this.t, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }
}
