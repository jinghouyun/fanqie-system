package com.taobao.weex.ui.action;

import com.alibaba.fastjson.JSONArray;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXLogUtils;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ActionInvokeMethod implements IExecutable {
    private static final String TAG = "ActionInvokeMethod";
    private final JSONArray mArgs;
    private final String mMethod;
    private String mPageId;
    private String mRef;

    public ActionInvokeMethod(String str, String str2, String str3, JSONArray jSONArray) {
        this.mPageId = str;
        this.mRef = str2;
        this.mMethod = str3;
        this.mArgs = jSONArray;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mPageId, this.mRef);
        if (wXComponent == null) {
            WXLogUtils.e(TAG, "target component not found.");
        } else {
            wXComponent.invoke(this.mMethod, this.mArgs);
        }
    }
}
