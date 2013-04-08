/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

/**
 * This enum offers various ways in which unresolvable variables are to be handled during conversions.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum UnresolvableVariableHandling {

	/**
	 * Throw an exception.
	 */
	EXCEPTION,

	/**
	 * Resolve to null (the value, not the string 'null').
	 */
	RESOLVE_TO_NULL_VALUE,

	/**
	 * Resolve to the string 'null'.
	 */
	RESOLVE_TO_NULL_STRING,

	/**
	 * Resolve to a string with the name of the variable.
	 */
	RESOLVE_TO_NAME_STRING,

	/**
	 * Resolve to the string '???'.
	 */
	RESOLVE_TO_QUESTIONMARK_STRING,

	/**
	 * Keep the variable reference as-is.
	 */
	KEEP_UNRESOLVED;

}
