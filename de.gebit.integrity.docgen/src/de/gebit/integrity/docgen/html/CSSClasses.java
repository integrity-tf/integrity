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
	 * Makes text bold.
	 */
	String BOLD = "bold";

	/**
	 * Italic text.
	 */
	String ITALIC = "italic";

	/**
	 * Large header text.
	 */
	String HEADER_1 = "header1";

	/**
	 * Smaller header text.
	 */
	String HEADER_2 = "header2";

	/**
	 * Used for parameter/result names.
	 */
	String PARAMNAME = "paramname " + CODE;

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

	/**
	 * Just entities.
	 */
	String ENTITY = "entity";

	/**
	 * Simple entity names.
	 */
	String ENTITYNAME = "entityname";

	/**
	 * Entity titles.
	 */
	String ENTITYTITLE = "entitytitle";

	/**
	 * Fully qualified entity names.
	 */
	String FULLENTITYNAME = "fullentityname";

	/**
	 * The header of entity boxes.
	 */
	String ENTITYHEADER = "entityheader";

	/**
	 * Defines the box that entities are in.
	 */
	String ENTITYBOX = "entitybox";

	/**
	 * Details for entities.
	 */
	String ENTITYDETAILS = "entitydetails";

	/**
	 * Entity summaries.
	 */
	String ENTITYSUMMARY = "entitysummary";

	/**
	 * Detailed descriptions about entities.
	 */
	String ENTITYDESCRIPTION = "entitydescription";

	/**
	 * Entity parameters.
	 */
	String ENTITYPARAMS = "entityparams";

	/**
	 * Smaller title for sections in details.
	 */
	String DETAILSTITLE = "detailstitle";

}
