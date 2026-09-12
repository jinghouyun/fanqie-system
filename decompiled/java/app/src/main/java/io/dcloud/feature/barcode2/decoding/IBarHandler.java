package io.dcloud.feature.barcode2.decoding;

import android.graphics.Bitmap;
import android.os.Handler;
import com.dcloud.zxing2.Result;
import io.dcloud.feature.barcode2.view.ViewfinderView;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IBarHandler {
    void autoFocus();

    void drawViewfinder();

    Handler getHandler();

    ViewfinderView getViewfinderView();

    void handleDecode(Result result, Bitmap bitmap);

    boolean isRunning();
}
