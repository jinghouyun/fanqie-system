package io.dcloud.feature.weex;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.android.bindingx.plugin.weex.BindingX;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.taobao.weex.IWXStatisticsListener;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.RenderTypes;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.tools.TimeCalculator;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IConfusionMgr;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.INativeAppInfo;
import io.dcloud.common.DHInterface.IUniInstanceMgr;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.io.UnicodeInputStream;
import io.dcloud.common.adapter.ui.webview.WebLoadEvent;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.IOUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.language.LanguageUtil;
import io.dcloud.feature.internal.sdk.SDK;
import io.dcloud.feature.uniapp.UniSDKInstance;
import io.dcloud.feature.weex.adapter.DCDefaultConfigAdapter;
import io.dcloud.feature.weex.adapter.DCVueBridgeAdapter;
import io.dcloud.feature.weex.adapter.DCWXHttpAdapter;
import io.dcloud.feature.weex.adapter.DefaultWebSocketAdapterFactory;
import io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeView;
import io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpImagePipelineConfigFactory;
import io.dcloud.feature.weex.adapter.FrescoDrawableLoader;
import io.dcloud.feature.weex.adapter.FrescoImageAdapter;
import io.dcloud.feature.weex.adapter.FrescoImageComponent;
import io.dcloud.feature.weex.adapter.FrescoImageComponentU;
import io.dcloud.feature.weex.adapter.JSExceptionAdapter;
import io.dcloud.feature.weex.adapter.PlusUriAdapter;
import io.dcloud.feature.weex.adapter.ScalableViewComponent;
import io.dcloud.feature.weex.adapter.webview.WXDCWeb;
import io.dcloud.feature.weex.extend.DCCoverImageComponent;
import io.dcloud.feature.weex.extend.DCCoverViewComponent;
import io.dcloud.feature.weex.extend.DCTabBarModule;
import io.dcloud.feature.weex.extend.DCUniMPModule;
import io.dcloud.feature.weex.extend.DCWXSlider;
import io.dcloud.feature.weex.extend.DCWXView;
import io.dcloud.feature.weex.extend.PlusModule;
import io.dcloud.feature.weex.extend.PlusStorageModule;
import io.dcloud.feature.weex.extend.RandomBytesModule;
import io.dcloud.feature.weex.extend.WXEventModule;
import io.dcloud.feature.weex_websocket.UniWebSocketModule;
import io.dcloud.weex.MoudlesLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class WeexInstanceMgr implements IWXStatisticsListener, IUniInstanceMgr {
    static final String SERVICE_NAME = "weexPlus";
    private static WeexInstanceMgr instance;
    private AbsMgr featureMgr;
    private IConfusionMgr mConfusionMgr;
    private Handler mHandler;
    private ICallBack mRestartReadyCall;
    private StringBuffer sb;
    String TAG = "WeexInstanceMgr";
    private LinkedHashMap<String, WXViewWrapper> instanceHashMap = new LinkedHashMap<>(16);
    private HashMap<String, WXServiceWrapper> serviceWrapperMapsCache = new HashMap<>(3);
    private ArrayList<IWXStatisticsCallBack> callBacks = new ArrayList<>();
    private String mUniNViewModules = null;
    private ArrayList<ICallBack> mReladyCallBacks = new ArrayList<>();
    private String complier = "weex";
    private String render = "auto";
    private String jsSACName = "uni-app-config";
    private String control = AbsoluteConst.UNI_V3;
    private int mVueVersion = 2;
    private boolean isWeexInitEnd = false;
    private boolean isJsFrameworkReady = false;
    private Application mApplication = null;
    private boolean isAssetsRes = false;
    private boolean isJSFKFileNotFound = false;
    private boolean isUniServiceCreated = false;
    private String mPreUniAppid = null;
    private String mPreInstanceId = null;
    private Map<String, ICallBack> mPreUniMPCallBackMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    interface EachListener<T> {
        void onEach(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface IWXStatisticsCallBack {
        void onJsFrameworkReady();
    }

    private void clearHandler() {
        if (this.mHandler != null) {
            this.mHandler = null;
        }
    }

    private void forEach(EachListener eachListener) {
        try {
            Collection<WXViewWrapper> collectionValues = this.instanceHashMap.values();
            if (collectionValues != null) {
                for (WXViewWrapper wXViewWrapper : collectionValues) {
                    if (wXViewWrapper != null) {
                        eachListener.onEach(wXViewWrapper);
                    }
                }
            }
            Collection<WXServiceWrapper> collectionValues2 = this.serviceWrapperMapsCache.values();
            if (collectionValues2 != null) {
                for (WXServiceWrapper wXServiceWrapper : collectionValues2) {
                    if (wXServiceWrapper != null) {
                        eachListener.onEach(wXServiceWrapper);
                    }
                }
            }
        } catch (Exception e) {
            Logger.e("forEach---" + e.getMessage());
        }
    }

    private InputStream getAppFileStream(Context context, String str, String str2) {
        InputStream inputStreamOpen;
        String path;
        InputStream inputStreamOpen2 = null;
        try {
            AndroidResources.initAndroidResources(context);
            if (TextUtils.isEmpty(str)) {
                BaseInfo.parseControl();
            } else {
                BaseInfo.sDefaultBootApp = str;
            }
            boolean z = BaseInfo.ISDEBUG || DHFile.hasFile();
            String str3 = "apps/" + BaseInfo.sDefaultBootApp + "/www/" + str2;
            if (!this.isAssetsRes || BaseInfo.SyncDebug || SDK.isUniMPSDK()) {
                inputStreamOpen = null;
            } else {
                try {
                    inputStreamOpen = context.getResources().getAssets().open(str3);
                } catch (Exception unused) {
                    inputStreamOpen = null;
                }
            }
            if (inputStreamOpen != null) {
                return inputStreamOpen;
            }
            try {
                if (z) {
                    path = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
                } else {
                    path = context.getFilesDir().getPath();
                }
                File file = new File(path + "/" + str3);
                if (file.exists()) {
                    inputStreamOpen2 = new FileInputStream(file);
                } else {
                    try {
                        inputStreamOpen2 = context.getResources().getAssets().open(str3);
                    } catch (Exception unused2) {
                    }
                }
                if (inputStreamOpen2 == null) {
                    return inputStreamOpen;
                }
            } catch (Exception e) {
                e = e;
                inputStreamOpen2 = inputStreamOpen;
                e.printStackTrace();
            }
            return inputStreamOpen2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private String getConfigParam() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__HtMl_Id__", (Object) "__uniapp_webview");
        jSONObject.put(RenderTypes.RENDER_TYPE_NATIVE, (Object) 1);
        jSONObject.put(AbsoluteConst.XML_DEBUG, (Object) Boolean.TRUE);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(IApp.ConfigProperty.CONFIG_LANGUAGE, (Object) LanguageUtil.getDeviceDefLocalLanguage());
        jSONObject2.put("version", (Object) Build.VERSION.RELEASE);
        jSONObject2.put("name", (Object) TimeCalculator.PLATFORM_ANDROID);
        jSONObject2.put("vendor", (Object) "Google");
        jSONObject.put(WXConfig.os, (Object) jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("CONNECTION_TYPE", (Object) 0);
        jSONObject.put("networkinfo", (Object) jSONObject3);
        return jSONObject.toJSONString();
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    private String getUniFileStr(Context context, String str, String str2) {
        try {
            return IOUtil.toString(getAppFileStream(context, str, str2));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String handleEncryptionInputStream(InputStream inputStream, Context context, boolean z) {
        System.currentTimeMillis();
        if (z) {
            inputStream = new UnicodeInputStream(inputStream, Charset.defaultCharset().name());
        }
        byte[] bytes = new byte[0];
        try {
            bytes = IOUtil.getBytes(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IConfusionMgr iConfusionMgr = this.mConfusionMgr;
        String strHandleEncryption = iConfusionMgr != null ? iConfusionMgr.handleEncryption(context.getApplicationContext(), bytes) : null;
        return TextUtils.isEmpty(strHandleEncryption) ? new String(bytes) : strHandleEncryption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initJSFramework(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        InputStream appFileStream = getAppFileStream(context, str, BaseInfo.sConfigXML);
        if (appFileStream != null) {
            try {
                JSONObject object = JSON.parseObject(handleEncryptionInputStream(appFileStream, context, true));
                if (object == null || !object.containsKey(IApp.ConfigProperty.CONFIG_PLUS)) {
                    return;
                }
                JSONObject jSONObject3 = object.getJSONObject(IApp.ConfigProperty.CONFIG_PLUS);
                if (jSONObject3 != null && jSONObject3.containsKey("uni-app")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("uni-app");
                    self().control = AbsoluteConst.UNI_V3;
                    if (jSONObject4.containsKey("renderer")) {
                        self().render = jSONObject4.getString("renderer");
                    }
                    if (jSONObject4.containsKey("nvueCompiler")) {
                        self().complier = jSONObject4.getString("nvueCompiler");
                    }
                    if (jSONObject4.containsKey("vueVersion")) {
                        self().mVueVersion = jSONObject4.getIntValue("vueVersion");
                    } else {
                        self().mVueVersion = 2;
                    }
                    if (jSONObject4.containsKey("useJSProcess")) {
                        if (AbsoluteConst.FALSE.equals(jSONObject4.getString("useJSProcess"))) {
                            WXBridgeManager.getInstance().setUseSingleProcess(true);
                        } else {
                            WXBridgeManager.getInstance().setUseSingleProcess(false);
                        }
                    }
                    if (jSONObject4.containsKey("webView") && (jSONObject2 = jSONObject4.getJSONObject("webView")) != null) {
                        try {
                            if (jSONObject2.containsKey("minUserAgentVersion")) {
                                BaseInfo.minUserAgentVersion = jSONObject2.getString("minUserAgentVersion");
                            }
                            if (jSONObject2.containsKey("x5")) {
                                JSONObject jSONObject5 = jSONObject2.getJSONObject("x5");
                                if (jSONObject5.containsKey("timeOut")) {
                                    BaseInfo.timeOut = jSONObject5.getIntValue("timeOut");
                                }
                                if (jSONObject5.containsKey("showTipsWithoutWifi")) {
                                    BaseInfo.showTipsWithoutWifi = jSONObject5.getBooleanValue("showTipsWithoutWifi");
                                }
                                if (jSONObject5.containsKey("allowDownloadWithoutWiFi")) {
                                    BaseInfo.allowDownloadWithoutWiFi = jSONObject5.getBooleanValue("allowDownloadWithoutWiFi");
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                if (jSONObject3 != null && jSONObject3.containsKey(IApp.ConfigProperty.CONFIG_UNISTATISTICS) && (jSONObject = jSONObject3.getJSONObject(IApp.ConfigProperty.CONFIG_UNISTATISTICS)) != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        if (jSONObject.containsKey(WebLoadEvent.ENABLE)) {
                            jSONObject6.put(WebLoadEvent.ENABLE, jSONObject.get(WebLoadEvent.ENABLE));
                        }
                        if (jSONObject.containsKey("version")) {
                            jSONObject6.put("version", jSONObject.get("version"));
                        }
                        if (jSONObject.containsKey("uniCloud")) {
                            jSONObject6.put("uniCloud", (Object) jSONObject.getJSONObject("uniCloud"));
                        }
                        AppRuntime.setUniStatistics(jSONObject6.toJSONString());
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject3 == null || !jSONObject3.containsKey("renderer")) {
                    return;
                }
                BaseInfo.renderer = jSONObject3.getString("renderer");
            } catch (Exception unused3) {
            }
        }
    }

    private WXViewWrapper makeWXViewWrapper(IWebview iWebview, ViewGroup viewGroup, org.json.JSONObject jSONObject, String str, int i) {
        WXViewWrapper wXViewWrapperRemove;
        WXSDKInstance wXSDKInstance;
        WXViewWrapper wXViewWrapper = new WXViewWrapper(iWebview, viewGroup, jSONObject, str, i, (!str.equals("__uniapp__service") || this.mPreUniAppid == null || WXSDKManager.getInstance().getSDKInstance(this.mPreInstanceId) == null) ? false : true);
        if (this.instanceHashMap.containsKey(str) && (wXViewWrapperRemove = this.instanceHashMap.remove(str)) != null && (wXSDKInstance = wXViewWrapperRemove.mWXSDKInstance) != null) {
            wXSDKInstance.destroy();
        }
        this.instanceHashMap.put(str, wXViewWrapper);
        return wXViewWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preUniControlService(Application application, String str) {
        this.isUniServiceCreated = true;
        this.mPreUniAppid = str;
        UniSDKInstance uniSDKInstance = new UniSDKInstance(application);
        this.mPreInstanceId = uniSDKInstance.getInstanceId();
        String uniFileStr = getUniFileStr(application, str, "app-service.js");
        String uniFileStr2 = getUniFileStr(application, str, "app-config.js");
        HashMap map = new HashMap();
        map.put("plus_appid", str);
        map.put("preload", Boolean.TRUE);
        map.put("bundleUrl", "app-service.js");
        uniSDKInstance.render("__uniapp__service", (uniFileStr2 + uniFileStr + " plus.weexBridge.preloadReady('" + str + "');").replaceFirst(Pattern.quote("\"use weex:vue\""), Matcher.quoteReplacement("")), map, new org.json.JSONObject().toString(), WXRenderStrategy.APPEND_ASYNC);
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("preUniControlService------");
        sb.append(str);
        Logger.e(str2, sb.toString());
    }

    private void registerReflexWeexPlugin(Context context) {
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_amap.AMapPluginImpl", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex.map.google.GoogleMapPluginImpl", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_scroller.DCScrollerPluginImpl", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_barcode.BarcodePlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.utsplugin.UTSPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_livepusher.LivePusherPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_media.VideoPlayerPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_text.DCWXTextPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_input.DCWXInputRegister", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.gcanvas.GCanvasRegister", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_switch.DCWXSwitchPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        PlatformUtil.invokeMethod("io.dcloud.feature.weex_ad.DCWXAdPlugin", "initPlugin", null, new Class[]{Context.class}, new Object[]{context});
        Object objInvokeFieldValue = PlatformUtil.invokeFieldValue("com.taobao.weex.devtools.inspector.elements.android.WXComponentDescriptor", "sClassName", null);
        if (objInvokeFieldValue == null || !(objInvokeFieldValue instanceof HashMap)) {
            return;
        }
        HashMap map = (HashMap) objInvokeFieldValue;
        map.put(FrescoImageComponent.class, "image");
        map.put(FrescoImageComponentU.class, "image");
        map.put(WXDCWeb.class, "web-view");
        map.put(DCWXView.class, WXBasicComponentType.VIEW);
        map.put(DCCoverViewComponent.class, "cover-view");
        map.put(DCWXSlider.class, WXBasicComponentType.SLIDER);
    }

    private void reloadWeexEngine() {
        unRegisterUniappService();
        WXSDKEngine.reload();
    }

    public static synchronized WeexInstanceMgr self() {
        if (instance == null) {
            instance = new WeexInstanceMgr();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterUniappService() {
        WXSDKEngine.unRegisterService(this.jsSACName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wrapperDestroy() {
        forEach(new EachListener<WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.7
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(WXBaseWrapper wXBaseWrapper) {
                if (wXBaseWrapper != null) {
                    wXBaseWrapper.onDestroy();
                }
            }
        });
        this.instanceHashMap.clear();
        this.serviceWrapperMapsCache.clear();
        if (SDK.isUniMPSDK()) {
            reloadWeexEngine();
        }
    }

    public void addComponentByName(String str, Class cls) {
        try {
            Object objInvokeFieldValue = PlatformUtil.invokeFieldValue("com.taobao.weex.devtools.inspector.elements.android.WXComponentDescriptor", "sClassName", null);
            if (objInvokeFieldValue == null || !(objInvokeFieldValue instanceof HashMap)) {
                return;
            }
            ((HashMap) objInvokeFieldValue).put(cls, str);
        } catch (Exception unused) {
        }
    }

    public WXServiceWrapper createWeexService(IApp iApp, ViewGroup viewGroup, String str, org.json.JSONObject jSONObject) {
        WXServiceWrapper wXServiceWrapper = new WXServiceWrapper(iApp, viewGroup, str, jSONObject);
        this.serviceWrapperMapsCache.put(str, wXServiceWrapper);
        return wXServiceWrapper;
    }

    public WXViewWrapper createWeexView(IWebview iWebview, ViewGroup viewGroup, org.json.JSONObject jSONObject, String str, int i) {
        WXViewWrapper wXViewWrapperMakeWXViewWrapper = makeWXViewWrapper(iWebview, viewGroup, jSONObject, str, i);
        wXViewWrapperMakeWXViewWrapper.loadTemplate(jSONObject);
        return wXViewWrapperMakeWXViewWrapper;
    }

    public Object doForFeature(IMgr.MgrType mgrType, int i, Object[] objArr) {
        AbsMgr absMgr = this.featureMgr;
        if (absMgr != null) {
            return absMgr.processEvent(mgrType, i, objArr);
        }
        return null;
    }

    public WXViewWrapper findPathByWrapper(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            String strInitSrcPath = wXViewWrapper.initSrcPath(str);
            String srcPath = wXViewWrapper.getSrcPath();
            if (!TextUtils.isEmpty(srcPath) && srcPath.equals(strInitSrcPath)) {
                return wXViewWrapper;
            }
        }
        return null;
    }

    WXBaseWrapper findWXBaseWrapper(String str) {
        if (this.serviceWrapperMapsCache.containsKey(str)) {
            return this.serviceWrapperMapsCache.get(str);
        }
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str);
        }
        return null;
    }

    public WXSDKInstance findWXSDKInstance(String str) {
        if (this.serviceWrapperMapsCache.containsKey(str)) {
            return this.serviceWrapperMapsCache.get(str).mWXSDKInstance;
        }
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str).mWXSDKInstance;
        }
        return null;
    }

    public WXServiceWrapper findWXServiceWrapper(WXSDKInstance wXSDKInstance) {
        if (this.serviceWrapperMapsCache.size() <= 0) {
            return null;
        }
        Iterator<String> it = this.serviceWrapperMapsCache.keySet().iterator();
        while (it.hasNext()) {
            WXServiceWrapper wXServiceWrapper = this.serviceWrapperMapsCache.get(it.next());
            if (wXServiceWrapper != null && wXServiceWrapper.mWXSDKInstance == wXSDKInstance) {
                return wXServiceWrapper;
            }
        }
        return null;
    }

    WXViewWrapper findWXViewWrapper(String str) {
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str);
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public IWebview findWebview(IWebview iWebview, IApp iApp, String str, String str2) {
        AbsMgr absMgr = this.featureMgr;
        IMgr.MgrType mgrType = IMgr.MgrType.FeatureMgr;
        Object obj = iWebview;
        if (iWebview == null) {
            obj = iApp;
        }
        Object objProcessEvent = absMgr.processEvent(mgrType, 10, new Object[]{obj, AbsoluteConst.F_UI, "findWebview", new String[]{str, str2}});
        if (objProcessEvent instanceof IWebview) {
            return (IWebview) objProcessEvent;
        }
        return null;
    }

    public IWebview findWebviewByInstanceId(String str) {
        Iterator<String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            if (wXViewWrapper != null && wXViewWrapper.mWXSDKInstance.getInstanceId().equals(str)) {
                return wXViewWrapper.mWebview;
            }
        }
        return null;
    }

    public String getComplier() {
        return this.complier;
    }

    public String getControl() {
        return this.control;
    }

    public String getPreInstanceId() {
        return this.mPreInstanceId;
    }

    public String getPreUniAppid() {
        return this.mPreUniAppid;
    }

    public ICallBack getPreUniMPCallBack(String str) {
        if (this.mPreUniMPCallBackMap.containsKey(str)) {
            return this.mPreUniMPCallBackMap.remove(str);
        }
        return null;
    }

    public String getUniMPFeature() {
        return "UniMP".toLowerCase(Locale.ENGLISH);
    }

    public String getUniNViewModules() {
        return this.mUniNViewModules;
    }

    public int getVueVersion() {
        return this.mVueVersion;
    }

    void init(AbsMgr absMgr) {
        this.featureMgr = absMgr;
    }

    public void initAppForPath(Context context, String str) {
        this.isAssetsRes = AppRuntime.isAppResourcesInAssetsPath(context, str);
    }

    public void initStatisticsListener() {
        WXSDKManager.getInstance().registerStatisticsListener(this);
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void initUniappPlugin(Application application) {
        MoudlesLoader.getInstance().onCreate(application);
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void initWeexEnv(INativeAppInfo iNativeAppInfo) {
        if (iNativeAppInfo != null) {
            this.mConfusionMgr = iNativeAppInfo.getCofusionMgr();
            initWeexEnv(iNativeAppInfo.getApplication());
        }
    }

    public boolean isJSFKFileNotFound() {
        return this.isJSFKFileNotFound;
    }

    public boolean isJsFrameworkReady() {
        return this.isJsFrameworkReady;
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public boolean isUniAppAssetsRes() {
        return this.isAssetsRes;
    }

    public boolean isUniServiceCreated(IApp iApp) {
        String strObtainConfigProperty = iApp.obtainConfigProperty(AbsoluteConst.NVUE_LAUNCH_MODE);
        if (!TextUtils.isEmpty(strObtainConfigProperty) && !strObtainConfigProperty.equals("fast") && getControl().equals(AbsoluteConst.UNI_V3)) {
            return this.isUniServiceCreated;
        }
        if (getControl().equals(Constants.CodeCache.SAVE_PATH)) {
            return this.isUniServiceCreated;
        }
        return true;
    }

    public boolean isWeexInitEnd() {
        return this.isWeexInitEnd;
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void loadWeexToAppid(Context context, String str, boolean z) {
        int vueVersion = getVueVersion();
        initAppForPath(context, str);
        initJSFramework(context, str);
        if (getVueVersion() != vueVersion) {
            z = true;
        }
        if (!WXBridgeManager.getInstance().isJSFrameworkInit() || z) {
            setJsFrameworkReady(false);
            WXSDKEngine.restartWeex();
        }
    }

    void onActivityDestroy() {
        onActivityDestroy(true);
    }

    void onActivityPause() {
        forEach(new EachListener<WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.3
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityPause();
            }
        });
    }

    void onActivityResult(final int i, final int i2, final Intent intent) {
        forEach(new EachListener<WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.4
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityResult(i, i2, intent);
            }
        });
    }

    void onActivityResume() {
        forEach(new EachListener<WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.2
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityResume();
            }
        });
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void onCreateProcess(Application application, Boolean bool) {
        MoudlesLoader.getInstance().initHooksClass(application, bool);
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onException(String str, String str2, String str3) {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onFirstScreen() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onFirstView() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHeadersReceived() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHttpFinish() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHttpStart() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onJsFrameworkReady() {
        this.isJsFrameworkReady = true;
        if (this.mRestartReadyCall != null) {
            MessageHandler.sendMessage(new MessageHandler.IMessages() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.9
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(Object obj) {
                    WeexInstanceMgr.this.mRestartReadyCall.onCallBack(1, null);
                    WeexInstanceMgr.this.mRestartReadyCall = null;
                }
            }, null);
        }
        ArrayList<IWXStatisticsCallBack> arrayList = this.callBacks;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                IWXStatisticsCallBack iWXStatisticsCallBack = arrayList.get(i);
                i++;
                iWXStatisticsCallBack.onJsFrameworkReady();
            }
        }
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onJsFrameworkStart() {
    }

    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        forEach(new EachListener<WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.8
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(WXBaseWrapper wXBaseWrapper) {
                if (wXBaseWrapper != null) {
                    wXBaseWrapper.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        });
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onSDKEngineInitialize() {
    }

    public void preUniMP(final Application application, final String str, ICallBack iCallBack) {
        if (!TextUtils.isEmpty(this.mPreUniAppid) && iCallBack != null) {
            iCallBack.onCallBack(-101, "");
            return;
        }
        if (iCallBack != null) {
            this.mPreUniMPCallBackMap.put(str, iCallBack);
        }
        if (isWeexInitEnd()) {
            restartWeex(application, new ICallBack() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.10
                @Override // io.dcloud.common.DHInterface.ICallBack
                public Object onCallBack(int i, Object obj) {
                    if (i != 1) {
                        return null;
                    }
                    WeexInstanceMgr.this.preUniControlService(application, str);
                    return null;
                }
            }, str);
        } else {
            initWeexEnv(application);
            preUniControlService(application, str);
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void registerUniappService(Context context, String str) {
        InputStream appFileStream;
        if (!self().control.equals(AbsoluteConst.UNI_V3) || (appFileStream = self().getAppFileStream(context, str, "app-config-service.js")) == null) {
            return;
        }
        try {
            WXSDKEngine.registerService(this.jsSACName, handleEncryptionInputStream(appFileStream, context, false), new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadWXServiceWrapper() {
        if (this.serviceWrapperMapsCache.size() > 0) {
            Iterator<String> it = this.serviceWrapperMapsCache.keySet().iterator();
            while (it.hasNext()) {
                WXServiceWrapper wXServiceWrapper = this.serviceWrapperMapsCache.get(it.next());
                if (wXServiceWrapper != null) {
                    wXServiceWrapper.reload();
                }
            }
        }
    }

    public void removeWeexView(String str) {
        if (this.instanceHashMap.containsKey(str)) {
            this.instanceHashMap.remove(str).onDestroy();
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void restartWeex(final Application application, final ICallBack iCallBack, final String str) {
        if (((getControl().equals(AbsoluteConst.UNI_V3) && isWeexInitEnd() && !BaseInfo.isFirstRun) || (SDK.isUniMPSDK() && isWeexInitEnd())) && this.mPreInstanceId == null) {
            Logger.e(this.TAG, "restartWeex-------");
            if (this.instanceHashMap.size() > 0) {
                onActivityDestroy(false);
            }
            getHandler().post(new Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    WeexInstanceMgr.this.unRegisterUniappService();
                    WeexInstanceMgr.this.mRestartReadyCall = iCallBack;
                    WeexInstanceMgr.this.mApplication = application;
                    WeexInstanceMgr weexInstanceMgr = WeexInstanceMgr.this;
                    weexInstanceMgr.initAppForPath(weexInstanceMgr.mApplication, str);
                    WeexInstanceMgr.this.setJsFrameworkReady(false);
                    WeexInstanceMgr.this.initJSFramework(application, str);
                    WeexInstanceMgr.this.registerUniappService(application, str);
                    WXSDKEngine.restartWeex();
                }
            });
        }
    }

    public void setApplication(Application application) {
        this.mApplication = application;
    }

    public void setJSFKFileNotFound(boolean z) {
        this.isJSFKFileNotFound = z;
    }

    public void setJsFrameworkReady(boolean z) {
        this.isJsFrameworkReady = z;
    }

    public void setUniNViewModuleReladyCallBack(ICallBack iCallBack) {
        if (this.mReladyCallBacks.contains(iCallBack)) {
            return;
        }
        this.mReladyCallBacks.add(iCallBack);
    }

    public void setUniNViewModules(String str) {
        this.mUniNViewModules = str;
        if (this.mReladyCallBacks.size() > 0) {
            ArrayList<ICallBack> arrayList = this.mReladyCallBacks;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                ICallBack iCallBack = arrayList.get(i);
                i++;
                iCallBack.onCallBack(0, str);
            }
            this.mReladyCallBacks.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public void setUniServiceCreated(boolean z, IApp iApp) {
        String strObtainConfigProperty;
        this.isUniServiceCreated = z;
        if (iApp != null) {
            strObtainConfigProperty = iApp.obtainConfigProperty(AbsoluteConst.NVUE_LAUNCH_MODE);
            if (TextUtils.isEmpty(strObtainConfigProperty)) {
                strObtainConfigProperty = "fast";
            }
        } else {
            strObtainConfigProperty = "fast";
        }
        if ((getControl().equals(Constants.CodeCache.SAVE_PATH) || (!strObtainConfigProperty.equals("fast") && getControl().equals(AbsoluteConst.UNI_V3))) && this.isUniServiceCreated) {
            Iterator<String> it = this.instanceHashMap.keySet().iterator();
            while (it.hasNext()) {
                WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
                if (wXViewWrapper != null && !wXViewWrapper.isService) {
                    wXViewWrapper.runDelayedRenderCaches(wXViewWrapper.getWaitServiceRenderList());
                }
            }
        }
    }

    public void setWXStatisticsCallBack(IWXStatisticsCallBack iWXStatisticsCallBack) {
        if (this.callBacks.contains(iWXStatisticsCallBack)) {
            return;
        }
        this.callBacks.add(iWXStatisticsCallBack);
    }

    public void setWeexInitEnd(boolean z) {
        this.isWeexInitEnd = z;
    }

    public void unWXStatisticsCallBack(IWXStatisticsCallBack iWXStatisticsCallBack) {
        if (this.callBacks.contains(iWXStatisticsCallBack)) {
            this.callBacks.remove(iWXStatisticsCallBack);
        }
    }

    public void weexDebugReload() {
        LinkedHashMap<String, WXViewWrapper> linkedHashMap = this.instanceHashMap;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        Iterator<String> it = this.instanceHashMap.keySet().iterator();
        if (it.hasNext()) {
            this.instanceHashMap.get(it.next()).mWebview.obtainFrameView().obtainWindowMgr().processEvent(IMgr.MgrType.AppMgr, 3, "snc:CID");
        }
    }

    void onActivityDestroy(boolean z) {
        this.mPreUniAppid = null;
        this.mPreInstanceId = null;
        if (this.instanceHashMap.size() > 0 || this.serviceWrapperMapsCache.size() > 0) {
            if (z) {
                getHandler().postDelayed(new Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.5
                    @Override // java.lang.Runnable
                    public void run() {
                        WeexInstanceMgr.this.wrapperDestroy();
                    }
                }, 200L);
            } else {
                getHandler().post(new Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.6
                    @Override // java.lang.Runnable
                    public void run() {
                        WeexInstanceMgr.this.wrapperDestroy();
                    }
                });
            }
        }
        this.mPreUniMPCallBackMap.clear();
        this.mApplication = null;
    }

    public void initWeexEnv(Application application) {
        if (!SDK.isUniMPSDK()) {
            PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "registerReloadReceiver", null, new Class[]{Application.class}, new Object[]{application});
        }
        self().setApplication(application);
        if (WXSDKEngine.isInitialized()) {
            return;
        }
        InitConfig.Builder builder = new InitConfig.Builder();
        self().initAppForPath(application, null);
        self().initJSFramework(application, null);
        if (!SDK.isUniMPSDK()) {
            PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "initDebugEnvironment", null, new Class[]{Application.class}, new Object[]{application});
        }
        DCWXHttpAdapter dCWXHttpAdapter = new DCWXHttpAdapter();
        builder.setHttpAdapter(dCWXHttpAdapter);
        Fresco.initialize(application, OkHttpImagePipelineConfigFactory.newBuilder(application, dCWXHttpAdapter.getImageOkHttpClient()).build());
        JSON.setDefaultTypeKey("@type_ft");
        DCGenericDraweeView.initialize(Fresco.getDraweeControllerBuilderSupplier());
        builder.setImgAdapter(new FrescoImageAdapter());
        builder.setDrawableLoader(new FrescoDrawableLoader(application));
        builder.setURIAdapter(new PlusUriAdapter());
        builder.setDCVueBridgeAdapter(new DCVueBridgeAdapter());
        builder.setWebSocketAdapterFactory(new DefaultWebSocketAdapterFactory());
        builder.setJSExceptionAdapter(new JSExceptionAdapter());
        InitConfig initConfigBuild = builder.build();
        WXSDKManager.getInstance().setWxConfigAdapter(new DCDefaultConfigAdapter());
        WXSDKEngine.initialize(application, initConfigBuild);
        self().initStatisticsListener();
        try {
            String str = new String(PlatformUtil.getFileContent("io/dcloud/weexUniJs.js", 1));
            this.sb = new StringBuffer();
            String configParam = self().getConfigParam();
            this.sb.append("var plusContext = {};plusContext.getLocationHerf = function(plus){\n    return plus.weex.config.bundleUrl;\n};var param = " + configParam + ";");
            this.sb.append(str);
            WXSDKEngine.registerComponent("image", (Class<? extends WXComponent>) FrescoImageComponent.class);
            WXSDKEngine.registerComponent("cover-view", (Class<? extends WXComponent>) DCCoverViewComponent.class);
            WXSDKEngine.registerComponent("u-image", (Class<? extends WXComponent>) FrescoImageComponentU.class);
            WXSDKEngine.registerComponent("cover-image", (Class<? extends WXComponent>) DCCoverImageComponent.class);
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(ScalableViewComponent.class, new ScalableViewComponent.Ceator()), false, "u-scalable");
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(DCWXSlider.class, new DCWXSlider.Creator()), true, WXBasicComponentType.SLIDER);
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(DCWXView.class, new DCWXView.Ceator()), false, WXBasicComponentType.VIEW);
            WXSDKEngine.registerComponent("u-web-view", (Class<? extends WXComponent>) WXDCWeb.class);
            WXSDKEngine.registerModule(IApp.ConfigProperty.CONFIG_PLUS, PlusModule.class);
            WXSDKEngine.registerModule("DCloud-Crypto", RandomBytesModule.class);
            WXSDKEngine.registerModule("plusstorage", PlusStorageModule.class);
            WXSDKEngine.registerModule("uni-tabview", DCTabBarModule.class);
            addComponentByName(WXBasicComponentType.DIV, ScalableViewComponent.class);
            if (PdrUtil.isUniMPHostForUniApp() && !SDK.isUniMPSDK()) {
                WXSDKEngine.registerModule("uniMP", DCUniMPModule.class);
            }
            WXSDKEngine.registerModule("event", WXEventModule.class);
            if (this.sb != null) {
                WXSDKEngine.registerService(SERVICE_NAME, this.sb.toString(), new HashMap());
            }
            if (!SDK.isUniMPSDK()) {
                self().registerUniappService(application, "");
            }
            WXEnvironment.setGlobalFontFamily("unincomponents", Typeface.createFromAsset(application.getAssets(), "fonts/unincomponents.ttf"));
            WXSDKEngine.registerModule("uni-webSocket", UniWebSocketModule.class);
            BindingX.register();
            registerReflexWeexPlugin(application);
            setWeexInitEnd(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WXBaseWrapper findWXBaseWrapper(WXSDKInstance wXSDKInstance) {
        Iterator<String> it = this.instanceHashMap.keySet().iterator();
        WXViewWrapper wXViewWrapper = null;
        while (it.hasNext()) {
            WXViewWrapper wXViewWrapper2 = this.instanceHashMap.get(it.next());
            if (wXViewWrapper2 != null && wXViewWrapper2.mWXSDKInstance == wXSDKInstance) {
                wXViewWrapper = wXViewWrapper2;
            }
        }
        return wXViewWrapper;
    }

    public IWebview findWebview(WXSDKInstance wXSDKInstance) {
        Iterator<String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            if (wXViewWrapper != null && wXViewWrapper.mWXSDKInstance == wXSDKInstance) {
                return wXViewWrapper.mWebview;
            }
        }
        return null;
    }
}
