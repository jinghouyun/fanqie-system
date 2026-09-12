package com.taobao.weex.performance;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWXApmMonitorAdapter {
    void addProperty(String str, Object obj);

    void addStats(String str, double d);

    void onAppear();

    void onDisappear();

    void onEnd();

    void onEvent(String str, Object obj);

    void onStage(String str, long j);

    void onStart(String str);

    void onSubProcedureEvent(String str, String str2);

    void onSubProcedureStage(String str, String str2);

    String parseReportUrl(String str);

    void setSubProcedureProperties(String str, String str2, Object obj);

    void setSubProcedureStats(String str, String str2, double d);
}
