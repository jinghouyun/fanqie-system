package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.border.BorderDrawable;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class TextWidget extends BaseWidget {
    private Layout mLayout;

    public TextWidget(FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(Canvas canvas) {
        Layout layout = this.mLayout;
        if (layout != null) {
            layout.draw(canvas);
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setContentBox(int i, int i2, int i3, int i4) {
        super.setContentBox(i, i2, i3, i4);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }

    public void updateTextDrawable(Layout layout) {
        this.mLayout = layout;
        invalidate();
    }
}
