package de.gebit.integrity.runner.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FilesystemTestResourceProvider implements TestResourceProvider {

	private Set<String> resourceFiles = new HashSet<String>();

	private ClassLoader classLoader = getClass().getClassLoader();

	public FilesystemTestResourceProvider(Collection<? extends File> someResourceFiles) {
		for (File tempFile : someResourceFiles) {
			if (tempFile.exists() && tempFile.isFile()) {
				resourceFiles.add(tempFile.getAbsolutePath());
			}
		}
	}

	public FilesystemTestResourceProvider(Collection<? extends File> someDirectories, boolean aSearchRecursivelyFlag) {
		for (File tempDir : someDirectories) {
			scanDirectory(tempDir, aSearchRecursivelyFlag);
		}
	}

	protected void scanDirectory(File aDirectory, boolean aSearchRecursivelyFlag) {
		if (!aDirectory.isDirectory()) {
			return;
		}
		for (File tempFile : aDirectory.listFiles()) {
			if (tempFile.isFile()) {
				if (tempFile.getAbsolutePath().endsWith(".integrity")) {
					resourceFiles.add(tempFile.getAbsolutePath());
				} else if (aSearchRecursivelyFlag && tempFile.isDirectory()) {
					scanDirectory(tempFile, aSearchRecursivelyFlag);
				}
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
			} catch (FileNotFoundException e) {
				e.printStackTrace();
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
