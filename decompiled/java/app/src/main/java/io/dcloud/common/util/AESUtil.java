package io.dcloud.common.util;

import io.dcloud.p.e1;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AESUtil {
    private static Cipher createCipher(int i, byte[] bArr, String str, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance(str);
        if (bArr2 == null) {
            bArr2 = new byte[cipher.getBlockSize()];
        }
        cipher.init(i, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    public static String decrypt(String str, String str2, byte[] bArr) {
        try {
            return new String(decrypt(str.getBytes(), str2.getBytes(), bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(String str, String str2, String str3) {
        return encrypt(str, str2, str3.getBytes());
    }

    public static String getDefaultTransformation() {
        return e1.b("IM['KJK'XCK[=Xillafo");
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) {
        try {
            return encrypt(str.getBytes(), bArr, getDefaultTransformation(), str2 != null ? str2.getBytes() : null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return createCipher(2, bArr, getDefaultTransformation(), bArr2).doFinal(bArr3);
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws Exception {
        return createCipher(1, bArr, str, bArr3).doFinal(bArr2);
    }
}
