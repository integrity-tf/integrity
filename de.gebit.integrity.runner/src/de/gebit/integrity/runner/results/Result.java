package de.gebit.integrity.runner.results;

/**
 * Abstract base class for results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class Result {

	/**
	 * The execution time of the test/call.
	 */
	private Long executionTime;

	/**
	 * Creates a new instance.
	 * 
	 * @param anExecutionTime
	 *            the execution time
	 */
	public Result(Long anExecutionTime) {
		executionTime = anExecutionTime;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

}
