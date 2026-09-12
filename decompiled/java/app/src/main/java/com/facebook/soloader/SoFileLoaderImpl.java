package com.facebook.soloader;

import io.dcloud.common.util.Md5Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private static final String TAG = "SoFileLoaderImpl";

    @Nullable
    private final String mLocalLdLibraryPath;

    @Nullable
    private final String mLocalLdLibraryPathNoZips;

    @Nullable
    private final Method mNativeLoadRuntimeMethod;
    private final Runtime mRuntime = Runtime.getRuntime();

    public SoFileLoaderImpl() {
        Method nativeLoadRuntimeMethod = SysUtil.getNativeLoadRuntimeMethod();
        this.mNativeLoadRuntimeMethod = nativeLoadRuntimeMethod;
        String classLoaderLdLoadLibrary = nativeLoadRuntimeMethod != null ? SysUtil.getClassLoaderLdLoadLibrary() : null;
        this.mLocalLdLibraryPath = classLoaderLdLoadLibrary;
        this.mLocalLdLibraryPathNoZips = SysUtil.makeNonZipPath(classLoaderLdLoadLibrary);
    }

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0082 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoFileLoaderImpl.TAG, "Error when loading library: " + r3 + ", library hash is " + getLibHash(r10) + ", LD_LIBRARY_PATH is " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return;
     */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(String str, int i) {
        if (this.mNativeLoadRuntimeMethod == null) {
            System.load(str);
            return;
        }
        String str2 = (i & 4) == 4 ? this.mLocalLdLibraryPath : this.mLocalLdLibraryPathNoZips;
        String str3 = null;
        try {
            try {
                synchronized (this.mRuntime) {
                    String str4 = (String) this.mNativeLoadRuntimeMethod.invoke(this.mRuntime, str, SoLoader.class.getClassLoader(), str2);
                    try {
                        if (str4 != null) {
                            String str5 = "nativeLoad() returned error for " + str + ": " + str4;
                            try {
                                throw new SoLoaderULError(str, str5);
                            } catch (Throwable th) {
                                str3 = str5;
                                th = th;
                                while (true) {
                                    break;
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = str4;
                    }
                }
                while (true) {
                    break;
                    break;
                }
                throw th;
            } catch (Throwable th3) {
                if (str3 != null) {
                    LogUtil.e(TAG, "Error when loading library: " + str3 + ", library hash is " + getLibHash(str) + ", LD_LIBRARY_PATH is " + str2);
                }
                throw th3;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            throw new RuntimeException("nativeLoad() error during invocation for " + str + ": " + str3);
        }
    }

    private String getLibHash(String str) {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance(Md5Utils.ALGORITHM);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}
