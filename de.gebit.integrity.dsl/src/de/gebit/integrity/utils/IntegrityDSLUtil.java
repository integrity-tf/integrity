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

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ResultName;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VisibleMultiLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineComment;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * A utility class providing various helper functions.
 * 
 * @author Rene Schneider
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
		if (anAnnotation.getAnnotation() != null) {
			if (anAnnotation.getAnnotation().getQualifiedName().equals(FixtureParameter.class.getCanonicalName())) {
				for (JvmAnnotationValue tempValue : anAnnotation.getValues()) {
					if (tempValue instanceof JvmStringAnnotationValue && "name".equals(tempValue.getValueName())) {
						return ((JvmStringAnnotationValue) tempValue).getValues().get(0);
					}
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
		} else if (aParameterName instanceof ArbitraryParameterOrResultName) {
			return ((ArbitraryParameterOrResultName) aParameterName).getIdentifier();
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
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag, boolean aLeaveUnresolvableVariableReferencesIntact) {
		return createParameterMap(aTest.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag,
				aLeaveUnresolvableVariableReferencesIntact);
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
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(Call aCall, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag, boolean aLeaveUnresolvableVariableReferencesIntact) {
		return createParameterMap(aCall.getParameters(), aVariableMap, anIncludeArbitraryParametersFlag,
				aLeaveUnresolvableVariableReferencesIntact);
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
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(TableTest aTableTest, TableTestRow aTableTestRow,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag,
			boolean aLeaveUnresolvableVariableReferencesIntact) {
		LinkedHashMap<ParameterName, ValueOrEnumValueCollection> tempParameterMap = new LinkedHashMap<ParameterName, ValueOrEnumValueCollection>();
		for (Parameter tempParameter : aTableTest.getParameters()) {
			tempParameterMap.put(tempParameter.getName(), tempParameter.getValue());
		}

		int tempCount = 0;
		for (ParameterTableHeader tempParameterHeader : aTableTest.getParameterHeaders()) {
			tempParameterMap.put(tempParameterHeader.getName(), (aTableTestRow == null || tempCount >= aTableTestRow
					.getValues().size()) ? null : aTableTestRow.getValues().get(tempCount).getValue());
			tempCount++;
		}

		return createParameterMap(tempParameterMap, aVariableMap, anIncludeArbitraryParametersFlag,
				aLeaveUnresolvableVariableReferencesIntact);
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
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 */
	public static Map<String, Object> createParameterMap(List<Parameter> someParameters,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryParametersFlag,
			boolean aLeaveUnresolvableVariableReferencesIntact) {
		Map<ParameterName, ValueOrEnumValueCollection> tempParameters = new LinkedHashMap<ParameterName, ValueOrEnumValueCollection>();
		for (Parameter tempParameter : someParameters) {
			tempParameters.put(tempParameter.getName(), tempParameter.getValue());
		}

		return createParameterMap(tempParameters, aVariableMap, anIncludeArbitraryParametersFlag,
				aLeaveUnresolvableVariableReferencesIntact);
	}

	private static Map<String, Object> createParameterMap(
			Map<ParameterName, ValueOrEnumValueCollection> someParameters, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryParametersFlag, boolean aLeaveUnresolvableVariableReferencesIntact) {
		Map<String, Object> tempResult = new LinkedHashMap<String, Object>();
		for (Entry<ParameterName, ValueOrEnumValueCollection> tempEntry : someParameters.entrySet()) {
			if (tempEntry.getKey() != null) {
				Object tempValue = null;
				if (tempEntry.getValue().getMoreValues().size() > 0) {
					// if multiple values have been provided
					Object[] tempValueArray = new Object[tempEntry.getValue().getMoreValues().size() + 1];
					tempValueArray[0] = tempEntry.getValue().getValue();
					int i = 1;
					for (ValueOrEnumValue tempSingleValue : tempEntry.getValue().getMoreValues()) {
						tempValue = tempSingleValue;
						if (tempSingleValue instanceof Variable) {
							Object tempResolvedValue = (aVariableMap != null ? aVariableMap
									.get(((Variable) tempSingleValue).getName()) : null);
							if (tempResolvedValue != null || !aLeaveUnresolvableVariableReferencesIntact) {
								tempValue = tempResolvedValue;
							}
						}
						tempValueArray[i++] = tempValue;
					}
					tempValue = tempValueArray;
				} else {
					// if only one value has been provided
					tempValue = tempEntry.getValue().getValue();
					if (tempValue instanceof Variable) {
						Object tempResolvedValue = (aVariableMap != null ? aVariableMap.get(((Variable) tempValue)
								.getName()) : null);
						if (tempResolvedValue != null || !aLeaveUnresolvableVariableReferencesIntact) {
							tempValue = tempResolvedValue;
						}
					}
				}
				if (anIncludeArbitraryParametersFlag || !(tempEntry.getKey() instanceof ArbitraryParameterOrResultName)) {
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
	public static String getQualifiedVariableEntityName(VariableEntity aVariable, boolean aQualifyLocalVariables) {
		if (aVariable.eContainer().eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aVariable.eContainer().eContainer();
			return tempPackageDef.getName() + "." + aVariable.getName();
		} else {
			if (aQualifyLocalVariables && aVariable.eContainer().eContainer() instanceof SuiteDefinition) {
				SuiteDefinition tempSuiteDef = (SuiteDefinition) aVariable.eContainer().eContainer();
				return getQualifiedSuiteName(tempSuiteDef) + "." + aVariable.getName();
			} else {
				return aVariable.getName();
			}
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
	 * @param anIncludeArbitraryResultFlag
	 *            whether arbitrary results shall be included
	 * @return a map of Strings to values
	 */
	public static Map<String, Object> createExpectedResultMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryResultFlag) {
		return createExpectedResultMap(aTest.getResults(), aVariableMap, anIncludeArbitraryResultFlag);
	}

	private static Map<String, Object> createExpectedResultMap(List<NamedResult> aTestResultList,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryResultFlag) {
		Map<String, Object> tempResultMap = new LinkedHashMap<String, Object>();
		for (NamedResult tempEntry : aTestResultList) {
			if (tempEntry.getName() != null && tempEntry.getValue() != null) {
				Object tempValue = tempEntry.getValue();
				if (tempValue instanceof Variable) {
					if (aVariableMap != null) {
						tempValue = aVariableMap.get(((Variable) tempValue).getName());
					} else {
						tempValue = null;
					}
				}
				if (anIncludeArbitraryResultFlag || !(tempEntry.getName() instanceof ArbitraryParameterOrResultName)) {
					tempResultMap.put(getExpectedResultNameStringFromTestResultName(tempEntry.getName()),
							tempEntry.getValue());
				}
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
	public static String getExpectedResultNameStringFromTestResultName(ResultName aName) {
		if (aName instanceof FixedResultName) {
			return ((FixedResultName) aName).getField().getSimpleName();
		} else if (aName instanceof ArbitraryParameterOrResultName) {
			return ((ArbitraryParameterOrResultName) aName).getIdentifier();
		} else {
			throw new UnsupportedOperationException("This subtype of TestResultName (" + aName.getClass().getName()
					+ ") is not supported yet!");
		}
	}

	/**
	 * Removes the prefix as well as any trailing newlines from visible single-line comment text.
	 * 
	 * @param aComment
	 *            the comment
	 * @return the cleaned text
	 */
	public static String cleanSingleLineComment(VisibleSingleLineComment aComment) {
		String tempString = aComment.getContent().trim();
		if (tempString.startsWith("--")) {
			if (tempString.length() > 2) {
				return tempString.substring(2);
			} else {
				return "";
			}
		}

		throw new IllegalArgumentException("The given single-line comment does not start with the expected literal.");
	}

	/**
	 * Removes prefix and suffix from visible single-line comment text, as well as any newlines in between.
	 * 
	 * @param aComment
	 *            the comment
	 * @return the cleaned text
	 */
	public static String cleanMultiLineComment(VisibleMultiLineComment aComment) {
		String tempString = aComment.getContent().trim();
		if (tempString.startsWith("/-") && tempString.endsWith("-/")) {
			StringBuilder tempBuilder = new StringBuilder();
			boolean tempSpaceWasAdded = false;
			for (int i = 2; i < tempString.length() - 2; i++) {
				char tempChar = tempString.charAt(i);
				if (!Character.isWhitespace(tempChar)) {
					tempSpaceWasAdded = false;
					tempBuilder.append(tempChar);
				} else {
					if (!tempSpaceWasAdded) {
						tempBuilder.append(' ');
						tempSpaceWasAdded = true;
					}
				}
			}

			return tempBuilder.toString();
		}

		throw new IllegalArgumentException(
				"The given multi-line comment does not start and end with the expected literals.");
	}

	/**
	 * Resolves a variable (recursively, if necessary) to its actual value. Since this static method doesn't have access
	 * to the actual variable store of a test runner instance, the resolving can only be successful in cases of
	 * variables with initial value (giving that value) or constants.
	 * 
	 * @param aVariable
	 *            the variable to resolve
	 * @return the result, or null if none was found
	 */
	public static Object resolveVariableStatically(Variable aVariable) {
		Value tempValue = null;

		if (aVariable.getName() != null) {
			if (aVariable.getName().eContainer() instanceof VariableDefinition) {
				VariableDefinition tempDefinition = (VariableDefinition) aVariable.getName().eContainer();
				tempValue = tempDefinition.getInitialValue();
			} else if (aVariable.getName().eContainer() instanceof ConstantDefinition) {
				ConstantDefinition tempDefinition = (ConstantDefinition) aVariable.getName().eContainer();
				tempValue = tempDefinition.getValue();
			}
		}

		if (tempValue != null && tempValue instanceof Variable) {
			return resolveVariableStatically(aVariable);
		} else {
			return tempValue;
		}
	}
}
