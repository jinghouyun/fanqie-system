package io.dcloud.api.custom.type.splash;

import android.view.ViewGroup;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomSplashLoader extends UniAdCustomBaseLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess(List<? extends UniAdCustomNativeAd> list) {
        onLoadSuccess();
    }

    public abstract void show(ViewGroup viewGroup);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((ViewGroup) obj);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess() {
        super.onLoadSuccess();
    }
}
