package io.dcloud.common.adapter.io;

import android.content.Context;
import io.dcloud.application.DCLoudApplicationImpl;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.util.FileUtil;
import io.dcloud.common.util.IOUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.ThreadPool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DHFile {
    public static final int BUF_SIZE = 204800;
    public static final byte FS_JAR = 0;
    public static final byte FS_NATIVE = 2;
    public static final byte FS_RMS = 1;
    public static final int READ = 1;
    public static final int READ_WRITE = 3;
    private static final String ROOTPATH = "/";
    public static final int WRITE = 2;

    public static void addFile(String str, byte[] bArr) throws IOException {
        Object objCreateFileHandler = createFileHandler(str);
        createNewFile(objCreateFileHandler);
        OutputStream outputStream = getOutputStream(objCreateFileHandler, false);
        if (outputStream != null) {
            try {
                outputStream.write(bArr, 0, bArr.length);
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean canRead(String str) throws IOException {
        return getFile(getRealPath(str)).canRead();
    }

    private static boolean checkIsNeedReload(String str) {
        return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".xml") || str.endsWith(".bmp");
    }

    public static boolean copyAssetsFile(String str, String str2) {
        boolean zWriteFile = false;
        InputStream resInputStream = null;
        try {
            resInputStream = PlatformUtil.getResInputStream(str);
            if (resInputStream != null) {
                zWriteFile = writeFile(resInputStream, str2);
            } else if (checkIsNeedReload(str)) {
                Logger.d("PlatFU copyAssetsFile fail ！！！！  is = null < " + str + " > to < " + str2 + " >");
            }
            Logger.d("PlatFU copyAssetsFile < " + str + " > to < " + str2 + " >");
            return zWriteFile;
        } catch (Exception e) {
            Logger.d("PlatFU copyAssetsFile " + str2 + " error!!!  is it a dir ?");
            StringBuilder sb = new StringBuilder("PlatFU copyAssetsFile ");
            sb.append(e);
            Logger.d(sb.toString());
            if (checkIsNeedReload(str)) {
                Logger.d("PlatFU copyAssetsFile fail ！！！！ Exception< " + str + " > to < " + str2 + " >");
            }
            return zWriteFile;
        } finally {
            IOUtil.close(resInputStream);
        }
    }

    public static void copyDir(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            if (str.charAt(0) == '/') {
                str = str.substring(1, str.length());
            }
            if (str.charAt(str.length() - 1) == '/') {
                str = str.substring(0, str.length() - 1);
            }
            String[] strArrListResFiles = PlatformUtil.listResFiles(str);
            if (createNewFile(str2) != -1) {
                for (String str3 : strArrListResFiles) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str);
                    stringBuffer.append('/');
                    stringBuffer.append(str3);
                    String string = stringBuffer.toString();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str2);
                    stringBuffer2.append(str3);
                    String string2 = stringBuffer2.toString();
                    if (!copyAssetsFile(string, string2)) {
                        if (!checkIsNeedReload(str3)) {
                            copyDir(string, string2 + "/");
                        } else if (!copyAssetsFile(string, string2) && !copyAssetsFile(string, string2)) {
                            Logger.d("PlatFU copyDir fail 3 times!!!!" + string);
                            copyDir(string, string2 + "/");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int copyFile(String str, String str2, boolean z, boolean z2, ICallBack iCallBack) throws Throwable {
        InputStream inputStream;
        OutputStream outputStream;
        InputStream fileInputStream;
        String realPath = getRealPath(str);
        String realPath2 = getRealPath(str2);
        int i = -1;
        OutputStream outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        InputStream inputStream2 = null;
        try {
            Context context = DCLoudApplicationImpl.self().getContext();
            if (!FileUtil.checkPathAccord(context, realPath2) && AndroidResources.sAppTargetSdkVersion > 28) {
                try {
                    Thread.sleep(10L);
                } catch (Exception unused) {
                }
                IOUtil.close((InputStream) null);
                IOUtil.close((OutputStream) null);
                return -3;
            }
            if (isExist(realPath2)) {
                if (z2) {
                    try {
                        Thread.sleep(10L);
                    } catch (Exception unused2) {
                    }
                    IOUtil.close((InputStream) null);
                    IOUtil.close((OutputStream) null);
                    return -2;
                }
                if (z && !isDirectory(new File(realPath2))) {
                    deleteFile(realPath2);
                }
            }
            File file = new File(realPath);
            if (!file.exists()) {
                if (iCallBack != null) {
                    iCallBack.onCallBack(-1, "not file =" + realPath);
                }
                try {
                    Thread.sleep(10L);
                } catch (Exception unused3) {
                }
                IOUtil.close((InputStream) null);
                IOUtil.close((OutputStream) null);
                return -1;
            }
            if (file.isDirectory()) {
                String[] list = list(file);
                StringBuilder sb = new StringBuilder();
                sb.append(realPath);
                String str3 = File.separator;
                sb.append(realPath.endsWith(str3) ? "" : str3);
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(realPath2);
                if (realPath2.endsWith(str3)) {
                    str3 = "";
                }
                sb2.append(str3);
                String string2 = sb2.toString();
                int iCopyFile = -1;
                for (int i2 = 0; i2 < list.length; i2++) {
                    iCopyFile = copyFile(string + list[i2], string2 + list[i2], z, z2);
                    if (iCopyFile != 1) {
                        if (iCallBack != null) {
                            iCallBack.onCallBack(iCopyFile, "copyFile error src=" + string + list[i2] + " dest=" + string2 + list[i2]);
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (Exception unused4) {
                        }
                        IOUtil.close((InputStream) null);
                        IOUtil.close((OutputStream) null);
                        return iCopyFile;
                    }
                }
                inputStream = null;
                i = iCopyFile;
            } else {
                if (FileUtil.checkPathAccord(context, realPath) || AndroidResources.sAppTargetSdkVersion <= 28) {
                    fileInputStream = new FileInputStream(file);
                } else {
                    if (!FileUtil.isFilePathForPublic(context, realPath)) {
                        try {
                            Thread.sleep(10L);
                        } catch (Exception unused5) {
                        }
                        IOUtil.close((InputStream) null);
                        IOUtil.close((OutputStream) null);
                        return -3;
                    }
                    fileInputStream = FileUtil.getFileInputStream(context, file);
                }
                inputStream = fileInputStream;
                try {
                    Object objCreateFileHandler = createFileHandler(realPath2);
                    if (!isExist(objCreateFileHandler)) {
                        createNewFile(objCreateFileHandler);
                    }
                    outputStream2 = getOutputStream(objCreateFileHandler);
                    byte[] bArr = new byte[BUF_SIZE];
                    if (inputStream != null) {
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (i3 <= 0) {
                                break;
                            }
                            outputStream2.write(bArr, 0, i3);
                            outputStream2.flush();
                        }
                        i = 1;
                    }
                } catch (Exception e) {
                    e = e;
                    OutputStream outputStream3 = outputStream2;
                    inputStream2 = inputStream;
                    outputStream = outputStream3;
                    try {
                        Logger.i("copyFile:" + e);
                        if (iCallBack != null) {
                            iCallBack.onCallBack(-1, "copyFile error Message=" + e.getMessage());
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (Exception unused6) {
                        }
                        IOUtil.close(inputStream2);
                        IOUtil.close(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        InputStream inputStream3 = inputStream2;
                        outputStream2 = outputStream;
                        inputStream = inputStream3;
                        try {
                            Thread.sleep(10L);
                        } catch (Exception unused7) {
                        }
                        IOUtil.close(inputStream);
                        IOUtil.close(outputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Thread.sleep(10L);
                    IOUtil.close(inputStream);
                    IOUtil.close(outputStream2);
                    throw th;
                }
            }
            try {
                Thread.sleep(10L);
            } catch (Exception unused8) {
            }
            IOUtil.close(inputStream);
            IOUtil.close(outputStream2);
            return i;
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static Object createFileHandler(String str) {
        return str.replace('\\', '/');
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x0040, please report this as an issue */
    public static byte createNewFile(Object obj) {
        File file;
        boolean z;
        File parentFile;
        if (obj == null) {
            return (byte) -1;
        }
        boolean zCreateNewFile = false;
        if (obj instanceof String) {
            String str = (String) obj;
            Logger.d("createNewFile 0:" + str);
            file = new File(str);
            z = str.endsWith("/");
            parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                Logger.d("createNewFile: parentPath mkdirs " + parentFile.mkdirs());
            }
            if (file.exists()) {
                return (byte) -2;
            }
            if (z) {
                zCreateNewFile = file.mkdirs();
            } else {
                try {
                    zCreateNewFile = file.createNewFile();
                } catch (IOException e) {
                    Logger.w("createNewFile:", e);
                }
            }
            if (zCreateNewFile) {
                return (byte) 1;
            }
            return (byte) -1;
        }
        if (!(obj instanceof File)) {
            return (byte) -1;
        }
        file = (File) obj;
        parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            Logger.d("createNewFile: parentPath mkdirs " + parentFile.mkdirs());
        }
        if (file.exists()) {
            return (byte) -2;
        }
        if (z) {
            zCreateNewFile = file.mkdirs();
        } else {
            zCreateNewFile = file.createNewFile();
        }
        if (zCreateNewFile) {
            return (byte) 1;
        }
        return (byte) -1;
    }

    public static boolean delete(Object obj) {
        boolean zDelete;
        if (obj == null) {
            return false;
        }
        try {
            File file = getFile(obj);
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    Logger.d("delete:" + fileArrListFiles[i].getPath());
                    if (fileArrListFiles[i].isDirectory()) {
                        zDelete = delete(file.getPath() + "/" + fileArrListFiles[i].getName());
                    } else {
                        zDelete = fileArrListFiles[i].delete();
                        Thread.sleep(2L);
                    }
                    if (!zDelete) {
                        return false;
                    }
                }
            }
            boolean zDelete2 = file.delete();
            Logger.i("delete " + obj + ":" + String.valueOf(zDelete2));
            return zDelete2;
        } catch (Exception e) {
            Logger.w("DHFile.delete", e);
            return false;
        }
    }

    public static void deleteAsync(final Object obj, final IAsyncCallback iAsyncCallback) {
        if (iAsyncCallback == null) {
            return;
        }
        if (obj == null) {
            iAsyncCallback.done(false);
            return;
        }
        try {
            ThreadPool.self().addSingleThreadTask(new Runnable() { // from class: io.dcloud.common.adapter.io.DHFile.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File file = DHFile.getFile(obj);
                        if (!file.exists()) {
                            iAsyncCallback.done(false);
                            return;
                        }
                        if (file.isFile()) {
                            iAsyncCallback.done(file.delete());
                            return;
                        }
                        File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                            for (int i = 0; i < fileArrListFiles.length; i++) {
                                if (!(fileArrListFiles[i].isDirectory() ? DHFile.delete(file.getPath() + "/" + fileArrListFiles[i].getName()) : fileArrListFiles[i].delete())) {
                                    iAsyncCallback.done(false);
                                    return;
                                }
                            }
                        }
                        iAsyncCallback.done(file.delete());
                    } catch (Exception e) {
                        Logger.w("DHFile.delete", e);
                        iAsyncCallback.done(false);
                    }
                }
            });
        } catch (Exception unused) {
            iAsyncCallback.done(false);
        }
    }

    public static int deleteFile(String str) throws IOException {
        return delete(new File(getRealPath(str))) ? 1 : -1;
    }

    public static boolean exists(Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static File getFile(Object obj) {
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

    public static String getFileName(Object obj) {
        return getName(obj);
    }

    public static String getFilePath(Object obj) {
        return getPath(obj);
    }

    public static long getFileSize(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        long fileSize = 0;
        for (File file2 : file.listFiles()) {
            fileSize += getFileSize(file2);
        }
        return fileSize;
    }

    public static String getFileUrl(Object obj) {
        return getPath(obj);
    }

    public static InputStream getInputStream(Object obj) throws IOException {
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
            Logger.e("DHFile getInputStream not found file: " + file.getPath());
            return null;
        } catch (SecurityException e) {
            Logger.w("getInputStream2", e);
            return null;
        }
    }

    public static long getLastModify(String str) throws IOException {
        File file = new File(getRealPath(str));
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    public static String getName(Object obj) {
        if (!(obj instanceof String)) {
            return ((File) obj).getName();
        }
        String strSubstring = (String) obj;
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return strSubstring.substring(strSubstring.lastIndexOf(47) + 1);
    }

    public static OutputStream getOutputStream(Object obj) throws IOException {
        File file;
        if (obj instanceof String) {
            file = new File((String) obj);
        } else {
            file = obj instanceof File ? (File) obj : null;
        }
        if (file != null) {
            if (file.canWrite()) {
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    Logger.w("getOutputStream:", e);
                    return null;
                }
            }
            Logger.i("getOutputStream:can not write");
        }
        return null;
    }

    public static Object getParent(Object obj) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(getPath(obj));
        if (((File) obj).isDirectory()) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.delete(stringBuffer.toString().lastIndexOf(47), stringBuffer.length());
        return createFileHandler(stringBuffer.toString());
    }

    public static String getPath(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return str.substring(0, str.lastIndexOf(47) + 1);
        }
        if (obj instanceof File) {
            return ((File) obj).getPath();
        }
        return null;
    }

    private static String getRealPath(String str) {
        String str2 = DeviceInfo.sBaseFsRootPath;
        StringBuffer stringBuffer = new StringBuffer();
        if ("".equals(str)) {
            return str2;
        }
        try {
            char[] charArray = str.toCharArray();
            int i = 0;
            while (i < charArray.length) {
                char c = charArray[0];
                int i2 = 3;
                if ((c == 'C' || c == 'c') && i == 0) {
                    stringBuffer.append(str2);
                    i = 3;
                }
                char c2 = charArray[0];
                if ((c2 == 'D' || c2 == 'd') && i == 0) {
                    stringBuffer.append(str2);
                } else {
                    i2 = i;
                }
                char c3 = charArray[i2];
                if (c3 == '\\') {
                    stringBuffer.append('/');
                } else {
                    stringBuffer.append(c3);
                }
                i = i2 + 1;
            }
            return stringBuffer.toString();
        } catch (ArrayIndexOutOfBoundsException unused) {
            return str;
        }
    }

    public static boolean hasFile() {
        return false;
    }

    public static boolean isDirectory(Object obj) throws IOException {
        return ((File) obj).isDirectory();
    }

    public static boolean isExist(String str) throws IOException {
        return exists(getFile(getRealPath(str)));
    }

    public static boolean isHidden(Object obj) throws IOException {
        File file = getFile(obj);
        if (file == null) {
            return false;
        }
        return file.isHidden();
    }

    public static long length(Object obj) {
        try {
            return ((File) obj).length();
        } catch (Exception e) {
            Logger.w("length:", e);
            return -1L;
        }
    }

    public static String[] list(Object obj) throws IOException {
        Object[] objArrListFiles = listFiles(obj);
        if (objArrListFiles == null) {
            return null;
        }
        String[] strArr = new String[objArrListFiles.length];
        for (int i = 0; i < objArrListFiles.length; i++) {
            File file = (File) objArrListFiles[i];
            if (file.isDirectory()) {
                strArr[i] = file.getName() + "/";
            } else {
                strArr[i] = file.getName();
            }
        }
        return strArr;
    }

    public static String[] listDir(Object obj) throws IOException {
        Object[] objArrListFiles = listFiles(obj);
        if (objArrListFiles == null) {
            return null;
        }
        String[] strArr = new String[objArrListFiles.length];
        for (int i = 0; i < objArrListFiles.length; i++) {
            File file = (File) objArrListFiles[i];
            if (file.isDirectory()) {
                strArr[i] = file.getName() + "/";
            }
        }
        return strArr;
    }

    public static Object[] listFiles(Object obj) throws IOException {
        File file;
        if (obj instanceof String) {
            file = new File((String) obj);
        } else {
            file = obj instanceof File ? (File) obj : null;
        }
        if (file != null) {
            file.isDirectory();
            try {
                return file.listFiles();
            } catch (Exception e) {
                Logger.w("listFiles:", e);
            }
        }
        return null;
    }

    public static List<String> listFilesWithName(Object obj, final String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            File file = obj instanceof String ? new File((String) obj) : obj instanceof File ? (File) obj : null;
            if (file != null && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: io.dcloud.common.adapter.io.DHFile.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    return new File(file2, str2).isDirectory() || str2.equals(str);
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(listFilesWithName(file2, str));
                    } else {
                        arrayList.add(file2.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<String> listFilesWithSuffix(Object obj, final String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            File file = obj instanceof String ? new File((String) obj) : obj instanceof File ? (File) obj : null;
            if (file != null && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: io.dcloud.common.adapter.io.DHFile.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    return new File(file2, str2).isDirectory() || str2.toLowerCase().endsWith(str);
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(listFilesWithSuffix(file2, str));
                    } else {
                        arrayList.add(file2.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static String[] listRoot() throws IOException {
        return new File("/").list();
    }

    protected static Object openFile(String str, int i, boolean z) throws IOException {
        return createFileHandler(getRealPath(str));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x004f A[EXC_TOP_SPLITTER, PHI: r4
  0x004f: PHI (r4v8 java.io.InputStream) = (r4v5 java.io.InputStream), (r4v6 java.io.InputStream), (r4v7 java.io.InputStream), (r4v10 java.io.InputStream) binds: [B:32:0x0037, B:27:0x002d, B:36:0x004d, B:19:0x001f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readAll(Object obj) throws Throwable {
        InputStream inputStream;
        ?? r1 = 0;
        try {
            try {
                inputStream = getInputStream(obj);
                if (inputStream == null) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
                try {
                    byte[] bytes = IOUtil.getBytes(inputStream);
                    try {
                        inputStream.close();
                        return bytes;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return bytes;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    Logger.i("readAll 0:" + e.getLocalizedMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    Logger.w("readAll 2:", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } catch (SecurityException e5) {
                    e = e5;
                    Logger.w("readAll 1:", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r1 = obj;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            inputStream = null;
        } catch (IOException e8) {
            e = e8;
            inputStream = null;
        } catch (SecurityException e9) {
            e = e9;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public static int rename(String str, String str2) throws IOException {
        String strSubstring;
        String realPath = getRealPath(str);
        if (realPath.endsWith("/")) {
            if (!str2.endsWith("/")) {
                str2 = str2 + "/";
            }
            strSubstring = realPath.substring(0, realPath.length() - 1);
        } else {
            strSubstring = null;
        }
        if (strSubstring != null) {
            if (!PdrUtil.isDeviceRootDir(str2)) {
                str2 = strSubstring.substring(0, strSubstring.lastIndexOf("/") + 1) + str2;
            }
            String realPath2 = getRealPath(str2);
            File file = new File(realPath);
            if (file.exists()) {
                File file2 = new File(realPath2);
                if (!file2.exists() && file.renameTo(file2)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static boolean writeFile(InputStream inputStream, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[BUF_SIZE];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        z = true;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        IOUtil.close(fileOutputStream2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        IOUtil.close(fileOutputStream);
                        throw th;
                    }
                }
                IOUtil.close(fileOutputStream);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static Object openFile(String str, int i) throws IOException {
        return openFile(str, i, false);
    }

    public static boolean isExist(Object obj) throws IOException {
        File file = getFile(obj);
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static boolean isHidden(String str) throws IOException {
        File file = new File(getRealPath(str));
        if (file.exists()) {
            return isHidden(file);
        }
        return false;
    }

    public static OutputStream getOutputStream(Object obj, boolean z) throws IOException {
        File file;
        if (obj instanceof String) {
            file = new File((String) obj);
        } else {
            file = obj instanceof File ? (File) obj : null;
        }
        if (file != null) {
            if (file.canWrite()) {
                try {
                    return new FileOutputStream(file, z);
                } catch (FileNotFoundException e) {
                    Logger.w("getOutputStream:", e);
                    return null;
                }
            }
            Logger.i("getOutputStream:can not write");
        }
        return null;
    }

    public static void writeFile(byte[] bArr, int i, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            Logger.i(str + "cannot create!");
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

    public static void writeFile(InputStream inputStream, int i, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            Logger.i(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                randomAccessFile.seek(file.length());
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 8192);
                    if (i2 != -1) {
                        randomAccessFile.write(bArr, 0, i2);
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
                            int i3 = inputStream.read(bArr2, 0, 8192);
                            if (i3 == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr2, 0, i3);
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

    public static int copyFile(String str, String str2) {
        return copyFile(str, str2, false, false, null);
    }

    public static int copyFile(String str, String str2, ICallBack iCallBack) {
        return copyFile(str, str2, false, false, iCallBack);
    }

    public static int copyFile(String str, String str2, boolean z, boolean z2) {
        return copyFile(str, str2, z, z2, null);
    }
}
