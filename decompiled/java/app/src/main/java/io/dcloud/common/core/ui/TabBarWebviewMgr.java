package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class TabBarWebviewMgr {
    private static TabBarWebviewMgr mInstance;
    private TabBarWebview mLaunchTabBar;

    public static TabBarWebviewMgr getInstance() {
        if (mInstance == null) {
            mInstance = new TabBarWebviewMgr();
        }
        return mInstance;
    }

    public TabBarWebview getLaunchTabBar() {
        return this.mLaunchTabBar;
    }

    public void setLancheTabBar(TabBarWebview tabBarWebview) {
        this.mLaunchTabBar = tabBarWebview;
    }
}
