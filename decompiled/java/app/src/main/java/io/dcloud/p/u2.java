package io.dcloud.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.sdk.poly.base.utils.PrivacyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u2 {
    private static String a = "";
    private static boolean b = false;

    public static String a(Context context) {
        String strA;
        if (context == null) {
            return a;
        }
        if (!PrivacyManager.getInstance().d()) {
            return a;
        }
        if (!b0.a().a(context)) {
            return a;
        }
        if (b) {
            return a;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo.isConnected()) {
            strA = a();
        } else {
            strA = networkInfo2.isConnected() ? a(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress()) : null;
        }
        a = strA;
        b = true;
        return strA;
    }

    public static String a() {
        try {
            ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
            int size = list.size();
            int i = 0;
            while (i < size) {
                Object obj = list.get(i);
                i++;
                ArrayList list2 = Collections.list(((NetworkInterface) obj).getInetAddresses());
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = list2.get(i2);
                    i2++;
                    InetAddress inetAddress = (InetAddress) obj2;
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String a(int i) {
        return (i & 255) + Operators.DOT_STR + ((i >> 8) & 255) + Operators.DOT_STR + ((i >> 16) & 255) + Operators.DOT_STR + ((i >> 24) & 255);
    }
}
