package io.dcloud.p;

import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.util.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 {
    public static boolean a(Object obj) {
        boolean zDelete;
        if (obj == null) {
            return false;
        }
        try {
            File fileC = c(obj);
            if (!fileC.exists()) {
                return false;
            }
            if (fileC.isFile()) {
                return fileC.delete();
            }
            File[] fileArrListFiles = fileC.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    c3.a("delete:" + fileArrListFiles[i].getPath());
                    if (fileArrListFiles[i].isDirectory()) {
                        zDelete = a((Object) (fileC.getPath() + "/" + fileArrListFiles[i].getName()));
                    } else {
                        zDelete = fileArrListFiles[i].delete();
                        Thread.sleep(2L);
                    }
                    if (!zDelete) {
                        return false;
                    }
                }
            }
            boolean zDelete2 = fileC.delete();
            c3.a("delete " + obj + ":" + String.valueOf(zDelete2));
            return zDelete2;
        } catch (Exception e) {
            c3.d("DHFile.delete" + e);
            return false;
        }
    }

    public static boolean b(Object obj) {
        try {
            if (!(obj instanceof String)) {
                if (obj instanceof File) {
                    return ((File) obj).exists();
                }
                return false;
            }
            String strSubstring = (String) obj;
            if (strSubstring.endsWith("/")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return new File(strSubstring).exists();
        } catch (Exception unused) {
        }
    }

    private static File c(Object obj) {
        if (!(obj instanceof String)) {
            if (obj instanceof File) {
                return (File) obj;
            }
            return null;
        }
        String strSubstring = (String) obj;
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return new File(strSubstring);
    }

    public static InputStream d(Object obj) {
        File file;
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            if (strSubstring.startsWith(DeviceInfo.FILE_PROTOCOL)) {
                strSubstring = strSubstring.substring(7);
            }
            file = new File(strSubstring);
        } else {
            file = obj instanceof File ? (File) obj : null;
        }
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            c3.b("uniAD", "DHFile getInputStream not found file: " + file.getPath());
            return null;
        } catch (SecurityException e) {
            c3.d("getInputStream2" + e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0067 A[EXC_TOP_SPLITTER, PHI: r4
  0x0067: PHI (r4v8 java.io.InputStream) = (r4v5 java.io.InputStream), (r4v6 java.io.InputStream), (r4v7 java.io.InputStream), (r4v10 java.io.InputStream) binds: [B:32:0x004f, B:27:0x003b, B:36:0x0065, B:19:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public static byte[] e(Object obj) throws Throwable {
        InputStream inputStreamD;
        ?? r3 = 0;
        try {
            try {
                inputStreamD = d(obj);
                if (inputStreamD == null) {
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                }
                try {
                    byte[] bArrA = a(inputStreamD);
                    try {
                        inputStreamD.close();
                        return bArrA;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return bArrA;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    c3.a("readAll 0:" + e.getLocalizedMessage());
                    if (inputStreamD != null) {
                        try {
                            inputStreamD.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    c3.d("readAll 2:" + e);
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                } catch (SecurityException e5) {
                    e = e5;
                    c3.d("readAll 1:" + e);
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r3 = obj;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            inputStreamD = null;
        } catch (IOException e8) {
            e = e8;
            inputStreamD = null;
        } catch (SecurityException e9) {
            e = e9;
            inputStreamD = null;
        } catch (Throwable th2) {
            th = th2;
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[DHFile.BUF_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a((OutputStream) byteArrayOutputStream);
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(String str) {
        return b(c(str));
    }

    public static void a(byte[] bArr, int i, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            c3.a(str + "cannot create!");
            return;
        }
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
            try {
                if (bArr != null) {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
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

    public static void a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            c3.a(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                randomAccessFile.seek(file.length());
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i != -1) {
                        randomAccessFile.write(bArr, 0, i);
                    } else {
                        randomAccessFile.close();
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
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
                try {
                    try {
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int i2 = inputStream.read(bArr2, 0, 8192);
                            if (i2 == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr2, 0, i2);
                            }
                        }
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
