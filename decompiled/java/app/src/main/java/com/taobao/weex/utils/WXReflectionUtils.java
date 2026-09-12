package com.taobao.weex.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXReflectionUtils {
    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object parseArgument(Type type, Object obj) {
        if (obj == null || (obj.getClass() != type && (!(type instanceof Class) || !((Class) type).isAssignableFrom(obj.getClass())))) {
            if (type != String.class) {
                Class<?> cls = Integer.TYPE;
                if (type != cls) {
                    Class<?> cls2 = Long.TYPE;
                    if (type != cls2) {
                        Class<?> cls3 = Double.TYPE;
                        if (type != cls3) {
                            Class<?> cls4 = Float.TYPE;
                            if (type == cls4) {
                                if (!obj.getClass().isAssignableFrom(cls4)) {
                                    return Float.valueOf(WXUtils.getFloat(obj));
                                }
                            } else if ((type != JSONArray.class || obj == null || obj.getClass() != JSONArray.class) && (type != JSONObject.class || obj == null || obj.getClass() != JSONObject.class)) {
                                return JSON.parseObject(obj instanceof String ? (String) obj : JSON.toJSONString(obj), type, new Feature[0]);
                            }
                        } else if (!obj.getClass().isAssignableFrom(cls3)) {
                            return Double.valueOf(WXUtils.getDouble(obj));
                        }
                    } else if (!obj.getClass().isAssignableFrom(cls2)) {
                        return Long.valueOf(WXUtils.getLong(obj));
                    }
                } else if (!obj.getClass().isAssignableFrom(cls)) {
                    return Integer.valueOf(WXUtils.getInt(obj));
                }
            } else if (!(obj instanceof String)) {
                return JSON.toJSONString(obj);
            }
        }
        return obj;
    }

    public static void setProperty(Object obj, Field field, Object obj2) {
        if (obj == null || field == null) {
            return;
        }
        try {
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    public static void setValue(Object obj, String str, Object obj2) {
        Object objValueOf;
        if (obj == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Field declaredField = getDeclaredField(obj, str);
            if (!(obj2 instanceof BigDecimal) && !(obj2 instanceof Number) && !(obj2 instanceof String)) {
                objValueOf = obj2;
            } else if (declaredField.getType() == Float.class || declaredField.getType() == Float.TYPE) {
                objValueOf = Float.valueOf(Float.parseFloat(obj2.toString()));
            } else if (declaredField.getType() == Double.class || declaredField.getType() == Double.TYPE) {
                objValueOf = Double.valueOf(Double.parseDouble(obj2.toString()));
            } else if (declaredField.getType() == Integer.class || declaredField.getType() == Integer.TYPE) {
                objValueOf = Integer.valueOf((int) Double.parseDouble(obj2.toString()));
            } else if (declaredField.getType() == Boolean.class || declaredField.getType() == Boolean.TYPE) {
                objValueOf = Boolean.valueOf(obj2.toString());
            } else {
                objValueOf = obj2;
            }
            if ((declaredField.getType() == Boolean.TYPE || declaredField.getType() == Boolean.class) && obj2 != null) {
                objValueOf = Boolean.valueOf(obj2.toString());
            }
            setProperty(obj, declaredField, objValueOf);
        } catch (Exception unused) {
        }
    }
}
