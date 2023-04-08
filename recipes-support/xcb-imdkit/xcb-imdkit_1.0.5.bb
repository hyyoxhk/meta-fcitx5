LICENSE = "MIT &LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://src/xlibi18n/lcUniConv/COPYRIGHT;md5=2715cd5c86722a098d6b97148d1e6936 \
                    file://LICENSES/LGPL-2.1-only.txt;md5=fabba2a3bfeb22a6483d44e9ae824d3f"

SRC_URI = "https://download.fcitx-im.org/fcitx5/xcb-imdkit/xcb-imdkit-${PV}.tar.xz"
SRC_URI[sha256sum] = "373fcd26d99254b1260fd0254bcea1d346e1061cc5707f4d71b4a091418f03cc"

DEPENDS = "extra-cmake-modules uthash libxcb xcb-util xcb-util-keysyms"

inherit cmake

FILES:${PN}-dev += "${libdir}/cmake/XCBImdkit"
