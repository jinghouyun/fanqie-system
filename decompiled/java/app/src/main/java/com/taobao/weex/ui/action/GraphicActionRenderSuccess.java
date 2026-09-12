package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRenderSuccess extends BasicGraphicAction {
    public GraphicActionRenderSuccess(WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        int layoutWidth;
        int layoutHeight;
        WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null) {
            return;
        }
        WXComponent rootComponent = wXSDKIntance.getRootComponent();
        if (rootComponent != null) {
            layoutWidth = (int) rootComponent.getLayoutWidth();
            layoutHeight = (int) rootComponent.getLayoutHeight();
        } else {
            layoutWidth = 0;
            layoutHeight = 0;
        }
        wXSDKIntance.onRenderSuccess(layoutWidth, layoutHeight);
    }
}
