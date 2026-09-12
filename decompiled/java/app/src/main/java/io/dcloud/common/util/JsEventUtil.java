package io.dcloud.common.util;

import com.taobao.weex.el.parse.Operators;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class JsEventUtil {
    public static String broadcastEvents_format(String str, String str2, boolean z, String... strArr) {
        StringBuilder sb = new StringBuilder("{evt:'%s',args:");
        sb.append(z ? "'%s'" : "%s");
        sb.append(",callbackId:'%s'}");
        return StringUtil.format(sb.toString(), str, str2, strArr);
    }

    public static String eventListener_format(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder("{evt:'%s',args:");
        sb.append(z ? "'%s'" : "%s");
        sb.append(Operators.BLOCK_END_STR);
        return StringUtil.format(sb.toString(), str, str2);
    }
}
