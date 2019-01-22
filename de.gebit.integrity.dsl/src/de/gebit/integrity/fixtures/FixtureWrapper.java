/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import de.gebit.integrity.classloading.IntegrityClassLoader;
import de.gebit.integrity.comparator.ComparisonResult;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableVariable;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.ExtendedResultFixture.FixtureInvocationResult;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.string.FormattedString;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * This wrapper is used to encapsulate fixture instances.
 * 
 * @param <C>
 *            the fixture class
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FixtureWrapper<C extends Object> {

	/**
	 * The fixture method reference.
	 */
	private MethodReference methodReference;

	/**
	 * The fixture method name.
	 */
	private String methodName;

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
	 * The classloader to use.
	 */
	@Inject
	private IntegrityClassLoader classLoader;

	/**
	 * The model source explorer.
	 */
	@Inject
	private ModelSourceExplorer modelSourceExplorer;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

	/**
	 * Fixture instance factories are cached in this map.
	 */
	private static Map<Class<?>, FixtureInstanceFactory<?>> factoryCache = new HashMap<Class<?>, FixtureInstanceFactory<?>>();

	/**
	 * Creates a new instance. This also instantiates the given fixture class!
	 * 
	 * @param aMethodReference
	 *            the fixture method reference to be wrapped
	 * @param anInjector
	 *            The injector required to inject dependencies into fixture instances and factories. (I don't really
	 *            like to provide this explicitly here, but cannot use injection, since that happens after the
	 *            constructor. Maybe I'll refactor this some time later...)
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public FixtureWrapper(MethodReference aMethodReference, Injector anInjector)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		anInjector.injectMembers(this);
		methodReference = aMethodReference;

		if (methodReference.getMethod() == null) {
			throw new ModelRuntimeLinkException("Method reference missing", aMethodReference,
					modelSourceExplorer.determineSourceInformation(aMethodReference));
		}
		methodName = methodReference.getMethod().getSimpleName();

		fixtureClass = (Class<C>) classLoader.loadClass(methodReference);

		FixtureInstanceFactory<C> tempFactory = null;
		if (factoryCache.containsKey(fixtureClass)) {
			tempFactory = (FixtureInstanceFactory<C>) factoryCache.get(fixtureClass);
		} else {
			FixtureFactory tempFactoryAnnotation = fixtureClass.getAnnotation(FixtureFactory.class);
			if (tempFactoryAnnotation != null) {
				tempFactory = (FixtureInstanceFactory<C>) tempFactoryAnnotation.value().newInstance();
				anInjector.injectMembers(tempFactory);
			}
			factoryCache.put(fixtureClass, tempFactory);
		}

		if (tempFactory != null) {
			fixtureInstance = tempFactory.retrieveInstance();
			factory = tempFactory;
		} else {
			fixtureInstance = fixtureClass.newInstance();
		}

		anInjector.injectMembers(fixtureInstance);
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
	 * Checks whether the wrapped fixture is a {@link ResultAwareFixture}.
	 * 
	 * @return true if it is
	 */
	public boolean isResultAwareFixture() {
		return (ResultAwareFixture.class.isAssignableFrom(fixtureClass));
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
	public ComparisonResult performCustomComparation(Object anExpectedResult, Object aFixtureResult, String aMethodName,
			String aPropertyName) {
		return ((CustomComparatorFixture) fixtureInstance).compareResults(anExpectedResult, aFixtureResult, aMethodName,
				aPropertyName);
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
	public Class<?> determineCustomConversionTargetType(Object aFixtureResult, String aMethodName,
			String aPropertyName) {
		return ((CustomComparatorAndConversionFixture) fixtureInstance).determineConversionTargetType(aFixtureResult,
				aMethodName, aPropertyName);
	}

	/**
	 * Converts the given value to a string. This method either calls the
	 * {@link ValueConverter#convertValueToString(Object, ConversionContext)} method or delegates the conversion to the
	 * contained fixture instance, if it does implement the {@link CustomStringConversionFixture} interface.
	 * 
	 * @param aValue
	 *            the value to convert
	 * @param aFixtureMethod
	 *            the fixture method that was called to return the given value
	 * @param aForceIntermediateMapFlag
	 *            whether the conversion should force the usage of an intermediate map (useful for bean types)
	 * @param aConversionContext
	 *            the conversion context to use (may be null if the default shall be used)
	 * @return the converted string
	 */
	public FormattedString performValueToFormattedStringConversion(Object aValue, String aFixtureMethod,
			boolean aForceIntermediateMapFlag, ConversionContext aConversionContext) {
		if (isCustomStringConversionFixture()) {
			return ((CustomStringConversionFixture) fixtureInstance).convertValueToString(aValue, aFixtureMethod);
		} else {
			return valueConverter.convertValueToFormattedString(aValue, aForceIntermediateMapFlag, aConversionContext);
		}
	}

	/**
	 * Executes the fixture method, using the given set of parameters.
	 * 
	 * @param someParameters
	 *            a map of parameters
	 * @return the resulting object
	 * @throws Throwable
	 */
	public Object execute(Map<String, Object> someParameters) throws Throwable {
		Method tempMethod = classLoader.loadMethod(methodReference);

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
			ModelSourceInformationElement tempModelSourceInfo = modelSourceExplorer
					.determineSourceInformation(methodReference);
			throw new IllegalArgumentException("Caught exception when trying to invoke fixture method '"
					+ tempModelSourceInfo.getSnippet() + "' defined at " + tempModelSourceInfo, exc);
		} catch (InvocationTargetException exc) {
			throw (Throwable) exc.getCause();
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
						Class<?> tempConvertedValueArrayType = Object.class;
						if (tempExpectedType != Object.class) {
							if (!tempExpectedType.isArray()) {
								throw new IllegalArgumentException("The parameter '" + tempName + "' of method '"
										+ aFixtureMethod.getName() + "' in fixture '" + fixtureClass.getName()
										+ "' is not an array type, thus you cannot put multiple values into it!");
							}
							tempConvertedValueArrayType = tempExpectedType.getComponentType();
						}

						Object tempConvertedValueArray = Array.newInstance(tempConvertedValueArrayType,
								((Object[]) tempValue).length);
						for (int k = 0; k < ((Object[]) tempValue).length; k++) {
							Object tempSingleValue = ((Object[]) tempValue)[k];
							Object tempSingleConvertedValue = valueConverter
									.convertValue(tempExpectedType.getComponentType(), tempSingleValue, null);
							performNullCheck(tempAnnotation, tempSingleConvertedValue);
							Array.set(tempConvertedValueArray, k, tempSingleConvertedValue);
						}
						tempConvertedValue = tempConvertedValueArray;
					} else {
						// if the expected type is an array, we don't want to convert to that array, but to the
						// component type, of course...
						Class<?> tempConversionTargetType = tempExpectedType.isArray()
								? tempExpectedType.getComponentType()
								: tempExpectedType;

						// ...except for byte arrays (issue #66), those must be treated specially!
						boolean tempSpecialByteArrayMode = false;
						if (tempExpectedType == byte[].class || tempExpectedType == Byte[].class) {
							tempConversionTargetType = tempExpectedType;
							tempSpecialByteArrayMode = true;
						}

						tempConvertedValue = valueConverter.convertValue(tempConversionTargetType, tempValue, null);
						performNullCheck(tempAnnotation, tempConvertedValue);

						if (!tempSpecialByteArrayMode && tempExpectedType.isArray()) {
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
					// In case of arbitrary parameters, we don't want to perform the default bean-to-map conversion,
					// because otherwise one couldn't put any objects into the fixture without having them converted to
					// maps. See also issue #52: https://github.com/integrity-tf/integrity/issues/52
					tempConvertedValue = valueConverter.convertValue(null, tempValue,
							conversionContextProvider.get().skipBeanToMapDefaultConversion());
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
	 * Validates given parameter values to comply with the {@link FixtureParameter#nullable()} setting.
	 * 
	 * @param anAnnotation
	 *            the fixture parameter annotation setting the rules
	 * @param aValue
	 *            the parameter value
	 */
	protected void performNullCheck(FixtureParameter anAnnotation, Object aValue) {
		if (!anAnnotation.nullable()) {
			if (aValue == null) {
				throw new IllegalArgumentException("The parameter '" + anAnnotation.name()
						+ "' is NOT nullable, but a null value was encountered!");
			}
		}
	}

	/**
	 * Call {@link ExtendedResultFixture#provideExtendedResults()} on the fixture - if it is an extended result fixture
	 * - and return the extended results.
	 * 
	 * @return the extended result list, or null if the fixture does not support the protocol or didn't return anything
	 */
	public List<ExtendedResult> retrieveExtendedResults(FixtureInvocationResult anInvocationResult) {
		if (fixtureInstance instanceof ExtendedResultFixture) {
			List<ExtendedResult> tempList = ((ExtendedResultFixture) fixtureInstance)
					.provideExtendedResults(anInvocationResult);
			return (tempList != null && tempList.size() > 0) ? tempList : null;
		} else {
			return null;
		}
	}

	/**
	 * Invoke the {@link ResultAwareFixture} method for the case of a 'call' type fixture invocation, if the fixture is
	 * a {@link ResultAwareFixture}.
	 */
	public void announceCallResults(VariableVariable aDefaultTargetVariable,
			List<NamedCallResult> someNamedTargetVariables) {
		if (fixtureInstance instanceof ResultAwareFixture) {
			Set<String> tempNamedResultSet = new HashSet<>();
			if (someNamedTargetVariables != null) {
				for (NamedCallResult tempResult : someNamedTargetVariables) {
					tempNamedResultSet
							.add(IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(tempResult.getName()));
				}
			}

			((ResultAwareFixture) fixtureInstance).announceCheckedResults(methodName, aDefaultTargetVariable != null,
					tempNamedResultSet);
		}
	}

	/**
	 * Invoke the {@link ResultAwareFixture} method for the case of a 'test' type fixture invocation, if the fixture is
	 * a {@link ResultAwareFixture}.
	 * 
	 * @param aDefaultResult
	 *            The default result as given in the test script
	 * @param someNamedResults
	 *            A list of named results used by the test
	 */
	public void announceTestResults(ValueOrEnumValueOrOperationCollection aDefaultResult,
			List<NamedResult> someNamedResults) {
		if (fixtureInstance instanceof ResultAwareFixture) {
			Set<String> tempNamedResultSet = new HashSet<>();
			if (someNamedResults != null) {
				for (NamedResult tempResult : someNamedResults) {
					tempNamedResultSet
							.add(IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(tempResult.getName()));
				}
			}

			announceTestResultsInternal(aDefaultResult, tempNamedResultSet);
		}
	}

	/**
	 * Invoke the {@link ResultAwareFixture} method for the case of a 'tabletest' type fixture invocation.
	 * 
	 * @param aDefaultResult
	 *            The default result as given in the test script
	 * @param someResultHeaders
	 *            A list of named results used by the test
	 */
	public void announceTableTestResults(ValueOrEnumValueOrOperationCollection aDefaultResult,
			List<ResultTableHeader> someResultHeaders) {
		if (fixtureInstance instanceof ResultAwareFixture) {
			Set<String> tempNamedResultSet = new HashSet<>();
			if (someResultHeaders != null) {
				for (ResultTableHeader tempHeader : someResultHeaders) {
					tempNamedResultSet
							.add(IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(tempHeader.getName()));
				}
			}

			announceTestResultsInternal(aDefaultResult, tempNamedResultSet);
		}
	}

	/**
	 * Actually performs the test result announcement call.
	 * 
	 * @param aDefaultResult
	 *            The default result as given in the test script
	 * @param aNamedResultSet
	 *            A list of named results used by the test
	 */
	protected void announceTestResultsInternal(ValueOrEnumValueOrOperationCollection aDefaultResult,
			Set<String> aNamedResultSet) {
		// no named result and no explicit default result = implicit default result!
		boolean tempHasDefaultResult = aDefaultResult != null || aNamedResultSet.size() == 0;
		((ResultAwareFixture) fixtureInstance).announceCheckedResults(methodName, tempHasDefaultResult,
				aNamedResultSet);
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
