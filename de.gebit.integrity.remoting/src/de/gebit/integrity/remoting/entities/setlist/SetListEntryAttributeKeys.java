/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.entities.setlist;

/**
 * Keys for Set List Entry Attributes.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum SetListEntryAttributeKeys {

	/**
	 * The reference to the parent entry.
	 */
	PARENT,

	/**
	 * Names, like suite/test/call names.
	 */
	NAME,

	/**
	 * Test or call description texts.
	 */
	DESCRIPTION,

	/**
	 * Result values / variable values.
	 */
	VALUE,

	/**
	 * Comment type.
	 */
	TYPE,

	/**
	 * Names of variables.
	 */
	VARIABLE_NAME,

	/**
	 * Parameter name.
	 */
	PARAMETER_NAME,

	/**
	 * The fully qualified fixture class and method name.
	 */
	FIXTURE,

	/**
	 * Definitions of variables.
	 */
	VARIABLE_DEFINITIONS,

	/**
	 * References to the actual statements in a suite.
	 */
	STATEMENTS,

	/**
	 * References to suites performed for setup.
	 */
	SETUP,

	/**
	 * References to suites performed for teardown.
	 */
	TEARDOWN,

	/**
	 * The time required to execute a suite/call/test.
	 */
	EXECUTION_TIME,

	/**
	 * Number of successful tests.
	 */
	SUCCESS_COUNT,

	/**
	 * Number of failed tests.
	 */
	FAILURE_COUNT,

	/**
	 * Number of exceptions.
	 */
	TEST_EXCEPTION_COUNT,

	/**
	 * Number of exceptions in calls.
	 */
	CALL_EXCEPTION_COUNT,

	/**
	 * The result of a test or call.
	 */
	RESULT,

	/**
	 * The expected result.
	 */
	EXPECTED_RESULT,

	/**
	 * Extended result data. This may be images (compressed byte arrays) or strings.
	 */
	EXTENDED_RESULT_DATA,

	/**
	 * Post invocation result data. See {@link PostInvocationTestFixture} for details.
	 */
	FINALIZATION_TEST_RESULT,

	/**
	 * Post invocation exception data. See {@link PostInvocationTestFixture} for details.
	 */
	FINALIZATION_TEST_EXCEPTION,

	/**
	 * Whether a test/call was successful.
	 */
	RESULT_SUCCESS_FLAG,

	/**
	 * The exception stacktrace.
	 */
	EXCEPTION,

	/**
	 * References to the parameters.
	 */
	PARAMETERS,

	/**
	 * References to the comparisons.
	 */
	COMPARISONS,

	/**
	 * Name of the fork a suite is executed on.
	 */
	FORK_NAME,

	/**
	 * Description of the fork a suite is executed on.
	 */
	FORK_DESCRIPTION,

	/**
	 * Updates of variables after a call.
	 */
	VARIABLE_UPDATES,

	/**
	 * A link to the test script (suite and optionally line).
	 */
	LINK,

	/**
	 * Fixture log output (as a multi-line string).
	 */
	FIXTURE_LOG;

}
