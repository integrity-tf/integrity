/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import java.util.Optional;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * A simple test fixture which provides methods using {@link Optional}.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class OptionalTestFixture {

	@FixtureMethod(description = "Echoes a number (maybe...only if it is even!)")
	public Optional<Integer> echoNumber(@FixtureParameter(name = "number") Integer anInput) {
		if (anInput == null) {
			// In case of "null", we return "null". This is deliberate, so we can also test on "null" vs. "inexistent".
			return null;
		} else if (anInput % 2 == 0) {
			return Optional.of(anInput);
		} else {
			return Optional.empty();
		}
	}

}
