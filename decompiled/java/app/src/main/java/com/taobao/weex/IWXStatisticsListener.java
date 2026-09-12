package com.taobao.weex;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWXStatisticsListener {
    void onException(String str, String str2, String str3);

    void onFirstScreen();

    void onFirstView();

    void onHeadersReceived();

    void onHttpFinish();

    void onHttpStart();

    void onJsFrameworkReady();

    void onJsFrameworkStart();

    void onSDKEngineInitialize();
}
