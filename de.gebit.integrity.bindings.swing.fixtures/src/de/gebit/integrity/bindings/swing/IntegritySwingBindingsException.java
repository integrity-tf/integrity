/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

/**
 * Base class for all special exceptions used in the Swing Bindings for Integrity.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegritySwingBindingsException extends Exception {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 3204821991129408837L;

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the message
	 * 
	 * @param aCause
	 *            the cause
	 */
	public IntegritySwingBindingsException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the message
	 */
	public IntegritySwingBindingsException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates an instance.
	 */
	public IntegritySwingBindingsException() {
		super();
	}

	/**
	 * Creates an instance.
	 * 
	 * @param aCause
	 *            the cause
	 */
	public IntegritySwingBindingsException(Throwable aCause) {
		super(aCause);
	}

}
