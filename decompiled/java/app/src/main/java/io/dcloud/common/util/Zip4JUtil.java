package io.dcloud.common.util;

import java.io.File;
import java.nio.charset.Charset;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class Zip4JUtil {
    public static boolean isEncryptedZip(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.isValidZipFile()) {
                return zipFile.isEncrypted();
            }
            return false;
        } catch (ZipException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void upZipFileWithPassword(File file, String str, String str2) throws ZipException {
        if (!str.endsWith("/")) {
            str = str + File.separatorChar;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file, str2 != null ? str2.toCharArray() : null);
        zipFile.setCharset(Charset.forName("UTF-8"));
        zipFile.extractAll(file2.getPath());
    }
}
