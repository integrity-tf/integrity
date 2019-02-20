/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import com.google.inject.Inject;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.fixtures.logging.FixtureLogLevel;
import de.gebit.integrity.fixtures.logging.FixtureLogger;
import de.gebit.integrity.runner.logging.DefaultFixtureLogger;

/**
 * A simple test fixture which does nothing (except echoing some input). Logs stuff.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class FixtureLogNoOpFixture {

	@Inject
	private FixtureLogger logger;

	@FixtureMethod(description = "Echo the integer '$integer$'")
	public Integer echoInteger(@FixtureParameter(name = "integer") Integer anIntToEcho) {
		if (anIntToEcho < 0) {
			// do nothing
		} else if (anIntToEcho < FixtureLogLevel.values().length) {
			logger.log(FixtureLogLevel.values()[anIntToEcho], "This is some simple log output");
		} else if (anIntToEcho == 9) {
			logger.trace("This is some trace log output that should NOT be visible");
			((DefaultFixtureLogger) logger).setThresholdLevel(FixtureLogLevel.TRACE);
			logger.trace("This is some trace log output that should be visible");
			((DefaultFixtureLogger) logger).setThresholdLevel(FixtureLogLevel.DEBUG);
			logger.trace("This is some trace log output that should NOT be visible");
		} else if (anIntToEcho == 10) {
			logger.info("Here is a log message with a parameter: {}", anIntToEcho);
		} else if (anIntToEcho == 11) {
			logger.info("Here is a log message with two parameters: {} and {}", null, "blah");
		} else if (anIntToEcho == 12) {
			logger.info("Here is a log message with two parameters, but the second is not provided: {} and {}",
					anIntToEcho);
		} else if (anIntToEcho == 13) {
			logger.info("Here is a log message with an array parameter: {}", new int[] { 1, 2, 3 });
		} else if (anIntToEcho == 20) {
			logger.warn("This is Fixture Log output");
			System.out.println("And this is standard output");
			System.err.println("And this is standard error");
			logger.info("And this is some more Fixture Log output");
		}

		return anIntToEcho;
	}

}
