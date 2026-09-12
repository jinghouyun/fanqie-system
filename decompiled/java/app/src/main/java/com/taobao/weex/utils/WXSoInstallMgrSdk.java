package com.taobao.weex.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.weex.IWXStatisticsListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.performance.WXInstanceApm;
import dalvik.system.PathClassLoader;
import io.dcloud.common.util.PdrUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXSoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String STARTUPSO = "/libweexjsb.so";
    private static final String STARTUPSOANDROID15 = "/libweexjst.so";
    private static final String X86 = "x86";
    private static String mAbi;
    static Application mContext;
    private static IWXSoLoaderAdapter mSoLoader;
    private static IWXStatisticsListener mStatisticsListener;

    private static String _cpuType() {
        if (TextUtils.isEmpty(mAbi)) {
            try {
                mAbi = Build.CPU_ABI;
            } catch (Throwable th) {
                th.printStackTrace();
                mAbi = ARMEABI;
            }
            if (TextUtils.isEmpty(mAbi)) {
                mAbi = ARMEABI;
            }
            mAbi = mAbi.toLowerCase(Locale.ROOT);
        }
        return mAbi;
    }

    private static File _desSoCopyFile(String str) {
        String str_cpuType = _cpuType();
        String strCopySoDesDir = WXEnvironment.copySoDesDir();
        if (TextUtils.isEmpty(strCopySoDesDir)) {
            return null;
        }
        return new File(strCopySoDesDir, str + "/" + str_cpuType);
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    static boolean _loadUnzipSo(String str, int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
        try {
            if (!isExist(str, i)) {
                return true;
            }
            IWXSoLoaderAdapter iWXSoLoaderAdapter = mSoLoader;
            if (iWXSoLoaderAdapter != null) {
                iWXSoLoaderAdapter.doLoad(_targetSoFile(str, i));
                return true;
            }
            System.load(_targetSoFile(str, i));
            return true;
        } catch (Throwable th) {
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT, "_loadUnzipSo", "[WX_KEY_EXCEPTION_SDK_INIT_WX_ERR_COPY_FROM_APK] \n Detail Msg is : " + th.getMessage(), null);
            WXLogUtils.e("", th);
            return false;
        }
    }

    static String _targetSoFile(String str, int i) {
        Application application = mContext;
        if (application == null) {
            return "";
        }
        String path = "/data/data/" + application.getPackageName() + "/files";
        File filesDir = application.getFilesDir();
        if (filesDir != null) {
            path = filesDir.getPath();
        }
        return path + "/lib" + str + "bk" + i + ".so";
    }

    static boolean checkSoIsValid(String str, long j) {
        if (mContext == null) {
            return false;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (WXSoInstallMgrSdk.class.getClassLoader() instanceof PathClassLoader) {
                String strFindLibrary = ((PathClassLoader) WXSoInstallMgrSdk.class.getClassLoader()).findLibrary(str);
                if (TextUtils.isEmpty(strFindLibrary)) {
                    return false;
                }
                File file = new File(strFindLibrary);
                if (file.exists() && j != file.length()) {
                    return false;
                }
                WXLogUtils.w("weex so size check path :" + strFindLibrary + "   " + (System.currentTimeMillis() - jCurrentTimeMillis));
                return true;
            }
        } catch (Throwable th) {
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "checkSoIsValid", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for weex so size check fail exception :" + th.getMessage(), null);
            WXLogUtils.e("weex so size check fail exception :" + th.getMessage());
        }
        return true;
    }

    public static void copyJssRuntimeSo() {
        boolean zCheckGreyConfig = WXUtils.checkGreyConfig("wxapm", "use_runtime_api", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        WXLogUtils.e("weex", "tryUseRunTimeApi ? " + zCheckGreyConfig);
        if (zCheckGreyConfig) {
            try {
                WXLogUtils.e("weex", "copyJssRuntimeSo: ");
                File file_desSoCopyFile = _desSoCopyFile(WXEnvironment.CORE_JSS_SO_NAME);
                if (!file_desSoCopyFile.exists()) {
                    file_desSoCopyFile.mkdirs();
                }
                File file = new File(file_desSoCopyFile, "libweexjss.so");
                String defaultSettingValue = WXEnvironment.getDefaultSettingValue("app_version_code_weex", "-1");
                if (file.exists()) {
                    if (TextUtils.equals(WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                        WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                        WXEnvironment.sUseRunTimeApi = true;
                        WXLogUtils.e("weex", "copyJssRuntimeSo exist:  return");
                        return;
                    }
                    file.delete();
                }
                String strFindLibrary = ((PathClassLoader) WXSoInstallMgrSdk.class.getClassLoader()).findLibrary("weexjssr");
                if (TextUtils.isEmpty(strFindLibrary)) {
                    return;
                }
                file.createNewFile();
                WXFileUtils.copyFileWithException(new File(strFindLibrary), file);
                WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                WXEnvironment.writeDefaultSettingsValue("app_version_code_weex", WXEnvironment.getAppVersionName());
                WXEnvironment.sUseRunTimeApi = true;
                WXLogUtils.e("weex", "copyJssRuntimeSo: cp end and return ");
            } catch (Throwable th) {
                th.printStackTrace();
                WXEnvironment.sUseRunTimeApi = false;
                WXLogUtils.e("weex", "copyJssRuntimeSo:  exception" + th);
            }
        }
    }

    public static void copyStartUpSo() {
        try {
            String packageName = WXEnvironment.getApplication().getPackageName();
            String path = WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath();
            File file_desSoCopyFile = _desSoCopyFile(WXEnvironment.CORE_JSB_SO_NAME);
            if (!file_desSoCopyFile.exists()) {
                file_desSoCopyFile.mkdirs();
            }
            File file = new File(file_desSoCopyFile, STARTUPSO);
            WXEnvironment.CORE_JSB_SO_PATH = file.getAbsolutePath();
            String defaultSettingValue = WXEnvironment.getDefaultSettingValue(WXEnvironment.CORE_JSB_SO_NAME, "-1");
            if (file.exists() && TextUtils.equals(WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                return;
            }
            String strReplace = "/data/data/" + packageName + "/lib";
            if (path != null && path.indexOf("/cache") > 0) {
                strReplace = path.replace("/cache", "/lib");
            }
            File file2 = new File(strReplace, STARTUPSO);
            if (!file2.exists()) {
                try {
                    file2 = new File(((PathClassLoader) WXSoInstallMgrSdk.class.getClassLoader()).findLibrary(WXEnvironment.CORE_JSB_SO_NAME));
                } catch (Throwable unused) {
                }
            }
            if (!file2.exists()) {
                WXEnvironment.extractSo();
                file2 = new File(WXEnvironment.copySoDesDir(), STARTUPSO);
            }
            if (file2.exists()) {
                WXFileUtils.copyFile(file2, file);
            }
            WXEnvironment.writeDefaultSettingsValue(WXEnvironment.CORE_JSB_SO_NAME, WXEnvironment.getAppVersionName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void init(Application application, IWXSoLoaderAdapter iWXSoLoaderAdapter, IWXStatisticsListener iWXStatisticsListener) {
        mContext = application;
        mSoLoader = iWXSoLoaderAdapter;
        mStatisticsListener = iWXStatisticsListener;
    }

    public static boolean initSo(String str, int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
        String str_cpuType = _cpuType();
        if (str_cpuType.equalsIgnoreCase(MIPS)) {
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "initSo", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is MIPS", null);
            return false;
        }
        if (WXEnvironment.CORE_SO_NAME.equals(str)) {
            copyStartUpSo();
        }
        try {
            IWXSoLoaderAdapter iWXSoLoaderAdapter = mSoLoader;
            if (iWXSoLoaderAdapter != null) {
                iWXSoLoaderAdapter.doLoadLibrary(str);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (Error | Exception e) {
            if (str_cpuType.contains(ARMEABI) || str_cpuType.contains("x86")) {
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "initSo", str + "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is " + str_cpuType + "\n Detail Error is: " + e.getMessage(), null);
            }
            if (WXEnvironment.isApkDebugable()) {
                throw e;
            }
            return false;
        }
    }

    public static boolean isCPUSupport() {
        return !_cpuType().equalsIgnoreCase(MIPS);
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    public static boolean isX86() {
        return _cpuType().equalsIgnoreCase("x86");
    }

    static void removeSoIfExit(String str, int i) {
        File file = new File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static boolean unZipSelectedFiles(String str, int i, IWXUserTrackAdapter iWXUserTrackAdapter) throws Throwable {
        Application application;
        InputStream inputStream;
        FileOutputStream fileOutputStreamOpenFileOutput;
        FileChannel channel;
        String str2 = "lib/armeabi/lib" + str + ".so";
        if (!PdrUtil.isSafeEntryName(str2) || (application = mContext) == null) {
            return false;
        }
        ApplicationInfo applicationInfo = application.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        try {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    try {
                        if (zipEntryNextElement.getName().startsWith(str2)) {
                            try {
                                removeSoIfExit(str, i);
                                inputStream = zipFile.getInputStream(zipEntryNextElement);
                                try {
                                    fileOutputStreamOpenFileOutput = application.openFileOutput("lib" + str + "bk" + i + ".so", 0);
                                    try {
                                        channel = fileOutputStreamOpenFileOutput.getChannel();
                                        try {
                                            byte[] bArr = new byte[1024];
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = inputStream.read(bArr);
                                                if (i3 > 0) {
                                                    channel.write(ByteBuffer.wrap(bArr, 0, i3));
                                                    i2 += i3;
                                                } else {
                                                    try {
                                                        break;
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            inputStream.close();
                                            if (channel != null) {
                                                try {
                                                    channel.close();
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            try {
                                                fileOutputStreamOpenFileOutput.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            zipFile.close();
                                            if (i2 > 0) {
                                                return _loadUnzipSo(str, i, iWXUserTrackAdapter);
                                            }
                                            return false;
                                        } catch (Throwable th) {
                                            th = th;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            if (channel != null) {
                                                try {
                                                    channel.close();
                                                } catch (Exception e5) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                            if (fileOutputStreamOpenFileOutput != null) {
                                                try {
                                                    fileOutputStreamOpenFileOutput.close();
                                                } catch (Exception e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            zipFile.close();
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        channel = null;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStreamOpenFileOutput = null;
                                    channel = fileOutputStreamOpenFileOutput;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput != null) {
                                        fileOutputStreamOpenFileOutput.close();
                                    }
                                    zipFile.close();
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                                fileOutputStreamOpenFileOutput = null;
                            }
                        }
                    } catch (IOException e7) {
                        e = e7;
                        zipFile = null;
                        e.printStackTrace();
                        WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT, "unZipSelectedFiles", "[WX_KEY_EXCEPTION_SDK_INIT_unZipSelectedFiles] \n Detail msg is: " + e.getMessage(), null);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        zipFile = null;
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e8) {
            e = e8;
        }
        zipFile.close();
        return false;
    }
}
