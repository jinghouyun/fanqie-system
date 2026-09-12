package io.dcloud.uts;

import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Boolean.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\t\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\b\u000b\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0007¢\u0006\u0002\b\r\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\b\u000f\u001a%\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003\u0018\u00010\u0010j\b\u0012\u0002\b\u0003\u0018\u0001`\u0011H\u0007¢\u0006\u0002\b\u0012\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0007¢\u0006\u0002\b\u0014\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\b\u0016\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\b\u0018\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0019¨\u0006\u001a"}, d2 = {"isTruthy", "", "value", "(Ljava/lang/Boolean;)Z", "", "isTruthy_string", "", "isTruthy_number", "Lio/dcloud/uts/UTSJSONObject;", "isTruthy_json", "Lio/dcloud/uts/UTSObject;", "isTruthy_utsobj", "Lio/dcloud/uts/UTSArray;", "isTruthy_array", "Lio/dcloud/uts/ArrayBuffer;", "isTruthy_arraybuffer", "Ljava/util/LinkedHashSet;", "Lio/dcloud/uts/Set;", "isTruthy_set", "Lio/dcloud/uts/Map;", "isTruthy_map", "Lio/dcloud/uts/UTSRegExp;", "isTruthy_regexp", "Lio/dcloud/uts/Date;", "isTruthy_date", "", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BooleanKt {
    public static final boolean isTruthy_array(UTSArray<?> uTSArray) {
        return uTSArray != null;
    }

    public static final boolean isTruthy_arraybuffer(ArrayBuffer arrayBuffer) {
        return arrayBuffer != null;
    }

    public static final boolean isTruthy_date(Date date) {
        return date != null;
    }

    public static final boolean isTruthy_json(UTSJSONObject uTSJSONObject) {
        return uTSJSONObject != null;
    }

    public static final boolean isTruthy_map(Map<?, ?> map) {
        return map != null;
    }

    public static final boolean isTruthy_regexp(UTSRegExp uTSRegExp) {
        return uTSRegExp != null;
    }

    public static final boolean isTruthy_set(LinkedHashSet<?> linkedHashSet) {
        return linkedHashSet != null;
    }

    public static final boolean isTruthy_utsobj(UTSObject uTSObject) {
        return uTSObject != null;
    }

    public static final boolean isTruthy(Boolean bool) {
        return Intrinsics.areEqual((java.lang.Object) bool, (java.lang.Object) true);
    }

    public static final boolean isTruthy_string(String str) {
        return str != null && str.length() > 0;
    }

    public static final boolean isTruthy_number(Number number) {
        if (number == null) {
            return false;
        }
        if (number instanceof Double) {
            return (Intrinsics.areEqual((Double) number, 0.0d) || Double.isNaN(number.doubleValue())) ? false : true;
        }
        if (number instanceof Float) {
            return (Intrinsics.areEqual((Float) number, 0.0f) || Float.isNaN(number.floatValue())) ? false : true;
        }
        if (number instanceof Integer) {
            return !Intrinsics.areEqual((java.lang.Object) number, (java.lang.Object) 0);
        }
        if (number instanceof Long) {
            return !Intrinsics.areEqual((java.lang.Object) number, (java.lang.Object) 0L);
        }
        if (number instanceof Short) {
            return number.shortValue() != 0;
        }
        if (number instanceof Byte) {
            return number.byteValue() != 0;
        }
        double dDoubleValue = number.doubleValue();
        return (dDoubleValue == 0.0d || Double.isNaN(dDoubleValue)) ? false : true;
    }

    public static final boolean isTruthy(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Number) {
            return isTruthy_number((Number) obj);
        }
        if (obj instanceof String) {
            return ((CharSequence) obj).length() > 0;
        }
        return !(obj instanceof Unit);
    }
}
