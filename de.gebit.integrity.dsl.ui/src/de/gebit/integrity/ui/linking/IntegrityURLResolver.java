/**
 * 
 */
package de.gebit.integrity.ui.linking;

/**
 * The {@link IntegrityURLResolver} is responsible to resolve integrity:// URLs.
 * 
 * @author Slartibartfast
 * 
 */
public interface IntegrityURLResolver {

	/**
	 * Parses an Integrity URL and jumps to the specified suite and line, if possible.
	 * 
	 * @param anURL
	 *            the URL to parse
	 * @return true if the URL matches the Integrity URL pattern, false if not
	 */
	boolean parseURL(String anURL);

}
