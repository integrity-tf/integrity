/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.exceptions;

/**
 * This exception is thrown in various situations which "should never happen", that is, situations in which all other
 * execution paths should technically cover all possible alternatives, but one cannot mathematically guarantee that this
 * is actually the case, or in which future extensions might open up new code paths not detectable by Eclipse. Throwing
 * this exception might not be the best solution; guaranteeing that all paths are covered is always better, but
 * sometimes that's just not possible.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ThisShouldNeverHappenException extends IllegalStateException {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 8591527326536869557L;

	/**
	 * The standard constructor. If you don't really need to customize the message, just use this one.
	 */
	public ThisShouldNeverHappenException() {
		super("Congratulations - you have reached a state that should have been impossible to reach! "
				+ "This is most likely a serious bug in Integrity, please report it so it can be fixed.");
	}

	/**
	 * A constructor for a custom message.
	 * 
	 * @param aMessage
	 *            the message
	 */
	public ThisShouldNeverHappenException(String aMessage) {
		super(aMessage);
	}

}
