/*******************************************************************************
 * Copyright (c) 2008, 2009 IBM Corporation and others.
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
package a.b.c;

/**
 * Tests invalid @noreference tags on nested inner interfaces
 * @noreference
 */
public interface test9 {

	/**
	 * @noreference
	 */
	interface inner {
		
	}
	
	interface inner1 {
		/**
		 * @noreference
		 */
		interface inner2 {
			
		}
	}
	
	interface inner2 {
		
	}
}

interface outer {
	
	/**
	 * @noreference
	 */
	interface InnerNoRef4 {
		
	}
}
