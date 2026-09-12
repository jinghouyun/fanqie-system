package com.taobao.weex.ui.component.richtext.span;

import android.text.style.ClickableSpan;
import android.view.View;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import com.taobao.weex.utils.WXDataStructureUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ItemClickSpan extends ClickableSpan {
    private final String mComponentRef;
    private final String mInstanceId;
    private final String mPseudoRef;

    public ItemClickSpan(String str, String str2, String str3) {
        this.mPseudoRef = str3;
        this.mInstanceId = str;
        this.mComponentRef = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        WXSDKInstance sDKInstance = WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        if (sDKInstance == null || sDKInstance.isDestroy()) {
            return;
        }
        HashMap mapNewHashMapWithExpectedSize = WXDataStructureUtil.newHashMapWithExpectedSize(1);
        mapNewHashMapWithExpectedSize.put(RichTextNode.PSEUDO_REF, this.mPseudoRef);
        sDKInstance.fireEvent(this.mComponentRef, RichTextNode.ITEM_CLICK, mapNewHashMapWithExpectedSize);
    }
}
