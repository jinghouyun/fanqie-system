package io.dcloud.feature.weex_barcode;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.dcloud.zxing2.BarcodeFormat;
import com.dcloud.zxing2.Result;
import com.hjq.permissions.Permission;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXImage;
import io.dcloud.base.R;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.ThreadPool;
import io.dcloud.feature.barcode2.camera.CameraManager;
import io.dcloud.feature.barcode2.decoding.CaptureActivityHandler;
import io.dcloud.feature.barcode2.decoding.IBarHandler;
import io.dcloud.feature.barcode2.decoding.InactivityTimer;
import io.dcloud.feature.barcode2.view.DetectorViewConfig;
import io.dcloud.feature.barcode2.view.ViewfinderView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class BarcodeView extends AbsoluteLayout implements IBarHandler, TextureView.SurfaceTextureListener {
    static final int AZTEC = 3;
    private static final float BEEP_VOLUME = 0.8f;
    static final int CODABAR = 7;
    static final int CODE128 = 10;
    static final int CODE39 = 8;
    static final int CODE93 = 9;
    static final int DATAMATRIX = 4;
    static final int EAN13 = 1;
    static final int EAN8 = 2;
    private static final int ID_ADD_VIEW = 201;
    private static final int ID_START_SCAN = 203;
    private static final int ID_UPDATE_VIEW = 202;
    static final int ITF = 11;
    static final int MAXICODE = 12;
    static final int PDF417 = 13;
    static final int QR = 0;
    static final int RSS14 = 14;
    static final int RSSEXPANDED = 15;
    static final int UNKOWN = -1000;
    static final int UPCA = 5;
    static final int UPCE = 6;
    private static final long VIBRATE_DURATION = 200;
    public boolean autoDecodeCharset;
    private final MediaPlayer.OnCompletionListener beepListener;
    private String characterSet;
    private WXComponent component;
    private Context context;
    private Vector<BarcodeFormat> decodeFormats;
    public String errorMsg;
    private CaptureActivityHandler handler;
    private boolean hasSurface;
    private InactivityTimer inactivityTimer;
    private boolean isCancelScan;
    private boolean isSurfaceAvaliable;
    private boolean isVerticalScreen;
    private Bitmap lastBiptmap;
    private boolean mConserve;
    private String mFilename;
    Handler mHandler;
    private WXSDKInstance mInstance;
    int mOrientationState;
    private boolean mRunning;
    private MediaPlayer mediaPlayer;
    private boolean nopermission;
    private boolean playBeep;
    private TextureView surfaceView;
    private boolean vibrate;
    private int viewHeight;
    private int viewWidth;
    private ViewfinderView viewfinderView;

    /* JADX WARN: Code duplicated, block: B:12:0x0081  */
    public BarcodeView(Context context, WXComponent wXComponent, WXSDKInstance wXSDKInstance) {
        super(context);
        this.hasSurface = false;
        this.errorMsg = null;
        this.mConserve = false;
        this.isSurfaceAvaliable = false;
        this.isVerticalScreen = false;
        this.autoDecodeCharset = false;
        this.mHandler = new Handler() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 201) {
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) message.obj;
                    if (BarcodeView.this.surfaceView != null) {
                        if (BarcodeView.this.surfaceView.getParent() != null) {
                            ((ViewGroup) BarcodeView.this.surfaceView.getParent()).removeView(BarcodeView.this.surfaceView);
                        }
                        BarcodeView barcodeView = BarcodeView.this;
                        barcodeView.addView(barcodeView.surfaceView, layoutParams);
                    }
                    BarcodeView barcodeView2 = BarcodeView.this;
                    barcodeView2.addView(barcodeView2.viewfinderView);
                    return;
                }
                if (i == BarcodeView.ID_UPDATE_VIEW) {
                    if (BarcodeView.this.surfaceView == null || BarcodeView.this.surfaceView.getParent() == null) {
                        return;
                    }
                    BarcodeView.this.surfaceView.setLayoutParams((AbsoluteLayout.LayoutParams) message.obj);
                    BarcodeView.this.viewfinderView.drawViewfinder();
                    return;
                }
                if (i != BarcodeView.ID_START_SCAN || BarcodeView.this.surfaceView == null || BarcodeView.this.surfaceView.getParent() == null) {
                    return;
                }
                BarcodeView.this.surfaceView.setLayoutParams((AbsoluteLayout.LayoutParams) message.obj);
                BarcodeView.this.viewfinderView.drawViewfinder();
                BarcodeView.this.startP();
            }
        };
        this.isCancelScan = false;
        this.mRunning = false;
        this.beepListener = new MediaPlayer.OnCompletionListener() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
            }
        };
        this.component = wXComponent;
        this.mInstance = wXSDKInstance;
        this.surfaceView = new TextureView(context);
        this.viewfinderView = new ViewfinderView(context, this);
        Activity activity = (Activity) context;
        this.inactivityTimer = new InactivityTimer(activity);
        this.context = context;
        saveOrientationState();
        CameraManager.init(this.context, false);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            ((Activity) this.context).setRequestedOrientation(7);
            CameraManager.init(context, true);
            this.isVerticalScreen = true;
        } else if (rotation == 1) {
            CameraManager.get().setHorizontalOrientation(false);
            ((Activity) this.context).setRequestedOrientation(0);
        } else if (rotation == 2) {
            ((Activity) this.context).setRequestedOrientation(7);
            CameraManager.init(context, true);
            this.isVerticalScreen = true;
        } else if (rotation == 3) {
            CameraManager.get().setHorizontalOrientation(true);
            ((Activity) this.context).setRequestedOrientation(8);
        }
        onResume(false);
        this.hasSurface = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBarcodeView() {
        AbsoluteLayout.LayoutParams layoutParams = setLayoutParams();
        if (layoutParams == null) {
            return;
        }
        Message message = new Message();
        message.what = 201;
        message.obj = layoutParams;
        this.mHandler.sendMessage(message);
    }

    private Bitmap byte2bitmap(byte[] bArr, Camera camera) {
        Exception exc;
        Bitmap bitmap = null;
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            YuvImage yuvImage = new YuvImage(bArr, 17, previewSize.width, previewSize.height, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 80, byteArrayOutputStream);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            try {
                byteArrayOutputStream.close();
                Matrix matrix = new Matrix();
                matrix.postRotate(90.0f);
                return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
            } catch (Exception e) {
                exc = e;
                bitmap = bitmapDecodeByteArray;
                exc.printStackTrace();
                return bitmap;
            }
        } catch (Exception e2) {
            exc = e2;
        }
    }

    private void cancel() {
        if (this.mRunning) {
            CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.stopDecode();
            }
            getViewfinderView().stopUpdateScreenTimer();
            this.mRunning = false;
        }
    }

    private BarcodeFormat convertNumToBarcodeFormat(int i) {
        switch (i) {
            case 0:
                return BarcodeFormat.QR_CODE;
            case 1:
                return BarcodeFormat.EAN_13;
            case 2:
                return BarcodeFormat.EAN_8;
            case 3:
                return BarcodeFormat.AZTEC;
            case 4:
                return BarcodeFormat.DATA_MATRIX;
            case 5:
                return BarcodeFormat.UPC_A;
            case 6:
                return BarcodeFormat.UPC_E;
            case 7:
                return BarcodeFormat.CODABAR;
            case 8:
                return BarcodeFormat.CODE_39;
            case 9:
                return BarcodeFormat.CODE_93;
            case 10:
                return BarcodeFormat.CODE_128;
            case 11:
                return BarcodeFormat.ITF;
            case 12:
                return BarcodeFormat.MAXICODE;
            case 13:
                return BarcodeFormat.PDF_417;
            case 14:
                return BarcodeFormat.RSS_14;
            case 15:
                return BarcodeFormat.RSS_EXPANDED;
            default:
                return null;
        }
    }

    private int convertTypestrToNum(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == BarcodeFormat.QR_CODE) {
            return 0;
        }
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return 1;
        }
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return 2;
        }
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return 3;
        }
        if (barcodeFormat == BarcodeFormat.DATA_MATRIX) {
            return 4;
        }
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return 5;
        }
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return 6;
        }
        if (barcodeFormat == BarcodeFormat.CODABAR) {
            return 7;
        }
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return 8;
        }
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return 9;
        }
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return 10;
        }
        if (barcodeFormat == BarcodeFormat.ITF) {
            return 11;
        }
        if (barcodeFormat == BarcodeFormat.MAXICODE) {
            return 12;
        }
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            return 13;
        }
        if (barcodeFormat == BarcodeFormat.RSS_14) {
            return 14;
        }
        return barcodeFormat == BarcodeFormat.RSS_EXPANDED ? 15 : -1000;
    }

    private void fireEvent(String str, Map<String, Object> map) {
        if (this.component.containsEvent(str)) {
            HashMap map2 = new HashMap();
            map2.put("detail", map);
            this.component.fireEvent(str, map2);
        }
    }

    private void initBeepSound() {
        if (this.mediaPlayer == null) {
            ((Activity) this.context).setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.context.getResources().getAssets().openFd(AbsoluteConst.RES_BEEP);
                this.mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                this.mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                this.mediaPlayer.prepare();
            } catch (IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void initCamera() {
        try {
            CameraManager.get().openDriver(this.surfaceView.getSurfaceTexture());
            CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.resume();
                return;
            }
            CaptureActivityHandler captureActivityHandler2 = new CaptureActivityHandler(this, this.decodeFormats, this.characterSet, this.autoDecodeCharset);
            this.handler = captureActivityHandler2;
            if (this.mRunning) {
                captureActivityHandler2.restartPreviewAndDecode();
            }
        } catch (IOException e) {
            this.errorMsg = e.getMessage();
        }
    }

    private void playBeepSoundAndVibrate() {
        MediaPlayer mediaPlayer;
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            try {
                ((Vibrator) this.context.getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void resumeOrientationState() {
        ((Activity) this.context).setRequestedOrientation(this.mOrientationState);
    }

    private void saveOrientationState() {
        this.mOrientationState = ((Activity) this.context).getRequestedOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsoluteLayout.LayoutParams setLayoutParams() {
        int i;
        int i2;
        int i3;
        CameraManager.sScreenWidth = this.context.getResources().getDisplayMetrics().widthPixels;
        CameraManager.sScreenAllHeight = this.context.getResources().getDisplayMetrics().heightPixels;
        Rect rect = DetectorViewConfig.getInstance().gatherRect;
        int i4 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = this.viewWidth;
        rect.bottom = this.viewHeight;
        Point cr = this.isVerticalScreen ? CameraManager.getCR(rect.height(), rect.width()) : CameraManager.getCR(rect.width(), rect.height());
        if (cr == null) {
            cr = new Point(this.viewWidth, this.viewHeight);
        }
        if (this.isVerticalScreen) {
            i = this.viewWidth;
            int i5 = cr.x;
            int i6 = cr.y;
            int i7 = (i * i5) / i6;
            int i8 = this.viewHeight;
            if (i7 < i8) {
                int i9 = (i6 * i8) / i5;
                int i10 = (i - i9) / 2;
                DetectorViewConfig.detectorRectOffestLeft = i10;
                DetectorViewConfig.detectorRectOffestTop = 0;
                i4 = i10;
                i3 = 0;
                i = i9;
                i2 = i8;
            } else {
                int i11 = (i8 - i7) / 2;
                DetectorViewConfig.detectorRectOffestTop = i11;
                DetectorViewConfig.detectorRectOffestLeft = 0;
                i2 = i7;
                i3 = i11;
            }
        } else {
            int i12 = this.viewHeight;
            int i13 = cr.x;
            int i14 = cr.y;
            int i15 = (i12 * i13) / i14;
            int i16 = this.viewWidth;
            if (i15 < i16) {
                i2 = (i14 * i16) / i13;
                i3 = (i12 - i2) / 2;
                DetectorViewConfig.detectorRectOffestTop = i3;
                DetectorViewConfig.detectorRectOffestLeft = 0;
                i = i16;
            } else {
                int i17 = (i16 - i15) / 2;
                DetectorViewConfig.detectorRectOffestLeft = i17;
                DetectorViewConfig.detectorRectOffestTop = 0;
                i = i15;
                i2 = i12;
                i4 = i17;
                i3 = 0;
            }
        }
        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(i, i2, i4, i3);
        DetectorViewConfig.getInstance().initSurfaceViewRect(i4, i3, i, i2);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startP() {
        initCamera();
        if (this.decodeFormats == null) {
            initDecodeFormats(null);
        }
        if (!TextUtils.isEmpty(this.errorMsg)) {
            HashMap map = new HashMap();
            map.put("code", 8);
            map.put("message", this.errorMsg);
            map.put("type", Constants.Event.FAIL);
            fireEvent("error", map);
            return;
        }
        if (this.mRunning) {
            return;
        }
        getViewfinderView().startUpdateScreenTimer();
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.restartPreviewAndDecode();
        } else {
            onResume(false);
        }
        if (this.isCancelScan) {
            this.surfaceView.setBackgroundDrawable(null);
            Bitmap bitmap = this.lastBiptmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.lastBiptmap.recycle();
                this.lastBiptmap = null;
            }
            CameraManager.get().clearLastBitmapData();
            this.surfaceView.postInvalidate();
            initCamera();
        }
        this.mRunning = true;
        this.isCancelScan = false;
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void autoFocus() {
        this.handler.autoFocus();
    }

    public void cancelScan() {
        if (this.mRunning) {
            CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.quitSynchronously();
                this.handler = null;
            }
            getViewfinderView().stopUpdateScreenTimer();
            CameraManager.get().removeAutoFocus();
            CameraManager.get().stopPreview();
            byte[] lastBitmapData = CameraManager.get().getLastBitmapData();
            Camera cameraHandler = CameraManager.get().getCameraHandler();
            if (lastBitmapData != null && cameraHandler != null) {
                this.lastBiptmap = byte2bitmap(lastBitmapData, cameraHandler);
            }
            CameraManager.get().closeDriver();
            this.mRunning = false;
            this.isCancelScan = true;
        }
    }

    public void closeScan() {
        onPause();
        CameraManager.get().closeDriver();
        DetectorViewConfig.clearData();
        this.surfaceView = null;
        Bitmap bitmap = this.lastBiptmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.lastBiptmap.recycle();
            this.lastBiptmap = null;
        }
        CameraManager.get().clearLastBitmapData();
        System.gc();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    @Override // android.view.View, io.dcloud.feature.barcode2.decoding.IBarHandler
    public Handler getHandler() {
        return this.handler;
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void handleDecode(Result result, Bitmap bitmap) {
        boolean zSaveBitmapToFile;
        String path;
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        if (this.mConserve) {
            if (!PdrUtil.isEmpty(this.mFilename) && !PdrUtil.isDeviceRootDir(this.mFilename) && !this.mFilename.startsWith(BaseInfo.REL_PRIVATE_DOC_DIR)) {
                this.mFilename = BaseInfo.REL_PRIVATE_DOC_DIR + this.mFilename;
            }
            path = this.mInstance.rewriteUri(Uri.parse(this.mFilename), "image").getPath();
            zSaveBitmapToFile = PdrUtil.saveBitmapToFile(bitmap, path);
        } else {
            zSaveBitmapToFile = false;
            path = null;
        }
        int iConvertTypestrToNum = convertTypestrToNum(result.getBarcodeFormat());
        Map<String, Object> map = new HashMap<>();
        map.put("code", Integer.valueOf(iConvertTypestrToNum));
        map.put("message", result.getText());
        if (zSaveBitmapToFile && !PdrUtil.isEmpty(path)) {
            map.put("file", path);
        }
        map.put("type", WXImage.SUCCEED);
        map.put("charSet", result.textCharset);
        fireEvent("marked", map);
        cancelScan();
    }

    public void initBarcodeView(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
        ThreadPool.self().addThreadTask(new Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.2
            @Override // java.lang.Runnable
            public void run() {
                BarcodeView.this.addBarcodeView();
            }
        });
    }

    public void initDecodeFormats(JSONArray jSONArray) {
        int iIntValue;
        this.decodeFormats = new Vector<>();
        if (jSONArray == null || jSONArray.size() == 0) {
            this.decodeFormats.add(BarcodeFormat.EAN_13);
            this.decodeFormats.add(BarcodeFormat.EAN_8);
            this.decodeFormats.add(BarcodeFormat.QR_CODE);
            return;
        }
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            try {
                iIntValue = jSONArray.getInteger(i).intValue();
            } catch (JSONException e) {
                e.printStackTrace();
                iIntValue = -1;
            }
            if (iIntValue != -1) {
                this.decodeFormats.add(convertNumToBarcodeFormat(iIntValue));
            }
        }
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public boolean isRunning() {
        return this.mRunning;
    }

    public void onDestory() {
        resumeOrientationState();
        this.inactivityTimer.shutdown();
        this.hasSurface = false;
        this.decodeFormats = null;
        this.characterSet = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String language;
        super.onDraw(canvas);
        if (this.nopermission) {
            TextPaint textPaint = new TextPaint();
            textPaint.setColor(-1);
            textPaint.setTextSize(PdrUtil.pxFromDp(18.0f, this.context.getResources().getDisplayMetrics()));
            textPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int i = (int) (((this.viewHeight / 2.0f) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f));
            int i2 = this.viewWidth / 2;
            if (Build.VERSION.SDK_INT >= 24) {
                language = getResources().getConfiguration().getLocales().get(0).getLanguage();
                getResources().getConfiguration().getLocales().get(0).getScript();
            } else {
                language = getResources().getConfiguration().locale.getLanguage();
                getResources().getConfiguration().getLocales().get(0).getScript();
            }
            String string = getResources().getString(R.string.dcloud_scan_no_permission_text);
            if (language.equalsIgnoreCase("ja")) {
                canvas.drawText("カメラ権限がありません", i2, i, textPaint);
            } else if (language.equalsIgnoreCase("ru")) {
                canvas.drawText("Требуется разрешение камеры.", i2, i, textPaint);
            } else {
                canvas.drawText(string, i2, i, textPaint);
            }
        }
    }

    public void onPause() {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        if (!this.nopermission) {
            CameraManager.get().closeDriver();
        }
        boolean z = this.mRunning;
        cancel();
        this.mRunning = z;
    }

    public void onResume(boolean z) {
        if (this.lastBiptmap != null && this.isCancelScan && z) {
            this.surfaceView.setBackgroundDrawable(new BitmapDrawable(this.context.getResources(), this.lastBiptmap));
        }
        if (!this.hasSurface) {
            this.surfaceView.setSurfaceTextureListener(this);
        }
        if (((AudioManager) this.context.getSystemService("audio")).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        if (z && this.mRunning) {
            this.mRunning = false;
            start();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.isSurfaceAvaliable = true;
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.hasSurface = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setAutoDecodeCharset(boolean z) {
        this.autoDecodeCharset = z;
    }

    public void setAutoZoom(boolean z) {
        CaptureActivityHandler.isAutoZoom = z;
    }

    public void setBackground(int i) {
        if (i == -1) {
            i = DetectorViewConfig.laserColor;
        }
        setBackgroundColor(i);
    }

    public void setConserve(boolean z) {
        this.mConserve = z;
    }

    public void setFilename(String str) {
        this.mFilename = str;
    }

    public void setFlash(boolean z) {
        CameraManager.get().setFlashlight(z);
    }

    public void setFrameColor(int i) {
        if (i == -1) {
            i = DetectorViewConfig.laserColor;
        }
        DetectorViewConfig.cornerColor = i;
    }

    public void setPlayBeep(boolean z) {
        this.playBeep = z;
    }

    public void setScanBarColor(int i) {
        if (i == -1) {
            i = DetectorViewConfig.laserColor;
        }
        DetectorViewConfig.laserColor = i;
    }

    public void setVibrate(boolean z) {
        this.vibrate = z;
    }

    public void start() {
        PermissionUtil.useSystemPermissions((Activity) this.context, new String[]{Permission.CAMERA}, new PermissionUtil.Request() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.4
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(String str) {
                BarcodeView.this.nopermission = true;
                BarcodeView.this.setBackground(-16777216);
                BarcodeView.this.invalidate();
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(String str) {
                BarcodeView.this.postDelayed(new Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!BarcodeView.this.isSurfaceAvaliable) {
                            BarcodeView.this.postDelayed(this, 100L);
                            return;
                        }
                        AbsoluteLayout.LayoutParams layoutParams = BarcodeView.this.setLayoutParams();
                        if (layoutParams == null) {
                            return;
                        }
                        Message message = new Message();
                        message.what = BarcodeView.ID_START_SCAN;
                        message.obj = layoutParams;
                        BarcodeView.this.mHandler.sendMessage(message);
                    }
                }, BarcodeView.this.isSurfaceAvaliable ? 0L : BarcodeView.VIBRATE_DURATION);
            }
        });
    }

    public void updateStyles(int i, int i2) {
        if (this.viewHeight == i2 && this.viewWidth == i) {
            return;
        }
        this.viewWidth = i;
        this.viewHeight = i2;
        ThreadPool.self().addThreadTask(new Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.3
            @Override // java.lang.Runnable
            public void run() {
                AbsoluteLayout.LayoutParams layoutParams = BarcodeView.this.setLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                Message message = new Message();
                message.what = BarcodeView.ID_UPDATE_VIEW;
                message.obj = layoutParams;
                BarcodeView.this.mHandler.sendMessage(message);
            }
        });
    }
}
