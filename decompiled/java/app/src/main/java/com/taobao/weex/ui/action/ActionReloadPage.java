package com.taobao.weex.ui.action;

import android.util.Log;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ActionReloadPage implements IExecutable {
    private final String TAG = "ReloadPageAction";
    private String mPageId;
    private boolean mReloadThis;

    public ActionReloadPage(String str, boolean z) {
        this.mPageId = str;
        this.mReloadThis = z;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXSDKInstance wXSDKInstance = WXSDKManager.getInstance().getWXRenderManager().getWXSDKInstance(this.mPageId);
        if (wXSDKInstance != null) {
            wXSDKInstance.reloadPage(this.mReloadThis);
        } else {
            Log.e("ReloadPageAction", "ReloadPageAction executeDom reloadPage instance is null");
        }
    }
}
