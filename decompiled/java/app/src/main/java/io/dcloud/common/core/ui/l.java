package io.dcloud.common.core.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alibaba.fastjson.JSON;
import com.dcloud.android.widget.StatusBarView;
import com.taobao.weex.common.Constants;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IActivityHandler;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.ICore;
import io.dcloud.common.DHInterface.IDCloudWebviewClientListener;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.ITitleNView;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.IWebviewStateListener;
import io.dcloud.common.adapter.ui.AdaFrameItem;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.adapter.ui.AdaUniWebView;
import io.dcloud.common.adapter.ui.AdaWebViewParent;
import io.dcloud.common.adapter.ui.AdaWebview;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.AnimOptions;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.EventActionInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.adapter.util.ViewOptions;
import io.dcloud.common.adapter.util.ViewRect;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.IntentConst;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.SubNViewsUtil;
import io.dcloud.common.util.TestUtil;
import io.dcloud.common.util.TitleNViewUtil;
import io.dcloud.feature.gg.dcloud.ADSim;
import io.dcloud.feature.internal.sdk.SDK;
import io.dcloud.nineoldandroids.view.ViewHelper;
import io.src.dcloud.adapter.DCloudAdapterUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class l extends AbsMgr implements IMgr.WindowEvent {
    HashMap a;
    List b;
    String c;
    Runnable d;
    Runnable e;
    boolean f;
    WindowManager.LayoutParams g;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements IEventCallback {
        final /* synthetic */ io.dcloud.common.core.ui.b a;
        final /* synthetic */ IApp b;
        final /* synthetic */ io.dcloud.common.core.ui.a c;

        a(io.dcloud.common.core.ui.b bVar, IApp iApp, io.dcloud.common.core.ui.a aVar) {
            this.a = bVar;
            this.b = iApp;
            this.c = aVar;
        }

        @Override // io.dcloud.common.DHInterface.IEventCallback
        public Object onCallBack(String str, Object obj) {
            if (!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE)) {
                return null;
            }
            this.a.removeFrameViewListener(this);
            l.this.a(this.b, this.c);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements IWebviewStateListener {
        boolean a = false;
        final /* synthetic */ IApp b;
        final /* synthetic */ io.dcloud.common.core.ui.b c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ AdaWebview g;
        final /* synthetic */ io.dcloud.common.core.ui.a h;
        final /* synthetic */ int i;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        class a implements MessageHandler.IMessages {
            a() {
            }

            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(Object obj) {
                if (((io.dcloud.common.core.ui.a) b.this.b.obtainWebAppRootView()).a(5) == null) {
                    b.this.b.checkOrLoadlaunchWebview();
                }
            }
        }

        b(IApp iApp, io.dcloud.common.core.ui.b bVar, boolean z, boolean z2, String str, AdaWebview adaWebview, io.dcloud.common.core.ui.a aVar, int i) {
            this.b = iApp;
            this.c = bVar;
            this.d = z;
            this.e = z2;
            this.f = str;
            this.g = adaWebview;
            this.h = aVar;
            this.i = i;
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00ef  */
        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            int i2;
            int i3;
            if (AbsoluteConst.EVENTS_TITLE_UPDATE.equals(l.this.c)) {
                i2 = 4;
            } else {
                i2 = AbsoluteConst.EVENTS_RENDERING.equals(l.this.c) ? 6 : 1;
            }
            if (i == 3 && !this.a) {
                Integer num = (Integer) obj;
                if (num.intValue() >= 50) {
                    this.a = true;
                    Intent intent = new Intent();
                    intent.setAction(this.b.getActivity().getPackageName() + ".streamdownload.downloadfinish." + this.b.obtainAppId());
                    intent.putExtra("appid", this.b.obtainAppId());
                    intent.putExtra("progress", num.intValue());
                    intent.putExtra("flag", AbsoluteConst.STREAMAPP_KEY_DIRECT_PAGE_PROGRESSED);
                    this.b.getActivity().sendBroadcast(intent);
                }
            }
            if (i == 1) {
                if (this.c.getFrameType() == 5) {
                    this.b.checkOrLoadlaunchWebview();
                } else if (this.c.getFrameType() == 4) {
                    MessageHandler.sendMessage(new a(), 3000L, null);
                }
            }
            if (i == i2 && this.d) {
                if (this.e || (PdrUtil.isNetPath(this.f) && (i == 4 || i == 6))) {
                    boolean z = this.e;
                    if (z) {
                        i3 = TestUtil.PointTime.AC_TYPE_1_1;
                    } else if (i == 4) {
                        i3 = TestUtil.PointTime.AC_TYPE_1_2;
                    } else if (i == 6) {
                        i3 = TestUtil.PointTime.AC_TYPE_1_3;
                    } else {
                        i3 = TestUtil.PointTime.AC_TYPE_1_1;
                    }
                    l lVar = l.this;
                    lVar.f = false;
                    lVar.a(this.g, this.b, z, this.h, 1, this.c, this.i, i3);
                } else {
                    this.b.setConfigProperty("timeout", "-1");
                    io.dcloud.common.core.ui.a aVar = this.h;
                    aVar.a(aVar, this.c, this.i, true, TestUtil.PointTime.AC_TYPE_1_1);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements Runnable {
        final /* synthetic */ AdaFrameItem a;

        c(AdaFrameItem adaFrameItem) {
            this.a = adaFrameItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((AdaFrameView) this.a).changeWebParentViewRect();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements ICallBack {
        final /* synthetic */ io.dcloud.common.core.ui.b a;
        final /* synthetic */ Object[] b;

        d(io.dcloud.common.core.ui.b bVar, Object[] objArr) {
            this.a = bVar;
            this.b = objArr;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            if (this.a.u) {
                return null;
            }
            this.a.c(((Boolean) this.b[1]).booleanValue());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements ICallBack {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        e(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            this.a.setVisible(true, false);
            this.a.p();
            this.a.lastShowTime = System.currentTimeMillis();
            this.a.k.k();
            io.dcloud.common.core.ui.b bVar = this.a;
            if (!bVar.isChildOfFrameView) {
                TestUtil.record("computeStackArray");
                io.dcloud.common.core.ui.b bVar2 = this.a;
                bVar2.k.b(bVar2);
                io.dcloud.common.core.ui.b bVar3 = this.a;
                bVar3.onPushToStack(bVar3.isAutoPop());
                TestUtil.print("computeStackArray", "计算满屏幕时间");
                if (this.a.k.d().contains(this.a)) {
                    this.a.k.l();
                } else {
                    io.dcloud.common.core.ui.b bVar4 = this.a;
                    bVar4.k.e(bVar4);
                }
            } else if (bVar.getParentFrameItem() != null) {
                io.dcloud.common.core.ui.b bVar5 = this.a;
                bVar5.k.h(bVar5);
            }
            io.dcloud.common.core.ui.b bVar6 = this.a;
            if (!bVar6.isChildOfFrameView) {
                int i2 = bVar6.obtainApp().getInt(0);
                int i3 = this.a.obtainApp().getInt(1);
                if ((i2 == this.a.obtainFrameOptions().width && this.a.obtainFrameOptions().height + 1 >= i3) || (this.a.obtainFrameOptions().width == -1 && this.a.obtainFrameOptions().height == -1)) {
                    io.dcloud.common.core.ui.i.a(this.a, 0);
                }
                if (PdrUtil.isEquals(this.a.getAnimOptions().mAnimType, "none")) {
                    this.a.makeViewOptions_animate();
                    this.a.m();
                } else {
                    this.a.s();
                    this.a.startAnimator(0);
                }
            } else if (PdrUtil.isEquals(bVar6.getAnimOptions().mAnimType, AnimOptions.ANIM_FADE_IN)) {
                this.a.s();
                this.a.startAnimator(0);
            } else {
                this.a.makeViewOptions_animate();
                this.a.m();
            }
            io.dcloud.common.core.ui.b bVar7 = this.a;
            bVar7.k.i(bVar7);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f implements ICallBack {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        f(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            io.dcloud.common.core.ui.b bVar = this.a;
            int iC = bVar.k.c(bVar);
            this.a.p();
            boolean z = false;
            boolean z2 = this.a.obtainMainView().getVisibility() == AdaFrameItem.VISIBLE;
            io.dcloud.common.core.ui.b bVar2 = this.a;
            if (bVar2.inStack && z2 && !bVar2.isChildOfFrameView) {
                bVar2.k.b(bVar2);
                if (this.a.e()) {
                    l.this.processEvent(IMgr.MgrType.WindowMgr, 28, this.a.b);
                    this.a.b = null;
                }
                int i2 = this.a.obtainApp().getInt(0);
                int i3 = this.a.obtainApp().getInt(1);
                if ((i2 == this.a.obtainFrameOptions().width && this.a.obtainFrameOptions().height + 1 >= i3) || (this.a.obtainFrameOptions().width == -1 && this.a.obtainFrameOptions().height == -1)) {
                    z = true;
                }
                if ((!PdrUtil.isEquals(this.a.getAnimOptions().mAnimType_close, "none") || (BaseInfo.isDefaultAim && z)) && iC >= 0) {
                    this.a.s();
                    if (z && !PdrUtil.isEquals(this.a.getAnimOptions().mAnimType_close, "none")) {
                        io.dcloud.common.core.ui.i.a(this.a, 1);
                    }
                    this.a.startAnimator(1);
                } else {
                    this.a.makeViewOptions_animate();
                    this.a.l();
                    this.a.k();
                }
            } else {
                bVar2.makeViewOptions_animate();
                this.a.l();
                this.a.k();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class g implements ICallBack {
        final /* synthetic */ io.dcloud.common.core.ui.b a;
        final /* synthetic */ int b;

        g(io.dcloud.common.core.ui.b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x008b  */
        /* JADX WARN: Code duplicated, block: B:22:0x0099  */
        /* JADX WARN: Code duplicated, block: B:23:0x009b  */
        /* JADX WARN: Code duplicated, block: B:53:0x0137  */
        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            io.dcloud.common.core.ui.b bVar;
            boolean z;
            io.dcloud.common.core.ui.b bVar2 = this.a;
            int iC = bVar2.k.c(bVar2);
            this.a.p();
            io.dcloud.common.core.ui.b bVar3 = this.a;
            boolean zD = bVar3.k.d(bVar3);
            Object objValueOf = AbsoluteConst.TRUE;
            if (zD) {
                bVar = this.a;
                boolean z2 = bVar.isChildOfFrameView;
                if (bVar.obtainMainView().getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.a.obtainApp().getInt(0) != this.a.obtainFrameOptions().width) {
                }
                if (iC >= 0) {
                    io.dcloud.common.core.ui.i.a(this.a, 1);
                }
                this.a.r();
                if (this.b == 2) {
                    this.a.i();
                } else {
                    this.a.i();
                }
            } else {
                io.dcloud.common.core.ui.b bVar4 = this.a;
                if (bVar4.k.q) {
                    IApp iAppObtainApp = bVar4.obtainApp();
                    this.a.r();
                    if (this.b == 2) {
                        io.dcloud.common.core.ui.b bVar5 = this.a;
                        if (bVar5.inStack) {
                            bVar5.getAnimOptions().mAnimType_close = AnimOptions.ANIM_ZOOM_FADE_IN;
                            this.a.s();
                            this.a.startAnimator(1);
                        } else {
                            bVar5.i();
                        }
                        if (this.a.getFrameType() == 3) {
                            l.this.processEvent(IMgr.MgrType.WindowMgr, 42, this.a);
                        }
                    } else {
                        this.a.i();
                    }
                    l lVar = l.this;
                    IMgr.MgrType mgrType = IMgr.MgrType.AppMgr;
                    boolean z3 = Boolean.parseBoolean(String.valueOf(lVar.processEvent(mgrType, 13, iAppObtainApp)));
                    if (z3) {
                        l.this.processEvent(mgrType, 10, iAppObtainApp);
                        objValueOf = Boolean.valueOf(z3);
                    }
                } else {
                    bVar = this.a;
                    boolean z4 = bVar.isChildOfFrameView;
                    if (bVar.obtainMainView().getVisibility() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z5 = (this.a.obtainApp().getInt(0) != this.a.obtainFrameOptions().width && this.a.obtainFrameOptions().height + 1 >= this.a.obtainApp().getInt(1)) || (this.a.obtainFrameOptions().width == -1 && this.a.obtainFrameOptions().height == -1);
                    if (iC >= 0 && z5 && !PdrUtil.isEquals(this.a.getAnimOptions().mAnimType_close, "none")) {
                        io.dcloud.common.core.ui.i.a(this.a, 1);
                    }
                    this.a.r();
                    if (this.b == 2 || iC < 0) {
                        this.a.i();
                    } else {
                        io.dcloud.common.core.ui.b bVar6 = this.a;
                        if (bVar6.inStack && z && !PdrUtil.isEquals(bVar6.getAnimOptions().mAnimType_close, "none")) {
                            this.a.s();
                            this.a.startAnimator(1);
                        } else {
                            this.a.i();
                        }
                        if (this.a.getFrameType() == 3) {
                            l.this.processEvent(IMgr.MgrType.WindowMgr, 42, this.a);
                        }
                    }
                }
            }
            io.dcloud.common.core.ui.b bVar7 = this.a;
            bVar7.i = false;
            bVar7.h = false;
            bVar7.inStack = false;
            return objValueOf;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class h implements ICallBack {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        h(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            io.dcloud.common.core.ui.b bVar = this.a;
            bVar.k.e(bVar);
            this.a.setVisible(true, false);
            this.a.k.i();
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class i implements IWebviewStateListener {
        boolean a = false;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ IApp d;
        final /* synthetic */ io.dcloud.common.core.ui.a e;
        final /* synthetic */ String f;
        final /* synthetic */ IWebview g;
        final /* synthetic */ int h;
        final /* synthetic */ io.dcloud.common.core.ui.b i;
        final /* synthetic */ int j;
        final /* synthetic */ long k;

        i(String str, boolean z, IApp iApp, io.dcloud.common.core.ui.a aVar, String str2, IWebview iWebview, int i, io.dcloud.common.core.ui.b bVar, int i2, long j) {
            this.b = str;
            this.c = z;
            this.d = iApp;
            this.e = aVar;
            this.f = str2;
            this.g = iWebview;
            this.h = i;
            this.i = bVar;
            this.j = i2;
            this.k = j;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public Object onCallBack(int i, Object obj) {
            int i2;
            IActivityHandler iActivityHandler;
            int i3;
            if (AbsoluteConst.EVENTS_TITLE_UPDATE.equals(l.this.c)) {
                i2 = 4;
            } else {
                i2 = AbsoluteConst.EVENTS_RENDERING.equals(l.this.c) ? 6 : 1;
            }
            Logger.d(Logger.MAIN_TAG, "autoCloseSplash4LaunchWebview  IWebviewStateListener pType= " + i + ";pArgs=" + obj);
            if (i != i2) {
                if (i != 3 || (iActivityHandler = DCloudAdapterUtil.getIActivityHandler(this.d.getActivity())) == null) {
                    return null;
                }
                iActivityHandler.updateParam("progress", obj);
                return null;
            }
            if (this.b.equals("id:*") && this.c) {
                l.this.a(this.d, this.e);
            } else if (this.b.equals("default") && this.c) {
                if (PdrUtil.isNetPath(this.f) && (i == 4 || i == 6)) {
                    if (i == 4) {
                        i3 = TestUtil.PointTime.AC_TYPE_1_2;
                    } else {
                        i3 = i == 6 ? TestUtil.PointTime.AC_TYPE_1_3 : TestUtil.PointTime.AC_TYPE_1_1;
                    }
                    l lVar = l.this;
                    lVar.f = false;
                    lVar.a(this.g, this.d, false, this.e, this.h, this.i, this.j, i3);
                } else {
                    this.d.setConfigProperty("timeout", "-1");
                    io.dcloud.common.core.ui.a aVar = this.e;
                    aVar.a(aVar, this.i, this.j, true, TestUtil.PointTime.AC_TYPE_1_1);
                }
            }
            BaseInfo.setLoadingLaunchePage(false, "f_need_auto_close_splash");
            long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
            this.d.setConfigProperty(IApp.ConfigProperty.CONFIG_LOADED_TIME, String.valueOf(jCurrentTimeMillis));
            this.g.evalJS(AbsoluteConst.PROTOCOL_JAVASCRIPT + StringUtil.format(AbsoluteConst.JS_RUNTIME_BASE, StringUtil.format(AbsoluteConst.JS_RUNTIME_LOADEDTIME, String.valueOf(jCurrentTimeMillis))));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class j implements Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.a a;
        final /* synthetic */ io.dcloud.common.core.ui.b b;
        final /* synthetic */ int c;

        j(io.dcloud.common.core.ui.a aVar, io.dcloud.common.core.ui.b bVar, int i) {
            this.a = aVar;
            this.b = bVar;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.a aVar = this.a;
            if (aVar != null) {
                aVar.a(aVar, this.b, this.c, true, 1000);
            }
            l.this.d = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class k implements Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.b a;
        final /* synthetic */ io.dcloud.common.core.ui.a b;
        final /* synthetic */ IApp c;

        k(io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.a aVar, IApp iApp) {
            this.a = bVar;
            this.b = aVar;
            this.c = iApp;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.obtainWebView().isLoaded()) {
                    l.this.a(this.c, this.b);
                } else if (this.a.obtainWebView().obtainUrl().endsWith("__uniappservice.html") || this.a.obtainWebView().checkWhite("auto")) {
                    l.this.a(this.c, this.b);
                } else {
                    io.dcloud.common.core.ui.a aVar = this.b;
                    aVar.a(aVar, this.a, 0, true, 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.common.core.ui.l$l, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class RunnableC0036l implements Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.a a;
        final /* synthetic */ boolean b;
        final /* synthetic */ io.dcloud.common.core.ui.b c;
        final /* synthetic */ IWebview d;
        final /* synthetic */ IApp e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        RunnableC0036l(io.dcloud.common.core.ui.a aVar, boolean z, io.dcloud.common.core.ui.b bVar, IWebview iWebview, IApp iApp, int i, int i2, int i3) {
            this.a = aVar;
            this.b = z;
            this.c = bVar;
            this.d = iWebview;
            this.e = iApp;
            this.f = i;
            this.g = i2;
            this.h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.common.core.ui.a aVar = this.a;
                if (aVar != null && !aVar.q && !l.this.f) {
                    if ((this.b || this.c.obtainFrameOptions().titleNView == null) && this.d.checkWhite("auto")) {
                        l.this.a(this.d, this.e, this.b, this.a, this.h, this.c, this.f, this.g);
                        return;
                    }
                    System.currentTimeMillis();
                    String str = BaseInfo.sGlobalUserAgent;
                    this.e.setConfigProperty("timeout", "-1");
                    io.dcloud.common.core.ui.a aVar2 = this.a;
                    aVar2.a(aVar2, this.c, this.f, true, this.g);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface m {
        void onAnimationEnd();
    }

    public l(ICore iCore) {
        super(iCore, "windowmgr", IMgr.MgrType.WindowMgr);
        this.a = new HashMap(0);
        this.b = Collections.synchronizedList(new ArrayList());
        this.c = null;
        this.d = null;
        this.f = false;
        this.g = null;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        return i2 == 0 && i3 == 0 && i4 == i6 && i5 == i7;
    }

    private void b(int i2, Object obj) {
        JSONObject jSONObjectCreateJSONObject;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            IApp iApp = (IApp) objArr[0];
            boolean zBooleanValue = objArr.length >= 3 ? ((Boolean) objArr[2]).booleanValue() : false;
            String strObtainAppId = iApp.obtainAppId();
            io.dcloud.common.core.ui.a aVar = (io.dcloud.common.core.ui.a) this.a.get(strObtainAppId);
            io.dcloud.common.core.ui.b bVar = aVar.d;
            boolean z = bVar == null;
            if (bVar == null) {
                String stringExtra = iApp.obtainWebAppIntent().getStringExtra(IntentConst.FROM_STREAM_OPEN_STYLE);
                try {
                    if (TextUtils.isEmpty(stringExtra)) {
                        jSONObjectCreateJSONObject = JSONUtil.createJSONObject("{}");
                    } else {
                        jSONObjectCreateJSONObject = new JSONObject(stringExtra);
                        try {
                            iApp.obtainWebAppIntent().removeExtra(IntentConst.FROM_STREAM_OPEN_STYLE);
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    jSONObjectCreateJSONObject = null;
                }
                bVar = (io.dcloud.common.core.ui.b) processEvent(IMgr.MgrType.WindowMgr, 3, new Object[]{3, iApp, new Object[]{objArr[1], jSONObjectCreateJSONObject}, aVar});
                aVar.d = bVar;
            }
            IWebview iWebviewObtainWebView = bVar.obtainWebView();
            if (zBooleanValue) {
                iWebviewObtainWebView.obtainWindowView().setLayerType(0, null);
            } else {
                iWebviewObtainWebView.obtainWindowView().setLayerType(1, null);
            }
            Logger.d(Logger.MAIN_TAG, "load " + strObtainAppId + " launchPage =" + objArr[1]);
            iWebviewObtainWebView.loadUrl(String.valueOf(objArr[1]));
            if (z) {
                aVar.e(bVar);
            }
        }
    }

    protected synchronized void c() {
        if (this.b != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (m mVar : this.b) {
                    mVar.onAnimationEnd();
                    arrayList.add(mVar);
                }
                if (arrayList.size() > 0) {
                    this.b.removeAll(arrayList);
                }
                arrayList.clear();
            } catch (Exception unused) {
            }
        }
    }

    public void d(io.dcloud.common.core.ui.b bVar) {
        IApp iAppObtainApp = bVar.obtainApp();
        iAppObtainApp.setMaskLayer(true);
        iAppObtainApp.obtainWebAppRootView().obtainMainView().invalidate();
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void dispose() {
        try {
            List list = this.b;
            if (list != null) {
                list.clear();
            }
            Iterator it = this.a.keySet().iterator();
            while (it.hasNext()) {
                ((io.dcloud.common.core.ui.a) this.a.get((String) it.next())).dispose();
            }
            this.a.clear();
            if (BaseInfo.ISDEBUG) {
                io.dcloud.common.core.ui.f.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:106:0x0253  */
    /* JADX WARN: Code duplicated, block: B:266:0x0650 A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:5:0x0028, B:303:0x0716, B:305:0x071a, B:307:0x0725, B:309:0x072b, B:311:0x0733, B:313:0x0739, B:314:0x0742, B:316:0x0749, B:318:0x074f, B:319:0x075a, B:321:0x075e, B:323:0x076d, B:325:0x0773, B:326:0x077c, B:328:0x0782, B:330:0x0788, B:331:0x0793, B:333:0x0797, B:335:0x07a9, B:337:0x07b3, B:336:0x07ae, B:338:0x0803, B:340:0x0811, B:342:0x0816, B:344:0x0824, B:346:0x0829, B:348:0x0841, B:349:0x084f, B:350:0x0883, B:352:0x0897, B:147:0x036a, B:149:0x036e, B:154:0x0390, B:150:0x037a, B:152:0x037e, B:166:0x03c3, B:168:0x03d8, B:169:0x03dd, B:170:0x03e5, B:172:0x03ef, B:174:0x03f8, B:176:0x0405, B:179:0x040f, B:181:0x0413, B:182:0x0417, B:184:0x0421, B:185:0x0454, B:186:0x045c, B:188:0x0461, B:189:0x046f, B:191:0x0474, B:193:0x0480, B:196:0x048a, B:198:0x048e, B:199:0x0492, B:201:0x049e, B:203:0x04a4, B:205:0x04a8, B:208:0x04b3, B:210:0x04bd, B:212:0x04c3, B:213:0x04cb, B:214:0x050c, B:217:0x0514, B:219:0x051a, B:221:0x0527, B:223:0x0533, B:225:0x0539, B:227:0x053f, B:229:0x0543, B:231:0x054d, B:233:0x0555, B:235:0x055d, B:236:0x0566, B:237:0x0571, B:238:0x0579, B:239:0x057c, B:241:0x0581, B:242:0x0589, B:243:0x059e, B:245:0x05a2, B:250:0x05ac, B:251:0x05d4, B:253:0x05d8, B:258:0x05e2, B:260:0x060c, B:262:0x061b, B:264:0x0625, B:265:0x0649, B:275:0x0687, B:277:0x0691, B:293:0x06ef, B:297:0x06f9, B:301:0x0706, B:302:0x070f, B:278:0x069b, B:280:0x069f, B:281:0x06ab, B:283:0x06af, B:287:0x06c1, B:290:0x06dd, B:133:0x02df, B:135:0x02e4, B:137:0x02fa, B:139:0x0302, B:141:0x0308, B:143:0x0343, B:144:0x034a, B:146:0x034e, B:22:0x005f, B:23:0x006c, B:24:0x0076, B:25:0x0080, B:26:0x008a, B:28:0x0098, B:30:0x00a2, B:32:0x00ab, B:34:0x00b0, B:36:0x00bc, B:38:0x00d7, B:39:0x00dd, B:40:0x00e5, B:48:0x0123, B:51:0x014a, B:53:0x014e, B:55:0x0159, B:56:0x0163, B:57:0x016c, B:59:0x0174, B:66:0x0191, B:69:0x0199, B:70:0x01a8, B:72:0x01b0, B:73:0x01be, B:75:0x01c2, B:77:0x01d2, B:79:0x01db, B:81:0x01e1, B:83:0x01fb, B:85:0x0219, B:87:0x0221, B:89:0x0227, B:91:0x022c, B:93:0x0230, B:95:0x0236, B:101:0x0244, B:103:0x0248, B:105:0x0250, B:108:0x0256, B:112:0x0262, B:113:0x0266, B:115:0x026a, B:120:0x0278, B:123:0x027e, B:96:0x0239, B:98:0x023d, B:124:0x0295, B:126:0x02a0, B:131:0x02b1, B:132:0x02b7, B:129:0x02a7, B:266:0x0650, B:268:0x0654, B:273:0x065d), top: B:453:0x0026, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x0654 A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:5:0x0028, B:303:0x0716, B:305:0x071a, B:307:0x0725, B:309:0x072b, B:311:0x0733, B:313:0x0739, B:314:0x0742, B:316:0x0749, B:318:0x074f, B:319:0x075a, B:321:0x075e, B:323:0x076d, B:325:0x0773, B:326:0x077c, B:328:0x0782, B:330:0x0788, B:331:0x0793, B:333:0x0797, B:335:0x07a9, B:337:0x07b3, B:336:0x07ae, B:338:0x0803, B:340:0x0811, B:342:0x0816, B:344:0x0824, B:346:0x0829, B:348:0x0841, B:349:0x084f, B:350:0x0883, B:352:0x0897, B:147:0x036a, B:149:0x036e, B:154:0x0390, B:150:0x037a, B:152:0x037e, B:166:0x03c3, B:168:0x03d8, B:169:0x03dd, B:170:0x03e5, B:172:0x03ef, B:174:0x03f8, B:176:0x0405, B:179:0x040f, B:181:0x0413, B:182:0x0417, B:184:0x0421, B:185:0x0454, B:186:0x045c, B:188:0x0461, B:189:0x046f, B:191:0x0474, B:193:0x0480, B:196:0x048a, B:198:0x048e, B:199:0x0492, B:201:0x049e, B:203:0x04a4, B:205:0x04a8, B:208:0x04b3, B:210:0x04bd, B:212:0x04c3, B:213:0x04cb, B:214:0x050c, B:217:0x0514, B:219:0x051a, B:221:0x0527, B:223:0x0533, B:225:0x0539, B:227:0x053f, B:229:0x0543, B:231:0x054d, B:233:0x0555, B:235:0x055d, B:236:0x0566, B:237:0x0571, B:238:0x0579, B:239:0x057c, B:241:0x0581, B:242:0x0589, B:243:0x059e, B:245:0x05a2, B:250:0x05ac, B:251:0x05d4, B:253:0x05d8, B:258:0x05e2, B:260:0x060c, B:262:0x061b, B:264:0x0625, B:265:0x0649, B:275:0x0687, B:277:0x0691, B:293:0x06ef, B:297:0x06f9, B:301:0x0706, B:302:0x070f, B:278:0x069b, B:280:0x069f, B:281:0x06ab, B:283:0x06af, B:287:0x06c1, B:290:0x06dd, B:133:0x02df, B:135:0x02e4, B:137:0x02fa, B:139:0x0302, B:141:0x0308, B:143:0x0343, B:144:0x034a, B:146:0x034e, B:22:0x005f, B:23:0x006c, B:24:0x0076, B:25:0x0080, B:26:0x008a, B:28:0x0098, B:30:0x00a2, B:32:0x00ab, B:34:0x00b0, B:36:0x00bc, B:38:0x00d7, B:39:0x00dd, B:40:0x00e5, B:48:0x0123, B:51:0x014a, B:53:0x014e, B:55:0x0159, B:56:0x0163, B:57:0x016c, B:59:0x0174, B:66:0x0191, B:69:0x0199, B:70:0x01a8, B:72:0x01b0, B:73:0x01be, B:75:0x01c2, B:77:0x01d2, B:79:0x01db, B:81:0x01e1, B:83:0x01fb, B:85:0x0219, B:87:0x0221, B:89:0x0227, B:91:0x022c, B:93:0x0230, B:95:0x0236, B:101:0x0244, B:103:0x0248, B:105:0x0250, B:108:0x0256, B:112:0x0262, B:113:0x0266, B:115:0x026a, B:120:0x0278, B:123:0x027e, B:96:0x0239, B:98:0x023d, B:124:0x0295, B:126:0x02a0, B:131:0x02b1, B:132:0x02b7, B:129:0x02a7, B:266:0x0650, B:268:0x0654, B:273:0x065d), top: B:453:0x0026, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x0657  */
    /* JADX WARN: Code duplicated, block: B:271:0x065a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:273:0x065d A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:5:0x0028, B:303:0x0716, B:305:0x071a, B:307:0x0725, B:309:0x072b, B:311:0x0733, B:313:0x0739, B:314:0x0742, B:316:0x0749, B:318:0x074f, B:319:0x075a, B:321:0x075e, B:323:0x076d, B:325:0x0773, B:326:0x077c, B:328:0x0782, B:330:0x0788, B:331:0x0793, B:333:0x0797, B:335:0x07a9, B:337:0x07b3, B:336:0x07ae, B:338:0x0803, B:340:0x0811, B:342:0x0816, B:344:0x0824, B:346:0x0829, B:348:0x0841, B:349:0x084f, B:350:0x0883, B:352:0x0897, B:147:0x036a, B:149:0x036e, B:154:0x0390, B:150:0x037a, B:152:0x037e, B:166:0x03c3, B:168:0x03d8, B:169:0x03dd, B:170:0x03e5, B:172:0x03ef, B:174:0x03f8, B:176:0x0405, B:179:0x040f, B:181:0x0413, B:182:0x0417, B:184:0x0421, B:185:0x0454, B:186:0x045c, B:188:0x0461, B:189:0x046f, B:191:0x0474, B:193:0x0480, B:196:0x048a, B:198:0x048e, B:199:0x0492, B:201:0x049e, B:203:0x04a4, B:205:0x04a8, B:208:0x04b3, B:210:0x04bd, B:212:0x04c3, B:213:0x04cb, B:214:0x050c, B:217:0x0514, B:219:0x051a, B:221:0x0527, B:223:0x0533, B:225:0x0539, B:227:0x053f, B:229:0x0543, B:231:0x054d, B:233:0x0555, B:235:0x055d, B:236:0x0566, B:237:0x0571, B:238:0x0579, B:239:0x057c, B:241:0x0581, B:242:0x0589, B:243:0x059e, B:245:0x05a2, B:250:0x05ac, B:251:0x05d4, B:253:0x05d8, B:258:0x05e2, B:260:0x060c, B:262:0x061b, B:264:0x0625, B:265:0x0649, B:275:0x0687, B:277:0x0691, B:293:0x06ef, B:297:0x06f9, B:301:0x0706, B:302:0x070f, B:278:0x069b, B:280:0x069f, B:281:0x06ab, B:283:0x06af, B:287:0x06c1, B:290:0x06dd, B:133:0x02df, B:135:0x02e4, B:137:0x02fa, B:139:0x0302, B:141:0x0308, B:143:0x0343, B:144:0x034a, B:146:0x034e, B:22:0x005f, B:23:0x006c, B:24:0x0076, B:25:0x0080, B:26:0x008a, B:28:0x0098, B:30:0x00a2, B:32:0x00ab, B:34:0x00b0, B:36:0x00bc, B:38:0x00d7, B:39:0x00dd, B:40:0x00e5, B:48:0x0123, B:51:0x014a, B:53:0x014e, B:55:0x0159, B:56:0x0163, B:57:0x016c, B:59:0x0174, B:66:0x0191, B:69:0x0199, B:70:0x01a8, B:72:0x01b0, B:73:0x01be, B:75:0x01c2, B:77:0x01d2, B:79:0x01db, B:81:0x01e1, B:83:0x01fb, B:85:0x0219, B:87:0x0221, B:89:0x0227, B:91:0x022c, B:93:0x0230, B:95:0x0236, B:101:0x0244, B:103:0x0248, B:105:0x0250, B:108:0x0256, B:112:0x0262, B:113:0x0266, B:115:0x026a, B:120:0x0278, B:123:0x027e, B:96:0x0239, B:98:0x023d, B:124:0x0295, B:126:0x02a0, B:131:0x02b1, B:132:0x02b7, B:129:0x02a7, B:266:0x0650, B:268:0x0654, B:273:0x065d), top: B:453:0x0026, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x022b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0242  */
    /* JADX WARN: Instruction removed from duplicated block: B:273:0x065d, please report this as an issue */
    @Override // io.dcloud.common.DHInterface.IMgr
    public Object processEvent(IMgr.MgrType mgrType, int i2, Object obj) {
        String str;
        Object obj2;
        io.dcloud.common.core.ui.b bVar;
        IDCloudWebviewClientListener iDCloudWebviewClientListener;
        io.dcloud.common.core.ui.a aVar;
        io.dcloud.common.core.ui.b bVarH;
        IEventCallback iEventCallback;
        String str2;
        io.dcloud.common.core.ui.a aVar2;
        String strObtainAppId;
        Activity activity;
        io.dcloud.common.core.ui.a aVar3;
        JSONObject jSONObject;
        io.dcloud.common.core.ui.b bVarH2;
        Object objProcessEvent;
        String str3 = "auto_pop ";
        try {
            try {
                if (!checkMgrId(mgrType)) {
                    return this.mCore.dispatchEvent(mgrType, i2, obj);
                }
                try {
                    if (i2 == -1) {
                        obj2 = null;
                        TestUtil.debug(b().obtainMainViewGroup());
                    } else if (i2 != 52) {
                        str = Logger.VIEW_VISIBLE_TAG;
                        switch (i2) {
                            case 1:
                                Object[] objArr = (Object[]) obj;
                                Object obj3 = objArr[0];
                                if (obj3 instanceof io.dcloud.common.core.ui.b) {
                                    io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) obj3;
                                    if (objArr.length < 3 ? true : ((Boolean) objArr[2]).booleanValue()) {
                                        bVar2.lastShowTime = System.currentTimeMillis();
                                    }
                                    bVar2.a(io.dcloud.common.core.ui.b.z);
                                    Logger.d(Logger.ANIMATION_TAG, "showWindow" + bVar2);
                                    bVar2.k.a(bVar2.obtainWebView().obtainWindowView(), new d(bVar2, objArr));
                                }
                                obj2 = null;
                                break;
                            case 2:
                                if (obj instanceof io.dcloud.common.core.ui.b) {
                                    bVar = (io.dcloud.common.core.ui.b) obj;
                                } else {
                                    bVar = null;
                                }
                                if (bVar == null) {
                                    return null;
                                }
                                bVar.a(io.dcloud.common.core.ui.b.B);
                                Logger.d(Logger.ANIMATION_TAG, "closeWindow" + bVar);
                                return bVar.k.a(bVar.obtainWebView().obtainWindowView(), new g(bVar, i2));
                            case 3:
                                Object[] objArr2 = (Object[]) obj;
                                int i3 = Integer.parseInt(String.valueOf(objArr2[0]));
                                IApp iApp = (IApp) objArr2[1];
                                Object[] objArr3 = (Object[]) objArr2[2];
                                if (objArr2.length <= 4 || PdrUtil.isEmpty(objArr2[4])) {
                                    iDCloudWebviewClientListener = null;
                                } else {
                                    Object obj4 = objArr2[4];
                                    if (obj4 instanceof IDCloudWebviewClientListener) {
                                        iDCloudWebviewClientListener = (IDCloudWebviewClientListener) obj4;
                                    } else {
                                        iDCloudWebviewClientListener = null;
                                    }
                                }
                                if (objArr2.length >= 4) {
                                    Object obj5 = objArr2[3];
                                    if (obj5 instanceof io.dcloud.common.core.ui.a) {
                                        aVar = (io.dcloud.common.core.ui.a) obj5;
                                        bVarH = null;
                                    } else if (obj5 instanceof io.dcloud.common.core.ui.b) {
                                        bVarH = (io.dcloud.common.core.ui.b) obj5;
                                        aVar = null;
                                    } else {
                                        aVar = null;
                                        bVarH = null;
                                    }
                                } else {
                                    aVar = null;
                                    bVarH = null;
                                }
                                if (objArr2.length >= 5) {
                                    Object obj6 = objArr2[4];
                                    if (obj6 instanceof IEventCallback) {
                                        iEventCallback = (IEventCallback) obj6;
                                    } else {
                                        iEventCallback = null;
                                    }
                                } else {
                                    iEventCallback = null;
                                }
                                if (aVar == null) {
                                    aVar = (io.dcloud.common.core.ui.a) iApp.obtainWebAppRootView();
                                }
                                if (bVarH == null) {
                                    bVarH = aVar == null ? null : aVar.h();
                                }
                                if (objArr2.length == 6) {
                                    Object obj7 = objArr2[5];
                                }
                                if (i3 != 1) {
                                    try {
                                        return a(i3, iApp, aVar, bVarH, iEventCallback, objArr3, iDCloudWebviewClientListener);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        Logger.e("winmgr", "Exception msg=" + e2);
                                    }
                                }
                                obj2 = null;
                                break;
                            case 4:
                                Object[] objArr4 = (Object[]) obj;
                                return Boolean.valueOf(a((IApp) objArr4[0], String.valueOf(objArr4[1])));
                            case 5:
                            case 10:
                                a(i2, obj);
                                obj2 = null;
                                break;
                            case 6:
                                return obj instanceof String ? ((io.dcloud.common.core.ui.a) this.a.get((String) obj)).c() : b().c();
                            case 7:
                                Object[] objArr5 = (Object[]) obj;
                                io.dcloud.common.core.ui.b bVar3 = (io.dcloud.common.core.ui.b) objArr5[0];
                                boolean zBooleanValue = ((Boolean) objArr5[1]).booleanValue();
                                boolean zBooleanValue2 = ((Boolean) objArr5[2]).booleanValue();
                                boolean zBooleanValue3 = ((Boolean) objArr5[3]).booleanValue();
                                StringBuilder sb = new StringBuilder("setStyle ");
                                sb.append(bVar3);
                                if (zBooleanValue) {
                                    str2 = "发生位置区域变化";
                                } else if (zBooleanValue2) {
                                    str2 = "zindex发生了变化";
                                } else {
                                    str2 = zBooleanValue3 ? "设置透明度变化" : "";
                                }
                                sb.append(str2);
                                Logger.d(Logger.ANIMATION_TAG, sb.toString());
                                bVar3.d = zBooleanValue3;
                                bVar3.p();
                                bVar3.g = !bVar3.k.d().contains(bVar3);
                                if (!bVar3.inStack || !zBooleanValue) {
                                    boolean z = zBooleanValue2 || zBooleanValue3 || zBooleanValue;
                                    bVar3.v = z;
                                    if (!bVar3.isChildOfFrameView && z) {
                                        bVar3.k.b(bVar3);
                                        processEvent(IMgr.MgrType.WindowMgr, 28, bVar3.b);
                                        bVar3.b = null;
                                    }
                                    bVar3.makeViewOptions_animate();
                                    bVar3.o();
                                    if (zBooleanValue) {
                                        bVar3.obtainMainView().dispatchConfigurationChanged(AndroidResources.mResources.getConfiguration());
                                    }
                                } else if (bVar3.isChildOfFrameView) {
                                    bVar3.makeViewOptions_animate();
                                    bVar3.o();
                                    if (zBooleanValue) {
                                        bVar3.obtainMainView().dispatchConfigurationChanged(AndroidResources.mResources.getConfiguration());
                                        bVar3.k.resize();
                                    }
                                } else {
                                    bVar3.k.b(bVar3);
                                    if (bVar3.e()) {
                                        processEvent(IMgr.MgrType.WindowMgr, 28, bVar3.b);
                                        bVar3.b = null;
                                    }
                                    bVar3.s();
                                    bVar3.startAnimator(0);
                                }
                                obj2 = null;
                                break;
                            case 8:
                                io.dcloud.common.core.ui.b bVar4 = (io.dcloud.common.core.ui.b) obj;
                                if (bVar4 != null && !bVar4.k.d().contains(bVar4)) {
                                    Logger.d(Logger.VIEW_VISIBLE_TAG, "setParent " + bVar4);
                                    bVar4.h();
                                    bVar4.k.e(bVar4);
                                    if (bVar4.g) {
                                        bVar4.resize();
                                        bVar4.g = false;
                                    }
                                }
                                bVar4.inStack = true;
                                bVar4.i = false;
                                obj2 = null;
                                break;
                            case 9:
                                io.dcloud.common.core.ui.a aVar4 = (io.dcloud.common.core.ui.a) this.a.get(String.valueOf(obj));
                                if (aVar4 != null && !aVar4.d().isEmpty()) {
                                    return aVar4.d().firstElement();
                                }
                                obj2 = null;
                                break;
                            case 11:
                                io.dcloud.common.core.ui.a aVar5 = ((io.dcloud.common.core.ui.b) obj).k;
                                aVar5.a(aVar5, 3);
                                obj2 = null;
                                break;
                            case 12:
                                b().reload(false);
                                obj2 = null;
                                break;
                            case 13:
                                b().reload(true);
                                obj2 = null;
                                break;
                            case 14:
                                b().reload(String.valueOf(obj));
                                obj2 = null;
                                break;
                            default:
                                switch (i2) {
                                    case 16:
                                        Object[] objArr6 = (Object[]) obj;
                                        a((ViewGroup) objArr6[0], (IApp) objArr6[1], (IWebview) objArr6[2], (ViewGroup.LayoutParams) objArr6[3]);
                                        obj2 = null;
                                        break;
                                    case 17:
                                        Object[] objArr7 = (Object[]) obj;
                                        IApp iApp2 = (IApp) objArr7[0];
                                        String str4 = (String) objArr7[1];
                                        IWebviewStateListener iWebviewStateListener = (IWebviewStateListener) objArr7[2];
                                        IDCloudWebviewClientListener iDCloudWebviewClientListener2 = (objArr7.length <= 3 || PdrUtil.isEmpty(objArr7[3])) ? null : (IDCloudWebviewClientListener) objArr7[3];
                                        a(iApp2, iApp2.obtainAppId());
                                        IFrameView iFrameView = (IFrameView) processEvent(IMgr.MgrType.WindowMgr, 3, new Object[]{2, iApp2, new Object[]{str4}, (io.dcloud.common.core.ui.a) this.a.get(iApp2.obtainAppId()), iDCloudWebviewClientListener2});
                                        IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
                                        if (iWebviewStateListener != null) {
                                            iWebviewObtainWebView.addStateListener(iWebviewStateListener);
                                            iWebviewStateListener.onCallBack(-1, iWebviewObtainWebView);
                                        }
                                        iWebviewObtainWebView.loadUrl(str4);
                                        return iFrameView;
                                    case 18:
                                        return a();
                                    default:
                                        try {
                                            switch (i2) {
                                                case 20:
                                                    boolean z2 = !SDK.isEnableBackground;
                                                    if (obj instanceof IApp) {
                                                        aVar2 = (io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView();
                                                    } else if (obj instanceof String) {
                                                        aVar2 = (io.dcloud.common.core.ui.a) this.a.get((String) obj);
                                                    } else if (obj instanceof Map) {
                                                        Map map = (Map) obj;
                                                        String str5 = (String) map.get("appid");
                                                        if (TextUtils.isEmpty(str5)) {
                                                            return null;
                                                        }
                                                        aVar2 = (io.dcloud.common.core.ui.a) this.a.get(str5);
                                                        boolean zBooleanValue4 = ((Boolean) map.get("isStopApp")).booleanValue();
                                                        if (map.containsKey("quitModel") && zBooleanValue4) {
                                                            aVar2.j.setQuitModel(((Integer) map.get("quitModel")).intValue());
                                                        }
                                                        z2 = zBooleanValue4;
                                                    } else {
                                                        aVar2 = null;
                                                    }
                                                    if (SDK.isUniMPSDK() && !z2) {
                                                        if (aVar2 == null) {
                                                            return null;
                                                        }
                                                        aVar2.getActivity().moveTaskToBack(true);
                                                        return null;
                                                    }
                                                    if (aVar2 != null) {
                                                        aVar2.j.setStatus((byte) 2);
                                                        aVar2.h = false;
                                                    }
                                                    processEvent(IMgr.MgrType.AppMgr, 10, obj);
                                                    obj2 = null;
                                                    break;
                                                    break;
                                                case 21:
                                                    if (obj instanceof io.dcloud.common.core.ui.b) {
                                                        bVar = (io.dcloud.common.core.ui.b) obj;
                                                    } else {
                                                        bVar = null;
                                                    }
                                                    if (bVar == null) {
                                                        return null;
                                                    }
                                                    bVar.a(io.dcloud.common.core.ui.b.B);
                                                    Logger.d(Logger.ANIMATION_TAG, "closeWindow" + bVar);
                                                    return bVar.k.a(bVar.obtainWebView().obtainWindowView(), new g(bVar, i2));
                                                case 22:
                                                    if (obj != null) {
                                                        io.dcloud.common.core.ui.b bVar5 = (io.dcloud.common.core.ui.b) obj;
                                                        if (bVar5.k.d().contains(bVar5) && !bVar5.obtainWebView().isUniService()) {
                                                            Logger.d(Logger.VIEW_VISIBLE_TAG, "setUnParent " + bVar5);
                                                            bVar5.onPopFromStack(bVar5.g());
                                                            bVar5.k.removeFrameItem(bVar5);
                                                            bVar5.k.d().remove(bVar5);
                                                        }
                                                        bVar5.inStack = false;
                                                        bVar5.h = false;
                                                    }
                                                    obj2 = null;
                                                    break;
                                                case 23:
                                                    io.dcloud.common.core.ui.b bVar6 = obj instanceof io.dcloud.common.core.ui.b ? (io.dcloud.common.core.ui.b) obj : null;
                                                    if (bVar6 == null) {
                                                        return null;
                                                    }
                                                    Logger.d(Logger.ANIMATION_TAG, "hideWindow" + bVar6);
                                                    bVar6.a(io.dcloud.common.core.ui.b.A);
                                                    bVar6.k.a(bVar6.obtainWebView().obtainWindowView(), new f(bVar6));
                                                    obj2 = null;
                                                    break;
                                                    break;
                                                case 24:
                                                    io.dcloud.common.core.ui.b bVar7 = obj instanceof io.dcloud.common.core.ui.b ? (io.dcloud.common.core.ui.b) obj : null;
                                                    if (bVar7 == null) {
                                                        return null;
                                                    }
                                                    Logger.d(Logger.ANIMATION_TAG, "hideShowWindow" + bVar7);
                                                    bVar7.a(io.dcloud.common.core.ui.b.z);
                                                    bVar7.k.a(bVar7.obtainWebView().obtainWindowView(), new e(bVar7));
                                                    obj2 = null;
                                                    break;
                                                    break;
                                                case 25:
                                                    io.dcloud.common.core.ui.a aVar6 = (io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView();
                                                    aVar6.dispose();
                                                    this.a.remove(aVar6.i);
                                                    obj2 = null;
                                                    break;
                                                case 26:
                                                    io.dcloud.common.core.ui.a aVar7 = (io.dcloud.common.core.ui.a) obj;
                                                    if (aVar7 != null) {
                                                        aVar7.k();
                                                        aVar7.l();
                                                    }
                                                    obj2 = null;
                                                    break;
                                                case 27:
                                                    ArrayList arrayList = (ArrayList) obj;
                                                    if (arrayList != null) {
                                                        io.dcloud.common.core.ui.a aVar8 = null;
                                                        IApp iAppObtainApp = null;
                                                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                                                            io.dcloud.common.core.ui.b bVar8 = (io.dcloud.common.core.ui.b) arrayList.get(size);
                                                            if (bVar8 != null) {
                                                                if (aVar8 == null) {
                                                                    aVar8 = bVar8.k;
                                                                }
                                                                if (iAppObtainApp == null) {
                                                                    iAppObtainApp = bVar8.obtainApp();
                                                                }
                                                                if (bVar8.k.d().contains(bVar8) && ((bVar8.checkITypeofAble() || !bVar8.a) && !bVar8.obtainWebView().isUniService())) {
                                                                    if (BaseInfo.isUniAppAppid(bVar8.obtainApp()) && bVar8.obtainWebView() != null) {
                                                                        bVar8.obtainWebView().setIWebViewFocusable(false);
                                                                    }
                                                                    bVar8.onPopFromStack(bVar8.g());
                                                                    Logger.d(Logger.AUTO_POP_PUSH_TAG, "auto_pop " + bVar8);
                                                                    Logger.d(Logger.ANIMATION_TAG, "auto_pop " + bVar8);
                                                                    bVar8.k.removeFrameItem(bVar8);
                                                                    bVar8.k.d().remove(bVar8);
                                                                    bVar8.i = false;
                                                                    bVar8.h = true;
                                                                    bVar8.inStack = false;
                                                                }
                                                            }
                                                        }
                                                        if (aVar8 != null && iAppObtainApp != null && BaseInfo.isUniAppAppid(iAppObtainApp)) {
                                                            int size2 = aVar8.d().size();
                                                            int i4 = 1;
                                                            for (int i5 = size2 - 1; i5 >= 0; i5--) {
                                                                io.dcloud.common.core.ui.b bVar9 = (io.dcloud.common.core.ui.b) aVar8.d().get(i5);
                                                                if (bVar9 != null && bVar9.obtainWebView() != null && bVar9.obtainMainView() != null) {
                                                                    if (i5 != size2 - i4) {
                                                                        bVar9.obtainWebView().setIWebViewFocusable(false);
                                                                    } else if (bVar9.obtainMainView().getVisibility() != 0 || bVar9.c() == io.dcloud.common.core.ui.b.A || bVar9.c() == io.dcloud.common.core.ui.b.B) {
                                                                        bVar9.obtainWebView().setIWebViewFocusable(false);
                                                                        i4++;
                                                                    } else {
                                                                        bVar9.obtainWebView().setIWebViewFocusable(true);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    break;
                                                case 28:
                                                    if (obj != null) {
                                                        ArrayList arrayList2 = (ArrayList) obj;
                                                        if (arrayList2.size() > 0) {
                                                            io.dcloud.common.core.ui.a aVar9 = null;
                                                            IApp iAppObtainApp2 = null;
                                                            boolean z3 = false;
                                                            for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                                                                io.dcloud.common.core.ui.b bVar10 = (io.dcloud.common.core.ui.b) arrayList2.get(size3);
                                                                if (bVar10 != null) {
                                                                    if (aVar9 == null) {
                                                                        aVar9 = bVar10.k;
                                                                    }
                                                                    if (iAppObtainApp2 == null) {
                                                                        iAppObtainApp2 = bVar10.obtainApp();
                                                                    }
                                                                    if (!aVar9.d().contains(bVar10)) {
                                                                        bVar10.onPushToStack(true);
                                                                        Logger.d(Logger.AUTO_POP_PUSH_TAG, "auto_push " + bVar10);
                                                                        Logger.d(Logger.ANIMATION_TAG, "auto_push " + bVar10);
                                                                        z3 |= bVar10.g;
                                                                        bVar10.g = false;
                                                                        bVar10.k.e(bVar10);
                                                                    }
                                                                    bVar10.i = true;
                                                                    bVar10.h = false;
                                                                    bVar10.inStack = true;
                                                                }
                                                            }
                                                            if (z3) {
                                                                ((io.dcloud.common.core.ui.b) arrayList2.get(0)).k.resize();
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    break;
                                                case 29:
                                                    d((io.dcloud.common.core.ui.b) obj);
                                                    obj2 = null;
                                                    break;
                                                case 30:
                                                    b((io.dcloud.common.core.ui.b) obj);
                                                    obj2 = null;
                                                    break;
                                                case 31:
                                                    IFrameView iFrameView2 = (IFrameView) obj;
                                                    View viewObtainMainView = iFrameView2.obtainMainView();
                                                    IActivityHandler iActivityHandler = DCloudAdapterUtil.getIActivityHandler(iFrameView2.obtainApp().getActivity());
                                                    if (iActivityHandler != null) {
                                                        iActivityHandler.setWebViewIntoPreloadView(viewObtainMainView);
                                                    }
                                                    obj2 = null;
                                                    break;
                                                case 32:
                                                    if (obj instanceof IApp) {
                                                        IApp iApp3 = (IApp) obj;
                                                        activity = iApp3.getActivity();
                                                        strObtainAppId = iApp3.obtainAppId();
                                                    } else if (obj instanceof Object[]) {
                                                        Object[] objArr8 = (Object[]) obj;
                                                        activity = (Activity) objArr8[0];
                                                        strObtainAppId = (String) objArr8[1];
                                                    } else {
                                                        strObtainAppId = null;
                                                        activity = null;
                                                    }
                                                    Boolean bool = Boolean.FALSE;
                                                    for (String str6 : this.a.keySet()) {
                                                        if (!PdrUtil.isEquals(str6, strObtainAppId) && activity == ((io.dcloud.common.core.ui.a) this.a.get(str6)).getActivity()) {
                                                            return Boolean.TRUE;
                                                        }
                                                    }
                                                    return bool;
                                                default:
                                                    switch (i2) {
                                                        case 41:
                                                            obj2 = null;
                                                            b(i2, obj);
                                                            break;
                                                        case 42:
                                                            io.dcloud.common.core.ui.b bVar11 = (io.dcloud.common.core.ui.b) obj;
                                                            io.dcloud.common.core.ui.a aVar10 = bVar11.k;
                                                            if (bVar11 == aVar10.d) {
                                                                obj2 = null;
                                                                aVar10.d = null;
                                                            } else {
                                                                obj2 = null;
                                                            }
                                                            break;
                                                        case 43:
                                                            return ((io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView()).d;
                                                        case 44:
                                                            return ((io.dcloud.common.core.ui.a) this.a.get(((IApp) obj).obtainAppId())).h();
                                                        case 45:
                                                            Object[] objArr9 = (Object[]) obj;
                                                            io.dcloud.common.core.ui.b bVar12 = (io.dcloud.common.core.ui.b) objArr9[0];
                                                            io.dcloud.common.core.ui.b bVar13 = (io.dcloud.common.core.ui.b) objArr9[1];
                                                            if (BaseInfo.isUniAppAppid(bVar12.obtainApp())) {
                                                                bVar12.obtainWebView().setIWebViewFocusable(true);
                                                                bVar13.obtainWebView().setIWebViewFocusable(true);
                                                            }
                                                            bVar12.lastShowTime = bVar13.lastShowTime - 1;
                                                            Stack stackD = bVar12.k.d();
                                                            ArrayList arrayListC = bVar12.k.c();
                                                            stackD.remove(bVar12);
                                                            arrayListC.remove(bVar12);
                                                            arrayListC.add(arrayListC.indexOf(bVar13), bVar12);
                                                            bVar12.k.a(bVar12.obtainWebView().obtainWindowView(), new h(bVar12));
                                                            obj2 = null;
                                                            break;
                                                        case 46:
                                                            io.dcloud.common.core.ui.a aVar11 = (io.dcloud.common.core.ui.a) this.a.get(String.valueOf(obj));
                                                            if (aVar11 != null) {
                                                                return aVar11.e();
                                                            }
                                                            obj2 = null;
                                                            break;
                                                        case 47:
                                                            io.dcloud.common.core.ui.a aVar12 = (io.dcloud.common.core.ui.a) this.a.get(String.valueOf(obj));
                                                            if (aVar12 != null) {
                                                                return aVar12.f();
                                                            }
                                                            obj2 = null;
                                                            break;
                                                        case 48:
                                                            if (obj instanceof IApp) {
                                                                io.dcloud.common.core.ui.a aVar13 = (io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView();
                                                                io.dcloud.common.core.ui.b bVarE = a((IApp) obj) ? aVar13.e() : aVar13.a(5);
                                                                JSONObject jSONObjectObtainThridInfo = ((IApp) obj).obtainThridInfo(IApp.ConfigProperty.ThridInfo.DirectPageJsonData);
                                                                JSONArray jSONArray = new JSONArray();
                                                                jSONArray.put("NWindow");
                                                                jSONArray.put("setStyle");
                                                                JSONArray jSONArray2 = new JSONArray();
                                                                jSONArray2.put(bVarE.hashCode());
                                                                JSONArray jSONArray3 = new JSONArray();
                                                                jSONArray3.put(jSONObjectObtainThridInfo);
                                                                jSONArray2.put(jSONArray3);
                                                                jSONArray.put(jSONArray2);
                                                                processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{bVarE.obtainWebView(), "UI", "execMethod", jSONArray});
                                                            }
                                                            obj2 = null;
                                                            break;
                                                        case 49:
                                                            if (obj instanceof IApp) {
                                                                io.dcloud.common.core.ui.a aVar14 = (io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView();
                                                                io.dcloud.common.core.ui.b bVarE2 = aVar14.e();
                                                                if (bVarE2 != null && bVarE2.obtainWebView() != null) {
                                                                    ((AdaWebview) bVarE2.obtainWebView()).checkInjectSitemap();
                                                                }
                                                                io.dcloud.common.core.ui.b bVarF = aVar14.f();
                                                                if (bVarF != null && bVarF.obtainWebView() != null) {
                                                                    ((AdaWebview) bVarF.obtainWebView()).checkInjectSitemap();
                                                                }
                                                            }
                                                            obj2 = null;
                                                            break;
                                                        case 50:
                                                            if ((obj instanceof IApp) && (aVar3 = (io.dcloud.common.core.ui.a) ((IApp) obj).obtainWebAppRootView()) != null) {
                                                                io.dcloud.common.core.ui.b bVarE3 = aVar3.e();
                                                                if (bVarE3 != null && a((IApp) obj) && bVarE3.obtainWebView() != null) {
                                                                    ((AdaWebview) bVarE3.obtainWebView()).checkPreLoadJsContent();
                                                                }
                                                                io.dcloud.common.core.ui.b bVarA = aVar3.a(5);
                                                                if (bVarA != null && bVarA.obtainWebView() != null) {
                                                                    ((AdaWebview) bVarA.obtainWebView()).checkPreLoadJsContent();
                                                                }
                                                            }
                                                            obj2 = null;
                                                            break;
                                                        default:
                                                            obj2 = null;
                                                            switch (i2) {
                                                                case IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
                                                                    c();
                                                                    break;
                                                                case IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
                                                                    a((m) obj);
                                                                    break;
                                                                case IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
                                                                    Object[] objArr10 = (Object[]) obj;
                                                                    io.dcloud.common.core.ui.b bVar14 = (io.dcloud.common.core.ui.b) objArr10[0];
                                                                    a(bVar14, bVar14.obtainApp().obtainStatusBarMgr().isImmersive, (JSONObject) objArr10[1], (String) objArr10[2]);
                                                                    break;
                                                                case IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
                                                                    Object[] objArr11 = (Object[]) obj;
                                                                    a((io.dcloud.common.core.ui.b) objArr11[0], (io.dcloud.common.core.ui.b) objArr11[1]);
                                                                    break;
                                                                case IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
                                                                    a((io.dcloud.common.core.ui.b) ((Object[]) obj)[0], true);
                                                                    break;
                                                                case IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                                                                    io.dcloud.common.core.ui.b bVar15 = (io.dcloud.common.core.ui.b) ((Object[]) obj)[0];
                                                                    ViewOptions viewOptionsObtainFrameOptions = bVar15.obtainWebviewParent().obtainFrameOptions();
                                                                    if (!viewOptionsObtainFrameOptions.hasBackground() || bVar15.obtainFrameOptions().isTabHasBg()) {
                                                                        viewOptionsObtainFrameOptions = bVar15.obtainFrameOptions();
                                                                    }
                                                                    bVar15.b(viewOptionsObtainFrameOptions, bVar15, bVar15.obtainWebviewParent(), (AdaFrameItem) bVar15.obtainWebView());
                                                                    break;
                                                                case IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
                                                                    IApp iApp4 = (IApp) obj;
                                                                    io.dcloud.common.core.ui.b bVarH3 = ((io.dcloud.common.core.ui.a) this.a.get(iApp4.obtainAppId())).h();
                                                                    if (bVarH3 != null && (bVarH3 instanceof io.dcloud.common.core.ui.c)) {
                                                                        bVarH3 = ((io.dcloud.common.core.ui.c) bVarH3).u();
                                                                    }
                                                                    if (bVarH3 == null || bVarH3.obtainFrameOptions().mDebugRefresh == null) {
                                                                        iApp4.setConfigProperty(IApp.ConfigProperty.UNI_RESTART_TO_DIRECT, String.valueOf(false));
                                                                    } else {
                                                                        iApp4.setConfigProperty(AbsoluteConst.JSON_KEY_DEBUG_REFRESH, bVarH3.obtainFrameOptions().mDebugRefresh.toString());
                                                                        iApp4.setConfigProperty(IApp.ConfigProperty.UNI_RESTART_TO_DIRECT, String.valueOf(true));
                                                                    }
                                                                    break;
                                                                case IMgr.WindowEvent.TITLE_BAR_MENU_ITEM_CLICK /* 77 */:
                                                                    if (obj != null) {
                                                                        Object[] objArr12 = (Object[]) obj;
                                                                        IWebview iWebview = (IWebview) objArr12[0];
                                                                        Bundle bundle = (Bundle) objArr12[1];
                                                                        if (iWebview.getActivity() instanceof IActivityHandler) {
                                                                            ((IActivityHandler) iWebview.getActivity()).callBack("TITLE_BAR_MENU_CLICK", bundle);
                                                                        }
                                                                    }
                                                                    break;
                                                                case IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
                                                                    if (obj != null) {
                                                                        io.dcloud.common.core.ui.b bVarH4 = ((io.dcloud.common.core.ui.a) this.a.get((String) obj)).h();
                                                                        if (bVarH4 != null && (bVarH4 instanceof io.dcloud.common.core.ui.c)) {
                                                                            bVarH4 = ((io.dcloud.common.core.ui.c) bVarH4).u();
                                                                        }
                                                                        if (bVarH4 != null && bVarH4.obtainFrameOptions().mUniPageUrl != null && (jSONObject = bVarH4.obtainFrameOptions().mUniPageUrl) != null) {
                                                                            String string = jSONObject.getString(AbsoluteConst.XML_PATH);
                                                                            if (jSONObject.has("query")) {
                                                                                String string2 = jSONObject.getString("query");
                                                                                if (!TextUtils.isEmpty(string2)) {
                                                                                    return ((Object) string) + Operators.CONDITION_IF_STRING + string2;
                                                                                }
                                                                            }
                                                                            return string;
                                                                        }
                                                                    }
                                                                    break;
                                                                case 79:
                                                                    if (obj != null) {
                                                                        Bundle bundle2 = (Bundle) obj;
                                                                        String string3 = bundle2.getString("appid");
                                                                        io.dcloud.common.core.ui.a aVar15 = (io.dcloud.common.core.ui.a) this.a.get(string3);
                                                                        if (aVar15 != null && (bVarH2 = aVar15.h()) != null && (objProcessEvent = processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{bVarH2.obtainApp(), AbsoluteConst.F_UI, "findWebview", new String[]{string3, "__uniapp__service"}})) != null && (objProcessEvent instanceof AdaUniWebView)) {
                                                                            HashMap map2 = new HashMap();
                                                                            if (bundle2.getString("dataType").equals("JSON")) {
                                                                                map2.put("data", JSON.parse(bundle2.getString("data")));
                                                                            } else {
                                                                                map2.put("data", bundle2.getString("data"));
                                                                            }
                                                                            map2.put("event", bundle2.getString("event"));
                                                                            ((AdaUniWebView) objProcessEvent).fireEvent(new EventActionInfo("uniMPNativeEvent", map2));
                                                                        }
                                                                    }
                                                                    break;
                                                                case 80:
                                                                    Object[] objArr13 = (Object[]) obj;
                                                                    IWebview iWebview2 = (IWebview) objArr13[0];
                                                                    Bundle bundle3 = (Bundle) objArr13[1];
                                                                    if (iWebview2.getActivity() instanceof IActivityHandler) {
                                                                        ((IActivityHandler) iWebview2.getActivity()).callBack(SDK.UNIMP_CAPSULE_BUTTON_CLICK, bundle3);
                                                                    }
                                                                    break;
                                                                case IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
                                                                    io.dcloud.common.core.ui.b bVarH5 = ((io.dcloud.common.core.ui.a) this.a.get(((IApp) obj).obtainAppId())).h();
                                                                    if (bVarH5 != null && (bVarH5 instanceof io.dcloud.common.core.ui.c)) {
                                                                        bVarH5 = ((io.dcloud.common.core.ui.c) bVarH5).u();
                                                                    }
                                                                    String string4 = (bVarH5 == null || bVarH5.obtainFrameOptions().mDebugRefresh == null) ? null : bVarH5.obtainFrameOptions().mDebugRefresh.toString();
                                                                    if (string4 != null || bVarH5 == null || bVarH5.obtainFrameOptions().mUniPageUrl == null) {
                                                                        return string4;
                                                                    }
                                                                    JSONObject jSONObject2 = bVarH5.obtainFrameOptions().mUniPageUrl;
                                                                    JSONObject jSONObject3 = new JSONObject();
                                                                    jSONObject3.put("arguments", jSONObject2.toString());
                                                                    return jSONObject3.toString();
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        obj2 = null;
                        Object[] objArr14 = (Object[]) obj;
                        Object obj8 = objArr14[0];
                        a((IApp) obj8, b((IApp) obj8).l, (JSONObject) objArr14[1]);
                    }
                    return obj2;
                } catch (Throwable th2) {
                    th = th2;
                    str = str3;
                }
            } catch (Throwable th3) {
                th = th3;
                str = null;
            }
        } catch (Throwable th4) {
            th = th4;
            str3 = null;
        }
        Logger.w("WindowMgr.processEvent", th);
        return str;
    }

    public synchronized void a(m mVar) {
        if (this.b.contains(mVar)) {
            return;
        }
        this.b.add(mVar);
    }

    void a(ViewGroup viewGroup, IApp iApp, IWebview iWebview, ViewGroup.LayoutParams layoutParams) {
        a(iApp, iApp.obtainAppId());
        io.dcloud.common.core.ui.a aVar = (io.dcloud.common.core.ui.a) this.a.get(iApp.obtainAppId());
        io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) iWebview.obtainFrameView();
        bVar.k = aVar;
        View viewObtainMainView = bVar.obtainMainView();
        if (viewObtainMainView.getParent() != null) {
            ((ViewGroup) viewObtainMainView.getParent()).removeView(viewObtainMainView);
        }
        viewGroup.addView(viewObtainMainView, layoutParams);
    }

    public void c(io.dcloud.common.core.ui.b bVar) {
        bVar.a(io.dcloud.common.core.ui.b.A);
        bVar.p();
        bVar.k.b(bVar);
        if (bVar.e()) {
            processEvent(IMgr.MgrType.WindowMgr, 28, bVar.b);
            bVar.b = null;
        }
        bVar.makeViewOptions_animate();
        bVar.l();
        bVar.k();
    }

    synchronized boolean a(IApp iApp, String str) {
        Logger.e("streamsdk", "come into createAppRootView pAppid===" + str);
        io.dcloud.common.core.ui.a aVar = (io.dcloud.common.core.ui.a) this.a.get(str);
        if (aVar != null && aVar.h) {
            return false;
        }
        if (aVar != null && !aVar.h) {
            this.a.remove(str);
        }
        Logger.e("streamsdk", "come into createAppRootView and new le rootview  pAppid===" + str);
        Logger.d(Logger.MAIN_TAG, "create " + str + " AppRootView");
        io.dcloud.common.core.ui.a aVar2 = new io.dcloud.common.core.ui.a(iApp.getActivity(), iApp, null);
        aVar2.onAppStart(iApp);
        aVar2.obtainFrameOptions().setParentViewRect(iApp.getAppViewRect());
        aVar2.obtainFrameOptions().updateViewData(JSONUtil.createJSONObject("{}"), iApp.getInt(0), iApp.getInt(1));
        this.a.put(str, aVar2);
        iApp.obtainAppId();
        return true;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v5 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v7 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: io.dcloud.common.core.ui.c
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: io.dcloud.common.core.ui.c
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: io.dcloud.common.core.ui.c
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: io.dcloud.common.core.ui.c
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: io.dcloud.common.core.ui.c
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v10 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v10 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v10 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v10 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v11 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v11 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v11 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v11 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v22 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v22 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v22 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v24 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v25 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v26 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v27 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v5 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v5 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v5 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v8 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v8 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v8 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v9 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v9 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v9 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v9 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v1 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v1 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v1 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v1 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v7 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v8 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: java.lang.Object[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: java.lang.Object[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: java.lang.Object[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: java.lang.Object[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.trySplitConstInsns(FixTypesVisitor.java:582)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r25v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v0 'this'  ??, new type: io.dcloud.common.core.ui.l
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v5 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
        */
    private void a(int r26, java.lang.Object r27) {
        /*
            Method dump skipped, instruction units count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.core.ui.l.a(int, java.lang.Object):void");
    }

    void b(IApp iApp, IWebview iWebview) {
        if (iApp.obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData) != null || (BaseInfo.isWap2AppAppid(iApp.obtainAppId()) && !TextUtils.isEmpty(iApp.getOriginalDirectPage()))) {
            processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{iWebview, "UI", "n_createSecondWebview", null});
        }
    }

    private io.dcloud.common.core.ui.b b(IApp iApp) {
        io.dcloud.common.core.ui.a aVar = (io.dcloud.common.core.ui.a) iApp.obtainWebAppRootView();
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    private io.dcloud.common.core.ui.a b() {
        return (io.dcloud.common.core.ui.a) this.a.get(String.valueOf(processEvent(IMgr.MgrType.AppMgr, 11, null)));
    }

    public void b(io.dcloud.common.core.ui.b bVar) {
        IApp iAppObtainApp = bVar.obtainApp();
        iAppObtainApp.setMaskLayer(false);
        iAppObtainApp.obtainWebAppRootView().obtainMainView().invalidate();
    }

    private io.dcloud.common.core.ui.c b(IApp iApp, io.dcloud.common.core.ui.a aVar) {
        JSONObject jSONObjectObtainThridInfo = iApp.obtainThridInfo(IApp.ConfigProperty.ThridInfo.Tabbar);
        if (jSONObjectObtainThridInfo == null) {
            return null;
        }
        io.dcloud.common.core.ui.c cVar = new io.dcloud.common.core.ui.c(iApp.getActivity(), this, iApp, aVar, 8, jSONObjectObtainThridInfo);
        int i2 = iApp.getInt(0);
        int i3 = iApp.getInt(1);
        ViewOptions viewOptionsObtainFrameOptions = cVar.obtainFrameOptions();
        ViewOptions viewOptionsObtainFrameOptions2 = aVar.obtainFrameOptions();
        if (viewOptionsObtainFrameOptions2.height > i3) {
            viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions2.mJsonViewOption, i2, i3);
        }
        viewOptionsObtainFrameOptions.setParentViewRect(viewOptionsObtainFrameOptions2);
        viewOptionsObtainFrameOptions.popGesture = iApp.getPopGesture();
        View viewObtainMainView = cVar.obtainMainView();
        viewOptionsObtainFrameOptions.width = -1;
        viewOptionsObtainFrameOptions.height = -1;
        AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(viewObtainMainView, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, -1, -1);
        aVar.addFrameItem(cVar, new ViewGroup.LayoutParams(-1, -1));
        cVar.k.e(cVar);
        processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{cVar.obtainWebView(), "UI", "", null});
        return cVar;
    }

    public void a(IApp iApp, io.dcloud.common.core.ui.a aVar, String str, String str2, JSONObject jSONObject) {
        String strOptString = (jSONObject == null || !jSONObject.has(AbsoluteConst.XML_PATH)) ? null : jSONObject.optString(AbsoluteConst.XML_PATH);
        if (PdrUtil.isEmpty(strOptString)) {
            return;
        }
        iApp.setConfigProperty(AbsoluteConst.UNIAPP_WEEX_JS_SERVICE, String.valueOf(true));
        int i2 = iApp.getInt(0);
        int i3 = iApp.getInt(1);
        io.dcloud.common.core.ui.b bVar = new io.dcloud.common.core.ui.b(iApp.getActivity(), this, iApp, aVar, 7, null);
        io.dcloud.common.core.ui.d dVar = new io.dcloud.common.core.ui.d(iApp.getActivity(), bVar, strOptString, str, jSONObject, true);
        dVar.initWebviewUUID(str);
        ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
        ViewOptions viewOptionsObtainFrameOptions2 = aVar.obtainFrameOptions();
        if (viewOptionsObtainFrameOptions2.height > i3) {
            viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions2.mJsonViewOption, i2, i3);
        }
        viewOptionsObtainFrameOptions.setParentViewRect(viewOptionsObtainFrameOptions2);
        viewOptionsObtainFrameOptions.popGesture = iApp.getPopGesture();
        View viewObtainMainView = bVar.obtainMainView();
        int i4 = viewOptionsObtainFrameOptions.width;
        if (i4 == i2) {
            i4 = -1;
        }
        int i5 = viewOptionsObtainFrameOptions.height;
        if (i5 == i3) {
            i5 = -1;
        }
        AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(viewObtainMainView, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, i4, i5);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        bVar.addFrameItem(bVar.obtainWebviewParent(), layoutParams);
        bVar.setVisible(false, false);
        aVar.addFrameItem(bVar, layoutParams);
        dVar.setFrameId(str2);
        bVar.k.e(bVar);
        processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{dVar, "UI", "", null});
    }

    private void a(IApp iApp, ViewGroup viewGroup) {
        if (!BaseInfo.isUniNViewBackgroud() || BaseInfo.isWeexUniJs(iApp)) {
            return;
        }
        Object objProcessEvent = processEvent(IMgr.MgrType.AppMgr, 24, null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("template", String.valueOf(objProcessEvent));
            jSONObject.put(AbsoluteConst.XML_PATH, iApp.obtainAppDataPath() + "nvue_service.js");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iApp, "weex,io.dcloud.feature.weex.WeexFeature", "createServiceUniNView", new Object[]{iApp, jSONObject, viewGroup, "__uniapp__nvue"}});
    }

    private boolean a(IApp iApp) {
        return (TextUtils.isEmpty(iApp.getOriginalDirectPage()) || iApp.obtainWebAppIntent().hasExtra(IntentConst.DIRECT_PAGE)) ? false : true;
    }

    private void a(int i2, io.dcloud.common.core.ui.a aVar, String str, io.dcloud.common.core.ui.b bVar, IApp iApp, String str2, IWebview iWebview) {
        boolean z;
        IWebviewStateListener iWebviewStateListenerObtainLaunchPageStateListener = iApp.obtainLaunchPageStateListener();
        if (iWebviewStateListenerObtainLaunchPageStateListener != null) {
            boolean z2 = PdrUtil.parseBoolean(String.valueOf(iWebviewStateListenerObtainLaunchPageStateListener.onCallBack(-1, iWebview)), true, false);
            iWebview.addStateListener(iApp.obtainLaunchPageStateListener());
            z = z2;
        } else {
            z = true;
        }
        int i3 = Integer.parseInt(iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_DELAY));
        boolean z3 = Boolean.parseBoolean(iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_AUTOCLOSE));
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = BaseInfo.isWap2AppAppid(str) && Boolean.parseBoolean(iApp.obtainConfigProperty("w2a_autoclose"));
        Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        String strObtainConfigProperty = iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_TARGET);
        if (TextUtils.isEmpty(strObtainConfigProperty)) {
            strObtainConfigProperty = "default";
        }
        boolean z5 = z3 || z4;
        int intExtra = intentObtainWebAppIntent.getIntExtra(IntentConst.FROM_STREAM_OPEN_TIMEOUT, 6000);
        boolean booleanExtra = intentObtainWebAppIntent.getBooleanExtra(IntentConst.FROM_STREAM_OPEN_AUTOCLOSE, z5);
        int i4 = (strObtainConfigProperty.startsWith("id:") && booleanExtra) ? ADSim.INTISPLSH : intExtra;
        int i5 = z4 ? Integer.parseInt(iApp.obtainConfigProperty("w2a_delay")) : i3;
        if (BaseInfo.isWap2AppAppid(str) && PdrUtil.isNetPath(str2)) {
            this.c = AbsoluteConst.EVENTS_RENDERING;
        } else {
            this.c = AbsoluteConst.EVENTS_LOADED;
        }
        String strObtainConfigProperty2 = iApp.obtainConfigProperty("event");
        if (!TextUtils.isEmpty(strObtainConfigProperty2)) {
            this.c = strObtainConfigProperty2;
        }
        Logger.d(Logger.MAIN_TAG, "_need_auto_close_splash = " + z3 + ";_delay=" + i3 + ";appid=" + str + ";f_event=" + this.c);
        iWebview.addStateListener(new i(strObtainConfigProperty, booleanExtra, iApp, aVar, str2, iWebview, i2, bVar, i5, jCurrentTimeMillis));
        if (booleanExtra) {
            a(i4, aVar, bVar, i5);
        }
        if (!z || bVar.isChildOfFrameView) {
            return;
        }
        aVar.e(bVar);
    }

    private void a(int i2, io.dcloud.common.core.ui.a aVar, io.dcloud.common.core.ui.b bVar, int i3) {
        if (this.d != null) {
            aVar.obtainMainView().removeCallbacks(this.d);
        }
        this.d = new j(aVar, bVar, i3);
        aVar.obtainMainView().postDelayed(this.d, i2);
    }

    private void a(io.dcloud.common.core.ui.a aVar) {
        if (this.d == null || aVar == null) {
            return;
        }
        aVar.obtainMainView().removeCallbacks(this.d);
        this.d = null;
    }

    void a(IApp iApp, IWebview iWebview, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, (Object) null);
            jSONArray.put(1, (Object) null);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, (Object) null);
            jSONArray.put(2, jSONArray2);
            jSONArray.put(3, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{iWebview, "UI", "n_createHDWebview", jSONArray});
    }

    void a(IApp iApp, IWebview iWebview) {
        if (BaseInfo.isWap2AppAppid(iApp.obtainAppId()) && iApp.obtainWebAppIntent().hasExtra(IntentConst.DIRECT_PAGE)) {
            processEvent(IMgr.MgrType.FeatureMgr, 1, new Object[]{iWebview, "UI", "n_createDirectWebview", null});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IApp iApp, io.dcloud.common.core.ui.a aVar) {
        io.dcloud.common.core.ui.b bVarH;
        if (aVar == null || aVar.q || (bVarH = aVar.h()) == null) {
            return;
        }
        k kVar = new k(bVarH, aVar, iApp);
        Runnable runnable = this.e;
        if (runnable != null) {
            this.f = true;
            MessageHandler.removeCallbacks(runnable);
        }
        MessageHandler.postDelayed(kVar, 100L);
    }

    public void a(IWebview iWebview, IApp iApp, boolean z, io.dcloud.common.core.ui.a aVar, int i2, io.dcloud.common.core.ui.b bVar, int i3, int i4) {
        RunnableC0036l runnableC0036l = new RunnableC0036l(aVar, z, bVar, iWebview, iApp, i3, i4, i2);
        this.e = runnableC0036l;
        MessageHandler.postDelayed(runnableC0036l, 100L);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x023b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0245  */
    /* JADX WARN: Code duplicated, block: B:106:0x0280  */
    /* JADX WARN: Code duplicated, block: B:108:0x028e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0290  */
    /* JADX WARN: Code duplicated, block: B:113:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:115:0x02de  */
    /* JADX WARN: Code duplicated, block: B:117:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:127:0x0308  */
    /* JADX WARN: Code duplicated, block: B:129:0x031b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0321  */
    /* JADX WARN: Code duplicated, block: B:132:0x0331  */
    /* JADX WARN: Code duplicated, block: B:134:0x033d  */
    /* JADX WARN: Code duplicated, block: B:136:0x0343  */
    /* JADX WARN: Code duplicated, block: B:137:0x034b  */
    /* JADX WARN: Code duplicated, block: B:139:0x0351  */
    /* JADX WARN: Code duplicated, block: B:142:0x0361  */
    /* JADX WARN: Code duplicated, block: B:143:0x0366  */
    /* JADX WARN: Code duplicated, block: B:152:0x0382  */
    /* JADX WARN: Code duplicated, block: B:154:0x0390 A[PHI: r21 r22
  0x0390: PHI (r21v3 int) = (r21v2 int), (r21v6 int) binds: [B:133:0x033b, B:129:0x031b] A[DONT_GENERATE, DONT_INLINE]
  0x0390: PHI (r22v2 int) = (r22v1 int), (r22v5 int) binds: [B:133:0x033b, B:129:0x031b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:156:0x0395  */
    /* JADX WARN: Code duplicated, block: B:158:0x039b  */
    /* JADX WARN: Code duplicated, block: B:159:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:161:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:164:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:165:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:174:0x03de  */
    /* JADX WARN: Code duplicated, block: B:182:0x03fe A[LOOP:0: B:180:0x03f8->B:182:0x03fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x041b  */
    /* JADX WARN: Code duplicated, block: B:188:0x0422  */
    /* JADX WARN: Code duplicated, block: B:190:0x042e  */
    /* JADX WARN: Code duplicated, block: B:193:0x0435  */
    /* JADX WARN: Code duplicated, block: B:197:0x0477  */
    /* JADX WARN: Code duplicated, block: B:202:0x048c  */
    /* JADX WARN: Code duplicated, block: B:205:0x049c  */
    /* JADX WARN: Code duplicated, block: B:211:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:217:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:220:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:221:0x04df  */
    /* JADX WARN: Code duplicated, block: B:227:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    /* JADX WARN: Code duplicated, block: B:56:0x011f  */
    /* JADX WARN: Code duplicated, block: B:57:0x012e  */
    /* JADX WARN: Code duplicated, block: B:69:0x017f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0185  */
    /* JADX WARN: Code duplicated, block: B:72:0x018f  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x0215  */
    /* JADX WARN: Code duplicated, block: B:99:0x021c  */
    io.dcloud.common.core.ui.b a(int i2, IApp iApp, io.dcloud.common.core.ui.a aVar, io.dcloud.common.core.ui.b bVar, IEventCallback iEventCallback, Object[] objArr, IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        io.dcloud.common.core.ui.b bVar2;
        io.dcloud.common.core.ui.a aVar2;
        String str;
        io.dcloud.common.core.ui.b bVar3;
        l lVar;
        boolean z;
        ViewOptions viewOptionsObtainFrameOptions;
        ViewRect viewRectObtainFrameOptions;
        String strObtainAppId;
        io.dcloud.common.core.ui.b bVar4;
        int i3;
        String strOptString;
        JSONObject jSONObject;
        String str2;
        JSONObject jSONObject2;
        io.dcloud.common.core.ui.b bVar5;
        AdaWebview eVar;
        io.dcloud.common.core.ui.b bVar6;
        JSONObject jSONObject3;
        boolean z2;
        String str3;
        int i4;
        int i5;
        JSONObject jSONObjectOptJSONObject;
        String string;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectObtainThridInfo;
        int i6;
        int i7;
        String strObtainConfigProperty;
        String strObtainAppId2;
        String strObtainConfigProperty2;
        String strObtainConfigProperty3;
        boolean z3;
        boolean z4;
        int i8;
        int i9;
        int i10;
        boolean zStartsWith;
        io.dcloud.common.core.ui.a aVar3;
        Iterator<String> itKeys;
        HashMap<String, String> map;
        JSONObject jSONObjectObtainThridInfo2;
        boolean zOptBoolean;
        int i11;
        l lVar2;
        IApp iApp2 = iApp;
        TestUtil.record("createFrameView", "createFrameView");
        String strValueOf = String.valueOf(objArr[0]);
        Logger.d(Logger.LAYOUT_TAG, "WindowMgr createWindow");
        int i12 = iApp2.getInt(0);
        int i13 = iApp2.getInt(1);
        if (i2 == 2) {
            bVar2 = aVar.f;
        } else if (i2 == 4) {
            bVar2 = aVar.g;
        } else {
            bVar2 = i2 == 5 ? aVar.e : null;
        }
        if (bVar2 == null) {
            aVar2 = aVar;
            io.dcloud.common.core.ui.b bVar7 = new io.dcloud.common.core.ui.b(iApp2.getActivity(), this, iApp2, aVar2, i2, null);
            l lVar3 = this;
            if (i2 == 2) {
                iApp2 = iApp2;
                aVar2.f = bVar7;
                str = strValueOf;
            } else if (i2 == 4) {
                aVar2.g = bVar7;
                io.dcloud.common.core.ui.b bVar8 = aVar2.e;
                str = strValueOf;
                if (bVar8 != null) {
                    bVar8.lastShowTime = bVar7.lastShowTime + 1;
                }
            } else {
                str = strValueOf;
                if (i2 == 5) {
                    aVar2.e = bVar7;
                    bVar3 = bVar7;
                    z = true;
                    lVar = lVar3;
                }
                viewOptionsObtainFrameOptions = bVar3.obtainFrameOptions();
                viewOptionsObtainFrameOptions.mWebviewScale = lVar.getContext().getResources().getDisplayMetrics().density;
                viewRectObtainFrameOptions = aVar2.obtainFrameOptions();
                if (viewRectObtainFrameOptions.height > i13) {
                    viewRectObtainFrameOptions.updateViewData(viewRectObtainFrameOptions.mJsonViewOption, i12, i13);
                }
                viewOptionsObtainFrameOptions.setParentViewRect(viewRectObtainFrameOptions);
                viewOptionsObtainFrameOptions.popGesture = iApp2.getPopGesture();
                strObtainAppId = "";
                if (objArr.length > 1) {
                    jSONObject = (JSONObject) objArr[1];
                    viewOptionsObtainFrameOptions.updateViewData(jSONObject);
                    if (jSONObject == null) {
                        strOptString = "";
                    } else {
                        if (jSONObject.has(AbsoluteConst.JSON_KEY_RENDER)) {
                            bVar3.setNeedRender(PdrUtil.isEquals(jSONObject.optString(AbsoluteConst.JSON_KEY_RENDER, "onscreen"), "always"));
                        }
                        if (jSONObject.has("name")) {
                            strOptString = jSONObject.optString("name");
                        } else if (jSONObject.has("id")) {
                            strOptString = jSONObject.optString("id");
                        } else {
                            strOptString = "";
                        }
                    }
                    bVar4 = bVar3;
                    i3 = 2;
                    if (objArr.length > 2) {
                        strObtainAppId = (String) objArr[2];
                    }
                } else {
                    bVar4 = bVar3;
                    i3 = 2;
                    viewOptionsObtainFrameOptions.width = i12;
                    viewOptionsObtainFrameOptions.height = i13;
                    strOptString = "";
                    jSONObject = null;
                }
                if (i2 == i3 && TextUtils.isEmpty(strObtainAppId)) {
                    strObtainAppId = iApp2.obtainAppId();
                }
                str2 = strObtainAppId;
                if (bVar4.obtainWebView() != null) {
                    eVar = (AdaWebview) bVar4.obtainWebView();
                    bVar6 = bVar4;
                } else {
                    jSONObject2 = viewOptionsObtainFrameOptions.mUniNViewJson;
                    if (jSONObject2 == null && jSONObject2.has(AbsoluteConst.XML_PATH)) {
                        String strOptString2 = viewOptionsObtainFrameOptions.mUniNViewJson.optString(AbsoluteConst.XML_PATH);
                        if (!TextUtils.isEmpty(strOptString2) && !strOptString2.endsWith(".js") && !strOptString2.contains(".js?")) {
                            strOptString2 = strOptString2 + ".js";
                        }
                        io.dcloud.common.core.ui.d dVar = new io.dcloud.common.core.ui.d(iApp2.getActivity(), bVar4, strOptString2, str2, viewOptionsObtainFrameOptions.mUniNViewJson, false);
                        bVar6 = bVar4;
                        eVar = dVar;
                    } else {
                        bVar5 = bVar4;
                        if (iDCloudWebviewClientListener != null) {
                            eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5, iDCloudWebviewClientListener);
                        } else {
                            eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5);
                        }
                        bVar6 = bVar5;
                    }
                }
                eVar.setOriginalUrl(str);
                if (!TextUtils.isEmpty(str2)) {
                    eVar.initWebviewUUID(str2);
                }
                if (BaseInfo.isUniAppAppid(iApp2)) {
                    eVar.setIWebViewFocusable(false);
                }
                jSONObject3 = viewOptionsObtainFrameOptions.mPullToRefresh;
                if (jSONObject3 != null) {
                    eVar.setWebViewEvent(AbsoluteConst.PULL_DOWN_REFRESH, jSONObject3);
                }
                Logger.e("createWindow before _url=" + str);
                if (iApp2.manifestBeParsed() && ((i2 != 2 || !lVar.a(iApp2)) && i2 != 5)) {
                    Logger.e("createWindow not manifestBeParsed");
                    return bVar6;
                }
                Logger.e("createWindow after _url=" + str);
                if (bVar6.getFrameType() == 2) {
                    viewOptionsObtainFrameOptions.isStatusbar = Boolean.valueOf(iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)).booleanValue();
                    viewOptionsObtainFrameOptions.mStatusbarColor = iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR);
                } else if (bVar6.getFrameType() == 4) {
                    viewOptionsObtainFrameOptions.isStatusbar = Boolean.valueOf(iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)).booleanValue();
                    viewOptionsObtainFrameOptions.mStatusbarColor = iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR);
                }
                lVar.a(bVar6, objArr);
                if (!viewOptionsObtainFrameOptions.mUseHardwave) {
                    eVar.obtainWindowView().setLayerType(1, null);
                } else {
                    eVar.obtainWindowView().setLayerType(0, null);
                }
                eVar.setWebViewCacheMode(viewOptionsObtainFrameOptions.mCacheMode);
                eVar.init();
                bVar6.addFrameViewListener(iEventCallback);
                bVar6.setFrameOptions_Birth(ViewOptions.createViewOptionsData(viewOptionsObtainFrameOptions, aVar.obtainFrameOptions()));
                AdaWebViewParent adaWebViewParentObtainWebviewParent = bVar6.obtainWebviewParent();
                eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE));
                eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_SHAREABLE, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_SHAREABLE));
                if (jSONObject != null) {
                    zOptBoolean = jSONObject.optBoolean("visible", true);
                    View viewObtainMainView = bVar6.obtainMainView();
                    if (zOptBoolean) {
                        i11 = 0;
                    } else {
                        i11 = 8;
                    }
                    viewObtainMainView.setVisibility(i11);
                }
                eVar.setWebviewProperty("injection", JSONUtil.getString(jSONObject, "injection"));
                eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN));
                z2 = z;
                str3 = strOptString;
                if (bVar6.getFrameType() == 2) {
                    viewOptionsObtainFrameOptions.setTitleNView(bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.TitleNViewJsonData), eVar);
                    jSONObjectObtainThridInfo2 = bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData);
                    if (jSONObjectObtainThridInfo2 != null) {
                        viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObjectObtainThridInfo2);
                        if (jSONObjectObtainThridInfo2.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                            jSONObjectOptJSONObject2 = jSONObjectObtainThridInfo2.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                        } else {
                            jSONObjectOptJSONObject2 = null;
                        }
                        string = JSONUtil.getString(jSONObjectObtainThridInfo2, "bounce");
                        if ("vertical".equalsIgnoreCase(string) && !Constants.Value.HORIZONTAL.equalsIgnoreCase(string) && !"all".equalsIgnoreCase(string)) {
                            viewOptionsObtainFrameOptions.mBounce = false;
                        } else {
                            viewOptionsObtainFrameOptions.mBounce = true;
                        }
                        viewOptionsObtainFrameOptions.historyBack = jSONObjectObtainThridInfo2.optString(AbsoluteConst.JSON_KEY_HISTORYBACK, viewOptionsObtainFrameOptions.historyBack);
                        i5 = i12;
                        i4 = i13;
                    } else {
                        i5 = i12;
                        i4 = i13;
                        string = "none";
                        jSONObjectOptJSONObject2 = null;
                    }
                } else {
                    i4 = i13;
                    i5 = i12;
                    if (bVar6.getFrameType() == 4) {
                        jSONObjectObtainThridInfo = bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
                        if (jSONObjectObtainThridInfo != null) {
                            if (jSONObjectObtainThridInfo.has("titleNView")) {
                                viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "titleNView"), eVar);
                            } else if (jSONObjectObtainThridInfo.has("navigationbar")) {
                                viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "navigationbar"), eVar);
                            }
                            viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObjectObtainThridInfo);
                            if (jSONObjectObtainThridInfo.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                                jSONObjectOptJSONObject2 = jSONObjectObtainThridInfo.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                            } else {
                                jSONObjectOptJSONObject2 = null;
                            }
                            string = JSONUtil.getString(jSONObjectObtainThridInfo, "bounce");
                            if ("vertical".equalsIgnoreCase(string) && !Constants.Value.HORIZONTAL.equalsIgnoreCase(string) && !"all".equalsIgnoreCase(string)) {
                                viewOptionsObtainFrameOptions.mBounce = false;
                            } else {
                                viewOptionsObtainFrameOptions.mBounce = true;
                            }
                            viewOptionsObtainFrameOptions.historyBack = jSONObjectObtainThridInfo.optString(AbsoluteConst.JSON_KEY_HISTORYBACK, viewOptionsObtainFrameOptions.historyBack);
                        } else {
                            string = "none";
                            jSONObjectOptJSONObject2 = null;
                        }
                    } else {
                        if (jSONObject.has("titleNView")) {
                            viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObject, "titleNView"), eVar);
                        } else if (jSONObject.has("navigationbar")) {
                            viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObject, "navigationbar"), eVar);
                        }
                        if (jSONObject.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                            jSONObjectOptJSONObject = jSONObject.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                        } else {
                            jSONObjectOptJSONObject = null;
                        }
                        viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObject);
                        string = JSONUtil.getString(jSONObject, "bounce");
                        if ("vertical".equalsIgnoreCase(string) && !Constants.Value.HORIZONTAL.equalsIgnoreCase(string) && !"all".equalsIgnoreCase(string)) {
                            viewOptionsObtainFrameOptions.mBounce = false;
                        } else {
                            viewOptionsObtainFrameOptions.mBounce = true;
                        }
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject;
                    }
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                    itKeys = jSONObjectOptJSONObject2.keys();
                    map = new HashMap<>(jSONObjectOptJSONObject2.length());
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject2.optString(next));
                    }
                    eVar.setLoadURLHeads(str, map);
                }
                eVar.setWebviewProperty("bounce", string);
                bVar6.a(viewOptionsObtainFrameOptions, bVar6, adaWebViewParentObtainWebviewParent, eVar);
                if (viewOptionsObtainFrameOptions.hasBackground()) {
                    lVar.a(bVar6, false);
                } else {
                    View viewObtainMainView2 = bVar6.obtainMainView();
                    i6 = viewOptionsObtainFrameOptions.width;
                    if (i6 == i5) {
                        i6 = -1;
                    }
                    i7 = viewOptionsObtainFrameOptions.height;
                    if (i7 == i4) {
                        i7 = -1;
                    }
                    AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(viewObtainMainView2, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, i6, i7);
                    bVar6.addFrameItem(bVar6.obtainWebviewParent(), new ViewGroup.LayoutParams(-1, -1));
                }
                lVar.a(bVar6, iApp);
                lVar.a(bVar6, bVar);
                SubNViewsUtil.initFrameSubNViews(bVar6);
                Logger.d("winmgr", "createWindow end !");
                TestUtil.print("createFrameView", "createFrameView耗时：");
                strObtainConfigProperty = iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_TARGET);
                if (lVar.a(i2, str3, strObtainConfigProperty, z2)) {
                    strObtainAppId2 = iApp.obtainAppId();
                    if (!BaseInfo.isWap2AppAppid(strObtainAppId2) && PdrUtil.isNetPath(str)) {
                        lVar.c = AbsoluteConst.EVENTS_RENDERING;
                    } else {
                        lVar.c = AbsoluteConst.EVENTS_LOADED;
                    }
                    strObtainConfigProperty2 = iApp.obtainConfigProperty("event");
                    if (!TextUtils.isEmpty(strObtainConfigProperty2)) {
                        lVar.c = strObtainConfigProperty2;
                    }
                    strObtainConfigProperty3 = iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_AUTOCLOSE);
                    if (BaseInfo.isWap2AppAppid(strObtainAppId2) || !Boolean.parseBoolean(iApp.obtainConfigProperty("w2a_autoclose"))) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!Boolean.parseBoolean(strObtainConfigProperty3) || z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i8 = Integer.parseInt(iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_DELAY));
                    i9 = Integer.parseInt(iApp.obtainConfigProperty("w2a_delay"));
                    if (z3) {
                        i10 = i9;
                    } else {
                        i10 = i8;
                    }
                    zStartsWith = strObtainConfigProperty.startsWith("id:");
                    if (zStartsWith || strObtainConfigProperty.equals("id:*")) {
                        aVar3 = aVar;
                    } else {
                        aVar3 = aVar;
                        bVar6.addFrameViewListener(lVar.new a(bVar6, iApp, aVar3));
                    }
                    AdaWebview adaWebview = eVar;
                    adaWebview.addStateListener(lVar.new b(iApp, bVar6, z4, zStartsWith, str, adaWebview, aVar3, i10));
                }
                return bVar6;
            }
            bVar3 = bVar7;
            lVar2 = lVar3;
        } else {
            l lVar4 = this;
            aVar2 = aVar;
            str = strValueOf;
            if (i2 == 2 && lVar4.a(iApp2)) {
                return bVar2;
            }
            bVar3 = bVar2;
            lVar2 = lVar4;
        }
        z = false;
        lVar = lVar2;
        viewOptionsObtainFrameOptions = bVar3.obtainFrameOptions();
        viewOptionsObtainFrameOptions.mWebviewScale = lVar.getContext().getResources().getDisplayMetrics().density;
        viewRectObtainFrameOptions = aVar2.obtainFrameOptions();
        if (viewRectObtainFrameOptions.height > i13) {
            viewRectObtainFrameOptions.updateViewData(viewRectObtainFrameOptions.mJsonViewOption, i12, i13);
        }
        viewOptionsObtainFrameOptions.setParentViewRect(viewRectObtainFrameOptions);
        viewOptionsObtainFrameOptions.popGesture = iApp2.getPopGesture();
        strObtainAppId = "";
        if (objArr.length > 1) {
            jSONObject = (JSONObject) objArr[1];
            viewOptionsObtainFrameOptions.updateViewData(jSONObject);
            if (jSONObject == null) {
                strOptString = "";
            } else {
                if (jSONObject.has(AbsoluteConst.JSON_KEY_RENDER)) {
                    bVar3.setNeedRender(PdrUtil.isEquals(jSONObject.optString(AbsoluteConst.JSON_KEY_RENDER, "onscreen"), "always"));
                }
                if (jSONObject.has("name")) {
                    strOptString = jSONObject.optString("name");
                } else if (jSONObject.has("id")) {
                    strOptString = jSONObject.optString("id");
                } else {
                    strOptString = "";
                }
            }
            bVar4 = bVar3;
            i3 = 2;
            if (objArr.length > 2) {
                strObtainAppId = (String) objArr[2];
            }
        } else {
            bVar4 = bVar3;
            i3 = 2;
            viewOptionsObtainFrameOptions.width = i12;
            viewOptionsObtainFrameOptions.height = i13;
            strOptString = "";
            jSONObject = null;
        }
        if (i2 == i3) {
            strObtainAppId = iApp2.obtainAppId();
        }
        str2 = strObtainAppId;
        if (bVar4.obtainWebView() != null) {
            eVar = (AdaWebview) bVar4.obtainWebView();
            bVar6 = bVar4;
        } else {
            jSONObject2 = viewOptionsObtainFrameOptions.mUniNViewJson;
            if (jSONObject2 == null) {
                bVar5 = bVar4;
                if (iDCloudWebviewClientListener != null) {
                    eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5, iDCloudWebviewClientListener);
                } else {
                    eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5);
                }
                bVar6 = bVar5;
            } else {
                bVar5 = bVar4;
                if (iDCloudWebviewClientListener != null) {
                    eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5, iDCloudWebviewClientListener);
                } else {
                    eVar = new io.dcloud.common.core.ui.e(iApp2.getActivity(), lVar, bVar5);
                }
                bVar6 = bVar5;
            }
        }
        eVar.setOriginalUrl(str);
        if (!TextUtils.isEmpty(str2)) {
            eVar.initWebviewUUID(str2);
        }
        if (BaseInfo.isUniAppAppid(iApp2)) {
            eVar.setIWebViewFocusable(false);
        }
        jSONObject3 = viewOptionsObtainFrameOptions.mPullToRefresh;
        if (jSONObject3 != null) {
            eVar.setWebViewEvent(AbsoluteConst.PULL_DOWN_REFRESH, jSONObject3);
        }
        Logger.e("createWindow before _url=" + str);
        if (iApp2.manifestBeParsed()) {
        }
        Logger.e("createWindow after _url=" + str);
        if (bVar6.getFrameType() == 2) {
            viewOptionsObtainFrameOptions.isStatusbar = Boolean.valueOf(iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)).booleanValue();
            viewOptionsObtainFrameOptions.mStatusbarColor = iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR);
        } else if (bVar6.getFrameType() == 4) {
            viewOptionsObtainFrameOptions.isStatusbar = Boolean.valueOf(iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)).booleanValue();
            viewOptionsObtainFrameOptions.mStatusbarColor = iApp2.obtainConfigProperty(AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR);
        }
        lVar.a(bVar6, objArr);
        if (!viewOptionsObtainFrameOptions.mUseHardwave) {
            eVar.obtainWindowView().setLayerType(1, null);
        } else {
            eVar.obtainWindowView().setLayerType(0, null);
        }
        eVar.setWebViewCacheMode(viewOptionsObtainFrameOptions.mCacheMode);
        eVar.init();
        bVar6.addFrameViewListener(iEventCallback);
        bVar6.setFrameOptions_Birth(ViewOptions.createViewOptionsData(viewOptionsObtainFrameOptions, aVar.obtainFrameOptions()));
        AdaWebViewParent adaWebViewParentObtainWebviewParent2 = bVar6.obtainWebviewParent();
        eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE));
        eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_SHAREABLE, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_SHAREABLE));
        if (jSONObject != null) {
            zOptBoolean = jSONObject.optBoolean("visible", true);
            View viewObtainMainView3 = bVar6.obtainMainView();
            if (zOptBoolean) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            viewObtainMainView3.setVisibility(i11);
        }
        eVar.setWebviewProperty("injection", JSONUtil.getString(jSONObject, "injection"));
        eVar.setWebviewProperty(AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN, JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN));
        z2 = z;
        str3 = strOptString;
        if (bVar6.getFrameType() == 2) {
            viewOptionsObtainFrameOptions.setTitleNView(bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.TitleNViewJsonData), eVar);
            jSONObjectObtainThridInfo2 = bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData);
            if (jSONObjectObtainThridInfo2 != null) {
                viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObjectObtainThridInfo2);
                if (jSONObjectObtainThridInfo2.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                    jSONObjectOptJSONObject2 = jSONObjectObtainThridInfo2.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                } else {
                    jSONObjectOptJSONObject2 = null;
                }
                string = JSONUtil.getString(jSONObjectObtainThridInfo2, "bounce");
                if ("vertical".equalsIgnoreCase(string)) {
                    viewOptionsObtainFrameOptions.mBounce = true;
                } else {
                    viewOptionsObtainFrameOptions.mBounce = true;
                }
                viewOptionsObtainFrameOptions.historyBack = jSONObjectObtainThridInfo2.optString(AbsoluteConst.JSON_KEY_HISTORYBACK, viewOptionsObtainFrameOptions.historyBack);
                i5 = i12;
                i4 = i13;
            } else {
                i5 = i12;
                i4 = i13;
                string = "none";
                jSONObjectOptJSONObject2 = null;
            }
        } else {
            i4 = i13;
            i5 = i12;
            if (bVar6.getFrameType() == 4) {
                jSONObjectObtainThridInfo = bVar6.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
                if (jSONObjectObtainThridInfo != null) {
                    if (jSONObjectObtainThridInfo.has("titleNView")) {
                        viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "titleNView"), eVar);
                    } else if (jSONObjectObtainThridInfo.has("navigationbar")) {
                        viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "navigationbar"), eVar);
                    }
                    viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObjectObtainThridInfo);
                    if (jSONObjectObtainThridInfo.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                        jSONObjectOptJSONObject2 = jSONObjectObtainThridInfo.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                    } else {
                        jSONObjectOptJSONObject2 = null;
                    }
                    string = JSONUtil.getString(jSONObjectObtainThridInfo, "bounce");
                    if ("vertical".equalsIgnoreCase(string)) {
                        viewOptionsObtainFrameOptions.mBounce = true;
                    } else {
                        viewOptionsObtainFrameOptions.mBounce = true;
                    }
                    viewOptionsObtainFrameOptions.historyBack = jSONObjectObtainThridInfo.optString(AbsoluteConst.JSON_KEY_HISTORYBACK, viewOptionsObtainFrameOptions.historyBack);
                } else {
                    string = "none";
                    jSONObjectOptJSONObject2 = null;
                }
            } else {
                if (jSONObject.has("titleNView")) {
                    viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObject, "titleNView"), eVar);
                } else if (jSONObject.has("navigationbar")) {
                    viewOptionsObtainFrameOptions.setTitleNView(JSONUtil.getJSONObject(jSONObject, "navigationbar"), eVar);
                }
                if (jSONObject.has(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS)) {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject(IApp.ConfigProperty.CONFIG_ADDITIONAL_HTTPHEADERS);
                } else {
                    jSONObjectOptJSONObject = null;
                }
                viewOptionsObtainFrameOptions.setBackButtonAutoControl(jSONObject);
                string = JSONUtil.getString(jSONObject, "bounce");
                if ("vertical".equalsIgnoreCase(string)) {
                    viewOptionsObtainFrameOptions.mBounce = true;
                } else {
                    viewOptionsObtainFrameOptions.mBounce = true;
                }
                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject;
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            itKeys = jSONObjectOptJSONObject2.keys();
            map = new HashMap<>(jSONObjectOptJSONObject2.length());
            while (itKeys.hasNext()) {
                String next2 = itKeys.next();
                map.put(next2, jSONObjectOptJSONObject2.optString(next2));
            }
            eVar.setLoadURLHeads(str, map);
        }
        eVar.setWebviewProperty("bounce", string);
        bVar6.a(viewOptionsObtainFrameOptions, bVar6, adaWebViewParentObtainWebviewParent2, eVar);
        if (viewOptionsObtainFrameOptions.hasBackground()) {
            lVar.a(bVar6, false);
        } else {
            View viewObtainMainView4 = bVar6.obtainMainView();
            i6 = viewOptionsObtainFrameOptions.width;
            if (i6 == i5) {
                i6 = -1;
            }
            i7 = viewOptionsObtainFrameOptions.height;
            if (i7 == i4) {
                i7 = -1;
            }
            AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(viewObtainMainView4, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, i6, i7);
            bVar6.addFrameItem(bVar6.obtainWebviewParent(), new ViewGroup.LayoutParams(-1, -1));
        }
        lVar.a(bVar6, iApp);
        lVar.a(bVar6, bVar);
        SubNViewsUtil.initFrameSubNViews(bVar6);
        Logger.d("winmgr", "createWindow end !");
        TestUtil.print("createFrameView", "createFrameView耗时：");
        strObtainConfigProperty = iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_TARGET);
        if (lVar.a(i2, str3, strObtainConfigProperty, z2)) {
            strObtainAppId2 = iApp.obtainAppId();
            if (!BaseInfo.isWap2AppAppid(strObtainAppId2)) {
                lVar.c = AbsoluteConst.EVENTS_LOADED;
            } else {
                lVar.c = AbsoluteConst.EVENTS_LOADED;
            }
            strObtainConfigProperty2 = iApp.obtainConfigProperty("event");
            if (!TextUtils.isEmpty(strObtainConfigProperty2)) {
                lVar.c = strObtainConfigProperty2;
            }
            strObtainConfigProperty3 = iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_AUTOCLOSE);
            if (BaseInfo.isWap2AppAppid(strObtainAppId2)) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (Boolean.parseBoolean(strObtainConfigProperty3)) {
                z4 = true;
            } else {
                z4 = true;
            }
            i8 = Integer.parseInt(iApp.obtainConfigProperty(IApp.ConfigProperty.CONFIG_DELAY));
            i9 = Integer.parseInt(iApp.obtainConfigProperty("w2a_delay"));
            if (z3) {
                i10 = i9;
            } else {
                i10 = i8;
            }
            zStartsWith = strObtainConfigProperty.startsWith("id:");
            if (zStartsWith) {
                aVar3 = aVar;
            } else {
                aVar3 = aVar;
            }
            AdaWebview adaWebview2 = eVar;
            adaWebview2.addStateListener(lVar.new b(iApp, bVar6, z4, zStartsWith, str, adaWebview2, aVar3, i10));
        }
        return bVar6;
    }

    private void a(io.dcloud.common.core.ui.b bVar, boolean z) {
        int i2 = bVar.obtainApp().getInt(0);
        int i3 = bVar.obtainApp().getInt(1);
        AdaWebViewParent adaWebViewParentObtainWebviewParent = bVar.obtainWebviewParent();
        ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
        ViewOptions viewOptionsObtainFrameOptions2 = adaWebViewParentObtainWebviewParent.obtainFrameOptions();
        io.dcloud.common.core.ui.a aVar = (io.dcloud.common.core.ui.a) bVar.obtainWebAppRootView();
        ViewOptions viewOptionsObtainFrameOptions3 = aVar.obtainFrameOptions();
        viewOptionsObtainFrameOptions2.setParentViewRect(viewOptionsObtainFrameOptions3);
        viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions);
        viewOptionsObtainFrameOptions.left = 0;
        viewOptionsObtainFrameOptions.top = 0;
        viewOptionsObtainFrameOptions.anim_top = 0;
        viewOptionsObtainFrameOptions.anim_left = 0;
        ViewHelper.setY(bVar.obtainMainView(), 0.0f);
        ViewHelper.setX(bVar.obtainMainView(), 0.0f);
        viewOptionsObtainFrameOptions.width = i2;
        viewOptionsObtainFrameOptions.height = i3;
        int i4 = viewOptionsObtainFrameOptions2.left;
        int i5 = viewOptionsObtainFrameOptions2.top;
        int i6 = viewOptionsObtainFrameOptions2.width;
        int i7 = viewOptionsObtainFrameOptions2.height;
        adaWebViewParentObtainWebviewParent.setFrameOptions_Birth(ViewOptions.createViewOptionsData(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions3, viewOptionsObtainFrameOptions2));
        viewOptionsObtainFrameOptions2.allowUpdate = false;
        viewOptionsObtainFrameOptions2.maskColor = viewOptionsObtainFrameOptions.maskColor;
        adaWebViewParentObtainWebviewParent.mNeedOrientationUpdate = true;
        viewOptionsObtainFrameOptions.checkValueIsPercentage("left", -1, -1, false, true);
        viewOptionsObtainFrameOptions.checkValueIsPercentage("top", -1, -1, false, true);
        viewOptionsObtainFrameOptions.checkValueIsPercentage("width", -1, -1, false, true);
        viewOptionsObtainFrameOptions.checkValueIsPercentage("height", -1, -1, false, true);
        if (a(i4, i5, i6, i7, aVar.obtainFrameOptions().width, aVar.obtainFrameOptions().height)) {
            Logger.d("winmgr", "createWindow use LayoutParams.MATCH_PARENT !");
            bVar.addFrameItem(bVar.obtainWebviewParent(), new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        bVar.addFrameItem(bVar.obtainWebviewParent(), AdaFrameItem.LayoutParamsUtil.createLayoutParams(i4, i5, i6, i7));
        if (z) {
            bVar.a(i2, i3);
            return;
        }
        int i8 = i4 + i6;
        if (i8 > i2 || i5 + i7 > i3) {
            StringBuilder sb = new StringBuilder("updateLayoutParams allW=");
            sb.append(i8);
            sb.append(";pdrW=");
            sb.append(i2);
            sb.append(";pdrH=");
            sb.append(i3);
            sb.append(";allH=");
            int i9 = i5 + i7;
            sb.append(i9);
            Logger.d("winmgr", sb.toString());
            bVar.a(Math.max(i8, i2), Math.max(i9, i3));
        }
    }

    private boolean a(int i2, String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith("id:") && !PdrUtil.isEmpty(str)) {
            return str2.substring(3).equals(str);
        }
        if (i2 == 4) {
            return !TextUtils.isEmpty(str2) && str2.equals("second");
        }
        return i2 == 5 && z;
    }

    private void a(AdaFrameItem adaFrameItem, IApp iApp) {
        int statusHeight;
        int iStringToColor;
        ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
        if (viewOptionsObtainFrameOptions.isStatusbar) {
            if ((PdrUtil.isEmpty(viewOptionsObtainFrameOptions.mStatusbarColor) || iApp.obtainStatusBarMgr().isImmersive) && -1 != (statusHeight = DeviceInfo.getStatusHeight(adaFrameItem.getContext()))) {
                int iHashCode = adaFrameItem.hashCode();
                int statusBarDefaultColor = iApp.obtainStatusBarMgr().getStatusBarDefaultColor();
                if (!PdrUtil.isEmpty(viewOptionsObtainFrameOptions.mStatusbarColor)) {
                    try {
                        iStringToColor = Color.parseColor(viewOptionsObtainFrameOptions.mStatusbarColor);
                    } catch (Exception unused) {
                        iStringToColor = PdrUtil.stringToColor(viewOptionsObtainFrameOptions.mStatusbarColor);
                    }
                    if (PdrUtil.checkStatusbarColor(iStringToColor)) {
                        statusBarDefaultColor = iStringToColor;
                    }
                }
                ViewGroup viewGroup = (ViewGroup) adaFrameItem.obtainMainView();
                if (viewGroup.findViewById(iHashCode) == null && viewOptionsObtainFrameOptions.height != 0) {
                    StatusBarView statusBarView = new StatusBarView(adaFrameItem.getContext());
                    statusBarView.setStatusBarHeight(statusHeight);
                    statusBarView.setBackgroundColor(statusBarDefaultColor);
                    statusBarView.setId(iHashCode);
                    ViewGroup viewGroup2 = (ViewGroup) ((AdaFrameView) adaFrameItem).obtainWebviewParent().obtainMainView();
                    if (viewOptionsObtainFrameOptions.isStatusbarDodifyHeight) {
                        viewGroup.getLayoutParams().height = viewOptionsObtainFrameOptions.height + DeviceInfo.sStatusBarHeight;
                        viewGroup.addView(statusBarView);
                    } else {
                        viewGroup.addView(statusBarView);
                    }
                    JSONObject jSONObject = viewOptionsObtainFrameOptions.titleNView;
                    if (jSONObject == null || !TitleNViewUtil.isTitleTypeForDef(jSONObject)) {
                        viewGroup2.post(new c(adaFrameItem));
                    }
                }
            }
        }
    }

    private io.dcloud.common.core.ui.b a() {
        io.dcloud.common.core.ui.a aVarB = b();
        if (aVarB != null) {
            return aVarB.h();
        }
        return null;
    }

    public void a(io.dcloud.common.core.ui.b bVar) {
        bVar.a(io.dcloud.common.core.ui.b.B);
        bVar.p();
        bVar.k.b(bVar);
        if (bVar.e()) {
            processEvent(IMgr.MgrType.WindowMgr, 28, bVar.b);
            bVar.b = null;
        }
        bVar.r();
        bVar.i();
        bVar.i = false;
        bVar.h = false;
        bVar.inStack = false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006e A[PHI: r1
  0x006e: PHI (r1v17 java.lang.String) = 
  (r1v16 java.lang.String)
  (r1v16 java.lang.String)
  (r1v16 java.lang.String)
  (r1v18 java.lang.String)
  (r1v18 java.lang.String)
 binds: [B:19:0x008a, B:21:0x0090, B:26:0x00a1, B:8:0x0054, B:13:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    private void a(io.dcloud.common.core.ui.b bVar, Object[] objArr) {
        JSONObject jSONObject;
        String strValueOf;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean z = bVar.obtainApp().obtainStatusBarMgr().isImmersive;
        if (bVar.getFrameType() == 2) {
            jSONObject = bVar.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.TitleNViewJsonData);
            strValueOf = String.valueOf(bVar.obtainWebView().obtainWindowView().hashCode());
        } else if (bVar.getFrameType() == 4) {
            strValueOf = String.valueOf(bVar.obtainWebView().obtainWindowView().hashCode());
            JSONObject jSONObjectObtainThridInfo = bVar.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
            if (jSONObjectObtainThridInfo == null) {
                jSONObject = null;
            } else if (jSONObjectObtainThridInfo.has("titleNView")) {
                jSONObject = JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "titleNView");
            } else if (jSONObjectObtainThridInfo.has("navigationbar")) {
                jSONObject = JSONUtil.getJSONObject(jSONObjectObtainThridInfo, "navigationbar");
            } else {
                jSONObject = null;
            }
        } else if (bVar.getFrameType() == 5) {
            strValueOf = String.valueOf(bVar.obtainWebView().obtainWindowView().hashCode());
            if (objArr.length <= 1 || (jSONObject3 = (JSONObject) objArr[1]) == null) {
                jSONObject = null;
            } else if (jSONObject3.has("titleNView")) {
                jSONObject = JSONUtil.getJSONObject(jSONObject3, "titleNView");
            } else if (jSONObject3.has("navigationbar")) {
                jSONObject = JSONUtil.getJSONObject(jSONObject3, "navigationbar");
            } else {
                jSONObject = null;
            }
        } else if (objArr.length > 1) {
            JSONObject jSONObject4 = (JSONObject) objArr[1];
            if (jSONObject4 == null) {
                jSONObject2 = null;
            } else if (jSONObject4.has("titleNView")) {
                jSONObject2 = JSONUtil.getJSONObject(jSONObject4, "titleNView");
            } else if (jSONObject4.has("navigationbar")) {
                jSONObject2 = JSONUtil.getJSONObject(jSONObject4, "navigationbar");
            } else {
                jSONObject2 = null;
            }
            if (objArr.length > 2) {
                JSONObject jSONObject5 = jSONObject2;
                strValueOf = (String) objArr[2];
                jSONObject = jSONObject5;
            } else {
                jSONObject = jSONObject2;
                strValueOf = null;
            }
        } else {
            jSONObject = null;
            strValueOf = null;
        }
        a(bVar, z, jSONObject, strValueOf);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x007b  */
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
    private void a(io.dcloud.common.core.ui.b bVar, boolean z, JSONObject jSONObject, String str) {
        String strChangeColorAlpha;
        String str2;
        String str3;
        String str4;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ((!jSONObject.has("backgroundcolor") || TextUtils.isEmpty(jSONObject.optString("backgroundcolor"))) && (!jSONObject.has("backgroundColor") || TextUtils.isEmpty(jSONObject.optString("backgroundColor")))) {
                jSONObject.remove("backgroundcolor");
                jSONObject.put("backgroundColor", "#F8F8F8");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String strOptString = jSONObject.optString("backgroundColor");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("backgroundcolor");
        }
        String str5 = strOptString;
        boolean zEquals = "transparent".equals(jSONObject.optString("type"));
        String str6 = AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE;
        if (zEquals) {
            if (TextUtils.isEmpty(str5)) {
                strChangeColorAlpha = str5;
            } else {
                try {
                    strChangeColorAlpha = TitleNViewUtil.changeColorAlpha(str5, 0.0f);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    strChangeColorAlpha = str5;
                }
            }
        } else if ("float".equals(jSONObject.optString("type"))) {
            strChangeColorAlpha = str5;
        } else {
            strChangeColorAlpha = TitleNViewUtil.changeColorAlpha(str5, 1.0f);
            str6 = "dock";
        }
        int statusHeight = DeviceInfo.getStatusHeight(bVar.getContext());
        int scale = (!z || bVar.obtainFrameOptions().isStatusbar || -1 == statusHeight) ? 0 : (int) (statusHeight / bVar.obtainWebView().getScale());
        JSONObject jSONObjectObtainThridInfo = bVar.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
        if (2 == bVar.getFrameType() && jSONObjectObtainThridInfo != null && "parent".equals(jSONObjectObtainThridInfo.optString("mode"))) {
            scale = 0;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.has("tags") ? jSONObject.optJSONArray("tags") : null;
        l lVar = bVar.mWindowMgr;
        IMgr.MgrType mgrType = IMgr.MgrType.FeatureMgr;
        IWebview iWebviewObtainWebView = bVar.obtainWebView();
        IWebview iWebviewObtainWebView2 = bVar.obtainWebView();
        StringBuilder sb = new StringBuilder("{'top':'0px','left':'0px','height':'44px','width':'100%',");
        String str7 = "";
        if (scale > 0) {
            str2 = "'statusbar':{'background':'" + strChangeColorAlpha + "','backgroundnoalpha':'" + str5 + "'},";
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (jSONObject.has("blurEffect")) {
            str3 = "'blurEffect':'" + jSONObject.optString("blurEffect") + "',";
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append("'backgroundColor':'");
        sb.append(strChangeColorAlpha);
        sb.append("','position':'");
        sb.append(str6);
        sb.append("','dock':'top'");
        if (jSONObject.has(Constants.Name.BACKGROUND_IMAGE)) {
            str4 = ",'backgroundImage':'" + jSONObject.optString(Constants.Name.BACKGROUND_IMAGE) + "'";
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (jSONObject.has("redDotColor")) {
            str7 = ",'redDotColor':'" + jSONObject.optString("redDotColor") + "'";
        }
        sb.append(str7);
        sb.append(Operators.BLOCK_END_STR);
        lVar.processEvent(mgrType, 10, new Object[]{iWebviewObtainWebView, "nativeobj", "View", new Object[]{bVar, iWebviewObtainWebView2, str, str, JSONUtil.createJSONObject(sb.toString()), jSONArrayOptJSONArray, AbsoluteConst.NATIVE_TITLE_N_VIEW}});
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
    private void a(io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
        String str;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        String string;
        if (bVar.obtainFrameOptions().titleNView != null) {
            JSONObject jSONObject = bVar.obtainFrameOptions().titleNView;
            String titleNViewId = TitleNViewUtil.getTitleNViewId(bVar);
            String str9 = Operators.SPACE_STR;
            if (jSONObject != null && !TextUtils.isEmpty(titleNViewId)) {
                try {
                    if ((!jSONObject.has("titletext") || jSONObject.getString("titletext") == null || Constants.Name.UNDEFINED.equals(jSONObject.getString("titletext"))) && (!jSONObject.has("titleText") || jSONObject.getString("titleText") == null || Constants.Name.UNDEFINED.equals(jSONObject.getString("titleText")))) {
                        jSONObject.remove("titletext");
                    }
                    if ((!jSONObject.has("titlecolor") || TextUtils.isEmpty(jSONObject.optString("titlecolor"))) && (!jSONObject.has("titleColor") || TextUtils.isEmpty(jSONObject.optString("titleColor")))) {
                        jSONObject.remove("titlecolor");
                        jSONObject.put("titleColor", "#000000");
                    }
                    if ((!jSONObject.has("titlesize") || TextUtils.isEmpty(jSONObject.optString("titlesize"))) && (!jSONObject.has("titleSize") || TextUtils.isEmpty(jSONObject.optString("titleSize")))) {
                        jSONObject.remove("titlesize");
                        jSONObject.put("titleSize", "17px");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    if (jSONObject.has("titleText")) {
                        Object obj2 = jSONObject.get("titleText");
                        if (obj2 != null && (obj2 instanceof String)) {
                            string = obj2.toString();
                            str9 = string;
                        }
                    } else if (jSONObject.has("titletext") && (obj = jSONObject.get("titletext")) != null && (obj instanceof String)) {
                        string = obj.toString();
                        str9 = string;
                    }
                } catch (Exception unused) {
                }
                String strOptString5 = jSONObject.optString("titleColor");
                if (TextUtils.isEmpty(strOptString5)) {
                    strOptString5 = jSONObject.optString("titlecolor");
                }
                String strChangeColorAlpha = strOptString5;
                String strOptString6 = jSONObject.optString("titleSize");
                if (TextUtils.isEmpty(strOptString6)) {
                    strOptString6 = jSONObject.optString("titlesize");
                }
                String str10 = strOptString6;
                if ("transparent".equals(jSONObject.optString("type")) && !TextUtils.isEmpty(strChangeColorAlpha)) {
                    try {
                        strChangeColorAlpha = TitleNViewUtil.changeColorAlpha(strChangeColorAlpha, 0.0f);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                String strOptString7 = jSONObject.optString("titleOverflow");
                String strOptString8 = jSONObject.optString("titleAlign");
                String strOptString9 = jSONObject.optString("titleIcon");
                String strOptString10 = jSONObject.optString("titleIconRadius");
                String strOptString11 = jSONObject.optString("subtitleText");
                strOptString = jSONObject.optString("subtitleColor");
                strOptString2 = jSONObject.optString("subtitleSize");
                strOptString3 = jSONObject.optString("subtitleOverflow");
                strOptString4 = jSONObject.optString("titleIconWidth");
                str8 = strChangeColorAlpha;
                str3 = str9;
                str7 = strOptString11;
                str = strOptString8;
                str2 = strOptString9;
                str4 = str10;
                str6 = strOptString10;
                str5 = strOptString7;
            } else {
                str = "";
                strOptString = str;
                strOptString2 = strOptString;
                strOptString3 = strOptString2;
                strOptString4 = strOptString3;
                str2 = strOptString4;
                str3 = Operators.SPACE_STR;
                str4 = null;
                str5 = null;
                str6 = str2;
                str7 = str6;
                str8 = null;
            }
            l lVar = bVar.mWindowMgr;
            IMgr.MgrType mgrType = IMgr.MgrType.FeatureMgr;
            String str11 = str3;
            String str12 = str8;
            lVar.processEvent(mgrType, 1, new Object[]{bVar.obtainWebView(), "nativeobj", AbsoluteConst.EVENTS_WEBVIEW_SHOW, JSONUtil.createJSONArray("['" + titleNViewId + "','" + titleNViewId + "']")});
            bVar.mWindowMgr.processEvent(mgrType, 10, new Object[]{bVar.obtainWebView(), "nativeobj", "addNativeView", new Object[]{bVar, titleNViewId}});
            Object titleNView = TitleNViewUtil.getTitleNView(bVar.mWindowMgr, bVar.obtainWebView(), bVar, titleNViewId);
            if (titleNView instanceof ITitleNView) {
                ITitleNView iTitleNView = (ITitleNView) titleNView;
                TitleNViewUtil.drawTitle(bVar, iTitleNView, str11, str12, str4, str5, str, str2, str6, str7, strOptString, strOptString2, strOptString3, strOptString4);
                TitleNViewUtil.setTitleNViewPadding(iTitleNView, bVar.obtainWebView(), bVar.obtainFrameOptions().titleNView);
                TitleNViewUtil.setButtons(iTitleNView, bVar.obtainFrameOptions().titleNView, bVar2 != null ? bVar2.obtainWebView() : null);
                TitleNViewUtil.setBackButton(iTitleNView, bVar.obtainFrameOptions().titleNView, bVar.getFrameType());
                if (jSONObject.optJSONObject("splitLine") != null) {
                    TitleNViewUtil.setSplitLine(iTitleNView, bVar.obtainWebView(), null, jSONObject.optJSONObject("splitLine"), true, jSONObject.optString("type"));
                }
                TitleNViewUtil.setProgress(iTitleNView, bVar.obtainFrameOptions().titleNView);
                TitleNViewUtil.setHomeButton(iTitleNView, bVar.obtainFrameOptions().titleNView, bVar.getFrameType());
                TitleNViewUtil.setCapsuleButtonStyle(iTitleNView, bVar.obtainFrameOptions().titleNView);
                if (jSONObject.optJSONObject("searchInput") != null) {
                    TitleNViewUtil.setSearchInput(iTitleNView, bVar.obtainFrameOptions().titleNView, bVar2 != null ? bVar2.obtainWebView() : null);
                }
                if (!PdrUtil.isEmpty(jSONObject.optString("backgroundRepeat"))) {
                    iTitleNView.setBackgroundRepeat(jSONObject.optString("backgroundRepeat"));
                }
                if (jSONObject.optJSONObject("shadow") != null) {
                    TitleNViewUtil.setShadow(iTitleNView, bVar.obtainFrameOptions().titleNView);
                }
            }
        }
    }
}
