require ${BPN}.inc

DEPENDS = "extra-cmake-modules-native fmt-native"

inherit cmake pkgconfig gettext native

PACKAGECONFIG = "libevent"

EXTRA_OECMAKE += " \
    -DDL_INCLUDE_DIR=/usr/include \
    -DLibIntl_INCLUDE_DIR=/usr/include \
    -DPTHREAD_INCLUDE_DIR=/usr/include \
    -DPTHREAD_LIB_FOUND=/usr/lib \
"

do_install:append () {
    rm ${D}/${bindir}/fcitx5-configtool
    rm ${D}/${bindir}/fcitx5-diagnose
    rm -rf ${D}/${includedir}/Fcitx5/Config
    rm -rf ${D}/${includedir}/Fcitx5/Core
    rm -rf ${D}/${includedir}/Fcitx5/Module

    rm -rf ${D}/${libdir}/cmake/Fcitx5Config
    rm -rf ${D}/${libdir}/cmake/Fcitx5Core
    rm -rf ${D}/${libdir}/cmake/Fcitx5Module
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleClipboard
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleEmoji
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleNotificationItem
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleNotifications
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleQuickPhrase
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleSpell
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleTestFrontend
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleTestIM
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleUnicode
    rm -rf ${D}/${libdir}/cmake/Fcitx5ModuleXCB

    rm -rf ${D}/${libdir}/fcitx5

    rm -rf ${D}/${libdir}/libFcitx5Config*
    rm -rf ${D}/${libdir}/libFcitx5Core*

    rm -rf ${D}/${libdir}/pkgconfig/Fcitx5Config.pc
    rm -rf ${D}/${libdir}/pkgconfig/Fcitx5Core.pc
    rm -rf ${D}/${libdir}/pkgconfig/Fcitx5Module.pc

    rm -rf ${D}/${datadir}

    install -m 755 ${B}/src/modules/spell/dict/comp-spell-dict ${D}/${bindir}
    install -m 644 ${S}/cmake/Fcitx5CompilerSettings.cmake ${D}/${libdir}/cmake/Fcitx5Utils
}
