package com.taobao.weex.utils;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXMap extends HashMap<String, String> implements Serializable {
    public String put(String str, byte[] bArr) {
        return (String) super.put(str, new String(bArr));
    }
}
