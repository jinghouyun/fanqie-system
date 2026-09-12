package io.dcloud.feature.weex.adapter;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.IDCVueBridgeAdapter;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaUniWebView;
import io.dcloud.feature.weex.WeexInstanceMgr;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCVueBridgeAdapter implements IDCVueBridgeAdapter {
    @Override // com.taobao.weex.bridge.IDCVueBridgeAdapter
    public void exec(WXSDKInstance wXSDKInstance, String str, String str2) {
        IWebview iWebviewFindWebview = WeexInstanceMgr.self().findWebview(wXSDKInstance);
        if (iWebviewFindWebview instanceof AdaUniWebView) {
            ((AdaUniWebView) iWebviewFindWebview).prompt(str, str2);
        }
    }

    @Override // com.taobao.weex.bridge.IDCVueBridgeAdapter
    public String execSync(WXSDKInstance wXSDKInstance, String str, String str2) {
        IWebview iWebviewFindWebview = WeexInstanceMgr.self().findWebview(wXSDKInstance);
        return iWebviewFindWebview instanceof AdaUniWebView ? ((AdaUniWebView) iWebviewFindWebview).prompt(str, str2) : "";
    }
}
