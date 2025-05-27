# meta-fcitx5

**English**,
[简体中文][ZH_CN]

[EN]:README.md
[ZH_CN]:README_zh.md

## Summary

This README file contains information on the contents of the meta-fcitx5 layer.

Please see the corresponding sections below for details.

## Dependencies

[YOCTO]

- URI: https://git.yoctoproject.org/poky

- branch: same dedicated branch as meta-fcitx5

[META-QT5]

- URI: https://github.com/meta-qt5/meta-qt5.git

- branch: same dedicated branch as meta-fcitx5

[META-OPENEMBEDDED]

- URI: https://github.com/openembedded/meta-openembedded.git

- branch: same dedicated branch as meta-fcitx5

## Quick Start

```shell
$> git clone -b kirkstone https://git.yoctoproject.org/poky
$> cd poky
$> git clone -b kirkstone https://github.com/openembedded/meta-openembedded.git
$> git clone -b kirkstone https://github.com/meta-qt5/meta-qt5.git
$> git clone -b kirkstone https://github.com/hyyoxhk/meta-fcitx5.git
$>
$> source oe-init-build-env
...
$ bitbake-layers add-layer ../meta-openembedded/meta-oe
$ bitbake-layers add-layer ../meta-qt5
$ bitbake-layers add-layer ../meta-fcitx5
```

## Example

Below we build for `stm32mp15-disco` machine as an example. to local.conf add:

```bitbake
INHERIT += " fcitx5-distro-defaults"
IMAGE_INSTALL += " fcitx5 fcitx5-chinese-addons"
```

## Contributing

If you want to contribute changes, you can send Github pull requests at https://github.com/hyyoxhk/meta-fcitx5/pulls

## Maintainer

- He Yong <hyyoxhk@163.com>
