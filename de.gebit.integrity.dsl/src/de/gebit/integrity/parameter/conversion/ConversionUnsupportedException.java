/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

/**
 * Thrown if a certain requested conversion is not supported, because no matching {@link Conversion} was found.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConversionUnsupportedException extends ConversionException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 666385391912314000L;

	/**
	 * Instantiates a new conversion unsupported exception.
	 * 
	 * @param aSourceType
	 *            the a source type
	 * @param aTargetType
	 *            the a target type
	 * @param aMessage
	 *            the a message
	 * @param aCause
	 *            the a cause
	 */
	public ConversionUnsupportedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage, Throwable aCause) {
		super(aSourceType, aTargetType, aMessage, aCause);
	}

	/**
	 * Instantiates a new conversion unsupported exception.
	 * 
	 * @param aSourceType
	 *            the a source type
	 * @param aTargetType
	 *            the a target type
	 * @param aMessage
	 *            the a message
	 */
	public ConversionUnsupportedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage) {
		super(aSourceType, aTargetType, aMessage);
	}

	@Override
	public String getMessage() {
		return "Unsupported conversion: " + super.getMessage();
	}

}
