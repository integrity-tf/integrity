package de.integrity.fixtures;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.fixtures.ArbitraryParameterFixture.ArbitraryParameterDefinition;
import de.integrity.utils.ParameterUtil;

public abstract class Fixture {

	public Object execute(String aName, Map<String, Object> someParameters) {
		Method tempMethod = findFixtureMethodByName(getClass(), aName);
		if (tempMethod == null) {
			throw new IllegalArgumentException("Did not find a fixture method of name '" + aName + "' in class "
					+ getClass().getName() + " or its superclasses");
		}

		convertParameterValuesToFixtureDefinedTypes(tempMethod, someParameters, true);

		int tempMethodParamCount = tempMethod.getParameterTypes().length;
		Object[] tempParams = new Object[tempMethodParamCount];
		for (int i = 0; i < tempMethodParamCount; i++) {
			if (Map.class.equals(tempMethod.getParameterTypes()[i])) {
				// this gets any arbitrary parameters left over
				tempParams[i] = someParameters;
			} else {
				FixtureParameter tempAnnotation = findAnnotation(FixtureParameter.class,
						tempMethod.getParameterAnnotations()[i]);
				if (tempAnnotation != null && tempAnnotation.name() != null) {
					tempParams[i] = someParameters.remove(tempAnnotation.name());
				}
			}
		}

		try {
			return tempMethod.invoke(this, tempParams);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Caught exception when trying to invoke method '" + aName + "'", e);
		} catch (InvocationTargetException e) {
			throw new IllegalArgumentException("Caught exception when trying to invoke method '" + aName + "'", e);
		}
	}

	public void convertParameterValuesToFixtureDefinedTypes(Method aFixtureMethod, Map<String, Object> aParameterMap,
			boolean anIncludeArbitraryParametersFlag) {
		Map<String, Object> tempFixedParamsMap = new HashMap<String, Object>();
		int tempMethodParamCount = aFixtureMethod.getParameterTypes().length;
		for (int i = 0; i < tempMethodParamCount; i++) {
			if (Map.class.equals(aFixtureMethod.getParameterTypes()[i])) {
				// ignore the arbitrary parameter parameter
			} else {
				FixtureParameter tempAnnotation = findAnnotation(FixtureParameter.class,
						aFixtureMethod.getParameterAnnotations()[i]);
				if (tempAnnotation != null && tempAnnotation.name() != null) {
					String tempName = tempAnnotation.name();
					Object tempValue = aParameterMap.get(tempName);
					if (tempValue != null && (tempValue instanceof ValueOrEnumValue)) {
						Object tempConvertedValue = ParameterUtil.convertValueToParamType(
								aFixtureMethod.getParameterTypes()[i], (ValueOrEnumValue) tempValue, null);
						aParameterMap.put(tempName, tempConvertedValue);
						tempFixedParamsMap.put(tempName, tempConvertedValue);
					}
				}
			}
		}

		if (anIncludeArbitraryParametersFlag && (this instanceof ArbitraryParameterFixture)) {
			List<ArbitraryParameterDefinition> tempArbitraryParameters = ((ArbitraryParameterFixture) this)
					.defineArbitraryParameters(aFixtureMethod.getName(), tempFixedParamsMap);
			for (ArbitraryParameterDefinition tempArbitraryParameter : tempArbitraryParameters) {
				String tempName = tempArbitraryParameter.getName();
				Object tempValue = aParameterMap.remove(tempName);
				if (tempValue != null && (tempValue instanceof ValueOrEnumValue)) {
					Object tempConvertedValue = ParameterUtil.convertValueToParamType(tempArbitraryParameter.getType(),
							(ValueOrEnumValue) tempValue, null);
					aParameterMap.put(tempName, tempConvertedValue);
				}
			}
		}
	}

	public static Method findFixtureMethodByName(Class<?> aClass, String aName) {
		for (Method tempMethod : aClass.getMethods()) {
			FixtureMethod tempMethodAnnotation = tempMethod.getAnnotation(FixtureMethod.class);
			if (tempMethodAnnotation != null) {
				String tempMethodName = tempMethod.getName();
				if (tempMethodAnnotation.name() != null && tempMethodAnnotation.name().length() > 0) {
					tempMethodName = tempMethodAnnotation.name();
				}

				if (tempMethodName.equals(aName)) {
					return tempMethod;
				}
			}
		}

		if (aClass.getSuperclass() != null) {
			return findFixtureMethodByName(aClass.getSuperclass(), aName);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static <A extends Annotation> A findAnnotation(Class<A> aClass, Annotation[] someAnnotations) {
		for (int i = 0; i < someAnnotations.length; i++) {
			if (aClass.isAssignableFrom(someAnnotations[i].getClass())) {
				return (A) someAnnotations[i];
			}
		}

		return null;
	}

}
