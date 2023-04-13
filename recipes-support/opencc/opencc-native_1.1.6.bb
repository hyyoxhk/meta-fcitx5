require ${BPN}.inc

inherit cmake native

do_compile() {
    cmake --build ${B} --target opencc_dict
}

do_install() {
    install -d ${D}/${bindir}
    install -d ${D}/${libdir}
    install -m 755 ${B}/src/tools/opencc_dict ${D}/${bindir}
    install -m 755 ${B}/src/libopencc.so* ${D}/${libdir}
}
