package com.taobao.weex.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public final class WXWorkThreadManager {
    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public void destroy() {
        ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
        this.singleThreadExecutor = null;
    }

    public void post(Runnable runnable) {
        ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
