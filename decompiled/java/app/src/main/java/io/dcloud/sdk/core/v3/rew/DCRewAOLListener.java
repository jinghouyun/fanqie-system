package io.dcloud.sdk.core.v3.rew;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface DCRewAOLListener {
    void onClick();

    void onClose();

    void onReward(JSONObject jSONObject);

    void onShow();

    void onShowError(int i, String str);

    void onSkip();

    void onVideoPlayEnd();
}
