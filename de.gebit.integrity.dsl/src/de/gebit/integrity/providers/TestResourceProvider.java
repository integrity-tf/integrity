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

/**
 * A test resource provider is used by the test runner to enumerate and retrieve the necessary resources, which are then
 * parsed and linked into the test model. The classloader to use for resolving any Java references is also provided by
 * the resource provider.
 * <p>
 * Test resource providers must be thread-safe with regard to all methods defined in {@link TestResourceProvider}, as
 * they are used in multi-threaded script loading, in which resources are opened and closed in parallel!
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface TestResourceProvider {

	/**
	 * Returns all known resource names.
	 * 
	 * @return
	 */
	TestResource[] getResourceNames();

	/**
	 * Opens a specific named resource. This should return an {@link InputStream} at the start of the data of the
	 * respective resources, and it is only expected to work if the resource is one of those enumerated by a call to
	 * {@link #getResourceNames()}.
	 * 
	 * @param aResourceName
	 *            the resource to be opened
	 * @return an {@link InputStream} to read the resource
	 * @throws IOException
	 */
	InputStream openResource(TestResource aResourceName) throws IOException;

	/**
	 * Closes a specified resources' stream (and all the stuff opened for this stream in the background).
	 * 
	 * @param aResourceName
	 *            the resource to be closed
	 * @param aResourceStream
	 *            the resource stream to close
	 * @throws IOException
	 */
	void closeResource(TestResource aResourceName, InputStream aResourceStream) throws IOException;

	/**
	 * Returns the classloader to use for all dynamic class resolving needs.
	 * 
	 * @return the classloader to use
	 */
	ClassLoader getClassLoader();

}
