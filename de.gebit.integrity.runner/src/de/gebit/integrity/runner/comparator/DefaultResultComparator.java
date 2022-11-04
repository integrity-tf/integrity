/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.comparator;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import com.google.inject.Inject;

import de.gebit.integrity.comparator.ComparisonResult;
import de.gebit.integrity.comparator.MapComparisonResult;
import de.gebit.integrity.comparator.SimpleComparisonResult;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.EmptyValue;
import de.gebit.integrity.dsl.InexistentValue;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.RegexValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.TypedNestedObject;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.EmptyValueHandling;
import de.gebit.integrity.parameter.conversion.InexistentValueHandling;
import de.gebit.integrity.parameter.conversion.RegexValueHandling;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.RegexValueToPattern;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * The standard result comparator component.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultResultComparator implements ResultComparator {

	/**
	 * The value converter to use.
	 */
	@Inject
	protected ValueConverter valueConverter;

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	@Override
	public ComparisonResult compareResult(Object aFixtureResult, ValueOrEnumValueOrOperationCollection anExpectedResult,
			FixtureWrapper<?> aFixtureInstance, MethodReference aFixtureMethod, String aPropertyName)
			throws ClassNotFoundException, UnexecutableException, InstantiationException {
		if (anExpectedResult != null) {
			if (aFixtureResult == null) {
				if (anExpectedResult.getMoreValues().size() > 0) {
					// if there's more than one value expected, this can never equal a single null value
					return SimpleComparisonResult.NOT_EQUAL;
				} else {
					boolean tempIsNull = false;
					// This is only true if the expected result is also null. That could be directly...
					if (anExpectedResult.getValue() instanceof NullValue) {
						tempIsNull = true;
					} else {
						// ...or indirectly by the value being a variable/constant that resolves to a null value
						VariableOrConstantEntity tempEntity
								= IntegrityDSLUtil.extractVariableOrConstantEntity(anExpectedResult.getValue());
						if (tempEntity != null) {
							Object tempResult = parameterResolver.resolveParameterValue(anExpectedResult,
									UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
							tempIsNull = (tempResult == null || (tempResult instanceof NullValue));
						}
					}

					return SimpleComparisonResult.valueOf(tempIsNull);
				}
			} else {
				if (aFixtureInstance.isCustomComparatorFixture()) {
					// Custom comparators will get whole arrays at once if arrays are used
					String tempMethodName = aFixtureMethod.getMethod().getSimpleName();
					Object tempConvertedResult = null;
					Class<?> tempConversionTargetType = null;

					if (aFixtureInstance.isCustomComparatorAndConversionFixture()) {
						tempConversionTargetType = aFixtureInstance.determineCustomConversionTargetType(aFixtureResult,
								tempMethodName, aPropertyName);
					} else {
						tempConversionTargetType
								= aFixtureResult.getClass().isArray() ? aFixtureResult.getClass().getComponentType()
										: aFixtureResult.getClass();
					}

					if (anExpectedResult.getMoreValues().size() > 0) {
						// multiple result values given -> we're going to put them into an array of the same type
						// as the fixture result
						Class<?> tempArrayType
								= (tempConversionTargetType == null) ? Object.class : tempConversionTargetType;
						tempConvertedResult
								= Array.newInstance(tempArrayType, anExpectedResult.getMoreValues().size() + 1);
						for (int i = 0; i < Array.getLength(tempConvertedResult); i++) {
							ValueOrEnumValueOrOperation tempSingleExpectedResult = (i == 0 ? anExpectedResult.getValue()
									: anExpectedResult.getMoreValues().get(i - 1));
							Array.set(tempConvertedResult, i, valueConverter.convertValue(tempConversionTargetType,
									tempSingleExpectedResult, null));
						}
					} else {
						tempConvertedResult = valueConverter.convertValue(tempConversionTargetType,
								anExpectedResult.getValue(), null);
					}

					return aFixtureInstance.performCustomComparation(tempConvertedResult, aFixtureResult,
							tempMethodName, aPropertyName);
				} else {
					// Standard comparation compares each value for itself in case of arrays
					if (anExpectedResult.getMoreValues().size() > 0) {
						// multiple result values were given -> fixture result must be an array of same size (or a List
						// as an array equivalent)
						if (!(((aFixtureResult.getClass().isArray()
								&& Array.getLength(aFixtureResult) == anExpectedResult.getMoreValues().size() + 1))
								|| ((aFixtureResult instanceof List) && ((List<?>) aFixtureResult)
										.size() == anExpectedResult.getMoreValues().size() + 1))) {
							return SimpleComparisonResult.NOT_EQUAL;
						}
						// In case of a list, convert to array first so we have a single path to handle both
						Object tempFixtureResultArray = aFixtureResult;
						if (aFixtureResult instanceof List) {
							tempFixtureResultArray = ((List<?>) aFixtureResult).toArray();
						}
						// now compare all values
						for (int i = 0; i < Array.getLength(tempFixtureResultArray); i++) {
							Object tempSingleFixtureResult = Array.get(tempFixtureResultArray, i);
							ValueOrEnumValueOrOperation tempSingleExpectedResult = (i == 0 ? anExpectedResult.getValue()
									: anExpectedResult.getMoreValues().get(i - 1));
							if (tempSingleFixtureResult == null) {
								// The fixture returned a null, we need to expect a null
								if (!(tempSingleExpectedResult instanceof NullValue)) {
									return SimpleComparisonResult.NOT_EQUAL;
								}
							} else {
								if (!convertAndPerformEqualityCheck(tempSingleFixtureResult, tempSingleExpectedResult,
										tempSingleFixtureResult.getClass()).isSuccessful()) {
									return SimpleComparisonResult.NOT_EQUAL;
								}
							}
						}
						return SimpleComparisonResult.EQUAL;
					} else {
						// If we arrive here, the expected result is a simple, single value.
						ValueOrEnumValueOrOperation tempSingleExpectedResult = anExpectedResult.getValue();
						Object tempSingleFixtureResult = aFixtureResult;

						// First see if we have the special case of byte arrays (issue #66). Those must be handled
						// separately.
						if (tempSingleFixtureResult instanceof byte[]) {
							byte[] tempConvertedExpectedResult = (byte[]) valueConverter.convertValue(byte[].class,
									tempSingleExpectedResult, null);
							return SimpleComparisonResult.valueOf(
									Arrays.equals((byte[]) tempSingleFixtureResult, tempConvertedExpectedResult));
						} else if (tempSingleFixtureResult instanceof Byte[]) {
							Byte[] tempConvertedExpectedResult = (Byte[]) valueConverter.convertValue(Byte[].class,
									tempSingleExpectedResult, null);
							return SimpleComparisonResult.valueOf(
									Arrays.equals((Byte[]) tempSingleFixtureResult, tempConvertedExpectedResult));
						}

						// The fixture might still have returned an array (or a List as an equivalent).
						// If the expected type is an array, we don't want to convert to that array, but to the
						// component type, of course
						Class<?> tempConversionTargetType = tempSingleFixtureResult.getClass();
						if (tempSingleFixtureResult.getClass().isArray() || (tempSingleFixtureResult instanceof List)) {
							Object tempSingleFixtureResultArray = tempSingleFixtureResult;
							if (tempSingleFixtureResult instanceof List) {
								tempSingleFixtureResultArray = ((List<?>) tempSingleFixtureResult).toArray();
							}
							// Now we know that the fixture result is an array

							tempConversionTargetType = tempSingleFixtureResultArray.getClass().getComponentType();
							if (tempConversionTargetType == Object.class) {
								// Object arrays are bad target types; in this case we try to deduct a target type from
								// the values within the array
								tempConversionTargetType = null;
								for (int i = 0; i < Array.getLength(tempSingleFixtureResultArray); i++) {
									Object tempArrayValue = Array.get(tempSingleFixtureResultArray, i);
									if (tempArrayValue != null) {
										if (tempConversionTargetType == null) {
											tempConversionTargetType = tempArrayValue.getClass();
										} else {
											if (tempConversionTargetType.isAssignableFrom(tempArrayValue.getClass())) {
												// current value type is a subtype of the current target type -> good!
											} else {
												// the types in the array don't match at all -> bad! Use standard
												// conversion.
												tempConversionTargetType = null;
												break;
											}
										}
									}
								}
							}
						}

						// If now the conversion target type happens to be Optional, we need to find something else to
						// convert to, because an Optional is just a wrapper
						if (tempConversionTargetType == Optional.class) {
							tempConversionTargetType = null;
							if (tempSingleFixtureResult instanceof Optional) {
								if (((Optional<?>) tempSingleFixtureResult).isPresent()) {
									Object tempContainedObject = ((Optional<?>) tempSingleFixtureResult).get();
									if (tempContainedObject != null) {
										tempConversionTargetType = tempContainedObject.getClass();
									}
								}
							}
						}

						return convertAndPerformEqualityCheck(tempSingleFixtureResult, tempSingleExpectedResult,
								tempConversionTargetType);
					}
				}
			}
		} else {
			if (aFixtureInstance.isCustomComparatorFixture()) {
				return aFixtureInstance.performCustomComparation(null, aFixtureResult,
						aFixtureMethod.getMethod().getSimpleName(), aPropertyName);
			} else {
				if (aFixtureResult instanceof Boolean) {
					return SimpleComparisonResult.valueOf((Boolean) aFixtureResult);
				} else {
					throw new IllegalArgumentException(
							"If no expected test result is given and the fixture is not a CustomComparatorFixture, "
									+ "the test fixture must return a boolean result!");
				}
			}
		}
	}

	/**
	 * Converts a fixture result and an expected result value for comparison (usually by converting the expected result
	 * to match the fixture result, but nested objects are handled differently and converted to maps for comparison).
	 * The final results are then compared.
	 * 
	 * @param aSingleFixtureResult
	 *            the fixture result
	 * @param aSingleExpectedResult
	 *            the expected result
	 * @param aConversionTargetType
	 *            the target type for conversion
	 * @return true if both values are considered equal, false if not
	 * @throws UnresolvableVariableException
	 * @throws UnexecutableException
	 */
	protected ComparisonResult convertAndPerformEqualityCheck(Object aSingleFixtureResult,
			ValueOrEnumValueOrOperation aSingleExpectedResult, Class<?> aConversionTargetType)
			throws UnresolvableVariableException, UnexecutableException {
		Object tempConvertedExpectedResult;
		Object tempConvertedFixtureResult = aSingleFixtureResult;

		// First we need to sort out the case that the expected result is a variable or operation. If we don't resolve
		// those, we may not find maps or nested objects or whatever hidden behind them.
		Object tempSingleExpectedResult = aSingleExpectedResult;
		if ((aSingleExpectedResult instanceof Variable) || (aSingleExpectedResult instanceof CustomOperation)) {
			try {
				tempSingleExpectedResult = parameterResolver.resolveSingleParameterValue(aSingleExpectedResult,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
			} catch (InstantiationException exc) {
				throw new UnexecutableException("Failed to resolve an operation", exc);
			} catch (ClassNotFoundException exc) {
				throw new UnexecutableException("Failed to resolve an operation", exc);
			}
		}

		// If the expected result is an Optional, we must resolve that optional to an actual value first
		boolean tempExpectedResultIsEmptyOptional = false;
		if (tempSingleExpectedResult instanceof Optional) {
			if (((Optional<?>) tempSingleExpectedResult).isPresent()) {
				tempSingleExpectedResult = ((Optional<?>) tempSingleExpectedResult).get();
			} else {
				tempExpectedResultIsEmptyOptional = true;
				tempSingleExpectedResult = ParameterUtil.INEXISTENT_VALUE;
			}
		}

		// Now sort out cases in which Optional results have been provided by the fixture. In those cases, it may be
		// the case that a non-existent result is actually expected by the test (via an Inexistent value), which means a
		// successful comparison. Otherwise we will have to resolve the optional to some concrete value and continue
		// with that. In all this action, we need to see if we have to shortcut the comparison because the expected
		// result is an Optional, too.
		if (tempConvertedFixtureResult instanceof Optional) {
			boolean tempWeExpectNoValue
					= (tempExpectedResultIsEmptyOptional || (tempSingleExpectedResult instanceof InexistentValue));
			if (((Optional<?>) tempConvertedFixtureResult).isPresent()) {
				// If the Optional has a value, but we explicitly don't expect one, the comparison has already failed
				if (tempWeExpectNoValue) {
					return new SimpleComparisonResult(false);
				}

				// The Optional contains a value and we seem to expect one -> just resolve to that value and continue
				tempConvertedFixtureResult = ((Optional<?>) tempConvertedFixtureResult).get();
			} else {
				// The Optional does not contain a value. If we explicitly don't expect one, that's great (successful
				// comparison), otherwise it's a failed comparison. In any case, the comparison is over at this point.
				return new SimpleComparisonResult(tempWeExpectNoValue);
			}
		}

		if (((tempSingleExpectedResult instanceof NestedObject)
				|| (tempSingleExpectedResult instanceof TypedNestedObject))
				&& !(tempConvertedFixtureResult instanceof Map)) {
			// if the expected result is a (typed) nested object, and the fixture has NOT returned a
			// map, we assume the fixture result to be a bean class/instance. We'll convert both to maps
			// for comparison!
			NestedObject tempNestedObject;
			if (tempSingleExpectedResult instanceof TypedNestedObject) {
				tempNestedObject = ((TypedNestedObject) tempSingleExpectedResult).getNestedObject();
			} else {
				tempNestedObject = (NestedObject) tempSingleExpectedResult;
			}

			tempConvertedFixtureResult = valueConverter.convertValue(Map.class, tempConvertedFixtureResult, null);
			// Keeping Inexistent values as they are (= the InexistentValue model class instance) is necessary so that
			// we can check for them later in map comparison. Otherwise they would be converted to strings.
			// The same must be done for regexes in order to be able to compare them correctly, and for empty values.
			tempConvertedExpectedResult = valueConverter.convertValue(Map.class, tempNestedObject,
					new ConversionContext().withInexistentValueHandling(InexistentValueHandling.KEEP_AS_IS)
							.withRegexValueHandling(RegexValueHandling.KEEP_AS_IS)
							.withEmptyValueHandling(EmptyValueHandling.KEEP_AS_IS));
		} else {
			if (tempSingleExpectedResult instanceof Map && !(tempConvertedFixtureResult instanceof Map)) {
				// if the expected result is a map, and the fixture has NOT returned a map, we also assume the fixture
				// result to be a bean class/instance. But we only need to convert that to a map for comparison.
				tempConvertedFixtureResult = valueConverter.convertValue(Map.class, tempConvertedFixtureResult, null);
				tempConvertedExpectedResult = tempSingleExpectedResult;
			} else if (tempSingleExpectedResult instanceof RegexValue) {
				// If the expected result is a regex, perform a regular expression comparison. For this we need
				// to convert the fixture result to a String, because that's what we can match the regex with.
				tempConvertedFixtureResult
						= valueConverter.convertValue(String.class, tempConvertedFixtureResult, null);
				return performRegexCheck((String) tempConvertedFixtureResult, (RegexValue) tempSingleExpectedResult);
			} else {
				// no special bean-related cases apply: convert the expected result to match the given fixture result
				tempConvertedExpectedResult
						= valueConverter.convertValue(aConversionTargetType, tempSingleExpectedResult,
								new ConversionContext().withEmptyValueHandling(EmptyValueHandling.KEEP_AS_IS)
										.withRegexValueHandling(RegexValueHandling.KEEP_AS_IS));
			}
		}

		return performEqualityCheck(tempConvertedFixtureResult, tempConvertedExpectedResult, aSingleExpectedResult);
	}

	/**
	 * Performs the regular expression based comparison between a fixture result and an expected regex. The pattern
	 * provided must be "found" in the value (it does not have to match the entire value, except if the pattern is
	 * anchored to the start and/or end).
	 * 
	 * @param aFixtureResult
	 *            the fixture result as a String
	 * @param anExpectedResult
	 *            the expected result
	 * @return {@link SimpleComparisonResult#EQUAL} (pattern found) or {@link SimpleComparisonResult#NOT_EQUAL} (pattern
	 *         not found)
	 */
	protected ComparisonResult performRegexCheck(String aFixtureResult, RegexValue anExpectedResult) {
		Pattern tempPattern = RegexValueToPattern.convert(anExpectedResult);
		return SimpleComparisonResult.valueOf(tempPattern.matcher(aFixtureResult).find());
	}

	/**
	 * Perform the actual equality check between a real result returned from a fixture and a converted result gathered
	 * from the test scripts. A few special cases are handled here, but if no special case applies, this just runs a
	 * standard equals() comparison.
	 * 
	 * @param aConvertedResult
	 *            the actual result
	 * @param aConvertedExpectedResult
	 *            the expected result from the scripts, converted to the same type as the actual result
	 * @param aRawExpectedResult
	 *            the raw expected result object from the scripts
	 * @return true if equal, false otherwise
	 */
	protected ComparisonResult performEqualityCheck(Object aConvertedResult, Object aConvertedExpectedResult,
			ValueOrEnumValueOrOperation aRawExpectedResult) {
		if (aConvertedResult == null) {
			return SimpleComparisonResult.valueOf(aConvertedExpectedResult == null
					|| (aConvertedExpectedResult.getClass().isArray() && Array.getLength(aConvertedExpectedResult) == 1
							&& Array.get(aConvertedExpectedResult, 0) == null));
		} else {
			if (aConvertedResult instanceof Date && aConvertedExpectedResult instanceof Date) {
				return performEqualityCheckForDates((Date) aConvertedResult, (Date) aConvertedExpectedResult,
						aRawExpectedResult);
			} else if (aConvertedResult instanceof Temporal && aConvertedExpectedResult instanceof Temporal) {
				return performEqualityCheckForJava8Dates((Temporal) aConvertedResult,
						(Temporal) aConvertedExpectedResult, aRawExpectedResult);
			} else if (aConvertedResult instanceof Map && aConvertedExpectedResult instanceof Map) {
				return performEqualityCheckForMaps((Map<?, ?>) aConvertedResult, (Map<?, ?>) aConvertedExpectedResult,
						aRawExpectedResult);
			} else if (aConvertedResult instanceof List) {
				// Lists can be treated just like Arrays, so we internally make them into Arrays
				return performEqualityCheck(
						((List<?>) aConvertedResult).toArray(new Object[((List<?>) aConvertedResult).size()]),
						aConvertedExpectedResult, aRawExpectedResult);
			} else if (aConvertedResult.getClass().isArray()) {
				// If an empty value is explicitly expected, test for that.
				if (aConvertedExpectedResult instanceof EmptyValue) {
					if (Array.getLength(aConvertedResult) > 0) {
						return SimpleComparisonResult.NOT_EQUAL;
					} else {
						return SimpleComparisonResult.EQUAL;
					}
				}

				if (aConvertedExpectedResult == null) {
					// the fixture may still be returning an array that has to be unpacked
					if (Array.getLength(aConvertedResult) != 1) {
						return SimpleComparisonResult.NOT_EQUAL;
					}
					return SimpleComparisonResult.valueOf(Array.get(aConvertedResult, 0) == null);
				} else {
					if (!aConvertedExpectedResult.getClass().isArray()) {
						// the fixture may be returning an array that has to be unpacked
						if (Array.getLength(aConvertedResult) != 1) {
							return SimpleComparisonResult.NOT_EQUAL;
						}
						return performEqualityCheck(Array.get(aConvertedResult, 0), aConvertedExpectedResult,
								aRawExpectedResult);
					} else {
						if (Array.getLength(aConvertedResult) != Array.getLength(aConvertedExpectedResult)) {
							return SimpleComparisonResult.NOT_EQUAL;
						}
						// both are converted arrays -> compare all values!
						for (int i = 0; i < Array.getLength(aConvertedResult); i++) {
							ComparisonResult tempResult = performEqualityCheck(Array.get(aConvertedResult, i),
									Array.get(aConvertedExpectedResult, i), aRawExpectedResult);
							if (!tempResult.isSuccessful()) {
								return SimpleComparisonResult.NOT_EQUAL;
							}
						}
						return SimpleComparisonResult.EQUAL;
					}
				}
			} else {
				// This is the super-simple case where we basically have only one value to compare
				if (aConvertedExpectedResult == null) {
					// we have validated convertedResult to be non-null before
					return SimpleComparisonResult.NOT_EQUAL;
				} else {
					if (aConvertedExpectedResult.getClass().isArray()) {
						// the converted result may still be an array
						if (Array.getLength(aConvertedExpectedResult) != 1) {
							return SimpleComparisonResult.EQUAL;
						}
						return performEqualityCheck(aConvertedResult, Array.get(aConvertedExpectedResult, 0),
								aRawExpectedResult);
					} else if (aConvertedExpectedResult instanceof RegexValue) {
						// The converted result may be a Regex (due to RegexValueHandling.KEEP_AS_IS on conversion)
						// in which case regex comparison rules apply. But the "converted result" must be a String
						// in this case, as regexes cannot be compared to anything besides String.
						try {
							return performRegexCheck(
									(String) valueConverter.convertValue(String.class, aConvertedResult, null),
									(RegexValue) aConvertedExpectedResult);
						} catch (UnresolvableVariableException | UnexecutableException exc) {
							// This should be impossible to happen at this point
							throw new RuntimeException(exc);
						}
					} else {
						// If no special cases apply, perform standard equals comparison
						return performEqualityCheckForObjects(aConvertedResult, aConvertedExpectedResult,
								aRawExpectedResult);
					}
				}
			}
		}
	}

	/**
	 * Compare two {@link Map}s for equality. Maps are considered equal if all the values in the expected result are
	 * found in the actual result (there may well be more keys in the actual result than expected, except if one of the
	 * maps declares one of these "inexistent", in which case it may NOT exist in the other!).
	 * 
	 * @param aResult
	 *            the result returned by the fixture
	 * @param anExpectedResult
	 *            the expected result as in the script, converted for comparison
	 * @param aRawExpectedResult
	 *            the raw expected result as in the script, before conversion
	 * @return true if equal, false otherwise
	 */
	protected MapComparisonResult performEqualityCheckForMaps(Map<?, ?> aResult, Map<?, ?> anExpectedResult,
			ValueOrEnumValueOrOperation aRawExpectedResult) {
		boolean tempSuccess = true;
		Set<String> tempCombinedFailedPaths = new HashSet<String>();

		for (Entry<?, ?> tempEntry : ((Map<?, ?>) anExpectedResult).entrySet()) {
			Object tempActualValue = ((Map<?, ?>) aResult).get(tempEntry.getKey());
			Object tempReferenceValue = tempEntry.getValue();

			if (tempReferenceValue instanceof InexistentValue) {
				if (tempActualValue != null || ((Map<?, ?>) aResult).containsKey(tempEntry.getKey())) {
					// Reference values requires inexistence of key in actual map, but it contains it -> failure
					tempSuccess = false;
					tempCombinedFailedPaths.add(tempEntry.getKey().toString());
					continue;
				} else {
					// Inexistence of value confirmed -> prevent further comparison (which would fail)
					continue;
				}
			} else if (tempReferenceValue instanceof EmptyValue) {
				if (tempActualValue != null) {
					if (tempActualValue instanceof Collection) {
						if (((Collection<?>) tempActualValue).size() == 0) {
							continue;
						}
					} else if (tempActualValue.getClass().isArray()) {
						if (Array.getLength(tempActualValue) == 0) {
							continue;
						}
					}
				}
				// If we arrive here, the value could not be confirmed to be something empty. Treat as failure.
				tempSuccess = false;
				tempCombinedFailedPaths.add(tempEntry.getKey().toString());
				continue;
			}

			Object tempConvertedReferenceValue = tempReferenceValue;
			if (!(tempActualValue instanceof Map && tempReferenceValue instanceof Map)) {
				// If the inner values aren't maps themselves, special handling is required.
				
				// Arrays and lists must be treated differently. Lists can be converted to arrays first, then we check
				// for special array treatment.
				if(tempActualValue != null && (tempActualValue instanceof List)) {
					tempActualValue = ((List<?>) tempActualValue).toArray(new Object[((List<?>) tempActualValue).size()]);
				}
				if(tempReferenceValue != null && (tempReferenceValue instanceof List)) {
					tempReferenceValue = ((List<?>) tempReferenceValue).toArray(new Object[((List<?>) tempReferenceValue).size()]);
				}

				// First see if they are arrays (maybe of maps, even). This stuff fixes issue #124!
				if ((tempActualValue != null && tempActualValue.getClass().isArray())
						|| (tempReferenceValue != null && tempReferenceValue.getClass().isArray())) {
					// If one or both values is an array, things get more complicated...
					if (!(tempActualValue != null && tempActualValue.getClass().isArray())
							|| !(tempReferenceValue != null && tempReferenceValue.getClass().isArray())) {
						// If just one is an array, we automatically fail, since we have a different number of elements
						// - except if one of them is an array with one element and the other one is not an array. That
						// is good, we just package the other one in an array and continue with array comparison.
						if (tempActualValue != null && tempActualValue.getClass().isArray()) {
							tempReferenceValue = new Object[] { tempReferenceValue };
						} else if (tempReferenceValue != null && tempReferenceValue.getClass().isArray()) {
							tempActualValue = new Object[] { tempActualValue };
						} else {
							tempCombinedFailedPaths.add(tempEntry.getKey().toString());
							tempSuccess = false;
							continue;
						}
					}

					// Both are arrays -> check if length is equal, then check each entry
					if (Array.getLength(tempActualValue) != Array.getLength(tempReferenceValue)) {
						tempSuccess = false;
						tempCombinedFailedPaths.add(tempEntry.getKey().toString());
					} else {
						for (int i = 0; i < Array.getLength(tempActualValue); i++) {
							
							// Each entry must be converted first (this fixes issue #262)
							Object tempActualSingleValue = Array.get(tempActualValue, i);
							Object tempReferenceSingleValue = Array.get(tempReferenceValue, i);
							try {								
								tempConvertedReferenceValue
										= (tempActualSingleValue != null)
												? valueConverter.convertValue(tempActualSingleValue.getClass(), tempReferenceSingleValue,
														new ConversionContext()
																.withRegexValueHandling(RegexValueHandling.KEEP_AS_IS))
												: tempReferenceSingleValue;
							} catch (UnresolvableVariableException exc) {
								exc.printStackTrace();
							} catch (UnexecutableException exc) {
								exc.printStackTrace();
							}
							
							ComparisonResult tempInnerResult = performEqualityCheck(tempActualSingleValue,
									tempConvertedReferenceValue, aRawExpectedResult);
							if (!tempInnerResult.isSuccessful()) {
								tempSuccess = false;

								// In case the sub-result is of a map comparison, we just add the failed paths to
								// ours, prepending them with the necessary prefix in the process
								if (tempInnerResult instanceof MapComparisonResult) {
									for (String tempSubPath : ((MapComparisonResult) tempInnerResult)
											.getFailedPaths()) {
										tempCombinedFailedPaths.add(tempEntry.getKey() + "#" + i + "." + tempSubPath);
									}
								} else {
									tempCombinedFailedPaths.add(tempEntry.getKey() + "#" + i);
								}
								break;
							}
						}

						continue;
					}
				}

				// Okay, not arrays. In this case we still have to ensure both values are of equal type first,
				// since even though both outer values are maps, their inner values have not been necessarily converted
				// to the same types. But we must keep Regexes alive here, in order to be able to perform Regex
				// comparison
				// within maps.
				try {
					tempConvertedReferenceValue
							= (tempActualValue != null)
									? valueConverter.convertValue(tempActualValue.getClass(), tempReferenceValue,
											new ConversionContext()
													.withRegexValueHandling(RegexValueHandling.KEEP_AS_IS))
									: tempReferenceValue;
				} catch (UnresolvableVariableException exc) {
					exc.printStackTrace();
				} catch (UnexecutableException exc) {
					exc.printStackTrace();
				}
			}

			ComparisonResult tempInnerResult = performEqualityCheck(tempActualValue, tempConvertedReferenceValue,
					(tempReferenceValue instanceof ValueOrEnumValueOrOperation)
							? (ValueOrEnumValueOrOperation) tempReferenceValue
							: null);

			if (!tempInnerResult.isSuccessful()) {
				tempSuccess = false;

				// In case the sub-result is of a map comparison, we just add the failed paths to ours, prepending them
				// with the necessary prefix in the process
				if (tempInnerResult instanceof MapComparisonResult) {
					for (String tempSubPath : ((MapComparisonResult) tempInnerResult).getFailedPaths()) {
						tempCombinedFailedPaths.add(tempEntry.getKey() + "." + tempSubPath);
					}
				} else {
					tempCombinedFailedPaths.add(tempEntry.getKey().toString());
				}
			}
		}

		return new MapComparisonResult(tempSuccess, tempCombinedFailedPaths);
	}

	/**
	 * Compare two {@link Date}s for equality.
	 * 
	 * @param aResult
	 *            the result returned by the fixture
	 * @param anExpectedResult
	 *            the expected result as in the script, converted for comparison
	 * @param aRawExpectedResult
	 *            the raw expected result as in the script, before conversion
	 * @return true if equal, false otherwise
	 */
	protected ComparisonResult performEqualityCheckForDates(Date aResult, Date anExpectedResult,
			Object aRawExpectedResult) {
		if (aRawExpectedResult instanceof DateValue) {
			// compare only the date part
			return SimpleComparisonResult.valueOf(DateUtil.stripTimeFromDate((Date) anExpectedResult)
					.equals(DateUtil.stripTimeFromDate((Date) aResult)));
		} else if (aRawExpectedResult instanceof TimeValue) {
			// compare only the time part
			return SimpleComparisonResult.valueOf(DateUtil.stripDateFromTime((Date) anExpectedResult)
					.equals(DateUtil.stripDateFromTime((Date) aResult)));
		} else {
			// compare both parts
			return SimpleComparisonResult.valueOf(anExpectedResult.equals(aResult));
		}
	}

	/**
	 * Compare two {@link Temporal}s for equality.
	 * 
	 * @param aResult
	 *            the result returned by the fixture
	 * @param anExpectedResult
	 *            the expected result as in the script, converted for comparison
	 * @param aRawExpectedResult
	 *            the raw expected result as in the script, before conversion
	 * @return true if equal, false otherwise
	 */
	protected ComparisonResult performEqualityCheckForJava8Dates(Temporal aResult, Temporal anExpectedResult,
			Object aRawExpectedResult) {
		if (aRawExpectedResult instanceof DateValue) {
			// compare only the date part
			if (aResult instanceof LocalTime) {
				throw new IllegalArgumentException("Cannot compare a LocalTime, which has no date part, to a date");
			} else if (aResult instanceof LocalDate) {
				return SimpleComparisonResult.valueOf(((LocalDate) aResult).equals(((LocalDate) anExpectedResult)));
			} else if (aResult instanceof LocalDateTime) {
				return SimpleComparisonResult.valueOf(((LocalDateTime) aResult).toLocalDate()
						.equals(((LocalDateTime) anExpectedResult).toLocalDate()));
			} else if (aResult instanceof ZonedDateTime) {
				return SimpleComparisonResult
						.valueOf((((ZonedDateTime) aResult).withZoneSameInstant(ZoneId.systemDefault()).toLocalDate())
								.equals(((ZonedDateTime) anExpectedResult).withZoneSameInstant(ZoneId.systemDefault())
										.toLocalDate()));
			} else if (aResult instanceof Instant) {
				return SimpleComparisonResult.valueOf(((Instant) aResult).atZone(ZoneId.systemDefault()).toLocalDate()
						.equals(((Instant) anExpectedResult).atZone(ZoneId.systemDefault()).toLocalDate()));
			} else {
				throw new UnsupportedOperationException(
						"Cannot compare '" + aResult.getClass() + "' and '" + anExpectedResult.getClass() + "'");
			}
		} else if (aRawExpectedResult instanceof TimeValue) {
			// compare only the time part
			if (aResult instanceof LocalDate) {
				throw new IllegalArgumentException("Cannot compare a LocalDate, which has no time part, to a time");
			} else if (aResult instanceof LocalTime) {
				return SimpleComparisonResult.valueOf(((LocalTime) aResult).equals(((LocalTime) anExpectedResult)));
			} else if (aResult instanceof LocalDateTime) {
				return SimpleComparisonResult.valueOf(((LocalDateTime) aResult).toLocalTime()
						.equals(((LocalDateTime) anExpectedResult).toLocalTime()));
			} else if (aResult instanceof ZonedDateTime) {
				// In this case, we consider two times equal if they mark the same point in time, even though the zones
				// might differ
				return SimpleComparisonResult
						.valueOf((((ZonedDateTime) aResult).withZoneSameInstant(ZoneId.systemDefault()).toLocalTime())
								.equals(((ZonedDateTime) anExpectedResult).withZoneSameInstant(ZoneId.systemDefault())
										.toLocalTime()));
			} else if (aResult instanceof Instant) {
				return SimpleComparisonResult.valueOf(((Instant) aResult).atZone(ZoneId.systemDefault()).toLocalTime()
						.equals(((Instant) anExpectedResult).atZone(ZoneId.systemDefault()).toLocalTime()));
			} else {
				throw new UnsupportedOperationException(
						"Cannot compare '" + aResult.getClass() + "' and '" + anExpectedResult.getClass() + "'");
			}
		} else {
			// compare both parts
			if (aResult instanceof LocalDate) {
				return SimpleComparisonResult.NOT_EQUAL;
			} else if (aResult instanceof LocalTime) {
				return SimpleComparisonResult.NOT_EQUAL;
			} else if (aResult instanceof LocalDateTime) {
				return SimpleComparisonResult
						.valueOf(((LocalDateTime) aResult).equals(((LocalDateTime) anExpectedResult)));
			} else if (aResult instanceof ZonedDateTime) {
				// In this case, we consider two times equal if they mark the same point in time, even though the zones
				// might differ
				return SimpleComparisonResult.valueOf(
						(((ZonedDateTime) aResult).toInstant()).equals(((ZonedDateTime) anExpectedResult).toInstant()));
			} else if (aResult instanceof Instant) {
				return SimpleComparisonResult.valueOf(((Instant) aResult).atZone(ZoneId.systemDefault())
						.equals(((Instant) anExpectedResult).atZone(ZoneId.systemDefault())));
			} else {
				throw new UnsupportedOperationException(
						"Cannot compare '" + aResult.getClass() + "' and '" + anExpectedResult.getClass() + "'");
			}
		}
	}

	/**
	 * Compare two objects. At this point it is expected that the previous stages have done all conversion work,
	 * iteration through arrays etc.
	 * 
	 * @param aResult
	 *            the result returned by the fixture
	 * @param anExpectedResult
	 *            the expected result as in the script, converted for comparison
	 * @param aRawExpectedResult
	 *            the raw expected result as in the script, before conversion
	 * @return true if equal, false otherwise
	 */
	protected ComparisonResult performEqualityCheckForObjects(Object aResult, Object anExpectedResult,
			Object aRawExpectedResult) {
		return SimpleComparisonResult.valueOf(anExpectedResult.equals(aResult));
	}
}
