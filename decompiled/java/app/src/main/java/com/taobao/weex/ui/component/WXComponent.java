package com.taobao.weex.ui.component;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.asm.Opcodes;
import com.taobao.weex.ComponentObserver;
import com.taobao.weex.IWXActivityStateListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXAccessibilityRoleAdapter;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.IWXObject;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.tracing.Stopwatch;
import com.taobao.weex.tracing.WXTracing;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.WXRenderManager;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.action.GraphicActionAnimation;
import com.taobao.weex.ui.action.GraphicActionUpdateStyle;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.animation.WXAnimationBean;
import com.taobao.weex.ui.component.basic.WXBasicComponent;
import com.taobao.weex.ui.component.binding.Statements;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.ui.component.pesudo.OnActivePseudoListner;
import com.taobao.weex.ui.component.pesudo.PesudoStatus;
import com.taobao.weex.ui.component.pesudo.TouchActivePseudoListener;
import com.taobao.weex.ui.flat.FlatComponent;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.flat.widget.AndroidViewWidget;
import com.taobao.weex.ui.flat.widget.Widget;
import com.taobao.weex.ui.view.BaseFrameLayout;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.taobao.weex.utils.WXDataStructureUtil;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXReflectionUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.feature.uniapp.dom.AbsCSSShorthand;
import io.dcloud.feature.uniapp.ui.AbsAnimationHolder;
import io.dcloud.feature.uniapp.ui.action.UniMethodData;
import io.dcloud.feature.uniapp.ui.component.AbsBasicComponent;
import io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData;
import io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowLayer;
import io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable;
import io.dcloud.feature.uniapp.utils.UniBoxShadowUtil;
import io.dcloud.weex.ViewHover;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.mozilla.universalchardet.prober.HebrewProber;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WXComponent<T extends View> extends WXBasicComponent<T> implements IWXObject, IWXActivityStateListener, OnActivePseudoListner {
    public static final String PROP_FIXED_SIZE = "fixedSize";
    public static final String PROP_FS_MATCH_PARENT = "m";
    public static final String PROP_FS_WRAP_CONTENT = "w";
    public static final String ROOT = "_root";
    public static final int STATE_ALL_FINISH = 2;
    public static final int STATE_DOM_FINISH = 0;
    public static final int STATE_UI_FINISH = 1;
    public static final String TYPE = "type";
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_VIRTUAL = 1;
    private int[] EMPTY_STATE_SET;
    private int[] ENABLED_STATE_SET;
    private int[] FOCUSED_ENABLED_STATE_SET;
    private long PRESSED_ANIM_DELAY;
    private long PRESSED_ANIM_DURATION;
    private int[] PRESSED_ENABLED_STATE_SET;
    private ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> animations;
    protected ContentBoxMeasurement contentBoxMeasurement;
    public int interactionAbsoluteX;
    public int interactionAbsoluteY;
    public boolean isIgnoreInteraction;
    private boolean isLastLayoutDirectionRTL;
    private boolean isPreventGesture;
    private boolean isUsing;
    private int mAbsoluteX;
    private int mAbsoluteY;
    private AbsAnimationHolder mAnimationHolder;
    private Set<String> mAppendEvents;
    private BorderDrawable mBackgroundDrawable;
    private UniBoxShadowData mBoxShadowData;
    private UniNormalBoxShadowDrawable mBoxShadowDrawable;
    private WXComponent<T>.OnClickListenerImp mClickEventListener;
    private Context mContext;
    public int mDeepInComponentTree;
    private float mElevation;
    private int mFixedProp;
    private List<OnFocusChangeListener> mFocusChangeListeners;
    protected WXGesture mGesture;
    private Set<String> mGestureType;
    private boolean mHasAddFocusListener;
    private IFComponentHolder mHolder;
    T mHost;
    private List<OnClickListener> mHostClickListeners;
    private ViewHover mHover;
    private UniInsetBoxShadowLayer mInsetBoxShadowDrawable;
    private WXSDKInstance mInstance;
    public boolean mIsAddElementToTree;
    private boolean mIsDestroyed;
    private boolean mIsDisabled;
    private String mLastBoxShadowId;
    private boolean mLazy;
    private boolean mNeedLayoutOnAnimation;
    private volatile WXVContainer mParent;
    private ConcurrentLinkedQueue<UniMethodData> mPendingComponetMethodQueue;
    private PesudoStatus mPesudoStatus;
    private int mPreRealHeight;
    private int mPreRealLeft;
    private int mPreRealRight;
    private int mPreRealTop;
    private int mPreRealWidth;
    private GraphicSize mPseudoResetGraphicSize;
    private Drawable mRippleBackground;
    private int mStickyOffset;
    public WXTracing.TraceInfo mTraceInfo;
    private WXTransition mTransition;
    private int mType;
    private String mViewTreeKey;
    private boolean waste;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class MeasureOutput {
        public int height;
        public int width;
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnClickListener {
        void onHostViewClick();
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    private class OnClickListenerImp implements OnClickListener {
        private OnClickListenerImp() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
        public void onHostViewClick() {
            HashMap mapNewHashMapWithExpectedSize = WXDataStructureUtil.newHashMapWithExpectedSize(1);
            HashMap mapNewHashMapWithExpectedSize2 = WXDataStructureUtil.newHashMapWithExpectedSize(4);
            int[] iArr = new int[2];
            WXComponent.this.mHost.getLocationOnScreen(iArr);
            mapNewHashMapWithExpectedSize2.put(Constants.Name.X, Float.valueOf(WXViewUtils.getWebPxByWidth(iArr[0], WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put(Constants.Name.Y, Float.valueOf(WXViewUtils.getWebPxByWidth(iArr[1], WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put("width", Float.valueOf(WXViewUtils.getWebPxByWidth(WXComponent.this.getLayoutWidth(), WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put("height", Float.valueOf(WXViewUtils.getWebPxByWidth(WXComponent.this.getLayoutHeight(), WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize.put("position", mapNewHashMapWithExpectedSize2);
            WXComponent.this.fireEvent(Constants.Event.CLICK, mapNewHashMapWithExpectedSize);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnFocusChangeListener {
        void onFocusChange(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RenderState {
    }

    @Deprecated
    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    private void applyBorder(AbsBasicComponent absBasicComponent) {
        AbsCSSShorthand border = absBasicComponent.getBorder();
        float f = border.get(CSSShorthand.EDGE.LEFT);
        float f2 = border.get(CSSShorthand.EDGE.TOP);
        float f3 = border.get(CSSShorthand.EDGE.RIGHT);
        float f4 = border.get(CSSShorthand.EDGE.BOTTOM);
        if (this.mHost == null) {
            return;
        }
        setBorderWidth(Constants.Name.BORDER_LEFT_WIDTH, f);
        setBorderWidth(Constants.Name.BORDER_TOP_WIDTH, f2);
        setBorderWidth(Constants.Name.BORDER_RIGHT_WIDTH, f3);
        setBorderWidth(Constants.Name.BORDER_BOTTOM_WIDTH, f4);
    }

    private void applyEvents() {
        if (getEvents() == null || getEvents().isEmpty()) {
            return;
        }
        WXEvent events = getEvents();
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            addEvent(events.get(i));
        }
        setActiveTouchListener();
    }

    private WXAnimationBean createAnimationBean(String str, Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get("transform");
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    String str2 = (String) map.get(Constants.Name.TRANSFORM_ORIGIN);
                    WXAnimationBean wXAnimationBean = new WXAnimationBean();
                    int layoutWidth = (int) getLayoutWidth();
                    int layoutHeight = (int) getLayoutHeight();
                    WXAnimationBean.Style style = new WXAnimationBean.Style();
                    wXAnimationBean.styles = style;
                    style.init(str2, (String) obj, layoutWidth, layoutHeight, WXSDKManager.getInstanceViewPortWidth(getInstanceId()), getInstance());
                    return wXAnimationBean;
                }
            } catch (RuntimeException e) {
                WXLogUtils.e("", e);
            }
        }
        return null;
    }

    private void initOutlineProvider(final float f) {
        if (useFeature() && (getHostView() instanceof BaseFrameLayout)) {
            getHostView().setOutlineProvider(new ViewOutlineProvider() { // from class: com.taobao.weex.ui.component.WXComponent.8
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (WXComponent.this.getInstance().isDestroy()) {
                        return;
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    if (width == 0 || height == 0 || !WXComponent.this.getOrCreateBorder().isRounded()) {
                        return;
                    }
                    Rect rect = new Rect(0, 0, width, height);
                    float f2 = width / (f * 2.0f);
                    if (Float.isNaN(f2) || f2 >= 1.0f) {
                        outline.setRoundRect(rect, f);
                    } else {
                        outline.setRoundRect(rect, f2 * f);
                    }
                }
            });
            getHostView().setClipToOutline(true);
        }
    }

    private final void invokePendingComponetMethod() {
        if (this.mPendingComponetMethodQueue.size() > 0) {
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.ui.component.WXComponent.6
                @Override // java.lang.Runnable
                public void run() {
                    while (!WXComponent.this.mPendingComponetMethodQueue.isEmpty()) {
                        UniMethodData uniMethodData = (UniMethodData) WXComponent.this.mPendingComponetMethodQueue.poll();
                        if (uniMethodData != null) {
                            WXComponent.this.invoke(uniMethodData.getMethod(), uniMethodData.getArgs());
                        }
                    }
                }
            });
        }
    }

    private boolean needGestureDetector(String str) {
        if (this.mHost != null) {
            for (WXGestureType.LowLevelGesture lowLevelGesture : WXGestureType.LowLevelGesture.values()) {
                if (str.equals(lowLevelGesture.toString())) {
                    return true;
                }
            }
            for (WXGestureType.HighLevelGesture highLevelGesture : WXGestureType.HighLevelGesture.values()) {
                if (str.equals(highLevelGesture.toString())) {
                    return true;
                }
            }
        }
        return WXGesture.isStopPropagation(str) || str.equals(ViewHover.VIEW_HOVER_EVENT) || isPreventGesture();
    }

    private void parseAnimation() {
        WXAnimationBean wXAnimationBeanCreateAnimationBean;
        ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> concurrentLinkedQueue = this.animations;
        if (concurrentLinkedQueue == null) {
            return;
        }
        for (Pair<String, Map<String, Object>> pair : concurrentLinkedQueue) {
            if (!TextUtils.isEmpty((CharSequence) pair.first) && (wXAnimationBeanCreateAnimationBean = createAnimationBean((String) pair.first, (Map) pair.second)) != null) {
                new GraphicActionAnimation(getInstance(), getRef(), wXAnimationBeanCreateAnimationBean).executeAction();
            }
        }
        this.animations.clear();
    }

    private Drawable prepareBackgroundRipple() {
        int color;
        Drawable drawable = null;
        try {
            if (getStyles() != null && getStyles().getPesudoResetStyles() != null) {
                Map<String, Object> pesudoResetStyles = getStyles().getPesudoResetStyles();
                Object obj = pesudoResetStyles.get("backgroundColor");
                if (obj != null) {
                    color = WXResourceUtils.getColor(obj.toString(), 0);
                    if (color == 0) {
                        return null;
                    }
                } else {
                    color = 0;
                }
                Object obj2 = pesudoResetStyles.get("backgroundColor:active");
                if (obj2 == null) {
                    return null;
                }
                return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{WXResourceUtils.getColor(obj2.toString(), color)}), new ColorDrawable(color), drawable) { // from class: com.taobao.weex.ui.component.WXComponent.7
                    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
                    public void draw(Canvas canvas) {
                        if (WXComponent.this.mBackgroundDrawable != null) {
                            canvas.clipPath(WXComponent.this.mBackgroundDrawable.getContentPath(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())));
                        }
                        super.draw(canvas);
                    }
                };
            }
        } catch (Throwable th) {
            WXLogUtils.w("Exception on create ripple: ", th);
        }
        return null;
    }

    private void recordInteraction(int i, int i2) {
        if (this.mIsAddElementToTree) {
            this.mIsAddElementToTree = false;
            if (this.mParent == null) {
                this.interactionAbsoluteX = 0;
                this.interactionAbsoluteY = 0;
            } else {
                float cSSLayoutTop = getCSSLayoutTop();
                float cSSLayoutLeft = getCSSLayoutLeft();
                if (!isFixed()) {
                    cSSLayoutLeft += this.mParent.interactionAbsoluteX;
                }
                this.interactionAbsoluteX = (int) cSSLayoutLeft;
                if (!isFixed()) {
                    cSSLayoutTop += this.mParent.interactionAbsoluteY;
                }
                this.interactionAbsoluteY = (int) cSSLayoutTop;
            }
            if (getInstance().getApmForInstance().instanceRect == null) {
                getInstance().getApmForInstance().instanceRect = new Rect();
            }
            Rect rect = getInstance().getApmForInstance().instanceRect;
            rect.set(0, 0, this.mInstance.getWeexWidth(), this.mInstance.getWeexHeight());
            this.mInstance.onChangeElement(this, !(rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY + i2) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY + i2)));
        }
    }

    private void setActiveTouchListener() {
        View realView;
        if (!getStyles().getPesudoStyles().containsKey(Constants.PSEUDO.ACTIVE) || (realView = getRealView()) == null) {
            return;
        }
        realView.setOnTouchListener(new TouchActivePseudoListener(this, !isConsumeTouch()));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Multi-variable type inference failed */
    private void setComponentLayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        int i7;
        int i8;
        int i9;
        int normalTop;
        Widget androidViewWidget;
        if (getInstance() == null || getInstance().isDestroy()) {
            return;
        }
        updateBoxShadow(i, i2, false);
        UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
        if (uniBoxShadowData == null || uniBoxShadowData.getNormalShadows().size() <= 0) {
            i7 = i;
            i8 = i2;
            i9 = i3;
            normalTop = i4;
        } else {
            int normalMaxWidth = this.mBoxShadowData.getNormalMaxWidth();
            int normalMaxHeight = this.mBoxShadowData.getNormalMaxHeight();
            int normalLeft = i3 - (this.mBoxShadowData.getNormalLeft() / 2);
            normalTop = i4 - (this.mBoxShadowData.getNormalTop() / 2);
            i9 = normalLeft;
            i8 = normalMaxHeight;
            i7 = normalMaxWidth;
        }
        FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
        if (flatUIContext != null && flatUIContext.getFlatComponentAncestor(this) != null) {
            if (this instanceof FlatComponent) {
                FlatComponent flatComponent = (FlatComponent) this;
                if (flatComponent.promoteToView(true)) {
                    androidViewWidget = flatUIContext.getAndroidViewWidget(this);
                } else {
                    androidViewWidget = flatComponent.getOrCreateFlatWidget();
                }
            } else {
                androidViewWidget = flatUIContext.getAndroidViewWidget(this);
            }
            int i10 = normalTop;
            Widget widget = androidViewWidget;
            setWidgetParams(widget, flatUIContext, point, i7, i8, i9, i5, i10, i6);
            return;
        }
        if (this.mHost != null) {
            if (isFixed()) {
                setFixedHostLayoutParams(this.mHost, i7, i8, i9, i5, normalTop, i6);
            } else {
                setHostLayoutParams(this.mHost, i7, i8, i9, i5, normalTop, i6);
            }
            recordInteraction(i, i2);
            this.mPreRealWidth = i;
            this.mPreRealHeight = i2;
            this.mPreRealLeft = i3;
            this.mPreRealRight = i5;
            this.mPreRealTop = i4;
            onFinishLayout();
        }
    }

    private void setFixedHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = i;
        layoutParams.height = i2;
        setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        t.setLayoutParams(layoutParams);
        this.mInstance.moveFixedView(t);
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("Weex_Fixed_Style", "WXComponent:setLayout :" + i3 + Operators.SPACE_STR + i5 + Operators.SPACE_STR + i + Operators.SPACE_STR + i2);
            StringBuilder sb = new StringBuilder("WXComponent:setLayout Left:");
            sb.append(getStyles().getLeft());
            sb.append(Operators.SPACE_STR);
            sb.append((int) getStyles().getTop());
            WXLogUtils.d("Weex_Fixed_Style", sb.toString());
        }
    }

    private void setFixedSize(String str) {
        ViewGroup.LayoutParams layoutParams;
        if (PROP_FS_MATCH_PARENT.equals(str)) {
            this.mFixedProp = -1;
        } else {
            if (!PROP_FS_WRAP_CONTENT.equals(str)) {
                this.mFixedProp = 0;
                return;
            }
            this.mFixedProp = -2;
        }
        T t = this.mHost;
        if (t == null || (layoutParams = t.getLayoutParams()) == null) {
            return;
        }
        int i = this.mFixedProp;
        layoutParams.height = i;
        layoutParams.width = i;
        this.mHost.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    private void setWidgetParams(Widget widget, FlatGUIContext flatGUIContext, Point point, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Point point2 = new Point();
        if (this.mParent == null) {
            i7 = i;
            i8 = i2;
            i9 = i3;
            i10 = i4;
            i11 = i5;
            i12 = i6;
        } else {
            if ((this.mParent instanceof FlatComponent) && flatGUIContext.getFlatComponentAncestor(this.mParent) != null && flatGUIContext.getAndroidViewWidget(this.mParent) == null) {
                point2.set(point.x, point.y);
                i13 = i3;
                i14 = i5;
            } else {
                i13 = i3;
                i14 = i5;
                point2.set(i13, i14);
            }
            if ((this.mParent instanceof FlatComponent) && flatGUIContext.getFlatComponentAncestor(this.mParent) != null && flatGUIContext.getAndroidViewWidget(this.mParent) == null) {
                Point locInFlatContainer = ((FlatComponent) this.mParent).getOrCreateFlatWidget().getLocInFlatContainer();
                point2.offset(locInFlatContainer.x, locInFlatContainer.y);
            }
            ViewGroup.LayoutParams childLayoutParams = this.mParent.getChildLayoutParams(this, this.mHost, i, i2, i13, i4, i14, i6);
            if (childLayoutParams instanceof ViewGroup.MarginLayoutParams) {
                int i15 = childLayoutParams.width;
                int i16 = childLayoutParams.height;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childLayoutParams;
                int i17 = marginLayoutParams.leftMargin;
                int i18 = marginLayoutParams.rightMargin;
                int i19 = marginLayoutParams.topMargin;
                i12 = marginLayoutParams.bottomMargin;
                i7 = i15;
                i8 = i16;
                i9 = i17;
                i10 = i18;
                i11 = i19;
            } else {
                i7 = i;
                i8 = i2;
                i9 = i3;
                i10 = i4;
                i11 = i5;
                i12 = i6;
            }
        }
        widget.setLayout(i7, i8, i9, i10, i11, i12, point2);
        int i20 = i7;
        int i21 = i8;
        int i22 = i10;
        int i23 = i12;
        if (widget instanceof AndroidViewWidget) {
            AndroidViewWidget androidViewWidget = (AndroidViewWidget) widget;
            if (androidViewWidget.getView() != null) {
                setHostLayoutParams(androidViewWidget.getView(), i20, i21, point2.x, i22, point2.y, i23);
            }
        }
    }

    private boolean shouldCancelHardwareAccelerate() {
        IWXConfigAdapter wxConfigAdapter = WXSDKManager.getInstance().getWxConfigAdapter();
        boolean z = true;
        if (wxConfigAdapter != null) {
            try {
                z = Boolean.parseBoolean(wxConfigAdapter.getConfig("android_weex_test_gpu", "cancel_hardware_accelerate", AbsoluteConst.TRUE));
            } catch (Exception e) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
            }
            WXLogUtils.i("cancel_hardware_accelerate : " + z);
        }
        return z;
    }

    private void updateElevation() {
        float elevation = getAttrs().getElevation(getInstance().getInstanceViewPortWidthWithFloat());
        if (Float.isNaN(elevation)) {
            return;
        }
        ViewCompat.setElevation(getHostView(), elevation);
    }

    private void updateStyleByPesudo(Map<String, Object> map) {
        if (getInstance() == null) {
            return;
        }
        new GraphicActionUpdateStyle(getInstance(), getRef(), map, getPadding(), getMargin(), getBorder(), true).executeActionOnRender();
        if (getLayoutWidth() == 0.0f && getLayoutHeight() == 0.0f) {
            return;
        }
        if (map.containsKey("width")) {
            WXBridgeManager.getInstance().setStyleWidth(getInstanceId(), getRef(), getLayoutWidth());
        } else if (map.containsKey("height")) {
            WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), getLayoutHeight());
        }
    }

    public void addAnimationForElement(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (this.animations == null) {
            this.animations = new ConcurrentLinkedQueue<>();
        }
        this.animations.add(new Pair<>(getRef(), map));
    }

    protected final void addClickListener(OnClickListener onClickListener) {
        View realView;
        if (onClickListener == null || (realView = getRealView()) == null) {
            return;
        }
        if (this.mHostClickListeners == null) {
            this.mHostClickListeners = new ArrayList();
        }
        if (!realView.hasOnClickListeners()) {
            realView.setClickable(true);
            realView.setOnClickListener(new View.OnClickListener() { // from class: com.taobao.weex.ui.component.WXComponent.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WXGesture wXGesture = WXComponent.this.mGesture;
                    if (wXGesture == null || !wXGesture.isTouchEventConsumedByAdvancedGesture()) {
                        for (OnClickListener onClickListener2 : WXComponent.this.mHostClickListeners) {
                            if (onClickListener2 != null) {
                                onClickListener2.onHostViewClick();
                            }
                        }
                    }
                }
            });
        }
        this.mHostClickListeners.add(onClickListener);
    }

    public void addEvent(String str) {
        if (this.mAppendEvents == null) {
            this.mAppendEvents = new HashSet();
        }
        if (TextUtils.isEmpty(str) || this.mAppendEvents.contains(str)) {
            return;
        }
        KeyEvent.Callback realView = getRealView();
        if (str.equals(Constants.Event.LAYEROVERFLOW)) {
            addLayerOverFlowListener(getRef());
        }
        if (str.equals(Constants.Event.CLICK)) {
            if (realView == null) {
                return;
            }
            if (this.mClickEventListener == null) {
                this.mClickEventListener = new OnClickListenerImp();
            }
            addClickListener(this.mClickEventListener);
        } else if (str.equals(Constants.Event.FOCUS) || str.equals(Constants.Event.BLUR)) {
            if (!this.mHasAddFocusListener) {
                this.mHasAddFocusListener = true;
                addFocusChangeListener(new OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.WXComponent.1
                    @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
                    public void onFocusChange(boolean z) {
                        HashMap map = new HashMap();
                        map.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                        WXComponent.this.fireEvent(z ? Constants.Event.FOCUS : Constants.Event.BLUR, map);
                    }
                });
            }
        } else if (!needGestureDetector(str)) {
            Scrollable parentScroller = getParentScroller();
            if (parentScroller == null) {
                return;
            }
            if (str.equals(Constants.Event.APPEAR)) {
                parentScroller.bindAppearEvent(this);
            } else if (str.equals(Constants.Event.DISAPPEAR)) {
                parentScroller.bindDisappearEvent(this);
            }
        } else {
            if (realView == null) {
                return;
            }
            if (realView instanceof WXGestureObservable) {
                if (this.mGesture == null) {
                    this.mGesture = new WXGesture(this, this.mContext);
                    this.mGesture.setPreventMoveEvent(WXUtils.getBoolean(getAttrs().get(Constants.Name.PREVENT_MOVE_EVENT), Boolean.FALSE).booleanValue());
                }
                if (this.mGestureType == null) {
                    this.mGestureType = new HashSet();
                }
                if (!ViewHover.VIEW_HOVER_EVENT.equals(str)) {
                    this.mGestureType.add(str);
                }
                ((WXGestureObservable) realView).registerGestureListener(this.mGesture);
            } else {
                WXLogUtils.e(realView.getClass().getSimpleName() + " don't implement WXGestureObservable, so no gesture is supported.");
            }
        }
        this.mAppendEvents.add(str);
    }

    protected final void addFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        View realView;
        if (onFocusChangeListener == null || (realView = getRealView()) == null) {
            return;
        }
        if (this.mFocusChangeListeners == null) {
            this.mFocusChangeListeners = new ArrayList();
            realView.setFocusable(true);
            realView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.WXComponent.3
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    for (OnFocusChangeListener onFocusChangeListener2 : WXComponent.this.mFocusChangeListeners) {
                        if (onFocusChangeListener2 != null) {
                            onFocusChangeListener2.onFocusChange(z);
                        }
                    }
                }
            });
        }
        this.mFocusChangeListeners.add(onFocusChangeListener);
    }

    public void addLayerOverFlowListener(String str) {
        if (getInstance() != null) {
            getInstance().addLayerOverFlowListener(str);
        }
    }

    protected void appendEventToDOM(String str) {
    }

    public void applyComponentEvents() {
        applyEvents();
    }

    public void applyLayoutAndEvent(AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        WXComponent wXComponent = (WXComponent) absBasicComponent;
        bindComponent(wXComponent);
        setSafeLayout(wXComponent);
        setPadding(absBasicComponent.getPadding(), absBasicComponent.getBorder());
        applyEvents();
    }

    public void applyLayoutOnly() {
        if (isLazy()) {
            return;
        }
        setSafeLayout(this);
        setPadding(getPadding(), getBorder());
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    protected final void bindComponent(AbsBasicComponent absBasicComponent) {
        super.bindComponent(absBasicComponent);
        if (getInstance() != null) {
            setViewPortWidth(getInstance().getInstanceViewPortWidthWithFloat());
        }
        WXComponent wXComponent = (WXComponent) absBasicComponent;
        this.mParent = wXComponent.getParent();
        this.mType = wXComponent.getType();
    }

    protected void bindComponentData(AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        WXComponent wXComponent = (WXComponent) absBasicComponent;
        bindComponent(wXComponent);
        updateStyles(wXComponent);
        updateAttrs(absBasicComponent);
        updateExtra(absBasicComponent.getExtra());
    }

    public void bindData(WXComponent wXComponent) {
        bindComponentData(wXComponent);
    }

    public void bindHolder(IFComponentHolder iFComponentHolder) {
        this.mHolder = iFComponentHolder;
    }

    public boolean canRecycled() {
        return !(isFixed() && isSticky()) && getAttrs().canRecycled();
    }

    protected void clearBoxShadow() {
        if (!UniBoxShadowUtil.isBoxShadowEnabled()) {
            WXLogUtils.w("BoxShadow", "box-shadow disabled");
            return;
        }
        BorderDrawable borderDrawable = this.mBackgroundDrawable;
        if (borderDrawable != null) {
            borderDrawable.updateBoxShadowData(null);
        }
        if (getHostView() != null && this.mBackgroundDrawable != null && (getHostView().getBackground() instanceof LayerDrawable)) {
            if (this.mRippleBackground == null) {
                WXViewUtils.setBackGround(getHostView(), new LayerDrawable(new Drawable[]{this.mBackgroundDrawable}), this);
            } else {
                WXViewUtils.setBackGround(getHostView(), new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
            }
        }
        if (this.mBoxShadowData != null) {
            this.mBoxShadowData = null;
        }
        UniNormalBoxShadowDrawable uniNormalBoxShadowDrawable = this.mBoxShadowDrawable;
        if (uniNormalBoxShadowDrawable != null) {
            if (uniNormalBoxShadowDrawable.getBitmap() != null) {
                this.mBoxShadowDrawable.getBitmap().recycle();
            }
            this.mBoxShadowDrawable = null;
        }
        if (this.mInsetBoxShadowDrawable != null) {
            this.mInsetBoxShadowDrawable = null;
        }
    }

    public void clearPreLayout() {
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
    }

    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        View realView = getRealView();
        pointF.set(realView.getScrollX(), realView.getScrollY());
    }

    public boolean containsEvent(String str) {
        if (getEvents().contains(str)) {
            return true;
        }
        Set<String> set = this.mAppendEvents;
        return set != null && set.contains(str);
    }

    public boolean containsGesture(WXGestureType wXGestureType) {
        Set<String> set = this.mGestureType;
        return set != null && set.contains(wXGestureType.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0013  */
    protected Object convertEmptyProperty(String str, Object obj) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "borderRightColor":
            case "borderTopColor":
            case "borderBottomColor":
            case "borderLeftColor":
            case "borderColor":
                return "black";
            case "borderRightWidth":
            case "borderTopWidth":
            case "borderBottomWidth":
            case "borderTopLeftRadius":
            case "borderLeftWidth":
            case "borderTopRightRadius":
            case "borderBottomLeftRadius":
            case "borderBottomRightRadius":
            case "borderWidth":
            case "borderRadius":
                return 0;
            case "backgroundColor":
                return "transparent";
            default:
                return obj;
        }
    }

    public final void createView() {
        if (isLazy()) {
            return;
        }
        createViewImpl();
    }

    protected void createViewImpl() {
        Context context = this.mContext;
        if (context == null) {
            WXLogUtils.e("createViewImpl", "Context is null");
            return;
        }
        T t = (T) initComponentHostView(context);
        this.mHost = t;
        if (t == null && !isVirtualComponent()) {
            initView();
        }
        T t2 = this.mHost;
        if (t2 != null) {
            if (t2.getId() == -1) {
                this.mHost.setId(WXViewUtils.generateViewId());
            }
            ComponentObserver componentObserver = getInstance().getComponentObserver();
            if (componentObserver != null) {
                componentObserver.onViewCreated(this, this.mHost);
            }
            invokePendingComponetMethod();
        }
        onHostViewInitialized(this.mHost);
    }

    public void destroy() {
        View hostView;
        if (getInstance() == null) {
            return;
        }
        clearBoxShadow();
        ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onPreDestory(this);
        }
        if (WXEnvironment.isApkDebugable() && !WXUtils.isUiThread()) {
            throw new WXRuntimeException("[WXComponent] destroy can only be called in main thread");
        }
        T t = this.mHost;
        if (t != null && t.getLayerType() == 2 && isLayerTypeEnabled()) {
            this.mHost.setLayerType(0, null);
        }
        removeAllEvent();
        removeStickyStyle();
        if (isFixed() && (hostView = getHostView()) != null) {
            getInstance().removeFixedView(hostView);
        }
        ContentBoxMeasurement contentBoxMeasurement = this.contentBoxMeasurement;
        if (contentBoxMeasurement != null) {
            contentBoxMeasurement.destroy();
            this.contentBoxMeasurement = null;
        }
        this.mIsDestroyed = true;
        ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> concurrentLinkedQueue = this.animations;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        ViewHover viewHover = this.mHover;
        if (viewHover != null) {
            viewHover.destroy();
            this.mHover = null;
        }
        this.mInstance = null;
        List<OnFocusChangeListener> list = this.mFocusChangeListeners;
        if (list != null) {
            list.clear();
        }
        List<OnClickListener> list2 = this.mHostClickListeners;
        if (list2 != null) {
            list2.clear();
        }
    }

    public View detachViewAndClearPreInfo() {
        T t = this.mHost;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
        return t;
    }

    protected final WXComponent findComponent(String str) {
        if (this.mInstance == null || str == null) {
            return null;
        }
        return WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mInstance.getInstanceId(), str);
    }

    public Object findTypeParent(AbsBasicComponent absBasicComponent, Class cls) {
        if (absBasicComponent.getClass() == cls) {
            return absBasicComponent;
        }
        WXComponent wXComponent = (WXComponent) absBasicComponent;
        if (wXComponent.getParent() == null) {
            return null;
        }
        findTypeParent(wXComponent.getParent(), cls);
        return null;
    }

    public final void fireEvent(String str) {
        fireEvent(str, null);
    }

    public final EventResult fireEventWait(String str, Map<String, Object> map) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        EventResult eventResult = new EventResult() { // from class: com.taobao.weex.ui.component.WXComponent.2
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            fireEvent(str, map, null, eventResult);
            countDownLatch.await(50L, TimeUnit.MILLISECONDS);
            return eventResult;
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("fireEventWait", e);
            }
            return eventResult;
        }
    }

    public int getAbsoluteX() {
        return this.mAbsoluteX;
    }

    public int getAbsoluteY() {
        return this.mAbsoluteY;
    }

    public String getAttrByKey(String str) {
        return "default";
    }

    public Rect getComponentSize() {
        Rect rect = new Rect();
        if (this.mHost != null && this.mInstance.getContainerView() != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mHost.getLocationOnScreen(iArr);
            this.mInstance.getContainerView().getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = (iArr[1] - this.mStickyOffset) - iArr2[1];
            rect.set(i, i2, ((int) getLayoutWidth()) + i, ((int) getLayoutHeight()) + i2);
        }
        return rect;
    }

    public Context getContext() {
        return this.mContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Scrollable getFirstScroller() {
        if (this instanceof Scrollable) {
            return (Scrollable) this;
        }
        return null;
    }

    public T getHostView() {
        return this.mHost;
    }

    public ViewHover getHover() {
        return this.mHover;
    }

    public WXSDKInstance getInstance() {
        return this.mInstance;
    }

    public String getInstanceId() {
        return this.mInstance.getInstanceId();
    }

    public int getLayoutTopOffsetForSibling() {
        return 0;
    }

    protected BorderDrawable getOrCreateBorder() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = new BorderDrawable();
            T t = this.mHost;
            if (t != null) {
                WXViewUtils.setBackGround(t, null, this);
                if (this.mRippleBackground == null) {
                    if (this.mBoxShadowDrawable != null) {
                        WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mBoxShadowDrawable, this.mBackgroundDrawable}), this);
                    } else if (this.mInsetBoxShadowDrawable != null) {
                        WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mBackgroundDrawable, this.mInsetBoxShadowDrawable}), this);
                    } else {
                        WXViewUtils.setBackGround(this.mHost, this.mBackgroundDrawable, this);
                    }
                } else if (this.mBoxShadowDrawable != null) {
                    WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBoxShadowDrawable, this.mBackgroundDrawable}), this);
                } else if (this.mInsetBoxShadowDrawable != null) {
                    WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable}), this);
                } else {
                    WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
                }
            }
        }
        return this.mBackgroundDrawable;
    }

    public WXVContainer getParent() {
        return this.mParent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Scrollable getParentScroller() {
        WXComponent parent = this;
        do {
            parent = parent.getParent();
            if (parent == 0) {
                return null;
            }
            if (parent instanceof Scrollable) {
                return (Scrollable) parent;
            }
        } while (!parent.getRef().equals(ROOT));
        return null;
    }

    public View getRealView() {
        return this.mHost;
    }

    public long getRenderObjectPtr() {
        if (getBasicComponentData().isRenderPtrEmpty()) {
            getBasicComponentData().setRenderObjectPr(NativeRenderObjectUtils.nativeGetRenderObject(getInstanceId(), getRef()));
        }
        return getBasicComponentData().getRenderObjectPr();
    }

    public int getStickyOffset() {
        return this.mStickyOffset;
    }

    public WXTransition getTransition() {
        return this.mTransition;
    }

    public int getType() {
        return this.mType;
    }

    @Deprecated
    public View getView() {
        return this.mHost;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public float getViewPortWidthForFloat() {
        if (getInstance() != null) {
            return getInstance().getInstanceViewPortWidthWithFloat();
        }
        return 720.0f;
    }

    public String getViewTreeKey() {
        if (this.mViewTreeKey == null) {
            if (getParent() == null) {
                this.mViewTreeKey = hashCode() + "_" + getRef();
            } else {
                this.mViewTreeKey = hashCode() + "_" + getRef() + "_" + getParent().indexOf(this);
            }
        }
        return this.mViewTreeKey;
    }

    public String getVisibility() {
        try {
            return (String) getStyles().get(Constants.Name.VISIBILITY);
        } catch (Exception unused) {
            return "visible";
        }
    }

    public boolean hasScrollParent(WXComponent wXComponent) {
        if (wXComponent.getParent() == null) {
            return true;
        }
        if (wXComponent.getParent() instanceof WXBaseScroller) {
            return false;
        }
        return hasScrollParent(wXComponent.getParent());
    }

    @WXComponentProp(name = "hoverClass")
    public void hoverClass(String str) {
        JSONObject object = JSON.parseObject(str);
        if (object != null) {
            ViewHover viewHover = this.mHover;
            if (viewHover == null) {
                this.mHover = new ViewHover(this, object);
            } else {
                viewHover.update(object);
            }
            if (getEvents().contains(ViewHover.VIEW_HOVER_EVENT)) {
                return;
            }
            addEvent(ViewHover.VIEW_HOVER_EVENT);
        }
    }

    @WXComponentProp(name = "hoverStartTime")
    public void hoverStartTime(int i) {
        if (this.mHover == null) {
            this.mHover = new ViewHover(this);
        }
        this.mHover.setHoverStartTime(i);
    }

    @WXComponentProp(name = "hoverStayTime")
    public void hoverStayTime(int i) {
        if (this.mHover == null) {
            this.mHover = new ViewHover(this);
        }
        this.mHover.setHoverStayTime(i);
    }

    @WXComponentProp(name = "hoverStopPropagation")
    public void hoverStopPropagation(boolean z) {
        if (this.mHover == null) {
            this.mHover = new ViewHover(this);
        }
        this.mHover.setHoverStopPropagation(z);
        if (!getEvents().contains(ViewHover.VIEW_HOVER_EVENT)) {
            addEvent(ViewHover.VIEW_HOVER_EVENT);
        }
        if (this.mParent == null || !z) {
            return;
        }
        this.mParent.setHoverReceiveTouch(false);
    }

    protected T initComponentHostView(Context context) {
        return null;
    }

    protected void initElevation(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        this.mElevation = WXViewUtils.getRealSubPxByWidth(WXUtils.getFloat(str, Float.valueOf(0.0f)).floatValue(), this.mInstance.getInstanceViewPortWidthWithFloat());
        if (this.mBoxShadowData != null) {
            clearBoxShadow();
        }
        if (i == 21) {
            getHostView().setElevation(this.mElevation);
            return;
        }
        StateListAnimator stateListAnimator = new StateListAnimator();
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builderPlay = animatorSet.play(ObjectAnimator.ofFloat(getHostView(), Constants.Name.ELEVATION, this.mElevation).setDuration(0L));
        View hostView = getHostView();
        Property property = View.TRANSLATION_Z;
        builderPlay.with(ObjectAnimator.ofFloat(hostView, (Property<View, Float>) property, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet.setInterpolator(new FastOutLinearInInterpolator());
        stateListAnimator.addState(this.PRESSED_ENABLED_STATE_SET, animatorSet);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(getHostView(), Constants.Name.ELEVATION, this.mElevation).setDuration(0L)).with(ObjectAnimator.ofFloat(getHostView(), (Property<View, Float>) property, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet2.setInterpolator(new FastOutLinearInInterpolator());
        stateListAnimator.addState(this.FOCUSED_ENABLED_STATE_SET, animatorSet2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(getHostView(), Constants.Name.ELEVATION, this.mElevation).setDuration(0L));
        if (i >= 22 && i <= 24) {
            arrayList.add(ObjectAnimator.ofFloat(getHostView(), (Property<View, Float>) property, getHostView().getTranslationZ()).setDuration(this.PRESSED_ANIM_DELAY));
        }
        arrayList.add(ObjectAnimator.ofFloat(getHostView(), (Property<View, Float>) property, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet3.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
        animatorSet3.setInterpolator(new FastOutLinearInInterpolator());
        stateListAnimator.addState(this.ENABLED_STATE_SET, animatorSet3);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ObjectAnimator.ofFloat(getHostView(), Constants.Name.ELEVATION, 0.0f).setDuration(0L)).with(ObjectAnimator.ofFloat(getHostView(), (Property<View, Float>) property, 0.0f).setDuration(0L));
        animatorSet4.setInterpolator(new FastOutLinearInInterpolator());
        stateListAnimator.addState(this.EMPTY_STATE_SET, animatorSet4);
        getHostView().setStateListAnimator(stateListAnimator);
    }

    @Deprecated
    protected void initView() {
        Context context = this.mContext;
        if (context != null) {
            T t = (T) initComponentHostView(context);
            this.mHost = t;
            if (t != null) {
                invokePendingComponetMethod();
            }
        }
    }

    public void interceptFocusAndBlurEvent() {
        this.mHasAddFocusListener = true;
    }

    public final void invoke(String str, JSONArray jSONArray) {
        if (getHostView() == null || getRealView() == null) {
            this.mPendingComponetMethodQueue.offer(new UniMethodData(str, jSONArray));
            return;
        }
        Invoker methodInvoker = this.mHolder.getMethodInvoker(str);
        if (methodInvoker == null) {
            onInvokeUnknownMethod(str, jSONArray);
            return;
        }
        try {
            getInstance().getNativeInvokeHelper().invoke(this, methodInvoker, jSONArray);
        } catch (Exception e) {
            WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + methodInvoker.toString() + " function " + WXLogUtils.getStackTrace(e));
        }
    }

    protected boolean isConsumeTouch() {
        List<OnClickListener> list = this.mHostClickListeners;
        return (list != null && list.size() > 0) || this.mGesture != null;
    }

    public boolean isDestoryed() {
        return this.mIsDestroyed;
    }

    public boolean isDisabled() {
        return this.mIsDisabled;
    }

    public boolean isFixed() {
        return getStyles().isFixed();
    }

    public boolean isFlatUIEnabled() {
        return this.mParent != null && this.mParent.isFlatUIEnabled();
    }

    public boolean isLayerTypeEnabled() {
        return getInstance().isLayerTypeEnabled();
    }

    public boolean isLazy() {
        if (this.mLazy) {
            return true;
        }
        return this.mParent != null && this.mParent.isLazy();
    }

    public boolean isPreventGesture() {
        return this.isPreventGesture;
    }

    protected boolean isRippleEnabled() {
        try {
            return WXUtils.getBoolean(getAttrs().get(Constants.Name.RIPPLE_ENABLED), Boolean.FALSE).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isSticky() {
        return getStyles().isSticky();
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public boolean isVirtualComponent() {
        return this.mType == 1;
    }

    public boolean isWaste() {
        return this.waste;
    }

    protected boolean ismHasFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        List<OnFocusChangeListener> list = this.mFocusChangeListeners;
        if (list != null) {
            return list.contains(onFocusChangeListener);
        }
        return false;
    }

    protected void layoutDirectionDidChanged(boolean z) {
    }

    public void lazy(boolean z) {
        this.mLazy = z;
    }

    protected MeasureOutput measure(int i, int i2) {
        MeasureOutput measureOutput = new MeasureOutput();
        int i3 = this.mFixedProp;
        if (i3 != 0) {
            measureOutput.width = i3;
            measureOutput.height = i3;
            return measureOutput;
        }
        measureOutput.width = i;
        measureOutput.height = i2;
        return measureOutput;
    }

    public void nativeUpdateAttrs(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeAttr(entry.getKey(), entry.getValue());
            }
        }
    }

    public void notifyAppearStateChange(String str, String str2) {
        if (containsEvent(Constants.Event.APPEAR) || containsEvent(Constants.Event.DISAPPEAR)) {
            HashMap map = new HashMap();
            map.put("direction", str2);
            fireEvent(str, map);
        }
    }

    public void notifyNativeSizeChanged(int i, int i2) {
        if (this.mNeedLayoutOnAnimation) {
            UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
            if (uniBoxShadowData != null && uniBoxShadowData.getNormalShadows().size() > 0) {
                i -= this.mBoxShadowData.getNormalLeft();
                i2 -= this.mBoxShadowData.getNormalTop();
            }
            WXBridgeManager wXBridgeManager = WXBridgeManager.getInstance();
            wXBridgeManager.setStyleWidth(getInstanceId(), getRef(), i);
            wXBridgeManager.setStyleHeight(getInstanceId(), getRef(), i2);
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        return false;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        ConcurrentLinkedQueue<UniMethodData> concurrentLinkedQueue = this.mPendingComponetMethodQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
    }

    protected void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    protected void onFinishLayout() {
        Object obj = getStyles() != null ? getStyles().get(Constants.Name.BACKGROUND_IMAGE) : null;
        if (obj != null) {
            setBackgroundImage(obj.toString());
        }
    }

    protected void onHostViewInitialized(T t) {
        AbsAnimationHolder absAnimationHolder = this.mAnimationHolder;
        if (absAnimationHolder != null) {
            absAnimationHolder.execute(this.mInstance, this);
        }
        setActiveTouchListener();
    }

    protected void onInvokeUnknownMethod(String str, JSONArray jSONArray) {
    }

    public void onRenderFinish(int i) {
        if (WXTracing.isAvailable()) {
            double dNanosToMillis = Stopwatch.nanosToMillis(this.mTraceInfo.uiThreadNanos);
            if (i == 2 || i == 0) {
                WXTracing.TraceEvent traceEventNewEvent = WXTracing.newEvent("DomExecute", getInstanceId(), this.mTraceInfo.rootEventId);
                traceEventNewEvent.ph = "X";
                traceEventNewEvent.ts = this.mTraceInfo.domThreadStart;
                traceEventNewEvent.tname = "DOMThread";
                traceEventNewEvent.name = getComponentType();
                traceEventNewEvent.classname = getClass().getSimpleName();
                if (getParent() != null) {
                    traceEventNewEvent.parentRef = getParent().getRef();
                }
                traceEventNewEvent.submit();
            }
            if (i == 2 || i == 1) {
                if (this.mTraceInfo.uiThreadStart == -1) {
                    if (WXEnvironment.isApkDebugable()) {
                        isLazy();
                        return;
                    }
                    return;
                }
                WXTracing.TraceEvent traceEventNewEvent2 = WXTracing.newEvent("UIExecute", getInstanceId(), this.mTraceInfo.rootEventId);
                traceEventNewEvent2.ph = "X";
                traceEventNewEvent2.duration = dNanosToMillis;
                traceEventNewEvent2.ts = this.mTraceInfo.uiThreadStart;
                traceEventNewEvent2.name = getComponentType();
                traceEventNewEvent2.classname = getClass().getSimpleName();
                if (getParent() != null) {
                    traceEventNewEvent2.parentRef = getParent().getRef();
                }
                traceEventNewEvent2.submit();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void postAnimation(AbsAnimationHolder absAnimationHolder) {
        this.mAnimationHolder = absAnimationHolder;
    }

    public void readyToRender() {
        if (this.mParent == null || getInstance() == null || !getInstance().isTrackComponent()) {
            return;
        }
        this.mParent.readyToRender();
    }

    public void recycled() {
        isFixed();
    }

    public void refreshData(WXComponent wXComponent) {
    }

    @Deprecated
    public void registerActivityStateListener() {
    }

    public void removeAllEvent() {
        if (getEvents().size() < 1) {
            return;
        }
        WXEvent events = getEvents();
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            String str = events.get(i);
            if (str != null) {
                removeEventFromView(str);
            }
        }
        Set<String> set = this.mAppendEvents;
        if (set != null) {
            set.clear();
        }
        Set<String> set2 = this.mGestureType;
        if (set2 != null) {
            set2.clear();
        }
        this.mGesture = null;
        if (getRealView() != null && (getRealView() instanceof WXGestureObservable)) {
            ((WXGestureObservable) getRealView()).registerGestureListener(null);
        }
        T t = this.mHost;
        if (t != null) {
            t.setOnFocusChangeListener(null);
            List<OnClickListener> list = this.mHostClickListeners;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.mHostClickListeners.clear();
            this.mHost.setOnClickListener(null);
        }
    }

    protected final void removeClickListener(OnClickListener onClickListener) {
        this.mHostClickListeners.remove(onClickListener);
    }

    public void removeEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(Constants.Event.LAYEROVERFLOW)) {
            removeLayerOverFlowListener(getRef());
        }
        if (getEvents() != null) {
            getEvents().remove(str);
        }
        Set<String> set = this.mAppendEvents;
        if (set != null) {
            set.remove(str);
        }
        Set<String> set2 = this.mGestureType;
        if (set2 != null) {
            set2.remove(str);
        }
        removeEventFromView(str);
    }

    protected void removeEventFromView(String str) {
        if (str.equals(Constants.Event.CLICK) && getRealView() != null && this.mHostClickListeners != null) {
            if (this.mClickEventListener == null) {
                this.mClickEventListener = new OnClickListenerImp();
            }
            this.mHostClickListeners.remove(this.mClickEventListener);
            if (this.mHostClickListeners.size() < 1) {
                getRealView().setOnClickListener(null);
                getRealView().setClickable(false);
            }
        }
        Scrollable parentScroller = getParentScroller();
        if (str.equals(Constants.Event.APPEAR) && parentScroller != null) {
            parentScroller.unbindAppearEvent(this);
        }
        if (!str.equals(Constants.Event.DISAPPEAR) || parentScroller == null) {
            return;
        }
        parentScroller.unbindDisappearEvent(this);
    }

    public void removeLayerOverFlowListener(String str) {
        if (getInstance() != null) {
            getInstance().removeLayerOverFlowListener(str);
        }
    }

    public final void removeStickyStyle() {
        Scrollable parentScroller;
        if (!isSticky() || (parentScroller = getParentScroller()) == null) {
            return;
        }
        parentScroller.unbindStickStyle(this);
    }

    public void removeVirtualComponent() {
    }

    protected void setAriaHidden(boolean z) {
        View hostView = getHostView();
        if (hostView != null) {
            hostView.setImportantForAccessibility(z ? 2 : 1);
        }
    }

    protected void setAriaLabel(String str) {
        View hostView = getHostView();
        if (hostView != null) {
            hostView.setContentDescription(str);
        }
    }

    public void setBackgroundColor(String str) {
        LayerDrawable layerDrawable;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int color = WXResourceUtils.getColor(str);
        if (isRippleEnabled()) {
            Drawable drawablePrepareBackgroundRipple = prepareBackgroundRipple();
            this.mRippleBackground = drawablePrepareBackgroundRipple;
            if (drawablePrepareBackgroundRipple != null) {
                if (this.mBackgroundDrawable == null) {
                    WXViewUtils.setBackGround(this.mHost, drawablePrepareBackgroundRipple, this);
                    return;
                }
                if (this.mBoxShadowDrawable != null) {
                    layerDrawable = new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBoxShadowDrawable, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable});
                } else {
                    layerDrawable = this.mInsetBoxShadowDrawable != null ? new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable}) : new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable});
                }
                WXViewUtils.setBackGround(this.mHost, layerDrawable, this);
                return;
            }
        }
        if (color == 0 && this.mBackgroundDrawable == null) {
            return;
        }
        getOrCreateBorder().setColor(color);
    }

    public void setBackgroundImage(String str) {
        if ("".equals(str.trim())) {
            getOrCreateBorder().setImage(null);
        } else {
            getOrCreateBorder().setImage(WXResourceUtils.getShader(str, getLayoutSize().getWidth(), getLayoutSize().getHeight()));
        }
    }

    public void setBorderColor(String str, String str2) {
        int color;
        if (TextUtils.isEmpty(str2) || (color = WXResourceUtils.getColor(str2)) == Integer.MIN_VALUE) {
            return;
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "borderRightColor":
                getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.RIGHT, color);
                break;
            case "borderTopColor":
                getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.TOP, color);
                break;
            case "borderBottomColor":
                getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.BOTTOM, color);
                break;
            case "borderLeftColor":
                getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.LEFT, color);
                break;
            case "borderColor":
                getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.ALL, color);
                break;
        }
    }

    public void setBorderRadius(String str, float f) {
        if (f >= 0.0f) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "borderTopLeftRadius":
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_TOP_LEFT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderTopRightRadius":
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_TOP_RIGHT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderBottomLeftRadius":
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderBottomRightRadius":
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderRadius":
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.ALL, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
            }
        }
    }

    public void setBorderStyle(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "borderRightStyle":
                getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.RIGHT, str2);
                break;
            case "borderTopStyle":
                getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.TOP, str2);
                break;
            case "borderBottomStyle":
                getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.BOTTOM, str2);
                break;
            case "borderLeftStyle":
                getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.LEFT, str2);
                break;
            case "borderStyle":
                getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.ALL, str2);
                break;
        }
    }

    public void setBorderWidth(String str, float f) {
        if (f >= 0.0f) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "borderRightWidth":
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.RIGHT, f);
                    break;
                case "borderTopWidth":
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.TOP, f);
                    break;
                case "borderBottomWidth":
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.BOTTOM, f);
                    break;
                case "borderLeftWidth":
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.LEFT, f);
                    break;
                case "borderWidth":
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.ALL, f);
                    break;
            }
        }
    }

    protected void setContentBoxMeasurement(ContentBoxMeasurement contentBoxMeasurement) {
        this.contentBoxMeasurement = contentBoxMeasurement;
        this.mInstance.addContentBoxMeasurement(getRenderObjectPtr(), contentBoxMeasurement);
        WXBridgeManager.getInstance().bindMeasurementToRenderObject(getRenderObjectPtr());
    }

    public void setDemission(GraphicSize graphicSize, GraphicPosition graphicPosition) {
        setLayoutPosition(graphicPosition);
        setLayoutSize(graphicSize);
    }

    public void setDisabled(boolean z) {
        this.mIsDisabled = z;
        T t = this.mHost;
        if (t == null) {
            return;
        }
        t.setEnabled(!z);
    }

    @WXComponentProp(name = Constants.Name.ELEVATION)
    public void setElevation(String str) {
        initElevation(str);
    }

    protected void setHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.LayoutParams childLayoutParams;
        FrameLayout.LayoutParams layoutParams;
        if (this.mParent == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
            setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        } else {
            childLayoutParams = this.mParent.getChildLayoutParams(this, t, i, i2, i3, i4, i5, i6);
        }
        if (childLayoutParams == null) {
            childLayoutParams = layoutParams;
            return;
        } else {
            childLayoutParams = layoutParams;
            t.setLayoutParams(childLayoutParams);
        }
    }

    public void setHoverClassStatus(boolean z) {
        Map<String, Object> mapUpdateStatusAndGetUpdateStyles = this.mHover.updateStatusAndGetUpdateStyles(z);
        if (mapUpdateStatusAndGetUpdateStyles != null) {
            if (z) {
                boolean zContains = mapUpdateStatusAndGetUpdateStyles.keySet().contains("width");
                boolean zContains2 = mapUpdateStatusAndGetUpdateStyles.keySet().contains("height");
                if (zContains || zContains2) {
                    this.mPseudoResetGraphicSize = new GraphicSize(getLayoutSize().getWidth(), getLayoutSize().getHeight());
                }
                if (zContains) {
                    getLayoutSize().setWidth(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(mapUpdateStatusAndGetUpdateStyles.get("width")), getViewPortWidthForFloat()));
                } else if (zContains2) {
                    getLayoutSize().setHeight(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(mapUpdateStatusAndGetUpdateStyles.get("height")), getViewPortWidthForFloat()));
                }
            } else {
                GraphicSize graphicSize = this.mPseudoResetGraphicSize;
                if (graphicSize != null) {
                    setLayoutSize(graphicSize);
                }
            }
        }
        updateStyleByPesudo(mapUpdateStatusAndGetUpdateStyles);
    }

    public void setHoverReceiveTouch(boolean z) {
        if (getHover() != null) {
            getHover().setReceiveTouch(z);
        }
        if (this.mParent != null) {
            this.mParent.setHoverReceiveTouch(z);
        }
    }

    public void setLayout(WXComponent wXComponent) {
        int top;
        int i;
        setLayoutSize(wXComponent.getLayoutSize());
        setLayoutPosition(wXComponent.getLayoutPosition());
        setPaddings(wXComponent.getPadding());
        setMargins(wXComponent.getMargin());
        setBorders(wXComponent.getBorder());
        boolean zIsLayoutRTL = wXComponent.isLayoutRTL();
        setIsLayoutRTL(zIsLayoutRTL);
        if (zIsLayoutRTL != wXComponent.isLastLayoutDirectionRTL) {
            wXComponent.isLastLayoutDirectionRTL = zIsLayoutRTL;
            layoutDirectionDidChanged(zIsLayoutRTL);
        }
        try {
            if (getLayoutSize().getWidth() != 0.0f && getLayoutSize().getHeight() != 0.0f) {
                parseAnimation();
            }
        } catch (Exception unused) {
        }
        boolean z = this.mParent == null;
        int childrenLayoutTopOffset = z ? 0 : this.mParent.getChildrenLayoutTopOffset();
        CSSShorthand cSSShorthand = z ? new CSSShorthand() : this.mParent.getPadding();
        CSSShorthand cSSShorthand2 = z ? new CSSShorthand() : this.mParent.getBorder();
        int width = (int) getLayoutSize().getWidth();
        int height = (int) getLayoutSize().getHeight();
        if (isFixed()) {
            int left = (int) (getLayoutPosition().getLeft() - getInstance().getRenderContainerPaddingLeft());
            top = ((int) (getLayoutPosition().getTop() - getInstance().getRenderContainerPaddingTop())) + childrenLayoutTopOffset;
            i = left;
        } else {
            float left2 = getLayoutPosition().getLeft();
            CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
            int i2 = (int) ((left2 - cSSShorthand.get(edge)) - cSSShorthand2.get(edge));
            float top2 = getLayoutPosition().getTop();
            CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
            top = ((int) ((top2 - cSSShorthand.get(edge2)) - cSSShorthand2.get(edge2))) + childrenLayoutTopOffset;
            i = i2;
        }
        int i3 = (int) getMargin().get(CSSShorthand.EDGE.RIGHT);
        int i4 = (int) getMargin().get(CSSShorthand.EDGE.BOTTOM);
        Point point = new Point((int) getLayoutPosition().getLeft(), (int) getLayoutPosition().getTop());
        if (this.mPreRealWidth == width && this.mPreRealHeight == height && this.mPreRealLeft == i && this.mPreRealRight == i3 && this.mPreRealTop == top) {
            return;
        }
        if ((this instanceof WXCell) && height >= WXPerformance.VIEW_LIMIT_HEIGHT && width >= WXPerformance.VIEW_LIMIT_WIDTH) {
            this.mInstance.getApmForInstance().updateDiffStats(WXInstanceApm.KEY_PAGE_STATS_CELL_EXCEED_NUM, 1.0d);
            this.mInstance.getWXPerformance().cellExceedNum++;
        }
        this.mAbsoluteY = (int) (z ? 0.0f : this.mParent.getAbsoluteY() + getCSSLayoutTop());
        this.mAbsoluteX = (int) (z ? 0.0f : this.mParent.getAbsoluteX() + getCSSLayoutLeft());
        T t = this.mHost;
        if (t == null) {
            return;
        }
        if (!(t instanceof ViewGroup) && this.mAbsoluteY + height > this.mInstance.getWeexHeight() + 1) {
            WXSDKInstance wXSDKInstance = this.mInstance;
            if (!wXSDKInstance.mEnd) {
                wXSDKInstance.onOldFsRenderTimeLogic();
            }
            WXSDKInstance wXSDKInstance2 = this.mInstance;
            if (!wXSDKInstance2.isNewFsEnd) {
                wXSDKInstance2.isNewFsEnd = true;
                wXSDKInstance2.getApmForInstance().arriveNewFsRenderTime();
            }
        }
        MeasureOutput measureOutputMeasure = measure(width, height);
        setComponentLayoutParams(measureOutputMeasure.width, measureOutputMeasure.height, i, top, i3, i4, point);
    }

    public void setMarginsSupportRTL(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
        if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) marginLayoutParams).gravity = 51;
        }
    }

    public void setNeedLayoutOnAnimation(boolean z) {
        this.mNeedLayoutOnAnimation = z;
    }

    public void setOpacity(float f) {
        if (f < 0.0f || f > 1.0f || this.mHost.getAlpha() == f) {
            return;
        }
        int openGLRenderLimitValue = WXRenderManager.getOpenGLRenderLimitValue();
        if (isLayerTypeEnabled()) {
            this.mHost.setLayerType(2, null);
        }
        if (isLayerTypeEnabled() && shouldCancelHardwareAccelerate() && openGLRenderLimitValue > 0) {
            float f2 = openGLRenderLimitValue;
            if (getLayoutHeight() > f2 || getLayoutWidth() > f2) {
                this.mHost.setLayerType(0, null);
            }
        }
        this.mHost.setAlpha(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPadding(AbsCSSShorthand absCSSShorthand, AbsCSSShorthand absCSSShorthand2) {
        CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
        int i = (int) (absCSSShorthand.get(edge) + absCSSShorthand2.get(edge));
        CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
        int i2 = (int) (absCSSShorthand.get(edge2) + absCSSShorthand2.get(edge2));
        CSSShorthand.EDGE edge3 = CSSShorthand.EDGE.RIGHT;
        int i3 = (int) (absCSSShorthand.get(edge3) + absCSSShorthand2.get(edge3));
        CSSShorthand.EDGE edge4 = CSSShorthand.EDGE.BOTTOM;
        int i4 = (int) (absCSSShorthand.get(edge4) + absCSSShorthand2.get(edge4));
        if (this instanceof FlatComponent) {
            FlatComponent flatComponent = (FlatComponent) this;
            if (!flatComponent.promoteToView(true)) {
                flatComponent.getOrCreateFlatWidget().setContentBox(i, i2, i3, i4);
                return;
            }
        }
        if (this.mHost != null) {
            UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
            if (uniBoxShadowData != null) {
                if (uniBoxShadowData.getNormalLeft() > 0) {
                    int normalLeft = this.mBoxShadowData.getNormalLeft() / 2;
                    i += normalLeft;
                    i3 += normalLeft;
                }
                if (this.mBoxShadowData.getNormalTop() > 0) {
                    int normalTop = this.mBoxShadowData.getNormalTop() / 2;
                    i2 += normalTop;
                    i4 += normalTop;
                }
            }
            this.mHost.setPadding(i, i2, i3, i4);
        }
    }

    @WXComponentProp(name = "preventGesture")
    public void setPreventGesture(boolean z) {
        this.isPreventGesture = z;
        addEvent("preventGesture");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected boolean setProperty(String str, Object obj) {
        if (str != null && getInstance() != null) {
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals(Constants.Name.BORDER_RIGHT_COLOR)) {
                        b = 0;
                    }
                    break;
                case -1974639039:
                    if (str.equals(Constants.Name.BORDER_RIGHT_STYLE)) {
                        b = 1;
                    }
                    break;
                case -1971292586:
                    if (str.equals(Constants.Name.BORDER_RIGHT_WIDTH)) {
                        b = 2;
                    }
                    break;
                case -1501175880:
                    if (str.equals(Constants.Name.PADDING_LEFT)) {
                        b = 3;
                    }
                    break;
                case -1470826662:
                    if (str.equals(Constants.Name.BORDER_TOP_COLOR)) {
                        b = 4;
                    }
                    break;
                case -1455888984:
                    if (str.equals(Constants.Name.BORDER_TOP_STYLE)) {
                        b = 5;
                    }
                    break;
                case -1452542531:
                    if (str.equals(Constants.Name.BORDER_TOP_WIDTH)) {
                        b = 6;
                    }
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        b = 7;
                    }
                    break;
                case -1375815020:
                    if (str.equals(Constants.Name.MIN_WIDTH)) {
                        b = 8;
                    }
                    break;
                case -1308858324:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_COLOR)) {
                        b = 9;
                    }
                    break;
                case -1293920646:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_STYLE)) {
                        b = 10;
                    }
                    break;
                case -1290574193:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_WIDTH)) {
                        b = 11;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        b = 12;
                    }
                    break;
                case -1228066334:
                    if (str.equals(Constants.Name.BORDER_TOP_LEFT_RADIUS)) {
                        b = 13;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 14;
                    }
                    break;
                case -1111969773:
                    if (str.equals(Constants.Name.ARIA_HIDDEN)) {
                        b = 15;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 16;
                    }
                    break;
                case -1063257157:
                    if (str.equals(Constants.Name.ALIGN_ITEMS)) {
                        b = 17;
                    }
                    break;
                case -1044792121:
                    if (str.equals(Constants.Name.MARGIN_TOP)) {
                        b = 18;
                    }
                    break;
                case -975171706:
                    if (str.equals(Constants.Name.FLEX_DIRECTION)) {
                        b = 19;
                    }
                    break;
                case -906066005:
                    if (str.equals(Constants.Name.MAX_HEIGHT)) {
                        b = 20;
                    }
                    break;
                case -863700117:
                    if (str.equals(Constants.Name.ARIA_LABEL)) {
                        b = 21;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 22;
                    }
                    break;
                case -289173127:
                    if (str.equals(Constants.Name.MARGIN_BOTTOM)) {
                        b = 23;
                    }
                    break;
                case -242276144:
                    if (str.equals(Constants.Name.BORDER_LEFT_COLOR)) {
                        b = 24;
                    }
                    break;
                case -227338466:
                    if (str.equals(Constants.Name.BORDER_LEFT_STYLE)) {
                        b = 25;
                    }
                    break;
                case -223992013:
                    if (str.equals(Constants.Name.BORDER_LEFT_WIDTH)) {
                        b = 26;
                    }
                    break;
                case -133587431:
                    if (str.equals(Constants.Name.MIN_HEIGHT)) {
                        b = 27;
                    }
                    break;
                case 115029:
                    if (str.equals("top")) {
                        b = 28;
                    }
                    break;
                case 3145721:
                    if (str.equals(Constants.Name.FLEX)) {
                        b = 29;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        b = 30;
                    }
                    break;
                case 3506294:
                    if (str.equals(Constants.Name.ROLE)) {
                        b = 31;
                    }
                    break;
                case 90130308:
                    if (str.equals(Constants.Name.PADDING_TOP)) {
                        b = HebrewProber.SPACE;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        b = 33;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 34;
                    }
                    break;
                case 202355100:
                    if (str.equals(Constants.Name.PADDING_BOTTOM)) {
                        b = 35;
                    }
                    break;
                case 270940796:
                    if (str.equals(Constants.Name.DISABLED)) {
                        b = 36;
                    }
                    break;
                case 333432965:
                    if (str.equals(Constants.Name.BORDER_TOP_RIGHT_RADIUS)) {
                        b = 37;
                    }
                    break;
                case 400381634:
                    if (str.equals(Constants.Name.MAX_WIDTH)) {
                        b = 38;
                    }
                    break;
                case 581268560:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS)) {
                        b = 39;
                    }
                    break;
                case 588239831:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS)) {
                        b = 40;
                    }
                    break;
                case 713848971:
                    if (str.equals(Constants.Name.PADDING_RIGHT)) {
                        b = 41;
                    }
                    break;
                case 717381201:
                    if (str.equals(Constants.Name.PREVENT_MOVE_EVENT)) {
                        b = 42;
                    }
                    break;
                case 722830999:
                    if (str.equals(Constants.Name.BORDER_COLOR)) {
                        b = 43;
                    }
                    break;
                case 737768677:
                    if (str.equals(Constants.Name.BORDER_STYLE)) {
                        b = 44;
                    }
                    break;
                case 741115130:
                    if (str.equals(Constants.Name.BORDER_WIDTH)) {
                        b = 45;
                    }
                    break;
                case 743055051:
                    if (str.equals(Constants.Name.BOX_SHADOW)) {
                        b = 46;
                    }
                    break;
                case 747463061:
                    if (str.equals(PROP_FIXED_SIZE)) {
                        b = 47;
                    }
                    break;
                case 747804969:
                    if (str.equals("position")) {
                        b = 48;
                    }
                    break;
                case 975087886:
                    if (str.equals(Constants.Name.MARGIN_RIGHT)) {
                        b = 49;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        b = 50;
                    }
                    break;
                case 1292595405:
                    if (str.equals(Constants.Name.BACKGROUND_IMAGE)) {
                        b = 51;
                    }
                    break;
                case 1349188574:
                    if (str.equals(Constants.Name.BORDER_RADIUS)) {
                        b = 52;
                    }
                    break;
                case 1744216035:
                    if (str.equals(Constants.Name.FLEX_WRAP)) {
                        b = 53;
                    }
                    break;
                case 1767100401:
                    if (str.equals(Constants.Name.ALIGN_SELF)) {
                        b = 54;
                    }
                    break;
                case 1860657097:
                    if (str.equals(Constants.Name.JUSTIFY_CONTENT)) {
                        b = 55;
                    }
                    break;
                case 1941332754:
                    if (str.equals(Constants.Name.VISIBILITY)) {
                        b = 56;
                    }
                    break;
                case 1970934485:
                    if (str.equals(Constants.Name.MARGIN_LEFT)) {
                        b = 57;
                    }
                    break;
            }
            switch (b) {
                case 0:
                case 4:
                case 9:
                case 24:
                case 43:
                    String string = WXUtils.getString(obj, null);
                    if (string != null) {
                        setBorderColor(str, string);
                    }
                    break;
                case 1:
                case 5:
                case 10:
                case 25:
                case 44:
                    String string2 = WXUtils.getString(obj, null);
                    if (string2 != null) {
                        setBorderStyle(str, string2);
                    }
                    return true;
                case 12:
                    Float f = WXUtils.getFloat(obj, Float.valueOf(1.0f));
                    if (f != null) {
                        setOpacity(f.floatValue());
                        break;
                    }
                case 2:
                case 3:
                case 6:
                case 7:
                case 8:
                case 11:
                case 14:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 32:
                case 33:
                case 34:
                case 35:
                case 38:
                case 41:
                case 45:
                case 49:
                case 53:
                case 54:
                case Opcodes.LSTORE /* 55 */:
                case Opcodes.DSTORE /* 57 */:
                    return true;
                case 13:
                case 37:
                case 39:
                case 40:
                case 52:
                    Float f2 = WXUtils.getFloat(obj, null);
                    if (f2 != null) {
                        setBorderRadius(str, f2.floatValue());
                    }
                    return true;
                case 15:
                    setAriaHidden(WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue());
                    return true;
                case 21:
                    setAriaLabel(WXUtils.getString(obj, ""));
                    return true;
                case 31:
                    setRole(WXUtils.getString(obj, ""));
                    return true;
                case 36:
                    Boolean bool = WXUtils.getBoolean(obj, null);
                    if (bool != null) {
                        setDisabled(bool.booleanValue());
                        setPseudoClassStatus(Constants.PSEUDO.DISABLED, bool.booleanValue());
                    }
                    return true;
                case 42:
                    WXGesture wXGesture = this.mGesture;
                    if (wXGesture != null) {
                        wXGesture.setPreventMoveEvent(WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue());
                    }
                    return true;
                case 46:
                    try {
                        getHostView();
                        break;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return true;
                case 47:
                    setFixedSize(WXUtils.getString(obj, PROP_FS_MATCH_PARENT));
                    return true;
                case 48:
                    String string3 = WXUtils.getString(obj, null);
                    if (string3 != null) {
                        setSticky(string3);
                    }
                    return true;
                case 50:
                    String string4 = WXUtils.getString(obj, null);
                    if (string4 != null) {
                        setBackgroundColor(string4);
                    }
                    return true;
                case 51:
                    String string5 = WXUtils.getString(obj, null);
                    if (string5 != null && this.mHost != null) {
                        setBackgroundImage(string5);
                    }
                    return true;
                case 56:
                    String string6 = WXUtils.getString(obj, null);
                    if (string6 != null) {
                        setVisibility(string6);
                    }
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    protected void setPseudoClassStatus(String str, boolean z) {
        WXStyle styles = getStyles();
        Map<String, Map<String, Object>> pesudoStyles = styles.getPesudoStyles();
        if (pesudoStyles == null || pesudoStyles.size() == 0) {
            return;
        }
        if (this.mPesudoStatus == null) {
            this.mPesudoStatus = new PesudoStatus();
        }
        Map<String, Object> mapUpdateStatusAndGetUpdateStyles = this.mPesudoStatus.updateStatusAndGetUpdateStyles(str, z, pesudoStyles, styles.getPesudoResetStyles());
        if (mapUpdateStatusAndGetUpdateStyles != null) {
            if (z) {
                this.mPseudoResetGraphicSize = new GraphicSize(getLayoutSize().getWidth(), getLayoutSize().getHeight());
                if (mapUpdateStatusAndGetUpdateStyles.keySet().contains("width")) {
                    getLayoutSize().setWidth(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(styles.getPesudoResetStyles().get("width:active")), getViewPortWidthForFloat()));
                } else if (mapUpdateStatusAndGetUpdateStyles.keySet().contains("height")) {
                    getLayoutSize().setHeight(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(styles.getPesudoResetStyles().get("height:active")), getViewPortWidthForFloat()));
                }
            } else {
                GraphicSize graphicSize = this.mPseudoResetGraphicSize;
                if (graphicSize != null) {
                    setLayoutSize(graphicSize);
                }
            }
        }
        updateStyleByPesudo(mapUpdateStatusAndGetUpdateStyles);
    }

    protected void setRole(final String str) {
        View hostView = getHostView();
        if (hostView == null || TextUtils.isEmpty(str)) {
            return;
        }
        IWXAccessibilityRoleAdapter accessibilityRoleAdapter = WXSDKManager.getInstance().getAccessibilityRoleAdapter();
        if (accessibilityRoleAdapter != null) {
            str = accessibilityRoleAdapter.getRole(str);
        }
        ViewCompat.setAccessibilityDelegate(hostView, new AccessibilityDelegateCompat() { // from class: com.taobao.weex.ui.component.WXComponent.5
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                try {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setRoleDescription(str);
                } catch (Throwable unused) {
                    WXLogUtils.e("SetRole failed!");
                }
            }
        });
    }

    public void setSafeLayout(WXComponent wXComponent) {
        if (TextUtils.isEmpty(wXComponent.getComponentType()) || TextUtils.isEmpty(wXComponent.getRef()) || wXComponent.getLayoutPosition() == null || wXComponent.getLayoutSize() == null) {
            return;
        }
        setLayout(wXComponent);
    }

    public void setSticky(String str) {
        Scrollable parentScroller;
        if (TextUtils.isEmpty(str) || !str.equals("sticky") || (parentScroller = getParentScroller()) == null) {
            return;
        }
        parentScroller.bindStickStyle(this);
    }

    public void setStickyOffset(int i) {
        this.mStickyOffset = i;
    }

    public void setTransition(WXTransition wXTransition) {
        this.mTransition = wXTransition;
    }

    public void setUsing(boolean z) {
        this.isUsing = z;
    }

    public void setVisibility(String str) {
        View realView = getRealView();
        if (realView != null) {
            if (TextUtils.equals(str, "visible")) {
                realView.setVisibility(0);
            } else if (TextUtils.equals(str, "hidden")) {
                realView.setVisibility(8);
            }
        }
    }

    public void setWaste(boolean z) {
        if (this.waste != z) {
            this.waste = z;
            if (!WXBasicComponentType.RECYCLE_LIST.equals(getParent().getComponentType())) {
                NativeRenderObjectUtils.nativeRenderObjectChildWaste(getRenderObjectPtr(), z);
            }
            if (z) {
                getStyles().put(Constants.Name.VISIBILITY, (Object) "hidden");
                if (getHostView() != null) {
                    getHostView().setVisibility(8);
                    return;
                } else {
                    if (this.mLazy) {
                        return;
                    }
                    lazy(true);
                    return;
                }
            }
            getStyles().put(Constants.Name.VISIBILITY, (Object) "visible");
            if (getHostView() != null) {
                getHostView().setVisibility(0);
                return;
            }
            if (this.mLazy) {
                if (this.mParent == null || !this.mParent.isLazy()) {
                    Statements.initLazyComponent(this, this.mParent);
                } else {
                    lazy(false);
                }
            }
        }
    }

    @Override // com.taobao.weex.ui.component.pesudo.OnActivePseudoListner
    public void updateActivePseudo(boolean z) {
        if (getInstance() != null) {
            setPseudoClassStatus(Constants.PSEUDO.ACTIVE, z);
        }
    }

    public void updateAttrs(AbsBasicComponent absBasicComponent) {
        if (absBasicComponent != null) {
            updateProperties(absBasicComponent.getAttrs());
        }
    }

    protected void updateBoxShadow(int i, int i2, boolean z) {
        UniBoxShadowData boxShadow;
        LayerDrawable layerDrawable;
        int top;
        int left;
        if (!UniBoxShadowUtil.isBoxShadowEnabled() || this.mElevation > 0.0f || getStyles().get(Constants.Name.ELEVATION) != null || getAttrs().get(Constants.Name.ELEVATION) != null) {
            WXLogUtils.w("BoxShadow", "box-shadow disabled");
            if (this.mBoxShadowData != null) {
                clearBoxShadow();
                return;
            }
            return;
        }
        if (getStyles() == null) {
            WXLogUtils.w("Can not resolve styles");
            return;
        }
        Object obj = getStyles().get(Constants.Name.BOX_SHADOW);
        Object obj2 = getAttrs().get(Constants.Name.SHADOW_QUALITY);
        if (obj != null && i > 0 && i2 > 0) {
            float fFloatValue = WXUtils.getFloat(obj2, Float.valueOf(0.5f)).floatValue();
            float instanceViewPortWidthWithFloat = getInstance().getInstanceViewPortWidthWithFloat();
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            WXStyle styles = getStyles();
            if (styles != null) {
                float fFloatValue2 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_TOP_LEFT_RADIUS), Float.valueOf(0.0f)).floatValue();
                fArr[0] = WXViewUtils.getRealSubPxByWidth(fFloatValue2, instanceViewPortWidthWithFloat);
                fArr[1] = WXViewUtils.getRealSubPxByWidth(fFloatValue2, instanceViewPortWidthWithFloat);
                float fFloatValue3 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_TOP_RIGHT_RADIUS), Float.valueOf(0.0f)).floatValue();
                fArr[2] = WXViewUtils.getRealSubPxByWidth(fFloatValue3, instanceViewPortWidthWithFloat);
                fArr[3] = WXViewUtils.getRealSubPxByWidth(fFloatValue3, instanceViewPortWidthWithFloat);
                float fFloatValue4 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS), Float.valueOf(0.0f)).floatValue();
                fArr[4] = WXViewUtils.getRealSubPxByWidth(fFloatValue4, instanceViewPortWidthWithFloat);
                fArr[5] = WXViewUtils.getRealSubPxByWidth(fFloatValue4, instanceViewPortWidthWithFloat);
                float fFloatValue5 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS), Float.valueOf(0.0f)).floatValue();
                fArr[6] = WXViewUtils.getRealSubPxByWidth(fFloatValue5, instanceViewPortWidthWithFloat);
                fArr[7] = WXViewUtils.getRealSubPxByWidth(fFloatValue5, instanceViewPortWidthWithFloat);
                if (styles.containsKey(Constants.Name.BORDER_RADIUS)) {
                    float fFloatValue6 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_RADIUS), Float.valueOf(0.0f)).floatValue();
                    for (int i3 = 0; i3 < 8; i3++) {
                        fArr[i3] = WXViewUtils.getRealSubPxByWidth(fFloatValue6, instanceViewPortWidthWithFloat);
                    }
                }
            }
            UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
            if ((uniBoxShadowData == null || !uniBoxShadowData.equalsUniBoxShadowData(obj.toString(), i, i2, fArr)) && (boxShadow = UniBoxShadowUtil.parseBoxShadow(i, i2, obj.toString(), fArr, instanceViewPortWidthWithFloat, fFloatValue)) != null) {
                this.mBoxShadowData = boxShadow;
                UniNormalBoxShadowDrawable normalBoxShadowDrawable = UniBoxShadowUtil.getNormalBoxShadowDrawable(boxShadow, getContext().getResources());
                UniInsetBoxShadowLayer insetBoxShadowDrawable = UniBoxShadowUtil.getInsetBoxShadowDrawable(boxShadow);
                if (normalBoxShadowDrawable == null && insetBoxShadowDrawable == null) {
                    return;
                }
                if (normalBoxShadowDrawable != null && z && this.mHost != null) {
                    int normalMaxWidth = boxShadow.getNormalMaxWidth();
                    int normalMaxHeight = boxShadow.getNormalMaxHeight();
                    boolean z2 = this.mParent == null;
                    CSSShorthand cSSShorthand = z2 ? new CSSShorthand() : this.mParent.getPadding();
                    CSSShorthand cSSShorthand2 = z2 ? new CSSShorthand() : this.mParent.getBorder();
                    int childrenLayoutTopOffset = z2 ? 0 : this.mParent.getChildrenLayoutTopOffset();
                    if (isFixed()) {
                        left = (int) (getLayoutPosition().getLeft() - getInstance().getRenderContainerPaddingLeft());
                        top = ((int) (getLayoutPosition().getTop() - getInstance().getRenderContainerPaddingTop())) + childrenLayoutTopOffset;
                    } else {
                        float left2 = getLayoutPosition().getLeft();
                        CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
                        int i4 = (int) ((left2 - cSSShorthand.get(edge)) - cSSShorthand2.get(edge));
                        float top2 = getLayoutPosition().getTop();
                        CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
                        top = ((int) ((top2 - cSSShorthand.get(edge2)) - cSSShorthand2.get(edge2))) + childrenLayoutTopOffset;
                        left = i4;
                    }
                    int i5 = (int) getMargin().get(CSSShorthand.EDGE.RIGHT);
                    int i6 = (int) getMargin().get(CSSShorthand.EDGE.BOTTOM);
                    int normalLeft = left - (boxShadow.getNormalLeft() / 2);
                    int normalTop = top - (boxShadow.getNormalTop() / 2);
                    if (isFixed()) {
                        setFixedHostLayoutParams(this.mHost, normalMaxWidth, normalMaxHeight, normalLeft, i5, normalTop, i6);
                    } else {
                        setHostLayoutParams(this.mHost, normalMaxWidth, normalMaxHeight, normalLeft, i5, normalTop, i6);
                    }
                    setPadding(getPadding(), getBorder());
                }
                if (this.mBackgroundDrawable == null) {
                    clearBoxShadow();
                    this.mBoxShadowData = boxShadow;
                    this.mBoxShadowDrawable = normalBoxShadowDrawable;
                    this.mInsetBoxShadowDrawable = insetBoxShadowDrawable;
                    getOrCreateBorder().updateBoxShadowData(boxShadow);
                    return;
                }
                clearBoxShadow();
                if (this.mRippleBackground == null) {
                    layerDrawable = normalBoxShadowDrawable != null ? new LayerDrawable(new Drawable[]{normalBoxShadowDrawable, this.mBackgroundDrawable}) : insetBoxShadowDrawable != null ? new LayerDrawable(new Drawable[]{this.mBackgroundDrawable, insetBoxShadowDrawable}) : new LayerDrawable(new Drawable[]{this.mBackgroundDrawable});
                } else if (normalBoxShadowDrawable != null) {
                    layerDrawable = new LayerDrawable(new Drawable[]{this.mRippleBackground, normalBoxShadowDrawable, this.mBackgroundDrawable});
                } else {
                    layerDrawable = insetBoxShadowDrawable != null ? new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, insetBoxShadowDrawable}) : new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable});
                }
                WXViewUtils.setBackGround(getHostView(), layerDrawable, this);
                this.mBoxShadowData = boxShadow;
                this.mBoxShadowDrawable = normalBoxShadowDrawable;
                this.mInsetBoxShadowDrawable = insetBoxShadowDrawable;
                this.mBackgroundDrawable.updateBoxShadowData(boxShadow);
            }
        }
    }

    public void updateDemission(float f, float f2, float f3, float f4, float f5, float f6) {
        getLayoutPosition().update(f, f2, f3, f4);
        getLayoutSize().update(f6, f5);
    }

    public void updateNativeAttr(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        getBasicComponentData().getAttrs().put(str, obj);
        NativeRenderObjectUtils.nativeUpdateRenderObjectAttr(getRenderObjectPtr(), str, obj.toString());
    }

    public void updateNativeStyle(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        getBasicComponentData().getStyles().put(str, obj);
        NativeRenderObjectUtils.nativeUpdateRenderObjectStyle(getRenderObjectPtr(), str, obj.toString());
    }

    public void updateNativeStyles(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeStyle(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void updateProperties(Map<String, Object> map) {
        if (map != null) {
            if ((this.mHost != null || isVirtualComponent()) && getInstance() != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String string = WXUtils.getString(value, null);
                    if (key == null) {
                        String instanceId = getInstanceId();
                        WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_NULL_KEY;
                        WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "updateProperties", wXErrorCode.getErrorMsg(), null);
                    } else {
                        if (TextUtils.isEmpty(string)) {
                            value = convertEmptyProperty(key, string);
                        }
                        if (setProperty(key, value)) {
                            continue;
                        } else {
                            if (this.mHolder == null || getInstance() == null) {
                                return;
                            }
                            Invoker propertyInvoker = this.mHolder.getPropertyInvoker(key);
                            if (propertyInvoker != null) {
                                try {
                                    Type[] parameterTypes = propertyInvoker.getParameterTypes();
                                    if (parameterTypes.length != 1) {
                                        WXLogUtils.e("[WXComponent] setX method only one parameter：" + propertyInvoker);
                                        return;
                                    }
                                    propertyInvoker.invoke(this, WXReflectionUtils.parseArgument(parameterTypes[0], value));
                                } catch (Exception e) {
                                    WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + propertyInvoker.toString() + " function " + WXLogUtils.getStackTrace(e));
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                readyToRender();
                if (!(this instanceof FlatComponent) || this.mBackgroundDrawable == null) {
                    return;
                }
                FlatComponent flatComponent = (FlatComponent) this;
                if (flatComponent.promoteToView(true) || (flatComponent.getOrCreateFlatWidget() instanceof AndroidViewWidget)) {
                    return;
                }
                flatComponent.getOrCreateFlatWidget().setBackgroundAndBorder(this.mBackgroundDrawable);
            }
        }
    }

    public void updateStyles(WXComponent wXComponent) {
        if (wXComponent != null) {
            updateProperties(wXComponent.getStyles());
            applyBorder(wXComponent);
        }
    }

    public boolean useFeature() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Deprecated
    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public final void fireEvent(String str, Map<String, Object> map) {
        if (WXUtils.getBoolean(getAttrs().get("fireEventSyn"), Boolean.FALSE).booleanValue()) {
            fireEventWait(str, map);
        } else {
            fireEvent(str, map, null, null);
        }
    }

    public void updateAttrs(Map<String, Object> map) {
        if (map != null) {
            updateProperties(map);
        }
    }

    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, 0, basicComponentData);
    }

    public void updateStyles(Map<String, Object> map) {
        if (map != null) {
            updateProperties(map);
            applyBorder(this);
        }
    }

    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(basicComponentData);
        this.mFixedProp = 0;
        this.mAbsoluteY = 0;
        this.mAbsoluteX = 0;
        this.isLastLayoutDirectionRTL = false;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealTop = 0;
        this.mStickyOffset = 0;
        this.isUsing = false;
        this.mIsDestroyed = false;
        this.mIsDisabled = false;
        this.mType = 0;
        this.mNeedLayoutOnAnimation = false;
        this.mDeepInComponentTree = 0;
        this.mIsAddElementToTree = false;
        this.interactionAbsoluteX = 0;
        this.interactionAbsoluteY = 0;
        this.mHasAddFocusListener = false;
        this.mTraceInfo = new WXTracing.TraceInfo();
        this.waste = false;
        this.isIgnoreInteraction = false;
        this.mPendingComponetMethodQueue = new ConcurrentLinkedQueue<>();
        this.PRESSED_ANIM_DURATION = 100L;
        this.PRESSED_ANIM_DELAY = 100L;
        this.ENABLED_STATE_SET = new int[]{R.attr.state_enabled};
        this.EMPTY_STATE_SET = new int[0];
        this.PRESSED_ENABLED_STATE_SET = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        this.FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_focused, R.attr.state_enabled};
        this.mElevation = 0.0f;
        this.mLazy = false;
        this.isPreventGesture = false;
        this.mInstance = wXSDKInstance;
        this.mContext = wXSDKInstance.getContext();
        this.mParent = wXVContainer;
        this.mType = i;
        if (wXSDKInstance != null) {
            setViewPortWidth(wXSDKInstance.getInstanceViewPortWidthWithFloat());
        }
        onCreate();
        ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onCreate(this);
        }
    }

    protected final void fireEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        fireEvent(str, map, map2, null);
    }

    private final void fireEvent(String str, Map<String, Object> map, Map<String, Object> map2, EventResult eventResult) {
        String componentId;
        if (this.mInstance != null) {
            List<Object> list = (getEvents() == null || getEvents().getEventBindingArgsValues() == null) ? null : getEvents().getEventBindingArgsValues().get(str);
            if (map != null && (componentId = Statements.getComponentId(this)) != null) {
                map.put("componentId", componentId);
            }
            this.mInstance.fireEvent(getRef(), str, map, map2, list, eventResult);
        }
    }
}
