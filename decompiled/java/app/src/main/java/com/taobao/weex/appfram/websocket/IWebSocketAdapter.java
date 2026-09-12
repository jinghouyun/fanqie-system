package com.taobao.weex.appfram.websocket;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWebSocketAdapter {
    public static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface EventListener {
        void onClose(int i, String str, boolean z);

        void onError(String str);

        void onMessage(String str);

        void onOpen();
    }

    void close(int i, String str);

    void connect(String str, String str2, EventListener eventListener);

    void connect(String str, String str2, String str3, EventListener eventListener);

    void destroy();

    void send(String str);
}
