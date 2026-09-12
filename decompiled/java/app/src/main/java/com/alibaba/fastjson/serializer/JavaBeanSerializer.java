package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.constant.AbsoluteConst;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected final SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public JSONType getJSONType() {
        return this.beanInfo.jsonType;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
            for (int i2 = 0; i2 < this.getters.length; i2++) {
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer != null) {
                    this.getters[i2] = fieldSerializer;
                } else {
                    FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                    System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
                    break;
                }
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class<? extends SerializeFilter> cls : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(null).newInstance(null));
                } catch (Exception unused) {
                }
            }
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Code duplicated, block: B:245:0x034c  */
    /* JADX WARN: Code duplicated, block: B:247:0x0350 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:249:0x0354 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:256:0x0370 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:257:0x0374  */
    /* JADX WARN: Code duplicated, block: B:259:0x0378 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:260:0x037a A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:261:0x037f  */
    /* JADX WARN: Code duplicated, block: B:264:0x0386  */
    /* JADX WARN: Code duplicated, block: B:266:0x0389 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:267:0x038b A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:269:0x0392 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:270:0x0394 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:272:0x03a0 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:274:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:279:0x03b5 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:284:0x03bf A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:285:0x03c9 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:286:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:288:0x03d1 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:290:0x03d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x042a A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:312:0x042e A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:318:0x0442 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:321:0x0449 A[Catch: Exception -> 0x04b4, all -> 0x04c4, TryCatch #3 {all -> 0x04c4, blocks: (B:196:0x02bf, B:198:0x02c3, B:200:0x02c7, B:203:0x02d2, B:205:0x02d6, B:207:0x02da, B:210:0x02e5, B:212:0x02e9, B:214:0x02ed, B:217:0x02f8, B:219:0x02fc, B:221:0x0300, B:224:0x030e, B:226:0x0312, B:228:0x0316, B:231:0x0324, B:233:0x0328, B:235:0x032c, B:238:0x033a, B:240:0x033e, B:242:0x0342, B:247:0x0350, B:249:0x0354, B:251:0x0358, B:254:0x0363, B:256:0x0370, B:260:0x037a, B:262:0x0380, B:319:0x0445, B:321:0x0449, B:323:0x044d, B:326:0x0456, B:328:0x045e, B:329:0x0466, B:331:0x046c, B:267:0x038b, B:268:0x038e, B:270:0x0394, B:272:0x03a0, B:279:0x03b5, B:284:0x03bf, B:288:0x03d1, B:291:0x03db, B:294:0x03e5, B:296:0x03ed, B:297:0x03fa, B:299:0x0403, B:301:0x040a, B:302:0x040e, B:304:0x0415, B:305:0x0419, B:306:0x041d, B:308:0x0422, B:309:0x0426, B:310:0x042a, B:312:0x042e, B:314:0x0432, B:317:0x043e, B:318:0x0442, B:285:0x03c9, B:335:0x0477, B:349:0x049f, B:351:0x04a5, B:353:0x04ad, B:358:0x04bc), top: B:404:0x02bf }] */
    /* JADX WARN: Code duplicated, block: B:333:0x0472  */
    /* JADX WARN: Code duplicated, block: B:373:0x04db A[Catch: all -> 0x04d1, TRY_LEAVE, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:376:0x04fb A[Catch: all -> 0x04d1, TRY_ENTER, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:377:0x0510  */
    /* JADX WARN: Code duplicated, block: B:378:0x0512 A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:382:0x051c A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:383:0x0537 A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:386:0x0553 A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:389:0x056f A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014c, B:100:0x0165, B:102:0x0173, B:104:0x0182, B:106:0x018c, B:189:0x02a1, B:191:0x02ad, B:373:0x04db, B:376:0x04fb, B:384:0x054d, B:386:0x0553, B:387:0x056b, B:389:0x056f, B:394:0x0579, B:395:0x057e, B:378:0x0512, B:380:0x0516, B:382:0x051c, B:383:0x0537, B:109:0x0196, B:111:0x01a4, B:113:0x01a8, B:116:0x01b1, B:118:0x01b5, B:119:0x01bb, B:121:0x01c1, B:123:0x01c8, B:126:0x01d2, B:128:0x01e0, B:130:0x01e4, B:133:0x01ee, B:136:0x01f5, B:138:0x01fb, B:141:0x0203, B:143:0x020b, B:145:0x0219, B:147:0x021d, B:150:0x0227, B:152:0x022b, B:153:0x0231, B:155:0x0237, B:157:0x023e, B:158:0x0243, B:160:0x024b, B:162:0x0259, B:164:0x025d, B:167:0x0267, B:169:0x026b, B:170:0x026e, B:172:0x0274, B:174:0x027b, B:176:0x0280, B:178:0x0284, B:180:0x028e, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:400:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:390:0x0574  */
    /* JADX WARN: Code duplicated, block: B:392:0x0577  */
    /* JADX WARN: Code duplicated, block: B:393:0x0578  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0133 A[PHI: r20
  0x0133: PHI (r20v10 com.alibaba.fastjson.serializer.FieldSerializer) = 
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
 binds: [B:71:0x0104, B:87:0x0131, B:182:0x0293, B:166:0x0265, B:149:0x0225, B:132:0x01ec, B:115:0x01b0, B:76:0x0115, B:63:0x00f0, B:60:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:373:0x04db, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:376:0x04fb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:382:0x051c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:383:0x0537, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:386:0x0553, please report this as an issue */
    protected void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws Throwable {
        FieldSerializer[] fieldSerializerArr;
        FieldSerializer fieldSerializer;
        Exception exc;
        String str;
        FieldInfo fieldInfo;
        Throwable cause;
        Exception exc2;
        char c;
        SerialContext serialContext;
        Exception e;
        boolean z2;
        Object propertyValueDirect;
        Object obj3;
        Object objDefaultValue;
        char c2;
        Type type2 = type;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (writeReference(jSONSerializer, obj, i)) {
            return;
        }
        if (serializeWriter.sortField) {
            fieldSerializerArr = this.sortedGetters;
        } else {
            fieldSerializerArr = this.getters;
        }
        FieldSerializer[] fieldSerializerArr2 = fieldSerializerArr;
        SerialContext serialContext2 = jSONSerializer.context;
        if (!this.beanInfo.beanType.isEnum()) {
            jSONSerializer.setContext(serialContext2, obj, obj2, this.beanInfo.features, i);
        }
        SerialContext serialContext3 = serialContext2;
        boolean zIsWriteAsArray = isWriteAsArray(jSONSerializer, i);
        char c3 = zIsWriteAsArray ? Operators.ARRAY_START : Operators.BLOCK_START;
        char c4 = zIsWriteAsArray ? Operators.ARRAY_END : Operators.BLOCK_END;
        if (!z) {
            try {
                try {
                    serializeWriter.append(c3);
                } catch (Throwable th) {
                    th = th;
                    jSONSerializer.context = serialContext3;
                    throw th;
                }
            } catch (Exception e2) {
                fieldSerializer = null;
                exc = e2;
                str = "write javaBean error, fastjson version 1.2.83";
                if (obj != null) {
                    str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                }
                if (obj2 != null) {
                    str = str + ", fieldName : " + obj2;
                } else if (fieldSerializer != null) {
                    fieldInfo = fieldSerializer.fieldInfo;
                    if (fieldInfo.method != null) {
                        str = str + ", method : " + fieldInfo.method.getName();
                    } else {
                        str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                    }
                }
                if (exc.getMessage() != null) {
                    str = str + ", " + exc.getMessage();
                }
                if (exc instanceof InvocationTargetException) {
                    cause = exc.getCause();
                } else {
                    cause = null;
                }
                if (cause == null) {
                    exc2 = exc;
                } else {
                    exc2 = cause;
                }
                throw new JSONException(str, exc2);
            }
        }
        if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
            jSONSerializer.incrementIndent();
            jSONSerializer.println();
        }
        if ((this.beanInfo.features & SerializerFeature.WriteClassName.mask) == 0 && (SerializerFeature.WriteClassName.mask & i) == 0 && !jSONSerializer.isWriteClassName(type2, obj)) {
            c = 0;
        } else {
            Class<?> cls = obj.getClass();
            if (cls != ((cls == type2 || !(type2 instanceof WildcardType)) ? type2 : TypeUtils.getClass(type2))) {
                writeClassName(jSONSerializer, this.beanInfo.typeKey, obj);
                c = Operators.ARRAY_SEPRATOR;
            } else {
                c = 0;
            }
        }
        boolean zIsEnabled = serializeWriter.isEnabled(SerializerFeature.WriteClassName);
        boolean z3 = writeBefore(jSONSerializer, obj, c) == ',';
        boolean zIsEnabled2 = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
        boolean zIsEnabled3 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
        boolean z4 = z3;
        int i2 = 0;
        FieldSerializer fieldSerializer2 = null;
        while (i2 < fieldSerializerArr2.length) {
            try {
                try {
                    try {
                        fieldSerializer = fieldSerializerArr2[i2];
                        Field field = fieldSerializer.fieldInfo.field;
                        boolean z5 = zIsWriteAsArray;
                        FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                        String str2 = fieldInfo2.name;
                        Class<?> cls2 = fieldInfo2.fieldClass;
                        int i3 = i2;
                        boolean zIsEnabled4 = SerializerFeature.isEnabled(serializeWriter.features, fieldInfo2.serialzeFeatures, SerializerFeature.UseSingleQuotes);
                        boolean z6 = serializeWriter.quoteFieldNames && !zIsEnabled4;
                        if ((zIsEnabled2 && fieldInfo2.fieldTransient) || (zIsEnabled3 && field == null)) {
                            serialContext = serialContext3;
                        } else {
                            if (applyName(jSONSerializer, obj, str2) && applyLabel(jSONSerializer, fieldInfo2.label)) {
                                z2 = false;
                            } else if (z5) {
                                z2 = true;
                            } else {
                                serialContext = serialContext3;
                            }
                            if (str2.equals(this.beanInfo.typeKey) && jSONSerializer.isWriteClassName(type2, obj)) {
                                serialContext = serialContext3;
                            } else {
                                if (z2) {
                                    propertyValueDirect = null;
                                } else {
                                    try {
                                        propertyValueDirect = fieldSerializer.getPropertyValueDirect(obj);
                                    } catch (InvocationTargetException e3) {
                                        try {
                                            if (!serializeWriter.isEnabled(SerializerFeature.IgnoreErrorGetter)) {
                                                serialContext = serialContext3;
                                                try {
                                                    throw e3;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    serialContext3 = serialContext;
                                                    exc = e;
                                                    str = "write javaBean error, fastjson version 1.2.83";
                                                    if (obj != null) {
                                                        str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                                    }
                                                    if (obj2 != null) {
                                                        str = str + ", fieldName : " + obj2;
                                                    } else if (fieldSerializer != null) {
                                                        fieldInfo = fieldSerializer.fieldInfo;
                                                        if (fieldInfo.method != null) {
                                                            str = str + ", method : " + fieldInfo.method.getName();
                                                        } else {
                                                            str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                        }
                                                    }
                                                    if (exc.getMessage() != null) {
                                                        str = str + ", " + exc.getMessage();
                                                    }
                                                    if (exc instanceof InvocationTargetException) {
                                                        cause = exc.getCause();
                                                    } else {
                                                        cause = null;
                                                    }
                                                    if (cause == null) {
                                                        exc2 = exc;
                                                    } else {
                                                        exc2 = cause;
                                                    }
                                                    throw new JSONException(str, exc2);
                                                }
                                            }
                                            fieldSerializer2 = fieldSerializer;
                                            propertyValueDirect = null;
                                        } catch (Exception e5) {
                                            exc = e5;
                                            str = "write javaBean error, fastjson version 1.2.83";
                                            if (obj != null) {
                                                str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                            }
                                            if (obj2 != null) {
                                                str = str + ", fieldName : " + obj2;
                                            } else if (fieldSerializer != null) {
                                                fieldInfo = fieldSerializer.fieldInfo;
                                                if (fieldInfo.method != null) {
                                                    str = str + ", method : " + fieldInfo.method.getName();
                                                } else {
                                                    str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                }
                                            }
                                            if (exc.getMessage() != null) {
                                                str = str + ", " + exc.getMessage();
                                            }
                                            if (exc instanceof InvocationTargetException) {
                                                cause = exc.getCause();
                                            } else {
                                                cause = null;
                                            }
                                            if (cause == null) {
                                                exc2 = exc;
                                            } else {
                                                exc2 = cause;
                                            }
                                            throw new JSONException(str, exc2);
                                        }
                                    }
                                }
                                if (apply(jSONSerializer, obj, str2, propertyValueDirect)) {
                                    if (cls2 == String.class && AbsoluteConst.XML_TRIM.equals(fieldInfo2.format) && propertyValueDirect != null) {
                                        propertyValueDirect = ((String) propertyValueDirect).trim();
                                    }
                                    Object obj4 = propertyValueDirect;
                                    String strProcessKey = processKey(jSONSerializer, obj, str2, obj4);
                                    Object objProcessValue = processValue(jSONSerializer, fieldSerializer.fieldContext, obj, str2, obj4, i);
                                    if (objProcessValue == null) {
                                        int iOf = fieldInfo2.serialzeFeatures;
                                        JSONField annotation = fieldInfo2.getAnnotation();
                                        obj3 = objProcessValue;
                                        if (this.beanInfo.jsonType != null) {
                                            iOf |= SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                        }
                                        if (annotation != null && !"".equals(annotation.defaultValue())) {
                                            objDefaultValue = annotation.defaultValue();
                                        } else if (cls2 == Boolean.class) {
                                            int i4 = SerializerFeature.WriteNullBooleanAsFalse.mask;
                                            int i5 = i4 | SerializerFeature.WriteMapNullValue.mask;
                                            if (!z5 && (iOf & i5) == 0 && (serializeWriter.features & i5) == 0) {
                                                serialContext = serialContext3;
                                            } else if ((iOf & i4) != 0) {
                                                objDefaultValue = false;
                                            } else if ((serializeWriter.features & i4) != 0 && (SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                objDefaultValue = false;
                                            }
                                        } else if (cls2 == String.class) {
                                            int i6 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                            int i7 = i6 | SerializerFeature.WriteMapNullValue.mask;
                                            if (!z5 && (iOf & i7) == 0 && (serializeWriter.features & i7) == 0) {
                                                serialContext = serialContext3;
                                            } else if ((iOf & i6) != 0 || ((serializeWriter.features & i6) != 0 && (SerializerFeature.WriteMapNullValue.mask & iOf) == 0)) {
                                                objDefaultValue = "";
                                            }
                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                            int i8 = SerializerFeature.WriteNullNumberAsZero.mask;
                                            int i9 = i8 | SerializerFeature.WriteMapNullValue.mask;
                                            if (!z5 && (iOf & i9) == 0 && (serializeWriter.features & i9) == 0) {
                                                serialContext = serialContext3;
                                            } else if ((iOf & i8) != 0) {
                                                objDefaultValue = 0;
                                            } else if ((serializeWriter.features & i8) != 0 && (SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                objDefaultValue = 0;
                                            }
                                        } else if (Collection.class.isAssignableFrom(cls2)) {
                                            int i10 = SerializerFeature.WriteNullListAsEmpty.mask;
                                            int i11 = i10 | SerializerFeature.WriteMapNullValue.mask;
                                            if (!z5 && (iOf & i11) == 0 && (serializeWriter.features & i11) == 0) {
                                                serialContext = serialContext3;
                                            } else if ((iOf & i10) != 0) {
                                                objDefaultValue = Collections.EMPTY_LIST;
                                            } else if ((serializeWriter.features & i10) != 0 && (SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                objDefaultValue = Collections.EMPTY_LIST;
                                            }
                                        } else if (!z5 && !fieldSerializer.writeNull && !serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue.mask) && (SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                            serialContext = serialContext3;
                                        }
                                        if (objDefaultValue != null || (!serializeWriter.notWriteDefaultValue && (fieldInfo2.serialzeFeatures & SerializerFeature.NotWriteDefaultValue.mask) == 0 && (this.beanInfo.features & SerializerFeature.NotWriteDefaultValue.mask) == 0)) {
                                            serialContext = serialContext3;
                                        } else {
                                            Class<?> cls3 = fieldInfo2.fieldClass;
                                            serialContext = serialContext3;
                                            try {
                                                try {
                                                    if ((cls3 != Byte.TYPE || !(objDefaultValue instanceof Byte) || ((Byte) objDefaultValue).byteValue() != 0) && ((cls3 != Short.TYPE || !(objDefaultValue instanceof Short) || ((Short) objDefaultValue).shortValue() != 0) && ((cls3 != Integer.TYPE || !(objDefaultValue instanceof Integer) || ((Integer) objDefaultValue).intValue() != 0) && ((cls3 != Long.TYPE || !(objDefaultValue instanceof Long) || ((Long) objDefaultValue).longValue() != 0) && ((cls3 != Float.TYPE || !(objDefaultValue instanceof Float) || ((Float) objDefaultValue).floatValue() != 0.0f) && ((cls3 != Double.TYPE || !(objDefaultValue instanceof Double) || ((Double) objDefaultValue).doubleValue() != 0.0d) && (cls3 != Boolean.TYPE || !(objDefaultValue instanceof Boolean) || ((Boolean) objDefaultValue).booleanValue()))))))) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    serialContext3 = serialContext;
                                                    jSONSerializer.context = serialContext3;
                                                    throw th;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                fieldSerializer = fieldSerializer2;
                                                serialContext3 = serialContext;
                                                exc = e;
                                                str = "write javaBean error, fastjson version 1.2.83";
                                                if (obj != null) {
                                                    str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                                }
                                                if (obj2 != null) {
                                                    str = str + ", fieldName : " + obj2;
                                                } else if (fieldSerializer != null) {
                                                    fieldInfo = fieldSerializer.fieldInfo;
                                                    if (fieldInfo.method != null) {
                                                        str = str + ", method : " + fieldInfo.method.getName();
                                                    } else {
                                                        str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                    }
                                                }
                                                if (exc.getMessage() != null) {
                                                    str = str + ", " + exc.getMessage();
                                                }
                                                if (exc instanceof InvocationTargetException) {
                                                    cause = exc.getCause();
                                                } else {
                                                    cause = null;
                                                }
                                                if (cause == null) {
                                                    exc2 = exc;
                                                } else {
                                                    exc2 = cause;
                                                }
                                                throw new JSONException(str, exc2);
                                            }
                                        }
                                        if (z4) {
                                            if (fieldInfo2.unwrapped || !(objDefaultValue instanceof Map) || ((Map) objDefaultValue).size() != 0) {
                                                serializeWriter.write(44);
                                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                    jSONSerializer.println();
                                                }
                                            }
                                        }
                                        if (strProcessKey != str2) {
                                            if (!z5) {
                                                serializeWriter.writeFieldName(strProcessKey, true);
                                            }
                                            jSONSerializer.write(objDefaultValue);
                                        } else if (obj4 != objDefaultValue) {
                                            if (!z5) {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                            jSONSerializer.write(objDefaultValue);
                                        } else {
                                            if (z5) {
                                                c2 = 0;
                                            } else {
                                                boolean zIsAssignableFrom = Map.class.isAssignableFrom(cls2);
                                                boolean z7 = (cls2.isPrimitive() && !cls2.getName().startsWith("java.")) || cls2 == Object.class;
                                                if (zIsEnabled && fieldInfo2.unwrapped && (zIsAssignableFrom || z7)) {
                                                    c2 = 0;
                                                } else if (z6) {
                                                    c2 = 0;
                                                    serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                } else {
                                                    c2 = 0;
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                            }
                                            if (!z5) {
                                                JSONField annotation2 = fieldInfo2.getAnnotation();
                                                if (cls2 == String.class || !(annotation2 == null || annotation2.serializeUsing() == Void.class)) {
                                                    if (!fieldInfo2.unwrapped && (objDefaultValue instanceof Map) && ((Map) objDefaultValue).size() == 0) {
                                                        z4 = false;
                                                    } else {
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    }
                                                } else if (objDefaultValue == null) {
                                                    int iOf2 = fieldSerializer.features;
                                                    if (this.beanInfo.jsonType != null) {
                                                        iOf2 |= SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                                    }
                                                    if (((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0 && (SerializerFeature.WriteMapNullValue.mask & iOf2) == 0) || (iOf2 & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                                                        serializeWriter.writeString("");
                                                    } else {
                                                        serializeWriter.writeNull();
                                                    }
                                                } else {
                                                    String str3 = (String) objDefaultValue;
                                                    if (zIsEnabled4) {
                                                        serializeWriter.writeStringWithSingleQuote(str3);
                                                    } else {
                                                        serializeWriter.writeStringWithDoubleQuote(str3, c2);
                                                    }
                                                }
                                            } else {
                                                fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                            }
                                            if (!fieldInfo2.unwrapped || !(objDefaultValue instanceof Map)) {
                                                z4 = true;
                                                break;
                                            }
                                            Map map = (Map) objDefaultValue;
                                            if (map.size() != 0) {
                                                if (jSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                                    z4 = true;
                                                    break;
                                                    break;
                                                }
                                                Iterator it = map.values().iterator();
                                                while (it.hasNext()) {
                                                    if (it.next() != null) {
                                                        z4 = true;
                                                        break;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (!fieldInfo2.unwrapped) {
                                            z4 = true;
                                            break;
                                            break;
                                        } else {
                                            z4 = true;
                                            break;
                                            break;
                                        }
                                    }
                                    obj3 = objProcessValue;
                                    objDefaultValue = obj3;
                                    if (objDefaultValue != null) {
                                        serialContext = serialContext3;
                                        if (z4) {
                                            if (fieldInfo2.unwrapped) {
                                            }
                                            serializeWriter.write(44);
                                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                jSONSerializer.println();
                                            }
                                        }
                                        if (strProcessKey != str2) {
                                            if (obj4 != objDefaultValue) {
                                                if (!z5) {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                                jSONSerializer.write(objDefaultValue);
                                            } else {
                                                if (z5) {
                                                    boolean zIsAssignableFrom2 = Map.class.isAssignableFrom(cls2);
                                                    if (cls2.isPrimitive()) {
                                                    }
                                                    if (zIsEnabled) {
                                                    }
                                                    if (z6) {
                                                        c2 = 0;
                                                        serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                    } else {
                                                        c2 = 0;
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                } else {
                                                    c2 = 0;
                                                }
                                                if (!z5) {
                                                    JSONField annotation3 = fieldInfo2.getAnnotation();
                                                    if (cls2 == String.class) {
                                                        if (!fieldInfo2.unwrapped) {
                                                        }
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    } else {
                                                        if (!fieldInfo2.unwrapped) {
                                                        }
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    }
                                                } else {
                                                    fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                }
                                                if (!fieldInfo2.unwrapped) {
                                                    z4 = true;
                                                    break;
                                                    break;
                                                } else {
                                                    z4 = true;
                                                    break;
                                                    break;
                                                }
                                            }
                                        } else {
                                            if (!z5) {
                                                serializeWriter.writeFieldName(strProcessKey, true);
                                            }
                                            jSONSerializer.write(objDefaultValue);
                                        }
                                        if (!fieldInfo2.unwrapped) {
                                            z4 = true;
                                            break;
                                            break;
                                        } else {
                                            z4 = true;
                                            break;
                                            break;
                                        }
                                    }
                                    serialContext = serialContext3;
                                    if (z4) {
                                        if (fieldInfo2.unwrapped) {
                                        }
                                        serializeWriter.write(44);
                                        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                            jSONSerializer.println();
                                        }
                                    }
                                    if (strProcessKey != str2) {
                                        if (obj4 != objDefaultValue) {
                                            if (!z5) {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                            jSONSerializer.write(objDefaultValue);
                                        } else {
                                            if (z5) {
                                                boolean zIsAssignableFrom3 = Map.class.isAssignableFrom(cls2);
                                                if (cls2.isPrimitive()) {
                                                }
                                                if (zIsEnabled) {
                                                }
                                                if (z6) {
                                                    c2 = 0;
                                                    serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                } else {
                                                    c2 = 0;
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                            } else {
                                                c2 = 0;
                                            }
                                            if (!z5) {
                                                JSONField annotation4 = fieldInfo2.getAnnotation();
                                                if (cls2 == String.class) {
                                                    if (!fieldInfo2.unwrapped) {
                                                    }
                                                    fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                } else {
                                                    if (!fieldInfo2.unwrapped) {
                                                    }
                                                    fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                }
                                            } else {
                                                fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                            }
                                            if (!fieldInfo2.unwrapped) {
                                                z4 = true;
                                                break;
                                                break;
                                            } else {
                                                z4 = true;
                                                break;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (!z5) {
                                            serializeWriter.writeFieldName(strProcessKey, true);
                                        }
                                        jSONSerializer.write(objDefaultValue);
                                    }
                                    if (!fieldInfo2.unwrapped) {
                                        z4 = true;
                                        break;
                                        break;
                                    } else {
                                        z4 = true;
                                        break;
                                        break;
                                    }
                                }
                                serialContext = serialContext3;
                            }
                        }
                        i2 = i3 + 1;
                        type2 = type;
                        zIsWriteAsArray = z5;
                        serialContext3 = serialContext;
                    } catch (Exception e7) {
                        e = e7;
                        fieldSerializer = fieldSerializer2;
                        exc = e;
                        str = "write javaBean error, fastjson version 1.2.83";
                        if (obj != null) {
                            str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                        }
                        if (obj2 != null) {
                            str = str + ", fieldName : " + obj2;
                        } else if (fieldSerializer != null && fieldSerializer.fieldInfo != null) {
                            fieldInfo = fieldSerializer.fieldInfo;
                            if (fieldInfo.method != null) {
                                str = str + ", method : " + fieldInfo.method.getName();
                            } else {
                                str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                            }
                        }
                        if (exc.getMessage() != null) {
                            str = str + ", " + exc.getMessage();
                        }
                        if (exc instanceof InvocationTargetException) {
                            cause = exc.getCause();
                        } else {
                            cause = null;
                        }
                        if (cause == null) {
                            exc2 = exc;
                        } else {
                            exc2 = cause;
                        }
                        throw new JSONException(str, exc2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e8) {
                e = e8;
            }
        }
        serialContext = serialContext3;
        try {
            writeAfter(jSONSerializer, obj, z4 ? Operators.ARRAY_SEPRATOR : (char) 0);
            if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
            }
            if (!z) {
                serializeWriter.append(c4);
            }
            jSONSerializer.context = serialContext;
        } catch (Exception e9) {
            e = e9;
            serialContext3 = serialContext;
            fieldSerializer = fieldSerializer2;
            exc = e;
            str = "write javaBean error, fastjson version 1.2.83";
            if (obj != null) {
                str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
            }
            if (obj2 != null) {
                str = str + ", fieldName : " + obj2;
            } else if (fieldSerializer != null) {
                fieldInfo = fieldSerializer.fieldInfo;
                if (fieldInfo.method != null) {
                    str = str + ", method : " + fieldInfo.method.getName();
                } else {
                    str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                }
            }
            if (exc.getMessage() != null) {
                str = str + ", " + exc.getMessage();
            }
            if (exc instanceof InvocationTargetException) {
                cause = exc.getCause();
            } else {
                cause = null;
            }
            if (cause == null) {
                exc2 = exc;
            } else {
                exc2 = cause;
            }
            throw new JSONException(str, exc2);
        }
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String name = this.beanInfo.typeName;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (TypeUtils.isProxy(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        jSONSerializer.write(name);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (!z) {
                return null;
            }
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int iCompareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i = i2 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArrValues;
        int iBinarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArrValues.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArrValues) {
                    String strTranslate = propertyNamingStrategy.translate(str);
                    if (!str.equals(strTranslate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(strTranslate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArrValues == null) {
                propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int iBinarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArrValues) {
                    String strTranslate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(strTranslate2) && (iBinarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(strTranslate2))) >= 0) {
                        sArr[iBinarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[iBinarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean zIsEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!zIsEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldSerializer.fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    protected BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            Iterator<BeforeFilter> it = jSONSerializer.beforeFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            Iterator<BeforeFilter> it2 = this.beforeFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            Iterator<AfterFilter> it = jSONSerializer.afterFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            Iterator<AfterFilter> it2 = this.afterFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            Iterator<LabelFilter> it = jSONSerializer.labelFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = this.labelFilters.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }
}
