/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

import java.util.Collection;

import de.gebit.integrity.docgen.IntegrityPackage;
import htmlflow.elements.HtmlA;
import htmlflow.elements.HtmlBody;
import htmlflow.elements.HtmlDiv;
import htmlflow.elements.HtmlFormInputSubmit;
import htmlflow.elements.HtmlFormInputText;

/**
 * This view represents a tree view of packages.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class PackageIndexView extends IntegrityHtmlView<Collection<String>> {

	/**
	 * Constructor.
	 * 
	 * @param somePackages
	 */
	public PackageIndexView(Collection<IntegrityPackage> somePackages, boolean aRelativeToPackageSubdirFlag) {
		head().title("Package Tree");
		head().linkCss((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/css/main.css");
		head().linkCss((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/css/vtree.css");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/index.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/lunr.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/lunr_config.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/lunr_integration.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/vanillatree.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/vanillatree_integration.js");
		head().scriptLink((aRelativeToPackageSubdirFlag ? "../" : "") + "resources/js/tree.js");

		HtmlBody<?> tempBody = body();
		HtmlDiv<?> tempTreeContainerDiv = tempBody.div().idAttr("treecontainer");
		HtmlDiv<?> tempTreeDiv = tempTreeContainerDiv.div().idAttr("packagetree");
		HtmlDiv<?> tempMainContainerDiv = tempBody.div().idAttr("maincontainer");
		tempMainContainerDiv.div().classAttr("title").text("Package Index");
		tempMainContainerDiv.hr();
		HtmlDiv<?> tempTreeIndexLinkDiv = tempTreeDiv.div().idAttr("treeindexlink");
		HtmlA<?> tempTreeIndexLink = new HtmlA<>((aRelativeToPackageSubdirFlag ? "../" : "") + "index.html");
		tempTreeIndexLink.text("Package Index");
		tempTreeIndexLinkDiv.addChild(tempTreeIndexLink);

		HtmlDiv<?> tempSearchForm = tempMainContainerDiv.div().idAttr("searchbox");
		HtmlFormInputText tempSearchFormInput = new HtmlFormInputText("searchtext", "searchtext");
		HtmlFormInputSubmit<?> tempSearchFormButton = new HtmlFormInputSubmit<>("searchbutton");
		tempSearchFormButton.addAttr("id", "searchbutton");
		tempSearchFormButton.addAttr("type", "button");
		tempSearchFormButton.addAttr("value", "Search");
		tempSearchForm.addChild(tempSearchFormInput);
		tempSearchForm.addChild(tempSearchFormButton);

		tempMainContainerDiv.div().idAttr("searchresults");
	}

}
