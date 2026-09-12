package io.dcloud.common.adapter.util;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class EventActionInfo {
    private String evalJs;
    private String eventAction;
    private Map<String, Object> params;

    public EventActionInfo(String str) {
        this.eventAction = str;
    }

    public String getEvalJs() {
        return this.evalJs;
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public EventActionInfo(String str, Map<String, Object> map) {
        this.eventAction = str;
        this.params = map;
    }

    public EventActionInfo(String str, String str2) {
        this.eventAction = str;
        this.evalJs = str2;
    }

    public EventActionInfo(String str, String str2, Map<String, Object> map) {
        this.eventAction = str;
        this.evalJs = str2;
        this.params = map;
    }
}
