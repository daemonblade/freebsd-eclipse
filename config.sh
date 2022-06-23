#
# Configuration
#
ECLIPSE_TAG="R4_24"

ECLIPSE_TOP="eclipse-platform/eclipse.platform.releng.aggregator"
ECLIPSE_MODULES="
	eclipse-jdt/eclipse.jdt
	eclipse-jdt/eclipse.jdt.core
	eclipse-jdt/eclipse.jdt.core.binaries
	eclipse-jdt/eclipse.jdt.debug
	eclipse-jdt/eclipse.jdt.ui
	eclipse-pde/eclipse.pde
	eclipse-platform/eclipse.platform
	eclipse-platform/eclipse.platform.common
	eclipse-platform/eclipse.platform.debug
	eclipse-platform/eclipse.platform.releng
	eclipse-platform/eclipse.platform.resources
	eclipse-platform/eclipse.platform.swt
	eclipse-platform/eclipse.platform.swt.binaries
	eclipse-platform/eclipse.platform.team
	eclipse-platform/eclipse.platform.text
	eclipse-platform/eclipse.platform.ua
	eclipse-platform/eclipse.platform.ui
	eclipse-platform/eclipse.platform.ui.tools
	eclipse-equinox/equinox.binaries:rt.equinox.binaries
	eclipse-equinox/equinox.bundles:rt.equinox.bundles
	eclipse-equinox/equinox.framework:rt.equinox.framework
	eclipse-equinox/p2:rt.equinox.p2"
#	eclipse-platform/eclipse.platform.runtime@fd42b6e331

PATCH_DIR="java-eclipse/files"
PATCHED_DIRS="
	eclipse-platform-parent
	eclipse.pde.build
	eclipse.pde.ui
	eclipse.platform.releng
	eclipse.platform.releng.tychoeclipsebuilder
	eclipse.platform.resources
	eclipse.platform.runtime
	eclipse.platform.swt
	eclipse.platform.swt.binaries
	eclipse.platform.team
	eclipse.platform.text
	eclipse.platform.ua
	eclipse.platform.ui
	rt.equinox.bundles
	rt.equinox.framework
	rt.equinox.p2
"

CEF_FILE="cef_binary_3.3071.1649.g98725e6_linux64_minimal"
