if ("undefined" == typeof Promise || Promise.prototype.finally || (Promise.prototype.finally = function(e) {
    const t = this.constructor;
    return this.then((a => t.resolve(e()).then((() => a))), (a => t.resolve(e()).then((() => {
      throw a
    }))))
  }), "undefined" != typeof uni && uni && uni.requireGlobal) {
  const e = uni.requireGlobal();
  ArrayBuffer = e.ArrayBuffer, Int8Array = e.Int8Array, Uint8Array = e.Uint8Array, Uint8ClampedArray = e
    .Uint8ClampedArray, Int16Array = e.Int16Array, Uint16Array = e.Uint16Array, Int32Array = e.Int32Array, Uint32Array =
    e.Uint32Array, Float32Array = e.Float32Array, Float64Array = e.Float64Array, BigInt64Array = e.BigInt64Array,
    BigUint64Array = e.BigUint64Array
}
uni.restoreGlobal && uni.restoreGlobal(Vue, weex, plus, setTimeout, clearTimeout, setInterval, clearInterval),
  function(e) {
    "use strict";
    const t = "http://47.116.57.181:3001";
    let a = null;

    function l() {
      try {
        return uni.getStorageSync("auth_token") || ""
      } catch {
        return ""
      }
    }

    function o() {
      try {
        uni.removeStorageSync("auth_token")
      } catch {}
    }

    function n() {
      try {
        uni.removeStorageSync("auth_user")
      } catch {}
    }

    function s(e) {
      const {
        url: s,
        method: c = "GET",
        data: r,
        header: i = {},
        showLoading: u = !1
      } = e;
      u && uni.showLoading({
        title: "加载中...",
        mask: !0
      });
      const d = l(),
        m = {
          "Content-Type": "application/json",
          "x-app-version": "1.1.0",
          ...i
        };
      d && (m.Authorization = `Bearer ${d}`);
      return function(e, t, l, s, c) {
        return new Promise(((r, i) => {
          const u = new plus.net.XMLHttpRequest,
            d = l && "GET" !== t ? JSON.stringify(l) : null;
          let m = !1;
          const v = setTimeout((() => {
            if (!m) {
              m = !0, c && uni.hideLoading(), i(new Error("请求超时"));
              try {
                u.abort()
              } catch {}
            }
          }), 15e3);
          u.onreadystatechange = () => {
            if (4 !== u.readyState || m) return;
            m = !0, clearTimeout(v), c && uni.hideLoading();
            const e = u.status,
              t = u.responseText || "";
            let l = {};
            try {
              l = JSON.parse(t)
            } catch {}
            return 426 === e ? ("version_outdated" === (null == l ? void 0 : l.error) && a && a(l
              .server_version, l.update_url), void i(new Error("版本过期，请更新"))) : 401 === e ? (o(), n(), uni
              .reLaunch({
                url: "/pages/login/login"
              }), void i(new Error("登录已过期"))) : void(e >= 200 && e < 300 ? r(l) : i(new Error(l.message ||
              `请求失败 (${e})`)))
          }, u.onerror = () => {
            m || (m = !0, clearTimeout(v), c && uni.hideLoading(), i(new Error("连接失败")))
          };
          try {
            u.open(t, e);
            for (const e in s) s[e] && u.setRequestHeader(e, s[e]);
            u.send(d)
          } catch (p) {
            if (m) return;
            m = !0, clearTimeout(v), c && uni.hideLoading(), i(p)
          }
        }))
      }(t + s, c, r, m, u)
    }

    function c(e) {
      return s({
        url: `/api/v3/tomato/task-status/${encodeURIComponent(e)}`
      })
    }
    const r = e.reactive({
        token: "",
        user: null,
        authDisabled: !1,
        platforms: [],
        loading: !1,
        error: "",
        restoreSession() {
          this.token = l() || "", this.user = function() {
            try {
              const e = uni.getStorageSync("auth_user");
              return e ? "string" == typeof e ? JSON.parse(e) : e : null
            } catch {
              return null
            }
          }(), this.token && (this.loadMe(), this.loadPlatforms())
        },
        setSession(e, t) {
          this.token = e || "", this.user = t || null, e ? (function(e) {
            try {
              uni.setStorageSync("auth_token", e)
            } catch {}
          }(e), function(e) {
            try {
              uni.setStorageSync("auth_user", JSON.stringify(e))
            } catch {}
          }(t)) : (o(), n())
        },
        clearSession() {
          this.setSession("", null)
        },
        async loadMe() {
          this.loading = !0, this.error = "";
          try {
            const e = await s({
              url: "/api/auth/me"
            });
            if (e.auth_disabled) return this.authDisabled = !0, void(this.user = null);
            this.authDisabled = !1, e.user ? (this.user = e.user, e.token && this.setSession(e.token, e.user)) : (
              this.user = null, this.token && this.clearSession())
          } catch (e) {
            this.error = e.message || "加载账号失败"
          } finally {
            this.loading = !1
          }
        },
        async loadPlatforms() {
          var e;
          try {
            const t = uni.getStorageSync("platforms_cache");
            if (t) {
              const a = JSON.parse(t);
              (null == (e = a.items) ? void 0 : e.length) && (this.platforms = a.items)
            }
          } catch {}
          try {
            const e = await s({
              url: "/api/platforms"
            });
            Array.isArray(e.items) && (this.platforms = e.items, uni.setStorageSync("platforms_cache", JSON
              .stringify({
                items: e.items,
                version: e.version || 0,
                ts: Date.now()
              })))
          } catch {}
        },
        async login(e, t) {
          const a = await

          function(e, t) {
            return s({
              url: "/api/auth/login",
              method: "POST",
              data: {
                username: e,
                password: t
              },
              showLoading: !0
            })
          }(e, t);
          return this.setSession(a.token, a.user), a
        },
        async register(e, t, a, l, o) {
          const n = await

          function(e, t, a, l, o) {
            return s({
              url: "/api/auth/register",
              method: "POST",
              data: {
                username: e,
                password: t,
                platform_slug: a || "tomato",
                qq: l,
                channel: o
              },
              showLoading: !0
            })
          }(e, t, a, l, o);
          return this.setSession(n.token, n.user), n
        },
        async heartbeat() {
          try {
            return await s({
              url: "/api/auth/heartbeat"
            })
          } catch {
            return null
          }
        },
        async logout() {
          try {
            this.token && await s({
              url: "/api/auth/logout",
              method: "POST"
            })
          } catch {}
          this.clearSession()
        },
        async savePlatform(e) {
          const t = await

          function(e) {
            return s({
              url: "/api/auth/me",
              method: "PATCH",
              data: {
                platform_slug: e
              }
            })
          }(e);
          return t.user && (this.user = t.user), t
        },
        getCardInfo: async e => await
        function(e) {
          return s({
            url: `/api/cards/info/${encodeURIComponent(e)}`
          })
        }(e),
        async redeem(e) {
          const t = await

          function(e) {
            return s({
              url: "/api/cards/redeem",
              method: "POST",
              data: {
                code: e
              }
            })
          }(e);
          return t.user && (this.user = t.user), t
        },
        loadPools: async () => (await s({
          url: "/api/user/pools"
        })).pools || [],
        loadShareToday: async () => await s({
          url: `/api/user/shares/today?_t=${Date.now()}`
        }),
        claimShareToday: async e => await
        function(e) {
          return s({
            url: "/api/user/shares/today/claim",
            method: "POST",
            data: {
              share_id: e
            }
          })
        }(e),
        membershipActive() {
          const e = this.user;
          return !(!e || null == e.membership_expires_at) && e.membership_expires_at > Date.now()
        }
      }),
      i = (e, t) => {
        const a = e.__vccOpts || e;
        for (const [l, o] of t) a[l] = o;
        return a
      },
      u = i({
        __name: "login",
        setup(t) {
          const a = e.ref("login"),
            l = e.ref(""),
            o = e.ref(""),
            n = e.ref(!1),
            s = e.ref(""),
            c = e.ref(""),
            i = e.ref(!1);

          function u(e, t = "err") {
            s.value = e, c.value = t, setTimeout((() => {
              s.value = ""
            }), 4e3)
          }
          async function d() {
            if (s.value = "", !l.value.trim()) return u("请输入用户名");
            if (!o.value || o.value.length < 6) return u("密码至少6位");
            n.value = !0;
            try {
              "login" === a.value ? await r.login(l.value.trim().toLowerCase(), o.value) : await r.register(l.value
                  .trim().toLowerCase(), o.value, "tomato", "", "004"), await r.loadPlatforms(), u("登录成功", "ok"),
                setTimeout((() => uni.reLaunch({
                  url: "/pages/home/home"
                })), 500)
            } catch (e) {
              u(e.message || "操作失败")
            } finally {
              n.value = !1
            }
          }

          function m() {
            uni.reLaunch({
              url: "/pages/home/home"
            })
          }
          return e.onMounted((async () => {
            try {
              await r.loadMe()
            } catch {}
            if (!r.authDisabled) return r.token && r.user ? (await r.loadPlatforms(), void uni.reLaunch({
              url: "/pages/home/home"
            })) : void 0;
            i.value = !0
          })), (t, r) => (e.openBlock(), e.createElementBlock("view", {
            class: "page"
          }, [e.createElementVNode("view", {
            class: "card"
          }, [e.createElementVNode("view", {
            class: "logo"
          }, "🍅"), e.createElementVNode("text", {
            class: "title"
          }, "番茄系统"), e.createElementVNode("text", {
            class: "sub"
          }, "多平台内容搜索与下载"), e.createElementVNode("view", {
            class: "tabs"
          }, [e.createElementVNode("view", {
            class: e.normalizeClass(["tab", {
              on: "login" === a.value
            }]),
            onClick: r[0] || (r[0] = e => a.value = "login")
          }, "登录", 2), e.createElementVNode("view", {
            class: e.normalizeClass(["tab", {
              on: "register" === a.value
            }]),
            onClick: r[1] || (r[1] = e => a.value = "register")
          }, "注册", 2)]), s.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 0,
            class: e.normalizeClass(["msg", c.value])
          }, e.toDisplayString(s.value), 3)) : e.createCommentVNode("", !0), e.createElementVNode(
            "view", {
              class: "field"
            }, [e.createElementVNode("text", {
              class: "label"
            }, "用户名"), e.withDirectives(e.createElementVNode("input", {
              class: "inp",
              "onUpdate:modelValue": r[2] || (r[2] = e => l.value = e),
              placeholder: "3-32位小写字母、数字或下划线",
              disabled: n.value
            }, null, 8, ["disabled"]), [
              [e.vModelText, l.value]
            ])]), e.createElementVNode("view", {
            class: "field"
          }, [e.createElementVNode("text", {
            class: "label"
          }, "密码"), e.withDirectives(e.createElementVNode("input", {
            class: "inp",
            "onUpdate:modelValue": r[3] || (r[3] = e => o.value = e),
            type: "password",
            placeholder: "至少6位",
            disabled: n.value
          }, null, 8, ["disabled"]), [
            [e.vModelText, o.value]
          ])]), "register" === a.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 1,
            class: "field"
          }, [e.createElementVNode("text", {
            class: "label"
          }, "注册渠道"), e.createElementVNode("view", {
            class: "inp"
          }, [e.createElementVNode("text", null, "APP")]), e.createElementVNode("text", {
            class: "dim fs-20"
          }, "自动识别为APP注册")])) : e.createCommentVNode("", !0), e.createElementVNode("button", {
            class: "btn",
            disabled: n.value,
            onClick: d
          }, e.toDisplayString(n.value ? "请稍候..." : "login" === a.value ? "登 录" : "注 册"), 9, [
            "disabled"
          ]), i.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 2,
            class: "auth-off"
          }, [e.createElementVNode("text", {
            class: "dim"
          }, "服务器未启用账号系统"), e.createElementVNode("button", {
            class: "btn sec",
            onClick: m
          }, "直接进入")])) : e.createCommentVNode("", !0)])]))
        }
      }, [
        ["__scopeId", "data-v-52332e30"]
      ]),
      d = i({
        __name: "home",
        setup(t) {
          const a = e.computed((() => {
            var e;
            const t = null == (e = r.user) ? void 0 : e.membership_expires_at;
            if (!t) return "暂无";
            const a = new Date(t);
            return `${a.getFullYear()}-${String(a.getMonth()+1).padStart(2,"0")}-${String(a.getDate()).padStart(2,"0")}`
          }));

          function l() {
            r.savePlatform("tomato").catch((() => {})), uni.navigateTo({
              url: "/pages/tomato/tomato"
            })
          }

          function o() {
            r.savePlatform("duoduosou").catch((() => {})), uni.navigateTo({
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
            })).confirm && (await r.logout(), uni.reLaunch({
              url: "/pages/login/login"
            }))
          }
          return e.onMounted((async () => {
            r.token && r.user ? (r.loadPlatforms().catch((() => {})), r.loadMe().catch((() => {}))) : uni
              .reLaunch({
                url: "/pages/login/login"
              })
          })), (t, c) => {
            var i;
            return e.openBlock(), e.createElementBlock("view", {
              class: "page"
            }, [e.createElementVNode("view", {
              class: "hdr flex-between"
            }, [e.createElementVNode("text", {
              class: "hdr-title"
            }, "番茄系统"), e.createElementVNode("view", {
              class: "hdr-right"
            }, [e.createElementVNode("text", {
                class: "hdr-user",
                onClick: n
              }, e.toDisplayString((null == (i = e.unref(r).user) ? void 0 : i.username) || ""), 1), e
              .createElementVNode("text", {
                class: "hdr-out",
                onClick: s
              }, "退出")
            ])]), e.unref(r).user ? (e.openBlock(), e.createElementBlock("view", {
              key: 0,
              class: "info"
            }, [e.createElementVNode("text", null, "会员到期: " + e.toDisplayString(a.value), 1), e
              .createElementVNode("text", null, "剩余下载: " + e.toDisplayString(e.unref(r).user
                .downloads_remaining ?? 0) + " 次", 1)
            ])) : e.createCommentVNode("", !0), e.createElementVNode("view", {
              class: "plat",
              onClick: l
            }, [e.createElementVNode("text", {
              class: "plat-icon"
            }, "🍅"), e.createElementVNode("view", {
              class: "plat-body"
            }, [e.createElementVNode("text", {
              class: "plat-name"
            }, "番茄小说"), e.createElementVNode("text", {
              class: "plat-desc"
            }, "链接解析、下载任务管理、本机书籍浏览")]), e.createElementVNode("text", {
              class: "plat-arr"
            }, "▶")]), e.createElementVNode("view", {
              class: "plat",
              onClick: o
            }, [e.createElementVNode("text", {
              class: "plat-icon"
            }, "📦"), e.createElementVNode("view", {
              class: "plat-body"
            }, [e.createElementVNode("text", {
              class: "plat-name"
            }, "多多盘"), e.createElementVNode("text", {
              class: "plat-desc"
            }, "搜索网盘资源（夸克/百度/迅雷/UC）— 广播剧/有声剧/小说/漫画")]), e.createElementVNode("text", {
              class: "plat-arr"
            }, "▶")])])
          }
        }
      }, [
        ["__scopeId", "data-v-7dbb5fb9"]
      ]),
      m = (t, a = 0) => (a, l = e.getCurrentInstance()) => {
        !e.isInSSRComponentSetup && e.injectHook(t, a, l)
      },
      v = m("onShow", 3),
      p = m("onLaunch", 1),
      k = m("onLoad", 2),
      g = i({
        __name: "tomato",
        setup(t) {
          const a = e.ref("search");

          function o(e) {
            if (!e) return !0;
            const t = new Date(e),
              a = new Date;
            return t.getFullYear() === a.getFullYear() && t.getMonth() === a.getMonth() && t.getDate() === a.getDate()
          }
          const n = e.ref(null),
            i = e.ref(""),
            u = e.ref(!1),
            d = e.ref([]),
            m = e.ref(!1),
            p = e.ref([]),
            k = e.ref(!1);
          let g = null;
          const y = e.ref(""),
            h = e.computed((() => p.value.filter((e => "running" === e.state || "pending" === e.state)).length));
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
              u.value = !0, m.value = !0, d.value = [];
              try {
                const a = await (t = e, s({
                  url: "/api/v3/tomato/search",
                  method: "POST",
                  data: {
                    keyword: t
                  },
                  showLoading: !0
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
                u.value = !1
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
                    showLoading: !0
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
            k.value = !0;
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
                    return t ? (delete a[e.task_id], "done" === t.state && (t._done = !0), t) : e
                  })),
                  n = new Set(l.map((e => e.task_id)));
                Object.values(a).forEach((e => {
                  n.has(e.task_id) || ("done" === e.state && (e._done = !0), l.unshift(e))
                }));
                const s = Date.now() - 2592e5;
                p.value = l.filter((e => "done" !== e.state && "failed" !== e.state || (e.created_at || 0) > s)),
                  V()
              }
            } catch {} finally {
              k.value = !1
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
          return e.onMounted((() => {
            if (r.token && r.user) {
              r.loadMe().catch((() => {})), f();
              try {
                y.value = uni.getStorageSync("notice_text") || ""
              } catch {}
              try {
                const e = uni.getStorageSync("tomato_tasks");
                if (e) {
                  const t = JSON.parse(e),
                    a = t.filter((e => e.book_id && e.task_id && !String(e.id).startsWith("notice_") &&
                      "notice" !== e.type));
                  a.length !== t.length && uni.setStorageSync("tomato_tasks", JSON.stringify(a))
                }
              } catch {}
            } else uni.reLaunch({
              url: "/pages/login/login"
            })
          })), v((() => {
            I()
          })), e.onUnmounted((() => _())), (t, l) => (e.openBlock(), e.createElementBlock("view", {
            class: "page"
          }, [e.createElementVNode("view", {
            class: "hdr flex-between"
          }, [e.createElementVNode("text", {
            class: "hdr-back",
            onClick: T
          }, "← 返回"), e.createElementVNode("text", {
            class: "hdr-title"
          }, "番茄小说"), e.createElementVNode("text", {
            class: "hdr-right",
            onClick: U
          }, "账户")]), n.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 0,
            class: "quota-bar"
          }, [e.createElementVNode("text", {
              class: "dim"
            }, "今日免费: " + e.toDisplayString(n.value.used) + "/" + e.toDisplayString(n.value.limit) +
            " 次", 1), n.value.remaining <= 0 ? (e.openBlock(), e.createElementBlock("text", {
            key: 0,
            class: "warn"
          }, "次数已用完")) : e.createCommentVNode("", !0)])) : e.createCommentVNode("", !0), e.createElementVNode(
            "view", {
              class: "tabs"
            }, [e.createElementVNode("view", {
              class: e.normalizeClass(["tab", {
                on: "search" === a.value
              }]),
              onClick: l[0] || (l[0] = e => a.value = "search")
            }, "搜索", 2), e.createElementVNode("view", {
              class: e.normalizeClass(["tab", {
                on: "tasks" === a.value
              }]),
              onClick: b
            }, [e.createTextVNode(" 任务 "), h.value ? (e.openBlock(), e.createElementBlock("text", {
              key: 0,
              class: "badge"
            }, e.toDisplayString(h.value), 1)) : e.createCommentVNode("", !0)], 2)]), "search" === a.value ? (
            e.openBlock(), e.createElementBlock("view", {
              key: 1,
              class: "body"
            }, [y.value ? (e.openBlock(), e.createElementBlock("view", {
                key: 0,
                class: "top-notice"
              }, [e.createElementVNode("text", {
                class: "top-notice-text"
              }, e.toDisplayString(y.value), 1)])) : e.createCommentVNode("", !0), e.createElementVNode(
                "view", {
                  class: "search-bar"
                }, [e.withDirectives(e.createElementVNode("input", {
                  class: "inp",
                  "onUpdate:modelValue": l[1] || (l[1] = e => i.value = e),
                  placeholder: "输入书名搜索...",
                  "confirm-type": "search",
                  onConfirm: E
                }, null, 544), [
                  [e.vModelText, i.value]
                ]), e.createElementVNode("button", {
                  class: "s-btn",
                  disabled: u.value || !i.value.trim(),
                  onClick: E
                }, e.toDisplayString(u.value ? ".." : "搜索"), 9, ["disabled"])]), d.value.length ? (e
                .openBlock(), e.createElementBlock("view", {
                  key: 1,
                  class: "results"
                }, [e.createElementVNode("text", {
                  class: "dim mb-16"
                }, "共 " + e.toDisplayString(d.value.length) + " 本", 1), (e.openBlock(!0), e
                  .createElementBlock(e.Fragment, null, e.renderList(d.value, (t => (e.openBlock(), e
                    .createElementBlock("view", {
                      key: t.book_id,
                      class: "book"
                    }, [t.thumb_url ? (e.openBlock(), e.createElementBlock("image", {
                        key: 0,
                        class: "cover",
                        src: t.thumb_url,
                        mode: "aspectFill"
                      }, null, 8, ["src"])) : e.createCommentVNode("", !0), e
                      .createElementVNode("view", {
                        class: "b-info"
                      }, [e.createElementVNode("text", {
                        class: "b-name"
                      }, e.toDisplayString(t.book_name), 1), e.createElementVNode("text", {
                        class: "b-author"
                      }, e.toDisplayString(t.author), 1), e.createElementVNode("view", {
                        class: "b-tags"
                      }, [t.word_number ? (e.openBlock(), e.createElementBlock("text", {
                          key: 0,
                          class: "tag"
                        }, e.toDisplayString(x(t.word_number)) + "字", 1)) : e
                        .createCommentVNode("", !0), t.serial_count ? (e.openBlock(), e
                          .createElementBlock("text", {
                            key: 1,
                            class: "tag"
                          }, e.toDisplayString(t.serial_count) + "章", 1)) : e
                        .createCommentVNode("", !0), t.score ? (e.openBlock(), e
                          .createElementBlock("text", {
                            key: 2,
                            class: "tag score"
                          }, "★" + e.toDisplayString(t.score), 1)) : e.createCommentVNode(
                          "", !0), e.createElementVNode("text", {
                            class: e.normalizeClass(["tag", "1" === t.creation_status ?
                              "t-done" : "t-serial"
                            ])
                          }, e.toDisplayString("1" === t.creation_status ? "完结" : "连载"),
                          3)
                      ]), e.createElementVNode("text", {
                        class: "b-desc"
                      }, e.toDisplayString(t.abstract || ""), 1)]), e.createElementVNode(
                        "view", {
                          class: "b-foot flex-between"
                        }, [e.createElementVNode("text", {
                            class: "dim fs-22"
                          }, e.toDisplayString(t.read_count ? C(t.read_count) + "人" : ""), 1), e
                          .createElementVNode("button", {
                            class: "btn-sm",
                            onClick: e.withModifiers((e => w(t)), ["stop"])
                          }, "下载全书", 8, ["onClick"])
                        ])
                    ])))), 128))])) : e.createCommentVNode("", !0), u.value || d.value.length || !m.value ?
              e.createCommentVNode("", !0) : (e.openBlock(), e.createElementBlock("view", {
                key: 2,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "empty-icon"
              }, "📭"), e.createElementVNode("text", {
                class: "empty-text"
              }, "未找到相关内容")])), m.value ? e.createCommentVNode("", !0) : (e.openBlock(), e
                .createElementBlock("view", {
                  key: 3,
                  class: "empty"
                }, [e.createElementVNode("text", {
                  class: "empty-icon"
                }, "🍅"), e.createElementVNode("text", {
                  class: "empty-text"
                }, "搜索番茄小说")]))
            ])) : e.createCommentVNode("", !0), "tasks" === a.value ? (e.openBlock(), e.createElementBlock(
            "view", {
              key: 2,
              class: "body"
            }, [p.value.length || k.value ? e.createCommentVNode("", !0) : (e.openBlock(), e
              .createElementBlock("view", {
                key: 0,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "empty-icon"
              }, "📋"), e.createElementVNode("text", {
                class: "empty-text"
              }, "暂无下载任务")])), (e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(p
              .value, (t => {
                return e.openBlock(), e.createElementBlock("view", {
                  key: t.id || t.task_id,
                  class: "card task"
                }, [e.createElementVNode("view", {
                    class: "flex-between"
                  }, [e.createElementVNode("text", {
                    class: "t-name"
                  }, e.toDisplayString(t.book_name || t.task_id), 1), e.createElementVNode(
                    "text", {
                      class: e.normalizeClass(["t-st", "ts-" + t.state])
                    }, e.toDisplayString((a = t.state, {
                      pending: "等待中",
                      running: "下载中",
                      done: "已完成",
                      failed: "失败"
                    } [a] || a || "下载中")), 3)]), t.book_id ? (e.openBlock(), e
                    .createElementBlock("text", {
                      key: 0,
                      class: "dim fs-22"
                    }, "书号: " + e.toDisplayString(t.book_id), 1)) : e.createCommentVNode("", !
                    0), null != t.progress && "done" !== t.state ? (e.openBlock(), e
                    .createElementBlock("view", {
                      key: 1,
                      class: "prog"
                    }, [e.createElementVNode("view", {
                      class: "prog-bar"
                    }, [e.createElementVNode("view", {
                      class: "prog-fill",
                      style: e.normalizeStyle({
                        width: (t.progress || 0) + "%"
                      })
                    }, null, 4)]), e.createElementVNode("text", {
                      class: "dim fs-22"
                    }, e.toDisplayString(Math.round(t.progress || 0)) + "%", 1)])) : e
                  .createCommentVNode("", !0), null != t.done && t.total ? (e.openBlock(), e
                    .createElementBlock("text", {
                        key: 2,
                        class: "dim fs-22"
                      }, "章节: " + e.toDisplayString(t.done) + "/" + e.toDisplayString(t.total),
                      1)) : e.createCommentVNode("", !0), t.created_at ? (e.openBlock(), e
                    .createElementBlock("text", {
                      key: 3,
                      class: "dim fs-22"
                    }, "创建: " + e.toDisplayString(D(t.created_at)), 1)) : e.createCommentVNode(
                    "", !0), "done" === t.state ? (e.openBlock(), e.createElementBlock(
                    "button", {
                      key: 4,
                      class: "btn-sm",
                      style: {
                        "margin-top": "14rpx"
                      },
                      onClick: e => S(t)
                    }, "打开下载", 8, ["onClick"])) : e.createCommentVNode("", !0)
                ]);
                var a
              })), 128))])) : e.createCommentVNode("", !0)]))
        }
      }, [
        ["__scopeId", "data-v-c6c0109b"]
      ]),
      y = i({
        __name: "duoduosou",
        setup(t) {
          const a = e.ref(!0),
            l = e.ref(""),
            o = e.ref(!1),
            n = e.ref("idle"),
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
            i = e.ref(""),
            u = e.ref(!1),
            d = e.ref(!1),
            m = e.ref(1),
            p = e.ref(0),
            k = e.ref([]),
            g = e.computed((() => {
              var e;
              return (null == (e = c.find((e => e.id === i.value))) ? void 0 : e.label) || "分类"
            })),
            y = e.ref([{
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
            h = e.ref(["quark", "baidu"]),
            f = e.ref("quark"),
            E = e.ref(new Set),
            w = e.ref(new Set),
            N = e.ref(1),
            V = e.ref(null),
            b = e.ref([]),
            B = e.computed((() => b.value.filter((e => e.diskType === f.value)))),
            _ = e.computed((() => Math.ceil(B.value.length / 10))),
            S = e.computed((() => {
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
            a.value || (a.value = !0, k.value.length || I(1))
          }

          function U() {
            a.value && (a.value = !1, f.value = h.value[0] || "quark", N.value = 1)
          }
          async function I(e = 1) {
            o.value = !0, n.value = "loading";
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
              o.value = !1
            }
          }
          async function L() {
            const e = l.value.trim();
            if (e) {
              d.value = !1, o.value = !0, n.value = "loading";
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
                }))), u.value = !1, p.value = 0, m.value = 1, n.value = "done", k.value.length || (uni.showToast({
                  title: "影视未找到，已切到网盘搜索",
                  icon: "none"
                }), U(), A())
              } catch (a) {
                uni.showToast({
                  title: a.message || "搜索失败",
                  icon: "none"
                }), n.value = "error"
              } finally {
                o.value = !1
              }
              var t
            } else uni.showToast({
              title: "请输入搜索关键词",
              icon: "none"
            })
          }

          function P() {
            d.value = !0, m.value = 1, I(1)
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
            o.value = !0, n.value = "loading";
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
              o.value = !1, n.value = "done"
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
          return v((async () => {
            var e, t;
            if (r.token && r.user) {
              r.loadMe().catch((() => {}));
              try {
                const a = await s({
                  url: "/api/duoduosou/channels"
                });
                (null == (e = a.channels) ? void 0 : e.length) && (y.value = a.channels.map((e => ({
                  value: e.slug,
                  label: e.label
                })))), (null == (t = a.autoTypes) ? void 0 : t.length) && (h.value = a.autoTypes)
              } catch {}
              a.value && !k.value.length && "idle" === n.value && I(1)
            } else uni.reLaunch({
              url: "/pages/login/login"
            })
          })), (t, s) => (e.openBlock(), e.createElementBlock("view", {
            class: "page"
          }, [e.createElementVNode("view", {
            class: "hdr flex-between"
          }, [e.createElementVNode("text", {
            class: "hdr-back",
            onClick: C
          }, "← 返回"), e.createElementVNode("text", {
            class: "hdr-title"
          }, "多多盘"), e.createElementVNode("text", {
            class: "hdr-right",
            onClick: D
          }, "账户")]), e.createElementVNode("view", {
            class: "mode-tabs"
          }, [e.createElementVNode("view", {
            class: e.normalizeClass(["mode-tab", {
              on: a.value
            }]),
            onClick: T
          }, [e.createElementVNode("text", {
            class: "mode-tab-name"
          }, "影视"), e.createElementVNode("text", {
            class: "mode-tab-desc"
          }, "电影 · 剧集 · 番剧 · 日韩 · 欧美")], 2), e.createElementVNode("view", {
            class: e.normalizeClass(["mode-tab", {
              on: !a.value
            }]),
            onClick: U
          }, [e.createElementVNode("text", {
            class: "mode-tab-name"
          }, "网盘"), e.createElementVNode("text", {
            class: "mode-tab-desc"
          }, "搜索网盘资源（夸克/百度/迅雷/UC）— 广播剧/有声剧/小说/漫画")], 2)]), a.value ? (e.openBlock(), e.createElementBlock(e
            .Fragment, {
              key: 0
            }, [e.createElementVNode("view", {
                class: "search-bar"
              }, [e.withDirectives(e.createElementVNode("input", {
                class: "inp",
                "onUpdate:modelValue": s[0] || (s[0] = e => l.value = e),
                placeholder: "搜索电影、剧集...",
                "confirm-type": "search",
                onConfirm: L
              }, null, 544), [
                [e.vModelText, l.value]
              ]), e.createElementVNode("button", {
                class: "s-btn",
                disabled: o.value || !l.value.trim(),
                onClick: L
              }, [o.value ? (e.openBlock(), e.createElementBlock("text", {
                key: 0,
                class: "btn-spin"
              })) : e.createCommentVNode("", !0), e.createElementVNode("text", null, e
                .toDisplayString(o.value ? "加载中" : "搜索"), 1)], 8, ["disabled"])]), e.createElementVNode(
                "scroll-view", {
                  "scroll-x": "",
                  class: "cat-nav",
                  "show-scrollbar": !1
                }, [e.createElementVNode("view", {
                  class: "cat-nav-inner"
                }, [(e.openBlock(), e.createElementBlock(e.Fragment, null, e.renderList(c, (t => e
                  .createElementVNode("view", {
                    key: t.id,
                    class: e.normalizeClass(["cat", {
                      on: i.value === t.id
                    }]),
                    onClick: e => {
                      return a = t.id, i.value = a, d.value = !1, m.value = 1, void I(1);
                      var a
                    }
                  }, e.toDisplayString(t.label), 11, ["onClick"]))), 64))])]), o.value && !k.value.length ?
              (e.openBlock(), e.createElementBlock("view", {
                key: 0,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "load-spin"
              }), e.createElementVNode("text", {
                class: "dim"
              }, "加载中...")])) : k.value.length || "done" !== n.value ? k.value.length ? e
              .createCommentVNode("", !0) : (e.openBlock(), e.createElementBlock("view", {
                key: 2,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "dim"
              }, "浏览影视")])) : (e.openBlock(), e.createElementBlock("view", {
                key: 1,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "dim"
              }, "暂无内容")])), k.value.length ? (e.openBlock(), e.createElementBlock("view", {
                key: 3,
                class: "movie-grid"
              }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(k.value, ((t,
                a) => (e.openBlock(), e.createElementBlock("view", {
                key: a,
                class: "m-card",
                onClick: e => function(e) {
                  e.detailUrl && uni.navigateTo({
                    url: "/pages/duoduosou/movie?url=" + encodeURIComponent(e
                      .detailUrl)
                  })
                }(t)
              }, [t.cover ? (e.openBlock(), e.createElementBlock("image", {
                key: 0,
                class: "m-cover",
                src: t.cover,
                mode: "aspectFill"
              }, null, 8, ["src"])) : (e.openBlock(), e.createElementBlock("view", {
                key: 1,
                class: "m-cover m-cover-ph"
              }, [e.createElementVNode("text", {
                class: "m-cover-ph-txt"
              }, "🎬")])), e.createElementVNode("view", {
                class: "m-info"
              }, [e.createElementVNode("text", {
                class: "m-title"
              }, e.toDisplayString(t.title), 1), e.createElementVNode("view", {
                class: "m-meta"
              }, [t.score ? (e.openBlock(), e.createElementBlock("text", {
                key: 0,
                class: "m-score"
              }, "★" + e.toDisplayString(t.score), 1)) : e.createCommentVNode(
                "", !0), t.status ? (e.openBlock(), e.createElementBlock(
                "text", {
                  key: 1,
                  class: "m-status"
                }, e.toDisplayString(t.status), 1)) : e.createCommentVNode("", !
                0)])])], 8, ["onClick"])))), 128))])) : e.createCommentVNode("", !0), d.value && p.value >
              1 ? (e.openBlock(), e.createElementBlock("view", {
                key: 4,
                class: "pager"
              }, [e.createElementVNode("view", {
                  class: e.normalizeClass(["pager-btn", {
                    dis: m.value <= 1
                  }]),
                  onClick: s[1] || (s[1] = e => m.value > 1 && M(m.value - 1))
                }, "上一页", 2), e.createElementVNode("text", {
                  class: "pager-info dim"
                }, e.toDisplayString(m.value) + "/" + e.toDisplayString(p.value), 1), e
                .createElementVNode("view", {
                  class: e.normalizeClass(["pager-btn", {
                    dis: m.value >= p.value
                  }]),
                  onClick: s[2] || (s[2] = e => m.value < p.value && M(m.value + 1))
                }, "下一页", 2)
              ])) : u.value && i.value && "done" === n.value ? (e.openBlock(), e.createElementBlock(
                "view", {
                  key: 5,
                  class: "more-btn",
                  onClick: P
                }, "更多「" + e.toDisplayString(g.value) + "」>", 1)) : e.createCommentVNode("", !0)
            ], 64)) : (e.openBlock(), e.createElementBlock(e.Fragment, {
            key: 1
          }, [e.createElementVNode("view", {
              class: "search-bar"
            }, [e.withDirectives(e.createElementVNode("input", {
              class: "inp",
              "onUpdate:modelValue": s[3] || (s[3] = e => l.value = e),
              placeholder: "输入关键词搜索...",
              "confirm-type": "search",
              onConfirm: A
            }, null, 544), [
              [e.vModelText, l.value]
            ]), e.createElementVNode("button", {
              class: "s-btn",
              disabled: o.value || !l.value.trim(),
              onClick: A
            }, [o.value ? (e.openBlock(), e.createElementBlock("text", {
              key: 0,
              class: "btn-spin"
            })) : e.createCommentVNode("", !0), e.createElementVNode("text", null, e
              .toDisplayString(o.value ? "加载中" : "搜索"), 1)], 8, ["disabled"])]), e.createElementVNode(
              "scroll-view", {
                "scroll-x": "",
                class: "cat-nav",
                "show-scrollbar": !1
              }, [e.createElementVNode("view", {
                class: "cat-nav-inner"
              }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(y.value, (t =>
                (e.openBlock(), e.createElementBlock("view", {
                  key: t.value,
                  class: e.normalizeClass(["cat", {
                    on: f.value === t.value
                  }]),
                  onClick: e => {
                    return a = t.value, f.value = a, N.value = 1, void(E.value.has(a) ||
                      w.value.has(a) || !l.value.trim() || F([a]));
                    var a
                  }
                }, [e.createTextVNode(e.toDisplayString(t.label) + " ", 1), E.value.has(t
                  .value) && f.value !== t.value ? (e.openBlock(), e.createElementBlock(
                  "text", {
                    key: 0,
                    class: "cat-dot"
                  }, "✓")) : e.createCommentVNode("", !0)], 10, ["onClick"])))), 128))])]), o.value ? (e
              .openBlock(), e.createElementBlock("view", {
                key: 0,
                class: "empty"
              }, [e.createElementVNode("text", {
                class: "dim"
              }, "搜索中...")])) : B.value.length || "done" !== n.value ? B.value.length ? e
            .createCommentVNode("", !0) : (e.openBlock(), e.createElementBlock("view", {
              key: 2,
              class: "empty"
            }, [e.createElementVNode("text", {
              class: "dim"
            }, "输入关键词，搜索网盘资源")])) : (e.openBlock(), e.createElementBlock("view", {
              key: 1,
              class: "empty"
            }, [e.createElementVNode("text", {
              class: "dim"
            }, "「" + e.toDisplayString(x(f.value)) + "」暂无结果", 1)])), S.value.length ? (e.openBlock(), e
              .createElementBlock("view", {
                key: 3,
                class: "list"
              }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(S.value, ((t,
                a) => (e.openBlock(), e.createElementBlock("view", {
                key: a,
                class: e.normalizeClass(["d-card", {
                  invalid: !1 === t.valid
                }])
              }, [e.createElementVNode("view", {
                class: "d-top"
              }, [e.createElementVNode("text", {
                  class: "d-title"
                }, e.toDisplayString(t.title || t.name || "无标题"), 1), e
                .createElementVNode("text", {
                  class: e.normalizeClass(["d-badge", "db-" + t.diskType])
                }, e.toDisplayString(t.diskLabel || x(t.diskType)), 3)
              ]), !1 === t.valid ? (e.openBlock(), e.createElementBlock("view", {
                key: 0,
                class: "d-hint fail"
              }, "链接已失效")) : !0 === t.valid ? (e.openBlock(), e.createElementBlock(
                "view", {
                  key: 1,
                  class: "d-hint ok"
                }, "链接有效")) : e.createCommentVNode("", !0), e.createElementVNode(
                "view", {
                  class: "d-foot"
                }, [t.shareUrl ? (e.openBlock(), e.createElementBlock(e.Fragment, {
                  key: 0
                }, [e.createElementVNode("text", {
                  class: "d-url",
                  "user-select": ""
                }, e.toDisplayString(t.shareUrl), 1), e.createElementVNode(
                  "button", {
                    class: "btn-sm",
                    onClick: e => function(e) {
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
                    }(t.shareUrl)
                  }, "复制", 8, ["onClick"])], 64)) : (e.openBlock(), e
                  .createElementBlock("button", {
                      key: 1,
                      class: "btn-sm btn-green",
                      disabled: V.value === t.itemId,
                      onClick: e => O(t)
                    }, e.toDisplayString(V.value === t.itemId ? "处理中..." : "获取分享链接"),
                    9, ["disabled", "onClick"]))])], 2)))), 128))])) : e.createCommentVNode("", !0), _
            .value > 1 ? (e.openBlock(), e.createElementBlock("view", {
              key: 4,
              class: "pager"
            }, [e.createElementVNode("view", {
                class: e.normalizeClass(["pager-btn", {
                  dis: N.value <= 1
                }]),
                onClick: s[4] || (s[4] = e => $(N.value - 1))
              }, "上一页", 2), e.createElementVNode("text", {
                class: "pager-info dim"
              }, e.toDisplayString(N.value) + "/" + e.toDisplayString(_.value), 1), e
              .createElementVNode("view", {
                class: e.normalizeClass(["pager-btn", {
                  dis: N.value >= _.value
                }]),
                onClick: s[5] || (s[5] = e => $(N.value + 1))
              }, "下一页", 2)
            ])) : e.createCommentVNode("", !0)
          ], 64))]))
        }
      }, [
        ["__scopeId", "data-v-93d609b5"]
      ]),
      h = i({
        __name: "movie",
        setup(t) {
          const a = e.ref(!0),
            l = e.ref(null);
          async function o(e) {
            if (!e) return l.value = null, void(a.value = !1);
            a.value = !0, l.value = null;
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
              a.value = !1
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
                  e._saving = !0;
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
                    e._saving = !1
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
          return k((e => {
            o(decodeURIComponent((null == e ? void 0 : e.url) || ""))
          })), (t, s) => (e.openBlock(), e.createElementBlock("view", {
            class: "page"
          }, [e.createElementVNode("view", {
            class: "hdr flex-between"
          }, [e.createElementVNode("text", {
            class: "hdr-back",
            onClick: n
          }, "← 返回"), e.createElementVNode("text", {
            class: "hdr-title"
          }, e.toDisplayString(a.value ? "加载中..." : "影片详情"), 1), e.createElementVNode("text", {
            class: "hdr-right"
          })]), a.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 0,
            class: "empty"
          }, [e.createElementVNode("text", {
            class: "dim"
          }, "加载中...")])) : l.value ? (e.openBlock(), e.createElementBlock(e.Fragment, {
            key: 1
          }, [e.createElementVNode("view", {
            class: "hero"
          }, [e.createElementVNode("view", {
            class: "poster"
          }, [l.value.cover ? (e.openBlock(), e.createElementBlock("image", {
            key: 0,
            class: "p-img",
            src: l.value.cover,
            mode: "aspectFill"
          }, null, 8, ["src"])) : (e.openBlock(), e.createElementBlock("view", {
            key: 1,
            class: "p-img p-ph"
          }, [e.createElementVNode("text", {
            class: "p-ph-txt"
          }, "🎬")]))]), e.createElementVNode("view", {
            class: "info"
          }, [e.createElementVNode("text", {
              class: "title"
            }, e.toDisplayString(l.value.title), 1), e.createElementVNode("view", {
              class: "meta"
            }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(l.value
              .meta, ((t, a) => (e.openBlock(), e.createElementBlock("text", {
                key: a,
                class: "meta-item"
              }, e.toDisplayString(t), 1)))), 128))]), l.value.desc ? (e.openBlock(), e
              .createElementBlock("text", {
                key: 0,
                class: "desc"
              }, e.toDisplayString(l.value.desc), 1)) : e.createCommentVNode("", !0), l.value
            .playUrl ? (e.openBlock(), e.createElementBlock("button", {
              key: 1,
              class: "play-btn",
              onClick: s[0] || (s[0] = e => c(l.value.playUrl))
            }, "立即播放")) : e.createCommentVNode("", !0)
          ])]), l.value.disks && l.value.disks.length ? (e.openBlock(), e.createElementBlock("view", {
            key: 0,
            class: "disks"
          }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(l.value.disks, (
            (t, a) => (e.openBlock(), e.createElementBlock("view", {
              key: a,
              class: "disk-panel"
            }, [e.createElementVNode("view", {
              class: "disk-head"
            }, [e.createElementVNode("text", {
              class: "disk-title"
            }, e.toDisplayString(t.title), 1), t.notice ? (e.openBlock(), e
              .createElementBlock("text", {
                key: 0,
                class: "disk-notice"
              }, e.toDisplayString(t.notice), 1)) : e.createCommentVNode("", !0)]), (e
              .openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(t
                .items, ((t, a) => (e.openBlock(), e.createElementBlock("view", {
                  key: a,
                  class: e.normalizeClass(["disk-item", "disk-item--" + t
                    .type
                  ]),
                  onClick: e => r(t)
                }, [e.createElementVNode("text", {
                  class: "disk-name"
                }, e.toDisplayString(t.name), 1), t._shareUrl ? (e
                  .openBlock(), e.createElementBlock(e.Fragment, {
                    key: 0
                  }, [e.createElementVNode("text", {
                      class: "disk-url",
                      "user-select": ""
                    }, e.toDisplayString(t._shareUrl), 1), e
                    .createElementVNode("button", {
                      class: "btn-sm",
                      onClick: e.withModifiers((e => i(t._shareUrl)), [
                        "stop"
                      ])
                    }, "复制", 8, ["onClick"])
                  ], 64)) : t.cachedShareUrl ? (e.openBlock(), e
                  .createElementBlock(e.Fragment, {
                    key: 1
                  }, [e.createElementVNode("text", {
                      class: "disk-url",
                      "user-select": ""
                    }, e.toDisplayString(t.cachedShareUrl), 1), e
                    .createElementVNode("button", {
                      class: "btn-sm",
                      onClick: e.withModifiers((e => i(t
                        .cachedShareUrl)), ["stop"])
                    }, "复制", 8, ["onClick"])
                  ], 64)) : t._saving ? (e.openBlock(), e
                  .createElementBlock("text", {
                    key: 2,
                    class: "dim"
                  }, "转存中...")) : (e.openBlock(), e.createElementBlock(
                  "button", {
                    key: 3,
                    class: "btn-sm btn-green"
                  }, "转存获取分享链接"))], 10, ["onClick"])))), 128))])))), 128))])) : e.createCommentVNode("",
            !0), l.value.related && l.value.related.length ? (e.openBlock(), e.createElementBlock(
            "view", {
              key: 1,
              class: "related"
            }, [e.createElementVNode("text", {
              class: "rel-title"
            }, "推荐影片"), e.createElementVNode("view", {
              class: "rel-grid"
            }, [(e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(l.value
              .related, ((t, a) => (e.openBlock(), e.createElementBlock("view", {
                key: a,
                class: "rel-card",
                onClick: e => o(t.detailUrl)
              }, [t.cover ? (e.openBlock(), e.createElementBlock("image", {
                key: 0,
                class: "rel-cover",
                src: t.cover,
                mode: "aspectFill"
              }, null, 8, ["src"])) : (e.openBlock(), e.createElementBlock("view", {
                key: 1,
                class: "rel-cover rel-ph"
              })), e.createElementVNode("text", {
                class: "rel-name"
              }, e.toDisplayString(t.title), 1)], 8, ["onClick"])))), 128))])])) : e.createCommentVNode(
            "", !0)], 64)) : (e.openBlock(), e.createElementBlock("view", {
            key: 2,
            class: "empty"
          }, [e.createElementVNode("text", {
            class: "dim"
          }, "影片信息加载失败")]))]))
        }
      }, [
        ["__scopeId", "data-v-0d0100b9"]
      ]),
      f = i({
        __name: "account",
        setup(t) {
          const a = e.ref(""),
            l = e.ref(null),
            o = e.ref(!1),
            n = e.ref([]),
            c = e.ref(""),
            i = e.ref(""),
            u = e.computed((() => {
              var e;
              const t = null == (e = r.user) ? void 0 : e.membership_expires_at;
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
              l.value = await r.getCardInfo(e)
            } catch {
              l.value = null
            }
            const t = l.value;
            if ((await uni.showModal({
                title: "确认",
                content: t ? `${t.days}天 + ${t.downloads}次${t.is_monthly?"（月卡）":""}` : "确定？"
              })).confirm) {
              o.value = !0;
              try {
                await r.redeem(e), a.value = "", l.value = null, uni.showToast({
                  title: "充值成功",
                  icon: "success"
                }), n.value = await r.loadPools().catch((() => [])), await r.loadMe()
              } catch (s) {
                uni.showToast({
                  title: s.message || "失败",
                  icon: "none"
                })
              } finally {
                o.value = !1
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
            })).confirm && (await r.logout(), uni.reLaunch({
              url: "/pages/login/login"
            }))
          }

          function k() {
            uni.navigateBack()
          }
          return e.onMounted((async () => {
            if (r.token && r.user) {
              r.loadMe().catch((() => {})), n.value = await r.loadPools().catch((() => []));
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
            return e.openBlock(), e.createElementBlock("view", {
              class: "page"
            }, [e.createElementVNode("view", {
              class: "hdr flex-between"
            }, [e.createElementVNode("text", {
              class: "hdr-back",
              onClick: k
            }, "← 返回"), e.createElementVNode("text", {
              class: "hdr-title"
            }, "我的账户"), e.createElementVNode("view", {
              style: {
                width: "80rpx"
              }
            })]), e.createElementVNode("scroll-view", {
              "scroll-y": "",
              class: "body"
            }, [e.createElementVNode("view", {
              class: "card"
            }, [e.createElementVNode("text", {
              class: "card-title"
            }, "账户信息"), e.createElementVNode("view", {
              class: "row"
            }, [e.createElementVNode("text", {
              class: "r-label"
            }, "用户名"), e.createElementVNode("text", {
                class: "r-val"
              }, e.toDisplayString((null == (g = e.unref(r).user) ? void 0 : g.username) || "-"),
              1)]), e.createElementVNode("view", {
              class: "row"
            }, [e.createElementVNode("text", {
              class: "r-label"
            }, "会员到期"), e.createElementVNode("text", {
              class: e.normalizeClass(["r-val", e.unref(r).membershipActive() ? "" : "danger"])
            }, e.toDisplayString(u.value), 3)]), e.createElementVNode("view", {
              class: "row"
            }, [e.createElementVNode("text", {
              class: "r-label"
            }, "剩余下载"), e.createElementVNode("text", {
              class: "r-val"
            }, e.toDisplayString((null == (y = e.unref(r).user) ? void 0 : y
              .downloads_remaining) ?? 0) + " 次", 1)])]), e.createElementVNode("view", {
              class: "card"
            }, [e.createElementVNode("text", {
                class: "card-title"
              }, "卡密充值"), e.createElementVNode("view", {
                class: "field"
              }, [e.withDirectives(e.createElementVNode("input", {
                class: "inp",
                "onUpdate:modelValue": s[0] || (s[0] = e => a.value = e),
                placeholder: "请输入卡密",
                disabled: o.value
              }, null, 8, ["disabled"]), [
                [e.vModelText, a.value]
              ])]), e.createElementVNode("button", {
                class: "btn",
                disabled: o.value || !a.value.trim(),
                onClick: m
              }, "充值", 8, ["disabled"]), l.value ? (e.openBlock(), e.createElementBlock("view", {
                key: 0,
                class: "tip-ok"
              }, " +" + e.toDisplayString(l.value.days) + "天 +" + e.toDisplayString(l.value
                .downloads) + "次" + e.toDisplayString(l.value.is_monthly ? "（月卡）" : ""), 1)) : e
              .createCommentVNode("", !0)
            ]), n.value.length ? (e.openBlock(), e.createElementBlock("view", {
              key: 0,
              class: "card"
            }, [e.createElementVNode("text", {
              class: "card-title"
            }, "已生效卡密"), (e.openBlock(!0), e.createElementBlock(e.Fragment, null, e.renderList(n
              .value, (t => (e.openBlock(), e.createElementBlock("view", {
                key: t.id,
                class: "pool-row"
              }, [e.createElementVNode("view", {
                  class: "flex-between"
                }, [e.createElementVNode("text", {
                  class: "pool-code"
                }, e.toDisplayString(t.code || "卡密"), 1), e.createElementVNode(
                  "text", {
                    class: e.normalizeClass(["pool-st", t.remaining > 0 ? "s-ok" :
                      "s-off"
                    ])
                  }, e.toDisplayString(t.remaining > 0 ? "生效中" : "已用尽"), 3)]), e
                .createElementVNode("view", {
                  class: "pool-det"
                }, [e.createElementVNode("text", {
                    class: "dim"
                  }, "剩余: " + e.toDisplayString(t.remaining) + "次", 1), e
                  .createElementVNode("text", {
                    class: "dim ml-20"
                  }, "到期: " + e.toDisplayString(d(t.expires_at)), 1)
                ])
              ])))), 128))])) : e.createCommentVNode("", !0), c.value ? (e.openBlock(), e
              .createElementBlock("view", {
                key: 1,
                class: "card"
              }, [e.createElementVNode("text", {
                class: "card-title"
              }, "系统公告"), e.createElementVNode("text", {
                class: "dim notice-text"
              }, e.toDisplayString(c.value), 1)])) : e.createCommentVNode("", !0), i.value ? (e
              .openBlock(), e.createElementBlock("view", {
                key: 2,
                class: "card"
              }, [e.createElementVNode("text", {
                class: "card-title"
              }, "月卡购买"), e.createElementVNode("button", {
                class: "btn sec",
                onClick: v
              }, "查看购买链接")])) : e.createCommentVNode("", !0), e.createElementVNode("view", {
              class: "card"
            }, [e.createElementVNode("button", {
              class: "btn sec danger",
              onClick: p
            }, "退出登录")])])])
          }
        }
      }, [
        ["__scopeId", "data-v-dcdc07d2"]
      ]);
    __definePage("pages/login/login", u), __definePage("pages/home/home", d), __definePage("pages/tomato/tomato", g),
      __definePage("pages/duoduosou/duoduosou", y), __definePage("pages/duoduosou/movie", h), __definePage(
        "pages/account/account", f);
    const E = "1.1.0",
      w = i({
        __name: "App",
        setup(t) {
          const l = e.ref(E),
            o = e.ref(""),
            n = e.ref(!1),
            c = e.ref(!1);
          let i = "";

          function u() {
            if (!i) return uni.showToast({
              title: "暂无下载链接",
              icon: "none"
            });
            plus.runtime.openURL(i)
          }
          return a = (e, t) => {
            o.value = e, i = t || i, n.value = !0
          }, p((() => {
            r.restoreSession(), async function() {
              try {
                const e = await s({
                    url: "/api/version"
                  }),
                  t = e.version || "1.0.0";
                o.value = t, i = e.update_url || "",
                  function(e, t) {
                    const a = e.split(".").map(Number),
                      l = t.split(".").map(Number);
                    for (let o = 0; o < Math.max(a.length, l.length); o++) {
                      const e = a[o] || 0,
                        t = l[o] || 0;
                      if (e > t) return 1;
                      if (e < t) return -1
                    }
                    return 0
                  }(t, E) > 0 && (e.force ? n.value = !0 : c.value = !0)
              } catch {}
            }()
          })), (t, a) => (e.openBlock(), e.createElementBlock("view", null, [n.value ? (e.openBlock(), e
            .createElementBlock("view", {
              key: 0,
              class: "update-overlay"
            }, [e.createElementVNode("view", {
              class: "update-dialog"
            }, [e.createElementVNode("text", {
                class: "up-icon"
              }, "📦"), e.createElementVNode("text", {
                class: "up-title"
              }, "发现新版本"), e.createElementVNode("text", {
                class: "up-ver"
              }, "最新: " + e.toDisplayString(o.value) + " | 当前: " + e.toDisplayString(l.value), 1), e
              .createElementVNode("text", {
                class: "up-desc"
              }, "此版本为强制更新，请立即升级"), e.createElementVNode("button", {
                class: "up-btn",
                onClick: u
              }, "立即更新")
            ])])) : e.createCommentVNode("", !0), c.value ? (e.openBlock(), e.createElementBlock("view", {
            key: 1,
            class: "update-banner",
            onClick: u
          }, [e.createElementVNode("text", {
            class: "bn-text"
          }, "新版本 " + e.toDisplayString(o.value) + " 可用，点击下载", 1), e.createElementVNode("text", {
            class: "bn-close",
            onClick: a[0] || (a[0] = e.withModifiers((e => c.value = !1), ["stop"]))
          }, "✕")])) : e.createCommentVNode("", !0), e.renderSlot(t.$slots, "default", {}, void 0, !0)]))
        }
      }, [
        ["__scopeId", "data-v-fa72a6fc"]
      ]);
    const {
      app: N,
      Vuex: V,
      Pinia: b
    } = {
      app: e.createVueApp(w)
    };
    uni.Vuex = V, uni.Pinia = b, N.provide("__globalStyles", __uniConfig.styles), N._component.mpType = "app", N
      ._component.render = () => {}, N.mount("#app")
  }(Vue);