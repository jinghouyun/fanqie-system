package io.dcloud.uts.gson;

import io.dcloud.uts.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
