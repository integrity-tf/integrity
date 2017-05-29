/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.providers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.gebit.integrity.providers.TestResource;
import de.gebit.integrity.providers.TestResourceProvider;

/**
 * A {@link AbstractCompoundTestResourceProvider} wraps one or multiple other {@link TestResourceProvider} instances.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractCompoundTestResourceProvider implements TestResourceProvider {

	/**
	 * The resource providers wrapped by this compound provider.
	 */
	private List<TestResourceProvider> resourceProviders;

	/**
	 * Creates a new compound provider, wrapping the given resource providers.
	 * 
	 * @param someProviders
	 *            the providers to wrap
	 */
	protected AbstractCompoundTestResourceProvider(List<TestResourceProvider> someProviders) {
		resourceProviders = someProviders;
	}

	/**
	 * Creates a new compound provider, wrapping the given resource providers.
	 * 
	 * @param someProviders
	 *            the providers to wrap
	 */
	protected AbstractCompoundTestResourceProvider(TestResourceProvider... someProviders) {
		resourceProviders = new ArrayList<>(someProviders.length);
		for (TestResourceProvider tempProvider : someProviders) {
			resourceProviders.add(tempProvider);
		}
	}

	@Override
	public TestResource[] getResourceNames() {
		List<TestResource> tempResourceNames = new ArrayList<TestResource>();
		HashSet<TestResource> tempDuplicateDetection = new HashSet<TestResource>();

		for (TestResourceProvider tempProvider : resourceProviders) {
			for (TestResource tempResourceName : tempProvider.getResourceNames()) {
				if (!tempDuplicateDetection.contains(tempResourceName)) {
					tempResourceNames.add(tempResourceName);
					tempDuplicateDetection.add(tempResourceName);
				}
			}
		}

		return tempResourceNames.toArray(new TestResource[0]);
	}

	@Override
	public InputStream openResource(TestResource aResourceName) throws IOException {
		if (resourceProviders.contains(aResourceName.getProvider())) {
			return aResourceName.getProvider().openResource(aResourceName);
		}

		return null;
	}

	@Override
	public void closeResource(TestResource aResourceName, InputStream aResourceStream) throws IOException {
		if (resourceProviders.contains(aResourceName.getProvider())) {
			aResourceName.getProvider().closeResource(aResourceName, aResourceStream);
		}
	}

	@Override
	public ClassLoader getClassLoader() {
		List<ClassLoader> tempUniqueClassLoader = new ArrayList<ClassLoader>();

		for (TestResourceProvider tempProvider : resourceProviders) {
			ClassLoader tempLoader = tempProvider.getClassLoader();
			if (!tempUniqueClassLoader.contains(tempLoader)) {
				tempUniqueClassLoader.add(tempLoader);
			}
		}

		if (tempUniqueClassLoader.size() == 1) {
			return tempUniqueClassLoader.get(0);
		} else {
			throw new RuntimeException("Using multiple different classloaders is not supported right now - "
					+ "the classloaders of all wrapped resource providers must be the same!");
		}
	}

	/**
	 * Finds a specific provider instance by its type.
	 * 
	 * @param aProviderClass
	 *            the providers' class
	 * @return the first instance matching the type
	 */
	@SuppressWarnings("unchecked")
	protected <T extends TestResourceProvider> T findProvider(Class<T> aProviderClass) {
		for (TestResourceProvider tempProvider : resourceProviders) {
			if (aProviderClass.isAssignableFrom(tempProvider.getClass())) {
				return (T) tempProvider;
			}
		}

		return null;
	}
}
