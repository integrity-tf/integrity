/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.util.List;

import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.remoting.entities.setlist.SetList;

/**
 * This message is sent to a fork before any test execution is started. It sets up the fork with all test scripts and
 * the current set list state from the master.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ForkSetupMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 9085447162313872124L;

	/**
	 * The parsed test scripts.
	 */
	private List<Model> testScripts;

	/**
	 * The current setlist.
	 */
	private SetList setList;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the new setlist
	 */
	public ForkSetupMessage(List<Model> someTestScripts, SetList aSetList) {
		testScripts = someTestScripts;
		setList = aSetList;
	}

	public List<Model> getTestScripts() {
		return testScripts;
	}

	public SetList getSetList() {
		return setList;
	}

}
