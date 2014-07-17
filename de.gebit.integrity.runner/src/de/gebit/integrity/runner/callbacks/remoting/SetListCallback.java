/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks.remoting;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.exceptions.MethodNotFoundException;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultHTML;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultImage;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultText;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.AbstractTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestFormatter;
import de.gebit.integrity.runner.results.FixtureExecutionResult;
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

/**
 * Callback for creation and update of the {@link SetList} - a crucial part of Integritys' remoting system.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SetListCallback extends AbstractTestRunnerCallback {

	/**
	 * The remoting server.
	 */
	private IntegrityRemotingServer remotingServer;

	/**
	 * The setlist that this callback is updating.
	 */
	private SetList setList;

	/**
	 * Stack of {@link SetListEntry}s. The stack grows when entering suites, and shrinks when returning from sub-suites.
	 */
	private Stack<SetListEntry> entryStack = new Stack<SetListEntry>();

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	private ParameterResolver parameterResolver;

	/**
	 * The test formatter to use.
	 */
	@Inject
	private TestFormatter testFormatter;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

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
	 */
	public SetListCallback(SetList aSetList, IntegrityRemotingServer aRemotingServer) {
		setList = aSetList;
		remotingServer = aRemotingServer;
	}

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.EXECUTION);
		entryStack.push(tempNewEntry);
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

		addLinkToEntry(tempNewEntry, aSuite);
		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.SUITE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME, IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
		addLinkToEntry(tempNewEntry, aSetupSuite);
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
				aTest.getParameters(), tempNewEntry, aTest);

		addLinkToEntry(tempNewEntry, aTest);
		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		entryStack.push(tempNewEntry);
		setList.setEntryInExecutionReference(tempNewEntry.getId());
		sendUpdateToClients(tempNewEntry.getId(), tempNewEntry, tempParamEntries);
	}

	@Override
	public void onTableTestStart(TableTest aTableTest) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.TABLETEST);

		SetListEntry[] tempParamEntries = addMethodAndParamsToTestOrCall(aTableTest.getDefinition().getFixtureMethod(),
				aTableTest.getParameters(), tempNewEntry, aTableTest);

		addLinkToEntry(tempNewEntry, aTableTest);
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
		SetListEntry tempTestEntry = entryStack.peek();

		List<SetListEntry> tempNewEntries = new LinkedList<SetListEntry>();
		Map<String, Object> tempParameterMap = new HashMap<String, Object>();

		try {
			// TODO see if this can be forwarded to the callbacks from the test runner; right now it's calculated twice
			tempParameterMap = parameterResolver.createParameterMap(aTableTest, aRow, true, createConversionContext()
					.getUnresolvableVariableHandlingPolicy());
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		}

		List<SetListEntry> tempResultEntries = onAnyKindOfSubTestFinish(aTableTest.getDefinition().getFixtureMethod(),
				aTableTest, tempTestEntry, aSubResult, tempParameterMap);

		// Add a link to the first entry from the list, which is the actual result entry
		addLinkToEntry(tempResultEntries.get(0), aRow);

		tempNewEntries.addAll(tempResultEntries);

		sendUpdateToClients(null, tempNewEntries.toArray(new SetListEntry[0]));
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult aResult) {
		SetListEntry tempTestEntry = entryStack.pop();

		if (aResult != null) {
			if (aResult.getExecutionTime() != null) {
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.EXECUTION_TIME,
						nanoTimeToString(aResult.getExecutionTime()));

				tempTestEntry.setAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT, aResult.getSubTestSuccessCount());
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.FAILURE_COUNT, aResult.getSubTestFailCount());
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.TEST_EXCEPTION_COUNT,
						aResult.getSubTestExceptionCount());
				tempTestEntry.setAttribute(SetListEntryAttributeKeys.CALL_EXCEPTION_COUNT, 0);
			}
		}

		addExtendedResultDataToEntry(tempTestEntry, aResult);

		sendUpdateToClients(null, tempTestEntry);
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		SetListEntry tempTestEntry = entryStack.pop();

		Map<String, Object> tempParameterMap = new HashMap<String, Object>();
		try {
			tempParameterMap = parameterResolver.createParameterMap(aTest, true, createConversionContext()
					.getUnresolvableVariableHandlingPolicy());
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		}

		addExtendedResultDataToEntry(tempTestEntry, aResult);
		List<SetListEntry> tempNewEntries = onAnyKindOfSubTestFinish(aTest.getDefinition().getFixtureMethod(), aTest,
				tempTestEntry, aResult.getSubResults().get(0), tempParameterMap);
		tempNewEntries.add(tempTestEntry);

		sendUpdateToClients(null, tempNewEntries.toArray(new SetListEntry[0]));
	}

	/**
	 * This method is used to perform the actual sub-test result parsing, both for normal tests and tabletests (with the
	 * latter having more than one subtest).
	 * 
	 * @param aMethod
	 *            the fixture method
	 * @param aStatement
	 *            the statement currently being executed
	 * @param aTestEntry
	 *            the setlist entry for the test
	 * @param aSubResult
	 *            the sub-result to analyze
	 * @param aParameterMap
	 *            the parameters given to the test method
	 * @return a list of newly generated setlist entries (with the first being the result entry itself)
	 */
	protected List<SetListEntry> onAnyKindOfSubTestFinish(MethodReference aMethod, SuiteStatementWithResult aStatement,
			SetListEntry aTestEntry, TestSubResult aSubResult, Map<String, Object> aParameterMap) {
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
					valueConverter.convertValueToString(tempEntry.getValue(), false, createConversionContext()));

			setList.addReference(tempNewEntry, SetListEntryAttributeKeys.PARAMETERS, tempParameterEntry);
		}

		try {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, testFormatter
					.fixtureMethodToHumanReadableString(aMethod, aStatement, aParameterMap, createConversionContext()));
		} catch (ClassNotFoundException exc) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
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

			// Either there is an expected value, or if there isn't, "true" is the default
			ValueOrEnumValueOrOperationCollection tempExpectedValue = tempEntry.getValue().getExpectedValue();

			boolean tempExpectedIsNestedObject = containsNestedObject(tempExpectedValue);

			tempComparisonEntry.setAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT, valueConverter
					.convertValueToString((tempExpectedValue == null ? true : tempExpectedValue), false,
							createConversionContext()));
			if (tempEntry.getValue().getActualValue() != null) {
				tempComparisonEntry.setAttribute(
						SetListEntryAttributeKeys.VALUE,
						convertResultValueToStringGuarded(tempEntry.getValue().getActualValue(), aSubResult,
								tempExpectedIsNestedObject, createConversionContext()));
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
				aCall.getParameters(), tempNewEntry, aCall);

		addLinkToEntry(tempNewEntry, aCall);
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
				tempResultEntry.setAttribute(
						SetListEntryAttributeKeys.VALUE,
						convertResultValueToStringGuarded(tempUpdatedVariable.getValue(), aResult, false,
								createConversionContext()));
			}
			if (tempUpdatedVariable.getParameterName() != null) {
				tempResultEntry.setAttribute(SetListEntryAttributeKeys.PARAMETER_NAME,
						tempUpdatedVariable.getParameterName());
			}
			setList.addReference(tempNewEntry, SetListEntryAttributeKeys.VARIABLE_UPDATES, tempResultEntry);
			tempEntries[tempCount] = tempResultEntry;
			tempCount++;
		}

		SetListEntry tempCallEntry = entryStack.pop();

		addExtendedResultDataToEntry(tempCallEntry, aResult);
		setList.addReference(tempCallEntry, SetListEntryAttributeKeys.RESULT, tempNewEntry);
		sendUpdateToClients(null, tempEntries, tempCallEntry, tempNewEntry);
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.SUITE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME,
				IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
		addLinkToEntry(tempNewEntry, aTearDownSuite);
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
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.TEST_EXCEPTION_COUNT, aResult.getTestExceptionCount());
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.CALL_EXCEPTION_COUNT, aResult.getCallExceptionCount());
		}

		setList.addReference(entryStack.pop(), SetListEntryAttributeKeys.RESULT, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		setList.setEntryInExecutionReference(null);
	}

	@Override
	public void onVisibleComment(String aCommentText, boolean anIsTitle, VisibleComment aCommentElement) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.COMMENT);

		tempNewEntry.setAttribute(SetListEntryAttributeKeys.VALUE, aCommentText);
		if (anIsTitle) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.TYPE, "title");
		}

		addLinkToEntry(tempNewEntry, aCommentElement);
		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.STATEMENTS, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	@Override
	public void onVisibleDivider(String aDividerText, VisibleDivider aDividerElement) {
		// currently these are ignored here
	}

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		onVariableDefinitionInternal(aDefinition, aSuite, anInitialValue);
	}

	@Override
	public void onConstantDefinition(ConstantEntity aDefinition, SuiteDefinition aSuite, Object aValue,
			boolean aParameterizedFlag) {
		// constants are handled like variables here (for now...)
		onVariableDefinitionInternal(aDefinition, aSuite, aValue);
	}

	private void onVariableDefinitionInternal(VariableOrConstantEntity aDefinition, SuiteDefinition aSuite,
			Object anInitialValue) {
		SetListEntry tempNewEntry = setList.createEntry(SetListEntryTypes.VARIABLE);
		tempNewEntry.setAttribute(SetListEntryAttributeKeys.NAME,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		if (anInitialValue != null) {
			tempNewEntry.setAttribute(SetListEntryAttributeKeys.VALUE,
					valueConverter.convertValueToString(anInitialValue, false, createConversionContext()));
		}

		setList.addReference(entryStack.peek(), SetListEntryAttributeKeys.VARIABLE_DEFINITIONS, tempNewEntry);
		sendUpdateToClients(null, tempNewEntry);
	}

	/**
	 * Determines the way unresolvable variables are to be handled.
	 * 
	 * @return
	 */
	protected ConversionContext createConversionContext() {
		if (isDryRun()) {
			return conversionContextProvider.get().withUnresolvableVariableHandlingPolicy(
					UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT);
		} else {
			return conversionContextProvider.get();
		}
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
	 * @param aStatement
	 *            the statement currently in execution
	 * @return the setlist entries created for the parameters
	 */
	protected SetListEntry[] addMethodAndParamsToTestOrCall(MethodReference aMethod, EList<Parameter> aParamList,
			SetListEntry anEntry, SuiteStatementWithResult aStatement) {
		try {
			anEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, testFormatter
					.fixtureMethodToHumanReadableString(aMethod, aStatement, parameterResolver.createParameterMap(
							aParamList, true, createConversionContext().getUnresolvableVariableHandlingPolicy()),
							createConversionContext()));
		} catch (ClassNotFoundException exc) {
			anEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			anEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			anEntry.setAttribute(SetListEntryAttributeKeys.DESCRIPTION, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
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
					valueConverter.convertValueToString(tempParameter.getValue(), false, createConversionContext()));
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
	 * Sends a setlist entry update to all clients of the remoting server. This is a convenience method and behaves much
	 * like {@link #sendUpdateToClients(Integer, SetListEntry...)}.
	 * 
	 * @param anEntryInExecution
	 *            the entry that is currently in execution (may be null if that information shouldn't be included)
	 * @param someEntries
	 *            some updated entries as an array
	 * @param someSingleEntries
	 *            more updated entries
	 */
	protected void sendUpdateToClients(Integer anEntryInExecution, SetListEntry[] someEntries,
			SetListEntry... someSingleEntries) {
		SetListEntry[] tempCombined = new SetListEntry[someEntries.length + someSingleEntries.length];
		System.arraycopy(someSingleEntries, 0, tempCombined, 0, someSingleEntries.length);
		System.arraycopy(someEntries, 0, tempCombined, someSingleEntries.length, someEntries.length);
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

	/**
	 * Adds a link (to suite and line number) to the given {@link SetListEntry}.
	 * 
	 * @param anEntry
	 *            the entry to add the link to
	 * @param anObject
	 *            the object to link to
	 */
	protected void addLinkToEntry(SetListEntry anEntry, EObject anObject) {
		SuiteDefinition tempParentSuite = null;
		EObject tempParent = anObject;
		while (tempParentSuite == null && tempParent != null) {
			if (tempParent instanceof SuiteDefinition) {
				tempParentSuite = (SuiteDefinition) tempParent;
			} else {
				tempParent = tempParent.eContainer();
			}
		}

		if (tempParentSuite != null) {
			String tempLink = IntegrityDSLUtil.getQualifiedSuiteName(tempParentSuite);
			if (!(anObject instanceof SuiteDefinition)) {
				ICompositeNode tempNode = NodeModelUtils.getNode(anObject);
				if (tempNode != null) {
					int tempLine = tempNode.getStartLine();
					tempLink += "#" + tempLine;
				}
			}
			anEntry.setAttribute(SetListEntryAttributeKeys.LINK, tempLink);
		}
	}

	/**
	 * Adds the extended result data in the {@link FixtureExecutionResult} object to the provided {@link SetListEntry}.
	 * If there's no extended results, this method does nothing.
	 * 
	 * @param anEntry
	 *            the entry to attach results to
	 * @param aResult
	 *            the result to explore
	 */
	protected void addExtendedResultDataToEntry(SetListEntry anEntry, FixtureExecutionResult aResult) {
		if (aResult.getExtendedResults() == null || aResult.getExtendedResults().size() == 0) {
			return;
		}

		List<Object[]> tempTargetList = new ArrayList<Object[]>(aResult.getExtendedResults().size());

		for (ExtendedResult tempExtResult : aResult.getExtendedResults()) {
			if (tempExtResult instanceof ExtendedResultText) {
				tempTargetList.add(new Object[] { tempExtResult.getTitle(),
						((ExtendedResultText) tempExtResult).getText() });
			} else if (tempExtResult instanceof ExtendedResultHTML) {
				tempTargetList.add(new Object[] { tempExtResult.getTitle(),
						((ExtendedResultHTML) tempExtResult).getHypertext() });
			} else if (tempExtResult instanceof ExtendedResultImage) {
				tempTargetList.add(new Object[] { tempExtResult.getTitle(),
						((ExtendedResultImage) tempExtResult).getEncodedImage() });
			}
		}

		if (tempTargetList.size() > 0) {
			anEntry.setAttribute(SetListEntryAttributeKeys.EXTENDED_RESULT_DATA,
					tempTargetList.toArray(new Object[tempTargetList.size()]));
		}
	}
}
