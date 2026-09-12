package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class TaskInfo {

    @JSONField(name = "args")
    public String args;

    @JSONField(name = "relateTaskId")
    public int relateTaskId;

    public String toString() {
        return "TaskInfo{args = '" + this.args + "',relateTaskId = '" + this.relateTaskId + "'}";
    }
}
