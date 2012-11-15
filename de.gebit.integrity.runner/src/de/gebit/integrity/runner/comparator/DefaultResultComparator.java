/**
 * 
 */
package de.gebit.integrity.runner.comparator;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.DateUtil;

/**
 * The standard result comparator component.
 * 
 * @author Rene Schneider
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
			FixtureWrapper<?> aFixtureInstance, MethodReference aFixtureMethod) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
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
					Object tempConvertedResult;
					Class<?> tempConversionTargetType = aFixtureResult.getClass().isArray() ? aFixtureResult.getClass()
							.getComponentType() : aFixtureResult.getClass();
					if (anExpectedResult.getMoreValues().size() > 0) {
						// multiple result values given -> we're going to put them into an array of the same type
						// as the fixture result
						tempConvertedResult = Array.newInstance(tempConversionTargetType, anExpectedResult
								.getMoreValues().size() + 1);
						for (int i = 0; i < Array.getLength(tempConvertedResult); i++) {
							ValueOrEnumValueOrOperation tempSingleExpectedResult = (i == 0 ? anExpectedResult
									.getValue() : anExpectedResult.getMoreValues().get(i - 1));
							Array.set(tempConvertedResult, i, valueConverter.convertEncapsulatedValueToParamType(
									tempConversionTargetType, tempSingleExpectedResult,
									UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
						}
					} else {
						tempConvertedResult = valueConverter.convertEncapsulatedValueToParamType(
								tempConversionTargetType, anExpectedResult.getValue(),
								UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
					}

					return aFixtureInstance.performCustomComparation(tempConvertedResult, aFixtureResult,
							aFixtureMethod.getMethod().getSimpleName());
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
								Object tempConvertedExpectedResult = valueConverter
										.convertEncapsulatedValueToParamType(tempSingleFixtureResult.getClass(),
												tempSingleExpectedResult,
												UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

								if (!performEqualityCheck(tempSingleFixtureResult, tempConvertedExpectedResult,
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
						Class<?> tempConversionTargetType = tempSingleFixtureResult.getClass().isArray() ? tempSingleFixtureResult
								.getClass().getComponentType() : tempSingleFixtureResult.getClass();

						ValueOrEnumValueOrOperation tempSingleExpectedResult = anExpectedResult.getValue();
						Object tempConvertedExpectedResult = valueConverter.convertEncapsulatedValueToParamType(
								tempConversionTargetType, tempSingleExpectedResult,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

						return performEqualityCheck(tempSingleFixtureResult, tempConvertedExpectedResult,
								tempSingleExpectedResult);
					}
				}
			}
		} else {
			if (aFixtureInstance.isCustomComparatorFixture()) {
				return aFixtureInstance.performCustomComparation(null, aFixtureResult, aFixtureMethod.getMethod()
						.getSimpleName());
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
				if (aRawExpectedResult instanceof DateValue) {
					// compare only the date part
					return DateUtil.stripTimeFromDate((Date) aConvertedExpectedResult).equals(
							DateUtil.stripTimeFromDate((Date) aConvertedResult));
				} else if (aRawExpectedResult instanceof TimeValue) {
					// compare only the time part
					return DateUtil.stripDateFromTime((Date) aConvertedExpectedResult).equals(
							DateUtil.stripDateFromTime((Date) aConvertedResult));
				} else {
					// compare both parts
					return aConvertedExpectedResult.equals(aConvertedResult);
				}
			} else if (aConvertedResult instanceof Map && aConvertedExpectedResult instanceof Map) {
				// maps are compared by exploring them
				for (Entry<?, ?> tempEntry : ((Map<?, ?>) aConvertedResult).entrySet()) {
					Object tempReferenceValue = ((Map<?, ?>) aConvertedExpectedResult).get(tempEntry.getKey());
					if (!performEqualityCheck(tempEntry.getValue(), tempReferenceValue, null)) {
						return false;
					}
				}

				return true;
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
							if (!performEqualityCheck(Array.get(aConvertedExpectedResult, i),
									Array.get(aConvertedResult, i), aRawExpectedResult)) {
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
						return aConvertedExpectedResult.equals(aConvertedResult);
					}
				}
			}
		}
	}

}
