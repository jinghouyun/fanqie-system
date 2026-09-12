package com.taobao.weex.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXCircleViewPager extends ViewPager implements WXGestureObservable {
    private final int SCROLL_TO_NEXT;
    private long intervalTime;
    private boolean isAutoScroll;
    private Handler mAutoScrollHandler;
    private WXSmoothScroller mScroller;
    private int mState;
    private boolean needLoop;
    private boolean scrollable;
    private WXGesture wxGesture;

    public WXCircleViewPager(Context context) {
        super(context);
        this.SCROLL_TO_NEXT = 1;
        this.intervalTime = 3000L;
        this.needLoop = true;
        this.scrollable = true;
        this.mState = 0;
        this.mAutoScrollHandler = new Handler(Looper.getMainLooper()) { // from class: com.taobao.weex.ui.view.WXCircleViewPager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                WXLogUtils.d("[CircleViewPager] trigger auto play action");
                WXCircleViewPager.this.showNextItem();
                sendEmptyMessageDelayed(1, WXCircleViewPager.this.intervalTime);
            }
        };
        init();
    }

    private void init() {
        setOverScrollMode(2);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.taobao.weex.ui.view.WXCircleViewPager.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                WXCircleViewPager.this.mState = i;
                WXCirclePageAdapter circlePageAdapter = WXCircleViewPager.this.getCirclePageAdapter();
                int currentItem = WXCircleViewPager.super.getCurrentItem();
                if (WXCircleViewPager.this.needLoop && i == 0 && circlePageAdapter.getCount() > 1) {
                    if (currentItem == circlePageAdapter.getCount() - 1) {
                        WXCircleViewPager.this.superSetCurrentItem(1, false);
                        circlePageAdapter.getViews().get(0).setTranslationY(0.0f);
                        circlePageAdapter.getViews().get(0).setTranslationX(0.0f);
                    } else if (currentItem == 0) {
                        WXCircleViewPager.this.superSetCurrentItem(circlePageAdapter.getCount() - 2, false);
                        try {
                            circlePageAdapter.getViews().get(circlePageAdapter.getCount() - 3).setTranslationY(0.0f);
                            circlePageAdapter.getViews().get(circlePageAdapter.getCount() - 3).setTranslationX(0.0f);
                        } catch (Exception unused) {
                        }
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
        postInitViewPager();
    }

    private void postInitViewPager() {
        if (isInEditMode()) {
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            WXSmoothScroller wXSmoothScroller = new WXSmoothScroller(getContext(), (Interpolator) declaredField2.get(null));
            this.mScroller = wXSmoothScroller;
            declaredField.set(this, wXSmoothScroller);
        } catch (Exception e) {
            WXLogUtils.e("[CircleViewPager] postInitViewPager: ", e);
        }
    }

    private void setRealCurrentItem(int i, boolean z) {
        superSetCurrentItem(((WXCirclePageAdapter) getAdapter()).getFirst() + i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextItem() {
        if (getCirclePageAdapter() == null || !getCirclePageAdapter().isRTL) {
            if (this.needLoop || superGetCurrentItem() != getRealCount() - 1) {
                if (getRealCount() == 2 && superGetCurrentItem() == 1) {
                    superSetCurrentItem(0, true);
                    return;
                } else {
                    superSetCurrentItem(superGetCurrentItem() + 1, true);
                    return;
                }
            }
            return;
        }
        if (this.needLoop || superGetCurrentItem() != 0) {
            if (getRealCount() == 2 && superGetCurrentItem() == 0) {
                superSetCurrentItem(1, true);
            } else {
                superSetCurrentItem(superGetCurrentItem() - 1, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void superSetCurrentItem(int i, boolean z) {
        try {
            if (Math.abs(i - getRealCurrentItem()) > 3 && this.needLoop && getRealCount() > 2 && i == getCirclePageAdapter().getCount() - 2) {
                super.setCurrentItem(i - 2, false);
            }
        } catch (Exception unused) {
        }
        try {
            super.setCurrentItem(i, z);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.setCurrentItem(i, z);
            }
        }
    }

    public void destory() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    /* JADX WARN: Code duplicated, block: B:14:0x001e  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        } else if (action == 1) {
            if (isAutoScroll()) {
                this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
            }
        } else if (action == 2) {
            this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        } else if (action == 3) {
            if (isAutoScroll()) {
                this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
            }
        }
        try {
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            WXGesture wXGesture = this.wxGesture;
            return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
        } catch (Exception unused) {
            return false;
        }
    }

    public WXCirclePageAdapter getCirclePageAdapter() {
        return (WXCirclePageAdapter) getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return getRealCurrentItem();
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public long getIntervalTime() {
        return this.intervalTime;
    }

    public int getRealCount() {
        return ((WXCirclePageAdapter) getAdapter()).getRealCount();
    }

    public int getRealCurrentItem() {
        return ((WXCirclePageAdapter) getAdapter()).getRealPosition(super.getCurrentItem());
    }

    public WXSmoothScroller getmScroller() {
        return this.mScroller;
    }

    public boolean isAutoScroll() {
        return this.isAutoScroll;
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return this.scrollable && super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void pauseAutoScroll() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.scrollable || this.mState != 1) {
            super.scrollTo(i, i2);
        }
    }

    public void setCircle(boolean z) {
        this.needLoop = z;
    }

    public void setCirclePageAdapter(WXCirclePageAdapter wXCirclePageAdapter) {
        setAdapter(wXCirclePageAdapter);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        setRealCurrentItem(i, true);
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public void startAutoScroll() {
        this.isAutoScroll = true;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
    }

    public void stopAutoScroll() {
        this.isAutoScroll = false;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    public int superGetCurrentItem() {
        return super.getCurrentItem();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        setRealCurrentItem(i, z);
    }

    public WXCircleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SCROLL_TO_NEXT = 1;
        this.intervalTime = 3000L;
        this.needLoop = true;
        this.scrollable = true;
        this.mState = 0;
        this.mAutoScrollHandler = new Handler(Looper.getMainLooper()) { // from class: com.taobao.weex.ui.view.WXCircleViewPager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                WXLogUtils.d("[CircleViewPager] trigger auto play action");
                WXCircleViewPager.this.showNextItem();
                sendEmptyMessageDelayed(1, WXCircleViewPager.this.intervalTime);
            }
        };
        init();
    }
}
