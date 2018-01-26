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
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import de.gebit.integrity.providers.TestResource;
import de.gebit.integrity.providers.TestResourceProvider;

/**
 * This {@link TestResourceProvider} can read archive files (zip/jar format) and provide the Integrity script files
 * within these archives transparently to the Test Runner. It can even read archives within archives, up to an arbitrary
 * depth.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ArchiveTestResourceProvider extends AbstractTestResourceProvider {

	/**
	 * The ending of zip archives.
	 */
	public static final String ARCHIVE_ENDING_ZIP = ".zip";

	/**
	 * The ending of jar archives.
	 */
	public static final String ARCHIVE_ENDING_JAR = ".jar";

	/**
	 * A map to keep track of opened {@link ZipInputStream}s. Used to close the streams.
	 */
	Map<InputStream, Stack<ZipInputStream>> openedResourceToStreamsMap = new Hashtable<InputStream, Stack<ZipInputStream>>();

	/**
	 * Adds an archive (all contained .integrity files) to the resource provider.
	 * 
	 * @param anArchiveFile
	 *            the archive file to add
	 * @param aRecursiveFlag
	 *            whether other archives inside this archive shall be added recursively
	 * @throws IOException
	 */
	public void addArchive(File anArchiveFile, boolean aRecursiveFlag) throws IOException {
		ZipInputStream tempZipInputStream = new ZipInputStream(new FileInputStream(anArchiveFile));
		Stack<String> tempArchiveStack = new Stack<String>();
		tempArchiveStack.add(anArchiveFile.getAbsolutePath());
		addArchive(tempZipInputStream, anArchiveFile.getAbsolutePath(), aRecursiveFlag, tempArchiveStack);
	}

	/**
	 * Recursive-enabled variant of {@link #addArchive(File, boolean)}.
	 * 
	 * @param anArchiveInputStream
	 *            the archive input stream to read from
	 * @param aPrefix
	 *            the prefix to prepend in front of the filename inside the archive
	 * @param aRecursiveFlag
	 *            a flag whether recursive invocation is desired
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected void addArchive(ZipInputStream anArchiveInputStream, String aPrefix, boolean aRecursiveFlag,
			Stack<String> anArchiveFileNameStack) throws IOException {
		ZipEntry tempEntry = anArchiveInputStream.getNextEntry();
		while (tempEntry != null) {
			if (!tempEntry.isDirectory()) {
				String tempEntryName = aPrefix + "/" + tempEntry.getName();
				String tempLowerCaseName = tempEntry.getName().toLowerCase();
				if (tempLowerCaseName.endsWith(INTEGRITY_TEST_FILES_SUFFIX)) {
					addResource(
							new ArchivedTestResource(tempEntryName, this, anArchiveFileNameStack, tempEntry.getName()));
				} else if (aRecursiveFlag && (tempLowerCaseName.endsWith(ARCHIVE_ENDING_ZIP)
						|| tempLowerCaseName.endsWith(ARCHIVE_ENDING_JAR))) {
					Stack<String> tempSubArchiveStack = (Stack<String>) anArchiveFileNameStack.clone();
					tempSubArchiveStack.push(tempEntry.getName());
					addArchive(new ZipInputStream(anArchiveInputStream), tempEntryName, aRecursiveFlag,
							tempSubArchiveStack);
				}
			}
			tempEntry = anArchiveInputStream.getNextEntry();
		}
	}

	@Override
	public InputStream openResource(TestResource aResourceName) throws IOException {
		if (!(aResourceName instanceof ArchivedTestResource)) {
			throw new IllegalArgumentException("The resource must be an " + ArchivedTestResource.class.getSimpleName());
		}

		ArchivedTestResource tempResource = (ArchivedTestResource) aResourceName;

		Stack<ZipInputStream> tempStreamStack = new Stack<ZipInputStream>();
		for (String tempFileName : tempResource.getArchiveFilenameStack()) {
			if (tempStreamStack.size() == 0) {
				// this is the first entry -> must open the file on the filesystem
				tempStreamStack.add(new ZipInputStream(new FileInputStream(new File(tempFileName))));
			} else {
				// this is an inner entry -> open the stream in the outer stream
				if (!findFileInZipInputStream(tempStreamStack.lastElement(), tempFileName)) {
					throw new RuntimeException("Could not find inner archive file '" + tempFileName + "'");
				}
				tempStreamStack.add(new ZipInputStream(tempStreamStack.lastElement()));
			}
		}

		// Now the top element on the stack is the zip file where we can read the resource from
		ZipInputStream tempInputStream = tempStreamStack.lastElement();
		if (!findFileInZipInputStream(tempInputStream, tempResource.getNameWithinArchive())) {
			throw new RuntimeException("Could not find script file '" + tempResource + "' in enclosing archive");
		}
		openedResourceToStreamsMap.put(tempInputStream, tempStreamStack);

		return tempInputStream;
	}

	@Override
	public void closeResource(TestResource aResourceName, InputStream aResourceStream) throws IOException {
		Stack<ZipInputStream> tempOpenStreams = openedResourceToStreamsMap.remove(aResourceStream);

		if (tempOpenStreams != null) {
			for (ZipInputStream tempOpenStream : tempOpenStreams) {
				tempOpenStream.close();
			}
		}
	}

	/**
	 * Searches the given {@link ZipInputStream} for an entry, then stops. This changes the active entry in the stream
	 * to the entry to find (if found) or no entry (if not found).
	 * 
	 * @param aStream
	 *            the stream to search in
	 * @param aFileName
	 *            the entry name
	 * @return true if the entry was found, false if not
	 * @throws IOException
	 */
	protected boolean findFileInZipInputStream(ZipInputStream aStream, String aFileName) throws IOException {
		ZipEntry tempEntry = aStream.getNextEntry();
		while (tempEntry != null) {
			if (!tempEntry.isDirectory()) {
				if (aFileName.equals(tempEntry.getName())) {
					return true;
				}
			}
			tempEntry = aStream.getNextEntry();
		}

		return false;
	}

	/**
	 * Test resource located within one or multiple archives.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class ArchivedTestResource extends TestResource {

		/**
		 * The stack of archive filenames in which this resource is located.
		 */
		private Stack<String> archiveFilenameStack;

		/**
		 * The name of the resource within its directly containing archive (top of {@link #archiveFilenameStack}).
		 */
		private String nameWithinArchive;

		/**
		 * Creates a new instance of {@link ArchivedTestResource}.
		 * 
		 * @param aName
		 *            the full name of the resource
		 * @param aProvider
		 *            the provider
		 * @param anArchiveFilenameStack
		 *            the stack of archives to search within
		 * @param aNameWithinArchive
		 *            the name of the resource within the directly containing archive
		 */
		public ArchivedTestResource(String aName, TestResourceProvider aProvider, Stack<String> anArchiveFilenameStack,
				String aNameWithinArchive) {
			super(aName, aProvider);
			archiveFilenameStack = anArchiveFilenameStack;
			nameWithinArchive = aNameWithinArchive;
		}

		public Stack<String> getArchiveFilenameStack() {
			return archiveFilenameStack;
		}

		public String getNameWithinArchive() {
			return nameWithinArchive;
		}

	}

}
