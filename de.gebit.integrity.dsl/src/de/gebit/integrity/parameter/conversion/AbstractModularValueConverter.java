/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.operations.OperationWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
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
	public Object convertValue(Class<?> aTargetClass, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {
		if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
			return convertEncapsulatedValueCollectionToParamType(aTargetClass,
					(ValueOrEnumValueOrOperationCollection) aValue, anUnresolvableVariableHandlingPolicy);
		} else if (aValue instanceof ValueOrEnumValueOrOperation) {
			return convertEncapsulatedValueToParamType(aTargetClass, (ValueOrEnumValueOrOperation) aValue,
					anUnresolvableVariableHandlingPolicy);
		} else {
			return convertPlainValueToParamType(aTargetClass, aValue, anUnresolvableVariableHandlingPolicy);
		}
	}

	/**
	 * Converts a given plain value (no instance of {@link ValueOrEnumValueOrOperation} or
	 * {@link ValueOrEnumValueOrOperationCollection}) to a given Java type class, if possible.
	 * 
	 * @param aTargetClass
	 *            the target type
	 * @param aValue
	 *            the value
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted value
	 */
	protected Object convertPlainValueToParamType(Class<?> aTargetClass, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (aValue == null) {
			return null;
		}

		if (aTargetClass != null && aTargetClass.isArray()) {
			Class<?> tempActualParamType = aTargetClass.getComponentType();
			Object tempResultArray;
			if (aValue.getClass().isArray()) {
				// both are arrays
				tempResultArray = Array.newInstance(tempActualParamType, Array.getLength(aValue));
				for (int i = 0; i < Array.getLength(aValue); i++) {
					Array.set(
							tempResultArray,
							i,
							convertPlainValueToParamType(tempActualParamType, Array.get(aValue, i),
									anUnresolvableVariableHandlingPolicy));
				}
			} else {
				// target is an array, but value is a single value
				tempResultArray = Array.newInstance(tempActualParamType, 1);
				Array.set(tempResultArray, 0,
						convertPlainValueToParamType(tempActualParamType, aValue, anUnresolvableVariableHandlingPolicy));
			}
			return tempResultArray;
		} else {
			if (aValue.getClass().isArray()) {
				// this is not convertible, but since this method does not guarantee any conversion...
				return aValue;
			} else {
				// unresolvable variables can't happen here, since variable values should have gone down the other path
				return convertSingleValueToParamType(aTargetClass, aValue, anUnresolvableVariableHandlingPolicy);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Object convertSingleValueToParamType(Class<?> aParamType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (aValue == null) {
			return null;
		} else if (aParamType != null && aParamType.isAssignableFrom(aValue.getClass())) {
			// No conversion necessary
			return aValue;
		}

		try {
			@SuppressWarnings("rawtypes")
			Conversion tempConversion = findConversion(aValue.getClass(), aParamType);
			if (tempConversion != null) {
				return tempConversion.convert(aValue, aParamType, anUnresolvableVariableHandlingPolicy);
			}
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		}

		throw new ConversionUnsupportedException(aValue.getClass(), aParamType, "Could not find a matching conversion");
	}

	/**
	 * Converts a given {@link ValueOrEnumValueOrOperation} to a given Java type class, if possible.
	 * 
	 * @param aTargetClass
	 *            the target type
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
	protected Object convertEncapsulatedValueToParamType(Class<?> aTargetClass, ValueOrEnumValueOrOperation aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {
		if (aValue == null) {
			return null;
		}

		if (aValue instanceof Operation) {
			if (wrapperFactory == null) {
				// cannot execute operations without the ability to load them
				return null;
			} else {
				OperationWrapper tempWrapper = wrapperFactory.newOperationWrapper((Operation) aValue);
				Object tempResult = tempWrapper.executeOperation(anUnresolvableVariableHandlingPolicy);
				return convertPlainValueToParamType(aTargetClass, tempResult, anUnresolvableVariableHandlingPolicy);
			}
		} else if (aValue instanceof Variable) {
			Object tempResult = parameterResolver.resolveSingleParameterValue(aValue,
					anUnresolvableVariableHandlingPolicy);
			return convertSingleValueToParamType(aTargetClass, tempResult, anUnresolvableVariableHandlingPolicy);
		} else {
			return convertPlainValueToParamType(aTargetClass, aValue, anUnresolvableVariableHandlingPolicy);
		}
	}

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item.
	 * 
	 * @param aTargetClass
	 *            the target type
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
	protected Object convertEncapsulatedValueCollectionToParamType(Class<?> aTargetClass,
			ValueOrEnumValueOrOperationCollection aCollection,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {

		Class<?> tempTargetParamType = null;
		if (aTargetClass != null && aTargetClass.isArray()) {
			tempTargetParamType = aTargetClass.getComponentType();
		} else {
			tempTargetParamType = aTargetClass;
		}

		Class<?> tempTargetArrayType = tempTargetParamType;
		if (tempTargetArrayType == null) {
			tempTargetArrayType = Object.class;
		}

		if (aCollection.getMoreValues() != null && aCollection.getMoreValues().size() > 0) {
			// this is actually an array
			Object tempResultArray = Array.newInstance(tempTargetArrayType, aCollection.getMoreValues().size() + 1);
			for (int i = 0; i < aCollection.getMoreValues().size() + 1; i++) {
				ValueOrEnumValueOrOperation tempValue = (i == 0 ? aCollection.getValue() : aCollection.getMoreValues()
						.get(i - 1));
				Object tempResultValue = convertEncapsulatedValueToParamType(tempTargetParamType, tempValue,
						anUnresolvableVariableHandlingPolicy);
				Array.set(tempResultArray, i, tempResultValue);
			}

			// now we need to see whether we're even allowed to return an array
			if (aTargetClass == null || aTargetClass.isArray()) {
				return tempResultArray;
			} else {
				throw new IllegalArgumentException("Parameter type class " + aTargetClass
						+ " is not an array, but more than one value was given for conversion.");
			}
		} else {
			// this is just a single value
			Object tempResult = convertEncapsulatedValueToParamType(tempTargetParamType, aCollection.getValue(),
					anUnresolvableVariableHandlingPolicy);

			// but we might need to return this as an array with one element
			if (aTargetClass != null && aTargetClass.isArray()) {
				Object tempResultArray = Array.newInstance(tempTargetArrayType, 1);
				Array.set(tempResultArray, 0, tempResult);
				return tempResultArray;
			} else {
				return tempResult;
			}
		}
	}

	@Override
	public String convertValueToString(Object aValue, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
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
		String[] tempResult;
		try {
			if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
				tempResult = (String[]) convertEncapsulatedValueCollectionToParamType(String[].class,
						(ValueOrEnumValueOrOperationCollection) aValue, anUnresolvableVariableHandlingPolicy);
			} else if (aValue instanceof ValueOrEnumValueOrOperation) {
				tempResult = (String[]) convertEncapsulatedValueToParamType(String[].class,
						(ValueOrEnumValueOrOperation) aValue, anUnresolvableVariableHandlingPolicy);
			} else {
				tempResult = (String[]) convertPlainValueToParamType(String[].class, aValue,
						anUnresolvableVariableHandlingPolicy);
			}
		} catch (InstantiationException exc) {
			exc.printStackTrace();
			return new String[] { "FAILURE" };
		} catch (UnresolvableVariableException exc) {
			exc.printStackTrace();
			return new String[] { "FAILURE" };
		} catch (ClassNotFoundException exc) {
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
	@SuppressWarnings("unchecked")
	protected void addConversion(Class<? extends Conversion> aConversion) {
		Class<? extends Conversion<?, ?>> tempConversion = (Class<? extends Conversion<?, ?>>) aConversion;
		ConversionKey tempConversionKey = new ConversionKey(tempConversion);

		// See whether the new conversion has a higher priority than the current default conversion for the given
		// source type
		try {
			Conversion<?, ?> tempInstance = (Conversion<?, ?>) createConversionInstance(aConversion, false);
			int tempNewPriority = tempInstance.getPriority();
			Integer tempCurrentPriority = conversionPriority.get(tempConversionKey.getSourceType());
			if (tempCurrentPriority == null || (tempNewPriority > tempCurrentPriority)) {
				defaultConversions.put(tempConversionKey.getSourceType(), tempConversion);
				conversionPriority.put(tempConversionKey.getSourceType(), tempCurrentPriority);
			}
		} catch (InstantiationException exc) {
			throw new IllegalArgumentException("Failed to instantiate conversion: " + aConversion.getName());
		} catch (IllegalAccessException exc) {
			throw new IllegalArgumentException("Failed to instantiate conversion: " + aConversion.getName());
		}

		conversions.put(tempConversionKey, tempConversion);
	}

	private static ParameterizedType findGenericInterfaceType(Type aType, Class<?> aGenericInterfaceClass) {
		if (aType instanceof ParameterizedType) {
			if (((ParameterizedType) aType).getRawType().equals(aGenericInterfaceClass)) {
				return (ParameterizedType) aType;
			}
		}

		if (aType instanceof Class) {
			for (Type tempInterface : ((Class<?>) aType).getGenericInterfaces()) {
				ParameterizedType tempType = findGenericInterfaceType(tempInterface, aGenericInterfaceClass);
				if (tempType != null) {
					return tempType;
				}
			}

			Class<?> tempSuperclass = ((Class<?>) aType).getSuperclass();
			if (tempSuperclass != null) {
				return findGenericInterfaceType(tempSuperclass, aGenericInterfaceClass);
			}
		}

		return null;
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

			Type tempType = findGenericInterfaceType(tempClass, Conversion.class);
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
	protected Conversion<?, ?> findConversion(Class<?> aSourceType, Class<?> aTargetType)
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

					tempTargetTypeInFocus = tempTargetTypeInFocus.getSuperclass();
				}
			}

			if (tempConversionClass != null) {
				return createConversionInstance(tempConversionClass, true);
			} else {
				for (Class<?> tempSourceInterface : tempSourceTypeInFocus.getInterfaces()) {
					if (aTargetType == null) {
						// This is the default target type case
						Conversion<?, ?> tempConversion = findConversion(tempSourceInterface, null);
						if (tempConversion != null) {
							return tempConversion;
						}
					} else {
						// We actually have a target type
						Class<?> tempTargetTypeInFocus = aTargetType;
						while (tempTargetTypeInFocus != null) {
							Conversion<?, ?> tempConversion = findConversion(tempSourceInterface, tempTargetTypeInFocus);
							if (tempConversion != null) {
								return tempConversion;
							}

							for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
								tempConversion = findConversion(tempSourceInterface, tempTargetInterface);
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
	 * @param anInjectFlag
	 *            whether Guice dependencies shall be injected
	 * @return the new instance
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected <C extends Conversion> C createConversionInstance(Class<C> aConversionClass, boolean anInjectFlag)
			throws InstantiationException, IllegalAccessException {
		C tempInstance = aConversionClass.newInstance();
		if (anInjectFlag) {
			injector.injectMembers(tempInstance);
		}

		return tempInstance;
	}

}
