# 番茄系统 Android 反编译源码

由 `番茄系统_1.1.0.apk` 反编译得到的可二次开发工程。原应用是 **uni-app（DCloud）+ Vue 3** 混合应用，因此本仓库同时保留了 **Java 原生壳层**、**smali/资源（可回编译）** 与 **uni-app 业务 JS 层** 三个部分。

## 应用信息

| 项目 | 值 |
| --- | --- |
| 应用名 | 番茄系统 |
| 描述 | 多平台内容搜索与下载 |
| 包名 | `uni.app.UNI34AA080` |
| 版本 | 1.1.0（versionCode 2） |
| 框架 | uni-app（DCloud） + Vue 3，编译器版本 5.15 |
| Application | `io.dcloud.application.DCloudApplication` |
| 入口 Activity | `io.dcloud.PandoraEntry` / `io.dcloud.PandoraEntryActivity` |
| minSdk / targetSdk | 21 / 27（compileSdk 36） |
| WebView 内核 | Weex + uni-app 运行时 |
| 后端接口 | `http://47.116.57.181:3001` |
| 登录态 | `uni.getStorageSync("auth_token")`，`Authorization: Bearer <token>` |

### 页面路由

| 路径 | 标题 | 说明 |
| --- | --- | --- |
| `pages/login/login` | 番茄系统 | 入口页 |
| `pages/home/home` | 番茄系统 | 首页 |
| `pages/tomato/tomato` | 番茄小说 | 小说搜索 |
| `pages/duoduosou/duoduosou` | 多多盘 | 网盘搜索 |
| `pages/duoduosou/movie` | 影片详情 | 详情页 |
| `pages/account/account` | 我的账户 | 账户页 |

## 目录结构

```
.
├── original/                       # 原始 APK（便于对照）
├── decompiled/
│   ├── apktool/                    # ① 可回编译工程
│   │   ├── AndroidManifest.xml     #    解码后的清单文件
│   │   ├── apktool.yml             #    apktool 工程元数据（回编译必需）
│   │   ├── res/                    #    解码后的资源
│   │   ├── smali/                  #    classes.dex 的 smali 代码
│   │   └── smali_classes2/         #    classes2.dex 的 smali 代码
│   ├── java/                       # ② jadx 导出的 Gradle Android 工程
│   │   ├── build.gradle / settings.gradle
│   │   └── app/src/main/java/      #    可读 Java 源码（约 5400 个类）
│   └── uniapp-www/                 # ③ uni-app 业务层（真正的业务逻辑）
│       └── __UNI__34AA080/www/
│           ├── app-service.js      #    全部页面的 Vue 组件逻辑（已格式化）
│           ├── app-config-service.js
│           ├── manifest.json
│           ├── app.css + pages/*/*.css
│           └── __uniapp*.js        #    uni-app 运行时辅助模块
└── docs/二次开发指南.md
```

## 三条二次开发路线（按推荐度排序）

### 路线 A：改业务界面/接口（推荐，成本最低）

真正的业务逻辑在 `decompiled/uniapp-www/__UNI__34AA080/www/`。

1. 在 HBuilderX 中新建 uni-app（Vue 3）空项目。
2. 用 `app-service.js` 里的页面组件还原 `pages/` 下的 `.vue` 文件；样式直接取对应的 `.css`。
3. 改完后用 HBuilderX 云打包 / 离线打包生成新 APK。

> `app-service.js` 是编译压缩产物，变量名被缩短但**未做混淆**，逻辑可读；`__uniappview.html`、`uni-app-view.umd.js` 是运行时，不要改。

### 路线 B：改原生层（权限、SDK、Manifest）

用 `decompiled/java/` 下的 Gradle 工程：

1. Android Studio 打开 `decompiled/java/` 目录。
2. 该工程由 jadx 生成，`dependencies` 为空，需要按报错逐个补回依赖（主要是 `io.dcloud` SDK、androidx、fresco/okhttp/kotlin 协程等）。
3. 编译通过后即可改原生代码。

> 这条路线工作量最大，适合要接新 SDK 或改启动流程的场景。

### 路线 C：直接改 smali 后回编译（最快见效）

改 Manifest、改字符串、改小段逻辑：

```bash
# 回编译（在 decompiled/apktool 的父目录执行）
java -jar apktool.jar b decompiled/apktool -o dist/番茄系统_mod.apk

# 生成签名（仅首次）
keytool -genkeypair -v -keystore my.keystore -alias fanqie -keyalg RSA -keysize 2048 -validity 10950

# 对齐 + 签名
zipalign -p -f -v 4 dist/番茄系统_mod.apk dist/aligned.apk
apksigner sign --ks my.keystore --ks-key-alias fanqie --out dist/番茄系统_signed.apk dist/aligned.apk
```

## 注意事项

- 反编译产物**不能 100% 还原原始源码**：注释、原始变量名、Gradle 依赖、签名信息均已丢失。
- jadx 报告 **93 个类**反编译失败，遇到这些类请回退看 `decompiled/apktool/smali*/` 下的 smali。
- APK 内含 `assets/39285EFA.dex` 与 `lib/*/lib39285EFA.so`（常见加固壳特征），改 smali 回编译前**先移除加固相关壳代码**，否则可能无法启动。
- 原 APK 的签名已失效，回编译后必须重新签名才能安装。

## 免责声明

本项目仅用于学习与技术交流。反编译产物的版权归原作者所有，请勿用于商业分发或侵犯他人权益的场景。
