/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.runner.TestModel;
import htmlflow.HtmlView;

/**
 * The documentation generator is responsible for parsing Integrity files and generating HTML documentation, similar to
 * JavaDoc.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DefaultDocumentationGenerator implements DocumentationGenerator {

	private TestModel model;

	private File targetDirectory;

	@Override
	public void initialize(TestModel aModel) {
		model = aModel;
	}

	@Override
	public void run(File aTargetDirectory) throws IOException {
		if (!aTargetDirectory.exists()) {
			if (!aTargetDirectory.mkdirs()) {
				throw new IOException("Failed to create target directory");
			}
		}
		if (!aTargetDirectory.isDirectory()) {
			throw new IOException("Target directory name provided is not a directory");
		}
		targetDirectory = aTargetDirectory;

		Map<String, Collection<SuiteDefinition>> tempSuitesByPackage = groupSuitesByPackage(model.getAllSuites());
		for (Entry<String, Collection<SuiteDefinition>> tempEntry : tempSuitesByPackage.entrySet()) {
			processPackage(tempEntry.getKey(), tempEntry.getValue());
		}
	}

	protected Map<String, Collection<SuiteDefinition>> groupSuitesByPackage(Collection<SuiteDefinition> someSuites) {
		Map<String, Collection<SuiteDefinition>> tempResult = new HashMap<>();

		for (SuiteDefinition tempSuite : model.getAllSuites()) {
			String tempPackageName = ((PackageDefinition) tempSuite.eContainer()).getName();
			Collection<SuiteDefinition> tempSuiteList = tempResult.get(tempPackageName);
			if (tempSuiteList == null) {
				tempSuiteList = new ArrayList<>();
				tempResult.put(tempPackageName, tempSuiteList);
			}
			tempSuiteList.add(tempSuite);
		}

		return tempResult;
	}

	protected void processPackage(String aPackageName, Collection<SuiteDefinition> someSuites) {
		HtmlView<Package> tempPackageView = new HtmlView<>();
		// @formatter:off
		tempPackageView
                .head()
                .title("Package " + aPackageName)
                .linkCss("resources/css/main.css");
//		HtmlDiv<>tempPackageView
//                .body().classAttr("container")
//                .div().classAttr("title").text("Package " + aPackageName);
		
		// @formatter:on
	}

	protected void processSuite(SuiteDefinition aSuiteDefinition) {
		if (aSuiteDefinition.getDocumentation() != null) {
			// do nothing
		}
	}

}
