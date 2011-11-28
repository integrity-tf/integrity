package de.integrity.remoting.server;

import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

public interface IntegrityRemotingServerListener {

	public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint);

	public void onConnectionLost(Endpoint anEndpoint);

	public void onSetListRequest(Endpoint anEndpoint);

	public void onRunCommand(Endpoint anEndpoint);

}
