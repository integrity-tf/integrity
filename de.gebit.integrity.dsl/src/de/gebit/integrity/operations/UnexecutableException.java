/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations;

/**
 * This exception is thrown if an operation cannot be executed (usually because it depends on variables which are
 * not resolvable because no variable map was given).
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class UnexecutableException extends Exception {

	/**
	 * The serialization version.
	 */
	private static final long serialVersionUID = -6492533441071927015L;

	/**
	 * Instantiates a new unexecutable exception.
	 */
	public UnexecutableException() {
		super();
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aMessage
	 *            the a message
	 * @param aCause
	 *            the a cause
	 */
	public UnexecutableException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aMessage
	 *            the a message
	 */
	public UnexecutableException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Instantiates a new unexecutable exception.
	 * 
	 * @param aCause
	 *            the a cause
	 */
	public UnexecutableException(Throwable aCause) {
		super(aCause);
	}

}