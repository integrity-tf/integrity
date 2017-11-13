/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This class wraps the Lunr JavaScript search engine used to implement client-side search functionality. It executes
 * the index builder to pre-build the index.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class LunrIndexBuilder {

	/**
	 * The JS engine used.
	 */
	private ScriptEngine jsEngine;

	/**
	 * Constructor. Performs JS engine init.
	 * 
	 * @throws IOException
	 */
	public LunrIndexBuilder() throws IOException {
		jsEngine = new ScriptEngineManager().getEngineByName("nashorn");

		loadJavascriptFile("lunr.js");
		loadJavascriptFile("lunr_config.js");

		try {
			jsEngine.eval("var lunrIndexBuilder = new lunr.Builder(); " + "lunrIndexBuilder.ref('id'); "
					+ "lunrIndexBuilder.field('content');");
		} catch (ScriptException exc) {
			throw new IOException("Failed to initialize Lunr index", exc);
		}
	}

	/**
	 * Used to load a JS source file into the {@link #jsEngine}.
	 * 
	 * @param aFilename
	 * @throws IOException
	 */
	protected void loadJavascriptFile(String aFilename) throws IOException {
		try (InputStream tempStream = getResourceAsStream("js/" + aFilename)) {
			try {
				jsEngine.eval(new InputStreamReader(tempStream, StandardCharsets.ISO_8859_1));
			} catch (ScriptException exc) {
				throw new IOException("Failed to parse Lunr JavaScript", exc);
			}
		}
	}

	/**
	 * Adds the provided document to the index.
	 * 
	 * @param anId
	 * @param aDocumentContent
	 */
	public void addToIndex(String anId, String aDocumentContent) {
		try {
			Invocable tempInvocable = (Invocable) jsEngine;

			Map<String, String> tempDocument = new HashMap<>();
			tempDocument.put("id", anId);
			tempDocument.put("content", aDocumentContent);

			tempInvocable.invokeMethod(jsEngine.get("lunrIndexBuilder"), "add", tempDocument);
		} catch (ScriptException | NoSuchMethodException exc) {
			throw new RuntimeException("Failed to add document to Lunr index", exc);
		}
	}

	/**
	 * Builds the actual index. This finalizes the index - you cannot add any more documents afterwards!
	 * 
	 * @return the index as JSON string
	 * @throws IOException
	 */
	public String build() throws IOException {
		try {
			jsEngine.eval("var lunrIndex = lunrIndexBuilder.build();"
					+ "var lunrIndexJSON = JSON.stringify({index: lunrIndex});");

			return (String) jsEngine.get("lunrIndexJSON");
		} catch (ScriptException exc) {
			throw new IOException("Failed to initialize Lunr index", exc);
		}
	}

	/**
	 * Builds the actual index. This finalizes the index - you cannot add any more documents afterwards! This also
	 * writes the index into a JS file.
	 * 
	 * @param aTargetFile
	 * @throws IOException
	 */
	public void build(File aTargetFile) throws IOException {
		try (FileWriter tempWriter = new FileWriter(aTargetFile)) {
			tempWriter.write("var lunrIndexJSON=");
			tempWriter.write(build());
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
