# -*- coding: utf-8 -*-
"""
把 uni-app 编译产物 app-service.js 还原成可导入 HBuilderX 的 Vue3 工程。
"""
import re, os, json, sys

WWW = r"D:\新建文件夹 (4)\fanqie-system\decompiled\uniapp-www\__UNI__34AA080\www"
OUT = r"D:\新建文件夹 (4)\fanqie-system\uniapp-project"

src = open(os.path.join(WWW, "app-service.js"), encoding="utf-8").read()

# ---------------------------------------------------------------- 基础工具
def find_balanced(s, i):
    """s[i] 必须是 ( [ 或 { ，返回 (内部文本, 结束下标)"""
    pairs = {"(": ")", "[": "]", "{": "}"}
    open_ch = s[i]
    stack = [open_ch]
    j = i + 1
    in_str = None
    while j < len(s):
        c = s[j]
        if in_str:
            if c == "\\":
                j += 2
                continue
            if c == in_str:
                in_str = None
        elif c in "\"'`":
            in_str = c
        elif c in pairs:
            stack.append(c)
        elif c in ")]}":
            if not stack:
                raise ValueError("unexpected close at %d" % j)
            if pairs[stack.pop()] != c:
                raise ValueError("mismatch close at %d" % j)
            if not stack:
                return s[i + 1:j], j
        j += 1
    raise ValueError("unbalanced at %d" % i)


def split_args(s):
    """按顶层逗号切分"""
    out, depth, cur = [], 0, ""
    in_str = None
    i = 0
    while i < len(s):
        c = s[i]
        if in_str:
            cur += c
            if c == "\\":
                cur += s[i + 1]
                i += 2
                continue
            if c == in_str:
                in_str = None
        elif c in "\"'`":
            in_str = c
            cur += c
        elif c in "([{":
            depth += 1
            cur += c
        elif c in ")]}":
            depth -= 1
            cur += c
        elif c == "," and depth == 0:
            out.append(cur.strip())
            cur = ""
        else:
            cur += c
        i += 1
    if cur.strip():
        out.append(cur.strip())
    return out


def unparen(s):
    s = s.strip()
    while s.startswith("(") and s.endswith(")"):
        inner, end = find_balanced(s, 0)
        if end != len(s) - 1:
            break
        parts = split_args(inner)
        if len(parts) > 1:
            # 逗号序列：只对 (openBlock(), NODE) 这种外壳脱壳
            if len(parts) == 2 and re.match(
                    r"^e?\s*\.?\s*openBlock\(\s*(?:true|!0|false|!1)?\s*\)$", parts[0].strip()):
                s = parts[1].strip()
            else:
                break
        else:
            s = inner.strip()
    return s


# ---------------------------------------------------------------- 表达式清洗
VUE_HELPERS = {
    "ref", "reactive", "computed", "watch", "onMounted", "onShow", "onLoad",
    "onUnmounted", "nextTick", "unref", "toRaw", "watchEffect", "onReachBottom",
    "onPullDownRefresh", "onHide", "onReady", "defineProps", "shallowRef",
}

def clean_expr(x):
    x = x.strip()
    x = re.sub(r"\s+", " ", x)
    x = x.replace("!0", "true").replace("!1", "false")
    x = re.sub(r"\be\.(%s)\b" % "|".join(sorted(VUE_HELPERS)), r"\1", x)
    x = re.sub(r"\be\s*\.\s*", "", x)           # 其余 e.xxx（渲染期辅助）在模板里无意义
    x = re.sub(r"\.value\b", "", x)             # 模板中 ref 自动解包
    x = re.sub(r"\bunref\(r\)", "auth", x)      # 共享 store
    x = re.sub(r"(?<![\w$])r\.(?!\d)", "auth.", x)
    return x.strip()


ARROW_CACHE = re.compile(r"^\w+\[\d+\]\s*\|\|\s*\(\s*\w+\[\d+\]\s*=\s*(.*)\)$", re.S)

def clean_handler(v):
    v = v.strip()
    m = ARROW_CACHE.match(v)
    if m:
        v = m.group(1)
    # 去掉箭头参数
    m = re.match(r"^\(?\s*\w+\s*\)?\s*=>\s*(.*)$", v, re.S)
    if m:
        v = m.group(1)
    v = v.strip()
    if v.startswith("{") and v.endswith("}"):
        # 多行箭头函数体：找 return，用 read_expr 读到语句结束（跳过后面的 var 声明）
        m = re.search(r"return\s+", v, re.S)
        if m:
            v = read_expr(v, m.end()).strip()
    v = v.rstrip(";")
    v = re.sub(r"\bvoid\s*(?=[\w$(])", "", v)
    while v.endswith(")") and v.count(")") > v.count("("):
        v = v[:-1].rstrip()
    return clean_expr(v)


def parse_object(s):
    """解析对象字面量 -> [(key, value)]，只处理顶层"""
    s = s.strip()
    if not s.startswith("{") or not s.endswith("}"):
        return None
    inner, end = find_balanced(s, 0)
    if end != len(s) - 1:
        return None
    res = []
    for part in split_args(inner):
        if not part:
            continue
        m = re.match(r"^(\"[^\"]*\"|'[^']*'|[A-Za-z_$][\w$]*)\s*:\s*(.*)$", part, re.S)
        if m:
            k = m.group(1).strip("\"'")
            res.append((k, m.group(2).strip()))
    return res


# ---------------------------------------------------------------- 模板还原
def norm_class(v):
    v = v.strip()
    m = re.match(r"^e\.normalizeClass\((.*)\)$", v, re.S)
    if m:
        return ":class", clean_expr(m.group(1))
    if v.startswith("\"") or v.startswith("'"):
        return "class", v.strip("\"'")
    return ":class", clean_expr(v)


def esc(v):
    """属性值里不能出现双引号"""
    return v.replace('"', "'")


def props_to_attrs(props_src):
    """-> 属性字符串"""
    if not props_src or props_src == "null":
        return ""
    obj = parse_object(props_src)
    if obj is None:
        return ""
    attrs = []
    has_model = False
    for k, v in obj:
        if k == "key":
            continue
        if k == "class":
            ak, av = norm_class(v)
            attrs.append('%s="%s"' % (ak, esc(av)))
        elif k.startswith("on"):
            if k == "onUpdate:modelValue":
                continue                      # 由 v-model 指令统一处理
            ev = k[2:].lower()
            mods = ""
            _c = ARROW_CACHE.match(v.strip())
            if _c:
                v = _c.group(1)
            wm = re.match(r"^(?:e\s*\.\s*)?withModifiers\(([\s\S]*)\)$", v)
            if wm:
                parts = split_args(wm.group(1))
                v = parts[0]
                if len(parts) > 1:
                    mods = "".join(
                        "." + x for x in re.findall(r"['\"]([^'\"]+)['\"]", parts[1])
                    )
            attrs.append('@%s%s="%s"' % (ev, mods, esc(clean_handler(v))))
        else:
            if v.startswith("\"") or v.startswith("'"):
                attrs.append('%s="%s"' % (k, esc(v.strip("\"'"))))
            elif v in ("true", "false"):
                attrs.append(':%s="%s"' % (k, v))
            else:
                attrs.append(':%s="%s"' % (k, esc(clean_expr(v))))
    return (" " + " ".join(attrs)) if attrs else ""



def read_expr(s, i):
    """从 i 开始读一个表达式，遇到 depth0 的 ';' 或 '}' 结束"""
    depth = 0
    in_str = None
    j = i
    while j < len(s):
        c = s[j]
        if in_str:
            if c == "\\":
                j += 2
                continue
            if c == in_str:
                in_str = None
        elif c in "\"'`":
            in_str = c
        elif c in "([{":
            depth += 1
        elif c in ")]}":
            if depth == 0:
                return s[i:j]
            depth -= 1
        elif c == ";" and depth == 0:
            return s[i:j]
        j += 1
    return s[i:j]


def split_top_plus(s):
    out, depth, cur = [], 0, ""
    in_str = None
    i = 0
    while i < len(s):
        c = s[i]
        if in_str:
            cur += c
            if c == "\\":
                cur += s[i + 1]
                i += 2
                continue
            if c == in_str:
                in_str = None
        elif c in "\"'`":
            in_str = c
            cur += c
        elif c in "([{":
            depth += 1
            cur += c
        elif c in ")]}":
            depth -= 1
            cur += c
        elif c == "+" and depth == 0:
            out.append(cur)
            cur = ""
        else:
            cur += c
        i += 1
    out.append(cur)
    return out


def convert_text_expr(node):
    parts = []
    for t in split_top_plus(node):
        t = t.strip()
        if not t:
            continue
        if t.startswith("\"") or t.startswith("'"):
            parts.append(t.strip("\"'"))
        else:
            m = re.match(r"^e\.toDisplayString\((.*)\)$", t, re.S)
            inner = m.group(1) if m else t
            parts.append("{{ %s }}" % clean_expr(inner))
    return "".join(parts)


def convert_node(node, indent=0, extra_attrs=None):
    """返回模板行列表"""
    pad = "  " * indent
    node = node.strip()
    node = re.sub(r"(?<![\w$.])e\s*\.\s*", "e.", node)   # 美化后可能出现 "e\n .xxx"
    node = unparen(node)

    # 逗号序列：取最后一项（openBlock(), NODE）
    parts = split_args(node)
    if len(parts) > 1:
        node = parts[-1]

    # v-if / v-else
    m = find_top_ternary(node)
    if m:
        cond, a, b = m
        out = []
        if is_comment(b):
            out += convert_node(a, indent, ['v-if="%s"' % esc(clean_expr(cond))])
        elif is_comment(a):
            out += convert_node(b, indent, ['v-if="!(%s)"' % esc(clean_expr(cond))])
        else:
            out += convert_node(a, indent, ['v-if="%s"' % esc(clean_expr(cond))])
            out += convert_node(b, indent, ['v-else'])
        return out

    if is_comment(node):
        return []

    # v-for
    m = re.match(r"^e\.renderList\((.*)\)\s*$", node, re.S)
    if m:
        args = split_args(m.group(1))
        listexpr = clean_expr(args[0])
        fn = args[-1].strip()
        while fn.startswith("(") and fn.endswith(")"):
            try:
                inner, e2 = find_balanced(fn, 0)
            except ValueError:
                break
            if e2 != len(fn) - 1:
                break
            fn = inner.strip()
        fm = re.match(r"^\(?\s*(\w+)\s*(?:,\s*(\w+))?\s*\)?\s*=>\s*(.*)$", fn, re.S)
        if fm:
            item, idx, body = fm.group(1), fm.group(2), fm.group(3).strip()
            # 块体箭头：{ var x; return NODE }
            if body.startswith("{") and body.endswith("}"):
                bm = re.search(r"return\s+", body)
                if bm:
                    body = read_expr(body, bm.end())
            loop = "(%s%s) in %s" % (item, (", %s" % idx) if idx else "", listexpr)
            return convert_node(body, indent, ['v-for="%s"' % esc(loop), ':key="%s"' % item])

    # v-model
    m = re.match(r"^e\.withDirectives\((.*)\)\s*$", node, re.S)
    if m:
        args = split_args(m.group(1))
        innernode = args[0]
        vmodel = None
        if len(args) > 1:
            d = args[1]
            dm = re.search(r"\[\s*e\.vModelText\s*,\s*([^\]]+?)\s*(?:,\s*void 0)?\s*\]", d)
            if dm:
                vmodel = clean_expr(dm.group(1))
        extra = list(extra_attrs or [])
        if vmodel:
            extra.append('v-model="%s"' % esc(vmodel))
        return convert_node(innernode, indent, extra)

    # Fragment
    m = re.match(r"^e\.create(?:Element)?Block\(\s*e\.Fragment\s*,(.*)\)\s*$", node, re.S)
    if m:
        # 注意：正则已吃掉 Fragment 参数，故下标比普通元素少 1
        args = split_args(m.group(1))
        children_src = args[1] if len(args) > 1 else None
        return convert_children(children_src, indent, extra_attrs)

    # openBlock(true), createElementBlock(Fragment, ...) 这类包裹
    if re.match(r"^e\.openBlock\(\s*(?:true|!0)\s*\)\s*,\s*(.*)$", node, re.S):
        node = node.split(",", 1)[1].strip()

    # 普通元素
    m = re.match(r"^e\.createElement(?:Block|VNode)\((.*)\)\s*$", node, re.S)
    if m:
        args = split_args(m.group(1))
        tag = args[0].strip("\"'")
        props = args[1] if len(args) > 1 else "null"
        children = args[2] if len(args) > 2 else None
        attrs = props_to_attrs(props)
        extra = "".join(" " + a for a in (extra_attrs or []))
        head = "%s<%s%s%s" % (pad, tag, attrs, extra)
        kids = convert_children(children, indent + 1)
        if not kids:
            return ["%s />" % head]
        if len(kids) == 1 and not kids[0].strip().startswith("<") and len(kids[0].strip()) <= 60:
            return ["%s>%s</%s>" % (head, kids[0].strip(), tag)]
        return [head + ">"] + kids + ["%s</%s>" % (pad, tag)]

    # 顶层 "+" 拼接优先于 toDisplayString，否则 "a" + toDisplayString(x) 会被整吞
    if len(split_top_plus(node)) > 1:
        return ["%s%s" % (pad, convert_text_expr(node))]

    # 文本 / 插值
    m = re.match(r"^e\.toDisplayString\((.*)\)\s*$", node, re.S)
    if m:
        return ["%s{{ %s }}" % (pad, clean_expr(m.group(1)))]

    m = re.match(r"^e\.createTextVNode\((.*)\)\s*$", node, re.S)
    if m:
        txt = m.group(1).strip()
        # 末尾可能是 patchFlag（如 createTextVNode(x, 1)）
        targs = split_args(txt)
        if len(targs) > 1 and re.match(r"^\d+$", targs[-1].strip()):
            txt = ", ".join(targs[:-1]).strip()
        if txt.startswith("\"") or txt.startswith("'"):
            return ["%s%s" % (pad, txt.strip("\"'"))]
        if len(split_top_plus(txt)) > 1:
            return ["%s%s" % (pad, convert_text_expr(txt))]
        return ["%s{{ %s }}" % (pad, clean_expr(txt))]

    if re.match(r"^\"[^\"]*\"$", node) or re.match(r"^'[^']*'$", node):
        return ["%s%s" % (pad, node[1:-1])]

    if node.startswith("e.renderSlot("):
        return ["%s<slot />" % pad]

    # 兜底
    return ["%s<!-- TODO: %s -->" % (pad, clean_expr(node)[:100])]


def is_comment(node):
    return bool(re.match(r"^e\.createCommentVNode\(", node.strip()))


def find_top_ternary(s):
    depth = 0
    in_str = None
    i = 0
    while i < len(s):
        c = s[i]
        if in_str:
            if c == "\\":
                i += 2
                continue
            if c == in_str:
                in_str = None
        elif c in "\"'`":
            in_str = c
        elif c in "([{":
            depth += 1
        elif c in ")]}":
            depth -= 1
        elif c == "?" and depth == 0:
            # 找配对的 :（三元右结合：a ? b ? c : d : e  =>  a ? (b ? c : d) : e）
            d2, j, pending = depth, i + 1, 1
            s2 = None
            while j < len(s):
                c2 = s[j]
                if s2:
                    if c2 == "\\":
                        j += 2
                        continue
                    if c2 == s2:
                        s2 = None
                elif c2 in "\"'`":
                    s2 = c2
                elif c2 in "([{":
                    d2 += 1
                elif c2 in ")]}":
                    d2 -= 1
                elif d2 == 0 and c2 == "?" and s[j - 1:j] != ".":
                    pending += 1
                elif d2 == 0 and c2 == ":":
                    pending -= 1
                    if pending == 0:
                        return s[:i], s[i + 1:j], s[j + 1:]
                j += 1
        i += 1
    return None


def convert_children(children, indent, extra_attrs=None):
    if not children or children.strip() in ("null", "[]"):
        return []
    children = children.strip()
    if children.startswith("["):
        inner, end = find_balanced(children, 0)
        if end == len(children) - 1:
            items = split_args(inner)
        else:
            items = [children]
    else:
        items = [children]
    out = []
    for it in items:
        it = it.strip()
        if not it or it == "null":
            continue
        out += convert_node(it, indent)
    return out


# ---------------------------------------------------------------- 拆分组件
NAME_RE = re.compile(r'__name\s*:\s*"([^"]+)"')
names = [(m.group(1), m.start()) for m in NAME_RE.finditer(src)]
print("组件:", [n for n, _ in names])

components = {}
for idx, (name, pos) in enumerate(names):
    end = names[idx + 1][1] if idx + 1 < len(names) else len(src)
    chunk = src[pos:end]
    render_arrow = None
    for am in re.finditer(r"\(\s*\w+\s*,\s*\w+\s*\)\s*=>", chunk):
        if "openBlock" in chunk[am.end():am.end() + 600]:
            render_arrow = am
            break
    if render_arrow is None:
        print("  !! 未找到 render:", name)
        continue
    i = render_arrow.end()
    while i < len(chunk) and chunk[i] in " \n\t":
        i += 1
    if chunk[i] == "(":
        render_src, _ = find_balanced(chunk, i)
        ret = chunk.rfind("return", 0, render_arrow.start())
    else:
        # 块体箭头 / 无外层括号：找到 return 之后的位置
        ri = chunk.find("return", i)
        if ri < 0 or ri > i + 60:
            print("  !! 渲染函数解析失败:", name)
            continue
        j = ri + len("return")
        while j < len(chunk) and chunk[j] in " \n\t":
            j += 1
        if chunk[j] == "(":
            render_src, _ = find_balanced(chunk, j)
        else:
            render_src = read_expr(chunk, j)
        ret = ri
    sm = re.search(r"setup\s*\([^)]*\)\s*\{", chunk)
    setup_body = chunk[sm.end():ret] if sm else ""
    components[name] = {"setup": setup_body.strip(), "render": render_src}
    print("  %-10s setup=%d render=%d" % (name, len(setup_body), len(render_src)))

# ---------------------------------------------------------------- 共享 API 层
first = names[0][1]
preamble = src[:first]
start = preamble.find("const t = \"http")
if start < 0:
    start = preamble.find("const t =")
cut = preamble.find("i = (e, t) => {")
if cut < 0:
    cut = preamble.rfind("})\n") + 2
api_src = preamble[start:cut].strip().rstrip(",")
api_src = api_src.replace("e.reactive(", "reactive(")

os.makedirs(OUT, exist_ok=True)
os.makedirs(os.path.join(OUT, "api"), exist_ok=True)

api_js = """// 从 app-service.js 还原的网络请求层 + 账户状态 store
// 变量名沿用反编译结果：request = 原 s，auth = 原 r
import { reactive } from 'vue'

""" + api_src + """

export { s as request, r as auth }
"""
open(os.path.join(OUT, "api", "index.js"), "w", encoding="utf-8").write(api_js)

# ---------------------------------------------------------------- 生成页面
PAGES = ["login", "home", "tomato", "duoduosou", "movie", "account"]
PAGE_DIR = {"login": "pages/login", "home": "pages/home", "tomato": "pages/tomato",
            "duoduosou": "pages/duoduosou", "movie": "pages/duoduosou",
            "account": "pages/account"}

def setup_to_script(body):
    body = re.sub(r"\be\.(%s)\b" % "|".join(sorted(VUE_HELPERS)), r"\1", body)
    body = re.sub(r"(?<![\w$.])r\.", "auth.", body)
    # 压缩后的布尔常量还原（避免 !0 顶到行首被当成指令）
    body = re.sub(r"(?<![\w$!])=(!0|!1)\b", lambda m: "=true" if m.group(1) == "!0" else "=false", body)
    body = re.sub(r"(!0|!1)\b", lambda m: "true" if m.group(1) == "!0" else "false", body)
    used = sorted(set(re.findall(r"\b(%s)\b" % "|".join(sorted(VUE_HELPERS)), body)))
    imports = "import { %s } from 'vue'\nimport { auth } from '@/api'\n" % ", ".join(used) if used else "import { auth } from '@/api'\n"
    return imports + "\n" + body.strip()


def css_for(name):
    p = os.path.join(WWW, "pages", PAGE_DIR[name], "%s.css" % name)
    if os.path.exists(p):
        return open(p, encoding="utf-8").read()
    return ""


for name in PAGES:
    if name not in components:
        print("  跳过", name)
        continue
    c = components[name]
    try:
        body_lines = convert_children(c["render"], 1)
    except Exception as e:
        print("  render 失败", name, e)
        body_lines = ["  <!-- 还原失败，请参考 decompiled/uniapp-www 中的原始 app-service.js -->"]
    tpl = "\n".join(convert_node(c["render"], 1))
    css = css_for(name)
    os.makedirs(os.path.join(OUT, PAGE_DIR[name]), exist_ok=True)
    vue = "<template>\n%s\n</template>\n\n<script setup>\n%s\n</script>\n" % (tpl, setup_to_script(c["setup"]))
    if css.strip():
        vue += "\n<style scoped>\n%s\n</style>\n" % css
    open(os.path.join(OUT, PAGE_DIR[name], "%s.vue" % name), "w", encoding="utf-8").write(vue)
    open(os.path.join(OUT, PAGE_DIR[name], "%s.render.txt" % name), "w", encoding="utf-8").write(
        "// %s.vue 的原始渲染函数（还原前的编译产物，模板若有 <!-- TODO --> 请对照这里手工补全）\n\n%s\n"
        % (name, c["render"]))
    print("  生成", PAGE_DIR[name] + "/" + name + ".vue", len(tpl))

# App.vue
if "App" in components:
    try:
        tpl = "\n".join(convert_node(components["App"]["render"], 1))
    except Exception as e:
        tpl = "  <view />\n  <!-- %s -->" % e
    appcss = open(os.path.join(WWW, "app.css"), encoding="utf-8").read()
    open(os.path.join(OUT, "App.vue"), "w", encoding="utf-8").write(
        "<template>\n%s\n</template>\n\n<script setup>\n%s\n</script>\n\n<style>\n%s\n</style>\n"
        % (tpl, setup_to_script(components["App"]["setup"]), appcss))

# ---------------------------------------------------------------- 工程文件
cfg = open(os.path.join(WWW, "app-config-service.js"), encoding="utf-8").read()
ri = cfg.find("__uniRoutes")
cfg_routes = cfg[ri:] if ri >= 0 else cfg
routes = re.findall(
    r'"path"\s*:\s*"([^"]+)"[\s\S]*?"titleText"\s*:\s*"([^"]*)"[\s\S]*?"style"\s*:\s*"([^"]*)"',
    cfg_routes)
if not routes:
    routes = [(p, t, "custom") for p, t in
              re.findall(r'"path"\s*:\s*"([^"]+)"[\s\S]*?"titleText"\s*:\s*"([^"]*)"', cfg_routes)]
entry = re.search(r'"entryPagePath"\s*:\s*"([^"]+)"', cfg)
entry_path = entry.group(1) if entry else "pages/login/login"
pages_json = {
    "pages": [],
    "globalStyle": {
        "navigationBarTextStyle": "white",
        "navigationBarTitleText": "番茄系统",
        "navigationBarBackgroundColor": "#FF5A5F",
        "backgroundColor": "#F5F5F5",
    },
}
ordered = [r for r in routes if r[0] == entry_path]
ordered += [r for r in routes if r[0] != entry_path]
for r in ordered:
    path, title = r[0], r[1]
    style = r[2] if len(r) > 2 and r[2] else "custom"
    pages_json["pages"].append({
        "path": path,
        "style": {"navigationBarTitleText": title, "navigationStyle": style},
    })
open(os.path.join(OUT, "pages.json"), "w", encoding="utf-8").write(
    json.dumps(pages_json, ensure_ascii=False, indent=2))

import shutil
shutil.copy(os.path.join(WWW, "manifest.json"), os.path.join(OUT, "manifest.json"))

open(os.path.join(OUT, "main.js"), "w", encoding="utf-8").write(
    "// uni-app Vue3 入口（标准模板）\nimport { createSSRApp } from 'vue'\nimport App from './App.vue'\n\n"
    "export function createApp() {\n  const app = createSSRApp(App)\n  return { app }\n}\n")

open(os.path.join(OUT, "README.md"), "w", encoding="utf-8").write(
    "# 番茄系统 · uni-app 还原工程\n\n"
    "由 `decompiled/uniapp-www/__UNI__34AA080/www/app-service.js` 自动还原的 Vue 3 单文件组件工程。\n\n"
    "## 用法\n\n"
    "1. HBuilderX → 新建 uni-app 项目（Vue 3）\n"
    "2. 用本目录覆盖新项目的根目录（`pages/`、`App.vue`、`main.js`、`pages.json`、`manifest.json`、`api/`）\n"
    "3. 运行到手机或模拟器\n\n"
    "## 目录\n\n"
    "```\n"
    "api/index.js    网络请求 + 账户 store（request = 原 s，auth = 原 r）\n"
    "App.vue         应用入口组件\n"
    "pages/          6 个页面（.vue 模板 + 逻辑 + 样式）\n"
    "*.render.txt    该页面还原前的原始渲染函数（对照用）\n"
    "```\n\n"
    "## 已知限制\n\n"
    "- 模板由渲染函数自动还原，个别节点可能还原失败，会保留为 `<!-- TODO -->`；"
    "请对照同目录下的 `*.render.txt` 手工补全。\n"
    "- 变量名沿用反编译结果（如 `a`、`l`、`o`），未做语义化重命名。\n"
    "- 打包成 APK 仍需 HBuilderX 云打包或离线打包；原生壳层请见仓库 `decompiled/` 目录。\n")

print("完成 ->", OUT)
