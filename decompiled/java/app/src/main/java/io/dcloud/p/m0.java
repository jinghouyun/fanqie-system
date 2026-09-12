package io.dcloud.p;

import android.app.Activity;
import android.view.ViewGroup;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.sdk.core.adapter.IAdAdapter;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.util.AdUtil;
import io.dcloud.sdk.core.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class m0 extends DCBaseAOLLoader implements w1, w1.a {
    private JSONObject K;
    private UniAdCustomAdapter L;
    private UniAdCustomBaseLoader M;

    public m0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.M;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.M;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.p.w1
    public void d() {
        loadSuccess();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.M;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.destroy();
        }
    }

    @Override // io.dcloud.p.w1
    public int f() {
        return isSlotSupportBidding() ? 1 : 0;
    }

    @Override // io.dcloud.p.w1.a
    public void g() {
        if (getVideoAdCallback() instanceof z3) {
            ((z3) getVideoAdCallback()).onReward(new JSONObject());
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public int getBiddingECPM() {
        return super.getBiddingECPM();
    }

    @Override // io.dcloud.p.w1
    public void h() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    protected void init(String str, String str2) {
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.M;
        return uniAdCustomBaseLoader != null && uniAdCustomBaseLoader.isReady();
    }

    @Override // io.dcloud.p.w1
    public void j() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void load(Map map) {
        UniAdSlot uniAdSlot = new UniAdSlot();
        uniAdSlot.setSlotId(getSlotId());
        uniAdSlot.setExtra(getSlot().getExtra());
        uniAdSlot.setUserId(getSlot().getUserId());
        int width = getSlot().getWidth();
        if (width <= 0) {
            width = ScreenUtil.dw(getActivity());
        }
        uniAdSlot.setWidth(width);
        uniAdSlot.setHeight(getSlot().getHeight());
        uniAdSlot.setAdCount(getSlot().getCount());
        a(getActivity(), uniAdSlot);
    }

    @Override // io.dcloud.p.w1
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.p.w1
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.w1
    public void onLoadFail(int i, String str) {
        loadFail(i, str);
    }

    @Override // io.dcloud.p.w1
    public void onLoadSuccess(List list) {
        if (list == null || list.isEmpty()) {
            loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UniAdCustomNativeAd uniAdCustomNativeAd = (UniAdCustomNativeAd) it.next();
            n0 n0Var = new n0(getSlot(), getActivity());
            n0Var.a(uniAdCustomNativeAd);
            if (isSlotSupportBidding()) {
                n0Var.setBiddingECPM(uniAdCustomNativeAd.getBidPrice());
            }
            arrayList.add(n0Var);
        }
        loadSuccess(arrayList);
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean s() {
        return true;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (isValid()) {
            this.M.show(activity);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void showIn(ViewGroup viewGroup) {
        if (isValid()) {
            this.M.show(viewGroup);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements UniAdCustomAdapter.a {
        final /* synthetic */ Activity a;
        final /* synthetic */ UniAdSlot b;

        a(Activity activity, UniAdSlot uniAdSlot) {
            this.a = activity;
            this.b = uniAdSlot;
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.a
        public void a() {
            m0.this.M.a(this.a, this.b, m0.this);
            m0.this.L.removeInitListener(this);
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.a
        public void a(int i, String str) {
            m0.this.loadFail(i, str);
            m0.this.L.removeInitListener(this);
        }
    }

    public void a(UniAdCustomBaseLoader uniAdCustomBaseLoader) {
        this.M = uniAdCustomBaseLoader;
    }

    @Override // io.dcloud.p.w1
    public void b() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    public void a(Activity activity, UniAdSlot uniAdSlot) {
        if (this.M != null) {
            UniAdCustomAdapter uniAdCustomAdapter = this.L;
            if (uniAdCustomAdapter != null) {
                if (uniAdCustomAdapter.isInitSuccess()) {
                    this.M.a(activity, uniAdSlot, this);
                    return;
                }
                this.L.addInitListener(new a(activity, uniAdSlot));
                try {
                    this.L.setPrivacyConfig(new UniAdPrivacyConfig(AdUtil.getCustomPrivacyConfig()));
                    this.L.init(getActivity(), this.K);
                    return;
                } catch (Exception unused) {
                    loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
                    return;
                }
            }
            loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
            return;
        }
        loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void a(IAdAdapter iAdAdapter, JSONObject jSONObject) {
        this.L = (UniAdCustomAdapter) iAdAdapter;
        this.K = jSONObject;
    }

    @Override // io.dcloud.p.w1
    public void a(int i, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + i + ";message:" + str);
        }
    }
}
