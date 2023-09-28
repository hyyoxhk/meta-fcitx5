require ${BPN}.inc

DEPENDS += "extra-cmake-modules gettext fmt iso-codes fcitx5-native"
DEPENDS += "${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', 'libxkbcommon cairo pango gdk-pixbuf', '', d)}"

inherit cmake pkgconfig gettext features_check
ANY_OF_DISTRO_FEATURES = "x11 wayland"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'x11 wayland', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', 'libevent', d)} \
                   dbus enchant server keyboard uuid"

FILES:${PN} += " \
    ${datadir}/icons/* \
    ${datadir}/dbus-1/* \
    ${datadir}/metainfo/* \
"
