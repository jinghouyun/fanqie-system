package io.dcloud.common.DHInterface;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMgr implements IMgr {
    protected Context mContextWrapper;
    protected ICore mCore;
    protected boolean mIsStreamAppMode = false;
    protected String mMgrName;
    protected IMgr.MgrType mMgrType;

    protected AbsMgr(ICore iCore, String str, IMgr.MgrType mgrType) {
        this.mContextWrapper = null;
        this.mCore = iCore;
        this.mMgrName = str;
        this.mMgrType = mgrType;
        this.mContextWrapper = iCore.obtainContext();
    }

    public final boolean checkMgrId(IMgr.MgrType mgrType) {
        return this.mMgrType == mgrType;
    }

    public void dispose() {
    }

    public final Context getContext() {
        return this.mContextWrapper;
    }

    public final boolean isStreamAppMode() {
        return this.mIsStreamAppMode;
    }

    public void onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
    }
}
