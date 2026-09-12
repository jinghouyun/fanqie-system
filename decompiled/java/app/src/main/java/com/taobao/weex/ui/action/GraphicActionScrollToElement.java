package com.taobao.weex.ui.action;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionScrollToElement extends BasicGraphicAction {
    private final JSONObject mOptions;

    public GraphicActionScrollToElement(WXSDKInstance wXSDKInstance, String str, JSONObject jSONObject) {
        super(wXSDKInstance, str);
        this.mOptions = jSONObject;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        Scrollable parentScroller;
        WXComponent wXComponent = WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null) {
            return;
        }
        parentScroller.scrollTo(wXComponent, this.mOptions);
    }
}
