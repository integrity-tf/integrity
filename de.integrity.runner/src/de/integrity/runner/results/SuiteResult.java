package de.integrity.runner.results;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.SuiteStatementWithResult;
import de.integrity.runner.results.test.ExceptionResult;
import de.integrity.runner.results.test.FailureResult;
import de.integrity.runner.results.test.SuccessResult;

public class SuiteResult extends Result {

	private Map<SuiteDefinition, Result> setupResults;

	private Map<SuiteDefinition, Result> tearDownResults;

	private Map<SuiteStatementWithResult, Result> statementResults;

	private Set<Result> results;

	private Integer testFailCount;

	private Integer testSuccessCount;

	private Integer testExceptionCount;

	public SuiteResult(Map<SuiteStatementWithResult, Result> someStatementResults,
			Map<SuiteDefinition, Result> someSetupResults, Map<SuiteDefinition, Result> someTearDownResults,
			Long anExecutionTime) {
		super(anExecutionTime);
		statementResults = someStatementResults;
		results = new HashSet<Result>(statementResults.values());
		if (someSetupResults == null) {
			setupResults = new HashMap<SuiteDefinition, Result>();
		} else {
			setupResults = someSetupResults;
			results.addAll(setupResults.values());
		}
		if (someTearDownResults == null) {
			tearDownResults = new HashMap<SuiteDefinition, Result>();
		} else {
			tearDownResults = someTearDownResults;
			results.addAll(tearDownResults.values());
		}
	}

	public Map<SuiteStatementWithResult, Result> getResults() {
		return statementResults;
	}

	public Map<SuiteDefinition, Result> getSetupResults() {
		return setupResults;
	}

	public Map<SuiteDefinition, Result> getTearDownResults() {
		return tearDownResults;
	}

	public Integer getTestFailCount() {
		if (testFailCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestFailCount();
				} else if (tempResult instanceof FailureResult) {
					tempCount++;
				}
			}
			testFailCount = tempCount;
		}

		return testFailCount;
	}

	public Integer getTestSuccessCount() {
		if (testSuccessCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestSuccessCount();
				} else if (tempResult instanceof SuccessResult) {
					tempCount++;
				}
			}
			testSuccessCount = tempCount;
		}

		return testSuccessCount;
	}

	public Integer getTestExceptionCount() {
		if (testExceptionCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestExceptionCount();
				} else if (tempResult instanceof ExceptionResult) {
					tempCount++;
				}
			}
			testExceptionCount = tempCount;
		}

		return testExceptionCount;
	}

}
