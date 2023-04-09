SUMMARY = "Large set of desktop widgets"
HOMEPAGE = "https://invent.kde.org/frameworks/kwidgetsaddons"
LICENSE = "BSD-3-Clause & CC0-1.0 & GPL-2.0-or-later & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/BSD-3-Clause.txt;md5=954f4d71a37096249f837652a7f586c0 \
                    file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
                    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
                    file://LICENSES/LGPL-2.0-only.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7"

SRC_URI = "https://download.kde.org/stable/frameworks/5.103/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "4c08cc7e8b28d1fbbf2804b44b534c66173b784457c4ca04b5609178e68c6441"

inherit cmake_qt5

DEPENDS += "extra-cmake-modules qttools-native"

EXTRA_OECMAKE += "-DBUILD_TESTING=Off"

PACKAGES += "${PN}-mkspecs"

FILES:${PN} += " \
    ${datadir}/qlogging-categories5/* \
    ${datadir}/kf5/* \
    "
FILES:${PN}-mkspecs = "${prefix}/mkspecs/*"
