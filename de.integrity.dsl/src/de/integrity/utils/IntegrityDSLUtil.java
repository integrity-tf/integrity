package de.integrity.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import de.integrity.dsl.ArbitraryParameterName;
import de.integrity.dsl.Call;
import de.integrity.dsl.FixedParameterName;
import de.integrity.dsl.MethodReference;
import de.integrity.dsl.PackageDefinition;
import de.integrity.dsl.Parameter;
import de.integrity.dsl.ParameterName;
import de.integrity.dsl.ParameterTableHeader;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.TableTest;
import de.integrity.dsl.TableTestRow;
import de.integrity.dsl.Test;
import de.integrity.dsl.ValueOrEnumValue;
import de.integrity.dsl.Variable;
import de.integrity.dsl.VariableEntity;
import de.integrity.fixtures.FixtureParameter;

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
			throw new UnsupportedOperationException("This subtype of ParameterName is not supported yet!");
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
		Map<String, Object> tempResult = new HashMap<String, Object>();
		for (Entry<ParameterName, ValueOrEnumValue> tempEntry : someParameters.entrySet()) {
			Object tempValue = tempEntry.getValue();
			if (tempValue instanceof Variable) {
				tempValue = aVariableMap.get(((Variable) tempValue).getName());
			}
			if (anIncludeArbitraryParametersFlag || !(tempEntry.getKey() instanceof ArbitraryParameterName)) {
				tempResult.put(IntegrityDSLUtil.getParamNameStringFromParameterName(tempEntry.getKey()), tempValue);
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

	// public static Set<VariableDefinition>
	// findVariableDefinitionsInPackages(Model aModel) {
	// Set<VariableDefinition> aDefinitionSet = new
	// HashSet<VariableDefinition>();
	// for (Statement tempStatement : aModel.getStatements()) {
	// if (tempStatement instanceof Suite) {
	// walkModelAndFindVariableDefinitionsInPackages(((Suite)
	// tempStatement).getName(), aDefinitionSet,
	// new HashSet<EObject>());
	// }
	// }
	//
	// return aDefinitionSet;
	// }
	//
	// private static void
	// walkModelAndFindVariableDefinitionsInPackages(SuiteDefinition aSuite,
	// Set<VariableDefinition> aDefinitionSet, Set<EObject>
	// aSetOfVisitedObjects) {
	// if (aSetOfVisitedObjects.contains(aSuite)) {
	// return;
	// }
	// aSetOfVisitedObjects.add(aSuite);
	//
	// // first check the package containing the current suite for variables
	// if (aSuite.eContainer() instanceof PackageDefinition) {
	// if (!aSetOfVisitedObjects.contains(aSuite.eContainer())) {
	// aSetOfVisitedObjects.add(aSuite.eContainer());
	// for (PackageStatement tempStatement : ((PackageDefinition)
	// aSuite.eContainer()).getStatements()) {
	// if (tempStatement instanceof VariableDefinition) {
	// aDefinitionSet.add((VariableDefinition) tempStatement);
	// }
	// }
	// }
	// }
	//
	// // then walk all statements in the suite to find links to other suites
	// // and follow those recursively
	// for (SuiteStatement tempStatement : aSuite.getStatements()) {
	// if (tempStatement instanceof Suite) {
	// if (!aSetOfVisitedObjects.contains(tempStatement)) {
	// aSetOfVisitedObjects.add(tempStatement);
	// walkModelAndFindVariableDefinitionsInPackages(((Suite)
	// tempStatement).getName(), aDefinitionSet,
	// aSetOfVisitedObjects);
	// }
	// }
	// }
	// }

}
