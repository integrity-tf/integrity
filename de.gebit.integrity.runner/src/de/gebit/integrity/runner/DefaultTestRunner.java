/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Semaphore;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import de.gebit.integrity.classloading.IntegrityClassLoader;
import de.gebit.integrity.comparator.ComparisonResult;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ConstantValue;
import de.gebit.integrity.dsl.DslFactory;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.dsl.VisibleMultiLineComment;
import de.gebit.integrity.dsl.VisibleMultiLineTitleComment;
import de.gebit.integrity.dsl.VisibleSingleLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineTitleComment;
import de.gebit.integrity.exceptions.AbortExecutionException;
import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.ExtendedResultFixture.FixtureInvocationResult;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.forker.ForkerParameter;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
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
import de.gebit.integrity.runner.comparator.ResultComparator;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.runner.forking.DefaultForker;
import de.gebit.integrity.runner.forking.Fork;
import de.gebit.integrity.runner.forking.ForkCallback;
import de.gebit.integrity.runner.forking.ForkException;
import de.gebit.integrity.runner.forking.ForkResultSummary;
import de.gebit.integrity.runner.forking.Forker;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.modelcheck.ModelChecker;
import de.gebit.integrity.runner.operations.RandomNumberOperation;
import de.gebit.integrity.runner.results.Result;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.call.CallResult.UpdatedVariable;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonUndeterminedResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.runner.wrapper.AbortExecutionCauseWrapper;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The test runner executes tests. This class is the core of the Integrity runtime system.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultTestRunner implements TestRunner {

	/**
	 * The test model being executed.
	 */
	protected TestModel model;

	/**
	 * The current setlist.
	 */
	protected SetList setList;

	/**
	 * A waiter object used by remoting while waiting for the setlist to be created.
	 */
	protected Object setListWaiter = new Object();

	/**
	 * A semaphore used for single-stepping tests.
	 */
	protected Semaphore executionWaiter = new Semaphore(0);

	/**
	 * Whether the test runner shall pause before executing the next step.
	 */
	protected boolean shallWaitBeforeNextStep;

	/**
	 * All enabled breakpoints.
	 */
	protected Set<Integer> breakpoints = Collections.synchronizedSet(new HashSet<Integer>());

	/**
	 * The callback provided by the creator of the {@link TestRunner}.
	 */
	protected TestRunnerCallback callback;

	/**
	 * The setlist callback (used to create/update the setlist).
	 */
	protected SetListCallback setListCallback;

	/**
	 * The currently used callback, that is, the callback that gets directly called during execution.
	 */
	protected TestRunnerCallback currentCallback;

	/**
	 * The current execution phase.
	 */
	protected Phase currentPhase;

	/**
	 * The variable manager, which keeps track of the variable values (local and global).
	 */
	@Inject
	protected VariableManager variableManager;

	/**
	 * The value converter.
	 */
	@Inject
	protected ValueConverter valueConverter;

	/**
	 * The parameter resolver.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The wrapper factory.
	 */
	@Inject
	protected WrapperFactory wrapperFactory;

	/**
	 * The result comparator to use.
	 */
	@Inject
	protected ResultComparator resultComparator;

	/**
	 * The process watchdog, used to govern other processes started by the test runner.
	 */
	@Inject
	protected ProcessTerminator processTerminator;

	/**
	 * The Guice injector.
	 */
	@Inject
	protected Injector injector;

	/**
	 * The model source explorer.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

	/**
	 * The remoting server.
	 */
	protected IntegrityRemotingServer remotingServer;

	/**
	 * The remoting listener, which allows the remoting server to influence test execution.
	 */
	protected RemotingListener remotingListener;

	/**
	 * Maps fork definitions to actual fork instances.
	 */
	protected Map<ForkDefinition, Fork> forkMap = new LinkedHashMap<ForkDefinition, Fork>();

	/**
	 * Collects all forks that have died. If forks die after they have executed their last statement, this is perfectly
	 * fine, but if forks die earlier, this set is used to detect that erroneous situation.
	 */
	protected Set<ForkDefinition> diedForks = new HashSet<ForkDefinition>();

	/**
	 * The original command line arguments, as given to the test runner by the test runner creator.
	 */
	protected String[] commandLineArguments;

	/**
	 * This maps fully qualified constant names to parameter values. Defined during initialization. This allows to
	 * define the values for "parameterized" constants.
	 */
	protected Map<String, String> parameterizedConstantValues;

	/**
	 * The model checker is used to validate the test model prior to execution.
	 */
	@Inject
	protected ModelChecker modelChecker;

	/**
	 * The classloader.
	 */
	@Inject
	protected IntegrityClassLoader classLoader;

	/**
	 * The classloader used to load model-related classes.
	 */
	@Inject
	protected ClassLoader javaClassLoader;

	/**
	 * If this JVM instance is executing a fork, the name is stored here.
	 */
	protected static final String MY_FORK_NAME = System.getProperty(Forker.SYSPARAM_FORK_NAME);

	/**
	 * The system property that allows to override the timeout used when connecting to forks.
	 */
	protected static final String FORK_CONNECTION_TIMEOUT_PROPERTY = "integrity.fork.timeout";

	/**
	 * The default connection timeout, in seconds.
	 */
	protected static final int FORK_CONNECTION_TIMEOUT_DEFAULT = 180;

	protected static int getForkConnectionTimeoutDefault() {
		return FORK_CONNECTION_TIMEOUT_DEFAULT;
	}

	/**
	 * The timeout in milliseconds used for a single connection attempt to a fork. If this timeout is hit, but the total
	 * timeout for connecting is not yet over, another attempt is being started.
	 */
	protected static final int FORK_SINGLE_CONNECT_TIMEOUT = 10000;

	protected static int getForkSingleConnectTimeout() {
		return FORK_SINGLE_CONNECT_TIMEOUT;
	}

	/**
	 * The delay until connection attempts are made to a newly started fork.
	 */
	protected static final int FORK_CONNECT_DELAY = 5000;

	protected static int getForkConnectDelay() {
		return FORK_CONNECT_DELAY;
	}

	/**
	 * The interval in which the forks' execution state is checked on first connect.
	 */
	protected static final int FORK_PAUSE_WAIT_INTERVAL = 200;

	protected static int getForkPauseWaitInterval() {
		return FORK_PAUSE_WAIT_INTERVAL;
	}

	/**
	 * The time to wait for child processes to be killed.
	 */
	protected static final int CHILD_PROCESS_KILL_TIMEOUT = 60000;

	protected int getChildProcessKillTimeout() {
		return CHILD_PROCESS_KILL_TIMEOUT;
	}

	/**
	 * The fork that is currently being executed.
	 */
	protected ForkDefinition forkInExecution;

	/**
	 * The currently executed test variant.
	 */
	protected VariantDefinition variantInExecution;

	/**
	 * The setup suites that have been executed.
	 */
	protected Map<ForkDefinition, Set<SuiteDefinition>> setupSuitesExecuted = new HashMap<ForkDefinition, Set<SuiteDefinition>>();

	/**
	 * In case of an {@link AbortExecutionException} aborting the test execution, this exception is stored here
	 * (actually, only the message and stack trace string are stored - this is because the data could just as well come
	 * from a fork, in which case an exception can not be transported over the remoting connection).
	 */
	protected AbortExecutionCauseWrapper abortExecutionCause;

	@Override
	public void initialize(TestModel aModel, Map<String, String> someParameterizedConstants,
			TestRunnerCallback aCallback, Integer aRemotingPort, String aRemotingBindHost, Long aRandomSeed,
			String[] someCommandLineArguments) throws IOException {
		model = aModel;
		callback = aCallback;

		if (callback instanceof CompoundTestRunnerCallback) {
			((CompoundTestRunnerCallback) callback).injectDependencies(injector);
		} else {
			injector.injectMembers(callback);
		}

		if (aRandomSeed != null) {
			RandomNumberOperation.seed(aRandomSeed);
		} else {
			String tempRandomSeed = System.getProperty(Forker.SYSPARAM_FORK_SEED);
			if (tempRandomSeed != null) {
				RandomNumberOperation.seed(Long.parseLong(tempRandomSeed));
			} else {
				RandomNumberOperation.seed(null);
			}
		}

		parameterizedConstantValues = someParameterizedConstants;
		commandLineArguments = someCommandLineArguments;
		Integer tempRemotingPort = aRemotingPort;
		if (isFork()) {
			tempRemotingPort = Integer.parseInt(System.getProperty(Forker.SYSPARAM_FORK_REMOTING_PORT));
		}
		if (tempRemotingPort != null) {
			remotingListener = new RemotingListener();
			remotingServer = new IntegrityRemotingServer(aRemotingBindHost, tempRemotingPort, remotingListener,
					javaClassLoader);
		}
	}

	/**
	 * Shuts down this test runner instance.
	 * 
	 * @param anEmptyRemotingOutputQueueFlag
	 *            true if the remoting server shall be given time to send all remaining messages to clients while
	 *            closing connections
	 */
	@Override
	public void shutdown(boolean anEmptyRemotingOutputQueueFlag) {
		if (remotingServer != null) {
			remotingServer.closeAll(anEmptyRemotingOutputQueueFlag);
		}
	}

	@Override
	public SuiteSummaryResult run(SuiteDefinition aRootSuite, VariantDefinition aVariant, boolean aBlockForRemotingFlag) {
		Suite tempRootSuiteCall = DslFactory.eINSTANCE.createSuite();
		tempRootSuiteCall.setDefinition(aRootSuite);

		return run(tempRootSuiteCall, aVariant, aBlockForRemotingFlag);
	}

	/**
	 * Executes a specific suite call. Internal starting point for test execution.
	 * 
	 * @param aRootSuiteCall
	 *            the suite call to execute
	 * @param aBlockForRemotingFlag
	 *            whether execution should pause before actually starting until execution is resumed via remoting
	 * @return the suite execution result
	 */
	protected SuiteSummaryResult run(Suite aRootSuiteCall, VariantDefinition aVariant, boolean aBlockForRemotingFlag) {
		variantInExecution = aVariant;
		boolean tempBlockForRemoting = isFork() ? false : aBlockForRemotingFlag;

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				processTerminator.killAndWait(getChildProcessKillTimeout());
			}
		});

		try {
			currentPhase = Phase.DRY_RUN;
			SetList tempSetList = new SetList();
			reset(false);
			setListCallback = new SetListCallback(tempSetList, remotingServer);
			injector.injectMembers(setListCallback);
			currentCallback = setListCallback;

			currentCallback.setDryRun(true);
			runInternal(aRootSuiteCall);
			currentCallback.setDryRun(false);

			synchronized (setListWaiter) {
				setList = tempSetList;
				setListWaiter.notify();
			}

			if (remotingServer != null && tempBlockForRemoting) {
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

			currentPhase = Phase.TEST_RUN;
			reset(true);

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
			processTerminator.killAndWait(getChildProcessKillTimeout());
		}
	}

	/**
	 * If the exception provided is an {@link AbortExecutionException}, this method performs the necessary steps to
	 * enter "abort" mode locally.
	 * 
	 * @param anException
	 */
	protected void handlePossibleAbortException(Throwable anException) {
		if (anException instanceof AbortExecutionException && abortExecutionCause == null) {
			abortExecutionCause = new AbortExecutionCauseWrapper((AbortExecutionException) anException);

			currentCallback.onAbortExecution(abortExecutionCause.getMessage(), abortExecutionCause.getStackTrace());
		}
	}

	/**
	 * Checks whether an {@link AbortExecutionException} has been thrown (either locally or by a fork). This is
	 * determined by looking at {@link #abortExecutionCause}. This method does NOT only check something, but also
	 * ensures that the {@link #setListCallback} is also removed from the current callback hierarchy - a very important
	 * step, since after this method has returned true for the first time, a different execution path than normally is
	 * expected, which would cause the set list callback to throw an inconsistency exception.
	 * 
	 * @return
	 */
	protected boolean checkForAbortion() {
		if (abortExecutionCause != null) {
			// Remove the setlist callback from the callback chain to prevent inconsistencies due to the expected change
			// in the execution path
			if (setListCallback != null && (currentCallback instanceof CompoundTestRunnerCallback)) {
				((CompoundTestRunnerCallback) currentCallback).removeCallback(setListCallback);
				setListCallback = null;
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Initializes the parameterized constants from the {@link #parameterizedConstantValues} map.
	 */
	protected void initializeParameterizedConstants() {
		for (ConstantDefinition tempConstant : model.getConstantDefinitionsInPackages()) {
			String tempName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempConstant.getName(), false);
			String tempValue = (parameterizedConstantValues != null) ? parameterizedConstantValues.get(tempName) : null;
			if (tempConstant.getParameterized() != null) {
				defineConstant(
						tempConstant,
						tempValue,
						(tempConstant.eContainer() instanceof SuiteDefinition) ? ((SuiteDefinition) tempConstant
								.eContainer()) : null);
			} else {
				if (tempValue != null) {
					throw new IllegalArgumentException("Constant '" + tempName
							+ "' is not defined as 'parameterized' in test scripts, but parameter data was specified.");
				}
			}
		}
	}

	/**
	 * Initializes all constants with the values given in the scripts.
	 */
	protected void initializeConstants() {
		for (ConstantDefinition tempConstantDef : model.getConstantDefinitionsInPackages()) {
			// Parameterized constants have already been initialized separately, so we don't initialize them here again
			if (tempConstantDef.getParameterized() == null) {
				defineConstant(tempConstantDef, null);
			}
		}
	}

	/**
	 * Initializes all variables with the initial values given in the scripts.
	 */
	protected void initializeVariables() {
		for (VariableDefinition tempVariableDef : model.getVariableDefinitionsInPackages()) {
			defineVariable(tempVariableDef, null);
		}
	}

	/**
	 * Resets the internal variable state.
	 * 
	 * @param aSoftResetFlag
	 *            Whether to perform a "soft" reset only. Soft resets are supposed to be performed between the dry run
	 *            and the actual test run.
	 */
	protected void reset(boolean aSoftResetFlag) {
		// Soft reset doesn't clear constants
		variableManager.clear(!aSoftResetFlag);
		setupSuitesExecuted.clear();
	}

	/**
	 * Actually executes a root suite call.
	 * 
	 * @param aRootSuiteCall
	 *            the suite call to execute
	 * @return the result
	 */
	protected SuiteSummaryResult runInternal(Suite aRootSuiteCall) {
		if (remotingServer != null && currentPhase == Phase.TEST_RUN) {
			remotingServer.updateExecutionState(ExecutionStates.RUNNING);
		}

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onExecutionStart(model, variantInExecution);
			currentCallback.onCallbackProcessingEnd();
		}

		initializeParameterizedConstants();
		initializeConstants();
		initializeVariables();

		SuiteSummaryResult tempResult = callSuiteSingle(aRootSuiteCall);

		if (remotingServer != null && currentPhase == Phase.TEST_RUN) {
			if (abortExecutionCause != null) {
				remotingServer.sendAbortMessage(abortExecutionCause.getMessage(), abortExecutionCause.getStackTrace());
			}
			remotingServer.updateExecutionState(ExecutionStates.FINALIZING);
		}

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onExecutionFinish(model, tempResult);
			currentCallback.onCallbackProcessingEnd();
		}

		if (remotingServer != null && currentPhase == Phase.TEST_RUN) {
			remotingServer.updateExecutionState(ExecutionStates.ENDED);
		}

		return tempResult;
	}

	/**
	 * Performs a specified suite call.
	 * 
	 * @param aSuiteCall
	 *            the suite call to execute
	 * @return the suite results (multiple if the suite has an execution multiplier)
	 */
	protected List<SuiteSummaryResult> callSuite(Suite aSuiteCall) {
		int tempCount = 1;
		if (aSuiteCall.getMultiplier() != null && aSuiteCall.getMultiplier().getCount() != null) {
			try {
				tempCount = (Integer) valueConverter.convertValue(
						Integer.class,
						aSuiteCall.getMultiplier().getCount(),
						conversionContextProvider.get().withUnresolvableVariableHandlingPolicy(
								UnresolvableVariableHandling.EXCEPTION));
			} catch (UnresolvableVariableException exc) {
				// should never happen, since constant values are not allowed to be variables which still need resolving
				throw new ThisShouldNeverHappenException(exc);
			} catch (UnexecutableException exc) {
				// should never happen, since constant values are not allowed to be unexecuted operations
				throw new ThisShouldNeverHappenException(exc);
			}
		}

		List<SuiteSummaryResult> tempResults = new ArrayList<SuiteSummaryResult>();
		for (int i = 0; i < tempCount; i++) {
			tempResults.add(callSuiteSingle(aSuiteCall));

			if (checkForAbortion()) {
				break;
			}
		}

		return tempResults;
	}

	/**
	 * Performs a specified suite call (doesn't honor the multiplier!).
	 * 
	 * @param aSuiteCall
	 *            the suite call to execute
	 * @return the suite result
	 */
	protected SuiteSummaryResult callSuiteSingle(Suite aSuiteCall) {
		modelChecker.check(aSuiteCall);

		boolean tempForkInExecutionOnEntry = forkInExecution != null;

		if (aSuiteCall.getFork() != null && !tempForkInExecutionOnEntry) {
			if (!isFork() && forkInExecution != null && aSuiteCall.getFork() != forkInExecution) {
				throw new UnsupportedOperationException(
						"It is not supported to execute another fork while inside a fork ("
								+ aSuiteCall.getFork().getName() + " inside " + forkInExecution.getName() + ").");
			}
			forkInExecution = aSuiteCall.getFork();
			currentCallback.setForkInExecution(forkInExecution);
		}

		if (currentPhase == Phase.TEST_RUN && !tempForkInExecutionOnEntry) {
			// all of this only has to be done in case of a real test run
			if (!isFork()) {
				// we're the master
				if (forkInExecution != null) {
					// set the currently executed entry to the suite call entry that will be created next
					// this signifies that a fork is about to be started executing the highlighted suite
					if (remotingServer != null) {
						remotingServer.updateSetList(setList.getEntryListPosition(), new SetListEntry[0]);
					}
					// we may need to start a new fork
					if (!forkMap.containsKey(aSuiteCall.getFork())) {
						// but first see if this fork has already died once. if true, then the fork has died
						// prematurely, which means we cannot continue execution at all
						if (diedForks.contains(aSuiteCall.getFork())) {
							throw new RuntimeException("Fork " + aSuiteCall.getFork().getName()
									+ " has died prematurely!");
						}
						try {
							forkMap.put(aSuiteCall.getFork(), createFork(aSuiteCall));
						} catch (ForkException exc) {
							// forking failed -> cannot continue at all :( kill all other still-living forks and
							// then exit with a runtime exception
							throw new RuntimeException(exc);
						}
					}
					// the master will perform all of this in dry run mode
					currentCallback.setDryRun(true);
				}
			} else {
				if (forkInExecution != null) {
					// now see if this is a job for us
					if (IntegrityDSLUtil.getQualifiedForkName(forkInExecution).equals(MY_FORK_NAME)) {
						// we're a fork, and we are at a point where we're gonna execute some stuff
						// but we have to wait until our master gives us the 'go'!
						scheduleWaitBeforeNextStep();
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
			currentCallback.onCallbackProcessingStart();
			currentCallback.onSuiteStart(aSuiteCall);
			currentCallback.onCallbackProcessingEnd();
		}

		List<SuiteDefinition> tempSetupSuitesExecuted = executeSetupSuites(aSuiteCall.getDefinition(), tempSetupResults);

		// Define variables for all the parameters provided to the suite call
		for (SuiteParameter tempParam : aSuiteCall.getParameters()) {
			if (tempParam.getValue() instanceof Variable) {
				Variable tempVariable = (Variable) tempParam.getValue();
				defineVariable(tempParam.getName(), variableManager.get(tempVariable.getName()),
						aSuiteCall.getDefinition());
			} else {
				defineVariable(tempParam.getName(), tempParam.getValue(), aSuiteCall.getDefinition());
			}
		}

		long tempSuiteDuration = System.nanoTime();
		Map<SuiteStatementWithResult, List<? extends Result>> tempResults = executeSuite(aSuiteCall.getDefinition());
		tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

		// Now unset all the parameter variables' values again (fixes issue #44)
		for (SuiteParameter tempParam : aSuiteCall.getParameters()) {
			variableManager.unset(tempParam.getName());
		}

		if (!checkForAbortion()) {
			executeTearDownSuites(tempSetupSuitesExecuted, tempTearDownResults);
		}

		SuiteSummaryResult tempResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempResults,
				tempSetupResults, tempTearDownResults, tempSuiteDuration);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onSuiteFinish(aSuiteCall, tempResult);
			currentCallback.onCallbackProcessingEnd();
		}

		if (forkInExecution != null && forkInExecution.equals(aSuiteCall.getFork())) {
			if (currentPhase == Phase.TEST_RUN) {
				// all of this only has to be done in case of a real test run

				if (!isFork()) {
					// we're the master and need to kick off the fork, which then actually executes the stuff we've just
					// jumped over
					Fork tempFork = forkMap.get(forkInExecution);

					// Since we might have been requested to wait before the next step, we need to push that request
					// forward to the fork, which will actually execute the next step.
					if (shallWaitBeforeNextStep) {
						tempFork.getClient().createBreakpoint(null);
					}

					ForkResultSummary tempForkResultSummary = null;
					tempSuiteDuration = System.nanoTime();
					if (tempFork != null) {
						tempForkResultSummary = tempFork.executeNextSegment();
					}
					tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

					if (tempForkResultSummary != null) {
						tempResult = new SuiteSummaryResult(tempForkResultSummary.getSuccessCount(),
								tempForkResultSummary.getFailureCount(), tempForkResultSummary.getTestExceptionCount(),
								tempForkResultSummary.getCallExceptionCount(), tempSuiteDuration);
					} else {
						if (tempFork != null && tempFork.hasAborted()) {
							// If this happens, an abortion has happened on the fork due to an AbortExecutionException.
							// TODO make this nicer, it's kind of ugly to create a fake object with null values
							abortExecutionCause = new AbortExecutionCauseWrapper(null, null);
						}
					}

					// and afterwards we'll switch back to real test mode
					currentCallback.setDryRun(false);
				} else {
					// we're a fork and will return to dry run mode
					currentCallback.setDryRun(true);
				}
			}
			forkInExecution = null;
			currentCallback.setForkInExecution(null);
		}

		return tempResult;
	}

	/**
	 * Executes the provided suite as a setup suite. This includes executing further nested setup suites (but not
	 * teardown suites, as those will intentionally be executed when the original suite which caused this setup suite to
	 * be executed has finished).
	 * 
	 * @param aSuite
	 *            the suite to be executed as setup suite
	 * @param aSetupResultMap
	 *            the map of setup results to add the result to
	 * @return a list of executed setup suites
	 */
	protected List<SuiteDefinition> executeSetupSuites(SuiteDefinition aSuite,
			Map<SuiteDefinition, Result> aSetupResultMap) {
		List<SuiteDefinition> tempSetupSuitesExecuted = new ArrayList<SuiteDefinition>();
		Set<SuiteDefinition> tempSetupsAlreadyRun = setupSuitesExecuted.get(forkInExecution);
		if (tempSetupsAlreadyRun == null) {
			tempSetupsAlreadyRun = new HashSet<SuiteDefinition>();
			setupSuitesExecuted.put(forkInExecution, tempSetupsAlreadyRun);
		}
		for (SuiteDefinition tempSetupSuite : aSuite.getDependencies()) {
			if (!tempSetupsAlreadyRun.contains(tempSetupSuite)) {
				if (currentCallback != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onSetupStart(tempSetupSuite);
					currentCallback.onCallbackProcessingEnd();
				}

				// This setup suite might have setup suites itself (issue #11)
				tempSetupSuitesExecuted.addAll(executeSetupSuites(tempSetupSuite, aSetupResultMap));
				if (tempSetupsAlreadyRun.contains(tempSetupSuite)) {
					// A circle has been created. This is a hard error -> abort before the stack inevitably explodes.
					throw new IllegalStateException("A setup suite circle has been detected ("
							+ tempSetupSuite.getName() + " called from " + aSuite.getName()
							+ "). Please break the circle!");
				}

				long tempStart = System.nanoTime();
				Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(tempSetupSuite);
				SuiteResult tempSetupResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempSuiteResults,
						null, null, System.nanoTime() - tempStart);
				aSetupResultMap.put(tempSetupSuite, tempSetupResult);

				tempSetupsAlreadyRun.add(tempSetupSuite);
				tempSetupSuitesExecuted.add(tempSetupSuite);

				if (currentCallback != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onSetupFinish(tempSetupSuite, tempSetupResult);
					currentCallback.onCallbackProcessingEnd();
				}
			}
		}

		return tempSetupSuitesExecuted;
	}

	/**
	 * Executes the teardown suites required by the provided setup suites.
	 * 
	 * @param aSetupSuitesList
	 *            the list of setup suites
	 * @param aTearDownResultMap
	 *            a map into which teardown suite execution results will be stored
	 */
	protected void executeTearDownSuites(List<SuiteDefinition> aSetupSuitesList,
			Map<SuiteDefinition, Result> aTearDownResultMap) {
		Set<SuiteDefinition> tempSetupsAlreadyRun = setupSuitesExecuted.get(forkInExecution);

		for (int i = aSetupSuitesList.size() - 1; i >= 0; i--) {
			SuiteDefinition tempSetupSuite = aSetupSuitesList.get(i);
			for (SuiteDefinition tempTearDownSuite : tempSetupSuite.getFinalizers()) {
				if (currentCallback != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onTearDownStart(tempTearDownSuite);
					currentCallback.onCallbackProcessingEnd();
				}

				long tempStart = System.nanoTime();
				Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(tempTearDownSuite);
				SuiteResult tempTearDownResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempSuiteResults,
						null, null, System.nanoTime() - tempStart);
				aTearDownResultMap.put(tempTearDownSuite, tempTearDownResult);

				if (currentCallback != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onTearDownFinish(tempTearDownSuite, tempTearDownResult);
					currentCallback.onCallbackProcessingEnd();
				}
			}

			tempSetupsAlreadyRun.remove(tempSetupSuite);
		}
	}

	/**
	 * Executes a suite.
	 * 
	 * @param aSuite
	 *            the suite to execute
	 * @return a map that maps statements to results
	 */
	protected Map<SuiteStatementWithResult, List<? extends Result>> executeSuite(SuiteDefinition aSuite) {
		Map<SuiteStatementWithResult, List<? extends Result>> tempResults = new LinkedHashMap<SuiteStatementWithResult, List<? extends Result>>();

		List<VariableOrConstantEntity> tempDefinedVariables = new ArrayList<VariableOrConstantEntity>();

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			checkForValidationError(tempStatement);
			if (tempStatement instanceof Suite) {
				Suite tempSuite = (Suite) tempStatement;
				boolean tempExecute = false;
				if (tempSuite.getVariants().size() > 0) {
					for (VariantDefinition tempVariant : tempSuite.getVariants()) {
						if (tempVariant == variantInExecution) {
							tempExecute = true;
							break;
						}
					}
				} else {
					tempExecute = true;
				}

				if (tempExecute) {
					tempResults.put((Suite) tempStatement, callSuite((Suite) tempStatement));
				}
			} else if (tempStatement instanceof Test) {
				List<Result> tempInnerList = new ArrayList<Result>();
				tempInnerList.add(executeTest((Test) tempStatement));
				tempResults.put((Test) tempStatement, tempInnerList);
			} else if (tempStatement instanceof TableTest) {
				List<Result> tempInnerList = new ArrayList<Result>();
				tempInnerList.add(executeTableTest((TableTest) tempStatement));
				tempResults.put((TableTest) tempStatement, tempInnerList);
			} else if (tempStatement instanceof Call) {
				List<Result> tempInnerList = new ArrayList<Result>();
				tempInnerList.addAll(executeCall((Call) tempStatement));
				tempResults.put((Call) tempStatement, tempInnerList);
			} else if (tempStatement instanceof VariableDefinition) {
				tempDefinedVariables.add(((VariableDefinition) tempStatement).getName());
				defineVariable((VariableDefinition) tempStatement, aSuite);
			} else if (tempStatement instanceof ConstantDefinition) {
				tempDefinedVariables.add(((ConstantDefinition) tempStatement).getName());
				defineConstant((ConstantDefinition) tempStatement, aSuite);
			} else if (tempStatement instanceof VisibleSingleLineComment) {
				if (currentCallback != null) {
					boolean tempIsTitle = (tempStatement instanceof VisibleSingleLineTitleComment);
					currentCallback.onCallbackProcessingStart();
					currentCallback.onVisibleComment(
							IntegrityDSLUtil.cleanSingleLineComment((VisibleSingleLineComment) tempStatement),
							tempIsTitle, (VisibleComment) tempStatement);
					currentCallback.onCallbackProcessingEnd();
				}
			} else if (tempStatement instanceof VisibleMultiLineComment) {
				if (currentCallback != null) {
					boolean tempIsTitle = (tempStatement instanceof VisibleMultiLineTitleComment);
					currentCallback.onCallbackProcessingStart();
					currentCallback.onVisibleComment(
							IntegrityDSLUtil.cleanMultiLineComment((VisibleMultiLineComment) tempStatement),
							tempIsTitle, (VisibleComment) tempStatement);
					currentCallback.onCallbackProcessingEnd();
				}
			} else if (tempStatement instanceof VisibleDivider) {
				if (currentCallback != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onVisibleDivider(((VisibleDivider) tempStatement).getContent(),
							(VisibleDivider) tempStatement);
					currentCallback.onCallbackProcessingEnd();
				}
			}

			if (checkForAbortion()) {
				break;
			}
		}

		for (VariableOrConstantEntity tempEntity : tempDefinedVariables) {
			variableManager.unset(tempEntity);
		}

		return tempResults;
	}

	/**
	 * Defines a variable.
	 * 
	 * @param aDefinition
	 *            the variable definition
	 * @param aSuite
	 *            the suite in which the variable is defined
	 */
	protected void defineVariable(VariableDefinition aDefinition, SuiteDefinition aSuite) {
		defineVariable(aDefinition.getName(), aDefinition.getInitialValue(), aSuite);
	}

	/**
	 * Defines a constant.
	 * 
	 * @param aDefinition
	 *            the constant definition
	 * @param aSuite
	 *            the suite in which the constant is defined
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 */
	protected void defineConstant(ConstantDefinition aDefinition, SuiteDefinition aSuite) {
		defineConstant(aDefinition, null, aSuite);
	}

	/**
	 * Defines a constant.
	 * 
	 * @param aDefinition
	 *            the constant definition
	 * @param aValue
	 *            the value to define (if null, the value in the constant definition is used; this should only be set in
	 *            case of parameterizable constants!)
	 * @param aSuite
	 *            the suite in which the constant is defined
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 */
	protected void defineConstant(ConstantDefinition aDefinition, Object aValue, SuiteDefinition aSuite) {
		// Constants can only be defined once, thus we'll define them in the first (dry) run and leave them defined for
		// the actual test run.
		if (currentPhase == Phase.DRY_RUN || !IntegrityDSLUtil.isGlobalVariableOrConstant(aDefinition.getName())) {
			Object tempValue;
			if (aValue == null) {
				try {
					tempValue = parameterResolver.resolveStatically(aDefinition, variantInExecution);
				} catch (UnexecutableException exc) {
					throw new RuntimeException("Failed to define constant value: " + exc.getMessage(), exc);
				} catch (ClassNotFoundException exc) {
					throw new RuntimeException("Failed to define constant value: " + exc.getMessage(), exc);
				} catch (InstantiationException exc) {
					throw new RuntimeException("Failed to define constant value: " + exc.getMessage(), exc);
				}
			} else {
				tempValue = aValue;
			}
			if (tempValue != null) {
				defineVariable(aDefinition.getName(), tempValue, aSuite);
			}
		} else {
			// The constant must be already defined, but in order for the calls to the callbacks to be consistent, we
			// need to perform that call, basically just as if we had determined the value just now.
			if (currentCallback != null) {
				Object tempConstantValue = variableManager.get(aDefinition.getName());
				if (tempConstantValue != null) {
					currentCallback.onCallbackProcessingStart();
					currentCallback.onConstantDefinition(aDefinition.getName(), aSuite, tempConstantValue,
							(aDefinition.getParameterized() != null));
					currentCallback.onCallbackProcessingEnd();
				}
			}
		}
	}

	/**
	 * Defines a variable.
	 * 
	 * @param anEntity
	 *            the variable entity
	 * @param anInitialValue
	 *            the initial variable value, or null if the variable is not initialized
	 * @param aSuite
	 *            the suite in which the variable is defined
	 */
	protected void defineVariable(VariableOrConstantEntity anEntity, Object anInitialValue, SuiteDefinition aSuite) {
		Object tempInitialValue = null;
		if (anInitialValue instanceof Variable) {
			tempInitialValue = variableManager.get(((Variable) anInitialValue).getName());
		} else {
			tempInitialValue = anInitialValue;
		}

		setVariableValue(anEntity, tempInitialValue, false);
		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			if (anEntity instanceof VariableEntity) {
				currentCallback.onVariableDefinition((VariableEntity) anEntity, aSuite, tempInitialValue);
			} else if (anEntity instanceof ConstantEntity) {
				currentCallback.onConstantDefinition((ConstantEntity) anEntity, aSuite, tempInitialValue,
						(((ConstantDefinition) anEntity.eContainer()).getParameterized() != null));
			}
			currentCallback.onCallbackProcessingEnd();
		}
	}

	/**
	 * Sets the value of a variable.
	 * 
	 * @param anEntity
	 *            the variable entity to update
	 * @param aValue
	 *            the new value
	 * @param aDoSendUpdateFlag
	 *            whether this update should be sent to connected master/slaves
	 */
	protected void setVariableValue(VariableOrConstantEntity anEntity, Object aValue, boolean aDoSendUpdateFlag) {
		variableManager.set(anEntity, aValue);
		if (aDoSendUpdateFlag) {
			if (isFork()) {
				// A fork will have to send updates to its master, but not for constants, as the master has those anyway
				if (remotingServer != null && !(anEntity instanceof ConstantEntity)) {
					String tempName = IntegrityDSLUtil.getQualifiedVariableEntityName(anEntity, true);
					if (aValue == null || (aValue instanceof Serializable)) {
						remotingServer.sendVariableUpdate(tempName, (Serializable) aValue);
					} else {
						System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempName + "' TO MASTER - VALUE '"
								+ aValue + "' OF TYPE '" + aValue.getClass().getName() + "' IS NOT SERIALIZABLE!");
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

	/**
	 * Updates a variables' value.
	 * 
	 * @param aQualifiedVariableName
	 *            the name of the variable to update
	 * @param aValue
	 *            the new value
	 * @param aDoSendUpdateFlag
	 *            whether this update should be sent to connected master/slaves
	 */
	protected void setVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag) {
		VariableOrConstantEntity tempEntity = model.getVariableOrConstantByName(aQualifiedVariableName);
		if (tempEntity != null) {
			setVariableValue(tempEntity, aValue, aDoSendUpdateFlag);
		}
	}

	/**
	 * Resolves a constant value (either it's a static value anyway, or it's a constant which needs to be resolved).
	 * 
	 * @param aConstantValue
	 *            the constant value
	 * @return the value
	 */
	protected Object resolveConstantValue(ConstantValue aConstantValue) {
		if (aConstantValue instanceof StaticValue) {
			return aConstantValue;
		} else if (aConstantValue instanceof Constant) {
			return variableManager.get(((Constant) aConstantValue).getName());
		}

		throw new ThisShouldNeverHappenException();
	}

	/**
	 * Executes a test (doesn't pay attention to the multiplier).
	 * 
	 * @param aTest
	 *            the test to execute
	 * @return the result
	 */
	protected TestResult executeTest(Test aTest) {
		modelChecker.check(aTest);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onTestStart(aTest);
			currentCallback.onCallbackProcessingEnd();
		}

		TestResult tempReturn = null;
		TestComparisonResult tempComparisonResult;
		Throwable tempException = null;
		long tempDuration = 0;
		FixtureWrapper<?> tempFixtureInstance = null;
		String tempFixtureMethodName = aTest.getDefinition().getFixtureMethod().getMethod().getSimpleName();

		Map<String, TestComparisonResult> tempComparisonMap = new LinkedHashMap<String, TestComparisonResult>();
		boolean tempUndeterminedComparisonResultsRequired = false;
		if (!shouldExecuteFixtures()) {
			tempUndeterminedComparisonResultsRequired = true;
		} else {
			pauseIfRequiredByRemoteClient(false);

			try {
				Map<String, Object> tempParameters = parameterResolver.createParameterMap(aTest, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

				tempFixtureInstance = wrapperFactory.newFixtureWrapper(aTest.getDefinition().getFixtureMethod());

				tempFixtureInstance.announceTestResults(aTest.getResult(), aTest.getResults());

				Object tempFixtureResult;
				tempDuration = System.nanoTime();
				try {
					tempFixtureResult = tempFixtureInstance.execute(tempParameters);
				} finally {
					tempDuration = System.nanoTime() - tempDuration;
				}

				if (aTest.getResults() != null && aTest.getResults().size() > 0) {
					Map<String, Object> tempFixtureResultMap = ParameterUtil
							.getValuesFromNamedResultContainer(tempFixtureResult);

					for (NamedResult tempNamedResult : aTest.getResults()) {
						String tempResultName = IntegrityDSLUtil
								.getExpectedResultNameStringFromTestResultName(tempNamedResult.getName());
						Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);
						ComparisonResult tempResult = resultComparator.compareResult(tempSingleFixtureResult,
								tempNamedResult.getValue(), tempFixtureInstance, aTest.getDefinition()
										.getFixtureMethod(), tempResultName);
						tempComparisonResult = TestComparisonResult.wrap(tempResult, tempResultName,
								tempSingleFixtureResult, tempNamedResult.getValue());
						tempComparisonMap.put(tempResultName, tempComparisonResult);
					}
				} else {
					ComparisonResult tempResult = resultComparator.compareResult(tempFixtureResult, aTest.getResult(),
							tempFixtureInstance, aTest.getDefinition().getFixtureMethod(), null);
					tempComparisonResult = TestComparisonResult.wrap(tempResult, ParameterUtil.DEFAULT_PARAMETER_NAME,
							tempFixtureResult, aTest.getResult());
					tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
				}
			} catch (Throwable exc) {
				tempException = exc;
				tempUndeterminedComparisonResultsRequired = true;
			}
		}

		if (tempUndeterminedComparisonResultsRequired) {
			// We always need to provide the comparison results, even if no comparison was done due to dry mode or
			// exception, in which case the "undetermined result" is used.
			tempComparisonMap.clear();
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
		}

		List<TestSubResult> tempSubResults = new LinkedList<TestSubResult>();
		if (tempException != null) {
			tempSubResults.add(new TestExceptionSubResult(tempException, tempComparisonMap, tempFixtureInstance,
					tempFixtureMethodName, tempDuration));
			handlePossibleAbortException(tempException);
		} else {
			tempSubResults.add(new TestExecutedSubResult(tempComparisonMap, tempFixtureInstance, tempFixtureMethodName,
					tempDuration));
		}

		List<ExtendedResult> tempExtendedResults = null;
		if (shouldExecuteFixtures()) {
			try {
				tempExtendedResults = tempFixtureInstance
						.retrieveExtendedResults(evaluateTestSubResultsToFixtureInvocationResult(tempSubResults));
			} catch (Throwable exc) {
				exc.printStackTrace();
			}
		}

		tempReturn = new TestResult(tempSubResults, tempFixtureInstance, tempFixtureMethodName, tempDuration,
				tempExtendedResults);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onTestFinish(aTest, tempReturn);
			currentCallback.onCallbackProcessingEnd();
		}

		if (tempFixtureInstance != null) {
			tempFixtureInstance.release();
		}

		return tempReturn;
	}

	/**
	 * Executes a table test.
	 * 
	 * @param aTest
	 *            the test to execute
	 * @return the result
	 */
	protected TestResult executeTableTest(TableTest aTest) {
		modelChecker.check(aTest);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onTableTestStart(aTest);
			currentCallback.onCallbackProcessingEnd();
		}

		if (currentPhase == Phase.TEST_RUN) {
			pauseIfRequiredByRemoteClient(false);
		}

		List<TestSubResult> tempSubResults = new LinkedList<TestSubResult>();
		String tempFixtureMethodName = aTest.getDefinition().getFixtureMethod().getMethod().getSimpleName();
		long tempOuterStart = System.nanoTime();

		FixtureWrapper<?> tempFixtureInstance = null;
		for (TableTestRow tempRow : aTest.getRows()) {
			if (currentCallback != null) {
				currentCallback.onCallbackProcessingStart();
				currentCallback.onTableTestRowStart(aTest, tempRow);
				currentCallback.onCallbackProcessingEnd();
			}

			Map<String, TestComparisonResult> tempComparisonMap = new LinkedHashMap<String, TestComparisonResult>();
			TestComparisonResult tempComparisonResult = null;
			Throwable tempException = null;
			Long tempDuration = null;

			boolean tempUndeterminedComparisonResultsRequired = false;

			if (!shouldExecuteFixtures()) {
				tempUndeterminedComparisonResultsRequired = true;
			} else {
				long tempStart = System.nanoTime();
				try {
					Map<String, Object> tempParameters = parameterResolver.createParameterMap(aTest, tempRow, true,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

					if (tempFixtureInstance == null) {
						// only instantiate on first pass
						tempFixtureInstance = wrapperFactory
								.newFixtureWrapper(aTest.getDefinition().getFixtureMethod());
					}

					// We need the default result value before the actual result comparison takes place
					ValueOrEnumValueOrOperationCollection tempExpectedDefaultResultValue = null;
					if ((aTest.getResultHeaders() == null || aTest.getResultHeaders().isEmpty())
							&& aTest.getDefaultResultColumn() != null) {
						// the last column MUST be the result column
						tempExpectedDefaultResultValue = tempRow.getValues().get(tempRow.getValues().size() - 1)
								.getValue();
					}

					tempFixtureInstance.announceTableTestResults(tempExpectedDefaultResultValue,
							aTest.getResultHeaders());

					tempStart = System.nanoTime();
					Object tempFixtureResult = tempFixtureInstance.execute(tempParameters);
					tempDuration = System.nanoTime() - tempStart;

					if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
						// Use named results
						Map<String, Object> tempFixtureResultMap = ParameterUtil
								.getValuesFromNamedResultContainer(tempFixtureResult);

						int tempColumn = aTest.getParameterHeaders().size();
						for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
							String tempResultName = IntegrityDSLUtil
									.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
							ValueOrEnumValueOrOperationCollection tempExpectedNamedResultValue = (tempColumn < tempRow
									.getValues().size()) ? tempRow.getValues().get(tempColumn).getValue() : null;

							Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);

							ComparisonResult tempResult = resultComparator.compareResult(tempSingleFixtureResult,
									tempExpectedNamedResultValue, tempFixtureInstance, aTest.getDefinition()
											.getFixtureMethod(), tempResultName);
							tempComparisonResult = TestComparisonResult.wrap(tempResult, tempResultName,
									tempSingleFixtureResult, tempExpectedNamedResultValue);
							tempComparisonMap.put(tempResultName, tempComparisonResult);

							tempColumn++;
						}
					} else {
						// Use the default result
						ComparisonResult tempResult = resultComparator.compareResult(tempFixtureResult,
								tempExpectedDefaultResultValue, tempFixtureInstance, aTest.getDefinition()
										.getFixtureMethod(), null);
						tempComparisonResult = TestComparisonResult
								.wrap(tempResult, ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult,
										tempExpectedDefaultResultValue);
						tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
					}
					// SUPPRESS CHECKSTYLE IllegalCatch
				} catch (Throwable exc) {
					tempDuration = System.nanoTime() - tempStart;
					tempException = exc;
					tempUndeterminedComparisonResultsRequired = true;
				}
			}

			if (tempUndeterminedComparisonResultsRequired) {
				tempComparisonMap.clear();
				if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
					int tempColumn = aTest.getParameterHeaders().size();
					for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
						String tempParameter = IntegrityDSLUtil
								.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
						ValueOrEnumValueOrOperationCollection tempExpectedValue = (tempColumn < tempRow.getValues()
								.size()) ? tempRow.getValues().get(tempColumn).getValue() : null;
						tempComparisonResult = new TestComparisonUndeterminedResult(tempParameter, tempExpectedValue);
						tempComparisonMap.put(tempParameter, tempComparisonResult);

						tempColumn++;
					}
				} else {
					ValueOrEnumValueOrOperationCollection tempExpectedValue = null;
					if (aTest.getDefaultResultColumn() != null) {
						// the last column MUST be the result column
						tempExpectedValue = tempRow.getValues().get(tempRow.getValues().size() - 1).getValue();
					}
					tempComparisonResult = new TestComparisonUndeterminedResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
							tempExpectedValue);
					tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
				}
			}

			TestSubResult tempSubResult;

			if (tempException != null) {
				tempSubResult = new TestExceptionSubResult(tempException, tempComparisonMap, tempFixtureInstance,
						tempFixtureMethodName, tempDuration);
				handlePossibleAbortException(tempException);
			} else {
				tempSubResult = new TestExecutedSubResult(tempComparisonMap, tempFixtureInstance,
						tempFixtureMethodName, tempDuration);
			}
			tempSubResults.add(tempSubResult);

			if (currentCallback != null) {
				currentCallback.onCallbackProcessingStart();
				currentCallback.onTableTestRowFinish(aTest, tempRow, tempSubResult);
				currentCallback.onCallbackProcessingEnd();
			}

			if (checkForAbortion()) {
				break;
			}
		}

		Long tempOuterDuration = System.nanoTime() - tempOuterStart;

		List<ExtendedResult> tempExtendedResult = null;
		if (shouldExecuteFixtures()) {
			try {
				tempExtendedResult = tempFixtureInstance
						.retrieveExtendedResults(evaluateTestSubResultsToFixtureInvocationResult(tempSubResults));
			} catch (Throwable exc) {
				exc.printStackTrace();
			}
		}

		TestResult tempReturn = new TestResult(tempSubResults, tempFixtureInstance, tempFixtureMethodName,
				currentPhase == Phase.DRY_RUN ? null : tempOuterDuration, tempExtendedResult);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onTableTestFinish(aTest, tempReturn);
			currentCallback.onCallbackProcessingEnd();
		}

		if (tempFixtureInstance != null) {
			tempFixtureInstance.release();
		}

		return tempReturn;
	}

	/**
	 * Loads a class by resolving a given {@link JvmType}.
	 * 
	 * @param aType
	 *            the type to load
	 * @return the class
	 * @throws ClassNotFoundException
	 */
	protected Class<?> getClassForJvmType(JvmType aType) throws ClassNotFoundException {
		// TODO replace with call to our own classloader
		return javaClassLoader.loadClass(aType.getQualifiedName());
	}

	/**
	 * Executes a call.
	 * 
	 * @param aCall
	 *            the call to execute
	 * @return the results (multiple if the call has an execution multiplier)
	 */
	protected List<CallResult> executeCall(Call aCall) {
		int tempCount = 1;
		if (aCall.getMultiplier() != null && aCall.getMultiplier().getCount() != null) {
			try {
				tempCount = (Integer) valueConverter.convertValue(
						Integer.class,
						aCall.getMultiplier().getCount(),
						conversionContextProvider.get().withUnresolvableVariableHandlingPolicy(
								UnresolvableVariableHandling.EXCEPTION));
			} catch (UnresolvableVariableException exc) {
				// should never happen, since constant values are not allowed to be variables which still need resolving
				throw new ThisShouldNeverHappenException(exc);
			} catch (UnexecutableException exc) {
				// should never happen, since constant values are not allowed to be unexecuted operations
				throw new ThisShouldNeverHappenException(exc);
			}
		}

		List<CallResult> tempResults = new ArrayList<CallResult>();
		for (int i = 0; i < tempCount; i++) {
			tempResults.add(executeCallSingle(aCall));
		}

		return tempResults;
	}

	/**
	 * Executes a call (a single time, doesn't honor the multiplier).
	 * 
	 * @param aCall
	 *            the call to execute
	 * @return the result
	 */
	protected CallResult executeCallSingle(Call aCall) {
		modelChecker.check(aCall);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onCallStart(aCall);
			currentCallback.onCallbackProcessingEnd();
		}

		List<UpdatedVariable> tempUpdatedVariables = new ArrayList<UpdatedVariable>();
		if (aCall.getResults() != null && aCall.getResults().size() > 0) {
			for (NamedCallResult tempNamedResult : aCall.getResults()) {
				String tempResultName = IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(tempNamedResult
						.getName());
				tempUpdatedVariables.add(new UpdatedVariable(tempNamedResult.getTarget().getName(), tempResultName,
						null));
			}
		} else if (aCall.getResult() != null) {
			tempUpdatedVariables.add(new UpdatedVariable(aCall.getResult().getName(), null, null));
		}

		CallResult tempReturn;
		String tempFixtureMethodName = aCall.getDefinition().getFixtureMethod().getMethod().getSimpleName();
		FixtureWrapper<?> tempFixtureInstance = null;

		if (!shouldExecuteFixtures()) {
			tempReturn = new de.gebit.integrity.runner.results.call.UndeterminedResult(tempUpdatedVariables,
					tempFixtureMethodName);
		} else {
			pauseIfRequiredByRemoteClient(false);

			long tempDuration = 0;
			List<ExtendedResult> tempExtendedResults = null;
			try {
				Map<String, Object> tempParameters = parameterResolver.createParameterMap(aCall, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

				tempFixtureInstance = wrapperFactory.newFixtureWrapper(aCall.getDefinition().getFixtureMethod());

				tempFixtureInstance.announceCallResults(aCall.getResult(), aCall.getResults());

				tempDuration = System.nanoTime();
				Object tempResult;
				try {
					tempResult = tempFixtureInstance.execute(tempParameters);
				} finally {
					tempDuration = System.nanoTime() - tempDuration;
				}

				if (shouldExecuteFixtures()) {
					// Perform the call to retrieve extended results from the fixture. If this crashes, log the stack
					// trace to stdout, but ignore it otherwise - it's non-critical to the actual test result.
					try {
						tempExtendedResults = tempFixtureInstance
								.retrieveExtendedResults(FixtureInvocationResult.SUCCESS);
					} catch (Throwable exc) {
						exc.printStackTrace();
					}
				}

				if (aCall.getResults() != null && aCall.getResults().size() > 0) {
					Map<String, Object> tempFixtureResultMap = ParameterUtil
							.getValuesFromNamedResultContainer(tempResult);
					for (UpdatedVariable tempUpdatedVariable : tempUpdatedVariables) {
						Object tempSingleFixtureResult = tempFixtureResultMap.get(tempUpdatedVariable
								.getParameterName());
						tempUpdatedVariable.setValue(tempSingleFixtureResult);
						setVariableValue(tempUpdatedVariable.getTargetVariable(), tempSingleFixtureResult, true);
					}
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempUpdatedVariables,
							tempFixtureInstance, tempFixtureMethodName, tempDuration, tempExtendedResults);
				} else if (aCall.getResult() != null) {
					tempUpdatedVariables.get(0).setValue(tempResult);
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempUpdatedVariables,
							tempFixtureInstance, tempFixtureMethodName, tempDuration, tempExtendedResults);
					setVariableValue(aCall.getResult().getName(), tempResult, true);
				} else {
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempUpdatedVariables,
							tempFixtureInstance, tempFixtureMethodName, tempDuration, tempExtendedResults);
				}
			} catch (Throwable exc) {
				if (shouldExecuteFixtures()) {
					try {
						tempExtendedResults = tempFixtureInstance
								.retrieveExtendedResults(FixtureInvocationResult.EXCEPTION);
					} catch (Throwable exc2) {
						exc2.printStackTrace();
					}
				}

				tempReturn = new de.gebit.integrity.runner.results.call.ExceptionResult(exc, tempUpdatedVariables,
						tempFixtureInstance, tempFixtureMethodName, tempDuration, tempExtendedResults);

				handlePossibleAbortException(exc);
			}
		}

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onCallFinish(aCall, tempReturn);
			currentCallback.onCallbackProcessingEnd();
		}

		if (tempFixtureInstance != null) {
			tempFixtureInstance.release();
		}

		return tempReturn;
	}

	/**
	 * Test execution is splitted in phases.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected enum Phase {

		/**
		 * The dry run is used to build up the {@link SetList}. In this phase, the whole model is walked, but no forks
		 * are being started and no test/call fixtures are being executed.
		 */
		DRY_RUN,

		/**
		 * The actual test run.
		 */
		TEST_RUN;

	}

	private FixtureInvocationResult evaluateTestSubResultsToFixtureInvocationResult(List<TestSubResult> someSubResults) {
		boolean tempHasFailure = false;
		for (TestSubResult tempSubResult : someSubResults) {
			if (tempSubResult instanceof TestExceptionSubResult) {
				return FixtureInvocationResult.EXCEPTION;
			} else {
				if (!tempSubResult.wereAllComparisonsSuccessful()) {
					tempHasFailure = true;
				}
			}
		}

		return tempHasFailure ? FixtureInvocationResult.FAILURE : FixtureInvocationResult.SUCCESS;
	}

	/**
	 * Determines whether we should actually execute fixture method calls at the moment.
	 * 
	 * @return true if calls should be executed, false otherwise
	 */
	protected boolean shouldExecuteFixtures() {
		if (currentPhase == Phase.DRY_RUN) {
			return false;
		} else {
			if (MY_FORK_NAME != null) {
				return (forkInExecution != null && IntegrityDSLUtil.getQualifiedForkName(forkInExecution).equals(
						MY_FORK_NAME));
			} else {
				return (forkInExecution == null);
			}
		}
	}

	/**
	 * Pauses execution (blocks the method call) if the remoting client requested to do so via execution control or
	 * breakpoints.
	 * 
	 * @param aForkSyncFlag
	 *            true if we are pausing for fork synchronization reasons
	 */
	protected void pauseIfRequiredByRemoteClient(boolean aForkSyncFlag) {
		if (remotingServer == null) {
			return;
		}

		Integer tempLastTestOrCallEntryRef = setList.getLastCreatedEntryId(SetListEntryTypes.CALL,
				SetListEntryTypes.TEST);

		if (tempLastTestOrCallEntryRef != null && breakpoints.contains(tempLastTestOrCallEntryRef)) {
			removeBreakpoint(tempLastTestOrCallEntryRef);
		} else if (shallWaitBeforeNextStep && shouldExecuteFixtures()) {
			resetWaitBeforeNextStep();
		} else {
			// do not wait
			remotingServer.updateExecutionState(ExecutionStates.RUNNING);
			return;
		}

		try {
			waitForContinue(aForkSyncFlag);
		} catch (InterruptedException exc) {
			// just continue
		}
	}

	/**
	 * Pause execution (blocks method call) until continuation is triggered by remoting.
	 * 
	 * @param aForkSyncFlag
	 *            true if we are pausing for fork synchronization reasons
	 * @throws InterruptedException
	 */
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

	/**
	 * Removes a specific breakpoint.
	 * 
	 * @param anEntryReference
	 *            the setlist entry reference at which the breakpoint is set
	 */
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

	/**
	 * Creates a new breapoint.
	 * 
	 * @param anEntryReference
	 *            the setlist entry reference at which the breakpoint will be created
	 */
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
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class RemotingListener implements IntegrityRemotingServerListener {

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// nothing to do
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
				Fork tempFork = forkMap.get(forkInExecution);
				tempFork.getClient().controlExecution(ExecutionCommands.RUN);
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
				scheduleWaitBeforeNextStep();
			}
		}

		@Override
		public void onStepIntoCommand(Endpoint anEndpoint) {
			if (!isFork() && forkInExecution != null) {
				// if we're the master and a fork is active, we're waiting for a fork, thus this command
				// is meant for the fork
				Fork tempFork = forkMap.get(forkInExecution);
				tempFork.getClient().controlExecution(ExecutionCommands.STEP_INTO);
			} else {
				scheduleWaitBeforeNextStep();
				executionWaiter.release();
			}
		}

		@Override
		public void onCreateBreakpoint(Integer anEntryReference, Endpoint anEndpoint) {
			if (anEntryReference == null) {
				scheduleWaitBeforeNextStep();
			} else {
				createBreakpoint(anEntryReference);
			}
		}

		@Override
		public void onRemoveBreakpoint(Integer anEntryReference, Endpoint anEndpoint) {
			if (anEntryReference == null) {
				resetWaitBeforeNextStep();
			} else {
				removeBreakpoint(anEntryReference);
			}
		}

		@Override
		public void onVariableUpdateRetrieval(String aVariableName, Serializable aValue) {
			setVariableValue(aVariableName, aValue, false);
		}

		@Override
		public void onShutdownRequest() {
			// Shutdown hook(s) will be called after this command automatically!
			System.exit(-1);
		}
	}

	public static boolean isFork() {
		return MY_FORK_NAME != null;
	}

	/**
	 * Creates a new fork instance. This starts up the forked JVM and connects to it for remote control.
	 * 
	 * @param aSuiteCall
	 *            the suite call that shall be run on the fork
	 * @return the new fork
	 * @throws ForkException
	 *             if any problem arises during forking
	 */
	@SuppressWarnings("unchecked")
	protected Fork createFork(Suite aSuiteCall) throws ForkException {
		ForkDefinition tempForkDef = aSuiteCall.getFork();
		Class<? extends Forker> tempForkerClass = DefaultForker.class;
		if (tempForkDef.getForkerClass() != null) {
			try {
				tempForkerClass = (Class<? extends Forker>) getClassForJvmType(tempForkDef.getForkerClass().getType());
			} catch (ClassCastException exc) {
				throw new ForkException("Could not create fork '" + tempForkDef.getName()
						+ "': forker class not usable.", exc);
			} catch (ClassNotFoundException exc) {
				throw new ForkException("Could not create fork '" + tempForkDef.getName()
						+ "': forker class not found.", exc);
			}
		}

		if (tempForkerClass.getConstructors().length != 1) {
			throw new ForkException("Found illegal number of constructors in forker class (must be exactly one!)");
		}

		// Forker can be parameterized
		Constructor<? extends Forker> tempConstructor = (Constructor<? extends Forker>) tempForkerClass
				.getConstructors()[0];
		Object[] tempParameters = new Object[tempConstructor.getParameterTypes().length];
		try {
			for (int i = 0; i < tempConstructor.getParameterTypes().length; i++) {
				for (Annotation tempAnnotation : tempConstructor.getParameterAnnotations()[i]) {
					if (ForkerParameter.class.isAssignableFrom(tempAnnotation.annotationType())) {
						String tempName = ((ForkerParameter) tempAnnotation).name();
						if (tempName != null) {
							for (ForkParameter tempParameter : tempForkDef.getParameters()) {
								String tempParamName = IntegrityDSLUtil
										.getParamNameStringFromParameterName(tempParameter.getName());
								if (tempName.equals(tempParamName)) {
									Class<?> tempTargetType = tempConstructor.getParameterTypes()[i];
									tempParameters[i] = valueConverter.convertValue(
											tempTargetType,
											tempParameter.getValue(),
											conversionContextProvider.get().withUnresolvableVariableHandlingPolicy(
													UnresolvableVariableHandling.EXCEPTION));
									break;
								}
							}
						}
					}
				}
			}
		} catch (ConversionException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': failed to resolve forker parameters.", exc);
		} catch (UnresolvableVariableException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': failed to resolve forker parameters.", exc);
		} catch (UnexecutableException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': failed to resolve forker parameters.", exc);
		}

		Forker tempForker = null;
		try {
			tempForker = tempConstructor.newInstance(tempParameters);
		} catch (InstantiationException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': forker class not instantiable.", exc);
		} catch (IllegalAccessException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': forker class not instantiable.", exc);
		} catch (IllegalArgumentException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': forker class not instantiable.", exc);
		} catch (InvocationTargetException exc) {
			throw new ForkException("Could not create fork '" + tempForkDef.getName()
					+ "': forker class not instantiable.", exc);
		}

		Fork tempFork = new Fork(aSuiteCall.getFork(), tempForker, commandLineArguments,
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
								diedForks.add(tempEntry.getKey());
								return;
							}
						}
					}
				});
		injector.injectMembers(tempFork);
		tempFork.start();

		long tempTimeout = System.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY) != null ? Integer.parseInt(System
				.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY)) : getForkConnectionTimeoutDefault();

		long tempStartTime = System.nanoTime();
		while (System.nanoTime() - tempStartTime < (tempTimeout * 1000 * 1000000)) {
			try {
				if (!tempFork.isAlive() || tempFork.connect(getForkSingleConnectTimeout(), javaClassLoader)) {
					break;
				}
			} catch (IOException exc) {
				// this is expected -> will simply retry
			}

			try {
				Thread.sleep(getForkConnectDelay());
			} catch (InterruptedException exc) {
				// ignored
			}
		}

		if (tempFork.isAlive() && tempFork.isConnected()) {
			// initially, we'll send a snapshot of all current non-encapsulated variable values to the fork
			// (encapsulated values are predefined in the test script and thus already known to the fork)
			for (Entry<VariableOrConstantEntity, Object> tempEntry : variableManager.getAllEntries()) {
				if (!(tempEntry.getValue() instanceof ValueOrEnumValueOrOperation)
						&& !(tempEntry.getKey() instanceof ConstantEntity)) {
					tempFork.updateVariableValue(tempEntry.getKey(), tempEntry.getValue());
				}
			}

			// and the fork will also need all current breakpoints
			for (Integer tempBreakpoint : breakpoints) {
				tempFork.getClient().createBreakpoint(tempBreakpoint);
			}

			// and the magic pause-on-next-instruction "breakpoint" too
			if (shallWaitBeforeNextStep) {
				tempFork.getClient().createBreakpoint(null);
			}

			// and now we'll wait until the fork is paused
			while (tempFork.isAlive() && tempFork.isConnected()
					&& tempFork.getExecutionState() != ExecutionStates.PAUSED_SYNC) {
				try {
					Thread.sleep(getForkPauseWaitInterval());
				} catch (InterruptedException exc) {
					// nothing to do here
				}
			}

			// a last sanity check
			if (tempFork.isAlive() && tempFork.isConnected()) {
				return tempFork;
			}
		}

		try {
			tempFork.kill();
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
		throw new ForkException("Could not successfully establish a control connection to the fork.");
	}

	/**
	 * Schedules a "wait for the master" before the next execution step.
	 */
	protected void scheduleWaitBeforeNextStep() {
		shallWaitBeforeNextStep = true;
	}

	/**
	 * Resets a scheduled interruption (see {@link #scheduleWaitBeforeNextStep()}).
	 */
	protected void resetWaitBeforeNextStep() {
		shallWaitBeforeNextStep = false;
	}

	/**
	 * Checks and ensures that the specified object has no validation errors.
	 * 
	 * @param anObject
	 *            Object to be validated.
	 */
	protected void checkForValidationError(EObject anObject) {
		Diagnostic tempDiagnostic = Diagnostician.INSTANCE.validate(anObject);
		if (tempDiagnostic == null || (tempDiagnostic.getSeverity() & BasicDiagnostic.ERROR) == 0) {
			return;
		}
		StringBuilder tempResult = new StringBuilder();
		Deque<Diagnostic> tempStack = new LinkedList<Diagnostic>();

		ModelSourceInformationElement tempModelInfo = modelSourceExplorer.determineSourceInformation(anObject);
		final ICompositeNode tempConflictOrigin = NodeModelUtils.getNode(anObject);
		tempResult.append("Validation Error at " + tempModelInfo);
		tempStack.addAll(tempDiagnostic.getChildren());
		while (!tempStack.isEmpty()) {
			tempResult.append("\n\t");
			Diagnostic tempCurrent = tempStack.poll();
			tempStack.addAll(tempCurrent.getChildren());
			tempResult.append(tempCurrent.getMessage());
		}
		throw new ValidationException(tempResult.toString(), tempConflictOrigin);
	}
}
