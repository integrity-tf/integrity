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
public class VersionUtil {

	/**
	 * Returns the version string of the bundle/jar in which the given class exists.
	 * 
	 * @param aClassFromTheBundle
	 *            a class from the bundle
	 * @return
	 */
	public String getBundleVersionString(Class<?> aClassFromTheBundle) {
		InputStream tempStream = getClass().getResourceAsStream("/META-INF/MANIFEST.MF");
		Manifest tempManifest;
		try {
			tempManifest = new Manifest(tempStream);
		} catch (IOException exc) {
			return null;
		}

		Attributes tempAttributes = tempManifest.getMainAttributes();
		return tempAttributes.getValue("Bundle-Version");
	}

}
