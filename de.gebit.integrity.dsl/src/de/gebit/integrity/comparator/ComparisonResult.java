/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.comparator;

/**
 * Base interface for comparison results.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ComparisonResult {

	/**
	 * Whether this result documents a successful comparison. Most of the time, this boils down to whether the result
	 * equals the expected value, but custom comparator fixtures may override this.
	 * 
	 * @return
	 */
	boolean isSuccessful();

}
