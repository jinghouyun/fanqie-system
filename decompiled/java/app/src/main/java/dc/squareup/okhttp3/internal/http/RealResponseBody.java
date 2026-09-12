package dc.squareup.okhttp3.internal.http;

import dc.squareup.okhttp3.MediaType;
import dc.squareup.okhttp3.ResponseBody;
import dc.squareup.okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
