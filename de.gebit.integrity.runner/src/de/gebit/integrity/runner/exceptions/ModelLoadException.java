/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.exceptions;

/**
 * Basic exception for errors during model loading.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ModelLoadException extends Exception {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 2536057162116739387L;

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 */
	public ModelLoadException(String aMessage) {
		super(aMessage);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMessage
	 *            the error message
	 * @param aNestedException
	 *            the nested exception
	 */
	public ModelLoadException(String aMessage, Throwable aNestedException) {
		super(aMessage, aNestedException);
	}

}
