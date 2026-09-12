package com.taobao.weex.appfram.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.utils.WXLogUtils;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.constant.AbsoluteConst;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class DefaultWXStorage implements IWXStorageAdapter {
    private WXSQLiteOpenHelper mDatabaseSupplier;
    private ExecutorService mExecutorService;

    public DefaultWXStorage(Context context) {
        this.mDatabaseSupplier = new WXSQLiteOpenHelper(context);
    }

    private void execute(Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor();
        }
        if (runnable == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            return;
        }
        this.mExecutorService.execute(WXThread.secure(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> performGetAllKeys() {
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = database.query("default_wx_storage", new String[]{IApp.ConfigProperty.CONFIG_KEY}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex(IApp.ConfigProperty.CONFIG_KEY)));
                } catch (Exception e) {
                    WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getAllKeys:" + e.getMessage());
                    cursorQuery.close();
                    return arrayList;
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String performGetItem(String str) {
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return null;
        }
        Cursor cursorQuery = database.query("default_wx_storage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
        try {
            if (!cursorQuery.moveToNext()) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", WXSQLiteOpenHelper.sDateFormatter.format(new Date()));
            int iUpdate = this.mDatabaseSupplier.getDatabase().update("default_wx_storage", contentValues, "key= ?", new String[]{str});
            StringBuilder sb = new StringBuilder("update timestamp ");
            sb.append(iUpdate == 1 ? WXImage.SUCCEED : AbsoluteConst.EVENTS_FAILED);
            sb.append(" for operation [getItem(key = ");
            sb.append(str);
            sb.append(")]");
            WXLogUtils.d("weex_storage", sb.toString());
            return cursorQuery.getString(cursorQuery.getColumnIndex("value"));
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getItem:" + e.getMessage());
            return null;
        } finally {
            cursorQuery.close();
        }
        cursorQuery.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long performGetLength() {
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return 0L;
        }
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = database.compileStatement("SELECT count(key) FROM default_wx_storage");
                long jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                sQLiteStatementCompileStatement.close();
                return jSimpleQueryForLong;
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getLength:" + e.getMessage());
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return 0L;
            }
        } catch (Throwable th) {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performRemoveItem(String str) {
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return false;
        }
        try {
            return database.delete("default_wx_storage", "key=?", new String[]{str}) == 1;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute removeItem:" + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00d2  */
    public boolean performSetItem(String str, String str2, boolean z, boolean z2) throws Throwable {
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return false;
        }
        WXLogUtils.d("weex_storage", "set k-v to storage(key:" + str + ",value:" + str2 + ",isPersistent:" + z + ",allowRetry:" + z2 + Operators.BRACKET_END_STR);
        String str3 = WXSQLiteOpenHelper.sDateFormatter.format(new Date());
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = database.compileStatement("INSERT OR REPLACE INTO default_wx_storage VALUES (?,?,?,?);");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, str);
                sQLiteStatementCompileStatement.bindString(2, str2);
                sQLiteStatementCompileStatement.bindString(3, str3);
                sQLiteStatementCompileStatement.bindLong(4, z ? 1L : 0L);
                sQLiteStatementCompileStatement.execute();
                sQLiteStatementCompileStatement.close();
                return true;
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute setItem :" + e.getMessage());
                if (!(e instanceof SQLiteFullException) || !z2 || !trimToSize()) {
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    return false;
                }
                WXLogUtils.d("weex_storage", "retry set k-v to storage(key:" + str + ",value:" + str2 + Operators.BRACKET_END_STR);
                try {
                    boolean zPerformSetItem = performSetItem(str, str2, z, false);
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    return zPerformSetItem;
                } catch (Throwable th) {
                    th = th;
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            throw th;
        }
    }

    private boolean trimToSize() {
        int i;
        SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        int i2 = 0;
        if (database == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = database.query("default_wx_storage", new String[]{IApp.ConfigProperty.CONFIG_KEY, "persistent"}, null, null, null, null, "timestamp ASC");
        try {
            try {
                int count = cursorQuery.getCount() / 10;
                i = 0;
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(IApp.ConfigProperty.CONFIG_KEY));
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("persistent")) != 1 && string != null) {
                            i++;
                            arrayList.add(string);
                            if (i == count) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute trimToSize:" + e.getMessage());
                    }
                }
            } catch (Exception e2) {
                e = e2;
                i = 0;
            }
            if (i <= 0) {
                return false;
            }
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                performRemoveItem((String) obj);
            }
            WXLogUtils.e("weex_storage", "remove " + i + " items by lru");
            return true;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void close() {
        final ExecutorService executorService = this.mExecutorService;
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultWXStorage.this.mDatabaseSupplier.closeDatabase();
                    ExecutorService executorService2 = executorService;
                    if (executorService2 != null) {
                        executorService2.shutdown();
                    }
                } catch (Exception e) {
                    WXLogUtils.e("weex_storage", e.getMessage());
                }
            }
        });
        this.mExecutorService = null;
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getAllKeys(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.5
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> allkeysResult = StorageResultHandler.getAllkeysResult(DefaultWXStorage.this.performGetAllKeys());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(allkeysResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.2
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> itemResult = StorageResultHandler.getItemResult(DefaultWXStorage.this.performGetItem(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void length(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.4
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> lengthResult = StorageResultHandler.getLengthResult(DefaultWXStorage.this.performGetLength());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(lengthResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void removeItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.3
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> mapRemoveItemResult = StorageResultHandler.removeItemResult(DefaultWXStorage.this.performRemoveItem(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(mapRemoveItemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItem(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.1
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> itemResult = StorageResultHandler.setItemResult(DefaultWXStorage.this.performSetItem(str, str2, false, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItemPersistent(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.6
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> itemResult = StorageResultHandler.setItemResult(DefaultWXStorage.this.performSetItem(str, str2, true, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }
}
