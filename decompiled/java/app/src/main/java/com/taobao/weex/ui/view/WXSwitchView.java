package com.taobao.weex.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import androidx.appcompat.widget.SwitchCompat;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXSwitchView extends SwitchCompat implements WXGestureObservable {
    private WXGesture wxGesture;

    public WXSwitchView(Context context) {
        super(context);
        setShowText(false);
        setGravity(16);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }
}
