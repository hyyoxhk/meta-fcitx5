SUMMARY = "Large set of desktop widgets"
HOMEPAGE = "https://invent.kde.org/frameworks/kitemviews"
LICENSE = "CC0-1.0 & GPL-2.0-or-later & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
                    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
                    file://LICENSES/LGPL-2.0-or-later.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7"

SRC_URI = "https://download.kde.org/stable/frameworks/5.116/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "6c0efbf408dab60c58bb13bb3a7488827283a5eea947ef3cfd0fbcb4f09e01eb"

inherit cmake_qt5

DEPENDS += "extra-cmake-modules qttools-native"

PACKAGES += "${PN}-mkspecs"

FILES:${PN} += "${datadir}/qlogging-categories5/*"
FILES:${PN}-mkspecs = "${prefix}/mkspecs/*"
