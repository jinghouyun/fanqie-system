package io.dcloud.sdk.core.v3.pv;

import android.app.Activity;
import io.dcloud.p.k1;
import io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCPreVideoLoader extends DCFeedAOLLoader {
    public DCPreVideoLoader(Activity activity) {
        super(activity);
    }

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader
    public void initLoader() {
        if (this.b == null) {
            this.b = new k1(getContext(), 5);
        }
    }
}
