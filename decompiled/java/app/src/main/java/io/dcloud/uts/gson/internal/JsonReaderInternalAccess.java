package io.dcloud.uts.gson.internal;

import io.dcloud.uts.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
