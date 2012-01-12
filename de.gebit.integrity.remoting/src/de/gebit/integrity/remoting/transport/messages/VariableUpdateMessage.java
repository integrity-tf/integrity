/**
 * 
 */
package de.gebit.integrity.remoting.transport.messages;

import java.io.Serializable;

/**
 * This message is used to synchronize variables between master and forks.
 * 
 * @author Rene Schneider
 * 
 */
public class VariableUpdateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -7802254994567353008L;

	/**
	 * The variable name.
	 */
	private String name;

	/**
	 * The variable value.
	 */
	private Serializable value;

	/**
	 * Creates a new instance.
	 * 
	 * @param aName
	 *            the variable name
	 * @param aValue
	 *            the variable value
	 */
	public VariableUpdateMessage(String aName, Serializable aValue) {
		super();
		name = aName;
		value = aValue;
	}

	public String getName() {
		return name;
	}

	public Serializable getValue() {
		return value;
	}

}
