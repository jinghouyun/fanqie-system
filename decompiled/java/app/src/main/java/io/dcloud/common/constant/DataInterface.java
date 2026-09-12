package io.dcloud.common.constant;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.common.callercontext.ContextChain;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MobilePhoneModel;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.CreateShortResultReceiver;
import io.dcloud.common.util.NetworkTypeUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.TelephonyUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DataInterface {
    public static String getRomVersion() {
        String str;
        if (!Build.MANUFACTURER.equals(MobilePhoneModel.XIAOMI)) {
            return Build.VERSION.INCREMENTAL;
        }
        String buildValue = DeviceInfo.getBuildValue("ro.miui.ui.version.name");
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.INCREMENTAL);
        if (TextUtils.isEmpty(buildValue)) {
            str = "";
        } else {
            str = Operators.SUB + buildValue;
        }
        sb.append(str);
        return sb.toString();
    }

    public static HashMap getStartupUrlBaseData(Context context, String str, String str2, String str3, boolean z) throws Throwable {
        String bundleData = SP.getBundleData(context, "pdr", SP.STARTUP_DEVICE_ID);
        if (PdrUtil.isEmpty(bundleData)) {
            bundleData = TelephonyUtil.getSBBS(context, true, true, false);
        }
        int networkType = NetworkTypeUtil.getNetworkType(context);
        String str4 = Build.MODEL;
        int i = Build.VERSION.SDK_INT;
        String str5 = DeviceInfo.sPackageName;
        if (str5 == null) {
            str5 = AndroidResources.packageName;
        }
        HashMap map = new HashMap();
        map.put("appid", str);
        if (!z) {
            map.put("net", Integer.valueOf(networkType));
        }
        map.put("imei", bundleData);
        map.put("md", str4);
        map.put(WXConfig.os, Integer.valueOf(i));
        map.put("vb", "1.9.9.82650");
        map.put(CreateShortResultReceiver.KEY_SF, Integer.valueOf(StringConst.getIntSF(str2)));
        map.put(ContextChain.TAG_PRODUCT, "a");
        map.put("d1", Long.valueOf(System.currentTimeMillis()));
        map.put(CreateShortResultReceiver.KEY_SFD, str3);
        map.put("vd", Build.MANUFACTURER);
        map.put("pn", str5);
        return map;
    }

    public static String getStreamappFrom(Intent intent) {
        if (intent == null || !intent.hasExtra(IntentConst.RUNING_STREAPP_LAUNCHER)) {
            return null;
        }
        String stringExtra = intent.getStringExtra(IntentConst.RUNING_STREAPP_LAUNCHER);
        if (stringExtra.indexOf("third:") == 0) {
            return stringExtra.substring(6, stringExtra.length());
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0068: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0068 */
    public static String getSystemProperty() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                        return line;
                    } catch (IOException e) {
                        Logger.i("Exception while closing InputStream" + e);
                        return line;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Logger.i("Unable to read sysprop ro.miui.ui.version.name" + e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            Logger.i("Exception while closing InputStream" + e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        Logger.i("Exception while closing InputStream" + e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
    }

    public static String getTestParam(String str) {
        return "&__am=".concat((TextUtils.isEmpty(str) || !BaseInfo.isTest(str)) ? "r" : "t");
    }
}
