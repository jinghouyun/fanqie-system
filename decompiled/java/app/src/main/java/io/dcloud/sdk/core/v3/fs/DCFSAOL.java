package io.dcloud.sdk.core.v3.fs;

import android.app.Activity;
import io.dcloud.p.b5;
import io.dcloud.p.w2;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCFSAOL extends DCBaseAOL implements AOLLoader.VAOLInteractionListener {
    private final b5 b;
    private DCFSAOLListener c;

    public DCFSAOL(Activity activity) {
        super(activity);
        this.b = new b5(activity, 7);
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

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCFSAOLLoadListener dCFSAOLLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCFSAOLLoadListener != null) {
                dCFSAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(dCloudAOLSlot, new w2() { // from class: io.dcloud.sdk.core.v3.fs.DCFSAOL.1
                @Override // io.dcloud.p.w2
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCFSAOLLoadListener dCFSAOLLoadListener2 = dCFSAOLLoadListener;
                    if (dCFSAOLLoadListener2 != null) {
                        dCFSAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    DCFSAOLLoadListener dCFSAOLLoadListener2 = dCFSAOLLoadListener;
                    if (dCFSAOLLoadListener2 != null) {
                        dCFSAOLLoadListener2.onFullScreenAOLLoad();
                    }
                }
            });
        } else if (dCFSAOLLoadListener != null) {
            dCFSAOLLoadListener.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onVideoPlayEnd();
        }
    }

    public void setFullScreenAOLListener(DCFSAOLListener dCFSAOLListener) {
        this.c = dCFSAOLListener;
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
