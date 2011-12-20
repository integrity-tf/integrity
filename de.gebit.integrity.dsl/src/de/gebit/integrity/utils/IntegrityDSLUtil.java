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

/**
 * A utility class providing various helper functions.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public final class IntegrityDSLUtil {

	private IntegrityDSLUtil() {
		// nothing to do
	}

	/**
	 * Returns a list of all defined parameter names in a given fixture method, each of the results linked to the
	 * annotation reference that's connected to the parameter in the method signature.
	 * 
	 * @param aMethod
	 *            the method to inspect
	 * @return a list of parameters and annotation references
	 */
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

	/**
	 * Returns the name of a single parameter defined by a given annotation reference.
	 * 
	 * @param anAnnotation
	 *            the annotation reference
	 * @return the name
	 */
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

	/**
	 * Returns the name of a single given parameter defined by a {@link ParameterName} instance.
	 * 
	 * @param aParameterName
	 *            the parameter name instance
	 * @return the parameter name string
	 */
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

	/**
	 * Returns a list of all valid enumeration literals for a given parameter in a given fixture method.
	 * 
	 * @param aMethod
	 *            the fixture method reference
	 * @param aParamAnnotation
	 *            the parameter annotation reference
	 * @return a list of enumeration literals, or null if the parameter is not an enum parameter
	 */
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

	/**
	 * Returns a list of all valid enumeration literals that are defined in the given type reference.
	 * 
	 * @param aTypeRef
	 *            the type reference
	 * @return the enumeration literals, or none if the type reference doesn't refer to an enum type
	 */
	public static List<JvmEnumerationLiteral> getAllEnumLiteralsFromJvmTypeReference(JvmTypeReference aTypeRef) {
		JvmType tempType = aTypeRef.getType();

		if (tempType instanceof JvmEnumerationType) {
			JvmEnumerationType tempEnumType = (JvmEnumerationType) tempType;
			return tempEnumType.getLiterals();
		}

		return null;
	}

	/**
	 * Returns a list of named results defined by a given fixture method.
	 * 
	 * @param aMethod
	 *            the method
	 * @return the list of results
	 */
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

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given {@link Test} to determine the valid
	 * parameters. Parameters that contain references to variables will be resolved if the variable map is provided, but
	 * no type conversions will be done.
	 * 
	 * @param aTest
	 *            the test
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createParameterMap(aTest.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given {@link Call} to determine the valid
	 * parameters. Parameters that contain references to variables will be resolved if the variable map is provided, but
	 * no type conversions will be done.
	 * 
	 * @param aCall
	 *            the call
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(Call aCall, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createParameterMap(aCall.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given row of a {@link TableTest} to determine the
	 * valid parameters. Parameters that contain references to variables will be resolved if the variable map is
	 * provided, but no type conversions will be done.
	 * 
	 * @param aTableTest
	 *            the table test
	 * @param aTableTestRow
	 *            the row of the test
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @return a map with a String to value mapping
	 */
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

	/**
	 * Returns a map mapping a parameter name to a value, using a list of {@link Parameter} instances to determine the
	 * valid parameters. Parameters that contain references to variables will be resolved if the variable map is
	 * provided, but no type conversions will be done.
	 * 
	 * @param someParameters
	 *            the parameters
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(List<Parameter> someParameters,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag) {
		Map<ParameterName, ValueOrEnumValue> tempParameters = new LinkedHashMap<ParameterName, ValueOrEnumValue>();
		for (Parameter tempParameter : someParameters) {
			tempParameters.put(tempParameter.getName(), tempParameter.getValue());
		}

		return createParameterMap(tempParameters, aVariableMap, anIncludeArbitraryParametersFlag);
	}

	private static Map<String, Object> createParameterMap(Map<ParameterName, ValueOrEnumValue> someParameters,
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

	/**
	 * Returns the fully qualified name of the fixture method referenced by the given method reference.
	 * 
	 * @param aReference
	 *            the method reference
	 * @return the fully qualified name, including the name of the class and the method itself
	 */
	public static String getQualifiedNameOfFixtureMethod(MethodReference aReference) {
		String tempName = aReference.getMethod().getQualifiedName();
		return tempName.replace("." + aReference.getMethod().getSimpleName(), "#"
				+ aReference.getMethod().getSimpleName());
	}

	/**
	 * Returns the fully qualified name of a give {@link de.gebit.integrity.dsl.Suite}.
	 * 
	 * @param aSuite
	 *            the suite
	 * @return the fully qualified name
	 */
	public static String getQualifiedSuiteName(SuiteDefinition aSuite) {
		if (aSuite.eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aSuite.eContainer();
			return tempPackageDef.getName() + "." + aSuite.getName();
		} else {
			return aSuite.getName();
		}
	}

	/**
	 * Returns the fully qualified name of the given {@link VariableEntity}.
	 * 
	 * @param aVariable
	 *            the variable
	 * @return the fully qualified name
	 */
	public static String getQualifiedGlobalVariableName(VariableEntity aVariable) {
		if (aVariable.eContainer().eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aVariable.eContainer().eContainer();
			return tempPackageDef.getName() + "." + aVariable.getName();
		} else {
			return aVariable.getName();
		}
	}

	/**
	 * Returns a map of named results as expected by the given {@link Test}. The Map will connect result names to actual
	 * values, with variable references being resolved if a variable map is provided.
	 * 
	 * @param aTest
	 *            the test
	 * @param aVariableMap
	 *            the variable map containing all currently active variables and their values, or null if no resolution
	 *            shall be done
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary results shall be included
	 * @return a map of Strings to values
	 */
	public static Map<String, Object> createExpectedResultMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag) {
		return createExpectedResultMap(aTest.getResults(), aVariableMap, anIncludeArbitraryParametersFlag);
	}

	private static Map<String, Object> createExpectedResultMap(List<NamedTestResult> aTestResultList,
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

	/**
	 * Returns the name of a specific test result value.
	 * 
	 * @param aName
	 *            the result name object
	 * @return the name string
	 */
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
