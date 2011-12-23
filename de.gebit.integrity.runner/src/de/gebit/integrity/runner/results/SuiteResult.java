package de.gebit.integrity.runner.results;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.runner.results.test.TestResult;

/**
 * Result of a suite call.
 * 
 * 
 * @author Rene Schneider
 * 
 */
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

	public int getTestFailCount() {
		if (testFailCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestFailCount();
				} else if (tempResult instanceof TestResult) {
					tempCount += ((TestResult) tempResult).getSubTestFailCount();
				}
			}
			testFailCount = tempCount;
		}

		return testFailCount;
	}

	public int getTestSuccessCount() {
		if (testSuccessCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestSuccessCount();
				} else if (tempResult instanceof TestResult) {
					tempCount += ((TestResult) tempResult).getSubTestSuccessCount();
				}
			}
			testSuccessCount = tempCount;
		}

		return testSuccessCount;
	}

	public int getTestExceptionCount() {
		if (testExceptionCount == null) {
			int tempCount = 0;
			for (Result tempResult : results) {
				if (tempResult instanceof SuiteResult) {
					tempCount += ((SuiteResult) tempResult).getTestExceptionCount();
				} else if (tempResult instanceof TestResult) {
					tempCount += ((TestResult) tempResult).getSubTestExceptionCount();
				}
			}
			testExceptionCount = tempCount;
		}

		return testExceptionCount;
	}

}
