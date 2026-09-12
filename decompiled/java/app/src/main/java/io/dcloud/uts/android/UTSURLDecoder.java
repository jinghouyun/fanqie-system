package io.dcloud.uts.android;

import io.dcloud.uts.ObjectKt;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: UTSURLDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\"\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/dcloud/uts/android/UTSURLDecoder;", "", "isComponent", "", "<init>", "(Z)V", "dfltEncName", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "getDfltEncName", "()Ljava/nio/charset/Charset;", "setDfltEncName", "(Ljava/nio/charset/Charset;)V", "decode", "", "s", "charset", "isValidHexChar", "c", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSURLDecoder {
    private Charset dfltEncName;
    private boolean isComponent;

    private final boolean isValidHexChar(char c) {
        if ('0' <= c && c < ':') {
            return true;
        }
        if ('a' > c || c >= 'g') {
            return 'A' <= c && c < 'G';
        }
        return true;
    }

    public final Charset getDfltEncName() {
        return this.dfltEncName;
    }

    public final void setDfltEncName(Charset charset) {
        this.dfltEncName = charset;
    }

    public UTSURLDecoder(boolean z) {
        this.dfltEncName = Charset.forName("UTF-8");
        this.isComponent = z;
    }

    public /* synthetic */ UTSURLDecoder(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public static /* synthetic */ String decode$default(UTSURLDecoder uTSURLDecoder, String str, Charset dfltEncName, int i, Object obj) {
        if ((i & 2) != 0) {
            dfltEncName = uTSURLDecoder.dfltEncName;
            Intrinsics.checkNotNullExpressionValue(dfltEncName, "dfltEncName");
        }
        return uTSURLDecoder.decode(str, dfltEncName);
    }

    public final String decode(String s, Charset charset) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ObjectKt.getGlobalError().put(Thread.currentThread().getName(), null);
        int length = s.length();
        StringBuilder sb = new StringBuilder(length > 500 ? length / 2 : length);
        byte[] bArr = null;
        int i = 0;
        boolean z = false;
        while (i < length) {
            char cCharAt = s.charAt(i);
            if (cCharAt == '%') {
                if (bArr == null) {
                    try {
                        bArr = new byte[(length - i) / 3];
                    } catch (NumberFormatException e) {
                        ObjectKt.getGlobalError().put(Thread.currentThread().getName(), new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - " + e.getMessage()));
                        return null;
                    }
                }
                int i2 = 0;
                while (true) {
                    int i3 = i + 2;
                    if (i3 >= length || cCharAt != '%') {
                        break;
                    }
                    int i4 = i + 1;
                    if (isValidHexChar(s.charAt(i4)) && isValidHexChar(s.charAt(i3))) {
                        int i5 = i + 3;
                        String strSubstring = s.substring(i4, i5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        int i6 = Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
                        if (i6 < 0) {
                            Map<String, Exception> globalError = ObjectKt.getGlobalError();
                            String name = Thread.currentThread().getName();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("URLDecoder: Illegal hex characters in escape (%) pattern - negative value : ");
                            String strSubstring2 = s.substring(i, i5);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            sb2.append(strSubstring2);
                            globalError.put(name, new IllegalArgumentException(sb2.toString()));
                            return null;
                        }
                        int i7 = i2 + 1;
                        bArr[i2] = (byte) i6;
                        if (i5 < length) {
                            cCharAt = s.charAt(i5);
                        }
                        i2 = i7;
                        i = i5;
                    }
                    Map<String, Exception> globalError2 = ObjectKt.getGlobalError();
                    String name2 = Thread.currentThread().getName();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("URLDecoder: Illegal hex characters in escape (%) pattern : ");
                    String strSubstring3 = s.substring(i, i + 3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    sb3.append(strSubstring3);
                    globalError2.put(name2, new IllegalArgumentException(sb3.toString()));
                    return null;
                }
                if (i < length && cCharAt == '%') {
                    ObjectKt.getGlobalError().put(Thread.currentThread().getName(), new IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern"));
                    return null;
                }
                sb.append(new String(bArr, 0, i2, charset));
                z = true;
            } else {
                sb.append(cCharAt);
                i++;
            }
        }
        return z ? sb.toString() : s;
    }
}
