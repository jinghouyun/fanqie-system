package com.taobao.weex.utils;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXDataStructureUtil {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private static int capacity(int i) {
        if (i < 3) {
            checkNonnegative(i, "expectedSize");
            return i + 1;
        }
        if (i < MAX_POWER_OF_TWO) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    private static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }
}
