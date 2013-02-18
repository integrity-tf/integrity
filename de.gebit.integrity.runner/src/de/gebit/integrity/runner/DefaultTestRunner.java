package de.gebit.integrity.runner;

import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ConstantValue;
import de.gebit.integrity.dsl.DslFactory;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.MethodReference;
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
import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.forker.ForkerParameter;
import de.gebit.integrity.operations.UnexecutableException;
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
import de.gebit.integrity.runner.forking.DefaultForker;
import de.gebit.integrity.runner.forking.Fork;
import de.gebit.integrity.runner.forking.ForkCallback;
import de.gebit.integrity.runner.forking.ForkException;
import de.gebit.integrity.runner.forking.ForkResultSummary;
import de.gebit.integrity.runner.forking.Forker;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.operations.RandomNumberOperation;
import de.gebit.integrity.runner.results.Result;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.call.CallResult.UpdatedVariable;
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
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The test runner executes tests. This class is the core of the Integrity runtime system.
 * 
 * 
 * @author Rene Schneider
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
	 * Initializes a fresh test runner instance.
	 * 
	 * @param aModel
	 *            the model to execute
	 * @param someParameterizedConstants
	 *            Maps fully qualified constant names (must be those with the "parameterized" keyword) to their desired
	 *            value. This way, test execution can be parameterized from outside.
	 * @param aCallback
	 *            the callback to use to report test results
	 * @param aRemotingPort
	 *            the port on which the remoting server should listen, or null if remoting should be disabled
	 * @param aRemotingBindHost
	 *            the host name (or IP) to which the remoting server should bind
	 * @param aRandomSeed
	 *            the seed for the {@link RandomNumberOperation} (optional; randomly determined if not given).
	 * @param someCommandLineArguments
	 *            all command line arguments as given to the original Java programs' main routine (required for
	 *            forking!)
	 * @throws IOException
	 *             if the remoting server startup fails
	 */
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
			remotingServer = new IntegrityRemotingServer(aRemotingBindHost, tempRemotingPort, remotingListener);
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
	 * Initializes the parameterized constants from the {@link #parameterizedConstantValues} map.
	 */
	protected void initializeParameterizedConstants() {
		if (parameterizedConstantValues != null) {
			for (Entry<String, String> tempEntry : parameterizedConstantValues.entrySet()) {
				VariableOrConstantEntity tempEntity = model.getVariableOrConstantByName(tempEntry.getKey());
				if (tempEntity == null) {
					throw new IllegalArgumentException("Parameterized constant '" + tempEntry.getKey()
							+ "' not defined in test scripts.");
				}
				ConstantDefinition tempDefinition = (ConstantDefinition) tempEntity.eContainer();
				if (!(tempEntity instanceof ConstantEntity)) {
					throw new IllegalArgumentException("Parameterized constant '" + tempEntry.getKey()
							+ "' not defined as a constant in test scripts.");
				} else if (tempDefinition.getParameterized() == null) {
					throw new IllegalArgumentException("Parameterized constant '" + tempEntry.getKey()
							+ "' not defined as 'parameterized' in test scripts.");
				} else {
					defineConstant(
							tempDefinition,
							tempEntry.getValue(),
							(tempDefinition.eContainer() instanceof SuiteDefinition) ? ((SuiteDefinition) tempDefinition
									.eContainer()) : null);
				}
			}
		}
	}

	/**
	 * Initializes all constants with the values given in the scripts.
	 */
	protected void initializeConstants() {
		for (ConstantDefinition tempConstantDef : model.getConstantDefinitionsInPackages()) {
			defineConstant(tempConstantDef, null);
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
		RandomNumberOperation.reSeed();
	}

	/**
	 * Actually executes a root suite call.
	 * 
	 * @param aRootSuiteCall
	 *            the suite call to execute
	 * @return the result
	 */
	protected SuiteSummaryResult runInternal(Suite aRootSuiteCall) {
		if (currentCallback != null) {
			currentCallback.onExecutionStart(model, variantInExecution);
		}

		initializeParameterizedConstants();
		initializeConstants();
		initializeVariables();

		SuiteSummaryResult tempResult = callSuiteSingle(aRootSuiteCall);

		if (currentCallback != null) {
			currentCallback.onExecutionFinish(model, tempResult);
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
				tempCount = (Integer) valueConverter.convertValue(Integer.class, aSuiteCall.getMultiplier().getCount(),
						UnresolvableVariableHandling.EXCEPTION);
			} catch (UnresolvableVariableException exc) {
				// should never happen, since constant values are not allowed to be variables which still need resolving
				throw new ThisShouldNeverHappenException();
			} catch (UnexecutableException exc) {
				// should never happen, since constant values are not allowed to be unexecuted operations
				throw new ThisShouldNeverHappenException();
			}
		}

		List<SuiteSummaryResult> tempResults = new ArrayList<SuiteSummaryResult>();
		for (int i = 0; i < tempCount; i++) {
			tempResults.add(callSuiteSingle(aSuiteCall));
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

		List<SuiteDefinition> tempSetupSuitesExecuted = new ArrayList<SuiteDefinition>();
		Set<SuiteDefinition> tempSetupsAlreadyRun = setupSuitesExecuted.get(forkInExecution);
		if (tempSetupsAlreadyRun == null) {
			tempSetupsAlreadyRun = new HashSet<SuiteDefinition>();
			setupSuitesExecuted.put(forkInExecution, tempSetupsAlreadyRun);
		}
		for (SuiteDefinition tempSetupSuite : aSuiteCall.getDefinition().getDependencies()) {
			if (!tempSetupsAlreadyRun.contains(tempSetupSuite)) {
				tempSetupsAlreadyRun.add(tempSetupSuite);
				tempSetupSuitesExecuted.add(tempSetupSuite);
				if (currentCallback != null) {
					currentCallback.onSetupStart(tempSetupSuite);
				}

				long tempStart = System.nanoTime();
				Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(tempSetupSuite);
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
				defineVariable(tempParam.getName(), variableManager.get(tempVariable.getName()),
						aSuiteCall.getDefinition());
			} else {
				defineVariable(tempParam.getName(), tempParam.getValue(), aSuiteCall.getDefinition());
			}
		}

		long tempSuiteDuration = System.nanoTime();
		Map<SuiteStatementWithResult, List<? extends Result>> tempResults = executeSuite(aSuiteCall.getDefinition());
		tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

		for (int i = tempSetupSuitesExecuted.size() - 1; i >= 0; i--) {
			SuiteDefinition tempSetupSuite = tempSetupSuitesExecuted.get(i);
			for (SuiteDefinition tempTearDownSuite : tempSetupSuite.getFinalizers()) {
				if (currentCallback != null) {
					currentCallback.onTearDownStart(tempTearDownSuite);
				}

				long tempStart = System.nanoTime();
				Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(tempTearDownSuite);
				SuiteResult tempTearDownResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempSuiteResults,
						null, null, System.nanoTime() - tempStart);
				tempTearDownResults.put(tempTearDownSuite, tempTearDownResult);

				if (currentCallback != null) {
					currentCallback.onTearDownFinish(tempTearDownSuite, tempTearDownResult);
				}
			}

			tempSetupsAlreadyRun.remove(tempSetupSuite);
		}

		SuiteSummaryResult tempResult = (!shouldExecuteFixtures()) ? null : new SuiteResult(tempResults,
				tempSetupResults, tempTearDownResults, tempSuiteDuration);

		if (currentCallback != null) {
			currentCallback.onSuiteFinish(aSuiteCall, tempResult);
		}

		if (forkInExecution != null && forkInExecution.equals(aSuiteCall.getFork())) {
			if (currentPhase == Phase.TEST_RUN) {
				// all of this only has to be done in case of a real test run

				if (!isFork()) {
					// we're the master and need to kick off the fork, which then actually executes the stuff we've just
					// jumped over
					Fork tempFork = forkMap.get(forkInExecution);
					tempSuiteDuration = System.nanoTime();
					ForkResultSummary tempForkResultSummary = tempFork.executeNextSegment();
					tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

					if (tempForkResultSummary != null) {
						tempResult = new SuiteSummaryResult(tempForkResultSummary.getSuccessCount(),
								tempForkResultSummary.getFailureCount(), tempForkResultSummary.getTestExceptionCount(),
								tempForkResultSummary.getCallExceptionCount(), tempSuiteDuration);
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
					currentCallback.onVisibleComment(
							IntegrityDSLUtil.cleanSingleLineComment((VisibleSingleLineComment) tempStatement),
							tempIsTitle, (VisibleComment) tempStatement);
				}
			} else if (tempStatement instanceof VisibleMultiLineComment) {
				if (currentCallback != null) {
					boolean tempIsTitle = (tempStatement instanceof VisibleMultiLineTitleComment);
					currentCallback.onVisibleComment(
							IntegrityDSLUtil.cleanMultiLineComment((VisibleMultiLineComment) tempStatement),
							tempIsTitle, (VisibleComment) tempStatement);
				}
			} else if (tempStatement instanceof VisibleDivider) {
				if (currentCallback != null) {
					currentCallback.onVisibleDivider(((VisibleDivider) tempStatement).getContent(),
							(VisibleDivider) tempStatement);
				}
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
				currentCallback.onConstantDefinition(aDefinition.getName(), aSuite, tempConstantValue,
						(aDefinition.getParameterized() != null));
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
			if (anEntity instanceof VariableEntity) {
				currentCallback.onVariableDefinition((VariableEntity) anEntity, aSuite, tempInitialValue);
			} else if (anEntity instanceof ConstantEntity) {
				currentCallback.onConstantDefinition((ConstantEntity) anEntity, aSuite, tempInitialValue,
						(((ConstantDefinition) anEntity.eContainer()).getParameterized() != null));
			}
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
		TestModel.ensureModelPartConsistency(aTest);

		if (currentCallback != null) {
			currentCallback.onTestStart(aTest);
		}

		TestResult tempReturn = null;
		TestComparisonResult tempComparisonResult;
		Throwable tempException = null;
		Long tempDuration = null;
		FixtureWrapper<?> tempFixtureInstance = null;
		String tempFixtureMethodName = aTest.getDefinition().getFixtureMethod().getMethod().getSimpleName();

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

			long tempStart = System.nanoTime();

			try {
				Map<String, Object> tempParameters = parameterResolver.createParameterMap(aTest, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

				tempFixtureInstance = wrapperFactory.newFixtureWrapper(aTest.getDefinition().getFixtureMethod()
						.getType());

				tempStart = System.nanoTime();
				Object tempFixtureResult = executeFixtureMethod(tempFixtureInstance, aTest.getDefinition()
						.getFixtureMethod(), tempParameters);
				tempDuration = System.nanoTime() - tempStart;

				if (aTest.getResults() != null && aTest.getResults().size() > 0) {
					Map<String, Object> tempFixtureResultMap = ParameterUtil
							.getValuesFromNamedResultContainer(tempFixtureResult);

					for (NamedResult tempNamedResult : aTest.getResults()) {
						String tempResultName = IntegrityDSLUtil
								.getExpectedResultNameStringFromTestResultName(tempNamedResult.getName());
						Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);
						if (resultComparator.compareResult(tempSingleFixtureResult, tempNamedResult.getValue(),
								tempFixtureInstance, aTest.getDefinition().getFixtureMethod(), tempResultName)) {
							tempComparisonResult = new TestComparisonSuccessResult(tempResultName,
									tempSingleFixtureResult, tempNamedResult.getValue());
						} else {
							tempComparisonResult = new TestComparisonFailureResult(tempResultName,
									tempSingleFixtureResult, tempNamedResult.getValue());
						}
						tempComparisonMap.put(tempResultName, tempComparisonResult);
					}
				} else {
					if (resultComparator.compareResult(tempFixtureResult, aTest.getResult(), tempFixtureInstance, aTest
							.getDefinition().getFixtureMethod(), null)) {
						tempComparisonResult = new TestComparisonSuccessResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
								tempFixtureResult, aTest.getResult());
					} else {
						tempComparisonResult = new TestComparisonFailureResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
								tempFixtureResult, aTest.getResult());
					}
					tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				tempDuration = System.nanoTime() - tempStart;
				tempException = exc;
				tempComparisonResult = new TestComparisonUndeterminedResult(ParameterUtil.DEFAULT_PARAMETER_NAME,
						aTest.getResult());
				tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
			}
		}

		List<TestSubResult> tempSubResults = new LinkedList<TestSubResult>();
		if (tempException != null) {
			tempSubResults.add(new TestExceptionSubResult(tempException, tempComparisonMap, tempFixtureInstance,
					tempFixtureMethodName, tempDuration));
		} else {
			tempSubResults.add(new TestExecutedSubResult(tempComparisonMap, tempFixtureInstance, tempFixtureMethodName,
					tempDuration));
		}
		tempReturn = new TestResult(tempSubResults, tempFixtureInstance, tempFixtureMethodName, tempDuration);

		if (currentCallback != null) {
			currentCallback.onTestFinish(aTest, tempReturn);
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
		TestModel.ensureModelPartConsistency(aTest);

		if (currentCallback != null) {
			currentCallback.onTableTestStart(aTest);
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
				currentCallback.onTableTestRowStart(aTest, tempRow);
			}

			Map<String, TestComparisonResult> tempComparisonMap = new LinkedHashMap<String, TestComparisonResult>();
			TestComparisonResult tempComparisonResult = null;
			Throwable tempException = null;
			Long tempDuration = null;

			if (!shouldExecuteFixtures()) {
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
			} else {
				long tempStart = System.nanoTime();
				try {
					Map<String, Object> tempParameters = parameterResolver.createParameterMap(aTest, tempRow, true,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

					if (tempFixtureInstance == null) {
						// only instantiate on first pass
						tempFixtureInstance = wrapperFactory.newFixtureWrapper(aTest.getDefinition().getFixtureMethod()
								.getType());
					}

					tempStart = System.nanoTime();
					Object tempFixtureResult = executeFixtureMethod(tempFixtureInstance, aTest.getDefinition()
							.getFixtureMethod(), tempParameters);
					tempDuration = System.nanoTime() - tempStart;

					if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
						Map<String, Object> tempFixtureResultMap = ParameterUtil
								.getValuesFromNamedResultContainer(tempFixtureResult);

						int tempColumn = aTest.getParameterHeaders().size();
						for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
							String tempResultName = IntegrityDSLUtil
									.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
							ValueOrEnumValueOrOperationCollection tempExpectedValue = (tempColumn < tempRow.getValues()
									.size()) ? tempRow.getValues().get(tempColumn).getValue() : null;

							Object tempSingleFixtureResult = tempFixtureResultMap.get(tempResultName);

							if (resultComparator.compareResult(tempSingleFixtureResult, tempExpectedValue,
									tempFixtureInstance, aTest.getDefinition().getFixtureMethod(), tempResultName)) {
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
						ValueOrEnumValueOrOperationCollection tempExpectedValue = null;
						if (aTest.getDefaultResultColumn() != null) {
							// the last column MUST be the result column
							tempExpectedValue = tempRow.getValues().get(tempRow.getValues().size() - 1).getValue();
						}

						if (resultComparator.compareResult(tempFixtureResult, tempExpectedValue, tempFixtureInstance,
								aTest.getDefinition().getFixtureMethod(), null)) {
							tempComparisonResult = new TestComparisonSuccessResult(
									ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult, tempExpectedValue);
						} else {
							tempComparisonResult = new TestComparisonFailureResult(
									ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult, tempExpectedValue);
						}
						tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
					}
					// SUPPRESS CHECKSTYLE IllegalCatch
				} catch (Throwable exc) {
					tempDuration = System.nanoTime() - tempStart;
					tempException = exc;
					// add undetermined result entries for all comparisons
					if (aTest.getResultHeaders() != null && aTest.getResultHeaders().size() > 0) {
						int tempColumn = aTest.getParameterHeaders().size();
						for (ResultTableHeader tempNamedResultHeader : aTest.getResultHeaders()) {
							String tempResultName = IntegrityDSLUtil
									.getExpectedResultNameStringFromTestResultName(tempNamedResultHeader.getName());
							ValueOrEnumValueOrOperationCollection tempExpectedValue = (tempColumn < tempRow.getValues()
									.size()) ? tempRow.getValues().get(tempColumn).getValue() : null;
							tempComparisonResult = new TestComparisonUndeterminedResult(tempResultName,
									tempExpectedValue);
							tempComparisonMap.put(tempResultName, tempComparisonResult);
							tempColumn++;
						}
					} else {
						ValueOrEnumValueOrOperationCollection tempExpectedValue = null;
						if (aTest.getDefaultResultColumn() != null) {
							// the last column MUST be the result column
							tempExpectedValue = tempRow.getValues().get(tempRow.getValues().size() - 1).getValue();
						}
						tempComparisonResult = new TestComparisonUndeterminedResult(
								ParameterUtil.DEFAULT_PARAMETER_NAME, tempExpectedValue);
						tempComparisonMap.put(ParameterUtil.DEFAULT_PARAMETER_NAME, tempComparisonResult);
					}
				}
			}

			TestSubResult tempSubResult;

			if (tempException != null) {
				tempSubResult = new TestExceptionSubResult(tempException, tempComparisonMap, tempFixtureInstance,
						tempFixtureMethodName, tempDuration);
			} else {
				tempSubResult = new TestExecutedSubResult(tempComparisonMap, tempFixtureInstance,
						tempFixtureMethodName, tempDuration);
			}
			tempSubResults.add(tempSubResult);

			if (currentCallback != null) {
				currentCallback.onTableTestRowFinish(aTest, tempRow, tempSubResult);
			}
		}

		Long tempOuterDuration = System.nanoTime() - tempOuterStart;

		TestResult tempReturn = new TestResult(tempSubResults, tempFixtureInstance, tempFixtureMethodName,
				currentPhase == Phase.DRY_RUN ? null : tempOuterDuration);

		if (currentCallback != null) {
			currentCallback.onTableTestFinish(aTest, tempReturn);
		}

		if (tempFixtureInstance != null) {
			tempFixtureInstance.release();
		}

		return tempReturn;
	}

	/**
	 * Calls a given method on a fixture instance.
	 * 
	 * @param aFixtureInstance
	 *            the fixture
	 * @param aMethod
	 *            the method reference to execute
	 * @param someParameters
	 *            the parameters to use for the call
	 * @return the return value
	 * @throws Exception
	 */
	protected Object executeFixtureMethod(FixtureWrapper<?> aFixtureInstance, MethodReference aMethod,
			Map<String, Object> someParameters) throws Exception {
		return aFixtureInstance.execute(aMethod.getMethod().getSimpleName(), someParameters);
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
		return getModelClassLoader().loadClass(aType.getQualifiedName());
	}

	/**
	 * Returns the classloader defined in the model. This one should be used for instantiation of fixtures and
	 * operations.
	 * 
	 * @return the classloader defined in the test model
	 */
	protected ClassLoader getModelClassLoader() {
		return model.getInjector().getInstance(ClassLoader.class);
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
				tempCount = (Integer) valueConverter.convertValue(Integer.class, aCall.getMultiplier().getCount(),
						UnresolvableVariableHandling.EXCEPTION);
			} catch (UnresolvableVariableException exc) {
				// should never happen, since constant values are not allowed to be variables which still need resolving
				throw new ThisShouldNeverHappenException();
			} catch (UnexecutableException exc) {
				// should never happen, since constant values are not allowed to be unexecuted operations
				throw new ThisShouldNeverHappenException();
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
		TestModel.ensureModelPartConsistency(aCall);

		if (currentCallback != null) {
			currentCallback.onCallStart(aCall);
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

			long tempStart = System.nanoTime();
			try {
				Map<String, Object> tempParameters = parameterResolver.createParameterMap(aCall, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

				tempFixtureInstance = wrapperFactory.newFixtureWrapper(aCall.getDefinition().getFixtureMethod()
						.getType());

				tempStart = System.nanoTime();
				Object tempResult = executeFixtureMethod(tempFixtureInstance, aCall.getDefinition().getFixtureMethod(),
						tempParameters);
				long tempDuration = System.nanoTime() - tempStart;

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
							tempFixtureInstance, tempFixtureMethodName, tempDuration);
				} else if (aCall.getResult() != null) {
					tempUpdatedVariables.get(0).setValue(tempResult);
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempUpdatedVariables,
							tempFixtureInstance, tempFixtureMethodName, tempDuration);
					setVariableValue(aCall.getResult().getName(), tempResult, true);
				} else {
					tempReturn = new de.gebit.integrity.runner.results.call.SuccessResult(tempUpdatedVariables,
							tempFixtureInstance, tempFixtureMethodName, tempDuration);
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				tempReturn = new de.gebit.integrity.runner.results.call.ExceptionResult(exc, tempUpdatedVariables,
						tempFixtureInstance, tempFixtureMethodName, System.nanoTime() - tempStart);
			}
		}

		if (currentCallback != null) {
			currentCallback.onCallFinish(aCall, tempReturn);
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
	 * @author Rene Schneider
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
				return (forkInExecution != null && forkInExecution.getName().equals(MY_FORK_NAME));
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
		} else if (shallWaitBeforeNextStep) {
			shallWaitBeforeNextStep = false;
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
	 * @author Rene Schneider
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
				shallWaitBeforeNextStep = true;
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
									tempParameters[i] = valueConverter.convertValue(tempTargetType,
											tempParameter.getValue(), UnresolvableVariableHandling.EXCEPTION);
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
				if (!tempFork.isAlive() || tempFork.connect(getForkSingleConnectTimeout())) {
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
}
