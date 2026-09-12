package io.dcloud.common.DHInterface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import io.dcloud.PdrR;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.feature.internal.splash.ISplash;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class SplashView extends RelativeLayout {
    public static int STYLE_BLACK = 1;
    public static int STYLE_DEFAULT = 0;
    public static int STYLE_WHITE = 2;
    final String TAG;
    private boolean hasAdSplash;
    protected boolean mShowSplashScreen;
    protected boolean mShowSplashWaiting;
    int screenHeight;
    int screenWidth;
    boolean showBitmap;

    public SplashView(Context context, Bitmap bitmap) {
        super(context);
        this.mShowSplashScreen = false;
        this.mShowSplashWaiting = false;
        this.TAG = "SplashView";
        this.showBitmap = false;
        this.hasAdSplash = false;
        setBackgroundColor(-1);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        setBackground(NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) ? new NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), new Rect(), null) : new BitmapDrawable(context.getResources(), bitmap));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof ISplash) {
            this.hasAdSplash = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (DeviceInfo.sStatusBarHeight <= 0) {
            Logger.d("SplashView", "paint() before DeviceInfo.updateScreenInfo()");
            DeviceInfo.updateStatusBarHeight((Activity) getContext());
        }
        Logger.d("SplashView", "dispatchDraw.....");
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hasAdSplash) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onShowProgressBar(ViewGroup viewGroup, int i) {
        Drawable drawable;
        if (this.hasAdSplash) {
            return;
        }
        Logger.d(Logger.MAIN_TAG, "showWaiting style=" + i);
        ProgressBar progressBar = new ProgressBar(getContext());
        int i2 = PdrUtil.parseInt("7%", this.screenWidth, -1);
        setGravity(17);
        if (i == STYLE_BLACK) {
            drawable = getContext().getResources().getDrawable(PdrR.DRAWBLE_PROGRESSBAR_BLACK_SNOW);
        } else {
            drawable = i == STYLE_WHITE ? getContext().getResources().getDrawable(PdrR.DRAWBLE_PROGRESSBAR_WHITE_SNOW) : null;
        }
        if (drawable != null) {
            progressBar.setIndeterminateDrawable(drawable);
        }
        viewGroup.addView(progressBar, new RelativeLayout.LayoutParams(i2, i2));
        Logger.d(Logger.MAIN_TAG, "onShowProgressBar");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void showWaiting() {
        showWaiting(STYLE_DEFAULT);
    }

    public void showWaiting(final int i) {
        post(new Runnable() { // from class: io.dcloud.common.DHInterface.SplashView.1
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
            @Override // java.lang.Runnable
            public void run() {
                SplashView splashView = SplashView.this;
                splashView.onShowProgressBar(splashView, i);
            }
        });
    }
}
