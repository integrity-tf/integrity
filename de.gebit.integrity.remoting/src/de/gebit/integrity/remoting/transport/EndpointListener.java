package de.gebit.integrity.remoting.transport;

/**
 * Implement this listener to be notified about changes to an endpoints' connection state.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public interface EndpointListener {

	/**
	 * The endpoint has unexpectedly lost the connection.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onConnectionLost(Endpoint anEndpoint);

	/**
	 * The endpoints' connection has been closed.
	 * 
	 * @param anEndpoint
	 *            the endpoint
	 */
	void onClosed(Endpoint anEndpoint);

}
