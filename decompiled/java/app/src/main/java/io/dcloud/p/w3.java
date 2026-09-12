package io.dcloud.p;

import com.taobao.weex.common.Constants;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.PdrUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class w3 implements IEventCallback {
    HashMap a = new HashMap();

    public String a(IWebview iWebview, String str, String[] strArr) {
        v3 v3Var;
        if (str.equals("getCurrentProximity")) {
            String str2 = strArr[0];
            v3 v3Var2 = (v3) this.a.get(iWebview);
            if (v3Var2 == null) {
                v3Var2 = new v3(iWebview);
                this.a.put(iWebview, v3Var2);
            }
            v3Var2.d = str2;
            v3Var2.a();
            return null;
        }
        if (!str.equals("start")) {
            if (!str.equals(Constants.Value.STOP) || (v3Var = (v3) this.a.get(iWebview)) == null) {
                return null;
            }
            v3Var.b();
            return null;
        }
        String str3 = strArr[0];
        ((AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(this);
        v3 v3Var3 = (v3) this.a.get(iWebview);
        if (v3Var3 == null) {
            v3Var3 = new v3(iWebview);
            this.a.put(iWebview, v3Var3);
        }
        v3Var3.e = str3;
        v3Var3.a();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public Object onCallBack(String str, Object obj) {
        if ((!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_WINDOW_CLOSE) && !PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof IWebview)) {
            return null;
        }
        IWebview iWebview = (IWebview) obj;
        v3 v3Var = (v3) this.a.remove(iWebview);
        if (v3Var != null) {
            v3Var.b();
        }
        ((AdaFrameView) iWebview.obtainFrameView()).removeFrameViewListener(this);
        return null;
    }
}
