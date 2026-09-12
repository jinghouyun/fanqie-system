package io.dcloud.feature.weex_text;

import android.content.Context;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import io.dcloud.feature.weex.WeexInstanceMgr;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCWXTextPlugin {
    public static void initPlugin(Context context) {
        try {
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(DCWXText.class, new DCWXText.Creator()), false, "u-text");
            WXSDKEngine.registerComponent((IFComponentHolder) new SimpleComponentHolder(DCWXRichText.class, new DCWXRichText.Creator()), false, "u-rich-text");
            WeexInstanceMgr.self().addComponentByName("text", DCWXText.class);
            WeexInstanceMgr.self().addComponentByName("rich-text", DCWXRichText.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
