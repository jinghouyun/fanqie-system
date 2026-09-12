package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class RichTextNodeManager {
    private static final Map<String, RichTextNodeCreator> registeredTextNodes;

    static {
        ArrayMap arrayMap = new ArrayMap();
        registeredTextNodes = arrayMap;
        arrayMap.put(SpanNode.NODE_TYPE, new SpanNode.SpanNodeCreator());
        arrayMap.put("image", new ImgNode.ImgNodeCreator());
        arrayMap.put("a", new ANode.ANodeCreator());
    }

    static RichTextNode createRichTextNode(Context context, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                RichTextNode richTextNodeCreateRichTextNode = registeredTextNodes.get(jSONObject.getString("type")).createRichTextNode(context, str, str2);
                richTextNodeCreateRichTextNode.parse(context, str, str2, jSONObject);
                return richTextNodeCreateRichTextNode;
            } catch (Exception e) {
                WXLogUtils.e("Richtext", WXLogUtils.getStackTrace(e));
            }
        }
        return null;
    }

    public static void registerTextNode(String str, RichTextNodeCreator richTextNodeCreator) {
        registeredTextNodes.put(str, richTextNodeCreator);
    }

    public static RichTextNode createRichTextNode(Context context, String str, String str2, String str3, String str4, Map<String, String> map, Map<String, String> map2) {
        try {
            return registeredTextNodes.get(str4).createRichTextNode(context, str, str2, str3, map, map2);
        } catch (Exception e) {
            WXLogUtils.e("Richtext", WXLogUtils.getStackTrace(e));
            return null;
        }
    }
}
