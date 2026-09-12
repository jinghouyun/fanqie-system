package io.dcloud.p;

import android.content.Context;
import com.taobao.weex.common.Constants;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.PdrUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class o3 implements IEventCallback {
    private HashMap a = new HashMap();
    Context b;

    public o3(Context context) {
        this.b = context;
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public Object onCallBack(String str, Object obj) {
        if ((!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_WINDOW_CLOSE) && !PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof IWebview)) {
            return null;
        }
        IWebview iWebview = (IWebview) obj;
        a(iWebview);
        ((AdaFrameView) iWebview.obtainFrameView()).removeFrameViewListener(this);
        return null;
    }

    public String a(IWebview iWebview, String str, String[] strArr) {
        if (str.equals("start")) {
            a(iWebview, strArr[0]);
            ((AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(this);
            return "";
        }
        if (str.equals(Constants.Value.STOP)) {
            a(iWebview);
        }
        return "";
    }

    private void a(IWebview iWebview, String str) {
        n3 n3Var = (n3) this.a.get(iWebview);
        if (n3Var == null) {
            n3Var = new n3(iWebview, str);
            this.a.put(iWebview, n3Var);
        }
        n3Var.a();
    }

    private void a(IWebview iWebview) {
        n3 n3Var = (n3) this.a.remove(iWebview);
        if (n3Var != null) {
            n3Var.b();
        }
    }
}
