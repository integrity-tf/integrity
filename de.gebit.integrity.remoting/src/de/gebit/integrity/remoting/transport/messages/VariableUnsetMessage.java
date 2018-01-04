/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * This message is used to synchronize variables between master and forks.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class VariableUnsetMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -7802254994567353008L;

	/**
	 * The variable name.
	 */
	private String name;

	/**
	 * Creates a new instance.
	 * 
	 * @param aName
	 *            the variable name
	 */
	public VariableUnsetMessage(String aName) {
		super();
		name = aName;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public VariableUnsetMessage() {
		// no-arg constructor
	}

	public String getName() {
		return name;
	}

}
