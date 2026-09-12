package io.dcloud.common.DHInterface;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IBoot extends ISysEventListener {
    void onPause();

    void onRestart(Context context);

    void onResume();

    void onStart(Context context, Bundle bundle, String[] strArr);

    void onStop();
}
