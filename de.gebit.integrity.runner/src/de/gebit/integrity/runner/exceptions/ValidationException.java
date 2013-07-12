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
 *
 *
 * @author YOUR_NAME_HERE - initial API and implementation
 *
 */
public class ValidationException extends RuntimeException {
	private final ICompositeNode node;


	/**
	 * @param message
	 */
	public ValidationException(String aMessage) {
		super(aMessage);
		node = null;
	}

	/**
	 * @param cause
	 */
	public ValidationException(Throwable aCause) {
		super(aCause);
		node = null;
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public ValidationException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
		node = null;
	}
	
	
	public ValidationException(String aMessage, ICompositeNode aNode) {
		super(aMessage);
		node = aNode;
	}
	
	
	public ValidationException(Throwable aCause, ICompositeNode aNode) {
		super(aCause);
		node = aNode;
	}
	
	
	public ValidationException(String aMessage, Throwable aCause, ICompositeNode aNode) {
		super(aMessage, aCause);
		node = aNode;
	}
}
