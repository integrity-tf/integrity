package de.gebit.integrity.runner.callbacks;

import java.io.Serializable;
import java.util.Map;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;

/**
 * During test execution, the test runner invokes a callback in order to report progress as well as test results. A
 * callback can then use this information for whatever purpose; usually writing test output files.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class TestRunnerCallback {

	public abstract void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap);

	public abstract void onSuiteStart(Suite aSuite);

	public abstract void onSetupStart(SuiteDefinition aSetupSuite);

	public abstract void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult);

	public abstract void onTestStart(Test aTest);

	public abstract void onTestFinish(Test aTest, TestResult aResult);

	public abstract void onTableTestStart(TableTest aTableTest);

	public abstract void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow);

	public abstract void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult);

	public abstract void onTableTestFinish(TableTest aTableTest, TestResult aResult);

	public abstract void onCallStart(Call aCall);

	public abstract void onCallFinish(Call aCall, CallResult aResult);

	public abstract void onTearDownStart(SuiteDefinition aTearDownSuite);

	public abstract void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult);

	public abstract void onSuiteFinish(Suite aSuite, SuiteResult aResult);

	public abstract void onExecutionFinish(TestModel aModel, SuiteResult aResult);

	public abstract void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue);

	public abstract void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects);

	protected IntegrityRemotingServer server;

	protected boolean dryRun;

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

	protected void sendToMaster(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		if (server != null) {
			// System.out.println(aMethod);
			server.sendTestRunnerCallbackData(getClass().getName(), aMethod, someObjects);
		}
	}

	public void receiveFromFork(String aCallbackClassName, TestRunnerCallbackMethods aMethod, Serializable[] someData) {
		if (getClass().getName().equals(aCallbackClassName)) {
			onMessageFromFork(aMethod, someData);
		}
	}

}
