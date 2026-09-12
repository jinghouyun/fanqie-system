package io.dcloud.common.ui.blur;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.TitleNViewUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DCBlurDraweeView extends FrameLayout implements AppEventForBlurManager.OnAppChangedCallBack {
    public static final String AUTOMATICALLY = "automatically";
    public static final String DARK = "dark";
    public static final String EXTRALIGHT = "extralight";
    public static final String LIGHT = "light";
    public static final String NONE = "none";
    public static final String SEMI_AUTOMATICALLY = "semi-automatic";
    public static final String STATIC = "static";
    private final String TAG;
    private Choreographer.FrameCallback invalidationLoop;
    private boolean isBlur;
    private float mAlpha;
    private boolean mAttachedToWindow;
    private String mBlurEffect;
    private int mBlurRadius;
    private String mBlurState;
    private BlurLayoutChangeCallBack mChangeCB;
    private float mCornerRadius;
    private float mDownscaleFactor;
    private int mFPS;
    private int mGravityType;
    private ImageView mImageView;
    private float mOverlayColorAlpha;
    private long mPostTime;
    private WeakReference<View> mRootView;
    private boolean mRunning;
    private int postDelayTime;
    private Choreographer.FrameCallback postInvalidationLoop;
    private Runnable removePostDelayed;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface BlurLayoutChangeCallBack {
        void setVisibility(int i);
    }

    public DCBlurDraweeView(Context context) {
        super(context);
        this.TAG = "DCBlurDraweeView";
        this.mDownscaleFactor = 0.2f;
        this.mBlurRadius = 15;
        this.mFPS = 60;
        this.mCornerRadius = 0.0f;
        this.mAlpha = Float.NaN;
        this.isBlur = false;
        this.mGravityType = 17;
        this.mBlurState = "static";
        this.mBlurEffect = "none";
        this.mPostTime = 1500L;
        this.invalidationLoop = new Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (!BaseInfo.sDoingAnimation) {
                    DCBlurDraweeView.this.invalidate();
                }
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / DCBlurDraweeView.this.mFPS);
            }
        };
        this.postDelayTime = 50;
        this.postInvalidationLoop = new Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (DCBlurDraweeView.this.mRunning) {
                    return;
                }
                if (!BaseInfo.sDoingAnimation) {
                    DCBlurDraweeView.this.invalidate();
                }
                Choreographer.getInstance().postFrameCallbackDelayed(this, DCBlurDraweeView.this.postDelayTime);
            }
        };
        this.removePostDelayed = new Runnable() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.3
            @Override // java.lang.Runnable
            public void run() {
                Choreographer.getInstance().removeFrameCallback(DCBlurDraweeView.this.postInvalidationLoop);
            }
        };
        this.mOverlayColorAlpha = 0.6f;
    }

    private View getActivityView() {
        try {
            return ((Activity) getContext()).getWindow().getDecorView().findViewById(R.id.content);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Bitmap getDownscaledBitmapForView(View view, Rect rect, float f, int i) throws Exception {
        int iHeight;
        int iHeight2;
        float f2 = f / 0.5f;
        if (f >= 0.5f) {
            f2 = 1.0f;
        } else {
            f = 0.5f;
        }
        int iWidth = (int) (rect.width() * f);
        int iHeight3 = (int) (rect.height() * f);
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || iWidth <= 0 || iHeight3 <= 0) {
            throw new Exception("No screen available (width or height = 0)");
        }
        float f3 = (-rect.left) * f;
        float f4 = ((-rect.top) + i) * f;
        int i2 = this.mGravityType;
        if (i2 != 17) {
            if (i2 != 48) {
                iHeight = rect.height();
            } else {
                iHeight2 = (int) ((rect.height() + i) * f);
                f4 -= i * f;
            }
            setViewVisibility(4);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight2, config);
            BlurCanvas blurCanvas = new BlurCanvas(bitmapCreateBitmap);
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            matrix.postTranslate(f3, f4);
            blurCanvas.setMatrix(matrix);
            view.draw(blurCanvas);
            blurCanvas.drawColor(getOverlayColor());
            blurCanvas.save();
            setViewVisibility(0);
            float f5 = iWidth;
            int i3 = (int) (f5 * f2);
            float f6 = iHeight2;
            int i4 = (int) (f2 * f6);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i3, i4, config);
            Canvas canvas = new Canvas(bitmapCreateBitmap2);
            Matrix matrix2 = new Matrix();
            matrix2.setScale(i3 / f5, i4 / f6);
            canvas.setMatrix(matrix2);
            canvas.drawColor(getBlurBGColor());
            Paint paint = new Paint();
            paint.setFlags(3);
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
            bitmapCreateBitmap.recycle();
            return bitmapCreateBitmap2;
        }
        iHeight = rect.height();
        i *= 2;
        iHeight2 = (int) ((iHeight + i) * f);
        setViewVisibility(4);
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(iWidth, iHeight2, config2);
        BlurCanvas blurCanvas2 = new BlurCanvas(bitmapCreateBitmap3);
        Matrix matrix3 = new Matrix();
        matrix3.postScale(f, f);
        matrix3.postTranslate(f3, f4);
        blurCanvas2.setMatrix(matrix3);
        view.draw(blurCanvas2);
        blurCanvas2.drawColor(getOverlayColor());
        blurCanvas2.save();
        setViewVisibility(0);
        float f7 = iWidth;
        int i5 = (int) (f7 * f2);
        float f8 = iHeight2;
        int i6 = (int) (f2 * f8);
        Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(i5, i6, config2);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap4);
        Matrix matrix4 = new Matrix();
        matrix4.setScale(i5 / f7, i6 / f8);
        canvas2.setMatrix(matrix4);
        canvas2.drawColor(getBlurBGColor());
        Paint paint2 = new Paint();
        paint2.setFlags(3);
        canvas2.drawBitmap(bitmapCreateBitmap3, 0.0f, 0.0f, paint2);
        bitmapCreateBitmap3.recycle();
        return bitmapCreateBitmap4;
    }

    private int getOverlayColor() {
        String str = this.mBlurEffect;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "dark":
                return Color.parseColor(TitleNViewUtil.changeColorAlpha("#454545", this.mOverlayColorAlpha));
            case "light":
                return Color.parseColor(TitleNViewUtil.changeColorAlpha("#F8F8F8", this.mOverlayColorAlpha));
            case "extralight":
                return Color.parseColor(TitleNViewUtil.changeColorAlpha(TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR, this.mOverlayColorAlpha));
            default:
                return 0;
        }
    }

    private Point getPositionInScreen() {
        PointF positionInScreen = getPositionInScreen(this);
        return new Point((int) positionInScreen.x, (int) positionInScreen.y);
    }

    private void initImageView() {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            this.mImageView = new ImageView(getContext());
        } else if (imageView.getParent() == null) {
            ((ViewGroup) this.mImageView.getParent()).removeView(this.mImageView);
        }
        this.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mImageView, 0);
        setCornerRadius(this.mCornerRadius);
    }

    private void pauseBlur() {
        if (this.mRunning && this.isBlur) {
            this.mRunning = false;
            Choreographer.getInstance().removeFrameCallback(this.invalidationLoop);
        }
    }

    private void setViewVisibility(int i) {
        setVisibility(i);
        BlurLayoutChangeCallBack blurLayoutChangeCallBack = this.mChangeCB;
        if (blurLayoutChangeCallBack != null) {
            blurLayoutChangeCallBack.setVisibility(i);
        }
    }

    private void startBlur() {
        if (this.mRunning || !this.isBlur || this.mFPS <= 0 || this.mBlurState.equals("static")) {
            return;
        }
        this.mRunning = true;
        Choreographer.getInstance().removeFrameCallback(this.postInvalidationLoop);
        Choreographer.getInstance().postFrameCallback(this.invalidationLoop);
    }

    public boolean checkBlurEffect(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(LIGHT) || str.equals(DARK) || str.equals(EXTRALIGHT);
    }

    public int getBlurBGColor() {
        String str = this.mBlurEffect;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "dark":
                return Color.parseColor("#F2454545");
            case "light":
                return Color.parseColor("#F2F8F8F8");
            case "extralight":
                return Color.parseColor("#F2FFFFFF");
            default:
                return 0;
        }
    }

    @Override // android.view.View
    public void invalidate() {
        Bitmap bitmapMakeBlur;
        super.invalidate();
        if (!this.mAttachedToWindow || this.mImageView == null || !this.isBlur || (bitmapMakeBlur = makeBlur()) == null) {
            return;
        }
        this.mImageView.setImageBitmap(bitmapMakeBlur);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ca  */
    public Bitmap makeBlur() {
        Bitmap downscaledBitmapForView = null;
        if (getContext() == null || isInEditMode() || !this.isBlur) {
            return null;
        }
        WeakReference<View> weakReference = this.mRootView;
        if (weakReference == null || weakReference.get() == null) {
            WeakReference<View> weakReference2 = new WeakReference<>(getActivityView());
            this.mRootView = weakReference2;
            if (weakReference2.get() == null) {
                return null;
            }
        }
        getLocationOnScreen(new int[2]);
        Point positionInScreen = getPositionInScreen();
        Rect rect = new Rect();
        if (!getGlobalVisibleRect(rect)) {
            return null;
        }
        int height = getHeight();
        int width = getWidth();
        boolean z = rect.height() >= height;
        int i = z ? this.mBlurRadius : 0;
        try {
            View view = this.mRootView.get();
            int i2 = positionInScreen.x;
            int i3 = positionInScreen.y;
            downscaledBitmapForView = getDownscaledBitmapForView(view, new Rect(i2, i3, width + i2, height + i3), this.mDownscaleFactor, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (downscaledBitmapForView == null) {
            return downscaledBitmapForView;
        }
        Bitmap bitmapProcessNatively = BlurManager.getInstance().processNatively(downscaledBitmapForView, this.mBlurRadius, false);
        int i4 = (int) (i * this.mDownscaleFactor);
        int i5 = z ? i4 : 0;
        int height2 = z ? bitmapProcessNatively.getHeight() - (i4 * 2) : bitmapProcessNatively.getHeight();
        int i6 = this.mGravityType;
        if (i6 == 17) {
            if (z) {
                height2 = bitmapProcessNatively.getHeight() - (i4 * 2);
            } else {
                height2 = bitmapProcessNatively.getHeight();
            }
        } else if (i6 == 48) {
            i5 = 5;
            height2 = (z ? bitmapProcessNatively.getHeight() - i4 : bitmapProcessNatively.getHeight()) - 5;
        } else if (i6 == 80) {
            if (z) {
                height2 = bitmapProcessNatively.getHeight() - (i4 * 2);
            } else {
                height2 = bitmapProcessNatively.getHeight();
            }
        }
        return Bitmap.createBitmap(bitmapProcessNatively, 0, i5, bitmapProcessNatively.getWidth(), height2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        byte b = 1;
        this.mAttachedToWindow = true;
        if (this.isBlur) {
            String str = this.mBlurState;
            str.getClass();
            str.hashCode();
            switch (str.hashCode()) {
                case -892481938:
                    if (!str.equals("static")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1030681228:
                    if (!str.equals(SEMI_AUTOMATICALLY)) {
                        b = -1;
                    }
                    break;
                case 1977933731:
                    if (!str.equals(AUTOMATICALLY)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    postInvalidate(this.mPostTime);
                    AppEventForBlurManager.removeEventChangedCallBack(this);
                    break;
                case 1:
                    postInvalidate(this.mPostTime);
                    AppEventForBlurManager.addEventChangedCallBack(this);
                    break;
                case 2:
                    AppEventForBlurManager.removeEventChangedCallBack(this);
                    startBlur();
                    break;
            }
        }
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onContentScrollEnd() {
        pauseBlur();
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onContentScrollStart() {
        startBlur();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        pauseBlur();
        AppEventForBlurManager.removeEventChangedCallBack(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.isBlur) {
            postInvalidate(this.mPostTime);
        }
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onSplashclosed() {
        postInvalidate(this.mPostTime);
    }

    public void postInvalidate(long j) {
        if (this.mRunning || !this.isBlur) {
            return;
        }
        MessageHandler.removeCallbacks(this.removePostDelayed);
        Choreographer.getInstance().removeFrameCallback(this.postInvalidationLoop);
        Choreographer.getInstance().postFrameCallback(this.postInvalidationLoop);
        MessageHandler.postDelayed(this.removePostDelayed, j + 10);
    }

    public void setBlur(boolean z) {
        this.isBlur = z;
        if (z && this.mImageView == null) {
            initImageView();
        }
    }

    public void setBlurEffect(String str) {
        this.mBlurEffect = str;
        if (this.isBlur || !this.mBlurState.equals("none")) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(getBlurBGColor());
        }
    }

    public void setBlurLayoutChangeCallBack(BlurLayoutChangeCallBack blurLayoutChangeCallBack) {
        this.mChangeCB = blurLayoutChangeCallBack;
    }

    public void setBlurRadius(int i) {
        if (i < 0) {
            i = 15;
        } else if (i > 25) {
            i = 25;
        }
        this.mBlurRadius = i;
        invalidate();
    }

    public void setBlurState(String str) {
        this.mBlurState = str;
    }

    public void setContentFocusable(boolean z) {
        String str = this.mBlurState;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "static":
                AppEventForBlurManager.removeEventChangedCallBack(this);
                pauseBlur();
                break;
            case "semi-automatic":
                if (!z) {
                    AppEventForBlurManager.removeEventChangedCallBack(this);
                    break;
                } else {
                    AppEventForBlurManager.addEventChangedCallBack(this);
                    break;
                }
                break;
            case "automatically":
                if (!z) {
                    pauseBlur();
                    break;
                } else {
                    startBlur();
                    break;
                }
                break;
        }
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
        invalidate();
    }

    public void setDownscaleFactor(float f) {
        this.mDownscaleFactor = f;
        invalidate();
    }

    public void setFPS(int i) {
        if (this.mRunning) {
            pauseBlur();
        }
        this.mFPS = i;
    }

    public void setGravityType(int i) {
        this.mGravityType = i;
    }

    public void setOverlayColorAlpha(float f) {
        this.mOverlayColorAlpha = f;
    }

    public void setRootView(View view) {
        WeakReference<View> weakReference = this.mRootView;
        if (weakReference != null && weakReference.get() != null) {
            this.mRootView.clear();
        }
        this.mRootView = new WeakReference<>(view);
    }

    private PointF getPositionInScreen(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        if (this.mRootView.get() != null && view == this.mRootView.get()) {
            return new PointF();
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new PointF();
            }
            PointF positionInScreen = getPositionInScreen(viewGroup);
            positionInScreen.offset(view.getX(), view.getY());
            return positionInScreen;
        } catch (Exception unused) {
            return new PointF();
        }
    }

    public DCBlurDraweeView(Context context, boolean z, String str) {
        super(context);
        this.TAG = "DCBlurDraweeView";
        this.mDownscaleFactor = 0.2f;
        this.mBlurRadius = 15;
        this.mFPS = 60;
        this.mCornerRadius = 0.0f;
        this.mAlpha = Float.NaN;
        this.isBlur = false;
        this.mGravityType = 17;
        this.mBlurState = "static";
        this.mBlurEffect = "none";
        this.mPostTime = 1500L;
        this.invalidationLoop = new Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (!BaseInfo.sDoingAnimation) {
                    DCBlurDraweeView.this.invalidate();
                }
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / DCBlurDraweeView.this.mFPS);
            }
        };
        this.postDelayTime = 50;
        this.postInvalidationLoop = new Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (DCBlurDraweeView.this.mRunning) {
                    return;
                }
                if (!BaseInfo.sDoingAnimation) {
                    DCBlurDraweeView.this.invalidate();
                }
                Choreographer.getInstance().postFrameCallbackDelayed(this, DCBlurDraweeView.this.postDelayTime);
            }
        };
        this.removePostDelayed = new Runnable() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.3
            @Override // java.lang.Runnable
            public void run() {
                Choreographer.getInstance().removeFrameCallback(DCBlurDraweeView.this.postInvalidationLoop);
            }
        };
        this.mOverlayColorAlpha = 0.6f;
        this.isBlur = z;
        this.mBlurState = str;
        if (z) {
            initImageView();
        }
    }
}
