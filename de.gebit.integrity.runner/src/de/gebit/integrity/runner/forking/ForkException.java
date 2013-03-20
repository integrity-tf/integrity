/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

/**
 * Thrown if forking failed.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ForkException extends Exception {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 8054739284988979101L;

	/**
	 * Creates a new instance.
	 */
	public ForkException() {
		super();
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 */
	public ForkException(Throwable aCause) {
		super(aCause);
	}

}
