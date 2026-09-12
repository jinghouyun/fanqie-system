package com.taobao.weex.ui.component.helper;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class SoftKeyboardDetector {
    private static final int KEYBOARD_VISIBLE_THRESHOLD_DIP = 100;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static final class DefaultUnRegister implements Unregister {
        private WeakReference<Activity> activityRef;
        private WeakReference<ViewTreeObserver.OnGlobalLayoutListener> listenerRef;

        public DefaultUnRegister(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.activityRef = new WeakReference<>(activity);
            this.listenerRef = new WeakReference<>(onGlobalLayoutListener);
        }

        @Override // com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister
        public void execute() {
            View activityRoot;
            Activity activity = this.activityRef.get();
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.listenerRef.get();
            if (activity != null && onGlobalLayoutListener != null && (activityRoot = SoftKeyboardDetector.getActivityRoot(activity)) != null) {
                activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.activityRef.clear();
            this.listenerRef.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnKeyboardEventListener {
        void onKeyboardEvent(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface Unregister {
        void execute();
    }

    public static View getActivityRoot(Activity activity) {
        if (activity != null) {
            return activity.findViewById(R.id.content);
        }
        return null;
    }

    public static boolean isKeyboardVisible(Activity activity) {
        Rect rect = new Rect();
        View activityRoot = getActivityRoot(activity);
        if (activityRoot != null) {
            activityRoot.getWindowVisibleDisplayFrame(rect);
            if (activityRoot.getRootView().getHeight() - rect.height() > WXViewUtils.dip2px(100.0f)) {
                return true;
            }
        }
        return false;
    }

    public static Unregister registerKeyboardEventListener(Activity activity, final OnKeyboardEventListener onKeyboardEventListener) {
        WindowManager.LayoutParams attributes;
        int i;
        if (activity == null || onKeyboardEventListener == null) {
            WXLogUtils.e("Activity or listener is null!");
            return null;
        }
        if (activity.getWindow() != null && (attributes = activity.getWindow().getAttributes()) != null && ((i = attributes.softInputMode) == 48 || i == 32)) {
            WXLogUtils.e("SoftKeyboard detector can't work with softInputMode is SOFT_INPUT_ADJUST_NOTHING or SOFT_INPUT_ADJUST_PAN");
            return null;
        }
        final View activityRoot = getActivityRoot(activity);
        if (activityRoot == null) {
            WXLogUtils.e("Activity root is null!");
            return null;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.helper.SoftKeyboardDetector.1
            private final Rect visibleFrame = new Rect();
            private final int threshold = WXViewUtils.dip2px(100.0f);
            private boolean wasKeyboardOpened = false;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                activityRoot.getWindowVisibleDisplayFrame(this.visibleFrame);
                boolean z = activityRoot.getRootView().getHeight() - this.visibleFrame.height() > this.threshold;
                if (z == this.wasKeyboardOpened) {
                    return;
                }
                this.wasKeyboardOpened = z;
                onKeyboardEventListener.onKeyboardEvent(z);
            }
        };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        return new DefaultUnRegister(activity, onGlobalLayoutListener);
    }
}
