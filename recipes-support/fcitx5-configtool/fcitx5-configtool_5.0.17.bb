SUMMARY = "A Qt-based GUI tool that provides user friendly configuration interface for Fcitx 5"
HOMEPAGE = "https://fcitx-im.org/wiki/Configtool_(Fcitx_5)"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "extra-cmake-modules qtx11extras kitemviews fcitx5 fcitx5-qt qtsvg kwidgetsaddons iso-codes"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5-configtool/${BPN}-${PV}.tar.xz \
           file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
           file://0002-split-X11-related-code.patch \
           "
SRC_URI[sha256sum] = "f8b6196d23d14a6acc9a2b3dbc3772b6e5b2e3a5147b78b649238a3d775786d5"

inherit cmake_qt5 pkgconfig gettext

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)}"

PACKAGECONFIG[x11] = "-DENABLE_X11=On,-DENABLE_X11=Off,qtx11extras libx11 xkeyboard-config"

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_KCM=Off \
    -DFCITX_TOOL_BINARY_DIR=${STAGING_LIBDIR_NATIVE}/fcitx/ \
"
