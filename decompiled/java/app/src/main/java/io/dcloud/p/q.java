package io.dcloud.p;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.dcloud.android.widget.dialog.DCloudAlertDialog;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.LoadAppUtils;
import io.dcloud.common.util.Md5Utils;
import io.dcloud.common.util.ReflectUtils;
import io.dcloud.feature.internal.sdk.SDK;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    public static String a = "appid";

    /* JADX WARN: Code duplicated, block: B:8:0x0042  */
    public static void a(Activity activity, IApp iApp) {
        String str;
        String string;
        String metaValue = AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
        if (TextUtils.isEmpty(metaValue) || metaValue == null) {
            str = null;
        } else {
            String[] strArrSplit = metaValue.split("\\|");
            if (strArrSplit.length > 2) {
                str = strArrSplit[2] + "|" + iApp.getConfusionMgr().decodeString(iApp.getConfusionMgr().getODS(), true, 50);
            } else {
                str = null;
            }
        }
        try {
            string = ReflectUtils.getStaticObjectField(activity.getPackageName() + iApp.getConfusionMgr().decryptStr("&J}adlKgfnao"), iApp.getConfusionMgr().decryptStr("GIC")).toString();
        } catch (Exception unused) {
            string = "";
        }
        if (BaseInfo.SyncDebug || SDK.isUniMP || TextUtils.isEmpty(string) || a(activity, iApp.obtainAppId(), LoadAppUtils.getAppSignatureSHA1(activity), string, str)) {
            return;
        }
        iApp.setStatus((byte) 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    private static boolean a(Context context, String str, String str2, String str3, String str4) {
        String packageName = context.getPackageName();
        Locale locale = Locale.ENGLISH;
        String lowerCase = packageName.toLowerCase(locale);
        try {
            StringBuilder sb = new StringBuilder("|");
            int iCharAt = str3.charAt(0) - '0';
            if ((iCharAt & 1) != 1) {
                str = "";
            }
            sb.append(str);
            sb.append("|");
            if ((iCharAt & 2) != 2) {
                lowerCase = "";
            }
            sb.append(lowerCase);
            sb.append("|");
            if ((iCharAt & 4) != 4) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            sb.append(str4);
            boolean zEquals = str3.equals((iCharAt + Md5Utils.md5(sb.toString())).toLowerCase(locale));
            if (!zEquals) {
                a(iCharAt, context);
            }
            return zEquals;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void a(int i, Context context) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        String string = "";
        if (!z && !z2 && !z3) {
            Process.killProcess(Process.myPid());
        } else if (z && z2 && z3) {
            string = context.getString(R.string.dcloud_onlone_fail_tips_all);
        } else {
            String string2 = context.getString(R.string.dcloud_onlone_fail_tips);
            String string3 = context.getString(R.string.dcloud_tips_package_name);
            String string4 = context.getString(R.string.dcloud_tips_certificate);
            if (z) {
                string = "" + a + "、";
            }
            if (z2) {
                string = string + string3 + "、";
            }
            if (z3) {
                string = string + string4 + "、";
            }
            string = String.format(string2, string.substring(0, string.length() - 1));
        }
        a(context, string);
    }

    public static void a(Context context, String str) {
        try {
            DCloudAlertDialog dCloudAlertDialog = new DCloudAlertDialog(context, AppRuntime.getAppDarkMode(context) ? DCloudAlertDialog.DARK_THEME : DCloudAlertDialog.LIGHT_THEME, true);
            dCloudAlertDialog.setTitle(str);
            dCloudAlertDialog.setButton(-2, context.getString(android.R.string.ok), new DialogInterface.OnClickListener() { // from class: io.dcloud.p.q$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    q.a(dialogInterface, i);
                }
            });
            dCloudAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: io.dcloud.p.q$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return q.a(dialogInterface, i, keyEvent);
                }
            });
            dCloudAlertDialog.setCancelable(false);
            dCloudAlertDialog.setCanceledOnTouchOutside(false);
            dCloudAlertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Process.killProcess(Process.myPid());
    }
}
