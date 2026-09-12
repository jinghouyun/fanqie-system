package io.dcloud.feature.weex.extend;

import android.util.Base64;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class RandomBytesModule extends WXModule {
    private String getRandomBytes(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 2);
    }

    @JSMethod(uiThread = false)
    public String getRandomValues(int i) {
        return getRandomBytes(i);
    }
}
