package de.integrity.runner.providers;

import java.io.InputStream;

public interface TestResourceProvider {

	String[] getResourceNames();

	InputStream openResource(String aResourceName);

	ClassLoader getClassLoader();

}
