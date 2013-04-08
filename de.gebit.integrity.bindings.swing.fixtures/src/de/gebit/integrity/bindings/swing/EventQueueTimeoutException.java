/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

/**
 * Thrown if the {@link EventQueueSynchronizer} has hit a timeout. The queue was not finished processing all events
 * until the given time has elapsed.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class EventQueueTimeoutException extends Exception {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -3382642663497141811L;

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            the error message
	 */
	public EventQueueTimeoutException(String aMessage) {
		super(aMessage);
	}

}
