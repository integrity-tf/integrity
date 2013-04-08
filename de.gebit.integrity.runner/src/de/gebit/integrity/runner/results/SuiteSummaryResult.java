/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results;

/**
 * This is a basic version of the {@link SuiteResult} class, which only contains the summary data. When forks return
 * from a suite execution, detailed information about the tests which were run is not available, thus this class is
 * used. If suites are run locally, more detailed info is available, in which case {@link SuiteResult} is used.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SuiteSummaryResult extends Result {

	/**
	 * Number of failed tests.
	 */
	private Integer testFailCount;

	/**
	 * Number of successful tests.
	 */
	private Integer testSuccessCount;

	/**
	 * Number of tests that threw an exception.
	 */
	private Integer testExceptionCount;

	/**
	 * Number of calls that threw an exception.
	 */
	private Integer callExceptionCount;

	/**
	 * Creates an instance.
	 * 
	 * @param anExecutionTime
	 *            the execution time
	 */
	public SuiteSummaryResult(long anExecutionTime) {
		super(anExecutionTime);
	}

	/**
	 * Creates an instance.
	 * 
	 * @param aTestSuccessCount
	 *            the number of successful tests
	 * @param aTestFailCount
	 *            the number of failed tests
	 * @param aTestExceptionCount
	 *            the number of exceptions
	 * @param anExecutionTime
	 *            the execution time
	 */
	public SuiteSummaryResult(int aTestSuccessCount, int aTestFailCount, int aTestExceptionCount,
			int aCallExceptionCount, long anExecutionTime) {
		super(anExecutionTime);
		setResultCounts(aTestSuccessCount, aTestFailCount, aTestExceptionCount, aCallExceptionCount);
	}

	/**
	 * Sets the summary information.
	 * 
	 * @param aTestSuccessCount
	 *            the number of successful tests
	 * @param aTestFailCount
	 *            the number of failed tests
	 * @param aTestExceptionCount
	 *            the number of exceptions
	 */
	protected void setResultCounts(int aTestSuccessCount, int aTestFailCount, int aTestExceptionCount,
			int aCallExceptionCount) {
		testSuccessCount = aTestSuccessCount;
		testFailCount = aTestFailCount;
		testExceptionCount = aTestExceptionCount;
		callExceptionCount = aCallExceptionCount;
	}

	public Integer getTestFailCount() {
		return testFailCount;
	}

	public Integer getTestSuccessCount() {
		return testSuccessCount;
	}

	public Integer getTestExceptionCount() {
		return testExceptionCount;
	}

	public Integer getCallExceptionCount() {
		return callExceptionCount;
	}

	/**
	 * Returns a total exception count, including tests and calls.
	 * 
	 * @return the total exception count or null if no counts are available
	 */
	public Integer getExceptionCount() {
		if (testExceptionCount != null && callExceptionCount != null) {
			return testExceptionCount + callExceptionCount;
		} else {
			return null;
		}
	}

}
