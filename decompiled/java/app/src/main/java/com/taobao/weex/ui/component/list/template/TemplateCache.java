package com.taobao.weex.ui.component.list.template;

import com.taobao.weex.ui.component.list.WXCell;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class TemplateCache {
    ConcurrentLinkedQueue<WXCell> cells = new ConcurrentLinkedQueue<>();
    boolean isLoadIng = false;

    TemplateCache() {
    }
}
