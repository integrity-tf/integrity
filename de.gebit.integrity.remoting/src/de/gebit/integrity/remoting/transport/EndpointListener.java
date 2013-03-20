/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport;

/**
 * Implement this listener to be notified about changes to an endpoints' connection state.
 * 
 * @author Rene Schneider - initial API and implementation
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
