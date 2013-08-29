/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;
import de.gebit.integrity.remoting.transport.messages.DisconnectMessage;

/**
 * An endpoint is a client- or serverside termination point of a message channel. The endpoint uses a TCP connection to
 * transmit messages bidirectionally, with processors waiting for new messages to arrive.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class Endpoint {

	/**
	 * The TCP socket used for communication.
	 */
	private Socket socket;

	/**
	 * The input processor thread waiting for new messages to arrive and process.
	 */
	private EndpointInputProcessor inputProcessor;

	/**
	 * The output processor thread waiting for new messages to be sent.
	 */
	private EndpointOutputProcessor outputProcessor;

	/**
	 * The listener.
	 */
	private EndpointListener listener;

	/**
	 * Whether the endpoint is active.
	 */
	private boolean isActive;

	/**
	 * An object used to wait on for the disconnect message handshake when closing the socket.
	 */
	private Object closeSyncObject = new Object();

	/**
	 * The classloader to use when deserializing objects.
	 */
	private ClassLoader classLoader;

	/**
	 * The maximum time in seconds to wait for the disconnect message handshake to be performed before closing the
	 * socket.
	 */
	private static final int DISCONNECT_WAIT_TIME = 10000;

	/**
	 * A map of message processors.
	 */
	private Map<Class<? extends AbstractMessage>, MessageProcessor<?>> messageProcessors = new HashMap<Class<? extends AbstractMessage>, MessageProcessor<?>>();

	/**
	 * The queue for outgoing messages. Is emptied by {@link #outputProcessor}.
	 */
	private LinkedBlockingQueue<AbstractMessage> outputQueue = new LinkedBlockingQueue<AbstractMessage>();

	/**
	 * Creates a new endpoint from a specific, already-connected socket.
	 * 
	 * @param aSocket
	 *            the connected socket
	 * @param aProcessorMap
	 *            the processors
	 * @param aListener
	 *            the listener
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 */
	public Endpoint(Socket aSocket, Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap,
			EndpointListener aListener, ClassLoader aClassLoader) {
		listener = aListener;
		socket = aSocket;
		messageProcessors = aProcessorMap;
		isActive = true;
		inputProcessor = new EndpointInputProcessor();
		inputProcessor.start();
		outputProcessor = new EndpointOutputProcessor();
		outputProcessor.start();
		classLoader = aClassLoader;
	}

	/**
	 * Creates a new endpoint and connects to a remote host, on which a {@link ServerEndpoint} is expected to run.
	 * 
	 * @param aHost
	 *            the host name or IP
	 * @param aPort
	 *            the port to connect to
	 * @param aProcessorMap
	 *            the map of processors
	 * @param aListener
	 *            the listener
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Endpoint(String aHost, int aPort, Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap,
			EndpointListener aListener, ClassLoader aClassLoader) throws UnknownHostException, IOException {
		messageProcessors = aProcessorMap;
		listener = aListener;
		socket = new Socket(aHost, aPort);
		isActive = true;
		inputProcessor = new EndpointInputProcessor();
		inputProcessor.start();
		outputProcessor = new EndpointOutputProcessor();
		outputProcessor.start();
		classLoader = aClassLoader;
	}

	/**
	 * Sends a message. This queues the message into the outqueue, which is then emptied asynchronously by the
	 * {@link #outputProcessor}.
	 * 
	 * @param aMessage
	 *            the message to send
	 */
	public void sendMessage(AbstractMessage aMessage) {
		if (isActive) {
			try {
				outputQueue.put(aMessage);
			} catch (InterruptedException exc) {
				// don't care
			}
		}
	}

	public boolean isActive() {
		return isActive && socket.isConnected();
	}

	/**
	 * Close the connection.
	 * 
	 * @param anEmptyOutputQueueFlag
	 *            whether the output queue shall be sent to the other endpoint before closing
	 */
	public void close(boolean anEmptyOutputQueueFlag) {
		isActive = false;

		if (anEmptyOutputQueueFlag) {
			// first: make sure the whole outqueue was sent
			while (outputQueue.size() > 0) {
				synchronized (outputQueue) {
					outputProcessor.interrupt();
					try {
						outputQueue.wait();
					} catch (InterruptedException exc) {
						// don't care
					}
				}
			}

			// second: send a disconnect message (request) and wait for the confirmation or the timeout
			synchronized (closeSyncObject) {
				try {
					outputQueue.put(new DisconnectMessage(false));
				} catch (InterruptedException exc) {
					// can't happen here, so don't care
				}

				try {
					closeSyncObject.wait(DISCONNECT_WAIT_TIME);
				} catch (InterruptedException exc) {
					// don't care
				}
			}

			// third: close the socket and kill the output processor
		}

		closeInternal();
		if (listener != null) {
			listener.onClosed(this);
		}
	}

	private void closeInternal() {
		isActive = false;
		outputProcessor.kill();
		outputProcessor.interrupt();
		if (!socket.isClosed()) {
			try {
				socket.shutdownOutput();
				socket.close();
			} catch (IOException exc) {
				// ignored; we're closing the socket anyway
			}
		}
	}

	private class EndpointInputProcessor extends Thread {

		public EndpointInputProcessor() {
			super("Endpoint Input Processor");
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void run() {
			ObjectInputStream tempObjectStream = null;
			try {
				InputStream tempInStream = socket.getInputStream();

				while (true) {
					int tempMessageLength = 0;
					for (int i = 0; i < 4; i++) {
						int tempByte = tempInStream.read();
						if (tempByte == -1) {
							// socket was closed
							return;
						}
						tempMessageLength |= tempByte << (i * 8);
					}

					byte[] tempMessage = new byte[tempMessageLength];
					int tempMessagePosition = 0;
					while (tempMessagePosition < tempMessageLength) {
						int tempBytesRead = tempInStream.read(tempMessage, tempMessagePosition, tempMessageLength
								- tempMessagePosition);
						if (tempBytesRead > -1) {
							tempMessagePosition += tempBytesRead;
						} else {
							// socket was closed
							return;
						}
					}

					tempObjectStream = new ClassloaderAwareObjectInputStream(new InflaterInputStream(
							new ByteArrayInputStream(tempMessage)), classLoader);
					try {
						AbstractMessage tempMessageObject = (AbstractMessage) tempObjectStream.readObject();
						if (tempMessageObject instanceof DisconnectMessage) {
							// disconnect messages are handled directly in the endpoints
							if (((DisconnectMessage) tempMessageObject).isConfirmation()) {
								synchronized (closeSyncObject) {
									closeSyncObject.notifyAll();
								}
							} else {
								// this is a disconnect request message and should be answered by a confirmation when
								// received
								sendMessage(new DisconnectMessage(true));
							}
						} else {
							// just a standard message; use the appropriate processor
							MessageProcessor tempProcessor = messageProcessors.get(tempMessageObject.getClass());
							if (tempProcessor != null) {
								tempProcessor.processMessage(tempMessageObject, Endpoint.this);
							}
						}
					} catch (ClassNotFoundException exc) {
						exc.printStackTrace();
					}
				}
			} catch (IOException exc) {
				// filter out socket closed messages; we're expecting those to happen and they're handled just fine
				if (!"socket closed".equals(exc.getMessage().toLowerCase())) {
					exc.printStackTrace();
				}
			} finally {
				closeInternal();
				if (tempObjectStream != null) {
					try {
						tempObjectStream.close();
					} catch (IOException exc) {
						// ignore
					}
				}
				if (listener != null) {
					listener.onConnectionLost(Endpoint.this);
				}
			}
		}
	}

	private class EndpointOutputProcessor extends Thread {

		/**
		 * Used to gracefully kill this thread.
		 */
		private boolean killSwitch;

		public EndpointOutputProcessor() {
			super("Endpoint Output Processor");
		}

		public void kill() {
			killSwitch = true;
		}

		@Override
		public void run() {
			try {
				OutputStream tempOutStream = socket.getOutputStream();

				while (socket.isConnected() && !killSwitch) {
					AbstractMessage tempMessageObject = null;
					try {
						tempMessageObject = outputQueue.poll(1, TimeUnit.SECONDS);
						if (outputQueue.size() == 0 && !isActive) {
							synchronized (outputQueue) {
								outputQueue.notify();
							}
						}
					} catch (InterruptedException exc) {
						// don't care
					}

					if (tempMessageObject != null && socket.isConnected()) {
						ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
						DeflaterOutputStream tempDeflateStream = new DeflaterOutputStream(tempStream);
						ObjectOutputStream tempObjectStream = new ObjectOutputStream(tempDeflateStream);
						tempObjectStream.writeObject(tempMessageObject);
						tempObjectStream.close();

						byte[] tempMessage = tempStream.toByteArray();
						byte[] tempLength = new byte[4];

						for (int i = 0; i < 4; i++) {
							tempLength[i] = (byte) ((tempMessage.length >> (i * 8)) & 0xFF);
						}

						tempOutStream.write(tempLength);
						tempOutStream.write(tempMessage);
						tempOutStream.flush();
					}
				}

			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
	}

	/**
	 * This object input stream allows to specify the classloader which is used to resolve the classes.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class ClassloaderAwareObjectInputStream extends ObjectInputStream {

		/**
		 * The classloader to use.
		 */
		private ClassLoader classLoader;

		/**
		 * Creates an instance.
		 * 
		 * @param anInputStream
		 *            the input stream to read from
		 * @param aClassLoader
		 *            the classloader to use for resolving
		 * @throws IOException
		 */
		public ClassloaderAwareObjectInputStream(InputStream anInputStream, ClassLoader aClassLoader)
				throws IOException {
			super(anInputStream);
			classLoader = aClassLoader;
		}

		@Override
		protected Class<?> resolveClass(ObjectStreamClass aDescription) throws IOException, ClassNotFoundException {
			if (classLoader != null) {
				try {
					return classLoader.loadClass(aDescription.getName());
				} catch (ClassNotFoundException exc) {
					return super.resolveClass(aDescription);
				}
			} else {
				return super.resolveClass(aDescription);
			}
		}

	}

}
