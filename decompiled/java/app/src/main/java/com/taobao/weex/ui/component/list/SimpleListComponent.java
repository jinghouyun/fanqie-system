package com.taobao.weex.ui.component.list;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleListComponent extends BasicListComponent<SimpleRecyclerView> {
    public SimpleListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public SimpleRecyclerView generateListView(Context context, int i) {
        SimpleRecyclerView simpleRecyclerView = new SimpleRecyclerView(context);
        simpleRecyclerView.initView(context, 1, i);
        return simpleRecyclerView;
    }
}
