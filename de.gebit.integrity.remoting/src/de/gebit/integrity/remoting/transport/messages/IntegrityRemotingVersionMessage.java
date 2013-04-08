/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is used to transmit the version of the remoting protocol as well as the software version. It should
 * ideally NEVER be changed (hopefully there's never a need to), because the client and server may use the protocol
 * version to determine if they are compatible at all. This message is always the first one sent from both sides in a
 * communication.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityRemotingVersionMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 4634244886123764595L;

	/**
	 * The major version of the protocol. A major version change signifies incompatibility.
	 */
	private int protocolMajorVersion;

	/**
	 * The minor version of the protocol. A minor change should keep compatibility to other minor versions as long as
	 * the same major version is used.
	 */
	private int protocolMinorVersion;

	/**
	 * The major part of the software version.
	 */
	private int majorVersion;

	/**
	 * The minor part of the software version.
	 */
	private int minorVersion;

	/**
	 * The patch part of the software version.
	 */
	private int patchVersion;

	/**
	 * The build part of the software version.
	 */
	private int buildVersion;

	/**
	 * Creates a new message instance.
	 * 
	 * @param aProtocolMajorVersion
	 *            the major protocol version number
	 * @param aProtocolMinorVersion
	 *            the minor protocol version number
	 * @param aMajorVersion
	 *            the major software version part
	 * @param aMinorVersion
	 *            the minor software version part
	 * @param aPatchVersion
	 *            the patch software version part
	 * @param aBuildVersion
	 *            the build software version part
	 */
	public IntegrityRemotingVersionMessage(int aProtocolMajorVersion, int aProtocolMinorVersion, int aMajorVersion,
			int aMinorVersion, int aPatchVersion, int aBuildVersion) {
		super();
		this.protocolMajorVersion = aProtocolMajorVersion;
		this.protocolMinorVersion = aProtocolMinorVersion;
		this.majorVersion = aMajorVersion;
		this.minorVersion = aMinorVersion;
		this.patchVersion = aPatchVersion;
		this.buildVersion = aBuildVersion;
	}

	public int getProtocolMajorVersion() {
		return protocolMajorVersion;
	}

	public int getProtocolMinorVersion() {
		return protocolMinorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getPatchVersion() {
		return patchVersion;
	}

	public int getBuildVersion() {
		return buildVersion;
	}

}
