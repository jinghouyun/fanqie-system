package com.taobao.weex.ui.action;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicPosition {
    private float mBottom;
    private float mLeft;
    private float mRight;
    private float mTop;

    public GraphicPosition(float f, float f2, float f3, float f4) {
        this.mLeft = f;
        this.mTop = f2;
        this.mRight = f3;
        this.mBottom = f4;
    }

    public float getBottom() {
        return this.mBottom;
    }

    public float getLeft() {
        return this.mLeft;
    }

    public float getRight() {
        return this.mRight;
    }

    public float getTop() {
        return this.mTop;
    }

    public void setBottom(float f) {
        this.mBottom = f;
    }

    public void setLeft(float f) {
        this.mLeft = f;
    }

    public void setRight(float f) {
        this.mRight = f;
    }

    public void setTop(float f) {
        this.mTop = f;
    }

    public void update(float f, float f2, float f3, float f4) {
        this.mTop = f;
        this.mBottom = f2;
        this.mLeft = f3;
        this.mRight = f4;
    }
}
