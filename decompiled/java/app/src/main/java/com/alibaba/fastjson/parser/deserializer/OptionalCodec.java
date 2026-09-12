package com.alibaba.fastjson.parser.deserializer;

import androidx.webkit.internal.ApiHelperForO$$ExternalSyntheticApiModelOutline2;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.taobao.weex.WXSDKInstance$$ExternalSyntheticApiModelOutline0;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX INFO: loaded from: classes.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$10()) {
            Integer numCastToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class) Integer.class));
            if (numCastToInt == null) {
                return (T) OptionalInt.empty();
            }
            return (T) OptionalInt.of(numCastToInt.intValue());
        }
        if (type == WXSDKInstance$$ExternalSyntheticApiModelOutline0.m390m()) {
            Long lCastToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class) Long.class));
            if (lCastToLong == null) {
                return (T) OptionalLong.empty();
            }
            return (T) OptionalLong.of(lCastToLong.longValue());
        }
        if (type == WXSDKInstance$$ExternalSyntheticApiModelOutline0.m411m$1()) {
            Double dCastToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class) Double.class));
            if (dCastToDouble == null) {
                return (T) OptionalDouble.empty();
            }
            return (T) OptionalDouble.of(dCastToDouble.doubleValue());
        }
        Object object = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
        if (object == null) {
            return (T) Optional.empty();
        }
        return (T) Optional.of(object);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        if (WXSDKInstance$$ExternalSyntheticApiModelOutline0.m$1(obj)) {
            Optional optionalM393m = WXSDKInstance$$ExternalSyntheticApiModelOutline0.m393m(obj);
            jSONSerializer.write(optionalM393m.isPresent() ? optionalM393m.get() : null);
            return;
        }
        if (ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$2(obj)) {
            OptionalDouble optionalDoubleM184m = ApiHelperForO$$ExternalSyntheticApiModelOutline2.m184m(obj);
            if (optionalDoubleM184m.isPresent()) {
                jSONSerializer.write(Double.valueOf(optionalDoubleM184m.getAsDouble()));
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (WXSDKInstance$$ExternalSyntheticApiModelOutline0.m407m(obj)) {
            OptionalInt optionalIntM396m = WXSDKInstance$$ExternalSyntheticApiModelOutline0.m396m(obj);
            if (optionalIntM396m.isPresent()) {
                jSONSerializer.out.writeInt(optionalIntM396m.getAsInt());
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (WXSDKInstance$$ExternalSyntheticApiModelOutline0.m$2(obj)) {
            OptionalLong optionalLongM399m = WXSDKInstance$$ExternalSyntheticApiModelOutline0.m399m(obj);
            if (optionalLongM399m.isPresent()) {
                jSONSerializer.out.writeLong(optionalLongM399m.getAsLong());
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        throw new JSONException("not support optional : " + obj.getClass());
    }
}
