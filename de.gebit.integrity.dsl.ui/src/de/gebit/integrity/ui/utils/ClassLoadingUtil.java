/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * A utility class containing methods to dynamically load classes into the eclipse workspace JVM.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class ClassLoadingUtil {

	/**
	 * The class cache caches loaded classes.
	 */
	private Map<String, Class<?>> classCache = new Hashtable<String, Class<?>>();

	/**
	 * The build listener is used to listen to workspace rebuilds and determines if Java-class-related changes have
	 * occurred.
	 */
	private JavaBuildListener buildListener = new JavaBuildListener();

	/**
	 * Creates a new instance.
	 */
	public ClassLoadingUtil() {
		IWorkspace tempWorkspace = ResourcesPlugin.getWorkspace();
		tempWorkspace.addResourceChangeListener(buildListener, IResourceChangeEvent.POST_BUILD);
	}

	/**
	 * Finalizes an instance.
	 */
	protected void finalize() throws Throwable {
		IWorkspace tempWorkspace = ResourcesPlugin.getWorkspace();
		tempWorkspace.removeResourceChangeListener(buildListener);
	};

	/**
	 * Loads a class defined in a specific project into the Eclipse JVM.
	 * 
	 * @param aClassName
	 *            the fully qualified class name
	 * @param aProject
	 *            the project where the class resides
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	public Class<?> loadClassFromWorkspace(String aClassName, IJavaProject aProject) throws ClassNotFoundException {
		Class<?> tempClass = classCache.get(aClassName);

		if (tempClass == null) {
			try {
				String[] tempClassPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(aProject);
				List<URL> tempUrlList = new ArrayList<URL>();
				for (int i = 0; i < tempClassPathEntries.length; i++) {
					String tempEntry = tempClassPathEntries[i];
					IPath tempPath = new Path(tempEntry);
					URL tempUrl = tempPath.toFile().toURI().toURL();
					tempUrlList.add(tempUrl);
				}
				ClassLoader tempParentClassLoader = ClassLoadingUtil.class.getClassLoader();
				URL[] tempUrls = (URL[]) tempUrlList.toArray(new URL[tempUrlList.size()]);
				URLClassLoader tempClassLoader = new URLClassLoader(tempUrls, tempParentClassLoader);
				tempClass = tempClassLoader.loadClass(aClassName);
				if (tempClass != null) {
					classCache.put(aClassName, tempClass);
				}
			} catch (CoreException exc) {
				exc.printStackTrace();
			} catch (MalformedURLException exc) {
				exc.printStackTrace();
			}
		}

		return tempClass;
	}

	private class JavaBuildListener implements IResourceChangeListener {

		@Override
		public void resourceChanged(IResourceChangeEvent anEvent) {
			if (anEvent.getType() == IResourceChangeEvent.POST_BUILD) {
				if (checkForJavaClassOrProjectChange(anEvent.getDelta())) {
					classCache.clear();
				}
			}
		}

		private boolean checkForJavaClassOrProjectChange(IResourceDelta aDelta) {
			IResourceDelta[] tempChilds = aDelta.getAffectedChildren();
			if (tempChilds != null && tempChilds.length > 0) {
				for (IResourceDelta tempChild : tempChilds) {
					boolean tempChange = checkForJavaClassOrProjectChange(tempChild);
					if (tempChange) {
						return tempChange;
					}
				}
			} else {
				IPath tempPath = aDelta.getFullPath();
				if (tempPath != null) {
					String tempFileExtension = tempPath.getFileExtension();
					return ("java".equals(tempFileExtension) || "jar".equals(tempFileExtension) || "classpath"
							.equals(tempFileExtension));
				}
			}
			return false;
		}

	}

}
