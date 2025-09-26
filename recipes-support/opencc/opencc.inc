SUMMARY = "Conversion between Traditional and Simplified Chinese"
HOMEPAGE = "https://opencc.byvoid.com"
LICENSE = "Apache-2.0 & BSD-2-Clause &  BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=a53192195ed45e801ce0642da66d65a7 \
    file://deps/google-benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
    file://deps/googletest-1.15.0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://deps/marisa-0.2.6/COPYING.md;md5=436b518598dca3cb23d801bd12d59826 \
    file://deps/pybind11-2.13.1//LICENSE;md5=774f65abd8a7fe3124be2cdf766cd06f"

SRC_URI = "git://github.com/BYVoid/OpenCC.git;protocol=https;branch=master"
SRCREV = "556ed22496d650bd0b13b6c163be9814637970ae"

S = "${WORKDIR}/git"
