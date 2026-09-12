package io.dcloud.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ThreadPool {
    private static final int MAX_COUNT = 3;
    ExecutorService newFixedThreadPool;
    ExecutorService singleThreadPool;
    ThreadPoolExecutor threadPool;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static class ThreadPoolHolder {
        static ThreadPool mInstance = new ThreadPool();

        ThreadPoolHolder() {
        }
    }

    public static ThreadPool self() {
        return ThreadPoolHolder.mInstance;
    }

    public synchronized void addSingleThreadTask(Runnable runnable) {
        ExecutorService executorService = this.singleThreadPool;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public synchronized void addThreadTask(Runnable runnable) {
        addThreadTask(runnable, false);
    }

    private ThreadPool() {
        this.threadPool = null;
        this.singleThreadPool = null;
        this.newFixedThreadPool = null;
        this.threadPool = new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.newFixedThreadPool = new ThreadPoolExecutor(3, 50, 300L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.singleThreadPool = Executors.newSingleThreadExecutor();
    }

    public synchronized void addThreadTask(Runnable runnable, boolean z) {
        try {
            if (z) {
                this.newFixedThreadPool.execute(runnable);
            } else {
                this.threadPool.execute(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
