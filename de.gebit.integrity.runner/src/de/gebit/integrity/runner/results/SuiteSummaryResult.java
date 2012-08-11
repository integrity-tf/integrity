/**
 * 
 */
package de.gebit.integrity.runner.results;

/**
 * This is a basic version of the {@link SuiteResult} class, which only contains the summary data. When forks return
 * from a suite execution, detailed information about the tests which were run is not available, thus this class is
 * used. If suites are run locally, more detailed info is available, in which case {@link SuiteResult} is used.
 * 
 * @author Rene Schneider
 * 
 */
public class SuiteSummaryResult extends Result {

	/**
	 * Number of failed tests. Calculated on demand.
	 */
	private Integer testFailCount;

	/**
	 * Number of successful tests. Calculated on demand.
	 */
	private Integer testSuccessCount;

	/**
	 * Number of tests that threw an exception. Calculated on demand.
	 */
	private Integer testExceptionCount;

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
	public SuiteSummaryResult(int aTestSuccessCount, int aTestFailCount, int aTestExceptionCount, long anExecutionTime) {
		super(anExecutionTime);
		setResultCounts(aTestSuccessCount, aTestFailCount, aTestExceptionCount);
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
	protected void setResultCounts(int aTestSuccessCount, int aTestFailCount, int aTestExceptionCount) {
		testSuccessCount = aTestSuccessCount;
		testFailCount = aTestFailCount;
		testExceptionCount = aTestExceptionCount;
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

}
