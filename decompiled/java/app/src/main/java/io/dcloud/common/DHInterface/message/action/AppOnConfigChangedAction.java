package io.dcloud.common.DHInterface.message.action;

import android.content.res.Configuration;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AppOnConfigChangedAction implements IAction {
    private Configuration newConfig;

    public AppOnConfigChangedAction(Configuration configuration) {
        this.newConfig = configuration;
    }

    public static AppOnConfigChangedAction obtain(Configuration configuration) {
        return new AppOnConfigChangedAction(configuration);
    }

    public Configuration getConfig() {
        return this.newConfig;
    }
}
