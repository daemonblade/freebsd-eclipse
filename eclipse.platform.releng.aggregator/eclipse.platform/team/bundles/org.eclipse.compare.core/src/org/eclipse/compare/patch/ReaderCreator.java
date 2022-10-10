/*******************************************************************************
 * Copyright (c) 2009, 2011 IBM Corporation and others.
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
package org.eclipse.compare.patch;

import java.io.Reader;

import org.eclipse.core.runtime.CoreException;

/**
 * Abstract class for creating readers.
 *
 * @since org.eclipse.compare.core 3.5
 */
public abstract class ReaderCreator {

	/**
	 * Creates new reader. The caller is responsible for closing the reader when
	 * finished.
	 *
	 * @return a reader
	 * @exception CoreException
	 *                if the reader can't be created
	 */
	public abstract Reader createReader() throws CoreException;

	/**
	 * Returns whether the reader can be created.
	 *
	 * @return true if the reader can be created, false otherwise
	 */
	public boolean canCreateReader() {
		return true;
	}
}
