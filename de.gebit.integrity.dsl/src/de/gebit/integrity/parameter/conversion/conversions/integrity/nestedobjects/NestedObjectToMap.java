/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import java.util.Map;
import java.util.TreeMap;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@SuppressWarnings("rawtypes")
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class NestedObjectToMap extends Conversion<NestedObject, Map> {

	@Override
	public Map convert(NestedObject aSource, Class<? extends Map> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		// Using a Tree Map here for values ordered by key
		Map<String, Object> tempKeyValueMap = new TreeMap<String, Object>();
		for (KeyValuePair tempAttribute : aSource.getAttributes()) {
			Object tempConvertedValue;
			try {
				tempConvertedValue = convertValueRecursive(null, null, tempAttribute.getValue(),
						anUnresolvableVariableHandlingPolicy);
			} catch (ClassNotFoundException exc) {
				throw new ConversionFailedException(aSource.getClass(), Map.class, null, exc);
			} catch (UnexecutableException exc) {
				throw new ConversionFailedException(aSource.getClass(), Map.class, null, exc);
			} catch (InstantiationException exc) {
				throw new ConversionFailedException(aSource.getClass(), Map.class, null, exc);
			}

			tempKeyValueMap.put(tempAttribute.getIdentifier(), tempConvertedValue);
		}

		return tempKeyValueMap;
	}

}
