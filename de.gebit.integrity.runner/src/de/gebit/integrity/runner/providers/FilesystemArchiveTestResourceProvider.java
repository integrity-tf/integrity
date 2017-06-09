/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.providers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * This is a compound {@link de.gebit.integrity.providers.TestResourceProvider}, able to read Integrity scripts directly
 * from the file system, within a directory on the filesystem, and within archive files (and archives within archives).
 * It wraps a {@link FilesystemTestResourceProvider} and an {@link ArchiveTestResourceProvider}, which provide the
 * actual functionality.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FilesystemArchiveTestResourceProvider extends AbstractCompoundTestResourceProvider {

	/**
	 * Creates a new instance.
	 */
	public FilesystemArchiveTestResourceProvider() {
		super(new FilesystemTestResourceProvider(), new ArchiveTestResourceProvider());
	}

	/**
	 * Adds the given resource recursively, that is if it is a directory all enclosed directories and files are
	 * recursively included as well.
	 * 
	 * @param aResourceFile
	 *            Resource to be added. May be a script file, a directory, or an archive (ending on .zip or .jar)
	 * @throws IOException
	 */
	public void addRecursively(File aResourceFile) throws IOException {
		if (!aResourceFile.exists()) {
			return;
		}
		if (aResourceFile.isDirectory()) {
			for (File tempFile : aResourceFile.listFiles()) {
				addRecursively(tempFile);
			}
		} else if (aResourceFile.isFile()) {
			String tempLowerCaseName = aResourceFile.getName().toLowerCase();
			if (tempLowerCaseName.endsWith(ArchiveTestResourceProvider.ARCHIVE_ENDING_ZIP)
					|| tempLowerCaseName.endsWith(ArchiveTestResourceProvider.ARCHIVE_ENDING_JAR)) {
				addArchiveFile(aResourceFile, true);
			} else {
				addScriptFile(aResourceFile);
			}
		}
	}

	/**
	 * Adds the given resources recursively, that is if one of them is a directory all enclosed directories and files of
	 * it are recursively included as well.
	 * 
	 * @param someResourceFiles
	 *            Resources to be added.
	 * @throws IOException
	 */
	public void addAllRecursively(Collection<? extends File> someResourceFiles) throws IOException {
		for (File tempResourceFile : someResourceFiles) {
			addRecursively(tempResourceFile);
		}
	}

	/**
	 * Adds the given resource if it is a plain script file. The file will only be added if it ends with the
	 * {@link AbstractTestResourceProvider#INTEGRITY_TEST_FILES_SUFFIX} suffix!
	 * 
	 * @param aResourceFile
	 *            the resource file to add
	 */
	public void addScriptFile(File aResourceFile) {
		findProvider(FilesystemTestResourceProvider.class).addFile(aResourceFile);
	}

	/**
	 * Adds the given archive file resource. This automatically adds all Integrity scripts (ending on the
	 * {@link AbstractTestResourceProvider#INTEGRITY_TEST_FILES_SUFFIX} suffix) within this archive.
	 * 
	 * @param anArchiveFile
	 *            the archive to add
	 * @param aRecursiveFlag
	 *            whether archives inside archives shall be searched too
	 * @throws IOException
	 */
	public void addArchiveFile(File anArchiveFile, boolean aRecursiveFlag) throws IOException {
		findProvider(ArchiveTestResourceProvider.class).addArchive(anArchiveFile, aRecursiveFlag);
	}

}
