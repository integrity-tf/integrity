/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.util.Optional;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * This conversion is necessary to allow {@link Optional}s to be used as parameters. It basically resolves them to the
 * contained object (which may have to be converted further afterwards).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE + 1)
public class OptionalToContainedObject extends Conversion<Optional, Object> {

	@Override
	public Object convert(Optional aSource, Class<? extends Object> aTargetType, ConversionContext aConversionContext)
			throws ConversionFailedException {
		if (aSource.isPresent()) {
			try {
				return convertValueRecursive(aTargetType, null, aSource.get(), aConversionContext);
			} catch (UnresolvableVariableException | ClassNotFoundException | InstantiationException
					| UnexecutableException exc) {
				throw new ConversionFailedException(aSource.getClass(), aTargetType,
						"Failed recursive conversion of Optional content", exc);
			}
		} else {
			if (aTargetType == null || FormattedString.class.isAssignableFrom(aTargetType)) {
				return new FormattedString(ParameterUtil.INEXISTENT_VALUE);
			} else if (String.class.isAssignableFrom(aTargetType)) {
				return ParameterUtil.INEXISTENT_VALUE;
			} else {
				// We can't convert this to any value with which we may preserve the knowledge about the "empty
				// Optional". So we fall back to "null".
				return null;
			}
		}
	}

}
