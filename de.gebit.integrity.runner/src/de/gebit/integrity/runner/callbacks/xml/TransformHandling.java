/**
 * 
 */
package de.gebit.integrity.runner.callbacks.xml;

/**
 * Enumerating the various ways in which the test runner can handle the supported transformation of the XML results into
 * a human-viewable HTML form.
 * 
 * @author Rene Schneider
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
