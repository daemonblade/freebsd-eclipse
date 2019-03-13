# Created by: Jonathan Chen <jonc@chen.org.nz>
# $FreeBSD$

PORTNAME=   	eclipse
PORTVERSION=    4.11.RC2
CATEGORIES= 	java devel

#ECLIPSE_TAG=	${PORTVERSION:C/^([0-9]+)\.([0-9]+)/R\1_\2/}.tar.xz
ECLIPSE_TAG=	S4_11_0_RC2
ECLIPSE_SUFX=	${ECLIPSE_TAG}.tar.xz
ECLIPSE_MODULES=jdt/eclipse.jdt \
		jdt/eclipse.jdt.core \
		jdt/eclipse.jdt.core.binaries \
		jdt/eclipse.jdt.debug \
		jdt/eclipse.jdt.ui \
		pde/eclipse.pde.build \
		pde/eclipse.pde.ui \
		platform/eclipse.platform \
		platform/eclipse.platform.common \
		platform/eclipse.platform.debug \
		platform/eclipse.platform.releng \
		platform/eclipse.platform.resources \
		platform/eclipse.platform.runtime \
		platform/eclipse.platform.swt \
		platform/eclipse.platform.swt.binaries \
		platform/eclipse.platform.team \
		platform/eclipse.platform.text \
		platform/eclipse.platform.ua \
		platform/eclipse.platform.ui \
		platform/eclipse.platform.ui.tools \
		equinox/rt.equinox.binaries \
		equinox/rt.equinox.bundles \
		equinox/rt.equinox.framework \
		equinox/rt.equinox.p2
# Each Eclipse module has its own MASTER_SITE
.for M in ${ECLIPSE_MODULES}
MASTER_SITES+=	https://git.eclipse.org/c/${M}.git/snapshot/:${M:C/[\.\/]//g}
DISTFILES+=	${M:C/.*\///}-${ECLIPSE_SUFX}:${M:C/[\.\/]//g}
.endfor

DIST_SUBDIR=	${PORTNAME}
USE_GITHUB=	yes
GH_TUPLE=	daemonblade:maven-repo:${PORTVERSION}

MAINTAINER=	jonc@chen.org.nz

LICENSE=	EPL

BUILD_DEPENDS=	ant:devel/apache-ant \
		git:devel/git-lite \
		${LOCALBASE}/share/java/maven/bin/mvn:devel/maven
LIB_DEPENDS=	libsecret-1.so:security/libsecret
USES=		gmake pkgconfig
USE_GNOME=	gtk30

ONLY_FOR_ARCHS=	amd64 power64

USE_JAVA=       yes
JAVA_VERSION=   1.8+

WRKSRC=		${WRKDIR}/eclipse.platform.releng.aggregator-${ECLIPSE_TAG}

MAVEN_ENV=	MAVEN_OPTS=-Xmx1024m 
MAVEN_REPO=	-Dmaven.repo.local=${WRKDIR}/maven-repo
MAVEN_NATIVE=	-Dnative=gtk.freebsd.${ARCH}

do-build:
	cd ${WRKSRC} && ${SETENV} ${MAVEN_ENV} mvn --offline ${MAVEN_REPO} ${MAVEN_NATIVE} -DskipTests clean verify

.include <bsd.port.mk>
