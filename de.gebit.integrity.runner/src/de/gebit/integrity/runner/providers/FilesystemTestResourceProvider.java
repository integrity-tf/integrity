package de.gebit.integrity.runner.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * A resource provider which reads test files from the filesystem, either from one or more flat directories or
 * optionally in a recursive way.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class FilesystemTestResourceProvider implements TestResourceProvider {

	/**
	 * The paths to the resource files.
	 */
	private Set<String> resourceFiles = new HashSet<String>();

	/**
	 * The classloader to use while linking the parsed resources.
	 */
	private ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * Creates an instance, naming a bunch of resource files.
	 * 
	 * @param someResourceFiles
	 *            the resource files to load
	 */
	public FilesystemTestResourceProvider(Collection<? extends File> someResourceFiles) {
		for (File tempFile : someResourceFiles) {
			if (tempFile.exists() && tempFile.isFile()) {
				resourceFiles.add(tempFile.getAbsolutePath());
			}
		}
	}

	/**
	 * Creates an instance naming some directories to scan for resource files. This scanning will search for file names
	 * ending with ".integrity".
	 * 
	 * @param someDirectoriesOrFiles
	 *            the directories and files to scan
	 * @param aSearchRecursivelyFlag
	 *            whether the scan process shall search recursively inside subdirectories
	 */
	public FilesystemTestResourceProvider(Collection<? extends File> someDirectoriesOrFiles,
			boolean aSearchRecursivelyFlag) {
		for (File tempDirOrFile : someDirectoriesOrFiles) {
			if (tempDirOrFile.isDirectory()) {
				scanDirectory(tempDirOrFile, aSearchRecursivelyFlag);
			} else {
				if (tempDirOrFile.getAbsolutePath().endsWith(".integrity")) {
					resourceFiles.add(tempDirOrFile.getAbsolutePath());
				}
			}
		}
	}

	/**
	 * Performs the actual scanning in one directory.
	 * 
	 * @param aDirectory
	 *            the directory
	 * @param aSearchRecursivelyFlag
	 *            whether scanning shall recurse into subdirectories
	 */
	protected void scanDirectory(File aDirectory, boolean aSearchRecursivelyFlag) {
		if (!aDirectory.isDirectory()) {
			return;
		}
		for (File tempFile : aDirectory.listFiles()) {
			if (tempFile.isFile()) {
				if (tempFile.getAbsolutePath().endsWith(".integrity")) {
					resourceFiles.add(tempFile.getAbsolutePath());
				}
			} else if (aSearchRecursivelyFlag && tempFile.isDirectory()) {
				scanDirectory(tempFile, aSearchRecursivelyFlag);
			}
		}
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
