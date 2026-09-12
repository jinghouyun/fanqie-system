package io.dcloud.feature.weex.adapter.widget.refresh;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class WeexDcRefreshLayout extends DCWeexBaseRefreshLayout {
    private boolean mDragger;
    private float mStartX;
    private float mStartY;
    private int mTouchSlop;

    public WeexDcRefreshLayout(Context context) {
        super(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean canScrollVertically(View view) {
        if (view instanceof ViewGroup) {
            if (!view.canScrollVertically(-1)) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (canScrollVertically(viewGroup.getChildAt(i))) {
                        return true;
                    }
                    i++;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isViewRefresh() {
        for (int i = 0; i < getChildCount(); i++) {
            if (canScrollVertically(getChildAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    @Override // io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (!isViewRefresh()) {
                return false;
            }
            if (action == 0) {
                this.mStartY = motionEvent.getY();
                this.mStartX = motionEvent.getX();
                this.mDragger = false;
            } else if (action == 1) {
                this.mDragger = false;
            } else if (action != 2) {
                if (action == 3) {
                    this.mDragger = false;
                }
            } else {
                if (this.mDragger) {
                    return false;
                }
                float y = motionEvent.getY();
                float fAbs = Math.abs(motionEvent.getX() - this.mStartX);
                float fAbs2 = Math.abs(y - this.mStartY);
                if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                    this.mDragger = true;
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
