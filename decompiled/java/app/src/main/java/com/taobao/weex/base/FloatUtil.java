package com.taobao.weex.base;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class FloatUtil {
    private static final float EPSILON = 1.0E-5f;

    public static boolean floatsEqual(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return Float.isNaN(f) && Float.isNaN(f2);
        }
        return Math.abs(f2 - f) < EPSILON;
    }
}
