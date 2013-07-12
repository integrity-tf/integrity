/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.exceptions;

import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * Validiation exception which indicates a validation result where progressing should not continue.
 * @author tilois - initial API and implementation
 */
public class ValidationException extends RuntimeException {
	/** Serial UUID. */
	private static final long serialVersionUID = 1L;

	/** Origin of the validation error. */
	private final ICompositeNode originNode;


	/**
	 * Creates a validation exception with the given message.
	 * @param aMessage Message for the validation exception.
	 */
	public ValidationException(String aMessage) {
		super(aMessage);
		originNode = null;
	}

	/**
	 * Creates a validation exception with the given cause.
	 * @param aCause Cause of the validation exception.
	 */
	public ValidationException(Throwable aCause) {
		super(aCause);
		originNode = null;
	}
	
	/**
	 * Creates a validation exception with the given cause and message.
	 * @param aMessage Message for the validation exception.
	 * @param aCause Cause of the validation exception.
	 */
	public ValidationException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
		originNode = null;
	}
	
	/**
	 * Creates a validation exception with the given message and the the node causing the validation failure.
	 * @param aMessage Message for the validation exception.
	 * @param aNode Node causing the validation exception.
	 */
	public ValidationException(String aMessage, ICompositeNode aNode) {
		super(aMessage);
		originNode = aNode;
	}
	
	/**
	 * Creates a validation exception with the given cause and the the node causing the validation failure.
	 * @param aCause Cause of the validation exception.
	 * @param aNode Node causing the validation exception.
	 */
	public ValidationException(Throwable aCause, ICompositeNode aNode) {
		super(aCause);
		originNode = aNode;
	}
	
	
	/**
	 * Creates a validation exception with the given cause, message and the the node causing the validation failure.
	 * @param aMessage Message for the validation exception.
	 * @param aCause Cause of the validation exception.
	 * @param aNode Node causing the validation exception.
	 */
	public ValidationException(String aMessage, Throwable aCause, ICompositeNode aNode) {
		super(aMessage, aCause);
		originNode = aNode;
	}
}
