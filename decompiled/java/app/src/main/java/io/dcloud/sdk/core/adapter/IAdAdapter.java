package io.dcloud.sdk.core.adapter;

import android.app.Activity;
import io.dcloud.sdk.core.DCloudAOLManager;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface IAdAdapter {
    DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot);

    String getAdapterSDKVersion();

    String getSDKVersion();

    boolean isSupport();

    void setPersonalAd(boolean z);

    void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig);
}
