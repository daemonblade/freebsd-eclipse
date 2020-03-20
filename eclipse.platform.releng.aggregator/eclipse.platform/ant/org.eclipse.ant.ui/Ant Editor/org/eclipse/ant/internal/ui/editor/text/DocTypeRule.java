/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
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

package org.eclipse.ant.internal.ui.editor.text;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

public class DocTypeRule extends MultiLineRule {

	private int fEmbeddedStart = 0;

	public DocTypeRule(IToken token) {
		super("<!DOCTYPE", ">", token); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	protected boolean endSequenceDetected(ICharacterScanner scanner) {
		int c;
		while ((c = scanner.read()) != ICharacterScanner.EOF) {
			if (c == fEscapeCharacter) {
				// Skip the escaped character.
				scanner.read();
			} else if (c == '<') {
				fEmbeddedStart++;
			} else if (c == '>') {
				if (fEmbeddedStart == 0) {
					return true;
				}
				fEmbeddedStart--;
			}
		}

		scanner.unread();
		return false;
	}
}