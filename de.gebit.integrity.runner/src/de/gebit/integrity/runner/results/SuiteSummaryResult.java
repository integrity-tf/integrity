/**
 * 
 */
package de.gebit.integrity.runner.results;

/**
 * 
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

	public SuiteSummaryResult(long anExecutionTime) {
		super(anExecutionTime);
	}

	public SuiteSummaryResult(int aTestSuccessCount, int aTestFailCount, int aTestExceptionCount, long anExecutionTime) {
		super(anExecutionTime);
		setResultCounts(aTestSuccessCount, aTestFailCount, aTestExceptionCount);
	}

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
