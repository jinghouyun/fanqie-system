package com.taobao.weex.ui.view.listview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ExtendedStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public ExtendedStaggeredGridLayoutManager(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        if (i == -1) {
            WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  Error Invalid Index : positionStart :" + i + "  itemCount:" + i2);
            return;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  positionStart :" + i + "  itemCount:" + i2);
        }
        super.onItemsRemoved(recyclerView, i, i2);
    }
}
