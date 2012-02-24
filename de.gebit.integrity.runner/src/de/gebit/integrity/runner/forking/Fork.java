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
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;
import de.gebit.integrity.remoting.client.IntegrityRemotingClientListener;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.server.IntegrityRemotingServer;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * A fork is the result of the test runner forking during test execution.
 * 
 * @author Rene Schneider
 * 
 */
public class Fork {

	/**
	 * The definition of the fork.
	 */
	private ForkDefinition definition;

	/**
	 * The actual process running the fork.
	 */
	private Process process;

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
	 * Buffer for variable updates to be transmitted to the fork.
	 */
	private HashMap<String, Object> variableUpdates = new HashMap<String, Object>();

	/**
	 * The port at which the fork listens for remoting connections.
	 */
	private Integer port;

	/**
	 * Whether the connection to the fork has been confirmed to be active.
	 */
	private boolean connectionConfirmed;

	/**
	 * Used to synchronize execution of segments between parent and fork.
	 */
	private boolean segmentExecuted;

	/**
	 * Whether variable updates shall be ignored. Used to prevent circles in variable update propagation.
	 */
	private boolean ignoreVariableUpdates;

	/**
	 * The forker to use when creating new forks.
	 */
	private static Forker forker = new DefaultForker();

	/**
	 * The offset of the port numbers to try from the remoting port of the current test runner.
	 */
	private static int portNumberOffset;

	/**
	 * The maximum possible port number.
	 */
	private static final int MAX_PORT_NUMBER = 65535;

	public static void setForker(Forker aForker) {
		forker = aForker;
	}

	/**
	 * Creates a new fork. Calling this constructor triggers the creation of the actual forked process implicitly.
	 * 
	 * @param aDefinition
	 *            the fork definition
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
	 * @throws ForkException
	 *             if something goes wrong
	 */
	public Fork(ForkDefinition aDefinition, String[] someCommandLineArguments, int aMainPortNumber,
			TestRunnerCallback aCallback, SetList aSetList, IntegrityRemotingServer aServer, ForkCallback aForkCallback)
			throws ForkException {
		super();
		definition = aDefinition;
		testRunnerCallback = aCallback;
		setList = aSetList;
		server = aServer;
		forkCallback = aForkCallback;

		port = getNextPort(aMainPortNumber);
		process = forker.fork(someCommandLineArguments, port, aDefinition.getName());

		boolean tempIsAlive = false;
		try {
			process.exitValue();
		} catch (IllegalThreadStateException exc) {
			tempIsAlive = true;
		}

		if (!tempIsAlive) {
			throw new ForkException("Failed to create forked process - new process died immediately.");
		}

		new StreamCopier("\tFORK '" + aDefinition.getName() + "': ", "stdout copy: " + aDefinition.getName(),
				process.getInputStream(), System.out).start();
		new StreamCopier("\tFORK '" + aDefinition.getName() + "': ", "stderr copy: " + aDefinition.getName(),
				process.getErrorStream(), System.err).start();
	}

	/**
	 * Destroy a fork.
	 */
	public void kill() {
		if (isAlive()) {
			process.destroy();
			process = null;
		}
	}

	public ForkDefinition getDefinition() {
		return definition;
	}

	public Process getProcess() {
		return process;
	}

	public IntegrityRemotingClient getClient() {
		return client;
	}

	public Integer getPort() {
		return port;
	}

	/**
	 * Checks whether a fork is still alive.
	 * 
	 * @return true if the fork is running
	 */
	public boolean isAlive() {
		if (process != null) {
			try {
				process.exitValue();
			} catch (IllegalThreadStateException exc) {
				return true;
			}
		}

		return false;
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
			IntegrityRemotingClient tempClient = null;
			try {
				tempClient = new IntegrityRemotingClient("localhost", getPort(), new ForkRemotingClientListener());
			} catch (UnknownHostException exc) {
				// cannot actually happen -> we're only connecting to localhost
			}

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
				return true;
			}
		}
	}

	/**
	 * Triggers execution of the next segment on the fork. Will block until the fork has finished executing the segment.
	 */
	public void executeNextSegment() {
		if (client != null) {
			transmitVariableUpdates();

			synchronized (this) {
				segmentExecuted = false;
				client.controlExecution(ExecutionCommands.RUN);

				while (isAlive() && !segmentExecuted) {
					try {
						wait();
					} catch (InterruptedException exc) {
						// ignore
					}
				}
			}
		}
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
					System.err.println("SKIPPED SYNCING OF VARIABLE '" + tempEntry.getKey()
							+ "' TO FORK - VALUE NOT SERIALIZABLE!");
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
		}

		@Override
		public void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint) {
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
			synchronized (Fork.this) {
				Fork.this.notifyAll();
			}
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			client = null;
			segmentExecuted = true;
			forkCallback.onForkExit(Fork.this);
			synchronized (Fork.this) {
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

	private static int getNextPort(int aMainPortNumber) {
		do {
			portNumberOffset++;
			if (aMainPortNumber + portNumberOffset > MAX_PORT_NUMBER) {
				throw new UnsupportedOperationException(
						"Ran out of fork child ports: reached end of valid TCP port numbers!");
			}
		} while (!isPortAvailable(aMainPortNumber + portNumberOffset));
		return aMainPortNumber + portNumberOffset;
	}

	private static boolean isPortAvailable(int aPort) {
		ServerSocket tempServerSocket = null;
		DatagramSocket tempDatagramSocket = null;
		try {
			tempServerSocket = new ServerSocket(aPort);
			tempServerSocket.setReuseAddress(true);
			tempDatagramSocket = new DatagramSocket(aPort);
			tempDatagramSocket.setReuseAddress(true);
			return true;
		} catch (IOException exc) {
			// nothing to do
		} finally {
			if (tempDatagramSocket != null) {
				tempDatagramSocket.close();
			}

			if (tempServerSocket != null) {
				try {
					tempServerSocket.close();
				} catch (IOException exc) {
					// ignore
				}
			}
		}

		return false;
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

}