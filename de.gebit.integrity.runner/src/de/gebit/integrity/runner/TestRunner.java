/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import java.io.IOException;
import java.util.Map;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.results.SuiteSummaryResult;

/**
 * The test runner executes tests.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface TestRunner {

	/**
	 * Initializes a fresh test runner instance. In case of forks, this method guarantees that when it exits without an
	 * exception, the master has successfully connected and injected the test scripts and a setlist into it.
	 * 
	 * @param aModel
	 *            the model to execute (may not contain any test script data yet in case of forks!)
	 * @param someParameterizedConstants
	 *            Maps fully qualified constant names (must be those with the "parameterized" keyword) to their desired
	 *            value. This way, test execution can be parameterized from outside.
	 * @param aCallback
	 *            the callback to use to report test results
	 * @param aRemotingPort
	 *            the port on which the remoting server should listen, or null if remoting should be disabled
	 * @param aRemotingBindHost
	 *            the host name (or IP) to which the remoting server should bind
	 * @param aRandomSeed
	 *            the seed for the {@link de.gebit.integrity.runner.operations.RandomNumberOperation} (optional;
	 *            randomly determined if not given).
	 * @param someCommandLineArguments
	 *            all command line arguments as given to the original Java programs' main routine (required for
	 *            forking!)
	 * @throws IOException
	 *             if the remoting server startup fails, or if the connection from the master process does not complete
	 *             in time (for forks only)
	 */
	void initialize(TestModel aModel, Map<String, String> someParameterizedConstants, TestRunnerCallback aCallback,
			Integer aRemotingPort, String aRemotingBindHost, Long aRandomSeed, String[] someCommandLineArguments)
			throws IOException;

	/**
	 * Executes a specified suite. Designated starting point for test execution.
	 * 
	 * @param aRootSuite
	 *            the suite to execute
	 * @param aBlockForRemotingFlag
	 *            whether execution should pause before actually starting until execution is resumed via remoting
	 * @return the suite execution result (this may also be null in case there is no tangible "result", like when the
	 *         test runner is actually just running the part of a single fork within a bigger test suite - the partial
	 *         result in this case is not relevant, but is automatically integrated in the result of the master process)
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
