package io.dcloud.net;

import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DownloaderFeatureImpl implements IFeature {
    DownloadJSMgr mDownloadMgr = null;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
        DownloadJSMgr downloadJSMgr = this.mDownloadMgr;
        if (downloadJSMgr != null) {
            downloadJSMgr.dispose();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        return this.mDownloadMgr.execute(iWebview, str, strArr);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.mDownloadMgr = DownloadJSMgr.getInstance();
    }
}
