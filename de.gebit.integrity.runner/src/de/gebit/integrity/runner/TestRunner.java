/**
 * 
 */
package de.gebit.integrity.runner;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.runner.results.SuiteSummaryResult;

/**
 * The test runner executes tests.
 * 
 * @author Rene Schneider
 * 
 */
public interface TestRunner {

	/**
	 * Executes a specified suite.
	 * 
	 * @param aRootSuite
	 *            the suite to execute
	 * @param aBlockForRemotingFlag
	 *            whether execution should pause before actually starting until execution is resumed via remoting
	 * @return the suite execution result
	 */
	SuiteSummaryResult run(SuiteDefinition aRootSuite, VariantDefinition aVariant, boolean aBlockForRemotingFlag);

	/**
	 * Shuts down this test runner instance.
	 * 
	 * @param anEmptyRemotingOutputQueueFlag
	 *            true if the remoting server shall be given time to send all remaining messages to clients while
	 *            closing connections
	 */
	void shutdown(boolean anEmptyRemotingOutputQueueFlag);

}
