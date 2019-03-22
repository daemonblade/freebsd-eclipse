# FreeBSD Eclipse Port Builder

This project contains tools to build the port files for
FreeBSD's /usr/ports/java/eclipse.

# Layout

* **config.sh** Project configuration
* **bin** Script files, expected to be invoked from top-level as `bin/script`
* **distfiles** Cached copy of Eclipse tarballs
* **java-eclipse** Port to be eventually released to /usr/ports/java/eclipse
* **java-eclipse/files/patch-** Generated patches to port Eclipse to FreeBSD
* **eclipse.platform.releng.aggregator (generated)** working copy
* **.baseline.eclipse.platform.releng.aggregator (generated)** pristine unpacked tree
* **.patched.eclipse.platform.releng.aggregator (generated)** patched tree without build artifacts
* **maven-repo._tag_ (generated)** Maven repository for build, (to be used for port-build on FreeBSD)

# Prerequisite Ports

* devel/pkgconf
* devel/gmake
* devel/maven
* java/openjdk8
* security/libsecret
* x11-toolkits/gtk30

# Workflow

1. `bin/fetch-distfiles`
1. `bin/unpack-distfiles`
1. `bin/apply-patches`
1. Work on **eclipse.platform.releng.aggregator**
1. `bin/build-eclipse [additional maven flags]` 
1. `bin/generate-patches`

# Generated Output

On a successful build, `org.eclipse.sdk.ide-freebsd.gtk.${ARCH}.tar.gz` is found
on top level. Unpack the archive to try it out. You need to manually set the
Java VM to use, eg:

`./eclipse -vm /usr/local/bin/openjdk8/bin/java`

# Notes

The porting-strategy is based on using the Linux port as the
base and converting it to FreeBSD. The pre-patch stage renames
Linux specific directories, and most of the work devolves to
changing the following lines of text:
* `linux.x86_64` => `freebsd.amd64`
* `linux.ppc64le` => `freebsd.powerpc64`

Some modules have been disabled as they involve updates to a
maven repository; but also some tests don't compile.
* org.eclipse.swt.tests
* tests/org.eclipse.swt.tests.gtk
* eclipse-junit-tests
* eclipse.platform.repository
