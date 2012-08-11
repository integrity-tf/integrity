package de.gebit.integrity.runner.callbacks.remoting;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.call.CallResult.UpdatedVariable;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonSuccessResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.TestFormatter;

/**
 * Callback for creation and update of the {@link SetList} - a crucial part of Integritys' remoting system.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SetListCallback extends TestRunnerCallback {

	/**
	 * Classloader to use.
	 */
	private ClassLoader classLoader;

	/**
	 * The remoting server.
	 */
	private IntegrityRemotingServer remotingServer;

	/**
	 * The formatter to use when creating test description strings.
	 */
	private TestFormatter formatter;

	/**
	 * The setlist that this callback is updating.
	 */
	private SetList setList;

	/**
	 * Stack of {@link SetListEntry}s. The stack grows when entering suites, and shrinks when returning from sub-suites.
	 */
	private Stack<SetListEntry> entryStack = new Stack<SetListEntry>();

	/**
	 * The variable storage map.
	 */
	private Map<VariableEntity, Object> variableStorage;

	/**
	 * Format used for execution time.
	 */
	private static final DecimalFormat EXECUTION_TIME_FORMAT = new DecimalFormat("0.000");

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the setlist to update
	 * @param aRemotingServer
	 *            the remoting server to use
	 * @param aClassLoader
	 *            the classloader to use
	 */
	public SetListCallback(SetList aSetList, IntegrityRemotingServer aRemotingServer, ClassLoader aClassLoader) {
		classLoader = aClassLoader;
		formatter = new TestFormatter(classLoader);
		setList = aSetList;
		remotingServer = aRemotingServer;
	}

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant, Map<VariableEntity, Object> aVariableMap) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.EXECUTION);
		entryStack.push(tempNewEntry);
		variableStorage = aVariableMap;
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.SUITE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME,
				IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));

		if (getForkInExecution() != null) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.FORK_NAME, getForkInExecution().getName());
			if (getForkInExecution().getDescription() != null) {
				tempNewEntry.setAttribute(SetListEntryAttributeKeys.FORK_DESCRIPTION, getForkInExecution()
						.getDescription());
			}
		}

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.SUITE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME, IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.SETUP, tempNewEntry);
		entryStack.push(tempNewEntry);
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		onAnyKindOfSuiteFinish(aSetupSuite, aResult);
	}

	@Override
	public void onTestStart(Test aTest) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.TEST);

		SetListEntry[] tempParamEntries = addMethodAndParamsToTestOrCall(aTest.getDefinition().getFixtureMethod(),
				aTest.getParameters(), tempNewEntry);

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
		setList.setEntryInExecutionReference(tempNewEntry.getId());
		sendUpdateToClients(tempNewEntry.getId(), tempNewEntry, tempParamEntries);
	}

	@Override
	public void onTableTestStart(TableTest aTableTest) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.TABLETEST);

		SetListEntry[] tempParamEntries = addMethodAndParamsToTestOrCall(aTableTest.getDefinition().getFixtureMethod(),
				aTableTest.getParameters(), tempNewEntry);

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
		setList.setEntryInExecutionReference(tempNewEntry.getId());
		sendUpdateToClients(tempNewEntry.getId(), tempNewEntry, tempParamEntries);
	}

	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		// nothing to do here
	}

	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		// nothing to do here
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult aResult) {
		int tempCount = 0;
		SetListEntry tempTestEntry = entryStack.pop();

		if (aResult != null) {
			if (aResult.getExecutionTime() != null) {
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.EXECUTION_TIME,
						nanoTimeToString(aResult.getExecutionTime()));

				tempTestEntry.setAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT, aResult.getSubTestSuccessCount());
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.FAILURE_COUNT, aResult.getSubTestFailCount());
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT,
						aResult.getSubTestExceptionCount());
			}
		}

		List<SetListEntry> tempNewEntries = new LinkedList<SetListEntry>();
		for (TestSubResult tempSubResult : aResult.getSubResults()) {
			tempNewEntries.addAll(onAnyKindOfSubTestFinish(aTableTest.getDefinition().getFixtureMethod(),
					tempTestEntry, tempSubResult, IntegrityDSLUtil.createParameterMap(aTableTest, aTableTest.getRows()
							.get(tempCount), variableStorage, true, false)));
			tempCount++;
		}
		tempNewEntries.add(tempTestEntry);

		sendUpdateToClients(null, tempNewEntries.toArray(new SetListEntry[0]));
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		SetListEntry tempTestEntry = entryStack.pop();
		List<SetListEntry> tempNewEntries = onAnyKindOfSubTestFinish(aTest.getDefinition().getFixtureMethod(),
				tempTestEntry, aResult.getSubResults().get(0),
				IntegrityDSLUtil.createParameterMap(aTest, variableStorage, true, false));
		tempNewEntries.add(tempTestEntry);

		sendUpdateToClients(null, tempNewEntries.toArray(new SetListEntry[0]));
	}

	/**
	 * This method is used to perform the actual sub-test result parsing, both for normal tests and tabletests (with the
	 * latter having more than one subtest).
	 * 
	 * @param aMethod
	 *            the fixture method
	 * @param aTestEntry
	 *            the setlist entry for the test
	 * @param aSubResult
	 *            the sub-result to analyze
	 * @param aParameterMap
	 *            the parameters given to the test method
	 * @return a list of newly generated setlist entries
	 */
	protected List<SetListEntry> onAnyKindOfSubTestFinish(MethodReference aMethod, SetListEntry aTestEntry,
			TestSubResult aSubResult, Map<String, Object> aParameterMap) {
		List<SetListEntry> tempNewEntries = new LinkedList<SetListEntry>();
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.RESULT);
		tempNewEntries.add(tempNewEntry);

		if (aSubResult.getExecutionTime() != null) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXECUTION_TIME,
					nanoTimeToString(aSubResult.getExecutionTime()));
		}

		for (Entry<String, Object> tempEntry : aParameterMap.entrySet()) {
			SetListEntry tempParameterEntry = setList.createEntry(SetListEntryTypes.PARAMETER);
			tempNewEntries.add(tempParameterEntry);

			tempParameterEntry.setAttribute(SetListEntryAttributeKeys.NAME, tempEntry.getKey());
			tempParameterEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
					ParameterUtil.convertValueToString(tempEntry.getValue(), variableStorage, false));

			setList.addReference(tempNewEntry, SetListEntryAttributeKeys.PARAMETERS, tempParameterEntry);
		}

		try {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION,
					formatter.fixtureMethodToHumanReadableString(aMethod, aParameterMap, true));
		} catch (ClassNotFoundException exc) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		}

		if (aSubResult instanceof TestExceptionSubResult) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.FALSE);
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXCEPTION,
					stackTraceToString(((TestExceptionSubResult) aSubResult).getException()));
		} else if (aSubResult instanceof TestExecutedSubResult) {
			if (!aSubResult.isUndetermined()) {
				if (aSubResult.wereAllComparisonsSuccessful()) {
					tempNewEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.TRUE);
				} else {
					tempNewEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.FALSE);
				}
			}
		}

		for (Entry<String, TestComparisonResult> tempEntry : aSubResult.getComparisonResults().entrySet()) {
			SetListEntry tempComparisonEntry = setList.createEntry(SetListEntryTypes.COMPARISON);
			tempNewEntries.add(tempComparisonEntry);

			tempComparisonEntry.setAttribute(SetListEntryAttributeKeys.NAME, tempEntry.getKey());

			ValueOrEnumValueCollection tempExpectedValue = tempEntry.getValue().getExpectedValue();

			tempComparisonEntry.setAttribute(
					SetListEntryAttributeKeys.EXPECTED_RESULT,
					tempExpectedValue == null ? Boolean.TRUE.toString() : ParameterUtil.convertValueToString(tempEntry
							.getValue().getExpectedValue(), variableStorage, false));
			if (tempEntry.getValue().getResult() != null) {
				tempComparisonEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
						ParameterUtil.convertValueToString(tempEntry.getValue().getResult(), variableStorage, false));
			}

			if (tempEntry.getValue() instanceof TestComparisonSuccessResult) {
				tempComparisonEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.TRUE);
			} else if (tempEntry.getValue() instanceof TestComparisonFailureResult) {
				tempComparisonEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.FALSE);
			}

			setList.addReference(tempNewEntry, SetListEntryAttributeKeys.COMPARISONS, tempComparisonEntry);
		}

		setList.addReference(aTestEntry, SetListEntryAttributeKeys.RESULT, tempNewEntry);

		return tempNewEntries;
	}

	@Override
	public void onCallStart(Call aCall) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.CALL);

		SetListEntry[] tempParamEntries = addMethodAndParamsToTestOrCall(aCall.getDefinition().getFixtureMethod(),
				aCall.getParameters(), tempNewEntry);

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
		setList.setEntryInExecutionReference(tempNewEntry.getId());
		sendUpdateToClients(tempNewEntry.getId(), tempNewEntry, tempParamEntries);
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.RESULT);
		if (aResult.getExecutionTime() != null) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXECUTION_TIME,
					nanoTimeToString(aResult.getExecutionTime()));
		}

		if (aResult instanceof de.gebit.integrity.runner.results.call.SuccessResult) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.TRUE);
		} else if (aResult instanceof de.gebit.integrity.runner.results.call.ExceptionResult) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG, Boolean.FALSE);
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXCEPTION,
					stackTraceToString(((de.gebit.integrity.runner.results.call.ExceptionResult) aResult)
							.getException()));
		}

		SetListEntry[] tempEntries = new SetListEntry[aResult.getUpdatedVariables().size()];
		int tempCount = 0;
		for (UpdatedVariable tempUpdatedVariable : aResult.getUpdatedVariables()) {
			SetListEntry tempResultEntry = setList.createEntry(SetListEntryTypes.VARIABLE_UPDATE);
			if (tempUpdatedVariable.getTargetVariable() != null) {
				tempResultEntry.setAttribute(SetListEntryAttributeKeys.VARIABLE_NAME, tempUpdatedVariable
						.getTargetVariable().getName());
			}
			if (tempUpdatedVariable.getValue() != null) {
				tempResultEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
						ParameterUtil.convertValueToString(tempUpdatedVariable.getValue(), variableStorage, false));
			}
			if (tempUpdatedVariable.getParameterName() != null) {
				tempResultEntry.setAttribute(SetListEntryAttributeKeys.PARAMETER_NAME,
						tempUpdatedVariable.getParameterName());
			}
			setList.addReference(tempNewEntry, SetListEntryAttributeKeys.VARIABLE_UPDATES, tempResultEntry);
			tempEntries[tempCount] = tempResultEntry;
			tempCount++;
		}

		setList.addReference(entryStack.pop(), SetListEntryAttributeKeys.RESULT, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry, tempEntries);
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.SUITE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME,
				IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.TEARDOWN, tempNewEntry);
		entryStack.push(tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		onAnyKindOfSuiteFinish(aTearDownSuite, aResult);
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult) {
		onAnyKindOfSuiteFinish(aSuite.getDefinition(), aResult);
	}

	private void onAnyKindOfSuiteFinish(SuiteDefinition aSuite, SuiteSummaryResult aResult) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.RESULT);

		if (aResult != null) {
			if (aResult.getExecutionTime() != null) {
				tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXECUTION_TIME,
						nanoTimeToString(aResult.getExecutionTime()));
			}
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT, aResult.getTestSuccessCount());
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.FAILURE_COUNT, aResult.getTestFailCount());
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT, aResult.getTestExceptionCount());
		}

		setList.addReference(entryStack.pop(), SetListEntryAttributeKeys.RESULT, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		setList.setEntryInExecutionReference(null);
	}

	@Override
	public void onVisibleComment(String aCommentText) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.COMMENT);

		tempNewEntry.setAttribute(SetListEntryAttributeKeys.VALUE, aCommentText);

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.VARIABLE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		if (anInitialValue != null) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
					ParameterUtil.convertValueToString(anInitialValue, variableStorage, false));
		}

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.VARIABLE_DEFINITIONS, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	/**
	 * Adds information about the fixture method being called and the parameters given to it to a test or call entry.
	 * 
	 * @param aMethod
	 *            the fixture method
	 * @param aParamList
	 *            the parameters
	 * @param anEntry
	 *            the entry to add the information to
	 * @return the setlist entries created for the parameters
	 */
	protected SetListEntry[] addMethodAndParamsToTestOrCall(MethodReference aMethod, EList<Parameter> aParamList,
			SetListEntry anEntry) {
		try {
			anEntry.setAttribute(
					SetListEntryAttributeKeys.DESCRIPTION,
					formatter.fixtureMethodToHumanReadableString(aMethod,
							IntegrityDSLUtil.createParameterMap(aParamList, variableStorage, true, false), true));
		} catch (ClassNotFoundException exc) {
			anEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		}
		anEntry.setAttribute(SetListEntryAttributeKeys.FIXTURE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aMethod));

		SetListEntry[] tempResultArray = new SetListEntry[aParamList.size()];
		int tempParamCounter = 0;
		for (Parameter tempParameter : aParamList) {
			SetListEntry tempParamEntry = setList.createEntry(SetListEntryTypes.PARAMETER);
			tempParamEntry.setAttribute(SetListEntryAttributeKeys.NAME,
					IntegrityDSLUtil.getParamNameStringFromParameterName(tempParameter.getName()));
			tempParamEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
					ParameterUtil.convertValueToString(tempParameter.getValue(), variableStorage, false));
			if (tempParameter.getValue() instanceof Variable) {
				tempParamEntry.setAttribute(SetListEntryAttributeKeys.VARIABLE_NAME,
						((Variable) tempParameter.getValue()).getName().getName());
			}

			setList.addReference(anEntry, SetListEntryAttributeKeys.PARAMETERS, tempParamEntry);
			tempResultArray[tempParamCounter] = tempParamEntry;
			tempParamCounter++;
		}

		return tempResultArray;
	}

	/**
	 * Sends a setlist entry update to all clients of the remoting server.
	 * 
	 * @param anEntryInExecution
	 *            the entry that is currently in execution (may be null if that information shouldn't be included)
	 * @param someUpdatedEntries
	 *            the actual updated entries
	 */
	protected void sendUpdateToClients(Integer anEntryInExecution, SetListEntry... someUpdatedEntries) {
		if (remotingServer != null && !isDryRun()) {
			remotingServer.updateSetList(anEntryInExecution, someUpdatedEntries);
		}
	}

	/**
	 * Sends a setlist entry update to all clients of the remoting server. This is a convenience method and behaves much
	 * like {@link #sendUpdateToClients(Integer, SetListEntry...)}.
	 * 
	 * @param anEntryInExecution
	 *            the entry that is currently in execution (may be null if that information shouldn't be included)
	 * @param aSingleEntry
	 *            one single updated entry
	 * @param someMoreEntries
	 *            more updated entries
	 */
	protected void sendUpdateToClients(Integer anEntryInExecution, SetListEntry aSingleEntry,
			SetListEntry[] someMoreEntries) {
		SetListEntry[] tempCombined = new SetListEntry[someMoreEntries.length + 1];
		tempCombined[0] = aSingleEntry;
		System.arraycopy(someMoreEntries, 0, tempCombined, 1, someMoreEntries.length);
		sendUpdateToClients(anEntryInExecution, tempCombined);
	}

	/**
	 * Utility method to convert a stack trace to a string to be included in a setlist entry.
	 * 
	 * @param anException
	 *            the exception from which to take the stack trace
	 * @return the formatted trace string
	 */
	protected static String stackTraceToString(Throwable anException) {
		String tempResult = null;
		StringWriter tempStringWriter = null;
		PrintWriter tempPrintWriter = null;
		try {
			tempStringWriter = new StringWriter();
			tempPrintWriter = new PrintWriter(tempStringWriter);
			anException.printStackTrace(tempPrintWriter);
			tempResult = tempStringWriter.toString();
		} finally {
			try {
				if (tempPrintWriter != null) {
					tempPrintWriter.close();
				}
				if (tempStringWriter != null) {
					tempStringWriter.close();
				}
			} catch (IOException exc) {
				// ignore, cannot happen
			}
		}
		return tempResult;
	}

	/**
	 * Converts a nanosecond time value into a string according to the {@link #EXECUTION_TIME_FORMAT}.
	 * 
	 * @param aNanosecondValue
	 *            the time value
	 * @return the formatted string
	 */
	protected static String nanoTimeToString(long aNanosecondValue) {
		return EXECUTION_TIME_FORMAT.format(((double) aNanosecondValue) / 1000000.0);
	}

	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		// not used
	}

}
