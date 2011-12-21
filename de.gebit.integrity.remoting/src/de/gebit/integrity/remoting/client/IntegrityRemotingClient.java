package de.gebit.integrity.remoting.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.EndpointListener;
import de.gebit.integrity.remoting.transport.MessageProcessor;
import de.gebit.integrity.remoting.transport.enums.BreakpointActions;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.messages.AbstractMessage;
import de.gebit.integrity.remoting.transport.messages.BreakpointUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.gebit.integrity.remoting.transport.messages.SetListUpdateMessage;

/**
 * The remoting client.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class IntegrityRemotingClient {

	/**
	 * The endpoint used for the communication with the server.
	 */
	private Endpoint endpoint;

	/**
	 * The listener.
	 */
	private IntegrityRemotingClientListener listener;

	/**
	 * The current execution state.
	 */
	private ExecutionStates executionState;

	/**
	 * Creates a new instance and connects to a given remoting host.
	 * 
	 * @param aHost
	 *            the host name or IP
	 * @param aPort
	 *            the port
	 * @param aListener
	 *            the listener
	 * @throws UnknownHostException
	 * @throws IOException
	 */
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

	/**
	 * Closes a given remoting session.
	 */
	public void close() {
		if (isActive()) {
			endpoint.close(false);
		}
	}

	public boolean isActive() {
		return (endpoint != null && endpoint.isActive());
	}

	/**
	 * Call this method to control the test execution on the server.
	 * 
	 * @param aCommand
	 *            the command to execute
	 */
	public void controlExecution(ExecutionCommands aCommand) {
		sendMessage(new ExecutionControlMessage(aCommand));
	}

	public ExecutionStates getExecutionState() {
		return executionState;
	}

	/**
	 * Creates a breakpoint at the specified entry reference.
	 * 
	 * @param anEntryReference
	 */
	public void createBreakpoint(int anEntryReference) {
		sendMessage(new BreakpointUpdateMessage(BreakpointActions.CREATE, anEntryReference));
	}

	/**
	 * Deletes a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint shall be deleted
	 */
	public void deleteBreakpoint(int anEntryReference) {
		sendMessage(new BreakpointUpdateMessage(BreakpointActions.REMOVE, anEntryReference));
	}

	/**
	 * Sends a message to the server.
	 * 
	 * @param aMessage
	 *            the message to send
	 */
	protected void sendMessage(AbstractMessage aMessage) {
		if (isActive()) {
			endpoint.sendMessage(aMessage);
		}
	}

	/**
	 * Creates processors to process messages.
	 * 
	 * @return
	 */
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
			public void processMessage(SetListBaselineMessage aMessage, Endpoint anEndpoint) {
				aMessage.getSetList().recreateTransientData();
				listener.onBaselineReceived(aMessage.getSetList(), anEndpoint);
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
				listener.onSetListUpdate(aMessage.getUpdatedEntries(), aMessage.getEntryInExecution(), anEndpoint);
			}
		});

		tempMap.put(BreakpointUpdateMessage.class, new MessageProcessor<BreakpointUpdateMessage>() {

			@Override
			public void processMessage(BreakpointUpdateMessage aMessage, Endpoint anEndpoint) {
				switch (aMessage.getAction()) {
				case CREATE:
					listener.onConfirmCreateBreakpoint(aMessage.getEntryReference(), anEndpoint);
					break;
				case REMOVE:
					listener.onConfirmRemoveBreakpoint(aMessage.getEntryReference(), anEndpoint);
					break;
				default:
					break;
				}
			}
		});

		return tempMap;
	}
}
