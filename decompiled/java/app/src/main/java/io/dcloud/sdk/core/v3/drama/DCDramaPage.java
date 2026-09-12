package io.dcloud.sdk.core.v3.drama;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import io.dcloud.p.a1;
import io.dcloud.p.w2;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCDramaPage extends DCBaseAOL implements AOLLoader.RewVAOLInteractionListener {
    private final a1 b;
    private DCDramaPageAdListener c;
    private DCDramaPageListener d;

    public DCDramaPage(Activity activity) {
        super(activity);
        this.b = new a1(activity, 11);
    }

    public void destroy() {
        a1 a1Var = this.b;
        if (a1Var != null) {
            a1Var.destroy();
        }
    }

    public Fragment getDramaPage() {
        a1 a1Var = this.b;
        if (a1Var == null) {
            return null;
        }
        return a1Var.s();
    }

    public String getType() {
        a1 a1Var = this.b;
        return a1Var == null ? "" : a1Var.getType();
    }

    public boolean isValid() {
        a1 a1Var = this.b;
        if (a1Var != null) {
            return a1Var.l();
        }
        return false;
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCDramaPageLoadListener dCDramaPageLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCDramaPageLoadListener != null) {
                dCDramaPageLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        a1 a1Var = this.b;
        if (a1Var != null) {
            a1Var.a(dCloudAOLSlot, new w2() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaPage.1
                @Override // io.dcloud.p.w2
                public void onError(int i, String str, JSONArray jSONArray) {
                    dCDramaPageLoadListener.onError(i, str, jSONArray);
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    dCDramaPageLoadListener.onDramaPageLoad();
                }
            });
        } else if (dCDramaPageLoadListener != null) {
            dCDramaPageLoadListener.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onClick();
        }
        DCDramaPageListener dCDramaPageListener = this.d;
        if (dCDramaPageListener != null) {
            dCDramaPageListener.onDramaClicked();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(JSONObject jSONObject) {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onReward(jSONObject);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        DCDramaPageAdListener dCDramaPageAdListener = this.c;
        if (dCDramaPageAdListener != null) {
            dCDramaPageAdListener.onVideoPlayEnd();
        }
    }

    public void setDramaPageAdListener(DCDramaPageAdListener dCDramaPageAdListener) {
        this.c = dCDramaPageAdListener;
        a1 a1Var = this.b;
        if (a1Var != null) {
            a1Var.a(this);
        }
    }

    public void setDramaPageListener(DCDramaPageListener dCDramaPageListener) {
        this.d = dCDramaPageListener;
    }

    public void setLockCount(int i) {
        a1 a1Var = this.b;
        if (a1Var != null) {
            a1Var.a(i);
        }
    }
}
