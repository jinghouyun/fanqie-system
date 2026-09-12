<template>
  <view class="page">
    <view class="hdr flex-between">
      <text class="hdr-back" @click="T">← 返回</text>
      <text class="hdr-title">番茄小说</text>
      <text class="hdr-right" @click="U">账户</text>
    </view>
    <view class="quota-bar" v-if="n">
      <text class="dim">今日免费: {{ n.used }}/{{ n.limit }} 次</text>
      <text class="warn" v-if="n.remaining <= 0">次数已用完</text>
    </view>
    <view class="tabs">
      <view :class="['tab', { on: 'search' === a }]" @click="a = 'search'">搜索</view>
      <view :class="['tab', { on: 'tasks' === a }]" @click="b">
         任务 
        <text class="badge" v-if="h">{{ h }}</text>
      </view>
    </view>
    <view class="body" v-if="'search' === a">
      <view class="top-notice" v-if="y">
        <text class="top-notice-text">{{ y }}</text>
      </view>
      <view class="search-bar">
        <input class="inp" placeholder="输入书名搜索..." confirm-type="search" @confirm="E" v-model="i" />
        <button class="s-btn" :disabled="u || !i.trim()" @click="E">{{ u ? ".." : "搜索" }}</button>
      </view>
      <view class="results" v-if="d.length">
        <text class="dim mb-16">共 {{ d.length }} 本</text>
        <view class="book" v-for="(t) in d" :key="t">
          <image class="cover" :src="t.thumb_url" mode="aspectFill" v-if="t.thumb_url" />
          <view class="b-info">
            <text class="b-name">{{ t.book_name }}</text>
            <text class="b-author">{{ t.author }}</text>
            <view class="b-tags">
              <text class="tag" v-if="t.word_number">{{ x(t.word_number) }}字</text>
              <text class="tag" v-if="t.serial_count">{{ t.serial_count }}章</text>
              <text class="tag score" v-if="t.score">★{{ t.score }}</text>
              <text :class="['tag', '1' === t.creation_status ? 't-done' : 't-serial' ]">{{ "1" === t.creation_status ? "完结" : "连载" }}</text>
            </view>
            <text class="b-desc">{{ t.abstract || "" }}</text>
          </view>
          <view class="b-foot flex-between">
            <text class="dim fs-22">{{ t.read_count ? C(t.read_count) + "人" : "" }}</text>
            <button class="btn-sm" @click.stop="w(t)">下载全书</button>
          </view>
        </view>
      </view>
      <view class="empty" v-if="!(u || d.length || !m)">
        <text class="empty-icon">📭</text>
        <text class="empty-text">未找到相关内容</text>
      </view>
      <view class="empty" v-if="!(m)">
        <text class="empty-icon">🍅</text>
        <text class="empty-text">搜索番茄小说</text>
      </view>
    </view>
    <view class="body" v-if="'tasks' === a">
      <view class="empty" v-if="!(p.length || k)">
        <text class="empty-icon">📋</text>
        <text class="empty-text">暂无下载任务</text>
      </view>
      <view class="card task" v-for="(t) in p" :key="t">
        <view class="flex-between">
          <text class="t-name">{{ t.book_name || t.task_id }}</text>
          <text :class="['t-st', 'ts-' + t.state]">
            {{ (a = t.state, { pending: "等待中", running: "下载中", done: "已完成", failed: "失败" } [a] || a || "下载中") }}
          </text>
        </view>
        <text class="dim fs-22" v-if="t.book_id">书号: {{ t.book_id }}</text>
        <view class="prog" v-if="null != t.progress && 'done' !== t.state">
          <view class="prog-bar">
            <view class="prog-fill" :style="normalizeStyle({ width: (t.progress || 0) + '%' })" />
          </view>
          <text class="dim fs-22">{{ Math.round(t.progress || 0) }}%</text>
        </view>
        <text class="dim fs-22" v-if="null != t.done && t.total">章节: {{ t.done }}/{{ t.total }}</text>
        <text class="dim fs-22" v-if="t.created_at">创建: {{ D(t.created_at) }}</text>
        <button class="btn-sm" :style="{ 'margin-top': '14rpx' }" @click="S(t)" v-if="'done' === t.state">打开下载</button>
      </view>
    </view>
  </view>
</template>

<script setup>
import { computed, ref } from 'vue'
import { auth } from '@/api'

const a = ref("search");

          function o(e) {
            if (!e) return true;
            const t = new Date(e),
              a = new Date;
            return t.getFullYear() === a.getFullYear() && t.getMonth() === a.getMonth() && t.getDate() === a.getDate()
          }
          const n = ref(null),
            i = ref(""),
            u = ref(false),
            d = ref([]),
            m = ref(false),
            p = ref([]),
            k = ref(false);
          let g = null;
          const y = ref(""),
            h = computed((() => p.value.filter((e => "running" === e.state || "pending" === e.state)).length));
          async function f() {
            try {
              n.value = await s({
                url: "/api/v3/tomato/daily-quota"
              })
            } catch {}
          }
          async function E() {
            const e = i.value.trim();
            if (e) {
              u.value = true, m.value = true, d.value = [];
              try {
                const a = await (t = e, s({
                  url: "/api/v3/tomato/search",
                  method: "POST",
                  data: {
                    keyword: t
                  },
                  showLoading: true
                }));
                uni.setStorageSync("tomato_search_source", a.source || "");
                const l = uni.getStorageSync("notice_version") || "0";
                if (a.notice_version && a.notice_version !== l ? (y.value = a.notice || "", uni.setStorageSync(
                    "notice_version", a.notice_version), uni.setStorageSync("notice_text", a.notice || "")) : a
                  .notice_version || (y.value = a.notice || ""), a.books) d.value = a.books;
                else if (a.search_tabs) {
                  const e = (a.search_tabs || []).find((e => 3 === e.tab_type));
                  (null == e ? void 0 : e.data) && (d.value = e.data.filter((e => {
                    var t;
                    return null == (t = e.book_data) ? void 0 : t.length
                  })).map((e => e.book_data[0])))
                }
              } catch (a) {
                uni.showToast({
                  title: a.message || "搜索失败",
                  icon: "none"
                })
              } finally {
                u.value = false
              }
              var t
            }
          }
          async function w(e) {
            if ((await uni.showModal({
                title: "确认下载",
                content: `《${e.book_name}》\n${e.author} | ${x(e.word_number)}字`
              })).confirm) {
              uni.showLoading({
                title: "创建中..."
              });
              try {
                const t = uni.getStorageSync("tomato_search_source") || "",
                  l = await

                function(e, t = "", a = "", l = "") {
                  return s({
                    url: "/api/v3/tomato/download",
                    method: "POST",
                    data: {
                      book_id: String(e),
                      title: t,
                      author: a,
                      source: l
                    },
                    showLoading: true
                  })
                }(e.book_id, e.book_name, e.author, t);
                uni.hideLoading(), l.task_id && (p.value.unshift({
                  id: l.task_id,
                  task_id: l.task_id,
                  book_name: e.book_name,
                  book_id: e.book_id,
                  state: "running",
                  progress: 0,
                  created_at: Date.now()
                }), f(), a.value = "tasks", B(), uni.showToast({
                  title: "已创建",
                  icon: "success"
                }))
              } catch (t) {
                uni.hideLoading(), uni.showToast({
                  title: t.message || "失败",
                  icon: "none"
                })
              }
            }
          }
          async function N() {
            k.value = true;
            try {
              const e = await s({
                url: "/api/v3/tomato/tasks"
              });
              if (e.tasks && e.tasks.length) {
                const t = e.tasks.filter((e => "notice" !== e.type && o(e.created_at))),
                  a = {};
                t.forEach((e => {
                  const t = e.task_id || e.id;
                  a[t] = {
                    id: t,
                    task_id: t,
                    book_name: e.book_name || "",
                    book_id: e.book_id || "",
                    state: e.state || "running",
                    progress: null != e.progress ? Number(e.progress) : null,
                    created_at: e.created_at || Date.now()
                  }
                }));
                const l = p.value.map((e => {
                    const t = a[e.task_id];
                    return t ? (delete a[e.task_id], "done" === t.state && (t._done = true), t) : e
                  })),
                  n = new Set(l.map((e => e.task_id)));
                Object.values(a).forEach((e => {
                  n.has(e.task_id) || ("done" === e.state && (e._done = true), l.unshift(e))
                }));
                const s = Date.now() - 2592e5;
                p.value = l.filter((e => "done" !== e.state && "failed" !== e.state || (e.created_at || 0) > s)),
                  V()
              }
            } catch {} finally {
              k.value = false
            }
          }

          function V() {
            try {
              const e = p.value.filter((e => "notice" !== e.type && o(e.created_at))).map((e => ({
                id: e.id,
                task_id: e.task_id,
                book_name: e.book_name,
                book_id: e.book_id,
                state: e.state,
                progress: e.progress,
                created_at: e.created_at,
                _done: e._done
              })));
              uni.setStorageSync("tomato_tasks", JSON.stringify(e))
            } catch {}
          }

          function b() {
            a.value = "tasks",
              function() {
                try {
                  const e = uni.getStorageSync("tomato_tasks");
                  if (e) {
                    const t = ["notice_text", "notice_link"],
                      a = JSON.parse(e).filter((e => e.book_id && "notice" !== e.type && !t.includes(e.id) && o(e
                        .created_at)));
                    a.length && (p.value = a)
                  }
                } catch {}
              }(), N(), B()
          }

          function B() {
            _(), g = setInterval((() => {
              "tasks" !== a.value ? _() : async function() {
                const e = p.value.filter((e => "notice" !== e.type && ("running" === e.state ||
                  "pending" === e.state)));
                if (!e.length) return;
                for (const t of e) try {
                  const e = await c(t.task_id);
                  t.state = e.status || "running", t.progress = null != e.progress ? Number(e.progress) :
                    t.progress, t.done = e.done, t.total = e.total, e.book_name && (t.book_name = e
                      .book_name)
                } catch {}
                V()
              }()
            }), 3e3)
          }

          function _() {
            g && (clearInterval(g), g = null)
          }

          function S(e) {
            plus.runtime.openURL(function(e, t = "") {
              const a = l(),
                o = t ? `&title=${encodeURIComponent(t)}` : "";
              return `http://47.116.57.181:3001/api/v3/tomato/download-file/${encodeURIComponent(e)}?auth_token=${encodeURIComponent(a)}${o}`
            }(e.task_id, e.book_name))
          }

          function x(e) {
            const t = Number(e);
            return t >= 1e4 ? (t / 1e4).toFixed(1) + "万" : String(t)
          }

          function C(e) {
            const t = Number(e);
            return t >= 1e4 ? (t / 1e4).toFixed(1) + "万" : String(t)
          }

          function D(e) {
            if (!e) return "";
            const t = new Date(e);
            return `${t.getMonth()+1}/${t.getDate()} ${String(t.getHours()).padStart(2,"0")}:${String(t.getMinutes()).padStart(2,"0")}`
          }

          function T() {
            uni.navigateBack()
          }

          function U() {
            uni.navigateTo({
              url: "/pages/account/account"
            })
          }
          async function I() {
            try {
              const e = await s({
                url: "/api/search-notice?_t=" + Date.now()
              });
              y.value = e.text || "", uni.setStorageSync("notice_text", e.text || "")
            } catch {}
          }
</script>
