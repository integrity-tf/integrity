/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.entities.setlist;

/**
 * Result states for set list entries.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum SetListEntryResultStates {

	/**
	 * The test/call has not yet been executed and is thus undetermined.
	 */
	UNKNOWN,

	/**
	 * The test/call has been finished successfully.
	 */
	SUCCESSFUL,

	/**
	 * The test has failed.
	 */
	FAILED,

	/**
	 * An exception has occurred.
	 */
	EXCEPTION;

	/**
	 * Returns true if the result state is considered "unsuccessful".
	 * 
	 * @return
	 */
	public boolean isUnsuccessful() {
		return this == FAILED || this == EXCEPTION;
	}

}
