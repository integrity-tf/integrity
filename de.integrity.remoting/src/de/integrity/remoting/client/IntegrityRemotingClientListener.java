package de.integrity.remoting.client;

import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.enums.ExecutionStates;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

public interface IntegrityRemotingClientListener {

	public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	public void onConnectionLost(Endpoint anEndpoint);

	public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint);

	public void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint);

	public void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	public void onSetListUpdate(SetListEntry[] someUpdatedEntries, Integer anEntryInExecution, Endpoint anEndpoint);

	public void onConfirmCreateBreakpoint(int anEntryReference, Endpoint anEndpoint);

	public void onConfirmRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint);

}
