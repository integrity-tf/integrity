/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * A summary over the results which is returned by a fork after executing a suite.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ForkResultSummaryMessage extends AbstractMessage {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 1842516084352748530L;

	/**
	 * The number of successful tests.
	 */
	private Integer successCount;

	/**
	 * The number of failed tests.
	 */
	private Integer failureCount;

	/**
	 * The number of exceptions in tests.
	 */
	private Integer testExceptionCount;

	/**
	 * The number of exceptions in calls.
	 */
	private Integer callExceptionCount;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSuccessCount
	 *            the number of successful tests
	 * @param aFailureCount
	 *            the number of failed tests
	 * @param aTestExceptionCount
	 *            the number of exceptions in tests
	 * @param aCallExceptionCount
	 *            the number of call exceptions in tests
	 */
	public ForkResultSummaryMessage(Integer aSuccessCount, Integer aFailureCount, Integer aTestExceptionCount,
			Integer aCallExceptionCount) {
		successCount = aSuccessCount;
		failureCount = aFailureCount;
		testExceptionCount = aTestExceptionCount;
		callExceptionCount = aCallExceptionCount;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public ForkResultSummaryMessage() {
		// no-arg constructor
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public Integer getFailureCount() {
		return failureCount;
	}

	public Integer getTestExceptionCount() {
		return testExceptionCount;
	}

	public Integer getCallExceptionCount() {
		return callExceptionCount;
	}
}
