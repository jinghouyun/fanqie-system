package io.dcloud.sdk.core.v3.rew;

import android.app.Activity;
import io.dcloud.p.w2;
import io.dcloud.p.z3;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCRewAOL extends DCBaseAOL implements AOLLoader.RewVAOLInteractionListener {
    private z3 b;
    private DCRewAOLListener c;

    public DCRewAOL(Activity activity) {
        super(activity);
        this.b = new z3(activity);
    }

    public void destroy() {
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.destroy();
        }
    }

    public void getRetryRewardResult(AOLLoader.GetConvertResultListener getConvertResultListener) {
        this.b.a(getConvertResultListener);
    }

    public String getType() {
        z3 z3Var = this.b;
        return z3Var == null ? "" : z3Var.getType();
    }

    public boolean isValid() {
        z3 z3Var = this.b;
        if (z3Var != null) {
            return z3Var.l();
        }
        return false;
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCRewAOLLoadListener dCRewAOLLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCRewAOLLoadListener != null) {
                dCRewAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(dCloudAOLSlot, new w2() { // from class: io.dcloud.sdk.core.v3.rew.DCRewAOL.1
                @Override // io.dcloud.p.w2
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCRewAOLLoadListener dCRewAOLLoadListener2 = dCRewAOLLoadListener;
                    if (dCRewAOLLoadListener2 != null) {
                        dCRewAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    DCRewAOLLoadListener dCRewAOLLoadListener2 = dCRewAOLLoadListener;
                    if (dCRewAOLLoadListener2 != null) {
                        dCRewAOLLoadListener2.onRewardAOLLoad();
                    }
                }
            });
        } else if (dCRewAOLLoadListener != null) {
            dCRewAOLLoadListener.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(JSONObject jSONObject) {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onReward(jSONObject);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onVideoPlayEnd();
        }
    }

    public void requestRetryRewardConvert(AOLLoader.RequestConvertResultListener requestConvertResultListener) {
        this.b.b(requestConvertResultListener);
    }

    public void setRewardAOLListener(DCRewAOLListener dCRewAOLListener) {
        this.c = dCRewAOLListener;
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(this);
        }
    }

    public void show(Activity activity) {
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(activity);
        }
    }
}
