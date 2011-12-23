package de.gebit.integrity.runner.callbacks;

import java.util.Map;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableEntity;
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
public interface TestRunnerCallback {

	void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap);

	void onSuiteStart(Suite aSuite);

	void onSetupStart(SuiteDefinition aSetupSuite);

	void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult);

	void onTestStart(Test aTest);

	void onTestFinish(Test aTest, TestResult aResult);

	void onTableTestStart(TableTest aTableTest);

	void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow);

	void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult);

	void onTableTestFinish(TableTest aTableTest, TestResult aResult);

	void onCallStart(Call aCall);

	void onCallFinish(Call aCall, CallResult aResult);

	void onTearDownStart(SuiteDefinition aTearDownSuite);

	void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult);

	void onSuiteFinish(Suite aSuite, SuiteResult aResult);

	void onExecutionFinish(TestModel aModel, SuiteResult aResult);

	void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue);

}
