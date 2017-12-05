/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.wrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import de.gebit.integrity.exceptions.AbortExecutionException;

/**
 * This wrapper is used to store the information from an exception like {@link AbortExecutionException}. The exception
 * cannot be transmitted over the remoting, since it cannot be guaranteed to match between versions for serialization
 * purposes. Instead, the important information is extracted out of it and wrapped inside this object.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ExceptionWrapper {

	/**
	 * The message.
	 */
	private String message;

	/**
	 * The stack trace (as a string).
	 */
	private String stackTrace;

	/**
	 * Creates an instance from the raw data.
	 * 
	 * @param aMessage
	 *            the message
	 * @param aStackTrace
	 *            the stack trace string
	 */
	public ExceptionWrapper(String aMessage, String aStackTrace) {
		message = aMessage;
		stackTrace = aStackTrace;
	}

	/**
	 * Creates an instance from the exception itself.
	 * 
	 * @param anException
	 *            the exception to use as a base
	 */
	public ExceptionWrapper(Throwable anException) {
		message = anException.getMessage();
		stackTrace = generateExceptionStackTrace(anException);
	}

	public String getMessage() {
		return message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	private static String generateExceptionStackTrace(Throwable anException) {
		StringWriter tempStringWriter = null;
		PrintWriter tempPrintWriter = null;
		try {
			tempStringWriter = new StringWriter();
			tempPrintWriter = new PrintWriter(tempStringWriter);
			anException.printStackTrace(tempPrintWriter);
			return tempStringWriter.toString();
		} finally {
			try {
				if (tempPrintWriter != null) {
					tempPrintWriter.close();
				}
				if (tempStringWriter != null) {
					tempStringWriter.close();
				}
			} catch (IOException exc) {
				// nothing to do, since this cannot happen
			}
		}
	}

}
