require ${BPN}.inc

DEPENDS = "extra-cmake-modules-native fcitx5-native boost-native"

inherit cmake native

EXTRA_OECMAKE += "-DENABLE_TEST=OFF"

do_compile() {
    cmake --build ${B} --target libime_pinyindict
    cmake --build ${B} --target libime_tabledict
    cmake --build ${B} --target libime_slm_build_binary
    cmake --build ${B} --target libime_prediction
}

do_install() {
    install -d ${D}/${bindir}
    install -d ${D}/${libdir}
    install -m 755 ${B}/tools/libime_pinyindict ${D}/${bindir}/pinyindict
    install -m 755 ${B}/tools/libime_tabledict ${D}/${bindir}/tabledict
    install -m 755 ${B}/tools/libime_slm_build_binary ${D}/${bindir}/slm_build_binary
    install -m 755 ${B}/tools/libime_prediction ${D}/${bindir}/prediction
    install -m 644 ${B}/src/libime/core/libIMECore.so* ${D}/${libdir}
    install -m 644 ${B}/src/libime/pinyin/libIMEPinyin.so* ${D}/${libdir}
    install -m 644 ${B}/src/libime/table/libIMETable.so* ${D}/${libdir}
}
