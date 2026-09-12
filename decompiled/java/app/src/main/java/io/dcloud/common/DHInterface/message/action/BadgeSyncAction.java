package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class BadgeSyncAction implements IAction {
    private ENUM_ACTION_TYPE mActionType;
    public int syncNumVal;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public enum ENUM_ACTION_TYPE {
        SYNC_NUM
    }

    private BadgeSyncAction(ENUM_ACTION_TYPE enum_action_type) {
        this.mActionType = enum_action_type;
    }

    public static BadgeSyncAction obtain(ENUM_ACTION_TYPE enum_action_type) {
        return new BadgeSyncAction(enum_action_type);
    }

    public ENUM_ACTION_TYPE getActionType() {
        return this.mActionType;
    }

    public int getSyncNumVal() {
        return this.syncNumVal;
    }

    public BadgeSyncAction setSyncNum(int i) {
        this.syncNumVal = i;
        return this;
    }
}
