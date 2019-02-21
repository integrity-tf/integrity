/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.fixtures.PostInvocationTestFixture;

/**
 * A simple test fixture which does nothing (except echoing some input). Is a {@link PostInvocationTestFixture}.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class PostInvocationNoOpFixture implements PostInvocationTestFixture {

	private int sum;

	@FixtureMethod(description = "Echoes a number")
	public Integer echoNumber(@FixtureParameter(name = "echo") Integer anInput) {
		sum += anInput;

		return anInput;
	}

	@Override
	public String performPostInvocationTest() {
		if (sum == 0) {
			// If the numbers add up to zero, consider this a success.
			return null;
		} else if (sum > 0) {
			// If the numbers add up to something greater than zero, consider it a test failure and return a failure
			// message.
			return "The sum is greater than zero!";
		} else {
			// If the numbers add up to something below zero, throw an exception.
			throw new RuntimeException("The sum is lower than 0!");
		}
	}

}
