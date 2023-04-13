SUMMARY = "Conversion between Traditional and Simplified Chinese"
HOMEPAGE = "https://opencc.byvoid.com"
LICENSE = "Apache-2.0 & BSD-2-Clause &  BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=a53192195ed45e801ce0642da66d65a7 \
    file://deps/google-benchmark/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
    file://deps/gtest-1.12.1/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://deps/marisa-0.2.6/COPYING.md;md5=436b518598dca3cb23d801bd12d59826 \
    file://deps/pybind11-2.10.0/LICENSE;md5=774f65abd8a7fe3124be2cdf766cd06f"

SRC_URI = "git://github.com/BYVoid/OpenCC.git;protocol=https;branch=master"
SRCREV = "982c74f45d0ca314e71aecf77362fc10b0a8ea90"

S = "${WORKDIR}/git"
