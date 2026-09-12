package io.dcloud.p;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import io.dcloud.sdk.core.DCloudAOLManager;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t3 extends DCloudAOLManager {
    public static void a(Context context, DCloudAOLManager.InitConfig initConfig, t1 t1Var) {
        if (context == null || initConfig == null) {
            throw new NullPointerException("context or config is null");
        }
        if (((context instanceof Activity) || (context instanceof Application)) && !DCloudAOLManager.c.get()) {
            DCloudAOLManager.c.set(true);
            if (DCloudAOLManager.b == null) {
                r0 r0VarD = r0.d();
                r0VarD.b(context);
                r0VarD.a(initConfig);
                r0VarD.a(t1Var);
                DCloudAOLManager.b = r0VarD;
                r0VarD.e();
                r0VarD.a(context);
            }
        }
    }

    public static boolean a() {
        return e.b().c().size() > 1;
    }
}
