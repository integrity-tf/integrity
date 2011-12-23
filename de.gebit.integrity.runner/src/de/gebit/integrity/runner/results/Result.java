package de.gebit.integrity.runner.results;

/**
 * Abstract base class for results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class Result {

	private Long executionTime;

	public Result(Long anExecutionTime) {
		executionTime = anExecutionTime;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

}
