/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting;

/**
 * Some constant values used by the remoting client and server.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface IntegrityRemotingConstants {

	/**
	 * The major part of the protocol version. Major version changes mandate an incompatibility to other major versions.
	 */
	int MAJOR_PROTOCOL_VERSION = 0;

	/**
	 * The minor part of the protocol version.
	 */
	int MINOR_PROTOCOL_VERSION = 1;

	/**
	 * The major part of the remoting client/server version.
	 */
	int MAJOR_VERSION = 0;

	/**
	 * The minor part of the remoting client/server version.
	 */
	int MINOR_VERSION = 1;

	/**
	 * The patch part of the remoting client/server version.
	 */
	int PATCH_VERSION = 0;

	/**
	 * The build part of the remoting client/server version.
	 */
	int BUILD_VERSION = 0;

	/**
	 * The default port number.
	 */
	int DEFAULT_PORT = 43526;

}
