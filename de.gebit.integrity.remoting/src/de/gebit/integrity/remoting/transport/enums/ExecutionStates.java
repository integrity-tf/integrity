package de.gebit.integrity.remoting.transport.enums;

import java.io.Serializable;

/**
 * Execution states.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
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
	 * Execution has ended.
	 */
	ENDED;

}
