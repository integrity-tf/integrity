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

import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;
import de.gebit.integrity.remoting.client.IntegrityRemotingClientListener;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;

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

	private TestRunnerCallback callback;

	private Integer port;

	private boolean connectionConfirmed;

	private boolean segmentExecuted;

	private static Forker forker = new DefaultForker();

	private static int portNumberOffset;

	private static final int MAX_PORT_NUMBER = 65535;

	public static void setForker(Forker aForker) {
		forker = aForker;
	}

	public Fork(ForkDefinition aDefinition, String[] someCommandLineArguments, int aMainPortNumber,
			TestRunnerCallback aCallback) throws ForkException {
		super();
		definition = aDefinition;
		callback = aCallback;

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

		}

		@Override
		public void onConfirmCreateBreakpoint(int anEntryReference, Endpoint anEndpoint) {

		}

		@Override
		public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint) {

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
