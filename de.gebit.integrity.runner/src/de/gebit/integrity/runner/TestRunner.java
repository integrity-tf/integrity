package de.gebit.integrity.runner;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Semaphore;

import org.eclipse.xtext.common.types.JvmType;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.DslFactory;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VisibleMultiLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineComment;
import de.gebit.integrity.fixtures.Fixture;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.server.IntegrityRemotingServerListener;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.BreakpointActions;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.messages.BreakpointUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.gebit.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.callbacks.remoting.SetListCallback;
import de.gebit.integrity.runner.forking.Fork;
import de.gebit.integrity.runner.forking.ForkCallback;
import de.gebit.integrity.runner.forking.ForkException;
import de.gebit.integrity.runner.forking.Forker;
import de.gebit.integrity.runner.results.Result;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonSuccessResult;
import de.gebit.integrity.runner.results.test.TestComparisonUndeterminedResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;

/**
 * The test runner executes tests. This class is the core of the Integrity runtime system.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestRunner {

	protected TestModel model;

	protected SetList setList;

	protected Object setListWaiter = new Object();

	protected Semaphore executionWaiter = new Semaphore(0);

	protected boolean shallWaitBeforeNextStep;

	protected Set<Integer> breakpoints = Collections.synchronizedSet(new HashSet<Integer>());

	protected TestRunnerCallback callback;

	protected SetListCallback setListCallback;

	protected TestRunnerCallback currentCallback;

	protected Phase currentPhase;

	protected Map<VariableEntity, Object> variableStorage = new HashMap<VariableEntity, Object>();

	protected Map<Suite, List<SuiteDefinition>> setupMoments;

	protected IntegrityRemotingServer remotingServer;

	protected RemotingListener remotingListener;

	protected Map<ForkDefinition, Fork> forkMap = new LinkedHashMap<ForkDefinition, Fork>();

	protected String[] commandLineArguments;

	protected static final String MY_FORK_NAME = System.getenv(Forker.ENV_FORK_NAME);

	protected static final String FORK_CONNECTION_TIMEOUT_PROPERTY = "integrity.fork.timeout";

	protected static final int FORK_CONNECTION_TIMEOUT_DEFAULT = 180;

	protected static final int FORK_SINGLE_CONNECT_TIMEOUT = 10000;

	protected static final int FORK_CONNECT_DELAY = 5000;

	protected ForkDefinition forkInExecution;

	public TestRunner(TestModel aModel, TestRunnerCallback aCallback, Integer aRemotingPort,
			String[] someCommandLineArguments) throws IOException {
		model = aModel;
		callback = aCallback;
		commandLineArguments = someCommandLineArguments;
		Integer tempRemotingPort = aRemotingPort;
		if (isFork()) {
			tempRemotingPort = Integer.parseInt(System.getenv(Forker.ENV_FORK_REMOTING_PORT));
		}
		if (tempRemotingPort != null) {
			remotingListener = new RemotingListener();
			remotingServer = new IntegrityRemotingServer("0.0.0.0", tempRemotingPort, remotingListener);
		}
	}

	public SuiteResult run(SuiteDefinition aRootSuite, boolean aBlockForRemotingFlag) {
		Suite tempRootSuiteCall = DslFactory.eINSTANCE.createSuite();
		tempRootSuiteCall.setDefinition(aRootSuite);

		return run(tempRootSuiteCall, aBlockForRemotingFlag);
	}

	public SuiteResult run(Suite aRootSuiteCall, boolean aBlockForRemotingFlag) {
		boolean tempBlockForRemoting = isFork() ? false : aBlockForRemotingFlag;

		try {
			if (remotingServer != null) {
				currentPhase = Phase.DRY_RUN;
				SetList tempSetList = new SetList();
				reset();
				setListCallback = new SetListCallback(tempSetList, remotingServer, model.getClassLoader());
				currentCallback = setListCallback;

				currentCallback.setDryRun(true);
				runInternal(aRootSuiteCall);
				currentCallback.setDryRun(false);

				synchronized (setListWaiter) {
					setList = tempSetList;
					setListWaiter.notify();
				}

				if (tempBlockForRemoting) {
					try {
						waitForContinue(false);
					} catch (InterruptedException exc) {
						if (remotingServer != null) {
							remotingServer.closeAll(false);
						}
						return null;
					}
				}
				tempSetList.rewind();
				currentCallback = new CompoundTestRunnerCallback(setListCallback, callback);
			} else {
				currentCallback = callback;
			}

			currentPhase = Phase.TEST_RUN;
			reset();

			if (isFork()) {
				// the callback will require the remoting server to be able to push stuff to the master
				currentCallback.setRemotingServer(remotingServer);

				// we start out in "dry run" mode if we're a fork
				currentCallback.setDryRun(true);
			}

			return runInternal(aRootSuiteCall);
		} finally {
			if (remotingServer != null) {
				remotingServer.closeAll(true);
			}
		}
	}

	protected void reset() {
		variableStorage.clear();
		setupMoments = null;
	}

	protected SuiteResult runInternal(Suite aRootSuiteCall) {
		variableStorage = new HashMap<VariableEntity, Object>();

		if (currentCallback != null) {
			currentCallback.onExecutionStart(model, variableStorage);
		}

		setupMoments = findSetupMoments(aRootSuiteCall);

		for (VariableDefinition tempVariableDef : model.getVariableDefinitionsInPackages()) {
			defineVariable(tempVariableDef, null);
		}

		SuiteResult tempResult = callSuite(aRootSuiteCall, null);

		if (currentCallback != null) {
			currentCallback.onExecutionFinish(model, tempResult);
		}

		return tempResult;
	}

	protected SuiteResult callSuite(Suite aSuiteCall, ForkDefinition aFork) {
		if (currentPhase == Phase.TEST_RUN) {
			// all of this only has to be done in case of a real test run

			if (!isFork()) {
				// we're the master
				if (aSuiteCall.getFork() != null) {
					// set the currently executed entry to the suite call entry that will be created next
					// this signifies that a fork is about to be started executing the highlighted suite
					if (remotingServer != null) {
						remotingServer.updateSetList(setList.getEntryListPosition(), new SetListEntry[0]);
					}
					// we may need to start a new fork
					if (!forkMap.containsKey(aSuiteCall.getFork())) {
						try {
							forkMap.put(aSuiteCall.getFork(), createFork(aSuiteCall, aFork));
						} catch (ForkException exc) {
							// if forking fails, this is such a severe error that we cannot continue testing at all
							throw new RuntimeException(exc);
						}
					}
					// now a fork takes over
					forkInExecution = aSuiteCall.getFork();

					// and the master will perform all of this in dry run mode
					currentCallback.setDryRun(true);
				}
			} else {
				if (aSuiteCall.getFork() != null) {
					// at this point, a fork takes over
					forkInExecution = aSuiteCall.getFork();

					// now see if this is a job for us
					if (forkInExecution.getName().equals(MY_FORK_NAME)) {
						// we're a fork, and we are at a point where we're gonna execute some stuff
						// but we have to wait until our master gives us the 'go'!
						shallWaitBeforeNextStep = true;
						pauseIfRequiredByRemoteClient(true);

						// and now we leave dry run mode
						currentCallback.setDryRun(false);
					}
				}
			}
		}

		Map<SuiteDefinition, Result> tempSetupResults = new HashMap<SuiteDefinition, Result>();
		Map<SuiteDefinition, Result> tempTearDownResults = new HashMap<SuiteDefinition, Result>();

		if (currentCallback != null) {
			currentCallback.onSuiteStart(aSuiteCall);
		}

		List<SuiteDefinition> tempSetupSuites = setupMoments.get(aSuiteCall);
		if (tempSetupSuites != null) {
			for (SuiteDefinition tempSetupSuite : tempSetupSuites) {
				if (currentCallback != null) {
					currentCallback.onSetupStart(tempSetupSuite);
				}

				long tempStart = System.nanoTime();
				Map<SuiteStatementWithResult, Result> tempSuiteResults = executeSuite(tempSetupSuite, aFork);
				SuiteResult tempSetupResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempSuiteResults,
						null, null, System.nanoTime() - tempStart);
				tempSetupResults.put(tempSetupSuite, tempSetupResult);

				if (currentCallback != null) {
					currentCallback.onSetupFinish(tempSetupSuite, tempSetupResult);
				}
			}
		}

		for (SuiteParameter tempParam : aSuiteCall.getParameters()) {
			if (tempParam.getValue() instanceof Variable) {
				Variable tempVariable = (Variable) tempParam.getValue();
				defineVariable(tempParam.getName(), variableStorage.get(tempVariable.getName()),
						aSuiteCall.getDefinition());
			} else {
				defineVariable(tempParam.getName(), tempParam.getValue(), aSuiteCall.getDefinition());
			}
		}

		long tempSuiteDuration = System.nanoTime();
		Map<SuiteStatementWithResult, Result> tempResults = executeSuite(aSuiteCall.getDefinition(), aFork);
		tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

		if (tempSetupSuites != null) {
			Set<SuiteDefinition> tempExecutedTearDownSuites = new HashSet<SuiteDefinition>();
			for (SuiteDefinition tempSetupSuite : tempSetupSuites) {
				for (SuiteDefinition tempTearDownSuite : tempSetupSuite.getFinalizers()) {
					if (!tempExecutedTearDownSuites.contains(tempTearDownSuite)) {
						tempExecutedTearDownSuites.add(tempTearDownSuite);

						if (currentCallback != null) {
							currentCallback.onTearDownStart(tempTearDownSuite);
						}

						long tempStart = System.nanoTime();
						Map<SuiteStatementWithResult, Result> tempSuiteResults = executeSuite(tempTearDownSuite, aFork);
						SuiteResult tempTearDownResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(
								tempSuiteResults, null, null, System.nanoTime() - tempStart);
						tempTearDownResults.put(tempTearDownSuite, tempTearDownResult);

						if (currentCallback != null) {
							currentCallback.onTearDownFinish(tempTearDownSuite, tempTearDownResult);
						}
					}
				}
			}
		}

		SuiteResult tempResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempResults, tempSetupResults,
				tempTearDownResults, tempSuiteDuration);

		if (currentCallback != null) {
			currentCallback.onSuiteFinish(aSuiteCall, tempResult);
		}

		if (currentPhase == Phase.TEST_RUN) {
			// all of this only has to be done in case of a real test run

			if (forkInExecution != null && forkInExecution.equals(aSuiteCall.getFork())) {
				if (!isFork()) {
					// we're the master and need to kick off the fork, which then actually executes the stuff we've just
					// jumped over
					forkMap.get(forkInExecution).executeNextSegment();

					// and afterwards we'll switch back to real test mode
					currentCallback.setDryRun(false);
				} else {
					// we're a fork and will return to dry run mode
					currentCallback.setDryRun(true);
				}
				forkInExecution = null;
			}
		}

		return tempResult;
	}

	protected Map<SuiteStatementWithResult, Result> executeSuite(SuiteDefinition aSuite, ForkDefinition aFork) {
		Map<SuiteStatementWithResult, Result> tempResults = new LinkedHashMap<SuiteStatementWithResult, Result>();

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof Suite) {
				tempResults.put((Suite) tempStatement, callSuite((Suite) tempStatement, aFork));
			} else if (tempStatement instanceof Test) {
				tempResults.put((Test) tempStatement, executeTest((Test) tempStatement));
			} else if (tempStatement instanceof TableTest) {
				tempResults.put((TableTest) tempStatement, executeTableTest((TableTest) tempStatement));
			} else if (tempStatement instanceof Call) {
				executeCall((Call) tempStatement);
			} else if (tempStatement instanceof VariableDefinition) {
				defineVariable((VariableDefinition) tempStatement, aSuite);
			} else if (tempStatement instanceof VisibleSingleLineComment) {
				if (currentCallback != null) {
					currentCallback.onVisibleComment(IntegrityDSLUtil
							.cleanSingleLineComment((VisibleSingleLineComment) tempStatement));
				}
			} else if (tempStatement instanceof VisibleMultiLineComment) {
				if (currentCallback != null) {
					currentCallback.onVisibleComment(IntegrityDSLUtil
							.cleanMultiLineComment((VisibleMultiLineComment) tempStatement));
				}
			}
		}

		return tempResults;
	}

	protected void defineVariable(VariableDefinition aDefinition, SuiteDefinition aSuite) {
		defineVariable(aDefinition.getName(), aDefinition.getInitialValue(), aSuite);
	}

	protected void defineVariable(VariableEntity anEntity, Object anInitialValue, SuiteDefinition aSuite) {
		Object tempInitialValue = null;
		if (anInitialValue instanceof Variable) {
			tempInitialValue = variableStorage.get(anInitialValue);
		} else {
			tempInitialValue = anInitialValue;
		}

		variableStorage.put(anEntity, tempInitialValue);
		if (currentCallback != null) {
			currentCallback.onVariableDefinition(anEntity, aSuite, tempInitialValue);
		}
	}

	protected void setVariableValue(VariableEntity anEntity, Object aValue, boolean aDoSendUpdateFlag) {
		variableStorage.put(anEntity, aValue);
		if (aDoSendUpdateFlag) {
			if (isFork()) {
				// A fork will have to send updates to its master
				if (remotingServer != null) {
					String tempName = IntegrityDSLUtil.getQualifiedVariableEntityName(anEntity, true);
					if (aValue instanceof Serializable) {
						remotingServer.sendVariableUpdate(tempName, (Serializable) aValue);
					} else {
						System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempName
								+ "' TO MASTER - VALUE NOT SERIALIZABLE!");
					}
				}
			} else {
				// The master will have to update all active forks.
				for (Entry<ForkDefinition, Fork> tempEntry : forkMap.entrySet()) {
					tempEntry.getValue().updateVariableValue(anEntity, aValue);
				}
			}
		}
	}

	protected void setVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag) {
		for (VariableEntity tempEntity : variableStorage.keySet()) {
			if (IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true).equals(aQualifiedVariableName)) {
				setVariableValue(tempEntity, aValue, aDoSendUpdateFlag);
				return;
			}
		}
	}

	protected TestResult executeTest(Test aTest) {
		if (currentCallback != null) {
			currentCallback.onTestStart(aTest);
		}

		TestResult tempReturn = null;
		TestComparisonResult tempComparisonResult;
		Exception tempException = null;
		Long tempDuration = null;

		Map<String, TestComparisonResult> tempComparisonMap = new LinkedHashMap<String, TestComparisonResult>();
		if (!shouldExecuteFixtures()) {
			if (aTest.getResults() != null && aTest.getResults().size() > 0) {
				for (NamedResult tempNamedResult : aTest.getResults()) {
					String tempParameter = IntegrityDSLUtil
							.getExpectedResultNameStringFromTestResultName(tempNamedResult.getName());
					tempComparisonResult = new TestComparisonUndeterminedResult(tempParameter,
							tempNamedResult.getValue());
					tempComparisonMap.put(tempParameter, tempComparisonResult);
				}
			} else {
				tempComparisonResult = new TestComparisonUndeterminedResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
						aTest.getResult());
				tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
			}
		} else {
			pauseIfRequiredByRemoteClient(false);

			Map<String, Object> tempParameters = IntegrityDSLUtil.createParameterMap(aTest, variableStorage, true);

			long tempStart = System.nanoTime();
			try {
				Object tempFixtureResult = executeFixtureMethod(aTest.getDefinition().getFixtureMethod(),
						tempParameters);
				tempDuration = System.nanoTime() - tempStart;

				if (aTest.getResults() != null && aTest.getResults().size() > 0) {
					Map<String, Object> tempFixtureResultMap = ParameterUtil
							.getValuesFromNamedResultContainer(tempFixtureResult);

					for (NamedResult tempNamedResult : aTest.getResults()) {
						String tempResultName = IntegrityDSLUtil
								.getExpectedResultNameStringFromTestResultName(tempNamedResult.getName());
						Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);
						if (compareResult(tempSingleFixtureResult, tempNamedResult.getValue())) {
							tempComparisonResult = new TestComparisonSuccessResult(tempResultName,
									tempSingleFixtureResult, tempNamedResult.getValue());
						} else {
							tempComparisonResult = new TestComparisonFailureResult(tempResultName,
									tempSingleFixtureResult, tempNamedResult.getValue());
						}
						tempComparisonMap.put(tempResultName, tempComparisonResult);
					}
				} else {
					if (compareResult(tempFixtureResult, aTest.getResult())) {
						tempComparisonResult = new TestComparisonSuccessResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
								tempFixtureResult, aTest.getResult());
					} else {
						tempComparisonResult = new TestComparisonFailureResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
								tempFixtureResult, aTest.getResult());
					}
					tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Exception exc) {
				tempDuration = System.nanoTime() - tempStart;
				tempException = exc;
				tempComparisonResult = new TestComparisonUndeterminedResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
						aTest.getResult());
				tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
			}
		}

		List<TestSubResult> tempSubResults = new LinkedList<TestSubResult>();
		if (tempException != null) {
			tempSubResults.add(new TestExceptionSubResult(tempException, tempComparisonMap, tempDuration));
		} else {
			tempSubResults.add(new TestExecutedSubResult(tempComparisonMap, tempDuration));
		}
		tempReturn = new TestResult(tempSubResults, tempDuration);

		if (currentCallback != null) {
			currentCallback.onTestFinish(aTest, tempReturn);
		}

		return tempReturn;
	}

	protected TestResult executeTableTest(TableTest aTest) {
		if (currentCallback != null) {
			currentCallback.onTableTestStart(aTest);
		}

		if (currentPhase == Phase.TEST_RUN) {
			pauseIfRequiredByRemoteClient(false);
		}

		List<TestSubResult> tempSubResults = new LinkedList<TestSubResult>();
		long tempOuterStart = System.nanoTime();

		for (TableTestRow tempRow : aTest.getRows()) {
			if (currentCallback != null) {
				currentCallback.onTableTestRowStart(aTest, tempRow);
			}

			Map<String, TestComparisonResult> tempComparisonMap = new LinkedHashMap<String, TestComparisonResult>();
			TestComparisonResult tempComparisonResult = null;
			Exception tempException = null;
			Long tempDuration = null;

			if (!shouldExecuteFixtures()) {
				if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
					int tempColumn = aTest.getParameterHeaders().size();
					for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
						String tempParameter = IntegrityDSLUtil
								.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
						ValueOrEnumValue tempExpectedValue = (tempColumn < tempRow.getValues().size()) ? tempRow
								.getValues().get(tempColumn).getValue() : null;
						tempComparisonResult = new TestComparisonUndeterminedResult(tempParameter, tempExpectedValue);
						tempComparisonMap.put(tempParameter, tempComparisonResult);

						tempColumn++;
					}
				} else {
					tempComparisonResult = new TestComparisonUndeterminedResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
							tempRow.getResult());
					tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
				}
			} else {
				Map<String, Object> tempParameters = IntegrityDSLUtil.createParameterMap(aTest, tempRow,
						variableStorage, true);

				long tempStart = System.nanoTime();
				try {
					Object tempFixtureResult = executeFixtureMethod(aTest.getDefinition().getFixtureMethod(),
							tempParameters);
					tempDuration = System.nanoTime() - tempStart;

					if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
						Map<String, Object> tempFixtureResultMap = ParameterUtil
								.getValuesFromNamedResultContainer(tempFixtureResult);

						int tempColumn = aTest.getParameterHeaders().size();
						for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
							String tempResultName = IntegrityDSLUtil
									.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
							ValueOrEnumValue tempExpectedValue = (tempColumn < tempRow.getValues().size()) ? tempRow
									.getValues().get(tempColumn).getValue() : null;

							Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);

							if (compareResult(tempSingleFixtureResult, tempExpectedValue)) {
								tempComparisonResult = new TestComparisonSuccessResult(tempResultName,
										tempSingleFixtureResult, tempExpectedValue);
							} else {
								tempComparisonResult = new TestComparisonFailureResult(tempResultName,
										tempSingleFixtureResult, tempExpectedValue);
							}
							tempComparisonMap.put(tempResultName, tempComparisonResult);

							tempColumn++;
						}
					} else {
						if (compareResult(tempFixtureResult, tempRow.getResult())) {
							tempComparisonResult = new TestComparisonSuccessResult(
									ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult, tempRow.getResult());
						} else {
							tempComparisonResult = new TestComparisonFailureResult(
									ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult, tempRow.getResult());
						}
						tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
					}
					// SUPPRESS CHECKSTYLE IllegalCatch
				} catch (Exception exc) {
					tempDuration = System.nanoTime() - tempStart;
					tempException = exc;
					// add undetermined result entries for all comparisons
					if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
						int tempColumn = aTest.getParameterHeaders().size();
						for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
							String tempResultName = IntegrityDSLUtil
									.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
							ValueOrEnumValue tempExpectedValue = (tempColumn < tempRow.getValues().size()) ? tempRow
									.getValues().get(tempColumn).getValue() : null;
							tempComparisonResult = new TestComparisonUndeterminedResult(tempResultName,
									tempExpectedValue);
							tempComparisonMap.put(tempResultName, tempComparisonResult);
							tempColumn++;
						}
					} else {
						tempComparisonResult = new TestComparisonUndeterminedResult(
								ParameterUtil.DEFAULT_PARAMETER_NAME, tempRow.getResult());
						tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
					}
				}
			}

			TestSubResult tempSubResult;

			if (tempException != null) {
				tempSubResult = new TestExceptionSubResult(tempException, tempComparisonMap, tempDuration);
			} else {
				tempSubResult = new TestExecutedSubResult(tempComparisonMap, tempDuration);
			}
			tempSubResults.add(tempSubResult);

			if (currentCallback != null) {
				currentCallback.onTableTestRowFinish(aTest, tempRow, tempSubResult);
			}
		}

		Long tempOuterDuration = System.nanoTime() - tempOuterStart;

		TestResult tempReturn = new TestResult(tempSubResults, currentPhase == Phase.DRY_RUN ? null : tempOuterDuration);

		if (currentCallback != null) {
			currentCallback.onTableTestFinish(aTest, tempReturn);
		}

		return tempReturn;
	}

	protected Object executeFixtureMethod(MethodReference aMethod, Map<String, Object> someParameters)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> tempFixtureClass = getClassForJvmType(aMethod.getType());
		Fixture tempFixtureInstance = (Fixture) tempFixtureClass.newInstance();
		return tempFixtureInstance.execute(aMethod.getMethod().getSimpleName(), someParameters);
	}

	protected Class<?> getClassForJvmType(JvmType aType) throws ClassNotFoundException {
		return model.getInjector().getInstance(ClassLoader.class).loadClass(aType.getQualifiedName());
	}

	protected boolean compareResult(Object aFixtureResult, ValueOrEnumValue anExpectedResult) {
		if (anExpectedResult != null) {
			Object tempConvertedResult = ParameterUtil.convertEncapsulatedValueToParamType(aFixtureResult.getClass(),
					anExpectedResult, variableStorage);
			return tempConvertedResult.equals(aFixtureResult);
		} else {
			if (aFixtureResult instanceof Boolean) {
				return (Boolean) aFixtureResult;
			} else {
				throw new IllegalArgumentException("If no expected test result is given, "
						+ "the test fixture must return a boolean result!");
			}
		}
	}

	protected CallResult executeCall(Call aCall) {
		if (currentCallback != null) {
			currentCallback.onCallStart(aCall);
		}

		CallResult tempReturn;
		if (!shouldExecuteFixtures()) {
			tempReturn = new de.gebit.integrity.runner.results.call.UndeterminedResult(
					aCall.getResult() != null ? aCall.getResult().getName() : null);
		} else {
			pauseIfRequiredByRemoteClient(false);

			Map<String, Object> tempParameters = IntegrityDSLUtil.createParameterMap(aCall, variableStorage, true);

			long tempStart = System.nanoTime();
			try {
				Object tempResult = executeFixtureMethod(aCall.getDefinition().getFixtureMethod(), tempParameters);
				long tempDuration = System.nanoTime() - tempStart;

				if (aCall.getResult() == null) {
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempResult, null,
							tempDuration);
				} else {
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempResult, aCall.getResult()
							.getName(), tempDuration);
					setVariableValue(aCall.getResult().getName(), tempResult, true);
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Exception exc) {
				tempReturn = new de.gebit.integrity.runner.results.call.ExceptionResult(exc,
						aCall.getResult() != null ? aCall.getResult().getName() : null, System.nanoTime() - tempStart);
			}
		}

		if (currentCallback != null) {
			currentCallback.onCallFinish(aCall, tempReturn);
		}

		return tempReturn;
	}

	protected static Map<Suite, List<SuiteDefinition>> findSetupMoments(Suite aSuiteCall) {
		return recursiveFindSetupMoments(aSuiteCall, new HashSet<SuiteDefinition>(), new HashSet<SuiteDefinition>());
	}

	protected static Map<Suite, List<SuiteDefinition>> recursiveFindSetupMoments(Suite aSuiteCall,
			Set<SuiteDefinition> someAlreadyCoveredDependencies, Set<SuiteDefinition> someAlreadyVisitedSuites) {
		SuiteDefinition tempSuite = aSuiteCall.getDefinition();
		Map<Suite, List<SuiteDefinition>> tempResults = new HashMap<Suite, List<SuiteDefinition>>();
		someAlreadyVisitedSuites.add(tempSuite);

		// first add our own dependencies, if not already covered
		for (SuiteDefinition tempDependency : recursiveListSuiteDependencies(tempSuite)) {
			if (!someAlreadyCoveredDependencies.contains(tempDependency)) {
				List<SuiteDefinition> tempDependencyList = tempResults.get(aSuiteCall);
				if (tempDependencyList == null) {
					tempDependencyList = new LinkedList<SuiteDefinition>();
					tempResults.put(aSuiteCall, tempDependencyList);
				}
				tempDependencyList.add(tempDependency);
				someAlreadyCoveredDependencies.add(tempDependency);
			}
		}

		// then descend down into other called suites
		for (SuiteStatement tempStatement : tempSuite.getStatements()) {
			if (tempStatement instanceof Suite) {
				Suite tempSuiteCall = (Suite) tempStatement;
				if (!someAlreadyVisitedSuites.contains(tempSuiteCall.getDefinition())) {
					Map<Suite, List<SuiteDefinition>> tempRecursiveResults = recursiveFindSetupMoments(tempSuiteCall,
							someAlreadyCoveredDependencies, someAlreadyVisitedSuites);

					// add sub-results to our own results
					for (Entry<Suite, List<SuiteDefinition>> tempEntry : tempRecursiveResults.entrySet()) {
						tempResults.put(tempEntry.getKey(), tempEntry.getValue());
					}
				}
			}
		}

		return tempResults;
	}

	protected static List<SuiteDefinition> recursiveListSuiteDependencies(SuiteDefinition aSuite) {
		List<SuiteDefinition> tempResults = new LinkedList<SuiteDefinition>(aSuite.getDependencies());
		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof Suite) {
				tempResults.addAll(recursiveListSuiteDependencies(((Suite) tempStatement).getDefinition()));
			}
		}
		return tempResults;
	}

	protected static List<SuiteDefinition> recursiveListSuiteFinalizers(SuiteDefinition aSuite) {
		List<SuiteDefinition> tempResults = new LinkedList<SuiteDefinition>(aSuite.getFinalizers());
		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof Suite) {
				tempResults.addAll(0, recursiveListSuiteFinalizers(((Suite) tempStatement).getDefinition()));
			}
		}
		return tempResults;
	}

	/**
	 * Test execution is splitted in phases.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	protected enum Phase {

		DRY_RUN,

		TEST_RUN;

	}

	protected boolean shouldExecuteFixtures() {
		if (currentPhase == Phase.DRY_RUN) {
			return false;
		} else {
			if (MY_FORK_NAME != null) {
				return (forkInExecution != null && forkInExecution.getName().equals(MY_FORK_NAME));
			} else {
				return (forkInExecution == null);
			}
		}
	}

	protected void pauseIfRequiredByRemoteClient(boolean aForkSyncFlag) {
		if (remotingServer == null) {
			return;
		}

		Integer tempLastTestOrCallEntryRef = setList.getLastCreatedEntryId(SetListEntryTypes.CALL,
				SetListEntryTypes.TEST);

		if (tempLastTestOrCallEntryRef != null && breakpoints.contains(tempLastTestOrCallEntryRef)) {
			removeBreakpoint(tempLastTestOrCallEntryRef);
		} else if (shallWaitBeforeNextStep) {
			shallWaitBeforeNextStep = false;
		} else {
			// do not wait
			return;
		}

		try {
			waitForContinue(aForkSyncFlag);
		} catch (InterruptedException exc) {
			// just continue
		}
	}

	protected void waitForContinue(boolean aForkSyncFlag) throws InterruptedException {
		if (aForkSyncFlag) {
			remotingServer.updateExecutionState(ExecutionStates.PAUSED_SYNC);
		} else {
			remotingServer.updateExecutionState(ExecutionStates.PAUSED);
		}
		executionWaiter.acquire();
		executionWaiter.drainPermits();
		remotingServer.updateExecutionState(ExecutionStates.RUNNING);
	}

	protected void removeBreakpoint(int anEntryReference) {
		// forward to forks
		for (Entry<ForkDefinition, Fork> tempForkEntry : forkMap.entrySet()) {
			tempForkEntry.getValue().getClient().createBreakpoint(anEntryReference);
		}

		// then perform for ourself
		if (breakpoints.remove(anEntryReference)) {
			remotingServer.confirmBreakpointRemoval(anEntryReference);
		}
	}

	protected void createBreakpoint(int anEntryReference) {
		// forward to forks
		for (Entry<ForkDefinition, Fork> tempForkEntry : forkMap.entrySet()) {
			tempForkEntry.getValue().getClient().createBreakpoint(anEntryReference);
		}

		// then perform for ourself
		if (breakpoints.add(anEntryReference)) {
			remotingServer.confirmBreakpointCreation(anEntryReference);
		}
	}

	/**
	 * The listener used to respond on actions triggered by remoting clients.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	protected class RemotingListener implements IntegrityRemotingServerListener {

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSetListRequest(Endpoint anEndpoint) {
			synchronized (setListWaiter) {
				while (setList == null) {
					try {
						setListWaiter.wait();
					} catch (InterruptedException exc) {
						// don't care
					}
				}

				anEndpoint.sendMessage(new SetListBaselineMessage(setList));
				for (Integer tempBreakpoint : breakpoints) {
					anEndpoint.sendMessage(new BreakpointUpdateMessage(BreakpointActions.CREATE, tempBreakpoint));
				}
			}
		}

		@Override
		public void onRunCommand(Endpoint anEndpoint) {
			if (!isFork() && forkInExecution != null) {
				// if we're the master and a fork is active, we're waiting for a fork, thus this command
				// is meant for the fork
				forkMap.get(forkInExecution).getClient().controlExecution(ExecutionCommands.RUN);
			} else {
				executionWaiter.release();
			}
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			// I don't care
		}

		@Override
		public void onPauseCommand(Endpoint anEndpoint) {
			if (!isFork() && forkInExecution != null) {
				// if we're the master and a fork is active, we're waiting for a fork, thus this command
				// is meant for the fork
				forkMap.get(forkInExecution).getClient().controlExecution(ExecutionCommands.PAUSE);
			} else {
				shallWaitBeforeNextStep = true;
			}
		}

		@Override
		public void onStepIntoCommand(Endpoint anEndpoint) {
			if (!isFork() && forkInExecution != null) {
				// if we're the master and a fork is active, we're waiting for a fork, thus this command
				// is meant for the fork
				forkMap.get(forkInExecution).getClient().controlExecution(ExecutionCommands.STEP_INTO);
			} else {
				shallWaitBeforeNextStep = true;
				executionWaiter.release();
			}
		}

		@Override
		public void onCreateBreakpoint(int anEntryReference, Endpoint anEndpoint) {
			createBreakpoint(anEntryReference);
		}

		@Override
		public void onRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint) {
			removeBreakpoint(anEntryReference);
		}

		@Override
		public void onVariableUpdateRetrieval(String aVariableName, Serializable aValue) {
			setVariableValue(aVariableName, aValue, false);
		}
	}

	public static boolean isFork() {
		return MY_FORK_NAME != null;
	}

	protected Fork createFork(Suite aSuiteCall, ForkDefinition aFork) throws ForkException {
		Fork tempFork = new Fork(aSuiteCall.getFork(), commandLineArguments,
				remotingServer != null ? remotingServer.getPort() : IntegrityRemotingConstants.DEFAULT_PORT,
				currentCallback, setList, remotingServer, new ForkCallback() {

					@Override
					public void onSetVariableValue(String aQualifiedVariableName, Object aValue,
							boolean aDoSendUpdateFlag) {
						setVariableValue(aQualifiedVariableName, aValue, aDoSendUpdateFlag);
					}

					@Override
					public void onForkExit(Fork aFork) {
						for (Entry<ForkDefinition, Fork> tempEntry : forkMap.entrySet()) {
							if (tempEntry.getValue() == aFork) {
								forkMap.remove(tempEntry.getKey());
								return;
							}
						}
					}
				});

		long tempTimeout = System.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY) != null ? Integer.parseInt(System
				.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY)) : FORK_CONNECTION_TIMEOUT_DEFAULT;

		long tempStartTime = System.nanoTime();
		while (System.nanoTime() - tempStartTime < (tempTimeout * 1000 * 1000000)) {
			try {
				if (tempFork.connect(FORK_SINGLE_CONNECT_TIMEOUT)) {
					break;
				}
			} catch (IOException exc) {
				// this is expected -> will simply retry
			}

			try {
				Thread.sleep(FORK_CONNECT_DELAY);
			} catch (InterruptedException exc) {
				// ignored
			}
		}

		if (tempFork.isAlive() && tempFork.isConnected()) {
			// initially, we'll send a snapshot of all current non-encapsulated variable values to the fork
			// (encapsulated values are predefined in the test script and thus already known to the fork)
			for (Entry<VariableEntity, Object> tempEntry : variableStorage.entrySet()) {
				if (!(tempEntry.getValue() instanceof ValueOrEnumValue)) {
					tempFork.updateVariableValue(tempEntry.getKey(), tempEntry.getValue());
				}
			}

			// and the fork will also need all current breakpoints
			for (Integer tempBreakpoint : breakpoints) {
				tempFork.getClient().createBreakpoint(tempBreakpoint);
			}

			return tempFork;
		} else {
			tempFork.kill();
			throw new ForkException("Could not successfully establish a control connection to the fork.");
		}
	}

}
