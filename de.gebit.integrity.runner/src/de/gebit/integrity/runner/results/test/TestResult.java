/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.test;

import java.util.List;

import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.fixtures.PostInvocationTestFixture;
import de.gebit.integrity.runner.results.FixtureExecutionResult;

/**
 * Base class for test results.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestResult extends FixtureExecutionResult {

	/**
	 * All sub-results of this test.
	 */
	private List<TestSubResult> subResults;

	/**
	 * The post-invocation test result, if one was obtained. See {@link PostInvocationTestFixture} for details.
	 */
	private TestSubResult postInvocationTestResult;

	/**
	 * Number of successful sub-tests. Calculated on demand.
	 */
	private Integer subTestSuccessCount;

	/**
	 * Number of failed sub-tests. Calculated on demand.
	 */
	private Integer subTestFailCount;

	/**
	 * Number of sub-tests that ended with an exception. Calculated on demand.
	 */
	private Integer subTestExceptionCount;

	/**
	 * Creates a new instance.
	 * 
	 * @param someSubResults
	 *            sub-results of this test
	 * @param aPostInvocationTestResult
	 *            The post-invocation test result, if one was obtained. See {@link PostInvocationTestFixture} for
	 *            details.
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            test method execution time
	 * @param someExtendedResults
	 *            any extended results returned from the fixture
	 */
	public TestResult(List<TestSubResult> someSubResults, TestSubResult aPostInvocationTestResult,
			FixtureWrapper<?> aFixtureInstance, String aFixtureMethod, Long anExecutionTime,
			List<ExtendedResult> someExtendedResults) {
		super(aFixtureInstance, aFixtureMethod, anExecutionTime, someExtendedResults);
		subResults = someSubResults;
		postInvocationTestResult = aPostInvocationTestResult;
	}

	public List<TestSubResult> getSubResults() {
		return subResults;
	}

	public TestSubResult getPostInvocationTestResult() {
		return postInvocationTestResult;
	}

	/**
	 * Returns the number of successful sub-tests.
	 * 
	 * @return
	 */
	public int getSubTestSuccessCount() {
		if (subTestSuccessCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if ((tempSubResult instanceof TestExecutedSubResult) && tempSubResult.wereAllComparisonsSuccessful()) {
					tempCount++;
				}
			}

			if (postInvocationTestResult instanceof TestExecutedSubResult
					&& postInvocationTestResult.wereAllComparisonsSuccessful()) {
				tempCount++;
			}

			subTestSuccessCount = tempCount;
		}

		return subTestSuccessCount;
	}

	/**
	 * Returns the number of failed sub-tests.
	 * 
	 * @return
	 */
	public int getSubTestFailCount() {
		if (subTestFailCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if ((tempSubResult instanceof TestExecutedSubResult) && !tempSubResult.wereAllComparisonsSuccessful()) {
					tempCount++;
				}
			}

			if (postInvocationTestResult instanceof TestExecutedSubResult
					&& !postInvocationTestResult.wereAllComparisonsSuccessful()) {
				tempCount++;
			}

			subTestFailCount = tempCount;
		}

		return subTestFailCount;
	}

	/**
	 * Returns the number of sub-tests that threw an exception.
	 * 
	 * @return
	 */
	public int getSubTestExceptionCount() {
		if (subTestExceptionCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if (tempSubResult instanceof TestExceptionSubResult) {
					tempCount++;
				}
			}

			if (postInvocationTestResult instanceof TestExceptionSubResult) {
				tempCount++;
			}

			subTestExceptionCount = tempCount;
		}

		return subTestExceptionCount;
	}

}
