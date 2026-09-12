package com.taobao.weex.ui.action;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicSize {
    private float mHeight;
    private float mWidth;

    public GraphicSize(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void update(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }
}
