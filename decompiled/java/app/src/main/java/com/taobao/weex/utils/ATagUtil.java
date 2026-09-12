package com.taobao.weex.utils;

import android.net.Uri;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import io.dcloud.feature.uniapp.adapter.AbsURIAdapter;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ATagUtil {
    public static void onClick(View view, String str, String str2) {
        WXSDKInstance sDKInstance = WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return;
        }
        String string = sDKInstance.rewriteUri(Uri.parse(str2), AbsURIAdapter.LINK).toString();
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(string);
        WXSDKManager.getInstance().getWXBridgeManager().callModuleMethod(str, "event", "openURL", jSONArray);
    }
}
