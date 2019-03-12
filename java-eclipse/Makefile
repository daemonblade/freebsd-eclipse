# Created by: Jonathan Chen <jonc@chen.org.nz>
# $FreeBSD$

PORTNAME=   	eclipse
PORTVERSION=    4.11
CATEGORIES= 	java devel
MASTER_SITES= 	https://git.eclipse.org/c/jdt:jdt \
		https://git.eclipse.org/c/pde:pde \
		https://git.eclipse.org/c/plateform:platform \
		https://git.eclipse.org/c/equinox:equinox \
		GH:mvn_repo
DISTFILES=	eclipse.jdt:jdt \
		eclipse.jdt.core:jdt \
		eclipse.jdt.core.binaries:jdt \
		eclipse.jdt.debug:jdt \
		eclipse.jdt.ui:jdt \
		eclipse.pde.build:pde \
		eclipse.pde.ui:pde \
		eclipse.platform:platform \
		eclipse.platform.common:platform \
		eclipse.platform.debug:platform \
		eclipse.platform.releng:platform \
		eclipse.platform.resources:platform \
		eclipse.platform.runtime:platform \
		eclipse.platform.swt:platform \
		eclipse.platform.swt.binaries:platform \
		eclipse.platform.team:platform \
		eclipse.platform.text:platform \
		eclipse.platform.ua:platform \
		eclipse.platform.ui:platform \
		eclipse.platform.ui.tools:platform \
		rt.equinox.binaries:equinox \
		rt.equinox.bundles:equinox \
		rt.equinox.framework:equinox \
		rt.equinox.p2:equinox

GH_ACCOUNT=	daemonblade
GH_PROJECT=	eclipse-maven-repo

MAINTAINER=	jonc@chen.org.nz

LICENSE=	EPL

BUILD_DEPENDS=	${LOCALBASE}/share/java/maven/bin/mvn:devel/maven
USE_GNOME=	gtk30

ONLY_FOR_ARCHS=	amd64

USE_JAVA=       yes
JAVA_VERSION=   1.8+

.include <bsd.port.mk>
