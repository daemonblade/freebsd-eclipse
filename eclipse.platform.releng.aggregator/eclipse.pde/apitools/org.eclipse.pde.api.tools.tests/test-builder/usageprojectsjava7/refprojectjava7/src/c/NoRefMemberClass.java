/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
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
package c;

/**
 * @noreference This class is not intended to be referenced by clients
 */
public class NoRefMemberClass {

	public static class Inner {
		
		public Inner() {
			
		}
		
		public String fNoRefMemberClassField = "one";
		
		public void noRefMemberClassMethod() {
			
		}
	}
	
}
