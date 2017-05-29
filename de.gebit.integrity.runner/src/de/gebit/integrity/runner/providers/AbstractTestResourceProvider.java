/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.providers;

import java.util.HashSet;
import java.util.Set;

import de.gebit.integrity.providers.TestResource;
import de.gebit.integrity.providers.TestResourceProvider;

/**
 * Base class for test resource providers. Provides some convenience base implementations.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractTestResourceProvider implements TestResourceProvider {

	/**
	 * The default suffix indicating a file is an Integrity test file.
	 */
	public static final String INTEGRITY_TEST_FILES_SUFFIX = ".integrity";

	/**
	 * The classloader to use while linking the parsed resources.
	 */
	private transient ClassLoader classLoader = getClass().getClassLoader();

	public void setClassLoader(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	@Override
	public ClassLoader getClassLoader() {
		return classLoader;
	}

	/**
	 * The resources in this provider. This abstract class supports an "early-evaluation" model: resources are
	 * discovered and added early, before they're actually requested.
	 */
	protected Set<TestResource> resourceFiles = new HashSet<TestResource>();

	@Override
	public TestResource[] getResourceNames() {
		return resourceFiles.toArray(new TestResource[0]);
	}

	/**
	 * Adds a given resource to the {@link #resourceFiles}.
	 * 
	 * @param aResource
	 *            the resource to add
	 */
	protected void addResource(TestResource aResource) {
		resourceFiles.add(aResource);
	}

	/**
	 * Convenience method to create a new {@link TestResource} instance wrapping a certain test resource name.
	 * 
	 * @param aResourceName
	 *            the resource name to wrap
	 * @return the resource instance
	 */
	protected TestResource createResource(String aResourceName) {
		return new TestResource(aResourceName, this);
	}

	/**
	 * Convenience method to create and add a new {@link TestResource}.
	 * 
	 * @param aResourceName
	 *            the resource name to wrap
	 */
	protected void createAndAddResource(String aResourceName) {
		addResource(createResource(aResourceName));
	}

}
