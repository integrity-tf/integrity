package de.gebit.integrity.remoting.server;

import java.io.Serializable;

import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

/**
 * This listener must be implemented by the server process itself and serves as a kind of callback.
 * 
 * @author Rene Schneider
 * 
 */
public interface IntegrityRemotingServerListener {

	/**
	 * Called when a connection attempt from a client was successful.
	 * 
	 * @param aRemoteVersion
	 *            the version of the client
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	/**
	 * Called when a connection to a client was lost.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConnectionLost(Endpoint anEndpoint);

	/**
	 * Called when a set list request from a client came in.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onSetListRequest(Endpoint anEndpoint);

	/**
	 * Called when a "run tests" command from a client came in.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onRunCommand(Endpoint anEndpoint);

	/**
	 * Called when a "pause tests" command from a client came in.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onPauseCommand(Endpoint anEndpoint);

	/**
	 * Called when a "step into" command from a client came in.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onStepIntoCommand(Endpoint anEndpoint);

	/**
	 * Called when a client wants to create a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint shall be created
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onCreateBreakpoint(int anEntryReference, Endpoint anEndpoint);

	/**
	 * Called when a client wants to remove a breakpoint.
	 * 
	 * @param anEntryReference
	 *            the entry at which the breakpoint shall be removed
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint);

	/**
	 * Called when an update for a variable was received from a master.
	 * 
	 * @param aVariableName
	 *            the name of the variable
	 * @param aValue
	 *            the new value
	 */
	void onVariableUpdateRetrieval(String aVariableName, Serializable aValue);

}
