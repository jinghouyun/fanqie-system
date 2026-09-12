package com.taobao.weex.ui.module;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.utils.LogLevel;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.feature.uniapp.utils.AbsLogLevel;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ConsoleLogModule extends WXModule {
    private AbsLogLevel getLogLevel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "off":
                return LogLevel.OFF;
            case "info":
                return LogLevel.INFO;
            case "debug":
                return LogLevel.DEBUG;
            case "error":
                return LogLevel.ERROR;
            case "warning":
                return LogLevel.WARN;
            default:
                return null;
        }
    }

    @JSMethod(uiThread = false)
    public void setPerfMode(String str) {
        WXEnvironment.isPerf = AbsoluteConst.TRUE.equals(str);
        WXBridgeManager.getInstance().setLogLevel(WXEnvironment.sLogLevel.getValue(), WXEnvironment.isPerf());
    }

    @JSMethod(uiThread = false)
    public void switchLogLevel(String str, JSCallback jSCallback) {
        AbsLogLevel logLevel = getLogLevel(str);
        ArrayMap arrayMap = new ArrayMap();
        if (logLevel != null) {
            WXEnvironment.sLogLevel = logLevel;
            WXBridgeManager.getInstance().setLogLevel(WXEnvironment.sLogLevel.getValue(), WXEnvironment.isPerf());
            arrayMap.put("status", WXImage.SUCCEED);
        } else {
            arrayMap.put("status", "failure");
        }
        if (jSCallback != null) {
            jSCallback.invoke(arrayMap);
        }
    }
}
