package de.gebit.integrity.fixtures;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.fixtures.ArbitraryParameterFixture.ArbitraryParameterDefinition;
import de.gebit.integrity.utils.ParameterUtil;

/**
 * Abstract base class for all Integrity fixture classes.
 * 
 * Fixtures are the primary way for Integrity test scripts to interact with the System Under Test. Fixture classes
 * implement fixture methods for this purpose, which are then referenced in test scripts. <br>
 * <br>
 * The suggested way to implement a fixture method is to subclass this abstract class and implement a method of any
 * desired name. This method must be decorated with the {@link FixtureMethod} annotation to be called by Integrity.
 * Parameters may be created by simply adding standard Java parameters to the method in question, annotated with a
 * {@link FixtureParameter} annotation. Integrity will take care of the necessary conversions of user-provided data into
 * the parameter data types, but the parameters may only use one of the following supported types:<br>
 * <br>
 * <ul>
 * <li>String</li>
 * <li>Byte</li>
 * <li>Short</li>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>BigInteger</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>BigDecimal</li>
 * <li>an Enumeration</li>
 * </ul>
 * <br>
 * The method may return either nothing at all, a value of one of the supported types, or an instance of a custom class
 * that acts as a container for multiple named result values. The first two cases are suited for use in test and call
 * statements, while the latter is suitable for test statements with named results.
 * 
 * @author Rene Schneider
 * 
 */
public abstract class Fixture {

	/**
	 * Executes a fixture method with a specified name, using the given set of parameters.
	 * 
	 * @param aName
	 *            the name of the fixture method
	 * @param someParameters
	 *            a map of parameters
	 * @return the resulting object
	 * @throws Throwable
	 */
	public Object execute(String aName, Map<String, Object> someParameters) throws Exception {
		Method tempMethod = findFixtureMethodByName(getClass(), aName);
		if (tempMethod == null) {
			throw new IllegalArgumentException("Did not find a fixture method of name '" + aName + "' in class "
					+ getClass().getName() + " or its superclasses");
		}

		// this will never be called within Eclipse, so we null the
		// resource provider
		convertParameterValuesToFixtureDefinedTypes(tempMethod, someParameters, true, false);

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
		} catch (IllegalAccessException exc) {
			throw new IllegalArgumentException("Caught exception when trying to invoke method '" + aName + "'", exc);
		} catch (InvocationTargetException exc) {
			throw (Exception) exc.getCause();
		}
	}

	/**
	 * Replaces all values in the given parameter map with converted versions that match the types that are expected by
	 * the given fixture method.
	 * 
	 * @param aFixtureMethod
	 *            the method
	 * @param aParameterMap
	 *            the parameter map
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters shall be included
	 * @param aCalledInEclipseFlag
	 *            whether this method is being called inside Eclipse
	 */
	public void convertParameterValuesToFixtureDefinedTypes(Method aFixtureMethod, Map<String, Object> aParameterMap,
			boolean anIncludeArbitraryParametersFlag, boolean aCalledInEclipseFlag) {
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
					if (tempValue != null) {
						Object tempConvertedValue;
						if (tempValue instanceof ValueOrEnumValue) {
							tempConvertedValue = ParameterUtil.convertEncapsulatedValueToParamType(
									aFixtureMethod.getParameterTypes()[i], (ValueOrEnumValue) tempValue, null);
						} else {
							tempConvertedValue = ParameterUtil.convertValueToParamType(
									aFixtureMethod.getParameterTypes()[i], tempValue);
						}
						aParameterMap.put(tempName, tempConvertedValue);
						tempFixedParamsMap.put(tempName, tempConvertedValue);
					}
				}
			}
		}

		if (anIncludeArbitraryParametersFlag && (this instanceof ArbitraryParameterFixture)) {
			List<ArbitraryParameterDefinition> tempArbitraryParameters = ((ArbitraryParameterFixture) this)
					.defineArbitraryParameters(aFixtureMethod.getName(), tempFixedParamsMap, aCalledInEclipseFlag);
			for (ArbitraryParameterDefinition tempArbitraryParameter : tempArbitraryParameters) {
				String tempName = tempArbitraryParameter.getName();
				Object tempValue = aParameterMap.remove(tempName);
				if (tempValue != null) {
					Object tempConvertedValue;
					if (tempValue instanceof ValueOrEnumValue) {
						tempConvertedValue = ParameterUtil.convertEncapsulatedValueToParamType(
								tempArbitraryParameter.getType(), (ValueOrEnumValue) tempValue, null);
					} else {
						tempConvertedValue = ParameterUtil.convertValueToParamType(tempArbitraryParameter.getType(),
								tempValue);
					}
					aParameterMap.put(tempName, tempConvertedValue);
				}
			}
		}
	}

	/**
	 * Searches the class for a fixture method with the given name.
	 * 
	 * @param aClass
	 *            the fixture class
	 * @param aName
	 *            the fixture method name
	 * @return the method if found, or null
	 */
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
