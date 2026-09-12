package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRefreshFinish extends BasicGraphicAction {
    private int mLayoutHeight;
    private int mLayoutWidth;

    public GraphicActionRefreshFinish(WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
        WXComponent rootComponent = wXSDKInstance.getRootComponent();
        if (rootComponent != null) {
            this.mLayoutWidth = (int) rootComponent.getLayoutWidth();
            this.mLayoutHeight = (int) rootComponent.getLayoutHeight();
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null) {
            return;
        }
        wXSDKIntance.onRefreshSuccess(this.mLayoutWidth, this.mLayoutHeight);
    }
}
