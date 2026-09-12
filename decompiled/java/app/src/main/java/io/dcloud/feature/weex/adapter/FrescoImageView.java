package io.dcloud.feature.weex.adapter;

import android.content.Context;
import android.view.MotionEvent;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeView;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class FrescoImageView extends DCGenericDraweeView implements WXGestureObservable {
    private WXGesture wxGesture;

    public FrescoImageView(Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void setFadeShow(boolean z) {
        if (getHierarchy() != null) {
            if (z) {
                getHierarchy().setFadeDuration(300);
                getHierarchy().getTopLevelDrawable().setRefresh(true);
            } else {
                getHierarchy().setFadeDuration(0);
                getHierarchy().getTopLevelDrawable().setRefresh(false);
            }
        }
    }
}
