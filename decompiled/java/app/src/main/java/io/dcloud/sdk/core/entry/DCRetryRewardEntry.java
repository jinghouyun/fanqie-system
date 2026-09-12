package io.dcloud.sdk.core.entry;

import com.taobao.weex.common.WXConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCRetryRewardEntry {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;
    private final int g;

    public DCRetryRewardEntry(String str, String str2, String str3, String str4, int i, String str5, int i2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = str5;
        this.g = i2;
    }

    public String getAdSource() {
        return this.b;
    }

    public String getAppIconUrl() {
        return this.c;
    }

    public String getAppName() {
        return this.d;
    }

    public int getConvertType() {
        return this.e;
    }

    public String getProductName() {
        return this.a;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productName", this.a);
            jSONObject.put("appIconUrl", this.c);
            jSONObject.put(WXConfig.appName, this.d);
            jSONObject.put("convertType", this.e);
            jSONObject.put("adDescription", this.f);
            jSONObject.put("interactionType", this.g);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
