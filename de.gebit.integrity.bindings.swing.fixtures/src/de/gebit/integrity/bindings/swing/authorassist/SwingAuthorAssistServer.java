/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.authorassist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;
import de.gebit.integrity.bindings.swing.util.Base64;

/**
 * The author assist server provides a kind of entrance into the running application, primarily used by the Swing
 * Fixture content assist feature in the Integrity editor. When the server is running, the content assist feature can
 * connect to it and query for information about components in the currently-running application.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingAuthorAssistServer {

	/**
	 * The server thread which performs the actual work.
	 */
	protected SwingAuthorAssistServerThread serverThread;

	/**
	 * The component handler.
	 */
	protected AbstractSwingComponentHandler swingComponentHandler;

	/**
	 * The frame which owns this server.
	 */
	protected JFrame ownerFrame;

	/**
	 * The default port to use.
	 */
	public static final int DEFAULT_PORT = 61432;

	/**
	 * The default hostname to bind to.
	 */
	public static final String DEFAULT_HOST = "127.0.0.1";

	/**
	 * Creates a new instance.
	 */
	public SwingAuthorAssistServer(AbstractSwingComponentHandler aSwingComponentHandler, JFrame anOwnerFrame) {
		swingComponentHandler = aSwingComponentHandler;
		ownerFrame = anOwnerFrame;
	}

	/**
	 * Creates and returns a new {@link ServerSocket}, bound to the desired hostname and port.
	 * 
	 * @return the bound socket
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	protected ServerSocket createServerSocket() throws UnknownHostException, IOException {
		return new ServerSocket(DEFAULT_PORT, 1, InetAddress.getByName(DEFAULT_HOST));
	}

	/**
	 * Starts the server.
	 */
	public void startUp() {
		if (serverThread == null) {
			serverThread = new SwingAuthorAssistServerThread();
			serverThread.start();
		}
	}

	/**
	 * Shuts down the server.
	 */
	public void shutDown() {
		if (serverThread != null) {
			serverThread.kill();
			serverThread = null;
		}
	}

	/**
	 * The author assist server is responsible for providing an entrance into the running Swing application to the code
	 * completion functionality of the Swing bindings (base class:
	 * {@link de.gebit.integrity.bindings.swing.eclipse.AbstractSwingFixtureAssist}).
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class SwingAuthorAssistServerThread extends Thread {

		/**
		 * The server socket.
		 */
		protected ServerSocket serverSocket;

		/**
		 * Creates an instance.
		 */
		public SwingAuthorAssistServerThread() {
			super("Author Assist Server");
		}

		/**
		 * Kills the server by closing the socket and ending the thread.
		 */
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

								List<Component> tempComponents = (List<Component>) swingComponentHandler
										.findComponents(null, (Class<? extends Component>) tempFilterClass, ownerFrame);

								Map<Object, Object> tempCache = new HashMap<Object, Object>();
								PrintWriter tempWriter = new PrintWriter(tempClientSocket.getOutputStream());
								for (Component tempComponent : tempComponents) {
									String tempLongPath = swingComponentHandler
											.createUniquifiedComponentPath(tempComponent);
									String tempShortPath = swingComponentHandler
											.createShortestComponentPath(tempComponent);

									if (tempLongPath != null) {
										if (tempShortPath == null) {
											tempShortPath = "";
										}
										tempWriter.println(generateComponentLine(tempShortPath, tempLongPath,
												tempComponent, tempCache));
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

	/**
	 * This is used as newline indicator in both HTML and plain results.
	 */
	public static final String COMPONENT_LINE_NEWLINE = "<br>";

	/**
	 * Maximum width for the quickhelp overview pictures pointing out a specific component. If the real width is larger,
	 * scaling will occur.
	 */
	public final int getComponentLineOverviewImgMaxWidth() {
		return 260;
	}

	/**
	 * Maximum height for the quickhelp overview pictures pointing out a specific component. If the real height is
	 * larger, scaling will occur.
	 */
	public final int getComponentLineOverviewImgMaxHeight() {
		return 160;
	}

	/**
	 * Minimum scaling factor. If scaling below this factor would be necessary, the max height/width values are ignored.
	 */
	public final float getComponentLineOverviewMinScaling() {
		return 0.33f;
	}

	/**
	 * Generates the data line for a specific component.
	 * 
	 * @param aShortPath
	 *            the short path, if available
	 * @param aLongPath
	 *            the long path
	 * @param aComponent
	 *            the component in question
	 * @param aCacheMap
	 *            a map which can be used to cache expensive stuff, such as generated images
	 * @return the line
	 */
	protected String generateComponentLine(String aShortPath, String aLongPath, Component aComponent,
			Map<Object, Object> aCacheMap) {
		StringBuilder tempHTMLDescription = new StringBuilder();
		StringBuilder tempPlainDescription = new StringBuilder();

		addHTMLComponentCSSLinePart(tempHTMLDescription);
		addHTMLComponentTagLinePart(tempHTMLDescription, "Component");
		tempHTMLDescription.append(aComponent.getClass().getName() + COMPONENT_LINE_NEWLINE);

		tempPlainDescription.append("Component: " + aComponent.getClass().getName() + COMPONENT_LINE_NEWLINE);

		if (aComponent instanceof JButton) {
			String tempButtonText = "'" + ((JButton) aComponent).getText() + "'";
			addHTMLComponentTagLinePart(tempHTMLDescription, "Text");
			tempHTMLDescription.append(tempButtonText + COMPONENT_LINE_NEWLINE);

			tempPlainDescription.append("Text: " + tempButtonText + COMPONENT_LINE_NEWLINE);
		} else if (aComponent instanceof JToggleButton) {
			String tempButtonText = "'" + ((JToggleButton) aComponent).getText() + "'";
			addHTMLComponentTagLinePart(tempHTMLDescription, "Text");
			tempHTMLDescription.append(tempButtonText + COMPONENT_LINE_NEWLINE);

			tempPlainDescription.append("Text: " + tempButtonText + COMPONENT_LINE_NEWLINE);
		}

		addHTMLComponentTagLinePart(tempHTMLDescription, "Enabled");
		tempHTMLDescription.append(aComponent.isEnabled());

		tempPlainDescription.append("Enabled: " + aComponent.isEnabled() + COMPONENT_LINE_NEWLINE);

		addHTMLComponentImageLinePart(tempHTMLDescription, aComponent, aCacheMap);

		return aLongPath + "||" + aShortPath + "||" + tempHTMLDescription.toString() + "||"
				+ tempPlainDescription.toString();
	}

	/**
	 * Adds a tag to the HTML line being built. A tag is basically a header for some data afterwards and printed bold.
	 * 
	 * @param aBuilder
	 *            the string builder building the line
	 * @param aTag
	 *            the name of the tag
	 */
	protected void addHTMLComponentTagLinePart(StringBuilder aBuilder, String aTag) {
		aBuilder.append("<span class=\"tag\">" + aTag + ":</span> ");
	}

	/**
	 * Adds a little overview image pointing out the position of the provided component in its host frame with a red
	 * line.
	 * 
	 * @param aBuilder
	 *            the string builder building the line
	 * @param aComponent
	 *            the component
	 * @param aCacheMap
	 *            the cache
	 */
	protected void addHTMLComponentImageLinePart(StringBuilder aBuilder, Component aComponent,
			Map<Object, Object> aCacheMap) {
		Window tempOuterContainer = null;
		Container tempParent = aComponent.getParent();
		while (tempParent != null) {
			if (tempParent instanceof Window) {
				tempOuterContainer = (Window) tempParent;
				break;
			}
			tempParent = tempParent.getParent();
		}

		if (tempOuterContainer != null && tempOuterContainer.getWidth() > 10 && tempOuterContainer.getHeight() > 10) {
			// Scaled images of outer containers are stored in the provided
			// cache for quick reuse
			BufferedImage tempScaledOriginalImage = (BufferedImage) aCacheMap.get(tempOuterContainer);
			Float tempScalingFactor = null;

			if (tempScaledOriginalImage != null) {
				tempScalingFactor = (Float) aCacheMap.get(tempScaledOriginalImage);
			} else {
				BufferedImage tempImage = new BufferedImage(tempOuterContainer.getWidth(),
						tempOuterContainer.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D tempGraphics = (Graphics2D) tempImage.getGraphics();
				tempOuterContainer.paintAll(tempGraphics);

				float tempScalingFactor1 = (float) getComponentLineOverviewImgMaxWidth() / (float) tempImage.getWidth();
				float tempScalingFactor2 = (float) getComponentLineOverviewImgMaxHeight()
						/ (float) tempImage.getHeight();
				tempScalingFactor = tempScalingFactor1 < tempScalingFactor2 ? tempScalingFactor1 : tempScalingFactor2;

				if (tempScalingFactor >= 1.0) {
					tempScalingFactor = 1.0f;
					tempScaledOriginalImage = tempImage;
				} else {
					if (tempScalingFactor < getComponentLineOverviewMinScaling()) {
						tempScalingFactor = getComponentLineOverviewMinScaling();
					}

					tempScaledOriginalImage = new BufferedImage(Math.round((float) tempImage.getWidth()
							* tempScalingFactor), Math.round((float) tempImage.getHeight() * tempScalingFactor),
							BufferedImage.TYPE_INT_RGB);
					tempGraphics = (Graphics2D) tempScaledOriginalImage.getGraphics();
					tempGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
							RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					tempGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					tempGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					tempGraphics.drawImage(tempImage, 0, 0, tempScaledOriginalImage.getWidth(),
							tempScaledOriginalImage.getHeight(), 0, 0, tempImage.getWidth(), tempImage.getHeight(),
							null);
					tempGraphics.dispose();
				}

				aCacheMap.put(tempOuterContainer, tempScaledOriginalImage);
				aCacheMap.put(tempScaledOriginalImage, tempScalingFactor);
			}

			// Create a copy of the scaled image for addition of component
			// location info
			BufferedImage tempScaledImage = new BufferedImage(tempScaledOriginalImage.getWidth(),
					tempScaledOriginalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D tempGraphics = (Graphics2D) tempScaledImage.getGraphics();
			tempGraphics.drawImage(tempScaledOriginalImage, 0, 0, null);

			// Calculate the coordinates for drawing a border around the
			// component in question
			int tempComponentX = aComponent.getX();
			int tempComponentY = aComponent.getY();
			int tempBorderWidth = aComponent.getWidth();
			int tempBorderHeight = aComponent.getHeight();
			tempParent = aComponent.getParent();
			while (tempParent != null && !(tempParent == tempOuterContainer)) {
				tempComponentX += tempParent.getX();
				tempComponentY += tempParent.getY();
				tempParent = tempParent.getParent();
			}
			tempComponentX = Math.round((float) tempComponentX * tempScalingFactor) - 2;
			tempComponentY = Math.round((float) tempComponentY * tempScalingFactor) - 2;
			tempBorderWidth = Math.round((float) tempBorderWidth * tempScalingFactor) + 2;
			tempBorderHeight = Math.round((float) tempBorderHeight * tempScalingFactor) + 2;

			// Ensure component border coordinates are within valid bounds
			if (tempComponentX < 0) {
				tempComponentX = 0;
			} else if (tempComponentX >= tempScaledImage.getWidth()) {
				tempComponentX = tempScaledImage.getWidth() - 1;
			}
			if (tempComponentY < 0) {
				tempComponentY = 0;
			} else if (tempComponentY >= tempScaledImage.getHeight()) {
				tempComponentY = tempScaledImage.getHeight() - 1;
			}
			if (tempBorderWidth + tempComponentX > tempScaledImage.getWidth()) {
				tempBorderWidth = tempScaledImage.getWidth() - tempComponentX;
			}
			if (tempBorderHeight + tempComponentY > tempScaledImage.getHeight()) {
				tempBorderHeight = tempScaledImage.getHeight() - tempComponentY;
			}

			// Draw a border around the whole image and a red border around the
			// coordinate
			tempGraphics.setColor(Color.BLACK);
			tempGraphics.drawRect(0, 0, tempScaledImage.getWidth() - 1, tempScaledImage.getHeight() - 1);
			tempGraphics.setColor(Color.RED);
			tempGraphics.drawRect(tempComponentX, tempComponentY, tempBorderWidth, tempBorderHeight);
			tempGraphics.dispose();

			// Encode the final image in base64 and place it in the HTML as an
			// "inline css" image
			ByteArrayOutputStream tempOutBuffer = new ByteArrayOutputStream();
			try {
				ImageIO.write(tempScaledImage, "PNG", tempOutBuffer);
				final byte[] tempByteArray = tempOutBuffer.toByteArray();
				String tempEncodedData = Base64.encodeBytes(tempByteArray);
				aBuilder.append("<div style=\"width: " + tempScaledImage.getWidth() + "px; height: "
						+ tempScaledImage.getHeight() + "px; background: #000 url(data:image/png;base64,"
						+ tempEncodedData + ");\"/>");
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
	}

	/**
	 * Adds the CSS style info to the given line.
	 * 
	 * @param aBuilder
	 *            the line builder
	 */
	protected void addHTMLComponentCSSLinePart(StringBuilder aBuilder) {
		aBuilder.append("<style type=\"text/css\">"
				+ "body { font-family: Arial, Sans-Serif; font-size: x-small; margin: 4px; } "
				+ ".tag { font-weight: bold; }" + "</style>");
	}
}
