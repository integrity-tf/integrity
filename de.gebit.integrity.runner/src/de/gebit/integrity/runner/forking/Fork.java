/**
 * 
 */
package de.gebit.integrity.runner.forking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.VariableEntity;
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
import de.gebit.integrity.runner.forking.processes.ProcessWatchdog;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * A fork is the result of the test runner forking during test execution.
 * 
 * @author Rene Schneider
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
	protected ProcessWatchdog processWatchdog;

	/**
	 * The interval in which the fork monitor shall check the liveliness of the fork until a connection has been
	 * established.
	 */
	private static final int FORK_CHECK_INTERVAL = 1000;

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
			TestRunnerCallback aCallback, SetList aSetList, IntegrityRemotingServer aServer, ForkCallback aForkCallback) {
		super();

		definition = aDefinition;
		testRunnerCallback = aCallback;
		setList = aSetList;
		server = aServer;
		forkCallback = aForkCallback;
		forker = aForker;
		commandLineArguments = someCommandLineArguments;
	}

	public void start() throws ForkException {
		if (wasStarted) {
			throw new IllegalStateException("The fork has already been started. A fork can only be started once!");
		}

		wasStarted = true;
		process = forker.fork(commandLineArguments, definition.getName());

		if (!process.isAlive()) {
			throw new ForkException("Failed to create forked process - new process died immediately.");
		}

		processWatchdog.registerFork(process);

		forkMonitor = new ForkMonitor();
		forkMonitor.start();

		InputStream tempStdOut = process.getInputStream();
		if (tempStdOut != null) {
			new StreamCopier("\tFORK '" + definition.getName() + "': ", "stdout copy: " + definition.getName(),
					tempStdOut, System.out).start();
		}
		InputStream tempStdErr = process.getErrorStream();
		if (tempStdErr != null) {
			new StreamCopier("\tFORK '" + definition.getName() + "': ", "stderr copy: " + definition.getName(),
					tempStdErr, System.err).start();
		}
	}

	/**
	 * Destroy a fork.
	 */
	public void kill() throws InterruptedException {
		if (process != null && isAlive()) {
			process.kill();
			processWatchdog.unregisterFork(process);
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
	 * @return true if successful, false if the timeout was hit
	 * @throws IOException
	 */
	public boolean connect(long aTimeout) throws IOException {
		synchronized (this) {
			IntegrityRemotingClient tempClient = new IntegrityRemotingClient(getProcess().getHost(), getProcess()
					.getPort(), new ForkRemotingClientListener());

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
	public ForkResultSummary executeNextSegment() {
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
					System.err.println("FAILED TO RECEIVE SUITE RESULT SUMMARY FROM FORK! "
							+ "TEST RESULT TOTAL NUMBERS MAY BE INACCURATE!");
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
	public void updateVariableValue(VariableEntity aVariable, Object aValue) {
		if (!ignoreVariableUpdates) {
			variableUpdates.put(IntegrityDSLUtil.getQualifiedVariableEntityName(aVariable, true), aValue);
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
		public void onSetListUpdate(SetListEntry[] someUpdatedEntries, Integer anEntryInExecution, Endpoint anEndpoint) {
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
					Integer tempExceptionCount = tempEntry.getAttribute(Integer.class,
							SetListEntryAttributeKeys.EXCEPTION_COUNT);
					if (tempSuccessCount != null && tempFailureCount != null && tempExceptionCount != null) {
						// ...must be a suite result!
						lastResultSummary = new ForkResultSummary(tempSuccessCount, tempFailureCount,
								tempExceptionCount);
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
				server.updateExecutionState(aState);
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
			client = null;
			segmentExecuted = true;
			synchronized (Fork.this) {
				forkDeathConfirmed = true;
				forkCallback.onForkExit(Fork.this);
				Fork.this.notifyAll();
			}
		}

		@Override
		public void onConfirmRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint) {
			// forward this confirmation to the clients of the master
			if (server != null) {
				server.confirmBreakpointRemoval(anEntryReference);
			}
		}

		@Override
		public void onConfirmCreateBreakpoint(int anEntryReference, Endpoint anEndpoint) {
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
	}

	private static class StreamCopier extends Thread {

		/**
		 * The prefix to add in front of each line.
		 */
		private String prefix;

		/**
		 * The source.
		 */
		private BufferedReader source;

		/**
		 * The target.
		 */
		private PrintStream target;

		public StreamCopier(String aPrefix, String aThreadName, InputStream aSource, PrintStream aTarget) {
			super(aThreadName);
			prefix = aPrefix;
			target = aTarget;
			source = new BufferedReader(new InputStreamReader(aSource));
		}

		@Override
		public void run() {
			target.println(prefix + "Process started!");
			target.flush();

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
					target.println(prefix + tempLine);
					target.flush();
				}
			} while (true);

			target.println(prefix + "Process terminated!");
			target.flush();
		}
	}

	private class ForkMonitor extends Thread {

		/**
		 * Set if the fork monitor thread should kill itself.
		 */
		boolean killSwitch;

		public void kill() {
			killSwitch = true;
		}

		public void run() {
			while (!killSwitch) {
				try {
					Thread.sleep(FORK_CHECK_INTERVAL);
				} catch (InterruptedException exc) {
					// ignore
				}
				if (!process.isAlive()) {
					synchronized (Fork.this) {
						if (!forkDeathConfirmed) {
							forkDeathConfirmed = true;
							processWatchdog.unregisterFork(process);
							client = null;
							process = null;
							forkCallback.onForkExit(Fork.this);
							Fork.this.notifyAll();
							return;
						}
					}
				}
			}
		}

	}

}
