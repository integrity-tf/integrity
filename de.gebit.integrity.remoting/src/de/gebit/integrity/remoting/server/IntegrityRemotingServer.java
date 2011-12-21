package de.gebit.integrity.remoting.server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.MessageProcessor;
import de.gebit.integrity.remoting.transport.ServerEndpoint;
import de.gebit.integrity.remoting.transport.enums.BreakpointActions;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.messages.AbstractMessage;
import de.gebit.integrity.remoting.transport.messages.BreakpointUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.gebit.integrity.remoting.transport.messages.SetListUpdateMessage;

/**
 * The server implementation.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class IntegrityRemotingServer {

	/**
	 * The actual server communication endpoint.
	 */
	private ServerEndpoint serverEndpoint;

	/**
	 * The server listener.
	 */
	private IntegrityRemotingServerListener listener;

	/**
	 * The current execution state.
	 */
	private ExecutionStates executionState;

	/**
	 * Creates a new server, listening on a specified port and a specified host IP.
	 * 
	 * @param aHostIP
	 *            the host IP to listen on
	 * @param aPort
	 *            the port to listen on
	 * @param aListener
	 *            the listener
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public IntegrityRemotingServer(String aHostIP, int aPort, IntegrityRemotingServerListener aListener)
			throws UnknownHostException, IOException {
		if (aListener == null) {
			throw new IllegalArgumentException("A listener must be provided.");
		}
		listener = aListener;
		serverEndpoint = new ServerEndpoint(aHostIP, aPort, createProcessors());
	}

	/**
	 * Closes all connections to clients.
	 * 
	 * @param anEmptyOutputQueueFlag
	 *            whether the output message queue shall be emptied before closing the connection
	 */
	public void closeAll(boolean anEmptyOutputQueueFlag) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.closeAll(anEmptyOutputQueueFlag);
		}
	}

	/**
	 * Updates the execution state, broadcasting a message to all clients to notify them about that change.
	 * 
	 * @param aNewState
	 *            the new state
	 */
	public void updateExecutionState(ExecutionStates aNewState) {
		if (aNewState != executionState) {
			executionState = aNewState;
			serverEndpoint.broadcastMessage(new ExecutionStateMessage(aNewState));
		}
	}

	/**
	 * Transmits updates to some {@link SetListEntry} instances to all clients.
	 * 
	 * @param anEntryInExecution
	 *            the entry in execution (null if nothing changed)
	 * @param someUpdatedEntries
	 *            the updated entries
	 */
	public void updateSetList(Integer anEntryInExecution, SetListEntry... someUpdatedEntries) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new SetListUpdateMessage(anEntryInExecution, someUpdatedEntries));
		}
	}

	/**
	 * Notifies all clients about the creation of a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint was created
	 */
	public void confirmBreakpointCreation(int anEntryReference) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new BreakpointUpdateMessage(BreakpointActions.CREATE, anEntryReference));
		}
	}

	/**
	 * Notifies all clients about the removal of a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint was removed
	 */
	public void confirmBreakpointRemoval(int anEntryReference) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new BreakpointUpdateMessage(BreakpointActions.REMOVE, anEntryReference));
		}
	}

	/**
	 * Creates the processors for processing incoming messages.
	 * 
	 * @return a map of message classes to processors
	 */
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
					break;
				case STEP_INTO:
					listener.onStepIntoCommand(anEndpoint);
					break;
				default:
					break;
				}
			}

		});

		tempMap.put(BreakpointUpdateMessage.class, new MessageProcessor<BreakpointUpdateMessage>() {

			@Override
			public void processMessage(BreakpointUpdateMessage aMessage, Endpoint anEndpoint) {
				switch (aMessage.getAction()) {
				case CREATE:
					listener.onCreateBreakpoint(aMessage.getEntryReference(), anEndpoint);
					break;
				case REMOVE:
					listener.onRemoveBreakpoint(aMessage.getEntryReference(), anEndpoint);
					break;
				default:
					break;
				}
			}

		});

		return tempMap;
	}
}
