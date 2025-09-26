require ${BPN}.inc

DEPENDS = "extra-cmake-modules fcitx5 boost zstd libime-native"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_TEST=OFF \
"
