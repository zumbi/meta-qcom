DESCRIPTION = "QCOM Firmware for DragonBoard 820c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

SRC_URI = "http://builds.96boards.org/releases/dragonboard820c/qualcomm/firmware/linux-board-support-package-r${PV}.zip"
SRC_URI[md5sum] = "587138c5e677342db9a88d5c8747ec6c"
SRC_URI[sha256sum] = "6ee9c461b2b5dd2d3bd705bb5ea3f44b319ecb909b2772f305ce12439e089cd9"

COMPATIBLE_MACHINE = "(dragonboard-820c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_compile() {
	:
}

do_install() {
    install -d ${D}/lib/firmware/
    install -d ${D}/lib/firmware/qcom/venus-4.2/
    
    install -m 0444 ./proprietary-linux/a530*.* ${D}/lib/firmware/
    install -m 0444 ./proprietary-linux/venus.* ${D}/lib/firmware/qcom/venus-4.2/
    install -m 0444 ./proprietary-linux/adsp.* ${D}/lib/firmware/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE
}

FILES_${PN} += "/lib/firmware/*"
INSANE_SKIP_${PN} += "arch"
