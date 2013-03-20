/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.call;

import java.util.List;

/**
 * Result used for undetermined calls.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class UndeterminedResult extends CallResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param someVariablesToUpdate
	 *            any variables to be updated by the call
	 * @param aFixtureMethod
	 *            the method that was executed
	 */
	public UndeterminedResult(List<UpdatedVariable> someVariablesToUpdate, String aFixtureMethod) {
		super(someVariablesToUpdate, null, aFixtureMethod, null);
	}
}
