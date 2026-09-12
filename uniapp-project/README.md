# 番茄系统 · uni-app 还原工程

由 `decompiled/uniapp-www/__UNI__34AA080/www/app-service.js` 自动还原的 Vue 3 单文件组件工程。

## 用法

1. HBuilderX → 新建 uni-app 项目（Vue 3）
2. 用本目录覆盖新项目的根目录（`pages/`、`App.vue`、`main.js`、`pages.json`、`manifest.json`、`api/`）
3. 运行到手机或模拟器

## 目录

```
api/index.js    网络请求 + 账户 store（request = 原 s，auth = 原 r）
App.vue         应用入口组件
pages/          6 个页面（.vue 模板 + 逻辑 + 样式）
*.render.txt    该页面还原前的原始渲染函数（对照用）
```

## 已知限制

- 模板由渲染函数自动还原，个别节点可能还原失败，会保留为 `<!-- TODO -->`；请对照同目录下的 `*.render.txt` 手工补全。
- 变量名沿用反编译结果（如 `a`、`l`、`o`），未做语义化重命名。
- 打包成 APK 仍需 HBuilderX 云打包或离线打包；原生壳层请见仓库 `decompiled/` 目录。
