package io.dcloud.sdk.base.entry;

import android.content.Context;
import io.dcloud.p.l4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private long a;
    private String b;
    private AdData c;

    public a(String str) {
        this.b = str;
    }

    public void a(String str) {
        try {
            Date date = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(new JSONObject(str).optString("expires"));
            if (date != null) {
                this.a = date.getTime();
            }
        } catch (ParseException | JSONException unused) {
        }
    }

    public boolean b() {
        return System.currentTimeMillis() > this.a;
    }

    public void a(Context context, AdData adData) {
        if (adData != null) {
            adData.c(context);
            String strA = l4.a().a(context, this.b);
            if (strA != null) {
                try {
                    adData.a(new JSONObject(strA), null, false);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public void a(AdData adData) {
        this.c = adData;
    }

    public String a() {
        return this.b;
    }
}
