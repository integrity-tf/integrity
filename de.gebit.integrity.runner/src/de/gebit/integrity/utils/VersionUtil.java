/**
 * 
 */
package de.gebit.integrity.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * Versioning Utility.
 * 
 * @author Rene Schneider
 * 
 */
public final class VersionUtil {

	private VersionUtil() {
		// private constructor
	}

	/**
	 * Returns the version string of the bundle/jar in which the given class exists.
	 * 
	 * @param aClassFromTheBundle
	 *            a class from the bundle
	 * @return
	 */
	public static String getBundleVersionString(Class<?> aClassFromTheBundle) {
		InputStream tempStream = aClassFromTheBundle.getResourceAsStream("/META-INF/MANIFEST.MF");
		Manifest tempManifest;
		try {
			tempManifest = new Manifest(tempStream);
		} catch (IOException exc) {
			return null;
		}

		Attributes tempAttributes = tempManifest.getMainAttributes();
		if ("de.gebit.integrity.runner".equals(tempAttributes.getValue("Bundle-SymbolicName"))) {
			return tempAttributes.getValue("Bundle-Version");
		} else {
			// cannot determine version - usually the case during Integrity development
			return null;
		}
	}
}
