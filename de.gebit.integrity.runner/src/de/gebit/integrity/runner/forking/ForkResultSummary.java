/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ForkResultSummary {

	private int successCount;

	private int failureCount;

	private int exceptionCount;

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
