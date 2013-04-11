/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.search;

import org.eclipse.ui.IEditorPart;

import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * The Integrity-specific search engine.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface IntegritySearch {

	/**
	 * Finds a suite definition by name (fullyqualified or part of the suite name).
	 * 
	 * @param aSuiteName
	 *            fully qualified suite name or part of the suite name
	 * @return the matching suites
	 */
	SuiteDefinition[] findSuiteDefinitionByName(String aSuiteName);

	/**
	 * Opens a suite definition by given suite name. This calls {@link #findSuiteDefinitionByName(String)} and opens the
	 * editor for the first match.
	 * 
	 * @param aSuiteName
	 *            the suite name to open (or part of)
	 * @return the opened editor or null
	 */
	IEditorPart openSuiteDefinitionByName(String aSuiteName);

}
