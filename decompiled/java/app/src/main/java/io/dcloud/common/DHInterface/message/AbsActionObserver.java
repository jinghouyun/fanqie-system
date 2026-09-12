package io.dcloud.common.DHInterface.message;

import io.dcloud.common.DHInterface.message.action.IAction;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsActionObserver {
    IObserveAble observeAble;

    public AbsActionObserver(IObserveAble iObserveAble) {
        this.observeAble = iObserveAble;
    }

    public EnumUniqueID getObserverUniqueID() {
        return this.observeAble.getActionObserverID();
    }

    public abstract boolean handleMessage(IAction iAction);
}
