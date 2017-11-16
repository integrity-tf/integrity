/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

/**
 * Common class names in the docgen CSS.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface CSSClasses {

	/**
	 * Used for all code elements.
	 */
	String CODE = "code";

	/**
	 * Used for mandatory stuff (in combination with {@link #CODE}).
	 */
	String MANDATORY = "mandatory";

	/**
	 * Stuff that is by default hidden.
	 */
	String HIDDEN = "hidden";

	/**
	 * Table cells that should be as small as possible.
	 */
	String SHRINK = "shrink";

	/**
	 * Table cells that should expand as much as possible.
	 */
	String EXPAND = "expand";

}
