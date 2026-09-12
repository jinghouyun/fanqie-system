package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.WXRichText;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRemoveChildFromRichtext extends BasicGraphicAction {
    private String parentRef;
    private String ref;
    private WXRichText richText;

    public GraphicActionRemoveChildFromRichtext(WXSDKInstance wXSDKInstance, String str, String str2, String str3) throws Throwable {
        super(wXSDKInstance, str3);
        this.ref = str;
        this.parentRef = str2;
        WXRichText wXRichText = (WXRichText) WXSDKManager.getInstance().getWXRenderManager().getWXComponent(wXSDKInstance.getInstanceId(), str3);
        this.richText = wXRichText;
        if (wXRichText != null) {
            wXRichText.removeChildNode(str2, str);
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
