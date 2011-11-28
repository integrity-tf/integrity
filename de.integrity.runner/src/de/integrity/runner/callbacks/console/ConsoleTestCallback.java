package de.integrity.runner.callbacks.console;

import java.util.Map;

import de.integrity.dsl.Call;
import de.integrity.dsl.Suite;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.Test;
import de.integrity.dsl.VariableEntity;
import de.integrity.runner.TestModel;
import de.integrity.runner.callbacks.TestRunnerCallback;
import de.integrity.runner.results.SuiteResult;
import de.integrity.runner.results.call.CallResult;
import de.integrity.runner.results.test.ExceptionResult;
import de.integrity.runner.results.test.FailureResult;
import de.integrity.runner.results.test.SuccessResult;
import de.integrity.runner.results.test.TestResult;
import de.integrity.utils.IntegrityDSLUtil;
import de.integrity.utils.ParameterUtil;
import de.integrity.utils.TestFormatter;

public class ConsoleTestCallback implements TestRunnerCallback {

	private ClassLoader classLoader;

	private long startTime;

	private TestFormatter formatter;

	private int testCount;

	private int callCount;

	private int suiteCount = 1;

	private Map<VariableEntity, Object> variableStorage;

	public ConsoleTestCallback(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
		formatter = new TestFormatter(classLoader);
	}

	@Override
	public void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap) {
		System.out.println("Test execution has begun...");
		startTime = System.currentTimeMillis();
		variableStorage = aVariableMap;
	}

	@Override
	public void onTestStart(Test aTest) {
		testCount++;
		try {
			System.out.print("Now running test " + testCount + ": "
					+ formatter.testToHumanReadableString(aTest, variableStorage) + "...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		if (aResult instanceof SuccessResult) {
			System.out.println("SUCCESS!");
		} else if (aResult instanceof FailureResult) {
			System.out.println("FAILURE: '"
					+ ParameterUtil.convertValueToString(((FailureResult) aResult).getExpectedValue(), variableStorage)
					+ "' expected, but got '" + aResult + "'!");
		} else if (aResult instanceof ExceptionResult) {
			System.out.println("EXCEPTION OCCURRED, SEE STDERR!");
			System.err.println(aResult.toString());
		}
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteResult aResult) {
		System.out.println("Finished executing " + suiteCount + " suites with " + testCount + " tests and " + callCount
				+ " calls in " + (System.currentTimeMillis() - startTime) + " msecs!");

		System.out.println(aResult.getTestSuccessCount() + " tests finished sucessfully, accompanied by "
				+ aResult.getTestFailCount() + " failures and " + aResult.getTestExceptionCount() + " exceptions.");
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		suiteCount++;
		System.out.println("Now entering suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteResult aResult) {
		System.out.println("Now leaving suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		System.out.println("Defined variable "
				+ IntegrityDSLUtil.getQualifiedGlobalVariableName(aDefinition)
				+ (anInitialValue == null ? "" : " with initial value: "
						+ ParameterUtil.convertValueToString(anInitialValue, variableStorage)));
	}

	@Override
	public void onCallStart(Call aCall) {
		callCount++;
		try {
			System.out.print("Now executing call " + callCount + ": "
					+ formatter.callToHumanReadableString(aCall, variableStorage) + "...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		if (aResult instanceof de.integrity.runner.results.call.SuccessResult) {
			System.out.println("SUCCESS!");
		} else if (aResult instanceof de.integrity.runner.results.call.ExceptionResult) {
			System.out.println("EXCEPTION OCCURRED, SEE STDERR!");
			System.err.println(aResult.toString());
		}
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		System.out.println("Now entering setup suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		System.out.println("Now leaving setup suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		System.out.println("Now entering teardown suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		System.out.println("Now leaving teardown suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
	}
}