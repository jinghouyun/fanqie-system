package com.taobao.weex.ui.animation;

import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class CameraDistanceProperty extends Property<View, Float> {
    private static final String TAG = "CameraDistance";
    private static CameraDistanceProperty instance;

    private CameraDistanceProperty() {
        super(Float.class, TAG);
    }

    static Property<View, Float> getInstance() {
        return instance;
    }

    @Override // android.util.Property
    public void set(View view, Float f) {
        view.setCameraDistance(f.floatValue());
    }

    @Override // android.util.Property
    public Float get(View view) {
        return Float.valueOf(view.getCameraDistance());
    }
}
