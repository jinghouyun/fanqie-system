package com.taobao.weex.bridge;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class ResultCallbackManager {
    private static SparseArray<ResultCallback> mResultCallbacks = new SparseArray<>();
    private static long sCallbackId;

    ResultCallbackManager() {
    }

    static long generateCallbackId(ResultCallback resultCallback) {
        if (sCallbackId >= 2147483647L) {
            sCallbackId = 0L;
        }
        long j = sCallbackId;
        sCallbackId = 1 + j;
        int i = (int) j;
        mResultCallbacks.put(i, resultCallback);
        return i;
    }

    static ResultCallback removeCallbackById(long j) {
        int i = (int) j;
        ResultCallback resultCallback = mResultCallbacks.get(i);
        mResultCallbacks.remove(i);
        return resultCallback;
    }
}
