package de.gebit.integrity.runner.callbacks.console;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.TestFormatter;

/**
 * A simple callback which prints out test progression information onto the console.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ConsoleTestCallback extends TestRunnerCallback {

	private ClassLoader classLoader;

	private long startTime;

	private TestFormatter formatter;

	private int testCount;

	private int tableTestRowCount;

	private int callCount;

	private int suiteCount = 1;

	private Map<VariableEntity, Object> variableStorage;

	public ConsoleTestCallback(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
		formatter = new TestFormatter(classLoader);
	}

	@Override
	public void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap) {
		println("Test execution has begun...");
		startTime = System.currentTimeMillis();
		variableStorage = aVariableMap;
	}

	@Override
	public void onTestStart(Test aTest) {
		testCount++;
		try {
			println("Now running test " + testCount + ": "
					+ formatter.testToHumanReadableString(aTest, variableStorage) + "...");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		displayTestSubResult(aResult.getSubResults().get(0));
	}

	protected void displayTestSubResult(TestSubResult aSubResult) {
		if (aSubResult instanceof TestExecutedSubResult) {
			if (aSubResult.wereAllComparisonsSuccessful()) {
				println("SUCCESS!");
			} else {
				print("FAILURE: ");
				boolean tempHasBegun = false;
				for (Entry<String, TestComparisonResult> tempEntry : aSubResult.getComparisonResults().entrySet()) {
					if (tempEntry.getValue() instanceof TestComparisonFailureResult) {
						if (tempHasBegun) {
							print("; ");
						}
						print("'"
								+ ParameterUtil.convertValueToString(tempEntry.getValue().getExpectedValue(),
										variableStorage, false)
								+ "' expected"
								+ (tempEntry.getKey().equals(ParameterUtil.DEFAULT_PARAMETER_NAME) ? "" : " for '"
										+ tempEntry.getKey() + "'") + ", but got '" + tempEntry.getValue() + "'!");
					}
				}
				println("");
			}
		} else if (aSubResult instanceof TestExceptionSubResult) {
			println("EXCEPTION OCCURRED, SEE STDERR!");
			((TestExceptionSubResult) aSubResult).getException().printStackTrace();
		}
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteResult aResult) {
		println("Finished executing " + suiteCount + " suites with " + testCount + " tests and " + callCount
				+ " calls in " + (System.currentTimeMillis() - startTime) + " msecs!");

		println(aResult.getTestSuccessCount() + " tests finished sucessfully, accompanied by "
				+ aResult.getTestFailCount() + " failures and " + aResult.getTestExceptionCount() + " exceptions.");
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		suiteCount++;
		println("Now entering suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteResult aResult) {
		println("Now leaving suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		println("Defined variable "
				+ IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false)
				+ (anInitialValue == null ? "" : " with initial value: "
						+ ParameterUtil.convertValueToString(anInitialValue, variableStorage, false)));
	}

	@Override
	public void onCallStart(Call aCall) {
		callCount++;
		try {
			println("Now executing call " + callCount + ": "
					+ formatter.callToHumanReadableString(aCall, variableStorage) + "...");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		if (aResult instanceof de.gebit.integrity.runner.results.call.SuccessResult) {
			println("SUCCESS!");
		} else if (aResult instanceof de.gebit.integrity.runner.results.call.ExceptionResult) {
			println("EXCEPTION OCCURRED, SEE STDERR!");
			System.err.println(aResult.toString());
		}
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		println("Now entering setup suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		println("Now leaving setup suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		println("Now entering teardown suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		println("Now leaving teardown suite: " + IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
	}

	@Override
	public void onTableTestStart(TableTest aTableTest) {
		testCount++;
		tableTestRowCount = 0;
		println("Now running table test " + testCount + ":");
	}

	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		tableTestRowCount++;
		try {
			print("\tRow " + tableTestRowCount + " ("
					+ formatter.tableTestRowToHumanReadableString(aTableTest, aRow, variableStorage) + ")...");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		displayTestSubResult(aSubResult);
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult someResults) {
		println("\tTotal: " + someResults.getSubTestSuccessCount() + "x SUCCESS, " + someResults.getSubTestFailCount()
				+ "x FAILURE, " + someResults.getSubTestExceptionCount() + "x EXCEPTION.");
	}

	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		// nothing to do; this callback is not fork-aware
	}

	protected void print(String aString) {
		if (!isDryRun()) {
			System.out.print(aString);
		}
	}

	protected void println(String aString) {
		if (!isDryRun()) {
			System.out.println(aString);
		}
	}
}