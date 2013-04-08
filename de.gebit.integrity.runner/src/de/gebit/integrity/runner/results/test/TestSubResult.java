/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.test;

import java.util.Map;

import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.runner.results.FixtureExecutionResult;

/**
 * Tests have one or more sub-results, with standard tests always having one, but tabletests potentially having more of
 * them, one for each row.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class TestSubResult extends FixtureExecutionResult {

	/**
	 * The comparison results, mapped by the respective parameter name.
	 */
	private Map<String, TestComparisonResult> comparisonResults;

	/**
	 * Creates a new instance.
	 * 
	 * @param someComparisonResults
	 *            the comparison results
	 * @param aFixtureInstance
	 *            The fixture instance (wrapped) - may be null if no fixtures are called in the current phase (for
	 *            example during the dry run).
	 * @param aFixtureMethod
	 *            the method that was executed
	 * @param anExecutionTime
	 *            the time taken to execute the fixture method
	 */
	public TestSubResult(Map<String, TestComparisonResult> someComparisonResults, FixtureWrapper<?> aFixtureInstance,
			String aFixtureMethod, Long anExecutionTime) {
		super(aFixtureInstance, aFixtureMethod, anExecutionTime);
		this.comparisonResults = someComparisonResults;
	}

	public Map<String, TestComparisonResult> getComparisonResults() {
		return comparisonResults;
	}

	/**
	 * Whether this sub-result is yet undetermined.
	 * 
	 * @return true if undetermined, false otherwise
	 */
	public boolean isUndetermined() {
		if (comparisonResults == null) {
			return true;
		} else {
			for (TestComparisonResult tempResult : comparisonResults.values()) {
				if (tempResult instanceof TestComparisonUndeterminedResult) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Whether all comparisons performed in this sub-result have been successful.
	 * 
	 * @return true if all comparisons passed, false otherwise
	 */
	public boolean wereAllComparisonsSuccessful() {
		if (comparisonResults == null) {
			return false;
		} else {
			for (TestComparisonResult tempResult : comparisonResults.values()) {
				if (tempResult instanceof TestComparisonFailureResult) {
					return false;
				}
			}
			return true;
		}
	}

}
