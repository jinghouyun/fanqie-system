package io.dcloud.common.DHInterface;

import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IJsInterface {
    @Deprecated
    String exec(String str, String str2, String str3);

    String exec(String str, String str2, JSONArray jSONArray);

    void forceStop(String str);

    String prompt(String str, String str2);
}
