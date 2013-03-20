/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity;

import hudson.model.Action;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;

/**
 * The project action for Integrity Test Results. This class is responsible for displaying the Integrity overview on the
 * projects' pages, where the results of the last build and historical graphs etc. are shown.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityProjectAction implements Action {

	/**
	 * The project.
	 */
	private AbstractProject<?, ?> project;

	/**
	 * Creates an instance.
	 * 
	 * @param aProject
	 */
	public IntegrityProjectAction(AbstractProject<?, ?> aProject) {
		this.project = aProject;
	}

	public String getIconFileName() {
		return null;
	}

	public String getDisplayName() {
		return null;
	}

	public String getUrlName() {
		return "integrity";
	}

	/**
	 * Checks whether a trend is available.
	 * 
	 * @return
	 */
	public boolean hasTrend() {
		return getLatestResults() != null;
	}

	/**
	 * Returns a historical trend graph for display.
	 * 
	 * @return
	 */
	public IntegrityHistory getTrend() {
		IntegrityTestResultAction tempLatestResults = getLatestResults();
		if (tempLatestResults == null) {
			return null;
		}
		IntegrityCompoundTestResult tempResult = tempLatestResults.getResult();
		return new IntegrityHistory(tempResult);
	}

	/**
	 * Returns the newest available results.
	 */
	public IntegrityTestResultAction getLatestResults() {
		final AbstractBuild<?, ?> tempLastSuccessfulBuild = project.getLastSuccessfulBuild();
		AbstractBuild<?, ?> tempBuild = project.getLastBuild();
		while (tempBuild != null) {
			IntegrityTestResultAction tempResultAction = tempBuild.getAction(IntegrityTestResultAction.class);
			if (tempResultAction != null) {
				return tempResultAction;
			} else if (tempBuild == tempLastSuccessfulBuild) {
				return null;
			}
			tempBuild = tempBuild.getPreviousBuild();
		}

		return null;
	}
}
