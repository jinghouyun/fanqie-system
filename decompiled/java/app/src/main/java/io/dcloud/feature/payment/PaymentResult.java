package io.dcloud.feature.payment;

import io.dcloud.common.DHInterface.IReflectAble;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.PdrUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class PaymentResult implements IReflectAble {
    AbsPaymentChannel a;
    public String description;
    public String rawDataJson;
    public String signature;
    public String tradeno;
    public String url;

    public PaymentResult(AbsPaymentChannel absPaymentChannel) {
        this.a = absPaymentChannel;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AbsoluteConst.XML_CHANNEL, this.a.toJSONObject());
            jSONObject.put("description", this.description);
            jSONObject.put("url", this.url);
            jSONObject.put("signature", this.signature);
            jSONObject.put("tradeno", this.tradeno);
            if (!PdrUtil.isEmpty(this.rawDataJson)) {
                jSONObject.put("rawdata", new JSONObject(this.rawDataJson).toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
