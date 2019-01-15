/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.gebit.integrity.classloading.IntegrityClassLoader;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TimeDifference;
import de.gebit.integrity.dsl.TimeSet;
import de.gebit.integrity.dsl.VariableAssignment;
import de.gebit.integrity.exceptions.MethodNotFoundException;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.UnresolvableVariable;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.resolving.TableTestParameterResolveMethod;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * The {@link TestFormatter} is responsible for creating human-readable strings out of various test-related entities.
 * This is usually done by using the descriptions attached to fixtures.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestFormatter {

	/**
	 * Escape pattern for parameters in descriptions.
	 */
	private static final Pattern PARAMETER_PATTERN = Pattern.compile("^(.*?)\\$([^$]*)\\$(.*)$");

	/**
	 * Newline separator.
	 */
	protected static final String NEWLINE = System.getProperty("line.separator");

	/**
	 * The classloader to use.
	 */
	@Inject
	private IntegrityClassLoader classLoader;

	/**
	 * The value converter to use.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	private ParameterResolver parameterResolver;

	/**
	 * The conversion context provider.
	 */
	@Inject
	protected Provider<ConversionContext> conversionContextProvider;

	/**
	 * Creates a new instance.
	 * 
	 */
	public TestFormatter() {
		super();
	}

	/**
	 * Creates a human-readable string for a test.
	 * 
	 * @param aTest
	 *            the test
	 * @return the human-readable test description
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws MethodNotFoundException
	 */
	public String testToHumanReadableString(Test aTest, ConversionContext aConversionContext)
			throws ClassNotFoundException, UnexecutableException, InstantiationException, MethodNotFoundException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(), aTest, parameterResolver
				.createParameterMap(aTest, true, tempConversionContext.getUnresolvableVariableHandlingPolicy()),
				tempConversionContext);
	}

	/**
	 * Creates a human-readable string for a tabletest.
	 * 
	 * @param aTest
	 *            the test
	 * @param aRow
	 *            the row (may be null if the string shall be for the whole test)
	 * @return the human-readable description
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws MethodNotFoundException
	 */
	public String tableTestRowToHumanReadableString(TableTest aTest, TableTestRow aRow,
			ConversionContext aConversionContext)
			throws ClassNotFoundException, UnexecutableException, InstantiationException, MethodNotFoundException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(), aTest,
				parameterResolver.createParameterMap(aTest, aRow, TableTestParameterResolveMethod.COMBINED, true,
						tempConversionContext.getUnresolvableVariableHandlingPolicy()),
				tempConversionContext);
	}

	/**
	 * Creates a human-readable string for a tabletest.
	 * 
	 * @param aTest
	 *            the test
	 * @return the human-readable string
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws MethodNotFoundException
	 */
	public String tableTestToHumanReadableString(TableTest aTest, ConversionContext aConversionContext)
			throws ClassNotFoundException, UnexecutableException, InstantiationException, MethodNotFoundException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(), aTest,
				parameterResolver.createParameterMap(aTest.getParameters(), true,
						tempConversionContext.getUnresolvableVariableHandlingPolicy()),
				tempConversionContext);
	}

	/**
	 * Creates a human-readable string for a call.
	 * 
	 * @param aCall
	 *            the call
	 * @return the human-readable string
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws MethodNotFoundException
	 */
	public String callToHumanReadableString(Call aCall, ConversionContext aConversionContext)
			throws ClassNotFoundException, UnexecutableException, InstantiationException, MethodNotFoundException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		return fixtureMethodToHumanReadableString(aCall.getDefinition().getFixtureMethod(), aCall, parameterResolver
				.createParameterMap(aCall, true, tempConversionContext.getUnresolvableVariableHandlingPolicy()),
				tempConversionContext);
	}

	/**
	 * Creates a human-readable string for a variable assignment.
	 * 
	 * @param anAssignment
	 *            the assignment
	 * @param aConversionContext
	 * @return the human-readable string
	 */
	public String variableAssignmentToHumanReadableString(VariableAssignment anAssignment,
			ConversionContext aConversionContext) {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		String tempValueString = valueConverter.convertValueToString(anAssignment.getValue(), false,
				tempConversionContext);

		return "Assign new value '" + tempValueString + "' to variable '"
				+ IntegrityDSLUtil.getQualifiedVariableEntityName(anAssignment.getTarget().getName(), false) + "'";
	}

	/**
	 * Creates a human-readable string for a fixture method.
	 * 
	 * @param aFixtureMethod
	 *            the fixture method
	 * @param aStatement
	 *            the suite statement currently being executed, if known
	 * @param someParameters
	 *            a map of parameters used for the test
	 * @param aConversionContext
	 *            the conversion context to use for conversion of parameters, if necessary
	 * @return the human-readable string
	 * @throws ClassNotFoundException
	 * @throws MethodNotFoundException
	 */
	public String fixtureMethodToHumanReadableString(MethodReference aFixtureMethod,
			SuiteStatementWithResult aStatement, Map<String, Object> someParameters,
			ConversionContext aConversionContext) throws ClassNotFoundException, MethodNotFoundException {
		ConversionContext tempConversionContext = safeguardConversionContext(aConversionContext);

		Method tempMethod = classLoader.loadMethod(aFixtureMethod);

		FixtureMethod tempAnnotation = tempMethod.getAnnotation(FixtureMethod.class);
		if (tempAnnotation == null) {
			return null;
		}

		String tempText = null;
		// Prefer specific texts, if not possible prefer generic text, if not possible use fixture method name
		if (aStatement != null) {
			if ((aStatement instanceof Test) || (aStatement instanceof TableTest)) {
				tempText = tempAnnotation.descriptionTest();
			} else if (aStatement instanceof Call) {
				tempText = tempAnnotation.descriptionCall();
			}
		}
		if (tempText != null && tempText.length() == 0) {
			tempText = tempAnnotation.description();
		}
		if (tempText != null && tempText.length() == 0) {
			tempText = aFixtureMethod.getMethod().getSimpleName();
		}

		tempText = replaceConditionalTextBlocks(tempText, someParameters);

		tempText = replaceParameters(tempText, someParameters, tempConversionContext);

		return tempText;
	}

	/**
	 * Replaces all blocks of conditional text. The syntax for these looks like this:<<br>
	 * <br>
	 * {someParameterName?some conditional text} or {^someParameterName?some conditional text}<br>
	 * <br>
	 * The first statement prints 'some conditional text' if the parameter 'someParameterName' is set to a value. The
	 * latter prints the text if the parameter is NOT set to a value (negation of the first example).<br>
	 * <br>
	 * Parameters may be used in the text itself according to the {@link #PARAMETER_PATTERN}. Conditional statements may
	 * be nested.
	 * 
	 * @param anInput
	 *            the text to start with
	 * @param someParameters
	 *            the parameters
	 * @return the resulting text
	 */
	protected String replaceConditionalTextBlocks(String anInput, Map<String, Object> someParameters) {
		int tempStart = -1;
		int tempEnd = -1;
		int tempNestingCount = 0;
		for (int i = 0; i < anInput.length(); i++) {
			char tempChar = anInput.charAt(i);

			if (tempChar == '{') {
				if (tempStart == -1) {
					tempStart = i;
				} else {
					tempNestingCount++;
				}
			} else if (tempChar == '}') {
				if (tempNestingCount == 0) {
					tempEnd = i;
					break;
				} else {
					tempNestingCount--;
				}
			}
		}

		if (tempStart >= 0) {
			if (tempEnd >= 0) {
				String tempBlock = anInput.substring(tempStart + 1, tempEnd);
				int tempDivider = tempBlock.indexOf('?');

				if (tempDivider >= 0) {
					String tempParameterName = tempBlock.substring(0, tempDivider);
					String tempBlockText = tempBlock.substring(tempDivider + 1);

					boolean tempInversion = false;
					if (tempParameterName.startsWith("^")) {
						tempParameterName = tempParameterName.substring(1);
						tempInversion = true;
					}

					String tempPrefix = anInput.substring(0, tempStart);
					String tempSuffix = anInput.substring(tempEnd + 1);

					// Fix for issue #41: Conditional fixture description parts are not correctly chosen in some
					// situations
					boolean tempParameterConsideredPresent = false;
					if (someParameters.containsKey(tempParameterName)) {
						Object tempParameterValue = someParameters.get(tempParameterName);
						tempParameterConsideredPresent = tempParameterValue != null
								&& tempParameterValue != UnresolvableVariable.getInstance();
					}

					if ((!tempInversion && tempParameterConsideredPresent)
							|| (tempInversion && !tempParameterConsideredPresent)) {
						return replaceConditionalTextBlocks(tempPrefix + tempBlockText + tempSuffix, someParameters);
					} else {
						return replaceConditionalTextBlocks(tempPrefix + tempSuffix, someParameters);
					}
				}
			}
		}

		return anInput;
	}

	/**
	 * Replaces all parameters according to the {@link #PARAMETER_PATTERN} with their respective value.
	 * 
	 * @param anInput
	 *            the text to start with
	 * @param someParameters
	 *            the parameters
	 * @param aConversionContext
	 *            the conversion context to use for conversion of parameters, if necessary
	 * @return the resulting text
	 */
	protected String replaceParameters(String anInput, Map<String, Object> someParameters,
			ConversionContext aConversionContext) {
		String tempString = anInput;

		StringBuilder tempBuilder = new StringBuilder();

		Matcher tempMatcher = PARAMETER_PATTERN.matcher(tempString);
		while (tempMatcher.matches()) {
			// classloader and variable maps are not supplied here because the parameters are already expected to be
			// resolved
			Object tempValueBeforeConversion = someParameters.get(tempMatcher.group(2));
			String tempValue = null;
			if (tempValueBeforeConversion == null && aConversionContext
					.getUnresolvableVariableHandlingPolicy() == UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT) {
				// If the unresolvable variable handling policy requires question marks as a replacement, we'll assume
				// that's required for unresolvable parameters as well; this is typically required for tabletests.
				tempValue = UnresolvableVariable.getInstance().toString();
			} else {
				tempValue = valueConverter.convertValueToString(tempValueBeforeConversion, false, aConversionContext);
			}

			tempBuilder.append(tempMatcher.group(1));
			tempBuilder.append(tempValue);

			tempString = tempMatcher.group(3);
			tempMatcher = PARAMETER_PATTERN.matcher(tempString);
		}
		tempBuilder.append(tempString);

		return tempBuilder.toString();
	}

	/**
	 * This method creates a default conversion context in case none is provided, and returns the provided context
	 * otherwise.
	 * 
	 * @param aContext
	 *            the context to safeguard
	 * @return a context (guaranteed not to return null)
	 */
	public ConversionContext safeguardConversionContext(ConversionContext aContext) {
		if (aContext == null) {
			return conversionContextProvider.get();
		} else {
			return aContext;
		}
	}

	/**
	 * Converts a {@link TimeSet} command to a human-readable description.
	 * 
	 * @param aTimeSet
	 *            the timeset command to convert
	 * @param someForks
	 *            the forks onto which it is executed (null = master)
	 * @return
	 */
	public String timeSetToHumanReadableString(TimeSet aTimeSet, List<ForkDefinition> someForks) {
		String tempStartTime = aTimeSet.getStartTime() != null ? valueConverter.convertValueToString(
				aTimeSet.getStartTime(), false, new ConversionContext().withUnresolvableVariableHandlingPolicy(
						UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT))
				: null;
		String tempProgressionFactor = null;
		if (aTimeSet.getProgressionMode() != null) {
			BigDecimal tempFactor = DateUtil.convertTimeSetProgressionFactor(aTimeSet, valueConverter,
					new ConversionContext().withUnresolvableVariableHandlingPolicy(
							UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
			if (tempFactor != null) {
				tempProgressionFactor = tempFactor.toPlainString();
			} else {
				tempProgressionFactor = UnresolvableVariable.getInstance().toString();
			}
		}

		String tempForkNames = "";
		if (someForks != null && someForks.size() > 0) {
			tempForkNames = "on fork(s) "
					+ someForks.stream().map((aFork) -> "'" + (aFork != null ? aFork.getName() : "master") + "'")
							.collect(Collectors.joining(","))
					+ " ";
		} else {
			if (aTimeSet.getForks().size() > 0) {
				tempForkNames = "on the master process ";
			}
		}

		if (tempStartTime != null) {
			if (tempProgressionFactor != null) {
				return "Setting test time " + tempForkNames + "to " + tempStartTime + ", progressing with "
						+ tempProgressionFactor + "x speed";
			} else {
				return "Setting test time " + tempForkNames + "to " + tempStartTime;
			}
		} else if (aTimeSet.getDiffTime() != null) {
			String tempDiffTime = timeDifferenceToHumanReadableString(aTimeSet.getDiffTime());
			return "Moving test time " + tempForkNames
					+ ("-".equals(aTimeSet.getDiffTime().getDirection()) ? "backward " : "forward ") + "by "
					+ tempDiffTime;
		} else {
			if (tempProgressionFactor != null) {
				return "Setting test time " + tempForkNames + "to current system time, progressing with "
						+ tempProgressionFactor + "x speed";
			} else {
				return "Resetting test time override " + tempForkNames + "- normal system time is used again";
			}
		}
	}

	/**
	 * Converts a {@link TimeDifference} to a human-readable string.
	 * 
	 * @param aTimeDiff
	 *            the command to convert
	 * @return
	 */
	public String timeDifferenceToHumanReadableString(TimeDifference aTimeDiff) {
		if (aTimeDiff.getCalculatedValue() != null) {
			Long tempMillis = DateUtil.convertTimeDifference(aTimeDiff, valueConverter).get(0).getFirst();
			if (tempMillis != null) {
				return DateUtil.convertNanosecondTimespanToHumanReadableFormat(
						TimeUnit.MILLISECONDS.toNanos(tempMillis), false, false);
			} else {
				return UnresolvableVariable.getInstance().toString();
			}
		} else {
			return aTimeDiff.getFixedValues().stream().collect(Collectors.joining(" "));
		}
	}

	/**
	 * Converts a test time info entry to a human-readable string.
	 * 
	 * @param aTestTimeInfoEntry
	 * @param anOmitPrefixFlag
	 * @return
	 */
	public String testTimeInfoToHumanReadableString(Entry<String, Pair<ZonedDateTime, Double>> aTestTimeInfoEntry,
			boolean anIncludePrefixFlag) {
		StringBuilder tempBuilder = new StringBuilder();
		if (anIncludePrefixFlag) {
			if (aTestTimeInfoEntry.getKey() == null) {
				tempBuilder.append("On master, t");
			} else {
				tempBuilder.append("On fork'" + aTestTimeInfoEntry.getKey() + "', t");
			}
		} else {
			tempBuilder.append("T");
		}
		tempBuilder.append("he time is now ");
		tempBuilder.append(aTestTimeInfoEntry.getValue().getFirst().toOffsetDateTime());

		if (aTestTimeInfoEntry.getValue().getSecond() == 0.0) {
			tempBuilder.append(" (frozen)");
		} else if (aTestTimeInfoEntry.getValue().getSecond() == 1.0) {
			tempBuilder.append(" (progressing normally)");
		} else {
			tempBuilder.append(" (progressing at " + aTestTimeInfoEntry.getValue().getSecond() + "x)");
		}

		return tempBuilder.toString();
	}

	/**
	 * Converts a {@link Set} of test time info entries according to
	 * {@link #testTimeInfoToHumanReadableString(Entry, boolean)}.
	 * 
	 * @param aTestTimeInfoSet
	 * @return
	 */
	public String testTimeInfoSetToHumanReadableString(
			Set<Entry<String, Pair<ZonedDateTime, Double>>> aTestTimeInfoSet) {
		StringBuilder tempBuilder = new StringBuilder();

		if (aTestTimeInfoSet.size() == 1) {
			tempBuilder.append(testTimeInfoToHumanReadableString(aTestTimeInfoSet.iterator().next(), false));
		} else {
			tempBuilder.append("The test time on all processes is now:");
			List<Entry<String, Pair<ZonedDateTime, Double>>> tempSortedList = new ArrayList<Map.Entry<String, Pair<ZonedDateTime, Double>>>(
					aTestTimeInfoSet);
			Collections.sort(tempSortedList, new Comparator<Entry<String, Pair<ZonedDateTime, Double>>>() {

				@Override
				public int compare(Entry<String, Pair<ZonedDateTime, Double>> aFirst,
						Entry<String, Pair<ZonedDateTime, Double>> aSecond) {
					if (aFirst.getKey() == null) {
						return Integer.MIN_VALUE;
					} else if (aSecond.getKey() == null) {
						return Integer.MAX_VALUE;
					} else {
						return aFirst.getKey().compareTo(aSecond.getKey());
					}
				}
			});
			for (Entry<String, Pair<ZonedDateTime, Double>> tempEntry : tempSortedList) {
				tempBuilder.append(NEWLINE + " - " + testTimeInfoToHumanReadableString(tempEntry, true));
			}
		}

		return tempBuilder.toString();
	}
}
