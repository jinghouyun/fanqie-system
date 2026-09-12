package com.taobao.weex.ui.component.list.template;

import com.taobao.weex.el.parse.ArrayStack;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class CellRenderContext {
    public int position;
    public CellRenderState renderState;
    public WXRecyclerTemplateList templateList;
    public ArrayStack stack = new ArrayStack();
    public Map map = new HashMap(8);

    public void clear() {
        if (this.stack.getList().size() > 0) {
            this.stack.getList().clear();
        }
        if (this.map.size() > 0) {
            this.map.clear();
        }
        this.renderState = null;
        this.position = 0;
        this.templateList = null;
    }

    public CellRenderState getRenderState() {
        if (this.renderState != null) {
            this.renderState = this.templateList.getCellDataManager().getRenderState(this.position);
        }
        return this.renderState;
    }
}
