/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import de.gebit.integrity.dsl.EmptyValue;
import de.gebit.integrity.utils.ParameterUtil;

/**
 * This enum offers various ways in which empty values ({@link EmptyValue}) may be handled during conversion.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public enum EmptyValueHandling {

	/**
	 * Empty values should be converted normally - which most likely means they will end up as a {@link String}.
	 * However, the String won't be just any object, but the specific, reserved instance
	 * {@link ParameterUtil#EMPTY_VALUE} (so even if converted, one could perform an instance comparison to specifically
	 * detect empty values - however, this is discouraged and should only be used if it is not possible to simply turn
	 * off conversion of inexistent values via {@link #KEEP_AS_IS}).
	 * <p>
	 * This is the default if not specified otherwise in a {@link ConversionContext}.
	 */
	CONVERT,

	/**
	 * Empty values will not be converted.
	 */
	KEEP_AS_IS;

}
