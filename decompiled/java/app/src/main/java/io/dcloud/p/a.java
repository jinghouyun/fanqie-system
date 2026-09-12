package io.dcloud.p;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static boolean a(View view) {
        return view != null && view.getVisibility() == 0 && view.isShown() && view.getWindowVisibility() == 0;
    }
}
