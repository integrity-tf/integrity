/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.client;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.providers.TestResourceProvider;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.EndpointListener;
import de.gebit.integrity.remoting.transport.MessageProcessor;
import de.gebit.integrity.remoting.transport.enums.BreakpointActions;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.messages.AbortExecutionMessage;
import de.gebit.integrity.remoting.transport.messages.AbstractMessage;
import de.gebit.integrity.remoting.transport.messages.BreakpointUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.gebit.integrity.remoting.transport.messages.ForkResultSummaryMessage;
import de.gebit.integrity.remoting.transport.messages.ForkSetupMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.gebit.integrity.remoting.transport.messages.SetListUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.ShutdownRequestMessage;
import de.gebit.integrity.remoting.transport.messages.TestRunnerCallbackMessage;
import de.gebit.integrity.remoting.transport.messages.TimeSyncRequestMessage;
import de.gebit.integrity.remoting.transport.messages.TimeSyncResultMessage;
import de.gebit.integrity.remoting.transport.messages.TimeSyncStateMessage;
import de.gebit.integrity.remoting.transport.messages.VariableUnsetMessage;
import de.gebit.integrity.remoting.transport.messages.VariableUpdateMessage;

/**
 * The remoting client.
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public IntegrityRemotingClient(String aHost, int aPort, IntegrityRemotingClientListener aListener,
			ClassLoader aClassLoader) throws UnknownHostException, IOException {
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
		}, aClassLoader);

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
	 * Requests an execution state update from the server.
	 */
	public void requestExecutionStateUpdate() {
		sendMessage(new ExecutionStateMessage(null));
	}

	/**
	 * Creates a breakpoint at the specified entry reference.
	 * 
	 * @param anEntryReference
	 */
	public void createBreakpoint(Integer anEntryReference) {
		sendMessage(new BreakpointUpdateMessage(BreakpointActions.CREATE, anEntryReference));
	}

	/**
	 * Deletes a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint shall be deleted
	 */
	public void deleteBreakpoint(Integer anEntryReference) {
		sendMessage(new BreakpointUpdateMessage(BreakpointActions.REMOVE, anEntryReference));
	}

	/**
	 * Sets up a new fork with the scripts to run and the current state of the setlist.
	 * 
	 * @param someResourceProviders
	 *            the test scripts currently loaded on the master
	 * @param aSetList
	 *            the current set list of the master
	 */
	public void setupFork(List<? extends TestResourceProvider> someResourceProviders, SetList aSetList,
			Map<String, Object> someInitialVariables, int aNumberOfSuiteInvocations) {
		sendMessage(
				new ForkSetupMessage(someResourceProviders, aSetList, someInitialVariables, aNumberOfSuiteInvocations));
	}

	/**
	 * Updates a variables' value on a fork.
	 * 
	 * @param aName
	 *            the fully qualified variable name
	 * @param aValue
	 *            the new value
	 */
	public void updateVariableValue(String aName, Serializable aValue) {
		sendMessage(new VariableUpdateMessage(aName, aValue));
	}

	/**
	 * Unsets a variables' value on a fork.
	 * 
	 * @param aName
	 *            the fully qualified variable name
	 */
	public void unsetVariableValue(String aName) {
		sendMessage(new VariableUnsetMessage(aName));
	}

	/**
	 * Requests an immediate shutdown.
	 */
	public void requestShutdown() {
		sendMessage(new ShutdownRequestMessage());
	}

	/**
	 * Sends a test time sync message.
	 * 
	 * @param aRealtimeOffset
	 *            the offset of our test time from real system time (wall clock)
	 * @param aRealtimeDecouplingTime
	 *            the point in real time at which our test time was decoupled from system time
	 * @param aProgressionFactor
	 *            the speed at which the test time should progress (1.0 is normal speed, progression factor may be
	 *            negative too, or 0.0, which means time is frozen)
	 */
	public void sendTestTimeState(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
		sendMessage(new TimeSyncStateMessage(aRealtimeOffset, aRealtimeDecouplingTime, aProgressionFactor));
	}

	/**
	 * Sends a {@link TimeSyncResultMessage}.
	 * 
	 * @param anErrorMessage
	 * @param anExceptionStackTrace
	 */
	public void sendTestTimeSyncResult(String anErrorMessage, String anExceptionStackTrace) {
		sendMessage(new TimeSyncResultMessage(anErrorMessage, anExceptionStackTrace));
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

		tempMap.put(TestRunnerCallbackMessage.class, new MessageProcessor<TestRunnerCallbackMessage>() {

			@Override
			public void processMessage(TestRunnerCallbackMessage aMessage, Endpoint anEndpoint) {
				listener.onTestRunnerCallbackMessageRetrieval(aMessage.getCallbackClassName(),
						aMessage.getCallbackMethod(), aMessage.getObjects());
			}
		});

		tempMap.put(VariableUpdateMessage.class, new MessageProcessor<VariableUpdateMessage>() {

			@Override
			public void processMessage(VariableUpdateMessage aMessage, Endpoint anEndpoint) {
				listener.onVariableUpdateRetrieval(aMessage.getName(), aMessage.getValue());
			}
		});

		tempMap.put(VariableUnsetMessage.class, new MessageProcessor<VariableUnsetMessage>() {

			@Override
			public void processMessage(VariableUnsetMessage aMessage, Endpoint anEndpoint) {
				listener.onVariableUnsetRetrieval(aMessage.getName());
			}
		});

		tempMap.put(AbortExecutionMessage.class, new MessageProcessor<AbortExecutionMessage>() {

			@Override
			public void processMessage(AbortExecutionMessage aMessage, Endpoint anEndpoint) {
				listener.onAbortExecution(aMessage.getExceptionMessage(), aMessage.getExceptionStackTrace());
			}
		});

		tempMap.put(TimeSyncRequestMessage.class, new MessageProcessor<TimeSyncRequestMessage>() {

			@Override
			public void processMessage(TimeSyncRequestMessage aMessage, Endpoint anEndpoint) {
				listener.onTimeSyncRequest(aMessage.getStartDate(), aMessage.getDiffTime(),
						aMessage.getProgressionFactor(), aMessage.getTargetedForks());
			}
		});

		tempMap.put(TimeSyncResultMessage.class, new MessageProcessor<TimeSyncResultMessage>() {

			@Override
			public void processMessage(TimeSyncResultMessage aMessage, Endpoint anEndpoint) {
				listener.onTimeSyncResponse(aMessage);
			}
		});

		tempMap.put(ForkResultSummaryMessage.class, new MessageProcessor<ForkResultSummaryMessage>() {

			@Override
			public void processMessage(ForkResultSummaryMessage aMessage, Endpoint anEndpoint) {
				listener.onForkResultSummaryRetrieval(aMessage.getSuccessCount(), aMessage.getFailureCount(),
						aMessage.getCallExceptionCount(), aMessage.getTestExceptionCount());
				;
			}
		});

		return tempMap;
	}
}
