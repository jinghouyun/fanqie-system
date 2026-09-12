package io.dcloud.p;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m1 {
    public static void a(byte[] bArr, int i, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                    randomAccessFile.setLength(bArr.length + i);
                    randomAccessFile.seek(i);
                    randomAccessFile.write(bArr);
                    randomAccessFile.close();
                    return;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            try {
                file.createNewFile();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                if (bArr != null) {
                    try {
                        try {
                            fileOutputStream.write(bArr, 0, bArr.length);
                            fileOutputStream.flush();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    } finally {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
