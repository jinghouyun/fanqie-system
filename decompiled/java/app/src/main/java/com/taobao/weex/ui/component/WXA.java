package com.taobao.weex.ui.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.utils.ATagUtil;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
@Component(lazyload = false)
public class WXA extends WXDiv {
    @Deprecated
    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(String str, Object obj) {
        str.getClass();
        if (str.equals("href")) {
            return true;
        }
        return super.setProperty(str, obj);
    }

    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(WXFrameLayout wXFrameLayout) {
        addClickListener(new WXComponent.OnClickListener() { // from class: com.taobao.weex.ui.component.WXA.1
            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                String str;
                WXAttr attrs = WXA.this.getAttrs();
                if (attrs == null || (str = (String) attrs.get("href")) == null) {
                    return;
                }
                ATagUtil.onClick(null, WXA.this.getInstanceId(), str);
            }
        });
        super.onHostViewInitialized(wXFrameLayout);
    }
}
