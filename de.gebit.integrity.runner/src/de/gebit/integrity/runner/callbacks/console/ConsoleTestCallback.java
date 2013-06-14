/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks.console;

import java.io.Serializable;
import java.util.List;
import java.util.Map.Entry;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultImage;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultText;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.AbstractTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestFormatter;
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

/**
 * A simple callback which prints out test progression information onto the console.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConsoleTestCallback extends AbstractTestRunnerCallback {

	/**
	 * Test execution start time.
	 */
	protected long startTime;

	/**
	 * The number of tests executed.
	 */
	protected int testCount;

	/**
	 * Counting table test rows.
	 */
	protected int tableTestRowCount;

	/**
	 * The number of calls executed.
	 */
	protected int callCount;

	/**
	 * The number of suites executed.
	 */
	protected int suiteCount;

	/**
	 * The classloader to use.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The variable manager to use.
	 */
	@Inject
	protected VariableManager variableManager;

	/**
	 * The test formatter to use.
	 */
	@Inject
	protected TestFormatter testFormatter;

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant) {
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
	}

	@Override
	public void onTestStart(Test aTest) {
		testCount++;
		try {
			println("Now running test "
					+ testCount
					+ ": "
					+ testFormatter.testToHumanReadableString(aTest,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING) + "...");
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
		displayExtendedResults(aResult.getExtendedResults());
	}

	/**
	 * Displays the provided extended results on the console.
	 * 
	 * @param someExtendedResults
	 *            the extended result list to display
	 */
	protected void displayExtendedResults(List<ExtendedResult> someExtendedResults) {
		int tempImageCount = 0;
		if (someExtendedResults != null) {
			for (ExtendedResult tempResult : someExtendedResults) {
				if (tempResult instanceof ExtendedResultText) {
					println("Ext. result: " + ((ExtendedResultText) tempResult).getText());
				} else if (tempResult instanceof ExtendedResultImage) {
					tempImageCount++;
				}
			}

			if (tempImageCount > 0) {
				println("Ext. result: " + tempImageCount + " images");
			}
		}
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

						boolean tempExpectedIsNestedObject = containsNestedObject(tempExpectedValue);

						print("'"
								+ valueConverter.convertValueToString((tempExpectedValue == null ? true
										: tempExpectedValue), false,
										UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING)
								+ "' expected"
								+ (tempEntry.getKey().equals(ParameterUtil.DEFAULT_PARAMETER_NAME) ? "" : " for '"
										+ tempEntry.getKey() + "'")
								+ ", but got '"
								+ convertResultValueToStringGuarded(tempEntry.getValue().getResult(), aSubResult,
										tempExpectedIsNestedObject, UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING)
								+ "'!");
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
					+ aResult.getTestFailCount() + " failures and " + aResult.getExceptionCount() + " exceptions.");
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
						+ valueConverter.convertValueToString(anInitialValue, false,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING)));
	}

	@Override
	public void onConstantDefinition(ConstantEntity aDefinition, SuiteDefinition aSuite, Object aValue,
			boolean aParameterizedFlag) {
		println("Defined constant "
				+ IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false)
				+ (aValue == null ? "" : " with value: "
						+ valueConverter.convertValueToString(aValue, false,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING))
				+ (aParameterizedFlag ? " (parameterized)" : ""));
	}

	@Override
	public void onCallStart(Call aCall) {
		callCount++;
		try {
			println("Now executing call "
					+ callCount
					+ ": "
					+ testFormatter.callToHumanReadableString(aCall,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING) + "...");
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
		displayExtendedResults(aResult.getExtendedResults());
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
			print("\tRow "
					+ tableTestRowCount
					+ " ("
					+ testFormatter.tableTestRowToHumanReadableString(aTableTest, aRow,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING) + ")...");
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
		displayExtendedResults(someResults.getExtendedResults());
	}

	@Override
	public void onVisibleComment(String aCommentText, boolean anIsTitle, VisibleComment aCommentElement) {
		if (!isDryRun()) { // don't want to print this if we're not actually executing stuff
			String tempDelimiters = (anIsTitle ? "**" : "--");
			System.out.println(" " + tempDelimiters + " " + aCommentText + " " + tempDelimiters);
		}
	}

	@Override
	public void onVisibleDivider(String aDividerText, VisibleDivider aDividerElement) {
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