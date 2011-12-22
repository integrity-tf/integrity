package de.gebit.integrity.remoting.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

/**
 * An endpoint is a client- or serverside termination point of a message channel. The endpoint uses a TCP connection to
 * transmit messages bidirectionally, with processors waiting for new messages to arrive.
 * 
 * @author Rene Schneider
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
	 */
	public Endpoint(Socket aSocket, Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap,
			EndpointListener aListener) {
		listener = aListener;
		socket = aSocket;
		messageProcessors = aProcessorMap;
		isActive = true;
		inputProcessor = new EndpointInputProcessor();
		inputProcessor.start();
		outputProcessor = new EndpointOutputProcessor();
		outputProcessor.start();
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
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Endpoint(String aHost, int aPort, Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap,
			EndpointListener aListener) throws UnknownHostException, IOException {
		messageProcessors = aProcessorMap;
		listener = aListener;
		socket = new Socket(aHost, aPort);
		isActive = true;
		inputProcessor = new EndpointInputProcessor();
		inputProcessor.start();
		outputProcessor = new EndpointOutputProcessor();
		outputProcessor.start();
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

		if (anEmptyOutputQueueFlag && outputQueue.size() > 0) {
			synchronized (outputQueue) {
				outputProcessor.interrupt();
				try {
					outputQueue.wait();
				} catch (InterruptedException exc) {
					// don't care
				}
			}
		}

		try {
			socket.getOutputStream().flush();
			socket.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		if (listener != null) {
			listener.onClosed(this);
		}
	}

	private class EndpointInputProcessor extends Thread {

		public EndpointInputProcessor() {
			super("Endpoint Input Processor");
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void run() {
			try {
				InputStream tempInStream = socket.getInputStream();

				while (socket.isConnected()) {
					int tempMessageLength = 0;
					for (int i = 0; i < 4; i++) {
						int tempByte = tempInStream.read();
						if (tempByte == -1) {
							return;
						}
						tempMessageLength |= tempByte << (i * 8);
					}

					byte[] tempMessage = new byte[tempMessageLength];
					int tempMessagePosition = 0;
					while (tempMessagePosition < tempMessageLength) {
						tempMessagePosition += tempInStream.read(tempMessage, tempMessagePosition, tempMessageLength
								- tempMessagePosition);
					}

					ObjectInputStream tempObjectStream = new ObjectInputStream(new ByteArrayInputStream(tempMessage));
					try {
						AbstractMessage tempMessageObject = (AbstractMessage) tempObjectStream.readObject();
						MessageProcessor tempProcessor = messageProcessors.get(tempMessageObject.getClass());
						if (tempProcessor != null) {
							tempProcessor.processMessage(tempMessageObject, Endpoint.this);
						}
					} catch (ClassNotFoundException exc) {
						exc.printStackTrace();
					}
				}
			} catch (IOException exc) {
				if (!"socket closed".equals(exc.getMessage())) {
					exc.printStackTrace();
				}
			} finally {
				isActive = false;
				outputProcessor.interrupt();
				if (listener != null) {
					listener.onConnectionLost(Endpoint.this);
				}
			}
		}
	}

	private class EndpointOutputProcessor extends Thread {

		public EndpointOutputProcessor() {
			super("Endpoint Output Processor");
		}

		@Override
		public void run() {
			try {
				OutputStream tempOutStream = socket.getOutputStream();

				while (socket.isConnected()) {
					AbstractMessage tempMessageObject = null;
					try {
						tempMessageObject = outputQueue.poll(1, TimeUnit.SECONDS);
						if (outputQueue.size() == 0 && !isActive) {
							synchronized (outputQueue) {
								outputQueue.notify();
								return;
							}
						}
					} catch (InterruptedException exc) {
						// don't care
					}

					if (tempMessageObject != null && socket.isConnected()) {
						ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
						ObjectOutputStream tempObjectStream = new ObjectOutputStream(tempStream);
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

}
