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
	 * All known targeted conversions.
	 */
	private Map<TargetedConversionKey, Class<? extends TargetedConversion<?, ?>>> targetedConversions = new HashMap<TargetedConversionKey, Class<? extends TargetedConversion<?, ?>>>();

	/**
	 * The default targeted conversions for all known source types. These are the conversions with the highest priority
	 * from their respective source types' conversion pool.
	 */
	private Map<Class<?>, Class<? extends TargetedConversion<?, ?>>> defaultTargetedConversions = new HashMap<Class<?>, Class<? extends TargetedConversion<?, ?>>>();

	/**
	 * The current defaults' priority. Used to fill the {@link #defaultTargetedConversions} map.
	 */
	private Map<Class<?>, Integer> targetedConversionPriority = new HashMap<Class<?>, Integer>();

	/**
	 * All known untargeted conversions.
	 */
	private Map<Class<?>, Class<? extends UntargetedConversion<?>>> untargetedConversions = new HashMap<Class<?>, Class<? extends UntargetedConversion<?>>>();

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
	public Object convertValueToParamType(Class<?> aParamType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (aValue == null) {
			return null;
		}

		if (aParamType != null && aParamType.isArray()) {
			Class<?> tempActualParamType = aParamType.getComponentType();
			Object tempResultArray;
			if (aValue.getClass().isArray()) {
				// both are arrays
				tempResultArray = Array.newInstance(tempActualParamType, Array.getLength(aValue));
				for (int i = 0; i < Array.getLength(aValue); i++) {
					Array.set(
							tempResultArray,
							i,
							convertValueToParamType(tempActualParamType, Array.get(aValue, i),
									anUnresolvableVariableHandlingPolicy));
				}
			} else {
				// target is an array, but value is a single value
				tempResultArray = Array.newInstance(tempActualParamType, 1);
				Array.set(tempResultArray, 0,
						convertValueToParamType(tempActualParamType, aValue, anUnresolvableVariableHandlingPolicy));
			}
			return tempResultArray;
		} else {
			// target is a single value
			// if (aValue instanceof Map) {
			// // maps are explored and all contained values are converted
			// convertMapOfValues((Map<?, ?>) aValue, aParamType);
			// }

			if (aValue.getClass().isArray()) {
				// this is not convertible, but since this method does not guarantee any conversion...
				return aValue;
			} else {
				// unresolvable variables can't happen here, since variable values should have gone down the other path
				return convertSingleValueToParamType(aParamType, aValue, anUnresolvableVariableHandlingPolicy);
			}
		}
	}

	// /**
	// * Internally used to convert trees of parameters to the given target type or their respective default target
	// types.
	// * The conversion happens "in-place", that is, the given map will be altered!
	// *
	// * @param aMap
	// * the map to convert
	// * @param aTargetType
	// * the target type (if null, default conversions are used)
	// * @return the converted map (which is currently the same map that was given to the method!)
	// */
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// protected Map<?, ?> convertMapOfValues(Map<?, ?> aMap, Class<?> aTargetType) {
	// for (Entry tempEntry : aMap.entrySet()) {
	// if (tempEntry.getValue() instanceof Map) {
	// convertMapOfValues((Map) tempEntry.getValue(), aTargetType);
	// } else {
	// Object tempConvertedValue = convertSingleValueToParamType(aTargetType, tempEntry.getValue());
	// tempEntry.setValue(tempConvertedValue);
	// }
	// }
	//
	// return aMap;
	// }

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
			UntargetedConversion tempUntargetedConversion = findUntargetedConversion(aValue.getClass());
			if (tempUntargetedConversion != null) {
				return tempUntargetedConversion.convert(aValue, aParamType, anUnresolvableVariableHandlingPolicy);
			}

			@SuppressWarnings("rawtypes")
			TargetedConversion tempTargetedConversion = findTargetedConversion(aValue.getClass(), aParamType);
			if (tempTargetedConversion != null) {
				return tempTargetedConversion.convert(aValue, anUnresolvableVariableHandlingPolicy);
			}
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		}

		throw new ConversionUnsupportedException(aValue.getClass(), aParamType, "Could not find a matching conversion");
	}

	@Override
	public Object convertEncapsulatedValueToParamType(Class<?> aParamType, ValueOrEnumValueOrOperation aValue,
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
				Object tempResult = tempWrapper.executeOperation(false);
				return convertValueToParamType(aParamType, tempResult, anUnresolvableVariableHandlingPolicy);
			}
		} else if (aValue instanceof Variable) {
			Object tempResult = parameterResolver.resolveSingleParameterValue(aValue, true);
			if (tempResult instanceof Variable) {
				// the variable was not resolvable
				switch (anUnresolvableVariableHandlingPolicy) {
				case RESOLVE_TO_NULL_VALUE:
					return null;
				case RESOLVE_TO_NAME_STRING:
					return ((Variable) tempResult).getName().getName();
				case RESOLVE_TO_NULL_STRING:
					return "null";
				case RESOLVE_TO_QUESTIONMARK_STRING:
					return "???";
				case EXCEPTION:
				default:
					throw new UnresolvableVariableException("Unresolvable variable "
							+ ((Variable) aValue).getName().getName() + " encountered!");
				}
			} else {
				return convertSingleValueToParamType(aParamType, tempResult, anUnresolvableVariableHandlingPolicy);
			}
			// } else if (aValue instanceof NestedObject) {
			// if (Map.class.isAssignableFrom(aParamType)) {
			// @SuppressWarnings("unchecked")
			// Map<String, Object> tempResult = (Map<String, Object>) parameterResolver.resolveSingleParameterValue(
			// aValue, aVariableMap, aClassLoader, this, false);
			//
			// convertMapOfValues(tempResult, null);
			//
			// return tempResult;
			// } else if (aParamType == String.class) {
			// Map<?, ?> tempMap = (Map<?, ?>) convertEncapsulatedValueToParamType(Map.class, aValue, aVariableMap,
			// aClassLoader);
			// return convertValueToString(tempMap, aVariableMap, aClassLoader, true);
			// } else {
			// throw new IllegalArgumentException("Cannot convert a nested object to parameter type " + aParamType
			// + " - it's advised to use a java.util.Map as target type!");
			// }
		} else {
			return convertValueToParamType(aParamType, aValue, anUnresolvableVariableHandlingPolicy);
		}
	}

	@Override
	public Object convertEncapsulatedValueCollectionToParamType(Class<?> aParamType,
			ValueOrEnumValueOrOperationCollection aCollection,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {

		Class<?> tempTargetParamType = null;
		if (aParamType != null && aParamType.isArray()) {
			tempTargetParamType = aParamType.getComponentType();
		} else {
			tempTargetParamType = aParamType;
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
			if (aParamType == null || aParamType.isArray()) {
				return tempResultArray;
			} else {
				throw new IllegalArgumentException("Parameter type class " + aParamType
						+ " is not an array, but more than one value was given for conversion.");
			}
		} else {
			// this is just a single value
			Object tempResult = convertEncapsulatedValueToParamType(tempTargetParamType, aCollection.getValue(),
					anUnresolvableVariableHandlingPolicy);

			// but we might need to return this as an array with one element
			if (aParamType != null && aParamType.isArray()) {
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
				tempResult = (String[]) convertValueToParamType(String[].class, aValue,
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
		if (TargetedConversion.class.isAssignableFrom(aConversion)) {
			Class<? extends TargetedConversion<?, ?>> tempTargetedConversion = (Class<? extends TargetedConversion<?, ?>>) aConversion;
			TargetedConversionKey tempTargetedConversionKey = new TargetedConversionKey(tempTargetedConversion);

			// See whether the new conversion has a higher priority than the current default conversion for the given
			// source type
			try {
				TargetedConversion<?, ?> tempInstance = (TargetedConversion<?, ?>) createConversionInstance(
						aConversion, false);
				int tempNewPriority = tempInstance.getPriority();
				Integer tempCurrentPriority = targetedConversionPriority.get(tempTargetedConversionKey.getSourceType());
				if (tempCurrentPriority == null || (tempNewPriority > tempCurrentPriority)) {
					defaultTargetedConversions.put(tempTargetedConversionKey.getSourceType(), tempTargetedConversion);
					targetedConversionPriority.put(tempTargetedConversionKey.getSourceType(), tempCurrentPriority);
				}
			} catch (InstantiationException exc) {
				throw new IllegalArgumentException("Failed to instantiate targeted conversion: "
						+ aConversion.getName());
			} catch (IllegalAccessException exc) {
				throw new IllegalArgumentException("Failed to instantiate targeted conversion: "
						+ aConversion.getName());
			}

			targetedConversions.put(tempTargetedConversionKey, tempTargetedConversion);
		} else if (UntargetedConversion.class.isAssignableFrom(aConversion)) {
			untargetedConversions.put(
					determineUntargetedConversionKey((Class<? extends UntargetedConversion<?>>) aConversion),
					(Class<? extends UntargetedConversion<?>>) aConversion);
		} else {
			throw new IllegalArgumentException("This conversion type is not supported: " + aConversion.getName());
		}
	}

	private static Class<?> determineUntargetedConversionKey(Class<? extends UntargetedConversion<?>> aConversion) {
		ParameterizedType tempType = findGenericInterfaceType(aConversion, UntargetedConversion.class);

		if (tempType == null) {
			throw new IllegalArgumentException("Was unable to find valid generic UntargetedConversion superinterface");
		} else {
			return (Class<?>) tempType.getActualTypeArguments()[0];
		}
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
	protected static class TargetedConversionKey {

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
		public TargetedConversionKey(Class<?> aSourceType, Class<?> aTargetType) {
			initializeInternalKey(aSourceType, aTargetType);
		}

		/**
		 * Takes a {@link TargetedConversion} implementation and determines the applicable conversion key.
		 * 
		 * @param aConversion
		 *            the conversion to look at
		 */
		public TargetedConversionKey(Class<? extends TargetedConversion<?, ?>> aConversion) {
			Class<?> tempClass = aConversion;

			Type tempType = findGenericInterfaceType(tempClass, TargetedConversion.class);
			if (tempType != null) {
				Class<?> tempSourceType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[0];
				Class<?> tempTargetType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[1];
				initializeInternalKey(tempSourceType, tempTargetType);
			} else {
				throw new IllegalArgumentException("Was unable to find valid generic TargetedConversion superinterface");
			}
		}

		@Override
		public int hashCode() {
			return internalKey.hashCode();
		}

		@Override
		public boolean equals(Object anObject) {
			if (!(anObject instanceof TargetedConversionKey)) {
				return false;
			} else {
				return internalKey.equals(((TargetedConversionKey) anObject).internalKey);
			}
		}

		@Override
		public String toString() {
			return internalKey;
		}
	}

	/**
	 * Searches all known untargeted conversions for a match which is able to convert a value of a given source type.
	 * 
	 * @param aSourceType
	 *            the source type
	 * @return the suitable, instantiated conversion, or null if none was found
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected UntargetedConversion<?> findUntargetedConversion(Class<?> aSourceType) throws InstantiationException,
			IllegalAccessException {
		Class<?> tempSourceTypeInFocus = aSourceType;
		while (tempSourceTypeInFocus != null) {
			Class<? extends UntargetedConversion<?>> tempConversionClass = untargetedConversions
					.get(tempSourceTypeInFocus);

			if (tempConversionClass != null) {
				return createConversionInstance(tempConversionClass, true);
			} else {
				for (Class<?> tempInterface : tempSourceTypeInFocus.getInterfaces()) {
					UntargetedConversion<?> tempConversion = findUntargetedConversion(tempInterface);
					if (tempConversion != null) {
						return tempConversion;
					}
				}

				tempSourceTypeInFocus = tempSourceTypeInFocus.getSuperclass();
			}
		}

		return null;
	}

	/**
	 * Searches all known targeted conversions for a match which is able to convert a given source type into a given
	 * target type.
	 * 
	 * @param aSourceType
	 *            the source type
	 * @param aTargetType
	 *            the target type
	 * @return a ready-to-use, instantiated conversion, or null if none was found
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected TargetedConversion<?, ?> findTargetedConversion(Class<?> aSourceType, Class<?> aTargetType)
			throws InstantiationException, IllegalAccessException {
		Class<?> tempSourceTypeInFocus = aSourceType;
		while (tempSourceTypeInFocus != null) {
			Class<? extends TargetedConversion<?, ?>> tempConversionClass = null;
			if (aTargetType == null) {
				// This is the default target type case
				tempConversionClass = defaultTargetedConversions.get(tempSourceTypeInFocus);
			} else {
				// We actually have a target type
				Class<?> tempTargetTypeInFocus = aTargetType;
				while (tempTargetTypeInFocus != null) {
					tempConversionClass = targetedConversions.get(new TargetedConversionKey(tempSourceTypeInFocus,
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
						TargetedConversion<?, ?> tempConversion = findTargetedConversion(tempSourceInterface, null);
						if (tempConversion != null) {
							return tempConversion;
						}
					} else {
						// We actually have a target type
						Class<?> tempTargetTypeInFocus = aTargetType;
						while (tempTargetTypeInFocus != null) {
							TargetedConversion<?, ?> tempConversion = findTargetedConversion(tempSourceInterface,
									tempTargetTypeInFocus);
							if (tempConversion != null) {
								return tempConversion;
							}

							for (Class<?> tempTargetInterface : tempTargetTypeInFocus.getInterfaces()) {
								tempConversion = findTargetedConversion(tempSourceInterface, tempTargetInterface);
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
