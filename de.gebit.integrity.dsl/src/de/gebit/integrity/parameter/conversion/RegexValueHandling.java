/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import de.gebit.integrity.dsl.RegexValue;

/**
 * This enum offers various ways in which regex values ({@link RegexValue}) may be handled during conversion.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public enum RegexValueHandling {

	/**
	 * Regex values should be converted normally - which most likely means they will end up as a {@link String}.
	 * <p>
	 * This is the default if not specified otherwise in a {@link ConversionContext}.
	 */
	CONVERT,

	/**
	 * Regex values will not be converted.
	 */
	KEEP_AS_IS;

}
