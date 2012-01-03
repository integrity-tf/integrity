package de.gebit.integrity.remoting.client;

import java.io.Serializable;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

/**
 * This listener must be implemented by anyone wanting to attach to the remoting client.
 * 
 * @author Rene Schneider
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
	void onConfirmCreateBreakpoint(int anEntryReference, Endpoint anEndpoint);

	/**
	 * Called when the server confirms the removal of a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint was removed
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConfirmRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint);

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

}
