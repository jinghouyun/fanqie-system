package io.dcloud.sdk.core.v3.inters;

import android.app.Activity;
import io.dcloud.p.b5;
import io.dcloud.p.w2;
import io.dcloud.p.y4;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCIntAOL extends DCBaseAOL implements AOLLoader.VAOLInteractionListener {
    private final b5 b;
    private DCIntAOLListener c;

    public DCIntAOL(Activity activity) {
        super(activity);
        this.b = new y4(activity, 15);
    }

    public String getType() {
        b5 b5Var = this.b;
        return b5Var == null ? "" : b5Var.getType();
    }

    public boolean isValid() {
        b5 b5Var = this.b;
        if (b5Var != null) {
            return b5Var.l();
        }
        return false;
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCIntAOLLoadListener dCIntAOLLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCIntAOLLoadListener != null) {
                dCIntAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(dCloudAOLSlot, new w2() { // from class: io.dcloud.sdk.core.v3.inters.DCIntAOL.1
                @Override // io.dcloud.p.w2
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCIntAOLLoadListener dCIntAOLLoadListener2 = dCIntAOLLoadListener;
                    if (dCIntAOLLoadListener2 != null) {
                        dCIntAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    DCIntAOLLoadListener dCIntAOLLoadListener2 = dCIntAOLLoadListener;
                    if (dCIntAOLLoadListener2 != null) {
                        dCIntAOLLoadListener2.onInterstitialAOLLoad();
                    }
                }
            });
        } else if (dCIntAOLLoadListener != null) {
            dCIntAOLLoadListener.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        DCIntAOLListener dCIntAOLListener = this.c;
        if (dCIntAOLListener != null) {
            dCIntAOLListener.onVideoPlayEnd();
        }
    }

    public void setInterstitialAOLListener(DCIntAOLListener dCIntAOLListener) {
        this.c = dCIntAOLListener;
        b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(this);
        }
    }

    public void show(Activity activity) {
        b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(activity);
        }
    }
}
