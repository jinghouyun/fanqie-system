package io.dcloud.common.util;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.INativeView;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class SubNViewsUtil {
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
    public static void initFrameSubNViews(AdaFrameView adaFrameView) {
        if (adaFrameView.getFrameType() == 2) {
            JSONObject jSONObjectObtainThridInfo = adaFrameView.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData);
            if (jSONObjectObtainThridInfo != null && jSONObjectObtainThridInfo.has(AbsoluteConst.JSON_KEY_SUB_NVIEWS)) {
                try {
                    adaFrameView.obtainFrameOptions().mSubNViews = jSONObjectObtainThridInfo.getJSONArray(AbsoluteConst.JSON_KEY_SUB_NVIEWS);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONObjectObtainThridInfo != null && jSONObjectObtainThridInfo.has(AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION) && jSONObjectObtainThridInfo.optString(AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION).equals("auto")) {
                adaFrameView.obtainFrameOptions().isAnimationOptimization = true;
            }
        } else if (adaFrameView.getFrameType() == 4) {
            JSONObject jSONObjectObtainThridInfo2 = adaFrameView.obtainApp().obtainThridInfo(IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
            if (jSONObjectObtainThridInfo2 != null && jSONObjectObtainThridInfo2.has(AbsoluteConst.JSON_KEY_SUB_NVIEWS)) {
                try {
                    adaFrameView.obtainFrameOptions().mSubNViews = jSONObjectObtainThridInfo2.getJSONArray(AbsoluteConst.JSON_KEY_SUB_NVIEWS);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (jSONObjectObtainThridInfo2 != null && jSONObjectObtainThridInfo2.has(AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION) && jSONObjectObtainThridInfo2.optString(AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION).equals("auto")) {
                adaFrameView.obtainFrameOptions().isAnimationOptimization = true;
            }
        }
        if (adaFrameView.obtainFrameOptions().mSubNViews != null) {
            JSONArray jSONArray = adaFrameView.obtainFrameOptions().mSubNViews;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString("id", i + "NativeView");
                    String strOptString2 = jSONObject.optString("uuid");
                    if (TextUtils.isEmpty(strOptString2)) {
                        strOptString2 = "NativeView" + (System.currentTimeMillis() + ((long) i));
                    }
                    Object objProcessEvent = adaFrameView.mWindowMgr.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{adaFrameView.obtainWebView(), "nativeobj", "View", new Object[]{adaFrameView, adaFrameView.obtainWebView(), strOptString, strOptString2, jSONObject.optJSONObject("styles"), jSONObject.optJSONArray("tags"), jSONObject.optString("type", "NView")}});
                    if (objProcessEvent != null) {
                        ((INativeView) objProcessEvent).attachToViewGroup(adaFrameView);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    public static boolean startAnimation(final AdaFrameView adaFrameView, Animator animator, int i) {
        ArrayList<INativeView> arrayList;
        if (adaFrameView.getAnimOptions().mAnimator != null && i == 0 && (arrayList = adaFrameView.mChildNativeViewList) != null && arrayList.size() > 0) {
            final ViewGroup viewGroupObtainWindowView = adaFrameView.obtainWebView().obtainWindowView();
            final ViewGroup viewGroup = (ViewGroup) viewGroupObtainWindowView.getParent();
            final ArrayList arrayList2 = new ArrayList();
            if (adaFrameView.obtainFrameOptions().background == -1) {
                viewGroup.setBackgroundColor(-1);
            }
            for (int i2 = 0; i2 < viewGroupObtainWindowView.getChildCount(); i2++) {
                KeyEvent.Callback childAt = viewGroupObtainWindowView.getChildAt(i2);
                if (childAt instanceof INativeView) {
                    arrayList2.add((INativeView) childAt);
                }
            }
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                INativeView iNativeView = (INativeView) obj;
                viewGroupObtainWindowView.removeView(iNativeView.obtanMainView());
                viewGroup.addView(iNativeView.obtanMainView());
            }
            viewGroup.removeView(viewGroupObtainWindowView);
            try {
                viewGroupObtainWindowView.getClass().getMethod("onPause", null).invoke(viewGroupObtainWindowView, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            final View viewObtainMainView = adaFrameView.obtainMainView();
            if (!PdrUtil.isEmpty(viewObtainMainView)) {
                viewObtainMainView.bringToFront();
                viewObtainMainView.setVisibility(0);
                adaFrameView.getAnimOptions().mAnimator.setAnimationListener(new Animation.AnimationListener() { // from class: io.dcloud.common.util.SubNViewsUtil.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Animator.AnimatorListener animatorListener = adaFrameView.mAnimatorListener;
                        if (animatorListener != null) {
                            animatorListener.onAnimationEnd(null);
                        }
                        BaseInfo.sDoingAnimation = false;
                        adaFrameView.setSlipping(false);
                        viewObtainMainView.post(new Runnable() { // from class: io.dcloud.common.util.SubNViewsUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ArrayList arrayList3 = arrayList2;
                                int size2 = arrayList3.size();
                                int i4 = 0;
                                while (i4 < size2) {
                                    Object obj2 = arrayList3.get(i4);
                                    i4++;
                                    INativeView iNativeView2 = (INativeView) obj2;
                                    viewGroup.removeView(iNativeView2.obtanMainView());
                                    viewGroupObtainWindowView.addView(iNativeView2.obtanMainView());
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                viewGroup.addView(viewGroupObtainWindowView);
                                if (adaFrameView.obtainFrameOptions().background == -1) {
                                    viewGroup.setBackgroundColor(0);
                                }
                                try {
                                    viewGroupObtainWindowView.getClass().getMethod("onResume", null).invoke(viewGroupObtainWindowView, null);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Animator.AnimatorListener animatorListener = adaFrameView.mAnimatorListener;
                        if (animatorListener != null) {
                            animatorListener.onAnimationStart(null);
                        }
                        BaseInfo.sDoingAnimation = true;
                    }
                });
                adaFrameView.setSlipping(true);
                viewObtainMainView.startAnimation(adaFrameView.getAnimOptions().mAnimator);
                return true;
            }
        }
        return false;
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
    public static void updateSubNViews(AdaFrameView adaFrameView, JSONArray jSONArray) {
        if (jSONArray != null) {
            adaFrameView.mWindowMgr.processEvent(IMgr.MgrType.FeatureMgr, 10, new Object[]{adaFrameView.obtainWebView(), "nativeobj", "updateSubNViews", new Object[]{adaFrameView, adaFrameView.obtainWebView(), jSONArray}});
        }
    }
}
