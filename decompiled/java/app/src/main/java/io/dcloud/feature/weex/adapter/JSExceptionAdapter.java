package io.dcloud.feature.weex.adapter;

import android.text.TextUtils;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.common.WXJSExceptionInfo;
import io.dcloud.common.util.AppConsoleLogUtil;
import io.dcloud.common.util.BaseInfo;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class JSExceptionAdapter implements IWXJSExceptionAdapter {
    @Override // com.taobao.weex.adapter.IWXJSExceptionAdapter
    public void onJSException(WXJSExceptionInfo wXJSExceptionInfo) {
        if (wXJSExceptionInfo == null || TextUtils.isEmpty(BaseInfo.sCurrentAppOriginalAppid) || !BaseInfo.sCurrentAppOriginalAppid.startsWith("__UNI__")) {
            return;
        }
        String strReplace = "reportJSException >>>> exception function:" + wXJSExceptionInfo.getFunction() + ", exception:" + wXJSExceptionInfo.getException();
        if (strReplace.endsWith("__ERROR")) {
            strReplace = strReplace.replace("__ERROR", "");
        }
        AppConsoleLogUtil.DCLog(strReplace, "ERROR");
    }
}
