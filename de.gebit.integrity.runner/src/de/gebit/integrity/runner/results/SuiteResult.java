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

	/**
	 * Map of suite definitions to respective results. This map contains the setup suites.
	 */
	private Map<SuiteDefinition, Result> setupResults;

	/**
	 * Map of suite definitions to respective results. This map contains teardown suites.
	 */
	private Map<SuiteDefinition, Result> tearDownResults;

	/**
	 * Map of suite statements to results.
	 */
	private Map<SuiteStatementWithResult, Result> statementResults;

	/**
	 * Set of all results.
	 */
	private Set<Result> results;

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
	 * Creates a new instance.
	 * 
	 * @param someStatementResults
	 *            map of statements to results
	 * @param someSetupResults
	 *            map of setup suites to results
	 * @param someTearDownResults
	 *            map of teardown suites to results
	 * @param anExecutionTime
	 *            the total time to execute the whole suite
	 */
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

	/**
	 * Returns the number of failed tests in this suite and all sub-suites.
	 * 
	 * @return number of tests that failed
	 */
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

	/**
	 * Returns the number of successful tests in this suite and all sub-suites.
	 * 
	 * @return the number of successful tests
	 */
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

	/**
	 * Returns the number of tests that threw an exception in this suite and all sub-suites.
	 * 
	 * @return the number of tests throwing an exception
	 */
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
