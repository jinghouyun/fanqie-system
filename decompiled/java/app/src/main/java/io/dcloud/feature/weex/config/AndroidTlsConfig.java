package io.dcloud.feature.weex.config;

import com.taobao.weex.el.parse.Operators;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class AndroidTlsConfig {
    private String[] ca;
    private String keystore;
    private String storePass;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AndroidTlsConfig androidTlsConfig = (AndroidTlsConfig) obj;
            String string = Arrays.toString(this.ca);
            String string2 = Arrays.toString(androidTlsConfig.ca);
            if (this.keystore.equals(androidTlsConfig.keystore) && this.storePass.equals(androidTlsConfig.storePass) && string.equals(string2)) {
                return true;
            }
        }
        return false;
    }

    public String[] getCa() {
        return this.ca;
    }

    public String getKeystore() {
        return this.keystore;
    }

    public String getStorePass() {
        return this.storePass;
    }

    public int hashCode() {
        return (Objects.hash(this.keystore, this.storePass, Arrays.toString(this.ca)) * 31) + Arrays.hashCode(this.ca);
    }

    public void setCa(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.ca = strArr;
    }

    public void setKeystore(String str) {
        if (str == null) {
            str = "";
        }
        this.keystore = str;
    }

    public void setStorePass(String str) {
        if (str == null) {
            str = "";
        }
        this.storePass = str;
    }

    public String toString() {
        return "AndroidTlsConfig{keystore='" + this.keystore + "', storePass='" + this.storePass + "', ca=" + Arrays.toString(this.ca) + Operators.BLOCK_END;
    }
}
