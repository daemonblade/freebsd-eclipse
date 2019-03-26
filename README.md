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
* java/openjdk8
* security/libsecret
* x11-toolkits/gtk30

# Workflow

## Setup

1. `bin/fetch-distfiles [additional fetch(1) flags]`
1. `bin/unpack-distfiles`
1. `bin/apply-patches`

Unpacked distfiles + up-to-date patches => **eclipse.platform.releng.aggregator**

## Development

1. Work on **eclipse.platform.releng.aggregator**
1. `bin/build-eclipse [additional maven flags]` 
1. Optionally `bin/generate-patches`

## java/eclipse port

1. `bin/generate-patches`
1. Update [maven-repo project](https://github.com/daemonblade/maven-repo)
1. Update **java-eclipse** Makefile, distinfo, etc
1. Verify port build and installation
1. Submit port

# Output

On a successful build, `org.eclipse.sdk.ide-freebsd.gtk.${ARCH}.tar.gz` is found
on top level. Unpack the archive to to run the executable `eclipse/eclipse`

# Notes

The porting-strategy is based on using the Linux port as the
base and converting it to FreeBSD. The pre-patch stage renames
Linux specific directories, and most of the work devolves to
changing the following lines of text:
* `linux.x86_64` => `freebsd.amd64`
* `linux.ppc64le` => `freebsd.powerpc64`

Some modules have been disabled as they involve updates to a
maven repository. Some tests have been disabled as they won't
compile.
* org.eclipse.swt.tests
* tests/org.eclipse.swt.tests.gtk
* eclipse-junit-tests
* eclipse.platform.repository
