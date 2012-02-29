/**
 * 
 */
package de.gebit.integrity.runner.eclipse.classpath;

import java.util.ArrayList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityClasspathContainer implements IClasspathContainer {

	private IPath path;

	public IntegrityClasspathContainer(IPath aPath) {
		path = aPath;
	}

	@Override
	public IClasspathEntry[] getClasspathEntries() {
		ArrayList<IClasspathEntry> tempEntryList = new ArrayList<IClasspathEntry>();

		// convert the list to an array and return it
		IClasspathEntry[] tempEntryArray = new IClasspathEntry[tempEntryList.size()];
		return (IClasspathEntry[]) tempEntryList.toArray(tempEntryArray);
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

}
