package io.dcloud.feature.barcode2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import com.dcloud.zxing2.ResultPoint;
import io.dcloud.feature.barcode2.decoding.IBarHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewfinderView extends View {
    private static final long ANIMATION_DELAY = 100;
    private static final int OPAQUE = 255;
    IBarHandler barHandler;
    ShapeDrawable laserBitmap;
    int laserY;
    private Collection<ResultPoint> lastPossibleResultPoints;
    private Rect lastRect;
    Timer mUpdateProgressBar;
    private final Paint paint;
    private Collection<ResultPoint> possibleResultPoints;
    private boolean running;

    public ViewfinderView(Context context, IBarHandler iBarHandler) {
        super(context);
        this.barHandler = null;
        this.lastRect = null;
        this.laserBitmap = null;
        this.laserY = -DetectorViewConfig.LASER_WIDTH;
        this.mUpdateProgressBar = null;
        this.running = false;
        this.barHandler = iBarHandler;
        this.paint = new Paint();
        getResources();
        this.possibleResultPoints = new HashSet(5);
    }

    private void drawDetectorCorner(Canvas canvas, Rect rect) {
        this.paint.setColor(DetectorViewConfig.cornerColor);
        int i = DetectorViewConfig.CORNER_WIDTH / 2;
        int i2 = DetectorViewConfig.CORNER_HEIGHT;
        int i3 = rect.left;
        int i4 = rect.top;
        canvas.drawRect(i3 - i, i4 - i, i3 + i2, i4 + i, this.paint);
        int i5 = rect.left;
        int i6 = rect.top;
        canvas.drawRect(i5 - i, i6, i5 + i, i6 + i2, this.paint);
        int i7 = rect.right;
        int i8 = rect.top;
        canvas.drawRect(i7 - i2, i8 - i, i7 + i, i8 + i, this.paint);
        int i9 = rect.right;
        int i10 = rect.top;
        canvas.drawRect(i9 - i, i10, i9 + i, i10 + i2, this.paint);
        int i11 = rect.left;
        int i12 = rect.bottom;
        canvas.drawRect(i11 - i, i12 - i2, i11 + i, i12, this.paint);
        int i13 = rect.left;
        int i14 = rect.bottom;
        canvas.drawRect(i13 - i, i14 - i, i13 + i2, i14 + i, this.paint);
        int i15 = rect.right;
        int i16 = rect.bottom;
        canvas.drawRect(i15 - i2, i16 - i, i15 + i, i16 + i, this.paint);
        int i17 = rect.right;
        int i18 = rect.bottom;
        canvas.drawRect(i17 - i, i18 - i2, i17 + i, i18 + i, this.paint);
    }

    private void drawLaserLine(Canvas canvas, Rect rect) {
        if (this.laserBitmap == null) {
            this.laserBitmap = new ShapeDrawable(new OvalShape());
            float fWidth = rect.width() / 2;
            float f = DetectorViewConfig.LASER_WIDTH / 2;
            int i = DetectorViewConfig.laserColor;
            this.laserBitmap.getPaint().setShader(new RadialGradient(fWidth, f, 240.0f, i, i & 16777215, Shader.TileMode.CLAMP));
        }
        this.paint.setAntiAlias(true);
        ShapeDrawable shapeDrawable = this.laserBitmap;
        int i2 = rect.left;
        shapeDrawable.setBounds(i2, this.laserY, rect.width() + i2, this.laserY + DetectorViewConfig.LASER_WIDTH);
        this.laserBitmap.draw(canvas);
        this.paint.setShader(null);
    }

    private void drawNonDetectorArea(Canvas canvas, Rect rect, Rect rect2) {
        this.paint.setColor(DetectorViewConfig.maskColor);
        canvas.drawRect(0.0f, 0.0f, rect2.right, rect.top, this.paint);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.paint);
        canvas.drawRect(rect.right, rect.top, rect2.right, rect.bottom, this.paint);
        canvas.drawRect(0.0f, rect.bottom, rect2.right, rect2.bottom, this.paint);
    }

    private void drawResultPoint(Canvas canvas, Rect rect) {
        Collection<ResultPoint> collection = this.possibleResultPoints;
        Collection<ResultPoint> collection2 = this.lastPossibleResultPoints;
        if (collection.isEmpty()) {
            this.lastPossibleResultPoints = null;
        } else {
            this.possibleResultPoints = new HashSet(5);
            this.lastPossibleResultPoints = collection;
            this.paint.setAlpha(255);
            this.paint.setColor(DetectorViewConfig.resultPointColor);
            for (ResultPoint resultPoint : collection) {
                canvas.drawCircle(rect.left + resultPoint.getX(), rect.top + resultPoint.getY(), 6.0f, this.paint);
            }
        }
        if (collection2 != null) {
            this.paint.setAlpha(WorkQueueKt.MASK);
            this.paint.setColor(DetectorViewConfig.resultPointColor);
            for (ResultPoint resultPoint2 : collection2) {
                canvas.drawCircle(rect.left + resultPoint2.getX(), rect.top + resultPoint2.getY(), 3.0f, this.paint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreen() {
        Rect detectorRect = DetectorViewConfig.getInstance().getDetectorRect();
        int i = this.laserY;
        if (i > detectorRect.bottom) {
            this.laserY = detectorRect.top;
        } else {
            this.laserY = i + 1;
        }
        postInvalidate();
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }

    public void drawViewfinder() {
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect detectorRect = DetectorViewConfig.getInstance().getDetectorRect();
        Rect rect = DetectorViewConfig.getInstance().gatherRect;
        if (detectorRect == null) {
            return;
        }
        drawNonDetectorArea(canvas, detectorRect, rect);
        drawDetectorCorner(canvas, detectorRect);
        if (this.running) {
            drawLaserLine(canvas, detectorRect);
        } else {
            this.lastRect = detectorRect;
            drawLaserLine(canvas, detectorRect);
        }
    }

    public void startUpdateScreenTimer() {
        if (this.running) {
            return;
        }
        stopUpdateScreenTimer();
        this.laserY = DetectorViewConfig.getInstance().getDetectorRect().top;
        Timer timer = new Timer();
        this.mUpdateProgressBar = timer;
        timer.schedule(new TimerTask() { // from class: io.dcloud.feature.barcode2.view.ViewfinderView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ViewfinderView.this.updateScreen();
            }
        }, 0L, 10L);
        this.running = true;
    }

    public void stopUpdateScreenTimer() {
        if (this.running) {
            Timer timer = this.mUpdateProgressBar;
            if (timer != null) {
                timer.cancel();
                this.mUpdateProgressBar = null;
            }
            this.running = false;
            updateScreen();
        }
    }
}
