package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Time {

    @JSONField(name = "constructor")
    public long constructor;

    @JSONField(name = "destructor")
    public long destructor;

    @JSONField(name = "execTime")
    public long execTime;

    @JSONField(name = "taskEnd")
    public long taskEnd;

    @JSONField(name = "taskStart")
    public long taskStart;

    @JSONField(name = "waitTime")
    public long waitTime;

    private void destructor() {
        waitTime();
        this.destructor = System.currentTimeMillis();
    }

    protected void constructor() {
        this.constructor = System.currentTimeMillis();
    }

    public void execTime() {
        this.execTime = this.taskEnd - this.taskStart;
    }

    public void taskEnd() {
        this.taskEnd = System.currentTimeMillis();
        execTime();
        destructor();
    }

    public void taskStart() {
        this.taskStart = System.currentTimeMillis();
    }

    public String toString() {
        return "time : {constructor = '" + this.constructor + "',taskStart = '" + this.taskStart + "',execTime = '" + this.execTime + "',waitTime = '" + this.waitTime + "',destructor = '" + this.destructor + "',taskEnd = '" + this.taskEnd + "'}";
    }

    public void waitTime() {
        this.waitTime = this.taskStart - this.constructor;
    }
}
