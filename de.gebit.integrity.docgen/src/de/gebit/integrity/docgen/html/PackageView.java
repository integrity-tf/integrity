/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

import java.util.Collection;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParsedDocumentationComment;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;
import htmlflow.HtmlView;
import htmlflow.elements.HtmlBody;
import htmlflow.elements.HtmlDiv;

/**
 * HTML view of an Integrity package, containing a number of suites.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class PackageView extends HtmlView<Entry<String, Collection<SuiteDefinition>>> {

	/**
	 * Constructor.
	 * 
	 * @param anEntry
	 * @throws ParseException
	 */
	public PackageView(Entry<String, Collection<SuiteDefinition>> anEntry, ModelSourceExplorer aModelSourceExplorer)
			throws ParseException {
		head().linkCss("resources/css/main.css").title("Package " + anEntry.getKey());

		HtmlBody<?> tempBody = body();
		tempBody.div().classAttr("title").text("Package " + anEntry.getKey());

		tempBody.hr();

		for (SuiteDefinition tempSuite : anEntry.getValue()) {
			HtmlDiv<?> tempSuiteDiv = tempBody.div().classAttr("suite");
			tempSuiteDiv.div().classAttr("suitetitle").text(IntegrityDSLUtil.getQualifiedSuiteName(tempSuite));

			if (tempSuite.getDocumentation() != null) {
				ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
						tempSuite.getDocumentation(),
						aModelSourceExplorer.determineSourceInformation(tempSuite.getDocumentation()));

				tempSuiteDiv.div().classAttr("suitedescription").text(tempParsedComment.getDocumentationText());
			}

			tempBody.addChild(tempSuiteDiv);
		}
	}

}
