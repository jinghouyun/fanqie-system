package com.dmcbig.mediapicker.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import io.dcloud.common.adapter.util.AndroidResources;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ScreenUtils {
    private ScreenUtils() {
        throw new UnsupportedOperationException("本屏幕工具类不能被实例化,直接调用静态方法就好");
    }

    public static int dp2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void fitAndroid16WindowInsets(Activity activity, View view, final int i) {
        if (Build.VERSION.SDK_INT < 36 || AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        activity.getWindow().setNavigationBarContrastEnforced(false);
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.dmcbig.mediapicker.utils.ScreenUtils$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ScreenUtils.lambda$fitAndroid16WindowInsets$0(i, view2, windowInsetsCompat);
            }
        });
    }

    public static int getBottomStatusHeight(Context context) {
        return getDpi(context) - getScreenHeight(context);
    }

    public static int getDpi(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getTitleHeight(Activity activity) {
        return activity.getWindow().findViewById(R.id.content).getTop();
    }

    public static boolean isScreenOriatationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    static /* synthetic */ WindowInsetsCompat lambda$fitAndroid16WindowInsets$0(int i, View view, WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Insets insets = windowInsetsCompat.getInsets(i);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        }
        return WindowInsetsCompat.CONSUMED;
    }

    public static float px2dp(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float px2sp(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int sp2px(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
