/**
 * 
 */
package de.gebit.integrity.bindings.swing.authorassist;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class SwingAuthorAssistServer {

	protected SwingAuthorAssistServerThread serverThread;

	protected AbstractSwingComponentHandler swingComponentHandler;

	protected JFrame ownerFrame;

	public static final int DEFAULT_PORT = 61432;

	public static final String DEFAULT_HOST = "127.0.0.1";

	/**
	 * 
	 */
	public SwingAuthorAssistServer(AbstractSwingComponentHandler aSwingComponentHandler, JFrame anOwnerFrame) {
		swingComponentHandler = aSwingComponentHandler;
		ownerFrame = anOwnerFrame;
	}

	protected ServerSocket createServerSocket() throws UnknownHostException, IOException {
		return new ServerSocket(DEFAULT_PORT, 1, InetAddress.getByName(DEFAULT_HOST));
	}

	public void startUp() {
		if (serverThread == null) {
			serverThread = new SwingAuthorAssistServerThread();
			serverThread.start();
		}
	}

	public void shutDown() {
		if (serverThread != null) {
			serverThread.kill();
			serverThread = null;
		}
	}

	protected class SwingAuthorAssistServerThread extends Thread {

		protected ServerSocket serverSocket;

		/**
		 * 
		 */
		public SwingAuthorAssistServerThread() {
			super("Author Assist Server");
		}

		public void kill() {
			try {
				serverSocket.close();
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			try {
				serverSocket = createServerSocket();

				while (!serverSocket.isClosed()) {
					Socket tempClientSocket;
					try {
						tempClientSocket = serverSocket.accept();
					} catch (SocketException exc) {
						if (!serverSocket.isClosed()) {
							exc.printStackTrace();
						}
						break;
					}

					try {
						BufferedReader tempReader = new BufferedReader(new InputStreamReader(
								tempClientSocket.getInputStream()));
						String tempFilterClassName = tempReader.readLine();

						if (tempFilterClassName != null) {
							try {
								Class<?> tempFilterClass = getClass().getClassLoader().loadClass(tempFilterClassName);

								List<Component> tempComponents = swingComponentHandler.findComponents(null,
										(Class<? extends Component>) tempFilterClass, ownerFrame);

								PrintWriter tempWriter = new PrintWriter(tempClientSocket.getOutputStream());
								for (Component tempComponent : tempComponents) {
									String tempLongPath = swingComponentHandler
											.createUniquifiedComponentPath(tempComponent);
									String tempShortPath = swingComponentHandler
											.createShortestComponentPath(tempComponent);

									if (tempLongPath != null) {
										if (tempShortPath != null) {
											tempWriter.println(generateComponentLine(tempShortPath, tempComponent,
													true, tempLongPath));
										}
										if (tempLongPath != null
												&& (tempShortPath == null || !tempLongPath.equals(tempShortPath))) {
											tempWriter.println(generateComponentLine(tempLongPath, tempComponent,
													false, tempShortPath));
										}
									}
								}

								tempWriter.flush();
							} catch (ClassNotFoundException exc) {
								exc.printStackTrace();
							}
						}
					} catch (Throwable exc) {
						exc.printStackTrace();
					} finally {
						tempClientSocket.close();
					}
				}
			} catch (UnknownHostException exc) {
				exc.printStackTrace();
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
	}

	public static final String COMPONENT_LINE_NEWLINE = "<nl>";

	protected String generateComponentLine(String aPath, Component aComponent, boolean anIsShortPath, String anOtherPath) {
		StringBuilder tempSuffix = new StringBuilder("Component: " + aComponent.getClass().getName());
		if (anIsShortPath) {
			tempSuffix.append(COMPONENT_LINE_NEWLINE + "Path: short path"
					+ (anOtherPath != null && !anOtherPath.equals(aPath) ? " (long path: '" + anOtherPath + "')" : ""));
		} else {
			tempSuffix
					.append(COMPONENT_LINE_NEWLINE
							+ "Path: long path"
							+ (anOtherPath != null && !anOtherPath.equals(aPath) ? " (short path: '" + anOtherPath
									+ "')" : ""));
		}

		if (aComponent instanceof JButton) {
			tempSuffix.append(COMPONENT_LINE_NEWLINE + "Text: '" + ((JButton) aComponent).getText() + "'");
		}
		tempSuffix.append(COMPONENT_LINE_NEWLINE + "Enabled: " + aComponent.isEnabled());

		return aPath + "|||" + tempSuffix.toString();
	}
}
