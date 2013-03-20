/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console.intercept;

/**
 * Performs interception of both console output streams (stdout and stderr). The implementation of this interface is
 * responsible for the actual capture, including splitting data into lines and sending those lines to a number of
 * targets. Since this service knows the real console output streams, it can be used to print strings on the real
 * streams, whether they are being intercepted or not.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ConsoleOutputInterceptor {

	/**
	 * Registers a target for intercepted data.
	 * 
	 * @param aTarget
	 *            the target to register
	 */
	void registerTarget(ConsoleInterceptorTarget aTarget);

	/**
	 * Unregisters a registered target.
	 * 
	 * @param aTarget
	 *            the target to unregister
	 */
	void unregisterTarget(ConsoleInterceptorTarget aTarget);

	/**
	 * Prints a line on the original System.err stream, including an added newline. Automatically flushes the stream.
	 * 
	 * @see java.io.PrintWriter#println(String)
	 * @param aLine
	 *            the line
	 */
	void printlnStdErr(String aLine);

	/**
	 * Prints text on the original System.err stream.
	 * 
	 * @see java.io.PrintWriter#print(String)
	 * @param aText
	 *            the text to print
	 */
	void printStdErr(String aText);

	/**
	 * Prints a line on the original System.out stream, including an added newline. Automatically flushes the stream.
	 * 
	 * @see java.io.PrintWriter#println(String)
	 * @param aLine
	 *            the line
	 */
	void printlnStdOut(String aLine);

	/**
	 * Prints text on the original System.out stream.
	 * 
	 * @see java.io.PrintWriter#print(String)
	 * @param aText
	 *            the text to print
	 */
	void printStdOut(String aText);

}
