require ${BPN}.inc

DEPENDS = "extra-cmake-modules fcitx5 boost libime-native"

inherit cmake

EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
    -DENABLE_TEST=OFF \
"
