/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.exceptions;

/**
 * This special runtime exception can be thrown from fixture methods in order to trigger an immediate abortion of
 * Integrity test execution. Generally, test execution is deterministic and all tests/calls must run through. Simply
 * killing the process by calling System.exit() or similar isn't such a good idea, because in that case, no test result
 * will be written, as the test runner does never reach that part of test execution. This exception is the solution for
 * this problem: just throw it from a fixture method if you want to have Integrity cancel further test execution. It
 * will also work fine if this is thrown in a fork - test execution on the master is killed as well in this case.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class AbortExecutionException extends RuntimeException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5513664766619688321L;

	/**
	 * Creates a new instance.
	 */
	public AbortExecutionException() {
		super("Aborted due to unknown reason"); // null message not allowed
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 * @param aCause
	 */
	public AbortExecutionException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 */
	public AbortExecutionException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aCause
	 */
	public AbortExecutionException(Throwable aCause) {
		super(aCause);
	}

}
