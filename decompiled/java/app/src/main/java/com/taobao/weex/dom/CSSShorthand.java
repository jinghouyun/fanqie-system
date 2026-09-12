package com.taobao.weex.dom;

import io.dcloud.feature.uniapp.dom.AbsCSSShorthand;
import java.lang.Enum;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class CSSShorthand<T extends Enum<? extends WXCSSProperty>> extends AbsCSSShorthand {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public enum CORNER implements WXCSSProperty {
        BORDER_TOP_LEFT,
        BORDER_TOP_RIGHT,
        BORDER_BOTTOM_RIGHT,
        BORDER_BOTTOM_LEFT,
        ALL
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public enum EDGE implements WXCSSProperty {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        ALL
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    interface WXCSSProperty extends AbsCSSShorthand.CSSProperty {
    }

    public CSSShorthand(float[] fArr) {
        super(fArr);
    }

    public CSSShorthand() {
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsCSSShorthand
    /* JADX INFO: renamed from: clone */
    public CSSShorthand mo415clone() {
        return (CSSShorthand) super.mo415clone();
    }
}
