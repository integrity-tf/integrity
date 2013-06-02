/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.comparator;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.DateUtil;
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

	@Override
	public boolean compareResult(Object aFixtureResult, ValueOrEnumValueOrOperationCollection anExpectedResult,
			FixtureWrapper<?> aFixtureInstance, MethodReference aFixtureMethod, String aPropertyName)
			throws ClassNotFoundException, UnexecutableException, InstantiationException {
		if (anExpectedResult != null) {
			if (aFixtureResult == null) {
				if (anExpectedResult.getMoreValues().size() > 0) {
					// if there's more than one value expected, this can never equal a single null value
					return false;
				} else {
					return (anExpectedResult.getValue() instanceof NullValue);
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
						tempConversionTargetType = aFixtureResult.getClass().isArray() ? aFixtureResult.getClass()
								.getComponentType() : aFixtureResult.getClass();
					}

					if (anExpectedResult.getMoreValues().size() > 0) {
						// multiple result values given -> we're going to put them into an array of the same type
						// as the fixture result
						Class<?> tempArrayType = (tempConversionTargetType == null) ? Object.class
								: tempConversionTargetType;
						tempConvertedResult = Array.newInstance(tempArrayType,
								anExpectedResult.getMoreValues().size() + 1);
						for (int i = 0; i < Array.getLength(tempConvertedResult); i++) {
							ValueOrEnumValueOrOperation tempSingleExpectedResult = (i == 0 ? anExpectedResult
									.getValue() : anExpectedResult.getMoreValues().get(i - 1));
							Array.set(tempConvertedResult, i, valueConverter.convertValue(tempConversionTargetType,
									tempSingleExpectedResult, UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
						}
					} else {
						tempConvertedResult = valueConverter.convertValue(tempConversionTargetType,
								anExpectedResult.getValue(), UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
					}

					return aFixtureInstance.performCustomComparation(tempConvertedResult, aFixtureResult,
							tempMethodName, aPropertyName);
				} else {
					// Standard comparation compares each value for itself in case of arrays
					if (anExpectedResult.getMoreValues().size() > 0) {
						// multiple result values were given -> fixture result must be an array of same size
						if (!(aFixtureResult.getClass().isArray() && Array.getLength(aFixtureResult) == anExpectedResult
								.getMoreValues().size() + 1)) {
							return false;
						}
						// now compare all values
						for (int i = 0; i < Array.getLength(aFixtureResult); i++) {
							Object tempSingleFixtureResult = Array.get(aFixtureResult, i);
							ValueOrEnumValueOrOperation tempSingleExpectedResult = (i == 0 ? anExpectedResult
									.getValue() : anExpectedResult.getMoreValues().get(i - 1));
							if (tempSingleFixtureResult == null) {
								// The fixture returned a null, we need to expect a null
								if (!(tempSingleExpectedResult instanceof NullValue)) {
									return false;
								}
							} else {
								Object tempConvertedExpectedResult;
								Object tempConvertedFixtureResult = tempSingleFixtureResult;

								if ((tempSingleExpectedResult instanceof NestedObject)
										&& !(tempSingleFixtureResult instanceof Map)) {
									// if the expected result is a nested object, and the fixture has NOT returned a
									// map, we assume
									// the fixture result to be a bean class/instance. We'll convert both to maps for
									// comparison!
									tempConvertedFixtureResult = valueConverter
											.convertValue(Map.class, tempSingleFixtureResult,
													UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
									tempConvertedExpectedResult = valueConverter.convertValue(Map.class,
											tempSingleExpectedResult,
											UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
								} else {
									// Convert the expected result to match the given fixture result
									tempConvertedExpectedResult = valueConverter.convertValue(
											tempSingleFixtureResult.getClass(), tempSingleExpectedResult,
											UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
								}

								if (!performEqualityCheck(tempConvertedFixtureResult, tempConvertedExpectedResult,
										tempSingleExpectedResult)) {
									return false;
								}
							}
						}
						return true;
					} else {
						// If we arrive here, the expected result is a simple, single value. But the fixture might still
						// return an array
						Object tempSingleFixtureResult = aFixtureResult;
						// if the expected type is an array, we don't want to convert to that array, but to the
						// component type, of course
						Class<?> tempConversionTargetType = tempSingleFixtureResult.getClass();
						if (tempSingleFixtureResult.getClass().isArray()) {
							tempConversionTargetType = tempSingleFixtureResult.getClass().getComponentType();
							if (tempConversionTargetType == Object.class) {
								// Object arrays are bad target types; in this case we try to deduct a target type from
								// the values within the array
								tempConversionTargetType = null;
								for (int i = 0; i < Array.getLength(tempSingleFixtureResult); i++) {
									Object tempArrayValue = Array.get(tempSingleFixtureResult, i);
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

						ValueOrEnumValueOrOperation tempSingleExpectedResult = anExpectedResult.getValue();

						Object tempConvertedExpectedResult;
						Object tempConvertedFixtureResult = tempSingleFixtureResult;

						if ((tempSingleExpectedResult instanceof NestedObject)
								&& !(tempSingleFixtureResult instanceof Map)) {
							// if the expected result is a nested object, and the fixture has NOT returned a
							// map, we assume
							// the fixture result to be a bean class/instance. We'll convert both to maps for
							// comparison!
							tempConvertedFixtureResult = valueConverter.convertValue(Map.class,
									tempSingleFixtureResult, UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
							tempConvertedExpectedResult = valueConverter.convertValue(Map.class,
									tempSingleExpectedResult, UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
						} else {
							// Convert the expected result to match the given fixture result
							tempConvertedExpectedResult = valueConverter.convertValue(tempConversionTargetType,
									tempSingleExpectedResult, UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
						}

						return performEqualityCheck(tempConvertedFixtureResult, tempConvertedExpectedResult,
								tempSingleExpectedResult);
					}
				}
			}
		} else {
			if (aFixtureInstance.isCustomComparatorFixture()) {
				return aFixtureInstance.performCustomComparation(null, aFixtureResult, aFixtureMethod.getMethod()
						.getSimpleName(), aPropertyName);
			} else {
				if (aFixtureResult instanceof Boolean) {
					return (Boolean) aFixtureResult;
				} else {
					throw new IllegalArgumentException(
							"If no expected test result is given and the fixture is not a CustomComparatorFixture, "
									+ "the test fixture must return a boolean result!");
				}
			}
		}
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
	protected boolean performEqualityCheck(Object aConvertedResult, Object aConvertedExpectedResult,
			ValueOrEnumValueOrOperation aRawExpectedResult) {
		if (aConvertedResult == null) {
			return (aConvertedExpectedResult == null || (aConvertedExpectedResult.getClass().isArray()
					&& Array.getLength(aConvertedExpectedResult) == 1 && Array.get(aConvertedExpectedResult, 0) == null));
		} else {
			if (aConvertedResult instanceof Date && aConvertedExpectedResult instanceof Date) {
				return performEqualityCheckForDates((Date) aConvertedResult, (Date) aConvertedExpectedResult,
						aRawExpectedResult);
			} else if (aConvertedResult instanceof Map && aConvertedExpectedResult instanceof Map) {
				return performEqualityCheckForMaps((Map<?, ?>) aConvertedResult, (Map<?, ?>) aConvertedExpectedResult,
						aRawExpectedResult);
			} else if (aConvertedResult.getClass().isArray()) {
				if (aConvertedExpectedResult == null) {
					// the fixture may still be returning an array that has to be unpacked
					if (Array.getLength(aConvertedResult) != 1) {
						return false;
					}
					return (Array.get(aConvertedResult, 0) == null);
				} else {
					if (!aConvertedExpectedResult.getClass().isArray()) {
						// the fixture may be returning an array that has to be unpacked
						if (Array.getLength(aConvertedResult) != 1) {
							return false;
						}
						return performEqualityCheck(Array.get(aConvertedResult, 0), aConvertedExpectedResult,
								aRawExpectedResult);
					} else {
						if (Array.getLength(aConvertedResult) != Array.getLength(aConvertedExpectedResult)) {
							return false;
						}
						// both are converted arrays -> compare all values!
						for (int i = 0; i < Array.getLength(aConvertedResult); i++) {
							if (!performEqualityCheck(Array.get(aConvertedResult, i),
									Array.get(aConvertedExpectedResult, i), aRawExpectedResult)) {
								return false;
							}
						}
						return true;
					}
				}
			} else {
				// This is the super-simple case where we basically have only one value to compare
				if (aConvertedExpectedResult == null) {
					// we have validated convertedResult to be non-null before
					return false;
				} else {
					if (aConvertedExpectedResult.getClass().isArray()) {
						// the converted result may still be an array
						if (Array.getLength(aConvertedExpectedResult) != 1) {
							return false;
						}
						return performEqualityCheck(aConvertedResult, Array.get(aConvertedExpectedResult, 0),
								aRawExpectedResult);
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
	 * found in the actual result (there may well be more keys in the actual result than expected!).
	 * 
	 * @param aResult
	 *            the result returned by the fixture
	 * @param anExpectedResult
	 *            the expected result as in the script, converted for comparison
	 * @param aRawExpectedResult
	 *            the raw expected result as in the script, before conversion
	 * @return true if equal, false otherwise
	 */
	protected boolean performEqualityCheckForMaps(Map<?, ?> aResult, Map<?, ?> anExpectedResult,
			Object aRawExpectedResult) {
		// maps are compared by exploring them
		for (Entry<?, ?> tempEntry : ((Map<?, ?>) anExpectedResult).entrySet()) {
			Object tempActualValue = ((Map<?, ?>) aResult).get(tempEntry.getKey());
			Object tempReferenceValue = tempEntry.getValue();

			// ...but we have to ensure both values are of equal type first, since even though both outer values
			// are maps, their inner values have not been necessarily converted to the same types
			Object tempConvertedReferenceValue = tempReferenceValue;
			try {
				tempConvertedReferenceValue = (tempActualValue != null) ? valueConverter.convertValue(
						tempActualValue.getClass(), tempReferenceValue,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE) : tempReferenceValue;
			} catch (UnresolvableVariableException exc) {
				exc.printStackTrace();
			} catch (UnexecutableException exc) {
				exc.printStackTrace();
			}

			if (!performEqualityCheck(
					tempActualValue,
					tempConvertedReferenceValue,
					(tempReferenceValue instanceof ValueOrEnumValueOrOperation) ? (ValueOrEnumValueOrOperation) tempReferenceValue
							: null)) {
				return false;
			}
		}

		return true;
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
	protected boolean performEqualityCheckForDates(Date aResult, Date anExpectedResult, Object aRawExpectedResult) {
		if (aRawExpectedResult instanceof DateValue) {
			// compare only the date part
			return DateUtil.stripTimeFromDate((Date) anExpectedResult).equals(
					DateUtil.stripTimeFromDate((Date) aResult));
		} else if (aRawExpectedResult instanceof TimeValue) {
			// compare only the time part
			return DateUtil.stripDateFromTime((Date) anExpectedResult).equals(
					DateUtil.stripDateFromTime((Date) aResult));
		} else {
			// compare both parts
			return anExpectedResult.equals(aResult);
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
	protected boolean performEqualityCheckForObjects(Object aResult, Object anExpectedResult, Object aRawExpectedResult) {
		return anExpectedResult.equals(aResult);
	}
}
