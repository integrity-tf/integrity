/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.server;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Pair;

import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.MessageProcessor;
import de.gebit.integrity.remoting.transport.ServerEndpoint;
import de.gebit.integrity.remoting.transport.enums.BreakpointActions;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.AbortExecutionMessage;
import de.gebit.integrity.remoting.transport.messages.AbstractMessage;
import de.gebit.integrity.remoting.transport.messages.BreakpointUpdateMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionControlMessage;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
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
 * The server implementation.
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * The bound port.
	 */
	private int port;

	/**
	 * Whether this remoting server has been initialized as a fork.
	 */
	private boolean isFork;

	/**
	 * Creates a new server, listening on a specified port and a specified host IP.
	 * 
	 * @param aHostIP
	 *            the host IP to listen on
	 * @param aPort
	 *            the port to listen on (0 = auto-choose a free port)
	 * @param aListener
	 *            the listener
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 * @param anIsForkFlag
	 *            whether this remoting server is serving inside an Integrity fork process
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public IntegrityRemotingServer(String aHostIP, int aPort, IntegrityRemotingServerListener aListener,
			ClassLoader aClassLoader, boolean anIsForkFlag) throws UnknownHostException, IOException {
		if (aListener == null) {
			throw new IllegalArgumentException("A listener must be provided.");
		}
		listener = aListener;
		isFork = anIsForkFlag;
		serverEndpoint = new ServerEndpoint(aHostIP, aPort, createProcessors(), aClassLoader, anIsForkFlag);
		port = serverEndpoint.getPort();
	}

	/**
	 * Closes all connections to clients.
	 * 
	 * @param anEmptyOutputQueueFlag
	 *            whether the output message queue shall be emptied before closing the connection
	 */
	public void closeAll(boolean anEmptyOutputQueueFlag) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
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
	 * Sends data from a test runner callback in a fork to the master, which will then forward it to the matching
	 * callback.
	 * 
	 * @param aCallbackClassName
	 *            the name of the callback class
	 * @param aMethod
	 *            the method being called
	 * @param someData
	 *            the data
	 */
	public void sendTestRunnerCallbackData(String aCallbackClassName, TestRunnerCallbackMethods aMethod,
			Serializable[] someData) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new TestRunnerCallbackMessage(aCallbackClassName, aMethod, someData));
		}
	}

	/**
	 * Transmits an update for a variables' value to the master.
	 * 
	 * @param aVariableName
	 *            the name of the variable
	 * @param aValue
	 *            the updated value
	 */
	public void sendVariableUpdate(String aVariableName, Serializable aValue) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new VariableUpdateMessage(aVariableName, aValue));
		}
	}

	/**
	 * Transmits an unsetting of a variables' value to the master.
	 * 
	 * @param aVariableName
	 *            the name of the variable
	 */
	public void sendVariableUnset(String aVariableName) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new VariableUnsetMessage(aVariableName));
		}
	}

	/**
	 * Transmits an abortion message.
	 * 
	 * @param anExceptionMessage
	 * @param anExceptionStackTrace
	 */
	public void sendAbortMessage(String anExceptionMessage, String anExceptionStackTrace) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(new AbortExecutionMessage(anExceptionMessage, anExceptionStackTrace));
		}
	}

	/**
	 * Sends a test time sync message.
	 * 
	 * @param aStartDate
	 * @param aProgressionFactor
	 */
	public void sendTestTimeSyncRequest(Date aStartDate, List<Pair<Long, TemporalUnit>> aDiffTime,
			BigDecimal aProgressionFactor, String[] someTargetedForks) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(
					new TimeSyncRequestMessage(aStartDate, aDiffTime, aProgressionFactor, someTargetedForks));
		}
	}

	/**
	 * Sends a response to a test time sync request.
	 * 
	 * @param anExceptionMessage
	 * @param anExceptionStackTrace
	 */
	public void sendTestTimeSyncResponse(TimeSyncResultMessage aResultMessage) {
		if (serverEndpoint.isActive()) {
			serverEndpoint.broadcastMessage(aResultMessage);
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
				anEndpoint.sendMessage(
						new IntegrityRemotingVersionMessage(IntegrityRemotingConstants.MAJOR_PROTOCOL_VERSION,
								IntegrityRemotingConstants.MINOR_PROTOCOL_VERSION,
								IntegrityRemotingConstants.MAJOR_VERSION, IntegrityRemotingConstants.MINOR_VERSION,
								IntegrityRemotingConstants.PATCH_VERSION, IntegrityRemotingConstants.BUILD_VERSION));
			}
		});

		tempMap.put(SetListBaselineMessage.class, new MessageProcessor<SetListBaselineMessage>() {

			@Override
			public void processMessage(SetListBaselineMessage aBaselineRequest, Endpoint anEndpoint) {
				listener.onSetListRequest(anEndpoint);
			}
		});

		tempMap.put(ExecutionStateMessage.class, new MessageProcessor<ExecutionStateMessage>() {

			@Override
			public void processMessage(ExecutionStateMessage aBaselineRequest, Endpoint anEndpoint) {
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

		tempMap.put(ShutdownRequestMessage.class, new MessageProcessor<ShutdownRequestMessage>() {

			@Override
			public void processMessage(ShutdownRequestMessage aMessage, Endpoint anEndpoint) {
				listener.onShutdownRequest();
			}
		});

		tempMap.put(ForkSetupMessage.class, new MessageProcessor<ForkSetupMessage>() {

			@Override
			public void processMessage(ForkSetupMessage aMessage, Endpoint anEndpoint) {
				listener.onForkSetupRetrieval(aMessage.getResourceProviders(), aMessage.getSetList(),
						aMessage.getInitialVariables(), aMessage.getNumberOfSuiteInvocations());
			}
		});

		tempMap.put(TimeSyncStateMessage.class, new MessageProcessor<TimeSyncStateMessage>() {

			@Override
			public void processMessage(TimeSyncStateMessage aMessage, Endpoint anEndpoint) {
				listener.onTimeSyncState(aMessage.getRealtimeOffset(), aMessage.getRealtimeDecouplingTime(),
						aMessage.getProgressionFactor());
			}
		});

		tempMap.put(TimeSyncResultMessage.class, new MessageProcessor<TimeSyncResultMessage>() {

			@Override
			public void processMessage(TimeSyncResultMessage aMessage, Endpoint anEndpoint) {
				listener.onTimeSyncResponse(aMessage);
			}
		});

		return tempMap;
	}

	public int getPort() {
		return port;
	}

	public boolean isFork() {
		return isFork;
	}
}
