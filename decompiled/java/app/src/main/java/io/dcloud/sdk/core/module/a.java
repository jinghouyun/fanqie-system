package io.dcloud.sdk.core.module;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.p.c3;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.util.Const;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends DCBaseAOL {
    private int A;
    private JSONObject B;
    private String C;
    private boolean D;
    private long E;
    private long z;

    public a(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.z = 0L;
        this.A = -1;
        this.C = "";
        this.D = true;
        this.E = 0L;
    }

    public void b(int i, String str) {
        this.D = i != -9999;
        c3.b("uniAD", getDCloudId() + ":" + getType() + ":" + i + ":" + str + ";id:" + getSlotId());
        this.A = 0;
        this.z = System.currentTimeMillis() - this.E;
        JSONObject jSONObject = new JSONObject();
        this.B = jSONObject;
        try {
            jSONObject.put("code", i);
            this.B.put(NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (JSONException unused) {
        }
        if (getType().equals(Const.TYPE_GDT) && i == 6000) {
            this.C = getType() + ":" + i + Operators.BRACKET_START_STR + str + Operators.BRACKET_END_STR;
            return;
        }
        if (getType().equals(Const.TYPE_BD) && i == -1) {
            this.C = getType() + ":" + str;
            return;
        }
        this.C = getType() + ":" + i;
    }

    protected void d(int i) {
        this.A = i;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public int getAdStatus() {
        return this.A;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void startLoadTime() {
        this.E = System.currentTimeMillis();
    }

    protected final long t() {
        return this.z;
    }

    protected void u() {
        this.z = System.currentTimeMillis() - this.E;
    }

    public void v() {
        c3.b("uniAD", getDCloudId() + ":" + getType() + ":success;id:" + getSlotId());
        this.A = 1;
        this.z = System.currentTimeMillis() - this.E;
    }
}
