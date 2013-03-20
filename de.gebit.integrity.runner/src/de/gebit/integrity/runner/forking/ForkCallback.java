/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

/**
 * Callback to deliver events from a fork to the parent.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ForkCallback {

	/**
	 * If the fork sets variables, it will sync them to the parent using this method.
	 * 
	 * @param aQualifiedVariableName
	 *            the variable name
	 * @param aValue
	 *            the new value
	 * @param aDoSendUpdateFlag
	 *            whether updates should be distributed to other remoting clients
	 */
	void onSetVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag);

	/**
	 * Called when the fork exits.
	 * 
	 * @param aFork
	 *            the fork
	 */
	void onForkExit(Fork aFork);

}
