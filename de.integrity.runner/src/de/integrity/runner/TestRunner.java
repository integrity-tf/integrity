package de.integrity.runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Semaphore;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmType;

import de.integrity.dsl.Call;
import de.integrity.dsl.DslFactory;
import de.integrity.dsl.MethodReference;
import de.integrity.dsl.Parameter;
import de.integrity.dsl.Suite;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.SuiteParameter;
import de.integrity.dsl.SuiteStatement;
import de.integrity.dsl.SuiteStatementWithResult;
import de.integrity.dsl.Test;
import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.dsl.Variable;
import de.integrity.dsl.VariableDefinition;
import de.integrity.dsl.VariableEntity;
import de.integrity.fixtures.Fixture;
import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.server.IntegrityRemotingServer;
import de.integrity.remoting.server.IntegrityRemotingServerListener;
import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.enums.ExecutionStates;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.integrity.runner.callbacks.TestRunnerCallback;
import de.integrity.runner.callbacks.remoting.SetListCallback;
import de.integrity.runner.results.Result;
import de.integrity.runner.results.SuiteResult;
import de.integrity.runner.results.call.CallResult;
import de.integrity.runner.results.test.ExceptionResult;
import de.integrity.runner.results.test.FailureResult;
import de.integrity.runner.results.test.SuccessResult;
import de.integrity.runner.results.test.TestResult;
import de.integrity.runner.results.test.UndeterminedResult;
import de.integrity.utils.IntegrityDSLUtil;
import de.integrity.utils.ParameterUtil;

public class TestRunner {

	protected TestModel model;

	protected SetList setList;

	protected Object setListWaiter = new Object();

	protected Semaphore executionWaiter = new Semaphore(0);

	protected TestRunnerCallback callback;

	protected TestRunnerCallback currentCallback;

	protected Phase currentPhase;

	protected Map<VariableEntity, Object> variableStorage = new HashMap<VariableEntity, Object>();

	protected Map<Suite, List<SuiteDefinition>> setupMoments;

	protected IntegrityRemotingServer remotingServer;

	protected RemotingListener remotingListener;

	public TestRunner(TestModel aModel, TestRunnerCallback aCallback, Integer aRemotingPort) throws IOException {
		model = aModel;
		callback = aCallback;
		if (aRemotingPort != null) {
			remotingListener = new RemotingListener();
			remotingServer = new IntegrityRemotingServer("0.0.0.0", aRemotingPort, remotingListener);
		}
	}

	public SuiteResult run(SuiteDefinition aRootSuite, boolean aBlockForRemotingFlag) {
		Suite tempRootSuiteCall = DslFactory.eINSTANCE.createSuite();
		tempRootSuiteCall.setDefinition(aRootSuite);

		return run(tempRootSuiteCall, aBlockForRemotingFlag);
	}

	public SuiteResult run(Suite aRootSuiteCall, boolean aBlockForRemotingFlag) {
		try {
			if (remotingServer != null) {
				currentPhase = Phase.DRY_RUN;
				SetList tempSetList = new SetList();
				reset();
				SetListCallback tempSetListCallback = new SetListCallback(tempSetList, remotingServer,
						model.getClassLoader());
				currentCallback = tempSetListCallback;

				runInternal(aRootSuiteCall);

				synchronized (setListWaiter) {
					setList = tempSetList;
					setListWaiter.notify();
				}

				if (aBlockForRemotingFlag) {
					try {
						waitForContinue();
					} catch (InterruptedException exc) {
						if (remotingServer != null) {
							remotingServer.closeAll(false);
						}
						return null;
					}
				}
				tempSetList.rewind();
				currentCallback = new CompoundTestRunnerCallback(tempSetListCallback, callback);
			} else {
				currentCallback = callback;
			}

			currentPhase = Phase.TEST_RUN;
			reset();

			return runInternal(aRootSuiteCall);
		} finally {
			if (remotingServer != null) {
				remotingServer.closeAll(true);
			}
		}
	}

	protected void reset() {
		variableStorage = new HashMap<VariableEntity, Object>();
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

		SuiteResult tempResult = callSuite(aRootSuiteCall);

		if (currentCallback != null) {
			currentCallback.onExecutionFinish(model, tempResult);
		}

		return tempResult;
	}

	protected SuiteResult callSuite(Suite aSuiteCall) {
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
				Map<SuiteStatementWithResult, Result> tempSuiteResults = executeSuite(tempSetupSuite);
				SuiteResult tempSetupResult = (currentPhase == Phase.DRY_RUN) ? null : new SuiteResult(
						tempSuiteResults, null, null, System.nanoTime() - tempStart);
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
		Map<SuiteStatementWithResult, Result> tempResults = executeSuite(aSuiteCall.getDefinition());
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
						Map<SuiteStatementWithResult, Result> tempSuiteResults = executeSuite(tempTearDownSuite);
						SuiteResult tempTearDownResult = (currentPhase == Phase.DRY_RUN) ? null : new SuiteResult(
								tempSuiteResults, null, null, System.nanoTime() - tempStart);
						tempTearDownResults.put(tempTearDownSuite, tempTearDownResult);

						if (currentCallback != null) {
							currentCallback.onTearDownFinish(tempTearDownSuite, tempTearDownResult);
						}
					}
				}
			}
		}

		SuiteResult tempResult = (currentPhase == Phase.DRY_RUN ? null : new SuiteResult(tempResults, tempSetupResults,
				tempTearDownResults, tempSuiteDuration));

		if (currentCallback != null) {
			currentCallback.onSuiteFinish(aSuiteCall, tempResult);
		}

		return tempResult;
	}

	protected Map<SuiteStatementWithResult, Result> executeSuite(SuiteDefinition aSuite) {
		Map<SuiteStatementWithResult, Result> tempResults = new HashMap<SuiteStatementWithResult, Result>();

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			if (tempStatement instanceof Suite) {
				tempResults.put((Suite) tempStatement, callSuite((Suite) tempStatement));
			} else if (tempStatement instanceof Test) {
				tempResults.put((Test) tempStatement, executeTest((Test) tempStatement));
			} else if (tempStatement instanceof Call) {
				executeCall((Call) tempStatement);
			} else if (tempStatement instanceof VariableDefinition) {
				defineVariable((VariableDefinition) tempStatement, aSuite);
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

	protected TestResult executeTest(Test aTest) {
		if (currentCallback != null) {
			currentCallback.onTestStart(aTest);
		}

		TestResult tempReturn;

		if (currentPhase == Phase.DRY_RUN) {
			tempReturn = new UndeterminedResult(aTest.getResult());
		} else {
			long tempStart = System.nanoTime();
			try {
				Object tempResult = executeFixtureMethod(aTest.getDefinition().getFixtureMethod(),
						aTest.getParameters());
				long tempDuration = System.nanoTime() - tempStart;

				if (compareResult(tempResult, aTest.getResult())) {
					tempReturn = new SuccessResult(tempResult, aTest.getResult(), tempDuration);
				} else {
					tempReturn = new FailureResult(tempResult, aTest.getResult(), tempDuration);
				}
			} catch (Exception e) {
				tempReturn = new ExceptionResult(e, aTest.getResult(), System.nanoTime() - tempStart);
			}
		}

		if (currentCallback != null) {
			currentCallback.onTestFinish(aTest, tempReturn);
		}

		return tempReturn;
	}

	protected Object executeFixtureMethod(MethodReference aMethod, EList<Parameter> someParameters)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> tempFixtureClass = getClassForJvmType(aMethod.getType());

		Fixture tempFixtureInstance = (Fixture) tempFixtureClass.newInstance();

		return tempFixtureInstance.execute(aMethod.getMethod().getSimpleName(),
				IntegrityDSLUtil.createParameterMap(someParameters, variableStorage));
	}

	protected Class<?> getClassForJvmType(JvmType aType) throws ClassNotFoundException {
		return model.getInjector().getInstance(ClassLoader.class).loadClass(aType.getQualifiedName());
	}

	protected boolean compareResult(Object aFixtureResult, ValueOrEnumValue aModelResult) {
		if (aModelResult != null) {
			Object tempConvertedResult = ParameterUtil.convertValueToParamType(aFixtureResult.getClass(), aModelResult,
					variableStorage);
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
		if (currentPhase == Phase.DRY_RUN) {
			tempReturn = new de.integrity.runner.results.call.UndeterminedResult(aCall.getResult().getName());
		} else {
			long tempStart = System.nanoTime();
			try {
				Object tempResult = executeFixtureMethod(aCall.getDefinition().getFixtureMethod(),
						aCall.getParameters());
				long tempDuration = System.nanoTime() - tempStart;

				if (aCall.getResult() == null) {
					tempReturn = new de.integrity.runner.results.call.SuccessResult(tempResult, null, tempDuration);
				} else {
					tempReturn = new de.integrity.runner.results.call.SuccessResult(tempResult, aCall.getResult()
							.getName(), tempDuration);
					variableStorage.put(aCall.getResult().getName(), tempResult);
				}
			} catch (Exception e) {
				tempReturn = new de.integrity.runner.results.call.ExceptionResult(e, aCall.getResult() != null ? aCall
						.getResult().getName() : null, System.nanoTime() - tempStart);
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

	protected enum Phase {

		DRY_RUN,

		TEST_RUN;

	}

	protected void waitForContinue() throws InterruptedException {
		remotingServer.updateExecutionState(ExecutionStates.PAUSED);
		executionWaiter.acquire();
		executionWaiter.drainPermits();
		remotingServer.updateExecutionState(ExecutionStates.RUNNING);
	}

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
			}
		}

		@Override
		public void onRunCommand(Endpoint anEndpoint) {
			executionWaiter.release();
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			// I don't care
		}
	}

}
