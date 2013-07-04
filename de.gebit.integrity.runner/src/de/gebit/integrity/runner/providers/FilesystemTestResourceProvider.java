/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A resource provider which reads test files from the filesystem, either from one or more flat directories or
 * optionally in a recursive way.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FilesystemTestResourceProvider implements TestResourceProvider {
	/**
	 * Path which are specified but got ignored.
	 * Key is the path, the value is the reason.
	 */
	private Map<String, String> ignoredReferences = new HashMap<String, String>();

	/**
	 * The paths to the resource files.
	 */
	private Set<String> resourceFiles = new HashSet<String>();

	/**
	 * The classloader to use while linking the parsed resources.
	 */
	private ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * Adds the given resource recursively, that is if it is a directory all
	 * enclosed directories and files are recursively included as well.
	 * @param aResourceFile Resource to be added.
	 */
	public void addRecursively(File aResourceFile) {
		if (!aResourceFile.exists()) {
			ignoredReferences.put(aResourceFile.getPath(), "does not exists");
			return;
		}
		if (!aResourceFile.isDirectory()) {
			addFile(aResourceFile);
			return;
		}
		for (File tempFile : aResourceFile.listFiles()) {
			addRecursively(tempFile);
		}
	}
	
	/**
	 * Adds the given resources recursively, that is if one of them is a directory all
	 * enclosed directories and files of it are recursively included as well.
	 * @param someResourceFiles Resources to be added.
	 */
	public void addAllRecursively(Collection<? extends File> someResourceFiles) {
		for (File resourceFile : someResourceFiles) {
			addRecursively(resourceFile);
		}
	}
	
	/**
	 * Adds the given resource if it is a file.
	 * @param aResourceFile
	 */
	public void addFile(File aResourceFile) {
		if (!aResourceFile.exists()) {
			ignoredReferences.put(aResourceFile.getPath(), "does not exists");
			return;
		}
		if (!aResourceFile.isFile()) {
			ignoredReferences.put(aResourceFile.getPath(), "is no file");
			return;
		}
		if (!aResourceFile.getAbsolutePath().endsWith(".integrity")) {
			ignoredReferences.put(aResourceFile.getPath(), "is no integrity file (*.integrity)");
			return;
		}
		resourceFiles.add(aResourceFile.getAbsolutePath());
	}
	
	/**
	 * Returns all references which got ignored and returns a reason along why they got ignored.
	 * @return Ignored references with a reason.
	 */
	public Set<Entry<String, String>> getIgnoredReferencesWithReasons() {
		return ignoredReferences.entrySet();
	}
	
	/**
	 * Returns all references which got ignored.
	 * @return All references which got ignored.
	 */
	public Set<String> getIgnoredReferences() {
		return ignoredReferences.keySet();
	}
	
	/**
	 * Checks if any reference got ignored.
	 * @return <code>true</code> if any reference got ignored, <code>false</code> otherwise.
	 */
	public boolean hasIgnoredReferences() {
		return !ignoredReferences.isEmpty();
	}

	@Override
	public String[] getResourceNames() {
		return resourceFiles.toArray(new String[0]);
	}

	@Override
	public InputStream openResource(String aResourceName) {
		if (resourceFiles.contains(aResourceName)) {
			try {
				return new FileInputStream(new File(aResourceName));
			} catch (FileNotFoundException exc) {
				exc.printStackTrace();
				return null;
			}
		}

		return null;
	}

	public void setClassLoader(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	@Override
	public ClassLoader getClassLoader() {
		return classLoader;
	}

}
