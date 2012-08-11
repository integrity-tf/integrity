package de.gebit.integrity.runner.results;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
public class SuiteResult extends SuiteSummaryResult {

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
	private Map<SuiteStatementWithResult, List<? extends Result>> statementResults;

	/**
	 * Set of all results.
	 */
	private Set<Result> results;

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
	public SuiteResult(Map<SuiteStatementWithResult, List<? extends Result>> someStatementResults,
			Map<SuiteDefinition, Result> someSetupResults, Map<SuiteDefinition, Result> someTearDownResults,
			Long anExecutionTime) {
		super(anExecutionTime);
		statementResults = someStatementResults;
		results = new HashSet<Result>();
		for (List<? extends Result> tempResultList : statementResults.values()) {
			results.addAll(tempResultList);
		}
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

		// Counts are calculated and saved immediately.
		int tempSuccessCount = 0;
		int tempFailCount = 0;
		int tempExceptionCount = 0;
		for (Result tempResult : results) {
			if (tempResult instanceof SuiteResult) {
				tempSuccessCount += ((SuiteResult) tempResult).getTestSuccessCount();
				tempFailCount += ((SuiteResult) tempResult).getTestFailCount();
				tempExceptionCount += ((SuiteResult) tempResult).getTestExceptionCount();
			} else if (tempResult instanceof SuiteSummaryResult) {
				tempSuccessCount += ((SuiteSummaryResult) tempResult).getTestSuccessCount();
				tempFailCount += ((SuiteSummaryResult) tempResult).getTestFailCount();
				tempExceptionCount += ((SuiteSummaryResult) tempResult).getTestExceptionCount();
			} else if (tempResult instanceof TestResult) {
				tempSuccessCount += ((TestResult) tempResult).getSubTestSuccessCount();
				tempFailCount += ((TestResult) tempResult).getSubTestFailCount();
				tempExceptionCount += ((TestResult) tempResult).getSubTestExceptionCount();
			}
		}

		setResultCounts(tempSuccessCount, tempFailCount, tempExceptionCount);
	}

	public Map<SuiteStatementWithResult, List<? extends Result>> getResults() {
		return statementResults;
	}

	public Map<SuiteDefinition, Result> getSetupResults() {
		return setupResults;
	}

	public Map<SuiteDefinition, Result> getTearDownResults() {
		return tearDownResults;
	}

}
