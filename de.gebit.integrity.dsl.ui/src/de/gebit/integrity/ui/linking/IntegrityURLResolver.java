/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.linking;

/**
 * The {@link IntegrityURLResolver} is responsible to resolve integrity:// URLs.
 * 
 * @author Rene Schneider - initial API and implementation
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
