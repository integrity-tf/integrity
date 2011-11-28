package de.integrity.remoting.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import de.integrity.remoting.IntegrityRemotingConstants;
import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.EndpointListener;
import de.integrity.remoting.transport.MessageProcessor;
import de.integrity.remoting.transport.enums.ExecutionCommands;
import de.integrity.remoting.transport.enums.ExecutionStates;
import de.integrity.remoting.transport.messages.AbstractMessage;
import de.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.integrity.remoting.transport.messages.SetListUpdateMessage;

public class IntegrityRemotingClient {

	private Endpoint endpoint;

	private IntegrityRemotingClientListener listener;

	private ExecutionStates executionState;

	public IntegrityRemotingClient(String aHost, int aPort, IntegrityRemotingClientListener aListener)
			throws UnknownHostException, IOException {
		if (aListener == null) {
			throw new IllegalArgumentException("A listener must be provided.");
		}
		listener = aListener;
		endpoint = new Endpoint(aHost, aPort, createProcessors(), new EndpointListener() {

			@Override
			public void onConnectionLost(Endpoint anEndpoint) {
				executionState = null;
				listener.onConnectionLost(anEndpoint);
			}

			@Override
			public void onClosed(Endpoint anEndpoint) {
				executionState = null;
			}
		});

		endpoint.sendMessage(new IntegrityRemotingVersionMessage(IntegrityRemotingConstants.MAJOR_PROTOCOL_VERSION,
				IntegrityRemotingConstants.MINOR_PROTOCOL_VERSION, IntegrityRemotingConstants.MAJOR_VERSION,
				IntegrityRemotingConstants.MINOR_VERSION, IntegrityRemotingConstants.PATCH_VERSION,
				IntegrityRemotingConstants.BUILD_VERSION));
	}

	public void close() {
		if (isActive()) {
			endpoint.close(false);
		}
	}

	public boolean isActive() {
		return (endpoint != null && endpoint.isActive());
	}

	public void controlExecution(ExecutionCommands aCommand) {
		sendMessage(new ExecutionControlMessage(aCommand));
	}

	public ExecutionStates getExecutionState() {
		return executionState;
	}

	protected void sendMessage(AbstractMessage aMessage) {
		if (isActive()) {
			endpoint.sendMessage(aMessage);
		}
	}

	protected Map<Class<? extends AbstractMessage>, MessageProcessor<?>> createProcessors() {
		Map<Class<? extends AbstractMessage>, MessageProcessor<?>> tempMap = new HashMap<Class<? extends AbstractMessage>, MessageProcessor<?>>();

		tempMap.put(IntegrityRemotingVersionMessage.class, new MessageProcessor<IntegrityRemotingVersionMessage>() {

			@Override
			public void processMessage(IntegrityRemotingVersionMessage aVersion, Endpoint anEndpoint) {
				if (IntegrityRemotingConstants.MAJOR_PROTOCOL_VERSION != aVersion.getProtocolMajorVersion()) {
					listener.onVersionMismatch(aVersion, anEndpoint);
					endpoint.close(false);
				} else {
					listener.onConnectionSuccessful(aVersion, anEndpoint);
					anEndpoint.sendMessage(new SetListBaselineMessage(null));
				}
			}
		});

		tempMap.put(SetListBaselineMessage.class, new MessageProcessor<SetListBaselineMessage>() {

			@Override
			public void processMessage(SetListBaselineMessage aBaseline, Endpoint anEndpoint) {
				listener.onBaselineReceived(aBaseline.getSetList(), anEndpoint);
			}
		});

		tempMap.put(ExecutionStateMessage.class, new MessageProcessor<ExecutionStateMessage>() {

			@Override
			public void processMessage(ExecutionStateMessage aMessage, Endpoint anEndpoint) {
				executionState = aMessage.getState();
				listener.onExecutionStateUpdate(aMessage.getState(), anEndpoint);
			}
		});

		tempMap.put(SetListUpdateMessage.class, new MessageProcessor<SetListUpdateMessage>() {

			@Override
			public void processMessage(SetListUpdateMessage aMessage, Endpoint anEndpoint) {
				listener.onSetListUpdate(anEndpoint, aMessage.getUpdatedEntries());
			}
		});

		return tempMap;
	}
}
