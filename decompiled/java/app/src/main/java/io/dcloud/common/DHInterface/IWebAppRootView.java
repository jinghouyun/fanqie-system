package io.dcloud.common.DHInterface;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IWebAppRootView {
    boolean didCloseSplash();

    IFrameView findFrameViewB(IFrameView iFrameView);

    void goHome(IFrameView iFrameView);

    View obtainMainView();

    void onAppActive(IApp iApp);

    void onAppStart(IApp iApp);

    void onAppStop(IApp iApp);

    void onAppUnActive(IApp iApp);

    void onRootViewGlobalLayout(View view);
}
