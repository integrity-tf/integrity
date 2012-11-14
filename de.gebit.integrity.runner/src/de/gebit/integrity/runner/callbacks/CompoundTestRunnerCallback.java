package de.gebit.integrity.runner.callbacks;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.google.inject.Injector;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;

/**
 * This special {@link TestRunnerCallback} is intended to be used for combining multiple callbacks. It will simply
 * distribute all calls to all contained callbacks.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class CompoundTestRunnerCallback extends TestRunnerCallback {

	/**
	 * The contained callbacks that are being wrapped.
	 */
	private List<TestRunnerCallback> callbacks = new LinkedList<TestRunnerCallback>();

	/**
	 * Creates a new instance.
	 * 
	 * @param someCallbacks
	 *            the callbacks to be wrapped
	 */
	public CompoundTestRunnerCallback(TestRunnerCallback... someCallbacks) {
		super();
		for (TestRunnerCallback tempCallback : someCallbacks) {
			addCallback(tempCallback);
		}
	}

	/**
	 * Adds another callback.
	 * 
	 * @param aCallback
	 *            the callback to be added
	 */
	public void addCallback(TestRunnerCallback aCallback) {
		callbacks.add(aCallback);
	}

	/**
	 * Removes a callback from the compound.
	 * 
	 * @param aCallback
	 *            the callback to be removed
	 */
	public void removeCallback(TestRunnerCallback aCallback) {
		callbacks.remove(aCallback);
	}

	/**
	 * Injects Guice dependencies into all contained callbacks.
	 * 
	 * @param anInjector
	 *            the guice injector
	 */
	public void injectDependencies(Injector anInjector) {
		for (TestRunnerCallback tempCallback : callbacks) {
			if (tempCallback instanceof CompoundTestRunnerCallback) {
				((CompoundTestRunnerCallback) tempCallback).injectDependencies(anInjector);
			} else {
				anInjector.injectMembers(tempCallback);
			}
		}
	}

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onExecutionStart(aModel, aVariant);
		}
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onSuiteStart(aSuite);
		}
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onSetupStart(aSetupSuite);
		}
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onSetupFinish(aSetupSuite, aResult);
		}
	}

	@Override
	public void onTestStart(Test aTest) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTestStart(aTest);
		}
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTestFinish(aTest, aResult);
		}
	}

	@Override
	public void onCallStart(Call aCall) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onCallStart(aCall);
		}
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onCallFinish(aCall, aResult);
		}
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTearDownStart(aTearDownSuite);
		}
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTearDownFinish(aTearDownSuite, aResult);
		}
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onSuiteFinish(aSuite, aResult);
		}
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onExecutionFinish(aModel, aResult);
		}
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onVariableDefinition(aDefinition, aSuite, anInitialValue);
		}
	}

	@Override
	public void onTableTestStart(TableTest aTableTest) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTableTestStart(aTableTest);
		}
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult someResults) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTableTestFinish(aTableTest, someResults);
		}
	}

	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTableTestRowStart(aTableTest, aRow);
		}
	}

	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onTableTestRowFinish(aTableTest, aRow, aSubResult);
		}
	}

	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onMessageFromFork(aMethod, someObjects);
		}
	}

	@Override
	public void setRemotingServer(IntegrityRemotingServer aRemotingServer) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.setRemotingServer(aRemotingServer);
		}
	}

	@Override
	public void setDryRun(boolean aDryRun) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.setDryRun(aDryRun);
		}
	}

	@Override
	public void receiveFromFork(String aCallbackClassName, TestRunnerCallbackMethods aMethod, Serializable[] someData) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.receiveFromFork(aCallbackClassName, aMethod, someData);
		}
	}

	@Override
	public void onVisibleComment(String aCommentText) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onVisibleComment(aCommentText);
		}
	}

	@Override
	public void onVisibleDivider(String aDividerText) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onVisibleDivider(aDividerText);
		}
	}

	@Override
	public void setForkInExecution(ForkDefinition aFork) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.setForkInExecution(aFork);
		}
	}
}
