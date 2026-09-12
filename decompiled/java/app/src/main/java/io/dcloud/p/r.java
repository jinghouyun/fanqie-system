package io.dcloud.p;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.dcloud.android.widget.dialog.DCloudAlertDialog;
import io.dcloud.PdrR;
import io.dcloud.WebAppActivity;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IActivityHandler;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.ICore;
import io.dcloud.common.DHInterface.IDCloudWebviewClientListener;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.IWebviewStateListener;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.ui.webview.WebResUtil;
import io.dcloud.common.adapter.ui.webview.WebViewFactory;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.constant.DataInterface;
import io.dcloud.common.constant.IntentConst;
import io.dcloud.common.constant.StringConst;
import io.dcloud.common.ui.PrivacyManager;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.CheckSignatureUtil;
import io.dcloud.common.util.DataUtil;
import io.dcloud.common.util.DialogUtil;
import io.dcloud.common.util.ErrorDialogUtil;
import io.dcloud.common.util.IOUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.ThreadPool;
import io.dcloud.feature.internal.sdk.SDK;
import io.src.dcloud.adapter.DCloudAdapterUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbsMgr implements IMgr.AppEvent {
    private static String j;
    d4 a;
    ArrayList b;
    ArrayList c;
    b4 d;
    Class[] e;
    private AlertDialog f;
    JSONObject g;
    private AlertDialog h;
    private AlertDialog i;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements ICallBack {
        a() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            String unused = r.j = String.valueOf(obj);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;
        final /* synthetic */ d5 c;
        final /* synthetic */ CheckBox d;
        final /* synthetic */ String e;
        final /* synthetic */ d5 f;
        final /* synthetic */ d5 g;
        final /* synthetic */ boolean h;

        c(Activity activity, String str, d5 d5Var, CheckBox checkBox, String str2, d5 d5Var2, d5 d5Var3, boolean z) {
            this.a = activity;
            this.b = str;
            this.c = d5Var;
            this.d = checkBox;
            this.e = str2;
            this.f = d5Var2;
            this.g = d5Var3;
            this.h = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i != -2) {
                if (i != -3 && i == -1) {
                    if (this.d.isChecked()) {
                        SP.setBundleData(this.a, "pdr", AbsoluteConst.TEST_RUN + this.b, "__am=t");
                    }
                    r.this.a(this.a, this.b, this.e, this.c, this.f, this.g, this.h);
                    r.this.f.dismiss();
                    return;
                }
                return;
            }
            r.this.f.dismiss();
            IActivityHandler iActivityHandler = DCloudAdapterUtil.getIActivityHandler(this.a);
            if (iActivityHandler != null) {
                iActivityHandler.closeAppStreamSplash(this.b);
                BaseInfo.setLoadingLaunchePage(false, "closeSplashScreen0");
                if (r.this.d.e() == 0) {
                    this.a.finish();
                    return;
                }
                d5 d5Var = this.c;
                if (d5Var != null) {
                    d5Var.w();
                }
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                this.a.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;

        d(Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://ask.dcloud.net.cn/article/35627"));
            this.a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;

        e(Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://ask.dcloud.net.cn/article/35877"));
            this.a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f implements ICallBack {
        final /* synthetic */ d5 a;

        f(d5 d5Var) {
            this.a = d5Var;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (AppRuntime.hasPrivacyForNotShown(this.a.getActivity())) {
                return null;
            }
            ((AbsMgr) r.this).mCore.onRestart(this.a.getActivity());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class g implements ICallBack {
        final /* synthetic */ d5 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ ICallBack d;

        g(d5 d5Var, boolean z, String str, ICallBack iCallBack) {
            this.a = d5Var;
            this.b = z;
            this.c = str;
            this.d = iCallBack;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (this.a.a(this.b)) {
                this.d.onCallBack(0, null);
            } else {
                Logger.e(Logger.AppMgr_TAG, "reboot " + this.c + " app failed !!!");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class h implements ICallBack {
        final /* synthetic */ d5 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        class a implements ICallBack {
            a() {
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                h hVar = h.this;
                r.this.a(hVar.a, hVar.b, hVar.c, hVar.d);
                return null;
            }
        }

        h(d5 d5Var, String str, String str2, boolean z) {
            this.a = d5Var;
            this.b = str;
            this.c = str2;
            this.d = z;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (!WebViewFactory.isOther() || WebViewFactory.isOtherInitialised() || WebViewFactory.isIsLoadOtherTimeOut()) {
                r.this.a(this.a, this.b, this.c, this.d);
                return null;
            }
            WebViewFactory.setOtherCallBack(new a());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DHFile.deleteFile(StringConst.STREAMAPP_KEY_ROOTPATH + "splash_temp/");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public r(ICore iCore) {
        super(iCore, Logger.AppMgr_TAG, IMgr.MgrType.AppMgr);
        this.a = null;
        this.b = new ArrayList(1);
        this.c = new ArrayList(1);
        this.d = null;
        this.e = new Class[0];
        this.g = null;
        if (iCore != null) {
            a(iCore.obtainContext());
        }
        c();
        b();
        d();
        a();
        this.d = new b4(this);
    }

    private void d(d5 d5Var) {
        Object objNewInstance = PlatformUtil.newInstance("android.app.ActivityManager$TaskDescription", new Class[]{String.class, Bitmap.class}, new Object[]{d5Var.obtainAppName(), BitmapFactory.decodeResource(getContext().getResources(), getContext().getApplicationInfo().icon)});
        PlatformUtil.invokeMethod(d5Var.getActivity(), "setTaskDescription", new Class[]{objNewInstance.getClass()}, objNewInstance);
    }

    d5 c(String str) {
        return a((Activity) null, str);
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void dispose() {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((d5) obj).g();
            }
        }
        this.c.clear();
        this.b.clear();
        b4 b4Var = this.d;
        if (b4Var != null) {
            b4Var.a();
        }
        this.d = null;
        ThreadPool.self().addThreadTask(new i());
    }

    void e(d5 d5Var) {
        this.d.b(d5Var.o);
        b(d5Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:200:0x0429  */
    @Override // io.dcloud.common.DHInterface.IMgr
    public Object processEvent(IMgr.MgrType mgrType, int i2, Object obj) {
        d5 d5VarC;
        String strSubstring;
        d5 d5VarA;
        Intent intentObtainWebAppIntent;
        String str;
        try {
            if (!checkMgrId(mgrType)) {
                return this.mCore.dispatchEvent(mgrType, i2, obj);
            }
            boolean z = true;
            switch (i2) {
                case 0:
                    Object[] objArr = (Object[]) obj;
                    Activity activity = (Activity) objArr[0];
                    String strValueOf = String.valueOf(objArr[1]);
                    String strValueOf2 = String.valueOf(objArr[2]);
                    Log.i("ylyl", " AppMGr START_APP " + strValueOf);
                    Logger.e("appMgr", "START_APP" + strValueOf);
                    d5 d5VarA2 = a(activity, strValueOf);
                    boolean zIsEmpty = TextUtils.isEmpty(d5VarA2.r0);
                    d5 d5VarB = this.d.b();
                    d5 d5VarA3 = this.d.a(activity, d5VarA2);
                    if (d5VarA3 != null && d5VarA3 == d5VarA2 && !d5VarA2.v) {
                        return d5VarA2;
                    }
                    if (!d5VarA2.q()) {
                        a(activity, strValueOf, strValueOf2, d5VarB, d5VarA2, d5VarA3, zIsEmpty);
                        if (d5VarA2.o()) {
                            AlertDialog alertDialog = this.h;
                            if (alertDialog != null && alertDialog.isShowing()) {
                                this.h.dismiss();
                            }
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(activity, PdrR.FEATURE_LOSS_STYLE).setTitle("HTML5+ Runtime").setIcon(R.drawable.ic_dialog_info).setMessage(StringUtil.format(activity.getString(io.dcloud.base.R.string.dcloud_common_app_tips1), d5VarA2.obtainConfigProperty(AbsoluteConst.APP_UNIAPP_VERSION), BaseInfo.uniVersionV3)).setPositiveButton(activity.getString(io.dcloud.base.R.string.dcloud_common_view_details), new d(activity)).setNegativeButton(activity.getString(io.dcloud.base.R.string.dcloud_common_ignore), (DialogInterface.OnClickListener) null).create();
                            this.h = alertDialogCreate;
                            alertDialogCreate.setCanceledOnTouchOutside(false);
                            this.h.show();
                        }
                        if (PlatformUtil.checkClass("io.dcloud.feature.weex.WeexFeature") || !BaseInfo.isUniAppAppid(d5VarA2) || !BaseInfo.isWeexUniJs(d5VarA2)) {
                            return d5VarA2;
                        }
                        AlertDialog alertDialog2 = this.i;
                        if (alertDialog2 != null && alertDialog2.isShowing()) {
                            this.i.dismiss();
                        }
                        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(activity, PdrR.FEATURE_LOSS_STYLE).setTitle("HTML5+ Runtime").setIcon(R.drawable.ic_dialog_info).setMessage(activity.getString(io.dcloud.base.R.string.dcloud_common_app_tips2)).setPositiveButton(activity.getString(io.dcloud.base.R.string.dcloud_common_view_details), new e(activity)).setNegativeButton(activity.getString(io.dcloud.base.R.string.dcloud_common_ignore), (DialogInterface.OnClickListener) null).create();
                        this.i = alertDialogCreate2;
                        alertDialogCreate2.setCanceledOnTouchOutside(false);
                        this.i.show();
                        return d5VarA2;
                    }
                    boolean z2 = d5VarA3 == null;
                    try {
                        String bundleData = SP.getBundleData(activity, "pdr", AbsoluteConst.TEST_RUN + strValueOf);
                        if (!TextUtils.isEmpty(bundleData)) {
                            if (bundleData.equals("popped")) {
                                SP.removeBundleData(activity, "pdr", AbsoluteConst.TEST_RUN + strValueOf);
                            }
                            z2 = false;
                        }
                        boolean booleanExtra = !d5VarA2.v ? activity.getIntent().getBooleanExtra(IntentConst.IS_START_FIRST_WEB, false) : false;
                        if (d5VarA2.n() || !z2 || booleanExtra || d5VarA2.u != 1) {
                            a(activity, strValueOf, strValueOf2, d5VarB, d5VarA2, d5VarA3, zIsEmpty);
                            return d5VarA2;
                        }
                        AlertDialog alertDialog3 = this.f;
                        if (alertDialog3 != null && alertDialog3.isShowing()) {
                            this.f.dismiss();
                        }
                        DCloudAlertDialog dCloudAlertDialogInitDialogTheme = DialogUtil.initDialogTheme(activity, true);
                        this.f = dCloudAlertDialogInitDialogTheme;
                        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
                        String string = activity.getString(io.dcloud.base.R.string.dcloud_common_app_test_tips);
                        CheckBox checkBox = new CheckBox(activity);
                        checkBox.setText(io.dcloud.base.R.string.dcloud_common_app_trust_tips);
                        checkBox.setTextColor(-65536);
                        this.f.setMessage(string);
                        this.f.setView(checkBox, DeviceInfo.getDeivceSuitablePixel(activity, 20), 0, 0, 0);
                        c cVar = new c(activity, strValueOf, d5VarB, checkBox, strValueOf2, d5VarA2, d5VarA3, zIsEmpty);
                        this.f.setButton(-2, activity.getResources().getString(R.string.cancel), cVar);
                        this.f.setButton(-1, activity.getResources().getString(R.string.ok), cVar);
                        Logger.e("yl", "test show ");
                        this.f.show();
                        return d5VarA2;
                    } catch (Throwable th) {
                        th = th;
                        d5VarC = null;
                        Logger.w("AppMgr.processEvent", th);
                        return d5VarC;
                    }
                case 1:
                    Object[] objArr2 = (Object[]) obj;
                    Object obj2 = objArr2[2];
                    d5 d5VarA4 = obj2 instanceof IApp ? (d5) obj2 : a(String.valueOf(obj2), false);
                    boolean zA = (BaseInfo.sRuntimeMode == null && d5VarA4 == null && !d5.a((ISysEventListener.SysEventType) objArr2[0])) ? false : this.d.a(d5VarA4, (ISysEventListener.SysEventType) objArr2[0], objArr2[1]);
                    if (zA || d5VarA4 == null || !((ISysEventListener.SysEventType) objArr2[0]).equals(ISysEventListener.SysEventType.onKeyUp)) {
                        z = zA;
                    } else {
                        int iIntValue = ((Integer) ((Object[]) objArr2[1])[0]).intValue();
                        if (iIntValue == 4) {
                            processEvent(IMgr.MgrType.WindowMgr, 20, d5VarA4);
                        } else {
                            z = zA;
                        }
                    }
                    return Boolean.valueOf(z);
                case 2:
                    String strValueOf3 = String.valueOf(obj);
                    if (PdrUtil.isDeviceRootDir(strValueOf3)) {
                        int iIndexOf = strValueOf3.indexOf(BaseInfo.sBaseFsAppsPath);
                        if (iIndexOf >= 0) {
                            String strSubstring2 = strValueOf3.substring(iIndexOf + BaseInfo.sBaseFsAppsPath.length());
                            strSubstring = strSubstring2.substring(0, strSubstring2.indexOf("/"));
                        } else {
                            strSubstring = null;
                        }
                        InputStream encryptionInputStream = TextUtils.isEmpty(strSubstring) ? null : WebResUtil.getEncryptionInputStream(strValueOf3, c(strSubstring));
                        return encryptionInputStream == null ? DHFile.getInputStream(DHFile.createFileHandler(strValueOf3)) : encryptionInputStream;
                    }
                    d5 d5VarC2 = c(this.d.b().o);
                    if (strValueOf3.startsWith(AbsoluteConst.MINI_SERVER_APP_WWW)) {
                        if (d5VarC2 != null) {
                            return d5VarC2.obtainResInStream(strValueOf3);
                        }
                    } else if (strValueOf3.startsWith(AbsoluteConst.MINI_SERVER_APP_DOC)) {
                        return DHFile.getInputStream(DHFile.createFileHandler(d5VarC2.obtainAppDocPath() + strValueOf3.substring(5)));
                    }
                    return null;
                case 3:
                    String strValueOf4 = String.valueOf(obj);
                    d5 d5VarB2 = "snc:CID".equals(strValueOf4) ? this.d.b() : a(strValueOf4, true);
                    if (!(d5VarB2.getActivity() instanceof WebAppActivity)) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    WebAppActivity webAppActivity = (WebAppActivity) d5VarB2.getActivity();
                    if (webAppActivity == null || webAppActivity.isFinishing()) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    if (!PrivacyManager.getInstance().isPrivacyVersionChange(webAppActivity.getContext())) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    Intent launchIntentForPackage = webAppActivity.getApplication().getPackageManager().getLaunchIntentForPackage(webAppActivity.getApplication().getPackageName());
                    launchIntentForPackage.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                    webAppActivity.getApplication().startActivity(launchIntentForPackage);
                    Process.killProcess(Process.myPid());
                    return null;
                case 4:
                    Object[] objArr3 = (Object[]) obj;
                    String strValueOf5 = String.valueOf(objArr3[0]);
                    JSONObject jSONObject = (JSONObject) objArr3[1];
                    IWebview iWebview = (IWebview) objArr3[2];
                    String string2 = JSONUtil.getString(jSONObject, "appid");
                    if (Boolean.parseBoolean(JSONUtil.getString(jSONObject, AbsoluteConst.INSTALL_OPTIONS_RECOGNISE)) && !TextUtils.isEmpty(strValueOf5)) {
                        Locale locale = Locale.ENGLISH;
                        if (!strValueOf5.toLowerCase(locale).endsWith(".wgtu") && !strValueOf5.toLowerCase(locale).endsWith(".wgt") && !CheckSignatureUtil.check(strValueOf5)) {
                            return new Object[]{Boolean.TRUE, StringUtil.format(DOMException.JSON_ERROR_INFO, 10, iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_common_app_check_failed))};
                        }
                    }
                    if (PdrUtil.isEmpty(string2)) {
                        string2 = iWebview.obtainFrameView().obtainApp().obtainAppId();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Logger.d(Logger.AppMgr_TAG, "install begin _filePath = " + strValueOf5 + ";_mayBeAppid = " + string2);
                    d5 d5VarA5 = a(strValueOf5, string2, jSONObject);
                    StringBuilder sb = new StringBuilder("install end useTime=");
                    sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    Logger.d(Logger.AppMgr_TAG, sb.toString());
                    return new Object[]{Boolean.valueOf(d5VarA5.s.a), d5VarA5.s.b};
                case 5:
                    d5 d5VarC3 = c(String.valueOf(obj));
                    if (d5VarC3 != null) {
                        return d5VarC3.v();
                    }
                    return null;
                case 6:
                    return c(String.valueOf(obj));
                case 7:
                    String str2 = (String) obj;
                    if (this.a == null) {
                        this.a = new d4(this);
                    }
                    this.a.a(str2);
                    Logger.d(Logger.AppMgr_TAG, "data=" + str2);
                    return null;
                case 8:
                    String[] strArr = (String[]) obj;
                    return a(strArr[0], strArr[1], strArr[2], Byte.parseByte(strArr[3]));
                case 9:
                    Object[] objArr4 = (Object[]) obj;
                    IApp iApp = (IApp) objArr4[0];
                    IWebviewStateListener iWebviewStateListener = (IWebviewStateListener) objArr4[1];
                    if (objArr4.length <= 2) {
                        return ((d5) iApp).a(iWebviewStateListener);
                    }
                    IDCloudWebviewClientListener iDCloudWebviewClientListener = (IDCloudWebviewClientListener) objArr4[2];
                    if (!PdrUtil.isEmpty(iDCloudWebviewClientListener)) {
                        return ((d5) iApp).a(iWebviewStateListener, iDCloudWebviewClientListener);
                    }
                    return null;
                case 10:
                    if (obj instanceof String) {
                        d5VarA = a(String.valueOf(obj), false);
                    } else if (obj instanceof d5) {
                        d5VarA = (d5) obj;
                    } else {
                        d5VarA = obj instanceof Map ? a((String) ((Map) obj).get("appid"), false) : null;
                    }
                    if (d5VarA != null) {
                        d5VarA.u();
                        return null;
                    }
                    return null;
                case 11:
                    if (this.d.b() != null) {
                        return this.d.b().o;
                    }
                    return null;
                case 12:
                    d5 d5VarA6 = a((String) obj, false);
                    if (d5VarA6 == null) {
                        return (byte) 1;
                    }
                    byte b2 = d5VarA6.u;
                    if (b2 != 3) {
                        return Byte.valueOf(b2);
                    }
                    byte b3 = d5VarA6.p() ? d5VarA6.u : (byte) 2;
                    d5VarA6.u = b3;
                    return Byte.valueOf(b3);
                case 13:
                    d5 d5Var = (d5) obj;
                    return d5Var != null ? Boolean.valueOf(d5Var.r()) : AbsoluteConst.FALSE;
                case 14:
                    String strValueOf6 = String.valueOf(obj);
                    if (strValueOf6.endsWith("/")) {
                        strValueOf6 = strValueOf6.substring(0, strValueOf6.length() - 1);
                    }
                    String strSubstring3 = strValueOf6.substring(strValueOf6.lastIndexOf("/") + 1);
                    d5VarC = b(strSubstring3) ? c(strSubstring3) : b(strValueOf6, strSubstring3);
                    if (!d5VarC.s.a) {
                        try {
                            c(d5VarC);
                            return d5VarC;
                        } catch (Throwable th2) {
                            th = th2;
                            Logger.w("AppMgr.processEvent", th);
                            return d5VarC;
                        }
                    }
                    return null;
                case 15:
                case 17:
                case 18:
                case 22:
                case 23:
                case 25:
                case 26:
                default:
                    return null;
                case 16:
                    Object[] objArr5 = (Object[]) obj;
                    ((d5) ((IApp) objArr5[0])).a((String) objArr5[1], 1);
                    return null;
                case 19:
                    return this.d.c();
                case 20:
                case 21:
                    if (obj instanceof String) {
                        str = (String) obj;
                        intentObtainWebAppIntent = null;
                    } else {
                        Object[] objArr6 = (Object[]) obj;
                        intentObtainWebAppIntent = (Intent) objArr6[1];
                        str = (String) objArr6[2];
                    }
                    d5 d5VarA7 = this.d.a(str);
                    Boolean bool = Boolean.TRUE;
                    if (d5VarA7 == null) {
                        return Boolean.FALSE;
                    }
                    d5 d5VarB3 = this.d.b();
                    if (d5VarB3 != d5VarA7) {
                        if (d5VarB3 != null) {
                            d5VarB3.w();
                        }
                        if (intentObtainWebAppIntent != null) {
                            d5VarA7.setWebAppIntent(intentObtainWebAppIntent);
                        } else {
                            intentObtainWebAppIntent = d5VarA7.obtainWebAppIntent();
                        }
                        if (21 == i2) {
                            intentObtainWebAppIntent.putExtra(IntentConst.IS_WEBAPP_REPLY, true);
                        }
                        d5VarA7.getActivity().setIntent(intentObtainWebAppIntent);
                        Logger.d(Logger.AppMgr_TAG, str + " will unactive change to active STREAM_START_APP");
                        if (d5VarA7.u == 2) {
                            d5VarA7.c();
                        }
                    }
                    return bool;
                case 24:
                    return j;
                case 27:
                    d5 d5VarB4 = this.d.b();
                    if (d5VarB4 != null) {
                        a(d5VarB4, (String) null, true);
                        return null;
                    }
                    Logger.e(Logger.AppMgr_TAG, "not app!!!");
                    return null;
                case 28:
                    return this.d.b() != null ? this.d.b() : a((String) obj, false);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements Runnable {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0013  */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (BaseInfo.SyncDebug) {
                str = (PlatformUtil.getResInputStream("uni-jsframework-dev.js") == null || SDK.isUniMPSDK()) ? "uni-jsframework.js" : "uni-jsframework-dev.js";
            }
            try {
                BaseInfo.setUniVersionV3(new JSONObject(new BufferedReader(new InputStreamReader(this.a.getAssets().open(str))).readLine().substring(2)).optString("version"), this.a);
            } catch (Exception unused) {
            }
        }
    }

    void b() {
        f5 f5Var;
        HashMap<String, BaseInfo.BaseAppInfo> map = BaseInfo.mBaseAppInfoSet;
        if (map == null || map.isEmpty()) {
            return;
        }
        Set<String> setKeySet = BaseInfo.mBaseAppInfoSet.keySet();
        int size = setKeySet.size();
        String[] strArr = new String[size];
        setKeySet.toArray(strArr);
        for (int i2 = 0; i2 < size; i2++) {
            String str = strArr[i2];
            BaseInfo.BaseAppInfo baseAppInfo = BaseInfo.mBaseAppInfoSet.get(str);
            if (!BaseInfo.mUnInstalledAppInfoSet.containsKey(str) && !b(str)) {
                d5 d5VarB = b(BaseInfo.sBaseResAppsPath + str, str);
                if (d5VarB != null && (f5Var = d5VarB.s) != null) {
                    if (f5Var.a) {
                        Logger.e("AppMgr", str + "  app error," + d5VarB.s);
                    } else {
                        d5VarB.t = baseAppInfo;
                        c(d5VarB);
                    }
                }
            }
        }
    }

    void c(d5 d5Var) {
        this.b.add(d5Var.obtainAppId());
        this.c.add(d5Var);
    }

    private void a() {
        if (PdrUtil.isEmpty(j)) {
            DataUtil.datToJsString(BaseInfo.sUniNViewServiceJsPath, new a());
        }
    }

    void c() {
        f5 f5Var;
        HashMap<String, BaseInfo.BaseAppInfo> map = BaseInfo.mInstalledAppInfoSet;
        if (map == null || map.isEmpty()) {
            return;
        }
        Set<String> setKeySet = BaseInfo.mInstalledAppInfoSet.keySet();
        int size = setKeySet.size();
        String[] strArr = new String[size];
        setKeySet.toArray(strArr);
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            String str = strArr[i2];
            if (!BaseInfo.mUnInstalledAppInfoSet.containsKey(str) && !b(str)) {
                d5 d5VarB = b(BaseInfo.sCacheFsAppsPath + str, str);
                if (d5VarB != null && (f5Var = d5VarB.s) != null && !f5Var.a) {
                    d5VarB.deleteAppTemp();
                    if (SDK.isUniMPSDK()) {
                        d5VarB.j0 = true;
                    } else {
                        d5VarB.j0 = false;
                    }
                    c(d5VarB);
                } else {
                    BaseInfo.mInstalledAppInfoSet.get(str).clearBundleData();
                    BaseInfo.mInstalledAppInfoSet.remove(str);
                    z = true;
                }
            }
        }
        if (z) {
            BaseInfo.saveInstalledAppInfo(getContext());
        }
    }

    private void a(Context context) {
        if (TextUtils.isEmpty(BaseInfo.uniVersionV3)) {
            ThreadPool.self().addThreadTask(new b(context), true);
        }
    }

    void d() {
        File file = new File(BaseInfo.sURDFilePath);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            DHFile.copyAssetsFile("data/dcloud_url.json", file.getAbsolutePath());
        }
        if (file.exists()) {
            try {
                this.g = new JSONObject(new String(DHFile.readAll(file)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(d5 d5Var, String str, boolean z) {
        if (d5Var != null) {
            String strObtainConfigProperty = d5Var.obtainConfigProperty(IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
            f fVar = new f(d5Var);
            if (!TextUtils.isEmpty(strObtainConfigProperty) && strObtainConfigProperty.equals(AbsoluteConst.UNI_V3)) {
                if (d5Var.getActivity() != null) {
                    BaseInfo.isFirstRun = false;
                    d5Var.showSplash();
                    AppRuntime.restartWeex(d5Var.getActivity().getApplication(), new g(d5Var, z, str, fVar), d5Var.o);
                    return;
                }
                return;
            }
            if (!d5Var.a(z)) {
                Logger.e(Logger.AppMgr_TAG, "reboot " + str + " app failed !!!");
                return;
            }
            fVar.onCallBack(0, null);
            return;
        }
        Logger.e(Logger.AppMgr_TAG, "not found " + str + " app!!!");
    }

    void b(d5 d5Var) {
        this.b.remove(d5Var.o);
        this.c.remove(d5Var);
    }

    private boolean b(String str) {
        return this.b.contains(str);
    }

    private d5 b(String str, String str2) {
        return a(str, str2);
    }

    private void a(d5 d5Var) {
        if (SDK.isUniMPSDK() && SDK.isEnableBackground) {
            d(d5Var);
        }
    }

    public void a(Activity activity, String str, String str2, d5 d5Var, d5 d5Var2, d5 d5Var3, boolean z) {
        Log.i("ylyl", "startOneApp " + str);
        BaseInfo.sLastRunApp = str;
        BaseInfo.CmtInfo cmitInfo = BaseInfo.getCmitInfo(str);
        if (cmitInfo.needUpdate) {
            cmitInfo.templateVersion = d5Var2.D;
            cmitInfo.rptCrs = d5Var2.M;
            cmitInfo.rptJse = d5Var2.N;
            cmitInfo.plusLauncher = BaseInfo.getLaunchType(d5Var2.obtainWebAppIntent());
            cmitInfo.sfd = DataInterface.getStreamappFrom(d5Var2.obtainWebAppIntent());
            cmitInfo.needUpdate = false;
        }
        if (!c4.c()) {
            if (d5Var2.u == 4) {
                ErrorDialogUtil.checkAppKeyErrorTips(activity);
                return;
            }
        } else if (!PdrUtil.checkIntl()) {
            q.a(activity, d5Var2);
            if (d5Var2.u == 4) {
                return;
            }
        }
        if (d5Var2.u == 3) {
            d5Var2.u = d5Var2.p() ? d5Var2.u : (byte) 2;
        }
        if (d5Var != null && d5Var != d5Var2 && d5Var != d5Var3) {
            d5Var.w();
        }
        byte b2 = d5Var2.u;
        if (b2 == 1 || ((z && !d5Var2.w) || ((d5Var2.x && d5Var2.v) || !z))) {
            Logger.d(Logger.AppMgr_TAG, str + " will unrunning change to active");
            d5Var2.a(activity);
            processEvent(IMgr.MgrType.WindowMgr, 4, new Object[]{d5Var2, str});
            d5Var2.a(new h(d5Var2, str, str2, z));
        } else if (b2 == 2) {
            Logger.d(Logger.AppMgr_TAG, str + " will unactive change to active");
            d5Var2.c();
        } else {
            Logger.d(Logger.AppMgr_TAG, str + " is active");
        }
        if (SDK.isUniMPSDK()) {
            a(d5Var2);
        }
        if (d5Var3 == null || d5Var3 == d5Var2) {
            return;
        }
        d5Var3.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d5 d5Var, String str, String str2, boolean z) {
        if (this.d == null) {
            return;
        }
        boolean zF = z ? d5Var.f(str2) : d5Var.g(str2);
        if (!d5Var.w && d5Var.v) {
            d5Var.f(str2);
        }
        if (zF) {
            this.d.a(str, d5Var);
            return;
        }
        Logger.e(Logger.AppMgr_TAG, str + " run failed!!!");
    }

    d5 a(Activity activity, String str) {
        return a(activity, str, true);
    }

    private d5 a(String str, boolean z) {
        return a((Activity) null, str, z);
    }

    private d5 a(Activity activity, String str, boolean z) {
        int iIndexOf;
        d5 d5Var = (!this.b.contains(str) || (iIndexOf = this.b.indexOf(str)) < 0) ? null : (d5) this.c.get(iIndexOf);
        if (d5Var != null || !z) {
            if (d5Var != null && activity != null) {
                if (d5Var.a == null) {
                    d5Var.a = activity;
                }
                if (d5Var.a.getIntent() != null) {
                    if (d5Var.manifestBeParsed()) {
                        d5Var.setWebAppIntent(d5Var.a.getIntent());
                    }
                } else {
                    d5Var.a.setIntent(d5Var.obtainWebAppIntent());
                }
                if (!d5Var.v) {
                    d5Var.b(str, null);
                }
            }
            return d5Var;
        }
        d5 d5Var2 = new d5(this, str, (byte) 0);
        d5Var2.setAppDataPath(BaseInfo.sCacheFsAppsPath + str + DeviceInfo.sSeparatorChar + BaseInfo.REAL_PRIVATE_WWW_DIR);
        if (d5Var2.a == null) {
            d5Var2.a = activity;
        }
        if (activity != null) {
            d5Var2.setWebAppIntent(activity.getIntent());
        }
        d5Var2.b(str, null);
        if (d5Var2.s.a) {
            d5Var2.o = str;
        }
        c(d5Var2);
        return d5Var2;
    }

    d5 a(String str, String str2, String str3, byte b2) {
        d5 d5VarA = a(str, false);
        if (d5VarA == null) {
            d5VarA = new d5(this, str, b2);
            d5VarA.u = (byte) 3;
            d5VarA.o = str;
            if (!PdrUtil.isEmpty(str2)) {
                d5VarA.setAppDataPath(str2);
            }
            d5VarA.l0 = str3;
            c(d5VarA);
            this.d.a(str, d5VarA);
        }
        return d5VarA;
    }

    d5 a(String str, String str2) {
        return a(str, str2, (JSONObject) null);
    }

    d5 a(String str, String str2, JSONObject jSONObject) {
        Exception e2;
        d5 d5Var;
        PackageInfo apkInfo;
        Class<?> cls;
        d5 d5VarA = a(str2, false);
        if (d5VarA != null) {
            try {
                d5VarA.s.a();
            } catch (Exception e3) {
                e2 = e3;
                d5Var = d5VarA;
                e2.printStackTrace();
                Logger.e(Logger.AppMgr_TAG, "installWebApp " + str + " is Illegal path");
                return d5Var;
            }
        }
        InputStream resInputStream = null;
        if (!DHFile.isExist(str) && !PdrUtil.isDeviceRootDir(str)) {
            boolean zContains = str.substring(str.lastIndexOf(47)).contains(".wgt");
            resInputStream = zContains ? PlatformUtil.getResInputStream(str) : null;
            if (d5VarA == null) {
                d5VarA = new d5(this, str2, (byte) 1);
            }
            if (!zContains && resInputStream == null) {
                d5VarA.setAppDataPath(str + DeviceInfo.sSeparatorChar + BaseInfo.REAL_PRIVATE_WWW_DIR);
                d5VarA.b(str2, jSONObject);
            } else {
                d5VarA.b(resInputStream);
            }
        } else {
            boolean zIsFile = new File(str).isFile();
            if (zIsFile) {
                if (zIsFile && str.toLowerCase(Locale.ENGLISH).endsWith(".wgtu")) {
                    if (d5VarA == null) {
                        d5VarA = new d5(this, str2, (byte) 0);
                    }
                    d5VarA.a(str, jSONObject);
                    f5 f5Var = d5VarA.s;
                    f5Var.c = false;
                    f5Var.d = false;
                } else if (zIsFile && str.toLowerCase(Locale.ENGLISH).endsWith(".wgt")) {
                    boolean z = d5VarA == null;
                    d5VarA.s.d = true;
                    if (z) {
                        d5Var = new d5(this, str2, (byte) 0);
                        try {
                            d5Var.o = str2;
                            d5Var.setAppDataPath(BaseInfo.sCacheFsAppsPath + str2 + DeviceInfo.sSeparatorChar + BaseInfo.REAL_PRIVATE_WWW_DIR);
                            d5VarA = d5Var;
                        } catch (Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            Logger.e(Logger.AppMgr_TAG, "installWebApp " + str + " is Illegal path");
                            return d5Var;
                        }
                    }
                    boolean zC = d5VarA.c(str, jSONObject);
                    d5VarA.s.d = false;
                    if (zC && z) {
                        c(d5VarA);
                    }
                } else if (zIsFile && str.toLowerCase(Locale.ENGLISH).endsWith(StringConst.POINT_APP_EN)) {
                    try {
                        apkInfo = PlatformUtil.parseApkInfo(getContext(), str);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        d5VarA.s.b = StringUtil.format(DOMException.JSON_ERROR_INFO, 10, e5.getMessage());
                        apkInfo = null;
                    }
                    try {
                        cls = Class.forName("io.dcloud.feature.pack.FileUtils");
                    } catch (Exception unused) {
                        cls = null;
                    }
                    if (apkInfo != null && cls != null) {
                        d5VarA.s.a = false;
                        String str3 = apkInfo.versionName;
                        String str4 = apkInfo.packageName;
                        String string = getContext().getPackageManager().getApplicationLabel(apkInfo.applicationInfo).toString();
                        if (string == null) {
                            string = "";
                        }
                        d5VarA.s.b = StringUtil.format("{pname:'%s',version:'%s',name:'%s'}", str4, str3, string);
                        try {
                            cls.getDeclaredMethod("addFileToSystem", Context.class, String.class, String.class).invoke(null, getContext(), getContext().getPackageName() + ".dc.fileprovider", str);
                        } catch (Exception unused2) {
                        }
                    } else {
                        d5VarA.s.a = true;
                    }
                } else {
                    f5 f5Var2 = d5VarA.s;
                    f5Var2.a = true;
                    f5Var2.b = StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(DOMException.CODE_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED), DOMException.MSG_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED);
                }
            } else {
                if (d5VarA != null) {
                    d5VarA.b((byte) 0);
                } else {
                    d5VarA = new d5(this, str2, (byte) 0);
                }
                d5VarA.setAppDataPath(str + DeviceInfo.sSeparatorChar + BaseInfo.REAL_PRIVATE_WWW_DIR);
                d5VarA.b(str2, jSONObject);
            }
        }
        IOUtil.close(resInputStream);
        return d5VarA;
    }
}
