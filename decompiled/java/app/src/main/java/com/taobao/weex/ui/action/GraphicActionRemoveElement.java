package com.taobao.weex.ui.action;

import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRemoveElement extends BasicGraphicAction {
    public GraphicActionRemoveElement(WXSDKInstance wXSDKInstance, String str) {
        super(wXSDKInstance, str);
    }

    private void clearRegistryForComponent(WXComponent wXComponent) {
        WXComponent wXComponentUnregisterComponent = WXSDKManager.getInstance().getWXRenderManager().unregisterComponent(getPageId(), getRef());
        if (wXComponentUnregisterComponent != null) {
            wXComponentUnregisterComponent.removeAllEvent();
            wXComponentUnregisterComponent.removeStickyStyle();
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int iChildCount = wXVContainer.childCount() - 1; iChildCount >= 0; iChildCount--) {
                clearRegistryForComponent(wXVContainer.getChild(iChildCount));
            }
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null || wXComponent.getParent() == null || wXComponent.getInstance() == null) {
            return;
        }
        clearRegistryForComponent(wXComponent);
        WXVContainer parent = wXComponent.getParent();
        if (wXComponent.getHostView() != null && !TextUtils.equals(wXComponent.getComponentType(), "video") && !TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        parent.remove(wXComponent, true);
    }
}
