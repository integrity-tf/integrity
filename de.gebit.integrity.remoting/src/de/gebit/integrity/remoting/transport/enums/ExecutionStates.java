/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.enums;

import java.io.Serializable;

/**
 * Execution states.
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * Execution has finished, but stuff is being finalized (results written, transformed et cetera).
	 */
	FINALIZING,

	/**
	 * Execution has ended.
	 */
	ENDED;

}
