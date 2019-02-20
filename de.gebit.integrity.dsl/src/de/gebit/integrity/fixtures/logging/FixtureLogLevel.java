/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures.logging;

/**
 * Log levels for log output of Integrity fixture code.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public enum FixtureLogLevel {

	/**
	 * Errors are incidents that make it impossible for the fixture to perform its job correctly. Note that you should
	 * most likely throw an exception in such a case, which then results in a very visible stack trace being logged into
	 * the test result. However, it may be useful to provide additional information (more than is practical in an
	 * exception message) to deal with the problem in the form of ERROR log messages before finishing fixture execution
	 * by throwing the exception.
	 */
	ERROR(4, "  "),

	/**
	 * Warnings should still result in successful fixture execution, but indicate some kind of "soft problem" that
	 * appeared while doing the job and that the fixture code dealt with successfully. Fallbacks in the code are a
	 * typical example for this.
	 */
	WARNING(3, ""),

	/**
	 * Info messages are just that - information to the fixture or test author, exposing some kind of internal data that
	 * might be useful to write tests.
	 */
	INFO(2, "   "),

	/**
	 * Debug log output is intended for fixture developers and may be used to expose detailed internal information
	 * useful to diagnose problems with a fixture. The debug level is by default the finest level that is actually being
	 * captured into test results.
	 */
	DEBUG(1, "  "),

	/**
	 * Trace log output should be extremely detailed information about fixture internals that is NOT usually needed to
	 * diagnose problems with a fixture, but that MAY be useful in specific circumstances. Capturing trace log lines is
	 * disabled by default, because it is expected that trace log data is large in volume and of limited general use.
	 */
	TRACE(0, "  ");

	/**
	 * The numeric level used to compare log levels.
	 */
	private int numericLevel;

	/**
	 * Adds necessary padding to bring this levels' name string to the same width as the others.
	 */
	private String paddedName;

	/**
	 * Constructor.
	 * 
	 * @param aNumericLevel
	 */
	FixtureLogLevel(int aNumericLevel, String aPadding) {
		numericLevel = aNumericLevel;
		paddedName = name() + aPadding;
	}

	/**
	 * Whether the level this is called upon is finer than the given log level.
	 * 
	 * @param anOtherLevel
	 *            the level to compare with
	 * @return true if this level is finer than the provided one
	 */
	public boolean isFinerThan(FixtureLogLevel anOtherLevel) {
		return numericLevel < anOtherLevel.numericLevel;
	}

	/**
	 * Whether the level this is called upon is finer than the given log level or equals it.
	 * 
	 * @param anOtherLevel
	 *            the level to compare with
	 * @return true if this level is finer than the provided one or equals it
	 */
	public boolean isEqualOrFinerThan(FixtureLogLevel anOtherLevel) {
		return numericLevel <= anOtherLevel.numericLevel;
	}

	public String getPaddedName() {
		return paddedName;
	}

}
