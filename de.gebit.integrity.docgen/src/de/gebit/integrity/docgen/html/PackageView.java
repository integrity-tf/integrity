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
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParsedDocumentationComment;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;
import htmlflow.HtmlView;
import htmlflow.elements.HtmlBody;
import htmlflow.elements.HtmlDiv;
import htmlflow.elements.HtmlTable;
import htmlflow.elements.HtmlTr;

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
		HtmlDiv<?> tempMainDiv = tempBody.div().classAttr("suites");
		tempMainDiv.div().classAttr("suitesummary")
				.text("This package defines " + anEntry.getValue().size() + " suites");

		for (SuiteDefinition tempSuite : anEntry.getValue()) {
			HtmlDiv<?> tempSuiteDiv = tempMainDiv.div().classAttr("suite");
			HtmlDiv<?> tempSuiteHeaderDiv = tempSuiteDiv.div().classAttr("suiteheader");
			tempSuiteHeaderDiv.div().classAttr("suitename").text(tempSuite.getName());
			String tempSuiteTitle = IntegrityDSLUtil.getSuiteTitle(tempSuite);
			if (tempSuiteTitle != null) {
				tempSuiteHeaderDiv.div().classAttr("suitetitle").text(tempSuiteTitle);
			}
			tempSuiteHeaderDiv.div().classAttr("fullsuitename code")
					.text(IntegrityDSLUtil.getQualifiedSuiteName(tempSuite));

			boolean tempSuiteHasDetails = (tempSuite.getDocumentation() != null);

			if (tempSuiteHasDetails) {
				HtmlDiv<?> tempSuiteDetailsDiv = tempSuiteDiv.div().classAttr("suitedetails");
				if (tempSuite.getDocumentation() != null) {
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempSuite.getDocumentation(),
							aModelSourceExplorer.determineSourceInformation(tempSuite.getDocumentation()));
					tempSuiteDetailsDiv.div().classAttr("suitedescription")
							.text(tempParsedComment.getDocumentationText());

					if (tempSuite.getParameters().size() > 0) {
						HtmlDiv<?> tempSuiteParamsDiv = tempSuiteDetailsDiv.div().classAttr("suiteparams");
						tempSuiteParamsDiv.div().classAttr("detailstitle").text("Parameters");
						HtmlTable<?> tempParamTable = tempSuiteParamsDiv.table();

						for (SuiteParameterDefinition tempParameter : tempSuite.getParameters()) {
							String tempParamDoc = tempParsedComment.getParameterDocumentationTexts()
									.get(tempParameter.getName().getName());
							HtmlTr<?> tempRow = tempParamTable.tr();
							tempRow.td().classAttr("code").text(tempParameter.getName().getName());
							tempRow.td().text(tempParamDoc != null ? tempParamDoc : "");
						}
					}
				}
			}
		}
	}

}
