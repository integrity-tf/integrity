package de.gebit.integrity.runner.callbacks;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;

/**
 * The {@link TestFormatter} is responsible for creating human-readable strings out of various test-related entities.
 * This is usually done by using the descriptions attached to fixtures.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestFormatter {

	/**
	 * Escape pattern for parameters in descriptions.
	 */
	private static final Pattern PARAMETER_PATTERN = Pattern.compile("^(.*)\\$(.*)\\$(.*)$");

	/**
	 * The classloader to use.
	 */
	@Inject
	private ClassLoader classLoader;

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
	 * The variable manager to use.
	 */
	@Inject
	private VariableManager variableManager;

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
	 */
	public String testToHumanReadableString(Test aTest,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(),
				parameterResolver.createParameterMap(aTest, true, anUnresolvableVariableHandlingPolicy),
				anUnresolvableVariableHandlingPolicy);
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
	 */
	public String tableTestRowToHumanReadableString(TableTest aTest, TableTestRow aRow,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(),
				parameterResolver.createParameterMap(aTest, aRow, true, anUnresolvableVariableHandlingPolicy),
				anUnresolvableVariableHandlingPolicy);
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
	 */
	public String tableTestToHumanReadableString(TableTest aTest,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return fixtureMethodToHumanReadableString(
				aTest.getDefinition().getFixtureMethod(),
				parameterResolver.createParameterMap(aTest.getParameters(), true, anUnresolvableVariableHandlingPolicy),
				anUnresolvableVariableHandlingPolicy);
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
	 */
	public String callToHumanReadableString(Call aCall,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return fixtureMethodToHumanReadableString(aCall.getDefinition().getFixtureMethod(),
				parameterResolver.createParameterMap(aCall, true, anUnresolvableVariableHandlingPolicy),
				anUnresolvableVariableHandlingPolicy);
	}

	/**
	 * Creates a human-readable string for a fixture method.
	 * 
	 * @param aFixtureMethod
	 *            the fixture method
	 * @param someParameters
	 *            a map of parameters used for the test
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the human-readable string
	 * @throws ClassNotFoundException
	 */
	public String fixtureMethodToHumanReadableString(MethodReference aFixtureMethod,
			Map<String, Object> someParameters, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException {
		String tempFixtureMethodName = aFixtureMethod.getMethod().getSimpleName();
		String tempFixtureClassName = aFixtureMethod.getType().getQualifiedName();
		Class<?> tempFixtureClass = classLoader.loadClass(tempFixtureClassName);
		Method tempMethod = FixtureWrapper.findFixtureMethodByName(tempFixtureClass, tempFixtureMethodName);
		if (tempMethod == null) {
			return null;
		}

		FixtureMethod tempAnnotation = tempMethod.getAnnotation(FixtureMethod.class);
		if (tempAnnotation == null) {
			return null;
		}

		String tempText = null;
		if (tempAnnotation.description() != null && tempAnnotation.description().length() > 0) {
			tempText = tempAnnotation.description();
		} else {
			tempText = tempFixtureMethodName;
		}

		Matcher tempMatcher = PARAMETER_PATTERN.matcher(tempText);
		while (tempMatcher.matches()) {
			// classloader and variable maps are not supplied here because the parameters are already expected to be
			// resolved
			String tempValue = valueConverter.convertValueToString(someParameters.get(tempMatcher.group(2)), false,
					anUnresolvableVariableHandlingPolicy);

			tempText = tempMatcher.group(1) + tempValue + tempMatcher.group(3);
			tempMatcher = PARAMETER_PATTERN.matcher(tempText);
		}

		return tempText;
	}
}
