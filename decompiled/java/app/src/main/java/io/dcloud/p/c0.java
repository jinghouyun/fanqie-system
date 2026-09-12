package io.dcloud.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.common.callercontext.ContextChain;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.common.util.CreateShortResultReceiver;
import io.dcloud.common.util.net.NetWork;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends ArrayList {
        a() {
            addAll(r1.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements q1.b {
        final /* synthetic */ String a;
        final /* synthetic */ HashMap b;
        final /* synthetic */ String[] c;

        b(String str, HashMap map, String[] strArr) {
            this.a = str;
            this.b = map;
            this.c = strArr;
        }

        @Override // io.dcloud.p.q1.b
        public void a(q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(q1.a aVar) {
            byte[] bArrA = l3.a(aVar.a(), this.a, this.b, this.c);
            if (bArrA == null) {
                return false;
            }
            String str = new String(bArrA, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            c3.c("uniAD-Commit_A", str);
            return true;
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c extends ArrayList {
        c() {
            addAll(r1.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements q1.b {
        final /* synthetic */ String a;
        final /* synthetic */ HashMap b;

        d(String str, HashMap map) {
            this.a = str;
            this.b = map;
        }

        @Override // io.dcloud.p.q1.b
        public void a(q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(q1.a aVar) {
            byte[] bArrA = l3.a(aVar.a(), this.a, this.b);
            if (bArrA == null) {
                return false;
            }
            String str = new String(bArrA, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            c3.c("uniAD-Commit_F", str);
            return true;
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4) {
        a(context, null, null, str2, str, str3, i, str4, null, null, null);
    }

    private static Map b(Context context, String str, String str2, int i, String str3, HashMap map) {
        String strEncode;
        String str4;
        try {
            strEncode = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            strEncode = "";
        }
        try {
            str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused2) {
            str4 = "";
        }
        String strA = u4.a(context, true, true);
        HashMap map2 = new HashMap();
        map2.put(ContextChain.TAG_PRODUCT, "a");
        map2.put("appid", str);
        map2.put(CreateShortResultReceiver.KEY_VERSIONNAME, str4);
        map2.put("at", Integer.valueOf(i));
        map2.put("psdk", Integer.valueOf(l0.c()));
        map2.put(WXConfig.os, Integer.valueOf(Build.VERSION.SDK_INT));
        map2.put("adpid", str3);
        if (strA.endsWith("&ie=1")) {
            strA = strA.replace("&ie=1", "");
            map2.put("ie", 1);
        } else if (strA.endsWith("&ie=0")) {
            strA = strA.replace("&ie=0", "");
            map2.put("ie", 0);
        }
        map2.put("imei", strA);
        map2.put("md", strEncode);
        map2.put("vd", Build.MANUFACTURER);
        map2.put("net", n4.d(context));
        map2.put("vb", l0.a());
        map2.put("t", Long.valueOf(System.currentTimeMillis()));
        map2.put("mc", l0.a(context));
        map2.put("paid", str2);
        map2.put("oaid", m3.a().c(context));
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, HashMap map, String str7, String str8) {
        a(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, map, str7, str8, null, null);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, HashMap map, String str7, String str8, String str9, String str10) {
        a(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, map, str7, str8, str9, str10);
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, String str5, JSONObject jSONObject, String str6, String str7, String str8, String str9, HashMap map, String str10, String str11, String str12, String str13) {
        String strEncode;
        JSONObject jSONObjectOptJSONObject;
        Map mapB = b(context, str, str3, i, str8, map);
        if (str10 != null) {
            mapB.put("rid", str10);
        }
        if (str11 != null) {
            mapB.put("cpm", str11);
        }
        if (str6 != null) {
            mapB.put("mediaId", str6);
        }
        if (str12 != null) {
            mapB.put("csv", str12);
        }
        if (str13 != null) {
            mapB.put("cav", str13);
        }
        if (str7 != null) {
            mapB.put("slotId", str7);
        }
        if (i == 32) {
            mapB.put("dec", str4);
            mapB.put("dem", str5);
        }
        if (i == 41 && jSONObject != null && str6 == null) {
            if (jSONObject.has(WXBasicComponentType.IMG)) {
                mapB.put(WXBasicComponentType.IMG, d3.a(jSONObject.optString(WXBasicComponentType.IMG)).toLowerCase(Locale.ENGLISH));
            }
            if (jSONObject.has("dw")) {
                mapB.put("dw", jSONObject.optString("dw"));
            }
            if (jSONObject.has("dh")) {
                mapB.put("dh", jSONObject.optString("dh"));
            }
            if (jSONObject.has("click_coord") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("click_coord")) != null) {
                mapB.put("click_coord", jSONObjectOptJSONObject.toString());
            }
        }
        mapB.put("tid", str2);
        HashMap map2 = new HashMap();
        map2.put(NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        try {
            strEncode = URLEncoder.encode(Base64.encodeToString(io.dcloud.p.d.b(g5.a(new JSONObject(mapB).toString()), f1.b(), f1.a()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            strEncode = null;
        }
        q1.a().a(context, new a(), "CAA_" + i, new b("edata=" + strEncode, map2, new String[1]));
    }

    public static void a(Context context, String str, String str2, int i, String str3, HashMap map) {
        String strEncode;
        try {
            strEncode = URLEncoder.encode(Base64.encodeToString(io.dcloud.p.d.b(g5.a(new JSONObject(b(context, str, str2, i, str3, map)).toString()), f1.b(), f1.a()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            strEncode = null;
        }
        HashMap map2 = new HashMap();
        map2.put(NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        q1.a().a(context, new c(), "RSP", new d("edata=" + strEncode, map2));
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8) {
        String strEncode;
        String strEncode2;
        String str9 = "";
        try {
            strEncode = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            strEncode = "";
        }
        try {
            str9 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused2) {
        }
        HashMap map = new HashMap();
        map.put(ContextChain.TAG_PRODUCT, "a");
        map.put("appid", str);
        map.put(CreateShortResultReceiver.KEY_VERSIONNAME, str9);
        map.put("psdk", Integer.valueOf(l0.c()));
        map.put(WXConfig.os, Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("adpid", str2);
        map.put("md", strEncode);
        map.put("vd", Build.MANUFACTURER);
        map.put("vb", l0.a());
        map.put("t", Long.valueOf(System.currentTimeMillis()));
        map.put("mc", l0.a(context));
        map.put("paid", str3);
        if (str4 != null) {
            map.put("mediaId", str4);
        }
        if (str5 != null) {
            map.put("slotId", str5);
        }
        if (str8 != null) {
            map.put("rid", str8);
            c3.b("uniad", str8);
        }
        map.put("gcpm", str6);
        map.put("currency", str7);
        map.put("pt", Integer.valueOf(i));
        try {
            strEncode2 = URLEncoder.encode(Base64.encodeToString(io.dcloud.p.d.b(g5.a(new JSONObject(map).toString()), f1.b(), f1.a()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused3) {
            strEncode2 = null;
        }
        HashMap map2 = new HashMap();
        map2.put(NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        byte[] bArrA = l3.a(r1.g.a(), "edata=" + strEncode2, map2);
        if (bArrA != null) {
            String str10 = new String(bArrA, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str10)) {
                return;
            }
            c3.c("uniAD-Commit_P", str10);
        }
    }
}
