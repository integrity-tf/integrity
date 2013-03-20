/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.classpath;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * Initializer for {@link IntegrityClasspathContainer}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityClasspathContainerInitializer extends ClasspathContainerInitializer {

	/**
	 * The path name of the Integrity Classpath Container.
	 */
	public static final String PATH = "de.gebit.integrity.INTEGRITY_CONTAINER";

	/**
	 * Default constructor for instantiation in Eclipse.
	 */
	public IntegrityClasspathContainerInitializer() {
	}

	@Override
	public void initialize(IPath aContainerPath, IJavaProject aProject) throws CoreException {
		if (PATH.equals(aContainerPath.toString())) {
			IntegrityClasspathContainer tempContainer = new IntegrityClasspathContainer(aContainerPath);
			JavaCore.setClasspathContainer(aContainerPath, new IJavaProject[] { aProject },
					new IClasspathContainer[] { tempContainer }, null);
		}
	}

	@Override
	public boolean canUpdateClasspathContainer(IPath aContainerPath, IJavaProject aProject) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(IPath aContainerPath, IJavaProject aProject,
			IClasspathContainer aContainerSuggestion) throws CoreException {
		if (aContainerSuggestion instanceof IntegrityClasspathContainer) {
			IntegrityClasspathContainer tempContainer = (IntegrityClasspathContainer) aContainerSuggestion;
			JavaCore.setClasspathContainer(aContainerPath, new IJavaProject[] { aProject },
					new IClasspathContainer[] { tempContainer }, null);
		}
	}

}
