package de.integrity.remoting.server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import de.integrity.remoting.IntegrityRemotingConstants;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.MessageProcessor;
import de.integrity.remoting.transport.ServerEndpoint;
import de.integrity.remoting.transport.enums.ExecutionStates;
import de.integrity.remoting.transport.messages.AbstractMessage;
import de.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.integrity.remoting.transport.messages.SetListUpdateMessage;

public class IntegrityRemotingServer {

	private ServerEndpoint serverEndpoint;

	private IntegrityRemotingServerListener listener;

	private ExecutionStates executionState;

	public IntegrityRemotingServer(String aHostIP, int aPort, IntegrityRemotingServerListener aListener)
			throws UnknownHostException, IOException {
		if (aListener == null) {
			throw new IllegalArgumentException("A listener must be provided.");
		}
		listener = aListener;
		serverEndpoint = new ServerEndpoint(aHostIP, aPort, createProcessors());
	}

	public void closeAll(boolean anEmptyOutputQueueFlag) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.closeAll(anEmptyOutputQueueFlag);
		}
	}

	public void updateExecutionState(ExecutionStates aNewState) {
		if (aNewState != executionState) {
			executionState = aNewState;
			serverEndpoint.broadcastMessage(new ExecutionStateMessage(aNewState));
		}
	}

	public void updateSetList(Integer anEntryInExecution, SetListEntry... someUpdatedEntries) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new SetListUpdateMessage(anEntryInExecution, someUpdatedEntries));
		}
	}

	protected Map<Class<? extends AbstractMessage>, MessageProcessor<?>> createProcessors() {
		Map<Class<? extends AbstractMessage>, MessageProcessor<?>> tempMap = new HashMap<Class<? extends AbstractMessage>, MessageProcessor<?>>();

		tempMap.put(IntegrityRemotingVersionMessage.class, new MessageProcessor<IntegrityRemotingVersionMessage>() {

			@Override
			public void processMessage(IntegrityRemotingVersionMessage aVersion, Endpoint anEndpoint) {
				if (IntegrityRemotingConstants.MAJOR_PROTOCOL_VERSION == aVersion.getProtocolMajorVersion()) {
					listener.onConnectionSuccessful(aVersion, anEndpoint);
				}
				anEndpoint.sendMessage(new IntegrityRemotingVersionMessage(
						IntegrityRemotingConstants.MAJOR_PROTOCOL_VERSION,
						IntegrityRemotingConstants.MINOR_PROTOCOL_VERSION, IntegrityRemotingConstants.MAJOR_VERSION,
						IntegrityRemotingConstants.MINOR_VERSION, IntegrityRemotingConstants.PATCH_VERSION,
						IntegrityRemotingConstants.BUILD_VERSION));
			}
		});

		tempMap.put(SetListBaselineMessage.class, new MessageProcessor<SetListBaselineMessage>() {

			@Override
			public void processMessage(SetListBaselineMessage aBaselineRequest, Endpoint anEndpoint) {
				listener.onSetListRequest(anEndpoint);
				anEndpoint.sendMessage(new ExecutionStateMessage(executionState));
			}

		});

		tempMap.put(ExecutionControlMessage.class, new MessageProcessor<ExecutionControlMessage>() {

			@Override
			public void processMessage(ExecutionControlMessage aRequest, Endpoint anEndpoint) {
				switch (aRequest.getCommand()) {
				case RUN:
					listener.onRunCommand(anEndpoint);
					break;
				case PAUSE:
					listener.onPauseCommand(anEndpoint);
				}
			}

		});

		return tempMap;
	}
}
