package io.dcloud.p;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.nostra13.dcloudimageloader.core.download.BaseImageDownloader;
import io.dcloud.WebAppActivity;
import io.dcloud.sdk.base.dcloud.ADHandler;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import io.dcloud.sdk.poly.api.Platform;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class u0 extends DCBaseAOLLoader implements v2.c {
    private w4 K;
    private Platform L;
    private String M;
    private ADHandler.e N;
    private Handler O;
    private int P;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            u0.this.loadFail(-9999, "");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements n {
        b() {
        }

        @Override // io.dcloud.p.n
        public void onClicked() {
            if (u0.this.getVideoAdCallback() != null) {
                u0.this.getVideoAdCallback().onClick();
            }
        }

        @Override // io.dcloud.p.n
        public void onFinishShow() {
            if (u0.this.getVideoAdCallback() != null) {
                u0.this.getVideoAdCallback().onClose();
            }
        }

        @Override // io.dcloud.p.n
        public void onShow() {
            if (u0.this.getVideoAdCallback() != null) {
                u0.this.getVideoAdCallback().onShow();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements ADHandler.g {
        c() {
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.g
        public void a() {
            if (u0.this.getAdStatus() != -1) {
                return;
            }
            ADHandler.e eVarB = ADHandler.b(u0.this.getActivity(), r0.d().b().getAppId());
            if (!eVarB.a()) {
                u0.this.loadFail(-9999, "");
                return;
            }
            u0.this.N = eVarB;
            u0.this.N.a(u0.this.getDCloudId());
            u0.this.loadSuccess();
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.g
        public void b() {
            if (u0.this.getAdStatus() != -1) {
                return;
            }
            ADHandler.e eVarB = ADHandler.b(u0.this.getActivity(), r0.d().b().getAppId());
            if (!eVarB.a()) {
                u0.this.loadFail(-9999, "");
                return;
            }
            u0.this.N = eVarB;
            u0.this.N.a(u0.this.getDCloudId());
            u0.this.loadSuccess();
        }
    }

    public u0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.M = "";
        this.O = new a(Looper.getMainLooper());
        this.P = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup) {
        this.K.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(ViewGroup viewGroup) {
        new io.dcloud.sdk.base.dcloud.g(getActivity(), this.N, viewGroup, new b()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        w4 w4VarA = s0.a(this, getActivity(), this.L.getSplash(), getSlotId(), this.L.getEr(), this.L.getEc());
        this.K = w4VarA;
        w4VarA.c();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public String getTid() {
        Platform platform = this.L;
        if (platform != null) {
            return platform.getTid();
        }
        ADHandler.e eVar = this.N;
        return eVar != null ? eVar.l : "";
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public String getType() {
        Platform platform = this.L;
        return platform == null ? this.M : platform.getType();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.p.v2.c
    public void k() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void l() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void load(Map map) {
        if (TextUtils.isEmpty(this.M)) {
            loadFail(-9999, "");
            return;
        }
        if (this.M.equals("dcloud")) {
            c3.a("uniAd", "load base");
            this.O.sendEmptyMessageDelayed(this.P, WebAppActivity.SPLASH_SECOND);
        } else if (this.L == null) {
            loadFail(-9999, "");
        } else {
            MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.z();
                }
            });
        }
    }

    @Override // io.dcloud.p.v2.c
    public void m() {
        loadSuccess();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public String n() {
        Platform platform = this.L;
        return platform == null ? "" : platform.getAppid();
    }

    @Override // io.dcloud.p.v2.c
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public boolean runOnMain() {
        return false;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void setPlatform(Platform platform, String str) {
        this.L = platform;
        this.M = str;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void showIn(final ViewGroup viewGroup) {
        if ((this.K == null && this.N == null) || TextUtils.isEmpty(this.M)) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
                return;
            }
            return;
        }
        if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else {
            if (this.M.equals("dcloud")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(viewGroup);
                    return;
                } else {
                    MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(viewGroup);
                        }
                    });
                    return;
                }
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.K.a(viewGroup);
            } else {
                MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(viewGroup);
                    }
                });
            }
        }
    }

    @Override // io.dcloud.p.v2.c
    public void a(int i, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "code" + i + ";message:" + str);
        }
    }

    public void a(JSONArray jSONArray, boolean z) {
        c3.a("uniAd-finish", String.valueOf(jSONArray) + "::::::" + z);
        if (this.O.hasMessages(this.P)) {
            this.O.removeMessages(this.P);
            if (z) {
                if (jSONArray != null && jSONArray.length() != 0) {
                    c cVar = new c();
                    boolean z2 = true;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            ADHandler.a(getActivity(), jSONObjectOptJSONObject, System.currentTimeMillis(), cVar);
                            z2 = false;
                        }
                    }
                    if (z2) {
                        loadFail(-9999, "");
                        return;
                    }
                    return;
                }
                ADHandler.e eVarB = ADHandler.b(getActivity(), r0.d().b().getAppId());
                if (eVarB.a()) {
                    this.N = eVarB;
                    eVarB.a(getDCloudId());
                    loadSuccess();
                    return;
                }
                loadFail(-9999, "");
                return;
            }
            loadFail(-9999, "");
        }
    }
}
