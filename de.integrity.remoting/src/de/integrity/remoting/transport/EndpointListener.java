package de.integrity.remoting.transport;

public interface EndpointListener {

	public void onConnectionLost(Endpoint anEndpoint);

	public void onClosed(Endpoint anEndpoint);

}
