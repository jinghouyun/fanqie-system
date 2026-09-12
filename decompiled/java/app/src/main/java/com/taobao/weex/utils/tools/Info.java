package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.common.RenderTypes;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Info {

    @JSONField(name = "instanceId")
    public String instanceId;

    @JSONField(name = RenderTypes.RENDER_TYPE_NATIVE)
    public String platform;

    @JSONField(name = "taskId")
    public int taskId;

    @JSONField(name = "taskInfo")
    public TaskInfo taskInfo = new TaskInfo();

    @JSONField(name = "taskName")
    public String taskName;

    public String toString() {
        return "Info : {instanceId = '" + this.instanceId + "',taskName = '" + this.taskName + "',taskInfo = '" + this.taskInfo + "',platform = '" + this.platform + "',taskId = '" + this.taskId + "'}";
    }
}
