SUMMARY = "Qt library and IM module for fcitx5"
HOMEPAGE = "https://github.com/fcitx/fcitx5-qt"
LICENSE = "LGPL-2.1-or-later & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68 \
                    file://LICENSES/BSD-3-Clause.txt;md5=954f4d71a37096249f837652a7f586c0"

DEPENDS = "extra-cmake-modules fcitx5 gettext"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5-qt/fcitx5-qt-${PV}.tar.xz \
           file://0001-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
           "
SRC_URI[sha256sum] = "f663f12f0c3806684f43dcc64decc4f81c853e9027e2203188e20d7507b39c31"

inherit cmake_qt5 gettext

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)} \
                   qt5"

PACKAGECONFIG[qt4] = "-DENABLE_QT4=On,-DENABLE_QT4=Off"
PACKAGECONFIG[qt5] = "-DENABLE_QT5=On,-DENABLE_QT5=Off"
PACKAGECONFIG[qt6] = "-DENABLE_QT6=On,-DENABLE_QT6=Off"
PACKAGECONFIG[x11] = "-DENABLE_X11=On,-DENABLE_X11=Off,libxcb libx11"

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DCMAKE_INSTALL_QT5PLUGINDIR=${libdir}/plugins \
"

FILES:${PN} += "${libdir}/plugins/* ${libdir}/fcitx5/*"
FILES:${PN}-dev += "${libdir}/cmake/*"
