package com.alibaba.android.bindingx.plugin.weex;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.core.IEventHandler;
import com.alibaba.android.bindingx.core.LogProxy;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.BindingXConstants;
import com.alibaba.android.bindingx.core.internal.Utils;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.animation.TransformParser;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.view.WXTextView;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.WXViewUtils;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.feature.uniapp.dom.AbsCSSShorthand;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WXBindingXModule extends WXSDKEngine.DestroyableModule {
    private BindingXCore mBindingXCore;
    private PlatformManager mPlatformManager;

    public WXBindingXModule() {
    }

    WXBindingXModule(BindingXCore bindingXCore) {
        this.mBindingXCore = bindingXCore;
    }

    private void prepareInternal() {
        if (this.mPlatformManager == null) {
            this.mPlatformManager = createPlatformManager(this.mWXSDKInstance);
        }
        if (this.mBindingXCore == null) {
            BindingXCore bindingXCore = new BindingXCore(this.mPlatformManager);
            this.mBindingXCore = bindingXCore;
            bindingXCore.registerEventHandler("scroll", new BindingXCore.ObjectCreator<IEventHandler, Context, PlatformManager>() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.1
                @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
                public IEventHandler createWith(Context context, PlatformManager platformManager, Object... objArr) {
                    return new BindingXScrollHandler(context, platformManager, objArr);
                }
            });
            this.mBindingXCore.registerEventHandler("pan", new BindingXCore.ObjectCreator<IEventHandler, Context, PlatformManager>() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.2
                @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
                public IEventHandler createWith(Context context, PlatformManager platformManager, Object... objArr) {
                    return new BindingXGestureHandler(context, platformManager, objArr);
                }
            });
        }
    }

    @JSMethod(uiThread = false)
    public void prepare(Map<String, Object> map) {
        prepareInternal();
    }

    @JSMethod(uiThread = false)
    public Map<String, String> bind(Map<String, Object> map, final JSCallback jSCallback) {
        prepareInternal();
        BindingXCore bindingXCore = this.mBindingXCore;
        Context context = this.mWXSDKInstance == null ? null : this.mWXSDKInstance.getContext();
        String instanceId = this.mWXSDKInstance != null ? this.mWXSDKInstance.getInstanceId() : null;
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        String strDoBind = bindingXCore.doBind(context, instanceId, map, new BindingXCore.JavaScriptCallback() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.3
            @Override // com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback
            public void callback(Object obj) {
                if (jSCallback != null) {
                    Log.e("触发去往前端的回调", WXBridgeManager.METHOD_CALLBACK);
                    jSCallback.invokeAndKeepAlive(obj);
                }
            }
        }, new Object[0]);
        HashMap map2 = new HashMap(2);
        map2.put(BindingXConstants.KEY_TOKEN, strDoBind);
        return map2;
    }

    @JSMethod(uiThread = false)
    public void bindAsync(Map<String, Object> map, JSCallback jSCallback, JSCallback jSCallback2) {
        Map<String, String> mapBind = bind(map, jSCallback);
        if (jSCallback2 == null || mapBind == null) {
            return;
        }
        jSCallback2.invoke(mapBind);
    }

    @JSMethod(uiThread = false)
    public void unbind(Map<String, Object> map) {
        BindingXCore bindingXCore = this.mBindingXCore;
        if (bindingXCore != null) {
            bindingXCore.doUnbind(map);
        }
    }

    @JSMethod(uiThread = false)
    public void unbindAll() {
        BindingXCore bindingXCore = this.mBindingXCore;
        if (bindingXCore != null) {
            bindingXCore.doRelease();
        }
    }

    @JSMethod(uiThread = false)
    public List<String> supportFeatures() {
        return Arrays.asList("pan", "orientation", BindingXEventType.TYPE_TIMING, "scroll", "experimentalGestureFeatures");
    }

    @JSMethod(uiThread = false)
    public void getComputedStyleAsync(String str, JSCallback jSCallback) {
        Map<String, Object> computedStyle = getComputedStyle(str);
        if (jSCallback != null) {
            jSCallback.invoke(computedStyle);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x01e6  */
    @JSMethod(uiThread = false)
    public Map<String, Object> getComputedStyle(String str) {
        char c;
        double d;
        double d2;
        double d3;
        double d4;
        char c2;
        Layout textLayout;
        CharSequence text;
        ForegroundColorSpan[] foregroundColorSpanArr;
        int color;
        prepareInternal();
        PlatformManager.IDeviceResolutionTranslator resolutionTranslator = this.mPlatformManager.getResolutionTranslator();
        WXComponent wXComponentFindComponentByRef = WXModuleUtils.findComponentByRef(this.mWXSDKInstance.getInstanceId(), str);
        if (wXComponentFindComponentByRef == null) {
            return Collections.EMPTY_MAP;
        }
        View hostView = wXComponentFindComponentByRef.getHostView();
        if (hostView == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        map.put("width", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getLayoutWidth(), new Object[0])));
        map.put("height", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getLayoutHeight(), new Object[0])));
        map.put(AbsoluteConst.JSON_KEY_PADDING_LEFT, Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(AbsCSSShorthand.EDGE.LEFT), new Object[0])));
        map.put("padding-top", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(AbsCSSShorthand.EDGE.TOP), new Object[0])));
        map.put(AbsoluteConst.JSON_KEY_PADDING_RIGHT, Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(AbsCSSShorthand.EDGE.RIGHT), new Object[0])));
        map.put("padding-bottom", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(AbsCSSShorthand.EDGE.BOTTOM), new Object[0])));
        map.put("margin-left", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(AbsCSSShorthand.EDGE.LEFT), new Object[0])));
        map.put("margin-top", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(AbsCSSShorthand.EDGE.TOP), new Object[0])));
        map.put("margin-right", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(AbsCSSShorthand.EDGE.RIGHT), new Object[0])));
        map.put("margin-bottom", Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(AbsCSSShorthand.EDGE.BOTTOM), new Object[0])));
        map.put("translateX", Double.valueOf(resolutionTranslator.nativeToWeb(hostView.getTranslationX(), new Object[0])));
        map.put("translateY", Double.valueOf(resolutionTranslator.nativeToWeb(hostView.getTranslationY(), new Object[0])));
        map.put("rotateX", Float.valueOf(Utils.normalizeRotation(hostView.getRotationX())));
        map.put("rotateY", Float.valueOf(Utils.normalizeRotation(hostView.getRotationY())));
        map.put(TransformParser.WX_ROTATE_Z, Float.valueOf(Utils.normalizeRotation(hostView.getRotation())));
        map.put("scaleX", Float.valueOf(hostView.getScaleX()));
        map.put("scaleY", Float.valueOf(hostView.getScaleY()));
        map.put("opacity", Float.valueOf(hostView.getAlpha()));
        Drawable background = hostView.getBackground();
        if (background == null || !(background instanceof BorderDrawable)) {
            c = 2;
            d = 0.0d;
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        } else {
            float[] borderRadius = ((BorderDrawable) background).getBorderRadius(new RectF(0.0f, 0.0f, hostView.getWidth(), hostView.getHeight()));
            if (borderRadius.length == 8) {
                double d5 = borderRadius[0];
                double d6 = borderRadius[2];
                double d7 = borderRadius[6];
                c = 2;
                d3 = borderRadius[4];
                d = d6;
                d4 = d5;
                d2 = d7;
            } else {
                c = 2;
                d = 0.0d;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
            }
        }
        map.put("border-top-left-radius", Double.valueOf(resolutionTranslator.nativeToWeb(d4, new Object[0])));
        map.put("border-top-right-radius", Double.valueOf(resolutionTranslator.nativeToWeb(d, new Object[0])));
        map.put("border-bottom-left-radius", Double.valueOf(resolutionTranslator.nativeToWeb(d2, new Object[0])));
        map.put("border-bottom-right-radius", Double.valueOf(resolutionTranslator.nativeToWeb(d3, new Object[0])));
        if (hostView.getBackground() != null) {
            if (hostView.getBackground() instanceof ColorDrawable) {
                color = ((ColorDrawable) hostView.getBackground()).getColor();
            } else {
                color = hostView.getBackground() instanceof BorderDrawable ? ((BorderDrawable) hostView.getBackground()).getColor() : -16777216;
            }
            double dAlpha = ((double) Color.alpha(color)) / 255.0d;
            int iRed = Color.red(color);
            int iGreen = Color.green(color);
            int iBlue = Color.blue(color);
            c2 = 3;
            Locale locale = Locale.getDefault();
            Integer numValueOf = Integer.valueOf(iRed);
            Integer numValueOf2 = Integer.valueOf(iGreen);
            Integer numValueOf3 = Integer.valueOf(iBlue);
            Double dValueOf = Double.valueOf(dAlpha);
            Object[] objArr = new Object[4];
            objArr[0] = numValueOf;
            objArr[1] = numValueOf2;
            objArr[c] = numValueOf3;
            objArr[3] = dValueOf;
            map.put("background-color", String.format(locale, "rgba(%d,%d,%d,%f)", objArr));
        } else {
            c2 = 3;
        }
        if ((wXComponentFindComponentByRef instanceof WXText) && (hostView instanceof WXTextView) && (textLayout = ((WXTextView) hostView).getTextLayout()) != null && (text = textLayout.getText()) != null && (text instanceof SpannableString) && (foregroundColorSpanArr = (ForegroundColorSpan[]) ((SpannableString) text).getSpans(0, text.length(), ForegroundColorSpan.class)) != null && foregroundColorSpanArr.length == 1) {
            int foregroundColor = foregroundColorSpanArr[0].getForegroundColor();
            double dAlpha2 = ((double) Color.alpha(foregroundColor)) / 255.0d;
            int iRed2 = Color.red(foregroundColor);
            int iGreen2 = Color.green(foregroundColor);
            int iBlue2 = Color.blue(foregroundColor);
            Locale locale2 = Locale.getDefault();
            Integer numValueOf4 = Integer.valueOf(iRed2);
            Integer numValueOf5 = Integer.valueOf(iGreen2);
            Integer numValueOf6 = Integer.valueOf(iBlue2);
            Double dValueOf2 = Double.valueOf(dAlpha2);
            Object[] objArr2 = new Object[4];
            objArr2[0] = numValueOf4;
            objArr2[1] = numValueOf5;
            objArr2[c] = numValueOf6;
            objArr2[c2] = dValueOf2;
            map.put("color", String.format(locale2, "rgba(%d,%d,%d,%f)", objArr2));
        }
        return map;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.4
            @Override // java.lang.Runnable
            public void run() {
                if (WXBindingXModule.this.mBindingXCore != null) {
                    WXBindingXModule.this.mBindingXCore.doRelease();
                    WXBindingXModule.this.mBindingXCore = null;
                }
                WXViewUpdateService.clearCallbacks();
            }
        }, null);
    }

    static PlatformManager createPlatformManager(WXSDKInstance wXSDKInstance) {
        final int instanceViewPortWidth = wXSDKInstance == null ? 750 : wXSDKInstance.getInstanceViewPortWidth();
        return new PlatformManager.Builder().withViewFinder(new PlatformManager.IViewFinder() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.7
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewFinder
            public View findViewBy(String str, Object... objArr) {
                if (objArr.length <= 0) {
                    return null;
                }
                Object obj = objArr[0];
                if (obj instanceof String) {
                    return WXModuleUtils.findViewByRef((String) obj, str);
                }
                return null;
            }
        }).withViewUpdater(new PlatformManager.IViewUpdater() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.6
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater
            public void synchronouslyUpdateViewOnUIThread(View view, String str, Object obj, PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, Map<String, Object> map, Object... objArr) {
                if (objArr == null || objArr.length < 2) {
                    return;
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        String str2 = (String) obj2;
                        String str3 = (String) obj3;
                        WXComponent wXComponentFindComponentByRef = WXModuleUtils.findComponentByRef(str3, str2);
                        if (wXComponentFindComponentByRef == null) {
                            LogProxy.e("unexpected error. component not found [ref:" + str2 + ",instanceId:" + str3 + Operators.ARRAY_END_STR);
                            return;
                        }
                        WXViewUpdateService.findUpdater(str).update(wXComponentFindComponentByRef, view, obj, iDeviceResolutionTranslator, map);
                    }
                }
            }
        }).withDeviceResolutionTranslator(new PlatformManager.IDeviceResolutionTranslator() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.5
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
            public double webToNative(double d, Object... objArr) {
                return WXViewUtils.getRealPxByWidth((float) d, instanceViewPortWidth);
            }

            @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
            public double nativeToWeb(double d, Object... objArr) {
                return WXViewUtils.getWebPxByWidth((float) d, instanceViewPortWidth);
            }
        }).build();
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.8
            @Override // java.lang.Runnable
            public void run() {
                if (WXBindingXModule.this.mBindingXCore != null) {
                    WXBindingXModule.this.mBindingXCore.onActivityPause();
                }
            }
        }, null);
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.9
            @Override // java.lang.Runnable
            public void run() {
                if (WXBindingXModule.this.mBindingXCore != null) {
                    WXBindingXModule.this.mBindingXCore.onActivityResume();
                }
            }
        }, null);
    }
}
