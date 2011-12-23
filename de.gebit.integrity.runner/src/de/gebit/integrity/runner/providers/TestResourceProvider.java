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

	String[] getResourceNames();

	InputStream openResource(String aResourceName);

	ClassLoader getClassLoader();

}
