/*******************************************************************************
 *  Copyright (c) 2000, 2013 IBM Corporation and others.
 *
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.tests.launching;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.internal.core.RefreshScopeComparator;
import org.eclipse.debug.tests.TestsPlugin;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Tests the refresh tab.
 */
public class RefreshTabTests extends AbstractLaunchTest {

	/**
	 * Constructor
	 * @param name
	 */
	public RefreshTabTests(String name) {
		super(name);
	}

	/**
	 * Sets the selected resource in the navigator view.
	 *
	 * @param resource resource to select
	 */
	protected void setSelection(IResource resource) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		assertNotNull("The active workbench page should not be null", page); //$NON-NLS-1$
		IViewPart part;
		try {
			part = page.showView("org.eclipse.ui.views.ResourceNavigator"); //$NON-NLS-1$
			IWorkbenchPartSite site = part.getSite();
			assertNotNull("The part site for org.eclipse.ui.views.ResourceNavigator should not be null ", site); //$NON-NLS-1$
			ISelectionProvider provider = site.getSelectionProvider();
			assertNotNull("the selection provider should not be null for org.eclipse.ui.views.ResourceNavigator", provider); //$NON-NLS-1$
			provider.setSelection(new StructuredSelection(resource));
		} catch (PartInitException e) {
			assertNotNull("Failed to open navigator view", null); //$NON-NLS-1$
		}
	}

	/**
	 * Tests a refresh scope of the selected resource
	 * @throws CoreException
	 */
	public void testSelectedResource() throws CoreException {
		String scope = "${resource}"; //$NON-NLS-1$
		IResource resource = getProject().getFolder("src"); //$NON-NLS-1$
		setSelection(resource);
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(resource, result[0]);
	}

	/**
	 * Tests a refresh scope of the selected resource's container
	 * @throws CoreException
	 */
	public void testSelectionsFolder() throws CoreException {
		String scope = "${container}"; //$NON-NLS-1$
		IResource resource = getProject().getFolder("src"); //$NON-NLS-1$
		setSelection(resource);
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(resource.getParent(), result[0]);
	}

	/**
	 * Tests a refresh scope of the selected resource's project
	 * @throws CoreException
	 */
	public void testSelectionsProject() throws CoreException {
		String scope = "${project}"; //$NON-NLS-1$
		IResource resource = getProject().getFolder("src"); //$NON-NLS-1$
		setSelection(resource);
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(resource.getProject(), result[0]);
	}

	/**
	 * Tests a refresh scope of the selected resource's project
	 * @throws CoreException
	 */
	public void testWorkspaceScope() throws CoreException {
		String scope = "${workspace}"; //$NON-NLS-1$
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(ResourcesPlugin.getWorkspace().getRoot(), result[0]);
	}

	/**
	 * Tests a refresh scope for a specific resource (old format)
	 * @throws CoreException
	 */
	public void testSpecificResource() throws CoreException {
		String scope = "${resource:/RefreshTabTests/some.file}"; //$NON-NLS-1$
		IResource resource = getProject().getFile("some.file"); //$NON-NLS-1$
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(resource, result[0]);
	}

	/**
	 * Tests a refresh scope for a working set
	 * @throws CoreException
	 */
	public void testWorkingSet() throws CoreException {
		String scope= "${working_set:<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<launchConfigurationWorkingSet factoryID=\"org.eclipse.ui.internal.WorkingSetFactory\" name=\"workingSet\" editPageId=\"org.eclipse.ui.resourceWorkingSetPage\">\n<item factoryID=\"org.eclipse.ui.internal.model.ResourceFactory\" path=\"/RefreshTabTests/some.file\" type=\"1\"/>\n</launchConfigurationWorkingSet>}"; //$NON-NLS-1$
		IResource resource = getProject().getFile("some.file"); //$NON-NLS-1$
		IResource[] result = RefreshTab.getRefreshResources(scope);
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(resource, result[0]);
	}

	/**
	 * Returns a scratch project for launch configurations
	 *
	 * @return
	 */
	protected IProject getProject() throws CoreException {
		IWorkspaceRoot root= ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject("RefreshTabTests"); //$NON-NLS-1$
		if (!project.exists()) {
			project = TestsPlugin.createProject("RefreshTabTests"); //$NON-NLS-1$
			IFolder folder = project.getFolder("src"); //$NON-NLS-1$
			folder.create(false, true, null);
			IFile file = project.getFile("some.file"); //$NON-NLS-1$
			file.create(new ByteArrayInputStream("test file".getBytes()), false, null); //$NON-NLS-1$
		}
		return project;
	}

	/**
	 * Tests the launch configuration attribute comparator extension for comparing
	 * old/new attribute styles.
	 *
	 * @throws CoreException
	 */
	public void testRefreshScopeComparator() throws CoreException {
		String oldStyle = "${working_set:<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<launchConfigurationWorkingSet factoryID=\"org.eclipse.ui.internal.WorkingSetFactory\" name=\"workingSet\" editPageId=\"org.eclipse.ui.resourceWorkingSetPage\">\n<item factoryID=\"org.eclipse.ui.internal.model.ResourceFactory\" path=\"/RefreshTabTests/some.file\" type=\"1\"/>\n</launchConfigurationWorkingSet>}"; //$NON-NLS-1$
		String newStyle = "${working_set:<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<resources>\n<item path=\"/RefreshTabTests/some.file\" type=\"1\"/>\n</resources>}"; //$NON-NLS-1$
		assertEquals("Comparator should return 0", 0, new RefreshScopeComparator().compare(oldStyle, newStyle)); //$NON-NLS-1$
	}

	/**
	 * Tests persist restore of some resources.
	 *
	 * @throws CoreException
	 */
	public void testResourceMemento() throws CoreException {
		IResource[] resources = new IResource[] { getProject(), getProject().getFile("not.exist"), getProject().getFile("some.file") }; //$NON-NLS-1$ //$NON-NLS-2$
		String memento = RefreshUtil.toMemento(resources);
		IResource[] restore = RefreshUtil.toResources(memento);
		assertEquals(resources.length, restore.length);
		assertEquals(resources[0], restore[0]);
		assertEquals(resources[1], restore[1]);
		assertEquals(resources[2], restore[2]);
	}

	/**
	 * Tests persist/restore of empty resource collection.
	 *
	 * @throws CoreException
	 */
	public void testEmptyResourceSet() throws CoreException {
		String memento = RefreshUtil.toMemento(new IResource[]{});
		IResource[] resources = RefreshUtil.toResources(memento);
		assertNotNull(resources);
		assertEquals("Should be empty", 0, resources.length); //$NON-NLS-1$
	}
}