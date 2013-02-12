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
	 * The number of exceptions in tests.
	 */
	private int testExceptionCount;

	/**
	 * The number of exceptions in calls.
	 */
	private int callExceptionCount;

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
	public ForkResultSummary(int aSuccessCount, int aFailureCount, int aTestExceptionCount, int aCallExceptionCount) {
		successCount = aSuccessCount;
		failureCount = aFailureCount;
		testExceptionCount = aTestExceptionCount;
		callExceptionCount = aCallExceptionCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public int getExceptionCount() {
		return testExceptionCount + callExceptionCount;
	}

	public int getTestExceptionCount() {
		return testExceptionCount;
	}

	public int getCallExceptionCount() {
		return callExceptionCount;
	}
}
