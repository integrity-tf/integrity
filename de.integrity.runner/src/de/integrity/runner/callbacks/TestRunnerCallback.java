package de.integrity.runner.callbacks;

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

public interface TestRunnerCallback {

	void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap);

	void onSuiteStart(Suite aSuite);

	void onSetupStart(SuiteDefinition aSetupSuite);

	void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult);

	void onTestStart(Test aTest);

	void onTestFinish(Test aTest, TestResult aResult);

	void onCallStart(Call aCall);

	void onCallFinish(Call aCall, CallResult aResult);

	void onTearDownStart(SuiteDefinition aTearDownSuite);

	void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult);

	void onSuiteFinish(Suite aSuite, SuiteResult aResult);

	void onExecutionFinish(TestModel aModel, SuiteResult aResult);

	void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue);

}
