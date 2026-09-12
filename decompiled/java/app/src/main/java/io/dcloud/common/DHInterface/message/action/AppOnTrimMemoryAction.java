package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AppOnTrimMemoryAction implements IAction {
    private int level;

    public AppOnTrimMemoryAction(int i) {
        this.level = i;
    }

    public static AppOnTrimMemoryAction obtain(int i) {
        return new AppOnTrimMemoryAction(i);
    }

    public int getLevel() {
        return this.level;
    }
}
