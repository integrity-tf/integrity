package de.integrity.remoting.transport;

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

import de.integrity.remoting.transport.messages.AbstractMessage;

public class Endpoint {

	private Socket socket;

	private EndpointInputProcessor inputProcessor;

	private EndpointOutputProcessor outputProcessor;

	private EndpointListener listener;

	private boolean isActive;

	private Map<Class<? extends AbstractMessage>, MessageProcessor<?>> messageProcessors = new HashMap<Class<? extends AbstractMessage>, MessageProcessor<?>>();

	private LinkedBlockingQueue<AbstractMessage> outputQueue = new LinkedBlockingQueue<AbstractMessage>();

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
