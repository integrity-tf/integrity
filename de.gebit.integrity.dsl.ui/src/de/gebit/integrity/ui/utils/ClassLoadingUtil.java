package de.gebit.integrity.ui.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * A utility class containing methods to dynamically load classes into the eclipse workspace JVM.
 * 
 * @author Rene Schneider
 * 
 */
public final class ClassLoadingUtil {

	private ClassLoadingUtil() {
		// nothing to do
	}

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
	public static Class<?> loadClassFromWorkspace(String aClassName, IJavaProject aProject)
			throws ClassNotFoundException {
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
			return tempClassLoader.loadClass(aClassName);
		} catch (CoreException exc) {
			exc.printStackTrace();
		} catch (MalformedURLException exc) {
			exc.printStackTrace();
		}

		return null;
	}

}
