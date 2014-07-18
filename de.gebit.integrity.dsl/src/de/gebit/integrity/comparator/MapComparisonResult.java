/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.comparator;

import java.util.Set;

/**
 * A comparison result of a map comparison. Contains additional information about the exact location of comparison
 * failures.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class MapComparisonResult extends SimpleComparisonResult {

	/**
	 * Paths in the map structure that failed during comparison.
	 */
	private Set<String> failedPaths;

	/**
	 * Constructor.
	 */
	public MapComparisonResult(boolean aValue, Set<String> someFailedPaths) {
		super(aValue);
		failedPaths = someFailedPaths;
	}

	public Set<String> getFailedPaths() {
		return failedPaths;
	}

}
