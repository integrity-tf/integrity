package de.gebit.integrity.remoting.entities.setlist;

/**
 * Keys for Set List Entry Attributes.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
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
	 * Names of variables.
	 */
	VARIABLE_NAME,

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
	EXCEPTION_COUNT,

	/**
	 * The result of a test or call.
	 */
	RESULT,

	/**
	 * The expected result.
	 */
	EXPECTED_RESULT,

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
	COMPARISONS;

}
