package de.gebit.integrity.runner.results.test;

import java.util.List;

import de.gebit.integrity.runner.results.Result;

/**
 * Base class for test results.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestResult extends Result {

	private List<TestSubResult> subResults;

	private Integer subTestSuccessCount;

	private Integer subTestFailCount;

	private Integer subTestExceptionCount;

	public TestResult(List<TestSubResult> someSubResults, Long anExecutionTime) {
		super(anExecutionTime);
		subResults = someSubResults;
	}

	public List<TestSubResult> getSubResults() {
		return subResults;
	}

	public int getSubTestSuccessCount() {
		if (subTestSuccessCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if ((tempSubResult instanceof TestExecutedSubResult) && tempSubResult.wereAllComparisonsSuccessful()) {
					tempCount++;
				}
			}
			subTestSuccessCount = tempCount;
		}

		return subTestSuccessCount;
	}

	public int getSubTestFailCount() {
		if (subTestFailCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if ((tempSubResult instanceof TestExecutedSubResult) && !tempSubResult.wereAllComparisonsSuccessful()) {
					tempCount++;
				}
			}
			subTestFailCount = tempCount;
		}

		return subTestFailCount;
	}

	public int getSubTestExceptionCount() {
		if (subTestExceptionCount == null) {
			int tempCount = 0;
			for (TestSubResult tempSubResult : subResults) {
				if (tempSubResult instanceof TestExceptionSubResult) {
					tempCount++;
				}
			}
			subTestExceptionCount = tempCount;
		}

		return subTestExceptionCount;
	}

}
