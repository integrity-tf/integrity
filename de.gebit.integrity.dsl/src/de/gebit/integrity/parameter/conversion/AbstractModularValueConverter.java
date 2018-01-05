/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantValue;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.operations.custom.CustomOperationWrapper;
import de.gebit.integrity.operations.standard.StandardOperationProcessor;
import de.gebit.integrity.parameter.conversion.Conversion.Priority;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.AbstractNestedObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.ObjectToObject;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToMap;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.string.FormattedStringElement;
import de.gebit.integrity.utils.JavaTypeUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * Abstract base class for a value converter which uses conversion classes to determine how a given value is to be
 * converted into a desired form. This modularity makes it easy to extend the converter with additional conversions.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractModularValueConverter implements ValueConverter {

	/**
	 * The parameter resolver.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The variable manager.
	 */
	@Inject(optional = true)
	protected VariableManager variableManager;

	/**
	 * The wrapper factory.
	 */
	@Inject(optional = true)
	protected WrapperFactory wrapperFactory;

	/**
	 * The processor for standard operations.
	 */
	@Inject
	protected StandardOperationProcessor standardOperationProcessor;

	/**
	 * The Guice injector. Required to inject stuff into instances of conversions.
	 */
	@Inject
	protected Injector injector;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

	/**
	 * All known conversions.
	 */
	private final Map<ConversionKey, Class<? extends Conversion<?, ?>>> conversions = new HashMap<ConversionKey, Class<? extends Conversion<?, ?>>>();

	/**
	 * Conversions derived from the directly added conversions by searching superclasses of the target type.
	 */
	private final Map<ConversionKey, List<Class<? extends Conversion<?, ?>>>> derivedConversions = new HashMap<ConversionKey, List<Class<? extends Conversion<?, ?>>>>();

	/**
	 * Reverse index of all known conversions.
	 */
	private final Map<Class<? extends Conversion<?, ?>>, ConversionKey> conversionToKey = new HashMap<Class<? extends Conversion<?, ?>>, ConversionKey>();

	/**
	 * The default conversions for all known source types. These are the conversions with the highest priority from
	 * their respective source types' conversion pool.
	 */
	private final Map<Class<?>, Class<? extends Conversion<?, ?>>> defaultConversions = new HashMap<Class<?>, Class<? extends Conversion<?, ?>>>();

	/**
	 * The current defaults' priority. Used to fill the {@link #defaultConversions} map.
	 */
	private final Map<Class<?>, Integer> conversionPriority = new HashMap<Class<?>, Integer>();

	/**
	 * These classes mark endpoints after which further search for conversions isn't practical anymore.
	 */
	private final Set<Class<?>> conversionSearchBlockers = new HashSet<Class<?>>();

	/**
	 * Implement this method to initialize known conversions.
	 * 
	 */
	protected abstract void initializeConversions();

	/**
	 * Initializes the contents of {@link #conversionSearchBlockers}.
	 */
	protected void initializeSearchBlockers() {
		conversionSearchBlockers.add(java.io.Serializable.class);
		// conversionSearchBlockers.add(java.lang.Object.class);
	}

	/**
	 * Default constructor. Initializes all conversions and search blockers.
	 */
	public AbstractModularValueConverter() {
		initializeConversions();
		initializeSearchBlockers();
	}

	@Override
	public Object convertValue(Class<?> aTargetType, Object aValue, ConversionContext aConversionContext)
			throws UnresolvableVariableException, UnexecutableException {
		return convertValue(aTargetType, null, aValue, aConversionContext);
	}

	@Override
	public Object convertValue(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			ConversionContext aConversionContext) throws UnresolvableVariableException, UnexecutableException {
		return convertValue(aTargetType, aParameterizedType, aValue, aConversionContext, new HashSet<Object>());
	}

	/**
	 * Extended version of #convertValue(Class, Class, Object, UnresolvableVariableHandling).
	 * 
	 * @param aTargetType
	 * @param aParameterizedType
	 * @param aValue
	 * @param aConversionContext
	 * @param someVisitedObjects
	 * @return
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	public Object convertValue(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			ConversionContext aConversionContext, Set<Object> someVisitedObjects)
			throws UnresolvableVariableException, UnexecutableException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		if (someVisitedObjects.contains(aValue)) {
			// endless loop protection
			return null;
		} else {
			try {
				someVisitedObjects.add(aValue);
				if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
					return convertEncapsulatedValueCollectionToTargetType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperationCollection) aValue, tempConversionContext, someVisitedObjects);
				} else if (aValue instanceof ValueOrEnumValueOrOperation) {
					return convertEncapsulatedValueToTargetType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperation) aValue, tempConversionContext, someVisitedObjects);
				} else if (aValue instanceof ConstantValue) {
					return convertEncapsulatedConstantValueToTargetType(aTargetType, aParameterizedType,
							(ConstantValue) aValue, tempConversionContext, someVisitedObjects);
				} else {
					return convertPlainValueToTargetType(aTargetType, aParameterizedType, aValue, tempConversionContext,
							someVisitedObjects);
				}
			} finally {
				someVisitedObjects.remove(aValue);
			}
		}
	}

	/**
	 * Converts a given plain value (no instance of {@link ValueOrEnumValueOrOperation} or
	 * {@link ValueOrEnumValueOrOperationCollection}) to a given Java type class, if possible.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized (via generics) type attached to the given target type, if applicable - for example
	 *            if a conversion to List<Integer> is desired, the target type is List, and the parameterized type is
	 *            Integer
	 * @param aValue
	 *            the value
	 * @param aConversionContext
	 *            defines some parameters controlling how the conversion is done in detail
	 * @return the converted value
	 */
	protected Object convertPlainValueToTargetType(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			ConversionContext aConversionContext, Set<Object> someVisitedValues) {
		if (aValue == null) {
			return null;
		}

		if (aTargetType != null && aTargetType.isArray()) {
			if (String.class.isAssignableFrom(aValue.getClass())
					|| StringValue.class.isAssignableFrom(aValue.getClass())) {
				// Could be special case of issue #66: single string to byte array
				// I admit that this stuff is not beautiful, but it works, and byte arrays should be the only special
				// case of this kind so a more decoupled solution like with the normal conversions seems like a bit of
				// overkill here.
				if (aTargetType.getComponentType() == Byte.class) {
					if (String.class.isAssignableFrom(aValue.getClass())) {
						return handleConversionOfStringToByteWrapperArray((String) aValue);
					} else if (StringValue.class.isAssignableFrom(aValue.getClass())) {
						return handleConversionOfStringValueToByteWrapperArray((StringValue) aValue);
					}
				} else if (aTargetType.getComponentType() == byte.class) {
					if (String.class.isAssignableFrom(aValue.getClass())) {
						return handleConversionOfStringToByteArray((String) aValue);
					} else if (StringValue.class.isAssignableFrom(aValue.getClass())) {
						return handleConversionOfStringValueToByteArray((StringValue) aValue);
					}
				}
			}

			Class<?> tempActualParamType = aTargetType.getComponentType();
			Object tempResultArray;
			if (aValue.getClass().isArray()) {
				// both are arrays

				// Just in case there's a nested object path property set in our conversion context: we need to extend
				// that property by the position within the array, and reset it later to the original plain value. This
				// is necessary to distinguish between array elements when converting to formatted strings (there's
				// highlighting being added based on these paths). In all other conversion cases it at least doesn't
				// hurt.
				String tempBaseObjectPath = (String) aConversionContext
						.getProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY);

				tempResultArray = Array.newInstance(tempActualParamType, Array.getLength(aValue));
				for (int i = 0; i < Array.getLength(aValue); i++) {
					if (tempBaseObjectPath != null) {
						aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
								tempBaseObjectPath + "#" + i);
					}
					Array.set(tempResultArray, i, convertPlainValueToTargetType(tempActualParamType, aParameterizedType,
							Array.get(aValue, i), aConversionContext, someVisitedValues));
				}

				if (tempBaseObjectPath != null) {
					aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
							tempBaseObjectPath);
				}
			} else {
				// target is an array, but value is a single value
				tempResultArray = Array.newInstance(tempActualParamType, 1);
				Array.set(tempResultArray, 0, convertPlainValueToTargetType(tempActualParamType, aParameterizedType,
						aValue, aConversionContext, someVisitedValues));
			}
			return tempResultArray;
		} else {
			if (aValue.getClass().isArray()) {
				if (aTargetType != null) {
					if (Array.getLength(aValue) == 0) {
						return null;
					} else if (Array.getLength(aValue) == 1) {
						return convertSingleValueToTargetType(aTargetType, aParameterizedType, Array.get(aValue, 0),
								aConversionContext, someVisitedValues);
					}
				} else {
					Class<?> tempCurrentArrayType = transformPrimitiveTypes(aValue.getClass().getComponentType());
					Class<?> tempTargetArrayType;

					if (tempCurrentArrayType == Object.class) {
						// If it's an object array, guessing by querying the conversions wouldn't lead to meaningful
						// results. So all that's left for us is to create an object array as target.
						tempTargetArrayType = Object.class;
					} else {
						// The arrays' target type is determined by looking at the conversion being used
						Class<? extends Conversion<?, ?>> tempConversionClass = findConversion(tempCurrentArrayType,
								aTargetType, someVisitedValues, aConversionContext);
						ConversionKey tempKey = conversionToKey.get(tempConversionClass);
						tempTargetArrayType = tempKey.getTargetType();
					}

					// Just in case there's a nested object path property set in our conversion context: we need to
					// extend
					// that property by the position within the array, and reset it later to the original plain value.
					// This
					// is necessary to distinguish between array elements when converting to formatted strings (there's
					// highlighting being added based on these paths). In all other conversion cases it at least doesn't
					// hurt.
					String tempBaseObjectPath = (String) aConversionContext
							.getProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY);

					Object tempArray = Array.newInstance(tempTargetArrayType, Array.getLength(aValue));

					for (int i = 0; i < Array.getLength(aValue); i++) {
						if (tempBaseObjectPath != null) {
							aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
									tempBaseObjectPath + "#" + i);
						}

						Object tempConvertedValue = convertSingleValueToTargetType(aTargetType, aParameterizedType,
								Array.get(aValue, i), aConversionContext, someVisitedValues);

						if (!tempTargetArrayType.isAssignableFrom(tempConvertedValue.getClass())) {
							// Oops - this case is pretty unlikely, but theoretically possible. In this case, the
							// heuristic approach of guessing a proper target array type above hasn't worked out, since
							// after conversion, one particular value doesn't fit in the new array. We'll fall back to
							// an object array in that case.
							tempTargetArrayType = Object.class;
							Object tempOldArray = tempArray;
							tempArray = Array.newInstance(tempTargetArrayType, Array.getLength(aValue));
							System.arraycopy(tempOldArray, 0, tempArray, 0, i);
						}

						Array.set(tempArray, i, tempConvertedValue);
					}

					if (tempBaseObjectPath != null) {
						aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
								tempBaseObjectPath);
					}

					return tempArray;
				}

				// this is not convertible, but since this method does not guarantee any conversion...
				return aValue;
			} else {
				// unresolvable variables can't happen here, since variable values should have gone down the other path
				return convertSingleValueToTargetType(aTargetType, aParameterizedType, aValue, aConversionContext,
						someVisitedValues);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Object convertSingleValueToTargetType(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			ConversionContext aConversionContext, Set<Object> someVisitedValues) {
		if (aValue == null) {
			return null;
		}

		// It is possible that we arrive here with a single value, but still a target type that's an array. In that case
		// we need to create the requested array, but it will only have one element.
		if (aTargetType != null && aTargetType.isArray()) {
			Object tempResultArray = Array.newInstance(aTargetType.getComponentType(), 1);
			Array.set(tempResultArray, 0, convertSingleValueToTargetType(aTargetType.getComponentType(),
					aParameterizedType, aValue, aConversionContext, someVisitedValues));
			return tempResultArray;
		}

		Class<?> tempTargetType = transformPrimitiveTypes(aTargetType);
		Class<?> tempSourceType = transformPrimitiveTypes(aValue.getClass());
		String tempSourceTypeName = tempSourceType.getName();

		if (Map.class.isAssignableFrom(tempSourceType)) {
			// Maps need special attention: we may have to convert their contents. Therefore we perform a Map-to-Map
			// conversion in this case, which iterates over inner value and ensures those are also converted, if
			// necessary.
			// In order to do this, we need to specify a concrete map target type.
			if (tempTargetType == null) {
				tempTargetType = HashMap.class; // HashMap is a good default
			} else if (Map.class.isAssignableFrom(tempTargetType)) {
				// If the target type is also a map, see whether the target is an abstract type
				if ((tempTargetType.getModifiers() & Modifier.ABSTRACT) != 0) {
					// If it is, just use the source value type as target. This basically performs no conversion of the
					// map object itself, but it nevertheless results in an execution of the Map-to-Map conversion,
					// which triggers conversion of inner values
					tempTargetType = tempSourceType;
				}
			}
		} else {
			// No conversion necessary if target type is a superclass or the same as the current type
			if (tempTargetType != null && tempTargetType.isAssignableFrom(tempSourceType)) {
				// ...except if the source type is one of Integritys' internal types, which shouldn't generally been
				// given
				// to fixtures in an unconverted state.
				if (!tempSourceTypeName.startsWith("de.gebit.integrity.dsl.")) {
					return aValue;
				}
			}

			if (tempTargetType == null && tempSourceTypeName.startsWith("java.")) {
				// Java types generally have themselves as "default type" and don't need to be converted to anything
				return aValue;
			}
		}

		try {
			@SuppressWarnings("rawtypes")
			Conversion tempConversion = findAndInstantiateConversion(tempSourceType, tempTargetType, someVisitedValues,
					aConversionContext);
			if (tempConversion != null) {
				return tempConversion.convert(aValue, tempTargetType, aConversionContext);
			}

			throw new ConversionUnsupportedException(aValue.getClass(), aTargetType,
					"Could not find a matching conversion");
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType, "Failed to instantiate conversion",
					exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType, "Failed to instantiate conversion",
					exc);
		} catch (ConversionUnsupportedException exc) {
			throw exc;
			// SUPPRESS CHECKSTYLE IllegalCatch
		} catch (Throwable exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType, "Unexpected error during conversion",
					exc);
		}
	}

	private Class<?> transformPrimitiveTypes(Class<?> aType) {
		if (int.class.equals(aType)) {
			return Integer.class;
		} else if (long.class.equals(aType)) {
			return Long.class;
		} else if (short.class.equals(aType)) {
			return Short.class;
		} else if (byte.class.equals(aType)) {
			return Byte.class;
		} else if (float.class.equals(aType)) {
			return Float.class;
		} else if (double.class.equals(aType)) {
			return Double.class;
		} else if (char.class.equals(aType)) {
			return Character.class;
		} else if (boolean.class.equals(aType)) {
			return Boolean.class;
		} else {
			return aType;
		}
	}

	/**
	 * Converts a given {@link ValueOrEnumValueOrOperation} to a given Java type class, if possible.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized (via generics) type attached to the given target type, if applicable - for example
	 *            if a conversion to List<Integer> is desired, the target type is List, and the parameterized type is
	 *            Integer
	 * @param aValue
	 *            the value
	 * @param aConversionContext
	 *            defines some parameters controlling how the conversion is done in detail
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	protected Object convertEncapsulatedValueToTargetType(Class<?> aTargetType, Class<?> aParameterizedType,
			ValueOrEnumValueOrOperation aValue, ConversionContext aConversionContext, Set<Object> someVisitedValues)
			throws UnresolvableVariableException, UnexecutableException {
		if (aValue == null) {
			return null;
		}

		try {
			if (aValue instanceof StandardOperation) {
				Object tempResult = standardOperationProcessor.executeOperation((StandardOperation) aValue);
				return convertPlainValueToTargetType(aTargetType, aParameterizedType, tempResult, aConversionContext,
						someVisitedValues);
			} else if (aValue instanceof CustomOperation) {
				if (wrapperFactory == null) {
					// cannot execute operations without the ability to load them
					return null;
				} else {
					CustomOperationWrapper tempWrapper = wrapperFactory
							.newCustomOperationWrapper((CustomOperation) aValue);
					Object tempResult = tempWrapper.executeOperation();
					return convertPlainValueToTargetType(aTargetType, aParameterizedType, tempResult,
							aConversionContext, someVisitedValues);
				}
			} else if (aValue instanceof Variable) {
				Object tempResult = parameterResolver.resolveSingleParameterValue(aValue,
						aConversionContext.getUnresolvableVariableHandlingPolicy());
				if (tempResult instanceof ValueOrEnumValueOrOperation) {
					// In case of an operation inside a variable, we need to recurse (see issue #36)
					return convertEncapsulatedValueToTargetType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperation) tempResult, aConversionContext, someVisitedValues);
				} else if (tempResult instanceof ValueOrEnumValueOrOperationCollection) {
					// The same is true in case of collections
					return convertEncapsulatedValueCollectionToTargetType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperationCollection) tempResult, aConversionContext, someVisitedValues);
				} else if (tempResult != null && tempResult.getClass().isArray()) {
					// A slight variant of the collection case is an array (possibly filled with Integrity types)
					// We just convert the individual elements in this case.
					Object tempResultArray = Array.newInstance(tempResult.getClass().getComponentType(),
							Array.getLength(tempResult));
					for (int i = 0; i < Array.getLength(tempResult); i++) {
						Array.set(tempResultArray, i, convertSingleValueToTargetType(aTargetType, aParameterizedType,
								Array.get(tempResult, i), aConversionContext, someVisitedValues));
					}
					return tempResultArray;
				} else {
					return convertSingleValueToTargetType(aTargetType, aParameterizedType, tempResult,
							aConversionContext, someVisitedValues);
				}
			} else {
				return convertPlainValueToTargetType(aTargetType, aParameterizedType, aValue, aConversionContext,
						someVisitedValues);
			}
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(null, aTargetType, exc.getMessage(), exc);
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(null, aTargetType, exc.getMessage(), exc);
		}
	}

	/**
	 * Converts a given {@link ValueOrEnumValueOrOperation} to a given Java type class, if possible.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized (via generics) type attached to the given target type, if applicable - for example
	 *            if a conversion to List<Integer> is desired, the target type is List, and the parameterized type is
	 *            Integer
	 * @param aValue
	 *            the value
	 * @param aConversionContext
	 *            defines some parameters controlling how the conversion is done in detail
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	protected Object convertEncapsulatedConstantValueToTargetType(Class<?> aTargetType, Class<?> aParameterizedType,
			ConstantValue aValue, ConversionContext aConversionContext, Set<Object> someVisitedValues)
			throws UnresolvableVariableException, UnexecutableException {
		if (aValue == null) {
			return null;
		}

		if (aValue instanceof Constant) {
			if (variableManager != null) {
				// Constants need to be "constantly" defined in the variable manager at runtime, so we can ask it
				// directly.
				Object tempResult = variableManager.get(((Constant) aValue).getName());
				return convertValue(aTargetType, aParameterizedType, tempResult, aConversionContext, someVisitedValues);
			} else if (((Constant) aValue).getName().eContainer() instanceof ConstantDefinition) {
				// Without the variable manager, we can still attempt to resolve statically.
				try {
					return parameterResolver
							.resolveStatically((ConstantDefinition) ((Constant) aValue).getName().eContainer(), null);
				} catch (ClassNotFoundException exc) {
					exc.printStackTrace();
				} catch (InstantiationException exc) {
					exc.printStackTrace();
				}
			}
			return null;
		} else {
			return convertPlainValueToTargetType(aTargetType, aParameterizedType, aValue, aConversionContext,
					someVisitedValues);
		}
	}

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized (via generics) type attached to the given target type, if applicable - for example
	 *            if a conversion to List<Integer> is desired, the target type is List, and the parameterized type is
	 *            Integer
	 * @param aCollection
	 *            the value collection
	 * @param aConversionContext
	 *            defines some parameters controlling how the conversion is done in detail
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({ "rawtypes" })
	protected Object convertEncapsulatedValueCollectionToTargetType(Class<?> aTargetType, Class<?> aParameterizedType,
			ValueOrEnumValueOrOperationCollection aCollection, ConversionContext aConversionContext,
			Set<Object> someVisitedValues) throws UnresolvableVariableException, UnexecutableException {

		Class<?> tempTargetType = null;
		Class<? extends Collection> tempCollectionType = null;
		boolean tempWrapResultIntoArray = false;
		if (aTargetType != null) {
			if (aTargetType.isArray()) {
				if ((aTargetType == Byte[].class || aTargetType == byte[].class)) {
					// This is a special case (issue #66): byte arrays are to be treated as "non-array" targets.
					tempTargetType = aTargetType;
					tempWrapResultIntoArray = false;
				} else {
					tempTargetType = aTargetType.getComponentType();
					tempWrapResultIntoArray = true;
				}
			} else if (List.class.isAssignableFrom(aTargetType)) {
				tempCollectionType = ArrayList.class;
			} else if (Set.class.isAssignableFrom(aTargetType)) {
				tempCollectionType = HashSet.class;
			} else if (Collection.class.isAssignableFrom(aTargetType)) {
				tempCollectionType = ArrayList.class;
			} else {
				tempTargetType = aTargetType;
			}
		}

		// Collections may specify a target type via a generics parameter
		if (tempCollectionType != null && aParameterizedType != null) {
			tempTargetType = aParameterizedType;
		}

		Class<?> tempTargetArrayType = tempTargetType;
		if (tempTargetArrayType == null) {
			tempTargetArrayType = Object.class;
		}

		if (aCollection.getMoreValues() != null && aCollection.getMoreValues().size() > 0) {
			// this is actually an array, so we need to iterate over all the values

			// Just in case there's a nested object path property set in our conversion context: we need to extend
			// that property by the position within the array, and reset it later to the original plain value. This
			// is necessary to distinguish between array elements when converting to formatted strings (there's
			// highlighting being added based on these paths). In all other conversion cases it at least doesn't hurt.
			String tempBaseObjectPath = (String) aConversionContext
					.getProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY);

			Object tempResultArray = Array.newInstance(tempTargetArrayType, aCollection.getMoreValues().size() + 1);
			for (int i = 0; i < aCollection.getMoreValues().size() + 1; i++) {
				if (tempBaseObjectPath != null) {
					aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
							tempBaseObjectPath + "#" + i);
				}

				ValueOrEnumValueOrOperation tempValue = (i == 0 ? aCollection.getValue()
						: aCollection.getMoreValues().get(i - 1));
				Object tempResultValue = convertEncapsulatedValueToTargetType(tempTargetType, aParameterizedType,
						tempValue, aConversionContext, someVisitedValues);
				Array.set(tempResultArray, i, tempResultValue);
			}

			if (tempBaseObjectPath != null) {
				// Here the resetting of the nested object path is done
				aConversionContext.withProperty(AbstractNestedObjectToString.NESTEDOBJECT_PATH_PROPERTY,
						tempBaseObjectPath);
			}

			// now we need to see whether we're even allowed to return an array
			if (aTargetType == null) {
				return tempResultArray;
			} else if (aTargetType.isArray()) {
				return tempResultArray;
			} else if (tempCollectionType != null) {
				return wrapInCollection((Class<? extends Collection>) tempCollectionType, tempResultArray);
			} else {
				throw new IllegalArgumentException("Parameter type class " + aTargetType
						+ " is not an array, but more than one value was given for conversion.");
			}
		} else {
			// this is just a single value
			Object tempResult = convertEncapsulatedValueToTargetType(tempTargetType, aParameterizedType,
					aCollection.getValue(), aConversionContext, someVisitedValues);

			// but we might need to return this as an array with one element
			if (aTargetType == null) {
				return tempResult;
			} else if (tempWrapResultIntoArray) {
				if (tempResult != null && tempResult.getClass().isArray()) {
					// This is already an array -> check if we need to convert it to a different component type
					if (tempResult.getClass().getComponentType() != tempTargetArrayType) {
						Object tempResultArray = Array.newInstance(tempTargetArrayType, Array.getLength(tempResult));
						for (int i = 0; i < Array.getLength(tempResult); i++) {
							Array.set(tempResultArray, i, Array.get(tempResult, i));
						}
						return tempResultArray;
					} else {
						return tempResult;
					}
				} else {
					// Not yet an array -> wrap it now!
					Object tempResultArray = Array.newInstance(tempTargetArrayType, 1);
					Array.set(tempResultArray, 0, tempResult);
					return tempResultArray;
				}
			} else if (tempCollectionType != null) {
				return wrapInCollection((Class<? extends Collection>) tempCollectionType, tempResult);
			} else {
				return tempResult;
			}
		}
	}

	/**
	 * Wraps a value (or an array of values) in a collection of the given type.
	 * 
	 * @param aCollectionType
	 *            the collection type
	 * @param anArrayOrSingleType
	 *            the array or value to wrap
	 * @return the collection
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T extends Collection> T wrapInCollection(Class<T> aCollectionType, Object anArrayOrSingleType) {
		T tempCollectionInstance;
		try {
			tempCollectionInstance = aCollectionType.newInstance();
		} catch (IllegalAccessException exc) {
			throw new RuntimeException("Failed to create collection instance", exc);
		} catch (InstantiationException exc) {
			throw new RuntimeException("Failed to create collection instance", exc);
		}
		if (anArrayOrSingleType.getClass().isArray()) {
			for (int i = 0; i < Array.getLength(anArrayOrSingleType); i++) {
				Collections.addAll(tempCollectionInstance, Array.get(anArrayOrSingleType, i));
			}
		} else {
			Collections.addAll(tempCollectionInstance, anArrayOrSingleType);
		}
		return tempCollectionInstance;
	}

	@Override
	public String convertValueToString(Object aValue, boolean aForceIntermediateMapFlag,
			ConversionContext aConversionContext) {
		return convertValueToFormattedString(aValue, aForceIntermediateMapFlag, aConversionContext)
				.toUnformattedString();
	}

	@Override
	public FormattedString convertValueToFormattedString(Object aValue, boolean aForceIntermediateMapFlag,
			ConversionContext aConversionContext) {
		if (aForceIntermediateMapFlag) {
			try {
				Map<?, ?>[] tempIntermediateMap = (Map[]) convertValue(Map[].class, aValue, aConversionContext);
				return convertValueToFormattedString(tempIntermediateMap, false, aConversionContext);
			} catch (UnresolvableVariableException exc) {
				exc.printStackTrace();
				return new FormattedString("FAILURE");
			} catch (UnexecutableException exc) {
				exc.printStackTrace();
				return new FormattedString("FAILURE");
			} catch (ConversionException exc) {
				exc.printStackTrace();
				return new FormattedString("FAILURE");
			}
		}

		// always convert to an array, so array values will convert fine
		FormattedString[] tempResult = convertValueToFormattedStringArray(aValue, aConversionContext);

		FormattedString tempBuffer = new FormattedString();
		for (FormattedString tempSingleResult : tempResult) {
			if (tempBuffer.getElementCount() > 0) {
				tempBuffer.add(new FormattedStringElement(", "));
			}
			tempBuffer.add(tempSingleResult);
		}

		return tempBuffer;
	}

	@Override
	public String[] convertValueToStringArray(Object aValue, ConversionContext aConversionContext) {
		FormattedString[] tempFormattedStrings = convertValueToStringArray(aValue, aConversionContext,
				new HashSet<Object>());

		String[] tempStrings = new String[tempFormattedStrings.length];
		for (int i = 0; i < tempFormattedStrings.length; i++) {
			tempStrings[i] = tempFormattedStrings[i].toUnformattedString();
		}

		return tempStrings;
	}

	@Override
	public FormattedString[] convertValueToFormattedStringArray(Object aValue, ConversionContext aConversionContext) {
		return convertValueToStringArray(aValue, aConversionContext, new HashSet<Object>());
	}

	/**
	 * Extended version of {@link #convertValueToStringArray(Object, UnresolvableVariableHandling)}.
	 * 
	 * @param aValue
	 * @param aConversionContext
	 * @param someVisitedValues
	 * @return
	 */
	public FormattedString[] convertValueToStringArray(Object aValue, ConversionContext aConversionContext,
			Set<Object> someVisitedValues) {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		FormattedString[] tempResult;
		try {
			if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
				tempResult = (FormattedString[]) convertEncapsulatedValueCollectionToTargetType(FormattedString[].class,
						null, (ValueOrEnumValueOrOperationCollection) aValue, tempConversionContext, someVisitedValues);
			} else if (aValue instanceof ValueOrEnumValueOrOperation) {
				tempResult = (FormattedString[]) convertEncapsulatedValueToTargetType(FormattedString[].class, null,
						(ValueOrEnumValueOrOperation) aValue, tempConversionContext, someVisitedValues);
			} else {
				tempResult = (FormattedString[]) convertValue(FormattedString[].class, null, aValue,
						tempConversionContext, someVisitedValues);
			}
		} catch (UnexecutableException exc) {
			// this is expected to happen in some cases during dry run - but not a problem
			return new FormattedString[] { new FormattedString("???") };
		} catch (UnresolvableVariableException exc) {
			// This is expected to happen - for example in case of operations depending on undefined variables.
			return new FormattedString[] { new FormattedString("???") };
		} catch (ConversionException exc) {
			exc.printStackTrace();
			return new FormattedString[] { new FormattedString("FAILURE") };
		}

		if (tempResult == null) {
			return new FormattedString[] { new FormattedString("null") };
		} else {
			return tempResult;
		}
	}

	/**
	 * Adds the given conversion class to the map of available conversions.
	 * 
	 * @param aConversion
	 *            the conversion to add
	 */
	protected void addConversion(Class<? extends Conversion<?, ?>> aConversion) {
		Class<? extends Conversion<?, ?>> tempConversion = (Class<? extends Conversion<?, ?>>) aConversion;
		ConversionKey tempConversionKey = new ConversionKey(tempConversion);

		// See whether the new conversion has a higher priority than the current default conversion for the given
		// source type
		int tempNewPriority = determineConversionPriority(aConversion);

		Integer tempCurrentPriority = conversionPriority.get(tempConversionKey.getSourceType());
		if (tempCurrentPriority == null || (tempNewPriority > tempCurrentPriority)) {
			defaultConversions.put(tempConversionKey.getSourceType(), tempConversion);
			conversionPriority.put(tempConversionKey.getSourceType(), tempNewPriority);
		}

		// Now add the conversion itself to the existing conversions...
		conversions.put(tempConversionKey, tempConversion);
		conversionToKey.put(tempConversion, tempConversionKey);

		// ...and then add all derived conversions. Note that duplicates can occur here!
		for (ConversionKey tempDerivedConversionKey : tempConversionKey.generateDerivedKeys()) {
			List<Class<? extends Conversion<?, ?>>> tempList = derivedConversions.get(tempDerivedConversionKey);
			if (tempList == null) {
				tempList = new ArrayList<Class<? extends Conversion<?, ?>>>();
				derivedConversions.put(tempDerivedConversionKey, tempList);
			}
			tempList.add(tempConversion);
			Collections.sort(tempList, new Comparator<Class<? extends Conversion<?, ?>>>() {

				@Override
				public int compare(Class<? extends Conversion<?, ?>> aFirstConversion,
						Class<? extends Conversion<?, ?>> aSecondConversion) {
					int tempFirstPriority = determineConversionPriority(aFirstConversion);
					int tempSecondPriority = determineConversionPriority(aSecondConversion);

					return (tempSecondPriority - tempFirstPriority);
				}
			});
		}
	}

	/**
	 * Determines the priority of the given conversion class.
	 * 
	 * @param aConversion
	 *            the conversion to introspect
	 * @return the numeric priority
	 */
	protected int determineConversionPriority(Class<? extends Conversion<?, ?>> aConversion) {
		Priority tempPriorityAnnotation = aConversion.getAnnotation(Priority.class);
		int tempPriority = Integer.MIN_VALUE;
		if (tempPriorityAnnotation != null) {
			tempPriority = tempPriorityAnnotation.value();
		}

		return tempPriority;
	}

	/**
	 * This class defines a key for efficient searching for conversions in maps.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected static class ConversionKey {

		/**
		 * The source type.
		 */
		private Class<?> sourceType;

		/**
		 * The target type.
		 */
		private Class<?> targetType;

		/**
		 * Internally, a string is used to determine equality and hash code.
		 */
		private String internalKey;

		private void initializeInternalKey(Class<?> aSourceType, Class<?> aTargetType) {
			sourceType = aSourceType;
			targetType = aTargetType;
			internalKey = (aSourceType.getName() + " -> " + aTargetType.getName());
		}

		public Class<?> getSourceType() {
			return sourceType;
		}

		public Class<?> getTargetType() {
			return targetType;
		}

		/**
		 * Creates a new instance.
		 * 
		 * @param aSourceType
		 *            the source type
		 * @param aTargetType
		 *            the target type
		 */
		public ConversionKey(Class<?> aSourceType, Class<?> aTargetType) {
			initializeInternalKey(aSourceType, aTargetType);
		}

		/**
		 * Takes a {@link Conversion} implementation and determines the applicable conversion key.
		 * 
		 * @param aConversion
		 *            the conversion to look at
		 */
		public ConversionKey(Class<? extends Conversion<?, ?>> aConversion) {
			Class<?> tempClass = aConversion;

			Type tempType = JavaTypeUtil.findGenericInterfaceOrSuperType(tempClass, Conversion.class);
			if (tempType != null) {
				// Replacing one of the types (source OR target) in the Conversion superinterface with a variable is
				// supported. In that case, it is expected that the first generic superinterface in the whole class
				// hierarchy does define that variable.
				Class<?> tempSourceType = null;
				Object tempSourceTypeObj = ((ParameterizedType) tempType).getActualTypeArguments()[0];
				if (tempSourceTypeObj instanceof Class) {
					tempSourceType = (Class<?>) tempSourceTypeObj;
				} else if (tempSourceTypeObj instanceof TypeVariable) {
					Type tempSubType = JavaTypeUtil.findGenericInterfaceOrSuperType(tempClass, null);
					tempSourceType = (Class<?>) ((ParameterizedType) tempSubType).getActualTypeArguments()[0];
				}

				Class<?> tempTargetType = null;
				Object tempTargetTypeObj = ((ParameterizedType) tempType).getActualTypeArguments()[1];
				if (tempTargetTypeObj instanceof Class) {
					tempTargetType = (Class<?>) tempTargetTypeObj;
				} else if (tempTargetTypeObj instanceof TypeVariable) {
					Type tempSubType = JavaTypeUtil.findGenericInterfaceOrSuperType(tempClass, null);
					tempTargetType = (Class<?>) ((ParameterizedType) tempSubType).getActualTypeArguments()[0];
				}

				initializeInternalKey(tempSourceType, tempTargetType);
			} else {
				throw new IllegalArgumentException("Was unable to find valid generic Conversion superinterface");
			}
		}

		/**
		 * Generates the derived conversion keys from the current key. "Derived keys" means keys which cover the whole
		 * target type superclass hierarchy.
		 * 
		 * @return the derived key list
		 */
		public List<ConversionKey> generateDerivedKeys() {
			List<ConversionKey> tempResults = new ArrayList<ConversionKey>();

			Class<?> tempTargetTypeInFocus = targetType.getSuperclass();
			while (tempTargetTypeInFocus != null) {
				tempResults.add(new ConversionKey(sourceType, tempTargetTypeInFocus));

				for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
					tempResults.add(new ConversionKey(sourceType, tempTargetInterface));
				}

				tempTargetTypeInFocus = tempTargetTypeInFocus.getSuperclass();
			}

			return tempResults;
		}

		@Override
		public int hashCode() {
			return internalKey.hashCode();
		}

		@Override
		public boolean equals(Object anObject) {
			if (!(anObject instanceof ConversionKey)) {
				return false;
			} else {
				return internalKey.equals(((ConversionKey) anObject).internalKey);
			}
		}

		@Override
		public String toString() {
			return internalKey;
		}
	}

	/**
	 * Searches all known conversions for a match which is able to convert a given source type into a given target type.
	 * This instantiates a found conversion class.
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @param someVisitedValues
	 * @param aConversionContext
	 *            The conversion context
	 * @return a ready-to-use, instantiated conversion, or null if none was found
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected Conversion<?, ?> findAndInstantiateConversion(Class<?> aSourceType, Class<?> aTargetType,
			Set<Object> someVisitedValues, ConversionContext aConversionContext)
			throws InstantiationException, IllegalAccessException {
		Class<? extends Conversion<?, ?>> tempConversionClass = findConversion(aSourceType, aTargetType,
				someVisitedValues, aConversionContext);

		return createConversionInstance(tempConversionClass, someVisitedValues);
	}

	/**
	 * Searches all known conversions for a match which is able to convert a given source type into a given target type.
	 * Returns the conversion class (must be instantiated before actually converting something).
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @param aConversionContext
	 *            The conversion context
	 * @return a conversion class, or null if none was found
	 */
	protected Class<? extends Conversion<?, ?>> findConversion(Class<?> aSourceType, Class<?> aTargetType,
			Set<Object> someVisitedValues, ConversionContext aConversionContext) {
		Class<? extends Conversion<?, ?>> tempConversion = findConversionRecursive(aSourceType, aTargetType,
				aConversionContext);

		if (tempConversion != null) {
			return tempConversion;
		}

		// If nothing found yet, continue search in the derived conversion lists
		return findDerivedConversionRecursive(aSourceType, aTargetType, aConversionContext);
	}

	/**
	 * Searches all known derived conversions for a match which is able to convert a given source type into a subclass
	 * of a given target type. If there are multiple matches (which is likely, if the target type is very generic), the
	 * conversion with the highest priority wins.
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @return a conversion class, or null if none was found
	 */
	protected Class<? extends Conversion<?, ?>> findDerivedConversionRecursive(Class<?> aSourceType,
			Class<?> aTargetType, ConversionContext aConversionContext) {
		if (aSourceType == null || aTargetType == null) {
			return null;
		}

		Class<? extends Conversion<?, ?>> tempConversion = searchDerivedConversionMap(aSourceType, aTargetType);
		if (tempConversion != null) {
			return tempConversion;
		}

		for (Class<?> tempSourceInterface : aSourceType.getInterfaces()) {
			tempConversion = findDerivedConversionRecursive(tempSourceInterface, aTargetType, aConversionContext);
			if (tempConversion != null) {
				return tempConversion;
			}
		}

		return findDerivedConversionRecursive(aSourceType.getSuperclass(), aTargetType, aConversionContext);
	}

	/**
	 * Searches the derived conversion map for a match. If one or multiple are found, the one with the highest priority
	 * is returned (the lists in the map are pre-sorted that way).
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @return a conversion class, or null if none was found
	 */
	protected Class<? extends Conversion<?, ?>> searchDerivedConversionMap(Class<?> aSourceType, Class<?> aTargetType) {
		List<Class<? extends Conversion<?, ?>>> tempList = derivedConversions
				.get(new ConversionKey(aSourceType, aTargetType));
		if (tempList != null && !tempList.isEmpty()) {
			return tempList.get(0);
		}

		return null;
	}

	/**
	 * Searches all known conversions for a match which is able to convert a given source type into a given target type.
	 * Returns the conversion class (must be instantiated before actually converting something).
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @param aConversionContext
	 *            The conversion context
	 * @return a conversion class, or null if none was found
	 */
	protected Class<? extends Conversion<?, ?>> findConversionRecursive(Class<?> aSourceType, Class<?> aTargetType,
			ConversionContext aConversionContext) {
		if (conversionSearchBlockers.contains(aSourceType) || conversionSearchBlockers.contains(aTargetType)) {
			return null;
		}

		Class<?> tempSourceTypeInFocus = aSourceType;
		while (tempSourceTypeInFocus != null) {
			Class<? extends Conversion<?, ?>> tempConversionClass = null;
			if (aTargetType == null || aTargetType == Object.class) {
				// This is the default target type case
				tempConversionClass = filterConversionClass(defaultConversions.get(tempSourceTypeInFocus), aSourceType,
						aTargetType, aConversionContext, true);
			} else {
				// We actually have a target type
				Class<?> tempTargetTypeInFocus = aTargetType;
				outerLoop: while (tempTargetTypeInFocus != null) {
					if (conversionSearchBlockers.contains(tempTargetTypeInFocus)) {
						break;
					}
					tempConversionClass = filterConversionClass(
							conversions.get(new ConversionKey(tempSourceTypeInFocus, tempTargetTypeInFocus)),
							aSourceType, aTargetType, aConversionContext, false);

					if (tempConversionClass != null) {
						break outerLoop;
					}

					for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
						tempConversionClass = findConversionRecursive(tempSourceTypeInFocus, tempTargetInterface,
								aConversionContext);
						if (tempConversionClass != null) {
							break outerLoop;
						}
					}

					tempTargetTypeInFocus = tempTargetTypeInFocus.getSuperclass();
				}
			}

			if (tempConversionClass != null) {
				return tempConversionClass;
			} else {
				for (Class<?> tempSourceInterface : tempSourceTypeInFocus.getInterfaces()) {
					if (aTargetType == null || aTargetType == Object.class) {
						// This is the default target type case
						Class<? extends Conversion<?, ?>> tempConversion = findConversionRecursive(tempSourceInterface,
								null, aConversionContext);
						if (tempConversion != null) {
							return tempConversion;
						}
					} else {
						// We actually have a target type
						Class<? extends Conversion<?, ?>> tempConversion = findConversionRecursive(tempSourceInterface,
								aTargetType, aConversionContext);
						if (tempConversion != null) {
							return tempConversion;
						}

						// Search the interfaces of the target type as well
						for (Class<?> tempTargetInterface : aTargetType.getInterfaces()) {
							tempConversion = findConversionRecursive(tempSourceInterface, tempTargetInterface,
									aConversionContext);
							if (tempConversion != null) {
								return tempConversion;
							}
						}
					}
				}

				tempSourceTypeInFocus = tempSourceTypeInFocus.getSuperclass();
			}
		}

		return null;
	}

	/**
	 * This filtering method has the ability to replace a conversion class found by the normal lookup before it's
	 * actually used. This is the point at which special rules (for example dictated by the {@link ConversionContext})
	 * may be enforced.
	 * 
	 * @param aConversionClass
	 *            the conversion class in question
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @param aConversionContext
	 *            the conversion context to use
	 * @param aDefaultConversionFlag
	 *            whether this is a default conversion or specifically requested to match the target type
	 * @return the conversion class to use, which may be the input class or any other replacement
	 */
	protected Class<? extends Conversion<?, ?>> filterConversionClass(
			Class<? extends Conversion<?, ?>> aConversionClass, Class<?> aSourceType, Class<?> aTargetType,
			ConversionContext aConversionContext, boolean aDefaultConversionFlag) {
		if (aConversionClass != null) {
			if (aConversionContext.getSkipBeanToMapDefaultConversion()) {
				if (aDefaultConversionFlag && ObjectToMap.class.isAssignableFrom(aConversionClass)) {
					return ObjectToObject.class;
				}
			}
		}

		return aConversionClass;
	}

	/**
	 * Creates an instance of the given conversion class. This also injects the Guice dependencies.
	 * 
	 * @param aConversionClass
	 *            the conversion
	 * @return the new instance
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <C extends Conversion> C createConversionInstance(Class<C> aConversionClass,
			Set<Object> someVisitedValues) throws InstantiationException, IllegalAccessException {
		if (aConversionClass == null) {
			return null;
		}

		C tempInstance = aConversionClass.newInstance();
		injector.injectMembers(tempInstance);
		tempInstance.setVisitedObjects(someVisitedValues);

		return tempInstance;
	}

	/**
	 * This method creates a default conversion context in case none is provided, and returns the provided context
	 * otherwise.
	 * 
	 * @param aContext
	 *            the context to safeguard
	 * @return a context (guaranteed not to return null)
	 */
	public ConversionContext safeguardConversionContext(ConversionContext aContext) {
		if (aContext == null) {
			return conversionContextProvider.get();
		} else {
			return aContext;
		}
	}

	/**
	 * Handles the special case of issue #66: single string to byte array.
	 * 
	 * @param aSource
	 *            the string to convert
	 * @return the byte array
	 */
	protected byte[] handleConversionOfStringToByteArray(String aSource) {
		return aSource.getBytes(Charset.defaultCharset());
	}

	/**
	 * Handles the special case of issue #66: single string to byte array.
	 * 
	 * @param aSource
	 *            the string to convert
	 * @return the byte array (using the wrapper type)
	 */
	protected Byte[] handleConversionOfStringToByteWrapperArray(String aSource) {
		byte[] tempArray = handleConversionOfStringToByteArray(aSource);
		Byte[] tempWrapperArray = new Byte[tempArray.length];

		for (int i = 0; i < tempArray.length; i++) {
			tempWrapperArray[i] = tempArray[i];
		}

		return tempWrapperArray;
	}

	/**
	 * Handles the special case of issue #66: single string to byte array.
	 * 
	 * @param aSource
	 *            the string to convert (wrapper type)
	 * @return the byte array
	 */
	protected byte[] handleConversionOfStringValueToByteArray(StringValue aSource) {
		return handleConversionOfStringToByteArray(aSource.getStringValue());
	}

	/**
	 * Handles the special case of issue #66: single string to byte array.
	 * 
	 * @param aSource
	 *            the string to convert (wrapper type)
	 * @return the byte array (using the wrapper type)
	 */
	protected Byte[] handleConversionOfStringValueToByteWrapperArray(StringValue aSource) {
		return handleConversionOfStringToByteWrapperArray(aSource.getStringValue());
	}
}
