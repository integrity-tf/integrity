/**
 * 
 */
package de.gebit.integrity.fixtures;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.utils.ParameterUtil;

/**
 * This wrapper is used to encapsulate fixture instances.
 * 
 * @param <C>
 *            the fixture class
 * @author Rene Schneider
 * 
 */
public class FixtureWrapper<C extends Object> {

	/**
	 * The fixture class.
	 */
	private Class<C> fixtureClass;

	/**
	 * The wrapped instance.
	 */
	private C fixtureInstance;

	/**
	 * The factory that created the fixture instance.
	 */
	private FixtureInstanceFactory<C> factory;

	/**
	 * Fixture instance factories are cached in this map.
	 */
	private static Map<Class<?>, FixtureInstanceFactory<?>> factoryCache = new HashMap<Class<?>, FixtureInstanceFactory<?>>();

	/**
	 * Creates a new instance. This also instantiates the given fixture class!
	 * 
	 * @param aFixtureClass
	 *            the fixture class to be wrapped
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public FixtureWrapper(Class<C> aFixtureClass) throws InstantiationException, IllegalAccessException {
		fixtureClass = aFixtureClass;

		FixtureInstanceFactory<C> tempFactory = null;
		if (factoryCache.containsKey(aFixtureClass)) {
			tempFactory = (FixtureInstanceFactory<C>) factoryCache.get(aFixtureClass);
		} else {
			FixtureFactory tempFactoryAnnotation = fixtureClass.getAnnotation(FixtureFactory.class);
			if (tempFactoryAnnotation != null) {
				tempFactory = (FixtureInstanceFactory<C>) tempFactoryAnnotation.value().newInstance();
			}
			factoryCache.put(aFixtureClass, tempFactory);
		}

		if (tempFactory != null) {
			fixtureInstance = tempFactory.retrieveInstance();
			factory = tempFactory;
		} else {
			fixtureInstance = fixtureClass.newInstance();
		}
	}

	/**
	 * Releases the fixture instance.
	 */
	public void release() {
		if (factory != null) {
			try {
				factory.releaseInstance(fixtureInstance);
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				// Since releasing is usually happening outside of the exception catch block that spans the actual
				// fixture method calls, we'll catch everything coming up during fixture instance release here. We
				// don't want any custom code running there to fuck up the whole test execution process. Instead, we
				// will just push it out on the console and go on.
				exc.printStackTrace();
			}
		}
		fixtureInstance = null;
	}

	protected Class<?> getFixtureClass() {
		return fixtureClass;
	}

	protected Object getFixtureInstance() {
		return fixtureInstance;
	}

	/**
	 * Checks whether the wrapped fixture is a {@link CustomComparatorFixture}.
	 * 
	 * @return true if it is
	 */
	public boolean isCustomComparatorFixture() {
		return (CustomComparatorFixture.class.isAssignableFrom(fixtureClass));
	}

	/**
	 * Performs a custom comparation using the wrapped fixture, which must be a {@link CustomComparatorFixture}. Only
	 * usable if {@link #isCustomComparatorFixture()} returns true.
	 * 
	 * @param anExpectedResult
	 *            the expected result
	 * @param aFixtureResult
	 *            the result actually returned by the fixture
	 * @param aMethodName
	 *            the name of the fixture method
	 * @return true if comparation was successful, false otherwise
	 */
	public boolean performCustomComparation(Object anExpectedResult, Object aFixtureResult, String aMethodName) {
		return ((CustomComparatorFixture) fixtureInstance)
				.compareResults(anExpectedResult, aFixtureResult, aMethodName);
	}

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
		Method tempMethod = findFixtureMethodByName(fixtureClass, aName);
		if (tempMethod == null) {
			throw new IllegalArgumentException("Did not find a fixture method of name '" + aName + "' in class "
					+ fixtureClass.getName() + " or its superclasses");
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
			return tempMethod.invoke(getFixtureInstance(), tempParams);
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
					Class<?> tempExpectedType = aFixtureMethod.getParameterTypes()[i];
					if (tempValue != null) {
						Object tempConvertedValue;
						if (tempValue instanceof Object[]) {
							if (!tempExpectedType.isArray()) {
								throw new IllegalArgumentException("The parameter '" + tempName + "' of method '"
										+ aFixtureMethod.getName() + "' in fixture '" + fixtureClass.getName()
										+ "' is not an array type, thus you cannot put multiple values into it!");
							}
							Object tempConvertedValueArray = Array.newInstance(tempExpectedType.getComponentType(),
									((Object[]) tempValue).length);
							for (int k = 0; k < ((Object[]) tempValue).length; k++) {
								Object tempSingleValue = ((Object[]) tempValue)[k];
								if (tempSingleValue instanceof ValueOrEnumValue) {
									Array.set(tempConvertedValueArray, k, ParameterUtil
											.convertEncapsulatedValueToParamType(tempExpectedType.getComponentType(),
													(ValueOrEnumValue) tempSingleValue, null));
								} else {
									Array.set(tempConvertedValueArray, k, ParameterUtil.convertValueToParamType(
											tempExpectedType.getComponentType(), tempSingleValue));
								}
							}
							tempConvertedValue = tempConvertedValueArray;
						} else {
							// if the expected type is an array, we don't want to convert to that array, but to the
							// component type, of course
							Class<?> tempConversionTargetType = tempExpectedType.isArray() ? tempExpectedType
									.getComponentType() : tempExpectedType;
							if (tempValue instanceof ValueOrEnumValue) {
								tempConvertedValue = ParameterUtil.convertEncapsulatedValueToParamType(
										tempConversionTargetType, (ValueOrEnumValue) tempValue, null);
							} else {
								tempConvertedValue = ParameterUtil.convertValueToParamType(tempConversionTargetType,
										tempValue);
							}
							if (tempExpectedType.isArray()) {
								// ...and if the expected type is an array, now we create one
								Object tempNewArray = Array.newInstance(tempExpectedType.getComponentType(), 1);
								Array.set(tempNewArray, 0, tempConvertedValue);
								tempConvertedValue = tempNewArray;
							}
						}
						aParameterMap.put(tempName, tempConvertedValue);
						tempFixedParamsMap.put(tempName, tempConvertedValue);
					}
				}
			}
		}

		if (anIncludeArbitraryParametersFlag && (getFixtureInstance() instanceof ArbitraryParameterFixture)) {
			Map<String, Class<?>> tempArbitraryParameters = ((ArbitraryParameterFixture) getFixtureInstance())
					.defineArbitraryParameters(aFixtureMethod.getName(), tempFixedParamsMap);
			for (Entry<String, Class<?>> tempArbitraryParameter : tempArbitraryParameters.entrySet()) {
				String tempName = tempArbitraryParameter.getKey();
				Object tempValue = aParameterMap.remove(tempName);
				Class<?> tempExpectedType = tempArbitraryParameter.getValue();
				if (tempValue != null) {
					Object tempConvertedValue;
					if (tempValue instanceof Object[]) {
						if (!tempExpectedType.isArray()) {
							throw new IllegalArgumentException("The parameter '" + tempName + "' of method '"
									+ aFixtureMethod.getName() + "' in fixture '" + fixtureClass.getName()
									+ "' is not an array type, thus you cannot put multiple values into it!");
						}
						Object tempConvertedValueArray = Array.newInstance(tempExpectedType.getComponentType(),
								((Object[]) tempValue).length);
						for (int k = 0; k < ((Object[]) tempValue).length; k++) {
							Object tempSingleValue = ((Object[]) tempValue)[k];
							if (tempSingleValue instanceof ValueOrEnumValue) {
								Array.set(tempConvertedValueArray, k, ParameterUtil
										.convertEncapsulatedValueToParamType(tempExpectedType.getComponentType(),
												(ValueOrEnumValue) tempSingleValue, null));
							} else {
								Array.set(tempConvertedValueArray, k, ParameterUtil.convertValueToParamType(
										tempExpectedType.getComponentType(), tempSingleValue));
							}
						}
						tempConvertedValue = tempConvertedValueArray;
					} else {
						if (tempValue instanceof ValueOrEnumValue) {
							tempConvertedValue = ParameterUtil.convertEncapsulatedValueToParamType(tempExpectedType,
									(ValueOrEnumValue) tempValue, null);
						} else {
							tempConvertedValue = ParameterUtil.convertValueToParamType(tempExpectedType, tempValue);
						}
						if (tempExpectedType.isArray()) {
							// The target type may still be an array, even though just one parameter value was given
							Object tempNewArray = Array.newInstance(tempExpectedType.getComponentType(), 1);
							Array.set(tempNewArray, 0, tempConvertedValue);
							tempConvertedValue = tempNewArray;
						}
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
