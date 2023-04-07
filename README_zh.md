# meta-exynos

[English][EN],
**简体中文**

[EN]:README.md
[ZH_CN]:README_zh.md

## 简介

此README文件包含有关 meta-fcitx5 层内容的信息.

有关详细信息，请参阅以下相应部分.

## 依赖

[YOCTO]

- URI: https://git.yoctoproject.org/poky

- branch: 与 meta-fcitx5 分支一样

[META-QT5]

- URI: https://github.com/meta-qt5/meta-qt5.git

- branch: 与 meta-fcitx5 分支一样

[META-OPENEMBEDDED]

- URI: https://github.com/openembedded/meta-openembedded.git

- branch: 与 meta-fcitx5 分支一样


## 快速开始

```shell
$> git clone -b kirkstone https://git.yoctoproject.org/poky
$> cd poky
$> git clone -b kirkstone git://github.com/openembedded/meta-openembedded.git
$> git clone -b kirkstone git://github.com/hyyoxhk/meta-fcitx5.git
$>
$> source oe-init-build-env
...
$ bitbake-layers add-layer ../meta-openembedded/meta-oe
$ bitbake-layers add-layer ../meta-fcitx5
```

## 示例

我们以 machine 是 `stm32mp15-disco` 为例, 在 local.conf 中添加:

```bitbake
INHERIT += " fcitx5-distro-defaults"
IMAGE_INSTALL += " fcitx5 fcitx5-chinese-addons"
```

## 贡献

如果您有提交的修正, 请在本仓库上提 pull requests, 地址是 https://github.com/hyyoxhk/meta-fcits5/pulls
