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
import java.util.concurrent.ConcurrentHashMap;

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
import de.gebit.integrity.parameter.variables.VariableOrConstantEntityInitialValueDefinitionCallback;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.TestRunner;
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
	 * System property to enable writing variable access trace output.
	 */
	protected static final String ENABLE_VARIABLES_TRACE_OUTPUT = "integrity.variables.trace";

	/**
	 * System property to enable writing variable access stacktrace output. If this is set,
	 * {@link #ENABLE_VARIABLES_TRACE_OUTPUT} is automatically true as well.
	 */
	protected static final String ENABLE_VARIABLES_STACKTRACE_OUTPUT = "integrity.variables.stacktrace";

	/**
	 * Whether variable tracing is enabled.
	 */
	protected boolean isStacktracingEnabled = Boolean.getBoolean(ENABLE_VARIABLES_STACKTRACE_OUTPUT);

	/**
	 * Whether variable tracing is enabled.
	 */
	protected boolean isTracingEnabled = isStacktracingEnabled || Boolean.getBoolean(ENABLE_VARIABLES_TRACE_OUTPUT);

	/**
	 * The map used to store variables.
	 */
	protected Map<VariableOrConstantEntity, Object> variableMap = new ConcurrentHashMap<VariableOrConstantEntity, Object>();

	/**
	 * This is a special null-representing object to be used to insert a logical "null" value into {@link #variableMap}
	 * (ConcurrentHashMap is important for performance purposes during concurrent variable/constant init, but does not
	 * support null values, which we unfortunately need).
	 */
	protected static final Object NULL = new Object();

	/**
	 * Helper method for {@link #NULL}.
	 * 
	 * @param aValue
	 * @return
	 */
	protected static Object makeNull(Object aValue) {
		return (aValue == null) ? NULL : aValue;
	}

	/**
	 * Helper method for {@link #NULL}.
	 * 
	 * @param aValue
	 * @return
	 */
	protected static Object restoreNull(Object aValue) {
		return (aValue == NULL) ? null : aValue;
	}

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

	/**
	 * A callback that can be used to trigger a lazy definition of the initial value of a constant or variable, if such
	 * a definition has not already been found to be done (= there is a value present in the {@link #variableMap}). This
	 * callback must be injected from the outside, as the variable manager is not able to actually perform a
	 * variable/constant resolving by itself, but relies on someone else (usually the {@link TestRunner}) to perform any
	 * variable value setting.
	 */
	protected VariableOrConstantEntityInitialValueDefinitionCallback constantResolver;

	@Override
	public void setInitialValueResolverCallback(
			VariableOrConstantEntityInitialValueDefinitionCallback aConstantResolver) {
		constantResolver = aConstantResolver;
	}

	@Override
	public Object get(VariableOrConstantEntity anEntity) {
		performLazyDefinitionIfNecessary(anEntity);

		return restoreNull(variableMap.get(anEntity));
	}

	/**
	 * Checks whether a given {@link VariableOrConstantEntity} is already defined in our map. If it isn't and we had a
	 * {@link VariableOrConstantEntityInitialValueDefinitionCallback} provided to us, a lazy initial value definition is
	 * triggered through this callback.
	 */
	protected void performLazyDefinitionIfNecessary(VariableOrConstantEntity anEntity) {
		if (!variableMap.containsKey(anEntity)) {
			if (constantResolver != null) {
				constantResolver.triggerDefinition(anEntity);
			}
		}
	}

	@Override
	public boolean isDefined(VariableOrConstantEntity anEntity) {
		if (variableMap.containsKey(anEntity)) {
			return true;
		} else {
			performLazyDefinitionIfNecessary(anEntity);
			return variableMap.containsKey(anEntity);
		}
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
		if (aVariable.getAttribute() != null) {
			if (isDefined(aVariable.getName())) {
				// Probe for a runtime exception during resolving of a potentially embedded nested object path
				try {
					get(aVariable);
				} catch (RuntimeException exc) {
					return false;
				}
				return true;
			} else {
				return false;
			}
		} else {
			return isDefined(aVariable.getName());
		}
	}

	@Override
	public void set(VariableOrConstantEntity anEntity, Object aValue) {
		set(anEntity, aValue, false);
	}

	/**
	 * Internal variant of {@link #set(VariableOrConstantEntity, Object)}. Exists to add the suppression of trace
	 * output.
	 * 
	 * @param anEntity
	 * @param aValue
	 * @param aSuppressTraceLogFlag
	 */
	protected void set(VariableOrConstantEntity anEntity, Object aValue, boolean aSuppressTraceLogFlag) {
		if (anEntity instanceof ConstantEntity) {
			if (variableMap.containsKey(anEntity)) {
				// Already known; ignoring this redefinition. Constant redefinitions can happen due to fork/master
				// communication, but they aren't a problem, so we can silently ignore them. In earlier versions, an
				// exception was thrown in this case and situations of redefinitions were actively prevented from
				// occurring. With the implementation of lazy constant definition however, actively preventing such
				// situations got even more complex than it was (and it was already some kind of hell), which is why
				// this was changed in response to issue #188 to just ignore redefinitions.
				return;
			}
		}

		if (isTracingEnabled && !aSuppressTraceLogFlag) {
			traceLog("set", IntegrityDSLUtil.getQualifiedVariableEntityName(anEntity, true) + " = "
					+ valueConverter.convertValueToString(aValue, false, null));
		}

		variableMap.put(anEntity, makeNull(aValue));
	}

	@Override
	public void unset(VariableOrConstantEntity anEntity) {
		if (isTracingEnabled) {
			traceLog("unset", IntegrityDSLUtil.getQualifiedVariableEntityName(anEntity, true));
		}

		variableMap.remove(anEntity);
	}

	@Override
	public Map<String, Object> dumpVariableState(VariantDefinition aCurrentVariant) {
		Map<String, Object> tempResult = new HashMap<>();

		for (Entry<VariableOrConstantEntity, Object> tempEntry : variableMap.entrySet()) {
			Object tempValue = restoreNull(tempEntry.getValue());
			try {
				tempValue = valueConverter.convertValue(null, tempValue, null);
			} catch (UnresolvableVariableException | UnexecutableException exc) {
				exc.printStackTrace();
				tempValue = null;
			}

			if (isTracingEnabled) {
				traceLog("dumped", IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntry.getKey(), true) + " = "
						+ valueConverter.convertValueToString(tempValue, false, null));
			}

			tempResult.put(IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntry.getKey(), true), tempValue);
		}

		return tempResult;
	}

	@Override
	public void importVariableState(Map<String, Object> aState) {
		for (Entry<String, Object> tempEntry : aState.entrySet()) {
			VariableOrConstantEntity tempEntity = model.getVariableOrConstantByName(tempEntry.getKey());

			if (isTracingEnabled) {
				traceLog("imported", IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true) + " = "
						+ valueConverter.convertValueToString(tempEntry.getValue(), false, null));
			}

			if (tempEntity != null) {
				set(tempEntity, tempEntry.getValue(), true);
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

	/**
	 * Outputs a trace log. Although this checks for {@link #isTracingEnabled}, the caller may also check to save some
	 * cycles when generating expensive parameters.
	 * 
	 * @param anAction
	 *            the action
	 * @param aLogMessage
	 *            the message to log
	 */
	protected void traceLog(String anAction, String aLogMessage) {
		if (isTracingEnabled) {
			System.out.println("--> VARIABLE " + anAction.toUpperCase() + ": " + aLogMessage);
			if (isStacktracingEnabled) {
				Thread.dumpStack();
			}
		}
	}

}
