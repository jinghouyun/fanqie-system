package io.dcloud.p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.WebAppActivity;
import io.dcloud.common.DHInterface.IActivityHandler;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IBoot;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IConfusionMgr;
import io.dcloud.common.DHInterface.IDCloudWebviewClientListener;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.IOnCreateSplashView;
import io.dcloud.common.DHInterface.IPdrModule;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebviewStateListener;
import io.dcloud.common.DHInterface.ReceiveSystemEventVoucher;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.io.UnicodeInputStream;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.adapter.ui.webview.WebViewFactory;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.MobilePhoneModel;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.constant.IntentConst;
import io.dcloud.common.core.permission.PermissionControler;
import io.dcloud.common.ui.PrivacyManager;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.AppStatus;
import io.dcloud.common.util.AppStatusBarManager;
import io.dcloud.common.util.AppStreamUtil;
import io.dcloud.common.util.Base64;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.CreateShortResultReceiver;
import io.dcloud.common.util.IOUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.LoadAppUtils;
import io.dcloud.common.util.Md5Utils;
import io.dcloud.common.util.NetworkTypeUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.TestUtil;
import io.dcloud.common.util.ThreadPool;
import io.dcloud.common.util.XmlUtil;
import io.dcloud.common.util.Zip4JUtil;
import io.dcloud.common.util.ZipUtils;
import io.dcloud.feature.gg.dcloud.ADSim;
import io.dcloud.feature.internal.sdk.SDK;
import io.src.dcloud.adapter.DCloudAdapterUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
class d5 extends e5 implements IApp, ISysEventListener {
    public static String H1 = "webapp";
    ArrayList B0;
    private String R0;
    private String f0;
    private String g0;
    private String h0;
    private String i0;
    f5 s;
    private IConfusionMgr t1;
    private String u1;
    r y;
    BaseInfo.BaseAppInfo t = null;
    byte u = 1;
    boolean v = false;
    boolean w = false;
    boolean x = false;
    String z = null;
    String A = "";
    String B = "";
    String C = "";
    String D = null;
    String E = "";
    String F = null;
    String G = null;
    String H = null;
    String I = null;
    String J = null;
    String K = null;
    String L = null;
    boolean M = true;
    boolean N = true;
    boolean O = true;
    boolean P = false;
    boolean Q = true;
    boolean R = true;
    boolean S = false;
    private String T = null;
    boolean U = false;
    private byte V = 1;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = true;
    private boolean Z = true;
    private int a0 = ADSim.INTISPLSH;
    private int b0 = 0;
    private int c0 = 0;
    private String d0 = null;
    private String e0 = null;
    boolean j0 = false;
    private String k0 = null;
    String l0 = null;
    String m0 = null;
    String n0 = null;
    boolean o0 = false;
    String p0 = "accept";
    String q0 = "file:///android_asset/data/dcloud_error.html";
    String r0 = null;
    private String s0 = null;
    String t0 = null;
    private String u0 = "-1";
    private JSONObject v0 = null;
    private String w0 = "";
    private boolean x0 = true;
    private boolean y0 = false;
    private String z0 = AbsoluteConst.UNI_V3;
    private String A0 = "fast";
    HashMap C0 = null;
    JSONObject D0 = null;
    JSONObject E0 = null;
    JSONObject F0 = null;
    JSONObject G0 = null;
    JSONObject H0 = null;
    JSONObject I0 = null;
    JSONObject J0 = null;
    JSONObject K0 = null;
    JSONObject L0 = null;
    String M0 = null;
    String N0 = null;
    Intent O0 = null;
    IApp.IAppStatusListener P0 = null;
    String Q0 = null;
    private String S0 = "none";
    boolean T0 = false;
    private boolean U0 = false;
    private boolean V0 = false;
    private String W0 = "default";
    private String X0 = null;
    private String Y0 = null;
    private String Z0 = null;
    private String a1 = "";
    protected boolean b1 = false;
    private boolean c1 = false;
    private boolean d1 = false;
    private String e1 = null;
    private String f1 = null;
    private boolean g1 = false;
    long h1 = 0;
    boolean i1 = true;
    boolean j1 = false;
    boolean k1 = false;
    ArrayList l1 = new ArrayList();
    ArrayList m1 = new ArrayList();
    String n1 = null;
    String o1 = null;
    private String p1 = "";
    private boolean q1 = false;
    private String r1 = null;
    private int s1 = 1;
    IWebviewStateListener v1 = null;
    boolean w1 = false;
    JSONObject x1 = null;
    private boolean y1 = false;
    private String z1 = "none";
    private String A1 = AbsoluteConst.INSTALL_OPTIONS_FORCE;
    private String B1 = null;
    private String C1 = null;
    boolean D1 = true;
    HashMap E1 = null;
    String F1 = null;
    boolean G1 = false;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DHFile.deleteFile(BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DHFile.deleteFile(BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
                DHFile.deleteFile(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements Runnable {
        final /* synthetic */ ICallBack a;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        class a implements MessageHandler.IMessages {
            a() {
            }

            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(Object obj) {
                c.this.a.onCallBack(0, null);
            }
        }

        c(ICallBack iCallBack) {
            this.a = iCallBack;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = BaseInfo.sCacheFsAppsPath + d5.this.o + DeviceInfo.sSeparatorChar + BaseInfo.APP_WWW_FS_DIR;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Logger.d(d5.H1, d5.this.o + " copy resoure begin!!!");
            DHFile.delete(str);
            DHFile.copyDir(d5.this.k0, str);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Logger.d(d5.H1, d5.this.o + " copy resoure end!!! useTime=" + (jCurrentTimeMillis2 - jCurrentTimeMillis));
            d5.this.V = (byte) 0;
            d5.this.setAppDataPath(str);
            d5 d5Var = d5.this;
            BaseInfo.BaseAppInfo baseAppInfo = d5Var.t;
            if (baseAppInfo != null) {
                baseAppInfo.saveToBundleData(d5Var.getActivity());
            }
            MessageHandler.sendMessage(new a(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TestUtil.PointTime.commitTid(d5.this.getActivity(), this.a, null, d5.this.N0, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DHFile.deleteFile(d5.this.obtainAppTempPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IApp.ConfigProperty.ThridInfo.values().length];
            a = iArr;
            try {
                iArr[IApp.ConfigProperty.ThridInfo.OverrideUrlJsonData.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.OverrideResourceJsonData.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.TitleNViewJsonData.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.SitemapJsonData.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.URDJsonData.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.DirectPageJsonData.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[IApp.ConfigProperty.ThridInfo.Tabbar.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    d5(r rVar, String str, byte b2) {
        this.s = null;
        this.y = null;
        this.B0 = null;
        this.y = rVar;
        this.o = str;
        b(b2);
        this.t1 = i0.c();
        this.s = new f5();
        this.B0 = new ArrayList(2);
        this.q = AppRuntime.isUniApp(str);
    }

    private void d() {
    }

    private void e() {
        JSONObject jSONObject = this.K0;
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("webviewid");
                if (TextUtils.isEmpty(strOptString)) {
                    this.K0.put("webviewid", IntentConst.DIRECT_PAGE);
                }
                if (this.o.equals(strOptString)) {
                    this.J0 = this.K0.optJSONObject("titleNView");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = this.K0.has("titleNView") ? this.K0.optJSONObject("titleNView") : null;
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    this.K0.put("titleNView", jSONObjectOptJSONObject);
                }
                jSONObjectOptJSONObject.put("autoBackButton", true);
                if (jSONObjectOptJSONObject.has("homeButton")) {
                    return;
                }
                jSONObjectOptJSONObject.put("homeButton", true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean e(String str) {
        return false;
    }

    private void f() {
        try {
            int iRename = DHFile.rename(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/", BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
            DHFile.copyDir("data/wap2app", BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
            if (iRename == 1) {
                ThreadPool.self().addThreadTask(new a());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private JSONObject h() {
        JSONObject jSONObjectA = null;
        try {
            InputStream inputStreamObtainResInStream = obtainResInStream("_www/__template.json");
            if (inputStreamObtainResInStream == null) {
                return null;
            }
            jSONObjectA = a(inputStreamObtainResInStream);
            IOUtil.close(inputStreamObtainResInStream);
            return jSONObjectA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObjectA;
        }
    }

    private JSONObject i() {
        ThreadPool threadPoolSelf;
        b bVar;
        JSONObject jSONObject = null;
        try {
            boolean z = true;
            boolean z2 = false;
            if (BaseInfo.sCoverApkRuning) {
                if (new File(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").exists()) {
                    InputStream inputStream = PlatformUtil.getInputStream(BaseInfo.sBaseConfigTemplatePath);
                    JSONObject jSONObjectA = a(inputStream);
                    String strOptString = jSONObjectA.optString("version");
                    IOUtil.close(inputStream);
                    InputStream inputStream2 = DHFile.getInputStream(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
                    JSONObject jSONObjectA2 = a(inputStream2);
                    String strOptString2 = jSONObjectA2.optString("version");
                    IOUtil.close(inputStream2);
                    BaseInfo.mWap2appTemplateFiles.clear();
                    BaseInfo.mW2AE.clear();
                    if (BaseInfo.BaseAppInfo.compareVersion(strOptString, strOptString2)) {
                        f();
                        jSONObject = jSONObjectA;
                        z2 = true;
                    } else {
                        jSONObject = jSONObjectA2;
                    }
                }
            }
            if (DHFile.isExist(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip")) {
                DHFile.rename(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/", BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
                try {
                    try {
                        ZipUtils.upZipFile(new File(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip"), BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
                        threadPoolSelf = ThreadPool.self();
                        bVar = new b();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        threadPoolSelf = ThreadPool.self();
                        bVar = new b();
                        z = z2;
                    }
                    threadPoolSelf.addThreadTask(bVar);
                } catch (Throwable th) {
                    ThreadPool.self().addThreadTask(new b());
                    throw th;
                }
            } else {
                if (new File(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").exists()) {
                    z = z2;
                } else {
                    f();
                }
            }
            if (!z && !TextUtils.isEmpty(BaseInfo.sWap2AppTemplateVersion) && BaseInfo.mWap2appTemplateFiles.size() != 0 && this.t1.getData("__w2a__template__") != null) {
                return jSONObject;
            }
            if (!DHFile.isExist(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json")) {
                return jSONObject;
            }
            InputStream inputStream3 = DHFile.getInputStream(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
            JSONObject jSONObjectA3 = a(inputStream3);
            IOUtil.close(inputStream3);
            BaseInfo.mWap2appTemplateFiles.clear();
            BaseInfo.mW2AE.clear();
            this.t1.removeData("__w2a__template__");
            return jSONObjectA3;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }

    private void l() {
        String[] strArrSplit;
        this.E1 = new HashMap();
        String string = SP.getOrCreateBundle(getActivity(), this.o + "_1").getString("Authorize", null);
        this.F1 = string;
        if (string == null || (strArrSplit = string.split("&")) == null || strArrSplit.length <= 0) {
            return;
        }
        for (String str : strArrSplit) {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit2 = str.split("=");
                this.E1.put(strArrSplit2[0], Integer.valueOf(Integer.parseInt(strArrSplit2[1])));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    private void x() {
        boolean z;
        if (BaseInfo.isWap2AppAppid(this.o)) {
            JSONObject jSONObjectI = i();
            String strOptString = jSONObjectI == null ? BaseInfo.sWap2AppTemplateVersion : jSONObjectI.optString("version");
            try {
                JSONObject jSONObjectH = h();
                if (jSONObjectH != null) {
                    String strOptString2 = jSONObjectH.optString("version");
                    if (TextUtils.isEmpty(strOptString2) || !BaseInfo.BaseAppInfo.compareVersion(strOptString2, strOptString)) {
                        z = false;
                    } else {
                        DHFile.deleteFile(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
                        BaseInfo.mWap2appTemplateFiles.clear();
                        BaseInfo.mW2AE.clear();
                        strOptString = strOptString2;
                        jSONObjectI = jSONObjectH;
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (BaseInfo.mWap2appTemplateFiles.size() == 0) {
                    if (jSONObjectI == null || !jSONObjectI.has("files")) {
                        String[] list = new File(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/").list();
                        if (list != null) {
                            for (String str : list) {
                                BaseInfo.mWap2appTemplateFiles.add(str);
                            }
                        }
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObjectI.optJSONArray("files");
                        int length = jSONArrayOptJSONArray.length();
                        boolean z2 = obtainRunningAppMode() == 1;
                        for (int i = 0; i < length; i++) {
                            String strOptString3 = jSONArrayOptJSONArray.optString(i);
                            BaseInfo.mWap2appTemplateFiles.add(strOptString3);
                            if (z) {
                                if (z2) {
                                    DHFile.copyAssetsFile(BaseInfo.sBaseResAppsPath + this.o + "/www/" + strOptString3, BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/" + strOptString3);
                                } else {
                                    DHFile.copyFile(BaseInfo.sCacheFsAppsPath + this.o + "/www/" + strOptString3, BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/" + strOptString3, true, false);
                                }
                            }
                        }
                        if (z && !BaseInfo.mWap2appTemplateFiles.contains("__template.json")) {
                            if (z2) {
                                DHFile.copyAssetsFile(BaseInfo.sBaseResAppsPath + this.o + "/www/__template.json", BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
                            } else {
                                DHFile.copyFile(BaseInfo.sCacheFsAppsPath + this.o + "/www/__template.json", BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json", true, false);
                            }
                        }
                    }
                }
                if ((z || this.t1.getData("__w2a__template__") == null) && jSONObjectI != null && jSONObjectI.has(IApp.ConfigProperty.CONFIG_CONFUSION)) {
                    byte[] bArrDecode2bytes = Base64.decode2bytes(jSONObjectI.optString(IApp.ConfigProperty.CONFIG_CONFUSION));
                    Context activity = getActivity();
                    if (activity == null) {
                        activity = DeviceInfo.sApplicationContext;
                    }
                    String strHandleEncryption = this.t1.handleEncryption(activity, bArrDecode2bytes);
                    if (PdrUtil.isEmpty(strHandleEncryption)) {
                        strHandleEncryption = "{}";
                    }
                    this.t1.removeData("__w2a__template__");
                    this.t1.recordEncryptionResources("__w2a__template__", new JSONObject(strHandleEncryption));
                }
                BaseInfo.sTemplateModifyTime = new File(BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").lastModified();
                BaseInfo.sWap2AppTemplateVersion = strOptString;
                this.D = strOptString;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void addAllFeaturePermission() {
        PermissionControler.registerRootPermission(this.o);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void addFeaturePermission(String str) {
        this.B0.add(str.toLowerCase(Locale.ENGLISH));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void applyMani() {
        try {
            a(DHFile.getInputStream(DHFile.createFileHandler(a(BaseInfo.sConfigXML))), this.o, null);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void applySmartUpdate() {
        a(false);
    }

    void b(InputStream inputStream) {
    }

    boolean b(String str, JSONObject jSONObject) {
        boolean z;
        HashMap<String, BaseInfo.BaseAppInfo> map;
        InputStream inputStream = null;
        try {
            this.o = str;
            this.t1.removeData(str);
            k();
            if (this.V == 0 || !((map = BaseInfo.mBaseAppInfoSet) == null || map.containsKey(this.o))) {
                inputStream = DHFile.getInputStream(DHFile.createFileHandler(a(BaseInfo.sConfigXML)));
                if (inputStream == null && (inputStream = PlatformUtil.getResInputStream(a(BaseInfo.sConfigXML))) != null) {
                    this.V = (byte) 1;
                }
            } else if (this.V == 1) {
                inputStream = PlatformUtil.getResInputStream(a(BaseInfo.sConfigXML));
            }
            if (BaseInfo.isWap2AppAppid(this.o)) {
                x();
                z = false;
            } else {
                z = true;
            }
            if (inputStream == null) {
                if (BaseInfo.isWap2AppAppid(this.o) && !TextUtils.isEmpty(this.n1)) {
                    return true;
                }
                if (q() && !TextUtils.isEmpty(this.r0)) {
                    return true;
                }
                f5 f5Var = this.s;
                f5Var.a = true;
                if (f5Var.c) {
                    f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST, DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST);
                } else {
                    f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGT_MANIFEST_NOT_EXIST, DOMException.MSG_RUNTIME_WGT_MANIFEST_NOT_EXIST);
                }
                return false;
            }
            boolean zA = a(inputStream, str, jSONObject);
            if (z) {
                x();
            }
            f5 f5Var2 = this.s;
            if (f5Var2 != null && f5Var2.a) {
                Logger.i("WebApp", "InstallError---msg=" + this.s.b);
            }
            IActivityHandler iActivityHandler = DCloudAdapterUtil.getIActivityHandler(getActivity());
            if (iActivityHandler != null) {
                iActivityHandler.updateSplash(this.t0);
            }
            this.v = true;
            return zA;
        } catch (Exception e2) {
            Logger.w("parseConfig", e2);
            return false;
        } finally {
            IOUtil.close((InputStream) null);
        }
    }

    void c() {
        Activity activity = this.a;
        if (activity != null && (activity instanceof WebAppActivity)) {
            ((WebAppActivity) activity).onAppActive(this.o);
            ((WebAppActivity) this.a).onAppActive(this);
        }
        diyStatusBarState();
        setStatus((byte) 3);
        this.b.onAppActive(this);
        callSysEventListener(ISysEventListener.SysEventType.onWebAppForeground, IntentConst.obtainArgs(obtainWebAppIntent(), this.o));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean callSysEventListener(ISysEventListener.SysEventType sysEventType, Object obj) {
        HashMap map = this.C0;
        boolean zOnExecute = false;
        if (map == null) {
            return false;
        }
        ArrayList arrayList = (ArrayList) map.get(sysEventType);
        ArrayList arrayList2 = (ArrayList) this.C0.get(ISysEventListener.SysEventType.AllSystemEvent);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList3.addAll(arrayList2);
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            ISysEventListener iSysEventListener = (ISysEventListener) arrayList3.get(size);
            if (a(iSysEventListener, sysEventType) && (zOnExecute || iSysEventListener.onExecute(sysEventType, obj)) && !a(sysEventType)) {
                return zOnExecute;
            }
        }
        return zOnExecute;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkIsCustomPath() {
        return this.o0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void checkOrLoadlaunchWebview() {
        r rVar = this.y;
        if (rVar != null) {
            AdaFrameView adaFrameView = (AdaFrameView) rVar.processEvent(IMgr.MgrType.WindowMgr, 46, obtainAppId());
            Logger.d("Direct_page", "checkOrLoadlaunchWebview " + manifestBeParsed() + ";adaFrameView=" + adaFrameView);
            this.w1 = manifestBeParsed() ^ true;
            if (adaFrameView == null || !manifestBeParsed()) {
                return;
            }
            adaFrameView.obtainWebView().checkIfNeedLoadOriginalUrl();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkPrivateDir(String str) {
        return str.startsWith(obtainAppDataPath()) || str.startsWith(BaseInfo.REL_PRIVATE_WWW_DIR);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String checkPrivateDirAndCopy2Temp(String str) {
        if (obtainRunningAppMode() == 1 && checkPrivateDir(str)) {
            String str2 = "/" + BaseInfo.APP_WWW_FS_DIR;
            String strSubstring = str.substring(str.indexOf(str2) + str2.length());
            String str3 = this.k0 + strSubstring;
            str = obtainAppTempPath() + strSubstring;
            if (!DHFile.exists(str)) {
                DHFile.copyAssetsFile(str3, str);
            }
        }
        return str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkSchemeWhite(String str) {
        if (!q()) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = this.m1;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                String str2 = (String) obj;
                if (!TextUtils.equals(str2, "*")) {
                    if (str.startsWith(str2 + ":")) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkWhiteUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.l1.contains("*") || this.l1.contains(str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void clearRuntimeArgs() {
        this.E = "";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String convert2AbsFullPath(String str, String str2) {
        boolean z = true;
        try {
            if (PdrUtil.isEmpty(str2) || ((this.V != 1 || !PlatformUtil.isResFileExists(str2)) && !DHFile.isExist(str2))) {
                if (!PdrUtil.isEmpty(str2)) {
                    int iIndexOf = str2.indexOf(Operators.CONDITION_IF_STRING);
                    if (iIndexOf > 0) {
                        str2 = str2.substring(0, iIndexOf);
                    }
                    if (str2.startsWith("_documents/")) {
                        return BaseInfo.sDocumentFullPath + str2.substring(11);
                    }
                    if (str2.startsWith(BaseInfo.REL_PUBLIC_DOCUMENTS_DIR)) {
                        return BaseInfo.sDocumentFullPath + str2.substring(10);
                    }
                    if (str2.startsWith(AbsoluteConst.MINI_SERVER_APP_DOC)) {
                        return obtainAppDocPath() + str2.substring(5);
                    }
                    if (str2.startsWith(BaseInfo.REL_PRIVATE_DOC_DIR)) {
                        return obtainAppDocPath() + str2.substring(4);
                    }
                    if (str2.startsWith("_downloads/")) {
                        return BaseInfo.sDownloadFullPath + str2.substring(11);
                    }
                    if (str2.startsWith(BaseInfo.REL_PUBLIC_DOWNLOADS_DIR)) {
                        return BaseInfo.sDownloadFullPath + str2.substring(10);
                    }
                    if (str2.startsWith(AbsoluteConst.MINI_SERVER_APP_WWW)) {
                        byte b2 = this.V;
                        if (b2 != 1) {
                            if (b2 != 0) {
                                return str2;
                            }
                            return this.k0 + str2.substring(5);
                        }
                        return BaseInfo.sBaseResAppsPath + this.o + "/" + BaseInfo.APP_WWW_FS_DIR + str2.substring(5);
                    }
                    if (str2.startsWith(BaseInfo.REL_PRIVATE_WWW_DIR)) {
                        byte b3 = this.V;
                        if (b3 != 1) {
                            if (b3 != 0) {
                                return str2;
                            }
                            return this.k0 + str2.substring(4);
                        }
                        return BaseInfo.sBaseResAppsPath + this.o + "/" + BaseInfo.APP_WWW_FS_DIR + str2.substring(4);
                    }
                    if (str2.startsWith(DeviceInfo.FILE_PROTOCOL)) {
                        return str2.substring(7);
                    }
                    if (str2.startsWith("content://") || str2.startsWith(DeviceInfo.sDeviceRootDir)) {
                        return str2;
                    }
                    if (str2.startsWith("http://localhost")) {
                        String strSubstring = str2.substring(16);
                        return convert2AbsFullPath(null, strSubstring.substring(strSubstring.indexOf("/") + 1));
                    }
                    if (!str2.startsWith("/") && str != null) {
                        z = false;
                    } else if (str2.startsWith("/")) {
                        str2 = str2.substring(1);
                    }
                    if (str != null) {
                        if (str.startsWith(SDK.ANDROID_ASSET)) {
                            str = str.substring(22);
                        } else if (str.startsWith(DeviceInfo.FILE_PROTOCOL)) {
                            str = str.substring(7);
                        }
                    }
                    if (str != null && !z) {
                        return PdrUtil.standardizedURL(str, str2);
                    }
                    if (!z) {
                        return str2;
                    }
                    String strObtainAppDataPath = obtainAppDataPath();
                    if (str != null && !PdrUtil.isEquals(str, strObtainAppDataPath) && str.contains("/www/")) {
                        strObtainAppDataPath = str.substring(0, str.indexOf("/www/") + 5);
                    }
                    return strObtainAppDataPath + b(str2);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String convert2LocalFullPath(String str, String str2) throws Throwable {
        String strConvert2AbsFullPath = convert2AbsFullPath(str, str2);
        byte b2 = this.V;
        if (b2 == 1 || DeviceInfo.isPrivateDirectory) {
            InputStream resInputStream = b2 == 1 ? PlatformUtil.getResInputStream(strConvert2AbsFullPath) : PlatformUtil.getInputStream(strConvert2AbsFullPath);
            if (resInputStream != null) {
                strConvert2AbsFullPath = obtainAppTempPath() + System.currentTimeMillis();
                try {
                    DHFile.writeFile(resInputStream, strConvert2AbsFullPath);
                    resInputStream.close();
                    return strConvert2AbsFullPath;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return strConvert2AbsFullPath;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String convert2RelPath(String str) {
        try {
            int length = obtainAppDataPath().length();
            int length2 = obtainAppDocPath().length();
            int length3 = BaseInfo.sDocumentFullPath.length();
            int length4 = BaseInfo.sDownloadFullPath.length();
            if (str.startsWith(obtainAppDataPath())) {
                return BaseInfo.REL_PRIVATE_WWW_DIR + str.substring(length - 1);
            }
            int i = length - 1;
            if (str.startsWith(obtainAppDataPath().substring(0, i))) {
                return BaseInfo.REL_PRIVATE_WWW_DIR + str.substring(i, str.length());
            }
            if (str.startsWith(obtainAppDocPath())) {
                return BaseInfo.REL_PRIVATE_DOC_DIR + str.substring(length2 - 1);
            }
            int i2 = length2 - 1;
            if (str.startsWith(obtainAppDocPath().substring(0, i2))) {
                return BaseInfo.REL_PRIVATE_DOC_DIR + str.substring(i2);
            }
            if (str.startsWith(BaseInfo.sDocumentFullPath)) {
                return BaseInfo.REL_PUBLIC_DOCUMENTS_DIR + str.substring(length3 - 1);
            }
            int i3 = length3 - 1;
            if (str.startsWith(BaseInfo.sDocumentFullPath.substring(0, i3))) {
                return BaseInfo.REL_PUBLIC_DOCUMENTS_DIR + str.substring(i3);
            }
            if (str.startsWith(BaseInfo.sDownloadFullPath)) {
                return BaseInfo.REL_PUBLIC_DOWNLOADS_DIR + str.substring(length4 - 1);
            }
            int i4 = length4 - 1;
            if (!str.startsWith(BaseInfo.sDownloadFullPath.substring(0, i4))) {
                return str;
            }
            return BaseInfo.REL_PUBLIC_DOWNLOADS_DIR + str.substring(i4);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String convert2WebviewFullPath(String str, String str2) {
        boolean z;
        if (!PdrUtil.isEmpty(str2)) {
            if (this.U) {
                if (!str2.startsWith(DeviceInfo.HTTP_PROTOCOL)) {
                    return this.s0 + str2;
                }
            } else if (!str2.startsWith(DeviceInfo.FILE_PROTOCOL) && !str2.startsWith(DeviceInfo.HTTP_PROTOCOL) && !str2.startsWith(DeviceInfo.HTTPS_PROTOCOL)) {
                try {
                    if (DHFile.isExist(str2)) {
                        return "file:///" + b(str2);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (str2.startsWith(DeviceInfo.sDeviceRootDir)) {
                    return DeviceInfo.FILE_PROTOCOL + str2;
                }
                if (str2.startsWith("/")) {
                    z = true;
                    str2 = str2.substring(1);
                } else {
                    z = false;
                }
                if (str2.startsWith(BaseInfo.REL_PRIVATE_WWW_DIR)) {
                    return obtainWebviewBaseUrl() + b(str2.substring(4));
                }
                if (str2.startsWith(BaseInfo.REL_PUBLIC_DOCUMENTS_DIR)) {
                    return DeviceInfo.FILE_PROTOCOL + BaseInfo.sDocumentFullPath + b(str2.substring(10));
                }
                if (str2.startsWith(BaseInfo.REL_PRIVATE_DOC_DIR)) {
                    return DeviceInfo.FILE_PROTOCOL + obtainAppDocPath() + b(str2.substring(4));
                }
                if (str2.startsWith(BaseInfo.REL_PUBLIC_DOWNLOADS_DIR)) {
                    return DeviceInfo.FILE_PROTOCOL + BaseInfo.sDownloadFullPath + b(str2.substring(10));
                }
                if (str != null && !z) {
                    return PdrUtil.standardizedURL(str, str2);
                }
                String strObtainWebviewBaseUrl = obtainWebviewBaseUrl();
                if (str != null && !PdrUtil.isEquals(str, strObtainWebviewBaseUrl) && str.contains("/www/")) {
                    strObtainWebviewBaseUrl = str.substring(0, str.indexOf("/www/") + 5);
                }
                return strObtainWebviewBaseUrl + b(str2);
            }
        }
        return str2;
    }

    JSONObject d(String str) {
        if (this.x1 == null) {
            m();
        }
        if (this.x1 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return PdrUtil.getSitemapParameters(this.x1, obtainAppId(), str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void deleteAppTemp() {
        ThreadPool.self().addThreadTask(new e(), true);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void diyStatusBarState() {
        AppStatusBarManager appStatusBarManager = this.m;
        if (appStatusBarManager == null) {
            return;
        }
        if (this.i) {
            appStatusBarManager.setFullScreen(getActivity(), this.i);
        } else {
            if (appStatusBarManager.checkImmersedStatusBar(getActivity(), this.b1)) {
                BaseInfo.isImmersive = true;
                this.m.setImmersive(getActivity(), true);
            } else {
                BaseInfo.isImmersive = false;
                this.m.setImmersive(getActivity(), false);
            }
            if (getActivity() != null) {
                if (PdrUtil.isEmpty(this.X0)) {
                    this.m.setStatusBarColor(getActivity(), BaseInfo.mDeStatusBarBackground);
                } else {
                    this.m.setStatusBarColor(getActivity(), this.X0.startsWith("#") ? PdrUtil.stringToColor(this.X0) : 0);
                }
            }
            this.m.setStatusBarMode(getActivity(), this.a1);
        }
        if (this.m.isFullScreenOrImmersive()) {
            updateScreenInfo(2);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String forceShortCut() {
        return this.A1;
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
    boolean g(String str) {
        setRuntimeArgs(str);
        setStatus((byte) 3);
        Object objProcessEvent = this.y.processEvent(IMgr.MgrType.WindowMgr, 41, new Object[]{this, convert2WebviewFullPath(null, this.r0), Boolean.valueOf(this.T0)});
        if (objProcessEvent == null) {
            return true;
        }
        return Boolean.parseBoolean(String.valueOf(objProcessEvent));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public IConfusionMgr getConfusionMgr() {
        return this.t1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String getDirectPage() {
        return this.n1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public IApp.IAppStatusListener getIAppStatusListener() {
        return this.P0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String getOriginalDirectPage() {
        return this.o1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String getPathByType(byte b2) {
        if (b2 == 0) {
            return obtainAppDataPath();
        }
        if (b2 == 1) {
            return obtainAppDocPath();
        }
        if (b2 == 2) {
            return BaseInfo.sDocumentFullPath;
        }
        if (b2 == 3) {
            return BaseInfo.sDownloadFullPath;
        }
        if (b2 != -1) {
            return null;
        }
        return BaseInfo.sBaseResAppsPath + this.o + "/" + BaseInfo.APP_WWW_FS_DIR;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String getPopGesture() {
        return this.S0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public int getQuitModel() {
        return this.s1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String getSystemInfo() {
        try {
            if (DeviceInfo.sSystemInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(DeviceInfo.sSystemInfo.toString());
            jSONObject.put("uniCompileVersion", this.u0);
            jSONObject.put("uniRuntimeVersion", BaseInfo.uniVersionV3);
            jSONObject.put("browserName", WebViewFactory.isOther() ? "x5webview" : "chrome");
            jSONObject.put("appId", BaseInfo.sCurrentAppOriginalAppid);
            jSONObject.put(WXConfig.appName, this.t0);
            if (SDK.isUniMP) {
                jSONObject.put(WXConfig.appVersion, this.A);
                jSONObject.put("appVersionCode", this.B);
            } else {
                jSONObject.put(WXConfig.appVersion, b(getActivity()));
                jSONObject.put("appVersionCode", a((Context) getActivity()));
            }
            jSONObject.put("appWgtVersion", this.A);
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean isOnAppRunningMode() {
        return this.V == 1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean isUniApp() {
        return this.q;
    }

    public float j() {
        return (PermissionControler.checkPermission(this.o, IFeature.F_DEVICE.toLowerCase(Locale.ENGLISH)) && getActivity() != null && NetworkTypeUtil.getNetworkType(getActivity()) == 4) ? 1000.0f : 0.0f;
    }

    void k() {
        if (PdrUtil.isEmpty(this.k0) || !DeviceInfo.startsWithSdcard(this.k0)) {
            setAppDataPath(BaseInfo.sCacheFsAppsPath + this.o + "/" + BaseInfo.REAL_PRIVATE_WWW_DIR);
        }
        if (PdrUtil.isEmpty(this.B1) || !DeviceInfo.startsWithSdcard(this.B1)) {
            setAppDocPath(BaseInfo.sBaseFsAppsPath + this.o + "/" + BaseInfo.REAL_PRIVATE_DOC_DIR);
        }
        if (PdrUtil.isEmpty(this.C1) || !DeviceInfo.startsWithSdcard(this.C1)) {
            this.C1 = BaseInfo.sCacheFsAppsPath + this.o + "/" + BaseInfo.APP_WEB_CHACHE;
        }
    }

    void m() {
        File file = new File(c(this.o));
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(IOUtil.toString(new FileInputStream(file)));
                this.x1 = jSONObject;
                this.C = jSONObject.optString("version");
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        byte[] fileContent = PlatformUtil.getFileContent("data/sitemap/" + this.o + ".json", 0);
        if (fileContent != null) {
            DHFile.writeFile(fileContent, 0, c(this.o));
            m();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean manifestBeParsed() {
        return this.v || SDK.IntegratedMode.WEBVIEW == BaseInfo.sRuntimeMode;
    }

    public boolean n() {
        if (q() && this.v) {
            return this.P;
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean needRefreshApp() {
        return this.k1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean needReload() {
        return this.j1;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public boolean o() {
        String str;
        String strOptString = "";
        if (PdrUtil.isEmpty(BaseInfo.uniVersionV3)) {
            if (BaseInfo.SyncDebug) {
                str = (PlatformUtil.getResInputStream("uni-jsframework-dev.js") == null || SDK.isUniMPSDK()) ? "uni-jsframework.js" : "uni-jsframework-dev.js";
            }
            try {
                strOptString = new JSONObject(new BufferedReader(new InputStreamReader(getActivity().getAssets().open(str))).readLine().substring(2)).optString("version");
                BaseInfo.setUniVersionV3(strOptString, getActivity());
            } catch (IOException | JSONException unused) {
            }
        } else {
            strOptString = BaseInfo.uniVersionV3;
        }
        return ((!PdrUtil.isEmpty(this.w0) && this.w0.contains(strOptString) && !this.x0) || this.y0 || !this.v || this.u0.equals("-1") || this.u0.trim().equals(strOptString) || PdrUtil.isEmpty(strOptString) || !this.q) ? false : true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAdaptationJs() {
        if (this.T == null && !PdrUtil.isEmpty(this.K)) {
            byte[] fileContent = PlatformUtil.getFileContent(a(this.K), obtainRunningAppMode() == 1 ? 0 : 2);
            if (fileContent != null) {
                this.T = new String(fileContent);
            } else {
                this.T = "";
            }
        }
        return this.T;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppDataPath() {
        String str = this.k0;
        if (str != null) {
            return str;
        }
        return this.o + "/www/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppDocPath() {
        return this.B1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppId() {
        return this.o;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.o);
            jSONObject.put("versionName", this.A);
            jSONObject.put("name", this.t0);
            jSONObject.put("versionCode", this.B);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppLog() {
        return BaseInfo.sBaseFsAppsPath + this.o + "/log/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppName() {
        return this.t0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public byte obtainAppStatus() {
        return this.u;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppTempPath() {
        return BaseInfo.sBaseFsAppsPath + this.o + "/temp/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppVersionCode() {
        return this.B;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppVersionName() {
        return this.A;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAppWebCachePath() {
        return this.C1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainConfigProperty(String str) {
        if (PdrUtil.isEquals(str, "adid")) {
            return this.N0;
        }
        if (PdrUtil.isEquals(str, "launchError")) {
            return this.M0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
            return String.valueOf(this.Y);
        }
        if (PdrUtil.isEquals(str, "timeout")) {
            return String.valueOf(this.a0);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_DELAY)) {
            return String.valueOf(this.b0);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_SPLASHSCREEN)) {
            return String.valueOf(this.W);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_WAITING)) {
            return String.valueOf(this.X);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_H5PLUS)) {
            return String.valueOf(this.R);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_funSetUA)) {
            return String.valueOf(this.S);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_USER_AGENT)) {
            return this.L;
        }
        if (PdrUtil.isEquals(str, "error")) {
            return this.q0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
            return String.valueOf(this.i);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_UNTRUSTEDCA)) {
            return this.p0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_LOADED_TIME)) {
            return this.Q0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_RAM_CACHE_MODE)) {
            return this.R0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_JSERROR)) {
            return this.N + "";
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_CRASH)) {
            return this.M + "";
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_USE_ENCRYPTION)) {
            return this.U0 + "";
        }
        if (PdrUtil.isEquals(str, "w2a_delay")) {
            return String.valueOf(this.c0);
        }
        if (PdrUtil.isEquals(str, "w2a_autoclose")) {
            return String.valueOf(this.Z);
        }
        if (PdrUtil.isEquals(str, "wap2app_running_mode")) {
            return this.O + "";
        }
        if (PdrUtil.isEquals(str, "injection")) {
            return this.i1 + "";
        }
        if (PdrUtil.isEquals(str, "event")) {
            return this.d0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_TARGET)) {
            return this.e0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_LPLUSERQUIRE)) {
            return this.f0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_SPLUSERQUIRE)) {
            return this.g0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_LGEOLOCATION)) {
            return this.h0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_SGEOLOCATION)) {
            return this.i0;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_BC)) {
            return this.X0 + "";
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_MODE)) {
            return this.a1;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
            return this.b1 + "";
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)) {
            return String.valueOf(this.c1);
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR)) {
            return this.e1;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)) {
            return String.valueOf(this.d1);
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR)) {
            return this.f1;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_MAP_COORD_TYPE)) {
            return this.p1;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.UNIAPP_WEEX_JS_SERVICE)) {
            return String.valueOf(this.g1);
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.APP_UNIAPP_VERSION)) {
            return this.u0;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL)) {
            return this.q ? this.z0 : "h5+";
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.UNI_NVUE_DATA)) {
            JSONObject jSONObject = this.v0;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString();
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_CONCATENATE)) {
            return this.Q + "";
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.NVUE_LAUNCH_MODE)) {
            return this.A0;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
            return this.r1;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.UNI_RESTART_TO_DIRECT)) {
            return String.valueOf(this.q1);
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.APP_IS_UNIAPP)) {
            return String.valueOf(this.q);
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_USE_V3_ENCRYPTION)) {
            return String.valueOf(this.V0);
        }
        if (PdrUtil.isEquals(str, IntentConst.UNIMP_RUN_EXTRA_INFO)) {
            return this.u1;
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public IWebviewStateListener obtainLaunchPageStateListener() {
        return this.v1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public Object obtainMgrData(IMgr.MgrType mgrType, int i, Object[] objArr) {
        return this.y.processEvent(mgrType, i, objArr);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainOriginalAppId() {
        return this.z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public InputStream obtainResInStream(String str, String str2) {
        String strConvert2AbsFullPath = convert2AbsFullPath(str, str2);
        byte b2 = this.V;
        if (b2 == 1) {
            if (!PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                return PlatformUtil.getResInputStream(strConvert2AbsFullPath);
            }
            try {
                return DHFile.getInputStream(DHFile.createFileHandler(strConvert2AbsFullPath));
            } catch (IOException e2) {
                Logger.w("WebApp.obtainResInStream", e2);
                return null;
            }
        }
        if (b2 != 0) {
            return null;
        }
        try {
            return DHFile.getInputStream(DHFile.createFileHandler(strConvert2AbsFullPath));
        } catch (IOException e3) {
            Logger.w("WebApp.obtainResInStream", e3);
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public byte obtainRunningAppMode() {
        return this.V;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainRuntimeArgs(boolean z) {
        return z ? JSONObject.quote(this.E) : this.E;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public AppStatusBarManager obtainStatusBarMgr() {
        return this.m;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public JSONObject obtainThridInfo(IApp.ConfigProperty.ThridInfo thridInfo) {
        switch (f.a[thridInfo.ordinal()]) {
            case 1:
                return this.D0;
            case 2:
                return this.F0;
            case 3:
                return this.G0;
            case 4:
                return this.H0;
            case 5:
                return this.J0;
            case 6:
                m();
                return this.x1;
            case 7:
                return this.y.g;
            case 8:
                return this.K0;
            case 9:
                return this.E0;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainVersionSitemap() {
        return this.C;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public Intent obtainWebAppIntent() {
        return this.O0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainWebviewBaseUrl() {
        return a(this.V);
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
        byte b2 = this.u;
        if (b2 == 3) {
            return callSysEventListener(sysEventType, obj);
        }
        if (b2 == 1 && (sysEventType == ISysEventListener.SysEventType.onWebAppStop || sysEventType == ISysEventListener.SysEventType.onStop)) {
            s();
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void onSplashClosed() {
        diyStatusBarState();
    }

    public boolean p() {
        return this.u == 3;
    }

    public boolean q() {
        Intent intentObtainWebAppIntent = obtainWebAppIntent();
        if (intentObtainWebAppIntent != null) {
            boolean z = this.G1;
            this.G1 = intentObtainWebAppIntent.getBooleanExtra(IntentConst.IS_STREAM_APP, z) | z;
        }
        return this.G1;
    }

    public boolean r() {
        Logger.d(Logger.AppMgr_TAG, this.o + " onStop");
        IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            return iAppStatusListener.onStop();
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void registerSysEventListener(ISysEventListener iSysEventListener, ISysEventListener.SysEventType sysEventType) {
        if (this.C0 == null) {
            this.C0 = new HashMap(1);
        }
        ArrayList arrayList = (ArrayList) this.C0.get(sysEventType);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.C0.put(sysEventType, arrayList);
        }
        arrayList.add(iSysEventListener);
    }

    public void s() {
        this.l1.clear();
        this.m1.clear();
        Activity activity = this.a;
        if (activity != null && (activity instanceof WebAppActivity)) {
            ((WebAppActivity) activity).onAppStop(this.o);
        }
        Logger.d(Logger.AppMgr_TAG, "webapp.onStoped");
        BaseInfo.s_Runing_App_Count--;
        callSysEventListener(ISysEventListener.SysEventType.onWebAppStop, this);
        d();
        PermissionUtil.removeTempPermission(this.a, this.o);
        b();
        deleteAppTemp();
        PermissionControler.unregisterRootPermission(this.o);
        this.y.e(this);
        if (getIAppStatusListener() != null) {
            getIAppStatusListener().onStoped(false, null);
        }
        this.y.processEvent(IMgr.MgrType.WindowMgr, 25, this);
        PrivacyManager.getInstance().unRegisterPrivacyAgreeAllListener();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setAppDataPath(String str) {
        if (this.V == 1) {
            if (str.startsWith(BaseInfo.sBaseResAppsPath)) {
                this.k0 = str;
                return;
            }
            this.k0 = BaseInfo.sBaseResAppsPath + this.o + "/" + BaseInfo.APP_WWW_FS_DIR;
            return;
        }
        if (new File(str).exists()) {
            this.k0 = str;
            return;
        }
        if (str.startsWith(DeviceInfo.sCacheRootDir)) {
            this.k0 = str;
            return;
        }
        this.k0 = DeviceInfo.sCacheRootDir + "/" + str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setAppDocPath(String str) {
        this.B1 = PdrUtil.appendByDeviceRootDir(str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setConfigProperty(String str, String str2) {
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
            this.Y = PdrUtil.parseBoolean(str2, this.Y, false);
            return;
        }
        if (PdrUtil.isEquals(str, "commit")) {
            a();
            return;
        }
        if (PdrUtil.isEquals(str, "timeout")) {
            this.a0 = PdrUtil.parseInt(str2, this.a0);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_DELAY)) {
            this.b0 = PdrUtil.parseInt(str2, this.b0);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_SPLASHSCREEN)) {
            this.W = PdrUtil.parseBoolean(str2, this.W, false);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_WAITING)) {
            this.X = PdrUtil.parseBoolean(str2, this.X, false);
            return;
        }
        if (PdrUtil.isEquals(str, "name")) {
            this.t0 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "name")) {
            this.G = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "email")) {
            this.H = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "url")) {
            this.J = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "name")) {
            this.A = str2;
            BaseInfo.sLastAppVersionName = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "code")) {
            this.B = str2;
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE)) {
            this.j0 = PdrUtil.parseBoolean(str2, this.W, false);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_H5PLUS)) {
            this.R = PdrUtil.parseBoolean(str2, true, false);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_funSetUA)) {
            this.S = PdrUtil.parseBoolean(str2, true, false);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_USER_AGENT)) {
            this.L = str2;
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
            this.i = PdrUtil.parseBoolean(str2, this.i, false);
            return;
        }
        if (PdrUtil.isEquals(str, "webcache_path")) {
            this.C1 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, "wap2app_running_mode")) {
            this.O = PdrUtil.parseBoolean(str2, false, false);
            return;
        }
        if (PdrUtil.isEquals(str, IApp.ConfigProperty.CONFIG_LOADED_TIME)) {
            this.Q0 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_BC)) {
            this.X0 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_MODE)) {
            this.a1 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
            this.b1 = Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)) {
            this.c1 = Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR)) {
            this.e1 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)) {
            this.d1 = Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR)) {
            this.f1 = str2;
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.UNIAPP_WEEX_JS_SERVICE)) {
            this.g1 = Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (PdrUtil.isEquals(str, AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
            this.r1 = str2;
        } else if (PdrUtil.isEquals(str, IApp.ConfigProperty.UNI_RESTART_TO_DIRECT)) {
            this.q1 = Boolean.valueOf(str2).booleanValue();
        } else if (PdrUtil.isEquals(str, IntentConst.UNIMP_RUN_EXTRA_INFO)) {
            this.u1 = str2;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setDirectPage(String str) {
        this.n1 = str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setHideNavBarState(boolean z) {
        this.p = z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setIAppStatusListener(IApp.IAppStatusListener iAppStatusListener) {
        this.P0 = iAppStatusListener;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setLaunchPageStateListener(IWebviewStateListener iWebviewStateListener) {
        this.v1 = iWebviewStateListener;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setNeedRefreshApp(boolean z) {
        this.k1 = z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setQuitModel(int i) {
        this.s1 = i;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setRuntimeArgs(String str) {
        if (PdrUtil.isEmpty(str)) {
            return;
        }
        this.E = str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setStatus(byte b2) {
        this.u = b2;
        if (b2 == 3) {
            this.h1 = System.currentTimeMillis();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setWebAppActivity(Activity activity) {
        this.a = activity;
        a(activity);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x012a A[Catch: Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #6 {MalformedURLException -> 0x01cd, Exception -> 0x01cb, blocks: (B:48:0x011e, B:47:0x011b, B:53:0x012f, B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2, B:80:0x01c7, B:51:0x012a), top: B:110:0x0065, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0167 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0178 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0186 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01aa A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c2 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TRY_LEAVE, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @Override // io.dcloud.common.DHInterface.IApp
    public void setWebAppIntent(Intent intent) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        char c2;
        boolean booleanExtra = intent.getBooleanExtra(IntentConst.EXE_NEW_INTENT, true);
        char c3 = 0;
        if (booleanExtra || this.O0 == null) {
            this.O0 = new Intent(intent);
            if (TextUtils.isEmpty(this.t0)) {
                this.t0 = this.O0.getStringExtra(IntentConst.NAME);
            }
            String stringExtra = this.O0.getStringExtra(IntentConst.FIRST_WEB_URL);
            if (!TextUtils.equals(this.r0, "__no__")) {
                this.r0 = stringExtra;
            }
            String stringExtra2 = this.O0.getStringExtra(IntentConst.DIRECT_PAGE);
            if (!TextUtils.isEmpty(stringExtra2)) {
                try {
                    URL url = new URL(stringExtra2);
                    String query = url.getQuery();
                    try {
                        if (query != null) {
                            if (query.contains("webviewParameter") || query.contains("__html5plusWebviewParameter")) {
                                String str2 = query.contains("webviewParameter") ? "webviewParameter" : "__html5plusWebviewParameter";
                                this.n1 = url.getProtocol() + "://" + url.getHost() + url.getPath();
                                String[] strArrSplit = query.split("&");
                                if (strArrSplit != null) {
                                    int i = 0;
                                    boolean z = true;
                                    String strDecode = null;
                                    while (i < strArrSplit.length) {
                                        String[] strArrSplit2 = strArrSplit[i].split("=");
                                        if (str2.equals(strArrSplit2[c3])) {
                                            strDecode = URLDecoder.decode(strArrSplit2[1]);
                                        } else {
                                            if (z) {
                                                try {
                                                    StringBuilder sb = new StringBuilder();
                                                    c2 = 0;
                                                    try {
                                                        sb.append(this.n1);
                                                        sb.append(Operators.CONDITION_IF_STRING);
                                                        this.n1 = sb.toString();
                                                        z = false;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        e.printStackTrace();
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                }
                                            } else {
                                                c2 = 0;
                                                if (i < strArrSplit.length) {
                                                    this.n1 += "&";
                                                }
                                            }
                                            this.n1 += strArrSplit2[c2] + "=" + strArrSplit2[1];
                                        }
                                        i++;
                                        c3 = 0;
                                    }
                                    str = strDecode;
                                }
                            } else {
                                this.n1 = stringExtra2;
                            }
                            str = null;
                        } else {
                            this.n1 = stringExtra2;
                            str = null;
                        }
                        String str3 = this.n1;
                        this.o1 = str3;
                        this.O0.putExtra(IntentConst.DIRECT_PAGE, str3);
                        JSONObject jSONObjectD = d(this.n1);
                        this.K0 = jSONObjectD;
                        if (jSONObjectD == null) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    this.K0 = new JSONObject();
                                } else {
                                    this.K0 = new JSONObject(str);
                                }
                                if (this.o.equals(this.K0.optString("webviewid"))) {
                                    if (!new File(a(BaseInfo.sConfigXML)).exists()) {
                                        strOptString = this.K0.optString(IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
                                        if (TextUtils.isEmpty(strOptString)) {
                                            strOptString = this.n1;
                                        }
                                        this.m0 = strOptString;
                                    }
                                    if (this.K0.has(AbsoluteConst.JSONKEY_STATUSBAR) && (jSONObjectOptJSONObject = this.K0.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR)) != null && jSONObjectOptJSONObject.optBoolean(AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED, true)) {
                                        this.c1 = true;
                                        if (jSONObjectOptJSONObject.has("background")) {
                                            this.e1 = jSONObjectOptJSONObject.optString("background", this.X0);
                                        }
                                    }
                                    this.O0.removeExtra(IntentConst.DIRECT_PAGE);
                                    this.J0 = this.K0.optJSONObject("titleNView");
                                } else {
                                    e();
                                }
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        } else if (this.o.equals(this.K0.optString("webviewid"))) {
                            if (!new File(a(BaseInfo.sConfigXML)).exists()) {
                                strOptString = this.K0.optString(IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = this.n1;
                                }
                                this.m0 = strOptString;
                            }
                            if (this.K0.has(AbsoluteConst.JSONKEY_STATUSBAR)) {
                                this.c1 = true;
                                if (jSONObjectOptJSONObject.has("background")) {
                                    this.e1 = jSONObjectOptJSONObject.optString("background", this.X0);
                                }
                            }
                            this.O0.removeExtra(IntentConst.DIRECT_PAGE);
                            this.J0 = this.K0.optJSONObject("titleNView");
                        } else {
                            e();
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                        e.printStackTrace();
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e = e8;
                }
            }
        }
        if (q() && BaseInfo.isWap2AppAppid(this.o) && !booleanExtra && intent.getBooleanExtra(IntentConst.WEBAPP_ACTIVITY_JUST_DOWNLOAD, false) && this.D1) {
            this.y.processEvent(IMgr.MgrType.WindowMgr, 50, this);
            this.D1 = false;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String shortcutQuit() {
        return this.z1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.common.DHInterface.IApp
    public void showSplash() {
        Activity activity = getActivity();
        if (activity instanceof IOnCreateSplashView) {
            activity.setIntent(this.O0);
            ((IOnCreateSplashView) activity).onCreateSplash(activity);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean startFromShortCut() {
        return this.y1;
    }

    void t() {
        PermissionControler.registerPermission(this.o, this.B0);
    }

    public String toString() {
        return this.t0 + Operators.SUB + this.o + Operators.SUB + super.toString();
    }

    public void u() {
        b(false);
        setStatus((byte) 1);
        AppStatus.setAppStatus(this.o, 0);
        this.y.processEvent(IMgr.MgrType.FeatureMgr, 3, this.o);
        Logger.d(Logger.AppMgr_TAG, this.o + " will active change to unrunning");
        this.y.processEvent(null, 0, this);
        WebViewFactory.sUsePermissionWebviews.clear();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void unregisterSysEventListener(ISysEventListener iSysEventListener, ISysEventListener.SysEventType sysEventType) {
        ArrayList arrayList;
        HashMap map = this.C0;
        if (map == null || (arrayList = (ArrayList) map.get(sysEventType)) == null) {
            return;
        }
        arrayList.remove(iSysEventListener);
        if (arrayList.isEmpty()) {
            this.C0.remove(sysEventType);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void updateDirectPage(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.n1;
        }
        JSONObject jSONObjectD = d(str);
        if (jSONObjectD != null) {
            this.K0 = jSONObjectD;
            e();
            this.y.processEvent(IMgr.MgrType.WindowMgr, 48, this);
        }
    }

    public String v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.o);
            jSONObject.put("version", this.A);
            jSONObject.put("name", this.t0);
            jSONObject.put("versionCode", this.B);
            jSONObject.put("description", this.F);
            jSONObject.put("author", this.G);
            jSONObject.put("email", this.H);
            jSONObject.put(IApp.ConfigProperty.CONFIG_LICENSE, this.I);
            jSONObject.put("licensehref", this.J);
            jSONObject.put(IApp.ConfigProperty.CONFIG_FEATURES, new JSONArray((Collection) this.B0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    void w() {
        b(true);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String obtainAuthority(String str) {
        String str2 = BaseInfo.sGlobalAuthority;
        if ((str2 != null && TextUtils.equals("*", str2)) || !q() || TextUtils.isEmpty(str) || e(this.o)) {
            return IApp.AUTHORITY_AUTHORIZED;
        }
        JSONObject jSONObject = this.I0;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (str.equalsIgnoreCase(next)) {
                    return this.I0.optString(next, IApp.AUTHORITY_UNDETERMINED);
                }
            }
        }
        return IApp.AUTHORITY_UNDETERMINED;
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0380 A[PHI: r38
  0x0380: PHI (r38v4 org.json.JSONObject) = (r38v3 org.json.JSONObject), (r38v7 org.json.JSONObject), (r38v7 org.json.JSONObject) binds: [B:162:0x0377, B:157:0x0364, B:159:0x036a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:287:0x0656  */
    /* JADX WARN: Code duplicated, block: B:289:0x0673  */
    /* JADX WARN: Code duplicated, block: B:291:0x068e  */
    /* JADX WARN: Code duplicated, block: B:293:0x0696  */
    /* JADX WARN: Code duplicated, block: B:294:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:298:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:299:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:301:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:303:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:305:0x070e  */
    /* JADX WARN: Code duplicated, block: B:306:0x0726  */
    /* JADX WARN: Code duplicated, block: B:308:0x072e  */
    /* JADX WARN: Code duplicated, block: B:310:0x0742  */
    /* JADX WARN: Code duplicated, block: B:313:0x0768  */
    /* JADX WARN: Code duplicated, block: B:314:0x0784  */
    /* JADX WARN: Code duplicated, block: B:355:0x08ab  */
    /* JADX WARN: Instruction removed from duplicated block: B:289:0x0673, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:298:0x06c5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:303:0x06f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:305:0x070e, please report this as an issue */
    boolean a(InputStream inputStream, String str, JSONObject jSONObject) {
        String strHandleEncryption;
        boolean z;
        boolean z2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        boolean z3;
        String strOptString;
        JSONObject jSONObject5;
        String str10;
        boolean zIsEquals;
        JSONObject jSONObject6;
        boolean z4;
        boolean z5;
        String string;
        String str11;
        String str12;
        String str13;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        boolean z9;
        int i2;
        String string2;
        JSONObject jSONObjectOptJSONObject;
        String str14;
        String str15;
        boolean z10;
        boolean z11;
        boolean z12;
        JSONArray jSONArrayNames;
        boolean z13;
        JSONArray jSONArray;
        JSONObject jSONObject7;
        boolean z14;
        boolean z15;
        boolean z16;
        int i3;
        int i4;
        StringBuilder sb;
        int iJ;
        boolean z17;
        boolean z18;
        String strOptString2;
        JSONObject jSONObject8;
        StringBuilder sb2;
        JSONArray jSONArray2;
        int i5;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        String strOptString3;
        String str16;
        String str17;
        Context context;
        InputStream unicodeInputStream = inputStream;
        String str18 = str;
        this.j1 = false;
        f5 f5Var = this.s;
        boolean z19 = f5Var != null && f5Var.d;
        this.m1.addAll(AppStreamUtil.AppStreamSchemeWhiteDefaultList);
        Context activity = getActivity();
        if (activity == null) {
            activity = DeviceInfo.sApplicationContext;
        }
        if (unicodeInputStream != null) {
            try {
                if (!this.q) {
                    unicodeInputStream = new UnicodeInputStream(unicodeInputStream, Charset.defaultCharset().name());
                }
                byte[] bytes = IOUtil.getBytes(unicodeInputStream);
                strHandleEncryption = this.t1.handleEncryption(activity, bytes);
                if (strHandleEncryption != null) {
                    this.U0 = true;
                } else {
                    this.U0 = false;
                    strHandleEncryption = new String(bytes);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                Logger.e("parseConfig error=" + e2.getMessage());
                strHandleEncryption = "";
            }
        } else {
            strHandleEncryption = "";
        }
        if (this.U0 && z19 && BaseInfo.SyncDebug && !BaseInfo.isBase(activity) && z19) {
            f5Var.a = true;
            f5Var.b = DOMException.toJSON(DOMException.CODE_BASE_DEBUG_WGT_INSTALL_ERROR_MALFORMED, DOMException.MSG_BASE_DEBUG_WGT_INSTALL_NOT_CONFUSION);
            return false;
        }
        try {
            JSONObject jSONObject11 = new JSONObject(strHandleEncryption);
            JSONObject jSONObject12 = JSONUtil.getJSONObject(jSONObject11, "version");
            String string3 = JSONUtil.getString(jSONObject12, "name");
            String string4 = JSONUtil.getString(jSONObject12, "code");
            BaseInfo.sLastAppVersionName = string3;
            String str19 = this.p0;
            String appSignatureSHA1 = LoadAppUtils.getAppSignatureSHA1(activity);
            if (z19) {
                z = jSONObject != null ? Boolean.parseBoolean(JSONUtil.getString(jSONObject, AbsoluteConst.INSTALL_OPTIONS_FORCE)) : false;
                if (!z && !TextUtils.isEmpty(this.A) && !BaseInfo.BaseAppInfo.compareVersion(string3, this.A)) {
                    if (f5Var.c) {
                        f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_VERSION_NOT_MATCH, DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_VERSION_NOT_MATCH);
                    } else {
                        f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGT_MANIFEST_VERSION_NOT_MATCH, DOMException.MSG_RUNTIME_WGT_MANIFEST_VERSION_NOT_MATCH);
                    }
                    f5Var.a = true;
                    return false;
                }
            } else {
                z = false;
            }
            String string5 = JSONUtil.getString(jSONObject11, "id");
            BaseInfo.sCurrentAppOriginalAppid = string5;
            if (BaseInfo.ISDEBUG && (context = DeviceInfo.sApplicationContext) != null && BaseInfo.isBase(context)) {
                z2 = true;
            } else {
                z2 = PdrUtil.isEquals(str18, string5) && PdrUtil.isEquals(this.o, string5);
                if (!z2) {
                    f5Var.a = true;
                    if (f5Var.c) {
                        f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED, DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_APPID_NOT_MATCH);
                    } else {
                        f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGT_MANIFEST_APPID_NOT_MATCH, DOMException.MSG_RUNTIME_WGT_MANIFEST_APPID_NOT_MATCH);
                    }
                    Log.e("Appmgr", "appid config is wrong pExpectAppid=" + str18 + ";appid=" + string5);
                    return false;
                }
                str18 = string5;
            }
            String string6 = JSONUtil.getString(jSONObject11, "name");
            boolean z20 = z;
            if (!c4.c()) {
                appSignatureSHA1 = appSignatureSHA1 + getConfusionMgr().decodeString(getConfusionMgr().getS5DS(), true, 60);
            }
            String str20 = appSignatureSHA1;
            String string7 = JSONUtil.getString(jSONObject11, "description");
            JSONObject jSONObject13 = JSONUtil.getJSONObject(jSONObject11, IApp.ConfigProperty.CONFIG_DEVELOPER);
            String string8 = JSONUtil.getString(jSONObject13, "name");
            String string9 = JSONUtil.getString(jSONObject13, "email");
            JSONUtil.getString(jSONObject13, "url");
            JSONObject jSONObject14 = JSONUtil.getJSONObject(jSONObject11, IApp.ConfigProperty.CONFIG_LICENSE);
            String string10 = JSONUtil.getString(jSONObject14, "url");
            JSONUtil.getString(jSONObject14, "description");
            String string11 = JSONUtil.getString(jSONObject11, IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
            String string12 = JSONUtil.getString(jSONObject11, IApp.ConfigProperty.CONFIG_LAUNCH_PATH_W2A);
            boolean z21 = this.j1 || !(TextUtils.isEmpty(this.l0) || TextUtils.equals(string11, this.l0));
            this.j1 = z21;
            this.j1 = z21 || !(TextUtils.isEmpty(this.n0) || TextUtils.equals(string12, this.n0));
            String string13 = JSONUtil.getString(jSONObject11, IApp.ConfigProperty.CONFIG_BASEURL);
            boolean z22 = !PdrUtil.isEmpty(this.s0);
            JSONObject jSONObject15 = JSONUtil.getJSONObject(jSONObject11, IApp.ConfigProperty.CONFIG_PLUS);
            if (jSONObject15.has(IApp.ConfigProperty.CONFIG_CONFUSION)) {
                str3 = string11;
                JSONObject jSONObject16 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_CONFUSION);
                if (jSONObject16 == null) {
                    str2 = string7;
                    if (jSONObject15.optString(IApp.ConfigProperty.CONFIG_CONFUSION).startsWith("BQ81KwABAA")) {
                        this.U0 = true;
                        this.V0 = true;
                    }
                    if (this.t1.recordEncryptionV3Resources(this.o, jSONObject15.optString(IApp.ConfigProperty.CONFIG_CONFUSION))) {
                        this.U0 = true;
                        this.V0 = true;
                    }
                } else {
                    str2 = string7;
                    if (this.U0) {
                        this.t1.recordEncryptionResources(this.o, jSONObject16);
                    }
                }
            } else {
                str2 = string7;
                str3 = string11;
            }
            PermissionUtil.isCheckPermissionDisabled = JSONUtil.getBoolean(jSONObject15, "checkPermissionDenied");
            JSONObject jSONObject17 = JSONUtil.getJSONObject(jSONObject15, AbsoluteConst.UNI_TABBAR_KEY);
            JSONObject jSONObject18 = JSONUtil.getJSONObject(jSONObject15, AbsoluteConst.JSONKEY_STATUSBAR);
            String strOptString4 = "none";
            if (jSONObject18 != null) {
                if (jSONObject18.has("background")) {
                    str4 = string5;
                    String strOptString5 = jSONObject18.optString("background");
                    if (!PdrUtil.isEmpty(strOptString5)) {
                        this.X0 = strOptString5;
                    }
                } else {
                    str4 = string5;
                }
                if (jSONObject18.has("style")) {
                    this.a1 = jSONObject18.optString("style", this.a1);
                }
                if (jSONObject18.has(AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
                    String strOptString6 = jSONObject18.optString(AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED);
                    this.n = strOptString6;
                    str5 = string3;
                    if (!strOptString6.equals("supportedDevice") && !this.n.equals("suggestedDevice")) {
                        if (!this.n.equals("none")) {
                            this.b1 = jSONObject18.optBoolean(AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED, this.b1);
                        } else {
                            this.b1 = false;
                        }
                    } else {
                        this.b1 = true;
                    }
                } else {
                    str5 = string3;
                }
            } else {
                str4 = string5;
                str5 = string3;
                string4 = string4;
            }
            JSONObject jSONObject19 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_LAUNCHWEBVIEW);
            String strOptString7 = null;
            if (jSONObject19 != null) {
                JSONObject jSONObject20 = JSONUtil.getJSONObject(jSONObject19, IApp.ConfigProperty.CONFIG_OVERRIDEURL);
                JSONArray jSONArray3 = JSONUtil.getJSONArray(jSONObject19, IApp.ConfigProperty.CONFIG_OVERRIDE_RESOURCE);
                if (jSONArray3 != null) {
                    str7 = str20;
                    jSONObject9 = new JSONObject();
                    str6 = str18;
                    try {
                        jSONObject9.put(WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, jSONArray3);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    str6 = str18;
                    str7 = str20;
                    jSONObject9 = null;
                }
                boolean zOptBoolean = jSONObject19.optBoolean("injection", this.i1);
                String strOptString8 = jSONObject19.optString("plusrequire", "normal");
                if (jSONObject19.has("titleNView")) {
                    jSONObject10 = JSONUtil.getJSONObject(jSONObject19, "titleNView");
                } else {
                    jSONObject10 = jSONObject19.has("navigationbar") ? JSONUtil.getJSONObject(jSONObject19, "navigationbar") : null;
                }
                if (jSONObject19.has("replacewebapi")) {
                    jSONObject4 = jSONObject10;
                    JSONObject jSONObjectOptJSONObject2 = jSONObject19.optJSONObject("replacewebapi");
                    if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.has("geolocation")) {
                        str16 = "none";
                    } else {
                        strOptString3 = jSONObjectOptJSONObject2.optString("geolocation", "none");
                        str16 = strOptString3;
                    }
                } else {
                    jSONObject4 = jSONObject10;
                    if (jSONObject19.has("geolocation")) {
                        strOptString3 = jSONObject19.optString("geolocation", "none");
                        str16 = strOptString3;
                    } else {
                        str16 = "none";
                    }
                }
                if (this.b1 && jSONObject19.has(AbsoluteConst.JSONKEY_STATUSBAR)) {
                    this.c1 = true;
                    JSONObject jSONObjectOptJSONObject3 = jSONObject19.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR);
                    if (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.has("background")) {
                        str17 = strOptString8;
                    } else {
                        str17 = strOptString8;
                        this.e1 = jSONObjectOptJSONObject3.optString("background", this.X0);
                    }
                } else {
                    str17 = strOptString8;
                }
                jSONObject3 = jSONObject9;
                jSONObject2 = jSONObject20;
                z3 = zOptBoolean;
                str8 = str16;
                str9 = str17;
            } else {
                str6 = str18;
                str7 = str20;
                str8 = "none";
                str9 = "normal";
                jSONObject2 = null;
                jSONObject3 = null;
                jSONObject4 = null;
                z3 = true;
            }
            if (jSONObject15.has("appWhitelist")) {
                JSONArray jSONArrayOptJSONArray = jSONObject15.optJSONArray("appWhitelist");
                int i6 = 0;
                while (i6 < jSONArrayOptJSONArray.length()) {
                    String strOptString9 = jSONArrayOptJSONArray.optString(i6);
                    if (TextUtils.isEmpty(strOptString9)) {
                        i5 = i6;
                    } else {
                        i5 = i6;
                        if (!this.l1.contains(strOptString9)) {
                            this.l1.add(strOptString9);
                        }
                    }
                    i6 = i5 + 1;
                }
            }
            if (jSONObject15.has("schemeWhitelist")) {
                JSONArray jSONArrayOptJSONArray2 = jSONObject15.optJSONArray("schemeWhitelist");
                int i7 = 0;
                while (i7 < jSONArrayOptJSONArray2.length()) {
                    String strOptString10 = jSONArrayOptJSONArray2.optString(i7);
                    if (TextUtils.isEmpty(strOptString10)) {
                        jSONArray2 = jSONArrayOptJSONArray2;
                    } else {
                        jSONArray2 = jSONArrayOptJSONArray2;
                        if (!this.m1.contains(strOptString10)) {
                            this.m1.add(strOptString10);
                        }
                    }
                    i7++;
                    jSONArrayOptJSONArray2 = jSONArray2;
                }
            }
            JSONObject jSONObject21 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_SECONDWEBVIEW);
            if (jSONObject21 != null) {
                strOptString = jSONObject21.optString("plusrequire", "normal");
                if (jSONObject21.has("replacewebapi")) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObject21.optJSONObject("replacewebapi");
                    if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("geolocation")) {
                        strOptString4 = jSONObjectOptJSONObject4.optString("geolocation", "none");
                    }
                } else if (jSONObject21.has("geolocation")) {
                    strOptString4 = jSONObject21.optString("geolocation", "none");
                }
                if (this.b1 && jSONObject21.has(AbsoluteConst.JSONKEY_STATUSBAR)) {
                    this.d1 = true;
                    JSONObject jSONObjectOptJSONObject5 = jSONObject21.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR);
                    if (jSONObjectOptJSONObject5 != null && jSONObjectOptJSONObject5.has("background")) {
                        this.f1 = jSONObjectOptJSONObject5.optString("background", this.X0);
                    }
                }
            } else {
                strOptString = "normal";
            }
            if (BaseInfo.isBase(this.y.getContext())) {
                this.R0 = JSONUtil.getString(jSONObject15, IApp.ConfigProperty.CONFIG_RAM_CACHE_MODE);
            }
            this.T0 = jSONObject15.optBoolean(AbsoluteConst.JSON_KEY_HARDWARE_ACCELERATED, MobilePhoneModel.checkPhoneBanAcceleration(Build.BRAND) || (BaseInfo.isWap2AppAppid(this.o) && q()));
            this.S0 = jSONObject15.optString("popGesture", this.S0);
            JSONObject jSONObject22 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_CACHE);
            if (jSONObject22 != null) {
                String string14 = JSONUtil.getString(jSONObject22, "mode");
                if (TextUtils.isEmpty(string14)) {
                    string14 = this.W0;
                }
                this.W0 = string14;
            }
            JSONObject jSONObject23 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_CERS);
            boolean z23 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject23, IApp.ConfigProperty.CONFIG_CRASH), this.M, false);
            boolean z24 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject23, IApp.ConfigProperty.CONFIG_JSERROR), this.N, false);
            JSONObject jSONObjectOptJSONObject6 = jSONObject15.optJSONObject("compatible");
            String str21 = strOptString4;
            if (jSONObjectOptJSONObject6 != null && jSONObject15.has("uni-app")) {
                JSONObject jSONObjectOptJSONObject7 = jSONObject15.optJSONObject("uni-app");
                if (!a(jSONObjectOptJSONObject7, f5Var)) {
                    return false;
                }
                str10 = strOptString;
                this.q = true;
                this.z0 = AbsoluteConst.UNI_V3;
                jSONObject5 = jSONObject21;
                this.y0 = jSONObjectOptJSONObject6.optBoolean("ignoreVersion", false);
                String strOptString11 = jSONObjectOptJSONObject6.optString("compilerVersion");
                this.w0 = jSONObjectOptJSONObject6.optString("runtimeVersion");
                this.u0 = jSONObjectOptJSONObject7.optString("compilerVersion");
                this.A0 = jSONObjectOptJSONObject7.optString(AbsoluteConst.NVUE_LAUNCH_MODE, "normal");
                if (!PdrUtil.isEmpty(strOptString11) && strOptString11.trim().equals(this.u0)) {
                    this.x0 = false;
                }
            } else {
                jSONObject5 = jSONObject21;
                str10 = strOptString;
                if (jSONObject15.has("uni-app")) {
                    JSONObject jSONObjectOptJSONObject8 = jSONObject15.optJSONObject("uni-app");
                    if (!a(jSONObjectOptJSONObject8, f5Var)) {
                        return false;
                    }
                    this.q = true;
                    this.u0 = jSONObjectOptJSONObject8.optString("compilerVersion");
                    this.z0 = AbsoluteConst.UNI_V3;
                    this.v0 = jSONObjectOptJSONObject8.optJSONObject("nvue");
                    this.A0 = jSONObjectOptJSONObject8.optString(AbsoluteConst.NVUE_LAUNCH_MODE, "normal");
                } else {
                    this.q = false;
                }
            }
            if (SDK.isUniMPSDK()) {
                zIsEquals = true;
            } else {
                String string15 = JSONUtil.getString(jSONObject15, IApp.ConfigProperty.CONFIG_RUNMODE);
                if (TextUtils.isEmpty(string15) && this.q) {
                    string15 = IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE;
                }
                zIsEquals = PdrUtil.isEquals(string15, IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE);
            }
            JSONObject jSONObject24 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_USER_AGENT);
            String string16 = JSONUtil.getString(jSONObject24, "value");
            boolean z25 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject24, IApp.ConfigProperty.CONFIG_CONCATENATE), this.Q, false);
            JSONObject jSONObject25 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_USER_AGENT_ANDROID);
            String string17 = JSONUtil.getString(jSONObject25, "value");
            boolean z26 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject25, IApp.ConfigProperty.CONFIG_CONCATENATE), z25, false);
            String str22 = !TextUtils.isEmpty(string17) ? string17 : string16;
            JSONObject jSONObject26 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_SPLASHSCREEN);
            if (jSONObject26 != null) {
                SharedPreferences orCreateBundle = SP.getOrCreateBundle(getActivity(), "pdr");
                StringBuilder sb3 = new StringBuilder();
                jSONObject6 = jSONObject2;
                sb3.append(this.o);
                sb3.append(SP.UPDATE_SPLASH_AUTOCLOSE);
                if (orCreateBundle.contains(sb3.toString())) {
                    z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE, true);
                } else {
                    if (JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
                        z14 = false;
                        z15 = true;
                    } else {
                        z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE)));
                    }
                    if (z15) {
                        z16 = z15;
                        sb2 = new StringBuilder();
                        z5 = z26;
                        sb2.append(this.o);
                        sb2.append(SP.UPDATE_SPLASH_DELAY);
                        if (orCreateBundle.contains(sb2.toString())) {
                            i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY, 0);
                        } else {
                            if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY)) {
                                i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY), this.b0);
                            }
                            sb = new StringBuilder();
                            z4 = zIsEquals;
                            sb.append(this.o);
                            sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                            if (orCreateBundle.contains(sb.toString())) {
                                z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                            } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                                z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                            }
                            if (z14) {
                                if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                                    i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                                } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                    i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                                }
                                iJ = (int) (i3 + j());
                            } else {
                                iJ = i3;
                            }
                            z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                            string = JSONUtil.getString(jSONObject26, "event");
                            z18 = z14;
                            strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                            jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                            if (jSONObject8 != null) {
                                String strOptString12 = jSONObject8.optString("background", "#ffffff");
                                String strOptString13 = jSONObject8.optString("image", "");
                                z9 = z17;
                                i2 = i4;
                                z7 = z18;
                                str13 = strOptString2;
                                str12 = strOptString12;
                                z8 = z16;
                                str11 = strOptString13;
                                i = iJ;
                                z6 = true;
                            } else {
                                i = iJ;
                                z9 = z17;
                                z8 = z16;
                                i2 = i4;
                                z7 = z18;
                                z6 = true;
                                str13 = strOptString2;
                                str11 = null;
                                str12 = null;
                            }
                        }
                        i4 = i3;
                        sb = new StringBuilder();
                        z4 = zIsEquals;
                        sb.append(this.o);
                        sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                        if (orCreateBundle.contains(sb.toString())) {
                            z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                        } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                        }
                        if (z14) {
                            if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                                i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                            } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                            }
                            iJ = (int) (i3 + j());
                        } else {
                            iJ = i3;
                        }
                        z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                        string = JSONUtil.getString(jSONObject26, "event");
                        z18 = z14;
                        strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                        jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                        if (jSONObject8 != null) {
                            String strOptString14 = jSONObject8.optString("background", "#ffffff");
                            String strOptString15 = jSONObject8.optString("image", "");
                            z9 = z17;
                            i2 = i4;
                            z7 = z18;
                            str13 = strOptString2;
                            str12 = strOptString14;
                            z8 = z16;
                            str11 = strOptString15;
                            i = iJ;
                            z6 = true;
                        } else {
                            i = iJ;
                            z9 = z17;
                            z8 = z16;
                            i2 = i4;
                            z7 = z18;
                            z6 = true;
                            str13 = strOptString2;
                            str11 = null;
                            str12 = null;
                        }
                    } else {
                        z5 = z26;
                        z16 = z15;
                    }
                    i3 = 0;
                    i4 = 0;
                    sb = new StringBuilder();
                    z4 = zIsEquals;
                    sb.append(this.o);
                    sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                    if (orCreateBundle.contains(sb.toString())) {
                        z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                    } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                        z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                    }
                    if (z14) {
                        if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                            i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                        } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                        }
                        iJ = (int) (i3 + j());
                    } else {
                        iJ = i3;
                    }
                    z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                    string = JSONUtil.getString(jSONObject26, "event");
                    z18 = z14;
                    strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                    jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                    if (jSONObject8 != null) {
                        String strOptString16 = jSONObject8.optString("background", "#ffffff");
                        String strOptString17 = jSONObject8.optString("image", "");
                        z9 = z17;
                        i2 = i4;
                        z7 = z18;
                        str13 = strOptString2;
                        str12 = strOptString16;
                        z8 = z16;
                        str11 = strOptString17;
                        i = iJ;
                        z6 = true;
                    } else {
                        i = iJ;
                        z9 = z17;
                        z8 = z16;
                        i2 = i4;
                        z7 = z18;
                        z6 = true;
                        str13 = strOptString2;
                        str11 = null;
                        str12 = null;
                    }
                }
                z15 = z14;
                if (z15) {
                    z16 = z15;
                    sb2 = new StringBuilder();
                    z5 = z26;
                    sb2.append(this.o);
                    sb2.append(SP.UPDATE_SPLASH_DELAY);
                    if (orCreateBundle.contains(sb2.toString())) {
                        i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY, 0);
                    } else {
                        if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY)) {
                            i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY), this.b0);
                        }
                        sb = new StringBuilder();
                        z4 = zIsEquals;
                        sb.append(this.o);
                        sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                        if (orCreateBundle.contains(sb.toString())) {
                            z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                        } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                        }
                        if (z14) {
                            if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                                i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                            } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                            }
                            iJ = (int) (i3 + j());
                        } else {
                            iJ = i3;
                        }
                        z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                        string = JSONUtil.getString(jSONObject26, "event");
                        z18 = z14;
                        strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                        jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                        if (jSONObject8 != null) {
                            String strOptString18 = jSONObject8.optString("background", "#ffffff");
                            String strOptString19 = jSONObject8.optString("image", "");
                            z9 = z17;
                            i2 = i4;
                            z7 = z18;
                            str13 = strOptString2;
                            str12 = strOptString18;
                            z8 = z16;
                            str11 = strOptString19;
                            i = iJ;
                            z6 = true;
                        } else {
                            i = iJ;
                            z9 = z17;
                            z8 = z16;
                            i2 = i4;
                            z7 = z18;
                            z6 = true;
                            str13 = strOptString2;
                            str11 = null;
                            str12 = null;
                        }
                    }
                    i4 = i3;
                    sb = new StringBuilder();
                    z4 = zIsEquals;
                    sb.append(this.o);
                    sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                    if (orCreateBundle.contains(sb.toString())) {
                        z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                    } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                        z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                    }
                    if (z14) {
                        if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                            i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                        } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                        }
                        iJ = (int) (i3 + j());
                    } else {
                        iJ = i3;
                    }
                    z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                    string = JSONUtil.getString(jSONObject26, "event");
                    z18 = z14;
                    strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                    jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                    if (jSONObject8 != null) {
                        String strOptString110 = jSONObject8.optString("background", "#ffffff");
                        String strOptString111 = jSONObject8.optString("image", "");
                        z9 = z17;
                        i2 = i4;
                        z7 = z18;
                        str13 = strOptString2;
                        str12 = strOptString110;
                        z8 = z16;
                        str11 = strOptString111;
                        i = iJ;
                        z6 = true;
                    } else {
                        i = iJ;
                        z9 = z17;
                        z8 = z16;
                        i2 = i4;
                        z7 = z18;
                        z6 = true;
                        str13 = strOptString2;
                        str11 = null;
                        str12 = null;
                    }
                } else {
                    z5 = z26;
                    z16 = z15;
                }
                i3 = 0;
                i4 = 0;
                sb = new StringBuilder();
                z4 = zIsEquals;
                sb.append(this.o);
                sb.append(SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                if (orCreateBundle.contains(sb.toString())) {
                    z14 = orCreateBundle.getBoolean(this.o + SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                    z14 = Boolean.parseBoolean(String.valueOf(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                }
                if (z14) {
                    if (orCreateBundle.contains(this.o + SP.UPDATE_SPLASH_DELAY_W2A)) {
                        i3 = orCreateBundle.getInt(this.o + SP.UPDATE_SPLASH_DELAY_W2A, i3);
                    } else if (!JSONUtil.isNull(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                        i3 = PdrUtil.parseInt(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                    }
                    iJ = (int) (i3 + j());
                } else {
                    iJ = i3;
                }
                z17 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject26, IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                string = JSONUtil.getString(jSONObject26, "event");
                z18 = z14;
                strOptString2 = jSONObject26.optString(IApp.ConfigProperty.CONFIG_TARGET, "default");
                jSONObject8 = JSONUtil.getJSONObject(jSONObject26, "ads");
                if (jSONObject8 != null) {
                    String strOptString112 = jSONObject8.optString("background", "#ffffff");
                    String strOptString113 = jSONObject8.optString("image", "");
                    z9 = z17;
                    i2 = i4;
                    z7 = z18;
                    str13 = strOptString2;
                    str12 = strOptString112;
                    z8 = z16;
                    str11 = strOptString113;
                    i = iJ;
                    z6 = true;
                } else {
                    i = iJ;
                    z9 = z17;
                    z8 = z16;
                    i2 = i4;
                    z7 = z18;
                    z6 = true;
                    str13 = strOptString2;
                    str11 = null;
                    str12 = null;
                }
            } else {
                jSONObject6 = jSONObject2;
                z4 = zIsEquals;
                z5 = z26;
                string = null;
                str11 = null;
                str12 = null;
                str13 = null;
                z6 = false;
                z7 = false;
                z8 = true;
                i = 0;
                z9 = false;
                i2 = 0;
            }
            JSONObject jSONObject27 = JSONUtil.getJSONObject(jSONObject15, "error");
            if (jSONObject27 != null && !JSONUtil.isNull(jSONObject27, "url")) {
                string2 = JSONUtil.getString(jSONObject27, "url");
            } else {
                string2 = "file:///android_asset/data/dcloud_error.html";
            }
            JSONObject jSONObject28 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_SSL);
            String str23 = string;
            String string18 = (jSONObject28 == null || JSONUtil.isNull(jSONObject28, IApp.ConfigProperty.CONFIG_UNTRUSTEDCA)) ? str19 : JSONUtil.getString(jSONObject28, IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
            JSONObject jSONObject29 = JSONUtil.getJSONObject(jSONObject15, IApp.ConfigProperty.CONFIG_STREAM);
            int i8 = i;
            boolean zIsWap2AppAppid = BaseInfo.isWap2AppAppid(this.o);
            this.P = zIsWap2AppAppid;
            int i9 = i2;
            if (jSONObject29 != null) {
                this.P = jSONObject29.optBoolean(IApp.ConfigProperty.CONFIG_COMPETENT, zIsWap2AppAppid);
                this.A1 = jSONObject29.optString(IApp.ConfigProperty.CONFIG_SHORTCUT);
                this.z1 = jSONObject29.optString("shortcutQuit");
                jSONObjectOptJSONObject = jSONObject29.optJSONObject(IApp.ConfigProperty.CONFIG_AUTHORITY);
            } else {
                jSONObjectOptJSONObject = null;
            }
            if (!this.P) {
                BaseInfo.createAppTestFile(str6);
            } else {
                BaseInfo.removeTestFile(str6);
            }
            String str24 = H1;
            StringBuilder sb4 = new StringBuilder();
            JSONObject jSONObject30 = jSONObjectOptJSONObject;
            sb4.append(this.o);
            sb4.append(" app competent=");
            sb4.append(this.P);
            Logger.i(str24, sb4.toString());
            if (this.q || c4.c()) {
                str14 = str6;
                str15 = string18;
                z10 = z2;
            } else {
                String metaValue = AndroidResources.getMetaValue(getConfusionMgr().decryptStr("lkdg}lWixxcmq"));
                if (c4.b()) {
                    str14 = str6;
                    if (s.c(activity, str14)) {
                        str15 = string18;
                        z10 = true;
                        if (!z10) {
                            setStatus((byte) 4);
                            return false;
                        }
                    }
                    str15 = string18;
                    z10 = false;
                    if (!z10) {
                        setStatus((byte) 4);
                        return false;
                    }
                } else {
                    str14 = str6;
                    if (TextUtils.isEmpty(metaValue)) {
                        str15 = string18;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str14);
                        str15 = string18;
                        sb5.append(activity.getPackageName().toLowerCase(Locale.ENGLISH));
                        String strMd5 = Md5Utils.md5(sb5.toString() + str7);
                        if (!TextUtils.isEmpty(strMd5) && metaValue.equalsIgnoreCase(strMd5)) {
                            z10 = true;
                        }
                        if (!z10) {
                            setStatus((byte) 4);
                            return false;
                        }
                    }
                    z10 = false;
                    if (!z10) {
                        setStatus((byte) 4);
                        return false;
                    }
                }
            }
            JSONObject jSONObject31 = JSONUtil.getJSONObject(jSONObject15, "ads");
            String string19 = JSONUtil.getString(jSONObject15, "adid");
            JSONObject jSONObject32 = JSONUtil.getJSONObject(jSONObject15, "wap2app");
            boolean z27 = z10;
            if (jSONObject32 != null) {
                strOptString7 = jSONObject32.optString("launchError", "tip");
            }
            String str25 = strOptString7;
            Intent intent = this.O0;
            if (intent != null && intent.hasExtra(IntentConst.UNIMP_DIRECT_DATA)) {
                this.q1 = true;
                this.r1 = this.O0.getStringExtra(IntentConst.UNIMP_DIRECT_DATA);
                this.O0.removeExtra(IntentConst.UNIMP_DIRECT_DATA);
            }
            this.u1 = IntentConst.obtainIntentStringExtra(this.O0, IntentConst.UNIMP_RUN_EXTRA_INFO, true);
            if (jSONObject15.has("arguments")) {
                setRuntimeArgs(JSONUtil.getString(jSONObject15, "arguments"));
            } else {
                Intent intent2 = this.O0;
                if (intent2 != null && intent2.hasExtra(IntentConst.UNIMP_RUN_ARGUMENTS)) {
                    setRuntimeArgs(this.O0.getStringExtra(IntentConst.UNIMP_RUN_ARGUMENTS));
                }
            }
            boolean z28 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject11, IApp.ConfigProperty.CONFIG_FULLSCREEN), this.i, false);
            Logger.i(H1, this.o + " app fullScreen=" + z28);
            ArrayList arrayList = new ArrayList();
            boolean zQ = q();
            JSONObject jSONObject33 = JSONUtil.getJSONObject(jSONObject11, "permissions");
            if (jSONObject33 == null || (jSONArrayNames = jSONObject33.names()) == null) {
                z11 = z7;
                z12 = z27;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                boolean z29 = z27;
                int i10 = 0;
                while (i10 < jSONArrayNames.length()) {
                    int i11 = i10;
                    String lowerCase = JSONUtil.getString(jSONArrayNames, i10).toLowerCase(Locale.ENGLISH);
                    arrayList.add(lowerCase);
                    if (lowerCase.equals("push")) {
                        jSONArray = jSONArrayNames;
                        z13 = z7;
                        PlatformUtil.APS_COVER = PdrUtil.parseBoolean(JSONUtil.getString(JSONUtil.getJSONObject(jSONObject33, lowerCase), IApp.ConfigProperty.CONFIG_COVER), PlatformUtil.APS_COVER, false);
                    } else {
                        z13 = z7;
                        jSONArray = jSONArrayNames;
                        if (lowerCase.equals("webview")) {
                            arrayList.add(AbsoluteConst.F_UI);
                        } else if (lowerCase.equals(AbsoluteConst.F_UI)) {
                            arrayList.add("webview");
                            arrayList.add("nativeui");
                            arrayList.add("navigator");
                        } else if (lowerCase.equals("maps") && (jSONObject7 = JSONUtil.getJSONObject(jSONObject33, IFeature.F_MAPS)) != null && jSONObject7.has(AbsoluteConst.JSONKEY_MAP_COORD_TYPE)) {
                            this.p1 = JSONUtil.getString(jSONObject7, AbsoluteConst.JSONKEY_MAP_COORD_TYPE);
                        }
                    }
                    if (z19 && !z20 && !zQ && !PermissionControler.checkSafePermission(str14, lowerCase)) {
                        ArrayList arrayList2 = this.B0;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            if (!this.B0.contains(lowerCase)) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(",");
                                }
                                stringBuffer.append(lowerCase);
                                z29 = false;
                            }
                        } else if (!((Boolean) this.y.processEvent(IMgr.MgrType.FeatureMgr, 9, lowerCase)).booleanValue()) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(lowerCase);
                            z29 = false;
                        }
                    }
                    i10 = i11 + 1;
                    jSONArrayNames = jSONArray;
                    z7 = z13;
                }
                z11 = z7;
                if (!z29 && z19 != 0) {
                    f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_5PRUNTIME_LACK_MODULE, StringUtil.format(DOMException.MSG_RUNTIME_5PRUNTIME_LACK_MODULE, stringBuffer));
                    f5Var.a = true;
                    return false;
                }
                z12 = z29;
            }
            if (z12) {
                BaseInfo.BaseAppInfo baseAppInfo = this.t;
                if (baseAppInfo != null) {
                    baseAppInfo.mAppVer = this.A;
                }
                this.A = str5;
                this.B = string4;
                this.B0 = arrayList;
                this.o = str14;
                this.z = str4;
                this.t0 = string6;
                this.M = z23;
                this.N = z24;
                this.F = str2;
                this.G = string8;
                this.H = string9;
                this.J = string10;
                this.l0 = str3;
                this.n0 = string12;
                this.s0 = string13;
                this.L = str22;
                this.q0 = string2;
                this.W = z6;
                this.Y = z8;
                this.Z = z11;
                this.j0 = z4;
                this.X = z9;
                this.Q = z5;
                this.i = z28;
                this.U = z22;
                String str26 = str15;
                this.p0 = str26;
                BaseInfo.untrustedca = str26;
                this.b0 = i9;
                this.c0 = i8;
                this.d0 = str23;
                this.e0 = str13;
                this.D0 = jSONObject6;
                this.F0 = jSONObject3;
                this.i1 = z3;
                this.G0 = jSONObject5;
                this.H0 = jSONObject19;
                this.J0 = jSONObject4;
                this.I0 = jSONObject30;
                this.L0 = jSONObject31;
                this.N0 = string19;
                this.f0 = str9;
                this.g0 = str10;
                this.h0 = str8;
                this.i0 = str21;
                this.Y0 = str12;
                this.Z0 = str11;
                this.M0 = str25;
                this.E0 = jSONObject17;
                l();
                f5Var.b = v();
            }
            f5Var.a = !z12;
            return z12;
        } catch (Exception e4) {
            e4.printStackTrace();
            f5Var.a = true;
            if (f5Var.c) {
                f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED, DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED);
                return false;
            }
            f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGT_MANIFEST_ERROR_MALFORMED, DOMException.MSG_RUNTIME_WGT_MANIFEST_ERROR_MALFORMED);
            return false;
        }
    }

    public void g() {
        ArrayList arrayList = this.B0;
        if (arrayList != null) {
            arrayList.clear();
            this.B0 = null;
        }
        HashMap map = this.C0;
        if (map != null) {
            map.clear();
            this.C0 = null;
        }
        this.t1.removeData(this.o);
        this.y = null;
        this.t = null;
        this.g1 = false;
    }

    private static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    boolean c(String str, JSONObject jSONObject) {
        String str2;
        String strObtainAppDataPath = obtainAppDataPath();
        StringBuilder sb = new StringBuilder();
        boolean zB = false;
        sb.append(strObtainAppDataPath.substring(0, strObtainAppDataPath.length() - 1));
        sb.append("_backup");
        String string = sb.toString();
        byte b2 = this.V;
        try {
            if (b2 == 1) {
                str2 = BaseInfo.sCacheFsAppsPath + this.o + File.separatorChar + BaseInfo.APP_WWW_FS_DIR;
                try {
                    DHFile.deleteFile(str2);
                    string = str2.substring(0, str2.length() - 1) + "_backup";
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    f5 f5Var = this.s;
                    f5Var.a = true;
                    f5Var.b = StringUtil.format(DOMException.JSON_ERROR_INFO, 10, e.getMessage());
                }
            } else {
                if (b2 == 0) {
                    new File(strObtainAppDataPath).renameTo(new File(string));
                }
                str2 = strObtainAppDataPath;
            }
            File file = new File(str);
            if (Zip4JUtil.isEncryptedZip(file)) {
                Zip4JUtil.upZipFileWithPassword(file, str2, jSONObject.getString(Constants.Value.PASSWORD));
            } else {
                ZipUtils.upZipFile(file, str2);
            }
            b((byte) 0);
            setAppDataPath(str2);
            zB = b(this.o, jSONObject);
        } catch (Exception e3) {
            e = e3;
            str2 = strObtainAppDataPath;
        }
        if (!zB) {
            Logger.e(Logger.AppMgr_TAG, "unZipWebApp failed pFilePath=" + str);
            b(b2);
            setAppDataPath(strObtainAppDataPath);
            try {
                DHFile.deleteFile(str2);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (b2 == 0) {
                new File(string).renameTo(new File(str2));
            }
        } else {
            if (b2 == 0) {
                try {
                    DHFile.deleteFile(string);
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            BaseInfo.BaseAppInfo baseAppInfo = new BaseInfo.BaseAppInfo(this.o, this.A);
            this.t = baseAppInfo;
            baseAppInfo.saveToBundleData(getActivity());
        }
        return zB;
    }

    boolean f(String str) {
        if (!this.v && this.x) {
            return false;
        }
        Logger.e("Webapp start " + this.o);
        Activity activity = this.a;
        if (activity != null && (activity instanceof WebAppActivity)) {
            ((WebAppActivity) activity).onAppStart(this.o);
            ((WebAppActivity) this.a).onAppStart(this);
        }
        BaseInfo.s_Runing_App_Count++;
        this.w = true;
        this.x = !this.v;
        setRuntimeArgs(str);
        return b(5);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public InputStream obtainResInStream(String str) {
        return obtainResInStream(null, str);
    }

    private String c(String str) {
        return BaseInfo.sBaseFsSitMapPath + str + "/_sitemap.json";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public String convert2AbsFullPath(String str) {
        return convert2AbsFullPath(null, str);
    }

    void b(byte b2) {
        this.V = b2;
    }

    private static String b(String str) {
        return (str == null || str.length() <= 0 || str.charAt(0) != '/') ? str : b(str.substring(1));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean b(int i) {
        PermissionUtil.sUseStreamAppPermissionDialogCount = 0;
        WebViewFactory.sUsePermissionWebviews.clear();
        PermissionUtil.removeTempPermission(this.a, this.o);
        Logger.e(H1, "start0 mAppid===" + this.o);
        BaseInfo.sCurrentAppOriginalAppid = this.z;
        BaseInfo.putStartupTimeData(this.o, String.valueOf(System.currentTimeMillis()));
        BaseInfo.sProcessId = Process.myPid();
        String str = H1;
        StringBuilder sb = new StringBuilder();
        sb.append(this.o);
        sb.append(this.V == 1 ? " APP_RUNNING_MODE" : " FS_RUNNING_MODE");
        Logger.i(str, sb.toString());
        t();
        setStatus((byte) 3);
        IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            iAppStatusListener.onStart();
        }
        Logger.i(H1, "mLaunchPath=" + this.l0);
        Logger.i("download_manager", "webapp start task begin success appid=" + this.o + " mLaunchPath=" + this.l0);
        String str2 = TestUtil.START_STREAM_APP;
        StringBuilder sb2 = new StringBuilder("webapp start appid=");
        sb2.append(this.o);
        TestUtil.print(str2, sb2.toString());
        BaseInfo.setLoadingLaunchePage(true, "start0");
        String stringExtra = getActivity().getIntent().getStringExtra(IntentConst.WEBAPP_ACTIVITY_LAUNCH_PATH);
        if (stringExtra != null && !"".equals(stringExtra.trim())) {
            getActivity().getIntent().removeExtra(IntentConst.WEBAPP_ACTIVITY_LAUNCH_PATH);
            if (!"about:blank".equals(stringExtra)) {
                stringExtra = convert2WebviewFullPath(null, stringExtra);
            }
            this.o0 = true;
        } else if (BaseInfo.isWap2AppAppid(this.o) && !TextUtils.isEmpty(this.n0)) {
            stringExtra = convert2WebviewFullPath(null, this.n0);
        } else {
            stringExtra = convert2WebviewFullPath(null, this.l0);
        }
        if (a((IApp) this) && !new File(a(BaseInfo.sConfigXML)).exists()) {
            stringExtra = TextUtils.isEmpty(this.m0) ? this.o1 : this.m0;
        }
        Uri data = getActivity().getIntent().getData();
        if (data != null && data.toString().endsWith(".html")) {
            stringExtra = data.toString();
        }
        if (this.q1) {
            stringExtra = convert2WebviewFullPath(null, "__uniappview.html");
        }
        Object objProcessEvent = this.y.processEvent(IMgr.MgrType.WindowMgr, i, new Object[]{this, stringExtra, Boolean.valueOf(this.T0), this.W0});
        if (objProcessEvent == null) {
            return true;
        }
        return Boolean.parseBoolean(String.valueOf(objProcessEvent));
    }

    void b(boolean z) {
        this.b.onAppUnActive(this);
        if (z) {
            callSysEventListener(ISysEventListener.SysEventType.onWebAppPause, this);
            callSysEventListener(ISysEventListener.SysEventType.onWebAppBackground, this);
        }
        IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            iAppStatusListener.onPause(this, null);
        }
        setStatus((byte) 2);
    }

    private void b() {
        if (q() || !s.c(getActivity())) {
            return;
        }
        ThreadPool.self().addThreadTask(new d(obtainAppId()));
    }

    public static String b(Context context) {
        return c(context).versionName;
    }

    private JSONObject a(InputStream inputStream) {
        try {
            if (!this.q) {
                inputStream = new UnicodeInputStream(inputStream, Charset.defaultCharset().name());
            }
            return new JSONObject(new String(IOUtil.getBytes(inputStream)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // io.dcloud.p.e5
    void a(Activity activity) {
        super.a(activity);
        AppStatusBarManager appStatusBarManager = this.m;
        if (appStatusBarManager != null) {
            appStatusBarManager.checkImmersedStatusBar(activity, this.b1);
            this.m.isFullScreen = isFullScreen();
        }
        this.l.mJsonViewOption = JSONUtil.createJSONObject("{}");
        this.f = PdrUtil.parseInt(SP.getBundleData(getActivity(), BaseInfo.PDR, "StatusBarHeight"), 0);
        updateScreenInfo(4);
        this.y1 = false;
        IActivityHandler iActivityHandler = DCloudAdapterUtil.getIActivityHandler(getActivity());
        if (!q() && iActivityHandler != null) {
            HashMap map = new HashMap();
            map.put(CreateShortResultReceiver.KEY_VERSIONNAME, this.A);
            map.put("appid", this.o);
            map.put("name", this.t0);
            map.put("adid", this.N0);
            map.put("bg", this.Y0);
            map.put(WXBasicComponentType.IMG, convert2AbsFullPath(this.Z0));
            k.a(getActivity(), this.o, "save", map);
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey(IntentConst.FROM_SHORT_CUT_STRAT) && extras.getBoolean(IntentConst.FROM_SHORT_CUT_STRAT)) {
                this.y1 = true;
            }
            if (extras != null && extras.containsKey(IntentConst.WEBAPP_ACTIVITY_CREATE_SHORTCUT)) {
                this.A1 = extras.getString(IntentConst.WEBAPP_ACTIVITY_CREATE_SHORTCUT);
            }
            if (extras != null && extras.containsKey("shortcutQuit")) {
                this.z1 = extras.getString("shortcutQuit");
            }
            if (extras != null && extras.containsKey(IntentConst.START_FORCE_SHORT_QUIT)) {
                this.z1 = extras.getString(IntentConst.START_FORCE_SHORT_QUIT);
            }
            if (intent.hasExtra(IntentConst.START_FORCE_SHORT)) {
                this.A1 = intent.getStringExtra(IntentConst.START_FORCE_SHORT);
            }
            if (TextUtils.isEmpty(this.A1)) {
                String launchType = BaseInfo.getLaunchType(intent);
                this.A1 = AbsoluteConst.INSTALL_OPTIONS_FORCE;
                if (launchType.equals("scheme")) {
                    this.A1 = "query";
                    return;
                }
                if (this.P) {
                    this.A1 = AbsoluteConst.INSTALL_OPTIONS_FORCE;
                    return;
                }
                String string = SP.getOrCreateBundle(activity, "pdr").getString(AbsoluteConst.TEST_RUN + this.o, null);
                if (!TextUtils.isEmpty(string) && string.equals("__am=t")) {
                    this.A1 = AbsoluteConst.INSTALL_OPTIONS_FORCE;
                } else {
                    this.A1 = "none";
                }
            }
        }
    }

    String a(String str) {
        return this.k0 + str;
    }

    void a(ICallBack iCallBack) {
        if ((BaseInfo.ISDEBUG || this.j0) && this.V == 1) {
            ThreadPool.self().addThreadTask(new c(iCallBack), true);
        } else {
            iCallBack.onCallBack(0, null);
        }
    }

    private boolean a(IApp iApp) {
        return (TextUtils.isEmpty(iApp.getOriginalDirectPage()) || iApp.obtainWebAppIntent().hasExtra(IntentConst.DIRECT_PAGE)) ? false : true;
    }

    boolean a(boolean z) {
        if (z) {
            this.r1 = null;
            this.y.processEvent(IMgr.MgrType.WindowMgr, 76, this);
        }
        setAppDataPath(BaseInfo.sCacheFsAppsPath + this.o + DeviceInfo.sSeparatorChar + BaseInfo.REAL_PRIVATE_WWW_DIR);
        boolean zB = b(this.o, null);
        if (!zB) {
            return zB;
        }
        setConfigProperty(IApp.ConfigProperty.CONFIG_funSetUA, String.valueOf(false));
        PermissionUtil.clearUseRejectedCache();
        showSplash();
        this.y.processEvent(IMgr.MgrType.FeatureMgr, 3, this.o);
        callSysEventListener(ISysEventListener.SysEventType.onWebAppReStart, null);
        this.g1 = false;
        TestUtil.record(AbsoluteConst.RUN_5AP_TIME_KEY);
        return b(10);
    }

    private void a() {
        IPdrModule iPdrModuleA;
        if (this.q) {
            return;
        }
        if (!SDK.isUniMPSDK()) {
            io.dcloud.p.b.o().a(this.a);
        }
        if (q() || (iPdrModuleA = r3.a().a("commit")) == null) {
            return;
        }
        String str = this.N0;
        JSONObject jSONObject = this.y.g;
        iPdrModuleA.execute("start_up", new Object[]{this, str, jSONObject != null ? jSONObject.optString("version") : "0.1"});
    }

    public static int a(Context context) {
        return c(context).versionCode;
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
    IFrameView a(IWebviewStateListener iWebviewStateListener) {
        t();
        return (IFrameView) this.y.processEvent(IMgr.MgrType.WindowMgr, 17, new Object[]{this, convert2WebviewFullPath(null, this.l0), iWebviewStateListener});
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
    IFrameView a(IWebviewStateListener iWebviewStateListener, IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        t();
        return (IFrameView) this.y.processEvent(IMgr.MgrType.WindowMgr, 17, new Object[]{this, convert2WebviewFullPath(null, this.l0), iWebviewStateListener, iDCloudWebviewClientListener});
    }

    private boolean a(ISysEventListener iSysEventListener, ISysEventListener.SysEventType sysEventType) {
        return !(iSysEventListener instanceof IBoot) || PdrUtil.parseBoolean(String.valueOf(this.y.processEvent(null, 1, iSysEventListener)), false, false) || !(sysEventType == ISysEventListener.SysEventType.onStart || sysEventType == ISysEventListener.SysEventType.onStop || sysEventType == ISysEventListener.SysEventType.onPause || sysEventType == ISysEventListener.SysEventType.onResume) || (iSysEventListener instanceof ReceiveSystemEventVoucher);
    }

    public static boolean a(ISysEventListener.SysEventType sysEventType) {
        return (sysEventType == ISysEventListener.SysEventType.onKeyDown || sysEventType == ISysEventListener.SysEventType.onKeyUp || sysEventType == ISysEventListener.SysEventType.onKeyLongPress) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x01df A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x01e7 A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01f5 A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0202 A[Catch: Exception -> 0x0289, LOOP:0: B:71:0x0200->B:72:0x0202, LOOP_END, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0229 A[Catch: Exception -> 0x0289, TRY_LEAVE, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x023e A[Catch: IOException -> 0x0278, Exception -> 0x0289, TryCatch #0 {IOException -> 0x0278, blocks: (B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c), top: B:105:0x0239, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x025c A[Catch: IOException -> 0x0278, Exception -> 0x0289, TRY_LEAVE, TryCatch #0 {IOException -> 0x0278, blocks: (B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c), top: B:105:0x0239, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02a6  */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x0202, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v27, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    boolean a(String str, JSONObject jSONObject) {
        String str2;
        boolean zA;
        byte b2;
        boolean z;
        ArrayList<XmlUtil.DHNode> elements;
        int size;
        int i;
        XmlUtil.DHNode element;
        f5 f5Var = this.s;
        f5Var.c = true;
        f5Var.d = true;
        String str3 = BaseInfo.sCacheFsAppsPath + this.o + DeviceInfo.sSeparatorChar + BaseInfo.APP_WWW_FS_DIR;
        StringBuilder sb = new StringBuilder();
        sb.append(str3.substring(0, str3.length() - 1));
        sb.append("_unzip");
        char c2 = File.separatorChar;
        sb.append(c2);
        String string = sb.toString();
        String str4 = str3.substring(0, str3.length() - 1) + "_backup" + c2;
        String str5 = str3.substring(0, str3.length() - 1) + "_backup1" + c2;
        ?? file = new File(str);
        ?? r8 = 0;
        String str6 = null;
        XmlUtil.DHNode dHNode = null;
        try {
            try {
                try {
                    try {
                        try {
                            DHFile.delete(string);
                            ZipUtils.upZipFile(file, string);
                            try {
                                file = DHFile.getInputStream(DHFile.createFileHandler(string + BaseInfo.WGTU_UPDATE_XML));
                                try {
                                    if (file == 0) {
                                        this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_UPDATE_NOT_EXIST, DOMException.MSG_RUNTIME_WGTU_UPDATE_NOT_EXIST);
                                        this.s.a = true;
                                        IOUtil.close((InputStream) file);
                                        return false;
                                    }
                                    XmlUtil.DHNode dHNodeXML_Parser = XmlUtil.XML_Parser(file);
                                    if (dHNodeXML_Parser != null) {
                                        String attributeValue = XmlUtil.getAttributeValue(dHNodeXML_Parser, "appid");
                                        String attributeValue2 = XmlUtil.getAttributeValue(XmlUtil.getElement(dHNodeXML_Parser, AbsoluteConst.XML_BASIS), "version");
                                        if (!BaseInfo.ISDEBUG && !this.o.equalsIgnoreCase(attributeValue)) {
                                            this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_UPDATE_APPID_NOT_MATCH, DOMException.MSG_RUNTIME_WGTU_UPDATE_APPID_NOT_MATCH);
                                        } else {
                                            if (!this.A.equals(attributeValue2) && !jSONObject.optBoolean(AbsoluteConst.INSTALL_OPTIONS_FORCE)) {
                                                this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_UPDATE_VERSION_NOT_MATCH, DOMException.MSG_RUNTIME_WGTU_UPDATE_VERSION_NOT_MATCH);
                                            } else {
                                                str2 = string + BaseInfo.APP_WWW_FS_DIR;
                                                try {
                                                    String str7 = str2 + BaseInfo.sConfigXML;
                                                    if (DHFile.isExist(str7)) {
                                                        InputStream inputStream = DHFile.getInputStream(DHFile.createFileHandler(str7));
                                                        zA = a(inputStream, this.o, jSONObject);
                                                        IOUtil.close(inputStream);
                                                        element = XmlUtil.getElement(dHNodeXML_Parser, AbsoluteConst.XML_REMOVE);
                                                        str6 = str2;
                                                    } else {
                                                        this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST, DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST);
                                                        this.s.a = true;
                                                        IOUtil.close((InputStream) file);
                                                        return false;
                                                    }
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    e.printStackTrace();
                                                    this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                    IOUtil.close((InputStream) file);
                                                    zA = false;
                                                }
                                            }
                                            IOUtil.close((InputStream) file);
                                            str2 = str6;
                                            dHNode = element;
                                            if (zA) {
                                                try {
                                                    DHFile.deleteFile(str4);
                                                    b2 = this.V;
                                                    if (b2 == 1) {
                                                        DHFile.copyDir(this.k0, str4);
                                                    } else {
                                                        if (b2 == 0) {
                                                            DHFile.copyFile(str3, str4, true, false);
                                                            z = true;
                                                        }
                                                        elements = XmlUtil.getElements(dHNode, AbsoluteConst.XML_ITEM);
                                                        if (elements != null && !elements.isEmpty()) {
                                                            size = elements.size();
                                                            for (i = 0; i < size; i++) {
                                                                DHFile.deleteFile(str4 + XmlUtil.getAttributeValue(elements.get(i), AbsoluteConst.XML_PATH));
                                                            }
                                                        }
                                                        if (1 != DHFile.copyFile(str2, str4, true, false)) {
                                                            DHFile.deleteFile(str4);
                                                            this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                            this.s.a = true;
                                                            return false;
                                                        }
                                                        try {
                                                            DHFile.deleteFile(string);
                                                            if (z) {
                                                                DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                            }
                                                            DHFile.rename(str4, BaseInfo.APP_WWW_FS_DIR);
                                                            if (z) {
                                                                DHFile.deleteFile(str5);
                                                            }
                                                            b((byte) 0);
                                                            setAppDataPath(str3);
                                                            BaseInfo.BaseAppInfo baseAppInfo = new BaseInfo.BaseAppInfo(this.o, this.A);
                                                            this.t = baseAppInfo;
                                                            baseAppInfo.saveToBundleData(getActivity());
                                                        } catch (IOException e3) {
                                                            e3.printStackTrace();
                                                            this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                            this.s.a = true;
                                                            return false;
                                                        }
                                                    }
                                                    z = false;
                                                    elements = XmlUtil.getElements(dHNode, AbsoluteConst.XML_ITEM);
                                                    if (elements != null) {
                                                        size = elements.size();
                                                        while (i < size) {
                                                            DHFile.deleteFile(str4 + XmlUtil.getAttributeValue(elements.get(i), AbsoluteConst.XML_PATH));
                                                        }
                                                    }
                                                    if (1 != DHFile.copyFile(str2, str4, true, false)) {
                                                        DHFile.deleteFile(str4);
                                                        this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                        this.s.a = true;
                                                        return false;
                                                    }
                                                    DHFile.deleteFile(string);
                                                    if (z) {
                                                        DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                    }
                                                    DHFile.rename(str4, BaseInfo.APP_WWW_FS_DIR);
                                                    if (z) {
                                                        DHFile.deleteFile(str5);
                                                    }
                                                    b((byte) 0);
                                                    setAppDataPath(str3);
                                                    BaseInfo.BaseAppInfo baseAppInfo2 = new BaseInfo.BaseAppInfo(this.o, this.A);
                                                    this.t = baseAppInfo2;
                                                    baseAppInfo2.saveToBundleData(getActivity());
                                                } catch (Exception e4) {
                                                    e4.printStackTrace();
                                                    try {
                                                        DHFile.deleteFile(string);
                                                    } catch (IOException e5) {
                                                        e5.printStackTrace();
                                                    }
                                                    this.s.b = DOMException.toJSON(-99, DOMException.MSG_UNKNOWN_ERROR);
                                                    this.s.a = true;
                                                    return false;
                                                }
                                            } else {
                                                this.s.a = true;
                                                try {
                                                    DHFile.deleteFile(string);
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            return false;
                                        }
                                        element = null;
                                        zA = false;
                                        IOUtil.close((InputStream) file);
                                        str2 = str6;
                                        dHNode = element;
                                        if (zA) {
                                            DHFile.deleteFile(str4);
                                            b2 = this.V;
                                            if (b2 == 1) {
                                                DHFile.copyDir(this.k0, str4);
                                            } else {
                                                if (b2 == 0) {
                                                    DHFile.copyFile(str3, str4, true, false);
                                                    z = true;
                                                }
                                                elements = XmlUtil.getElements(dHNode, AbsoluteConst.XML_ITEM);
                                                if (elements != null) {
                                                    size = elements.size();
                                                    while (i < size) {
                                                        DHFile.deleteFile(str4 + XmlUtil.getAttributeValue(elements.get(i), AbsoluteConst.XML_PATH));
                                                    }
                                                }
                                                if (1 != DHFile.copyFile(str2, str4, true, false)) {
                                                    DHFile.deleteFile(str4);
                                                    this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                    this.s.a = true;
                                                    return false;
                                                }
                                                DHFile.deleteFile(string);
                                                if (z) {
                                                    DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                }
                                                DHFile.rename(str4, BaseInfo.APP_WWW_FS_DIR);
                                                if (z) {
                                                    DHFile.deleteFile(str5);
                                                }
                                                b((byte) 0);
                                                setAppDataPath(str3);
                                                BaseInfo.BaseAppInfo baseAppInfo3 = new BaseInfo.BaseAppInfo(this.o, this.A);
                                                this.t = baseAppInfo3;
                                                baseAppInfo3.saveToBundleData(getActivity());
                                            }
                                            z = false;
                                            elements = XmlUtil.getElements(dHNode, AbsoluteConst.XML_ITEM);
                                            if (elements != null) {
                                                size = elements.size();
                                                while (i < size) {
                                                    DHFile.deleteFile(str4 + XmlUtil.getAttributeValue(elements.get(i), AbsoluteConst.XML_PATH));
                                                }
                                            }
                                            if (1 != DHFile.copyFile(str2, str4, true, false)) {
                                                DHFile.deleteFile(str4);
                                                this.s.b = DOMException.toJSON(-5, DOMException.MSG_IO_ERROR);
                                                this.s.a = true;
                                                return false;
                                            }
                                            DHFile.deleteFile(string);
                                            if (z) {
                                                DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                            }
                                            DHFile.rename(str4, BaseInfo.APP_WWW_FS_DIR);
                                            if (z) {
                                                DHFile.deleteFile(str5);
                                            }
                                            b((byte) 0);
                                            setAppDataPath(str3);
                                            BaseInfo.BaseAppInfo baseAppInfo4 = new BaseInfo.BaseAppInfo(this.o, this.A);
                                            this.t = baseAppInfo4;
                                            baseAppInfo4.saveToBundleData(getActivity());
                                        } else {
                                            this.s.a = true;
                                            DHFile.deleteFile(string);
                                        }
                                        return false;
                                    }
                                    throw new Exception();
                                } catch (Exception e7) {
                                    e = e7;
                                    e.printStackTrace();
                                    this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGTU_UPDATE_ERROR_MALFORMED, DOMException.MSG_RUNTIME_WGTU_UPDATE_ERROR_MALFORMED);
                                    this.s.a = true;
                                    IOUtil.close((InputStream) file);
                                    return false;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                file = 0;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            str2 = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r8 = file;
                        IOUtil.close((InputStream) r8);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    file = 0;
                    str2 = null;
                }
            } catch (FileNotFoundException unused) {
                DHFile.delete(string);
                this.s.b = DOMException.toJSON(-4, DOMException.MSG_FILE_NOT_EXIST);
                this.s.a = true;
                IOUtil.close((InputStream) null);
                return false;
            } catch (Exception e11) {
                Logger.w(e11);
                DHFile.delete(string);
                this.s.b = DOMException.toJSON(DOMException.CODE_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED, DOMException.MSG_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED);
                this.s.a = true;
                IOUtil.close((InputStream) null);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String a(byte b2) {
        byte b3 = this.V;
        if (b3 != 1) {
            if (b3 != 0) {
                return null;
            }
            return DeviceInfo.FILE_PROTOCOL + this.k0;
        }
        return BaseInfo.sBaseResAppsFullPath + this.o + "/" + BaseInfo.APP_WWW_FS_DIR;
    }

    public void a(String str, int i) {
        this.E1.put(str, Integer.valueOf(i));
        if (TextUtils.isEmpty(this.F1)) {
            this.F1 = str + "=" + i;
        } else {
            this.F1 += "&" + str + "=" + i;
        }
        SP.getOrCreateBundle(getActivity(), this.o + "_1").edit().putString("Authorize", this.F1).commit();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    private boolean a(JSONObject jSONObject, f5 f5Var) {
        boolean z;
        if (jSONObject == null || !jSONObject.has(IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL)) {
            z = true;
        } else {
            String strOptString = jSONObject.optString(IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
            if (TextUtils.isEmpty(strOptString) || !strOptString.equals(AbsoluteConst.UNI_V3)) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            f5Var.a = true;
            f5Var.b = DOMException.toJSON(DOMException.CODE_RUNTIME_COMPONENTS_MODE_NOT_SUPPORT, DOMException.MSG_RUNTIME_COMPONENTS_MODE_NOT_SUPPORT);
        }
        return z;
    }
}
