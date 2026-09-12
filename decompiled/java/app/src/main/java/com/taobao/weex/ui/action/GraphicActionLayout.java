package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionLayout extends BasicGraphicAction {
    private final boolean mIsLayoutRTL;
    private final GraphicPosition mLayoutPosition;
    private final GraphicSize mLayoutSize;

    public GraphicActionLayout(WXSDKInstance wXSDKInstance, String str, GraphicPosition graphicPosition, GraphicSize graphicSize, boolean z) {
        super(wXSDKInstance, str);
        this.mLayoutPosition = graphicPosition;
        this.mLayoutSize = graphicSize;
        this.mIsLayoutRTL = z;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        wXComponent.setIsLayoutRTL(this.mIsLayoutRTL);
        wXComponent.setDemission(this.mLayoutSize, this.mLayoutPosition);
        wXComponent.setSafeLayout(wXComponent);
        wXComponent.setPadding(wXComponent.getPadding(), wXComponent.getBorder());
    }
}
