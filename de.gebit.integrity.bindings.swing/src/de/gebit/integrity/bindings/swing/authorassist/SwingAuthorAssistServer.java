/**
 * 
 */
package de.gebit.integrity.bindings.swing.authorassist;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class SwingAuthorAssistServer {

	protected ServerSocket serverSocket;

	protected AbstractSwingComponentHandler swingComponentHandler;

	public static final int DEFAULT_PORT = 61432;

	public static final String DEFAULT_HOST = "127.0.0.1";

	/**
	 * 
	 */
	public SwingAuthorAssistServer(AbstractSwingComponentHandler aSwingComponentHandler) {
		swingComponentHandler = aSwingComponentHandler;
	}

	protected ServerSocket createServerSocket() throws UnknownHostException, IOException {
		return new ServerSocket(DEFAULT_PORT, 1, InetAddress.getByName(DEFAULT_HOST));
	}

	protected class SwingAuthorAssistServerThread extends Thread {

		private boolean killSwitch;

		/**
		 * 
		 */
		public SwingAuthorAssistServerThread() {
			super("Author Assist Server");
		}

		@Override
		public void run() {
			try {
				serverSocket = createServerSocket();

				while (!killSwitch) {
					Socket tempClientSocket = serverSocket.accept();

				}
			} catch (UnknownHostException exc) {
				exc.printStackTrace();
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
	}

}
