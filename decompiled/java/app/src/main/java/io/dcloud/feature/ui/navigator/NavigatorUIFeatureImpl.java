package io.dcloud.feature.ui.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import com.dcloud.android.widget.toast.ToastCompat;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.PdrR;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.ui.webview.DCWebView;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.constant.IntentConst;
import io.dcloud.common.constant.StringConst;
import io.dcloud.common.ui.blur.DCBlurDraweeView;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.LoadAppUtils;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.ShortCutUtil;
import io.dcloud.common.util.ShortcutCreateUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.TestUtil;
import io.dcloud.common.util.emulator.EmulatorCheckUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class NavigatorUIFeatureImpl implements IFeature {
    AbsMgr a;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String[] b;
        final /* synthetic */ IApp c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(IApp iApp, IWebview iWebview, String[] strArr, IApp iApp2, String str) {
            super(iApp);
            this.a = iWebview;
            this.b = strArr;
            this.c = iApp2;
            this.d = str;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(String str) {
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(String str) {
            NavigatorUIFeatureImpl.this.a(this.a, this.b, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements ISysEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ IApp b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        b(int i, IApp iApp, IWebview iWebview, String str, String str2) {
            this.a = i;
            this.b = iApp;
            this.c = iWebview;
            this.d = str;
            this.e = str2;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
            Object[] objArr = (Object[]) obj;
            int iIntValue = ((Integer) objArr[0]).intValue();
            int[] iArr = (int[]) objArr[2];
            ISysEventListener.SysEventType sysEventType2 = ISysEventListener.SysEventType.onRequestPermissionsResult;
            if (sysEventType2 == sysEventType && iIntValue == this.a) {
                this.b.unregisterSysEventListener(this, sysEventType2);
                Deprecated_JSUtil.execCallback(this.c, this.e, StringUtil.format("{result:'%s'}", PermissionUtil.convert5PlusValue(iArr.length > 0 ? iArr[0] : this.c.obtainApp().checkSelfPermission(this.d, this.c.obtainApp().obtainAppName()))), JSUtil.OK, true, false);
            }
            return true;
        }
    }

    private void b(Context context, IWebview iWebview, String str, String str2) {
        String str3;
        String strRequestShortCut = ShortCutUtil.requestShortCut(context, str2);
        if (ShortCutUtil.SHORT_CUT_EXISTING.equals(strRequestShortCut)) {
            str3 = StringUtil.format(DOMException.JSON_SHORTCUT_RESULT_INFO, "existing");
        } else if (ShortCutUtil.SHORT_CUT_NONE.equals(strRequestShortCut)) {
            str3 = StringUtil.format(DOMException.JSON_SHORTCUT_RESULT_INFO, "none");
        } else {
            str3 = ShortCutUtil.NOPERMISSIONS.equals(strRequestShortCut) ? StringUtil.format(DOMException.JSON_SHORTCUT_RESULT_INFO, ShortCutUtil.NOPERMISSIONS) : StringUtil.format(DOMException.JSON_SHORTCUT_RESULT_INFO, "unknown");
        }
        try {
            JSUtil.execCallback(iWebview, str, new JSONObject(str3), JSUtil.OK, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        int i;
        int iStringToColor;
        IApp iAppObtainApp = iWebview.obtainApp();
        String strObtainAppId = iAppObtainApp.obtainAppId();
        str.getClass();
        str.hashCode();
        switch (str) {
            case "getOrientation":
                try {
                    int rotation = iWebview.getActivity().getWindowManager().getDefaultDisplay().getRotation();
                    if (rotation == 1) {
                        i = 90;
                    } else if (rotation != 2) {
                        i = rotation != 3 ? 0 : -90;
                    } else {
                        i = 180;
                    }
                    return JSUtil.wrapJsVar(i);
                } catch (Exception unused) {
                    return JSUtil.wrapJsVar(0.0f);
                }
            case "hideSystemNavigation":
                Window window = iAppObtainApp.getActivity().getWindow();
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 4866);
                iWebview.obtainApp().setHideNavBarState(true);
                return null;
            case "updateSplashscreen":
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    SharedPreferences.Editor editorEdit = SP.getOrCreateBundle(iWebview.getContext(), "pdr").edit();
                    String strObtainAppId2 = iAppObtainApp.obtainAppId();
                    String strOptString = jSONObject.optString("image", null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                        if (PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                            DHFile.copyFile(strConvert2AbsFullPath, StringConst.STREAMAPP_KEY_ROOTPATH + "splash/" + iAppObtainApp.obtainAppId() + ".png", true, false);
                        }
                        editorEdit.putString(SP.UPDATE_SPLASH_IMG_PATH, strConvert2AbsFullPath);
                    }
                    if (!jSONObject.isNull(IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
                        editorEdit.putBoolean(strObtainAppId2 + SP.UPDATE_SPLASH_AUTOCLOSE, jSONObject.optBoolean(IApp.ConfigProperty.CONFIG_AUTOCLOSE));
                    }
                    if (!jSONObject.isNull(IApp.ConfigProperty.CONFIG_DELAY)) {
                        editorEdit.putInt(strObtainAppId2 + SP.UPDATE_SPLASH_DELAY, jSONObject.optInt(IApp.ConfigProperty.CONFIG_DELAY));
                    }
                    if (BaseInfo.isWap2AppAppid(strObtainAppId2)) {
                        if (!jSONObject.isNull(IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            editorEdit.putBoolean(strObtainAppId2 + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, jSONObject.optBoolean(IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A));
                        }
                        if (!jSONObject.isNull(IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            editorEdit.putInt(strObtainAppId2 + SP.UPDATE_SPLASH_DELAY_W2A, jSONObject.optInt(IApp.ConfigProperty.CONFIG_DELAY_W2A));
                        }
                    }
                    editorEdit.commit();
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            case "hasShortcut":
                AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                String str2 = strArr[0];
                String str3 = strArr[1];
                String strObtainAppName = iWebview.obtainApp().obtainAppName();
                try {
                    strObtainAppName = new JSONObject(str2).optString("name", strObtainAppName);
                    break;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b(iWebview.getContext(), iWebview, str3, strObtainAppName);
                return null;
            case "closeSplashscreen":
                Logger.d(Logger.MAIN_TAG, "appid=" + strObtainAppId + " closeSplashscreen");
                TestUtil.print(TestUtil.START_STREAM_APP, "closeSplashscreen appid=" + strObtainAppId);
                Logger.i("download_manager", "javascript webapp task begin success appid=" + strObtainAppId + " closeSplashscreen");
                this.a.processEvent(IMgr.MgrType.WindowMgr, 11, iWebview.obtainFrameView());
                return null;
            case "getStatusBarStyle":
                return JSUtil.wrapJsVar(iAppObtainApp.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_MODE));
            case "isLogs":
                return JSUtil.wrapJsVar(Logger.isOpen());
            case "showSystemNavigation":
                Window window2 = iAppObtainApp.getActivity().getWindow();
                window2.getDecorView().setSystemUiVisibility(window2.getDecorView().getSystemUiVisibility() & (-515));
                iWebview.obtainApp().setHideNavBarState(false);
                return null;
            case "isSimulator":
                AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                return JSUtil.wrapJsVar(EmulatorCheckUtil.getSingleInstance().emulatorCheck(iWebview.getContext()));
            case "removeSessionCookie":
                try {
                    iWebview.removeSessionCookie();
                    return null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            case "isImmersedStatusbar":
                return JSUtil.wrapJsVar(iAppObtainApp.obtainStatusBarMgr().checkImmersedStatusBar(iWebview.getActivity(), Boolean.valueOf(iAppObtainApp.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)).booleanValue()));
            case "getStatusBarBackground":
                return JSUtil.wrapJsVar(PdrUtil.toHexFromColor(iAppObtainApp.getActivity().getWindow().getStatusBarColor()));
            case "setCookie":
                iWebview.setCookie(strArr[0], strArr[1]);
                return null;
            case "hasSplashscreen":
                return JSUtil.wrapJsVar(!iAppObtainApp.obtainWebAppRootView().didCloseSplash());
            case "getUserAgent":
                boolean z = Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_funSetUA));
                String strObtainConfigProperty = iWebview.obtainApp().obtainConfigProperty(IApp.ConfigProperty.CONFIG_USER_AGENT);
                if (TextUtils.isEmpty(strObtainConfigProperty)) {
                    strObtainConfigProperty = "";
                }
                if (!z) {
                    boolean z2 = Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_CONCATENATE));
                    boolean z3 = Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_H5PLUS));
                    if (z2) {
                        String str4 = BaseInfo.sDefWebViewUserAgent + Operators.SPACE_STR + strObtainConfigProperty;
                        if (iWebview.obtainApp().isUniApp() && !str4.contains("uni-app")) {
                            str4 = str4 + " uni-app";
                        }
                        if (!z3) {
                            return str4;
                        }
                        return str4 + DCWebView.UserAgentExtInfo;
                    }
                }
                return strObtainConfigProperty;
            case "getCookie":
                return iWebview.getCookie(strArr[0]);
            case "createShortcut":
                AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                PermissionUtil.usePermission(iWebview.getActivity(), IFeature.F_NAVIGATOR, "SHORTCUT", 2, new a(iAppObtainApp, iWebview, strArr, iAppObtainApp, strObtainAppId));
                return null;
            case "setFullscreen":
                iAppObtainApp.setFullScreen(PdrUtil.parseBoolean(String.valueOf(strArr[0]), false, false));
                break;
            case "getUiStyle":
                return JSUtil.wrapJsVar(AppRuntime.getAppDarkMode(iWebview.getContext()) ? DCBlurDraweeView.DARK : DCBlurDraweeView.LIGHT);
            case "checkPermission":
                return JSUtil.wrapJsVar(PermissionUtil.checkPermission(iWebview, strArr));
            case "requestPermission":
                String str5 = strArr[0];
                String str6 = strArr[1];
                int requestCode = PermissionUtil.getRequestCode();
                String strConvertNativePermission = PermissionUtil.convertNativePermission(str5);
                iAppObtainApp.registerSysEventListener(new b(requestCode, iAppObtainApp, iWebview, strConvertNativePermission, str6), ISysEventListener.SysEventType.onRequestPermissionsResult);
                iAppObtainApp.requestPermissions(new String[]{strConvertNativePermission}, requestCode);
                break;
            case "isBackground":
                return JSUtil.wrapJsVar(iAppObtainApp.obtainAppStatus() == 2);
            case "getSignature":
                return JSUtil.wrapJsVar(LoadAppUtils.getAppSignatureSHA1(iWebview.getContext()));
            case "hasNotchInScreen":
                return JSUtil.wrapJsVar(QueryNotchTool.hasNotchInScreen(iWebview.getActivity()));
            case "setStatusBarBackground":
                String str7 = strArr[0];
                if (!TextUtils.isEmpty(str7)) {
                    try {
                        iStringToColor = Color.parseColor(str7);
                        break;
                    } catch (Exception unused2) {
                        iStringToColor = PdrUtil.stringToColor(str7);
                    }
                    iAppObtainApp.setConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_BC, strArr[0]);
                    iAppObtainApp.obtainStatusBarMgr().setStatusBarColor(iAppObtainApp.getActivity(), iStringToColor);
                    break;
                }
                break;
            case "removeAllCookie":
                try {
                    iWebview.removeAllCookie();
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    break;
                }
                break;
            case "isFullScreen":
                return JSUtil.wrapJsVar(iAppObtainApp.isFullScreen());
            case "getStatusbarHeight":
                DeviceInfo.updateStatusBarHeight(iWebview.getActivity());
                return JSUtil.wrapJsVar(DeviceInfo.sStatusBarHeight / iWebview.getScale());
            case "setUserAgent":
                String str8 = strArr[0];
                String str9 = strArr[1];
                iAppObtainApp.setConfigProperty(IApp.ConfigProperty.CONFIG_USER_AGENT, str8);
                iAppObtainApp.setConfigProperty(IApp.ConfigProperty.CONFIG_funSetUA, AbsoluteConst.TRUE);
                iAppObtainApp.setConfigProperty(IApp.ConfigProperty.CONFIG_H5PLUS, str9);
                iWebview.setWebviewProperty(IWebview.USER_AGENT, str8);
                break;
            case "setLogs":
                Logger.setOpen(PdrUtil.parseBoolean(String.valueOf(strArr[0]), false, false));
                break;
            case "setStatusBarStyle":
                String str10 = strArr[0];
                iAppObtainApp.setConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_MODE, str10);
                iAppObtainApp.obtainStatusBarMgr().setStatusBarMode(iAppObtainApp.getActivity(), str10);
                break;
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.a = absMgr;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;

        c(Context context, String str, IWebview iWebview, String str2) {
            this.a = context;
            this.b = str;
            this.c = iWebview;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (!ShortCutUtil.SHORT_CUT_EXISTING.equals(ShortCutUtil.requestShortCutForCommit(this.a, this.b))) {
                str = AbsoluteConst.FALSE;
            } else {
                str = AbsoluteConst.TRUE;
            }
            try {
                JSUtil.execCallback(this.c, this.d, new JSONObject(StringUtil.format(DOMException.JSON_SHORTCUT_SUCCESS_INFO, str)), JSUtil.OK, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00a4 A[Catch: Exception -> 0x00d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d0, blocks: (B:28:0x009e, B:30:0x00a4, B:39:0x00c1, B:36:0x00ba, B:33:0x00b3), top: B:45:0x009e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd A[DONT_INVERT, PHI: r3
  0x00bd: PHI (r3v10 android.graphics.Bitmap) = (r3v8 android.graphics.Bitmap), (r3v8 android.graphics.Bitmap), (r3v9 android.graphics.Bitmap) binds: [B:32:0x00b1, B:36:0x00ba, B:34:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean a(IWebview iWebview, String[] strArr, IApp iApp, String str) {
        String str2;
        boolean zOptBoolean;
        String str3;
        boolean z;
        String str4;
        String str5;
        boolean zOptBoolean2;
        String str6;
        String str7;
        Bitmap bitmapDecodeFile;
        String str8 = strArr[0];
        String str9 = strArr[1];
        String strOptString = "";
        String strOptString2 = StringUtil.format(iWebview.getContext().getString(R.string.dcloud_short_cut_created), iApp.obtainAppName());
        JSONObject jSONObjectOptJSONObject = null;
        try {
            JSONObject jSONObject = new JSONObject(str8);
            zOptBoolean = jSONObject.optBoolean(AbsoluteConst.INSTALL_OPTIONS_FORCE, true);
            if (zOptBoolean) {
                try {
                    strOptString2 = strOptString2 + iWebview.getActivity().getString(R.string.dcloud_short_cut_created_removed_manually);
                } catch (JSONException e) {
                    e = e;
                    str2 = strOptString2;
                    str3 = strOptString;
                    e.printStackTrace();
                    z = zOptBoolean;
                    str4 = str3;
                    str5 = strOptString;
                    zOptBoolean2 = true;
                    str6 = strOptString;
                    str7 = str2;
                    bitmapDecodeFile = TextUtils.isEmpty(str5) ? null : BitmapFactory.decodeFile(iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str5));
                    if (bitmapDecodeFile == null) {
                        try {
                            bitmapDecodeFile = a(iApp);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (bitmapDecodeFile == null) {
                            bitmapDecodeFile = BitmapFactory.decodeResource(iWebview.getContext().getResources(), PdrR.DRAWABLE_ICON);
                        }
                    } else if (bitmapDecodeFile == null) {
                        bitmapDecodeFile = BitmapFactory.decodeResource(iWebview.getContext().getResources(), PdrR.DRAWABLE_ICON);
                    }
                    a(iWebview, str6, bitmapDecodeFile, str4, str7, jSONObjectOptJSONObject, z, zOptBoolean2, str9);
                    return false;
                }
            }
            String strOptString3 = jSONObject.optString("name");
            try {
                strOptString = jSONObject.optString(AbsoluteConst.JSON_KEY_ICON);
                try {
                    strOptString = jSONObject.optString("classname");
                    if (jSONObject.has("toast")) {
                        strOptString2 = jSONObject.optString("toast");
                    }
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        z = zOptBoolean;
                        zOptBoolean2 = jSONObject.optBoolean("check", true);
                        str6 = strOptString3;
                        str5 = strOptString;
                        str4 = strOptString;
                        str7 = strOptString2;
                    } catch (JSONException e3) {
                        e = e3;
                        str2 = strOptString2;
                        str3 = strOptString;
                        strOptString = strOptString3;
                        e.printStackTrace();
                        z = zOptBoolean;
                        str4 = str3;
                        str5 = strOptString;
                        zOptBoolean2 = true;
                        str6 = strOptString;
                        str7 = str2;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str2 = strOptString2;
                    jSONObjectOptJSONObject = null;
                }
            } catch (JSONException e5) {
                e = e5;
                strOptString = "";
                str2 = strOptString2;
                jSONObjectOptJSONObject = null;
                str3 = strOptString;
            }
        } catch (JSONException e6) {
            e = e6;
            str2 = strOptString2;
            zOptBoolean = true;
        }
        try {
            if (TextUtils.isEmpty(str5)) {
            }
            if (bitmapDecodeFile == null) {
                bitmapDecodeFile = a(iApp);
                if (bitmapDecodeFile == null && bitmapDecodeFile == null) {
                    bitmapDecodeFile = BitmapFactory.decodeResource(iWebview.getContext().getResources(), PdrR.DRAWABLE_ICON);
                }
            } else if (bitmapDecodeFile == null) {
                bitmapDecodeFile = BitmapFactory.decodeResource(iWebview.getContext().getResources(), PdrR.DRAWABLE_ICON);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        a(iWebview, str6, bitmapDecodeFile, str4, str7, jSONObjectOptJSONObject, z, zOptBoolean2, str9);
        return false;
    }

    private String b(IApp iApp) {
        Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        return intentObtainWebAppIntent != null ? intentObtainWebAppIntent.getStringExtra(IntentConst.WEBAPP_ACTIVITY_APPICON) : "";
    }

    private void a(Context context, IWebview iWebview, String str, String str2) {
        MessageHandler.postDelayed(new c(context, str2, iWebview, str), Build.VERSION.SDK_INT >= 25 ? 1500 : 500);
    }

    private Bitmap a(IApp iApp) {
        String strB = b(iApp);
        if (strB != null) {
            return BitmapFactory.decodeFile(strB);
        }
        return null;
    }

    private void a(IWebview iWebview, String str, Bitmap bitmap, String str2, String str3, JSONObject jSONObject, boolean z, boolean z2, String str4) {
        String str5;
        Intent intentObtainWebAppIntent;
        IApp iAppObtainApp = iWebview.obtainApp();
        String strObtainAppId = iAppObtainApp.obtainAppId();
        Activity activity = iWebview.getActivity();
        SharedPreferences orCreateBundle = SP.getOrCreateBundle(iWebview.getContext(), "pdr");
        if (PdrUtil.isEmpty(str)) {
            str = iAppObtainApp.obtainAppName();
        }
        boolean z3 = orCreateBundle.getBoolean(strObtainAppId + SP.K_CREATED_SHORTCUT, false);
        if (TextUtils.isEmpty(str2) && (intentObtainWebAppIntent = iWebview.obtainApp().obtainWebAppIntent()) != null) {
            str2 = intentObtainWebAppIntent.getStringExtra(IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME);
        }
        String str6 = str2;
        if (Build.VERSION.SDK_INT >= 25) {
            if (!ShortCutUtil.hasShortcut(activity, str) || z) {
                str5 = str;
                if (ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !TextUtils.isEmpty(str3)) {
                    ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) str3, 1).show();
                }
            } else {
                str5 = str;
            }
        } else {
            str5 = str;
            if (ShortcutCreateUtil.isDuplicateLauncher(activity)) {
                if (ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !TextUtils.isEmpty(str3) && ShortcutCreateUtil.needToast(activity)) {
                    ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) str3, 1).show();
                }
            } else if (!ShortCutUtil.hasShortcut(activity, str5)) {
                if (z) {
                    if (!TextUtils.isEmpty(str3) && ShortcutCreateUtil.needToast(activity)) {
                        ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) str3, 1).show();
                    }
                    ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true);
                } else {
                    if (z3) {
                        return;
                    }
                    if (ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !TextUtils.isEmpty(str3) && ShortcutCreateUtil.needToast(activity)) {
                        ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) str3, 1).show();
                    }
                }
            }
        }
        a(iWebview.getContext(), iWebview, str4, str5);
    }
}
