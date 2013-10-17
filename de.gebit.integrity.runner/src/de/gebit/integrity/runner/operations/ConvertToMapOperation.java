/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.operations;

import java.util.Map;

import com.google.inject.Inject;

import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.operations.custom.Operation;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * This operation converts a given single parameter to a key-value-pair map. Meant to be used like:<br>
 * <br>
 * (aVariableWithABeanObject asMap)<br>
 * 
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConvertToMapOperation implements Operation<Object, Object, Map<String, Object>> {

	/**
	 * The value converter being used.
	 */
	@Inject
	protected ValueConverter valueConverter;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> execute(Object aParameter, Object anUnusedSecondParameter) {
		if (aParameter == null) {
			return null;
		}
		if (aParameter.getClass().isArray()) {
			throw new IllegalArgumentException("Arrays are not supported by this operation");
		}

		try {
			return (Map<String, Object>) valueConverter.convertValue(Map.class, aParameter,
					UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
		} catch (UnresolvableVariableException exc) {
			throw new ThisShouldNeverHappenException("Unresolvable variables should be resolved to null");
		} catch (UnexecutableException exc) {
			throw new RuntimeException(exc);
		}
	}
}
