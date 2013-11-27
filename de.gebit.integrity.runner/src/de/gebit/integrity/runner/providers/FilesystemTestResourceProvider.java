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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * A resource provider which reads test files from the filesystem, either from one or more flat directories or
 * optionally in a recursive way.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FilesystemTestResourceProvider extends AbstractTestResourceProvider {

	/**
	 * The classloader to use while linking the parsed resources.
	 */
	private ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * Adds the given resource recursively, that is if it is a directory all enclosed directories and files are
	 * recursively included as well.
	 * 
	 * @param aResourceFile
	 *            Resource to be added.
	 */
	public void addRecursively(File aResourceFile) {
		if (!aResourceFile.exists()) {
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
	 * Adds the given resources recursively, that is if one of them is a directory all enclosed directories and files of
	 * it are recursively included as well.
	 * 
	 * @param someResourceFiles
	 *            Resources to be added.
	 */
	public void addAllRecursively(Collection<? extends File> someResourceFiles) {
		for (File tempResourceFile : someResourceFiles) {
			addRecursively(tempResourceFile);
		}
	}

	/**
	 * Adds the given resource if it is a file.
	 * 
	 * @param aResourceFile
	 */
	public void addFile(File aResourceFile) {
		if (!aResourceFile.exists()) {
			return;
		}
		if (!aResourceFile.isFile()) {
			return;
		}
		if (!aResourceFile.getName().toLowerCase().endsWith(INTEGRITY_TEST_FILES_SUFFIX)) {
			return;
		}
		createAndAddResource(aResourceFile.getAbsolutePath());
	}

	@Override
	public InputStream openResource(TestResource aResourceName) {
		if (resourceFiles.contains(aResourceName)) {
			try {
				return new FileInputStream(new File(aResourceName.getName()));
			} catch (FileNotFoundException exc) {
				exc.printStackTrace();
				return null;
			}
		}

		return null;
	}

	@Override
	public void closeResource(TestResource aResourceName, InputStream aResourceStream) throws IOException {
		aResourceStream.close();
	}

	public void setClassLoader(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	@Override
	public ClassLoader getClassLoader() {
		return classLoader;
	}

}
