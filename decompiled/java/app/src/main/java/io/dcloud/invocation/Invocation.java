package io.dcloud.invocation;

import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.feature.internal.sdk.SDK;
import io.dcloud.p.x2;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class Invocation implements IFeature {
    x2 a;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
        this.a.a(str);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        return (!SDK.isUniMPSDK() || SDK.isNJS) ? this.a.a(iWebview, str, strArr) : "";
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.a = new x2(absMgr);
    }
}
