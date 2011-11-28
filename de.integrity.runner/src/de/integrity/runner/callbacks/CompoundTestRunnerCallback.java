package de.integrity.runner.callbacks;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.integrity.dsl.Call;
import de.integrity.dsl.Suite;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.Test;
import de.integrity.dsl.VariableEntity;
import de.integrity.runner.TestModel;
import de.integrity.runner.results.SuiteResult;
import de.integrity.runner.results.call.CallResult;
import de.integrity.runner.results.test.TestResult;

public class CompoundTestRunnerCallback implements TestRunnerCallback {

	private List<TestRunnerCallback> callbacks = new LinkedList<TestRunnerCallback>();

	public CompoundTestRunnerCallback(TestRunnerCallback... someCallbacks) {
		super();
		for (TestRunnerCallback tempCallback : someCallbacks) {
			addCallback(tempCallback);
		}
	}

	public void addCallback(TestRunnerCallback aCallback) {
		callbacks.add(aCallback);
	}

	public void removeCallback(TestRunnerCallback aCallback) {
		callbacks.remove(aCallback);
	}

	@Override
	public void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onExecutionStart(aModel, aVariableMap);
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
	public void onSuiteFinish(Suite aSuite, SuiteResult aResult) {
		for (TestRunnerCallback tempCallback : callbacks) {
			tempCallback.onSuiteFinish(aSuite, aResult);
		}
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteResult aResult) {
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

}
