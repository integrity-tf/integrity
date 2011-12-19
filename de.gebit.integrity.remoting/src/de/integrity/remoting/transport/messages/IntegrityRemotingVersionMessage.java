package de.integrity.remoting.transport.messages;

public class IntegrityRemotingVersionMessage extends AbstractMessage {

	private static final long serialVersionUID = 4634244886123764595L;

	private int protocolMajorVersion;

	private int protocolMinorVersion;

	private int majorVersion;

	private int minorVersion;

	private int patchVersion;

	private int buildVersion;

	public IntegrityRemotingVersionMessage(int protocolMajorVersion, int protocolMinorVersion, int majorVersion,
			int minorVersion, int patchVersion, int buildVersion) {
		super();
		this.protocolMajorVersion = protocolMajorVersion;
		this.protocolMinorVersion = protocolMinorVersion;
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.patchVersion = patchVersion;
		this.buildVersion = buildVersion;
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
