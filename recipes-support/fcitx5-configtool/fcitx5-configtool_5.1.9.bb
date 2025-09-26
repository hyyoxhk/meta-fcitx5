SUMMARY = "A Qt-based GUI tool that provides user friendly configuration interface for Fcitx 5"
HOMEPAGE = "https://fcitx-im.org/wiki/Configtool_(Fcitx_5)"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "extra-cmake-modules kitemviews fcitx5 fcitx5-qt qtsvg kwidgetsaddons iso-codes"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5-configtool/${BPN}-${PV}.tar.zst \
           file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
           file://0002-split-X11-related-code.patch \
           "
SRC_URI[sha256sum] = "650685b593652079d72044fc4f13f842ebc928aa2bb413ce0a9359dfa6069659"

inherit cmake_qt5 pkgconfig gettext

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)}"

PACKAGECONFIG[x11] = "-DENABLE_X11=On,-DENABLE_X11=Off,qtx11extras libx11 xkeyboard-config"

EXTRA_OECMAKE += " \
    -DUSE_QT6=Off \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_KCM=Off \
    -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"
