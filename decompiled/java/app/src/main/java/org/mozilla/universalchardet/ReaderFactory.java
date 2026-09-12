package org.mozilla.universalchardet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReaderFactory {
    private ReaderFactory() {
        throw new AssertionError("No instances allowed");
    }

    public static Reader createReaderFromFile(File file, Charset charset) throws IOException {
        if (charset == null) {
            throw new NullPointerException("defaultCharset must be not null");
        }
        String strDetectCharset = UniversalDetector.detectCharset(file);
        if (strDetectCharset != null) {
            charset = Charset.forName(strDetectCharset);
        }
        return !charset.toString().contains("UTF") ? new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), charset) : new InputStreamReader(new UnicodeBOMInputStream(new BufferedInputStream(new FileInputStream(file))), charset);
    }

    public static Reader createReaderFromFile(File file) throws IOException {
        return createReaderFromFile(file, Charset.defaultCharset());
    }
}
