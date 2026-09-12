package io.dcloud.feature.weex.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.ui.view.WXCircleViewPager;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCWXCircleViewPager extends WXCircleViewPager {
    private boolean isVertical;
    private int pointCounr;

    public DCWXCircleViewPager(Context context) {
        super(context);
        this.isVertical = false;
        this.pointCounr = 0;
    }

    private MotionEvent swapTouchEvent(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    public int getPointCounr() {
        return this.pointCounr;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // com.taobao.weex.ui.view.WXCircleViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!this.isVertical) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(swapTouchEvent(motionEvent));
            swapTouchEvent(motionEvent);
            return zOnInterceptTouchEvent;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031  */
    @Override // com.taobao.weex.ui.view.WXCircleViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pointCounr = motionEvent.getPointerCount();
        } else if (action == 1 || action == 3) {
            this.pointCounr = 0;
        }
        if (!this.isVertical) {
            return super.onTouchEvent(motionEvent);
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int action2 = motionEvent.getAction();
        if (action2 == 1) {
            viewGroup.requestDisallowInterceptTouchEvent(false);
        } else if (action2 == 2) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        } else if (action2 == 3) {
            viewGroup.requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(swapTouchEvent(motionEvent));
    }

    public void setVertical(boolean z) {
        this.isVertical = z;
        if (z) {
            setPageTransformer(false, new ViewPager.PageTransformer() { // from class: io.dcloud.feature.weex.extend.DCWXCircleViewPager.1
                @Override // androidx.viewpager.widget.ViewPager.PageTransformer
                public void transformPage(View view, float f) {
                    view.setTranslationX(view.getWidth() * (-f));
                    view.setTranslationY(f * view.getHeight());
                }
            });
        } else {
            setPageTransformer(false, null);
        }
    }

    public DCWXCircleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVertical = false;
        this.pointCounr = 0;
    }
}
