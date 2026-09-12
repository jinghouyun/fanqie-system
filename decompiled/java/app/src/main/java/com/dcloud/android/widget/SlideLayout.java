package com.dcloud.android.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.PdrUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class SlideLayout extends android.widget.AbsoluteLayout {
    private static String AFTER_SLIDE = "afterSlide";
    private static String BEFORE_SLIDE = "beforeSlide";
    private static String LEFT = "left";
    private static String RIGHT = "right";
    private static final int SCROLL_DURATION = 150;
    private static final int SNAP_VELOCITY = 1000;
    boolean isLeftSlide;
    boolean isRightSlide;
    boolean isSlideOpen;
    private boolean mCanDoSlideTransverseEvent;
    private OnStateChangeListener mChangeListener;
    private float mFirstX;
    private boolean mInterceptEventEnable;
    private boolean mIsHandledTouchEvent;
    private float mLastMotionX;
    private Scroller mScroller;
    private int mSlideLeftPosition;
    private int mSlideRightPosition;
    private int mSlideTransverseLeftMaxWitch;
    private int mSlideTransverseRightMaxWitch;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface OnStateChangeListener {
        void onStateChanged(String str, String str2);
    }

    public SlideLayout(Context context) {
        super(context);
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mLastMotionX = -1.0f;
        this.mCanDoSlideTransverseEvent = false;
        this.mSlideTransverseLeftMaxWitch = 0;
        this.mSlideTransverseRightMaxWitch = 0;
        this.mSlideLeftPosition = -1;
        this.mSlideRightPosition = -1;
        this.isRightSlide = false;
        this.isLeftSlide = false;
        this.isSlideOpen = false;
        this.mFirstX = 0.0f;
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void setState(final String str, final String str2) {
        if (this.mChangeListener != null) {
            postDelayed(new Runnable() { // from class: com.dcloud.android.widget.SlideLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    SlideLayout.this.mChangeListener.onStateChanged(str2, str);
                }
            }, 150L);
        }
    }

    private void smoothScrollTo(int i, int i2) {
        enableChildrenCache();
        this.mScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 2);
        invalidate();
    }

    void clearChildrenCache() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setDrawingCacheEnabled(false);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        } else {
            clearChildrenCache();
        }
        super.computeScroll();
    }

    void enableChildrenCache() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setDrawingCacheEnabled(true);
        }
    }

    public void initSlideInfo(JSONObject jSONObject, float f, int i) {
        JSONObject jSONObject2 = JSONUtil.getJSONObject(jSONObject, AbsoluteConst.BOUNCE_SLIDEO_OFFSET);
        if (jSONObject2 != null) {
            JSONObject jSONObject3 = JSONUtil.getJSONObject(jSONObject, "position");
            if (jSONObject3 != null) {
                String strOptString = jSONObject3.optString(LEFT);
                String strOptString2 = jSONObject3.optString(RIGHT);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.mSlideLeftPosition = PdrUtil.convertToScreenInt(strOptString, i, i / 2, f);
                }
                if (!TextUtils.isEmpty(strOptString2)) {
                    this.mSlideRightPosition = PdrUtil.convertToScreenInt(strOptString2, i, i / 2, f);
                }
            }
            this.mInterceptEventEnable = jSONObject.optBoolean("preventTouchEvent", true);
            String string = JSONUtil.getString(jSONObject2, LEFT);
            if (!TextUtils.isEmpty(string)) {
                this.isLeftSlide = this.mSlideLeftPosition > 0;
                this.mSlideTransverseLeftMaxWitch = PdrUtil.convertToScreenInt(string, i, i / 2, f);
            }
            String string2 = JSONUtil.getString(jSONObject2, RIGHT);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            this.isRightSlide = this.mSlideRightPosition > 0;
            this.mSlideTransverseRightMaxWitch = PdrUtil.convertToScreenInt(string2, i, i / 2, f);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!this.mInterceptEventEnable) {
            return false;
        }
        if (!this.isLeftSlide && !this.isRightSlide) {
            return false;
        }
        if (action == 3 || action == 1) {
            this.mIsHandledTouchEvent = false;
            clearChildrenCache();
            return this.mIsHandledTouchEvent;
        }
        if (action != 0 && this.mIsHandledTouchEvent) {
            return true;
        }
        if (action == 0) {
            this.mLastMotionX = motionEvent.getX();
            this.mFirstX = motionEvent.getX();
            this.mIsHandledTouchEvent = false;
            this.mCanDoSlideTransverseEvent = false;
        } else if (action == 2 && ((int) Math.abs(motionEvent.getX() - this.mFirstX)) > this.mTouchSlop) {
            enableChildrenCache();
            this.mIsHandledTouchEvent = true;
            this.mCanDoSlideTransverseEvent = true;
            requestDisallowInterceptTouchEvent(true);
        }
        return this.mIsHandledTouchEvent;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:69:0x0101  */
    /* JADX WARN: Code duplicated, block: B:72:0x0113  */
    /* JADX WARN: Code duplicated, block: B:73:0x0117  */
    /* JADX WARN: Code duplicated, block: B:75:0x011b  */
    /* JADX WARN: Code duplicated, block: B:79:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0131  */
    /* JADX WARN: Code duplicated, block: B:85:0x014d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0151  */
    /* JADX WARN: Code duplicated, block: B:89:0x0158  */
    /* JADX WARN: Code duplicated, block: B:92:0x0161  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int xVelocity;
        int scrollX;
        VelocityTracker velocityTracker2;
        if (this.mCanDoSlideTransverseEvent && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mIsHandledTouchEvent = false;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
        } else if (action == 1) {
            if (this.mIsHandledTouchEvent) {
                this.mIsHandledTouchEvent = false;
                if (this.mCanDoSlideTransverseEvent) {
                    requestDisallowInterceptTouchEvent(false);
                    VelocityTracker velocityTracker3 = this.mVelocityTracker;
                    velocityTracker3.computeCurrentVelocity(1000);
                    xVelocity = (int) velocityTracker3.getXVelocity();
                    scrollX = getScrollX();
                    if (xVelocity > 1000) {
                        if (scrollX >= 0 && this.isLeftSlide) {
                            int i = this.mSlideLeftPosition;
                            int i2 = this.mSlideTransverseLeftMaxWitch;
                            if (i >= i2) {
                                smoothScrollTo(-(i2 - Math.abs(scrollX)), 0);
                                this.isSlideOpen = true;
                                setState(LEFT, AFTER_SLIDE);
                            } else if (scrollX > 0) {
                                upSlideTo(scrollX);
                            } else {
                                upSlideTo(scrollX);
                            }
                        } else if (scrollX > 0 || !this.isRightSlide) {
                            upSlideTo(scrollX);
                        } else {
                            smoothScrollTo(-scrollX, 0);
                            this.isSlideOpen = false;
                            setState(RIGHT, BEFORE_SLIDE);
                        }
                    } else if (xVelocity < -1000) {
                        upSlideTo(scrollX);
                    } else if (scrollX >= 0 && this.isLeftSlide) {
                        smoothScrollTo(-scrollX, 0);
                        this.isSlideOpen = false;
                        setState(LEFT, BEFORE_SLIDE);
                    } else if (scrollX > 0 || !this.isRightSlide) {
                        upSlideTo(scrollX);
                    } else {
                        int i3 = this.mSlideRightPosition;
                        int i4 = this.mSlideTransverseRightMaxWitch;
                        if (i3 >= i4) {
                            smoothScrollTo(i4 - Math.abs(scrollX), 0);
                            this.isSlideOpen = true;
                            setState(RIGHT, AFTER_SLIDE);
                        } else {
                            upSlideTo(scrollX);
                        }
                    }
                    velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                }
            }
            velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else if (action == 2) {
            VelocityTracker velocityTracker4 = this.mVelocityTracker;
            if (velocityTracker4 != null) {
                velocityTracker4.addMovement(motionEvent);
            }
            float x = motionEvent.getX();
            if (this.mCanDoSlideTransverseEvent) {
                int i5 = (int) (this.mLastMotionX - x);
                this.mLastMotionX = x;
                int scrollX2 = getScrollX();
                int right = (getChildAt(getChildCount() - 1).getRight() - scrollX2) - getWidth();
                if (scrollX2 == 0) {
                    if (this.isRightSlide && i5 > 0) {
                        scrollBy(i5, 0);
                    } else if (this.isLeftSlide && i5 < 0) {
                        scrollBy(i5, 0);
                    }
                } else if (scrollX2 > 0 && right < 0 && this.isRightSlide) {
                    int i6 = scrollX2 + i5;
                    if (Math.abs(i6) <= this.mSlideRightPosition) {
                        if (i6 < 0) {
                            scrollBy(0, 0);
                        } else if (Math.abs(i6) >= this.mSlideTransverseRightMaxWitch) {
                            scrollBy((int) (((double) i5) / 1.5d), 0);
                        } else {
                            scrollBy(i5, 0);
                        }
                    }
                } else if (scrollX2 < 0 && right > 0 && this.isLeftSlide) {
                    int i7 = scrollX2 + i5;
                    if (Math.abs(i7) <= this.mSlideLeftPosition) {
                        if (i7 > 0) {
                            scrollBy(0, 0);
                        } else if (Math.abs(i7) >= this.mSlideTransverseLeftMaxWitch) {
                            scrollBy((int) (((double) i5) / 1.5d), 0);
                        } else {
                            scrollBy(i5, 0);
                        }
                    }
                }
            }
        } else if (action == 3) {
            if (this.mIsHandledTouchEvent) {
                this.mIsHandledTouchEvent = false;
                if (this.mCanDoSlideTransverseEvent) {
                    requestDisallowInterceptTouchEvent(false);
                    VelocityTracker velocityTracker5 = this.mVelocityTracker;
                    velocityTracker5.computeCurrentVelocity(1000);
                    xVelocity = (int) velocityTracker5.getXVelocity();
                    scrollX = getScrollX();
                    if (xVelocity > 1000) {
                        if (scrollX >= 0) {
                            if (scrollX > 0) {
                                upSlideTo(scrollX);
                            } else {
                                upSlideTo(scrollX);
                            }
                        } else if (scrollX > 0) {
                            upSlideTo(scrollX);
                        } else {
                            upSlideTo(scrollX);
                        }
                    } else if (xVelocity < -1000) {
                        upSlideTo(scrollX);
                    } else if (scrollX >= 0) {
                        if (scrollX > 0) {
                            upSlideTo(scrollX);
                        } else {
                            upSlideTo(scrollX);
                        }
                    } else if (scrollX > 0) {
                        upSlideTo(scrollX);
                    } else {
                        upSlideTo(scrollX);
                    }
                    velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                }
            }
            velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        int scrollX = getScrollX();
        if (scrollX == 0) {
            return;
        }
        smoothScrollTo(-scrollX, 0);
        if (scrollX < 0) {
            setState(LEFT, BEFORE_SLIDE);
        } else {
            setState(RIGHT, BEFORE_SLIDE);
        }
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            requestLayout();
        }
    }

    public void setInterceptTouchEventEnabled(boolean z) {
        this.mIsHandledTouchEvent = z;
    }

    public void setOffset(String str, String str2, float f) {
        int iConvertToScreenInt = PdrUtil.convertToScreenInt(str2, getWidth(), 0, f);
        int scrollX = getScrollX();
        if (str.equals(LEFT)) {
            if (iConvertToScreenInt == 0) {
                if (scrollX != 0) {
                    smoothScrollTo(-scrollX, 0);
                    setState(LEFT, BEFORE_SLIDE);
                    return;
                }
                return;
            }
            int i = this.mSlideLeftPosition;
            if (iConvertToScreenInt > i) {
                iConvertToScreenInt = i;
            }
            int iAbs = iConvertToScreenInt - Math.abs(scrollX);
            smoothScrollTo(-iAbs, 0);
            postDelayed(new Runnable() { // from class: com.dcloud.android.widget.SlideLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    SlideLayout slideLayout = SlideLayout.this;
                    slideLayout.upSlideTo(slideLayout.getScrollX());
                }
            }, (iAbs * 2) + 200);
            return;
        }
        if (iConvertToScreenInt == 0) {
            if (scrollX != 0) {
                smoothScrollTo(-scrollX, 0);
                setState(RIGHT, BEFORE_SLIDE);
                return;
            }
            return;
        }
        int i2 = this.mSlideRightPosition;
        if (iConvertToScreenInt > i2) {
            iConvertToScreenInt = i2;
        }
        int iAbs2 = iConvertToScreenInt - Math.abs(scrollX);
        smoothScrollTo(iAbs2, 0);
        postDelayed(new Runnable() { // from class: com.dcloud.android.widget.SlideLayout.3
            @Override // java.lang.Runnable
            public void run() {
                SlideLayout slideLayout = SlideLayout.this;
                slideLayout.upSlideTo(slideLayout.getScrollX());
            }
        }, (iAbs2 * 2) + 200);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mChangeListener = onStateChangeListener;
    }

    public void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            requestLayout();
        }
    }

    public void upSlideTo(int i) {
        if (i < 0) {
            int iAbs = Math.abs(i);
            int i2 = this.mSlideTransverseLeftMaxWitch;
            if (iAbs >= i2 / 2 && this.mSlideLeftPosition >= i2) {
                smoothScrollTo(-(i2 - Math.abs(i)), 0);
                this.isSlideOpen = true;
                setState(LEFT, AFTER_SLIDE);
                return;
            }
        }
        if (i > 0) {
            int iAbs2 = Math.abs(i);
            int i3 = this.mSlideTransverseRightMaxWitch;
            if (iAbs2 >= i3 / 2 && this.mSlideRightPosition >= i3) {
                smoothScrollTo(i3 - Math.abs(i), 0);
                this.isSlideOpen = true;
                setState(RIGHT, AFTER_SLIDE);
                return;
            }
        }
        if (i > 0) {
            smoothScrollTo(-i, 0);
            setState(RIGHT, BEFORE_SLIDE);
        } else {
            smoothScrollTo(-i, 0);
            setState(LEFT, BEFORE_SLIDE);
        }
        this.isSlideOpen = false;
    }
}
