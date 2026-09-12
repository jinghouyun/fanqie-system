package io.dcloud.common.util.net.http;

import android.content.Context;
import android.webkit.CookieSyncManager;
import java.net.CookieHandler;
import java.net.CookiePolicy;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class CookieManager {
    public static void initCookieConfig(Context context) {
        CookieSyncManager.createInstance(context);
        android.webkit.CookieManager.getInstance().setAcceptCookie(true);
        CookieHandler.setDefault(new WebkitCookieManagerProxy(null, CookiePolicy.ACCEPT_ALL));
    }
}
