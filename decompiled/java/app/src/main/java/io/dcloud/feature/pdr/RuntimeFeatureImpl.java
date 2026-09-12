package io.dcloud.feature.pdr;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.android.bindingx.core.internal.BindingXConstants;
import com.alibaba.fastjson.JSON;
import com.facebook.common.util.UriUtil;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.PandoraEntry;
import io.dcloud.PdrR;
import io.dcloud.WebAppActivity;
import io.dcloud.WebviewActivity;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.message.ActionBus;
import io.dcloud.common.DHInterface.message.action.BadgeSyncAction;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.constant.StringConst;
import io.dcloud.common.ui.Info.AndroidPrivacyResponse;
import io.dcloud.common.ui.PrivacyManager;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.CustomPath;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.LoadAppUtils;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.TelephonyUtil;
import io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class RuntimeFeatureImpl implements IFeature, MessageHandler.IMessages {
    final String a = PandoraEntry.class.getName();
    AbsMgr b = null;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends Thread {
        final /* synthetic */ String[] a;
        final /* synthetic */ String b;
        final /* synthetic */ IWebview c;

        a(String[] strArr, String str, IWebview iWebview) {
            this.a = strArr;
            this.b = str;
            this.c = iWebview;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr = this.a;
            String str = strArr[1];
            Object[] objArr = (Object[]) RuntimeFeatureImpl.this.b.processEvent(IMgr.MgrType.AppMgr, 4, new Object[]{this.b, !PdrUtil.isEmpty(strArr[2]) ? JSONUtil.createJSONObject(this.a[2]) : null, this.c});
            boolean zBooleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
            String strValueOf = String.valueOf(objArr[1]);
            if (zBooleanValue) {
                Deprecated_JSUtil.execCallback(this.c, str, strValueOf, JSUtil.ERROR, true, false);
            } else {
                Deprecated_JSUtil.execCallback(this.c, str, strValueOf, JSUtil.OK, true, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements PrivacyManager.b {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;
        final /* synthetic */ WebAppActivity c;

        b(IWebview iWebview, String str, WebAppActivity webAppActivity) {
            this.a = iWebview;
            this.b = str;
            this.c = webAppActivity;
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(String str) {
            JSUtil.execCallback(this.a, this.b, new JSONObject(), JSUtil.ERROR, false);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void b(AndroidPrivacyResponse androidPrivacyResponse) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSUtil.execCallback(this.a, this.b, jSONObject, JSUtil.OK, false);
        }

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        class a implements PrivacyManager.b {
            a() {
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a(String str) {
                JSONObject jSONObject = new JSONObject();
                b bVar = b.this;
                JSUtil.execCallback(bVar.a, bVar.b, jSONObject, JSUtil.ERROR, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void b(AndroidPrivacyResponse androidPrivacyResponse) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b bVar = b.this;
                JSUtil.execCallback(bVar.a, bVar.b, jSONObject, JSUtil.OK, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a() {
                b.this.c.onPrivacySureAction();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", 1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b bVar = b.this;
                JSUtil.execCallback(bVar.a, bVar.b, jSONObject, JSUtil.OK, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a(AndroidPrivacyResponse androidPrivacyResponse) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b bVar = b.this;
                JSUtil.execCallback(bVar.a, bVar.b, jSONObject, JSUtil.OK, false);
            }
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a() {
            this.c.onPrivacySureAction();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSUtil.execCallback(this.a, this.b, jSONObject, JSUtil.OK, false);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(AndroidPrivacyResponse androidPrivacyResponse) {
            if (TextUtils.isEmpty(androidPrivacyResponse.second.message)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSUtil.execCallback(this.a, this.b, jSONObject, JSUtil.OK, false);
                return;
            }
            PrivacyManager.getInstance().showPrivacyDialog(this.c, new a(), true, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        c(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (i == 1) {
                return null;
            }
            Deprecated_JSUtil.excCallbackError(this.a, this.b, String.valueOf(obj), true);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        d(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (i == 1) {
                Deprecated_JSUtil.execCallback(this.a, this.b, "{}", JSUtil.OK, true, false);
                return null;
            }
            Deprecated_JSUtil.excCallbackError(this.a, this.b, String.valueOf(obj), true);
            return null;
        }
    }

    private void a(IWebview iWebview, String str, String str2) throws Throwable {
        String strValueOf = (TextUtils.isEmpty(str) || str.equals(WXInstanceApm.VALUE_ERROR_CODE_DEFAULT)) ? "" : String.valueOf(Math.max(0, Integer.valueOf(str).intValue()));
        try {
            String str3 = Build.MANUFACTURER;
            if (str3.equalsIgnoreCase("Xiaomi")) {
                b(iWebview, strValueOf, str2);
                return;
            }
            if (str3.equalsIgnoreCase("samsung")) {
                c(iWebview, strValueOf);
                return;
            }
            Locale locale = Locale.ENGLISH;
            if (str3.toLowerCase(locale).contains("sony")) {
                d(iWebview, strValueOf);
                return;
            }
            if (str3.toLowerCase(locale).contains("huawei")) {
                e(iWebview, strValueOf);
                return;
            }
            if (str3.toLowerCase(locale).contains("vivo")) {
                g(iWebview, strValueOf);
            } else if (str3.toLowerCase(locale).contains("oppo")) {
                f(iWebview, strValueOf);
            } else if (str3.toLowerCase(locale).contains("honor")) {
                b(iWebview, strValueOf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(IWebview iWebview, String str, String str2) throws Throwable {
        JSONObject jSONObject;
        Notification.Builder builder;
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        NotificationManager notificationManager = (NotificationManager) iWebview.getContext().getSystemService("notification");
        boolean z = false;
        Notification notificationBuild = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    a(iWebview.getContext());
                    g4$$ExternalSyntheticApiModelOutline0.m$2();
                    builder = g4$$ExternalSyntheticApiModelOutline0.m(iWebview.getContext(), "LOCAL_BADGE_NUM");
                } else {
                    builder = new Notification.Builder(iWebview.getContext());
                }
                builder.setContentText(PdrUtil.isEmpty(jSONObject.optString(UriUtil.LOCAL_CONTENT_SCHEME)) ? StringUtil.format(iWebview.getContext().getString(R.string.dcloud_common_msg_unread_prompt), str) : jSONObject.optString(UriUtil.LOCAL_CONTENT_SCHEME));
                builder.setAutoCancel(true);
                int i = PdrR.getInt(iWebview.getContext(), "drawable", "push");
                if (i <= 0) {
                    builder.setSmallIcon(iWebview.getContext().getApplicationInfo().icon);
                } else {
                    builder.setSmallIcon(i);
                }
                builder.setDefaults(4);
                String packageName = iWebview.getActivity().getPackageName();
                PackageManager packageManager = iWebview.getActivity().getPackageManager();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                builder.setContentTitle(PdrUtil.isEmpty(jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE)) ? AndroidResources.mApplicationInfo.applicationInfo.loadLabel(packageManager) : jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE));
                builder.setContentIntent(PendingIntent.getActivity(iWebview.getActivity(), 10019, launchIntentForPackage, 1073741824));
                builder.setAutoCancel(true);
                notificationBuild = builder.build();
                notificationBuild.flags = 16;
                Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(Integer.parseInt(str)));
                notificationManager.notify(101010, notificationBuild);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
                    intent.putExtra("android.intent.extra.update_application_component_name", this.a);
                    intent.putExtra("android.intent.extra.update_application_message_text", str);
                    iWebview.getContext().sendBroadcast(intent);
                } catch (Throwable th) {
                    th = th;
                    if (notificationBuild != null) {
                        notificationManager.notify(101010, notificationBuild);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (notificationBuild != null && z) {
                notificationManager.notify(101010, notificationBuild);
            }
            throw th;
        }
    }

    private void c(IWebview iWebview, String str) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", Integer.parseInt(str));
        intent.putExtra("badge_count_package_name", iWebview.getContext().getPackageName());
        intent.putExtra("badge_count_class_name", this.a);
        iWebview.getContext().sendBroadcast(intent);
    }

    private void d(IWebview iWebview, String str) {
        if (iWebview.getContext().getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) == null) {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", str);
            intent.putExtra("badge_count_package_name", iWebview.getContext().getPackageName());
            intent.putExtra("badge_count_class_name", this.a);
            iWebview.getActivity().sendBroadcast(intent);
            return;
        }
        boolean z = Integer.parseInt(str) != 0;
        Intent intent2 = new Intent();
        intent2.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", this.a);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", iWebview.getContext().getPackageName());
        iWebview.getContext().sendBroadcast(intent2);
    }

    private void e(IWebview iWebview, String str) {
        int i = !str.equals("") ? Integer.parseInt(str) : 0;
        int i2 = i >= 0 ? i : 0;
        Bundle bundle = new Bundle();
        bundle.putString("package", iWebview.getContext().getPackageName());
        bundle.putString("class", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
        bundle.putInt("badgenumber", i2);
        iWebview.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        ActionBus.getInstance().sendToBus(BadgeSyncAction.obtain(BadgeSyncAction.ENUM_ACTION_TYPE.SYNC_NUM).setSyncNum(i2));
    }

    private void f(IWebview iWebview, String str) {
        int i = Integer.parseInt(str);
        if (i == 0) {
            i = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        iWebview.getContext().getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
    }

    private void g(IWebview iWebview, String str) {
        try {
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", iWebview.getContext().getPackageName());
            intent.putExtra("className", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
            intent.putExtra("notificationNum", Integer.parseInt(str));
            iWebview.getContext().sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0016  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        String strSubstring;
        String str2;
        String str3;
        Object objValueOf;
        str.getClass();
        str.hashCode();
        boolean z = false;
        switch (str) {
            case "getDCloudId":
                String bundleData = SP.getBundleData(iWebview.getContext(), "pdr", SP.STARTUP_DEVICE_ID);
                return !PdrUtil.isEmpty(bundleData) ? Deprecated_JSUtil.wrapJsVar(bundleData, true) : Deprecated_JSUtil.wrapJsVar(TelephonyUtil.getIMEI(iWebview.getContext(), true, true), true);
            case "isApplicationExist":
                String str4 = strArr[0];
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        if (jSONObject.has("pname")) {
                            String string = jSONObject.getString("pname");
                            return (!TextUtils.isEmpty(string) && LoadAppUtils.isAppLoad(iWebview.getContext(), string)) ? AbsoluteConst.TRUE : AbsoluteConst.FALSE;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return AbsoluteConst.FALSE;
                    }
                }
                return AbsoluteConst.FALSE;
            case "isCustomLaunchPath":
                return iWebview.obtainFrameView().obtainApp().checkIsCustomPath() ? AbsoluteConst.TRUE : AbsoluteConst.FALSE;
            case "processDirectPage":
                String directPage = iWebview.obtainApp().getDirectPage();
                iWebview.obtainApp().setDirectPage(null);
                if (TextUtils.isEmpty(directPage)) {
                    directPage = "";
                }
                return JSUtil.wrapJsVar(directPage);
            case "isStreamValid":
                return (BaseInfo.existsStreamEnv() && BaseInfo.existsLibso()) ? AbsoluteConst.TRUE : AbsoluteConst.FALSE;
            case "isAgreePrivacy":
                String bundleData2 = SP.getBundleData(iWebview.getContext(), "pdr", "scok");
                String metaValue = AndroidResources.getMetaValue("DCLOUD_PRIVACY_PROMPT");
                if (PdrUtil.isEmpty(metaValue) ? PdrUtil.isEmpty(bundleData2) || bundleData2.equals("1") : !metaValue.equalsIgnoreCase("template") ? !metaValue.equalsIgnoreCase("custom") ? PdrUtil.isEmpty(bundleData2) || bundleData2.equals("1") : !PdrUtil.isEmpty(bundleData2) && bundleData2.equals("1") : !PdrUtil.isEmpty(bundleData2) && bundleData2.equals("1")) {
                    z = true;
                }
                return JSUtil.wrapJsVar(z);
            case "downloadBlob":
                try {
                    strSubstring = strArr[0];
                    try {
                        str2 = strArr[2];
                        try {
                            str3 = str2;
                            objValueOf = strArr[1];
                        } catch (Exception unused) {
                            str3 = str2;
                            objValueOf = null;
                        }
                    } catch (Exception unused2) {
                        str2 = null;
                    }
                } catch (Exception unused3) {
                    strSubstring = null;
                    str2 = null;
                }
                if (PdrUtil.isEmpty(strSubstring)) {
                    Deprecated_JSUtil.execCallback(iWebview, str3, DOMException.toJSON(-1, "blob error"), JSUtil.ERROR, true, false);
                } else {
                    try {
                        strSubstring = strSubstring.substring(strSubstring.indexOf(",") + 1);
                        break;
                    } catch (Exception unused4) {
                    }
                    String str5 = DeviceInfo.sDeviceRootDir + "/Download/";
                    StringBuilder sb = new StringBuilder();
                    sb.append(str5);
                    if (PdrUtil.isEmpty(objValueOf)) {
                        objValueOf = Long.valueOf(System.currentTimeMillis());
                    }
                    sb.append(objValueOf);
                    File file = new File(sb.toString());
                    byte[] bArrDecode = Base64.decode(strSubstring, 0);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                        fileOutputStream.write(bArrDecode);
                        fileOutputStream.flush();
                        Deprecated_JSUtil.execCallback(iWebview, str3, "{'code':0,'message':'" + file.getPath() + "'}", JSUtil.ERROR, true, false);
                    } catch (Exception e2) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("code", -1);
                            jSONObject2.put("message", e2.toString());
                            break;
                        } catch (JSONException unused5) {
                        }
                        JSUtil.execCallback(iWebview, str3, jSONObject2, JSUtil.ERROR, false);
                        return null;
                    }
                }
                return null;
            case "disagreePrivacy":
                SP.setBundleData(iWebview.getContext(), "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return null;
            case "agreePrivacy":
                SP.setBundleData(iWebview.getContext(), "pdr", "scok", "1");
                return null;
            default:
                MessageHandler.sendMessage(this, new Object[]{iWebview, str, strArr});
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.b = absMgr;
    }

    private void a(IWebview iWebview, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(iWebview.getActivity(), WebviewActivity.class);
            intent.putExtra("url", str);
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            iWebview.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, IApp iApp) {
        if (TextUtils.isEmpty(str) || !BaseInfo.ISAMU) {
            return;
        }
        int length = str.length();
        String str2 = StringConst.POINT_APP_EN;
        if ((length - str.indexOf(str2)) - str2.length() == 0 || (length - str.indexOf(".wgt")) - 4 == 0 || (length - str.indexOf(".wgtu")) - 5 == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "install");
                jSONObject.put("file", str);
                jSONObject.put("appid", iApp.obtainOriginalAppId());
                jSONObject.put("version", iApp.obtainAppVersionName());
                Log.i(AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Context context) {
        if (Build.VERSION.SDK_INT < 26 || !Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.createNotificationChannelGroup(g4$$ExternalSyntheticApiModelOutline0.m("LOCAL_BADGE_SETTING", "badge"));
        g4$$ExternalSyntheticApiModelOutline0.m471m$1();
        NotificationChannel notificationChannelM = g4$$ExternalSyntheticApiModelOutline0.m("LOCAL_BADGE_NUM", context.getString(R.string.dcloud_nf_desktop_icon_corner), 3);
        notificationChannelM.enableLights(true);
        notificationChannelM.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannelM);
    }

    private void b(IWebview iWebview, String str) {
        int i = !str.equals("") ? Integer.parseInt(str) : 0;
        int i2 = i >= 0 ? i : 0;
        Bundle bundle = new Bundle();
        bundle.putString("package", iWebview.getContext().getPackageName());
        bundle.putString("class", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
        bundle.putInt("badgenumber", i2);
        iWebview.getContext().getContentResolver().call(Uri.parse("content://com.hihonor.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        ActionBus.getInstance().sendToBus(BadgeSyncAction.obtain(BadgeSyncAction.ENUM_ACTION_TYPE.SYNC_NUM).setSyncNum(i2));
    }

    private void b(String str, IApp iApp) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "openurl");
            jSONObject.put("url", str);
            jSONObject.put("appid", iApp.obtainOriginalAppId());
            jSONObject.put("version", iApp.obtainAppVersionName());
            Log.i(AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
    public void execute(Object obj) throws Throwable {
        char c2;
        String strOptString;
        String str;
        String strOptString2;
        JSONObject jSONObject;
        Object[] objArr = (Object[]) obj;
        IWebview iWebview = (IWebview) objArr[0];
        String strValueOf = String.valueOf(objArr[1]);
        String[] strArr = (String[]) objArr[2];
        IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        strValueOf.hashCode();
        byte b2 = -1;
        switch (strValueOf.hashCode()) {
            case -1263204667:
                if (strValueOf.equals("openURL")) {
                    b2 = 0;
                }
                break;
            case -1263202134:
                if (strValueOf.equals("openWeb")) {
                    b2 = 1;
                }
                break;
            case -1150858339:
                if (strValueOf.equals("launchApplication")) {
                    b2 = 2;
                }
                break;
            case -944934523:
                if (strValueOf.equals("openDocument")) {
                    b2 = 3;
                }
                break;
            case -505062682:
                if (strValueOf.equals("openFile")) {
                    b2 = 4;
                }
                break;
            case 3482191:
                if (strValueOf.equals("quit")) {
                    b2 = 5;
                }
                break;
            case 545494794:
                if (strValueOf.equals("setBadgeNumber")) {
                    b2 = 6;
                }
                break;
            case 1084758859:
                if (strValueOf.equals("getProperty")) {
                    b2 = 7;
                }
                break;
            case 1097506319:
                if (strValueOf.equals("restart")) {
                    b2 = 8;
                }
                break;
            case 1247092467:
                if (strValueOf.equals("showPrivacyDialog")) {
                    b2 = 9;
                }
                break;
            case 1957569947:
                if (strValueOf.equals("install")) {
                    b2 = 10;
                }
                break;
        }
        String string = null;
        switch (b2) {
            case 0:
                try {
                    String str2 = strArr[0];
                    if (PdrUtil.isDeviceRootDir(str2) || PdrUtil.isNetPath(str2) || str2.startsWith(DeviceInfo.FILE_PROTOCOL) || iAppObtainApp.checkSchemeWhite(str2)) {
                        b(strArr[0], iAppObtainApp);
                        PlatformUtil.openURL(iWebview.getActivity(), strArr[0], String.valueOf(PdrUtil.getObject(strArr, 2)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Deprecated_JSUtil.excCallbackError(iWebview, strArr[1], e.getMessage());
                    return;
                }
                break;
            case 1:
                a(iWebview, strArr[0]);
                break;
            case 2:
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    JSONArray jSONArrayNames = jSONObject2.names();
                    HashMap map = new HashMap();
                    String string2 = null;
                    boolean z = true;
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        String string3 = jSONArrayNames.getString(i);
                        try {
                            if (string3.equals("pname")) {
                                string = jSONObject2.getString(string3);
                            } else if (string3.equals("action")) {
                                string2 = jSONObject2.getString(string3);
                            } else {
                                if (string3.equals("extra")) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(string3);
                                    Iterator<String> itKeys = jSONObject3.keys();
                                    while (itKeys.hasNext()) {
                                        String next = itKeys.next();
                                        map.put(next, jSONObject3.get(next));
                                    }
                                } else {
                                    c2 = 1;
                                    if (string3.equals("newTask")) {
                                        z = jSONObject2.getBoolean("newTask");
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            Deprecated_JSUtil.execCallback(iWebview, strArr[c2], DOMException.toJSON(-99, e.getMessage()), JSUtil.OK, true, false);
                            return;
                        }
                        c2 = 1;
                        break;
                    }
                    c2 = 1;
                    PlatformUtil.launchApplication(iWebview.getActivity(), string, string2, map, z);
                } catch (Exception e3) {
                    e = e3;
                    c2 = 1;
                }
                break;
            case 3:
                String strCheckPrivateDirAndCopy2Temp = iAppObtainApp.checkPrivateDirAndCopy2Temp(strArr[0]);
                String str3 = strArr[2];
                try {
                    JSONObject jSONObject4 = new JSONObject(strArr[1]);
                    strOptString = jSONObject4.optString("pname");
                    try {
                        String lowerCase = jSONObject4.optString("fileType").toLowerCase(Locale.ENGLISH);
                        switch (lowerCase.hashCode()) {
                            case 99640:
                                if (lowerCase.equals(CustomPath.CUSTOM_PATH_DOC)) {
                                    str = "application/msword";
                                    string = str;
                                }
                                break;
                            case 110834:
                                if (lowerCase.equals("pdf")) {
                                    str = "application/pdf";
                                    string = str;
                                }
                                break;
                            case 111220:
                                if (lowerCase.equals("ppt")) {
                                    str = "application/vnd.ms-powerpoint";
                                    string = str;
                                }
                                break;
                            case 118783:
                                if (lowerCase.equals("xls")) {
                                    str = "application/vnd.ms-excel";
                                    string = str;
                                }
                                break;
                            case 3088960:
                                if (lowerCase.equals("docx")) {
                                    str = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                    string = str;
                                }
                                break;
                            case 3447940:
                                if (lowerCase.equals("pptx")) {
                                    str = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                                    string = str;
                                }
                                break;
                            case 3682393:
                                if (lowerCase.equals("xlsx")) {
                                    str = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                    string = str;
                                }
                                break;
                        }
                        break;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    strOptString = null;
                }
                String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strCheckPrivateDirAndCopy2Temp);
                if (!new File(strConvert2AbsFullPath).isFile()) {
                    Deprecated_JSUtil.execCallback(iWebview, str3, DOMException.toJSON(-4, DOMException.MSG_FILE_NOT_EXIST), JSUtil.ERROR, true, false);
                } else {
                    PlatformUtil.openFileBySystem(iAppObtainApp.getActivity(), strConvert2AbsFullPath, strOptString, string, new d(iWebview, str3));
                }
                break;
            case 4:
                String strCheckPrivateDirAndCopy2Temp2 = iAppObtainApp.checkPrivateDirAndCopy2Temp(strArr[0]);
                String str4 = strArr[2];
                try {
                    strOptString2 = new JSONObject(strArr[1]).optString("pname");
                } catch (Exception e4) {
                    e4.printStackTrace();
                    strOptString2 = null;
                }
                String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strCheckPrivateDirAndCopy2Temp2);
                if (!new File(strConvert2AbsFullPath2).isFile()) {
                    Deprecated_JSUtil.execCallback(iWebview, str4, DOMException.toJSON(-4, DOMException.MSG_FILE_NOT_EXIST), JSUtil.ERROR, true, false);
                } else {
                    PlatformUtil.openFileBySystem(iAppObtainApp.getActivity(), strConvert2AbsFullPath2, strOptString2, null, new c(iWebview, str4));
                }
                break;
            case 5:
                this.b.processEvent(IMgr.MgrType.WindowMgr, 20, iAppObtainApp);
                break;
            case 6:
                a(iWebview, strArr[0], (strArr.length <= 1 || PdrUtil.isEmpty(strArr[1])) ? "{}" : strArr[1]);
                break;
            case 7:
                String strObtainAppId = strArr[0];
                if (PdrUtil.isEmpty(strObtainAppId)) {
                    strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
                }
                String str5 = strArr[1];
                String strValueOf2 = String.valueOf(this.b.processEvent(IMgr.MgrType.AppMgr, 5, strObtainAppId));
                if (PdrUtil.isEmpty(strValueOf2)) {
                    Deprecated_JSUtil.excCallbackError(iWebview, str5, null);
                } else {
                    Deprecated_JSUtil.excCallbackSuccess(iWebview, str5, strValueOf2, true);
                }
                break;
            case 8:
                String strObtainAppId2 = iAppObtainApp.obtainAppId();
                iAppObtainApp.clearRuntimeArgs();
                this.b.processEvent(IMgr.MgrType.AppMgr, 3, strObtainAppId2);
                break;
            case 9:
                String str6 = strArr[0];
                try {
                    jSONObject = new JSONObject(strArr[1]);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    jSONObject = null;
                }
                PrivacyManager.getInstance().resetPrivacyLocalConfig(iWebview.getContext());
                if (jSONObject == null || jSONObject.optJSONObject(BindingXConstants.KEY_CONFIG) == null) {
                    PrivacyManager.getInstance().reInit(iWebview.getContext(), null);
                } else {
                    PrivacyManager.getInstance().reInit(iWebview.getContext(), JSON.parseObject(jSONObject.toString()));
                }
                WebAppActivity webAppActivity = (WebAppActivity) iWebview.getContext();
                PrivacyManager.getInstance().showPrivacyDialog(webAppActivity, new b(iWebview, str6, webAppActivity), false, true);
                break;
            case 10:
                AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Runtime-install");
                String strConvert2AbsFullPath3 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[0]);
                a(strConvert2AbsFullPath3, iAppObtainApp);
                new a(strArr, strConvert2AbsFullPath3, iWebview).start();
                break;
        }
    }
}
