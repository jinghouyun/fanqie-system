package io.dcloud.feature.gg;

import android.text.TextUtils;
import io.dcloud.common.DHInterface.IReflectAble;
import io.dcloud.common.DHInterface.IWaiter;
import io.dcloud.feature.gg.dcloud.AolFeatureImpl;
import io.dcloud.p.t3;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AolFeatureImplMgr implements IReflectAble, IWaiter {
    public static final /* synthetic */ int a = 0;
    static final AolFeatureImplMgr mSingleInstance = new AolFeatureImplMgr();
    String mAdType = null;

    public static IWaiter self() {
        return mSingleInstance;
    }

    public void clearAdType() {
        this.mAdType = null;
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public Object doForFeature(String str, Object obj) {
        if (TextUtils.isEmpty(this.mAdType)) {
            this.mAdType = AolSplashUtil.getPlashType();
        }
        Object objDoForFeature = AolFeatureImpl.doForFeature(str, obj);
        if (!str.equals("onWillCloseSplash") && !str.equals("onBack")) {
            return str.equals("adc") ? Boolean.valueOf(t3.a()) : objDoForFeature;
        }
        clearAdType();
        return objDoForFeature;
    }
}
