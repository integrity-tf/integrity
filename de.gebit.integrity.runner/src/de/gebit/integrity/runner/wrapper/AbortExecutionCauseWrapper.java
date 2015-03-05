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
 *
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class AbortExecutionCauseWrapper {

	private String message;

	private String stackTrace;

	public AbortExecutionCauseWrapper(String aMessage, String aStackTrace) {
		message = aMessage;
		stackTrace = aStackTrace;
	}

	public AbortExecutionCauseWrapper(AbortExecutionException anException) {
		message = anException.getMessage();
		stackTrace = generateExceptionStackTrace(anException);
	}

	public String getMessage() {
		return message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public static String generateExceptionStackTrace(Throwable anException) {
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
