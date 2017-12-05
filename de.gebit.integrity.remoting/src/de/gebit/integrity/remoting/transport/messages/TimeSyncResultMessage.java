/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * A response to {@link TimeSyncRequestMessage}.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSyncResultMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 2543255984131293038L;

	/**
	 * In case of errors during time sync, this contains the error message. If null, time sync is assumed to be
	 * successful.
	 */
	private String errorMessage;

	/**
	 * In case of errors during time sync, this contains the stack trace. Can only be non-null if {@link #errorMessage}
	 * is non-null.
	 */
	private String stackTrace;

	/**
	 * Constructor.
	 */
	public TimeSyncResultMessage() {
		// no-arg constructor
	}

	/**
	 * Constructs an instance.
	 * 
	 * @param aStartDate
	 * @param aProgressionFactor
	 */
	public TimeSyncResultMessage(String anErrorMessage, String aStackTrace) {
		errorMessage = anErrorMessage;
		stackTrace = aStackTrace;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

}
