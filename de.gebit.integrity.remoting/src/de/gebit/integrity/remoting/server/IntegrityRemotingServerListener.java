package de.gebit.integrity.remoting.server;

import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

public interface IntegrityRemotingServerListener {

	public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	public void onConnectionLost(Endpoint anEndpoint);

	public void onSetListRequest(Endpoint anEndpoint);

	public void onRunCommand(Endpoint anEndpoint);

	public void onPauseCommand(Endpoint anEndpoint);

	public void onStepIntoCommand(Endpoint anEndpoint);

	public void onCreateBreakpoint(int anEntryReference, Endpoint anEndpoint);

	public void onRemoveBreakpoint(int anEntryReference, Endpoint anEndpoint);

}
