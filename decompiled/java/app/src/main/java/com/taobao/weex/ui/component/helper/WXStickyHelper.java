package com.taobao.weex.ui.component.helper;

import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXStickyHelper {
    private Scrollable scrollable;

    public WXStickyHelper(Scrollable scrollable) {
        this.scrollable = scrollable;
    }

    public void bindStickStyle(WXComponent wXComponent, Map<String, Map<String, WXComponent>> map) {
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null) {
            return;
        }
        Map<String, WXComponent> concurrentHashMap = map.get(parentScroller.getRef());
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        if (concurrentHashMap.containsKey(wXComponent.getRef())) {
            return;
        }
        concurrentHashMap.put(wXComponent.getRef(), wXComponent);
        map.put(parentScroller.getRef(), concurrentHashMap);
    }

    public void unbindStickStyle(WXComponent wXComponent, Map<String, Map<String, WXComponent>> map) {
        Map<String, WXComponent> map2;
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null || (map2 = map.get(parentScroller.getRef())) == null) {
            return;
        }
        map2.remove(wXComponent.getRef());
    }
}
