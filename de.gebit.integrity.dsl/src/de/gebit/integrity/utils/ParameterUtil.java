package de.gebit.integrity.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;

public class ParameterUtil {

	public static final String DEFAULT_PARAMETER_NAME = "";

	public static Object convertValueToParamType(Class<?> aParamType, ValueOrEnumValue aValue,
			Map<VariableEntity, Object> aVariableMap) {
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
						return convertValueToParamType(aParamType, (Value) tempActualValue, aVariableMap);
					} else {
						return tempActualValue;
					}
				} else {
					return null;
				}
			} else {
				throw new IllegalArgumentException("Unresolved variable " + ((Variable) aValue).getName().getName()
						+ " encountered, but missing variable to value map!");
			}
		} else {
			throw new UnsupportedOperationException("Value class " + aValue.getClass() + " is unsupported");
		}

		throw new IllegalArgumentException("Value class " + aValue.getClass() + " is incompatible with parameter type "
				+ aParamType);
	}

	public static String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap,
			boolean anAllowNullResultFlag) {
		if (aValue instanceof DecimalValue) {
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
		} else {
			if (aValue != null) {
				return aValue.toString();
			} else {
				return anAllowNullResultFlag ? null : "(null)";
			}
		}
	}

	public static Map<String, Object> getValuesFromNamedResultContainer(Object aContainer)
			throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> tempResultMap = new HashMap<String, Object>();

		for (PropertyDescriptor tempDescriptor : Introspector.getBeanInfo(aContainer.getClass())
				.getPropertyDescriptors()) {
			tempResultMap.put(tempDescriptor.getName(), tempDescriptor.getReadMethod().invoke(aContainer));
		}

		return tempResultMap;
	}

}
