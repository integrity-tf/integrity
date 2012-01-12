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
import de.gebit.integrity.runner.TestRunner;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * A fork is the result of the test runner forking during test execution.
 * 
 * @author Rene Schneider
 * 
 */
public class Fork {

	private ForkDefinition definition;

	private Process process;

	private IntegrityRemotingClient client;

	private TestRunner owner;

	private TestRunnerCallback callback;

	private IntegrityRemotingServer server;

	private SetList setList;

	private HashMap<String, Object> variableUpdates = new HashMap<String, Object>();

	private Integer port;

	private boolean connectionConfirmed;

	private boolean segmentExecuted;

	private boolean ignoreVariableUpdates;

	private static Forker forker = new DefaultForker();

	private static int portNumberOffset;

	private static final int MAX_PORT_NUMBER = 65535;

	public static void setForker(Forker aForker) {
		forker = aForker;
	}

	public Fork(ForkDefinition aDefinition, String[] someCommandLineArguments, int aMainPortNumber,
			TestRunnerCallback aCallback, SetList aSetList, IntegrityRemotingServer aServer, TestRunner anOwner)
			throws ForkException {
		super();
		definition = aDefinition;
		callback = aCallback;
		setList = aSetList;
		server = aServer;
		owner = anOwner;

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
			if (callback != null) {
				callback.receiveFromFork(aCallbackClassName, aMethod, someData);
			}
		}

		@Override
		public void onSetListUpdate(SetListEntry[] someUpdatedEntries, Integer anEntryInExecution, Endpoint anEndpoint) {
			setList.integrateUpdates(someUpdatedEntries);
			server.updateSetList(anEntryInExecution, someUpdatedEntries);
		}

		@Override
		public void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint) {
			if (aState == ExecutionStates.PAUSED || aState == ExecutionStates.ENDED) {
				segmentExecuted = true;
				synchronized (Fork.this) {
					Fork.this.notifyAll();
				}
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
			synchronized (Fork.this) {
				Fork.this.notifyAll();
			}
		}

		@Override
		public void onConfirmRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint) {
			// not required in this context
		}

		@Override
		public void onConfirmCreateBreakpoint(int anEntryReference, Endpoint anEndpoint) {
			// not required in this context
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
			owner.setVariableValue(aVariableName, aValue, true);
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

		private String prefix;

		private BufferedReader source;

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
