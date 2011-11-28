package de.integrity.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import de.integrity.dsl.DecimalValue;
import de.integrity.dsl.EnumValue;
import de.integrity.dsl.IntegerValue;
import de.integrity.dsl.StringValue;
import de.integrity.dsl.Value;
import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.dsl.Variable;
import de.integrity.dsl.VariableEntity;

public class ParameterUtil {

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

	public static String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap) {
		if (aValue instanceof DecimalValue) {
			return ((DecimalValue) aValue).getDecimalValue().toString();
		} else if (aValue instanceof IntegerValue) {
			return ((IntegerValue) aValue).getIntegerValue().toString();
		} else if (aValue instanceof StringValue) {
			return ((StringValue) aValue).getStringValue().toString();
		} else if (aValue instanceof Variable) {
			Object tempActualValue = aVariableMap.get(((Variable) aValue).getName());
			if (tempActualValue != null) {
				return convertValueToString(tempActualValue, aVariableMap);
			} else {
				return ((Variable) aValue).getName().getName();
			}
		} else if (aValue instanceof EnumValue) {
			return ((EnumValue) aValue).getEnumValue().getSimpleName();
		} else {
			if (aValue != null) {
				return aValue.toString();
			} else {
				return "(null)";
			}
		}
	}

}
