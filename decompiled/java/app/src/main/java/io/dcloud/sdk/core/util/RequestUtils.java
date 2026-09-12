package io.dcloud.sdk.core.util;

import android.content.Context;
import android.util.Base64;
import io.dcloud.p.a3;
import io.dcloud.p.d;
import io.dcloud.p.e4;
import io.dcloud.p.g5;
import io.dcloud.p.l0;
import io.dcloud.p.l3;
import io.dcloud.p.m3;
import io.dcloud.p.u4;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class RequestUtils {
    public static String get(Context context, String str) {
        return e4.a(context, "dcloud-ads", str);
    }

    public static String getDid(Context context) {
        return u4.a(context, true, true);
    }

    public static String getOid(Context context) {
        return m3.a().c(context);
    }

    public static String getPost(String str, String str2, String str3) {
        return Base64.encodeToString(d.b(g5.a(str), str2, str3), 2);
    }

    public static byte[] httpGet(String str, HashMap<String, String> map) {
        return l3.a(str, (HashMap) map, true);
    }

    public static byte[] httpPost(String str, String str2, HashMap<String, String> map) {
        return l3.a(str, str2, map);
    }

    public static String mc(Context context) {
        return l0.a(context);
    }

    public static void postMessage(Runnable runnable) {
        a3.a().post(runnable);
    }

    public static void save(Context context, String str, String str2) {
        e4.a(context, "dcloud-ads", str, str2);
    }
}
