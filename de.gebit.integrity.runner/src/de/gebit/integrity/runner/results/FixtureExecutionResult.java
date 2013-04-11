/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results;

import de.gebit.integrity.fixtures.FixtureWrapper;

/**
 * Base class for results which are based on the execution of a fixture method.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class FixtureExecutionResult extends Result {

	/**
	 * The (wrapped) fixture instance that defines the action which was executed.
	 */
	private FixtureWrapper<?> fixtureInstance;

	/**
	 * The name of the executed fixture method.
	 */
	private String fixtureMethod;

	/**
	 * Creates a new instance.
	 * 
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            The time required for execution
	 */
	public FixtureExecutionResult(FixtureWrapper<?> aFixtureInstance, String aFixtureMethod, Long anExecutionTime) {
		super(anExecutionTime);
		fixtureInstance = aFixtureInstance;
		fixtureMethod = aFixtureMethod;
	}

	public FixtureWrapper<?> getFixtureInstance() {
		return fixtureInstance;
	}

	public String getFixtureMethod() {
		return fixtureMethod;
	}

}
