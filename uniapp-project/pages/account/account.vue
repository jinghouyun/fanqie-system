<template>
  <view class="page">
    <view class="hdr flex-between">
      <text class="hdr-back" @click="k">← 返回</text>
      <text class="hdr-title">我的账户</text>
      <view :style="{ width: '80rpx' }" />
    </view>
    <scroll-view scroll-y="" class="body">
      <view class="card">
        <text class="card-title">账户信息</text>
        <view class="row">
          <text class="r-label">用户名</text>
          <text class="r-val">{{ (null == (g = auth.user) ? void 0 : g.username) || "-" }}</text>
        </view>
        <view class="row">
          <text class="r-label">会员到期</text>
          <text :class="['r-val', auth.membershipActive() ? '' : 'danger']">{{ u }}</text>
        </view>
        <view class="row">
          <text class="r-label">剩余下载</text>
          <text class="r-val">
            {{ (null == (y = auth.user) ? void 0 : y .downloads_remaining) ?? 0 }} 次
          </text>
        </view>
      </view>
      <view class="card">
        <text class="card-title">卡密充值</text>
        <view class="field">
          <input class="inp" placeholder="请输入卡密" :disabled="o" v-model="a" />
        </view>
        <button class="btn" :disabled="o || !a.trim()" @click="m">充值</button>
        <view class="tip-ok" v-if="l">
           +{{ l.days }}天 +{{ l .downloads }}次{{ l.is_monthly ? "（月卡）" : "" }}
        </view>
      </view>
      <view class="card" v-if="n.length">
        <text class="card-title">已生效卡密</text>
        <view class="pool-row" v-for="(t) in n" :key="t">
          <view class="flex-between">
            <text class="pool-code">{{ t.code || "卡密" }}</text>
            <text :class="['pool-st', t.remaining > 0 ? 's-ok' : 's-off' ]">{{ t.remaining > 0 ? "生效中" : "已用尽" }}</text>
          </view>
          <view class="pool-det">
            <text class="dim">剩余: {{ t.remaining }}次</text>
            <text class="dim ml-20">到期: {{ d(t.expires_at) }}</text>
          </view>
        </view>
      </view>
      <view class="card" v-if="c">
        <text class="card-title">系统公告</text>
        <text class="dim notice-text">{{ c }}</text>
      </view>
      <view class="card" v-if="i">
        <text class="card-title">月卡购买</text>
        <button class="btn sec" @click="v">查看购买链接</button>
      </view>
      <view class="card">
        <button class="btn sec danger" @click="p">退出登录</button>
      </view>
    </scroll-view>
  </view>
</template>

<script setup>
import { computed, onMounted, ref } from 'vue'
import { auth } from '@/api'

const a = ref(""),
            l = ref(null),
            o = ref(false),
            n = ref([]),
            c = ref(""),
            i = ref(""),
            u = computed((() => {
              var e;
              const t = null == (e = auth.user) ? void 0 : e.membership_expires_at;
              if (!t) return "暂无";
              const a = new Date(t);
              return `${a.getFullYear()}-${String(a.getMonth()+1).padStart(2,"0")}-${String(a.getDate()).padStart(2,"0")}`
            }));

          function d(e) {
            if (!e) return "-";
            const t = new Date(e);
            return `${t.getMonth()+1}/${t.getDate()}`
          }
          async function m() {
            const e = a.value.trim().toUpperCase().replace(/\s+/g, "");
            if (!e) return uni.showToast({
              title: "请输入卡密",
              icon: "none"
            });
            try {
              l.value = await auth.getCardInfo(e)
            } catch {
              l.value = null
            }
            const t = l.value;
            if ((await uni.showModal({
                title: "确认",
                content: t ? `${t.days}天 + ${t.downloads}次${t.is_monthly?"（月卡）":""}` : "确定？"
              })).confirm) {
              o.value = true;
              try {
                await auth.redeem(e), a.value = "", l.value = null, uni.showToast({
                  title: "充值成功",
                  icon: "success"
                }), n.value = await auth.loadPools().catch((() => [])), await auth.loadMe()
              } catch (s) {
                uni.showToast({
                  title: s.message || "失败",
                  icon: "none"
                })
              } finally {
                o.value = false
              }
            }
          }

          function v() {
            i.value && plus.runtime.openURL(i.value)
          }
          async function p() {
            (await uni.showModal({
              title: "提示",
              content: "确定退出？"
            })).confirm && (await auth.logout(), uni.reLaunch({
              url: "/pages/login/login"
            }))
          }

          function k() {
            uni.navigateBack()
          }
          return onMounted((async () => {
            if (auth.token && auth.user) {
              auth.loadMe().catch((() => {})), n.value = await auth.loadPools().catch((() => []));
              try {
                c.value = (await s({
                  url: "/api/user/notice"
                })).notice || ""
              } catch {}
              try {
                i.value = (await s({
                  url: "/api/user/purchase-link"
                })).link || ""
              } catch {}
            } else uni.reLaunch({
              url: "/pages/login/login"
            })
          })), (t, s) => {
            var g, y;
</script>
