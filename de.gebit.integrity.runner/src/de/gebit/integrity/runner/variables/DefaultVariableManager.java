/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.variables;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * The simple, default variable manager which keeps variables in a map.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultVariableManager implements VariableManager {

	/**
	 * The map used to store variables.
	 */
	protected Map<VariableOrConstantEntity, Object> variableMap = new HashMap<VariableOrConstantEntity, Object>();

	/**
	 * The current test model.
	 */
	@Inject
	protected TestModel model;

	/**
	 * The parameter resolver.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The value converter.
	 */
	@Inject
	protected ValueConverter valueConverter;

	@Override
	public Object get(VariableOrConstantEntity anEntity) {
		return variableMap.get(anEntity);
	}

	@Override
	public boolean isDefined(VariableOrConstantEntity anEntity) {
		return variableMap.containsKey(anEntity);
	}

	@Override
	public Object get(Variable aVariable) {
		Object tempObject = get(aVariable.getName());

		if (aVariable.getAttribute() != null && tempObject != null) {
			// The attribute value may be a path to nested objects
			String[] tempAttributeParts = aVariable.getAttribute().split("\\.");

			outer: for (String tempAttributePart : tempAttributeParts) {
				try {
					for (PropertyDescriptor tempDescriptor : Introspector
							.getBeanInfo(tempObject.getClass(), Object.class).getPropertyDescriptors()) {
						if (tempDescriptor.getName().equals(tempAttributePart)) {
							Method tempReadMethod = tempDescriptor.getReadMethod();
							if (tempReadMethod != null && Modifier.isPublic(tempReadMethod.getModifiers())) {
								try {
									tempObject = tempReadMethod.invoke(tempObject);

									if (tempObject == null) {
										return null;
									}

									continue outer;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException exc) {
									throw new RuntimeException("Failed to read attribute '" + aVariable.getAttribute()
											+ "' in bean class " + tempObject.getClass().getName(), exc);
								}
							}
						}
					}

					// No matching property was found
					throw new RuntimeException("Did not find readable attribute '" + aVariable.getAttribute()
							+ "' in bean class " + tempObject.getClass().getName());
				} catch (IntrospectionException exc) {
					throw new RuntimeException("Failed to introspect bean class " + tempObject.getClass().getName(),
							exc);
				}
			}

			// Now, the target value is found
			return tempObject;
		} else {
			return tempObject;
		}
	}

	@Override
	public boolean isDefined(Variable aVariable) {
		Object tempObject = get(aVariable.getName());

		if (aVariable.getAttribute() != null && tempObject != null) {
			// Probe for a runtime exception during resolving of a potentially embedded nested object path
			try {
				get(aVariable);
			} catch (RuntimeException exc) {
				return false;
			}
			return true;
		}

		return tempObject != null || variableMap.containsKey(aVariable.getName());
	}

	@Override
	public void set(VariableOrConstantEntity anEntity, Object aValue) {
		if (anEntity instanceof ConstantEntity) {
			if (variableMap.containsKey(anEntity)) {
				throw new RuntimeException("Illegal attempt to redefine a constant: " + anEntity.getName());
			}
		}
		variableMap.put(anEntity, aValue);
	}

	@Override
	public void unset(VariableOrConstantEntity anEntity) {
		variableMap.remove(anEntity);
	}

	@Override
	public Map<String, Object> dumpVariableState(VariantDefinition aCurrentVariant) {
		Map<String, Object> tempResult = new HashMap<>();

		for (Entry<VariableOrConstantEntity, Object> tempEntry : variableMap.entrySet()) {
			Object tempValue = tempEntry.getValue();
			// try {
			// if (tempValue instanceof ValueOrEnumValueOrOperationCollection) {
			// tempValue = parameterResolver.resolveStatically((ValueOrEnumValueOrOperationCollection) tempValue,
			// aCurrentVariant);
			// } else if (tempValue instanceof ValueOrEnumValueOrOperation) {
			// tempValue = parameterResolver.resolveStatically((ValueOrEnumValueOrOperation) tempValue,
			// aCurrentVariant);
			// } else if (tempValue instanceof VariableOrConstantEntity) {
			// tempValue = parameterResolver.resolveStatically((VariableOrConstantEntity) tempValue,
			// aCurrentVariant);
			// }
			// } catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
			// exc.printStackTrace();
			// tempValue = null;
			// }
			try {
				tempValue = valueConverter.convertValue(null, tempValue, null);
			} catch (UnresolvableVariableException | UnexecutableException exc) {
				exc.printStackTrace();
				tempValue = null;
			}

			tempResult.put(IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntry.getKey(), true), tempValue);
		}

		return tempResult;
	}

	@Override
	public void importVariableState(Map<String, Object> aState) {
		for (Entry<String, Object> tempEntry : aState.entrySet()) {
			VariableOrConstantEntity tempEntity = model.getVariableOrConstantByName(tempEntry.getKey());
			if (tempEntity != null) {
				set(tempEntity, tempEntry.getValue());
			}
		}
	}

	@Override
	public void clear(boolean aClearConstantsFlag) {
		if (aClearConstantsFlag) {
			variableMap.clear();
		} else {
			// Pick all non-constants out of the map, leave the constants untouched.
			Iterator<Entry<VariableOrConstantEntity, Object>> tempIterator = variableMap.entrySet().iterator();
			while (tempIterator.hasNext()) {
				if (!(tempIterator.next().getKey() instanceof ConstantEntity)) {
					tempIterator.remove();
				}
			}
		}
	}

}
