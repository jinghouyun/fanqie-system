package io.dcloud.common.adapter.util;

import android.view.View;
import io.dcloud.common.DHInterface.IFrameView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DragBean {
    public JSONObject dragCurrentViewOp = null;
    public JSONObject dragBindViewOp = null;
    public IFrameView dragBindWebView = null;
    public IFrameView dragCallBackWebView = null;
    public String dragCbId = null;
    public View nativeView = null;
}
