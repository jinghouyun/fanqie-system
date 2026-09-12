package io.dcloud.api.custom.base;

import io.dcloud.sdk.core.DCloudAOLManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class UniAdPrivacyConfig {
    private final DCloudAOLManager.PrivacyConfig a;

    public UniAdPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        this.a = privacyConfig;
    }

    public boolean isAdult() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isAdult();
    }

    public boolean isCanGetAndroidId() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetAndroidId();
    }

    public boolean isCanGetBootId() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetBootId();
    }

    public boolean isCanGetIP() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetIP();
    }

    public boolean isCanGetInstallAppList() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetInstallAppList();
    }

    public boolean isCanGetMacAddress() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetMacAddress();
    }

    public boolean isCanGetOAID() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetOAID();
    }

    public boolean isCanGetRunningApps() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetRunningApps();
    }

    public boolean isCanUseLocation() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseLocation();
    }

    public boolean isCanUsePhoneState() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUsePhoneState();
    }

    public boolean isCanUseRecordPermission() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseRecordPermission();
    }

    public boolean isCanUseSensor() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseSensor();
    }

    public boolean isCanUseSimOperator() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseSimOperator();
    }

    public boolean isCanUseStorage() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseStorage();
    }

    public boolean isCanUseWifiState() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseWifiState();
    }

    public boolean isGDTAgreeStrategy() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isGDTAgreeStrategy();
    }

    public JSONObject userPrivacyConfig() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        JSONObject jSONObjectUserPrivacyConfig = privacyConfig != null ? privacyConfig.userPrivacyConfig() : null;
        return jSONObjectUserPrivacyConfig == null ? new JSONObject() : jSONObjectUserPrivacyConfig;
    }
}
