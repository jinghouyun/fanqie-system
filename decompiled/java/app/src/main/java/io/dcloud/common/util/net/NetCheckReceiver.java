package io.dcloud.common.util.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.ISysEventListener;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class NetCheckReceiver extends BroadcastReceiver {
    public static final String netACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String simACTION = "android.intent.action.SIM_STATE_CHANGED";
    AbsMgr mNetMgr;

    NetCheckReceiver(AbsMgr absMgr) {
        this.mNetMgr = absMgr;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equals(netACTION)) {
                this.mNetMgr.processEvent(IMgr.MgrType.AppMgr, 1, new Object[]{ISysEventListener.SysEventType.onDeviceNetChanged, null, null});
            } else if (action.equals(simACTION)) {
                this.mNetMgr.processEvent(IMgr.MgrType.AppMgr, 1, new Object[]{ISysEventListener.SysEventType.onSimStateChanged, null, null});
            }
        }
    }
}
