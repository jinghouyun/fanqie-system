package com.taobao.weex.adapter;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IDrawableLoader {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface AnimatedTarget extends DrawableTarget {
        void setAnimatedDrawable(Drawable drawable);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface DrawableTarget {
        void setDrawable(Drawable drawable, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface StaticTarget extends DrawableTarget {
        @Override // com.taobao.weex.adapter.IDrawableLoader.DrawableTarget
        void setDrawable(Drawable drawable, boolean z);
    }

    void setDrawable(String str, DrawableTarget drawableTarget, DrawableStrategy drawableStrategy);
}
