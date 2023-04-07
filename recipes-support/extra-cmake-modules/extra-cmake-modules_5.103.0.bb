SUMMARY = "Extra CMake modules"
HOMEPAGE = "https://api.kde.org/ecm"
SECTION = "console/utils"
LICENSE = "BSD-2-Clause & BSD-3-Clause & CC0-1.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSES/BSD-2-Clause.txt;md5=63d6ee386b8aaba70b1bf15a79ca50f2 \
                    file://LICENSES/BSD-3-Clause.txt;md5=954f4d71a37096249f837652a7f586c0 \
                    file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
                    file://LICENSES/MIT.txt;md5=38aa75cf4c4c87f018227d5ec9638d75"

SRC_URI = "https://download.kde.org/stable/frameworks/5.103/extra-cmake-modules-${PV}.tar.xz"
SRC_URI[sha256sum] = "92ca2e55cb38956fbdeaf254231f074647173ccfd12dc9664989c6fa9e9c4346"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_TESTING=Off"

FILES:${PN}-dev += " ${datadir}/ECM"

BBCLASSEXTEND = "native nativesdk"
