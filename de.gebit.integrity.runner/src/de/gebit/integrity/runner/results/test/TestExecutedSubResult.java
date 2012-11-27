package de.gebit.integrity.runner.results.test;

import java.util.Map;

import de.gebit.integrity.fixtures.FixtureWrapper;

/**
 * A sub-result of an executed test.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestExecutedSubResult extends TestSubResult {

	/**
	 * Creates a new instance.
	 * 
	 * @param someComparisonResults
	 *            Map of named result name to the respective comparison result
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            The time taken to execute the test method
	 */
	public TestExecutedSubResult(Map<String, TestComparisonResult> someComparisonResults,
			FixtureWrapper<?> aFixtureInstance, String aFixtureMethod, Long anExecutionTime) {
		super(someComparisonResults, aFixtureInstance, aFixtureMethod, anExecutionTime);
	}

}
