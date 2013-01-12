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

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.gebit.integrity.operations.CustomOperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

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
	 * The value converter to use.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * Fixture instance factories are cached in this map.
	 */
	private static Map<Class<?>, FixtureInstanceFactory<?>> factoryCache = new HashMap<Class<?>, FixtureInstanceFactory<?>>();

	/**
	 * Creates a new instance. This also instantiates the given fixture class!
	 * 
	 * @param aFixtureClass
	 *            the fixture class to be wrapped
	 * @param anInjector
	 *            The injector required to inject dependencies into fixture instances and factories. (I don't really
	 *            like to provide this explicitly here, but cannot use injection, since that happens after the
	 *            constructor. Maybe I'll refactor this some time later...)
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public FixtureWrapper(Class<C> aFixtureClass, Injector anInjector) throws InstantiationException,
			IllegalAccessException {
		fixtureClass = aFixtureClass;

		FixtureInstanceFactory<C> tempFactory = null;
		if (factoryCache.containsKey(aFixtureClass)) {
			tempFactory = (FixtureInstanceFactory<C>) factoryCache.get(aFixtureClass);
		} else {
			FixtureFactory tempFactoryAnnotation = fixtureClass.getAnnotation(FixtureFactory.class);
			if (tempFactoryAnnotation != null) {
				tempFactory = (FixtureInstanceFactory<C>) tempFactoryAnnotation.value().newInstance();
				anInjector.injectMembers(tempFactory);
			}
			factoryCache.put(aFixtureClass, tempFactory);
		}

		if (tempFactory != null) {
			fixtureInstance = tempFactory.retrieveInstance();
			factory = tempFactory;
		} else {
			fixtureInstance = fixtureClass.newInstance();
		}

		anInjector.injectMembers(fixtureInstance);
		anInjector.injectMembers(this);
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
	 * Checks whether the wrapped fixture is a {@link CustomComparatorAndConversionFixture}.
	 * 
	 * @return true if it is
	 */
	public boolean isCustomComparatorAndConversionFixture() {
		return (CustomComparatorAndConversionFixture.class.isAssignableFrom(fixtureClass));
	}

	/**
	 * Checks whether the wrapped fixture is a {@link CustomStringConversionFixture}.
	 * 
	 * @return true if it is
	 */
	public boolean isCustomStringConversionFixture() {
		return (CustomStringConversionFixture.class.isAssignableFrom(fixtureClass));
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
	 * @param aPropertyName
	 *            the name of the result property to be compared (null if it's the default result)
	 * @return true if comparation was successful, false otherwise
	 */
	public boolean performCustomComparation(Object anExpectedResult, Object aFixtureResult, String aMethodName,
			String aPropertyName) {
		return ((CustomComparatorFixture) fixtureInstance).compareResults(anExpectedResult, aFixtureResult,
				aMethodName, aPropertyName);
	}

	/**
	 * Returns the type to which the expected result (the data given in the test script) that corresponds to the given
	 * fixture result is to be converted. This can only be used for {@link CustomComparatorAndConversionFixture}
	 * instances, which can be checked via {@link #isCustomComparatorAndConversionFixture()}.
	 * 
	 * @param aFixtureResult
	 *            the result value returned by the fixture call
	 * @param aMethodName
	 *            the fixture method that was called
	 * @param aPropertyName
	 *            the property name that is to be compared (null if it's the default result)
	 * @return the desired target type. "null" chooses the default conversion, but note that this does NOT mean "the
	 *         conversion that would have been used if the fixture was just a {@link CustomComparatorFixture}", but "the
	 *         conversion that has the highest priority for the data type found in the script".
	 */
	public Class<?> determineCustomConversionTargetType(Object aFixtureResult, String aMethodName, String aPropertyName) {
		return ((CustomComparatorAndConversionFixture) fixtureInstance).determineConversionTargetType(aFixtureResult,
				aMethodName, aPropertyName);
	}

	/**
	 * Converts the given value to a string. This method either calls the
	 * {@link ValueConverter#convertValueToString(Object, UnresolvableVariableHandling)} method or delegates the
	 * conversion to the contained fixture instance, if it does implement the {@link CustomStringConversionFixture}
	 * interface.
	 * 
	 * @param aValue
	 *            the value to convert
	 * @param aFixtureMethod
	 *            the fixture method that was called to return the given value
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param anUnresolvedVariableHandlingPolicy
	 *            how to handle unresolvable variables
	 * @return the converted string
	 */
	public String performValueToStringConversion(Object aValue, String aFixtureMethod,
			boolean aForceIntermediateMapFlag, UnresolvableVariableHandling anUnresolvedVariableHandlingPolicy) {
		if (isCustomStringConversionFixture()) {
			return ((CustomStringConversionFixture) fixtureInstance).convertValueToString(aValue, aFixtureMethod);
		} else {
			return valueConverter.convertValueToString(aValue, aForceIntermediateMapFlag,
					anUnresolvedVariableHandlingPolicy);
		}
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
		convertParameterValuesToFixtureDefinedTypes(tempMethod, someParameters, true);

		int tempMethodParamCount = tempMethod.getParameterTypes().length;
		Object[] tempParams = new Object[tempMethodParamCount];
		for (int i = 0; i < tempMethodParamCount; i++) {
			FixtureParameter tempAnnotation = findAnnotation(FixtureParameter.class,
					tempMethod.getParameterAnnotations()[i]);

			if (tempAnnotation != null && tempAnnotation.name() != null) {
				tempParams[i] = someParameters.remove(tempAnnotation.name());
			} else if (Map.class.equals(tempMethod.getParameterTypes()[i])) {
				// this gets any arbitrary parameters left over
				tempParams[i] = someParameters;
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
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 * @throws UnresolvableVariableException
	 */
	public void convertParameterValuesToFixtureDefinedTypes(Method aFixtureMethod, Map<String, Object> aParameterMap,
			boolean anIncludeArbitraryParametersFlag) throws UnresolvableVariableException, ClassNotFoundException,
			UnexecutableException, InstantiationException {
		Map<String, Object> tempClonedParameterMap = new HashMap<String, Object>(aParameterMap);

		int tempMethodParamCount = aFixtureMethod.getParameterTypes().length;
		for (int i = 0; i < tempMethodParamCount; i++) {
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
							Array.set(tempConvertedValueArray, k, valueConverter.convertValue(
									tempExpectedType.getComponentType(), tempSingleValue,
									UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
						}
						tempConvertedValue = tempConvertedValueArray;
					} else {
						// if the expected type is an array, we don't want to convert to that array, but to the
						// component type, of course
						Class<?> tempConversionTargetType = tempExpectedType.isArray() ? tempExpectedType
								.getComponentType() : tempExpectedType;
						tempConvertedValue = valueConverter.convertValue(tempConversionTargetType, tempValue,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
						if (tempExpectedType.isArray()) {
							// ...and if the expected type is an array, now we create one
							Object tempNewArray = Array.newInstance(tempExpectedType.getComponentType(), 1);
							Array.set(tempNewArray, 0, tempConvertedValue);
							tempConvertedValue = tempNewArray;
						}
					}
					aParameterMap.put(tempName, tempConvertedValue);
				}
				tempClonedParameterMap.remove(tempName);
			}
		}

		if (anIncludeArbitraryParametersFlag && (getFixtureInstance() instanceof ArbitraryParameterFixture)) {
			for (Entry<String, Object> tempParameter : tempClonedParameterMap.entrySet()) {
				String tempName = tempParameter.getKey();

				Object tempValue = aParameterMap.remove(tempName);
				if (tempValue != null) {
					Object tempConvertedValue;
					tempConvertedValue = valueConverter.convertValue(null, tempValue,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
					aParameterMap.put(tempName, tempConvertedValue);
				}
			}
		} else {
			if (tempClonedParameterMap.size() > 0) {
				throw new IllegalStateException("There were " + tempClonedParameterMap.size()
						+ " parameters left after processing the fixed params, but the fixture '"
						+ fixtureClass.getName() + "' is not an arbitrary parameter fixture. Left-over params: "
						+ tempClonedParameterMap.keySet());
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
