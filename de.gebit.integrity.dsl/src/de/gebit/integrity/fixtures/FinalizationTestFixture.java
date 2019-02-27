/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

/**
 * A finalization test fixture defines a method that is to be invoked AFTER the actual fixture methods had been called
 * during a tabletest invocation. This post-invocation test method is expected to return a success or failure result,
 * and if it returns a failure, this is logged as a failure for the entire tabletest.
 * <p>
 * The finalization test method is useful with tabletests, as it is only called exactly once, after all the method calls
 * for the lines of the tabletest were invoked. It is also called on the same fixture class instance that the tabletest
 * method calls will be called on, effectively providing a good point of entry to perform some sort of finalization test
 * for fixtures that hold internal state. Think of a fixture that loads a number of datasets at first invocation,
 * testing them one by one afterwards in a tabletest. A useful finalization test would be to check if there are still
 * datasets left unchecked.
 * <p>
 * For call or test invocations, finalization test methods are simply ignored. They are only used in conjunction with
 * tabletests. For normal test invocations, it is assumed that the test method invocation itself should already lead to
 * a final result as to whether the test is considered successful or not.
 * 
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface FinalizationTestFixture {

	/**
	 * The finalization test method will be invoked after fixture methods had been called. It should do any post-checks
	 * necessary before the fixture instance is being destroyed, and if it concludes that the entire tabletest should be
	 * considered a failure, it should return a failure message explaining what is wrong.
	 * <p>
	 * The message returned will end up in the test result in a prominent spot, so it should be reasonably concise.
	 * Longer explanations and possibly data that is useful to diagnose the problem (such as surplus line raw data)
	 * should be provided as an extended result via an {@link ExtendedResultFixture} method (which will be called after
	 * the finalization test has run).
	 * 
	 * @return null if the test is considered successful, an error message if not
	 */
	String performFinalizationTest();

}
