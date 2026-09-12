package io.dcloud.net;

import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class UploadFeature implements IFeature {
    private JsUploadMgr mJsUploadMgr;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        this.mJsUploadMgr.execute(iWebview, str, strArr);
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.mJsUploadMgr = new JsUploadMgr();
    }
}
