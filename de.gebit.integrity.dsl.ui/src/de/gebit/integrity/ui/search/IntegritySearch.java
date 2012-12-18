/**
 * 
 */
package de.gebit.integrity.ui.search;

import org.eclipse.ui.IEditorPart;

import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public interface IntegritySearch {

	SuiteDefinition[] findSuiteDefinitionByName(String aSuiteName);

	IEditorPart openSuiteDefinitionByName(String aSuiteName);

}
