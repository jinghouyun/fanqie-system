package com.alibaba.fastjson.serializer;

import com.taobao.weex.WXSDKInstance$$ExternalSyntheticApiModelOutline0;
import com.taobao.weex.el.parse.Operators;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (WXSDKInstance$$ExternalSyntheticApiModelOutline0.m$3(obj)) {
            serializeWriter.writeFieldValue(Operators.BLOCK_START, "value", WXSDKInstance$$ExternalSyntheticApiModelOutline0.m401m(obj).longValue());
            serializeWriter.write(125);
        } else if (WXSDKInstance$$ExternalSyntheticApiModelOutline0.m$4(obj)) {
            serializeWriter.writeFieldValue(Operators.BLOCK_START, "value", WXSDKInstance$$ExternalSyntheticApiModelOutline0.m400m(obj).doubleValue());
            serializeWriter.write(125);
        }
    }
}
