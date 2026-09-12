package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class GraphicActionBatchAction extends BasicGraphicAction {
    private List<BasicGraphicAction> mActions;

    public GraphicActionBatchAction(WXSDKInstance wXSDKInstance, String str, List<BasicGraphicAction> list) {
        super(wXSDKInstance, str);
        this.mActions = new ArrayList(list);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        for (int i = 0; i < this.mActions.size(); i++) {
            this.mActions.get(i).executeAction();
        }
    }
}
