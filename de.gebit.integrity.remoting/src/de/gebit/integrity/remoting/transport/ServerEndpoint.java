package de.gebit.integrity.remoting.transport;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

public class ServerEndpoint {

	private ServerSocket serverSocket;

	private Map<Class<? extends AbstractMessage>, MessageProcessor<?>> messageProcessors;

	private ConnectionWaiter connectionWaiter;

	private List<Endpoint> endpoints = new LinkedList<Endpoint>();

	private boolean closing;

	public ServerEndpoint(String aHostIP, int aPort,
			Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap) throws UnknownHostException,
			IOException {
		messageProcessors = aProcessorMap;
		serverSocket = new ServerSocket(aPort, 0, Inet4Address.getByName(aHostIP));
		connectionWaiter = new ConnectionWaiter();
		connectionWaiter.start();
	}

	public boolean isActive() {
		return serverSocket.isBound() && !serverSocket.isClosed();
	}

	public void closeAll(boolean anEmptyOutputQueueFlag) {
		if (isActive()) {
			closing = true;
			try {
				serverSocket.close();
			} catch (IOException exc) {
				// don't care
			}

			synchronized (endpoints) {
				for (Endpoint tempEndpoint : endpoints) {
					if (tempEndpoint.isActive()) {
						tempEndpoint.close(anEmptyOutputQueueFlag);
					}
				}
				endpoints.clear();
			}
		}
	}

	private class ConnectionWaiter extends Thread {

		public ConnectionWaiter() {
			super("Server Endpoint Connection Waiter");
		}

		@Override
		public void run() {
			while (isActive()) {
				try {
					Socket tempSocket = serverSocket.accept();
					synchronized (endpoints) {
						endpoints.add(new Endpoint(tempSocket, messageProcessors, new EndpointListener() {

							@Override
							public void onConnectionLost(Endpoint anEndpoint) {
								synchronized (endpoints) {
									endpoints.remove(anEndpoint);
								}
							}

							@Override
							public void onClosed(Endpoint anEndpoint) {
								// we'll remove it in the outer class
							}

						}));
					}
				} catch (IOException exc) {
					if (!closing) {
						exc.printStackTrace();
					}
				}
			}
		}
	}

	public void broadcastMessage(AbstractMessage aMessage) {
		synchronized (endpoints) {
			for (Endpoint tempEndpoint : endpoints) {
				if (tempEndpoint.isActive()) {
					tempEndpoint.sendMessage(aMessage);
				}
			}
		}
	}

}
