/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.exceptions;

/**
 * Checked exception to throw if a method has not been found. This is designed to be a counterpart for
 * {@link ClassNotFoundException}, just covering methods instead of classes.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class MethodNotFoundException extends Exception {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 8398390164013254741L;

	/**
	 * Creates an instance.
	 */
	public MethodNotFoundException() {
		super();
	}

	/**
	 * Creates an instance.
	 */
	public MethodNotFoundException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	/**
	 * Creates an instance.
	 */
	public MethodNotFoundException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates an instance.
	 */
	public MethodNotFoundException(Throwable aCause) {
		super(aCause);
	}

}
