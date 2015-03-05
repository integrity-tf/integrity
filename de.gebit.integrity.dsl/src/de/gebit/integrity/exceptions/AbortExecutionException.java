/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.exceptions;

/**
 *
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class AbortExecutionException extends RuntimeException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5513664766619688321L;

	/**
	 * Creates a new instance.
	 */
	public AbortExecutionException() {
		super();
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 * @param aCause
	 */
	public AbortExecutionException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 */
	public AbortExecutionException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aCause
	 */
	public AbortExecutionException(Throwable aCause) {
		super(aCause);
	}

}
