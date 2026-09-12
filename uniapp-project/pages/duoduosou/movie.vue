<template>
  <view class="page">
    <view class="hdr flex-between">
      <text class="hdr-back" @click="n">← 返回</text>
      <text class="hdr-title">{{ a ? "加载中..." : "影片详情" }}</text>
      <text class="hdr-right" />
    </view>
    <view class="empty" v-if="a">
      <text class="dim">加载中...</text>
    </view>
    <view class="hero">
      <view class="poster">
        <image class="p-img" :src="l.cover" mode="aspectFill" v-if="l.cover" />
        <view class="p-img p-ph" v-else>
          <text class="p-ph-txt">🎬</text>
        </view>
      </view>
      <view class="info">
        <text class="title">{{ l.title }}</text>
        <view class="meta">
          <text class="meta-item" v-for="(t, a) in l .meta" :key="t">{{ t }}</text>
        </view>
        <text class="desc" v-if="l.desc">{{ l.desc }}</text>
        <button class="play-btn" @click="c(l.playUrl)" v-if="l .playUrl">立即播放</button>
      </view>
    </view>
    <view class="disks" v-if="l.disks && l.disks.length">
      <view class="disk-panel" v-for="(t, a) in l.disks" :key="t">
        <view class="disk-head">
          <text class="disk-title">{{ t.title }}</text>
          <text class="disk-notice" v-if="t.notice">{{ t.notice }}</text>
        </view>
        <view :class="['disk-item', 'disk-item--' + t .type ]" @click="r(t)" v-for="(t, a) in t .items" :key="t">
          <text class="disk-name">{{ t.name }}</text>
          <text class="disk-url" user-select="">{{ t._shareUrl }}</text>
          <button class="btn-sm" @click.stop="i(t._shareUrl)">复制</button>
          <text class="disk-url" user-select="">{{ t.cachedShareUrl }}</text>
          <button class="btn-sm" @click.stop="i(t .cachedShareUrl)">复制</button>
          <text class="dim" v-if="t._saving">转存中...</text>
          <button class="btn-sm btn-green" v-else>转存获取分享链接</button>
        </view>
      </view>
    </view>
    <view class="related" v-if="l.related && l.related.length">
      <text class="rel-title">推荐影片</text>
      <view class="rel-grid">
        <view class="rel-card" @click="o(t.detailUrl)" v-for="(t, a) in l .related" :key="t">
          <image class="rel-cover" :src="t.cover" mode="aspectFill" v-if="t.cover" />
          <view class="rel-cover rel-ph" v-else />
          <text class="rel-name">{{ t.title }}</text>
        </view>
      </view>
    </view>
    <view class="empty" v-else>
      <text class="dim">影片信息加载失败</text>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'
import { auth } from '@/api'

const a = ref(true),
            l = ref(null);
          async function o(e) {
            if (!e) return l.value = null, void(a.value = false);
            a.value = true, l.value = null;
            try {
              const t = await

              function(e) {
                return s({
                  url: "/api/libvio/detail",
                  method: "POST",
                  data: {
                    url: e
                  }
                })
              }(e);
              t.ok && (l.value = t)
            } catch {} finally {
              a.value = false
            }
          }

          function n() {
            uni.navigateBack()
          }

          function c(e) {
            e && plus.runtime.openURL(e)
          }
          async function r(e) {
            var t;
            if (e.url)
              if (/quark\.cn|drive\.uc\.cn/.test(e.url)) {
                if (!e._saving) {
                  e._saving = true;
                  try {
                    const n = await (a = e.url, o = (null == (t = l.value) ? void 0 : t.title) || "", s({
                      url: "/api/libvio/save-and-share",
                      method: "POST",
                      data: {
                        url: a,
                        title: o
                      }
                    }));
                    if (!n.ok) throw new Error(n.message || "转存失败");
                    e._shareUrl = n.shareUrl
                  } catch (n) {
                    uni.showToast({
                      title: n.message || "转存失败",
                      icon: "none"
                    })
                  } finally {
                    e._saving = false
                  }
                  var a, o
                }
              } else c(e.url)
          }

          function i(e) {
            const t = String(e || "");
            t && uni.setClipboardData({
              data: t,
              success() {
                uni.showToast({
                  title: "已复制",
                  icon: "success"
                })
              }
            })
          }
</script>
