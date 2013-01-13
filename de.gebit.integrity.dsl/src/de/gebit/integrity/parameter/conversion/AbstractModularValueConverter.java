/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.operations.custom.CustomOperationWrapper;
import de.gebit.integrity.operations.standard.StandardOperationProcessor;
import de.gebit.integrity.parameter.conversion.Conversion.Priority;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.utils.JavaTypeUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * Abstract base class for a value converter which uses conversion classes to determine how a given value is to be
 * converted into a desired form. This modularity makes it easy to extend the converter with additional conversions.
 * 
 * @author Rene Schneider
 * 
 */
public abstract class AbstractModularValueConverter implements ValueConverter {

	/**
	 * The parameter resolver.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

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
	 * All known conversions.
	 */
	private Map<ConversionKey, Class<? extends Conversion<?, ?>>> conversions = new HashMap<ConversionKey, Class<? extends Conversion<?, ?>>>();

	/**
	 * The default conversions for all known source types. These are the conversions with the highest priority from
	 * their respective source types' conversion pool.
	 */
	private Map<Class<?>, Class<? extends Conversion<?, ?>>> defaultConversions = new HashMap<Class<?>, Class<? extends Conversion<?, ?>>>();

	/**
	 * The current defaults' priority. Used to fill the {@link #defaultConversions} map.
	 */
	private Map<Class<?>, Integer> conversionPriority = new HashMap<Class<?>, Integer>();

	/**
	 * Implement this method to initialize known conversions.
	 * 
	 */
	protected abstract void initializeConversions();

	/**
	 * Default constructor. Initializes all conversions.
	 */
	public AbstractModularValueConverter() {
		initializeConversions();
	}

	@Override
	public Object convertValue(Class<?> aTargetType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			UnexecutableException {
		return convertValue(aTargetType, null, aValue, anUnresolvableVariableHandlingPolicy);
	}

	@Override
	public Object convertValue(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			UnexecutableException {
		return convertValue(aTargetType, aParameterizedType, aValue, anUnresolvableVariableHandlingPolicy,
				new HashSet<Object>());
	}

	/**
	 * Extended version of #convertValue(Class, Class, Object, UnresolvableVariableHandling).
	 * 
	 * @param aTargetType
	 * @param aParameterizedType
	 * @param aValue
	 * @param anUnresolvableVariableHandlingPolicy
	 * @param someVisitedObjects
	 * @return
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	public Object convertValue(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy, Set<Object> someVisitedObjects)
			throws UnresolvableVariableException, UnexecutableException {
		if (someVisitedObjects.contains(aValue)) {
			// endless loop protection
			return null;
		} else {
			try {
				someVisitedObjects.add(aValue);
				if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
					return convertEncapsulatedValueCollectionToParamType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperationCollection) aValue, anUnresolvableVariableHandlingPolicy,
							someVisitedObjects);
				} else if (aValue instanceof ValueOrEnumValueOrOperation) {
					return convertEncapsulatedValueToParamType(aTargetType, aParameterizedType,
							(ValueOrEnumValueOrOperation) aValue, anUnresolvableVariableHandlingPolicy,
							someVisitedObjects);
				} else {
					return convertPlainValueToParamType(aTargetType, aParameterizedType, aValue,
							anUnresolvableVariableHandlingPolicy, someVisitedObjects);
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
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted value
	 */
	protected Object convertPlainValueToParamType(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy, Set<Object> someVisitedValues) {
		if (aValue == null) {
			return null;
		}

		if (aTargetType != null && aTargetType.isArray()) {
			Class<?> tempActualParamType = aTargetType.getComponentType();
			Object tempResultArray;
			if (aValue.getClass().isArray()) {
				// both are arrays
				tempResultArray = Array.newInstance(tempActualParamType, Array.getLength(aValue));
				for (int i = 0; i < Array.getLength(aValue); i++) {
					Array.set(
							tempResultArray,
							i,
							convertPlainValueToParamType(tempActualParamType, aParameterizedType, Array.get(aValue, i),
									anUnresolvableVariableHandlingPolicy, someVisitedValues));
				}
			} else {
				// target is an array, but value is a single value
				tempResultArray = Array.newInstance(tempActualParamType, 1);
				Array.set(
						tempResultArray,
						0,
						convertPlainValueToParamType(tempActualParamType, aParameterizedType, aValue,
								anUnresolvableVariableHandlingPolicy, someVisitedValues));
			}
			return tempResultArray;
		} else {
			if (aValue.getClass().isArray()) {
				// this is not convertible, but since this method does not guarantee any conversion...
				return aValue;
			} else {
				// unresolvable variables can't happen here, since variable values should have gone down the other path
				return convertSingleValueToParamType(aTargetType, aParameterizedType, aValue,
						anUnresolvableVariableHandlingPolicy, someVisitedValues);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Object convertSingleValueToParamType(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy, Set<Object> someVisitedValues) {
		if (aValue == null) {
			return null;
		}

		Class<?> tempTargetType = transformPrimitiveTypes(aTargetType);
		Class<?> tempSourceType = transformPrimitiveTypes(aValue.getClass());

		if (tempTargetType != null && tempTargetType.isAssignableFrom(tempSourceType)) {
			// No conversion necessary
			return aValue;
		}

		if (tempTargetType == null && tempSourceType.getName().startsWith("java.")) {
			// Java types generally have themselves as "default type" and don't need to be converted to anything
			return aValue;
		}

		try {
			@SuppressWarnings("rawtypes")
			Conversion tempConversion = findConversion(tempSourceType, tempTargetType, someVisitedValues);
			if (tempConversion != null) {
				return tempConversion.convert(aValue, tempTargetType, anUnresolvableVariableHandlingPolicy);
			}
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType, "Failed to instantiate conversion",
					exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType, "Failed to instantiate conversion",
					exc);
			// SUPPRESS CHECKSTYLE IllegalCatch
		} catch (Throwable exc) {
			throw new ConversionFailedException(aValue.getClass(), tempTargetType,
					"Unexpected error during conversion", exc);
		}

		throw new ConversionUnsupportedException(aValue.getClass(), tempTargetType,
				"Could not find a matching conversion");
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
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	protected Object convertEncapsulatedValueToParamType(Class<?> aTargetType, Class<?> aParameterizedType,
			ValueOrEnumValueOrOperation aValue, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy,
			Set<Object> someVisitedValues) throws UnresolvableVariableException, UnexecutableException {
		if (aValue == null) {
			return null;
		}

		try {
			if (aValue instanceof StandardOperation) {
				Object tempResult = standardOperationProcessor.executeOperation((StandardOperation) aValue);
				return convertPlainValueToParamType(aTargetType, aParameterizedType, tempResult,
						anUnresolvableVariableHandlingPolicy, someVisitedValues);
			} else if (aValue instanceof CustomOperation) {
				if (wrapperFactory == null) {
					// cannot execute operations without the ability to load them
					return null;
				} else {
					CustomOperationWrapper tempWrapper = wrapperFactory
							.newCustomOperationWrapper((CustomOperation) aValue);
					Object tempResult = tempWrapper.executeOperation();
					return convertPlainValueToParamType(aTargetType, aParameterizedType, tempResult,
							anUnresolvableVariableHandlingPolicy, someVisitedValues);
				}
			} else if (aValue instanceof Variable) {
				Object tempResult = parameterResolver.resolveSingleParameterValue(aValue,
						anUnresolvableVariableHandlingPolicy);
				return convertSingleValueToParamType(aTargetType, aParameterizedType, tempResult,
						anUnresolvableVariableHandlingPolicy, someVisitedValues);
			} else {
				return convertPlainValueToParamType(aTargetType, aParameterizedType, aValue,
						anUnresolvableVariableHandlingPolicy, someVisitedValues);
			}
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(null, aTargetType, exc.getMessage(), exc);
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(null, aTargetType, exc.getMessage(), exc);
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
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({ "rawtypes" })
	protected Object convertEncapsulatedValueCollectionToParamType(Class<?> aTargetType, Class<?> aParameterizedType,
			ValueOrEnumValueOrOperationCollection aCollection,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy, Set<Object> someVisitedValues)
			throws UnresolvableVariableException, UnexecutableException {

		Class<?> tempTargetType = null;
		Class<? extends Collection> tempCollectionType = null;
		if (aTargetType != null) {
			if (aTargetType.isArray()) {
				tempTargetType = aTargetType.getComponentType();
			} else if (aTargetType.isAssignableFrom(ArrayList.class)) {
				tempCollectionType = ArrayList.class;
			} else if (aTargetType.isAssignableFrom(HashSet.class)) {
				tempCollectionType = HashSet.class;
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
			// this is actually an array
			Object tempResultArray = Array.newInstance(tempTargetArrayType, aCollection.getMoreValues().size() + 1);
			for (int i = 0; i < aCollection.getMoreValues().size() + 1; i++) {
				ValueOrEnumValueOrOperation tempValue = (i == 0 ? aCollection.getValue() : aCollection.getMoreValues()
						.get(i - 1));
				Object tempResultValue = convertEncapsulatedValueToParamType(tempTargetType, aParameterizedType,
						tempValue, anUnresolvableVariableHandlingPolicy, someVisitedValues);
				Array.set(tempResultArray, i, tempResultValue);
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
			Object tempResult = convertEncapsulatedValueToParamType(tempTargetType, aParameterizedType,
					aCollection.getValue(), anUnresolvableVariableHandlingPolicy, someVisitedValues);

			// but we might need to return this as an array with one element
			if (aTargetType == null) {
				return tempResult;
			} else if (aTargetType.isArray()) {
				Object tempResultArray = Array.newInstance(tempTargetArrayType, 1);
				Array.set(tempResultArray, 0, tempResult);
				return tempResultArray;
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
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (aForceIntermediateMapFlag) {
			try {
				Map<?, ?>[] tempIntermediateMap = (Map[]) convertValue(Map[].class, aValue,
						anUnresolvableVariableHandlingPolicy);
				return convertValueToString(tempIntermediateMap, false, anUnresolvableVariableHandlingPolicy);
			} catch (UnresolvableVariableException exc) {
				exc.printStackTrace();
				return "FAILURE";
			} catch (UnexecutableException exc) {
				exc.printStackTrace();
				return "FAILURE";
			} catch (ConversionException exc) {
				exc.printStackTrace();
				return "FAILURE";
			}
		}

		// always convert to an array, so array values will convert fine
		String[] tempResult = convertValueToStringArray(aValue, anUnresolvableVariableHandlingPolicy);

		StringBuilder tempBuffer = new StringBuilder();
		for (String tempSingleResult : tempResult) {
			if (tempBuffer.length() > 0) {
				tempBuffer.append(", ");
			}
			tempBuffer.append(tempSingleResult);
		}

		return tempBuffer.toString();
	}

	@Override
	public String[] convertValueToStringArray(Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return convertValueToStringArray(aValue, anUnresolvableVariableHandlingPolicy, new HashSet<Object>());
	}

	/**
	 * Extended version of {@link #convertValueToStringArray(Object, UnresolvableVariableHandling)}.
	 * 
	 * @param aValue
	 * @param anUnresolvableVariableHandlingPolicy
	 * @param someVisitedValues
	 * @return
	 */
	public String[] convertValueToStringArray(Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy, Set<Object> someVisitedValues) {
		String[] tempResult;
		try {
			if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
				tempResult = (String[]) convertEncapsulatedValueCollectionToParamType(String[].class, null,
						(ValueOrEnumValueOrOperationCollection) aValue, anUnresolvableVariableHandlingPolicy,
						someVisitedValues);
			} else if (aValue instanceof ValueOrEnumValueOrOperation) {
				tempResult = (String[]) convertEncapsulatedValueToParamType(String[].class, null,
						(ValueOrEnumValueOrOperation) aValue, anUnresolvableVariableHandlingPolicy, someVisitedValues);
			} else {
				tempResult = (String[]) convertPlainValueToParamType(String[].class, null, aValue,
						anUnresolvableVariableHandlingPolicy, someVisitedValues);
			}
		} catch (ConversionException exc) {
			exc.printStackTrace();
			return new String[] { "FAILURE" };
		} catch (UnresolvableVariableException exc) {
			exc.printStackTrace();
			return new String[] { "FAILURE" };
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
			return new String[] { "FAILURE" };
		}

		if (tempResult == null) {
			return new String[] { "null" };
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void addConversion(Class<? extends Conversion> aConversion) {
		Class<? extends Conversion<?, ?>> tempConversion = (Class<? extends Conversion<?, ?>>) aConversion;
		ConversionKey tempConversionKey = new ConversionKey(tempConversion);

		// See whether the new conversion has a higher priority than the current default conversion for the given
		// source type
		Priority tempPriorityAnnotation = aConversion.getAnnotation(Priority.class);
		int tempNewPriority = Integer.MIN_VALUE;
		if (tempPriorityAnnotation != null) {
			tempNewPriority = tempPriorityAnnotation.value();
		}

		Integer tempCurrentPriority = conversionPriority.get(tempConversionKey.getSourceType());
		if (tempCurrentPriority == null || (tempNewPriority > tempCurrentPriority)) {
			defaultConversions.put(tempConversionKey.getSourceType(), tempConversion);
			conversionPriority.put(tempConversionKey.getSourceType(), tempNewPriority);
		}

		conversions.put(tempConversionKey, tempConversion);
	}

	/**
	 * This class defines a key for efficient searching for conversions in maps.
	 * 
	 * 
	 * @author Rene Schneider
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
				Class<?> tempSourceType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[0];
				Class<?> tempTargetType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[1];
				initializeInternalKey(tempSourceType, tempTargetType);
			} else {
				throw new IllegalArgumentException("Was unable to find valid generic Conversion superinterface");
			}
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
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @return a ready-to-use, instantiated conversion, or null if none was found
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected Conversion<?, ?> findConversion(Class<?> aSourceType, Class<?> aTargetType, Set<Object> someVisitedValues)
			throws InstantiationException, IllegalAccessException {
		Class<?> tempSourceTypeInFocus = aSourceType;
		while (tempSourceTypeInFocus != null) {
			Class<? extends Conversion<?, ?>> tempConversionClass = null;
			if (aTargetType == null) {
				// This is the default target type case
				tempConversionClass = defaultConversions.get(tempSourceTypeInFocus);
			} else {
				// We actually have a target type
				Class<?> tempTargetTypeInFocus = aTargetType;
				while (tempTargetTypeInFocus != null) {
					tempConversionClass = conversions.get(new ConversionKey(tempSourceTypeInFocus,
							tempTargetTypeInFocus));
					if (tempConversionClass != null) {
						break;
					}

					for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
						Conversion<?, ?> tempConversion = findConversion(tempSourceTypeInFocus, tempTargetInterface,
								someVisitedValues);
						if (tempConversion != null) {
							return tempConversion;
						}
					}

					tempTargetTypeInFocus = tempTargetTypeInFocus.getSuperclass();
				}
			}

			if (tempConversionClass != null) {
				return createConversionInstance(tempConversionClass, someVisitedValues);
			} else {
				for (Class<?> tempSourceInterface : tempSourceTypeInFocus.getInterfaces()) {
					if (aTargetType == null) {
						// This is the default target type case
						Conversion<?, ?> tempConversion = findConversion(tempSourceInterface, null, someVisitedValues);
						if (tempConversion != null) {
							return tempConversion;
						}
					} else {
						// We actually have a target type
						Class<?> tempTargetTypeInFocus = aTargetType;
						while (tempTargetTypeInFocus != null) {
							Conversion<?, ?> tempConversion = findConversion(tempSourceInterface,
									tempTargetTypeInFocus, someVisitedValues);
							if (tempConversion != null) {
								return tempConversion;
							}

							for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
								tempConversion = findConversion(tempSourceInterface, tempTargetInterface,
										someVisitedValues);
								if (tempConversion != null) {
									return tempConversion;
								}
							}

							tempTargetTypeInFocus = tempTargetTypeInFocus.getSuperclass();
						}
					}
				}

				tempSourceTypeInFocus = tempSourceTypeInFocus.getSuperclass();
			}
		}

		return null;
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
	protected <C extends Conversion> C createConversionInstance(Class<C> aConversionClass, Set<Object> someVisitedValues)
			throws InstantiationException, IllegalAccessException {
		C tempInstance = aConversionClass.newInstance();
		injector.injectMembers(tempInstance);
		tempInstance.setVisitedObjects(someVisitedValues);

		return tempInstance;
	}

}
