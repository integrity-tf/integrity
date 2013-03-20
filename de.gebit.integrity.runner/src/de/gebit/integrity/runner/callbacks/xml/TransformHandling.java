/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks.xml;

/**
 * Enumerating the various ways in which the test runner can handle the supported transformation of the XML results into
 * a human-viewable HTML form.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum TransformHandling {

	/**
	 * Just keep the plain XML.
	 */
	NO_TRANSFORM,

	/**
	 * The XSLT transformation script that transforms the XML result data into a viewable HTML document shall be
	 * embedded into the result.
	 */
	EMBED_TRANSFORM,

	/**
	 * The XSLT transformation script that transforms the XML result data into a viewable HTML document shall be
	 * directly executed on the result. The resulting HTML document will still contain the complete, raw XML data tree
	 * in an invisible element, since it's required by some of the Javascript elements of the document, and because the
	 * "single result file with all information" concept requires this.
	 */
	EXECUTE_TRANSFORM;

}
