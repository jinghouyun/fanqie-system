package io.dcloud.common.adapter.ui.webview;

import io.dcloud.common.adapter.ui.AdaWebview;
import io.dcloud.common.adapter.util.PlatformUtil;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class PerWrapper {
    public String action;
    public JSONArray args;
    public boolean async;
    private Object result;
    public String service;
    public AdaWebview webview;

    public PerWrapper(Object obj, AdaWebview adaWebview, String str, String str2, JSONArray jSONArray, boolean z) {
        this.result = obj;
        this.webview = adaWebview;
        this.service = str;
        this.action = str2;
        this.args = jSONArray;
        this.async = z;
    }

    public void confirm(String str) {
        Object obj = this.result;
        if (obj != null) {
            PlatformUtil.invokeMethod(obj, "confirm", new Class[]{String.class}, str);
        }
    }
}
