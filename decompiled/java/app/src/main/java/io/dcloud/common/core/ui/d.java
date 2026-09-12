package io.dcloud.common.core.ui;

import android.content.Context;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.adapter.ui.AdaUniWebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class d extends AdaUniWebView {
    protected d(Context context, b bVar, String str, String str2, JSONObject jSONObject, boolean z) {
        super(context, bVar.obtainApp(), bVar, str, str2, jSONObject, z);
        bVar.l = this;
        bVar.m = getWebviewParent();
    }

    @Override // io.dcloud.common.adapter.ui.AdaUniWebView, io.dcloud.common.DHInterface.IWebview
    public IApp obtainApp() {
        if (obtainFrameView() != null) {
            return obtainFrameView().obtainApp();
        }
        return null;
    }
}
