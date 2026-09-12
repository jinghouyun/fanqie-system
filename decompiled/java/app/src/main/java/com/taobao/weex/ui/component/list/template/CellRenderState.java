package com.taobao.weex.ui.component.list.template;

import com.taobao.weex.el.parse.ArrayStack;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class CellRenderState {
    private Map<String, ArrayStack> onceComponentStates;
    int position;
    private Map<String, Object> virtualComponentDatas;
    private Map<String, String> virtualComponentIds;
    boolean hasVirtualCompoentUpdate = false;
    boolean hasDataUpdate = false;
    boolean hasPositionChange = false;
    long itemId = -1;

    public Map<String, ArrayStack> getOnceComponentStates() {
        if (this.onceComponentStates == null) {
            this.onceComponentStates = new HashMap();
        }
        return this.onceComponentStates;
    }

    public Map<String, Object> getVirtualComponentDatas() {
        if (this.virtualComponentDatas == null) {
            this.virtualComponentDatas = new HashMap(4);
        }
        return this.virtualComponentDatas;
    }

    public Map<String, String> getVirtualComponentIds() {
        if (this.virtualComponentIds == null) {
            this.virtualComponentIds = new HashMap(8);
        }
        return this.virtualComponentIds;
    }

    public boolean hasVirtualComponents() {
        Map<String, String> map = this.virtualComponentIds;
        return map != null && map.size() > 0;
    }

    public boolean isDirty() {
        return this.hasDataUpdate || this.hasVirtualCompoentUpdate || this.hasPositionChange;
    }

    public boolean isHasDataUpdate() {
        return this.hasDataUpdate;
    }

    public void resetDirty() {
        this.hasDataUpdate = false;
        this.hasVirtualCompoentUpdate = false;
        this.hasPositionChange = false;
    }
}
