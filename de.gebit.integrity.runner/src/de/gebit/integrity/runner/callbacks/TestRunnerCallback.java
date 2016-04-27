/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks;

import java.io.Serializable;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteReturn;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableAssignment;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;

/**
 * During test execution, the test runner invokes a callback in order to report progress as well as test results. A
 * callback can then use this information for whatever purpose; usually writing test output files.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class TestRunnerCallback {

	/**
	 * Called when a call to all callbacks is imminent.
	 */
	public void onCallbackProcessingStart() {
		// do nothing; can be overridden if callback wants to be notified when the test runner starts calling the
		// callbacks
	}

	/**
	 * Called after a call has been performed on all callbacks.
	 */
	public void onCallbackProcessingEnd() {
		// do nothing; can be overridden if callback wants to be notified when the test runner has finished calling
		// the callbacks
	}

	/**
	 * Called when the execution starts, that is, before the first (root) suite is entered. This is always the first
	 * call of an execution phase.
	 * 
	 * @param aModel
	 *            the test model that will be executed
	 */
	public abstract void onExecutionStart(TestModel aModel, VariantDefinition aVariant);

	/**
	 * Called when a suite call is being followed.
	 * 
	 * @param aSuite
	 *            the suite call that will be entered
	 */
	public abstract void onSuiteStart(Suite aSuite);

	/**
	 * Called when a setup suite is being called.
	 * 
	 * @param aSetupSuite
	 *            the setup suite being entered
	 */
	public abstract void onSetupStart(SuiteDefinition aSetupSuite);

	/**
	 * Called when a setup suite has been executed.
	 * 
	 * @param aSetupSuite
	 *            the setup suite that was executed
	 * @param aResult
	 *            the result of the execution
	 */
	public abstract void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult);

	/**
	 * Called right before a test is being executed.
	 * 
	 * @param aTest
	 *            the test
	 */
	public abstract void onTestStart(Test aTest);

	/**
	 * Called after a test was executed.
	 * 
	 * @param aTest
	 *            the test that was executed
	 * @param aResult
	 *            the result of the execution
	 */
	public abstract void onTestFinish(Test aTest, TestResult aResult);

	/**
	 * Called when a table test is about to be executed.
	 * 
	 * @param aTableTest
	 *            the table test
	 */
	public abstract void onTableTestStart(TableTest aTableTest);

	/**
	 * Called when a single row of a table test is about to be executed.
	 * 
	 * @param aTableTest
	 *            the table test that contains the row
	 * @param aRow
	 *            the row
	 */
	public abstract void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow);

	/**
	 * Called after a table test row has been executed.
	 * 
	 * @param aTableTest
	 *            the table test that contains the row
	 * @param aRow
	 *            the row that was executed
	 * @param aSubResult
	 *            the result of the execution
	 */
	public abstract void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult);

	/**
	 * Called after a tabletest was fully executed (all rows have been executed).
	 * 
	 * @param aTableTest
	 *            the table test
	 * @param aResult
	 *            the result of the test execution
	 */
	public abstract void onTableTestFinish(TableTest aTableTest, TestResult aResult);

	/**
	 * Called before a call is being executed.
	 * 
	 * @param aCall
	 *            the call
	 */
	public abstract void onCallStart(Call aCall);

	/**
	 * Called right after a call was executed.
	 * 
	 * @param aCall
	 *            the call
	 * @param aResult
	 *            the result of the execution
	 */
	public abstract void onCallFinish(Call aCall, CallResult aResult);

	/**
	 * Called before a teardown suite is being executed.
	 * 
	 * @param aTearDownSuite
	 *            the suite to be executed
	 */
	public abstract void onTearDownStart(SuiteDefinition aTearDownSuite);

	/**
	 * Called after a teardown suite was executed.
	 * 
	 * @param aTearDownSuite
	 *            the suite that was executed
	 * @param aResult
	 *            the result of the execution
	 */
	public abstract void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult);

	/**
	 * Called after a suite has finished execution. This might return a {@link SuiteResult} instance if the suite was
	 * executed locally, or a {@link SuiteSummaryResult} with just the summary count information if the suite ran on a
	 * fork, in which case the detailed information is not available.
	 * 
	 * @param aSuite
	 *            the suite that was executed
	 * @param aResult
	 *            the result of the execution
	 */
	public abstract void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult);

	/**
	 * Called after all execution has been finished. This is always the last call of an execution phase.
	 * 
	 * @param aModel
	 * @param aResult
	 */
	public abstract void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult);

	/**
	 * Called when a variable is being defined.
	 * 
	 * @param aDefinition
	 *            the variable
	 * @param aSuite
	 *            the suite in which the variable is scoped (may be null if the variable is global)
	 * @param anInitialValue
	 *            the initial value (may be null if no initial value is given)
	 */
	public abstract void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite,
			Object anInitialValue);

	/**
	 * Called when a constant is being defined.
	 * 
	 * @param aDefinition
	 *            the constant
	 * @param aSuite
	 *            the suite in which the constant is scoped (may be null if the constant is global)
	 * @param aValue
	 *            the value (may be null if no value was given)
	 * @param aParameterizedFlag
	 *            true if the constant was parameterized (value defined not in script, but from outside the test runner
	 *            via parameter)
	 */
	public abstract void onConstantDefinition(ConstantEntity aDefinition, SuiteDefinition aSuite, Object aValue,
			boolean aParameterizedFlag);

	/**
	 * Called when a variable is being assigned.
	 * 
	 * @param anAssignment
	 *            the assignment
	 * @param aDefinition
	 *            the variable that the value is to be assigned
	 * @param aSuite
	 *            the suite in which the variable is scoped (may be null if the variable is global)
	 * @param aValue
	 *            the value
	 */
	public abstract void onVariableAssignment(VariableAssignment anAssignment, VariableEntity aDefinition,
			SuiteDefinition aSuite, Object aValue);

	/**
	 * Called when a return variable value from a suite is assigned to the respective local variable in the calling
	 * suite.
	 * 
	 * @param aReturn
	 *            the return variable object
	 * @param aSource
	 *            the source variable entity
	 * @param aTarget
	 *            the target variable entity
	 * @param aSuite
	 *            the suite invocation for which the assignment is done
	 * @param aValue
	 *            the value to be assigned
	 */
	public abstract void onReturnVariableAssignment(SuiteReturn aReturn, VariableEntity aSource, VariableEntity aTarget,
			Suite aSuite, Object aValue);

	/**
	 * Called when a visible comment is encountered during execution.
	 * 
	 * @param aCommentText
	 *            the text inside the comment
	 * @param aCommentElement
	 *            the raw comment element
	 */
	public abstract void onVisibleComment(String aCommentText, boolean anIsTitle, VisibleComment aCommentElement);

	/**
	 * Called when a visible divider is encountered during execution.
	 * 
	 * @param aDividerText
	 *            the divider text (basically a String of '-' chars with minimum length of 3 chars)
	 * @param aDividerElement
	 *            the raw divider element
	 */
	public abstract void onVisibleDivider(String aDividerText, VisibleDivider aDividerElement);

	/**
	 * Called when a fork has sent a message to the masters' callback. In order to merge results determined by forks
	 * seamlessly into the masters' results, callbacks do automatically have a simple messaging system at their
	 * disposal. When a fork callback uses {@link #sendToMaster(TestRunnerCallbackMethods, Serializable...)}, this
	 * method is called on the masters' respective callback in order to deliver the objects given.
	 * 
	 * @param aMethod
	 *            the method that was called on the forks' callback (doesn't have to be used, evaluating this parameter
	 *            is the job of the masters' callback and can thus be omitted if it ain't necessary)
	 * @param someObjects
	 *            the objects sent by the forks' callback
	 */
	public abstract void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects);

	/**
	 * Called when test execution is aborted prematurely due to an
	 * {@link de.gebit.integrity.exceptions.AbortExecutionException} - either thrown locally or by a fork. The original
	 * exception can't be provided since it cannot be received from a fork by remoting. Instead, the data from the
	 * exception is provided in both cases.
	 * 
	 * @param anAbortExecutionMessage
	 *            the message from the exception
	 * @param anAbortExecutionStackTrace
	 *            the stack trace of the exception
	 */
	public abstract void onAbortExecution(String anAbortExecutionMessage, String anAbortExecutionStackTrace);

	/**
	 * The remoting server, required for callback-to-callback communication in master-fork situations.
	 */
	protected IntegrityRemotingServer server;

	/**
	 * Whether the current phase is a dry run.
	 */
	protected boolean dryRun;

	/**
	 * The fork that is currently being executed.
	 */
	protected ForkDefinition forkInExecution;

	public void setRemotingServer(IntegrityRemotingServer aRemotingServer) {
		server = aRemotingServer;
	}

	public void setDryRun(boolean aDryRun) {
		dryRun = aDryRun;
	}

	public boolean isFork() {
		return (server != null);
	}

	public boolean isDryRun() {
		return dryRun;
	}

	public void setForkInExecution(ForkDefinition aFork) {
		forkInExecution = aFork;
	}

	public ForkDefinition getForkInExecution() {
		return forkInExecution;
	}

	/**
	 * When a callback that is running inside a fork instance uses this method, the given objects and the method
	 * parameter are being sent to the respective callback instance on the master. This mechanism is designed to allow
	 * for seamless integration of fork results into the masters' results.
	 * 
	 * @param aMethod
	 *            the method that was executed (doesn't have to be used, since the callback itself is responsible to
	 *            parse this value)
	 * @param someObjects
	 *            the objects to be sent
	 */
	protected void sendToMaster(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		if (server != null) {
			server.sendTestRunnerCallbackData(getClass().getName(), aMethod, someObjects);
		}
	}

	/**
	 * This method is used by the test runner to forward messages received from the forks to the callback.
	 * 
	 * @param aCallbackClassName
	 *            the callback class name
	 * @param aMethod
	 *            the method called
	 * @param someData
	 *            the objects given by the fork
	 */
	public void receiveFromFork(String aCallbackClassName, TestRunnerCallbackMethods aMethod, Serializable[] someData) {
		if (getClass().getName().equals(aCallbackClassName)) {
			onMessageFromFork(aMethod, someData);
		}
	}

}
