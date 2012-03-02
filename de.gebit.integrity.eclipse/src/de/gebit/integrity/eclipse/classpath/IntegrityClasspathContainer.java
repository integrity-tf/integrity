/**
 * 
 */
package de.gebit.integrity.eclipse.classpath;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.gebit.integrity.eclipse.Activator;

/**
 * Classpath container which adds the Integrity bundles required to run tests as well as their immediate dependencies.
 * Note that not all declared dependencies (and their sub-dependencies) are actually added! This is due to a lot of them
 * actually not being required for simple test execution. If you're using an environment that does enforce full
 * dependency resolution (OSGi!), you'll have to add all necessary dependencies there yourself (for example on the
 * target platform in Eclipse PDE).
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityClasspathContainer implements IClasspathContainer {

	/**
	 * The container path.
	 */
	private IPath path;

	/**
	 * Creates a new instance.
	 * 
	 * @param aPath
	 *            the container path
	 */
	public IntegrityClasspathContainer(IPath aPath) {
		path = aPath;
	}

	@Override
	public IClasspathEntry[] getClasspathEntries() {
		ArrayList<IClasspathEntry> tempEntryList = new ArrayList<IClasspathEntry>();

		addToList(tempEntryList, "de.gebit.integrity.runner");
		addToList(tempEntryList, "de.gebit.integrity.remoting");
		addToList(tempEntryList, "de.gebit.integrity.dsl");

		addToList(tempEntryList, "com.google.inject");
		addToList(tempEntryList, "org.antlr.runtime");
		addToList(tempEntryList, "org.eclipse.core.contenttype");
		addToList(tempEntryList, "org.eclipse.core.jobs");
		addToList(tempEntryList, "org.eclipse.core.resources");
		addToList(tempEntryList, "org.eclipse.core.runtime");
		addToList(tempEntryList, "org.eclipse.emf.common");
		addToList(tempEntryList, "org.eclipse.emf.ecore");
		addToList(tempEntryList, "org.eclipse.emf.mwe.utils");
		addToList(tempEntryList, "org.eclipse.equinox.preferences");
		addToList(tempEntryList, "org.eclipse.text");
		addToList(tempEntryList, "org.eclipse.xtext");
		addToList(tempEntryList, "org.eclipse.xtext.common.types");

		// convert the list to an array and return it
		IClasspathEntry[] tempEntryArray = new IClasspathEntry[tempEntryList.size()];
		return (IClasspathEntry[]) tempEntryList.toArray(tempEntryArray);
	}

	private void addToList(List<IClasspathEntry> aList, String aBundleName) {
		IClasspathEntry tempEntry = getPluginEntry(findBundle(aBundleName));
		if (tempEntry != null) {
			aList.add(tempEntry);
		} else {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Was unable to find bundle '" + aBundleName
							+ "' to add it to a projects' classpath!"));
		}
	}

	private Bundle findBundle(String aSymbolicName) {
		for (Bundle tempBundle : FrameworkUtil.getBundle(JavaCore.class).getBundleContext().getBundles()) {
			if (tempBundle.getSymbolicName().equals(aSymbolicName)) {
				return tempBundle;
			}
		}
		return null;
	}

	@Override
	public String getDescription() {
		return "Integrity";
	}

	@Override
	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	@Override
	public IPath getPath() {
		return path;
	}

	/**
	 * Resolves a bundle to its installation directory and creates an {@link IClasspathEntry} with it.
	 * 
	 * @param aBundle
	 *            the bundle
	 * @return The classpath entry, or null if no path was determinable.
	 */
	private IClasspathEntry getPluginEntry(Bundle aBundle) {
		if (aBundle == null) {
			return null;
		}
		IPath tempPluginPath = getInstallationDirectoryFor(aBundle);
		if (tempPluginPath == null) {
			return null;
		} else {
			return getLibrary(tempPluginPath);
		}
	}

	/**
	 * Returns the installation directory for the given bundle or <code>null</code> if it cannot be determined.
	 */
	private IPath getInstallationDirectoryFor(Bundle aBundle) {
		String tempBundleLocation = aBundle.getLocation();
		if (tempBundleLocation == null || tempBundleLocation.length() == 0) {
			return null;
		}
		IPath tempBundlePath = new Path(tempBundleLocation);
		if (tempBundlePath.isAbsolute()) {
			return tempBundlePath;
		}
		if (tempBundlePath.toString().startsWith("reference:file:")) {
			String tempPathString = tempBundlePath.toString().substring(15);
			if (tempPathString.endsWith("/")) {
				// This is a directory! Happens during development, when an Eclipse instance is started from another
				// Eclipse with the Integrity projects living there as projects and thus being included in the "inner"
				// Eclipse as directories. We'll return the right subdir in that case to allow for inclusion of the
				// compiled classes
				return new Path(tempPathString + "target/classes/");
			} else {
				return new Path(tempPathString);
			}
		}

		Location tempInstallLocation = Platform.getInstallLocation();
		if (tempInstallLocation == null || !tempInstallLocation.isSet()) {
			return null;
		}

		Path tempPath = new Path(tempInstallLocation.getURL().getPath());

		return tempPath.append(tempBundlePath);
	}

	/**
	 * Creates an IClasspathEntry for the given jar file in the given path.
	 * 
	 * @param aLibPath
	 *            the path where to find the jar
	 * @param aJarName
	 *            the file name of the jar file
	 * @return the library IClasspath entry
	 */
	private IClasspathEntry getLibrary(IPath aLibPath) {
		String tempJarName = aLibPath.removeFileExtension().lastSegment();
		IPath tempSourceJar = aLibPath.removeLastSegments(1).append(tempJarName + "_src").addFileExtension("jar");

		return JavaCore.newLibraryEntry(aLibPath, tempSourceJar, null);
	}

}
