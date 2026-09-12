package io.dcloud.feature.barcode2;

import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWaiter;
import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class BarcodeFeatureImpl implements IFeature, IWaiter {
    BarcodeProxyMgr mBProxyMgr;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
        this.mBProxyMgr.onDestroy();
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public Object doForFeature(String str, Object obj) {
        return this.mBProxyMgr.doForFeature(str, obj);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        return this.mBProxyMgr.execute(iWebview, str, strArr);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        BarcodeProxyMgr barcodeProxyMgr = BarcodeProxyMgr.getBarcodeProxyMgr();
        this.mBProxyMgr = barcodeProxyMgr;
        barcodeProxyMgr.setFeatureMgr(absMgr);
    }
}
