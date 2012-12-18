/**
 * 
 */
package de.gebit.integrity.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.search.IXtextEObjectSearch;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class DefaultIntegritySearch implements IntegritySearch {

	@Inject
	private IXtextEObjectSearch searchEngine;

	@Inject
	private IURIEditorOpener uriEditorOpener;

	public SuiteDefinition[] findSuiteDefinitionByName(String aSuiteName) {
		List<SuiteDefinition> tempResult = new ArrayList<SuiteDefinition>();

		for (IEObjectDescription tempDesc : searchEngine.findMatches(aSuiteName, SuiteDefinition.class.getSimpleName())) {
			EObject tempObject = tempDesc.getEObjectOrProxy();
			if (tempObject instanceof SuiteDefinition) {
				SuiteDefinition tempDefinition = (SuiteDefinition) tempObject;
				tempResult.add(tempDefinition);
			}
		}

		if (tempResult.size() > 0) {
			return tempResult.toArray(new SuiteDefinition[tempResult.size()]);
		} else {
			return null;
		}
	}

	public IEditorPart openSuiteDefinitionByName(String aSuiteName) {
		SuiteDefinition[] tempSuiteDef = findSuiteDefinitionByName(aSuiteName);
		if (tempSuiteDef != null) {
			return uriEditorOpener.open(EcoreUtil.getURI(tempSuiteDef[0]), true);
		} else {
			return null;
		}
	}
}
