package de.gebit.integrity.remoting.transport.enums;

import java.io.Serializable;

/**
 * Valid commands for test execution control.
 * 
 * @author Rene Schneider
 * 
 */
public enum ExecutionCommands implements Serializable {

	/**
	 * Run/continue the test.
	 */
	RUN,

	/**
	 * Pause test execution.
	 */
	PAUSE,

	/**
	 * Single-step.
	 */
	STEP_INTO;

}
