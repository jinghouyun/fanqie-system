package io.dcloud.feature.weex_scroller;

import android.content.Context;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import com.taobao.weex.ui.component.DCWXScroller;
import io.dcloud.feature.weex.WeexInstanceMgr;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCScrollerPluginImpl {
    public static void initPlugin(Context context) {
        try {
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(DCWXScroller.class, new DCWXScroller.Creator()), false, "scroll-view");
            WeexInstanceMgr.self().addComponentByName("scroll-view", DCWXScroller.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
