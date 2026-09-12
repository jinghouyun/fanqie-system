package io.dcloud.feature.weex.adapter.Fresco;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.generic.RootDrawable;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCRootDrawable extends RootDrawable {
    private boolean isRefresh;
    private VisibilityCallback mVisibilityCallback;

    public DCRootDrawable(Drawable drawable) {
        super(drawable);
        this.isRefresh = true;
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
        }
    }

    public void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null && this.isRefresh) {
            try {
                visibilityCallback.onVisibilityChange(z);
            } catch (Exception unused) {
            }
        }
        return super.setVisible(z, z2);
    }
}
