package de.gebit.integrity.remoting.entities.setlist;

/**
 * The various types of set list entries.
 * 
 * @author Rene Schneider
 * 
 */
public enum SetListEntryTypes {

	/**
	 * The root entry.
	 */
	EXECUTION,

	/**
	 * Definition of variables.
	 */
	VARIABLE,

	/**
	 * Suite call.
	 */
	SUITE,

	/**
	 * Setup suite call.
	 */
	SETUP,

	/**
	 * Teardown suite call.
	 */
	TEARDOWN,

	/**
	 * Test execution.
	 */
	TEST,

	/**
	 * Table test execution.
	 */
	TABLETEST,

	/**
	 * Call execution.
	 */
	CALL,

	/**
	 * Test/Call result.
	 */
	RESULT,

	/**
	 * Parameter definition.
	 */
	PARAMETER,

	/**
	 * Test comparison.
	 */
	COMPARISON;

}
