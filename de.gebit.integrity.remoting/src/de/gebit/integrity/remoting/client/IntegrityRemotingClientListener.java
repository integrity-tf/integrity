package de.gebit.integrity.remoting.client;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

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
