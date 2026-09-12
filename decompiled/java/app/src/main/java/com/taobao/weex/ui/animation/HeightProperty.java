package com.taobao.weex.ui.animation;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class HeightProperty extends LayoutParamsProperty {
    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ Integer get(View view) {
        return super.get(view);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected Integer getProperty(ViewGroup.LayoutParams layoutParams) {
        return Integer.valueOf(layoutParams.height);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ void set(View view, Integer num) {
        super.set(view, num);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected void setProperty(ViewGroup.LayoutParams layoutParams, Integer num) {
        layoutParams.height = num.intValue();
    }
}
