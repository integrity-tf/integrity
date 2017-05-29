/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.io.Serializable;

import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;

/**
 * This message is used to send callback-specific data from callbacks run in forks to the main test runner.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestRunnerCallbackMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 8068146517375998550L;

	/**
	 * The name of the callback class that sent this message.
	 */
	private String callbackClassName;

	/**
	 * The method that created this message.
	 */
	private TestRunnerCallbackMethods callbackMethod;

	/**
	 * The payload.
	 */
	private Serializable[] objects;

	/**
	 * Creates a new instance.
	 * 
	 * @param aCallbackClassName
	 *            the callbacks' class name
	 * @param aCallbackMethod
	 *            the method that created this message
	 * @param someObjects
	 *            the payload
	 */
	public TestRunnerCallbackMessage(String aCallbackClassName, TestRunnerCallbackMethods aCallbackMethod,
			Serializable[] someObjects) {
		callbackClassName = aCallbackClassName;
		callbackMethod = aCallbackMethod;
		objects = someObjects;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public TestRunnerCallbackMessage() {
		// no-arg constructor
	}

	public String getCallbackClassName() {
		return callbackClassName;
	}

	public TestRunnerCallbackMethods getCallbackMethod() {
		return callbackMethod;
	}

	public Serializable[] getObjects() {
		return objects;
	}

}
