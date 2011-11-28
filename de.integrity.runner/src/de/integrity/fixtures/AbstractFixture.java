package de.integrity.fixtures;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.utils.ParameterUtil;

public abstract class AbstractFixture implements Fixture {

	@Override
	public Object execute(String aName, Map<String, Object> someParameters) {
		Method tempMethod = findFixtureMethodByName(getClass(), aName);
		if (tempMethod == null) {
			throw new IllegalArgumentException("Did not find a fixture method of name '" + aName + "' in class "
					+ getClass().getName() + " or its superclasses");
		}

		int tempMethodParamCount = tempMethod.getParameterTypes().length;
		Object[] tempParams = new Object[tempMethodParamCount];
		for (int i = 0; i < tempMethodParamCount; i++) {
			FixtureParameter tempAnnotation = findAnnotation(FixtureParameter.class,
					tempMethod.getParameterAnnotations()[i]);
			if (tempAnnotation != null && tempAnnotation.name() != null) {
				Object tempValue = someParameters.get(tempAnnotation.name());
				if (tempValue == null) {
					if (tempAnnotation.optional()) {
						// all fine, the parameter is optional anyway
						continue;
					} else {
						throw new IllegalArgumentException("Did not find a matching parameter value for parameter '"
								+ tempAnnotation.name() + "'");
					}
				}

				if (tempValue instanceof ValueOrEnumValue) {
					tempParams[i] = ParameterUtil.convertValueToParamType(tempMethod.getParameterTypes()[i],
							(ValueOrEnumValue) tempValue, null);
				} else {
					tempParams[i] = tempValue;
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
