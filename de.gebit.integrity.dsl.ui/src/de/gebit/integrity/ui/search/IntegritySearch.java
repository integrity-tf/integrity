/**
 * 
 */
package de.gebit.integrity.ui.search;

import org.eclipse.ui.IEditorPart;

import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * The Integrity-specific search engine.
 * 
 * @author Slartibartfast
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
