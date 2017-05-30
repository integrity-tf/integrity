/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.providers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import de.gebit.integrity.providers.TestResource;
import de.gebit.integrity.providers.TestResourceProvider;

/**
 * This test resource provider holds the entire resources in memory and returns them from memory on demand. It is
 * intended to be used to create fully self-sufficient clones of other resource providers (that typically just enumerate
 * resources from external sources and load them on demand) which can then be transferred over the remoting connection
 * to forks.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class InMemoryTestResourceProvider implements TestResourceProvider {

	/**
	 * The map containing all resources' data.
	 */
	private LinkedHashMap<String, byte[]> resourceMap = new LinkedHashMap<>();

	/**
	 * The classloader to use while linking the parsed resources. This is transient here because the class is intended
	 * to be sent via Remoting, and we cannot send the classloader.
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
	 * Default constructor for serialization.
	 */
	public InMemoryTestResourceProvider() {
		// empty default no-arg constructor
	}

	/**
	 * Creates a new instance that acts as an in-memory copy of the given resource provider.
	 * 
	 * @param aSourceProvider
	 *            the provider that is to be copied
	 * @param aNamePrefix
	 *            a prefix to be added to all resource names on copy (if null, nothing is added)
	 * @throws IOException
	 */
	public InMemoryTestResourceProvider(TestResourceProvider aSourceProvider, String aNamePrefix) throws IOException {
		for (TestResource tempResource : aSourceProvider.getResourceNames()) {
			String tempNewName = tempResource.getName();
			if (aNamePrefix != null) {
				tempNewName = aNamePrefix + tempNewName;
			}

			InputStream tempIn = aSourceProvider.openResource(tempResource);

			try {
				byte[] tempBuffer = new byte[4096];
				int tempInitialSize = tempIn.available();
				if (tempInitialSize <= 0 || tempInitialSize >= 1048576) {
					tempInitialSize = 1048576;
				}
				ByteArrayOutputStream tempOut = new ByteArrayOutputStream(tempInitialSize);

				int tempCount = 0;
				do {
					tempCount = tempIn.read(tempBuffer);
					if (tempCount > 0) {
						tempOut.write(tempBuffer, 0, tempCount);
					}
				} while (tempCount >= 0);

				resourceMap.put(tempNewName, tempOut.toByteArray());
			} finally {
				aSourceProvider.closeResource(tempResource, tempIn);
			}
		}
	}

	@Override
	public TestResource[] getResourceNames() {
		List<TestResource> tempList = new ArrayList<>(resourceMap.size());

		// The ordering of this set is guaranteed to be the insertion order by the used LinkedHashMap
		for (String tempKey : resourceMap.keySet()) {
			tempList.add(new TestResource(tempKey, this));
		}

		return tempList.toArray(new TestResource[tempList.size()]);
	}

	@Override
	public InputStream openResource(TestResource aResourceName) throws IOException {
		byte[] tempBuffer = resourceMap.get(aResourceName.getName());

		if (tempBuffer == null) {
			throw new IOException("Resource does not exist: " + aResourceName);
		}

		return new ByteArrayInputStream(tempBuffer);
	}

	@Override
	public void closeResource(TestResource aResourceName, InputStream aResourceStream) throws IOException {
		// We do not have do do anything here, since our resources are ByteArrayInputStreams, for which close() is no-op
	}

}
