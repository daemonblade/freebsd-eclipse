/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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
package org.eclipse.jdt.internal.ui.javaeditor.breadcrumb;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.jface.viewers.ISelectionProvider;


/**
 * Implementors can provide a breadcrumb inside an editor.
 *
 * <p>Clients should not implement this interface. They should
 * subclass {@link EditorBreadcrumb} instead if possible</p>
 *
 * @since 3.4
 */
public interface IBreadcrumb {

	/**
	 * Create breadcrumb content.
	 *
	 * @param parent the parent of the content
	 * @return the control containing the created content
	 */
	Control createContent(Composite parent);

	/**
	 * Returns the selection provider for this breadcrumb.
	 *
	 * @return the selection provider for this breadcrumb
	 */
	ISelectionProvider getSelectionProvider();

	/**
	 * Activates the breadcrumb. This sets the keyboard focus
	 * inside this breadcrumb and retargets the editor
	 * actions.
	 */
	void activate();

	/**
	 * A breadcrumb is active if it either has the focus or another workbench part has the focus and
	 * the breadcrumb had the focus before the other workbench part was made active.
	 *
	 * @return <code>true</code> if this breadcrumb is active
	 */
	boolean isActive();

	/**
	 * Set the input of the breadcrumb to the given element
	 *
	 * @param element the input element can be <code>null</code>
	 */
	void setInput(Object element);

	/**
	 * Dispose all resources hold by this breadcrumb.
	 */
	void dispose();

}
