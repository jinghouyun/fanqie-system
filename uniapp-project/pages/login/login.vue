<template>
  <view class="page">
    <view class="card">
      <view class="logo">🍅</view>
      <text class="title">番茄系统</text>
      <text class="sub">多平台内容搜索与下载</text>
      <view class="tabs">
        <view :class="['tab', { on: 'login' === a }]" @click="a = 'login'">登录</view>
        <view :class="['tab', { on: 'register' === a }]" @click="a = 'register'">注册</view>
      </view>
      <view :class="['msg', c]" v-if="s">{{ s }}</view>
      <view class="field">
        <text class="label">用户名</text>
        <input class="inp" placeholder="3-32位小写字母、数字或下划线" :disabled="n" v-model="l" />
      </view>
      <view class="field">
        <text class="label">密码</text>
        <input class="inp" type="password" placeholder="至少6位" :disabled="n" v-model="o" />
      </view>
      <view class="field" v-if="'register' === a">
        <text class="label">注册渠道</text>
        <view class="inp">
          <text>APP</text>
        </view>
        <text class="dim fs-20">自动识别为APP注册</text>
      </view>
      <button class="btn" :disabled="n" @click="d">{{ n ? "请稍候..." : "login" === a ? "登 录" : "注 册" }}</button>
      <view class="auth-off" v-if="i">
        <text class="dim">服务器未启用账号系统</text>
        <button class="btn sec" @click="m">直接进入</button>
      </view>
    </view>
  </view>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { auth } from '@/api'

const a = ref("login"),
            l = ref(""),
            o = ref(""),
            n = ref(false),
            s = ref(""),
            c = ref(""),
            i = ref(false);

          function u(e, t = "err") {
            s.value = e, c.value = t, setTimeout((() => {
              s.value = ""
            }), 4e3)
          }
          async function d() {
            if (s.value = "", !l.value.trim()) return u("请输入用户名");
            if (!o.value || o.value.length < 6) return u("密码至少6位");
            n.value = true;
            try {
              "login" === a.value ? await auth.login(l.value.trim().toLowerCase(), o.value) : await auth.register(l.value
                  .trim().toLowerCase(), o.value, "tomato", "", "004"), await auth.loadPlatforms(), u("登录成功", "ok"),
                setTimeout((() => uni.reLaunch({
                  url: "/pages/home/home"
                })), 500)
            } catch (e) {
              u(e.message || "操作失败")
            } finally {
              n.value = false
            }
          }

          function m() {
            uni.reLaunch({
              url: "/pages/home/home"
            })
          }
          return onMounted((async () => {
            try {
              await auth.loadMe()
            } catch {}
            if (!auth.authDisabled)
</script>
