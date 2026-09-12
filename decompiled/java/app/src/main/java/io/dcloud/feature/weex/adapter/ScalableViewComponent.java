package io.dcloud.feature.weex.adapter;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.WXFrameLayout;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class ScalableViewComponent extends WXDiv {
    private boolean isScalable;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class Ceator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
            return new ScalableViewComponent(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    public ScalableViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isScalable = false;
    }

    public boolean isScalable() {
        return this.isScalable;
    }

    public void setScalable(boolean z) {
        this.isScalable = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXDiv, com.taobao.weex.ui.component.WXComponent
    public WXFrameLayout initComponentHostView(Context context) {
        ScalableView scalableView = new ScalableView(context);
        scalableView.holdComponent((WXDiv) this);
        return scalableView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(WXFrameLayout wXFrameLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        if (isScalable()) {
            super.setHostLayoutParams(wXFrameLayout, -1, -1, i3, i4, i5, i6);
        } else {
            super.setHostLayoutParams(wXFrameLayout, i, i2, i3, i4, i5, i6);
        }
    }
}
