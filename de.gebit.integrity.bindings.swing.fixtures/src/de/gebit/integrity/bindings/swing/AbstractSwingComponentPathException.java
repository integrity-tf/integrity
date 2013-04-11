/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Exception base class for exceptions concerning Swing component paths.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractSwingComponentPathException extends IntegritySwingBindingsException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -9106012024572041003L;

	/**
	 * The path.
	 */
	private String path;

	/**
	 * The string with detailed information about the error.
	 */
	private StringBuilder detailString;

	/**
	 * The component handler.
	 */
	private AbstractSwingComponentHandler componentHandler;

	/**
	 * New line char(s).
	 */
	protected static final String NEWLINE = System.getProperty("line.separator");

	/**
	 * A prefix used for detail string lines.
	 */
	protected static final String PREFIX = "      in ";

	/**
	 * Constructor.
	 * 
	 * @param aPath
	 *            the path
	 * @param aComponentHandler
	 *            the component handler
	 * @param aMessage
	 *            the message
	 */
	public AbstractSwingComponentPathException(String aPath, AbstractSwingComponentHandler aComponentHandler,
			String aMessage) {
		super(aMessage);
		path = aPath;
		componentHandler = aComponentHandler;
	}

	/**
	 * This method should create a string with detailed exception information using the provided {@link StringBuilder}.
	 * 
	 * @param aStringBuilder
	 *            the string builder to use
	 * @param aComponentHandler
	 *            the component handler instance
	 */
	protected abstract void buildDetailString(StringBuilder aStringBuilder,
			AbstractSwingComponentHandler aComponentHandler);

	public String getPath() {
		return path;
	}

	/**
	 * Gets the detail string, if available.
	 * 
	 * @return the detail info
	 */
	public String getDetailString() {
		if (detailString == null) {
			detailString = new StringBuilder();
			buildDetailString(detailString, componentHandler);
		}

		return detailString.toString();
	}

	/**
	 * Prints the stack trace. Usually {@link #printStackTrace()} does this, but since that standard functionality is
	 * overridden here, you'll need to call this method instead.
	 */
	public void printActualStackTrace() {
		super.printStackTrace();
	}

	/**
	 * Prints the stack trace. Usually {@link #printStackTrace()} does this, but since that standard functionality is
	 * overridden here, you'll need to call this method instead.
	 */
	public void printActualStackTrace(PrintStream aStream) {
		super.printStackTrace(aStream);
	}

	/**
	 * Prints the stack trace. Usually {@link #printStackTrace()} does this, but since that standard functionality is
	 * overridden here, you'll need to call this method instead.
	 */
	public void printActualStackTrace(PrintWriter aWriter) {
		super.printStackTrace(aWriter);
	}

	@Override
	public void printStackTrace() {
		printMessageAndDetails();
	}

	@Override
	public void printStackTrace(PrintStream aStream) {
		printMessageAndDetails(aStream);
	}

	@Override
	public void printStackTrace(PrintWriter aWriter) {
		printMessageAndDetails(aWriter);
	}

	/**
	 * Prints the exception message and the detail string.
	 * 
	 * @param aWriter
	 *            the writer
	 */
	public void printMessageAndDetails(PrintWriter aWriter) {
		aWriter.println(getClass().getName() + ": " + getMessage());
		aWriter.println("");
		aWriter.print(getDetailString());
	}

	/**
	 * Prints the exception message and the detail string.
	 * 
	 * @param aStream
	 *            the stream
	 */
	public void printMessageAndDetails(PrintStream aStream) {
		aStream.println(getClass().getName() + ": " + getMessage());
		aStream.println("");
		aStream.print(getDetailString());
	}

	/**
	 * Prints the exception message and the detail string to stderr.
	 */
	public void printMessageAndDetails() {
		printMessageAndDetails(System.err);
	}

}
