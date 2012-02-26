package de.gebit.integrity.runner.results.test;

import java.util.List;

import de.gebit.integrity.runner.results.Result;

/**
 * Base class for test results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestResult extends Result {

	/**
	 * All sub-results of this test.
	 */
	private List<TestSubResult> subResults;

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
	 * @param anExecutionTime
	 *            test method execution time
	 */
	public TestResult(List<TestSubResult> someSubResults, Long anExecutionTime) {
		super(anExecutionTime);
		subResults = someSubResults;
	}

	public List<TestSubResult> getSubResults() {
		return subResults;
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
			subTestExceptionCount = tempCount;
		}

		return subTestExceptionCount;
	}

}
