package com.taobao.weex.common;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXRequest {
    public static final int DEFAULT_TIMEOUT_MS = 60000;
    public String body;
    public String inputType;
    public String instanceId;
    public String method;
    public Map<String, String> paramMap;
    public String url;
    public int timeoutMs = DEFAULT_TIMEOUT_MS;
    public boolean sslVerify = false;
    public boolean isFirstIpv4 = false;
    public JSONObject tls = null;
}
