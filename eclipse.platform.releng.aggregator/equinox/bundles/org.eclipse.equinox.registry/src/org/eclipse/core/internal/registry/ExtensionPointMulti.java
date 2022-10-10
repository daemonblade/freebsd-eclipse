/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
package org.eclipse.core.internal.registry;

/**
 * A multi-language version of the ExtensionPoint
 */
public class ExtensionPointMulti extends ExtensionPoint {

	protected ExtensionPointMulti(ExtensionRegistry registry, boolean persist) {
		super(registry, persist);
	}

	protected ExtensionPointMulti(int self, int[] children, int dataOffset, ExtensionRegistry registry, boolean persist) {
		super(self, children, dataOffset, registry, persist);
	}

	@Override
	protected String getLabel(String locale) {
		// this method call should be fairly rare, so no caching to save on memory
		String[] translated = registry.translate(new String[] {getLabelAsIs()}, getContributor(), locale);
		return translated[0];
	}

	@Override
	protected String getLabel() {
		return getLabel(getLocale());
	}
}
