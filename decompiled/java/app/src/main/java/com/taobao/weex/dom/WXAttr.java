package com.taobao.weex.dom;

import androidx.collection.ArrayMap;
import com.taobao.weex.dom.binding.WXStatement;
import io.dcloud.feature.uniapp.dom.AbsAttr;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXAttr extends AbsAttr {
    public WXAttr() {
    }

    public WXAttr(Map<String, Object> map) {
        super(map);
    }

    public WXAttr(Map<String, Object> map, int i) {
        super(map, i);
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsAttr
    /* JADX INFO: renamed from: clone */
    public WXAttr mo416clone() {
        WXAttr wXAttr = new WXAttr();
        wXAttr.skipFilterPutAll(getAttr());
        if (getBindingAttrs() != null) {
            wXAttr.setBindingAttrs(new ArrayMap<>(getBindingAttrs()));
        }
        if (getStatement() != null) {
            wXAttr.setStatement(new WXStatement(getStatement()));
        }
        return wXAttr;
    }
}
