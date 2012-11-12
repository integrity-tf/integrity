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
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.IntegrityValueConverter;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
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

	/**
	 * The classloader to use for resolving purposes.
	 */
	private ClassLoader classLoader;

	/**
	 * Test execution start time.
	 */
	private long startTime;

	/**
	 * The test formatter to use for creating test/call description strings.
	 */
	private TestFormatter formatter;

	/**
	 * The number of tests executed.
	 */
	private int testCount;

	/**
	 * Counting table test rows.
	 */
	private int tableTestRowCount;

	/**
	 * The number of calls executed.
	 */
	private int callCount;

	/**
	 * The number of suites executed.
	 */
	private int suiteCount;

	/**
	 * The variable storage map.
	 */
	private Map<VariableEntity, Object> variableStorage;

	/**
	 * The value converter to use.
	 */
	private IntegrityValueConverter valueConverter;

	/**
	 * Creates a new instance.
	 * 
	 * @param aClassLoader
	 *            the classloader to use
	 */
	public ConsoleTestCallback(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant,
			Map<VariableEntity, Object> aVariableMap, IntegrityValueConverter aValueConverter) {
		String tempLine = "Test execution has begun";
		if (aVariant != null) {
			tempLine += " (variant '" + aVariant.getName() + "'";
			if (aVariant.getDescription() != null) {
				tempLine += ": '" + aVariant.getDescription() + "'";
			}
			tempLine += ")";
		}
		tempLine += "...";

		println(tempLine);
		startTime = System.currentTimeMillis();
		variableStorage = aVariableMap;
		valueConverter = aValueConverter;
		formatter = new TestFormatter(classLoader, aValueConverter);
	}

	@Override
	public void onTestStart(Test aTest) {
		testCount++;
		try {
			println("Now running test " + testCount + ": "
					+ formatter.testToHumanReadableString(aTest, variableStorage) + "...");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		displayTestSubResult(aResult.getSubResults().get(0));
	}

	/**
	 * Displays a test sub-result.
	 * 
	 * @param aSubResult
	 *            the sub-result to display
	 */
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
						// Either there is an expected value, or if there isn't, "true" is the default
						ValueOrEnumValueOrOperationCollection tempExpectedValue = tempEntry.getValue()
								.getExpectedValue();
						print("'"
								+ valueConverter.convertValueToString((tempExpectedValue == null ? true
										: tempExpectedValue), variableStorage, classLoader, false)
								+ "' expected"
								+ (tempEntry.getKey().equals(ParameterUtil.DEFAULT_PARAMETER_NAME) ? "" : " for '"
										+ tempEntry.getKey() + "'")
								+ ", but got '"
								+ valueConverter.convertValueToString(tempEntry.getValue().getResult(),
										variableStorage, classLoader, false) + "'!");
						tempHasBegun = true;
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
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		if (aResult != null) {
			println("Finished executing " + suiteCount + " suites with " + testCount + " tests and " + callCount
					+ " calls in " + (System.currentTimeMillis() - startTime) + " msecs!");

			println(aResult.getTestSuccessCount() + " tests finished sucessfully, accompanied by "
					+ aResult.getTestFailCount() + " failures and " + aResult.getTestExceptionCount() + " exceptions.");
		}
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		suiteCount++;
		println("Now entering suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult) {
		println("Now leaving suite " + suiteCount + ": "
				+ IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		println("Defined variable "
				+ IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false)
				+ (anInitialValue == null ? "" : " with initial value: "
						+ valueConverter.convertValueToString(anInitialValue, variableStorage, classLoader, false)));
	}

	@Override
	public void onCallStart(Call aCall) {
		callCount++;
		try {
			println("Now executing call " + callCount + ": "
					+ formatter.callToHumanReadableString(aCall, variableStorage) + "...");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
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
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
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
	public void onVisibleComment(String aCommentText) {
		if (!isDryRun()) { // don't want to print this if we're not actually executing stuff
			System.out.println(" -- " + aCommentText + " --");
		}
	}

	@Override
	public void onVisibleDivider(String aDividerText) {
		if (!isDryRun()) { // don't want to print this if we're not actually executing stuff
			System.out.println(" " + aDividerText + "");
		}
	}

	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		// nothing to do; this callback is not fork-aware
	}

	/**
	 * Prints something, if we're not currently in a dry run.
	 * 
	 * @param aString
	 *            the string to print
	 */
	protected void print(String aString) {
		if (!isDryRun()) {
			System.out.print(aString);
		}
	}

	/**
	 * Prints plus newline, if we're not currently in a dry run.
	 * 
	 * @param aString
	 *            the string to print
	 */
	protected void println(String aString) {
		if (!isDryRun()) {
			System.out.println(aString);
		}
	}
}