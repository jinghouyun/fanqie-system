package io.dcloud.common.adapter.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import io.dcloud.common.adapter.util.Logger;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AdaRootView extends AdaContainerFrameItem {
    FrameLayout mMyRootView;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class MyRootView extends FrameLayout {
        AdaRootView mProxy;

        public MyRootView(Context context, AdaRootView adaRootView) {
            super(context);
            this.mProxy = adaRootView;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            AdaRootView.this.mViewOptions.onScreenChanged();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            AdaRootView.this.mViewOptions.onScreenChanged(i, i2);
            Logger.d(Logger.LAYOUT_TAG, "AdaRootView onSizeChanged", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    protected AdaRootView(Context context, FrameLayout frameLayout) {
        super(context);
        this.mMyRootView = null;
        if (frameLayout != null) {
            this.mMyRootView = frameLayout;
        } else {
            this.mMyRootView = new MyRootView(context, this);
        }
        setMainView(this.mMyRootView);
    }
}
