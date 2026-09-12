package io.dcloud.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import io.dcloud.common.DHInterface.message.ActionBus;
import io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction;
import io.dcloud.common.DHInterface.message.action.AppOnCreateAction;
import io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction;
import io.dcloud.common.adapter.util.Logger;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DCloudApplication extends Application {
    private final String TAG = "DCloudApplication";

    public void addActivityStatusListener(DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        DCLoudApplicationImpl.self().addActivityStatusListener(activityStatusListener);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        DCLoudApplicationImpl.self().attachBaseContext(context);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBus.getInstance().sendToBus(AppOnConfigChangedAction.obtain(configuration));
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        DCLoudApplicationImpl.self().onCreate(this);
        ActionBus.getInstance().sendToBus(AppOnCreateAction.obtain());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Logger.e(this.TAG, "onLowMemory" + Runtime.getRuntime().maxMemory());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        ActionBus.getInstance().sendToBus(AppOnTrimMemoryAction.obtain(i));
    }

    public void removeActivityStatusListener(DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        DCLoudApplicationImpl.self().removeActivityStatusListener(activityStatusListener);
    }

    public void stopB2FOnce() {
        DCLoudApplicationImpl.self().stopActivityStatusListener();
    }
}
