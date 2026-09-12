package io.dcloud.feature.barcode2.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import io.dcloud.feature.barcode2.decoding.CaptureActivityHandler;
import io.dcloud.feature.barcode2.decoding.IBarHandler;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
final class PreviewCallback implements Camera.PreviewCallback {
    private static final String TAG = "PreviewCallback";
    private static boolean mIsVerticalScreen = true;
    private final CameraConfigurationManager configManager;
    private byte[] lastBitmapData = null;
    private IBarHandler mBarHandler;
    private Handler previewHandler;
    private int previewMessage;
    private final boolean useOneShotPreviewCallback;

    PreviewCallback(CameraConfigurationManager cameraConfigurationManager, boolean z) {
        this.configManager = cameraConfigurationManager;
        this.useOneShotPreviewCallback = z;
    }

    public byte[] getLastBitmapData() {
        return this.lastBitmapData;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Message messageObtainMessage;
        IBarHandler iBarHandler = this.mBarHandler;
        if (iBarHandler == null || !iBarHandler.isRunning()) {
            return;
        }
        Point cameraResolution = this.configManager.getCameraResolution();
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.previewHandler;
        if (handler != null) {
            int i = this.previewMessage;
            if (i == 1004) {
                messageObtainMessage = mIsVerticalScreen ? handler.obtainMessage(CaptureActivityHandler.CODE_DECODE_portrait, cameraResolution.x, cameraResolution.y, bArr) : handler.obtainMessage(1006, cameraResolution.x, cameraResolution.y, bArr);
            } else {
                messageObtainMessage = handler.obtainMessage(i, cameraResolution.x, cameraResolution.y, bArr);
            }
            messageObtainMessage.sendToTarget();
            this.previewHandler = null;
        } else {
            Log.d(TAG, "Got preview callback, but no handler for it");
        }
        this.lastBitmapData = bArr;
    }

    void setHandler(IBarHandler iBarHandler, Handler handler, int i, boolean z) {
        this.mBarHandler = iBarHandler;
        this.previewHandler = handler;
        this.previewMessage = i;
        mIsVerticalScreen = z;
    }

    public void setLastBitmapData(byte[] bArr) {
        this.lastBitmapData = bArr;
    }
}
