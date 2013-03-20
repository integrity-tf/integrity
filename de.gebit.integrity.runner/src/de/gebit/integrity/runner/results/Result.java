/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results;

/**
 * Abstract base class for results.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class Result {

	/**
	 * The execution time of the test/call.
	 */
	private Long executionTime;

	/**
	 * Creates a new instance.
	 * 
	 * @param anExecutionTime
	 *            the execution time
	 */
	public Result(Long anExecutionTime) {
		executionTime = anExecutionTime;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

}
