package com.taobao.weex.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXJSService implements IWXObject {
    private String name;
    private Map<String, Object> options = new HashMap();
    private String script;

    public String getName() {
        return this.name;
    }

    public Map<String, Object> getOptions() {
        return this.options;
    }

    public String getScript() {
        return this.script;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOptions(Map<String, Object> map) {
        this.options = map;
    }

    public void setScript(String str) {
        this.script = str;
    }
}
