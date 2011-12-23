/**
 * 
 */
package de.gebit.integrity.runner.forking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;

import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;

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

	private static Forker forker = new DefaultForker();

	private static int portNumberOffset;

	private static final int MAX_PORT_NUMBER = 65535;

	public static void setForker(Forker aForker) {
		forker = aForker;
	}

	public Fork(ForkDefinition aDefinition, String[] someCommandLineArguments, int aMainPortNumber)
			throws ForkException {
		super();
		definition = aDefinition;

		process = forker.fork(someCommandLineArguments, getNextPort(aMainPortNumber));

		boolean tempIsAlive = false;
		try {
			process.exitValue();
		} catch (IllegalStateException exc) {
			tempIsAlive = true;
		}

		if (!tempIsAlive) {
			throw new ForkException("Failed to create forked process - new process died immediately.");
		}

		new StreamCopier("FORK '" + aDefinition.getName() + "': ", "stdout copy: " + aDefinition.getName(),
				process.getInputStream(), System.out).start();
		new StreamCopier("FORK '" + aDefinition.getName() + "': ", "stderr copy: " + aDefinition.getName(),
				process.getErrorStream(), System.err).start();
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

		private PrintWriter target;

		public StreamCopier(String aPrefix, String aThreadName, InputStream aSource, OutputStream aTarget) {
			super(aThreadName);
			prefix = aPrefix;
			source = new BufferedReader(new InputStreamReader(aSource));
			target = new PrintWriter(new OutputStreamWriter(aTarget));
		}

		@Override
		public void run() {
			do {
				String tempLine;
				try {
					tempLine = source.readLine();
				} catch (IOException exc) {
					exc.printStackTrace();
					return;
				}
				if (tempLine == null) {
					return;
				} else {
					target.println(prefix + tempLine);
				}
			} while (true);
		}
	}

}
