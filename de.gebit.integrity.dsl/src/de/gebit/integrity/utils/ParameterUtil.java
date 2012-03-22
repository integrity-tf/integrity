package de.gebit.integrity.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;

/**
 * A utility class for handling of test/call parameters.
 * 
 * @author Rene Schneider
 * 
 */
public final class ParameterUtil {

	private ParameterUtil() {
		// nothing to do
	}

	/**
	 * The "fake" name of the default parameter. This is used for unnamed parameters in maps which require a non-null
	 * key.
	 */
	public static final String DEFAULT_PARAMETER_NAME = "";

	/**
	 * Converts a given value to a given Java type class, if possible.
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aValue
	 *            the value
	 * @return the converted value
	 */
	public static Object convertValueToParamType(Class<?> aParamType, Object aValue) {
		if (aValue instanceof Number) {
			if (aParamType == Integer.class) {
				return aValue;
			} else if (aParamType == Long.class) {
				return ((Number) aValue).longValue();
			} else if (aParamType == Short.class) {
				return ((Number) aValue).shortValue();
			} else if (aParamType == Byte.class) {
				return ((Number) aValue).byteValue();
			} else if (aParamType == BigInteger.class) {
				return BigInteger.valueOf(((Number) aValue).longValue());
			} else if (aParamType == BigDecimal.class) {
				if (aValue instanceof Integer) {
					return new BigDecimal((Integer) aValue);
				} else if (aValue instanceof Long) {
					return new BigDecimal((Long) aValue);
				} else if (aValue instanceof Short) {
					return new BigDecimal((Short) aValue);
				} else if (aValue instanceof Byte) {
					return new BigDecimal((Byte) aValue);
				} else if (aValue instanceof Float) {
					return new BigDecimal((Float) aValue);
				} else if (aValue instanceof Double) {
					return new BigDecimal((Double) aValue);
				} else if (aValue instanceof BigInteger) {
					return new BigDecimal((BigInteger) aValue);
				}
			} else if (aParamType == Float.class) {
				return ((Number) aValue).floatValue();
			} else if (aParamType == Double.class) {
				return ((Number) aValue).doubleValue();
			} else if (aParamType == String.class) {
				return aValue.toString();
			}
		} else if (aValue instanceof String) {
			if (aParamType == Integer.class) {
				return Integer.parseInt((String) aValue);
			} else if (aParamType == Long.class) {
				return Long.parseLong((String) aValue);
			} else if (aParamType == Short.class) {
				return Short.parseShort((String) aValue);
			} else if (aParamType == Byte.class) {
				return Byte.parseByte((String) aValue);
			} else if (aParamType == Float.class) {
				return Float.parseFloat((String) aValue);
			} else if (aParamType == Double.class) {
				return Double.parseDouble((String) aValue);
			} else if (aParamType == BigDecimal.class) {
				return new BigDecimal((String) aValue);
			} else if (aParamType == BigInteger.class) {
				return new BigInteger((String) aValue);
			}
		} else if (aValue instanceof Boolean) {
			if (aParamType == String.class) {
				return aValue.toString();
			}
		}

		return aValue;
	}

	/**
	 * Converts a given parameter value to a given Java type class, if possible.
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aValue
	 *            the value
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @return the converted value
	 * @throws IllegalArgumentException
	 *             if the conversion required is not supported
	 */
	public static Object convertEncapsulatedValueToParamType(Class<?> aParamType, ValueOrEnumValue aValue,
			Map<VariableEntity, Object> aVariableMap) {
		if (aValue == null) {
			return null;
		}

		if (aValue instanceof DecimalValue) {
			if (aParamType == Float.class) {
				return ((DecimalValue) aValue).getDecimalValue().floatValue();
			} else if (aParamType == Double.class) {
				return ((DecimalValue) aValue).getDecimalValue().doubleValue();
			} else if (aParamType == BigDecimal.class) {
				return ((DecimalValue) aValue).getDecimalValue();
			} else if (aParamType == String.class) {
				return ((DecimalValue) aValue).getDecimalValue().toString();
			}
		} else if (aValue instanceof IntegerValue) {
			if (aParamType == Integer.class) {
				return ((IntegerValue) aValue).getIntegerValue().intValue();
			} else if (aParamType == Short.class) {
				return ((IntegerValue) aValue).getIntegerValue().shortValue();
			} else if (aParamType == Byte.class) {
				return ((IntegerValue) aValue).getIntegerValue().byteValue();
			} else if (aParamType == Long.class) {
				return ((IntegerValue) aValue).getIntegerValue().longValue();
			} else if (aParamType == BigDecimal.class) {
				return new BigDecimal(((IntegerValue) aValue).getIntegerValue(), 0);
			} else if (aParamType == BigInteger.class) {
				return ((IntegerValue) aValue).getIntegerValue();
			} else if (aParamType == Float.class) {
				return ((IntegerValue) aValue).getIntegerValue().floatValue();
			} else if (aParamType == Double.class) {
				return ((IntegerValue) aValue).getIntegerValue().doubleValue();
			} else if (aParamType == String.class) {
				return Integer.toString(((IntegerValue) aValue).getIntegerValue().intValue());
			}
		} else if (aValue instanceof NullValue) {
			return null;
		} else if (aValue instanceof StringValue) {
			if (aParamType == String.class) {
				return ((StringValue) aValue).getStringValue();
			} else {
				try {
					if (aParamType == Integer.class) {
						return Integer.parseInt(((StringValue) aValue).getStringValue());
					} else if (aParamType == Short.class) {
						return Short.parseShort(((StringValue) aValue).getStringValue());
					} else if (aParamType == Byte.class) {
						return Byte.parseByte(((StringValue) aValue).getStringValue());
					} else if (aParamType == Long.class) {
						return Long.parseLong(((StringValue) aValue).getStringValue());
					} else if (aParamType == BigDecimal.class) {
						return new BigDecimal(((StringValue) aValue).getStringValue());
					} else if (aParamType == BigInteger.class) {
						return new BigInteger(((StringValue) aValue).getStringValue());
					} else if (aParamType == Float.class) {
						return Float.parseFloat(((StringValue) aValue).getStringValue());
					} else if (aParamType == Double.class) {
						return Double.parseDouble(((StringValue) aValue).getStringValue());
					}
				} catch (NumberFormatException exc) {
					throw new IllegalArgumentException("String value '" + ((StringValue) aValue).getStringValue() + "'"
							+ " is not autoconvertible to parameter type " + aParamType);
				}
			}
		} else if (aValue instanceof EnumValue) {
			if (Enum.class.isAssignableFrom(aParamType)) {
				for (Object tempConstant : aParamType.getEnumConstants()) {
					if (tempConstant.toString().equals(((EnumValue) aValue).getEnumValue().getSimpleName())) {
						return tempConstant;
					}
				}
			}
		} else if (aValue instanceof Variable) {
			if (aVariableMap != null) {
				Object tempActualValue = aVariableMap.get(((Variable) aValue).getName());
				if (tempActualValue != null) {
					if (tempActualValue instanceof Value) {
						return convertEncapsulatedValueToParamType(aParamType, (Value) tempActualValue, aVariableMap);
					} else {
						return convertValueToParamType(aParamType, tempActualValue);
					}
				} else {
					return null;
				}
			} else {
				throw new IllegalArgumentException("Unresolved variable " + ((Variable) aValue).getName().getName()
						+ " encountered, but missing variable to value map!");
			}
		} else if (aValue instanceof BooleanValue) {
			if (aParamType == Boolean.class) {
				return Boolean.valueOf(((BooleanValue) aValue).getBooleanValue());
			} else if (aParamType == String.class) {
				return ((BooleanValue) aValue).getBooleanValue();
			}
		} else {
			throw new UnsupportedOperationException("Value class " + aValue.getClass() + " is unsupported");
		}

		throw new IllegalArgumentException("Value class " + aValue.getClass() + " is incompatible with parameter type "
				+ aParamType);
	}

	/**
	 * Converts a given value to a String.
	 * 
	 * @param aValue
	 *            the value
	 * @param aVariableMap
	 *            the variable map, if variable references as values shall be resolved. If this is null, unresolved
	 *            variable references will always return either the string "(null)" or a null value, depending on the
	 *            following flag
	 * @param anAllowNullResultFlag
	 *            whether a null value shall be returned in case of unresolvable variable references
	 * @return
	 */
	public static String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap,
			boolean anAllowNullResultFlag) {
		if (aValue instanceof ValueOrEnumValueCollection) {
			ValueOrEnumValueCollection tempValueCollection = (ValueOrEnumValueCollection) aValue;
			if (tempValueCollection.getMoreValues().size() == 0) {
				return convertValueToString(tempValueCollection.getValue(), aVariableMap, anAllowNullResultFlag);
			} else {
				StringBuilder tempBuilder = new StringBuilder();
				for (int i = 0; i < tempValueCollection.getMoreValues().size() + 1; i++) {
					if (i > 0) {
						tempBuilder.append(", ");
					}
					tempBuilder.append(convertValueToString(i == 0 ? tempValueCollection.getValue()
							: tempValueCollection.getMoreValues().get(i - 1), aVariableMap, anAllowNullResultFlag));
				}
				return tempBuilder.toString();
			}
		} else if (aValue != null && aValue.getClass().isArray()) {
			// this is basically the same as above, but the collection has already been "merged" into an array
			StringBuilder tempBuilder = new StringBuilder();
			for (int i = 0; i < Array.getLength(aValue); i++) {
				if (i > 0) {
					tempBuilder.append(", ");
				}
				tempBuilder.append(convertValueToString(Array.get(aValue, i), aVariableMap, anAllowNullResultFlag));
			}
			return tempBuilder.toString();
		} else if (aValue instanceof DecimalValue) {
			return ((DecimalValue) aValue).getDecimalValue().toString();
		} else if (aValue instanceof IntegerValue) {
			return ((IntegerValue) aValue).getIntegerValue().toString();
		} else if (aValue instanceof StringValue) {
			return ((StringValue) aValue).getStringValue().toString();
		} else if (aValue instanceof Variable) {
			Object tempActualValue = aVariableMap != null ? aVariableMap.get(((Variable) aValue).getName()) : null;
			return convertValueToString(tempActualValue, aVariableMap, anAllowNullResultFlag);
		} else if (aValue instanceof EnumValue) {
			return ((EnumValue) aValue).getEnumValue().getSimpleName();
		} else if (aValue instanceof BooleanValue) {
			return ((BooleanValue) aValue).getBooleanValue();
		} else if (aValue instanceof NullValue) {
			return "null";
		} else {
			if (aValue != null) {
				return aValue.toString();
			} else {
				return anAllowNullResultFlag ? null : "(null)";
			}
		}
	}

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item.
	 * 
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aCollection
	 *            the value collection
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @return the converted value
	 * @throws IllegalArgumentException
	 *             if the conversion required is not supported
	 */
	public static Object convertEncapsulatedValueCollectionToParamType(Class<?> aParamType,
			ValueOrEnumValueCollection aCollection, Map<VariableEntity, Object> aVariableMap) {
		if (aCollection.getMoreValues() != null && aCollection.getMoreValues().size() > 0) {
			// this is actually an array
			Object tempResultArray = Array.newInstance(aParamType, aCollection.getMoreValues().size() + 1);
			for (int i = 0; i < aCollection.getMoreValues().size() + 1; i++) {
				ValueOrEnumValue tempValue = (i == 0 ? aCollection.getValue() : aCollection.getMoreValues().get(i - 1));
				Object tempResultValue = convertEncapsulatedValueToParamType(aParamType, tempValue, aVariableMap);
				Array.set(tempResultArray, i, tempResultValue);
			}
			return tempResultArray;
		} else {
			// this is just a single value
			return convertEncapsulatedValueToParamType(aParamType, aCollection.getValue(), aVariableMap);
		}
	}

	/**
	 * Returns a map of named result names to values acquired from a given named result container. This container is
	 * assumed to be a simple Java Bean, with accessible accessor methods useable to retrieve the values of fields. The
	 * field names are used as result names and thus keys in the map. Unreachable fields are ignored.
	 * 
	 * @param aContainer
	 *            the container instance
	 * @return the map of result names to values
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> getValuesFromNamedResultContainer(Object aContainer)
			throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> tempResultMap = new HashMap<String, Object>();

		if (aContainer != null) {
			for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainer.getClass())
					.getPropertyDescriptors()) {
				Method tempReadMethod = tempDescriptor.getReadMethod();
				if (tempReadMethod != null) {
					if (Map.class.isAssignableFrom(tempDescriptor.getPropertyType())) {
						// this is a map for arbitrary result names
						@SuppressWarnings("unchecked")
						Map<String, Object> tempMap = (Map<String, Object>) tempReadMethod.invoke(aContainer);
						for (Entry<String, Object> tempEntry : tempMap.entrySet()) {
							tempResultMap.put(tempEntry.getKey(), tempEntry.getValue());
						}
					} else {
						tempResultMap.put(tempDescriptor.getName(), tempReadMethod.invoke(aContainer));
					}
				}
			}
		}

		return tempResultMap;
	}

	/**
	 * Determines the result type by looking at a result container type for a specific result name.
	 * 
	 * @param aContainerType
	 *            the container type
	 * @param aResultName
	 *            the name of the result
	 * @return the result type
	 * @throws IntrospectionException
	 */
	public static Class<?> getResultTypeFromNamedResultContainerType(Class<?> aContainerType, String aResultName)
			throws IntrospectionException {
		for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainerType).getPropertyDescriptors()) {
			if (tempDescriptor.getName().equals(aResultName)) {
				return tempDescriptor.getPropertyType();
			}
		}
		return null;
	}

}
