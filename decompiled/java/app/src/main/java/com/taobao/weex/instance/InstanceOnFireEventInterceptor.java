package com.taobao.weex.instance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InstanceOnFireEventInterceptor {
    private List<String> listenEvents = new ArrayList();

    public void addInterceptEvent(String str) {
        if (this.listenEvents.contains(str)) {
            return;
        }
        this.listenEvents.add(str);
    }

    public List<String> getListenEvents() {
        return this.listenEvents;
    }

    public abstract void onFireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);

    public void onInterceptFireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        if (map != null && this.listenEvents.contains(str3)) {
            onFireEvent(str, str2, str3, map, map2);
        }
    }
}
