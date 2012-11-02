package de.gebit.integrity.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.operations.OperationWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;

/**
 * A utility class for handling of test/call parameters.
 * 
 * @author Rene Schneider
 * 
 */
public final class ParameterUtil {

	/**
	 * Instantiates a new parameter util.
	 */
	private ParameterUtil() {
		// nothing to do
	}

	/**
	 * The "fake" name of the default parameter. This is used for unnamed parameters in maps which require a non-null
	 * key.
	 */
	public static final String DEFAULT_PARAMETER_NAME = "";

	/**
	 * Converts a given Java type value to a given Java type class, if possible.
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aValue
	 *            the value
	 * @return the converted value
	 */
	public static Object convertValueToParamType(Class<?> aParamType, Object aValue) {
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

	/**
	 * Convert a given single Java type value to param type (which is also a Java type).
	 * 
	 * @param aParamType
	 *            the param type
	 * @param aValue
	 *            the value
	 * @return the object
	 */
	private static Object convertSingleValueToParamType(Class<?> aParamType, Object aValue) {
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
	 * @throws UnresolvableVariableException
	 *             the unresolvable variable exception
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	public static Object convertEncapsulatedValueToParamType(Class<?> aParamType, ValueOrEnumValueOrOperation aValue,
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
				OperationWrapper tempWrapper = new OperationWrapper((Operation) aValue, aClassLoader);
				Object tempResult = tempWrapper.executeOperation(aVariableMap, false);
				return convertValueToParamType(aParamType, tempResult);
			}
		} else if (aValue instanceof DecimalValue) {
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
						return convertEncapsulatedValueToParamType(aParamType, (Value) tempActualValue, aVariableMap,
								aClassLoader);
					} else {
						return convertValueToParamType(aParamType, tempActualValue);
					}
				} else {
					return null;
				}
			} else {
				throw new UnresolvableVariableException("Unresolved variable "
						+ ((Variable) aValue).getName().getName() + " encountered, but missing variable to value map!");
			}
		} else if (aValue instanceof BooleanValue) {
			if (aParamType == Boolean.class) {
				return Boolean.valueOf(((BooleanValue) aValue).getBooleanValue());
			} else if (aParamType == String.class) {
				return ((BooleanValue) aValue).getBooleanValue();
			}
		} else if (aValue instanceof DateValue) {
			if (aParamType == Date.class) {
				return guardedDateConversion((DateValue) aValue).getTime();
			} else if (aParamType == Calendar.class) {
				return guardedDateConversion((DateValue) aValue);
			} else if (aParamType == String.class) {
				return DateFormat.getDateInstance(DateFormat.LONG).format(guardedDateConversion((DateValue) aValue));
			} else {
				throw new IllegalArgumentException("Date value '" + aValue + "'"
						+ " is not autoconvertible to parameter type " + aParamType);
			}
		} else if (aValue instanceof TimeValue) {
			if (aParamType == Date.class) {
				return guardedTimeConversion((TimeValue) aValue).getTime();
			} else if (aParamType == Calendar.class) {
				return guardedTimeConversion((TimeValue) aValue);
			} else if (aParamType == String.class) {
				return DateFormat.getTimeInstance(DateFormat.LONG).format(guardedTimeConversion((TimeValue) aValue));
			} else {
				throw new IllegalArgumentException("Date value '" + aValue + "'"
						+ " is not autoconvertible to parameter type " + aParamType);
			}
		} else if (aValue instanceof DateAndTimeValue) {
			if (aParamType == Date.class) {
				return guardedDateAndTimeConversion((DateAndTimeValue) aValue).getTime();
			} else if (aParamType == Calendar.class) {
				return guardedDateAndTimeConversion((DateAndTimeValue) aValue);
			} else if (aParamType == String.class) {
				return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(
						guardedDateAndTimeConversion((DateAndTimeValue) aValue));
			} else {
				throw new IllegalArgumentException("Date/Time value '" + aValue + "'"
						+ " is not autoconvertible to parameter type " + aParamType);
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
	 *            the value (can be an {@link OperationOrValueCollection} or a plain Java Object)
	 * @param aVariableMap
	 *            the variable map, if variable references as values shall be resolved. If this is null, unresolved
	 *            variable references will always return either the string "(null)" or a null value, depending on the
	 *            following flag
	 * @param aClassLoader
	 *            the classloader to use in order to resolve operations. If not given, operations will be "resolved" to
	 *            the string "UNSUPPORTED".
	 * @param anAllowNullResultFlag
	 *            whether a null value shall be returned in case of unresolvable variable references or operations
	 * @return the string
	 */
	public static String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, boolean anAllowNullResultFlag) {
		if (aValue instanceof Operation) {
			if (aClassLoader == null) {
				return anAllowNullResultFlag ? null : "UNSUPPORTED";
			} else {
				Object tempResult = null;
				try {
					OperationWrapper tempWrapper = new OperationWrapper((Operation) aValue, aClassLoader);
					tempResult = tempWrapper.executeOperation(aVariableMap, false);
				} catch (ClassNotFoundException exc) {
					return anAllowNullResultFlag ? null : "FAILURE";
				} catch (UnexecutableException exc) {
					return anAllowNullResultFlag ? null : "FAILURE";
				} catch (InstantiationException exc) {
					return anAllowNullResultFlag ? null : "FAILURE";
				}

				if (tempResult.getClass().isArray()) {
					StringBuilder tempBuilder = new StringBuilder();
					for (int i = 0; i < Array.getLength(tempResult); i++) {
						if (i > 0) {
							tempBuilder.append(", ");
						}
						tempBuilder.append(convertValueToString(Array.get(tempResult, i), aVariableMap, aClassLoader,
								anAllowNullResultFlag));
					}
					return tempBuilder.toString();
				} else {
					return convertValueToString(tempResult, aVariableMap, aClassLoader, anAllowNullResultFlag);
				}
			}

		} else if (aValue instanceof ValueOrEnumValueOrOperationCollection) {
			ValueOrEnumValueOrOperationCollection tempValueCollection = (ValueOrEnumValueOrOperationCollection) aValue;
			if (tempValueCollection.getMoreValues().size() == 0) {
				return convertValueToString(tempValueCollection.getValue(), aVariableMap, aClassLoader,
						anAllowNullResultFlag);
			} else {
				StringBuilder tempBuilder = new StringBuilder();
				for (int i = 0; i < tempValueCollection.getMoreValues().size() + 1; i++) {
					if (i > 0) {
						tempBuilder.append(", ");
					}
					tempBuilder.append(convertValueToString(i == 0 ? tempValueCollection.getValue()
							: tempValueCollection.getMoreValues().get(i - 1), aVariableMap, aClassLoader,
							anAllowNullResultFlag));
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
				tempBuilder.append(convertValueToString(Array.get(aValue, i), aVariableMap, aClassLoader,
						anAllowNullResultFlag));
			}
			return tempBuilder.toString();
		} else if (aValue instanceof DecimalValue) {
			return maskNullString(((DecimalValue) aValue).getDecimalValue().toString(), !anAllowNullResultFlag);
		} else if (aValue instanceof IntegerValue) {
			return maskNullString(((IntegerValue) aValue).getIntegerValue().toString(), !anAllowNullResultFlag);
		} else if (aValue instanceof StringValue) {
			return maskNullString(((StringValue) aValue).getStringValue().toString(), !anAllowNullResultFlag);
		} else if (aValue instanceof Variable) {
			Object tempActualValue = aVariableMap != null ? aVariableMap.get(((Variable) aValue).getName()) : null;
			return convertValueToString(tempActualValue, aVariableMap, aClassLoader, anAllowNullResultFlag);
		} else if (aValue instanceof EnumValue) {
			return maskNullString(((EnumValue) aValue).getEnumValue().getSimpleName(), !anAllowNullResultFlag);
		} else if (aValue instanceof BooleanValue) {
			return maskNullString(((BooleanValue) aValue).getBooleanValue(), !anAllowNullResultFlag);
		} else if (aValue instanceof DateValue) {
			DateFormat tempFormat = DateFormat.getDateInstance(DateFormat.LONG);
			Calendar tempCalendar = guardedDateConversion((DateValue) aValue);
			tempFormat.setCalendar(tempCalendar);
			return maskNullString(tempFormat.format(tempCalendar.getTime()), !anAllowNullResultFlag);
		} else if (aValue instanceof TimeValue) {
			DateFormat tempFormat = DateFormat.getTimeInstance(DateFormat.LONG);
			Calendar tempCalendar = guardedTimeConversion((TimeValue) aValue);
			tempFormat.setCalendar(tempCalendar);
			return maskNullString(tempFormat.format(tempCalendar.getTime()), !anAllowNullResultFlag);
		} else if (aValue instanceof DateAndTimeValue) {
			DateFormat tempFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
			Calendar tempCalendar = guardedDateAndTimeConversion((DateAndTimeValue) aValue);
			tempFormat.setCalendar(tempCalendar);
			return maskNullString(tempFormat.format(tempCalendar.getTime()), !anAllowNullResultFlag);
		} else if (aValue instanceof Date) {
			return maskNullString(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(aValue),
					!anAllowNullResultFlag);
		} else if (aValue instanceof NullValue) {
			return "null";
		} else {
			if (aValue != null) {
				return aValue.toString();
			} else {
				return maskNullString(null, !anAllowNullResultFlag);
			}
		}
	}

	/**
	 * Ensures that a string is not null.
	 * 
	 * @param aValue
	 *            the a value
	 * @param aMaskValueFlag
	 *            the a mask value flag
	 * @return the string
	 */
	public static String maskNullString(String aValue, boolean aMaskValueFlag) {
		if (aMaskValueFlag && aValue == null) {
			return "(null)";
		} else {
			return aValue;
		}
	}

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item. This method is only being called inside Eclipse!
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aCollection
	 *            the value collection
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @param aClassLoader
	 *            the a class loader
	 * @return the converted value
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws UnexecutableException
	 *             the unexecutable exception
	 * @throws InstantiationException
	 *             the instantiation exception
	 */
	public static Object convertEncapsulatedValueCollectionToParamType(Class<?> aParamType,
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

	/**
	 * Returns a map of named result names to values acquired from a given named result container. This container is
	 * assumed to be a simple Java Bean, with accessible accessor methods useable to retrieve the values of fields. The
	 * field names are used as result names and thus keys in the map. Unreachable fields are ignored.
	 * 
	 * @param aContainer
	 *            the container instance
	 * @return the map of result names to values
	 * @throws IntrospectionException
	 *             the introspection exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
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
	 *             the introspection exception
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

	private static Calendar guardedDateConversion(DateValue aValue) {
		try {
			return DateUtil.convertDateValue((DateValue) aValue);
		} catch (ParseException exc) {
			throw new IllegalArgumentException("Failed to parse date", exc);
		}
	}

	private static Calendar guardedTimeConversion(TimeValue aValue) {
		try {
			return DateUtil.convertTimeValue((TimeValue) aValue);
		} catch (ParseException exc) {
			throw new IllegalArgumentException("Failed to parse time", exc);
		}
	}

	private static Calendar guardedDateAndTimeConversion(DateAndTimeValue aValue) {
		try {
			return DateUtil.convertDateAndTimeValue((DateAndTimeValue) aValue);
		} catch (ParseException exc) {
			throw new IllegalArgumentException("Failed to parse date/time", exc);
		}
	}

	/**
	 * Thrown if a variable value cannot be resolved because there's no variable map given.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public static class UnresolvableVariableException extends RuntimeException {

		/**
		 * Serialization version.
		 */
		private static final long serialVersionUID = -7255981207674292161L;

		/**
		 * Instantiates a new unresolvable variable exception.
		 */
		public UnresolvableVariableException() {
			super();
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 * @param aCause
		 *            the a cause
		 */
		public UnresolvableVariableException(String aMessage, Throwable aCause) {
			super(aMessage, aCause);
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 */
		public UnresolvableVariableException(String aMessage) {
			super(aMessage);
		}

		/**
		 * Instantiates a new unresolvable variable exception.
		 * 
		 * @param aCause
		 *            the a cause
		 */
		public UnresolvableVariableException(Throwable aCause) {
			super(aCause);
		}

	}

}
