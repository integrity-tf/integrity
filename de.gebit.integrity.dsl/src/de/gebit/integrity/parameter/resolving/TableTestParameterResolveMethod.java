/*******************************************************************************
 * Copyright (c) 2015 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.resolving;

/**
 *
 * Table test parameters may be resolved with different scope.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public enum TableTestParameterResolveMethod {

	/**
	 * Resolve both kinds of tabletest parameters: those that are provided for all lines, and those that are provided
	 * individually per line.
	 */
	COMBINED,

	/**
	 * Only resolve parameters for which a value is provided individually per line.
	 */
	ONLY_INDIVIDUAL,

	/**
	 * Only resolve parameters for which a value is provided that is the same for all lines.
	 */
	ONLY_COMMON;

}
