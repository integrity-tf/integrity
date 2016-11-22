/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;
import de.gebit.integrity.remoting.client.IntegrityRemotingClientListener;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.console.intercept.ConsoleOutputInterceptor;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.operations.RandomNumberOperation;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A fork is the result of the test runner forking during test execution.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class Fork {

	/**
	 * The forker to use to create the actual {@link ForkedProcess}.
	 */
	private Forker forker;

	/**
	 * The command line arguments to pass on to the forked process.
	 */
	private String[] commandLineArguments;

	/**
	 * The definition of the fork.
	 */
	private ForkDefinition definition;

	/**
	 * The actual process running the fork.
	 */
	private ForkedProcess process;

	/**
	 * A flag remembering whether the fork has been started once.
	 */
	private boolean wasStarted;

	/**
	 * The remoting client used to communicate with the fork. Each fork gets its own client which connects to the
	 * remoting server in the forked process.
	 */
	private IntegrityRemotingClient client;

	/**
	 * The fork callback.
	 */
	private ForkCallback forkCallback;

	/**
	 * The test runner callback of the current test runner.
	 */
	private TestRunnerCallback testRunnerCallback;

	/**
	 * The remoting server of the current test runner.
	 */
	private IntegrityRemotingServer server;

	/**
	 * The setlist in the current test runner.
	 */
	private SetList setList;

	/**
	 * The last suite execution result summary received from the fork.
	 */
	private ForkResultSummary lastResultSummary;

	/**
	 * Buffer for variable updates to be transmitted to the fork.
	 */
	private HashMap<String, Object> variableUpdates = new HashMap<String, Object>();

	/**
	 * Whether the connection to the fork has been confirmed to be active.
	 */
	private boolean connectionConfirmed;

	/**
	 * Whether the death of the fork process has already been passed to the listener.
	 */
	private boolean forkDeathConfirmed;

	/**
	 * Used to synchronize execution of segments between parent and fork.
	 */
	private boolean segmentExecuted;

	/**
	 * Whether variable updates shall be ignored. Used to prevent circles in variable update propagation.
	 */
	private boolean ignoreVariableUpdates;

	/**
	 * Whether this fork has aborted normal test execution abnormally.
	 */
	private boolean hasAborted;

	/**
	 * Thread used to check the liveliness of the fork process until a connection was made.
	 */
	private ForkMonitor forkMonitor;

	/**
	 * The latest received execution state of this fork.
	 */
	private ExecutionStates executionState;

	/**
	 * The process watchdog, used to govern other processes started by the test runner.
	 */
	@Inject
	protected ProcessTerminator processWatchdog;

	/**
	 * The console interceptor. Used to output strings to the console, which prevents them from being intercepted by the
	 * interceptor!
	 */
	@Inject
	protected ConsoleOutputInterceptor consoleInterceptor;

	/**
	 * The value converter, which is used to resolve and convert values before sending them to forks.
	 */
	@Inject
	protected ValueConverter valueConverter;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

	/**
	 * The interval in which the fork monitor shall check the liveliness of the fork until a connection has been
	 * established, in milliseconds.
	 */
	private static final int FORK_CHECK_INTERVAL = 1000;

	/**
	 * The msecs available for the fork to shutdown in case of a kill request, before it is killed forcefully.
	 */
	private static final int FORK_SHUTDOWN_GRACE_TIME = 5000;

	/**
	 * The maximum time to wait for a fork to disconnect after its last statement has executed. If it did not disconnect
	 * until then, test execution continues. This is in milliseconds.
	 */
	private static final int FORK_DISCONNECT_WAIT_TIME = 60000;

	/**
	 * Creates a new fork. Calling this constructor triggers the creation of the actual forked process implicitly.
	 * 
	 * @param aDefinition
	 *            the fork definition
	 * @param aForker
	 *            the forker is a kind of factory for forked processes
	 * @param someCommandLineArguments
	 *            the complete and original command line arguments with which the current test runner was started
	 * @param aMainPortNumber
	 *            the port number used for the remoting server in the current test runner
	 * @param aCallback
	 *            the test runner callback
	 * @param aSetList
	 *            the setlist
	 * @param aServer
	 *            the remoting server of the parent test runner
	 * @param aForkCallback
	 *            the fork callback to use
	 */
	// SUPPRESS CHECKSTYLE ParameterNum
	public Fork(ForkDefinition aDefinition, Forker aForker, String[] someCommandLineArguments, int aMainPortNumber,
			TestRunnerCallback aCallback, SetList aSetList, IntegrityRemotingServer aServer,
			ForkCallback aForkCallback) {
		super();

		definition = aDefinition;
		testRunnerCallback = aCallback;
		setList = aSetList;
		server = aServer;
		forkCallback = aForkCallback;
		forker = aForker;
		commandLineArguments = someCommandLineArguments;
	}

	/**
	 * Actually start the fork. May only be called once!
	 * 
	 * @throws ForkException
	 *             in case of errors
	 */
	public void start() throws ForkException {
		if (wasStarted) {
			throw new IllegalStateException("The fork has already been started. A fork can only be started once!");
		}

		String tempFullyQualifiedForkName = IntegrityDSLUtil.getQualifiedForkName(definition);

		wasStarted = true;
		process = forker.fork(commandLineArguments, tempFullyQualifiedForkName, RandomNumberOperation.getSeed());

		if (!process.isAlive()) {
			throw new ForkException("Failed to create forked process - new process died immediately.");
		}

		processWatchdog.registerFork(this);

		forkMonitor = new ForkMonitor();
		forkMonitor.start();

		InputStream tempStdOut = process.getInputStream();
		if (tempStdOut != null) {
			new StreamCopier("\tFORK '" + definition.getName() + "': ",
					"Integrity - stdout copy: " + definition.getName(), tempStdOut, false).start();
		}
		InputStream tempStdErr = process.getErrorStream();
		if (tempStdErr != null) {
			new StreamCopier("\tFORK '" + definition.getName() + "': ",
					"Integrity - stderr copy: " + definition.getName(), tempStdErr, true).start();
		}
	}

	/**
	 * Destroy a fork.
	 */
	public void kill() throws InterruptedException {
		if (process != null && isAlive()) {
			boolean tempDead = false;
			if (isConnected()) {
				// attempt to send a shutdown signal first
				client.requestShutdown();
				long tempStart = System.nanoTime();
				while (System.nanoTime() - tempStart < (FORK_SHUTDOWN_GRACE_TIME * 1000000L)) {
					Thread.sleep(200);
					if (!process.isAlive()) {
						tempDead = true;
						break;
					}
				}
			}
			if (!tempDead) {
				// if still not dead now, just terminate it
				process.kill();
			}
			processWatchdog.unregisterFork(this);
			process = null;
		}
	}

	public ForkDefinition getDefinition() {
		return definition;
	}

	public ForkedProcess getProcess() {
		return process;
	}

	public IntegrityRemotingClient getClient() {
		return client;
	}

	public ExecutionStates getExecutionState() {
		return executionState;
	}

	/**
	 * Returns true if the fork was aborted due to an {@link de.gebit.integrity.exceptions.AbortExecutionException}.
	 * 
	 * @return true if test execution was aborted on the fork
	 */
	public boolean hasAborted() {
		return hasAborted;
	}

	/**
	 * Checks whether a fork is still alive.
	 * 
	 * @return true if the fork is running
	 */
	public boolean isAlive() {
		return (process != null && process.isAlive());
	}

	public boolean isConnected() {
		return client != null && client.isActive();
	}

	/**
	 * Connects to the successfully started fork process.
	 * 
	 * @param aTimeout
	 *            the timeout after which the method shall return in milliseconds
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 * @return true if successful, false if the timeout was hit
	 * @throws IOException
	 */
	public boolean connect(long aTimeout, ClassLoader aClassLoader) throws IOException {
		synchronized (this) {
			IntegrityRemotingClient tempClient = new IntegrityRemotingClient(getProcess().getHost(),
					getProcess().getPort(), new ForkRemotingClientListener(), aClassLoader);

			try {
				wait(aTimeout);
			} catch (InterruptedException exc) {
				// ignore
			}

			if (!connectionConfirmed) {
				tempClient.close();
				return false;
			} else {
				client = tempClient;
				client.requestExecutionStateUpdate();
				return true;
			}
		}
	}

	/**
	 * Triggers execution of the next segment on the fork. Will block until the fork has finished executing the segment.
	 */
	public ForkResultSummary executeNextSegment(boolean aWaitForForkDisconnect) {
		if (aWaitForForkDisconnect) {
			System.out.println("WAITING");
		}

		if (client != null) {
			transmitVariableUpdates();

			synchronized (this) {
				segmentExecuted = false;
				lastResultSummary = null;
				client.controlExecution(ExecutionCommands.RUN);

				while (isAlive() && !segmentExecuted) {
					try {
						wait();
					} catch (InterruptedException exc) {
						// ignore
					}
				}
				if (lastResultSummary == null) {
					System.err.println("FAILED TO RECEIVE SUITE RESULT SUMMARY FROM FORK '" + definition.getName()
							+ "'! TEST RESULT TOTAL NUMBERS MAY BE INACCURATE!");
				}

				if (aWaitForForkDisconnect) {
					long tempStart = System.nanoTime();
					while (!forkDeathConfirmed && TimeUnit.NANOSECONDS
							.toMillis(System.nanoTime() - tempStart) < FORK_DISCONNECT_WAIT_TIME) {
						try {
							wait(1000);
						} catch (InterruptedException exc) {
							// ignored
						}
					}
					if (!forkDeathConfirmed) {
						System.err.println("FAILED TO CONFIRM DEATH OF FORK '" + definition.getName()
								+ "'! EXECUTION WILL CONTINUE, BUT THERE MAY BE PROBLEMS DOWN "
								+ "THE ROAD...OR ZOMBIE PROCESSES!");
					}
				}
				return lastResultSummary;
			}
		}
		return null;
	}

	/**
	 * Transmits the buffered variable updates.
	 */
	protected void transmitVariableUpdates() {
		if (client != null) {
			for (Entry<String, Object> tempEntry : variableUpdates.entrySet()) {
				if (tempEntry.getValue() == null || (tempEntry.getValue() instanceof Serializable)) {
					client.updateVariableValue(tempEntry.getKey(), (Serializable) tempEntry.getValue());
				} else {
					System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempEntry.getKey() + "' TO FORK - VALUE '"
							+ tempEntry.getValue() + "' OF TYPE '" + tempEntry.getValue().getClass().getName()
							+ "' NOT SERIALIZABLE!");
				}
			}
			variableUpdates.clear();
		}
	}

	/**
	 * Updates a variable value. This does not immediately update the variable, but buffers the update until it's being
	 * transmitted to the fork.
	 * 
	 * @param aVariable
	 *            the variable entity to update
	 * @param aValue
	 *            the new value
	 */
	public void updateVariableValue(VariableOrConstantEntity aVariable, Object aValue) {
		if (!ignoreVariableUpdates) {
			String tempKey = IntegrityDSLUtil.getQualifiedVariableEntityName(aVariable, true);
			try {
				// When we're sending stuff to the fork, we want to convert all Integrity-internal value types to Java
				// types that we can transfer, but not arbitrary bean-type objects - those are already considered
				// "Java types". Of course this opens up the possibility of a type being non-serializable, but that case
				// is already handled gracefully enough a step or two above in the call stack - an error is logged and
				// the variable in question is skipped for syncing.
				// See also issue #100: https://github.com/integrity-tf/integrity/issues/100
				variableUpdates.put(tempKey, valueConverter.convertValue(null, aValue,
						conversionContextProvider.get().skipBeanToMapDefaultConversion()));
			} catch (UnresolvableVariableException exc) {
				System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempKey + "' TO FORK - EXCEPTION OCCURRED");
				exc.printStackTrace();
			} catch (UnexecutableException exc) {
				System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempKey + "' TO FORK - EXCEPTION OCCURRED");
				exc.printStackTrace();
			}
		}
	}

	private class ForkRemotingClientListener implements IntegrityRemotingClientListener {

		@Override
		public void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			synchronized (Fork.this) {
				Fork.this.notify();
			}
		}

		@Override
		public void onTestRunnerCallbackMessageRetrieval(String aCallbackClassName, TestRunnerCallbackMethods aMethod,
				Serializable[] someData) {
			if (testRunnerCallback != null) {
				testRunnerCallback.receiveFromFork(aCallbackClassName, aMethod, someData);
			}
		}

		@Override
		public void onSetListUpdate(SetListEntry[] someUpdatedEntries, Integer anEntryInExecution,
				Endpoint anEndpoint) {
			setList.integrateUpdates(someUpdatedEntries);
			if (server != null) {
				server.updateSetList(anEntryInExecution, someUpdatedEntries);
			}

			for (SetListEntry tempEntry : someUpdatedEntries) {
				if (SetListEntryTypes.RESULT.equals(tempEntry.getType())) {
					// It is a result...
					Integer tempSuccessCount = tempEntry.getAttribute(Integer.class,
							SetListEntryAttributeKeys.SUCCESS_COUNT);
					Integer tempFailureCount = tempEntry.getAttribute(Integer.class,
							SetListEntryAttributeKeys.FAILURE_COUNT);
					Integer tempTestExceptionCount = tempEntry.getAttribute(Integer.class,
							SetListEntryAttributeKeys.TEST_EXCEPTION_COUNT);
					Integer tempCallExceptionCount = tempEntry.getAttribute(Integer.class,
							SetListEntryAttributeKeys.CALL_EXCEPTION_COUNT);
					if (tempSuccessCount != null && tempFailureCount != null && tempTestExceptionCount != null
							&& tempCallExceptionCount != null) {
						// ...must be a suite result!
						lastResultSummary = new ForkResultSummary(tempSuccessCount, tempFailureCount,
								tempTestExceptionCount, tempCallExceptionCount);
					}
				}
			}
		}

		@Override
		public void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint) {
			executionState = aState;
			if (aState == ExecutionStates.PAUSED_SYNC || aState == ExecutionStates.ENDED) {
				segmentExecuted = true;
				synchronized (Fork.this) {
					Fork.this.notifyAll();
				}
			} else if (aState == ExecutionStates.PAUSED || aState == ExecutionStates.RUNNING) {
				// now waiting or continuing at a user-defined breakpoint
				if (server != null) {
					server.updateExecutionState(aState);
				}
			}
		}

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			connectionConfirmed = true;
			forkMonitor.kill();
			synchronized (Fork.this) {
				Fork.this.notifyAll();
			}
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			if (!anEndpoint.isDisconnectRequested()) {
				System.err.println("THE FORK '" + definition.getName()
						+ "' HAS TERMINATED BEFORE THE CONTROL CONNECTION COULD BE SHUT DOWN PROPERLY! "
						+ "THIS MAY RESULT IN FURTHER PROBLEMS DOWN THE ROAD!");
			}

			client = null;
			segmentExecuted = true;
			synchronized (Fork.this) {
				forkDeathConfirmed = true;
				forkCallback.onForkExit(Fork.this);
				Fork.this.notifyAll();
			}
		}

		@Override
		public void onConfirmRemoveBreakpoint(Integer anEntryReference, Endpoint anEndpoint) {
			// forward this confirmation to the clients of the master
			if (server != null) {
				server.confirmBreakpointRemoval(anEntryReference);
			}
		}

		@Override
		public void onConfirmCreateBreakpoint(Integer anEntryReference, Endpoint anEndpoint) {
			// not required in this context, since the master will already confirm this
		}

		@Override
		public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint) {
			// not required in this context
		}

		@Override
		public void onVariableUpdateRetrieval(String aVariableName, Serializable aValue) {
			// Updating variables in the testrunner will trigger update messages to all forks, which includes this one.
			// However, this fork already has the new value, thus we'll simply ignore this update.
			ignoreVariableUpdates = true;
			forkCallback.onSetVariableValue(aVariableName, aValue, true);
			ignoreVariableUpdates = false;
		}

		@Override
		public void onAbortExecution(String anAbortExecutionMessage, String anAbortExecutionStackTrace) {
			hasAborted = true;
			if (testRunnerCallback != null) {
				testRunnerCallback.onAbortExecution(anAbortExecutionMessage, anAbortExecutionStackTrace);
			}
		}
	}

	private class StreamCopier extends Thread {

		/**
		 * The prefix to add in front of each line.
		 */
		private String prefix;

		/**
		 * The source.
		 */
		private BufferedReader source;

		/**
		 * Whether this stream copier shall forward the lines to stderr.
		 */
		private boolean stdErr;

		StreamCopier(String aPrefix, String aThreadName, InputStream aSource, boolean anStdErrFlag) {
			super(aThreadName);
			prefix = aPrefix;
			source = new BufferedReader(new InputStreamReader(aSource));
			stdErr = anStdErrFlag;
		}

		private void println(String aLine) {
			if (stdErr) {
				consoleInterceptor.printlnStdErr(aLine);
			} else {
				consoleInterceptor.printlnStdOut(aLine);
			}
		}

		@Override
		public void run() {
			println(prefix + "Process started!");

			do {
				String tempLine;
				try {
					tempLine = source.readLine();
				} catch (IOException exc) {
					exc.printStackTrace();
					break;
				}
				if (tempLine == null) {
					break;
				} else {
					println(prefix + tempLine);
				}
			} while (true);

			println(prefix + "Process terminated!");
		}
	}

	private class ForkMonitor extends Thread {

		ForkMonitor() {
			super("Integrity - Fork Monitor Thread");
		}

		/**
		 * Set if the fork monitor thread should kill itself.
		 */
		boolean killSwitch;

		public void kill() {
			killSwitch = true;
			if (Thread.currentThread() != this) {
				try {
					join(FORK_CHECK_INTERVAL * 2);
				} catch (InterruptedException exc) {
					// ignored
				}
			}
		}

		@Override
		public void run() {
			while (!killSwitch) {
				try {
					Thread.sleep(FORK_CHECK_INTERVAL);
				} catch (InterruptedException exc) {
					// ignore
				}
				if (process == null) {
					kill();
				} else if (!process.isAlive()) {
					synchronized (Fork.this) {
						if (!forkDeathConfirmed) {
							forkDeathConfirmed = true;
							processWatchdog.unregisterFork(Fork.this);
							client = null;
							process = null;
							forkCallback.onForkExit(Fork.this);
							Fork.this.notifyAll();
							kill();
						}
					}
				}
			}
		}

	}

}
