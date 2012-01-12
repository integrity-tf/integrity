package de.gebit.integrity.remoting.transport.enums;

import java.io.Serializable;

/**
 * Execution states.
 * 
 * @author Rene Schneider
 * 
 */
public enum ExecutionStates implements Serializable {

	/**
	 * The execution is blocked (waiting to be started).
	 */
	BLOCKED,

	/**
	 * The execution is in progress.
	 */
	RUNNING,

	/**
	 * Execution is paused.
	 */
	PAUSED,

	/**
	 * Execution is paused while waiting for the master to perform its next steps and then return to the fork.
	 */
	PAUSED_SYNC,

	/**
	 * Execution has ended.
	 */
	ENDED;

}
