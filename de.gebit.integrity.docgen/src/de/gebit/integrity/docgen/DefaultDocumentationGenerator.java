/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

import de.gebit.integrity.docgen.html.PackageTreeView;
import de.gebit.integrity.docgen.html.PackageView;
import de.gebit.integrity.docgen.search.LunrIndexBuilder;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;
import htmlflow.HtmlView;

/**
 * The documentation generator is responsible for parsing Integrity files and generating HTML documentation, similar to
 * JavaDoc.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DefaultDocumentationGenerator implements DocumentationGenerator {

	/**
	 * The model to parse.
	 */
	private TestModel model;

	/**
	 * The target directory for the HTML result files.
	 */
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

		System.out.print("Initializing Lunr index builder...");
		LunrIndexBuilder tempIndexBuilder = new LunrIndexBuilder();
		System.out.println("done!");

		System.out.print("Preprocessing entities...");
		Collection<IntegrityPackage> tempPackages = groupEntitiesByPackage(model);
		System.out.println("done!");

		// Write out the package tree view document
		System.out.print("Writing package tree...");
		PackageTreeView tempTreeView = new PackageTreeView(tempPackages, false);
		// We also need a second PackageTreeView that is to be embedded into the package pages
		PackageTreeView tempTreeViewEmbedded = new PackageTreeView(tempPackages, true);
		processDocument(new File(targetDirectory, "index.html"), tempTreeView);
		System.out.println("done!");

		// Write all the documents for packages
		File tempPackageSubdir = new File(targetDirectory, "packages");
		tempPackageSubdir.mkdir();
		for (IntegrityPackage tempPackage : tempPackages) {
			System.out.print("Writing doc for package '" + tempPackage.getName() + "'...");
			try {
				PackageView tempPackageView = new PackageView(tempPackage, model, tempTreeViewEmbedded);
				processDocument(new File(tempPackageSubdir, tempPackage.getName() + ".html"), tempPackageView);
				tempIndexBuilder.addToIndex(tempPackage.getName(), tempPackageView.textOnly());
			} catch (ParseException exc) {
				System.out.println("...failed :-( " + exc.getMessage());
			}
			System.out.println("done!");
		}

		System.out.print("Copying static resources...");
		copyResources(targetDirectory);
		System.out.println("done!");

		System.out.print("Finalizing Lunr index...");
		tempIndexBuilder.build(new File(targetDirectory, "resources/js/index.js"));
		System.out.println("done!");

		System.out.println("Finished generating documentation!");
	}

	/**
	 * Parses all entities relevant for documentation, grouping them by the packages that they are located within, and
	 * returns those packages.
	 * 
	 * @param aModel
	 *            the model to search
	 * @return a list of packages with entity info
	 */
	protected Collection<IntegrityPackage> groupEntitiesByPackage(TestModel aModel) {
		Map<String, IntegrityPackage> tempResult = new HashMap<>();

		Consumer<EObject> tempConsumer = new Consumer<EObject>() {
			@Override
			public void accept(EObject anEntity) {
				String tempPackageName = IntegrityDSLUtil.getPackageContaining(anEntity).getName();
				IntegrityPackage tempPackageInfo = tempResult.get(tempPackageName);
				if (tempPackageInfo == null) {
					tempPackageInfo = new IntegrityPackage(tempPackageName);
					tempResult.put(tempPackageName, tempPackageInfo);
				}
				tempPackageInfo.add(anEntity);
			};

		};

		// For suites, we only include those that are either non-private or are private but have a doc comment attached
		aModel.getAllSuites().stream()
				.filter((aSuite) -> (aSuite.getPrivate() == null || aSuite.getDocumentation() != null))
				.forEach(tempConsumer);
		aModel.getConstantDefinitionsInPackages().forEach(tempConsumer);
		aModel.getAllCalls().forEach(tempConsumer);
		aModel.getAllTests().forEach(tempConsumer);

		return tempResult.values();
	}

	/**
	 * Writes out the result HTML for the provided view.
	 * 
	 * @param aTargetFile
	 *            the file to write into
	 * @param aView
	 *            the view to generate HTML from
	 * @throws IOException
	 */
	protected <T> void processDocument(File aTargetFile, HtmlView<T> aView) throws IOException {
		try (PrintStream tempOut = new PrintStream(new FileOutputStream(aTargetFile))) {
			aView.setPrintStream(tempOut).write();
		}
	}

	/**
	 * Copies all static resource files into the target directory.
	 * 
	 * @param aTargetDir
	 *            the target directory
	 * @throws IOException
	 */
	protected void copyResources(File aTargetDir) throws IOException {
		File tempCssTargetDir = new File(aTargetDir, "resources/css");
		if (!tempCssTargetDir.exists() || !tempCssTargetDir.isDirectory()) {
			if (!tempCssTargetDir.mkdirs()) {
				throw new IOException("Failed to create CSS target directory");
			}
		}

		File tempJsTargetDir = new File(aTargetDir, "resources/js");
		if (!tempJsTargetDir.exists() || !tempJsTargetDir.isDirectory()) {
			if (!tempJsTargetDir.mkdirs()) {
				throw new IOException("Failed to create JS target directory");
			}
		}

		copySingleResource("css/main.css", new File(tempCssTargetDir, "main.css"));
		copySingleResource("js/lunr.js", new File(tempJsTargetDir, "lunr.js"));
		copySingleResource("js/lunr_config.js", new File(tempJsTargetDir, "lunr_config.js"));
		copySingleResource("js/mark.js", new File(tempJsTargetDir, "mark.js"));
		copySingleResource("js/search.js", new File(tempJsTargetDir, "search.js"));
		copySingleResource("js/package.js", new File(tempJsTargetDir, "package.js"));
	}

	/**
	 * Copies a single resource to the target file.
	 * 
	 * @param aResourceName
	 * @param aTarget
	 * @throws IOException
	 */
	protected void copySingleResource(String aResourceName, File aTarget) throws IOException {
		try (InputStream tempStream = getResourceAsStream(aResourceName)) {
			Files.copy(tempStream, aTarget.getAbsoluteFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	/**
	 * Opens a stream to read the given resource from the classpath. Assumes resources are present under a fixed
	 * subdirectory.
	 * 
	 * @param aResourceName
	 *            the name of the resource
	 * @return the resource stream
	 * @throws FileNotFoundException
	 *             if the resource is not found
	 */
	protected InputStream getResourceAsStream(String aResourceName) throws FileNotFoundException {
		InputStream tempStream = getClass().getResourceAsStream("/docgen-resources/" + aResourceName);
		if (tempStream == null) {
			throw new FileNotFoundException("Failed to find docgen resource '" + aResourceName + "' in JAR file");
		}

		return tempStream;
	}

}
