package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface RichTextNodeCreator<T extends RichTextNode> {
    T createRichTextNode(Context context, String str, String str2);

    T createRichTextNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);
}
