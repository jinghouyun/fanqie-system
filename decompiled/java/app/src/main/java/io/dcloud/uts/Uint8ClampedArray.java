package io.dcloud.uts;

import com.taobao.weex.common.Constants;
import io.dcloud.uts.utils.IndexKt;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Uint8ClampedArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0013J_\u0010\u0014\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00162K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u001b0\u0018H\u0016J_\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00162K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\u001c\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006$"}, d2 = {"Lio/dcloud/uts/Uint8ClampedArray;", "Lio/dcloud/uts/Uint8Array;", "length", "", "<init>", "(Ljava/lang/Number;)V", "array", "", "(Ljava/util/Collection;)V", "buffer", "Lio/dcloud/uts/ArrayBuffer;", "(Lio/dcloud/uts/ArrayBuffer;)V", "byteOffset", "(Lio/dcloud/uts/ArrayBuffer;Ljava/lang/Number;Ljava/lang/Number;)V", "putAuto", "", "index", "", "value", "(Ljava/lang/Integer;Ljava/lang/Number;)V", Constants.Name.FILTER, "T", "Lio/dcloud/uts/TypedArray;", "predicate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "map", "callbackfn", "slice", "start", "end", "subarray", "begin", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Uint8ClampedArray extends Uint8Array {
    public static final int BYTES_PER_ELEMENT = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: Uint8ClampedArray.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/Uint8ClampedArray$Companion;", "", "<init>", "()V", "BYTES_PER_ELEMENT", "", "of", "Lio/dcloud/uts/Uint8ClampedArray;", "items", "", "", "([Ljava/lang/Number;)Lio/dcloud/uts/Uint8ClampedArray;", "from", "arrayLike", "", "mapFn", "Lkotlin/Function2;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uint8ClampedArray of(Number... items) {
            Intrinsics.checkNotNullParameter(items, "items");
            Uint8ClampedArray uint8ClampedArray = new Uint8ClampedArray(Integer.valueOf(items.length));
            ArrayList arrayList = new ArrayList(items.length);
            for (Number number : items) {
                TypedArray.putAuto$default(uint8ClampedArray, null, Byte.valueOf(number.byteValue()), 1, null);
                arrayList.add(Unit.INSTANCE);
            }
            return uint8ClampedArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Uint8ClampedArray from$default(Companion companion, Collection collection, Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from(collection, function2);
        }

        public final Uint8ClampedArray from(Collection<? extends Number> arrayLike, Function2<? super Number, ? super Number, ? extends Number> mapFn) {
            Intrinsics.checkNotNullParameter(arrayLike, "arrayLike");
            Uint8ClampedArray uint8ClampedArray = new Uint8ClampedArray(Integer.valueOf(arrayLike.size()));
            int i = 0;
            for (Number number : arrayLike) {
                if (mapFn != null) {
                    TypedArray.putAuto$default(uint8ClampedArray, null, Byte.valueOf(mapFn.invoke(number, Integer.valueOf(i)).byteValue()), 1, null);
                } else {
                    TypedArray.putAuto$default(uint8ClampedArray, null, Byte.valueOf(number.byteValue()), 1, null);
                }
                i++;
            }
            return uint8ClampedArray;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(Number length) {
        super(length);
        Intrinsics.checkNotNullParameter(length, "length");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(Collection<? extends Number> array) {
        super(array);
        Intrinsics.checkNotNullParameter(array, "array");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(ArrayBuffer buffer) {
        super(buffer);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    public /* synthetic */ Uint8ClampedArray(ArrayBuffer arrayBuffer, Number number, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayBuffer, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : number2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(ArrayBuffer buffer, Number number, Number number2) {
        super(buffer, number, number2);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public void putAuto(Integer index, Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (NumberKt.compareTo(value, (Number) 0) < 0) {
            value = (Number) 0;
        } else if (NumberKt.compareTo(value, (Number) 255) > 0) {
            value = (Number) 255;
        }
        super.putAuto(index, value);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public <T extends TypedArray> Uint8ClampedArray filter(Function3<? super Number, ? super Number, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        UTSArray uTSArray = new UTSArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            Number auto = getAuto(i);
            Integer numValueOf = Integer.valueOf(auto.intValue());
            Integer numValueOf2 = Integer.valueOf(i);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8ClampedArray.filter");
            if (predicate.invoke(numValueOf, numValueOf2, this).booleanValue()) {
                uTSArray.add(Integer.valueOf(auto.intValue()));
            }
        }
        return new Uint8ClampedArray(uTSArray);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public <T extends TypedArray> Uint8ClampedArray map(Function3<? super Number, ? super Number, ? super T, ? extends Number> callbackfn) {
        Intrinsics.checkNotNullParameter(callbackfn, "callbackfn");
        int size = size();
        UTSArray uTSArray = new UTSArray();
        for (int i = 0; i < size; i++) {
            Number auto = getAuto(i);
            Integer numValueOf = Integer.valueOf(i);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8ClampedArray.map");
            uTSArray.add(Integer.valueOf(callbackfn.invoke(auto, numValueOf, this).intValue()));
        }
        return new Uint8ClampedArray(uTSArray);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public Uint8ClampedArray slice(Number start, Number end) {
        if (start == null) {
            start = (Number) 0;
        }
        if (end == null) {
            end = Integer.valueOf(getLength().intValue());
        }
        UTSArray uTSArray = new UTSArray();
        int sliceIndex = IndexKt.toSliceIndex(end, getLength().intValue());
        for (int sliceIndex2 = IndexKt.toSliceIndex(start, getLength().intValue()); sliceIndex2 < sliceIndex; sliceIndex2++) {
            uTSArray.add(getAuto(sliceIndex2));
        }
        return new Uint8ClampedArray(uTSArray);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public Uint8ClampedArray subarray(Number begin, Number end) {
        if (begin != null) {
            if (NumberKt.compareTo(begin, (Number) 0) < 0) {
                begin = NumberKt.plus(getLength(), begin);
            }
            if (begin == null) {
                begin = (Number) 0;
            }
        } else {
            begin = (Number) 0;
        }
        if (end != null) {
            if (NumberKt.compareTo(end, (Number) 0) < 0) {
                end = NumberKt.plus(getLength(), end);
            }
            if (end == null) {
                end = getLength();
            }
        } else {
            end = getLength();
        }
        int iCoerceIn = RangesKt.coerceIn(begin.intValue(), 0, getLength().intValue());
        int iCoerceIn2 = RangesKt.coerceIn(end.intValue(), iCoerceIn, getLength().intValue());
        UTSArray uTSArray = new UTSArray();
        while (iCoerceIn < iCoerceIn2) {
            uTSArray.push(getAuto(iCoerceIn));
            iCoerceIn++;
        }
        return new Uint8ClampedArray(uTSArray);
    }
}
