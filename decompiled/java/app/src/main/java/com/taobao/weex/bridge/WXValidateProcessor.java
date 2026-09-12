package com.taobao.weex.bridge;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface WXValidateProcessor {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class WXComponentValidateResult {
        public boolean isSuccess;
        public String replacedComponent;
        public JSONObject validateInfo;
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class WXModuleValidateResult {
        public boolean isSuccess;
        public JSONObject validateInfo;
    }

    boolean needValidate(String str);

    WXComponentValidateResult onComponentValidate(WXSDKInstance wXSDKInstance, String str, WXComponent wXComponent);

    WXModuleValidateResult onModuleValidate(WXSDKInstance wXSDKInstance, String str, String str2, JSONArray jSONArray, JSONObject jSONObject);
}
