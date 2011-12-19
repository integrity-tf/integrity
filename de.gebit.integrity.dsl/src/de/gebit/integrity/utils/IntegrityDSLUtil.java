package de.gebit.integrity.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import de.gebit.integrity.dsl.ArbitraryParameterName;
import de.gebit.integrity.dsl.ArbitraryTestResultName;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedTestResultName;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedTestResult;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestResultName;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.fixtures.FixtureParameter;

public class IntegrityDSLUtil {

	public static List<ParamAnnotationTuple> getAllParamNamesFromFixtureMethod(MethodReference aMethod) {
		ArrayList<ParamAnnotationTuple> tempList = new ArrayList<ParamAnnotationTuple>();
		JvmOperation tempOperation = aMethod.getMethod();
		if (tempOperation != null) {
			for (JvmFormalParameter tempParam : tempOperation.getParameters()) {
				for (JvmAnnotationReference tempAnnotation : tempParam.getAnnotations()) {
					String tempParamName = getParamNameFromAnnotation(tempAnnotation);
					if (tempParamName != null) {
						tempList.add(new ParamAnnotationTuple(tempParamName, tempParam.getQualifiedName(),
								tempAnnotation));
					}
				}
			}
		}

		return tempList;
	}

	public static String getParamNameFromAnnotation(JvmAnnotationReference anAnnotation) {
		if (anAnnotation.getAnnotation().getQualifiedName().equals(FixtureParameter.class.getCanonicalName())) {
			for (JvmAnnotationValue tempValue : anAnnotation.getValues()) {
				if (tempValue instanceof JvmStringAnnotationValue && "name".equals(tempValue.getValueName())) {
					return ((JvmStringAnnotationValue) tempValue).getValues().get(0);
				}
			}
		}

		return null;
	}

	public static String getParamNameStringFromParameterName(ParameterName aParameterName) {
		if (aParameterName instanceof FixedParameterName) {
			return getParamNameFromAnnotation(((FixedParameterName) aParameterName).getAnnotation());
		} else if (aParameterName instanceof ArbitraryParameterName) {
			return ((ArbitraryParameterName) aParameterName).getIdentifier();
		} else {
			throw new UnsupportedOperationException("This subtype of ParameterName ("
					+ aParameterName.getClass().toString() + ") is not supported yet!");
		}
	}

	public static List<JvmEnumerationLiteral> getAllEnumLiteralsFromFixtureMethodParam(MethodReference aMethod,
			JvmAnnotationReference aParamAnnotation) {
		JvmOperation tempOperation = aMethod.getMethod();
		if (tempOperation != null) {
			for (JvmFormalParameter tempParam : tempOperation.getParameters()) {
				for (JvmAnnotationReference tempAnnotation : tempParam.getAnnotations()) {
					if (aParamAnnotation == tempAnnotation) {
						JvmTypeReference tempTypeRef = tempParam.getParameterType();
						return getAllEnumLiteralsFromJvmTypeReference(tempTypeRef);
					}
				}
			}
		}

		return null;
	}

	public static List<JvmEnumerationLiteral> getAllEnumLiteralsFromJvmTypeReference(JvmTypeReference aTypeRef) {
		JvmType tempType = aTypeRef.getType();

		if (tempType instanceof JvmEnumerationType) {
			JvmEnumerationType tempEnumType = (JvmEnumerationType) tempType;
			return tempEnumType.getLiterals();
		}

		return null;
	}

	public static List<ResultFieldTuple> getAllResultNamesFromFixtureMethod(MethodReference aMethod) {
		ArrayList<ResultFieldTuple> tempList = new ArrayList<ResultFieldTuple>();

		JvmOperation tempOperation = aMethod.getMethod();
		if (tempOperation != null) {
			JvmTypeReference tempReturnType = tempOperation.getReturnType();
			if ((tempReturnType.getType() instanceof JvmGenericType)
					&& !tempReturnType.getType().getQualifiedName().startsWith("java.")
					&& ((JvmGenericType) tempReturnType.getType()).isInstantiateable()) {
				JvmGenericType tempTypeInFocus = (JvmGenericType) tempReturnType.getType();

				while (tempTypeInFocus != null) {
					for (JvmField tempField : tempTypeInFocus.getDeclaredFields()) {
						tempList.add(new ResultFieldTuple(tempField.getSimpleName(), tempField));
					}

					JvmGenericType tempOldType = tempTypeInFocus;
					tempTypeInFocus = null;
					for (JvmTypeReference tempSuperType : tempOldType.getSuperTypes()) {
						if ((tempSuperType.getType() instanceof JvmGenericType)
								&& !((JvmGenericType) tempSuperType.getType()).isInterface()) {
							tempTypeInFocus = (JvmGenericType) tempSuperType.getType();
							break;
						}
					}
				}
			}
		}

		return tempList;
	}

	public static Map<String, Object> createParameterMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createParameterMap(aTest.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	public static Map<String, Object> createParameterMap(Call aCall, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createParameterMap(aCall.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	public static Map<String, Object> createParameterMap(TableTest aTableTest, TableTestRow aTableTestRow,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag) {
		LinkedHashMap<ParameterName, ValueOrEnumValue> tempParameterMap = new LinkedHashMap<ParameterName, ValueOrEnumValue>();
		for (Parameter tempParameter : aTableTest.getParameters()) {
			tempParameterMap.put(tempParameter.getName(), tempParameter.getValue());
		}

		int tempCount = 0;
		for (ParameterTableHeader tempParameterHeader : aTableTest.getHeaders()) {
			tempParameterMap.put(tempParameterHeader.getName(), (tempCount >= aTableTestRow.getValues().size()) ? null
					: aTableTestRow.getValues().get(tempCount).getValue());
			tempCount++;
		}

		return createParameterMap(tempParameterMap, aVariableMap, anIncludeArbitraryParametersFlag);
	}

	public static Map<String, Object> createParameterMap(List<Parameter> someParameters,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag) {
		Map<ParameterName, ValueOrEnumValue> tempParameters = new LinkedHashMap<ParameterName, ValueOrEnumValue>();
		for (Parameter tempParameter : someParameters) {
			tempParameters.put(tempParameter.getName(), tempParameter.getValue());
		}

		return createParameterMap(tempParameters, aVariableMap, anIncludeArbitraryParametersFlag);
	}

	public static Map<String, Object> createParameterMap(Map<ParameterName, ValueOrEnumValue> someParameters,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag) {
		Map<String, Object> tempResult = new LinkedHashMap<String, Object>();
		for (Entry<ParameterName, ValueOrEnumValue> tempEntry : someParameters.entrySet()) {
			if (tempEntry.getKey() != null) {
				Object tempValue = tempEntry.getValue();
				if (tempValue instanceof Variable) {
					if (aVariableMap != null) {
						tempValue = aVariableMap.get(((Variable) tempValue).getName());
					} else {
						tempValue = null;
					}
				}
				if (anIncludeArbitraryParametersFlag || !(tempEntry.getKey() instanceof ArbitraryParameterName)) {
					tempResult.put(IntegrityDSLUtil.getParamNameStringFromParameterName(tempEntry.getKey()), tempValue);
				}
			}
		}

		return tempResult;
	}

	public static String getQualifiedNameOfFixtureMethod(MethodReference aReference) {
		String name = aReference.getMethod().getQualifiedName();
		return name.replace("." + aReference.getMethod().getSimpleName(), "#" + aReference.getMethod().getSimpleName());
	}

	public static String getQualifiedSuiteName(SuiteDefinition aSuite) {
		if (aSuite.eContainer() instanceof PackageDefinition) {
			PackageDefinition packageDef = (PackageDefinition) aSuite.eContainer();
			return packageDef.getName() + "." + aSuite.getName();
		} else {
			return aSuite.getName();
		}
	}

	public static String getQualifiedGlobalVariableName(VariableEntity aVariable) {
		if (aVariable.eContainer().eContainer() instanceof PackageDefinition) {
			PackageDefinition packageDef = (PackageDefinition) aVariable.eContainer().eContainer();
			return packageDef.getName() + "." + aVariable.getName();
		} else {
			return aVariable.getName();
		}
	}

	public static Map<String, Object> createExpectedResultMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createExpectedResultMap(aTest.getResults(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	public static Map<String, Object> createExpectedResultMap(List<NamedTestResult> aTestResultList,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag) {
		Map<String, Object> tempResultMap = new LinkedHashMap<String, Object>();
		for (NamedTestResult tempEntry : aTestResultList) {
			Object tempValue = tempEntry.getValue();
			if (tempValue instanceof Variable) {
				if (aVariableMap != null) {
					tempValue = aVariableMap.get(((Variable) tempValue).getName());
				} else {
					tempValue = null;
				}
			}
			if (anIncludeArbitraryParametersFlag || !(tempEntry.getName() instanceof ArbitraryTestResultName)) {
				tempResultMap.put(getExpectedResultNameStringFromTestResultName(tempEntry.getName()),
						tempEntry.getValue());
			}
		}

		return tempResultMap;
	}

	public static String getExpectedResultNameStringFromTestResultName(TestResultName aName) {
		if (aName instanceof FixedTestResultName) {
			return ((FixedTestResultName) aName).getField().getSimpleName();
		} else if (aName instanceof ArbitraryTestResultName) {
			return ((ArbitraryTestResultName) aName).getIdentifier();
		} else {
			throw new UnsupportedOperationException("This subtype of TestResultName (" + aName.getClass().getName()
					+ ") is not supported yet!");
		}
	}

}
