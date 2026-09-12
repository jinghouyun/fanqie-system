package io.dcloud.common.util;

import com.taobao.weex.el.parse.Operators;
import io.dcloud.p.e1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class Base64 {
    private static final char[] BASE64CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final String CRLF = "\r\n";
    private static final char PAD = '=';

    public static String decode2String(String str) {
        try {
            return new String(decode2bytes(str), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0079 A[Catch: all -> 0x00a5, Exception -> 0x00af, TryCatch #8 {Exception -> 0x00af, all -> 0x00a5, blocks: (B:3:0x0006, B:4:0x000e, B:8:0x0014, B:24:0x0037, B:33:0x0051, B:40:0x0070, B:43:0x0094, B:42:0x0079, B:44:0x0098), top: B:71:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0094 A[SYNTHETIC] */
    public static byte[] decode2bytes(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                int i = 0;
                int iSixbit = 0;
                for (byte b : str.getBytes()) {
                    if (i < 4) {
                        int iDecodeInt = decodeInt(b);
                        if (iDecodeInt == -1) {
                            continue;
                        } else {
                            if (iDecodeInt == -2 && i != 2 && i != 3) {
                                try {
                                    byteArrayOutputStream.close();
                                    return null;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                            if (iDecodeInt == -2 && i == 2) {
                                byteArrayOutputStream.write(eightbit(iSixbit >> 4));
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    return byteArray;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return byteArray;
                                }
                            }
                            if (iDecodeInt == -2 && i == 3) {
                                byteArrayOutputStream.write(eightbit(iSixbit >> 10));
                                byteArrayOutputStream.write(eightbit(iSixbit >> 2));
                                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    return byteArray2;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return byteArray2;
                                }
                            }
                            iSixbit = (iSixbit << 6) | sixbit(iDecodeInt);
                            i++;
                            if (i == 4) {
                                byteArrayOutputStream.write(eightbit(iSixbit >> 16));
                                byteArrayOutputStream.write(eightbit(iSixbit >> 8));
                                byteArrayOutputStream.write(eightbit(iSixbit));
                                i = 0;
                                iSixbit = 0;
                            }
                        }
                    } else if (i == 4) {
                        byteArrayOutputStream.write(eightbit(iSixbit >> 16));
                        byteArrayOutputStream.write(eightbit(iSixbit >> 8));
                        byteArrayOutputStream.write(eightbit(iSixbit));
                        i = 0;
                        iSixbit = 0;
                    }
                }
                byte[] byteArray3 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray3;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return byteArray3;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    private static int decodeInt(int i) {
        if (i >= 65 && i <= 90) {
            return i - 65;
        }
        if (i >= 97 && i <= 122) {
            return i - 71;
        }
        if (i >= 48 && i <= 57) {
            return i + 4;
        }
        if (i == 43) {
            return 62;
        }
        if (i == 47) {
            return 63;
        }
        return i == 61 ? -2 : -1;
    }

    public static String decodeString(String str, boolean z, int i) {
        return e1.a(str, z, i);
    }

    private static int eightbit(int i) {
        return i & 255;
    }

    public static String encode(String str) {
        try {
            return encode(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String encodeString(String str, boolean z, int i) {
        return e1.b(str, z, i);
    }

    private static int sixbit(int i) {
        return i & 63;
    }

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i += 3) {
            if (i % 57 == 0 && i != 0) {
                stringBuffer.append(CRLF);
            }
            int i2 = i + 1;
            if (bArr.length <= i2) {
                int iEightbit = eightbit(bArr[i]) << 16;
                char[] cArr = BASE64CHARS;
                stringBuffer.append(cArr[sixbit(iEightbit >> 18)]);
                stringBuffer.append(cArr[sixbit(iEightbit >> 12)]);
                stringBuffer.append(Operators.EQUAL2);
            } else {
                int i3 = i + 2;
                if (bArr.length <= i3) {
                    int iEightbit2 = (eightbit(bArr[i]) << 16) | (eightbit(bArr[i2]) << 8);
                    char[] cArr2 = BASE64CHARS;
                    stringBuffer.append(cArr2[sixbit(iEightbit2 >> 18)]);
                    stringBuffer.append(cArr2[sixbit(iEightbit2 >> 12)]);
                    stringBuffer.append(cArr2[sixbit(iEightbit2 >> 6)]);
                    stringBuffer.append(PAD);
                } else {
                    int iEightbit3 = (eightbit(bArr[i]) << 16) | (eightbit(bArr[i2]) << 8) | eightbit(bArr[i3]);
                    char[] cArr3 = BASE64CHARS;
                    stringBuffer.append(cArr3[sixbit(iEightbit3 >> 18)]);
                    stringBuffer.append(cArr3[sixbit(iEightbit3 >> 12)]);
                    stringBuffer.append(cArr3[sixbit(iEightbit3 >> 6)]);
                    stringBuffer.append(cArr3[sixbit(iEightbit3)]);
                }
            }
        }
        return stringBuffer.toString();
    }
}
