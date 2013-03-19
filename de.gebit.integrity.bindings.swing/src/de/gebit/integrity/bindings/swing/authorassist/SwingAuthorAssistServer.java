/**
 * 
 */
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

import sun.misc.BASE64Encoder;
import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
@SuppressWarnings("restriction")
public class SwingAuthorAssistServer {

	protected SwingAuthorAssistServerThread serverThread;

	protected AbstractSwingComponentHandler swingComponentHandler;

	protected JFrame ownerFrame;

	public static final int DEFAULT_PORT = 61432;

	public static final String DEFAULT_HOST = "127.0.0.1";

	/**
	 * 
	 */
	public SwingAuthorAssistServer(
			AbstractSwingComponentHandler aSwingComponentHandler,
			JFrame anOwnerFrame) {
		swingComponentHandler = aSwingComponentHandler;
		ownerFrame = anOwnerFrame;
	}

	protected ServerSocket createServerSocket() throws UnknownHostException,
			IOException {
		return new ServerSocket(DEFAULT_PORT, 1,
				InetAddress.getByName(DEFAULT_HOST));
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
						BufferedReader tempReader = new BufferedReader(
								new InputStreamReader(
										tempClientSocket.getInputStream()));
						String tempFilterClassName = tempReader.readLine();

						if (tempFilterClassName != null) {
							try {
								Class<?> tempFilterClass = getClass()
										.getClassLoader().loadClass(
												tempFilterClassName);

								List<Component> tempComponents = (List<Component>) swingComponentHandler
										.findComponents(
												null,
												(Class<? extends Component>) tempFilterClass,
												ownerFrame);

								Map<Object, Object> tempCache = new HashMap<Object, Object>();
								PrintWriter tempWriter = new PrintWriter(
										tempClientSocket.getOutputStream());
								for (Component tempComponent : tempComponents) {
									String tempLongPath = swingComponentHandler
											.createUniquifiedComponentPath(tempComponent);
									String tempShortPath = swingComponentHandler
											.createShortestComponentPath(tempComponent);

									if (tempLongPath != null) {
										if (tempShortPath == null) {
											tempShortPath = "";
										}
										tempWriter
												.println(generateComponentLine(
														tempShortPath,
														tempLongPath,
														tempComponent,
														tempCache));
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

	public static final String COMPONENT_LINE_NEWLINE = "<br>";

	public static final int COMPONENT_LINE_OVERVIEW_IMG_MAXWIDTH = 260;

	public static final int COMPONENT_LINE_OVERVIEW_IMG_MAXHEIGHT = 160;

	protected String generateComponentLine(String aShortPath, String aLongPath,
			Component aComponent, Map<Object, Object> aCacheMap) {
		StringBuilder tempHTMLDescription = new StringBuilder();
		StringBuilder tempPlainDescription = new StringBuilder();

		addComponentHTMLLinePart_CSS(tempHTMLDescription);
		addComponentHTMLLinePart_Tag(tempHTMLDescription, "Component");
		tempHTMLDescription.append(aComponent.getClass().getName()
				+ COMPONENT_LINE_NEWLINE);

		tempPlainDescription.append("Component: "
				+ aComponent.getClass().getName() + COMPONENT_LINE_NEWLINE);

		if (aComponent instanceof JButton) {
			String tempButtonText = "'" + ((JButton) aComponent).getText()
					+ "'";
			addComponentHTMLLinePart_Tag(tempHTMLDescription, "Text");
			tempHTMLDescription.append(tempButtonText + COMPONENT_LINE_NEWLINE);

			tempPlainDescription.append("Text: " + tempButtonText
					+ COMPONENT_LINE_NEWLINE);
		} else if (aComponent instanceof JToggleButton) {
			String tempButtonText = "'"
					+ ((JToggleButton) aComponent).getText() + "'";
			addComponentHTMLLinePart_Tag(tempHTMLDescription, "Text");
			tempHTMLDescription.append(tempButtonText + COMPONENT_LINE_NEWLINE);

			tempPlainDescription.append("Text: " + tempButtonText
					+ COMPONENT_LINE_NEWLINE);
		}

		addComponentHTMLLinePart_Tag(tempHTMLDescription, "Enabled");
		tempHTMLDescription.append(aComponent.isEnabled());

		tempPlainDescription.append("Enabled: " + aComponent.isEnabled()
				+ COMPONENT_LINE_NEWLINE);

		addComponentHTMLLinePart_Image(tempHTMLDescription, aComponent,
				aCacheMap);

		return aLongPath + "||" + aShortPath + "||"
				+ tempHTMLDescription.toString() + "||"
				+ tempPlainDescription.toString();
	}

	protected void addComponentHTMLLinePart_Tag(StringBuilder aBuilder,
			String aTag) {
		aBuilder.append("<span class=\"tag\">" + aTag + ":</span> ");
	}

	protected void addComponentHTMLLinePart_Image(StringBuilder aBuilder,
			Component aComponent, Map<Object, Object> aCacheMap) {
		Window tempOuterContainer = null;
		Container tempParent = aComponent.getParent();
		while (tempParent != null) {
			if (tempParent instanceof Window) {
				tempOuterContainer = (Window) tempParent;
				break;
			}
			tempParent = tempParent.getParent();
		}

		if (tempOuterContainer != null && tempOuterContainer.getWidth() > 10
				&& tempOuterContainer.getHeight() > 10) {
			// Scaled images of outer containers are stored in the provided
			// cache for quick reuse
			BufferedImage tempScaledOriginalImage = (BufferedImage) aCacheMap
					.get(tempOuterContainer);
			Float tempScalingFactor = null;

			if (tempScaledOriginalImage != null) {
				tempScalingFactor = (Float) aCacheMap
						.get(tempScaledOriginalImage);
			} else {
				BufferedImage tempImage = new BufferedImage(
						tempOuterContainer.getWidth(),
						tempOuterContainer.getHeight(),
						BufferedImage.TYPE_INT_RGB);
				Graphics2D tempGraphics = (Graphics2D) tempImage.getGraphics();
				tempOuterContainer.paintAll(tempGraphics);

				float tempScalingFactor1 = (float) COMPONENT_LINE_OVERVIEW_IMG_MAXWIDTH
						/ (float) tempImage.getWidth();
				float tempScalingFactor2 = (float) COMPONENT_LINE_OVERVIEW_IMG_MAXHEIGHT
						/ (float) tempImage.getHeight();
				tempScalingFactor = tempScalingFactor1 < tempScalingFactor2 ? tempScalingFactor1
						: tempScalingFactor2;

				if (tempScalingFactor >= 1.0) {
					tempScalingFactor = 1.0f;
					tempScaledOriginalImage = tempImage;
				} else {
					tempScaledOriginalImage = new BufferedImage(
							Math.round((float) tempImage.getWidth()
									* tempScalingFactor),
							Math.round((float) tempImage.getHeight()
									* tempScalingFactor),
							BufferedImage.TYPE_INT_RGB);
					tempGraphics = (Graphics2D) tempScaledOriginalImage
							.getGraphics();
					tempGraphics.setRenderingHint(
							RenderingHints.KEY_INTERPOLATION,
							RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					tempGraphics.setRenderingHint(RenderingHints.KEY_RENDERING,
							RenderingHints.VALUE_RENDER_QUALITY);
					tempGraphics.setRenderingHint(
							RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					tempGraphics.drawImage(tempImage, 0, 0,
							tempScaledOriginalImage.getWidth(),
							tempScaledOriginalImage.getHeight(), 0, 0,
							tempImage.getWidth(), tempImage.getHeight(), null);
					tempGraphics.dispose();
				}

				aCacheMap.put(tempOuterContainer, tempScaledOriginalImage);
				aCacheMap.put(tempScaledOriginalImage, tempScalingFactor);
			}

			// Create a copy of the scaled image for addition of component
			// location info
			BufferedImage tempScaledImage = new BufferedImage(
					tempScaledOriginalImage.getWidth(),
					tempScaledOriginalImage.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D tempGraphics = (Graphics2D) tempScaledImage
					.getGraphics();
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
			tempComponentX = Math.round((float) tempComponentX
					* tempScalingFactor) - 2;
			tempComponentY = Math.round((float) tempComponentY
					* tempScalingFactor) - 2;
			tempBorderWidth = Math.round((float) tempBorderWidth
					* tempScalingFactor) + 2;
			tempBorderHeight = Math.round((float) tempBorderHeight
					* tempScalingFactor) + 2;

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
			tempGraphics.drawRect(0, 0, tempScaledImage.getWidth() - 1,
					tempScaledImage.getHeight() - 1);
			tempGraphics.setColor(Color.RED);
			tempGraphics.drawRect(tempComponentX, tempComponentY,
					tempBorderWidth, tempBorderHeight);
			tempGraphics.dispose();

			// Encode the final image in base64 and place it in the HTML as an
			// "inline css" image
			ByteArrayOutputStream tempOutBuffer = new ByteArrayOutputStream();
			try {
				ImageIO.write(tempScaledImage, "PNG", tempOutBuffer);
				final byte[] tempByteArray = tempOutBuffer.toByteArray();
				String tempEncodedData = new BASE64Encoder() {
					protected int bytesPerLine() {
						return tempByteArray.length + 10;
					};
				}.encode(tempByteArray);
				aBuilder.append("<div style=\"width: "
						+ tempScaledImage.getWidth() + "px; height: "
						+ tempScaledImage.getHeight()
						+ "px; background: #000 url(data:image/png;base64,"
						+ tempEncodedData + ");\"/>");
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
	}

	protected void addComponentHTMLLinePart_CSS(StringBuilder aBuilder) {
		aBuilder.append("<style type=\"text/css\">"
				+ "body { font-family: Arial, Sans-Serif; font-size: x-small; margin: 4px; } "
				+ ".tag { font-weight: bold; }" + "</style>");
	}
}
