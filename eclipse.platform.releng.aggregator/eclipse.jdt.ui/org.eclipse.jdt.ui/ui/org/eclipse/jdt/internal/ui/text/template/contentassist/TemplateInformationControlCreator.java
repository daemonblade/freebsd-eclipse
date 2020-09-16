/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
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
package org.eclipse.jdt.internal.ui.text.template.contentassist;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.core.runtime.Assert;

import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlCreatorExtension;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.java.hover.SourceViewerInformationControl;


public final class TemplateInformationControlCreator implements IInformationControlCreator, IInformationControlCreatorExtension {

	private SourceViewerInformationControl fControl;

	/**
	 * The orientation to be used by this hover.
	 * Allowed values are: SWT#RIGHT_TO_LEFT or SWT#LEFT_TO_RIGHT
	 * @since 3.2
	 */
	private int fOrientation;

	/**
	 * @param orientation the orientation, allowed values are: SWT#RIGHT_TO_LEFT or SWT#LEFT_TO_RIGHT
	 */
	public TemplateInformationControlCreator(int orientation) {
		Assert.isLegal(orientation == SWT.RIGHT_TO_LEFT || orientation == SWT.LEFT_TO_RIGHT);
		fOrientation= orientation;
	}

	/*
	 * @see org.eclipse.jface.text.IInformationControlCreator#createInformationControl(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	public IInformationControl createInformationControl(Shell parent) {
		fControl= new SourceViewerInformationControl(parent, false, fOrientation, JavaPlugin.getAdditionalInfoAffordanceString());
		fControl.addDisposeListener(e -> fControl= null);
		return fControl;
	}

	/*
	 * @see org.eclipse.jface.text.IInformationControlCreatorExtension#canReuse(org.eclipse.jface.text.IInformationControl)
	 */
	@Override
	public boolean canReuse(IInformationControl control) {
		return fControl == control && fControl != null;
	}

	/*
	 * @see org.eclipse.jface.text.IInformationControlCreatorExtension#canReplace(org.eclipse.jface.text.IInformationControlCreator)
	 */
	@Override
	public boolean canReplace(IInformationControlCreator creator) {
		return (creator != null && getClass() == creator.getClass());
	}
}
