package io.dcloud.share;

import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface IWeiXinFShareApi extends IFShareApi {
    void launchMiniProgram(IWebview iWebview, String str, String str2);

    void openCustomerServiceChat(IWebview iWebview, String str, String str2);
}
