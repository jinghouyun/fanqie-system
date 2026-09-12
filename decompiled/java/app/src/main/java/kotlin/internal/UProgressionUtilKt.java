package kotlin.internal;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: compiled from: UProgressionUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1740differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int iM$4 = UByte$$ExternalSyntheticBackport0.m$4(i, i3);
        int iM$5 = UByte$$ExternalSyntheticBackport0.m$4(i2, i3);
        int iCompare = Integer.compare(iM$4 ^ Integer.MIN_VALUE, iM$5 ^ Integer.MIN_VALUE);
        int iM623constructorimpl = UInt.m623constructorimpl(iM$4 - iM$5);
        return iCompare >= 0 ? iM623constructorimpl : UInt.m623constructorimpl(iM623constructorimpl + i3);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1741differenceModulosambcqE(long j, long j2, long j3) {
        long jM$3 = UByte$$ExternalSyntheticBackport0.m$3(j, j3);
        long jM$4 = UByte$$ExternalSyntheticBackport0.m$3(j2, j3);
        int iCompare = Long.compare(jM$3 ^ Long.MIN_VALUE, jM$4 ^ Long.MIN_VALUE);
        long jM702constructorimpl = ULong.m702constructorimpl(jM$3 - jM$4);
        return iCompare >= 0 ? jM702constructorimpl : ULong.m702constructorimpl(jM702constructorimpl + j3);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1743getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            if (Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) < 0) {
                return UInt.m623constructorimpl(i2 - m1740differenceModuloWZ9TVnA(i2, i, UInt.m623constructorimpl(i3)));
            }
        } else if (i3 < 0) {
            if (Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) > 0) {
                return UInt.m623constructorimpl(i2 + m1740differenceModuloWZ9TVnA(i, i2, UInt.m623constructorimpl(-i3)));
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return i2;
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1742getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) >= 0 ? j2 : ULong.m702constructorimpl(j2 - m1741differenceModulosambcqE(j2, j, ULong.m702constructorimpl(j3)));
        }
        if (j3 < 0) {
            return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) <= 0 ? j2 : ULong.m702constructorimpl(j2 + m1741differenceModulosambcqE(j, j2, ULong.m702constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
