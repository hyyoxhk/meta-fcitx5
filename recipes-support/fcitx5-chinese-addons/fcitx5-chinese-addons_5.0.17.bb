SUMMARY = "Addons related to Chinese, including IME previous bundled inside fcitx4"
HOMEPAGE = "https://github.com/fcitx/fcitx5-chinese-addons"
LICENSE = "GPL-2.0-or-later & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
                    file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS = "fcitx5 fmt curl opencc libime gettext libime-native"
RDEPENDS:${PN} = "fcitx5 curl opencc libime"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${BPN}/${BPN}-${PV}_dict.tar.xz \
           file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
           file://0002-Add-cmake-option-ENABLE_METAINFO.patch \
           file://0003-Work-arround-to-execute-libime_pinyindict-for-cross-.patch \
           "
SRC_URI[sha256sum] = "7dc7ab82f373199973c125035835d948d5714dcde393d7408d190a8013c1346e"

inherit cmake pkgconfig gettext

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_METAINFO=OFF \
    -DENABLE_GUI=OFF \
    -DENABLE_TEST=OFF \
"

FILES:${PN} += "\
    ${libdir}/fcitx5/*.so \
    ${datadir}/icons \
    ${datadir}/fcitx5 \
"

FILES:${PN}-dev += "${libdir}/cmake"
