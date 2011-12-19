package de.integrity.utils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.integrity.dsl.Call;
import de.integrity.dsl.MethodReference;
import de.integrity.dsl.TableTest;
import de.integrity.dsl.TableTestRow;
import de.integrity.dsl.Test;
import de.integrity.dsl.VariableEntity;
import de.integrity.fixtures.Fixture;
import de.integrity.fixtures.FixtureMethod;

public class TestFormatter {

	private static final Pattern PARAMETER_PATTERN = Pattern.compile("^(.*)\\$(.*)\\$(.*)$");

	ClassLoader classloader = getClass().getClassLoader();

	public TestFormatter(ClassLoader classloader) {
		super();
		this.classloader = classloader;
	}

	public void setClassloader(ClassLoader aClassloader) {
		classloader = aClassloader;
	}

	public String testToHumanReadableString(Test aTest, Map<VariableEntity, Object> aVariableMap)
			throws ClassNotFoundException {
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(),
				IntegrityDSLUtil.createParameterMap(aTest, aVariableMap, true), false);
	}

	public String tableTestRowToHumanReadableString(TableTest aTest, TableTestRow aRow,
			Map<VariableEntity, Object> aVariableMap) throws ClassNotFoundException {
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(),
				IntegrityDSLUtil.createParameterMap(aTest, aRow, aVariableMap, true), false);
	}

	public String tableTestToHumanReadableString(TableTest aTest, Map<VariableEntity, Object> aVariableMap)
			throws ClassNotFoundException {
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(),
				IntegrityDSLUtil.createParameterMap(aTest.getParameters(), aVariableMap, true), true);
	}

	public String callToHumanReadableString(Call aCall, Map<VariableEntity, Object> aVariableMap)
			throws ClassNotFoundException {
		return fixtureMethodToHumanReadableString(aCall.getDefinition().getFixtureMethod(),
				IntegrityDSLUtil.createParameterMap(aCall, aVariableMap, true), false);
	}

	public String fixtureMethodToHumanReadableString(MethodReference aFixtureMethod,
			Map<String, Object> someParameters, boolean anExpectUnspecifiedParametersFlag)
			throws ClassNotFoundException {
		String tempFixtureMethodName = aFixtureMethod.getMethod().getSimpleName();
		String tempFixtureClassName = aFixtureMethod.getType().getQualifiedName();
		Class<?> tempFixtureClass = classloader.loadClass(tempFixtureClassName);
		Method tempMethod = Fixture.findFixtureMethodByName(tempFixtureClass, tempFixtureMethodName);
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
			String tempValue = ParameterUtil.convertValueToString(someParameters.get(tempMatcher.group(2)), null,
					anExpectUnspecifiedParametersFlag);
			if (tempValue == null) {
				tempValue = "???";
			}

			tempText = tempMatcher.group(1) + tempValue + tempMatcher.group(3);
			tempMatcher = PARAMETER_PATTERN.matcher(tempText);
		}

		return tempText;
	}
}
