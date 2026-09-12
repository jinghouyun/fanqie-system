package io.dcloud.feature.uniapp.ui.action;

import com.alibaba.fastjson.JSONArray;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class UniMethodData {
    JSONArray args;
    String method;

    public UniMethodData(String str, JSONArray jSONArray) {
        this.method = str;
        this.args = jSONArray;
    }

    public JSONArray getArgs() {
        return this.args;
    }

    public String getMethod() {
        return this.method;
    }
}
