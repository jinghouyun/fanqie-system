package io.dcloud.p;

import android.app.Application;
import io.dcloud.common.DHInterface.IConfusionMgr;
import io.dcloud.common.DHInterface.INativeAppInfo;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class i3 implements INativeAppInfo {
    private IConfusionMgr a;
    private SoftReference b;

    public i3(Application application) {
        a(application);
        a(this.a);
    }

    private void a(Application application) {
        this.b = new SoftReference(application);
    }

    @Override // io.dcloud.common.DHInterface.INativeAppInfo
    public Application getApplication() {
        SoftReference softReference = this.b;
        if (softReference != null) {
            return (Application) softReference.get();
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.INativeAppInfo
    public IConfusionMgr getCofusionMgr() {
        return this.a;
    }

    private void a(IConfusionMgr iConfusionMgr) {
        if (iConfusionMgr == null) {
            iConfusionMgr = i0.c();
        }
        this.a = iConfusionMgr;
    }
}
