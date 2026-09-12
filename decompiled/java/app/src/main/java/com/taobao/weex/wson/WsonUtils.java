package com.taobao.weex.wson;

import com.taobao.weex.utils.WXLogUtils;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WsonUtils {
    public static final Object parseWson(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return Wson.parse(bArr);
        } catch (Exception e) {
            WXLogUtils.e("weex wson parse error ", e);
            return null;
        }
    }

    public static final byte[] toWson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Wson.toWson(obj);
        } catch (Exception e) {
            WXLogUtils.e("weex wson to wson error ", e);
            return null;
        }
    }
}
