package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionAppendTreeCreateFinish extends BasicGraphicAction {
    WXComponent component;

    public GraphicActionAppendTreeCreateFinish(WXSDKInstance wXSDKInstance, String str) {
        super(wXSDKInstance, str);
        WXComponent wXComponent = WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), str);
        this.component = wXComponent;
        if (wXComponent == null || !(wXComponent instanceof WXVContainer)) {
            return;
        }
        ((WXVContainer) wXComponent).appendTreeCreateFinish();
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
