package io.dcloud.feature.gg.dcloud;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IAolReceiver {
    void onError(String str, String str2);

    void onReceiver(JSONObject jSONObject);
}
