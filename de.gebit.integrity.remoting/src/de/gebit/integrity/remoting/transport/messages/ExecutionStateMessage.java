/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.transport.enums.ExecutionStates;

/**
 * Sent to inform clients about changes in the execution state.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ExecutionStateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 3437600335397554935L;

	/**
	 * The new execution state.
	 */
	private ExecutionStates state;

	/**
	 * Creates a new message.
	 * 
	 * @param aState
	 *            the new execution state
	 */
	public ExecutionStateMessage(ExecutionStates aState) {
		state = aState;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public ExecutionStateMessage() {
		// no-arg constructor
	}

	public ExecutionStates getState() {
		return state;
	}

}
