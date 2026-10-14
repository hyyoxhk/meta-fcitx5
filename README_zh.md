# meta-fcitx5 — Yocto/OpenEmbedded 的 Fcitx 5 输入法 Layer

[English](README.md) | **简体中文**

meta-fcitx5 为使用 Yocto Project 和 OpenEmbedded 构建的嵌入式 Linux 镜像提供
Fcitx 5 输入法框架及中文输入扩展的 BitBake recipes。包含 Qt 5 输入法集成、
图形配置工具，以及中文输入和简繁转换所需的库。

## 兼容范围与依赖

当前 `scarthgap` 分支在 [conf/layer.conf](conf/layer.conf) 中声明兼容 Yocto
scarthgap。该声明不代表特定板卡的测试报告。以下依赖应使用对应的 `scarthgap` 分支：

| 仓库 | 需要添加的 Layer | 用途 |
| --- | --- | --- |
| [Poky](https://git.yoctoproject.org/poky) | 默认 Poky 构建配置已添加 | Yocto 构建环境与核心元数据 |
| [meta-openembedded](https://github.com/openembedded/meta-openembedded) | `meta-oe` | 附加 recipe 依赖 |
| [meta-qt5](https://github.com/meta-qt5/meta-qt5) | `meta-qt5` | Qt 5 recipes 与构建类 |

Fcitx 5 目标端 recipe 要求 `DISTRO_FEATURES` 包含 `x11` 或 `wayland`。
其他 Yocto 版本或具体板卡的支持情况需要单独验证。使用实体板卡时，请添加相应的
BSP Layer，并采用该 BSP 提供的 machine 配置。

## 包含的组件

| Recipe | 版本 | 用途 |
| --- | --- | --- |
| `fcitx5` | 5.0.17 | 输入法框架 |
| `fcitx5-chinese-addons` | 5.0.17 | 中文输入扩展，包括拼音 |
| `fcitx5-qt` | 5.1.5 | Qt 集成与输入法模块，默认启用 Qt 5 |
| `fcitx5-configtool` | 5.0.17 | Qt 图形配置工具 |
| `libime` | 1.0.17 | 输入法实现所需的库 |
| `opencc` | 1.1.6 | 简体与繁体中文转换 |
| `xcb-imdkit` | 1.0.5 | X11 输入法协议支持 |

本 Layer 还包含 KDE 构建依赖和交叉编译所需的 native recipes。
完整列表见 [recipes-support](recipes-support)。

## 快速开始

先准备满足 Yocto scarthgap 构建要求的主机环境，然后执行：

```sh
git clone -b scarthgap https://git.yoctoproject.org/poky
cd poky
git clone -b scarthgap https://github.com/openembedded/meta-openembedded.git
git clone -b scarthgap https://github.com/meta-qt5/meta-qt5.git
git clone -b scarthgap https://github.com/hyyoxhk/meta-fcitx5.git
source oe-init-build-env
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-qt5
bitbake-layers add-layer ../meta-fcitx5
```

### 配置并构建 Weston 镜像

以下使用不依赖外部板卡 BSP 的 QEMU 示例。在 `build/conf/local.conf`
（如果当前已在 build 目录内，则为 `conf/local.conf`）中添加：

```bitbake
MACHINE = "qemux86-64"
INHERIT += " fcitx5-distro-defaults"
IMAGE_INSTALL:append = " fcitx5 fcitx5-chinese-addons fcitx5-qt fcitx5-configtool"
```

[fcitx5-distro-defaults.bbclass](classes/fcitx5-distro-defaults.bbclass) 将
`INIT_MANAGER` 设置为 `systemd`，并向 `DISTRO_FEATURES` 追加 `wayland x11 kde`。
接入已有发行版时，请检查这些设置是否适用。也可以不继承此 class，改为在自己的
distro 配置中设置所需功能。这里的默认配置同时启用 Wayland 和 X11，并非纯 Wayland 配置。

在 build 目录中构建并启动：

```sh
bitbake core-image-weston
runqemu qemux86-64
```

以上为构建流程示例，不代表已经完成 QEMU 运行测试。实体板卡需将 `MACHINE`
替换为 BSP 提供的值，并按 BSP 文档部署镜像。

## 运行配置与验证

[core-image-weston 的 append](recipes-graphics/images/core-image-weston.bbappend)
会向该镜像添加 Fcitx 5、中文输入扩展及配置工具。上述显式包列表还包含供 Qt 应用使用的
`fcitx5-qt`。其他镜像需要自行选择软件包并完成桌面会话集成。

启动图形会话后：

1. 执行 `fcitx5 --version`，确认输入法框架已安装。
2. 如果 Fcitx 5 尚未运行，在图形会话中启动它。
3. 打开 `fcitx5-config-qt`，添加需要的中文输入法，例如拼音。
4. 在目标应用中测试输入。仅安装 recipes 并不能证明合成器和应用的输入法集成已经正常工作。

Layer 中提供了 [Weston 配置示例](recipes-graphics/wayland/weston-init/weston.ini)，
将 Fcitx 5 配置为输入法并启用 Xwayland。但当前
[weston-init 的 append](recipes-graphics/wayland/weston-init.bbappend) 为空，
因此本 Layer 不会自动安装该配置文件。如需使用，请按自己的环境调整并安装。

无法输入中文时，请检查 Fcitx 5 进程、已启用的输入法、应用的输入模块配置和合成器支持。
对于 Qt 5 应用，还应确认目标镜像已安装 `fcitx5-qt`。

## 许可证

仓库提供 [COPYING.MIT](COPYING.MIT)。各 recipe 构建的软件有各自的许可证，
请查阅对应 recipe 的 `LICENSE` 和 `LIC_FILES_CHKSUM`。

## 贡献与支持

通过 [GitHub issues](https://github.com/hyyoxhk/meta-fcitx5/issues) 报告问题，
请提供 Layer 分支、Yocto 版本、machine、distro features 和相关构建或运行日志。
代码修改请提交 [GitHub pull requests](https://github.com/hyyoxhk/meta-fcitx5/pulls)。

维护者：He Yong <hyyoxhk@163.com>
