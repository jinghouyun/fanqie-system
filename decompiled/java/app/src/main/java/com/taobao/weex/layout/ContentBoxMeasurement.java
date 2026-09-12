package com.taobao.weex.layout;

import com.taobao.weex.common.Destroyable;
import com.taobao.weex.ui.component.WXComponent;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentBoxMeasurement implements Serializable, Destroyable {
    protected WXComponent mComponent;
    protected boolean mMeasureExactly;
    protected float mMeasureHeight;
    protected float mMeasureWidth;

    public ContentBoxMeasurement() {
        this.mMeasureExactly = false;
        this.mComponent = null;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        this.mComponent = null;
    }

    public float getHeight() {
        return this.mMeasureHeight;
    }

    public boolean getMeasureExactly() {
        return this.mMeasureExactly;
    }

    public float getWidth() {
        return this.mMeasureWidth;
    }

    public abstract void layoutAfter(float f, float f2);

    public abstract void layoutBefore();

    public final void measure(float f, float f2, int i, int i2) {
        measureInternal(f, f2, i, i2);
    }

    public abstract void measureInternal(float f, float f2, int i, int i2);

    public ContentBoxMeasurement(WXComponent wXComponent) {
        this.mMeasureExactly = false;
        this.mComponent = wXComponent;
    }
}
