package io.dcloud.feature.ui;

import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.common.Constants;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXWeb;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IContainerView;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.INativeBitmap;
import io.dcloud.common.DHInterface.INativeView;
import io.dcloud.common.DHInterface.ITitleNView;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaContainerFrameItem;
import io.dcloud.common.adapter.ui.AdaFrameItem;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.adapter.ui.AdaUniWebView;
import io.dcloud.common.adapter.ui.AdaWebViewParent;
import io.dcloud.common.adapter.ui.AdaWebview;
import io.dcloud.common.adapter.ui.ReceiveJSValue;
import io.dcloud.common.adapter.ui.webview.WebResUtil;
import io.dcloud.common.adapter.util.AnimOptions;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.ViewOptions;
import io.dcloud.common.adapter.util.ViewRect;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.core.ui.DCKeyboardManager;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.SubNViewsUtil;
import io.dcloud.common.util.TestUtil;
import io.dcloud.common.util.ThreadPool;
import io.dcloud.common.util.TitleNViewUtil;
import io.dcloud.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class c extends io.dcloud.feature.ui.b implements IEventCallback {
    private static final HashMap d0;
    int A;
    Object B;
    boolean C;
    boolean D;
    int E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    protected ArrayList M;
    String N;
    String O;
    IWebview P;
    String Q;
    IWebview R;
    String S;
    IWebview T;
    String U;
    private boolean V;
    c W;
    private ArrayList X;
    private boolean Y;
    private String Z;
    private int a0;
    private boolean b0;
    Runnable c0;
    long u;
    JSONArray v;
    IWebview w;
    JSONObject x;
    IFrameView y;
    String z;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.y.obtainWebView().checkWhite(c.this.Z)) {
                c.this.l();
            } else {
                c.this.a(AbsoluteConst.EVENTS_WEBVIEW_RENDERED, "{}", false);
            }
            c.this.c0 = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements ReceiveJSValue.ReceiveJSValueCallback {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        b(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback
        public String callback(JSONArray jSONArray) {
            Object obj;
            String string = JSONUtil.getString(jSONArray, 0);
            try {
                obj = jSONArray.get(1);
            } catch (JSONException unused) {
                obj = null;
            }
            if ((obj instanceof String) || "string".equals(string)) {
                Deprecated_JSUtil.execCallback(this.a, this.b, String.valueOf(obj), JSUtil.OK, false, false);
            } else if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || "object".equals(string) || !Constants.Name.UNDEFINED.equals(string)) {
                Deprecated_JSUtil.execCallback(this.a, this.b, obj.toString(), JSUtil.OK, true, false);
            } else {
                Deprecated_JSUtil.execCallback(this.a, this.b, Constants.Name.UNDEFINED, JSUtil.OK, true, false);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.ui.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class RunnableC0045c implements Runnable {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        RunnableC0045c(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.evalJSSync(this.b, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements MessageHandler.UncheckedCallable {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        class a implements ICallBack {
            final /* synthetic */ MessageHandler.WaitableRunnable a;

            a(MessageHandler.WaitableRunnable waitableRunnable) {
                this.a = waitableRunnable;
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                MessageHandler.WaitableRunnable waitableRunnable = this.a;
                if (waitableRunnable == null) {
                    return null;
                }
                waitableRunnable.callBack(obj);
                return null;
            }
        }

        d(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.UncheckedCallable
        public void run(MessageHandler.WaitableRunnable waitableRunnable) {
            try {
                this.a.evalJSSync(this.b, new a(waitableRunnable));
            } catch (Exception e) {
                e.printStackTrace();
                if (waitableRunnable != null) {
                    waitableRunnable.callBack("");
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements Runnable {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;

        e(IWebview iWebview, String str, IWebview iWebview2, String str2) {
            this.a = iWebview;
            this.b = str;
            this.c = iWebview2;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean zCheckWhite = this.a.checkWhite(this.b);
                IWebview iWebview = this.c;
                String str = this.d;
                StringBuilder sb = new StringBuilder("{\"code\":100,\"rendered\":");
                sb.append(!zCheckWhite);
                sb.append(Operators.BLOCK_END_STR);
                Deprecated_JSUtil.execCallback(iWebview, str, sb.toString(), JSUtil.OK, true, false);
            } catch (Exception unused) {
                if (c.this.a() != null) {
                    Deprecated_JSUtil.execCallback(this.c, this.d, "{\"code\":-100,\"message\":\"" + c.this.a().getString(R.string.dcloud_common_screenshot_fail) + "\"}", JSUtil.ERROR, true, false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        f(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            Deprecated_JSUtil.execCallback(this.a, this.b, null, JSUtil.OK, false, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class g implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        g(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            Deprecated_JSUtil.execCallback(this.a, this.b, "{\"code\":-100,\"message\":\"" + this.a.getContext().getString(R.string.dcloud_common_screenshot_fail) + "\"}", JSUtil.ERROR, true, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class h implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        h(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            Deprecated_JSUtil.execCallback(this.a, this.b, null, JSUtil.OK, false, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class i implements ICallBack {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        i(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            IWebview iWebview = this.a;
            String str = this.b;
            StringBuilder sb = new StringBuilder("{\"code\":");
            sb.append(i);
            sb.append(",\"message\":\"");
            sb.append(obj != null ? obj.toString() : c.this.a().getString(R.string.dcloud_common_screenshot_fail));
            sb.append("\"}");
            Deprecated_JSUtil.execCallback(iWebview, str, sb.toString(), JSUtil.ERROR, true, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class j implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        j(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TestUtil.PointTime.commitTid(c.this.a(), this.a, c.this.g, this.b, 10);
        }
    }

    static {
        HashMap map = new HashMap();
        d0 = map;
        map.put(AbsoluteConst.EVENTS_CLOSE, "onclose");
        map.put("loading", "onloading");
        map.put(AbsoluteConst.EVENTS_FAILED, "onerror");
        map.put(AbsoluteConst.EVENTS_LOADED, "onloaded");
    }

    c(io.dcloud.feature.ui.a aVar, String str, String str2, String str3, JSONObject jSONObject) {
        this(aVar, null, str, str2, str3, jSONObject);
    }

    private INativeBitmap g(IWebview iWebview, String str) {
        return (INativeBitmap) iWebview.obtainApp().obtainMgrData(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", "getNativeBitmap", new String[]{iWebview.obtainApp().obtainAppId(), str}});
    }

    private void i() {
        if (this.y.getFrameType() == 6) {
            ThreadPool.self().addThreadTask(new j(this.c.f.obtainAppId(), this.c.f.obtainConfigProperty("adid")));
        }
    }

    private void j() {
        View viewObtainMainView = this.y.obtainMainView();
        if (viewObtainMainView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) viewObtainMainView;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ITitleNView) {
                    childAt.bringToFront();
                    return;
                }
            }
        }
    }

    private boolean k() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.F && cVar.k();
        }
        return true;
    }

    private void s() {
        this.c.b(this);
        if (!this.I) {
            d().onDispose();
            d().dispose();
        } else if (!this.J) {
            if (this.L) {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.c(this);
                }
                d().onDispose();
                d().dispose();
            } else {
                ((AdaFrameItem) this.y).getAnimOptions().mOption = (byte) 1;
            }
        }
        e();
    }

    private void t() {
        ((AdaFrameItem) this.y).getAnimOptions().mOption = (byte) 3;
        this.F = false;
        this.G = true;
    }

    @Override // io.dcloud.feature.ui.b
    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    public void b(boolean z) {
        this.Y = z;
    }

    protected io.dcloud.feature.ui.b c(String str) {
        ArrayList arrayList = this.M;
        io.dcloud.feature.ui.b bVar = null;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int size = this.M.size() - 1; size >= 0; size--) {
                bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (PdrUtil.isEquals(str, bVar.f)) {
                    return bVar;
                }
            }
        }
        return bVar;
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
    protected void d(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "maps", "appendToFrameView", new Object[]{this.y, str}});
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
    protected void e(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", "addNativeView", new Object[]{this.y, str}});
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
    protected void f(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "videoplayer", "appendToFrameView", new Object[]{this.y, str}});
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
    protected void h(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", "removeNativeView", new Object[]{this.y, str}});
    }

    public void l() {
        HashMap map = this.m;
        if (map == null || !map.containsKey(AbsoluteConst.EVENTS_WEBVIEW_RENDERED)) {
            return;
        }
        Runnable runnable = this.c0;
        if (runnable != null) {
            MessageHandler.removeCallbacks(runnable);
        }
        a aVar = new a();
        this.c0 = aVar;
        MessageHandler.postDelayed(aVar, this.a0);
    }

    public String m() {
        IWebview iWebviewObtainWebView = this.y.obtainWebView();
        if (iWebviewObtainWebView != null) {
            return iWebviewObtainWebView.obtainFrameId();
        }
        return null;
    }

    protected String n() {
        ViewOptions viewOptionsObtainFrameOptions = ((AdaFrameItem) this.y).obtainFrameOptions();
        return StringUtil.format("{top:%d,left:%d,width:%d,height:%d}", Integer.valueOf((int) (viewOptionsObtainFrameOptions.top / viewOptionsObtainFrameOptions.mWebviewScale)), Integer.valueOf((int) (viewOptionsObtainFrameOptions.left / viewOptionsObtainFrameOptions.mWebviewScale)), Integer.valueOf((int) (viewOptionsObtainFrameOptions.width / viewOptionsObtainFrameOptions.mWebviewScale)), Integer.valueOf((int) (viewOptionsObtainFrameOptions.height / viewOptionsObtainFrameOptions.mWebviewScale)));
    }

    public boolean o() {
        return !this.y.isWebviewCovered();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0034  */
    /* JADX WARN: Code duplicated, block: B:88:0x0147  */
    @Override // io.dcloud.common.DHInterface.IEventCallback
    public Object onCallBack(String str, Object obj) {
        IWebview iWebview;
        byte b2 = 2;
        Logger.d("yl", "NWindow.onCallBack pEventType=" + str, obj);
        str.getClass();
        str.hashCode();
        switch (str) {
            case "listenResourceLoading":
                Deprecated_JSUtil.execCallback(this.T, this.S, (String) obj, JSUtil.OK, true, true);
                return null;
            case "onresize":
                q();
                return null;
            case "dragBounce":
            case "slideBounce":
            case "titleNViewSearchInputFocusChanged":
            case "resize":
            case "titleNViewSearchInputConfirmed":
            case "titleNViewSearchInputChanged":
                a(str, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj), false);
                return null;
            case "touchstart":
                HashMap map = this.m;
                if (map != null && map.containsKey(AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START)) {
                    a(str, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj));
                }
                return null;
            case "hide_loading":
                this.c.d(this);
                return null;
            case "progressChanged":
                a(str, StringUtil.format("{progress:%s,target:%s}", obj, "plus.webview._find__Window_By_UUID__('" + this.f + "','" + this.e + "')"), false);
                return null;
            case "show_animation_end":
                if (!PdrUtil.isEmpty(this.O) && (iWebview = this.P) != null) {
                    Deprecated_JSUtil.execCallback(iWebview, this.O, "", JSUtil.OK, false, false);
                }
                a(AbsoluteConst.EVENTS_WEBVIEW_SHOW, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj));
                return null;
            case "popGesture":
                Object[] objArr = (Object[]) obj;
                String str2 = (String) objArr[0];
                Object obj2 = objArr[1];
                c cVarA = this.c.a((IFrameView) objArr[2]);
                a(str, StringUtil.format("{type:'%s', result:%s, private_args:{uuid:'%s',id:'%s',extras:'%s'}}", str2, obj2, cVarA.e, cVarA.f, cVarA.x), false);
                return null;
            case "overrideUrlLoading":
                Deprecated_JSUtil.execCallback(this.R, this.Q, (String) obj, JSUtil.OK, true, true);
                return null;
            case "slide_webview_hide":
                t();
                return null;
            case "titleUpdate":
                a(str, StringUtil.format("{title:%s}", obj == null ? "''" : JSONObject.quote(obj.toString())), false);
                l();
                return null;
            case "slide_webview_close":
                s();
                return null;
            case "titleNViewSearchInputClicked":
                a(str, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj));
                return null;
            case "show_loading":
                if (this.I) {
                    this.c.f(this);
                }
                return null;
            default:
                String str3 = (String) d0.get(str);
                if (!PdrUtil.isEmpty(str3)) {
                    a(str3, obj, this.c.c, this);
                }
                str.hashCode();
                switch (str.hashCode()) {
                    case -1183076191:
                        if (!str.equals(AbsoluteConst.EVENTS_WEBVIEW_RESUME)) {
                            b2 = -1;
                        } else {
                            b2 = 0;
                        }
                        break;
                    case -1097519099:
                        if (!str.equals(AbsoluteConst.EVENTS_LOADED)) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case -787126039:
                        if (!str.equals(AbsoluteConst.EVENTS_WINDOW_CLOSE)) {
                            b2 = -1;
                        }
                        break;
                    case -732864766:
                        if (!str.equals(AbsoluteConst.EVENTS_WEBVIEW_PAUSE)) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case 3202370:
                        if (!str.equals("hide")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    case 94756344:
                        if (!str.equals(AbsoluteConst.EVENTS_CLOSE)) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case 301767451:
                        if (!str.equals(AbsoluteConst.EVENTS_PULL_TO_REFRESH)) {
                            b2 = -1;
                        } else {
                            b2 = 6;
                        }
                        break;
                    case 336650556:
                        if (!str.equals("loading")) {
                            b2 = -1;
                        } else {
                            b2 = 7;
                        }
                        break;
                    case 1839654540:
                        if (!str.equals(AbsoluteConst.EVENTS_RENDERING)) {
                            b2 = -1;
                        } else {
                            b2 = 8;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                        a(str, "{}", false);
                        return null;
                    case 1:
                        this.A = -1;
                        JSONArray jSONArray = this.v;
                        if (jSONArray != null) {
                            a(this.w, jSONArray, this, this.y.obtainApp().obtainAppId());
                        }
                        TestUtil.print(TestUtil.CREATE_WEBVIEW, this.z + " 从加载完成分发loaded事件到开始分发事件 " + str);
                        StringBuilder sb = new StringBuilder("EVENTS_LOADED mUrl=");
                        sb.append(this.z);
                        Logger.d(Logger.MAIN_TAG, sb.toString());
                        a(str, "{}", false);
                        return null;
                    case 2:
                        a(str, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj));
                        g();
                        return null;
                    case 5:
                        this.c.b(this);
                        a(str, "{}", false);
                        return null;
                    default:
                        a(str, PdrUtil.isEmpty(obj) ? null : String.valueOf(obj));
                        return null;
                }
        }
    }

    public boolean p() {
        return this.b0;
    }

    protected void q() {
    }

    public IWebview r() {
        return this.y.obtainWebView();
    }

    private c(io.dcloud.feature.ui.a aVar, IFrameView iFrameView, String str, String str2, String str3, JSONObject jSONObject) {
        super("NWindow");
        this.u = System.currentTimeMillis();
        this.v = null;
        this.w = null;
        this.x = null;
        this.A = -1;
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = true;
        this.W = null;
        this.X = null;
        this.Y = false;
        this.Z = "auto";
        this.a0 = 150;
        this.b0 = false;
        this.c0 = null;
        this.c = aVar;
        this.z = str;
        this.e = str3;
        this.h = jSONObject;
        a(iFrameView, str2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
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
    private void e(IWebview iWebview, JSONArray jSONArray, c cVar) {
        boolean z;
        boolean z2;
        char c;
        JSONObject jSONObject;
        boolean z3;
        if (cVar.J) {
            return;
        }
        AdaFrameItem adaFrameItemObtainWebviewParent = (AdaFrameItem) cVar.y;
        ViewOptions viewOptionsObtainFrameOptions = adaFrameItemObtainWebviewParent.obtainFrameOptions();
        JSONObject jSONObject2 = JSONUtil.getJSONObject(jSONArray, 0);
        if (!viewOptionsObtainFrameOptions.isTabItem.booleanValue() || jSONObject2.isNull("background")) {
            z = false;
        } else {
            try {
                String string = JSONUtil.getString(jSONObject2, "background");
                jSONObject2.remove("background");
                jSONObject2.put(AbsoluteConst.JSON_KEY_TABBG, string);
                z = true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                z = false;
            }
        }
        boolean zA = a(jSONObject2, true);
        boolean zIsNull = jSONObject2.isNull("background");
        if (zIsNull) {
            z2 = false;
        } else {
            String lowerCase = JSONUtil.getString(jSONObject2, "background").toLowerCase(Locale.ENGLISH);
            if (TextUtils.isEmpty(lowerCase) || !lowerCase.equals("transparent")) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!jSONObject2.isNull(AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT) && JSONUtil.getBoolean(jSONObject2, AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT)) {
            ((AdaWebview) cVar.y.obtainWebView()).setBgcolor(0);
        }
        if (cVar.K || (!zIsNull && !z2)) {
            if (zIsNull) {
                c = 0;
            } else {
                try {
                    String string2 = JSONUtil.getString(jSONObject2, "background");
                    if (jSONObject2.isNull(AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG)) {
                        c = 0;
                    } else {
                        c = 0;
                        try {
                            viewOptionsObtainFrameOptions.mJsonViewOption.put(AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG, JSONUtil.getString(jSONObject2, AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG));
                        } catch (JSONException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                    viewOptionsObtainFrameOptions.mJsonViewOption.put("background", string2);
                    if (jSONObject2.has(AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
                        viewOptionsObtainFrameOptions.mJsonViewOption.put(AbsoluteConst.JSON_KEY_DEBUG_REFRESH, JSONUtil.getJSONObject(jSONObject2, AbsoluteConst.JSON_KEY_DEBUG_REFRESH));
                    }
                    if (jSONObject2.has("isUniH5")) {
                        viewOptionsObtainFrameOptions.mJsonViewOption.put("isUniH5", JSONUtil.getBoolean(jSONObject2, "isUniH5"));
                    }
                    viewOptionsObtainFrameOptions.updateViewData(viewOptionsObtainFrameOptions.mJsonViewOption);
                } catch (JSONException e4) {
                    e = e4;
                    c = 0;
                }
            }
            JSONObject jSONObject3 = adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView != null ? adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView : null;
            adaFrameItemObtainWebviewParent = cVar.y.obtainWebviewParent();
            if (jSONObject3 != null && adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView == null) {
                adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView = jSONObject3;
            }
            if (adaFrameItemObtainWebviewParent.obtainFrameOptions().getParentViewRect() == null) {
                AbsMgr absMgr = this.c.d;
                IMgr.MgrType mgrType = IMgr.MgrType.WindowMgr;
                Object[] objArr = new Object[1];
                objArr[c] = cVar.y;
                absMgr.processEvent(mgrType, 74, objArr);
            }
        }
        if (viewOptionsObtainFrameOptions.hasBackground()) {
            adaFrameItemObtainWebviewParent = cVar.y.obtainWebviewParent();
        }
        adaFrameItemObtainWebviewParent.obtainFrameOptions().allowUpdate = true;
        ViewOptions viewOptionsObtainFrameOptions2 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
        int i2 = viewOptionsObtainFrameOptions2.maskColor;
        try {
            jSONObject = viewOptionsObtainFrameOptions2.titleNView != null ? new JSONObject(viewOptionsObtainFrameOptions2.titleNView.toString()) : null;
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        ViewOptions viewOptionsCreateViewOptionsData = ViewOptions.createViewOptionsData(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions2.getParentViewRect());
        IWebview iWebviewObtainWebView = this.y.obtainWebView();
        iWebviewObtainWebView.setWebviewProperty(AbsoluteConst.JSON_KEY_SHAREABLE, jSONObject2.optString(AbsoluteConst.JSON_KEY_SHAREABLE));
        if (!JSONUtil.isNull(jSONObject2, AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN)) {
            iWebviewObtainWebView.setWebviewProperty(AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN, jSONObject2.optString(AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN));
        }
        if (jSONObject2.has(AbsoluteConst.EVENTS_PULL_TO_REFRESH)) {
            cVar.y.obtainWebView().setWebViewEvent(AbsoluteConst.PULL_DOWN_REFRESH, JSONUtil.combinJSONObject(viewOptionsObtainFrameOptions2.mPullToRefresh, JSONUtil.getJSONObject(jSONObject2, AbsoluteConst.EVENTS_PULL_TO_REFRESH)));
        }
        if (!JSONUtil.isNull(jSONObject2, "bounce")) {
            iWebviewObtainWebView.setWebviewProperty("bounce", jSONObject2.optString("bounce"));
        }
        iWebview.setWebViewCacheMode(viewOptionsCreateViewOptionsData.mCacheMode);
        JSONUtil.combinJSONObject(this.h, jSONObject2);
        f();
        if (!JSONUtil.isNull(jSONObject2, "titleNView")) {
            a(iWebview, cVar, jSONObject, jSONObject2.optJSONObject("titleNView"));
        } else if (!JSONUtil.isNull(jSONObject2, "navigationbar")) {
            a(iWebview, cVar, jSONObject, jSONObject2.optJSONObject("navigationbar"));
        }
        if (!JSONUtil.isNull(jSONObject2, AbsoluteConst.JSON_KEY_UNINVIEW)) {
            a(cVar, jSONObject2.optJSONObject(AbsoluteConst.JSON_KEY_UNINVIEW));
        }
        if (cVar.I) {
            int i3 = viewOptionsCreateViewOptionsData.background;
            float f2 = viewOptionsCreateViewOptionsData.opacity;
            boolean zUpdateViewData = viewOptionsCreateViewOptionsData.updateViewData(jSONObject2);
            z3 = z;
            boolean z4 = (PdrUtil.checkAlphaTransparent(i3) != PdrUtil.checkAlphaTransparent(viewOptionsCreateViewOptionsData.background)) | (f2 != viewOptionsCreateViewOptionsData.opacity);
            if (jSONObject2.has(AbsoluteConst.JSON_KEY_RENDER)) {
                cVar.y.setNeedRender(PdrUtil.isEquals(jSONObject2.optString(AbsoluteConst.JSON_KEY_RENDER, "onscreen"), "always"));
            }
            cVar.K = viewOptionsCreateViewOptionsData.hasBackground();
            if (!JSONUtil.isNull(jSONObject2, AbsoluteConst.JSON_KEY_SCROLLINDICATOR)) {
                iWebviewObtainWebView.setScrollIndicator(viewOptionsCreateViewOptionsData.getScrollIndicator());
            }
            if (!JSONUtil.isNull(jSONObject2, AbsoluteConst.JSON_KEY_SCALABLE)) {
                iWebviewObtainWebView.setWebviewProperty(AbsoluteConst.JSON_KEY_SCALABLE, String.valueOf(viewOptionsCreateViewOptionsData.scalable));
            }
            iWebviewObtainWebView.setWebviewProperty("injection", viewOptionsCreateViewOptionsData.mInjection);
            iWebviewObtainWebView.setWebviewProperty("plusrequire", viewOptionsCreateViewOptionsData.mPlusrequire);
            iWebviewObtainWebView.setWebviewProperty("geolocation", viewOptionsCreateViewOptionsData.mGeoInject);
            AnimOptions animOptions = adaFrameItemObtainWebviewParent.getAnimOptions();
            if (JSONUtil.isNull(jSONObject2, AbsoluteConst.JSON_KEY_TRANSITION)) {
                animOptions.duration = 0;
            } else {
                animOptions.parseTransition(viewOptionsCreateViewOptionsData.transition);
                if (viewOptionsCreateViewOptionsData.transition.isNull("duration")) {
                    animOptions.duration = 0;
                }
            }
            if (!JSONUtil.isNull(jSONObject2, "transform")) {
                animOptions.parseTransform(viewOptionsCreateViewOptionsData.transform);
            }
            if (zUpdateViewData || zA || z4) {
                this.y.setFrameOptions_Animate(viewOptionsCreateViewOptionsData);
                adaFrameItemObtainWebviewParent.setFrameOptions_Animate(viewOptionsCreateViewOptionsData);
                ((AdaFrameItem) cVar.y).getAnimOptions().mOption = (byte) 2;
                IFrameView iFrameView = cVar.y;
                Boolean boolValueOf = Boolean.valueOf(zUpdateViewData);
                if (zUpdateViewData) {
                    zA = false;
                }
                this.c.d.processEvent(IMgr.MgrType.WindowMgr, 7, new Object[]{iFrameView, boolValueOf, Boolean.valueOf(zA), Boolean.valueOf(z4)});
            } else {
                viewOptionsObtainFrameOptions2.updateViewData(jSONObject2);
                if (i2 != viewOptionsCreateViewOptionsData.maskColor) {
                    adaFrameItemObtainWebviewParent.obtainFrameOptions().maskColor = viewOptionsCreateViewOptionsData.maskColor;
                    ((AdaFrameView) cVar.y).obtainFrameOptions().maskColor = viewOptionsCreateViewOptionsData.maskColor;
                    ((AdaFrameView) cVar.y).obtainMainView().invalidate();
                }
            }
        } else {
            z3 = z;
            boolean zUpdateViewData2 = adaFrameItemObtainWebviewParent.obtainFrameOptions().updateViewData(jSONObject2);
            adaFrameItemObtainWebviewParent.obtainFrameOptions_Birth().updateViewData(jSONObject2);
            ViewOptions viewOptionsObtainFrameOptions3 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
            iWebviewObtainWebView.setScrollIndicator(viewOptionsObtainFrameOptions3.getScrollIndicator());
            iWebviewObtainWebView.setWebviewProperty(AbsoluteConst.JSON_KEY_SCALABLE, String.valueOf(viewOptionsObtainFrameOptions3.scalable));
            iWebviewObtainWebView.setWebviewProperty("injection", viewOptionsCreateViewOptionsData.mInjection);
            iWebviewObtainWebView.setWebviewProperty("plusrequire", viewOptionsCreateViewOptionsData.mPlusrequire);
            iWebviewObtainWebView.setWebviewProperty("geolocation", viewOptionsCreateViewOptionsData.mGeoInject);
            if (zUpdateViewData2) {
                ViewOptions viewOptionsObtainFrameOptions4 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
                int i4 = viewOptionsObtainFrameOptions4.left;
                AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(cVar.y.obtainMainView(), viewOptionsObtainFrameOptions4.left, viewOptionsObtainFrameOptions4.top, viewOptionsObtainFrameOptions4.width, viewOptionsObtainFrameOptions4.height);
            }
        }
        if (!zIsNull || z3) {
            this.c.d.processEvent(IMgr.MgrType.WindowMgr, 75, new Object[]{cVar.y});
        }
    }

    public boolean b(io.dcloud.feature.ui.b bVar) {
        ArrayList arrayList = this.M;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(bVar);
    }

    @Override // io.dcloud.feature.ui.b
    public AdaFrameItem d() {
        return (AdaFrameItem) this.y;
    }

    @Override // io.dcloud.feature.ui.b
    public String h() {
        if (PdrUtil.isEmpty(r().obtainFrameId())) {
            String str = this.e;
            String str2 = this.d;
            JSONObject jSONObject = this.x;
            return StringUtil.format("(function(){return {'uuid':'%s','id':%s,'identity':'%s','extras':%s}})()", str, Constants.Name.UNDEFINED, str2, jSONObject != null ? jSONObject.toString() : "{}");
        }
        String str3 = this.e;
        String strObtainFrameId = r().obtainFrameId();
        String str4 = this.d;
        JSONObject jSONObject2 = this.x;
        return StringUtil.format("(function(){return {'uuid':'%s','id':'%s','identity':'%s','extras':%s}})()", str3, strObtainFrameId, str4, jSONObject2 != null ? jSONObject2.toString() : "{}");
    }

    private void d(IWebview iWebview, JSONArray jSONArray, c cVar) {
        String string = JSONUtil.getString(jSONArray, 0);
        String string2 = JSONUtil.getString(jSONArray, 1);
        AnimOptions animOptions = ((AdaFrameItem) cVar.y).getAnimOptions();
        if (!PdrUtil.isEmpty(string2)) {
            animOptions.duration_close = PdrUtil.parseInt(string2, animOptions.duration_close);
        } else {
            animOptions.duration_close = animOptions.duration_show;
        }
        animOptions.setCloseAnimType(string);
        animOptions.mOption = (byte) 3;
        Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.hide view=" + cVar.d());
        if (cVar.F) {
            if (cVar.k()) {
                a(iWebview, JSONUtil.getJSONObject(jSONArray, 2), cVar, string);
                this.c.d.processEvent(IMgr.MgrType.WindowMgr, 23, cVar.y);
            } else {
                onCallBack("hide", null);
                cVar.y.setVisible(false, true);
            }
            cVar.F = false;
        } else {
            cVar.y.setVisible(false, true);
        }
        cVar.G = true;
    }

    public void a(boolean z) {
        this.b0 = z;
    }

    public void a(IFrameView iFrameView, String str) {
        if (iFrameView != null) {
            this.y = iFrameView;
            IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
            if (iWebviewObtainWebView != null) {
                iWebviewObtainWebView.initWebviewUUID(this.e);
                iWebviewObtainWebView.setFrameId(str);
            }
        }
    }

    protected void b(c cVar) {
        if (this.X == null) {
            this.X = new ArrayList();
        }
        this.X.add(cVar);
        cVar.W = this;
        if (cVar.r() != null) {
            cVar.r().setOpener(r());
        }
    }

    protected void c(io.dcloud.feature.ui.b bVar) {
        ArrayList arrayList = this.M;
        if (arrayList == null || !arrayList.contains(bVar)) {
            return;
        }
        this.M.remove(bVar);
        bVar.a = null;
        byte bC = bVar.c();
        boolean z = bVar instanceof c;
        if (bC == io.dcloud.feature.ui.b.n) {
            this.y.obtainWebView().removeFrameItem(bVar.d());
            return;
        }
        if (bC == io.dcloud.feature.ui.b.o) {
            this.y.obtainWebviewParent().removeFrameItem(bVar.d());
        } else if (bC == io.dcloud.feature.ui.b.p) {
            this.y.removeFrameItem(bVar.d());
            if (z) {
                this.y.obtainWebviewParent().obtainFrameOptions().delRelViewRect(bVar.d().obtainFrameOptions());
            }
            d().resize();
        }
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
    protected void a(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "ad", "addNativeView", new Object[]{this.y, str}});
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0273  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:50:0x0117  */
    /* JADX WARN: Code duplicated, block: B:52:0x0126  */
    /* JADX WARN: Code duplicated, block: B:53:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0165  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0231  */
    /* JADX WARN: Code duplicated, block: B:98:0x0244  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [io.dcloud.common.DHInterface.IContainerView] */
    protected void a(io.dcloud.feature.ui.b bVar) {
        boolean z;
        JSONObject jSONObject;
        ViewOptions viewOptionsObtainFrameOptions;
        AdaWebViewParent adaWebViewParentObtainWebviewParent;
        ViewOptions viewOptionsObtainFrameOptions2;
        ViewOptions viewOptionsObtainFrameOptions3;
        ?? r16;
        int i2;
        int i3;
        int i4;
        int i5;
        AdaContainerFrameItem adaContainerFrameItem;
        String titleNViewId;
        Object titleNView;
        int i6;
        int iConvertToScreenInt;
        JSONObject jSONObject2;
        int i7;
        int i8;
        int i9;
        if (this.M == null) {
            this.M = new ArrayList(2);
        }
        AdaFrameItem adaFrameItemD = bVar.d();
        byte bC = bVar.c();
        if (bC == ViewRect.POSITION_DOCK) {
            adaFrameItemD.setPosition(bVar.b());
        } else {
            adaFrameItemD.setPosition(bC);
        }
        if (this.M.contains(bVar)) {
            return;
        }
        Object objObtainWebView = null;
        if (bVar instanceof c) {
            c cVar = (c) bVar;
            a(bVar, cVar);
            if (this.c.a(cVar) && this.F) {
                cVar.A = 4;
                this.c.f(cVar);
            }
            if (bVar.d().obtainMainView().getVisibility() != 0 && !cVar.G) {
                cVar.F = true;
                cVar.y.setVisible(true, true);
                IFrameView iFrameView = cVar.y;
                if (iFrameView instanceof AdaFrameView) {
                    ((AdaFrameView) iFrameView).dispatchFrameViewEvents(AbsoluteConst.EVENTS_CHILD_INITIALIZE_SHOW, null);
                }
                Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView set visible true");
            }
            this.c.c(cVar.y);
            Logger.d(Logger.VIEW_VISIBLE_TAG, "append " + cVar.y);
            cVar.L = true;
            cVar.I = true;
            if (cVar.r() != null && BaseInfo.isUniAppAppid(cVar.r().obtainApp())) {
                cVar.r().setIWebViewFocusable(true);
            }
        } else {
            if (bVar instanceof io.dcloud.feature.ui.d) {
                io.dcloud.feature.ui.d dVar = (io.dcloud.feature.ui.d) bVar;
                dVar.i();
                dVar.a(true);
            } else {
                z = false;
            }
            jSONObject = bVar.h;
            viewOptionsObtainFrameOptions = ((AdaFrameItem) this.y).obtainFrameOptions();
            adaWebViewParentObtainWebviewParent = this.y.obtainWebviewParent();
            viewOptionsObtainFrameOptions2 = adaWebViewParentObtainWebviewParent.obtainFrameOptions();
            viewOptionsObtainFrameOptions3 = adaFrameItemD.obtainFrameOptions();
            if (bC == io.dcloud.feature.ui.b.p) {
                objObtainWebView = this.y;
                viewOptionsObtainFrameOptions2.setParentViewRect(viewOptionsObtainFrameOptions.getParentViewRect());
                viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions);
            } else {
                if (bC == io.dcloud.feature.ui.b.o) {
                    objObtainWebView = this.y;
                } else if (bC == io.dcloud.feature.ui.b.n) {
                    objObtainWebView = this.y.obtainWebView();
                }
                viewOptionsObtainFrameOptions3.setParentViewRect(((AdaFrameView) this.y).obtainFrameOptions());
            }
            r16 = objObtainWebView;
            if (viewOptionsObtainFrameOptions.hasBackground()) {
                viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, viewOptionsObtainFrameOptions2.mWebviewScale);
                if (viewOptionsObtainFrameOptions3.hasBackground()) {
                    viewOptionsObtainFrameOptions3.left = 0;
                    viewOptionsObtainFrameOptions3.top = 0;
                    viewOptionsObtainFrameOptions3.anim_top = 0;
                    viewOptionsObtainFrameOptions3.anim_left = 0;
                }
            } else {
                viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height, viewOptionsObtainFrameOptions.mWebviewScale);
            }
            if (bC == io.dcloud.feature.ui.b.p) {
                viewOptionsObtainFrameOptions3.setParentViewRect(((AdaFrameItem) r16).obtainFrameOptions());
                ViewRect.layoutDockViewRect(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions3);
                adaWebViewParentObtainWebviewParent.mNeedOrientationUpdate = true;
                viewOptionsObtainFrameOptions2.putRelViewRect(viewOptionsObtainFrameOptions3);
                int i10 = viewOptionsObtainFrameOptions2.left;
                i8 = viewOptionsObtainFrameOptions2.top;
                int i11 = viewOptionsObtainFrameOptions2.width;
                i9 = viewOptionsObtainFrameOptions2.height;
                if (BaseInfo.isImmersive && viewOptionsObtainFrameOptions2.isStatusbar) {
                    if (!viewOptionsObtainFrameOptions.isHeightAbsolute()) {
                        i9 += DeviceInfo.sStatusBarHeight;
                    }
                    i8 += DeviceInfo.sStatusBarHeight;
                }
                Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.appendView ---> _webview left=" + i10 + ";top=" + i8 + ";width=" + i11 + ";height=" + i9);
                AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaWebViewParentObtainWebviewParent.obtainMainView(), i10, i8, i11, i9);
            }
            i2 = viewOptionsObtainFrameOptions3.width;
            i3 = viewOptionsObtainFrameOptions3.height;
            i4 = viewOptionsObtainFrameOptions3.left;
            i5 = viewOptionsObtainFrameOptions3.top;
            bVar.a(viewOptionsObtainFrameOptions2.left, viewOptionsObtainFrameOptions2.top, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, i2, i3);
            Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView=" + bVar.d());
            adaContainerFrameItem = (AdaContainerFrameItem) r16;
            adaFrameItemD.setParentFrameItem(adaContainerFrameItem);
            if (z) {
                if (bC == io.dcloud.feature.ui.b.n || viewOptionsObtainFrameOptions3.hasHeightAbsolutevalue() || (i7 = viewOptionsObtainFrameOptions2.height) <= 0) {
                    i6 = i3;
                } else {
                    i6 = i7;
                }
                a(r16, adaFrameItemD, adaFrameItemD.obtainMainView().getLayoutParams(), i4, i5, i2, i6);
                iConvertToScreenInt = i5;
                if (bC == io.dcloud.feature.ui.b.p && bVar.b() == io.dcloud.feature.ui.b.s && (jSONObject2 = viewOptionsObtainFrameOptions.titleNView) != null && TitleNViewUtil.isTitleTypeForDef(jSONObject2)) {
                    iConvertToScreenInt += PdrUtil.convertToScreenInt("44px", 0, 0, this.y.obtainWebView().getScale());
                }
                if (!viewOptionsObtainFrameOptions3.isStatusbar && viewOptionsObtainFrameOptions.isStatusbar) {
                    iConvertToScreenInt += DeviceInfo.sStatusBarHeight;
                    if (viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                        i6 -= DeviceInfo.sStatusBarHeight;
                    }
                }
                if (viewOptionsObtainFrameOptions3.isStatusbar && !viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                    i6 += DeviceInfo.sStatusBarHeight;
                }
                if (i6 < -1) {
                    i6 = -1;
                }
                AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaFrameItemD.obtainMainView(), i4, iConvertToScreenInt, i2, i6);
            } else {
                r16.addFrameItem(bVar.d(), AdaFrameItem.LayoutParamsUtil.createLayoutParams(i4, i5, i2, i3));
            }
            this.M.add(bVar);
            bVar.a = this;
            ((AdaFrameView) this.y).sortNativeViewBringToFront();
            if (adaContainerFrameItem.obtainFrameOptions().isStatusbar) {
                bVar.d().resize();
            }
            titleNViewId = TitleNViewUtil.getTitleNViewId(this.y);
            if (PdrUtil.isEmpty(titleNViewId) && (titleNView = TitleNViewUtil.getTitleNView(this.c.d, this.y.obtainWebView(), this.y, titleNViewId)) != null && (titleNView instanceof ITitleNView)) {
                ((ITitleNView) titleNView).reMeasure();
                return;
            }
            return;
        }
        z = true;
        jSONObject = bVar.h;
        viewOptionsObtainFrameOptions = ((AdaFrameItem) this.y).obtainFrameOptions();
        adaWebViewParentObtainWebviewParent = this.y.obtainWebviewParent();
        viewOptionsObtainFrameOptions2 = adaWebViewParentObtainWebviewParent.obtainFrameOptions();
        viewOptionsObtainFrameOptions3 = adaFrameItemD.obtainFrameOptions();
        if (bC == io.dcloud.feature.ui.b.p) {
            objObtainWebView = this.y;
            viewOptionsObtainFrameOptions2.setParentViewRect(viewOptionsObtainFrameOptions.getParentViewRect());
            viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions);
        } else {
            if (bC == io.dcloud.feature.ui.b.o) {
                objObtainWebView = this.y;
            } else if (bC == io.dcloud.feature.ui.b.n) {
                objObtainWebView = this.y.obtainWebView();
            }
            viewOptionsObtainFrameOptions3.setParentViewRect(((AdaFrameView) this.y).obtainFrameOptions());
        }
        r16 = objObtainWebView;
        if (viewOptionsObtainFrameOptions.hasBackground()) {
            viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, viewOptionsObtainFrameOptions2.mWebviewScale);
            if (viewOptionsObtainFrameOptions3.hasBackground()) {
                viewOptionsObtainFrameOptions3.left = 0;
                viewOptionsObtainFrameOptions3.top = 0;
                viewOptionsObtainFrameOptions3.anim_top = 0;
                viewOptionsObtainFrameOptions3.anim_left = 0;
            }
        } else {
            viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height, viewOptionsObtainFrameOptions.mWebviewScale);
        }
        if (bC == io.dcloud.feature.ui.b.p) {
            viewOptionsObtainFrameOptions3.setParentViewRect(((AdaFrameItem) r16).obtainFrameOptions());
            ViewRect.layoutDockViewRect(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions3);
            adaWebViewParentObtainWebviewParent.mNeedOrientationUpdate = true;
            viewOptionsObtainFrameOptions2.putRelViewRect(viewOptionsObtainFrameOptions3);
            int i12 = viewOptionsObtainFrameOptions2.left;
            i8 = viewOptionsObtainFrameOptions2.top;
            int i13 = viewOptionsObtainFrameOptions2.width;
            i9 = viewOptionsObtainFrameOptions2.height;
            if (BaseInfo.isImmersive) {
                if (!viewOptionsObtainFrameOptions.isHeightAbsolute()) {
                    i9 += DeviceInfo.sStatusBarHeight;
                }
                i8 += DeviceInfo.sStatusBarHeight;
            }
            Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.appendView ---> _webview left=" + i12 + ";top=" + i8 + ";width=" + i13 + ";height=" + i9);
            AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaWebViewParentObtainWebviewParent.obtainMainView(), i12, i8, i13, i9);
        }
        i2 = viewOptionsObtainFrameOptions3.width;
        i3 = viewOptionsObtainFrameOptions3.height;
        i4 = viewOptionsObtainFrameOptions3.left;
        i5 = viewOptionsObtainFrameOptions3.top;
        bVar.a(viewOptionsObtainFrameOptions2.left, viewOptionsObtainFrameOptions2.top, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, i2, i3);
        Logger.d(Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView=" + bVar.d());
        adaContainerFrameItem = (AdaContainerFrameItem) r16;
        adaFrameItemD.setParentFrameItem(adaContainerFrameItem);
        if (z) {
            if (bC == io.dcloud.feature.ui.b.n) {
                i6 = i3;
            } else {
                i6 = i3;
            }
            a(r16, adaFrameItemD, adaFrameItemD.obtainMainView().getLayoutParams(), i4, i5, i2, i6);
            iConvertToScreenInt = i5;
            if (bC == io.dcloud.feature.ui.b.p) {
                iConvertToScreenInt += PdrUtil.convertToScreenInt("44px", 0, 0, this.y.obtainWebView().getScale());
            }
            if (!viewOptionsObtainFrameOptions3.isStatusbar) {
                iConvertToScreenInt += DeviceInfo.sStatusBarHeight;
                if (viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                    i6 -= DeviceInfo.sStatusBarHeight;
                }
            }
            if (viewOptionsObtainFrameOptions3.isStatusbar) {
                i6 += DeviceInfo.sStatusBarHeight;
            }
            if (i6 < -1) {
                i6 = -1;
            }
            AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaFrameItemD.obtainMainView(), i4, iConvertToScreenInt, i2, i6);
        } else {
            r16.addFrameItem(bVar.d(), AdaFrameItem.LayoutParamsUtil.createLayoutParams(i4, i5, i2, i3));
        }
        this.M.add(bVar);
        bVar.a = this;
        ((AdaFrameView) this.y).sortNativeViewBringToFront();
        if (adaContainerFrameItem.obtainFrameOptions().isStatusbar) {
            bVar.d().resize();
        }
        titleNViewId = TitleNViewUtil.getTitleNViewId(this.y);
        if (PdrUtil.isEmpty(titleNViewId)) {
        }
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
    protected void b(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "barcode", "appendToFrameView", new Object[]{this.y, str}});
    }

    void b(IWebview iWebview, JSONArray jSONArray, c cVar) {
        if (cVar.I) {
            if (!cVar.J) {
                this.c.b(cVar);
                if (cVar.L) {
                    c cVar2 = cVar.a;
                    if (cVar2 != null) {
                        cVar2.c(cVar);
                    }
                    cVar.d().onDispose();
                    cVar.d().dispose();
                } else {
                    String string = JSONUtil.getString(jSONArray, 0);
                    String string2 = JSONUtil.getString(jSONArray, 1);
                    AnimOptions animOptions = ((AdaFrameItem) cVar.y).getAnimOptions();
                    if (PdrUtil.isEmpty(string)) {
                        string = "auto";
                    }
                    if (!PdrUtil.isEmpty(string2)) {
                        animOptions.duration_close = PdrUtil.parseInt(string2, animOptions.duration_close);
                    } else if (string.equals(AnimOptions.ANIM_POP_OUT)) {
                        animOptions.duration_close = 360;
                    } else {
                        animOptions.duration_close = animOptions.duration_show;
                    }
                    animOptions.setCloseAnimType(string);
                    animOptions.mOption = (byte) 1;
                    a(iWebview, JSONUtil.getJSONObject(jSONArray, 2), cVar, string);
                    this.c.d.processEvent(IMgr.MgrType.WindowMgr, 2, cVar.y);
                }
            }
        } else {
            this.c.b(cVar);
            cVar.d().onDispose();
            cVar.d().dispose();
        }
        cVar.e();
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
    protected void c(IWebview iWebview, String str) {
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "livepusher", "appendToFrameView", new Object[]{this.y, str}});
    }

    private void c(IWebview iWebview, JSONArray jSONArray, c cVar) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        Rect rect;
        String string = JSONUtil.getString(jSONArray, 0);
        String string2 = JSONUtil.getString(jSONArray, 1);
        View viewObtainMainView = this.c.a(string2, string2, (String) null).d().obtainMainView();
        String string3 = JSONUtil.getString(jSONArray, 2);
        JSONObject jSONObject = JSONUtil.getJSONObject(jSONArray, 3);
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("check", false);
            boolean zOptBoolean2 = jSONObject.optBoolean("checkKeyboard", false);
            boolean zOptBoolean3 = jSONObject.optBoolean("wholeContent");
            String strOptString = jSONObject.optString("bit", "RGB565");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clip");
            if (jSONObjectOptJSONObject != null) {
                int width = viewObtainMainView.getWidth();
                int height = viewObtainMainView.getHeight();
                float scale = iWebview.getScale();
                Rect rect2 = new Rect(PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("left"), width, 0, scale), PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("top"), height, 0, scale), PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("width"), width, width, scale), PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("height"), height, height, scale));
                str = strOptString;
                z3 = zOptBoolean3;
                rect = rect2;
                z = zOptBoolean;
                z2 = zOptBoolean2;
            } else {
                str = strOptString;
                z2 = zOptBoolean2;
                z3 = zOptBoolean3;
                rect = null;
                z = zOptBoolean;
            }
        } else {
            str = "RGB565";
            z = false;
            z2 = false;
            z3 = false;
            rect = null;
        }
        iWebview.obtainFrameView().draw(viewObtainMainView, g(iWebview, string), z, z2, z3, rect, str, TextUtils.isEmpty(string3) ? null : new h(iWebview, string3), TextUtils.isEmpty(string3) ? null : new i(iWebview, string3));
    }

    boolean b(String str, String str2, boolean z) {
        ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (bVar instanceof c) {
                    c cVar = (c) bVar;
                    if (cVar.F && cVar.b(str, str2, z)) {
                        return true;
                    }
                }
            }
        }
        return a(str) && a(str, str2, z);
    }

    boolean c(String str, String str2, boolean z) {
        ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (bVar instanceof c) {
                    c cVar = (c) bVar;
                    if (cVar.F && cVar.c(str, str2, z)) {
                        return true;
                    }
                }
            }
        }
        if (a(str)) {
            return a(str, str2, z);
        }
        IFrameView iFrameView = this.y;
        if (iFrameView instanceof AdaFrameView) {
            String str3 = ((AdaFrameView) iFrameView).obtainFrameOptions().historyBack;
            if ((str3.equals("backButton") || str3.equals("all")) && this.y.obtainWebView() != null && this.y.obtainWebView().canGoBack()) {
                this.y.obtainWebView().goBackOrForward(-1);
                return true;
            }
        }
        if ("hide".equals(d().obtainFrameOptions().backButtonAutoControl)) {
            d(this.y.obtainWebView(), JSONUtil.createJSONArray("['auto',null]"), this);
            return true;
        }
        if ("quit".equals(d().obtainFrameOptions().backButtonAutoControl)) {
            this.c.d.processEvent(IMgr.MgrType.WindowMgr, 20, this.y.obtainApp());
            return false;
        }
        if (!AbsoluteConst.EVENTS_CLOSE.equals(d().obtainFrameOptions().backButtonAutoControl)) {
            return false;
        }
        b(this.y.obtainWebView(), JSONUtil.createJSONArray("['auto',null]"), this);
        return true;
    }

    boolean b(String str) {
        ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if ((bVar instanceof c) && ((c) bVar).a(str)) {
                    return true;
                }
            }
        }
        return a(str);
    }

    private void a(io.dcloud.feature.ui.b bVar, c cVar) {
        if (!BaseInfo.isBase(bVar.a()) || this.z.startsWith(DeviceInfo.HTTP_PROTOCOL) || this.z.startsWith(DeviceInfo.HTTPS_PROTOCOL) || cVar.z.startsWith(DeviceInfo.HTTP_PROTOCOL) || cVar.z.startsWith(DeviceInfo.HTTPS_PROTOCOL) || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(cVar.z)) {
            return;
        }
        Log.i(AbsoluteConst.HBUILDER_TAG, StringUtil.format(AbsoluteConst.FILIATIONLOG, io.dcloud.feature.ui.e.c(WebResUtil.getHBuilderPrintUrl(cVar.r().obtainApp().convert2RelPath(r().obtainUrl()))), io.dcloud.feature.ui.e.c(WebResUtil.getHBuilderPrintUrl(cVar.r().obtainUrl()))));
    }

    private static void a(IContainerView iContainerView, AdaFrameItem adaFrameItem, ViewGroup.LayoutParams layoutParams, int i2, int i3, int i4, int i5) {
        ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
        viewOptionsObtainFrameOptions.left = i2;
        viewOptionsObtainFrameOptions.top = i3;
        viewOptionsObtainFrameOptions.width = i4;
        viewOptionsObtainFrameOptions.height = i5;
        viewOptionsObtainFrameOptions.commitUpdate2JSONObject();
        AdaFrameView adaFrameView = (AdaFrameView) adaFrameItem;
        adaFrameView.isChildOfFrameView = true;
        View viewObtainMainView = adaFrameItem.obtainMainView();
        if (adaFrameView.obtainWebView().isUniWebView()) {
            viewObtainMainView.layout(0, 0, i4, i5);
        } else {
            viewObtainMainView.setTop(0);
            viewObtainMainView.setLeft(0);
        }
        ViewHelper.setX(viewObtainMainView, 0.0f);
        ViewHelper.setY(viewObtainMainView, 0.0f);
        iContainerView.addFrameItem(adaFrameItem, AdaFrameItem.LayoutParamsUtil.createLayoutParams(i2, i3, i4, i5));
        Logger.d(Logger.VIEW_VISIBLE_TAG, "appendNWindow Y=" + ViewHelper.getY(viewObtainMainView));
    }

    @Override // io.dcloud.feature.ui.b
    protected void e() {
        ArrayList arrayList;
        i();
        c cVar = this.W;
        if (cVar != null && (arrayList = cVar.X) != null) {
            arrayList.remove(this);
        }
        this.W = null;
        this.a = null;
        ArrayList arrayList2 = this.M;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                ((io.dcloud.feature.ui.b) obj).e();
            }
            this.M.clear();
            this.M = null;
        }
        this.P = null;
        this.O = null;
        this.Q = null;
        this.R = null;
        this.a0 = 150;
        this.i = null;
        HashMap map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public static synchronized void a(String str, Object obj, List list, c cVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JSUtil.broadcastWebviewEvent(((c) it.next()).r(), cVar.e, str, JSONUtil.toJSONableString(String.valueOf(obj)));
        }
        if (list.contains(cVar)) {
            return;
        }
        JSUtil.broadcastWebviewEvent(cVar.r(), cVar.e, str, JSONUtil.toJSONableString(String.valueOf(obj)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
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
    @Override // io.dcloud.feature.ui.b
    public String a(IWebview iWebview, String str, JSONArray jSONArray) {
        String str2;
        Object objProcessEvent;
        JSONObject json;
        c cVar;
        IWebview iWebviewObtainWebView;
        Object objProcessEvent2;
        IWebview iWebviewObtainWebView2;
        HashMap<String, String> map;
        IWebview iWebviewObtainWebView3;
        IWebview iWebview2;
        IWebview iWebviewObtainWebView4;
        try {
            IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            String strObtainAppId = iAppObtainApp.obtainAppId();
            str2 = null;
            String nonString = "";
            try {
                switch (str.hashCode()) {
                    case -2087705423:
                        if (str.equals("getTitleNView")) {
                            objProcessEvent = this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{this.y.obtainWebView(), "nativeobj", "getNativeView", new Object[]{this.y, TitleNViewUtil.getTitleNViewId(this.y)}});
                            if (objProcessEvent != null && (objProcessEvent instanceof INativeView) && (json = ((INativeView) objProcessEvent).toJSON()) != null) {
                                return Deprecated_JSUtil.wrapJsVar(json.toString(), false);
                            }
                        }
                        return null;
                    case -2081275691:
                        if (str.equals("canForward")) {
                            Deprecated_JSUtil.execCallback(iWebview, JSONUtil.getString(jSONArray, 0), String.valueOf(this.y.obtainWebView().canGoForward()), JSUtil.OK, true, false);
                            return null;
                        }
                        return null;
                    case -2051330937:
                        if (str.equals(AbsoluteConst.EVENTS_LISTEN_RESOURCE_LOADING)) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                            this.S = jSONArray.optString(1);
                            this.T = iWebview;
                            this.y.obtainWebView().setListenResourceLoading(jSONObjectOptJSONObject);
                            return null;
                        }
                        return null;
                    case -2018969440:
                        if (str.equals("setFavoriteOptions")) {
                            this.y.obtainWebView().setWebviewProperty("setFavoriteOptions", jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1815848150:
                        if (str.equals("captureSnapshot")) {
                            a(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case -1679210541:
                        if (str.equals("setTitleNViewSearchInputFocus")) {
                            Object titleNView = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView instanceof ITitleNView) {
                                TitleNViewUtil.setTitleNViewSearchInputFocus((ITitleNView) titleNView, jSONArray.optString(0));
                                return null;
                            }
                        }
                        return null;
                    case -1525164844:
                        if (str.equals("appendPreloadJsFile")) {
                            this.y.obtainWebView().appendPreloadJsFile(this.y.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), JSONUtil.getString(jSONArray, 0)));
                            return null;
                        }
                        return null;
                    case -1476587689:
                        if (str.equals("showSoftKeybord")) {
                            IFrameView iFrameView = this.y;
                            if (iFrameView != null && iFrameView.obtainWebView().isUniService()) {
                                DeviceInfo.showIME(this.y.obtainMainView());
                                return null;
                            }
                            DeviceInfo.showIME(this.y.obtainMainView(), true);
                            return null;
                        }
                        return null;
                    case -1428651141:
                        if (str.equals("setRenderedEventOptions")) {
                            JSONObject jSONObject = JSONUtil.getJSONObject(jSONArray, 0);
                            this.Z = jSONObject.optString("type", this.Z);
                            this.a0 = jSONObject.optInt("interval", this.a0);
                            return null;
                        }
                        return null;
                    case -1411068134:
                        if (str.equals("append")) {
                            String string = JSONUtil.getString(jSONArray, 1);
                            io.dcloud.feature.ui.b bVarA = this.c.a(string);
                            if (bVarA == null) {
                                bVarA = this.c.a(string, string, (String) null);
                            }
                            if (!b(bVarA) && bVarA != null) {
                                a(bVarA);
                                return null;
                            }
                        }
                        return null;
                    case -1389361719:
                        if (str.equals("getNavigationbar")) {
                            objProcessEvent = this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{this.y.obtainWebView(), "nativeobj", "getNativeView", new Object[]{this.y, TitleNViewUtil.getTitleNViewId(this.y)}});
                            if (objProcessEvent != null) {
                                return Deprecated_JSUtil.wrapJsVar(json.toString(), false);
                            }
                        }
                        return null;
                    case -1295077293:
                        if (str.equals("setSoftinputTemporary")) {
                            DCKeyboardManager.getInstance().setHTMLInputRect(this.y.obtainWebView(), jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1291451675:
                        if (str.equals("evalJS")) {
                            String string2 = JSONUtil.getString(jSONArray, 0);
                            IWebview iWebviewObtainWebView5 = this.y.obtainWebView();
                            String string3 = JSONUtil.getString(jSONArray, 1);
                            if (!PdrUtil.isEmpty(string3)) {
                                string2 = ReceiveJSValue.registerCallback(string2, new b(iWebview, string3));
                            }
                            iWebviewObtainWebView5.evalJS(string2);
                            return null;
                        }
                        return null;
                    case -1278805514:
                        if (str.equals("setAssistantType")) {
                            r().setAssistantType(jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1263963897:
                        if (str.equals("hideTitleNViewButtonRedDot")) {
                            Object titleNView2 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView2 instanceof ITitleNView) {
                                TitleNViewUtil.titleNViewButtonRedDot((ITitleNView) titleNView2, jSONArray.optJSONObject(0), false);
                                return null;
                            }
                        }
                        return null;
                    case -1263826761:
                        if (str.equals("resetBounce")) {
                            this.y.obtainWebView().endWebViewEvent(AbsoluteConst.BOUNCE_REGISTER);
                            return null;
                        }
                        return null;
                    case -1249348039:
                        if (str.equals("getUrl")) {
                            return Deprecated_JSUtil.wrapJsVar(this.y.obtainWebView().obtainFullUrl(), true);
                        }
                        return null;
                    case -1205263208:
                        if (str.equals("removeFromParent") && (cVar = this.a) != null && cVar.b((io.dcloud.feature.ui.b) this)) {
                            cVar.c(this);
                            return null;
                        }
                        return null;
                    case -1199488876:
                        if (str.equals("setTitleNViewButtonBadge")) {
                            Object titleNView3 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView3 instanceof ITitleNView) {
                                TitleNViewUtil.titleNViewButtonBadge((ITitleNView) titleNView3, jSONArray.optJSONObject(0), true);
                                return null;
                            }
                        }
                        return null;
                    case -1199260532:
                        if (str.equals("setPreloadJsFile")) {
                            String string4 = JSONUtil.getString(jSONArray, 0);
                            boolean zOptBoolean = jSONArray.optBoolean(1, false);
                            if (!PdrUtil.isEmpty(string4)) {
                                this.y.obtainWebView().setPreloadJsFile(this.y.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), string4), zOptBoolean);
                                return null;
                            }
                        }
                        return null;
                    case -1183202654:
                        if (str.equals("setTitleNViewButtonStyle")) {
                            Object titleNView4 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView4 instanceof ITitleNView) {
                                TitleNViewUtil.setTitleNViewButtonStyle((ITitleNView) titleNView4, jSONArray.optString(0), jSONArray.optJSONObject(1), this.y);
                                return null;
                            }
                        }
                        return null;
                    case -1093745411:
                        if (str.equals("interceptTouchEvent")) {
                            this.y.interceptTouchEvent(Boolean.valueOf(JSONUtil.getString(jSONArray, 0)).booleanValue());
                            return null;
                        }
                        return null;
                    case -1068341284:
                        if (str.equals("checkRenderedContent")) {
                            a(iWebview, jSONArray);
                            return null;
                        }
                        return null;
                    case -1010579351:
                        if (str.equals("opened")) {
                            return a(this.X);
                        }
                        return null;
                    case -1010579337:
                        if (str.equals("opener")) {
                            c cVar2 = this.W;
                            if (cVar2 == null) {
                                return Deprecated_JSUtil.wrapJsVar(StringUtil.format("{'uuid':%s,'id':%s}", Constants.Name.UNDEFINED, Constants.Name.UNDEFINED), false);
                            }
                            return cVar2.h();
                        }
                        return null;
                    case -995424086:
                        if (str.equals("parent")) {
                            c cVar3 = this.a;
                            if (cVar3 == null) {
                                return Deprecated_JSUtil.wrapJsVar(StringUtil.format("{'uuid':%s,'id':%s}", Constants.Name.UNDEFINED, Constants.Name.UNDEFINED), false);
                            }
                            return cVar3.h();
                        }
                        return null;
                    case -934641255:
                        if (str.equals(WXWeb.RELOAD)) {
                            a(this, PdrUtil.parseBoolean(JSONUtil.getString(jSONArray, 0), true, false));
                            return null;
                        }
                        return null;
                    case -934610812:
                        if (str.equals(AbsoluteConst.XML_REMOVE)) {
                            String string5 = JSONUtil.getString(jSONArray, 0);
                            io.dcloud.feature.ui.b bVarA2 = this.c.a(string5);
                            if (bVarA2 == null) {
                                bVarA2 = this.c.a(string5, string5, (String) null);
                            }
                            if (b(bVarA2)) {
                                c(bVarA2);
                                return null;
                            }
                        }
                        return null;
                    case -934426579:
                        if (str.equals(AbsoluteConst.EVENTS_RESUME) && (iWebviewObtainWebView = this.y.obtainWebView()) != null) {
                            iWebviewObtainWebView.resume();
                            return null;
                        }
                        return null;
                    case -898815851:
                        if (str.equals("isHardwareAccelerated")) {
                            return JSUtil.wrapJsVar(((AdaFrameItem) this.y).obtainFrameOptions().mUseHardwave);
                        }
                        return null;
                    case -854558288:
                        if (str.equals("setVisible")) {
                            boolean z = jSONArray.getBoolean(0);
                            this.F = z;
                            this.y.setVisible(z, true);
                            return null;
                        }
                        return null;
                    case -677145915:
                        if (str.equals("forward")) {
                            IWebview iWebviewObtainWebView6 = this.y.obtainWebView();
                            iWebviewObtainWebView6.stopLoading();
                            iWebviewObtainWebView6.goBackOrForward(1);
                            return null;
                        }
                        return null;
                    case -625809843:
                        if (str.equals("addEventListener")) {
                            String string6 = jSONArray.getString(0);
                            a(jSONArray.getString(1), string6, (String) this.b.get(iWebview.getWebviewANID()));
                            if (!this.y.obtainWebView().unReceiveTitle() && AbsoluteConst.EVENTS_TITLE_UPDATE.equals(string6)) {
                                onCallBack(AbsoluteConst.EVENTS_TITLE_UPDATE, this.y.obtainWebView().getTitle());
                                return null;
                            }
                        }
                        return null;
                    case -566318518:
                        if (str.equals("getSubNViews")) {
                            IFrameView iFrameView2 = this.y;
                            if (iFrameView2 instanceof AdaFrameView) {
                                AdaFrameView adaFrameView = (AdaFrameView) iFrameView2;
                                ArrayList<INativeView> arrayList = adaFrameView.mChildNativeViewList;
                                if (arrayList != null) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    int size = arrayList.size();
                                    int i2 = 0;
                                    while (i2 < size) {
                                        INativeView iNativeView = arrayList.get(i2);
                                        i2++;
                                        jSONArray2.put(iNativeView.toJSON());
                                    }
                                    return Deprecated_JSUtil.wrapJsVar(jSONArray2.toString(), false);
                                }
                                if (adaFrameView.obtainFrameOptions().mSubNViews != null) {
                                    return Deprecated_JSUtil.wrapJsVar(adaFrameView.obtainFrameOptions().mSubNViews.toString(), false);
                                }
                            }
                        }
                        return null;
                    case -541487286:
                        if (str.equals("removeEventListener")) {
                            b(jSONArray.getString(1), jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -481402894:
                        if (str.equals("hideSoftKeybord")) {
                            DeviceInfo.hideIME(this.y.obtainMainView());
                            return null;
                        }
                        return null;
                    case -453356751:
                        if (str.equals("clearSnapshot")) {
                            this.y.clearSnapshot(jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -410173765:
                        if (str.equals("setContentVisible")) {
                            boolean z2 = jSONArray.getBoolean(0);
                            this.H = z2;
                            ((AdaFrameItem) this.y.obtainWebView()).setVisibility(z2 ? AdaFrameItem.VISIBLE : AdaFrameItem.GONE);
                            this.y.obtainWebviewParent().setBgcolor(-1);
                            return null;
                        }
                        return null;
                    case -400905144:
                        if (str.equals("webview_restore")) {
                            this.y.restore();
                            return null;
                        }
                        return null;
                    case -386427104:
                        if (str.equals("evalJSSync")) {
                            boolean z3 = Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
                            String string7 = JSONUtil.getString(jSONArray, 0);
                            IWebview iWebviewObtainWebView7 = this.y.obtainWebView();
                            if (z3) {
                                MessageHandler.post(new RunnableC0045c(iWebviewObtainWebView7, string7));
                                return null;
                            }
                            Object objPostAndWait = MessageHandler.postAndWait(new d(iWebviewObtainWebView7, string7));
                            if (objPostAndWait != null) {
                                return JSUtil.wrapJsVar(String.valueOf(objPostAndWait));
                            }
                        }
                        return null;
                    case -252003491:
                        if (str.equals("setCssFile")) {
                            String string8 = JSONUtil.getString(jSONArray, 0);
                            if (!PdrUtil.isEmpty(string8)) {
                                this.y.obtainWebView().setCssFile(iAppObtainApp.convert2LocalFullPath(iWebview.obtainFullUrl(), string8), null);
                                return null;
                            }
                        }
                        return null;
                    case -251589874:
                        if (str.equals("setCssText")) {
                            String string9 = JSONUtil.getString(jSONArray, 0);
                            if (!PdrUtil.isEmpty(string9)) {
                                this.y.obtainWebView().setCssFile(null, string9);
                                return null;
                            }
                        }
                        return null;
                    case -155575552:
                        if (str.equals("removeNativeView")) {
                            h(iWebview, JSONUtil.getString(jSONArray, 1));
                            return null;
                        }
                        return null;
                    case -113035288:
                        if (str.equals("isVisible")) {
                            return Deprecated_JSUtil.wrapJsVar(String.valueOf(this.F), false);
                        }
                        return null;
                    case -41183179:
                        if (str.equals("getShareOptions")) {
                            String webviewProperty = this.y.obtainWebView().getWebviewProperty("getShareOptions");
                            if (!TextUtils.isEmpty(webviewProperty)) {
                                return Deprecated_JSUtil.wrapJsVar(webviewProperty, false);
                            }
                        }
                        return null;
                    case -25924366:
                        if (str.equals("beginPullToRefresh")) {
                            this.y.obtainWebView().setWebViewEvent(AbsoluteConst.PULL_REFRESH_BEGIN, null);
                            return null;
                        }
                        return null;
                    case 3015911:
                        if (str.equals("back")) {
                            IWebview iWebviewObtainWebView8 = this.y.obtainWebView();
                            iWebviewObtainWebView8.stopLoading();
                            iWebviewObtainWebView8.goBackOrForward(-1);
                            return null;
                        }
                        return null;
                    case 3091764:
                        if (str.equals("drag")) {
                            JSONObject jSONObject2 = JSONUtil.getJSONObject(jSONArray, 0);
                            JSONObject jSONObject3 = JSONUtil.getJSONObject(jSONArray, 1);
                            String string10 = JSONUtil.getString(jSONArray, 2);
                            String string11 = JSONUtil.getString(jSONArray, 3);
                            if (jSONObject2 != null && !TextUtils.isEmpty(JSONUtil.getString(jSONObject2, "direction")) && !TextUtils.isEmpty(JSONUtil.getString(jSONObject2, "moveMode"))) {
                                ViewOptions viewOptionsObtainFrameOptions = d().obtainFrameOptions();
                                String string12 = JSONUtil.getString(jSONObject3, WXBasicComponentType.VIEW);
                                c cVarA = !TextUtils.isEmpty(string12) ? this.c.a("", string12, string12) : null;
                                View view = (cVarA == null && (objProcessEvent2 = this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", "getNativeView", new Object[]{this.y, string12}})) != null && (objProcessEvent2 instanceof View)) ? (View) objProcessEvent2 : null;
                                c cVarA2 = this.c.a(string10, string10, string10);
                                viewOptionsObtainFrameOptions.setDragData(jSONObject2, jSONObject3, cVarA == null ? null : cVarA.y, cVarA2 == null ? null : cVarA2.y, string11 != null ? string11 : null, view);
                                return null;
                            }
                        }
                        return null;
                    case 3091780:
                        if (str.equals("draw")) {
                            c(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 3202370:
                        if (str.equals("hide")) {
                            d(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 3327206:
                        if (str.equals("load") && (iWebviewObtainWebView2 = this.y.obtainWebView()) != null) {
                            String strObtainUrl = iWebviewObtainWebView2.obtainUrl();
                            String string13 = JSONUtil.getString(jSONArray, 0);
                            JSONObject jSONObject4 = JSONUtil.getJSONObject(jSONArray, 2);
                            String strConvert2WebviewFullPath = iWebviewObtainWebView2.obtainFrameView().obtainApp().convert2WebviewFullPath(iWebviewObtainWebView2.obtainFullUrl(), string13);
                            Logger.d("NWindow.load " + strConvert2WebviewFullPath);
                            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                                map = null;
                            } else {
                                map = new HashMap<>(jSONObject4.length());
                                Iterator<String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    map.put(next, jSONObject4.optString(next));
                                }
                            }
                            if ((iWebviewObtainWebView2 instanceof AdaWebview) && ((AdaWebview) iWebviewObtainWebView2).checkOverrideUrl(strConvert2WebviewFullPath)) {
                                ((AdaWebview) iWebviewObtainWebView2).mFrameView.dispatchFrameViewEvents(AbsoluteConst.EVENTS_OVERRIDE_URL_LOADING, "{url:'" + strConvert2WebviewFullPath + "'}");
                                return null;
                            }
                            iWebviewObtainWebView2.setLoadURLHeads(string13, map);
                            this.y.obtainWebView().setOriginalUrl(string13);
                            this.y.obtainWebView().reload(strConvert2WebviewFullPath);
                            a(this, strObtainUrl);
                            return null;
                        }
                        return null;
                    case 3529469:
                        if (str.equals(AbsoluteConst.EVENTS_WEBVIEW_SHOW)) {
                            a(iWebview, jSONArray, this, strObtainAppId);
                            return null;
                        }
                        return null;
                    case 3540994:
                        if (str.equals(Constants.Value.STOP)) {
                            this.y.obtainWebView().stopLoading();
                            return null;
                        }
                        return null;
                    case 18100665:
                        if (str.equals(AbsoluteConst.EVENTS_OVERRIDE_URL_LOADING)) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(0);
                            this.Q = jSONArray.optString(1);
                            this.R = iWebview;
                            this.y.obtainWebView().setOverrideUrlLoadingData(jSONObjectOptJSONObject2);
                            return null;
                        }
                        return null;
                    case 94746189:
                        if (str.equals("clear")) {
                            this.y.obtainWebView().clearHistory();
                            return null;
                        }
                        return null;
                    case 94756344:
                        if (str.equals(AbsoluteConst.EVENTS_CLOSE)) {
                            b(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 98192778:
                        if (str.equals("setBounce")) {
                            this.y.obtainWebView().setWebViewEvent(AbsoluteConst.BOUNCE_REGISTER, JSONUtil.getJSONObject(jSONArray, 0));
                            return null;
                        }
                        return null;
                    case 106440182:
                        if (str.equals("pause") && (iWebviewObtainWebView3 = this.y.obtainWebView()) != null) {
                            iWebviewObtainWebView3.pause();
                            return null;
                        }
                        return null;
                    case 282257047:
                        if (str.equals("showBehind")) {
                            String string14 = JSONUtil.getString(jSONArray, 1);
                            if (this.c.a(string14) == null) {
                                a(this.c.a(string14, string14, (String) null), this, strObtainAppId);
                                return null;
                            }
                        }
                        return null;
                    case 387104256:
                        if (!str.equals("endPullToRefresh")) {
                            return null;
                        }
                        this.y.obtainWebView().endWebViewEvent(AbsoluteConst.PULL_DOWN_REFRESH);
                        return null;
                    case 471261047:
                        iWebview2 = iWebview;
                        if (!str.equals("setOption")) {
                            return null;
                        }
                        e(iWebview2, jSONArray, this);
                        return null;
                    case 509226590:
                        if (!str.equals("getTitleNViewSearchInputText")) {
                            return null;
                        }
                        Object titleNView5 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                        if (titleNView5 instanceof ITitleNView) {
                            return JSUtil.wrapJsVar(TitleNViewUtil.getTitleNViewSearchInputText((ITitleNView) titleNView5));
                        }
                        return null;
                    case 549228759:
                        if (!str.equals("canBack")) {
                            return null;
                        }
                        Deprecated_JSUtil.execCallback(iWebview, JSONUtil.getString(jSONArray, 0), String.valueOf(this.y.obtainWebView().canGoBack()), JSUtil.OK, true, false);
                        return null;
                    case 648802871:
                        if (!str.equals("updateSubNViews")) {
                            return null;
                        }
                        IFrameView iFrameView3 = this.y;
                        if (!(iFrameView3 instanceof AdaFrameView)) {
                            return null;
                        }
                        SubNViewsUtil.updateSubNViews((AdaFrameView) iFrameView3, jSONArray.getJSONArray(0));
                        return null;
                    case 685878123:
                        if (!str.equals("getOption")) {
                            return null;
                        }
                        ViewOptions viewOptionsObtainFrameOptions2 = ((AdaFrameItem) this.y).obtainFrameOptions();
                        if (viewOptionsObtainFrameOptions2.hasBackground()) {
                            viewOptionsObtainFrameOptions2 = this.y.obtainWebviewParent().obtainFrameOptions();
                        }
                        JSONObject jSONObject5 = new JSONObject(viewOptionsObtainFrameOptions2.mJsonViewOption.toString());
                        if (jSONObject5.has(AbsoluteConst.JSON_KEY_TABBG)) {
                            String string15 = jSONObject5.getString(AbsoluteConst.JSON_KEY_TABBG);
                            jSONObject5.remove(AbsoluteConst.JSON_KEY_TABBG);
                            jSONObject5.put("background", string15);
                        }
                        return Deprecated_JSUtil.wrapJsVar(jSONObject5.toString(), false);
                    case 770098485:
                        if (!str.equals("overrideResourceRequest")) {
                            return null;
                        }
                        this.y.obtainWebView().setOverrideResourceRequest(jSONArray.optJSONArray(0));
                        return null;
                    case 869569345:
                        if (!str.equals("setShareOptions")) {
                            return null;
                        }
                        this.y.obtainWebView().setWebviewProperty("setShareOptions", jSONArray.getString(0));
                        return null;
                    case 1081068728:
                        if (!str.equals("setBlockNetworkImage")) {
                            return null;
                        }
                        r().setWebviewProperty(AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE, JSONUtil.getString(jSONArray, 0));
                        return null;
                    case 1192599283:
                        if (!str.equals("setVolumeButtonEnabled")) {
                            return null;
                        }
                        String string16 = JSONUtil.getString(jSONArray, 0);
                        if (PdrUtil.isEmpty(string16)) {
                            return null;
                        }
                        DeviceInfo.isVolumeButtonEnabled = Boolean.valueOf(string16).booleanValue();
                        return null;
                    case 1295982686:
                        if (!str.equals("setFixBottom")) {
                            return null;
                        }
                        IWebview iWebviewObtainWebView9 = this.y.obtainWebView();
                        iWebviewObtainWebView9.setFixBottom((int) (jSONArray.getInt(0) * iWebviewObtainWebView9.getScale()));
                        return null;
                    case 1341702384:
                        if (str.equals("findViewById")) {
                            return c(JSONUtil.getString(jSONArray, 0)).h();
                        }
                        return null;
                    case 1348313218:
                        if (!str.equals("showTitleNViewButtonRedDot")) {
                            return null;
                        }
                        Object titleNView6 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView6 instanceof ITitleNView)) {
                            return null;
                        }
                        TitleNViewUtil.titleNViewButtonRedDot((ITitleNView) titleNView6, jSONArray.optJSONObject(0), true);
                        return null;
                    case 1355964204:
                        if (!str.equals("getFavoriteOptions")) {
                            return null;
                        }
                        String webviewProperty2 = this.y.obtainWebView().getWebviewProperty("getFavoriteOptions");
                        if (TextUtils.isEmpty(webviewProperty2)) {
                            return null;
                        }
                        return Deprecated_JSUtil.wrapJsVar(webviewProperty2, false);
                    case 1404493423:
                        if (!str.equals("setStyle")) {
                            return null;
                        }
                        iWebview2 = iWebview;
                        e(iWebview2, jSONArray, this);
                        return null;
                    case 1518415382:
                        if (!str.equals("appendNativeView")) {
                            return null;
                        }
                        String string17 = JSONUtil.getString(jSONArray, 1);
                        String string18 = JSONUtil.getString(jSONArray, 0);
                        switch (string18.hashCode()) {
                            case -1677935844:
                                if (string18.equals("VideoPlayer")) {
                                    f(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case -1515621005:
                                if (string18.equals("LivePusher")) {
                                    c(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case -333584256:
                                if (string18.equals("barcode")) {
                                    b(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case 2115:
                                if (string18.equals("Ad")) {
                                    a(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case 2390711:
                                if (string18.equals(IFeature.F_MAPS)) {
                                    d(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                        }
                        e(iWebview, string17);
                        return null;
                    case 1566068146:
                        if (!str.equals("removeTitleNViewButtonBadge")) {
                            return null;
                        }
                        Object titleNView7 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView7 instanceof ITitleNView)) {
                            return null;
                        }
                        TitleNViewUtil.titleNViewButtonBadge((ITitleNView) titleNView7, jSONArray.optJSONObject(0), false);
                        return null;
                    case 1647492569:
                        if (!str.equals("setPullToRefresh")) {
                            return null;
                        }
                        Logger.d(Logger.VIEW_VISIBLE_TAG, "refreshLoadingViewsSize setPullToRefresh args=" + jSONArray);
                        JSONObject jSONObject6 = JSONUtil.getJSONObject(jSONArray, 0);
                        String string19 = JSONUtil.getString(jSONArray, 1);
                        if (!PdrUtil.isEmpty(string19)) {
                            this.U = string19;
                        }
                        this.y.obtainWebView().setWebViewEvent(AbsoluteConst.PULL_DOWN_REFRESH, jSONObject6);
                        return null;
                    case 1659526655:
                        if (str.equals(RichTextNode.CHILDREN)) {
                            return a(this.M);
                        }
                        return null;
                    case 1747355346:
                        if (!str.equals("setTitleNViewSearchInputText")) {
                            return null;
                        }
                        Object titleNView8 = TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView8 instanceof ITitleNView)) {
                            return null;
                        }
                        TitleNViewUtil.setTitleNViewSearchInputText((ITitleNView) titleNView8, jSONArray.optString(0));
                        return null;
                    case 1845118384:
                        if (!str.equals("loadData")) {
                            return null;
                        }
                        String string20 = JSONUtil.getString(jSONArray, 0);
                        JSONObject jSONObject7 = JSONUtil.getJSONObject(jSONArray, 1);
                        String nonString2 = "text/html";
                        String nonString3 = "utf-8";
                        if (jSONObject7 != null) {
                            nonString3 = PdrUtil.getNonString(jSONObject7.optString("encoding"), "utf-8");
                            nonString2 = PdrUtil.getNonString(jSONObject7.optString("mimeType"), "text/html");
                            nonString = PdrUtil.getNonString(jSONObject7.optString("baseURL"), "");
                        }
                        this.y.obtainWebView().loadContentData(nonString, string20, nonString2, nonString3);
                        return null;
                    case 1872589777:
                        if (!str.equals("needTouchEvent")) {
                            return null;
                        }
                        this.y.obtainWebView().setWebviewProperty("needTouchEvent", AbsoluteConst.TRUE);
                        return AbsoluteConst.FALSE;
                    case 1939606683:
                        if (!str.equals("webview_animate")) {
                            return null;
                        }
                        this.y.animate(iWebview, JSONUtil.getString(jSONArray, 0), JSONUtil.getString(jSONArray, 1));
                        return null;
                    case 1966196898:
                        if (str.equals("getTitle")) {
                            return Deprecated_JSUtil.wrapJsVar(this.y.obtainWebView().obtainPageTitle(), true);
                        }
                        return null;
                    case 1992686733:
                        if (!str.equals("getMetrics")) {
                            return null;
                        }
                        Deprecated_JSUtil.execCallback(iWebview, JSONUtil.getString(jSONArray, 0), n(), JSUtil.OK, true, false);
                        return null;
                    case 2067845868:
                        if (!str.equals("isPause") || (iWebviewObtainWebView4 = this.y.obtainWebView()) == null) {
                            return null;
                        }
                        return JSUtil.wrapJsVar(iWebviewObtainWebView4.isPause());
                    default:
                        return null;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x0086  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private void a(IWebview iWebview, JSONArray jSONArray) {
        IWebview iWebview2;
        IWebview iWebviewR;
        JSONObject jSONObject;
        String strOptString;
        String str;
        ViewGroup viewGroupObtainWindowView;
        String string = JSONUtil.getString(jSONArray, 0);
        String string2 = JSONUtil.getString(jSONArray, 1);
        c cVarA = this.c.a(string, string, (String) null);
        if (cVarA != null) {
            try {
                if (cVarA.y.obtainMainView().getParent() != null && cVarA.y.obtainMainView().getVisibility() == 0) {
                    iWebview2 = iWebview;
                    iWebviewR = cVarA.r();
                    jSONObject = JSONUtil.getJSONObject(jSONArray, 2);
                    strOptString = "auto";
                    if (jSONObject != null && jSONObject.has("type")) {
                        strOptString = jSONObject.optString("type", "auto");
                    }
                    str = strOptString;
                    viewGroupObtainWindowView = iWebviewR.obtainWindowView();
                    if (viewGroupObtainWindowView != null) {
                        viewGroupObtainWindowView.post(new e(iWebviewR, str, iWebview2, string2));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                iWebview2 = iWebview;
                e.printStackTrace();
                Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"\"+sWeb.getContext().getString(R.string.dcloud_ui_webview_not_finished)+\"\"}", JSUtil.ERROR, true, false);
                iWebviewR = cVarA.r();
                jSONObject = JSONUtil.getJSONObject(jSONArray, 2);
                strOptString = "auto";
                if (jSONObject != null) {
                    strOptString = jSONObject.optString("type", "auto");
                }
                str = strOptString;
                viewGroupObtainWindowView = iWebviewR.obtainWindowView();
                if (viewGroupObtainWindowView != null) {
                    viewGroupObtainWindowView.post(new e(iWebviewR, str, iWebview2, string2));
                }
            }
        }
        iWebview2 = iWebview;
        try {
            Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"" + iWebview.getContext().getString(R.string.dcloud_ui_webview_not_finished) + "\"}", JSUtil.ERROR, true, false);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"\"+sWeb.getContext().getString(R.string.dcloud_ui_webview_not_finished)+\"\"}", JSUtil.ERROR, true, false);
            iWebviewR = cVarA.r();
            jSONObject = JSONUtil.getJSONObject(jSONArray, 2);
            strOptString = "auto";
            if (jSONObject != null) {
                strOptString = jSONObject.optString("type", "auto");
            }
            str = strOptString;
            viewGroupObtainWindowView = iWebviewR.obtainWindowView();
            if (viewGroupObtainWindowView != null) {
                viewGroupObtainWindowView.post(new e(iWebviewR, str, iWebview2, string2));
            }
        }
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
    private void a(io.dcloud.feature.ui.b bVar, c cVar, String str) {
        c cVar2 = (c) bVar;
        if (cVar2.F) {
            cVar.u = cVar2.u - 1;
            cVar.F = true;
            cVar.I = true;
            cVar.G = false;
            this.c.a(str, cVar, this.c.c(this));
            this.c.d.processEvent(IMgr.MgrType.WindowMgr, 45, new Object[]{cVar.y, cVar2.y});
        }
    }

    private void a(c cVar, String str) {
        IApp iAppObtainApp;
        if (cVar == null || PdrUtil.isEmpty(str) || (iAppObtainApp = cVar.r().obtainApp()) == null) {
            return;
        }
        c cVar2 = cVar.W;
        if (cVar2 != null) {
            str = cVar2.r().obtainUrl();
        }
        String strObtainUrl = cVar.r().obtainUrl();
        if (!BaseInfo.isBase(cVar.a()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(strObtainUrl) || str.startsWith(DeviceInfo.HTTP_PROTOCOL) || strObtainUrl.startsWith(DeviceInfo.HTTP_PROTOCOL)) {
            return;
        }
        Log.i(AbsoluteConst.HBUILDER_TAG, StringUtil.format(AbsoluteConst.OPENLOG, WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(WebResUtil.getOriginalUrl(str))), WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(WebResUtil.getOriginalUrl(strObtainUrl)))));
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
    void a(IWebview iWebview, JSONArray jSONArray, c cVar, String str) {
        String str2;
        if (this.c.a(cVar)) {
            Logger.d(Logger.StreamApp_TAG, "showWebview url=" + cVar.z);
            cVar.A = 1;
            this.c.f(cVar);
            cVar.B = new Object[]{iWebview, jSONArray, cVar, str};
            return;
        }
        cVar.u = System.currentTimeMillis();
        cVar.F = true;
        String string = JSONUtil.getString(jSONArray, 0);
        String string2 = JSONUtil.getString(jSONArray, 1);
        String string3 = JSONUtil.getString(jSONArray, 3);
        this.O = string3;
        if (!PdrUtil.isEmpty(string3)) {
            this.P = iWebview;
        }
        AnimOptions animOptions = ((AdaFrameItem) cVar.y).getAnimOptions();
        if (PdrUtil.isEquals("auto", string)) {
            str2 = animOptions.mAnimType;
        } else {
            str2 = PdrUtil.isEmpty(string) ? "none" : string;
        }
        animOptions.mAnimType = str2;
        boolean z = !PdrUtil.isEquals("none", str2);
        if (PdrUtil.isEmpty(string2)) {
            if (animOptions.mAnimType.equals(AnimOptions.ANIM_POP_IN)) {
                animOptions.duration_show = 300;
            }
        } else {
            animOptions.duration_show = PdrUtil.parseInt(string2, animOptions.duration_show);
        }
        if (!cVar.G && cVar.I) {
            z = false;
        }
        this.c.a(str, cVar, this.c.c(this));
        a(iWebview, JSONUtil.getJSONObject(jSONArray, 4), cVar, string);
        if (cVar.G) {
            animOptions.mOption = (byte) 4;
            this.c.d.processEvent(IMgr.MgrType.WindowMgr, 24, cVar.y);
        } else {
            animOptions.mOption = (byte) 0;
            cVar.I = true;
            this.c.d.processEvent(IMgr.MgrType.WindowMgr, 1, new Object[]{cVar.y, Boolean.valueOf(z)});
        }
        cVar.G = false;
        Logger.d(Logger.VIEW_VISIBLE_TAG, "show " + cVar.y + ";webview_name=" + r().obtainFrameId());
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
    private void a(IWebview iWebview, JSONObject jSONObject, c cVar, String str) {
        Object obj;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(AbsoluteConst.ACCELERATION);
            String str2 = TextUtils.isEmpty(strOptString) ? "auto" : strOptString;
            String strOptString2 = jSONObject.optString("action", "none");
            cVar.y.setAccelerationType(str2);
            if (jSONObject.has(AbsoluteConst.CAPTURE)) {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(AbsoluteConst.CAPTURE);
                if (jSONObjectOptJSONObject2 == null) {
                    return;
                }
                String strOptString3 = jSONObjectOptJSONObject2.optString("__id__");
                if (jSONObjectOptJSONObject2.has("type") && jSONObjectOptJSONObject2.optString("type").equals(AbsoluteConst.NATIVE_NVIEW)) {
                    obj = "getNativeView";
                    Object objProcessEvent = this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", obj, new Object[]{this.y, strOptString3}});
                    if (objProcessEvent != null && (objProcessEvent instanceof INativeView)) {
                        cVar.y.setSnapshotView((INativeView) objProcessEvent, strOptString2);
                        cVar.y.setSnapshot(null);
                    }
                } else {
                    obj = "getNativeView";
                    INativeBitmap iNativeBitmapG = g(cVar.y.obtainWebView(), strOptString3);
                    cVar.y.setSnapshot(iNativeBitmapG != null ? iNativeBitmapG.getBitmap() : null);
                    cVar.y.setSnapshotView(null, "none");
                }
            } else {
                obj = "getNativeView";
            }
            IFrameView iFrameViewFindPageB = cVar.y.findPageB();
            if (iFrameViewFindPageB != null) {
                iFrameViewFindPageB.setAccelerationType(str2);
                if (!jSONObject.has("otherCapture") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("otherCapture")) == null) {
                    return;
                }
                String strOptString4 = jSONObjectOptJSONObject.optString("__id__");
                if (jSONObjectOptJSONObject.has("type") && jSONObjectOptJSONObject.optString("type").equals(AbsoluteConst.NATIVE_NVIEW)) {
                    Object objProcessEvent2 = this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview, "nativeobj", obj, new Object[]{iFrameViewFindPageB, strOptString4}});
                    if (objProcessEvent2 == null || !(objProcessEvent2 instanceof INativeView)) {
                        return;
                    }
                    iFrameViewFindPageB.setSnapshotView((INativeView) objProcessEvent2, strOptString2);
                    iFrameViewFindPageB.setSnapshot(null);
                    return;
                }
                INativeBitmap iNativeBitmapG2 = g(iFrameViewFindPageB.obtainWebView(), strOptString4);
                iFrameViewFindPageB.setSnapshot(iNativeBitmapG2 != null ? iNativeBitmapG2.getBitmap() : null);
                iFrameViewFindPageB.setSnapshotView(null, "none");
                return;
            }
            return;
        }
        cVar.y.setSnapshot(null);
        cVar.y.setAccelerationType("auto");
        IFrameView iFrameViewFindPageB2 = cVar.y.findPageB();
        if (iFrameViewFindPageB2 != null) {
            iFrameViewFindPageB2.setSnapshot(null);
            iFrameViewFindPageB2.setAccelerationType("auto");
        }
    }

    void a(IWebview iWebview, JSONArray jSONArray, c cVar) {
        String string = JSONUtil.getString(jSONArray, 0);
        String string2 = JSONUtil.getString(jSONArray, 1);
        cVar.y.captureSnapshot(string, TextUtils.isEmpty(string2) ? null : new f(iWebview, string2), TextUtils.isEmpty(string2) ? null : new g(iWebview, string2));
    }

    void a(c cVar, boolean z) {
        cVar.y.obtainWebView().reload(z);
    }

    boolean a(JSONObject jSONObject, boolean z) {
        boolean z2 = false;
        if (!jSONObject.isNull(AbsoluteConst.JSON_KEY_ZINDEX)) {
            try {
                int i2 = Integer.parseInt(JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ZINDEX));
                if (i2 != this.E) {
                    z2 = true;
                    this.E = i2;
                    ((AdaFrameView) this.y).mZIndex = i2;
                    if (z) {
                        this.c.g(this);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return z2;
    }

    private static String a(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer(Operators.ARRAY_START_STR);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) arrayList.get(i2);
                if (bVar instanceof c) {
                    stringBuffer.append(((c) bVar).h());
                } else {
                    stringBuffer.append("'" + bVar.e + "'");
                }
                if (i2 != size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append(Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0145  */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0145 -> B:34:0x0146). Please report as a decompilation issue!!! */
    private void a(IWebview iWebview, c cVar, JSONObject jSONObject, JSONObject jSONObject2) {
        String string;
        String strOptString;
        String strOptString2;
        String strOptString3;
        JSONObject jSONObject3;
        String strChangeColorAlpha;
        String str;
        Object obj;
        if (jSONObject == null) {
            AdaFrameItem adaFrameItem = (AdaFrameItem) cVar.y;
            ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
            String titleNViewId = TitleNViewUtil.getTitleNViewId(cVar.y);
            AbsMgr absMgr = this.c.d;
            IMgr.MgrType mgrType = IMgr.MgrType.WindowMgr;
            absMgr.processEvent(mgrType, 72, new Object[]{adaFrameItem, jSONObject2, titleNViewId});
            viewOptionsObtainFrameOptions.setTitleNView(jSONObject2, cVar.r());
            this.c.d.processEvent(mgrType, 73, new Object[]{adaFrameItem, iWebview.obtainFrameView()});
            if (cVar.y.obtainWebView().isUniWebView()) {
                ((AdaUniWebView) cVar.y.obtainWebView()).titleNViewRefresh();
                return;
            }
            return;
        }
        if (jSONObject2 == null) {
            return;
        }
        boolean zPaddingIsChanged = TitleNViewUtil.paddingIsChanged(jSONObject, jSONObject2);
        boolean zBackgroundIsChanged = TitleNViewUtil.backgroundIsChanged(jSONObject, jSONObject2);
        boolean zBackgroundImageIsChanged = TitleNViewUtil.backgroundImageIsChanged(jSONObject, jSONObject2);
        boolean zTitleAlignIsChanged = TitleNViewUtil.titleAlignIsChanged(jSONObject, jSONObject2);
        boolean zRedDotChange = TitleNViewUtil.redDotChange(jSONObject, jSONObject2);
        TitleNViewUtil.titleNViewStyleNoTitle(jSONObject);
        boolean zTitleIsChanged = TitleNViewUtil.titleIsChanged(jSONObject, jSONObject2);
        boolean zTitleColorIsChanged = TitleNViewUtil.titleColorIsChanged(jSONObject, jSONObject2);
        boolean zTitleSizeIsChanged = TitleNViewUtil.titleSizeIsChanged(jSONObject, jSONObject2);
        boolean zTitleOverflowIsChanged = TitleNViewUtil.titleOverflowIsChanged(jSONObject, jSONObject2);
        boolean zSplitLineIsChanged = TitleNViewUtil.splitLineIsChanged(jSONObject, jSONObject2);
        boolean zBackButtonIsChanged = TitleNViewUtil.backButtonIsChanged(jSONObject, jSONObject2);
        boolean zProgressIsChanged = TitleNViewUtil.progressIsChanged(jSONObject, jSONObject2);
        boolean zHas = jSONObject2.has("homeButton");
        boolean zIsButtonsIsChanged = TitleNViewUtil.isButtonsIsChanged(jSONObject, jSONObject2);
        boolean zIsSearchInputChange = TitleNViewUtil.isSearchInputChange(jSONObject, jSONObject2);
        boolean zSubTitleIconChanged = TitleNViewUtil.subTitleIconChanged(jSONObject, jSONObject2);
        boolean zIsShadowChanged = TitleNViewUtil.isShadowChanged(jSONObject, jSONObject2);
        String titleNViewId2 = TitleNViewUtil.getTitleNViewId(cVar.y);
        JSONObject jSONObjectCreateJSONObject = JSONUtil.createJSONObject(jSONObject.toString());
        JSONObject jSONObjectCreateJSONObject2 = JSONUtil.createJSONObject(jSONObject2.toString());
        JSONUtil.combinJSONObject(jSONObjectCreateJSONObject, jSONObjectCreateJSONObject2);
        int i2 = ((AdaFrameItem) cVar.y).obtainFrameOptions().coverage;
        if (jSONObjectCreateJSONObject != null && jSONObjectCreateJSONObject.has("coverage")) {
            ((AdaFrameItem) cVar.y).obtainFrameOptions().coverage = PdrUtil.convertToScreenInt(jSONObjectCreateJSONObject.optString("coverage"), PlatformUtil.SCREEN_WIDTH(cVar.a()), i2, cVar.r().getScale());
        }
        if (jSONObjectCreateJSONObject != null) {
            try {
                if (jSONObject2.has("titleText")) {
                    Object obj2 = jSONObjectCreateJSONObject.get("titleText");
                    if (obj2 == null || !(obj2 instanceof String)) {
                        string = null;
                    } else {
                        string = obj2.toString();
                    }
                } else if (jSONObject2.has("titletext") && (obj = jSONObjectCreateJSONObject.get("titletext")) != null && (obj instanceof String)) {
                    string = obj.toString();
                } else {
                    string = null;
                }
            } catch (Exception unused) {
            }
            if (jSONObject2.has("titleColor")) {
                strOptString = jSONObjectCreateJSONObject.optString("titleColor");
            } else {
                strOptString = jSONObject2.has("titlecolor") ? jSONObjectCreateJSONObject.optString("titlecolor") : null;
            }
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObjectCreateJSONObject.optString("titleColor");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectCreateJSONObject.optString("titlecolor");
                }
            }
            String str2 = "type";
            if ("transparent".equals(jSONObject2.optString("type")) && !TextUtils.isEmpty(strOptString)) {
                strOptString = TitleNViewUtil.changeColorAlpha(strOptString, 0.0f);
            }
            if (jSONObject2.has("titleSize")) {
                strOptString2 = jSONObjectCreateJSONObject.optString("titleSize");
            } else {
                strOptString2 = jSONObject2.has("titlesize") ? jSONObjectCreateJSONObject.optString("titlesize") : null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = jSONObjectCreateJSONObject.optString("titleSize");
                if (TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = jSONObjectCreateJSONObject.optString("titlesize");
                }
            }
            String str3 = strOptString2;
            String strOptString4 = jSONObjectCreateJSONObject.optString("titleOverflow");
            if (jSONObject2.has("backgroundColor")) {
                strOptString3 = jSONObjectCreateJSONObject.optString("backgroundColor");
            } else {
                strOptString3 = jSONObject2.has("backgroundcolor") ? jSONObjectCreateJSONObject.optString("backgroundcolor") : null;
            }
            if (TextUtils.isEmpty(strOptString3)) {
                strOptString3 = jSONObjectCreateJSONObject.optString("backgroundColor");
                if (TextUtils.isEmpty(strOptString3)) {
                    strOptString3 = jSONObjectCreateJSONObject.optString("backgroundcolor");
                }
            }
            String str4 = strOptString3;
            String strOptString5 = jSONObject2.has(Constants.Name.BACKGROUND_IMAGE) ? jSONObjectCreateJSONObject.optString(Constants.Name.BACKGROUND_IMAGE) : null;
            if (!zBackgroundIsChanged || TextUtils.isEmpty(str4)) {
                str2 = "type";
            } else {
                if ("transparent".equals(jSONObjectCreateJSONObject.optString("type"))) {
                    strChangeColorAlpha = TitleNViewUtil.changeColorAlpha(str4, 0.0f);
                } else {
                    strChangeColorAlpha = "float".equals(jSONObjectCreateJSONObject.optString("type")) ? str4 : TitleNViewUtil.changeColorAlpha(str4, 1.0f);
                }
                if (!((AdaFrameItem) cVar.y).obtainFrameOptions().isStatusbar && cVar.y.obtainApp().obtainStatusBarMgr().isImmersive) {
                    str = ",'statusbar':{'background':'" + strChangeColorAlpha + "','backgroundnoalpha':'" + str4 + "'}";
                } else {
                    str = "";
                }
                this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{cVar.r(), "nativeobj", "setStyle", JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "',{'backgroundColor':'" + strChangeColorAlpha + "'" + str + "}]")});
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectCreateJSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray != null) {
                this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{cVar.r(), "nativeobj", "view_draw", JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "'," + jSONArrayOptJSONArray.toString() + Operators.ARRAY_END_STR)});
            }
            Object titleNView = TitleNViewUtil.getTitleNView(this.c.d, cVar.r(), cVar.y, titleNViewId2);
            if (titleNView instanceof ITitleNView) {
                ITitleNView iTitleNView = (ITitleNView) titleNView;
                if (zTitleIsChanged) {
                    iTitleNView.setTitleText(string);
                }
                if (zTitleColorIsChanged) {
                    iTitleNView.setTitleColor(strOptString);
                }
                if (zTitleSizeIsChanged) {
                    iTitleNView.setTitleSize(str3);
                }
                if (zTitleOverflowIsChanged) {
                    iTitleNView.setTitleOverflow(strOptString4);
                }
                if (zPaddingIsChanged) {
                    jSONObject3 = jSONObjectCreateJSONObject;
                    TitleNViewUtil.setTitleNViewPadding(iTitleNView, cVar.r(), jSONObject3);
                } else {
                    jSONObject3 = jSONObjectCreateJSONObject;
                }
                if (zSplitLineIsChanged) {
                    TitleNViewUtil.setSplitLine(iTitleNView, cVar.r(), jSONObject.optJSONObject("splitLine"), jSONObject2.optJSONObject("splitLine"), false, jSONObject3.optString(str2));
                }
                if (zBackButtonIsChanged) {
                    TitleNViewUtil.setBackButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zProgressIsChanged) {
                    TitleNViewUtil.setProgress(iTitleNView, jSONObject3);
                }
                if (zIsSearchInputChange) {
                    TitleNViewUtil.setSearchInput(iTitleNView, jSONObject3, cVar.y.obtainWebView());
                }
                if (zIsButtonsIsChanged) {
                    iTitleNView.clearButtons();
                    TitleNViewUtil.setButtons(iTitleNView, jSONObject3, cVar.y.obtainWebView());
                    TitleNViewUtil.setBackButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zHas || zIsButtonsIsChanged) {
                    TitleNViewUtil.setHomeButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zRedDotChange) {
                    TitleNViewUtil.setRedDotColor(iTitleNView, jSONObject3);
                }
                if (zTitleAlignIsChanged) {
                    TitleNViewUtil.setTitleAlign(iTitleNView, jSONObject3);
                }
                if (zBackgroundImageIsChanged && strOptString5 != null) {
                    this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{cVar.r(), "nativeobj", "setStyle", JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "',{'backgroundImage':'" + strOptString5 + "'}]")});
                }
                if (jSONObject3.has("backgroundRepeat")) {
                    iTitleNView.setBackgroundRepeat(jSONObject3.optString("backgroundRepeat"));
                }
                if (zSubTitleIconChanged) {
                    TitleNViewUtil.setSubTitleIcon(iTitleNView, jSONObject3);
                }
                if (zIsShadowChanged) {
                    TitleNViewUtil.setShadow(iTitleNView, jSONObject3);
                }
            }
            if (cVar.y.obtainWebView().isUniWebView()) {
                ((AdaUniWebView) cVar.y.obtainWebView()).titleNViewRefresh();
            }
        }
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
    private void a(c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.c.d.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{cVar.r().obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "weexViewUpdate", new Object[]{cVar.r(), cVar.y.obtainMainView(), jSONObject, BaseInfo.getUniNViewId(cVar.y)}});
    }
}
