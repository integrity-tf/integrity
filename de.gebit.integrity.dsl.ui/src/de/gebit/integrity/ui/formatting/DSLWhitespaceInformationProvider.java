/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.formatting;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.editor.formatting.PreferenceStoreWhitespaceInformationProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

import de.gebit.integrity.ui.formatting.LineSeparatorDetector.LineSeparatorType;

/**
 * Custom whitespace information provider which implements a more sophisticated, automatic line break detection, in case
 * no line break information can be deduced from project/file settings. Only if that automatic detection fails, a
 * fallback to the system property is done. <br>
 * <br>
 * Unfortunately, due to the superclass being not really ideal to extend in the manner I required, I had to copy/paste a
 * lot more lines from it than I feel comfortable to :(.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLWhitespaceInformationProvider extends PreferenceStoreWhitespaceInformationProvider {

	/**
	 * Injected mapper.
	 */
	@Inject
	private IStorage2UriMapper storage2UriMapper;

	/**
	 * Injected workspace.
	 */
	@Inject
	private IWorkspace workspace;

	@Override
	protected String getLineSeparatorPreference(URI aUri) {
		IProject tempProject = null;
		if (aUri.isPlatformResource()) {
			tempProject = workspace.getRoot().getProject(aUri.segment(1));
		} else {
			for (Pair<IStorage, IProject> tempStorage : storage2UriMapper.getStorages(aUri)) {
				tempProject = tempStorage.getSecond();
				break;
			}
		}
		if (tempProject != null) {
			String tempResult = getLineSeparatorPreference(new ProjectScope(tempProject));
			if (tempResult != null) {
				return tempResult;
			}
		}
		@SuppressWarnings("deprecation")
		String tempResult = getLineSeparatorPreference(new InstanceScope());
		if (tempResult != null) {
			return tempResult;
		}

		InputStream tempStream = null;
		LineSeparatorType tempBreakType = null;
		try {
			IFile tempFile = workspace.getRoot().getFile(new Path(aUri.toPlatformString(true)));
			tempBreakType = new LineSeparatorDetector().detectLineBreakType(tempFile.getContents());
		} catch (CoreException exc) {
			exc.printStackTrace();
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (tempStream != null) {
				try {
					tempStream.close();
				} catch (IOException exc) {
					// ignore
				}
			}
		}
		if (tempBreakType != null) {
			return tempBreakType.getLineSeparatorChars();
		}

		return System.getProperty("line.separator");
	}

}
