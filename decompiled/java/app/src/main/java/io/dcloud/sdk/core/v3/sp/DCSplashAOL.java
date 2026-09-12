package io.dcloud.sdk.core.v3.sp;

import android.app.Activity;
import android.view.ViewGroup;
import io.dcloud.p.k4;
import io.dcloud.p.m;
import io.dcloud.p.w2;
import io.dcloud.sdk.core.entry.SplashAOLConfig;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCSplashAOL extends DCBaseAOL implements AOLLoader.VAOLInteractionListener {
    k4 b;
    private DCSplashAOLListener c;

    public DCSplashAOL(Activity activity) {
        super(activity);
        this.b = new k4(activity, 1);
    }

    public boolean isSplashOpen() {
        return m.d(getContext());
    }

    public boolean isValid() {
        k4 k4Var = this.b;
        return k4Var != null && k4Var.l();
    }

    public void load(SplashAOLConfig splashAOLConfig, final DCSplashAOLLoadListener dCSplashAOLLoadListener) {
        if (getContext() == null || splashAOLConfig == null) {
            if (dCSplashAOLLoadListener != null) {
                dCSplashAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(splashAOLConfig, new w2() { // from class: io.dcloud.sdk.core.v3.sp.DCSplashAOL.1
                public void getConfig(JSONObject jSONObject) {
                    try {
                        dCSplashAOLLoadListener.getClass().getDeclaredMethod("getConfig", JSONObject.class).invoke(dCSplashAOLLoadListener, jSONObject);
                    } catch (Exception unused) {
                    }
                }

                @Override // io.dcloud.p.w2
                public void onError(int i, String str, JSONArray jSONArray) {
                    dCSplashAOLLoadListener.onError(i, str, jSONArray);
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    dCSplashAOLLoadListener.onSplashAOLLoad();
                }
            });
        } else if (dCSplashAOLLoadListener != null) {
            dCSplashAOLLoadListener.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onVideoPlayEnd();
        }
    }

    public void setSplashAOLListener(DCSplashAOLListener dCSplashAOLListener) {
        this.c = dCSplashAOLListener;
        k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(this);
        }
    }

    public void show(Activity activity) {
    }

    @Deprecated
    public void showIn(ViewGroup viewGroup) {
        k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(viewGroup);
        }
    }

    public void show(ViewGroup viewGroup) {
        showIn(viewGroup);
    }
}
