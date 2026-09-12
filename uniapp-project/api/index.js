// 从 app-service.js 还原的网络请求层 + 账户状态 store
// 变量名沿用反编译结果：request = 原 s，auth = 原 r
import { reactive } from 'vue'

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
    const r = reactive({
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
      })

export { s as request, r as auth }
