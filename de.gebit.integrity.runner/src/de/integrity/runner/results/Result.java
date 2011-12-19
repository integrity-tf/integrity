package de.integrity.runner.results;

public abstract class Result {

	private Long executionTime;

	public Result(Long anExecutionTime) {
		executionTime = anExecutionTime;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

}
