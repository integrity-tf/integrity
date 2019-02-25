/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.classpath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * @author Rene Schneider - initial API and implementation
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

		addToList(tempEntryList, new String[][] { new String[] { "de.gebit.integrity.runner" } });
		addToList(tempEntryList, new String[][] { new String[] { "de.gebit.integrity.docgen" } });
		addToList(tempEntryList, new String[][] { new String[] { "de.gebit.integrity.remoting" } });
		addToList(tempEntryList, new String[][] { new String[] { "de.gebit.integrity.dsl" } });

		addToList(tempEntryList, new String[][] { new String[] { "javax.inject" } });
		addToList(tempEntryList, new String[][] { new String[] { "com.google.inject" } });
		addToList(tempEntryList, new String[][] { new String[] { "com.google.guava" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.antlr.runtime" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.slf4j.log4j", "org.slf4j.api" },
				new String[] { "org.apache.log4j" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.core.contenttype" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.core.jobs" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.core.resources" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.core.runtime" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.emf.common" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.emf.ecore" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.emf.ecore.xmi" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.emf.mwe.utils" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.equinox.common" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.equinox.preferences" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.text" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.xtext" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.xtext.util" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.eclipse.xtext.common.types" } });
		addToList(tempEntryList, new String[][] { new String[] { "org.jdom" }, new String[] { "org.jdom_jaxen" } });

		// Recursion is necessary for org.objectweb.asm because xtext 2.16.x depends on 7.0.0 of that bundle, but
		// Eclipse itself just uses 6.2.1, so we must recursively search the entire bundle tree in order to find all
		// bundles.
		addToList(tempEntryList, new String[][] { new String[] { "org.objectweb.asm" } }, true);

		// convert the list to an array and return it
		IClasspathEntry[] tempEntryArray = new IClasspathEntry[tempEntryList.size()];
		return (IClasspathEntry[]) tempEntryList.toArray(tempEntryArray);
	}

	/**
	 * Finds one of the provided combination of bundles and adds it to the classpath. If no combination is found, an
	 * error is logged.
	 * 
	 * @param aList
	 *            the classpath
	 * @param someBundleNames
	 *            an array of combinations of bundle names (outer array contains combinations, inner array contains the
	 *            bundles that are part of a single combination)
	 */
	private void addToList(List<IClasspathEntry> aList, String[][] someBundleNames) {
		addToList(aList, someBundleNames, false);
	}

	/**
	 * Finds one of the provided combination of bundles and adds it to the classpath. If no combination is found, an
	 * error is logged.
	 * 
	 * @param aList
	 *            the classpath
	 * @param someBundleNames
	 *            an array of combinations of bundle names (outer array contains combinations, inner array contains the
	 *            bundles that are part of a single combination)
	 * @param aRecursiveFlag
	 *            whether to recursively search the contexts of bundles
	 */
	private void addToList(List<IClasspathEntry> aList, String[][] someBundleNames, boolean aRecursiveFlag) {
		StringBuffer tempBuffer = new StringBuffer();
		for (String[] tempBundleNames : someBundleNames) {
			StringBuffer tempInnerBuffer = new StringBuffer();
			List<IClasspathEntry> tempList = new ArrayList<IClasspathEntry>();
			boolean tempFoundAll = true;
			for (String tempBundleName : tempBundleNames) {
				IClasspathEntry tempEntry = getPluginEntry(findBundle(tempBundleName, aRecursiveFlag));
				if (tempEntry != null) {
					tempList.add(tempEntry);
				} else {
					if (tempInnerBuffer.length() > 0) {
						tempInnerBuffer.append(", ");
					}
					tempInnerBuffer.append(tempBundleName);
					tempFoundAll = false;
				}
			}

			if (tempList.size() == 0 || !tempFoundAll) {
				if (tempBuffer.length() > 0) {
					tempBuffer.append(", ");
				}
				tempBuffer.append("{ " + tempInnerBuffer + " }");
			} else {
				aList.addAll(tempList);
				return;
			}
		}

		Activator.getInstance().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Was unable to find any of the bundle combinations '"
						+ tempBuffer + "' to add it to a projects' classpath!"));
	}

	private Bundle findBundle(String aSymbolicName, boolean aRecursiveFlag) {
		return findBundleRecursive(aSymbolicName, FrameworkUtil.getBundle(JavaCore.class),
				aRecursiveFlag ? new HashSet<>() : null);
	}

	private Bundle findBundleRecursive(String aSymbolicName, Bundle aRootBundle, Set<Bundle> someSeenBundles) {
		Bundle tempBundleMatch = null;

		if (aRootBundle.getBundleContext() == null) {
			return null;
		}

		for (Bundle tempBundleCandidate : aRootBundle.getBundleContext().getBundles()) {
			if (someSeenBundles != null) {
				if (someSeenBundles.contains(tempBundleCandidate)) {
					continue;
				} else {
					someSeenBundles.add(tempBundleCandidate);
				}
			}

			if (tempBundleCandidate.getSymbolicName().equals(aSymbolicName)) {
				if (tempBundleMatch != null) {
					if (tempBundleMatch.getVersion().compareTo(tempBundleCandidate.getVersion()) < 0) {
						// already-found matches' version is less than candidates' version
						continue;
					}
				}

				tempBundleMatch = tempBundleCandidate;
			} else if (someSeenBundles != null) {
				Bundle tempRecursionCandidate
						= findBundleRecursive(aSymbolicName, tempBundleCandidate, someSeenBundles);

				if (tempRecursionCandidate != null) {
					if (tempBundleMatch != null) {
						if (tempBundleMatch.getVersion().compareTo(tempBundleCandidate.getVersion()) < 0) {
							// already-found matches' version is less than candidates' version
							continue;
						}
					}
					tempBundleMatch = tempRecursionCandidate;
				}
			}
		}

		return tempBundleMatch;
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
		IPath tempBundlePath;
		if (tempBundleLocation.startsWith("reference:file:")) {
			String tempPathString = tempBundleLocation.substring(15);
			if (tempPathString.endsWith("/")) {
				// This is a directory! Happens during development, when an Eclipse instance is started from another
				// Eclipse with the Integrity projects living there as projects and thus being included in the "inner"
				// Eclipse as directories. We'll return the right subdir in that case to allow for inclusion of the
				// compiled classes
				return new Path(tempPathString + "target/classes/");
			}
			tempBundlePath = new Path(tempPathString);
		} else {
			tempBundlePath = new Path(tempBundleLocation);
		}

		if (tempBundlePath.isAbsolute()) {
			return tempBundlePath;
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
		String tempSourceSuffix = aLibPath.toString().contains("de.gebit.integrity") ? "" : "_src";

		IPath tempSourceJar
				= aLibPath.removeLastSegments(1).append(tempJarName + tempSourceSuffix).addFileExtension("jar");

		return JavaCore.newLibraryEntry(aLibPath, tempSourceJar, null);
	}

}
