package de.integrity.utils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.integrity.dsl.Call;
import de.integrity.dsl.MethodReference;
import de.integrity.dsl.Parameter;
import de.integrity.dsl.Test;
import de.integrity.dsl.VariableEntity;
import de.integrity.fixtures.AbstractFixture;
import de.integrity.fixtures.FixtureMethod;

public class TestFormatter {

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
		return fixtureMethodToHumanReadableString(aTest.getDefinition().getFixtureMethod(), aTest.getParameters(),
				aVariableMap);
	}

	public String callToHumanReadableString(Call aCall, Map<VariableEntity, Object> aVariableMap)
			throws ClassNotFoundException {
		return fixtureMethodToHumanReadableString(aCall.getDefinition().getFixtureMethod(), aCall.getParameters(),
				aVariableMap);
	}

	public String fixtureMethodToHumanReadableString(MethodReference aFixtureMethod, EList<Parameter> aParamList,
			Map<VariableEntity, Object> aVariableMap) throws ClassNotFoundException {
		String tempFixtureMethodName = aFixtureMethod.getMethod().getSimpleName();
		String tempFixtureClassName = aFixtureMethod.getType().getQualifiedName();
		Class<?> tempFixtureClass = classloader.loadClass(tempFixtureClassName);
		Method tempMethod = AbstractFixture.findFixtureMethodByName(tempFixtureClass, tempFixtureMethodName);
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

		List<ParamAnnotationTuple> tempParams = IntegrityDSLUtil.getAllParamNamesFromFixtureMethod(aFixtureMethod);
		Map<String, Object> tempValues = IntegrityDSLUtil.createParameterMap(aParamList, aVariableMap);
		for (ParamAnnotationTuple tempParam : tempParams) {
			String tempValue = ParameterUtil.convertValueToString(tempValues.get(tempParam.getParamName()),
					aVariableMap);
			if (tempValue == null) {
				tempValue = "(null)";
			}
			tempText = tempText.replace("$" + tempParam.getParamName() + "$", tempValue);
		}

		return tempText;
	}
}
