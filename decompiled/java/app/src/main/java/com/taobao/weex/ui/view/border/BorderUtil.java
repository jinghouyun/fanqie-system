package com.taobao.weex.ui.view.border;

import android.util.SparseIntArray;
import com.taobao.weex.dom.CSSShorthand;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class BorderUtil {
    BorderUtil() {
    }

    static int fetchFromSparseArray(SparseIntArray sparseIntArray, int i, int i2) {
        return sparseIntArray == null ? i2 : sparseIntArray.get(i, sparseIntArray.get(CSSShorthand.EDGE.ALL.ordinal()));
    }

    static void updateSparseArray(SparseIntArray sparseIntArray, int i, int i2) {
        CSSShorthand.EDGE edge = CSSShorthand.EDGE.ALL;
        if (i != edge.ordinal()) {
            sparseIntArray.put(i, i2);
            return;
        }
        sparseIntArray.put(edge.ordinal(), i2);
        sparseIntArray.put(CSSShorthand.EDGE.TOP.ordinal(), i2);
        sparseIntArray.put(CSSShorthand.EDGE.LEFT.ordinal(), i2);
        sparseIntArray.put(CSSShorthand.EDGE.RIGHT.ordinal(), i2);
        sparseIntArray.put(CSSShorthand.EDGE.BOTTOM.ordinal(), i2);
    }
}
