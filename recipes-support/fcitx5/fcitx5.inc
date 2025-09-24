SUMMARY = "An input method framework with extension support"
HOMEPAGE = "https://fcitx-im.org/wiki/Fcitx_5"
SECTION = "base"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "https://download.fcitx-im.org/fcitx5/fcitx5/fcitx5-${PV}_dict.tar.zst \
           file://0001-Do-not-use-alias-for-target-binary.patch \
           file://0002-Use-CMAKE_INSTALL_INCLUDEDIR-instead-of-CMAKE_INSTAL.patch \
           file://0003-Use-CMAKE_INSTALL_FULL_LIBDIR-instead-of-CMAKE_INSTA.patch \
           file://0001-Tweak-include-directories-to-care-CMAKE_SYSROOT.patch \
           "
SRC_URI[sha256sum] = "7a43cf181c967a9cdefce3c95c51e0e8f117740a25ddca111ec750f87af7dce4"

PACKAGECONFIG[enchant] = "-DENABLE_ENCHANT=On,-DENABLE_ENCHANT=Off,enchant2"
PACKAGECONFIG[x11] = "-DENABLE_X11=On,-DENABLE_X11=Off,libxcb xcb-util xcb-util-keysyms xcb-util-wm xcb-imdkit libxkbfile"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND=On,-DENABLE_WAYLAND=Off,wayland wayland-native wayland-protocols"
PACKAGECONFIG[dbus] = "-DENABLE_DBUS=On,-DENABLE_DBUS=Off,dbus"
PACKAGECONFIG[server] = "-DENABLE_SERVER=On,-DENABLE_SERVER=Off"
PACKAGECONFIG[keyboard] = "-DENABLE_KEYBOARD=On,-DENABLE_KEYBOARD=Off,iso-codes xkeyboard-config json-c"
PACKAGECONFIG[systemd] = "-DUSE_SYSTEMD=On,-DUSE_SYSTEMD=Off,systemd"
PACKAGECONFIG[libuv] = ",,libuv"
PACKAGECONFIG[xdg] = "-DENABLE_XDGAUTOSTART=On,-DENABLE_XDGAUTOSTART=Off"
PACKAGECONFIG[emoji] = "-DENABLE_EMOJI=On,-DENABLE_EMOJI=Off"
PACKAGECONFIG[uuid] = "-DENABLE_LIBUUID=On,-DENABLE_LIBUUID=Off,util-linux-libuuid"

EXTRA_OECMAKE += "-DENABLE_TEST=Off"
EXTRA_OECMAKE += "-DISOCODES_ISO639_JSON=${datadir}/iso-codes/json/iso_639-3.json"
EXTRA_OECMAKE += "-DISOCODES_ISO3166_JSON=${datadir}/iso-codes/json/iso_3166-1.json"
