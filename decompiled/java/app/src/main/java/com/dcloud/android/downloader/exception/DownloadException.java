package com.dcloud.android.downloader.exception;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DownloadException extends RuntimeException {
    public static final int EXCEPTION_FILE_SIZE_ZERO = 6;
    public static final int EXCEPTION_IO_EXCEPTION = 5;
    public static final int EXCEPTION_OTHER = 9;
    public static final int EXCEPTION_PATH_NULL = 1;
    public static final int EXCEPTION_PAUSE = 7;
    public static final int EXCEPTION_PROTOCOL = 4;
    public static final int EXCEPTION_SERVER_ERROR = 3;
    public static final int EXCEPTION_SERVER_SUPPORT_CODE = 8;
    public static final int EXCEPTION_URL_ERROR = 2;
    public static final int EXCEPTION_URL_NULL = 0;
    private int code;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExceptionType {
    }

    public DownloadException(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public DownloadException(int i, String str) {
        super(str);
        this.code = i;
    }

    public DownloadException(int i, String str, Throwable th) {
        super(str, th);
        this.code = i;
    }

    public DownloadException(int i, Throwable th) {
        super(th);
        this.code = i;
    }
}
