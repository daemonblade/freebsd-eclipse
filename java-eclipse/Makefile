# Created by: Jonathan Chen <jonc@chen.org.nz>
# $FreeBSD$

PORTNAME=   	eclipse
PORTVERSION=    4.11
CATEGORIES= 	java devel
MASTER_SITES= 	https://git.eclipse.org/c/jdt/:jdt \
		https://git.eclipse.org/c/pde/:pde \
		https://git.eclipse.org/c/plateform/:platform \
		https://git.eclipse.org/c/equinox/:equinox \
		GH:mvn_repo
#ECLIPSE_TAG=	${PORTVERSION:C/^([0-9]+)\.([0-9]+)/R\1_\2/}.tar.xz
ECLIPSE_TAG=	${PORTVERSION:C/^([0-9]+)\.([0-9]+)/S\1_\2/}_0_RC2
ECLIPSE_SUFX=	${ECLIPSE_TAG}.tar.xz
DISTFILES=	eclipse.jdt-${ECLIPSE_SUFX}:jdt \
		eclipse.jdt.core-${ECLIPSE_SUFX}:jdt \
		eclipse.jdt.core.binaries-${ECLIPSE_SUFX}:jdt \
		eclipse.jdt.debug-${ECLIPSE_SUFX}:jdt \
		eclipse.jdt.ui-${ECLIPSE_SUFX}:jdt \
		eclipse.pde.build-${ECLIPSE_SUFX}:pde \
		eclipse.pde.ui-${ECLIPSE_SUFX}:pde \
		eclipse.platform-${ECLIPSE_SUFX}:platform \
		eclipse.platform.common-${ECLIPSE_SUFX}:platform \
		eclipse.platform.debug-${ECLIPSE_SUFX}:platform \
		eclipse.platform.releng-${ECLIPSE_SUFX}:platform \
		eclipse.platform.releng.aggregator-${ECLIPSE_SUFX}:platform \
		eclipse.platform.resources-${ECLIPSE_SUFX}:platform \
		eclipse.platform.runtime-${ECLIPSE_SUFX}:platform \
		eclipse.platform.swt-${ECLIPSE_SUFX}:platform \
		eclipse.platform.swt.binaries-${ECLIPSE_SUFX}:platform \
		eclipse.platform.team-${ECLIPSE_SUFX}:platform \
		eclipse.platform.text-${ECLIPSE_SUFX}:platform \
		eclipse.platform.ua-${ECLIPSE_SUFX}:platform \
		eclipse.platform.ui-${ECLIPSE_SUFX}:platform \
		eclipse.platform.ui.tools-${ECLIPSE_SUFX}:platform \
		rt.equinox.binaries-${ECLIPSE_SUFX}:equinox \
		rt.equinox.bundles-${ECLIPSE_SUFX}:equinox \
		rt.equinox.framework-${ECLIPSE_SUFX}:equinox \
		rt.equinox.p2-${ECLIPSE_SUFX}:equinox \
		maven-repo-${PORTVERSION}.tar.gz:mvn_repo
DIST_SUBDIR=	${PORTNAME}
USE_GH=		yes
GH_ACCOUNT=	daemonblade
GH_PROJECT=	maven-repo

MAINTAINER=	jonc@chen.org.nz

LICENSE=	EPL

BUILD_DEPENDS=	ant:devel/apache-ant \
		git:devel/git-lite \
		${LOCALBASE}/share/java/maven/bin/mvn:devel/maven
LIB_DEPENDS=	libsecret-1.so:security/libsecret
USES=		gmake pkgconfig
USE_GNOME=	gtk30

ONLY_FOR_ARCHS=	amd64

USE_JAVA=       yes
JAVA_VERSION=   1.8+

WRKSRC=		${WRKDIR}/eclipse.platform.releng.aggregator-${ECLIPSE_TAG}

MAVEN_ENV=	MAVEN_OPTS=-Xmx1024m 
MAVEN_REPO=	-Dmaven.repo.local=${WRKDIR}/maven-repo
MAVEN_NATIVE=	-Dnative=gtk.freebsd.${ARCH}

do-build:
	cd ${WRKSRC} && ${SETENV} ${MAVEN_ENV} mvn --offline ${MAVEN_REPO} ${MAVEN_NATIVE} -DskipTests clean verify

.include <bsd.port.mk>
