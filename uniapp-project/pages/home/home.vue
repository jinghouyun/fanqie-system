<template>
  <view class="page">
    <view class="hdr flex-between">
      <text class="hdr-title">番茄系统</text>
      <view class="hdr-right">
        <text class="hdr-user" @click="n">{{ (null == (i = auth.user) ? void 0 : i.username) || "" }}</text>
        <text class="hdr-out" @click="s">退出</text>
      </view>
    </view>
    <view class="info" v-if="auth.user">
      <text>会员到期: {{ a }}</text>
      <text>剩余下载: {{ auth.user .downloads_remaining ?? 0 }} 次</text>
    </view>
    <view class="plat" @click="l">
      <text class="plat-icon">🍅</text>
      <view class="plat-body">
        <text class="plat-name">番茄小说</text>
        <text class="plat-desc">链接解析、下载任务管理、本机书籍浏览</text>
      </view>
      <text class="plat-arr">▶</text>
    </view>
    <view class="plat" @click="o">
      <text class="plat-icon">📦</text>
      <view class="plat-body">
        <text class="plat-name">多多盘</text>
        <text class="plat-desc">搜索网盘资源（夸克/百度/迅雷/UC）— 广播剧/有声剧/小说/漫画</text>
      </view>
      <text class="plat-arr">▶</text>
    </view>
  </view>
</template>

<script setup>
import { computed, onMounted } from 'vue'
import { auth } from '@/api'

const a = computed((() => {
            var e;
            const t = null == (e = auth.user) ? void 0 : e.membership_expires_at;
            if (!t) return "暂无";
            const a = new Date(t);
            return `${a.getFullYear()}-${String(a.getMonth()+1).padStart(2,"0")}-${String(a.getDate()).padStart(2,"0")}`
          }));

          function l() {
            auth.savePlatform("tomato").catch((() => {})), uni.navigateTo({
              url: "/pages/tomato/tomato"
            })
          }

          function o() {
            auth.savePlatform("duoduosou").catch((() => {})), uni.navigateTo({
              url: "/pages/duoduosou/duoduosou"
            })
          }

          function n() {
            uni.navigateTo({
              url: "/pages/account/account"
            })
          }
          async function s() {
            (await uni.showModal({
              title: "提示",
              content: "确定退出？"
            })).confirm && (await auth.logout(), uni.reLaunch({
              url: "/pages/login/login"
            }))
          }
          return onMounted((async () => {
            auth.token && auth.user ? (auth.loadPlatforms().catch((() => {})), auth.loadMe().catch((() => {}))) : uni
              .reLaunch({
                url: "/pages/login/login"
              })
          })), (t, c) => {
            var i;
</script>
