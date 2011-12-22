package de.gebit.integrity.remoting.entities.setlist;

/**
 * Result states for set list entries.
 * 
 * @author Rene Schneider
 * 
 */
public enum SetListEntryResultStates {

	/**
	 * The test/call has not yet been executed and is thus undetermined.
	 */
	UNKNOWN,

	/**
	 * The test/call has been finished successfully.
	 */
	SUCCESSFUL,

	/**
	 * The test has failed.
	 */
	FAILED,

	/**
	 * An exception has occurred.
	 */
	EXCEPTION;

}
