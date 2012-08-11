/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * A summary over the results which is returned by a fork after executing a suite.
 * 
 * @author Rene Schneider
 * 
 */
public class ForkResultSummary {

	/**
	 * The number of successful tests.
	 */
	private int successCount;

	/**
	 * The number of failed tests.
	 */
	private int failureCount;

	/**
	 * The number of exceptions.
	 */
	private int exceptionCount;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSuccessCount
	 *            the number of successful tests
	 * @param aFailureCount
	 *            the number of failed tests
	 * @param anExceptionCount
	 *            the number of exceptions
	 */
	public ForkResultSummary(int aSuccessCount, int aFailureCount, int anExceptionCount) {
		successCount = aSuccessCount;
		failureCount = aFailureCount;
		exceptionCount = anExceptionCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public int getExceptionCount() {
		return exceptionCount;
	}

}
