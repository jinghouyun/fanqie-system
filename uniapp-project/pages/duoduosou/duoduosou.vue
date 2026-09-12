<template>
  <view class="page">
    <view class="hdr flex-between">
      <text class="hdr-back" @click="C">← 返回</text>
      <text class="hdr-title">多多盘</text>
      <text class="hdr-right" @click="D">账户</text>
    </view>
    <view class="mode-tabs">
      <view :class="['mode-tab', { on: a }]" @click="T">
        <text class="mode-tab-name">影视</text>
        <text class="mode-tab-desc">电影 · 剧集 · 番剧 · 日韩 · 欧美</text>
      </view>
      <view :class="['mode-tab', { on: !a }]" @click="U">
        <text class="mode-tab-name">网盘</text>
        <text class="mode-tab-desc">搜索网盘资源（夸克/百度/迅雷/UC）— 广播剧/有声剧/小说/漫画</text>
      </view>
    </view>
    <view class="search-bar">
      <input class="inp" placeholder="搜索电影、剧集..." confirm-type="search" @confirm="L" v-model="l" />
      <button class="s-btn" :disabled="o || !l.trim()" @click="L">
        <text class="btn-spin" v-if="o" />
        <text>{{ o ? "加载中" : "搜索" }}</text>
      </button>
    </view>
    <scroll-view scroll-x="" class="cat-nav" :show-scrollbar="false">
      <view class="cat-nav-inner">
        <view :class="['cat', { on: i === t.id }]" @click="a = t.id, i = a, d = false, m = 1, I(1)" v-for="(t) in c" :key="t">{{ t.label }}</view>
      </view>
    </scroll-view>
    <view class="empty" v-if="o && !k.length">
      <text class="load-spin" />
      <text class="dim">加载中...</text>
    </view>
    <view class="empty" v-if="!(k.length)">
      <text class="dim">浏览影视</text>
    </view>
    <view class="empty" v-else>
      <text class="dim">暂无内容</text>
    </view>
    <view class="movie-grid" v-if="k.length">
      <view class="m-card" @click="function(e) { detailUrl && uni.navigateTo({ url: '/pages/duoduosou/movie?url=' + encodeURIComponent(detailUrl) }) }(t)" v-for="(t, a) in k" :key="t">
        <image class="m-cover" :src="t.cover" mode="aspectFill" v-if="t.cover" />
        <view class="m-cover m-cover-ph" v-else>
          <text class="m-cover-ph-txt">🎬</text>
        </view>
        <view class="m-info">
          <text class="m-title">{{ t.title }}</text>
          <view class="m-meta">
            <text class="m-score" v-if="t.score">★{{ t.score }}</text>
            <text class="m-status" v-if="t.status">{{ t.status }}</text>
          </view>
        </view>
      </view>
    </view>
    <view class="pager" v-if="d && p > 1">
      <view :class="['pager-btn', { dis: m <= 1 }]" @click="m > 1 && M(m - 1)">上一页</view>
      <text class="pager-info dim">{{ m }}/{{ p }}</text>
      <view :class="['pager-btn', { dis: m >= p }]" @click="m < p && M(m + 1)">下一页</view>
    </view>
    <view class="more-btn" @click="P" v-if="u && i && 'done' === n">更多「{{ g }}」></view>
    <view class="search-bar">
      <input class="inp" placeholder="输入关键词搜索..." confirm-type="search" @confirm="A" v-model="l" />
      <button class="s-btn" :disabled="o || !l.trim()" @click="A">
        <text class="btn-spin" v-if="o" />
        <text>{{ o ? "加载中" : "搜索" }}</text>
      </button>
    </view>
    <scroll-view scroll-x="" class="cat-nav" :show-scrollbar="false">
      <view class="cat-nav-inner">
        <view :class="['cat', { on: f === t }]" @click="a = t, f = a, N = 1, (E.has(a) || w.has(a) || !l.trim() || F([a]))" v-for="(t) in y" :key="t">
          {{ t.label }} 
          <text class="cat-dot" v-if="E.has(t ) && f !== t">✓</text>
        </view>
      </view>
    </scroll-view>
    <view class="empty" v-if="o">
      <text class="dim">搜索中...</text>
    </view>
    <view class="empty" v-if="!(B.length)">
      <text class="dim">输入关键词，搜索网盘资源</text>
    </view>
    <view class="empty" v-else>
      <text class="dim">「{{ x(f) }}」暂无结果</text>
    </view>
    <view class="list" v-if="S.length">
      <view :class="['d-card', { invalid: false === t.valid }]" v-for="(t, a) in S" :key="t">
        <view class="d-top">
          <text class="d-title">{{ t.title || t.name || "无标题" }}</text>
          <text :class="['d-badge', 'db-' + t.diskType]">{{ t.diskLabel || x(t.diskType) }}</text>
        </view>
        <view class="d-hint fail" v-if="false === t.valid">链接已失效</view>
        <view class="d-hint ok" v-if="true === t.valid">链接有效</view>
        <view class="d-foot">
          <text class="d-url" user-select="">{{ t.shareUrl }}</text>
          <button class="btn-sm" @click="function(e) { const t = String(e || ''); t && uni.setClipboardData({ data: t, success() { uni.showToast({ title: '已复制', icon: 'success' }) } }) }(t.shareUrl)">复制</button>
          <button class="btn-sm btn-green" :disabled="V === t.itemId" @click="O(t)" v-else>{{ V === t.itemId ? "处理中..." : "获取分享链接" }}</button>
        </view>
      </view>
    </view>
    <view class="pager" v-if="_  > 1">
      <view :class="['pager-btn', { dis: N <= 1 }]" @click="$(N - 1)">上一页</view>
      <text class="pager-info dim">{{ N }}/{{ _ }}</text>
      <view :class="['pager-btn', { dis: N >= _ }]" @click="$(N + 1)">下一页</view>
    </view>
  </view>
</template>

<script setup>
import { computed, ref } from 'vue'
import { auth } from '@/api'

const a = ref(true),
            l = ref(""),
            o = ref(false),
            n = ref("idle"),
            c = [{
              id: "",
              label: "推荐"
            }, {
              id: "1",
              label: "电影"
            }, {
              id: "2",
              label: "剧集"
            }, {
              id: "4",
              label: "番剧"
            }, {
              id: "15",
              label: "日韩"
            }, {
              id: "16",
              label: "欧美"
            }],
            i = ref(""),
            u = ref(false),
            d = ref(false),
            m = ref(1),
            p = ref(0),
            k = ref([]),
            g = computed((() => {
              var e;
              return (null == (e = c.find((e => e.id === i.value))) ? void 0 : e.label) || "分类"
            })),
            y = ref([{
              value: "quark",
              label: "夸克"
            }, {
              value: "baidu",
              label: "百度"
            }, {
              value: "uc",
              label: "UC"
            }, {
              value: "xunlei",
              label: "迅雷"
            }, {
              value: "tianyi",
              label: "天翼"
            }, {
              value: "pan123",
              label: "123"
            }]),
            h = ref(["quark", "baidu"]),
            f = ref("quark"),
            E = ref(new Set),
            w = ref(new Set),
            N = ref(1),
            V = ref(null),
            b = ref([]),
            B = computed((() => b.value.filter((e => e.diskType === f.value)))),
            _ = computed((() => Math.ceil(B.value.length / 10))),
            S = computed((() => {
              const e = 10 * (N.value - 1);
              return B.value.slice(e, e + 10)
            }));

          function x(e) {
            var t;
            return (null == (t = y.value.find((t => t.value === e))) ? void 0 : t.label) || e
          }

          function C() {
            uni.navigateBack()
          }

          function D() {
            uni.navigateTo({
              url: "/pages/account/account"
            })
          }

          function T() {
            a.value || (a.value = true, k.value.length || I(1))
          }

          function U() {
            a.value && (a.value = false, f.value = h.value[0] || "quark", N.value = 1)
          }
          async function I(e = 1) {
            o.value = true, n.value = "loading";
            try {
              const t = await

              function(e = "", t = 1) {
                return s({
                  url: `/api/libvio/home?cat=${encodeURIComponent(e)}&page=${t}`
                })
              }(i.value, e);
              k.value = (t.items || []).map((e => ({
                title: e.title || "",
                cover: e.cover || "",
                score: e.score || "",
                status: e.status || "",
                detailUrl: e.detailUrl || "",
                itemId: e.itemId || ""
              }))), u.value = !!t.hasMore, p.value = t.totalPages || 0, m.value = e, n.value = "done"
            } catch {
              n.value = "error"
            } finally {
              o.value = false
            }
          }
          async function L() {
            const e = l.value.trim();
            if (e) {
              d.value = false, o.value = true, n.value = "loading";
              try {
                const a = await (t = e, s({
                  url: "/api/libvio/search",
                  method: "POST",
                  data: {
                    keyword: t
                  }
                }));
                k.value = (a.items || []).map((e => ({
                  title: e.title || "",
                  cover: e.cover || "",
                  score: e.score || "",
                  status: e.status || "",
                  detailUrl: e.detailUrl || "",
                  itemId: e.itemId || ""
                }))), u.value = false, p.value = 0, m.value = 1, n.value = "done", k.value.length || (uni.showToast({
                  title: "影视未找到，已切到网盘搜索",
                  icon: "none"
                }), U(), A())
              } catch (a) {
                uni.showToast({
                  title: a.message || "搜索失败",
                  icon: "none"
                }), n.value = "error"
              } finally {
                o.value = false
              }
              var t
            } else uni.showToast({
              title: "请输入搜索关键词",
              icon: "none"
            })
          }

          function P() {
            d.value = true, m.value = 1, I(1)
          }

          function M(e) {
            m.value = e, I(e)
          }

          function A() {
            l.value.trim() ? (b.value = [], E.value = new Set, f.value = h.value[0] || "quark", N.value = 1, F(h
              .value)) : uni.showToast({
              title: "请输入搜索关键词",
              icon: "none"
            })
          }
          async function F(e) {
            o.value = true, n.value = "loading";
            try {
              await Promise.all(e.map((async e => {
                if (!E.value.has(e)) {
                  w.value.add(e);
                  try {
                    const t = await

                    function(e, t) {
                      return s({
                        url: "/api/duoduosou/search",
                        method: "POST",
                        data: {
                          keyword: e,
                          type: t
                        }
                      })
                    }(l.value.trim(), e);
                    E.value.add(e),
                      function(e) {
                        const t = new Set(b.value.map((e => e.itemId)));
                        (e || []).forEach((e => {
                          e.itemId && !t.has(e.itemId) && (t.add(e.itemId), b.value.push({
                            title: e.title || "",
                            name: e.name || "",
                            diskType: e.diskType || "",
                            diskLabel: e.diskLabel || "",
                            valid: e.valid,
                            validReason: e.validReason || "",
                            itemId: e.itemId || "",
                            priority: e.priority || 0,
                            source: e.source || ""
                          }))
                        }))
                      }(t.items || [])
                  } catch (t) {
                    uni.showToast({
                      title: `「${x(e)}」搜索失败`,
                      icon: "none"
                    })
                  } finally {
                    w.value.delete(e)
                  }
                }
              })))
            } finally {
              o.value = false, n.value = "done"
            }
          }

          function $(e) {
            e < 1 || e > _.value || (N.value = e)
          }
          async function O(e) {
            if (e.itemId) {
              V.value = e.itemId;
              try {
                const l = await (t = e.itemId, a = e.title || e.name || "", s({
                  url: "/api/duoduosou/get-share-link",
                  method: "POST",
                  data: {
                    itemId: t,
                    title: a
                  }
                }));
                if (!l.ok) throw new Error(l.message || "获取分享链接失败");
                e.shareUrl = l.shareUrl
              } catch {
                uni.showToast({
                  title: "转存失败，请联系管理员",
                  icon: "none"
                })
              } finally {
                V.value = null
              }
              var t, a
            }
          }
</script>
