package io.dcloud.feature.weex.adapter.webview.video;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class FullscreenHolder extends FrameLayout {
    public FullscreenHolder(Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(R.color.black));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
