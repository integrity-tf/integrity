/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.providers;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;

/**
 * A {@link TestResource} represents a single entity of an Integrity test script, which can be read by a
 * {@link TestResourceProvider}. It basically consists of a unique name and provider combination.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestResource {

	/**
	 * The name of the resource.
	 */
	private String name;

	/**
	 * The resource provider.
	 */
	private TestResourceProvider provider;

	/**
	 * Creates an instance.
	 * 
	 * @param aName
	 *            the name of the resource
	 * @param aProvider
	 *            the resource provider
	 */
	public TestResource(String aName, TestResourceProvider aProvider) {
		name = aName;
		provider = aProvider;
	}

	/**
	 * No-arg constructor for serialization.
	 */
	public TestResource() {
		// empty constructor
	}

	public String getName() {
		return name;
	}

	public TestResourceProvider getProvider() {
		return provider;
	}

	/**
	 * Open the resource. This is basically a shorthand for {@link #getProvider()}.openResource().
	 * 
	 * @see {@link TestResourceProvider#openResource(TestResource)}.
	 * 
	 * @return the opened resource
	 * @throws IOException
	 */
	public InputStream openResource() throws IOException {
		return provider.openResource(this);
	}

	/**
	 * Creates an EMF-compatible platform resource {@link URI} for the current resource.
	 * 
	 * @return the URI
	 */
	public URI createPlatformResourceURI() {
		return URI.createPlatformResourceURI(name, true);
	}

	@Override
	public boolean equals(Object anOther) {
		if (!(anOther instanceof TestResource)) {
			return false;
		}

		TestResource tempOther = (TestResource) anOther;

		if ((name == null && tempOther.name != null) || !(name.equals(tempOther.name))) {
			return false;
		}
		if ((provider == null && tempOther.provider != null) || !(provider.equals(tempOther.provider))) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int tempCode = 0;
		if (name != null) {
			tempCode ^= name.hashCode();
		}
		if (provider != null) {
			tempCode ^= provider.hashCode();
		}

		return tempCode;
	}

	@Override
	public String toString() {
		return name;
	}

}
