package io.dcloud.p;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f1 {
    private static String a;
    private static String b;

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            try {
                b = a("@\\ED=XD][Z]F\\AEM");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static String b() {
        if (TextUtils.isEmpty(a)) {
            try {
                a = a("LKdg}l.:\"8V9+>88");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    private static String a(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return new String(bytes, "GBK");
    }
}
