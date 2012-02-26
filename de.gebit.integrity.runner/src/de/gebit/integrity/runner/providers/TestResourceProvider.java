package de.gebit.integrity.runner.providers;

import java.io.InputStream;

/**
 * A test resource provider is used by the test runner to enumerate and retrieve the necessary resources, which are then
 * parsed and linked into the test model. The classloader to use for resolving any Java references is also provided by
 * the resource provider.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public interface TestResourceProvider {

	/**
	 * Returns all known resource names.
	 * 
	 * @return
	 */
	String[] getResourceNames();

	/**
	 * Opens a specific named resource. This should return an {@link InputStream} at the start of the data of the
	 * respective resources, and it is only expected to work if the resource is one of those enumerated by a call to
	 * {@link #getResourceNames()}.
	 * 
	 * @param aResourceName
	 *            the resource to be opened
	 * @return an {@link InputStream} to read the resource
	 */
	InputStream openResource(String aResourceName);

	/**
	 * Returns the classloader to use for all dynamic class resolving needs.
	 * 
	 * @return the classloader to use
	 */
	ClassLoader getClassLoader();

}
