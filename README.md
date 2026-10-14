# meta-fcitx5 — Fcitx 5 Input Method Layer for Yocto/OpenEmbedded

**English** | [简体中文](README_zh.md)

meta-fcitx5 provides BitBake recipes for integrating the Fcitx 5 input method
framework and Chinese input addons into embedded Linux images built with the
Yocto Project and OpenEmbedded. It includes Qt 5 integration, a graphical
configuration tool, and libraries used for Chinese input and character conversion.

## Compatibility and dependencies

The current `scarthgap` branch declares compatibility with Yocto scarthgap in
[conf/layer.conf](conf/layer.conf). This declaration is not a board-specific test
report. Use matching `scarthgap` branches for the following dependencies:

| Repository | Layer to add | Purpose |
| --- | --- | --- |
| [Poky](https://git.yoctoproject.org/poky) | Added by the default Poky build configuration | Yocto build environment and core metadata |
| [meta-openembedded](https://github.com/openembedded/meta-openembedded) | `meta-oe` | Additional recipe dependencies |
| [meta-qt5](https://github.com/meta-qt5/meta-qt5) | `meta-qt5` | Qt 5 recipes and build classes |

The Fcitx 5 target recipe requires `x11` or `wayland` in `DISTRO_FEATURES`.
Support for another Yocto release or a particular board needs separate validation.
For physical hardware, add the appropriate BSP layer and use its machine configuration.

## Included components

| Recipe | Version | Purpose |
| --- | --- | --- |
| `fcitx5` | 5.0.17 | Input method framework |
| `fcitx5-chinese-addons` | 5.0.17 | Chinese input addons, including Pinyin |
| `fcitx5-qt` | 5.1.5 | Qt integration and input method module; Qt 5 is enabled by default |
| `fcitx5-configtool` | 5.0.17 | Qt graphical configuration tool |
| `libime` | 1.0.17 | Libraries for input method implementation |
| `opencc` | 1.1.6 | Simplified and Traditional Chinese conversion |
| `xcb-imdkit` | 1.0.5 | X11 input method protocol support |

The layer also includes KDE build dependencies and native recipes used during
cross compilation. See [recipes-support](recipes-support) for the complete recipe list.

## Quick start

Prepare a host with the prerequisites required by Yocto scarthgap, then run:

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

### Configure and build a Weston image

For a QEMU example that does not require an external board BSP, add the following
to `build/conf/local.conf` (or `conf/local.conf` from inside the build directory):

```bitbake
MACHINE = "qemux86-64"
INHERIT += " fcitx5-distro-defaults"
IMAGE_INSTALL:append = " fcitx5 fcitx5-chinese-addons fcitx5-qt fcitx5-configtool"
```

[fcitx5-distro-defaults.bbclass](classes/fcitx5-distro-defaults.bbclass) sets
`INIT_MANAGER` to `systemd` and appends `wayland x11 kde` to `DISTRO_FEATURES`.
Review these settings when integrating into an existing distribution. You can
omit the class and configure the required features in your own distro instead.
The supplied defaults enable both Wayland and X11; they are not a pure Wayland configuration.

Build and launch from the build directory:

```sh
bitbake core-image-weston
runqemu qemux86-64
```

This is a build workflow example, not a claim of a verified QEMU runtime test.
For a physical board, replace `MACHINE` with the BSP-provided value and deploy the
image using the BSP instructions.

## Runtime setup and verification

The [core-image-weston append](recipes-graphics/images/core-image-weston.bbappend)
adds Fcitx 5, Chinese addons, and the configuration tool to that image.
The explicit package list above also includes `fcitx5-qt` for Qt applications.
Other images need their own package selection and desktop session integration.

After booting into your graphical session:

1. Run `fcitx5 --version` to check that the framework is installed.
2. Start Fcitx 5 in the graphical session if it is not already running.
3. Open `fcitx5-config-qt` and add the desired Chinese input method, such as Pinyin.
4. Test input in the intended application. Installing recipes alone does not
   establish that the compositor and application's input method integration work.

The layer contains a [Weston configuration example](recipes-graphics/wayland/weston-init/weston.ini)
with Fcitx 5 as the input method and Xwayland enabled. The current
[weston-init append](recipes-graphics/wayland/weston-init.bbappend) is empty,
so that configuration file is not automatically installed by this layer.
Adapt and install it through your own configuration if needed.

If Chinese input is unavailable, check the running Fcitx 5 process, enabled input
methods, application input module configuration, and compositor support. For Qt 5
applications, also check that `fcitx5-qt` is installed in the target image.

## License

The repository includes [COPYING.MIT](COPYING.MIT). Software built by individual
recipes has its own license; consult each recipe's `LICENSE` and `LIC_FILES_CHKSUM`.

## Contributing and support

Report problems through [GitHub issues](https://github.com/hyyoxhk/meta-fcitx5/issues).
Include the layer branch, Yocto release, machine, distro features, and relevant
build or runtime logs. Submit changes through
[GitHub pull requests](https://github.com/hyyoxhk/meta-fcitx5/pulls).

Maintainer: He Yong <hyyoxhk@163.com>
