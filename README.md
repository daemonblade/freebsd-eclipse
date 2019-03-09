# FreeBSD Eclipse Port Builder

This project contains tools to build the port files for
FreeBSD's /usr/ports/java/eclipse.

# Layout

* **config.sh** Project configuration
* **bin** Script files, expected to be invoked from top-level as `bin/script`
* **distfiles** Cached copy of Eclipse tarballs
* **patches** Generated patches to port Eclipse to FreeBSD
* **java-eclipse** Port to be eventually released to /usr/ports/java/eclipse
* **eclipse.platform.releng.aggregator** working copy
* **.baseline.eclipse.platform.releng.aggregator** pristine unpacked tree
* **.patched.eclipse.platform.releng.aggregator** patched tree without build artifacts
* **maven-repo._tag_** Maven repository for build, (to be used for port-build on FreeBSD)

# Prerequisite Ports

* devel/apache-ant
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
1. `bin/build-eclipse`
1. `bin/generate-patches`
