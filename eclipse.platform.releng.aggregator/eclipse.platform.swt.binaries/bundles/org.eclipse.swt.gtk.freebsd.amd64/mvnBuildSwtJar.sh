#!/bin/bash

# tl;dr Force-copies fresh sources and builds *swt*.jar file, while overcomming some quirks with build system.
#       Used for testing/development of swt behaviour when in .jar And/Or runs as OSGI package in eclipse. (Not for official builds).
# If you set your DEV_ECLIPSE env var, then this script will copy the generated *.jar into it. (See below).

# This script modifies a few build files and uses maven to:
# 1) Builds the SWT binaries (build.sh)  in the swt/../lib/bin folder.
# 2) Copies the swt sources (.java files)
# 3) Packages everything into jar files.
# Generated .jar and source.jar can be found as
# org.eclipse.swt.gtk.linux.x86_64.source_3.1XX.0.v20XXXXXX-XXXX.jar in the ./target folder
# and can be copied directly into  eclipse/plugins/ folder of live-eclipse instances.
# Quricks:
#  * If you make changes in SWT source code, those are not picked up by regular mvn builds because it pulls upstream SWT sources.
#    Because of this, local changes to SWT sources (during develeopment) are not copied into the generated swt.jar
#  * To get around this, we temporarily set the forceContextQualifier to an old date (year 2000). This forces mvn to copy local SWT sources
#    instead of pulling them from upstream.
#  * Note, mvn only copies if local.binary.contextQualifier < remote.swtSrc.contextQualifier.
#    changes to the swt.contextQualifier in the swtSrc repo don't have any impact.

CACHED_FQM=$(grep -E "<forceContextQualifier>v[0-9]{8}-[0-9]{4}" ../binaries-parent/pom.xml | grep -oE "[0-9]{8}-[0-9]{4}")

# Replace force Context Qualifier with one that is guaranteed to be older than the one in swt source.
PREFIX="<forceContextQualifier>"
sed -r -i "s/${PREFIX}v[0-9]{8}-[0-9]{4}/${PREFIX}v20000000-0000/" ../binaries-parent/pom.xml 

#  Build swt jar
mvn clean verify -Pbuild-individual-bundles

# Replace old FQM with original one.
sed -r -i "s/${PREFIX}v[0-9]{8}-[0-9]{4}/${PREFIX}v${CACHED_FQM}/" ../binaries-parent/pom.xml 

# Print instructions to user.
echo -e "---\nIf Maven build went well, the *swt*.jar can be found in ./target/"

if [ "${DEV_ECLIPSE}" != "" ]; then
	echo " Copying generated *.jar files into your ${DEV_ECLIPSE} folder"
	cp -v ./target/org.eclipse.swt.gtk.linux.x86_64-*-SNAPSHOT.jar ${DEV_ECLIPSE}/plugins/org.eclipse.swt.gtk.linux.x86_64_*
	cp -v ./target/org.eclipse.swt.gtk.linux.x86_64-*-SNAPSHOT-sources.jar ${DEV_ECLIPSE}/plugins/org.eclipse.swt.gtk.linux.x86_64.source_*.jar
	echo "Note: Below should list newly generated *jar files with current timestamp"
	ls -l --color=auto -a ${DEV_ECLIPSE}/plugins/org.eclipse.swt.gtk.linux.x86_64*
else
	echo "Note:" 
	echo "  Set DEV_ECLIPSE to your development eclipse folder to have the *.jar files copied into it automatically."
	echo '  e.g:  cd <your dev eclipse>; export DEV_ECLIPSE=$(pwd)'
	echo '  Note that "pwd" does not add trailing forward slash'
fi
