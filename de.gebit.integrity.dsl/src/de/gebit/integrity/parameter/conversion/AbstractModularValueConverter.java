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

import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.operations.OperationWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

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
	ParameterResolver parameterResolver;

	/**
	 * All known targeted conversions.
	 */
	private Map<TargetedConversionKey, Class<? extends TargetedConversion<?, ?>>> targetedConversions = new HashMap<TargetedConversionKey, Class<? extends TargetedConversion<?, ?>>>();

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
	public Object convertValueToParamType(Class<?> aParamType, Object aValue) {
		if (aValue == null) {
			return null;
		}

		if (aParamType.isArray()) {
			Class<?> tempActualParamType = aParamType.getComponentType();
			Object tempResultArray;
			if (aValue.getClass().isArray()) {
				// both are arrays
				tempResultArray = Array.newInstance(tempActualParamType, Array.getLength(aValue));
				for (int i = 0; i < Array.getLength(aValue); i++) {
					Array.set(tempResultArray, i,
							convertSingleValueToParamType(tempActualParamType, Array.get(aValue, i)));
				}
			} else {
				// target is an array, but value is a single value
				tempResultArray = Array.newInstance(tempActualParamType, 1);
				Array.set(tempResultArray, 0, convertSingleValueToParamType(tempActualParamType, aValue));
			}
			return tempResultArray;
		} else {
			// target is a single value
			if (aValue.getClass().isArray()) {
				// this is not convertible, but since this method does not guarantee any conversion...
				return aValue;
			} else {
				return convertSingleValueToParamType(aParamType, aValue);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Object convertSingleValueToParamType(Class<?> aParamType, Object aValue) {
		if (aValue == null) {
			return null;
		} else if (aParamType.isAssignableFrom(aValue.getClass())) {
			// No conversion necessary
			return aValue;
		}

		try {
			@SuppressWarnings("rawtypes")
			UntargetedConversion tempUntargetedConversion = findUntargetedConversion(aValue.getClass());
			if (tempUntargetedConversion != null) {
				return tempUntargetedConversion.convert(aValue, aParamType);
			}

			@SuppressWarnings("rawtypes")
			TargetedConversion tempTargetedConversion = findTargetedConversion(aValue.getClass(), aParamType);
			if (tempTargetedConversion != null) {
				return tempTargetedConversion.convert(aValue);
			}
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aValue.getClass(), aParamType, "Failed to instantiate conversion", exc);
		}

		throw new ConversionFailedException(aValue.getClass(), aParamType, "Could not find a matching conversion");
	}

	@Override
	public Object convertEncapsulatedValueToParamType(Class<?> aParamType, ValueOrEnumValueOrOperation aValue,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {
		if (aValue == null) {
			return null;
		}

		if (aValue instanceof Operation) {
			if (aClassLoader == null) {
				// cannot execute operations without the ability to load them
				return null;
			} else {
				OperationWrapper tempWrapper = new OperationWrapper((Operation) aValue, aClassLoader, this);
				Object tempResult = tempWrapper.executeOperation(aVariableMap, false);
				return convertValueToParamType(aParamType, tempResult);
			}
		} else if (aValue instanceof Variable) {
			Object tempResult;
			if (aVariableMap != null) {
				tempResult = parameterResolver.resolveSingleParameterValue(aValue, aVariableMap, aClassLoader, this,
						true);
				if (tempResult instanceof Variable) {
					throw new UnresolvableVariableException("Unresolvable variable "
							+ ((Variable) aValue).getName().getName() + " encountered!");
				} else {
					return convertSingleValueToParamType(aParamType, tempResult);
				}
			} else {
				throw new UnresolvableVariableException("Unresolved variable "
						+ ((Variable) aValue).getName().getName() + " encountered, but missing variable to value map!");
			}
		} else if (aValue instanceof NestedObject) {
			if (aParamType == String.class) {
				return aValue.toString();
			} else if (Map.class.isAssignableFrom(aParamType)) {
				@SuppressWarnings("unchecked")
				Map<String, Object> tempResult = (Map<String, Object>) parameterResolver.resolveSingleParameterValue(
						aValue, aVariableMap, aClassLoader, this, false);
				// TODO this must be converted!
				return tempResult;
			} else {
				throw new IllegalArgumentException("Cannot convert a nested object to parameter type " + aParamType
						+ " - it's advised to use a java.util.Map as target type!");
			}
		} else {
			return convertValueToParamType(aParamType, aValue);
		}
	}

	@Override
	public Object convertEncapsulatedValueCollectionToParamType(Class<?> aParamType,
			ValueOrEnumValueOrOperationCollection aCollection, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader) throws ClassNotFoundException, UnexecutableException, InstantiationException {

		Class<?> tempTargetParamType = null;
		if (aParamType.isArray()) {
			tempTargetParamType = aParamType.getComponentType();
		} else {
			tempTargetParamType = aParamType;
		}

		if (aCollection.getMoreValues() != null && aCollection.getMoreValues().size() > 0) {
			// this is actually an array
			Object tempResultArray = Array.newInstance(tempTargetParamType, aCollection.getMoreValues().size() + 1);
			for (int i = 0; i < aCollection.getMoreValues().size() + 1; i++) {
				ValueOrEnumValueOrOperation tempValue = (i == 0 ? aCollection.getValue() : aCollection.getMoreValues()
						.get(i - 1));
				Object tempResultValue = convertEncapsulatedValueToParamType(tempTargetParamType, tempValue,
						aVariableMap, aClassLoader);
				Array.set(tempResultArray, i, tempResultValue);
			}

			// now we need to see whether we're even allowed to return an array
			if (aParamType.isArray()) {
				return tempResultArray;
			} else {
				throw new IllegalArgumentException("Parameter type class " + aParamType
						+ " is not an array, but more than one value was given for conversion.");
			}
		} else {
			// this is just a single value
			Object tempResult = convertEncapsulatedValueToParamType(tempTargetParamType, aCollection.getValue(),
					aVariableMap, aClassLoader);

			// but we might need to return this as an array with one element
			if (aParamType.isArray()) {
				Object tempResultArray = Array.newInstance(tempTargetParamType, 1);
				Array.set(tempResultArray, 0, tempResult);
				return tempResultArray;
			} else {
				return tempResult;
			}
		}
	}

	@Override
	public String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, boolean anAllowNullResultFlag) {
		// always convert to an array, so array values will convert fine
		String[] tempResult;
		try {
			if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
				tempResult = (String[]) convertEncapsulatedValueCollectionToParamType(String[].class,
						(ValueOrEnumValueOrOperationCollection) aValue, aVariableMap, aClassLoader);
			} else if (aValue instanceof ValueOrEnumValueOrOperation) {
				tempResult = (String[]) convertEncapsulatedValueToParamType(String[].class,
						(ValueOrEnumValueOrOperation) aValue, aVariableMap, aClassLoader);
			} else {
				tempResult = (String[]) convertValueToParamType(String[].class, aValue);
			}
		} catch (InstantiationException exc) {
			exc.printStackTrace();
			return "FAILURE";
		} catch (UnresolvableVariableException exc) {
			exc.printStackTrace();
			return "FAILURE";
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			return "FAILURE";
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
			return "FAILURE";
		}

		if (tempResult == null && !anAllowNullResultFlag) {
			return "null";
		} else {
			if (tempResult != null) {
				StringBuilder tempBuffer = new StringBuilder();
				for (String tempSingleResult : tempResult) {
					if (tempBuffer.length() > 0) {
						tempBuffer.append(", ");
					}
					tempBuffer.append(tempSingleResult);
				}

				return tempBuffer.toString();
			} else {
				return null;
			}
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
			targetedConversions
					.put(new TargetedConversionKey(
							(Class<? extends TargetedConversion<?, ?>>) (Class<? extends TargetedConversion<?, ?>>) aConversion),
							(Class<? extends TargetedConversion<?, ?>>) aConversion);
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
		 * Internally, a string is used to determine equality and hash code.
		 */
		private String internalKey;

		private void generateInternalKey(Class<?> aSourceType, Class<?> aTargetType) {
			internalKey = (aSourceType.getName() + "|" + aTargetType.getName());
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
			generateInternalKey(aSourceType, aTargetType);
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
				generateInternalKey(tempSourceType, tempTargetType);
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
				return tempConversionClass.newInstance();
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
			Class<? extends TargetedConversion<?, ?>> tempConversionClass = targetedConversions
					.get(new TargetedConversionKey(tempSourceTypeInFocus, aTargetType));

			if (tempConversionClass != null) {
				return tempConversionClass.newInstance();
			} else {
				for (Class<?> tempInterface : tempSourceTypeInFocus.getInterfaces()) {
					TargetedConversion<?, ?> tempConversion = findTargetedConversion(tempInterface, aTargetType);
					if (tempConversion != null) {
						return tempConversion;
					}
				}

				tempSourceTypeInFocus = tempSourceTypeInFocus.getSuperclass();
			}
		}

		return null;
	}

}
