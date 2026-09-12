package com.taobao.weex.dom;

import androidx.collection.ArrayMap;
import io.dcloud.feature.uniapp.dom.AbsStyle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXStyle extends AbsStyle {
    public WXStyle() {
    }

    public WXStyle(Map<String, Object> map) {
        super(map);
    }

    public WXStyle(Map<String, Object> map, boolean z) {
        super(map, z);
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsStyle
    /* JADX INFO: renamed from: clone */
    public WXStyle mo417clone() {
        WXStyle wXStyle = new WXStyle();
        wXStyle.mStyles.putAll(this.mStyles);
        if (this.mBindingStyle != null) {
            wXStyle.mBindingStyle = new ArrayMap<>(this.mBindingStyle);
        }
        if (this.mPesudoStyleMap != null) {
            wXStyle.mPesudoStyleMap = new ArrayMap();
            for (Map.Entry<String, Map<String, Object>> entry : this.mPesudoStyleMap.entrySet()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.putAll(entry.getValue());
                wXStyle.mPesudoStyleMap.put(entry.getKey(), arrayMap);
            }
        }
        if (this.mPesudoResetStyleMap != null) {
            ArrayMap arrayMap2 = new ArrayMap();
            wXStyle.mPesudoResetStyleMap = arrayMap2;
            arrayMap2.putAll(this.mPesudoResetStyleMap);
        }
        return wXStyle;
    }
}
