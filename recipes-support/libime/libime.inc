SUMMARY = "A library to support generic input method implementation"
HOMEPAGE = "https://github.com/fcitx/libime"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/${BPN}/${BPN}-${PV}_dict.tar.xz \
           file://0001-Do-not-use-alias-for-target-binary.patch \
           file://0002-Add-CMAKE_SYSROOT-to-find-additional-cmake-file.patch \
           file://0003-Use-CMAKE_INSTALL_INCLUDEDIR-instead-of-CMAKE_INSTAL.patch \
           file://0004-Fix-variable-is-initialized.patch \
           "
SRC_URI[sha256sum] = "8e14bbcab8b259cf359a73c9b6007470b20202da458a58fcec6c62f86c48a101"
