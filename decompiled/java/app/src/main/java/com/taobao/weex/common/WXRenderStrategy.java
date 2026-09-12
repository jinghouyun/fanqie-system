package com.taobao.weex.common;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public enum WXRenderStrategy {
    APPEND_ASYNC("APPEND_ASYNC"),
    APPEND_ONCE("APPEND_ONCE"),
    DATA_RENDER("DATA_RENDER"),
    DATA_RENDER_BINARY("DATA_RENDER_BINARY"),
    JSON_RENDER("JSON_RENDER");

    private String flag;

    WXRenderStrategy(String str) {
        this.flag = str;
    }

    public String getFlag() {
        return this.flag;
    }
}
