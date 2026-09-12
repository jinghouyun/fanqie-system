package io.dcloud.feature.nativeObj;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.INativeBitmap;
import io.dcloud.common.DHInterface.INativeView;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.adapter.ui.DHImageView;
import io.dcloud.common.adapter.ui.FrameSwitchView;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.TitleNViewUtil;
import io.dcloud.feature.internal.splash.ISplash;
import io.dcloud.feature.nativeObj.richtext.RichTextLayout;
import io.dcloud.feature.uniapp.adapter.AbsURIAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class NativeBitmapMgr {
    private HashMap<String, INativeBitmap> mSnaps = new HashMap<>();
    private HashMap<String, String> mIds = new HashMap<>();
    protected LinkedHashMap<String, NativeView> mNativeViews = new LinkedHashMap<>();
    public final String SUCCESS_INFO = "{path:'file://%s', w:%d, h:%d, size:%d}";

    /* JADX INFO: renamed from: io.dcloud.feature.nativeObj.NativeBitmapMgr$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action = iArr;
            try {
                iArr[Action.View.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.setStyle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.addEventListener.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.interceptTouchEvent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.setTouchEventRect.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.getViewById.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.evalWeexJS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.drawRichText.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.drawBitmap.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.drawText.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.drawInput.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.getInputValueById.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.getInputFocusById.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.setInputFocusById.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.show.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.hide.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_close.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_animate.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_reset.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_restore.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_drawRect.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.isVisible.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.Bitmap.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.getItems.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.getBitmapById.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.clear.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.bitmapRecycle.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.load.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.loadBase64Data.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.save.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.toBase64Data.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.startAnimation.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.clearAnimation.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_clearRect.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.view_draw.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.setImages.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.addImages.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[Action.currentImageIndex.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    protected enum Action {
        Bitmap,
        getItems,
        getBitmapById,
        clear,
        load,
        loadBase64Data,
        save,
        toBase64Data,
        View,
        startAnimation,
        clearAnimation,
        getViewById,
        drawBitmap,
        drawText,
        evalWeexJS,
        drawRichText,
        show,
        hide,
        setImages,
        addImages,
        view_animate,
        view_reset,
        view_restore,
        view_drawRect,
        isVisible,
        addEventListener,
        interceptTouchEvent,
        setTouchEventRect,
        bitmapRecycle,
        setStyle,
        view_clearRect,
        view_draw,
        view_close,
        currentImageIndex,
        drawInput,
        getInputValueById,
        getInputFocusById,
        setInputFocusById
    }

    private void createBitmap(IApp iApp, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "" + System.currentTimeMillis();
        }
        if (this.mSnaps.containsKey(str)) {
            return;
        }
        this.mSnaps.put(str, new NativeBitmap(iApp, str2, str, str3));
        this.mIds.put(str2, str);
    }

    private NativeView getNativeView(String str, String str2) {
        NativeView nativeView = this.mNativeViews.get(str2);
        if (nativeView == null && !TextUtils.isEmpty(str)) {
            for (NativeView nativeView2 : this.mNativeViews.values()) {
                if (TextUtils.equals(nativeView2.mID, str)) {
                    return nativeView2;
                }
            }
        }
        return nativeView;
    }

    private void load(final IWebview iWebview, NativeBitmap nativeBitmap, String str, final String str2) {
        nativeBitmap.load(iWebview, iWebview.obtainFrameView().obtainMainView().getContext(), str, TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.1
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                Deprecated_JSUtil.execCallback(iWebview, str2, null, JSUtil.OK, false, false);
                return null;
            }
        }, TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.2
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                String string = obj == null ? iWebview.getContext().getString(R.string.dcloud_native_obj_load_failed) : obj.toString();
                Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"" + string + "\"}", JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    private void loadBase64Data(final IWebview iWebview, NativeBitmap nativeBitmap, String str, final String str2) {
        nativeBitmap.loadBase64Data(str, TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.3
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                Deprecated_JSUtil.execCallback(iWebview, str2, null, JSUtil.OK, false, false);
                return null;
            }
        }, TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.4
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"" + iWebview.getContext().getString(R.string.dcloud_native_obj_load_failed) + "\"}", JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    private void save(final IWebview iWebview, NativeBitmap nativeBitmap, String str, JSONObject jSONObject, final String str2) {
        nativeBitmap.save(iWebview.obtainFrameView().obtainApp(), str, new NativeBitmapSaveOptions(jSONObject.toString()), iWebview.getScale(), TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.5
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                String str3;
                if (obj == null || !(obj instanceof NativeBitmapSaveOptions)) {
                    str3 = null;
                } else {
                    NativeBitmapSaveOptions nativeBitmapSaveOptions = (NativeBitmapSaveOptions) obj;
                    str3 = StringUtil.format("{path:'file://%s', w:%d, h:%d, size:%d}", nativeBitmapSaveOptions.path, Integer.valueOf(nativeBitmapSaveOptions.width), Integer.valueOf(nativeBitmapSaveOptions.height), Long.valueOf(nativeBitmapSaveOptions.size));
                }
                Deprecated_JSUtil.execCallback(iWebview, str2, str3, JSUtil.OK, true, false);
                return null;
            }
        }, TextUtils.isEmpty(str2) ? null : new ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.6
            @Override // io.dcloud.common.DHInterface.ICallBack
            public Object onCallBack(int i, Object obj) {
                Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"\"+webview.getContext().getString(R.string.dcloud_native_obj_load_failed)+\"\"}", JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    public void destroy() {
        try {
            Iterator<INativeBitmap> it = this.mSnaps.values().iterator();
            while (it.hasNext()) {
                try {
                    it.next().clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mIds.clear();
            this.mSnaps.clear();
            for (NativeView nativeView : this.mNativeViews.values()) {
                if (nativeView != null) {
                    nativeView.clearNativeViewData();
                }
            }
            this.mNativeViews.clear();
            NativeTypefaceFactory.clearCache();
            System.gc();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroyNativeView(NativeView nativeView) {
        NativeView nativeView2 = this.mNativeViews.get(nativeView.mUUID);
        nativeView.clearNativeViewData();
        if (nativeView2 == nativeView) {
            this.mNativeViews.remove(nativeView.mUUID);
        } else {
            this.mNativeViews.remove(nativeView.mID);
        }
    }

    public Object doForFeature(String str, Object obj) {
        NativeView nativeView;
        if ("addNativeView".equals(str)) {
            Object[] objArr = (Object[]) obj;
            IFrameView iFrameView = (IFrameView) objArr[0];
            String str2 = (String) objArr[1];
            NativeView nativeView2 = getNativeView(str2, str2);
            Logger.d("adadad", "addNativeView outter" + nativeView2);
            if (nativeView2 != null) {
                Logger.d("adadad", "addNativeView inner" + iFrameView);
                nativeView2.attachToViewGroup(iFrameView);
                return null;
            }
        } else if ("removeNativeView".equals(str)) {
            String str3 = (String) ((Object[]) obj)[1];
            NativeView nativeView3 = getNativeView(str3, str3);
            if (nativeView3 != null) {
                nativeView3.removeFromViewGroup();
                return null;
            }
        } else if ("getNativeView".equals(str)) {
            try {
                Object[] objArr2 = (Object[]) obj;
                String str4 = (String) objArr2[1];
                return getNativeView(str4, str4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if ("makeRichText".equals(str)) {
                return RichTextLayout.makeRichText((Object[]) obj);
            }
            if ("View".equals(str)) {
                try {
                    Object[] objArr3 = (Object[]) obj;
                    IWebview iWebview = (IWebview) objArr3[1];
                    String str5 = (String) objArr3[2];
                    String str6 = (String) objArr3[3];
                    JSONObject jSONObject = (JSONObject) objArr3[4];
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    JSONObject jSONObject2 = jSONObject;
                    JSONArray jSONArray = objArr3.length > 5 ? (JSONArray) objArr3[5] : null;
                    String str7 = AbsoluteConst.NATIVE_NVIEW;
                    if (objArr3.length > 6) {
                        str7 = (String) objArr3[6];
                    }
                    if (!this.mNativeViews.containsKey(str6)) {
                        NativeView nativeImageSlider = str7.equals(AbsoluteConst.NATIVE_IMAGESLIDER) ? new NativeImageSlider(iWebview.getContext(), iWebview, str6, str5, jSONObject2) : AbsoluteConst.NATIVE_TITLE_N_VIEW.equals(str7) ? new TitleNView(iWebview.getContext(), iWebview, str6, str5, jSONObject2) : new NativeView(iWebview.getContext(), iWebview, str6, str5, jSONObject2);
                        this.mNativeViews.put(nativeImageSlider.mUUID, nativeImageSlider);
                        initViewDrawItme(iWebview, nativeImageSlider, jSONArray);
                        return nativeImageSlider;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if ("updateSubNViews".equals(str)) {
                Object[] objArr4 = (Object[]) obj;
                IWebview iWebview2 = (IWebview) objArr4[1];
                JSONArray jSONArray2 = (JSONArray) objArr4[2];
                AdaFrameView adaFrameView = (AdaFrameView) iWebview2.obtainFrameView();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        String strOptString = jSONObject3.optString("id");
                        if (!PdrUtil.isEmpty(strOptString)) {
                            ArrayList<INativeView> arrayList = adaFrameView.mChildNativeViewList;
                            int size = arrayList.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    nativeView = null;
                                    break;
                                }
                                INativeView iNativeView = arrayList.get(i2);
                                i2++;
                                INativeView iNativeView2 = iNativeView;
                                if (strOptString.equals(iNativeView2.getViewId())) {
                                    nativeView = (NativeView) iNativeView2;
                                    break;
                                }
                            }
                            if (nativeView != null) {
                                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("tags");
                                nativeView.setStyle(jSONObject3.optJSONObject("styles"), jSONArrayOptJSONArray == null);
                                initViewDrawItme(iWebview2, nativeView, jSONArrayOptJSONArray);
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:112:0x028e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r4v6, types: [io.dcloud.common.DHInterface.AbsMgr, io.dcloud.common.DHInterface.IMgr] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public String execute(IWebview iWebview, String str, String[] strArr) {
        Action actionValueOf;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int iStringToColor;
        JSONObject jSONObject3;
        JSONArray jSONArray;
        NativeView nativeView;
        IWebview iWebview2;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        NativeBitmap srcNativeBitmap;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        JSONObject jSONObject11;
        JSONObject jSONObject12;
        String str2;
        String strWrapJsVar;
        NativeBitmapMgr nativeBitmapMgr;
        String strConvert2AbsFullPath;
        String strOptString;
        Object bitmapByUuid;
        Object bitmapByUuid2;
        String strOptString2;
        String str3 = null;
        try {
            IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            if (iAppObtainApp == null) {
                return null;
            }
            iAppObtainApp.obtainAppId();
            try {
                actionValueOf = Action.valueOf(str);
            } catch (Exception unused) {
                actionValueOf = null;
            }
            ?? r12 = 3;
            boolean z = true;
            try {
                try {
                    try {
                        try {
                            switch (AnonymousClass7.$SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[actionValueOf.ordinal()]) {
                                case 1:
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    String str6 = AbsoluteConst.NATIVE_NVIEW;
                                    if (strArr.length > 4) {
                                        str6 = strArr[4];
                                    }
                                    try {
                                        jSONObject3 = new JSONObject(strArr[2]);
                                        break;
                                    } catch (JSONException unused2) {
                                        jSONObject3 = new JSONObject();
                                    }
                                    if (strArr.length > 3) {
                                        try {
                                            jSONArray = new JSONArray(strArr[3]);
                                        } catch (JSONException unused3) {
                                            jSONArray = null;
                                        }
                                        break;
                                    } else {
                                        jSONArray = null;
                                    }
                                    if (this.mNativeViews.containsKey(str5)) {
                                        return null;
                                    }
                                    if (str6.equals(AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        nativeView = new NativeImageSlider(iWebview.getContext(), iWebview, str5, str4, jSONObject3);
                                        iWebview2 = iWebview;
                                    } else {
                                        iWebview2 = iWebview;
                                        nativeView = new NativeView(iWebview.getContext(), iWebview2, str5, str4, jSONObject3);
                                    }
                                    initViewDrawItme(iWebview2, nativeView, jSONArray);
                                    this.mNativeViews.put(nativeView.mUUID, nativeView);
                                    return null;
                                case 2:
                                    String str7 = strArr[0];
                                    String str8 = strArr[1];
                                    try {
                                        jSONObject4 = new JSONObject(strArr[2]);
                                        break;
                                    } catch (JSONException unused4) {
                                        jSONObject4 = new JSONObject();
                                    }
                                    NativeView nativeView2 = getNativeView(str7, str8);
                                    if (nativeView2 == null) {
                                        return null;
                                    }
                                    nativeView2.setStyle(jSONObject4, true);
                                    return null;
                                case 3:
                                    NativeView nativeView3 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView3 == null) {
                                        return null;
                                    }
                                    nativeView3.addEventListener(strArr[2], iWebview, strArr[3]);
                                    return null;
                                case 4:
                                    NativeView nativeView4 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView4 == null) {
                                        return null;
                                    }
                                    nativeView4.interceptTouchEvent(PdrUtil.parseBoolean(strArr[2], true, false));
                                    return null;
                                case 5:
                                    NativeView nativeView5 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView5 == null) {
                                        return null;
                                    }
                                    String str9 = strArr[2];
                                    if (TextUtils.isEmpty(str9) || str9.equals("null")) {
                                        return null;
                                    }
                                    nativeView5.setTouchEventRect(str9);
                                    return null;
                                case 6:
                                    NativeView nativeView6 = getNativeView(strArr[0], strArr.length > 1 ? strArr[1] : null);
                                    if (nativeView6 != null) {
                                        return JSUtil.wrapJsVar(nativeView6.toJSON());
                                    }
                                    return null;
                                case 7:
                                    String str10 = strArr[0];
                                    String str11 = strArr[1];
                                    iWebview.obtainFrameView().obtainWindowMgr().processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{iWebview.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "evalWeexJS", new Object[]{iWebview, strArr[2], strArr[3], strArr[4]}});
                                    return null;
                                case 8:
                                    NativeView nativeView7 = getNativeView(strArr[0], strArr[1]);
                                    String str12 = strArr[2];
                                    if (nativeView7 == null || TextUtils.isEmpty(str12)) {
                                        return null;
                                    }
                                    try {
                                        jSONObject5 = new JSONObject(strArr[3]);
                                        break;
                                    } catch (JSONException unused5) {
                                        jSONObject5 = new JSONObject();
                                    }
                                    try {
                                        jSONObject6 = new JSONObject(strArr[4]);
                                        break;
                                    } catch (JSONException unused6) {
                                        jSONObject6 = new JSONObject();
                                    }
                                    nativeView7.makeRichText(iWebview, str12, jSONObject5, jSONObject6, strArr[5]);
                                    return null;
                                case 9:
                                    NativeView nativeView8 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView8 != null && (srcNativeBitmap = getSrcNativeBitmap(iWebview, iAppObtainApp, strArr[2])) != null && srcNativeBitmap.getBitmap() != null) {
                                        try {
                                            jSONObject7 = new JSONObject(strArr[3]);
                                        } catch (JSONException unused7) {
                                            jSONObject7 = new JSONObject();
                                        }
                                        try {
                                            jSONObject8 = new JSONObject(strArr[4]);
                                        } catch (JSONException unused8) {
                                            jSONObject8 = new JSONObject();
                                        }
                                        nativeView8.makeOverlay(iWebview, srcNativeBitmap, null, -1, jSONObject7, jSONObject8, null, strArr[5], WXBasicComponentType.IMG, true);
                                        break;
                                    }
                                    return null;
                                case 10:
                                    NativeView nativeView9 = getNativeView(strArr[0], strArr[1]);
                                    String str13 = strArr[2];
                                    if (nativeView9 != null && str13 != null) {
                                        try {
                                            jSONObject9 = new JSONObject(strArr[3]);
                                        } catch (JSONException unused9) {
                                            jSONObject9 = new JSONObject();
                                        }
                                        JSONObject jSONObject13 = jSONObject9;
                                        try {
                                            jSONObject10 = new JSONObject(strArr[4]);
                                        } catch (JSONException unused10) {
                                            jSONObject10 = new JSONObject();
                                        }
                                        nativeView9.makeOverlay(iWebview, null, str13, -1, null, jSONObject13, jSONObject10, strArr[5], AbsURIAdapter.FONT, !AbsoluteConst.FALSE.equals(strArr[6]));
                                        break;
                                    }
                                    return null;
                                case 11:
                                    NativeView nativeView10 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView10 != null) {
                                        try {
                                            jSONObject11 = new JSONObject(strArr[2]);
                                        } catch (JSONException unused11) {
                                            jSONObject11 = new JSONObject();
                                        }
                                        JSONObject jSONObject14 = jSONObject11;
                                        try {
                                            jSONObject12 = new JSONObject(strArr[3]);
                                        } catch (JSONException unused12) {
                                            jSONObject12 = new JSONObject();
                                        }
                                        JSONObject jSONObject15 = jSONObject12;
                                        try {
                                            str2 = strArr[4];
                                        } catch (Exception unused13) {
                                            str2 = null;
                                        }
                                        nativeView10.makeOverlay(iWebview, null, null, -1, null, jSONObject14, jSONObject15, str2, "input", true);
                                        break;
                                    }
                                    return null;
                                case 12:
                                    NativeView nativeView11 = getNativeView(strArr[0], strArr[1]);
                                    String str14 = strArr[2];
                                    if (nativeView11 != null) {
                                        strWrapJsVar = Deprecated_JSUtil.wrapJsVar(nativeView11.getInputValueById(str14), true);
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                case 13:
                                    NativeView nativeView12 = getNativeView(strArr[0], strArr[1]);
                                    String str15 = strArr[2];
                                    if (nativeView12 != null) {
                                        strWrapJsVar = Deprecated_JSUtil.wrapJsVar(String.valueOf(nativeView12.getInputFocusById(str15)), false);
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                case 14:
                                    NativeView nativeView13 = getNativeView(strArr[0], strArr[1]);
                                    String str16 = strArr[2];
                                    boolean zBooleanValue = 4 <= strArr.length ? Boolean.valueOf(strArr[3]).booleanValue() : false;
                                    if (nativeView13 != null) {
                                        nativeView13.setInputFocusById(str16, zBooleanValue);
                                    }
                                    return str3;
                                case 15:
                                    NativeView nativeView14 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView14 != null) {
                                        nativeView14.setVisibility(0);
                                        ViewGroup viewGroup = (ViewGroup) iWebview.obtainApp().obtainWebAppRootView().obtainMainView().getParent();
                                        if (nativeView14.getParent() == null) {
                                            nativeView14.mShow = true;
                                            int childCount = viewGroup.getChildCount();
                                            for (int i = 0; i < childCount; i++) {
                                                if (viewGroup.getChildAt(i) instanceof ISplash) {
                                                    childCount = i;
                                                    viewGroup.addView(nativeView14, childCount);
                                                }
                                            }
                                            viewGroup.addView(nativeView14, childCount);
                                        }
                                    }
                                    return str3;
                                case 16:
                                    NativeView nativeView15 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView15 != null) {
                                        nativeView15.setVisibility(4);
                                        ViewGroup viewGroup2 = (ViewGroup) nativeView15.getParent();
                                        if (viewGroup2 != null && (viewGroup2 instanceof DHImageView)) {
                                            DHImageView dHImageView = (DHImageView) viewGroup2;
                                            dHImageView.clear();
                                            dHImageView.setVisibility(4);
                                        }
                                    }
                                    return str3;
                                case 17:
                                    String str17 = strArr[0];
                                    String str18 = strArr[1];
                                    NativeView nativeView16 = getNativeView(str17, str18);
                                    if (nativeView16 != null) {
                                        this.mNativeViews.remove(str18);
                                        nativeView16.removeFromViewGroup();
                                    }
                                    return str3;
                                case 18:
                                    NativeView nativeView17 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView17 != null) {
                                        nativeView17.StartAnimate(iWebview, strArr[2], strArr[3]);
                                    }
                                    return str3;
                                case 19:
                                    nativeBitmapMgr = this;
                                    NativeView nativeView18 = nativeBitmapMgr.getNativeView(strArr[0], strArr[1]);
                                    if (nativeView18 != null) {
                                        nativeView18.resetNativeView();
                                    }
                                    return null;
                                case 20:
                                    nativeBitmapMgr = this;
                                    NativeView nativeView19 = nativeBitmapMgr.getNativeView(strArr[0], strArr[1]);
                                    if (nativeView19 != null) {
                                        nativeView19.clearAnimate();
                                    }
                                    return null;
                                case 21:
                                    try {
                                        NativeView nativeView20 = getNativeView(strArr[0], strArr[1]);
                                        if (nativeView20 != null) {
                                            String strOptString3 = TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
                                            if (!PdrUtil.isEmpty(strArr[2])) {
                                                try {
                                                    jSONObject = new JSONObject(strArr[2]);
                                                    try {
                                                        if (jSONObject.has("color")) {
                                                            strOptString3 = jSONObject.optString("color");
                                                        }
                                                    } catch (JSONException e) {
                                                        e = e;
                                                        e.printStackTrace();
                                                        strOptString3 = strArr[2];
                                                    }
                                                } catch (JSONException e2) {
                                                    e = e2;
                                                    jSONObject = null;
                                                }
                                                jSONObject2 = jSONObject;
                                                break;
                                            } else {
                                                jSONObject2 = null;
                                            }
                                            String str19 = strArr[3];
                                            JSONObject jSONObject16 = (TextUtils.isEmpty(str19) || str19.equals("null")) ? null : new JSONObject(str19);
                                            String str20 = strArr[4];
                                            try {
                                                iStringToColor = Color.parseColor(strOptString3);
                                                break;
                                            } catch (Exception unused14) {
                                                iStringToColor = PdrUtil.stringToColor(strOptString3);
                                            }
                                            nativeView20.makeOverlay(iWebview, null, null, iStringToColor, null, jSONObject16, jSONObject2, str20, "rect", !AbsoluteConst.FALSE.equals(strArr[5]));
                                            return null;
                                        }
                                        return str3;
                                    } catch (Exception e3) {
                                        e = e3;
                                        r12 = this;
                                        Logger.e("NativeBitmapMgr", e.toString());
                                        e.printStackTrace();
                                        return null;
                                    }
                                case 22:
                                    NativeView nativeView21 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView21 == null || nativeView21.getParent() == null) {
                                        strWrapJsVar = Deprecated_JSUtil.wrapJsVar(String.valueOf(false), false);
                                    } else {
                                        if (nativeView21.getVisibility() != 0) {
                                            z = false;
                                        }
                                        strWrapJsVar = Deprecated_JSUtil.wrapJsVar(String.valueOf(z), false);
                                    }
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 23:
                                    if (strArr.length > 2) {
                                        strConvert2AbsFullPath = strArr[2];
                                        if (!PdrUtil.isNetPath(strConvert2AbsFullPath)) {
                                            if (TextUtils.isEmpty(strConvert2AbsFullPath) || strConvert2AbsFullPath.equals("null")) {
                                                strConvert2AbsFullPath = null;
                                            } else {
                                                strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strConvert2AbsFullPath);
                                            }
                                        }
                                    } else {
                                        strConvert2AbsFullPath = null;
                                    }
                                    createBitmap(iAppObtainApp, strArr[0], strArr[1], strConvert2AbsFullPath);
                                    return str3;
                                case 24:
                                    strWrapJsVar = Deprecated_JSUtil.wrapJsVar(getItems().toString(), false);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 25:
                                    NativeBitmap nativeBitmap = (NativeBitmap) getBitmapById(strArr[0]);
                                    strWrapJsVar = Deprecated_JSUtil.wrapJsVar(nativeBitmap != null ? nativeBitmap.toJsString() : null, false);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 26:
                                    NativeBitmap nativeBitmap2 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    this.mSnaps.remove(this.mIds.get(nativeBitmap2.getId()));
                                    this.mIds.remove(nativeBitmap2.getId());
                                    nativeBitmap2.clear();
                                    return str3;
                                case 27:
                                    NativeBitmap nativeBitmap3 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    if (nativeBitmap3 != null) {
                                        nativeBitmap3.recycle();
                                    }
                                    return str3;
                                case 28:
                                    NativeBitmap nativeBitmap4 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    String str21 = strArr[1];
                                    String str22 = strArr[2];
                                    if (nativeBitmap4 != null) {
                                        load(iWebview, nativeBitmap4, str21, str22);
                                    }
                                    return str3;
                                case 29:
                                    NativeBitmap nativeBitmap5 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    String str23 = strArr[1];
                                    String str24 = strArr[2];
                                    if (nativeBitmap5 != null) {
                                        loadBase64Data(iWebview, nativeBitmap5, str23, str24);
                                    }
                                    return str3;
                                case 30:
                                    NativeBitmap nativeBitmap6 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    String str25 = strArr[1];
                                    JSONObject jSONObject17 = new JSONObject(strArr[2]);
                                    String str26 = strArr[3];
                                    String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str25);
                                    if (nativeBitmap6 != null) {
                                        save(iWebview, nativeBitmap6, strConvert2AbsFullPath2, jSONObject17, str26);
                                    }
                                    return str3;
                                case 31:
                                    NativeBitmap nativeBitmap7 = (NativeBitmap) getBitmapByUuid(strArr[0]);
                                    strWrapJsVar = Deprecated_JSUtil.wrapJsVar(nativeBitmap7 != null ? nativeBitmap7.toBase64Data() : null, true);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 32:
                                    String str27 = strArr[0];
                                    String str28 = strArr[1];
                                    String str29 = strArr.length > 2 ? strArr[2] : null;
                                    String str30 = strArr.length > 3 ? strArr[3] : null;
                                    JSONObject jSONObject18 = new JSONObject(str28);
                                    String strOptString4 = jSONObject18.optString("viewId", null);
                                    if (TextUtils.isEmpty(strOptString4)) {
                                        strOptString = jSONObject18.optString("texts", null);
                                        bitmapByUuid = getBitmapByUuid(jSONObject18.optString("uuid", null));
                                    } else if (this.mNativeViews.containsKey(strOptString4)) {
                                        bitmapByUuid = this.mNativeViews.get(strOptString4);
                                        this.mNativeViews.get(strOptString4).mShow = true;
                                        strOptString = null;
                                    } else {
                                        strOptString = null;
                                        bitmapByUuid = null;
                                    }
                                    if (TextUtils.isEmpty(str29) || str29.equals("null")) {
                                        bitmapByUuid2 = null;
                                        strOptString2 = null;
                                    } else {
                                        JSONObject jSONObject19 = new JSONObject(str29);
                                        String strOptString5 = jSONObject19.optString("viewId", null);
                                        if (TextUtils.isEmpty(strOptString5)) {
                                            strOptString2 = jSONObject19.optString("texts", null);
                                            bitmapByUuid2 = getBitmapByUuid(jSONObject19.optString("uuid", null));
                                        } else {
                                            NativeView nativeView22 = this.mNativeViews.get(strOptString5);
                                            this.mNativeViews.get(strOptString5).mShow = true;
                                            bitmapByUuid2 = nativeView22;
                                            strOptString2 = null;
                                        }
                                    }
                                    FrameSwitchView frameSwitchView = FrameSwitchView.getInstance(iAppObtainApp.getActivity());
                                    if (!frameSwitchView.isInit()) {
                                        frameSwitchView.initView();
                                    }
                                    frameSwitchView.startAnimation(iWebview, str27, bitmapByUuid, strOptString, bitmapByUuid2, strOptString2, str30);
                                    return str3;
                                case 33:
                                    FrameSwitchView frameSwitchView2 = FrameSwitchView.getInstance(iAppObtainApp.getActivity());
                                    if (!frameSwitchView2.isInit()) {
                                        frameSwitchView2.initView();
                                    }
                                    frameSwitchView2.clearSwitchAnimation(strArr[0]);
                                    return str3;
                                case 34:
                                    NativeView nativeView23 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView23 != null) {
                                        String str31 = strArr[2];
                                        nativeView23.makeOverlay(iWebview, null, null, -1, null, (TextUtils.isEmpty(str31) || str31.equals("null")) ? null : new JSONObject(str31), null, strArr[3], "clear", false, true);
                                        return null;
                                    }
                                    return str3;
                                case 35:
                                    NativeView nativeView24 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView24 != null) {
                                        initViewDrawItme(iWebview, nativeView24, new JSONArray(strArr[2]));
                                    }
                                    return str3;
                                case 36:
                                    String str32 = strArr[0];
                                    String str33 = strArr[1];
                                    String str34 = strArr[2];
                                    NativeView nativeView25 = getNativeView(str32, str33);
                                    if (!PdrUtil.isEmpty(str34) && nativeView25 != null && nativeView25.getViewType().equals(AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        ((NativeImageSlider) nativeView25).setImages(iWebview, new JSONArray(str34));
                                    }
                                    return str3;
                                case 37:
                                    String str35 = strArr[0];
                                    String str36 = strArr[1];
                                    String str37 = strArr[2];
                                    NativeView nativeView26 = getNativeView(str35, str36);
                                    if (!PdrUtil.isEmpty(str37) && nativeView26 != null && nativeView26.getViewType().equals(AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        ((NativeImageSlider) nativeView26).addImages(iWebview, new JSONArray(str37));
                                    }
                                    return str3;
                                case 38:
                                    NativeView nativeView27 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView27 != null && nativeView27.getViewType().equals(AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        strWrapJsVar = String.valueOf(((NativeImageSlider) nativeView27).getCurrentImageIndex());
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                default:
                                    return str3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Logger.e("NativeBitmapMgr", e.toString());
                        e.printStackTrace();
                        return null;
                    }
                } catch (JSONException | Exception unused15) {
                }
            } catch (Exception e6) {
                e = e6;
                Logger.e("NativeBitmapMgr", e.toString());
                e.printStackTrace();
                return null;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public INativeBitmap getBitmapById(String str) {
        return getBitmapByUuid(this.mIds.get(str));
    }

    public INativeBitmap getBitmapByUuid(String str) {
        return this.mSnaps.get(str);
    }

    public JSONArray getItems() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, INativeBitmap>> it = this.mSnaps.entrySet().iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(new JSONObject(((NativeBitmap) it.next().getValue()).toJsString()));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    public NativeBitmap getSrcNativeBitmap(IWebview iWebview, IApp iApp, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return (NativeBitmap) getBitmapById(jSONObject.optString("id"));
        }
        if (!PdrUtil.isNetPath(str)) {
            str = (TextUtils.isEmpty(str) || str.equals("null")) ? null : iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        }
        if (PdrUtil.isEmpty(str)) {
            return null;
        }
        String str2 = iApp.obtainAppId() + str.hashCode();
        return new NativeBitmap(iApp, str2, str2, str);
    }

    protected void initViewDrawItme(IWebview iWebview, NativeView nativeView, JSONArray jSONArray) {
        String str;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int iStringToColor;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        IWebview iWebview2 = iWebview;
        JSONArray jSONArray2 = jSONArray;
        String str2 = "color";
        if (jSONArray2 == null || nativeView == null) {
            return;
        }
        int i2 = 0;
        while (i2 < jSONArray2.length()) {
            try {
                JSONObject jSONObject7 = jSONArray2.getJSONObject(i2);
                JSONObject jSONObjectOptJSONObject = null;
                String strOptString = jSONObject7.has("id") ? jSONObject7.optString("id") : null;
                String strOptString2 = jSONObject7.optString("tag");
                if (strOptString2.equals(WXBasicComponentType.IMG)) {
                    NativeBitmap srcNativeBitmap = getSrcNativeBitmap(iWebview2, iWebview2.obtainApp(), jSONObject7.optString("src"));
                    try {
                        jSONObject5 = new JSONObject(jSONObject7.optString("sprite"));
                    } catch (JSONException unused) {
                        jSONObject5 = new JSONObject();
                    }
                    try {
                        jSONObject6 = new JSONObject(jSONObject7.optString("position"));
                    } catch (JSONException unused2) {
                        jSONObject6 = new JSONObject();
                    }
                    i = i2;
                    str = str2;
                    nativeView.makeOverlay(iWebview2, srcNativeBitmap, null, -1, jSONObject5, jSONObject6, null, strOptString, WXBasicComponentType.IMG, false, true);
                } else {
                    str = str2;
                    i = i2;
                    if (strOptString2.equals(AbsURIAdapter.FONT)) {
                        String strOptString3 = jSONObject7.optString("text");
                        if (strOptString3 != null) {
                            try {
                                jSONObject3 = new JSONObject(jSONObject7.optString("position"));
                            } catch (JSONException unused3) {
                                jSONObject3 = new JSONObject();
                            }
                            JSONObject jSONObject8 = jSONObject3;
                            try {
                                jSONObject4 = new JSONObject(jSONObject7.optString("textStyles"));
                            } catch (JSONException unused4) {
                                jSONObject4 = new JSONObject();
                            }
                            nativeView.makeOverlay(iWebview, null, strOptString3, -1, null, jSONObject8, jSONObject4, strOptString, AbsURIAdapter.FONT, false, true);
                        }
                    } else if (strOptString2.equals("rect")) {
                        String strOptString4 = TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
                        if (jSONObject7.has(str)) {
                            strOptString4 = jSONObject7.optString(str);
                        }
                        String strOptString5 = jSONObject7.optString("position");
                        JSONObject jSONObject9 = (TextUtils.isEmpty(strOptString5) || strOptString5.equals("null")) ? null : new JSONObject(strOptString5);
                        if (jSONObject7.has("rectStyles")) {
                            jSONObjectOptJSONObject = jSONObject7.optJSONObject("rectStyles");
                            if (jSONObjectOptJSONObject.has(str)) {
                                strOptString4 = jSONObjectOptJSONObject.optString(str);
                            }
                        }
                        JSONObject jSONObject10 = jSONObjectOptJSONObject;
                        try {
                            iStringToColor = Color.parseColor(strOptString4);
                        } catch (Exception unused5) {
                            iStringToColor = PdrUtil.stringToColor(strOptString4);
                        }
                        nativeView.makeOverlay(iWebview, null, null, iStringToColor, null, jSONObject9, jSONObject10, strOptString, "rect", false, true);
                    } else {
                        if (strOptString2.equals(WXBasicComponentType.RICHTEXT)) {
                            String strOptString6 = jSONObject7.optString("text");
                            String strOptString7 = jSONObject7.optString("position");
                            nativeView.makeRichText(iWebview, strOptString6, (TextUtils.isEmpty(strOptString7) || strOptString7.equals("null")) ? null : new JSONObject(strOptString7), jSONObject7.has("richTextStyles") ? jSONObject7.optJSONObject("richTextStyles") : null, strOptString);
                        } else if (strOptString2.equals("input")) {
                            try {
                                jSONObject = new JSONObject(jSONObject7.optString("position"));
                            } catch (JSONException unused6) {
                                jSONObject = new JSONObject();
                            }
                            JSONObject jSONObject11 = jSONObject;
                            try {
                                jSONObject2 = new JSONObject(jSONObject7.optString("inputStyles"));
                            } catch (JSONException unused7) {
                                jSONObject2 = new JSONObject();
                            }
                            iWebview2 = iWebview;
                            nativeView.makeOverlay(iWebview2, null, null, -1, null, jSONObject11, jSONObject2, strOptString, "input", false, true);
                        } else {
                            iWebview2 = iWebview;
                            if (strOptString2.equals("weex")) {
                                nativeView.makeWeexView(iWebview2, jSONObject7, strOptString);
                            }
                        }
                        i2 = i + 1;
                        str2 = str;
                        jSONArray2 = jSONArray;
                    }
                }
                iWebview2 = iWebview;
                i2 = i + 1;
                str2 = str;
                jSONArray2 = jSONArray;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        nativeView.nativeInvalidate(true);
    }
}
