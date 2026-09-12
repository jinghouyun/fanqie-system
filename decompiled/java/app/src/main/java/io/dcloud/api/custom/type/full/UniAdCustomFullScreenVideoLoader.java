package io.dcloud.api.custom.type.full;

import android.app.Activity;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomFullScreenVideoLoader extends UniAdCustomBaseLoader {
    public abstract void show(Activity activity);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((Activity) obj);
    }
}
