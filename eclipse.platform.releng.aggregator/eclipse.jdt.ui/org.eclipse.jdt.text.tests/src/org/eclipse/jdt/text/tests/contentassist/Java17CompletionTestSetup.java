/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.text.tests.contentassist;

import junit.framework.Test;

import org.eclipse.jdt.testplugin.JavaProjectHelper;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;

import org.eclipse.jdt.ui.tests.core.Java1d7ProjectTestSetup;


class Java17CompletionTestSetup extends Java1d7ProjectTestSetup {

	public static IPackageFragment getTestPackage() throws CoreException {
		IJavaProject project= getProject();
		IPackageFragmentRoot root= project.getPackageFragmentRoot("src");
		if (!root.exists())
			root= JavaProjectHelper.addSourceContainer(project, "src");

		IPackageFragment fragment= root.getPackageFragment("test1");
		if (!fragment.exists())
			fragment= root.createPackageFragment("test1", false, null);

		return fragment;
	}

	private static int fAnonymousSoureFolderCounter= 0;
	public static IPackageFragment getAnonymousTestPackage() throws CoreException {
		IJavaProject project= getProject();
		String sourceFolder= "src" + fAnonymousSoureFolderCounter++;
		IPackageFragmentRoot root= project.getPackageFragmentRoot(sourceFolder);
		if (!root.exists())
			root= JavaProjectHelper.addSourceContainer(project, sourceFolder);

		IPackageFragment fragment= root.getPackageFragment("test1");
		if (!fragment.exists())
			fragment= root.createPackageFragment("test1", false, null);

		return fragment;
	}

	public Java17CompletionTestSetup(Test test) {
		super(test);
	}
}