package io.dcloud.p;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import io.dcloud.sdk.activity.WebViewActivity;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.a, this.b, 0).show();
        }
    }

    public static boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(context.getPackageName())) {
            return true;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(Context context, String str) {
        MainHandlerUtil.getMainHandler().post(new a(context, str));
    }

    public static void c(Context context, String str) {
        try {
            Intent intent = new Intent();
            if (!Build.BRAND.equalsIgnoreCase("vivo") && a(context, "com.android.browser")) {
                intent.setPackage("com.android.browser");
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e("ADUtils", "openBrowser exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean d(Context context, String str) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.setSelector(null);
            uri.setComponent(null);
            uri.addCategory("android.intent.category.BROWSABLE");
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(uri, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                return false;
            }
            uri.setFlags(268435456);
            context.startActivity(uri);
            return true;
        } catch (Exception e) {
            Log.e("ADUtils", "openDeepLink exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static void e(Context context, String str) {
        try {
            Intent intent = new Intent();
            int i = WebViewActivity.o;
            intent.setClass(context, WebViewActivity.class);
            intent.putExtra("url", str);
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e("ADUtils", "openUrl exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static PackageInfo f(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static void a(Context context) {
        b(context, "已开始下载，完成后自动打开安装界面");
    }
}
