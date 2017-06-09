/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.util.List;
import java.util.Map;

import de.gebit.integrity.providers.TestResourceProvider;
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
	 * The test script resource providers that are to be loaded by the fork.
	 */
	private List<? extends TestResourceProvider> resourceProviders;

	/**
	 * The current setlist.
	 */
	private SetList setList;

	/**
	 * All initial variables and constants to set on the fork.
	 */
	private Map<String, Object> initialVariables;

	/**
	 * The total number of suite invocations that this fork will have to perform. Used as a means to allow the fork to
	 * quickly terminate execution when it's done with its work.
	 */
	private int numberOfSuiteInvocations;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the new setlist
	 */
	public ForkSetupMessage(List<? extends TestResourceProvider> someResourceProviders, SetList aSetList,
			Map<String, Object> someInitialVariables, int aNumberOfSuiteInvocations) {
		resourceProviders = someResourceProviders;
		setList = aSetList;
		initialVariables = someInitialVariables;
		numberOfSuiteInvocations = aNumberOfSuiteInvocations;
	}

	/**
	 * The no-arg constructor, primarily used for serialization.
	 */
	public ForkSetupMessage() {
		// no-arg constructor
	}

	public List<? extends TestResourceProvider> getResourceProviders() {
		return resourceProviders;
	}

	public SetList getSetList() {
		return setList;
	}

	public Map<String, Object> getInitialVariables() {
		return initialVariables;
	}

	public int getNumberOfSuiteInvocations() {
		return numberOfSuiteInvocations;
	}

}
