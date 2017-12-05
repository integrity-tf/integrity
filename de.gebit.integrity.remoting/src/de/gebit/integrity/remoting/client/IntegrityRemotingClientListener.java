/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.TimeSyncResultMessage;

/**
 * This listener must be implemented by anyone wanting to attach to the remoting client.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface IntegrityRemotingClientListener {

	/**
	 * Called if a connection to a server was established successfully.
	 * 
	 * @param aRemoteVersion
	 *            the version of the server
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	/**
	 * Called if the connection was lost.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConnectionLost(Endpoint anEndpoint);

	/**
	 * Called after the initial set list baseline was received from the server. The server will send this baseline right
	 * after connecting.
	 * 
	 * @param aSetList
	 *            the set list
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onBaselineReceived(SetList aSetList, Endpoint anEndpoint);

	/**
	 * Called when the execution state has changed.
	 * 
	 * @param aState
	 *            the new state
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint);

	/**
	 * Called on a connection attempt if the remote version doesn't match the local version.
	 * 
	 * @param aRemoteVersion
	 *            the remote version information
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	/**
	 * Called when there are updates to the set list.
	 * 
	 * @param someUpdatedEntries
	 *            the updated entries
	 * @param anEntryInExecution
	 *            the currently executed entry (may be null in case there's no change)
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onSetListUpdate(SetListEntry[] someUpdatedEntries, Integer anEntryInExecution, Endpoint anEndpoint);

	/**
	 * Called when the server confirms the creation of a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint was created
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConfirmCreateBreakpoint(Integer anEntryReference, Endpoint anEndpoint);

	/**
	 * Called when the server confirms the removal of a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint was removed
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConfirmRemoveBreakpoint(Integer anEntryReference, Endpoint anEndpoint);

	/**
	 * Called when data for a test runner callback was received from a fork.
	 * 
	 * @param aCallbackClassName
	 *            the callback classes' name
	 * @param aMethod
	 *            the method
	 * @param someData
	 *            the payload
	 */
	void onTestRunnerCallbackMessageRetrieval(String aCallbackClassName, TestRunnerCallbackMethods aMethod,
			Serializable[] someData);

	/**
	 * Called when an update for a variable was received from a fork.
	 * 
	 * @param aVariableName
	 *            the name of the variable
	 * @param aValue
	 *            the new value
	 */
	void onVariableUpdateRetrieval(String aVariableName, Serializable aValue);

	/**
	 * Called when a timesync command has arrived.
	 * 
	 * @param aStartDate
	 *            the start date
	 * @param aProgressionFactor
	 *            the progression factor
	 * @param someTargetedForks
	 *            the forks that this message should be sent to
	 */
	void onTimeSyncRequest(Date aStartDate, BigDecimal aProgressionFactor, String[] someTargetedForks);

	/**
	 * Called when a timesync response has arrived. If the arguments' error fields are null, this was successful.
	 * 
	 * @param anErrorMessage
	 * @param anErrorStackTrace
	 */
	void onTimeSyncResponse(TimeSyncResultMessage aResult);

	/**
	 * Called when the server has hit an AbortExecutionException aborting further test execution.
	 * 
	 * @param anAbortExecutionMessage
	 *            The message of the AbortExecutionException
	 * @param anAbortExecutionStackTrace
	 *            The stacktrace of the AbortExecutionException
	 */
	void onAbortExecution(String anAbortExecutionMessage, String anAbortExecutionStackTrace);

}
