# FreeBSD Eclipse Port Builder

This project contains tools to build the port files for
FreeBSD's /usr/ports/java/eclipse.

# Layout

* **config.sh** Project configuration
* **bin** Script files, expected to be invoked from top-level as `bin/script`
* **distfiles** Cached copy of Eclipse tarballs
* **java-eclipse** Port to be eventually released to /usr/ports/java/eclipse
* **java-eclipse/files/patch-** Generated patches to port Eclipse to FreeBSD
* **eclipse.platform.releng.aggregator** Eclipse patched for FreeBSD
* **.baseline.eclipse.platform.releng.aggregator (generated)** pristine unpacked tree
* **maven-repo.${tag}** Maven repository for Eclipse build

# Prerequisite Ports

* devel/gmake
* devel/maven
* devel/pkgconf
* java/openjdk11
* security/libsecret
* www/webkit2-gtk3
* x11-toolkits/gtk30

# Workflow

## Setup

1. `bin/fetch-distfiles [additional fetch(1) flags]`
1. `bin/unpack-distfiles`
1. `bin/apply-patches [directory ...]`

Unpacked distfiles + up-to-date patches => **eclipse.platform.releng.aggregator**

## Development

1. Work on **eclipse.platform.releng.aggregator**
1. `bin/build-eclipse [additional maven flags]` 

The challenge is to get a working build. Changes to
**eclipse.platform.releng.aggregator** should be committed and pushed to
the repo as required. At stable checkpoints, patches for the port should
be generated with:

1. `bin/generate-patches`

On a successful build, `org.eclipse.sdk.ide-freebsd.gtk.${ARCH}.tar.gz` is
generated. This can be unpacked to test the generated executable:

1. `tar xf org.eclipse.sdk.ide-freebsd.gtk.${ARCH}.tar.gz`
2. `eclipse/eclipse`

## java/eclipse port

When a usable executable has been generated the java/eclipse port can be
updated:

1. `bin/generate-patches`
1. Update the
[eclipse-maven-repo](https://github.com/daemonblade/eclipse-maven-repo)
project with the contents of **maven-repo.${TAG}**.
1. Update **java-eclipse** Makefile, distinfo, etc
1. Verify port build and installation
1. Submit port

# Notes

The porting-strategy is based on using the Linux port as the
base and converting it to FreeBSD. The pre-patch stage renames
Linux specific directories, and most of the work devolves to
changing the following lines of text:
* `linux.x86_64` => `freebsd.amd64`
* `linux.ppc64le` => `freebsd.powerpc64`

The following modules have been disabled as they involve maven repository
updates or are uncompilable tests.
* tests/org.eclipse.swt.tests.gtk
* eclipse-junit-tests
* eclipse.platform.repository
