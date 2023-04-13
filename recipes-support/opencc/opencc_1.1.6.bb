require ${BPN}.inc

DEPENDS = "opencc-native"

inherit cmake

EXTRA_OECMAKE = " \
    -DLIB_INSTALL_DIR=${libdir} \
"
