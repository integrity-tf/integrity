/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
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
import java.math.BigDecimal;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

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
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturn;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TimeSet;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableAssignment;
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
import de.gebit.integrity.exceptions.MethodNotFoundException;
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
import de.gebit.integrity.parameter.resolving.TableTestParameterResolveMethod;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.parameter.variables.VariableOrConstantEntityInitialValueDefinitionCallback;
import de.gebit.integrity.providers.TestResourceProvider;
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
import de.gebit.integrity.remoting.transport.messages.TimeSyncResultMessage;
import de.gebit.integrity.runner.callbacks.CompoundTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.SuiteSkipReason;
import de.gebit.integrity.runner.callbacks.TestFormatter;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.callbacks.remoting.SetListCallback;
import de.gebit.integrity.runner.comparator.ResultComparator;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ValidationException;
import de.gebit.integrity.runner.forking.DefaultForker;
import de.gebit.integrity.runner.forking.Fork;
import de.gebit.integrity.runner.forking.ForkCallback;
import de.gebit.integrity.runner.forking.ForkException;
import de.gebit.integrity.runner.forking.ForkResultSummary;
import de.gebit.integrity.runner.forking.Forker;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.logging.TestRunnerPerformanceLogger;
import de.gebit.integrity.runner.modelcheck.ModelChecker;
import de.gebit.integrity.runner.operations.RandomNumberOperation;
import de.gebit.integrity.runner.results.Result;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.call.CallResult.UpdatedVariable;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonUndeterminedResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.runner.time.TestTimeAdapter;
import de.gebit.integrity.runner.time.TimeSyncState;
import de.gebit.integrity.runner.wrapper.ExceptionWrapper;
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
	 * The test formatter.
	 */
	@Inject
	protected TestFormatter testFormatter;

	/**
	 * The performance logger.
	 */
	@Inject
	protected TestRunnerPerformanceLogger performanceLogger;

	/**
	 * The test time adapter.
	 */
	@Inject
	protected TestTimeAdapter testTimeAdapter;

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
	 * Maps forks to their (intended) timesync states.
	 */
	protected Map<ForkDefinition, TimeSyncState> forkTimeSyncStates = new HashMap<>();

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
	 * This list is used to collect invocations to callbacks during a parallel constant/variable definition phase.
	 * Callbacks are not expected to be thread-safe, so we need to synchronize those calls anyway, and we want to have
	 * them in deterministic order, so we have to sort them by the variable/constant name.<br>
	 * <br>
	 * The existence of this queue defines that all callback invocations should be delayed. If it does not exist,
	 * immediate invocation is necessary.
	 */
	protected Queue<Pair<String, Runnable>> constantAndVariableDefinitionDelayedCallbackInvocations;

	/**
	 * If this JVM instance is executing a fork, the name is stored here.
	 */
	protected static final String MY_FORK_NAME = System.getProperty(Forker.SYSPARAM_FORK_NAME);

	/**
	 * The system property that allows to override the timeout used when connecting to forks.
	 */
	protected static final String FORK_CONNECTION_TIMEOUT_PROPERTY = "integrity.fork.timeout.connect";

	/**
	 * The default fork connection timeout, in seconds.
	 */
	protected static final int FORK_CONNECTION_TIMEOUT_DEFAULT = 180;

	/**
	 * The fork connection timeout, in seconds.
	 */
	protected int getForkConnectionTimeout() {
		return System.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY) != null
				? Integer.parseInt(System.getProperty(FORK_CONNECTION_TIMEOUT_PROPERTY))
				: getForkConnectionTimeoutDefault();
	}

	/**
	 * The default fork connection timeout, in seconds.
	 */
	protected int getForkConnectionTimeoutDefault() {
		return FORK_CONNECTION_TIMEOUT_DEFAULT;
	}

	/**
	 * The system property that allows to override the single connect timeout used when connecting to forks.
	 */
	protected static final String FORK_SINGLE_CONNECT_TIMEOUT_PROPERTY = "integrity.fork.timeout.single";

	/**
	 * The timeout in milliseconds used for a single connection attempt to a fork. If this timeout is hit, but the total
	 * timeout for connecting is not yet over, another attempt is being started.
	 */
	protected static final int FORK_SINGLE_CONNECT_TIMEOUT_DEFAULT = 10000;

	/**
	 * The timeout in milliseconds used for a single connection attempt to a fork. If this timeout is hit, but the total
	 * timeout for connecting is not yet over, another attempt is being started.
	 */
	protected int getForkSingleConnectTimeout() {
		return System.getProperty(FORK_SINGLE_CONNECT_TIMEOUT_PROPERTY) != null
				? Integer.parseInt(System.getProperty(FORK_SINGLE_CONNECT_TIMEOUT_PROPERTY))
				: getForkSingleConnectTimeoutDefault();
	}

	/**
	 * Default for the timeout in milliseconds used for a single connection attempt to a fork. If this timeout is hit,
	 * but the total timeout for connecting is not yet over, another attempt is being started.
	 */
	protected int getForkSingleConnectTimeoutDefault() {
		return FORK_SINGLE_CONNECT_TIMEOUT_DEFAULT;
	}

	/**
	 * The delay until connection attempts are made to a newly started fork.
	 */
	protected static final int FORK_CONNECT_DELAY = 200;

	/**
	 * The delay until connection attempts are made to a newly started fork.
	 */
	protected int getForkConnectDelay() {
		return FORK_CONNECT_DELAY;
	}

	/**
	 * The interval in which the forks' execution state is checked on first connect.
	 */
	protected static final int FORK_PAUSE_WAIT_INTERVAL = 200;

	/**
	 * The interval in which the forks' execution state is checked on first connect.
	 */
	protected int getForkPauseWaitInterval() {
		return FORK_PAUSE_WAIT_INTERVAL;
	}

	/**
	 * The system property that allows to override the time to wait for a fork to become ready for execution.
	 */
	protected static final String FORK_WAIT_UNTIL_READY_TIMEOUT_PROPERTY = "integrity.fork.timeout.wait";

	/**
	 * The default time to wait for a fork to become ready for execution.
	 */
	protected static final int FORK_WAIT_UNTIL_READY_TIMEOUT_DEFAULT = (int) TimeUnit.MINUTES.toSeconds(5);

	/**
	 * Returns the time to wait for a fork to become ready for execution.
	 */
	protected int getForkWaitUntilReadyTimeout() {
		return System.getProperty(FORK_WAIT_UNTIL_READY_TIMEOUT_PROPERTY) != null
				? Integer.parseInt(System.getProperty(FORK_WAIT_UNTIL_READY_TIMEOUT_PROPERTY))
				: getForkWaitUntilReadyTimeoutDefault();
	}

	/**
	 * Returns the default time to wait for a fork to become ready for execution.
	 */
	protected int getForkWaitUntilReadyTimeoutDefault() {
		return FORK_WAIT_UNTIL_READY_TIMEOUT_DEFAULT;
	}

	/**
	 * The system property that allows to override the single connect timeout used when connecting to forks.
	 */
	protected static final String CHILD_PROCESS_KILL_TIMEOUT_PROPERTY = "integrity.fork.timeout.kill";

	/**
	 * The default time to wait for child processes to be killed.
	 */
	protected static final int CHILD_PROCESS_KILL_TIMEOUT_DEFAULT = 60;

	protected int getChildProcessKillTimeout() {
		return System.getProperty(CHILD_PROCESS_KILL_TIMEOUT_PROPERTY) != null
				? Integer.parseInt(System.getProperty(CHILD_PROCESS_KILL_TIMEOUT_PROPERTY))
				: getChildProcessKillTimeoutDefault();
	}

	protected int getChildProcessKillTimeoutDefault() {
		return CHILD_PROCESS_KILL_TIMEOUT_DEFAULT;
	}

	/**
	 * The fork that is currently being executed. This is set regardless of whether we are a fork ourselves and are
	 * currently executing our own stuff, or whether we are a master or different fork and skipping over a bunch of
	 * invocations due to them being executed by another fork.
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
	 * The single-run suites that have already been executed.
	 */
	protected Set<SuiteDefinition> singleRunSuitesExecuted = new HashSet<>();

	/**
	 * In case of an {@link AbortExecutionException} aborting the test execution, this exception is stored here
	 * (actually, only the message and stack trace string are stored - this is because the data could just as well come
	 * from a fork, in which case an exception can not be transported over the remoting connection).
	 */
	protected ExceptionWrapper abortExecutionCause;

	/**
	 * Maps each {@link ForkDefinition} to the suite call and a number that counts any suite invocations. The fork
	 * should die after this number of suites has executed. Since suite invocation numbers are predeterminable in the
	 * dry run and deterministic, this can be used to find out whether a suite during the test run has been the last one
	 * to run on a particular fork. During this real test run, the counter is decremented on each suite invocation on a
	 * fork, so in the end, we know when the fork has finished execution (= counter reaches zero).<br/>
	 * <br>
	 * This map is only used by the master to keep track of when the forks should die. It will then wait until they do.
	 * The forks still carry the responsibility to terminate their execution in a clean way!
	 */
	protected Map<ForkDefinition, Integer> lastSuiteForFork = new HashMap<ForkDefinition, Integer>();

	/**
	 * This counts the number of suite invocations ttill to be done on this fork. Is only used if this test runner is
	 * indeed a fork (otherwise this value has no meaning). Is somewhat related to {@link #lastSuiteForFork} in that
	 * this is the individual number of invocations on a fork that is left; it is initially seeded with the
	 * corresponding {@link #lastSuiteForFork} value from the master process and then counted down to know when a fork
	 * can take the quick path to termination. Basically this is an optimization to allow for quicker termination on
	 * forks that would otherwise have a huge bunch of test scripts to run through in dry mode when they're finished.
	 */
	protected int numberOfSuiteInvocationsLeftOnThisFork;

	/**
	 * The result of a time sync request from this fork sent to a master is stored here.
	 */
	protected TimeSyncResultMessage timeSyncResult;

	/**
	 * A sync object used to synchronize accesses to {@link #timeSyncResult}.
	 */
	protected final Object timeSyncResultSyncObject = new Object();

	/**
	 * Returns the timeout in seconds for timesync requests originating from this fork, sent to the master and
	 * distributed to a variable number of forks for execution.
	 * 
	 * @param aNumberOfForks
	 *            the number of forks involved in this timesync
	 * @return a timeout in seconds
	 */
	protected int calculateMasterTimeSyncTimeout(int aNumberOfForks) {
		// The default just takes the configured timeout per fork and multiplies it with the number of forks
		return Fork.getForkTimesyncTimeout() * aNumberOfForks;
	}

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

		performRemotingBinding(aRemotingPort, aRemotingBindHost);

		waitForSetListInjection();
	}

	/**
	 * Performs the remoting port binding.
	 * 
	 * @param aRemotingPort
	 *            the port to bind to, or null if no remoting is desired
	 * @param aRemotingBindHost
	 *            the host/IP to bind to
	 * @throws IOException
	 */
	protected void performRemotingBinding(Integer aRemotingPort, String aRemotingBindHost) throws IOException {
		Integer tempRemotingPort = aRemotingPort;
		String tempRemotingHost = aRemotingBindHost;
		if (isFork() && System.getProperty(Forker.SYSPARAM_FORK_REMOTING_HOST) != null) {
			tempRemotingHost = System.getProperty(Forker.SYSPARAM_FORK_REMOTING_HOST);
		}
		if (isFork() && System.getProperty(Forker.SYSPARAM_FORK_REMOTING_PORT) != null) {
			tempRemotingPort = Integer.parseInt(System.getProperty(Forker.SYSPARAM_FORK_REMOTING_PORT));
		}

		if (tempRemotingPort != null) {
			remotingListener = new RemotingListener();
			try {
				remotingServer = new IntegrityRemotingServer(tempRemotingHost, tempRemotingPort, remotingListener,
						javaClassLoader, isFork());
			} catch (BindException exc) {
				System.err.println("FAILED TO BIND REMOTING SERVER TO " + tempRemotingHost + ":" + tempRemotingPort);
				throw exc;
			}

			if (tempRemotingPort == 0) {
				// This message is important! It is being parsed by the master to find out the auto-generated fork port
				// (see de.gebit.integrity.runner.forking.Fork.FORK_HOST_AND_PORT_PATTERN).
				System.out
						.println("Integrity Test Runner bound to " + tempRemotingHost + ":" + remotingServer.getPort());
			}
		}
	}

	/**
	 * If this is a fork, we now need to wait for the setlist and test scripts to be injected by the master! Otherwise
	 * this method returns immediately.
	 * 
	 * @throws IOException
	 */
	protected void waitForSetListInjection() throws IOException {
		if (isFork()) {
			long tempTimeout = System.nanoTime() + TimeUnit.SECONDS.toNanos(getForkConnectionTimeout());

			synchronized (setListWaiter) {
				long tempTimeLeft = 0;
				while (setList == null && tempTimeLeft >= 0) {
					tempTimeLeft = TimeUnit.NANOSECONDS.toMillis(tempTimeout - System.nanoTime());

					if (tempTimeLeft > 0) {
						try {
							setListWaiter.wait(tempTimeLeft);
						} catch (InterruptedException exc) {
							// don't care
						}
					}
				}

				if (setList == null) {
					throw new IOException("Timed out while waiting to receive test script data from master process!");
				}
			}
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
	public SuiteSummaryResult run(SuiteDefinition aRootSuite, VariantDefinition aVariant,
			boolean aBlockForRemotingFlag) {
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
	protected SuiteSummaryResult run(final Suite aRootSuiteCall, VariantDefinition aVariant,
			boolean aBlockForRemotingFlag) {
		variantInExecution = aVariant;
		boolean tempBlockForRemoting = isFork() ? false : aBlockForRemotingFlag;

		Runtime.getRuntime().addShutdownHook(new Thread("Integrity - Process Terminator Shutdown Hook") {

			@Override
			public void run() {
				processTerminator.killAndWait((int) TimeUnit.SECONDS.toMillis(getChildProcessKillTimeout()));
			}
		});

		try {
			boolean tempDryRunHasHappened = false;
			if (!isFork()) {
				// If this is NOT a fork, a dry run is needed to create the initial setlist. In case of forks, the
				// setlist is already initialized by having it be injected from the master (in the initialize method!)
				performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_INIT,
						"Dry Run Phase", new Runnable() {

							@Override
							public void run() {
								currentPhase = Phase.DRY_RUN;
								SetList tempSetList = new SetList();
								reset();
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
							}

						});
				tempDryRunHasHappened = true;
			} else {
				setListCallback = new SetListCallback(setList, remotingServer);
				injector.injectMembers(setListCallback);
			}

			if (remotingServer != null && tempBlockForRemoting) {
				try {
					performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_RUNNER,
							"Wait for Remoting",
							new TestRunnerPerformanceLogger.RunnableWithException<InterruptedException>() {

								@Override
								public void run() throws InterruptedException {
									waitForContinue(false);
								}
							});
				} catch (InterruptedException exc) {
					if (remotingServer != null) {
						remotingServer.closeAll(false);
					}
					return null;
				}
			}
			setList.rewind();
			currentCallback = new CompoundTestRunnerCallback(setListCallback, callback);

			currentPhase = Phase.TEST_RUN;

			if (tempDryRunHasHappened) {
				// The reset is only necessary if we have actually performed a dry run.
				reset();
			}

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
			processTerminator.killAndWait((int) TimeUnit.SECONDS.toMillis(getChildProcessKillTimeout()));
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
			abortExecutionCause = new ExceptionWrapper(anException);

			currentCallback.onAbortExecution(abortExecutionCause.getMessage(), abortExecutionCause.getStackTrace());
		}
	}

	/**
	 * Checks whether a situation demanding for a quick test run abortion has occurred. This is true if either an
	 * {@link AbortExecutionException} has been thrown (locally or by a fork) or if we are a fork and our last suite has
	 * executed. This method does NOT only check something, but also ensures that the {@link #setListCallback} is also
	 * removed from the current callback hierarchy - a very important step, since after this method has returned true
	 * for the first time, a different execution path than normally is expected, which would cause the set list callback
	 * to throw an inconsistency exception.
	 * 
	 * @return true if the test execution shall take the quick path to an end
	 */
	protected boolean checkForAbortion() {
		if (abortExecutionCause != null || (isFork() && numberOfSuiteInvocationsLeftOnThisFork <= 0)) {
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
		for (ConstantDefinition tempDefinition : model.getConstantDefinitionsInPackages()) {
			if (tempDefinition.getParameterized() != null) {
				String tempName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempDefinition.getName(), false);
				String tempValue = (parameterizedConstantValues != null) ? parameterizedConstantValues.get(tempName)
						: null;
				try {
					defineConstant(tempDefinition, tempValue, (tempDefinition.eContainer() instanceof SuiteDefinition)
							? ((SuiteDefinition) tempDefinition.eContainer()) : null);
				} catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
					// Cannot happen - parameterized constants aren't evaluated
				}
			}
		}
	}

	/**
	 * Resets the internal variable state.
	 */
	protected void reset() {
		variableManager.clear(true);
		setupSuitesExecuted.clear();
		singleRunSuitesExecuted.clear();
	}

	/**
	 * Actually executes a root suite call.
	 * 
	 * @param aRootSuiteCall
	 *            the suite call to execute
	 * @return the result
	 */
	protected SuiteSummaryResult runInternal(final Suite aRootSuiteCall) {
		if (remotingServer != null && currentPhase == Phase.TEST_RUN) {
			remotingServer.updateExecutionState(ExecutionStates.RUNNING);
		}

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onExecutionStart(model, variantInExecution);
			currentCallback.onCallbackProcessingEnd();
		}

		variableManager.setInitialValueResolverCallback(new VariableOrConstantEntityInitialValueDefinitionCallback() {

			@Override
			public void triggerDefinition(VariableOrConstantEntity anEntity) {
				if (anEntity instanceof ConstantEntity) {
					try {
						defineConstant((ConstantDefinition) anEntity.eContainer(), null);
					} catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
						throw new RuntimeException("Failed to lazily define constant", exc);
					}
				} else if (anEntity instanceof VariableEntity
						&& (anEntity.eContainer() instanceof VariableDefinition)) {
					// The condition above filters out variables that are actually suite parameters
					defineVariable((VariableDefinition) anEntity.eContainer(), null);
				}
			}
		});

		if (!isFork()) {
			// Forks get their parameterized constants injected by the master on initial connect.
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_INIT,
					"Parameterized Constant Definition", new Runnable() {

						@Override
						public void run() {
							initializeParameterizedConstants();
						}

					});

			// In earlier versions there was a parallelized constant and variable initialization happening here.
			// That was removed, as it turned out to be susceptible of (very rare) concurrency issues, and because
			// the lazy-init approach that is implemented now via the callback seen above is better performance-wise
			// anyway, especially in case of large numbers of global constants.
		}

		SuiteSummaryResult tempResult = performanceLogger.executeAndLog(
				TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_RUNNER, "Execution",
				new TestRunnerPerformanceLogger.RunnableWithResult<SuiteSummaryResult>() {

					@Override
					public SuiteSummaryResult run() {
						return callSuiteSingle(aRootSuiteCall);
					}

				});

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
				tempCount = (Integer) valueConverter.convertValue(Integer.class, aSuiteCall.getMultiplier().getCount(),
						conversionContextProvider.get()
								.withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling.EXCEPTION));
			} catch (UnresolvableVariableException exc) {
				// should never happen, since constant values are not allowed to be variables which still need resolving
				throw new ThisShouldNeverHappenException(exc);
			} catch (UnexecutableException exc) {
				// should never happen, since constant values are not allowed to be unexecuted operations
				throw new ThisShouldNeverHappenException(exc);
			}
		}

		if (aSuiteCall.getDefinition().getSingleRun() != null) {
			// Special handling for single-run suites -> just run them once, regardless of multipliers
			// We assume that it has not yet run when we arrive here -> all callers have to check that!
			tempCount = 1;
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
		ForkDefinition tempForkSpecifiedBySuite = aSuiteCall.getFork();

		if (tempForkSpecifiedBySuite != null && !tempForkInExecutionOnEntry) {
			if (!isFork() && forkInExecution != null && tempForkSpecifiedBySuite != forkInExecution) {
				throw new UnsupportedOperationException(
						"It is not supported to execute another fork while inside a fork ("
								+ tempForkSpecifiedBySuite.getName() + " inside " + forkInExecution.getName() + ").");
			}
			if (forkInExecution == tempForkSpecifiedBySuite) {
				// We can just ignore fork specifications that specify the fork we are already running
				tempForkSpecifiedBySuite = null;
			} else {
				forkInExecution = tempForkSpecifiedBySuite;
				currentCallback.setForkInExecution(forkInExecution);
			}
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
					if (!forkMap.containsKey(tempForkSpecifiedBySuite)) {
						// but first see if this fork has already died once. if true, then the fork has died
						// prematurely, which means we cannot continue execution at all
						if (diedForks.contains(tempForkSpecifiedBySuite)) {
							throw new RuntimeException(
									"Fork " + tempForkSpecifiedBySuite.getName() + " has died prematurely!");
						}
						try {
							forkMap.put(tempForkSpecifiedBySuite, createFork(aSuiteCall));
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

		List<SuiteDefinition> tempSetupSuitesExecuted = executeSetupSuites(aSuiteCall.getDefinition(),
				tempSetupResults);

		// Define variables for all the parameters provided to the suite call
		List<VariableOrConstantEntity> tempVariablesSet = new ArrayList<>();
		for (SuiteParameter tempParam : aSuiteCall.getParameters()) {
			Object tempValueToSet = null;
			if (tempParam.getValue() instanceof Variable) {
				Variable tempVariable = (Variable) tempParam.getValue();
				tempValueToSet = variableManager.get(tempVariable);
			} else {
				tempValueToSet = tempParam.getValue();
			}

			defineVariable(tempParam.getName(), tempValueToSet, aSuiteCall.getDefinition());
			tempVariablesSet.add(tempParam.getName());
		}

		// And for all variables supported by the suite that were missing in the call, their respective default is set
		for (SuiteParameterDefinition tempParamDefinition : aSuiteCall.getDefinition().getParameters()) {
			if (tempParamDefinition.getDefault() != null && !tempVariablesSet.contains(tempParamDefinition.getName())) {
				Object tempValueToSet = null;
				if (tempParamDefinition.getDefault().getValue() instanceof Variable) {
					Variable tempVariable = (Variable) tempParamDefinition.getDefault().getValue();
					tempValueToSet = variableManager.get(tempVariable);
				} else {
					tempValueToSet = tempParamDefinition.getDefault();
				}

				defineVariable(tempParamDefinition.getName(), tempValueToSet, aSuiteCall.getDefinition());
				tempVariablesSet.add(tempParamDefinition.getName());
			}
		}

		// Also define the output variables
		for (SuiteReturnDefinition tempReturnDefinition : aSuiteCall.getDefinition().getReturn()) {
			defineVariable(tempReturnDefinition.getName(), null, aSuiteCall.getDefinition());
			tempVariablesSet.add(tempReturnDefinition.getName());
		}

		long tempSuiteDuration = System.nanoTime();
		Map<SuiteStatementWithResult, List<? extends Result>> tempResults;
		// It is possible that a setup suite caused an abortion. If that's the case, use an empty suite result.
		// Fixes issue #112.
		if (!checkForAbortion()) {
			tempResults = executeSuite(aSuiteCall.getDefinition());
		} else {
			tempResults = new HashMap<>();
		}
		tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

		// Fetch all output values into their respective local target variables
		for (SuiteReturn tempReturn : aSuiteCall.getReturn()) {
			VariableEntity tempSource = tempReturn.getName().getName();
			VariableEntity tempTarget = tempReturn.getTarget().getName();
			Object tempValue = variableManager.get(tempSource);
			// If we are in the dry run phase on a fork, do not send anything to the clients (which in this case is the
			// master process)! This would otherwise possibly cause ConcurrentModificationExceptions on the master.
			// See issue #111, which is fixed by this.
			boolean tempSendToClients = (!isFork() || currentPhase != Phase.DRY_RUN);
			setVariableValue(tempTarget, tempValue, tempSendToClients);
			if (currentCallback != null) {
				currentCallback.onCallbackProcessingStart();
				currentCallback.onReturnVariableAssignment(tempReturn, tempSource, tempTarget, aSuiteCall, tempValue);
				currentCallback.onCallbackProcessingEnd();
			}
		}

		// Now unset all the suite-scoped variables again (fixes issue #44)
		for (VariableOrConstantEntity tempVariableSet : tempVariablesSet) {
			undefineVariable(tempVariableSet);
		}

		if (!checkForAbortion()) {
			executeTearDownSuites(tempSetupSuitesExecuted, tempTearDownResults);
		}

		SuiteSummaryResult tempResult = (!shouldExecuteFixtures()) ? null
				: new SuiteResult(tempResults, tempSetupResults, tempTearDownResults, tempSuiteDuration);

		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onSuiteFinish(aSuiteCall, tempResult);
			currentCallback.onCallbackProcessingEnd();
		}

		if (forkInExecution != null && forkInExecution.equals(tempForkSpecifiedBySuite)) {

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
						// Count backwards during actual execution. When this counter reaches zero, the fork is
						// executing its last suite and shall terminate afterwards.
						Integer tempCounter = lastSuiteForFork.get(tempForkSpecifiedBySuite) - 1;
						lastSuiteForFork.put(tempForkSpecifiedBySuite, tempCounter);

						tempForkResultSummary = tempFork.executeNextSegment(tempCounter <= 0);
					}
					tempSuiteDuration = System.nanoTime() - tempSuiteDuration;

					if (tempForkResultSummary != null) {
						tempResult = new SuiteSummaryResult(tempForkResultSummary.getSuccessCount(),
								tempForkResultSummary.getFailureCount(), tempForkResultSummary.getTestExceptionCount(),
								tempForkResultSummary.getCallExceptionCount(), tempSuiteDuration);
					}

					if (tempFork != null && tempFork.hasAborted()) {
						// If this happens, an abortion has happened on the fork due to an AbortExecutionException.
						// TODO make this nicer, it's kind of ugly to create a fake object with null values
						abortExecutionCause = new ExceptionWrapper(null, null);

						if (tempResult == null && tempForkResultSummary == null) {
							// We may not have any result at this point, as the fork has aborted without providing us
							// one. In order to ensure that at least the exception that triggered the abortion is logged
							// in the counts (and thus a user who typically only looks at the total counts is alerted to
							// the problem), we generate a result here with one exception. This might be wrong actually
							// (for example there could have been a successful test before the exception, which may not
							// be counted in this case), but that's basically what's meant by "test result total numbers
							// may be inaccurate" which is printed out in this case, and the current structure of the
							// master-fork sync protocol makes it hard to perfectly fix this inaccuracy in cases of
							// sudden execution path deviations. Thus, this "forced result" was deemed a good-enough
							// solution. This fixes issue #145: https://github.com/integrity-tf/integrity/issues/145
							tempResult = new SuiteSummaryResult(0, 0, 1, 0, tempSuiteDuration);
						}
					}

					// and afterwards we'll switch back to real test mode
					currentCallback.setDryRun(false);
				} else {
					// we're a fork and will return to dry run mode
					currentCallback.setDryRun(true);

					if (shouldExecuteFixtures()) {
						// This is us! We apparently finished an invocation, so count down the counter.
						numberOfSuiteInvocationsLeftOnThisFork--;
					}
				}
			}
			forkInExecution = null;
			currentCallback.setForkInExecution(null);
		}

		if (currentPhase == Phase.DRY_RUN && tempForkSpecifiedBySuite != null) {
			// Determining the last suite for all forks is simple: just count suites invoked for each fork in a map
			// during dry run. At the end of dry run, we know the "number" of the last suite per fork.
			Integer tempCounter = lastSuiteForFork.get(tempForkSpecifiedBySuite);
			if (tempCounter == null) {
				tempCounter = 0;
			}
			lastSuiteForFork.put(tempForkSpecifiedBySuite, tempCounter + 1);
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
				if (tempSetupSuite.getSingleRun() != null && singleRunSuitesExecuted.contains(tempSetupSuite)) {
					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onSetupSkipped(tempSetupSuite, SuiteSkipReason.SINGLE_RUN_EXECUTED);
						currentCallback.onCallbackProcessingEnd();
					}
				} else {
					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onSetupStart(tempSetupSuite);
						currentCallback.onCallbackProcessingEnd();
					}

					// This setup suite might have setup suites itself (issue #11)
					tempSetupSuitesExecuted.addAll(executeSetupSuites(tempSetupSuite, aSetupResultMap));
					if (tempSetupsAlreadyRun.contains(tempSetupSuite)) {
						// A circle has been created. This is a hard error -> abort before the stack inevitably
						// explodes.
						throw new IllegalStateException(
								"A setup suite circle has been detected (" + tempSetupSuite.getName() + " called from "
										+ aSuite.getName() + "). Please break the circle!");
					}

					long tempStart = System.nanoTime();
					Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(
							tempSetupSuite);
					SuiteResult tempSetupResult = (!shouldExecuteFixtures()) ? null
							: new SuiteResult(tempSuiteResults, null, null, System.nanoTime() - tempStart);
					aSetupResultMap.put(tempSetupSuite, tempSetupResult);

					if (!checkForAbortion()) {
						tempSetupsAlreadyRun.add(tempSetupSuite);
						tempSetupSuitesExecuted.add(tempSetupSuite);
					}

					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onSetupFinish(tempSetupSuite, tempSetupResult);
						currentCallback.onCallbackProcessingEnd();
					}
				}
			}

			if (checkForAbortion()) {
				break;
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
				if (tempTearDownSuite.getSingleRun() != null && singleRunSuitesExecuted.contains(tempTearDownSuite)) {
					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onTearDownSkipped(tempTearDownSuite, SuiteSkipReason.SINGLE_RUN_EXECUTED);
						currentCallback.onCallbackProcessingEnd();
					}
				} else {
					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onTearDownStart(tempTearDownSuite);
						currentCallback.onCallbackProcessingEnd();
					}

					long tempStart = System.nanoTime();
					Map<SuiteStatementWithResult, List<? extends Result>> tempSuiteResults = executeSuite(
							tempTearDownSuite);
					SuiteResult tempTearDownResult = (!shouldExecuteFixtures()) ? null
							: new SuiteResult(tempSuiteResults, null, null, System.nanoTime() - tempStart);
					aTearDownResultMap.put(tempTearDownSuite, tempTearDownResult);

					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onTearDownFinish(tempTearDownSuite, tempTearDownResult);
						currentCallback.onCallbackProcessingEnd();
					}
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

		if (aSuite.getSingleRun() != null) {
			singleRunSuitesExecuted.add(aSuite);
		}

		for (SuiteStatement tempStatement : aSuite.getStatements()) {
			checkForValidationError(tempStatement);
			if (tempStatement instanceof Suite) {
				Suite tempSuite = (Suite) tempStatement;
				boolean tempExecute = false;
				if (tempSuite.getDefinition().getSingleRun() != null
						&& singleRunSuitesExecuted.contains(tempSuite.getDefinition())) {
					if (currentCallback != null) {
						currentCallback.onCallbackProcessingStart();
						currentCallback.onSuiteSkipped(tempSuite, SuiteSkipReason.SINGLE_RUN_EXECUTED);
						currentCallback.onCallbackProcessingEnd();
					}
				} else {
					// Single-run suites that have already run have been filtered out now
					if (tempSuite.getVariants().size() > 0) {
						for (VariantDefinition tempVariant : tempSuite.getVariants()) {
							if (tempVariant == variantInExecution) {
								tempExecute = true;
								break;
							}
						}
						if (!tempExecute) {
							if (currentCallback != null) {
								currentCallback.onCallbackProcessingStart();
								currentCallback.onSuiteSkipped(tempSuite, SuiteSkipReason.VARIANT_MISMATCH);
								currentCallback.onCallbackProcessingEnd();
							}
						}
					} else {
						tempExecute = true;
					}
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
				try {
					defineConstant((ConstantDefinition) tempStatement, aSuite);
				} catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
					throw new RuntimeException("Failed to define constant", exc);
				}
			} else if (tempStatement instanceof VariableAssignment) {
				executeVariableAssignment((VariableAssignment) tempStatement, aSuite);
			} else if (tempStatement instanceof VisibleSingleLineComment) {
				if (currentCallback != null) {
					boolean tempIsTitle = (tempStatement instanceof VisibleSingleLineTitleComment);
					currentCallback.onCallbackProcessingStart();
					currentCallback.onVisibleComment(
							IntegrityDSLUtil.cleanSingleLineComment((VisibleSingleLineComment) tempStatement),
							tempIsTitle, (VisibleComment) tempStatement);
					currentCallback.onCallbackProcessingEnd();
				}
			} else if (tempStatement instanceof TimeSet) {
				executeTimeSet((TimeSet) tempStatement);
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
	protected void defineConstant(ConstantDefinition aDefinition, SuiteDefinition aSuite)
			throws ClassNotFoundException, InstantiationException, UnexecutableException {
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
	protected void defineConstant(final ConstantDefinition aDefinition, Object aValue, final SuiteDefinition aSuite)
			throws ClassNotFoundException, InstantiationException, UnexecutableException {
		Object tempValue;
		if (aValue == null) {
			tempValue = parameterResolver.resolveStatically(aDefinition, variantInExecution);
		} else {
			tempValue = aValue;
		}
		defineVariable(aDefinition.getName(), tempValue, aSuite);
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
	protected void defineVariable(final VariableOrConstantEntity anEntity, Object anInitialValue,
			final SuiteDefinition aSuite) {
		final Object tempInitialValue = (anInitialValue instanceof Variable)
				? variableManager.get(((Variable) anInitialValue).getName()) : anInitialValue;

		// We need to send variable updates to forks in the main phase here.
		boolean tempSendToForks = (!isFork()) && shouldExecuteFixtures();

		setVariableValue(anEntity, tempInitialValue, tempSendToForks);

		if (currentCallback != null) {
			Runnable tempRunnable = new Runnable() {

				@Override
				public void run() {
					currentCallback.onCallbackProcessingStart();
					if (anEntity instanceof VariableEntity) {
						currentCallback.onVariableDefinition((VariableEntity) anEntity, aSuite, tempInitialValue);
					} else if (anEntity instanceof ConstantEntity) {
						currentCallback.onConstantDefinition((ConstantEntity) anEntity, aSuite, tempInitialValue,
								(((ConstantDefinition) anEntity.eContainer()).getParameterized() != null));
					}
					currentCallback.onCallbackProcessingEnd();
				}
			};
			if (constantAndVariableDefinitionDelayedCallbackInvocations != null) {
				constantAndVariableDefinitionDelayedCallbackInvocations
						.add(Tuples.create(model.getFullyQualifiedVariableOrConstantName(anEntity), tempRunnable));
			} else {
				tempRunnable.run();
			}
		}
	}

	/**
	 * Undefines a variable (= clears its value, which is NOT exactly the same as setting it to null).
	 * 
	 * @param anEntity
	 *            the variable entity
	 */
	protected void undefineVariable(final VariableOrConstantEntity anEntity) {
		// We need to send variable unsets to forks in the main phase here; fixes issue #167
		unsetVariableValue(anEntity, (!isFork()) && shouldExecuteFixtures());
	}

	/**
	 * Sets the value of a variable.
	 * 
	 * @param anEntity
	 *            the variable entity to update
	 * @param aValue
	 *            the new value (which will be converted to its default type before assigning it!)
	 * @param aDoSendUpdateFlag
	 *            whether this update should be sent to connected master/slaves
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 */
	protected void setVariableValueConverted(VariableOrConstantEntity anEntity,
			ValueOrEnumValueOrOperationCollection aValue, boolean aDoSendUpdateFlag)
			throws InstantiationException, ClassNotFoundException, UnexecutableException {
		Object tempConvertedValue = valueConverter.convertValue(null, aValue, null);

		setVariableValue(anEntity, tempConvertedValue, aDoSendUpdateFlag);
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
					String tempName = model.getFullyQualifiedVariableOrConstantName(anEntity);
					if (aValue == null || (aValue instanceof Serializable)) {
						remotingServer.sendVariableUpdate(tempName, (Serializable) aValue);
					} else {
						System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempName + "' TO MASTER - VALUE '" + aValue
								+ "' OF TYPE '" + aValue.getClass().getName() + "' IS NOT SERIALIZABLE!");
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
		} else {
			throw new ThisShouldNeverHappenException(
					"Failed to find variable entity for name '" + aQualifiedVariableName + "'!");
		}
	}

	/**
	 * Unsets the value of a variable.
	 * 
	 * @param anEntity
	 *            the variable entity to unset
	 * @param aDoSendUpdateFlag
	 *            whether this update should be sent to connected master/slaves
	 */
	protected void unsetVariableValue(VariableOrConstantEntity anEntity, boolean aDoSendUpdateFlag) {
		variableManager.unset(anEntity);
		if (aDoSendUpdateFlag) {
			if (isFork()) {
				// A fork will have to send updates to its master, but not for constants, as the master has those anyway
				if (remotingServer != null && !(anEntity instanceof ConstantEntity)) {
					String tempName = model.getFullyQualifiedVariableOrConstantName(anEntity);
					remotingServer.sendVariableUnset(tempName);
				}
			} else {
				// The master will have to update all active forks.
				for (Entry<ForkDefinition, Fork> tempEntry : forkMap.entrySet()) {
					tempEntry.getValue().unsetVariableValue(anEntity);
				}
			}
		}
	}

	/**
	 * Unsets a variables' value.
	 * 
	 * @param aQualifiedVariableName
	 *            the name of the variable to unset
	 * @param aDoSendUpdateFlag
	 *            whether this update should be sent to connected master/slaves
	 */
	protected void unsetVariableValue(String aQualifiedVariableName, boolean aDoSendUpdateFlag) {
		VariableOrConstantEntity tempEntity = model.getVariableOrConstantByName(aQualifiedVariableName);
		if (tempEntity != null) {
			unsetVariableValue(tempEntity, aDoSendUpdateFlag);
		} else {
			throw new ThisShouldNeverHappenException(
					"Failed to find variable entity for name '" + aQualifiedVariableName + "'!");
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
	 * Executes variable assignments.
	 * 
	 * @param anAssignment
	 *            the assignment to execute
	 * @param aSuite
	 *            the suite that the assignment is in
	 */
	protected void executeVariableAssignment(VariableAssignment anAssignment, SuiteDefinition aSuite) {
		if (currentCallback != null) {
			currentCallback.onCallbackProcessingStart();
			currentCallback.onVariableAssignment(anAssignment, anAssignment.getTarget().getName(), aSuite,
					anAssignment.getValue());
			currentCallback.onCallbackProcessingEnd();
		}

		// Assignments are very much like variable definitions with default value - we perform them regardless of dry
		// run or test run mode.
		try {
			setVariableValueConverted(anAssignment.getTarget().getName(), anAssignment.getValue(), true);
		} catch (InstantiationException | ClassNotFoundException | UnexecutableException exc) {
			exc.printStackTrace();
		}
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
								tempNamedResult.getValue(), tempFixtureInstance,
								aTest.getDefinition().getFixtureMethod(), tempResultName);
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

		if (tempException == null && aTest.getCheckpoint() != null) {
			// In case of checkpoint tests, execution has to be aborted if they fail. This is done by "throwing" an
			// abort exception if there is any failed test result.
			for (TestComparisonResult tempResult : tempComparisonMap.values()) {
				if (tempResult instanceof TestComparisonFailureResult) {
					String tempTestDescription = "<unknown>";
					try {
						tempTestDescription = testFormatter.testToHumanReadableString(aTest, null);
					} catch (ClassNotFoundException | InstantiationException | UnexecutableException
							| MethodNotFoundException exc) {
						// ignored
					}

					tempException = new AbortExecutionException(
							"Checkpoint Test '" + tempTestDescription + "' has failed!");
					break;
				}
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
					Map<String, Object> tempParameters = parameterResolver.createParameterMap(aTest, tempRow,
							TableTestParameterResolveMethod.COMBINED, true,
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
									tempExpectedNamedResultValue, tempFixtureInstance,
									aTest.getDefinition().getFixtureMethod(), tempResultName);
							tempComparisonResult = TestComparisonResult.wrap(tempResult, tempResultName,
									tempSingleFixtureResult, tempExpectedNamedResultValue);
							tempComparisonMap.put(tempResultName, tempComparisonResult);

							tempColumn++;
						}
					} else {
						// Use the default result
						ComparisonResult tempResult = resultComparator.compareResult(tempFixtureResult,
								tempExpectedDefaultResultValue, tempFixtureInstance,
								aTest.getDefinition().getFixtureMethod(), null);
						tempComparisonResult = TestComparisonResult.wrap(tempResult,
								ParameterUtil.DEFAULT_PARAMETER_NAME, tempFixtureResult,
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
				tempSubResult = new TestExecutedSubResult(tempComparisonMap, tempFixtureInstance, tempFixtureMethodName,
						tempDuration);
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
				tempCount = (Integer) valueConverter.convertValue(Integer.class, aCall.getMultiplier().getCount(),
						conversionContextProvider.get()
								.withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling.EXCEPTION));
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
				String tempResultName = IntegrityDSLUtil
						.getExpectedResultNameStringFromTestResultName(tempNamedResult.getName());
				tempUpdatedVariables
						.add(new UpdatedVariable(tempNamedResult.getTarget().getName(), tempResultName, null));
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
						Object tempSingleFixtureResult = tempFixtureResultMap
								.get(tempUpdatedVariable.getParameterName());
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
	 * Executes a time setting operation.
	 * 
	 * @param aTimeSet
	 */
	protected void executeTimeSet(TimeSet aTimeSet) {
		Date tempStartTime = null;
		BigDecimal tempProgressionFactor = null;

		try {
			if (aTimeSet.getStartTime() != null) {
				tempStartTime = (Date) valueConverter.convertValue(Date.class, aTimeSet.getStartTime(), null);
			}

			if (aTimeSet.getProgressionMode() != null) {
				if (aTimeSet.getProgressionFactor() != null) {
					tempProgressionFactor = (BigDecimal) valueConverter.convertValue(BigDecimal.class,
							aTimeSet.getProgressionFactor(), null);
				} else {
					tempProgressionFactor = new BigDecimal(1);
				}
			}

			List<ForkDefinition> tempForksToRunOn = new ArrayList<>();
			if (aTimeSet.getMasterFork() != null) {
				tempForksToRunOn.add(null);
			}
			if (aTimeSet.getForks().size() > 0) {
				for (ForkDefinition tempFork : aTimeSet.getForks()) {
					tempForksToRunOn.add(tempFork);
				}
			}

			if (currentCallback != null) {
				currentCallback.onCallbackProcessingStart();
				currentCallback.onTimeSetStart(aTimeSet, (SuiteDefinition) aTimeSet.eContainer(), tempForksToRunOn);
				currentCallback.onCallbackProcessingEnd();
			}

			String tempErrorMessage = null;
			String tempExceptionTrace = null;

			if (shouldExecuteFixtures()) {
				// Technically this is not a fixture call, but we nevertheless only perform time setting in run mode
				String[] tempForksToRunOnArray = tempForksToRunOn.size() == 0 ? null
						: tempForksToRunOn.stream().map((aFork) -> {
							return aFork != null ? IntegrityDSLUtil.getQualifiedForkName(aFork) : null;
						}).collect(Collectors.toList()).toArray(new String[0]);

				if (isFork()) {
					// If on a fork, deliver the timesync request to the master, which will then distribute it to all
					// forks, which will perform it and respond. The master collects all responses and delivers them
					// back to us.
					synchronized (timeSyncResultSyncObject) {
						timeSyncResult = null;
						long tempStart = System.nanoTime();
						remotingServer.sendTestTimeSyncRequest(tempStartTime, tempProgressionFactor,
								tempForksToRunOnArray);

						while (timeSyncResult == null) {
							long tempTimeLeft = TimeUnit.SECONDS
									.toMillis(calculateMasterTimeSyncTimeout(tempForksToRunOn.size() + 1))
									- TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - tempStart);
							if (tempTimeLeft > 0) {
								try {
									timeSyncResultSyncObject.wait(tempTimeLeft);
								} catch (InterruptedException exc) {
									// ignored
								}
							} else {
								throw new RuntimeException(
										"Timed out while waiting to receive time sync confirmation from master!");
							}
						}

						tempErrorMessage = timeSyncResult.getErrorMessage();
						tempExceptionTrace = timeSyncResult.getStackTrace();
					}
				} else {
					// On the master, the timesync is just executed and then sent to the forks, if necessary
					ExceptionWrapper tempException = distributeTimeSyncRequest(tempStartTime, tempProgressionFactor,
							tempForksToRunOnArray);
					if (tempException != null) {
						tempErrorMessage = tempException.getMessage();
						tempExceptionTrace = tempException.getStackTrace();
					}
				}
			}

			if (currentCallback != null) {
				currentCallback.onCallbackProcessingStart();
				currentCallback.onTimeSetFinish(aTimeSet, (SuiteDefinition) aTimeSet.eContainer(), tempForksToRunOn,
						tempErrorMessage, tempExceptionTrace);
				currentCallback.onCallbackProcessingEnd();
			}
		} catch (Exception exc) {
			// Any exception happening in Integrity itself during time setting is considered an abort execution case
			handlePossibleAbortException(new AbortExecutionException("Failed to set test time", exc));
		}
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

	private FixtureInvocationResult evaluateTestSubResultsToFixtureInvocationResult(
			List<TestSubResult> someSubResults) {
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
				return (forkInExecution != null
						&& IntegrityDSLUtil.getQualifiedForkName(forkInExecution).equals(MY_FORK_NAME));
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
			// we are at a breakpoint, so we need to wait, but don't have to do anything else here
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
		public void onSetListRequest(final Endpoint anEndpoint) {
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_REMOTING,
					"Set List Response", new Runnable() {

						@Override
						public void run() {
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
									anEndpoint.sendMessage(
											new BreakpointUpdateMessage(BreakpointActions.CREATE, tempBreakpoint));
								}
							}
						}
					});
		}

		@Override
		public void onForkSetupRetrieval(final List<? extends TestResourceProvider> someResourceProviders,
				final SetList aSetList, final Map<String, Object> someVariableValues,
				final int aNumberOfSuiteInvocations) {
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_REMOTING,
					"Setup Processing", new Runnable() {

						@Override
						public void run() {
							numberOfSuiteInvocationsLeftOnThisFork = aNumberOfSuiteInvocations;
							synchronized (setListWaiter) {
								setList = aSetList;
								for (TestResourceProvider tempProvider : someResourceProviders) {
									try {
										model.readIntegrityScriptFiles(tempProvider);
									} catch (ModelLoadException exc) {
										throw new RuntimeException("Failed to parse scripts received from master!",
												exc);
									}
								}
								variableManager.importVariableState(someVariableValues);
								setListWaiter.notifyAll();
							}
						}
					});
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
		public void onVariableUnsetRetrieval(String aVariableName) {
			unsetVariableValue(aVariableName, false);
		}

		@Override
		public void onTimeSyncState(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
			// This is called when a master process wants to set the time of a fork. Just set it.
			ExceptionWrapper tempException = setTestTimeGuarded(aRealtimeOffset, aRealtimeDecouplingTime,
					aProgressionFactor);
			if (tempException != null) {
				remotingServer.sendTestTimeSyncResponse(tempException.getMessage(), tempException.getStackTrace());
			} else {
				remotingServer.sendTestTimeSyncResponse(null, null);
			}
		}

		@Override
		public void onTimeSyncResponse(TimeSyncResultMessage aResult) {
			// Called when a fork has triggered a time sync via relaying the request to the master, which then
			// distributed it to the forks. After all forks finished, it will return the result to the fork that
			// originally triggered the request, and that will end up here.
			synchronized (timeSyncResultSyncObject) {
				timeSyncResult = aResult;
				timeSyncResultSyncObject.notifyAll();
			}
		}

		@Override
		public void onShutdownRequest() {
			if (isFork()) {
				System.err.println("RECEIVED SHUTDOWN REQUEST FROM MASTER PROCESS - THIS FORK WILL NOW TERMINATE!");
			} else {
				System.err.println("RECEIVED SHUTDOWN REQUEST FROM CLIENT - THIS PROCESS WILL NOW TERMINATE!");
			}

			// Shutdown hook(s) will be called after this command automatically!
			System.exit(-1);
		}
	}

	/**
	 * This will be called when a master process either receives a time sync message from one of its forks and has to
	 * redistribute it to all the forks that this time sync is intended for, or when a master process encounters a time
	 * sync command by itself. In both cases it may have to execute it for itself. This method ONLY runs on the master!
	 * It calculates the actual internal state variables necessary for the test time proxies running in the individual
	 * fork processes and forwards those to the forks (and to the master itself), where these state variable values are
	 * then being used to call the {@link TestTimeAdapter}.<br>
	 * <br>
	 * The method is also responsible for collecting the responses about successful or failed timesyncs and for
	 * aggregating them into a result object. It blocks until this has finished (or a timeout has hit).
	 * 
	 * @param aStartTime
	 * @param aProgressionFactor
	 * @param someTargetedForks
	 * @return null if nothing went wrong, an exception wrapper containing all messages and all exceptions (textually
	 *         merged) in case of (non-critical) errors
	 */
	protected ExceptionWrapper distributeTimeSyncRequest(Date aStartTime, BigDecimal aProgressionFactor,
			String[] someTargetedForks) {
		boolean tempMasterHasToSync = false;
		List<Fork> tempTargetedForks = new ArrayList<Fork>();

		// These are the parameters used to actually calculate the fake test time in the individual systems under test
		long tempRealtimeDecouplingTime = System.currentTimeMillis();
		long tempRealtimeOffset = (aStartTime != null ? aStartTime.getTime() - tempRealtimeDecouplingTime : 0);
		double tempProgressionFactor = (aProgressionFactor != null ? aProgressionFactor.doubleValue()
				: (aStartTime == null ? 1.0d : 0.0d));
		TimeSyncState tempNewState = new TimeSyncState(tempRealtimeOffset, tempRealtimeDecouplingTime,
				tempProgressionFactor);

		if (someTargetedForks == null) {
			// This should go to all forks, including the master
			tempMasterHasToSync = true;
			tempTargetedForks.addAll(forkMap.values());
			forkTimeSyncStates.put(null, tempNewState);
			for (ForkDefinition tempFork : model.getAllForks()) {
				forkTimeSyncStates.put(tempFork, tempNewState);
			}
		} else {
			for (String tempForkName : someTargetedForks) {
				if (tempForkName == null) {
					// The null name is the master fork
					tempMasterHasToSync = true;
				} else {
					ForkDefinition tempForkDef = model.getForkByName(tempForkName);
					if (tempForkDef != null) {
						forkTimeSyncStates.put(tempForkDef, tempNewState);
						Fork tempFork = forkMap.get(tempForkDef);
						if (tempFork != null) {
							tempTargetedForks.add(tempFork);
						}
					}
				}
			}
		}

		// These are used to collect result messages (typically in case of errors)
		String tempMergedResultMessage = "";
		String tempMergedResultStackTrace = "";

		if (tempMasterHasToSync) {
			ExceptionWrapper tempExc = setTestTimeGuarded(tempRealtimeOffset, tempRealtimeDecouplingTime,
					tempProgressionFactor);
			if (tempExc != null) {
				if (tempTargetedForks.size() > 0) {
					tempMergedResultMessage = "Master process failed with: '" + tempExc.getMessage() + "'";
					tempMergedResultStackTrace = "Master process failed with:\n" + tempExc.getStackTrace();
				} else {
					tempMergedResultMessage = tempExc.getMessage();
					tempMergedResultStackTrace = tempExc.getStackTrace();
				}
			}
		}
		for (Fork tempFork : tempTargetedForks) {
			TimeSyncResultMessage tempResult = tempFork.injectTestTimeState(tempRealtimeOffset,
					tempRealtimeDecouplingTime, tempProgressionFactor);
			if (tempResult != null && tempResult.getErrorMessage() != null) {
				if (tempMergedResultMessage.length() != 0) {
					tempMergedResultMessage += ", ";
					tempMergedResultStackTrace += "\n\n";
				}
				tempMergedResultMessage += "Fork '" + IntegrityDSLUtil.getQualifiedForkName(tempFork.getDefinition())
						+ "' failed with: '" + tempResult.getErrorMessage() + "'";
				tempMergedResultStackTrace += "Fork '" + IntegrityDSLUtil.getQualifiedForkName(tempFork.getDefinition())
						+ "' failed with:\n" + tempResult.getStackTrace();
			}
		}

		if (tempMergedResultMessage.length() == 0) {
			// no errors
			return null;
		} else {
			return new ExceptionWrapper(tempMergedResultMessage, tempMergedResultStackTrace);
		}
	}

	/**
	 * Like {@link #distributeTimeSyncRequest(Date, BigDecimal, String[])}, but performs the work in an asynchronous
	 * thread, so it returns instantly. The result of the operation is sent to the provided fork that shall receive it.
	 * 
	 * @param aStartTime
	 * @param aProgressionFactor
	 * @param someTargetedForks
	 */
	protected void distributeTimeSyncRequestAsync(Date aStartTime, BigDecimal aProgressionFactor,
			String[] someTargetedForks, Fork aResultTarget) {
		Thread tempThread = new Thread("Integrity Test Runner - Timesync Distribution") {

			@Override
			public void run() {
				ExceptionWrapper tempExc = distributeTimeSyncRequest(aStartTime, aProgressionFactor, someTargetedForks);
				aResultTarget.deliverTimeSyncResult(tempExc);
			}

		};
		tempThread.start();
	}

	/**
	 * Performs a guarded call to the {@link TestTimeAdapter}. If the call runs into any exception, it will be caught
	 * and returned.
	 * 
	 * @param aStartTime
	 * @param aProgressionFactor
	 * @return null in case of success or an exception wrapper with errors in case of errors
	 */
	protected ExceptionWrapper setTestTimeGuarded(long aRealtimeOffset, long aRealtimeDecouplingTime,
			double aProgressionFactor) {
		try {
			testTimeAdapter.setInternalState(aRealtimeOffset, aRealtimeDecouplingTime, aProgressionFactor);
		} catch (Throwable exc) {
			return new ExceptionWrapper(exc);
		}

		return null;
	}

	/**
	 * Determines whether this JVM is a forked JVM from a master Integrity process.
	 * 
	 * @return
	 */
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
		final ForkDefinition tempForkDef = aSuiteCall.getFork();
		Class<? extends Forker> tempForkerClass = DefaultForker.class;

		// If we are using forkdef inheritance, we need to resolve the chain up to the forkdef without a base fork ->
		// this one could potentially define a forker
		ForkDefinition tempCurrentForkDef = tempForkDef;
		List<ForkDefinition> tempForkDefList = new ArrayList<ForkDefinition>();
		tempForkDefList.add(tempForkDef);
		while (tempCurrentForkDef.getBaseFork() != null) {
			tempCurrentForkDef = tempCurrentForkDef.getBaseFork();
			tempForkDefList.add(tempCurrentForkDef);
		}

		// Now we are at the last one, this one must define the forker class (or no forker class is defined)
		if (tempCurrentForkDef.getForkerClass() != null) {
			try {
				tempForkerClass = (Class<? extends Forker>) getClassForJvmType(
						tempCurrentForkDef.getForkerClass().getType());
			} catch (ClassCastException exc) {
				throw new ForkException(
						"Could not create fork '" + tempCurrentForkDef.getName() + "': forker class not usable.", exc);
			} catch (ClassNotFoundException exc) {
				throw new ForkException(
						"Could not create fork '" + tempCurrentForkDef.getName() + "': forker class not found.", exc);
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
							// For each parameter, check all forkdefs, starting with the latest ones in the chain (which
							// are the first ones in the list). The first match is used, so it's possible to override
							// parameters further down the forkdef inheritance line.
							forkDefLoop: for (ForkDefinition tempPossibleForkDef : tempForkDefList) {
								for (ForkParameter tempParameter : tempPossibleForkDef.getParameters()) {
									String tempParamName = IntegrityDSLUtil
											.getParamNameStringFromParameterName(tempParameter.getName());
									if (tempName.equals(tempParamName)) {
										Class<?> tempTargetType = tempConstructor.getParameterTypes()[i];
										tempParameters[i] = valueConverter.convertValue(tempTargetType,
												tempParameter.getValue(),
												conversionContextProvider.get().withUnresolvableVariableHandlingPolicy(
														UnresolvableVariableHandling.EXCEPTION));
										break forkDefLoop;
									}
								}
							}
						}
					}
				}
			}
		} catch (ConversionException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': failed to resolve forker parameters.", exc);
		} catch (UnresolvableVariableException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': failed to resolve forker parameters.", exc);
		} catch (UnexecutableException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': failed to resolve forker parameters.", exc);
		}

		Forker tempForker = null;
		try {
			tempForker = tempConstructor.newInstance(tempParameters);
		} catch (InstantiationException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': forker class not instantiable.", exc);
		} catch (IllegalAccessException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': forker class not instantiable.", exc);
		} catch (IllegalArgumentException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': forker class not instantiable.", exc);
		} catch (InvocationTargetException exc) {
			throw new ForkException(
					"Could not create fork '" + tempForkDef.getName() + "': forker class not instantiable.", exc);
		}

		final Fork tempFork = new Fork(aSuiteCall.getFork(), tempForker, commandLineArguments,
				remotingServer != null ? remotingServer.getPort() : IntegrityRemotingConstants.DEFAULT_PORT,
				currentCallback, setList, remotingServer, new ForkCallback() {

					@Override
					public void onSetVariableValue(String aQualifiedVariableName, Object aValue,
							boolean aDoSendUpdateFlag) {
						setVariableValue(aQualifiedVariableName, aValue, aDoSendUpdateFlag);
					}

					@Override
					public void onUnsetVariableValue(String aQualifiedVariableName, boolean aDoSendUpdateFlag) {
						unsetVariableValue(aQualifiedVariableName, aDoSendUpdateFlag);
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

					@Override
					public void onTimeSync(Date aStartDate, BigDecimal aProgressionFactor, String[] someTargetedForks,
							Fork aResultTarget) {
						distributeTimeSyncRequestAsync(aStartDate, aProgressionFactor, someTargetedForks,
								aResultTarget);
					}
				});
		injector.injectMembers(tempFork);

		performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
				"Fork Process Start (" + tempForkDef.getName() + ")",
				new TestRunnerPerformanceLogger.RunnableWithException<ForkException>() {

					@Override
					public void run() throws ForkException {
						tempFork.start(forkTimeSyncStates.get(aSuiteCall.getFork()));
					}
				});

		final long tempTimeout = getForkConnectionTimeout();
		final long tempStartTime = System.nanoTime();

		performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
				"Fork Connect (" + tempForkDef.getName() + ")", new Runnable() {

					@Override
					public void run() {
						while (System.nanoTime() - tempStartTime < (tempTimeout * 1000 * 1000000)) {
							try {
								if (!tempFork.isAlive()
										|| tempFork.connect(getForkSingleConnectTimeout(), javaClassLoader)) {
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
					}

				});

		if (tempFork.isAlive() && tempFork.isConnected()) {
			// Start off the fork with a full set of test scripts and the current setlist as well as all other init data
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
					"Fork Setup (" + tempForkDef.getName() + ")", new Runnable() {

						@Override
						public void run() {
							try {
								tempFork.getClient().setupFork(model.getInMemoryResourceProviders(), setList,
										variableManager.dumpVariableState(variantInExecution),
										lastSuiteForFork.get(tempForkDef));

								TimeSyncState tempTimeSyncState = forkTimeSyncStates.get(tempForkDef);
								if (tempTimeSyncState != null) {
									// This fork had a fake test time set before it was started. We need to provide that
									// time to the fork now.
									tempFork.getClient().sendTestTimeState(tempTimeSyncState.getRealtimeOffset(),
											tempTimeSyncState.getRealtimeDecouplingTime(),
											tempTimeSyncState.getProgressionFactor());
								}
							} catch (IOException exc1) {
								throw new RuntimeException("Failed to read resource providers into memory", exc1);
							}
						}
					});

			// and the fork will also need all current breakpoints
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
					"Fork Breakpoint Init (" + tempForkDef.getName() + ")", new Runnable() {

						@Override
						public void run() {
							for (Integer tempBreakpoint : breakpoints) {
								tempFork.getClient().createBreakpoint(tempBreakpoint);
							}

							// and the magic pause-on-next-instruction "breakpoint" too
							if (shallWaitBeforeNextStep) {
								tempFork.getClient().createBreakpoint(null);
							}
						}
					});

			// and now we'll wait until the fork is paused
			final long tempWaitTimeout = getForkWaitUntilReadyTimeout();
			final long tempWaitStartTime = System.nanoTime();
			boolean tempForkWaitSuccessful = performanceLogger.executeAndLog(
					TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
					"Fork Wait Until Ready (" + tempForkDef.getName() + ")",
					new TestRunnerPerformanceLogger.RunnableWithResult<Boolean>() {

						@Override
						public Boolean run() {
							while (tempFork.isAlive() && tempFork.isConnected()
									&& tempFork.getExecutionState() != ExecutionStates.PAUSED_SYNC) {
								try {
									Thread.sleep(getForkPauseWaitInterval());
								} catch (InterruptedException exc) {
									// nothing to do here
								}

								if (System.nanoTime() - tempWaitStartTime > TimeUnit.SECONDS.toNanos(tempWaitTimeout)) {
									System.err.println("TIMED OUT WHILE WAITING FOR FORK TO GET READY");
									return false;
								}
							}

							return true;
						}
					});

			// a last sanity check
			if (tempForkWaitSuccessful && tempFork.isAlive() && tempFork.isConnected()) {
				return tempFork;
			}
		}

		performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_FORK,
				"Fork Kill (" + tempForkDef.getName() + ")", new Runnable() {

					@Override
					public void run() {
						try {
							tempFork.kill();
						} catch (InterruptedException exc) {
							exc.printStackTrace();
						}
					}
				});
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
