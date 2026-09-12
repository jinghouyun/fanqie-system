package io.dcloud.p;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface q2 {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface a {
        void a(View view);

        boolean b(View view);

        void c(View view);
    }

    void a(Canvas canvas);

    void a(a aVar);

    boolean a();

    void b(a aVar);

    boolean b();

    boolean dismiss();

    RectF getFrame();
}
