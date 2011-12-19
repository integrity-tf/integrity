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

public class ClassLoadingUtil {

	public static Class<?> loadClassFromWorkspace(String aClassName, IJavaProject aProject)
			throws ClassNotFoundException {
		try {
			String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(aProject);
			List<URL> tempUrlList = new ArrayList<URL>();
			for (int i = 0; i < classPathEntries.length; i++) {
				String tempEntry = classPathEntries[i];
				IPath tempPath = new Path(tempEntry);
				URL tempUrl = tempPath.toFile().toURI().toURL();
				tempUrlList.add(tempUrl);
			}
			ClassLoader parentClassLoader = ClassLoadingUtil.class.getClassLoader();
			URL[] urls = (URL[]) tempUrlList.toArray(new URL[tempUrlList.size()]);
			URLClassLoader tempClassLoader = new URLClassLoader(urls, parentClassLoader);
			return tempClassLoader.loadClass(aClassName);
		} catch (CoreException exc) {
			exc.printStackTrace();
		} catch (MalformedURLException exc) {
			exc.printStackTrace();
		}

		return null;
	}

}
