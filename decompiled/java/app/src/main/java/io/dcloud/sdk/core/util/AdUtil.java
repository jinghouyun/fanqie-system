package io.dcloud.sdk.core.util;

import android.content.Context;
import android.text.TextUtils;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.p.e4;
import io.dcloud.sdk.core.DCloudAOLManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class AdUtil {
    private static DCloudAOLManager.PrivacyConfig a;

    public static String getCustomPrivacyConfig(Context context) {
        return e4.a(context, "dcloud-ads", "CustomPrivacyConfig");
    }

    public static DCloudAOLManager.PrivacyConfig getDCloudPrivacyConfig(Context context) {
        String customPrivacyConfig = getCustomPrivacyConfig(context);
        if (TextUtils.isEmpty(customPrivacyConfig)) {
            return null;
        }
        try {
            return getPrivacyConfig(new JSONObject(customPrivacyConfig));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T getOrDefault(Map<String, T> map, Object obj, T t) {
        T t2;
        return (map != null && ((t2 = map.get(obj)) != null || map.containsKey(obj))) ? t2 : t;
    }

    public static boolean getPersonalAd(Context context) {
        String strA = e4.a(context, "dcloud-ads", "PersonalizedAdEnable");
        if (TextUtils.isEmpty(strA)) {
            strA = AbsoluteConst.TRUE;
        }
        return Boolean.parseBoolean(strA);
    }

    public static DCloudAOLManager.PrivacyConfig getPrivacyConfig(final JSONObject jSONObject) {
        return new DCloudAOLManager.PrivacyConfig() { // from class: io.dcloud.sdk.core.util.AdUtil.1
            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isAdult() {
                return jSONObject.optBoolean("isAdult", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetAndroidId() {
                return jSONObject.optBoolean("isCanGetAndroidId", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetBootId() {
                return jSONObject.optBoolean("isCanGetBootId", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetIP() {
                return jSONObject.optBoolean("isCanGetIP", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetInstallAppList() {
                return jSONObject.optBoolean("isCanGetInstallAppList", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetMacAddress() {
                return jSONObject.optBoolean("isCanGetMacAddress", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetOAID() {
                return jSONObject.optBoolean("isCanGetOAID", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetRunningApps() {
                return jSONObject.optBoolean("isCanGetRunningApps", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseLocation() {
                return jSONObject.optBoolean("isCanUseLocation", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUsePhoneState() {
                return jSONObject.optBoolean("isCanUsePhoneState", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseRecordPermission() {
                return jSONObject.optBoolean("isCanUseRecordPermission", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSensor() {
                return jSONObject.optBoolean("isCanUseSensor", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSimOperator() {
                return jSONObject.optBoolean("isCanUseSimOperator", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseStorage() {
                return jSONObject.optBoolean("isCanUseStorage", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseWifiState() {
                return jSONObject.optBoolean("isCanUseWifiState", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isGDTAgreeStrategy() {
                return jSONObject.optBoolean("isGDTAgreeStrategy", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public JSONObject userPrivacyConfig() {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("userPrivacyConfig");
                return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
            }
        };
    }

    public static void setCustomPrivacyConfig(Context context, String str) {
        e4.a(context, "dcloud-ads", "CustomPrivacyConfig", str);
    }

    public static void setPersonalAd(Context context, boolean z) {
        e4.a(context, "dcloud-ads", "PersonalizedAdEnable", String.valueOf(z));
    }

    public static DCloudAOLManager.PrivacyConfig getCustomPrivacyConfig() {
        return a;
    }

    public static void setCustomPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        a = privacyConfig;
    }
}
