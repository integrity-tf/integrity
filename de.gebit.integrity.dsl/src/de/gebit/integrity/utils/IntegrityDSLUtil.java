/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultName;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;
import de.gebit.integrity.dsl.VisibleMultiLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineTitleComment;
import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.forker.ForkerParameter;

/**
 * A utility class providing various helper functions.
 * 
 * @author Rene Schneider - initial API and implementation
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
	public static List<ParamAnnotationTypeTriplet> getAllParamNamesFromFixtureMethod(MethodReference aMethod) {
		ArrayList<ParamAnnotationTypeTriplet> tempList = new ArrayList<ParamAnnotationTypeTriplet>();
		JvmOperation tempOperation = aMethod.getMethod();
		if (tempOperation != null) {
			for (JvmFormalParameter tempParam : tempOperation.getParameters()) {
				for (JvmAnnotationReference tempAnnotation : tempParam.getAnnotations()) {
					String tempParamName = getParamNameFromAnnotation(tempAnnotation);
					if (tempParamName != null) {
						tempList.add(new ParamAnnotationTypeTriplet(tempParamName, tempParam.getQualifiedName(),
								tempAnnotation, tempParam.getParameterType()));
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
			if (anAnnotation.getAnnotation().getQualifiedName().equals(FixtureParameter.class.getCanonicalName())
					|| anAnnotation.getAnnotation().getQualifiedName()
							.equals(ForkerParameter.class.getCanonicalName())) {
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
	 * Returns whether the mandatory flag is set defined by a given annotation reference.
	 * 
	 * @param anAnnotation
	 *            the annotation reference
	 * @return true if mandatory, false otherwise
	 */
	public static boolean getParamMandatoryFlagFromAnnotation(JvmAnnotationReference anAnnotation) {
		if (anAnnotation.getAnnotation() != null) {
			if (anAnnotation.getAnnotation().getQualifiedName().equals(FixtureParameter.class.getCanonicalName())) {
				for (JvmAnnotationValue tempValue : anAnnotation.getValues()) {
					if (tempValue instanceof JvmBooleanAnnotationValue
							&& "mandatory".equals(tempValue.getValueName())) {
						return ((JvmBooleanAnnotationValue) tempValue).getValues().get(0);
					}
				}
			}
		}

		throw new IllegalArgumentException(
				"Provided annotation reference did not contain mandatory information: " + anAnnotation.getAnnotation());
	}

	/**
	 * Returns a list of all defined parameter names in a given fork, each of the results linked to the annotation
	 * reference that's connected to the parameter in the constructor signature. Only one constructor is supported.
	 * 
	 * @param aFork
	 *            the fork to inspect
	 * @return a list of parameters and annotation references
	 */
	@SuppressWarnings("unchecked")
	public static List<ParamAnnotationTypeTriplet> getAllParamNamesFromFork(ForkDefinition aFork) {
		if (aFork.getBaseFork() != null) {
			return getAllParamNamesFromFork(aFork.getBaseFork());
		} else if (aFork.getForkerClass() != null) {
			return getAllParamNamesFromForkerClass((JvmGenericType) aFork.getForkerClass().getType());
		} else {
			return (List<ParamAnnotationTypeTriplet>) Collections.EMPTY_LIST;
		}
	}

	/**
	 * Returns a list of all defined parameter names in a given forker class, each of the results linked to the
	 * annotation reference that's connected to the parameter in the constructor signature. Only one constructor is
	 * supported.
	 * 
	 * @param aForkerType
	 *            the forker class to inspect
	 * @return a list of parameters and annotation references
	 */
	public static List<ParamAnnotationTypeTriplet> getAllParamNamesFromForkerClass(JvmGenericType aForkerType) {
		ArrayList<ParamAnnotationTypeTriplet> tempList = new ArrayList<ParamAnnotationTypeTriplet>();
		try {
			JvmConstructor tempConstructor = aForkerType.getDeclaredConstructors().iterator().next();
			if (tempConstructor != null) {
				for (JvmFormalParameter tempParam : tempConstructor.getParameters()) {
					for (JvmAnnotationReference tempAnnotation : tempParam.getAnnotations()) {
						String tempParamName = getParamNameFromAnnotation(tempAnnotation);
						if (tempParamName != null) {
							tempList.add(new ParamAnnotationTypeTriplet(tempParamName, tempParam.getQualifiedName(),
									tempAnnotation, tempParam.getParameterType()));
						}
					}
				}
			}
		} catch (NoSuchElementException exc) {
			// expected if no constructor is available
		}

		return tempList;
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
			return IntegrityDSLUtil
					.getIdentifierFromArbitraryParameterOrResultName((ArbitraryParameterOrResultName) aParameterName);
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
						return JavaTypeUtil.getAllEnumLiteralsFromJvmType(tempTypeRef.getType());
					}
				}
			}
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
						if (!"java.util.Map".equals(tempField.getType().getType().getQualifiedName())) {
							tempList.add(new ResultFieldTuple(tempField.getSimpleName(), tempField));
						}
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
	 * Returns the fully qualified name of the fixture method referenced by the given method reference.
	 * 
	 * @param aReference
	 *            the method reference
	 * @return the fully qualified name, including the name of the class and the method itself
	 */
	public static String getQualifiedNameOfFixtureMethod(MethodReference aReference) {
		String tempName = aReference.getMethod().getQualifiedName();
		return tempName.replace("." + aReference.getMethod().getSimpleName(),
				"#" + aReference.getMethod().getSimpleName());
	}

	/**
	 * Returns the fully qualified name of a given {@link SuiteDefinition}.
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
	 * Returns the fully qualified name of a given {@link VariantDefinition}.
	 * 
	 * @param aVariant
	 *            the variant
	 * @return the fully qualified name
	 */
	public static String getQualifiedVariantName(VariantDefinition aVariant) {
		if (aVariant.eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aVariant.eContainer();
			return tempPackageDef.getName() + "." + aVariant.getName();
		} else {
			return aVariant.getName();
		}
	}

	/**
	 * Returns the fully qualified name of a given {@link ForkDefinition}.
	 * 
	 * @param aFork
	 *            the fork
	 * @return the fully qualified name
	 */
	public static String getQualifiedForkName(ForkDefinition aFork) {
		if (aFork.eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aFork.eContainer();
			return tempPackageDef.getName() + "." + aFork.getName();
		} else {
			return aFork.getName();
		}
	}

	/**
	 * Returns the fully qualified name of a given {@link CallDefinition}.
	 * 
	 * @param aCall
	 *            the call definition
	 * @return the fully qualified name
	 */
	public static String getQualifiedCallName(CallDefinition aCall) {
		if (aCall.eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aCall.eContainer();
			return tempPackageDef.getName() + "." + aCall.getName();
		} else {
			return aCall.getName();
		}
	}

	/**
	 * Returns the fully qualified name of a given {@link TestDefinition}.
	 * 
	 * @param aTest
	 *            the test definition
	 * @return the fully qualified name
	 */
	public static String getQualifiedTestName(TestDefinition aTest) {
		if (aTest.eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aTest.eContainer();
			return tempPackageDef.getName() + "." + aTest.getName();
		} else {
			return aTest.getName();
		}
	}

	/**
	 * Returns the fully qualified name of the given {@link VariableOrConstantEntity}.
	 * 
	 * @param aVariable
	 *            the variable
	 * @return the fully qualified name
	 */
	public static String getQualifiedVariableEntityName(VariableOrConstantEntity aVariable,
			boolean aQualifyLocalVariables) {
		if (aVariable.eContainer().eContainer() instanceof PackageDefinition) {
			PackageDefinition tempPackageDef = (PackageDefinition) aVariable.eContainer().eContainer();
			return tempPackageDef.getName() + "." + aVariable.getName();
		} else {
			if (aQualifyLocalVariables && aVariable.eContainer().eContainer() instanceof SuiteDefinition) {
				// This covers both: variables defined in suites and suite parameters/returns (which are also variables)
				// We use the container of the variable to discern between these.
				String tempType = aVariable.eContainer().eClass().getName();
				SuiteDefinition tempSuiteDef = (SuiteDefinition) aVariable.eContainer().eContainer();
				return getQualifiedSuiteName(tempSuiteDef) + "$" + tempType + "$" + aVariable.getName();
			} else {
				return aVariable.getName();
			}
		}
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
			return IntegrityDSLUtil
					.getIdentifierFromArbitraryParameterOrResultName((ArbitraryParameterOrResultName) aName);
		} else {
			throw new UnsupportedOperationException(
					"This subtype of TestResultName (" + aName.getClass().getName() + ") is not supported yet!");
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
		int tempCharsToTrim = 0;
		if (tempString.startsWith("--- ")) {
			tempCharsToTrim = 4;
		} else if (tempString.startsWith("-- ")) {
			tempCharsToTrim = 3;
		}

		if (tempCharsToTrim > 0) {
			if (tempString.length() > tempCharsToTrim) {
				return tempString.substring(tempCharsToTrim);
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
		int tempCharsToTrimStart = 0;
		int tempCharsToTrimEnd = 0;

		if (tempString.startsWith("/--") && tempString.endsWith("--/")) {
			tempCharsToTrimStart = 4;
			tempCharsToTrimEnd = 3;
		} else if (tempString.startsWith("/- ") && tempString.endsWith("-/")) {
			tempCharsToTrimStart = 3;
			tempCharsToTrimEnd = 2;
		}

		if (tempCharsToTrimStart > 0) {
			StringBuilder tempBuilder = new StringBuilder();
			boolean tempSpaceWasAdded = false;
			for (int i = tempCharsToTrimStart; i < tempString.length() - tempCharsToTrimEnd; i++) {
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

			return tempBuilder.toString().trim();
		}

		throw new IllegalArgumentException(
				"The given multi-line comment does not start and end with the expected literals.");
	}

	/**
	 * Gets the suites' title from a given suite.
	 * 
	 * @param aSuite
	 *            the suite to search in
	 * @return the title of the suite or null if it does not have one
	 */
	public static String getSuiteTitle(SuiteDefinition aSuite) {
		if (aSuite.getStatements().size() == 0) {
			return null;
		}

		SuiteStatement tempFirstStatement = aSuite.getStatements().get(0);
		if (tempFirstStatement instanceof VisibleSingleLineTitleComment) {
			return cleanSingleLineComment(((VisibleSingleLineTitleComment) tempFirstStatement));
		}
		return null;
	}

	/**
	 * Determines whether a given {@link EObject} is part of a result of a test/call/tabletest.
	 * 
	 * @param anObject
	 *            the object to look at
	 * @return true if it is a result, false if not. Null if not determinable.
	 */
	public static Boolean isResult(EObject anObject) {
		if (anObject instanceof ValueOrEnumValueOrOperationCollection) {
			ValueOrEnumValueOrOperationCollection tempCollection = (ValueOrEnumValueOrOperationCollection) anObject;
			if (tempCollection.eContainer() instanceof Test) {
				return ((Test) tempCollection.eContainer()).getResult() == tempCollection;
			} else if (tempCollection.eContainer() instanceof Suite) {
				return false;
			} else if (tempCollection.eContainer() instanceof NamedResult) {
				NamedResult tempResult = (NamedResult) tempCollection.eContainer();
				if (tempResult.eContainer() instanceof Test || tempResult.eContainer() instanceof TableTest) {
					return true;
				}
			} else if (tempCollection.eContainer() instanceof ParameterTableValue) {
				ParameterTableValue tempParameter = (ParameterTableValue) tempCollection.eContainer();
				TableTestRow tempRow = (TableTestRow) tempParameter.eContainer();
				int tempColumnNumber = tempRow.getValues().indexOf(tempParameter);
				if (tempColumnNumber >= 0) {
					TableTest tempTest = (TableTest) tempRow.eContainer();
					return (tempColumnNumber >= tempTest.getParameterHeaders().size());
				}
			} else if (tempCollection.eContainer() instanceof Parameter) {
				Parameter tempParameter = (Parameter) tempCollection.eContainer();
				if (tempParameter.eContainer() instanceof Test || tempParameter.eContainer() instanceof Call
						|| tempParameter.eContainer() instanceof TableTest) {
					return false;
				}
			}
		} else if (anObject instanceof Call) {
			return ((Call) anObject).getResult() == anObject;
		} else if (anObject instanceof NamedCallResult) {
			return true;
		} else if (anObject instanceof SuiteParameter) {
			return false;
		}

		if (anObject != null && !(anObject instanceof SuiteDefinition)) {
			return isResult(anObject.eContainer());
		} else {
			return null;
		}
	}

	/**
	 * Finds the corresponding table header element to a given table cell element.
	 * 
	 * @param aTableCell
	 *            the table cell element
	 * @return the table header element if one exists, the table itself in case of the default result column or null if
	 *         nothing was found
	 */
	public static EObject getTableHeaderForTableCell(ParameterTableValue aTableCell) {
		int tempColumn = ((TableTestRow) aTableCell.eContainer()).getValues().indexOf(aTableCell);

		if (tempColumn >= 0) {
			TableTestRow tempRow = (TableTestRow) aTableCell.eContainer();
			TableTest tempTest = (TableTest) tempRow.eContainer();
			if (tempColumn < tempTest.getParameterHeaders().size()) {
				return tempTest.getParameterHeaders().get(tempColumn);
			} else {
				// we might be in the range of the result columns
				int tempResultColumn = tempColumn - tempTest.getParameterHeaders().size();
				boolean tempDefaultResultExists = tempTest.getDefaultResultColumn() != null;
				if (tempResultColumn >= 0
						&& tempResultColumn < tempTest.getResultHeaders().size() + (tempDefaultResultExists ? 1 : 0)) {

					if (tempResultColumn < tempTest.getResultHeaders().size()) {
						return tempTest.getResultHeaders().get(tempResultColumn);
					} else if (tempResultColumn == tempTest.getResultHeaders().size()) {
						return tempTest;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Returns a map of all {@link ParameterTableHeader}s in a given {@link TableTest} with their associated
	 * {@link ParameterTableValue}s.
	 * 
	 * @param aTableTest
	 *            the table test to map
	 * @return all parameter columns with their associated values
	 */
	public static Map<ParameterTableHeader, List<ParameterTableValue>> getTableParameterValuesPerParameter(
			TableTest aTableTest) {
		Map<ParameterTableHeader, List<ParameterTableValue>> tempMap
				= new HashMap<>(aTableTest.getParameterHeaders().size());

		for (ParameterTableHeader tempHeader : aTableTest.getParameterHeaders()) {
			List<ParameterTableValue> tempValues = new ArrayList<>(aTableTest.getRows().size());
			int tempColumnNumber = tempMap.size(); // consecutive parameter columns make this possible

			for (TableTestRow tempRow : aTableTest.getRows()) {
				tempValues.add(tempRow.getValues().get(tempColumnNumber));
			}

			tempMap.put(tempHeader, tempValues);
		}

		return tempMap;
	}

	/**
	 * Finds the matching method reference for a given {@link Test}, {@link Call} or {@link TableTest}.
	 * 
	 * @param anAction
	 *            the action to find a method for
	 * @return the method or null if none was found
	 */
	public static MethodReference getMethodReferenceForAction(EObject anAction) {
		if (anAction instanceof Test) {
			TestDefinition tempDefinition = ((Test) anAction).getDefinition();
			if (tempDefinition != null) {
				return tempDefinition.getFixtureMethod();
			}
		} else if (anAction instanceof Call) {
			CallDefinition tempDefinition = ((Call) anAction).getDefinition();
			if (tempDefinition != null) {
				return tempDefinition.getFixtureMethod();
			}
		} else if (anAction instanceof TableTest) {
			TestDefinition tempDefinition = ((TableTest) anAction).getDefinition();
			if (tempDefinition != null) {
				return tempDefinition.getFixtureMethod();
			}
		}

		return null;
	}

	/**
	 * Determines the initial value to use for the given {@link VariableOrConstantEntity}.
	 * 
	 * @param anEntity
	 *            the entity to explore
	 * @param aVariant
	 *            the current variant being executed (null if no variant is used)
	 * @return the initial value, or null if none was given
	 */
	public static ValueOrEnumValueOrOperationCollection getInitialValueForVariableOrConstantEntity(
			VariableOrConstantEntity anEntity, VariantDefinition aVariant) {
		ensureResolved(anEntity);

		EObject tempDefiningStatement = anEntity.eContainer();
		if (tempDefiningStatement instanceof VariableDefinition) {
			return ((VariableDefinition) tempDefiningStatement).getInitialValue();
		} else if (tempDefiningStatement instanceof ConstantDefinition) {
			return getInitialValueForConstant((ConstantDefinition) tempDefiningStatement, aVariant);
		}

		throw new ThisShouldNeverHappenException();
	}

	/**
	 * Determines the initial value for the given constant.
	 * 
	 * @param aConstant
	 *            the constant to explore
	 * @param aVariant
	 *            the current variant being executed (null if no variant is used)
	 * @return the initial value, or null if none was given
	 */
	public static ValueOrEnumValueOrOperationCollection getInitialValueForConstant(ConstantDefinition aConstant,
			VariantDefinition aVariant) {
		ValueOrEnumValueOrOperationCollection tempValue = aConstant.getValue();
		if (aVariant != null) {
			outer: for (VariantValue tempVariantValue : aConstant.getVariantValues()) {
				for (VariantDefinition tempDefinition : tempVariantValue.getNames()) {
					if (tempDefinition == aVariant) {
						tempValue = tempVariantValue.getValue();
						break outer;
					}
				}
			}
		}

		return tempValue;
	}

	/**
	 * Aggregates all {@link ValueOrEnumValueOrOperation}s from the given
	 * {@link ValueOrEnumValueOrOperationCollection}.<br/>
	 * Integrity has (historically; could be done more elegant with todays' Xtext) splitted
	 * {@link ValueOrEnumValueOrOperationCollection}s' internal values into two properties: a single value comes from
	 * {@link ValueOrEnumValueOrOperationCollection#getValue()} and everything else goes into
	 * {@link ValueOrEnumValueOrOperationCollection#getMoreValues()}. This method helps handling these by merging all
	 * the values into a single {@link Collection}.
	 * 
	 * @param aValueCollection
	 *            the value collection to aggregate single values from
	 * @return all the aggregated values in a single {@link Collection}.
	 */
	public static Collection<ValueOrEnumValueOrOperation> getAllValuesFromCollection(
			ValueOrEnumValueOrOperationCollection aValueCollection) {
		Collection<ValueOrEnumValueOrOperation> tempResult
				= new ArrayList<>(aValueCollection.getMoreValues().size() + 1);
		tempResult.add(aValueCollection.getValue());
		tempResult.addAll(aValueCollection.getMoreValues());
		return tempResult;
	}

	/**
	 * Gets a specific index position out of a {@link ValueOrEnumValueOrOperationCollection}.
	 * 
	 * @param aValueCollection
	 *            the value collection
	 * @param anIndex
	 *            the index to get
	 * @return the value
	 */
	public static ValueOrEnumValueOrOperation getSpecificValueFromCollection(
			ValueOrEnumValueOrOperationCollection aValueCollection, int anIndex) {
		return (anIndex == 0) ? aValueCollection.getValue() : aValueCollection.getMoreValues().get(anIndex - 1);
	}

	/**
	 * Checks whether the given variable/constant entity is defined in a global (package) context.
	 * 
	 * @param anEntity
	 *            the entity to check
	 * @return true if globally defined, false if defined in a suite
	 */
	public static boolean isGlobalVariableOrConstant(VariableOrConstantEntity anEntity) {
		return (anEntity.eContainer().eContainer() instanceof PackageDefinition);
	}

	/**
	 * Finds an upstream container matching a provided container class.
	 * 
	 * @param aContainerClass
	 *            the class to find
	 * @param aSource
	 *            the starting point for the search
	 * @return the upstream container, or null if nothing was found
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T findUpstreamContainer(Class<T> aContainerClass, EObject aSource) {
		EObject tempParent = aSource;

		while (tempParent != null && !aContainerClass.isAssignableFrom(tempParent.getClass())) {
			tempParent = tempParent.eContainer();
		}

		return (T) tempParent;
	}

	/**
	 * Finds the {@link PackageDefinition} that contains the given {@link EObject}.
	 * 
	 * @param anObject
	 *            the entity
	 * @return the package containing the entity, or null if the entity is not in a package
	 */
	public static PackageDefinition getPackageContaining(EObject anObject) {
		return findUpstreamContainer(PackageDefinition.class, anObject);
	}

	/**
	 * Finds the {@link SuiteDefinition} that contains the given {@link EObject}.
	 * 
	 * @param anObject
	 *            the entity
	 * @return the suite containing the entity, or null if the entity is not in a package
	 */
	public static SuiteDefinition getSuiteContaining(EObject anObject) {
		return findUpstreamContainer(SuiteDefinition.class, anObject);
	}

	/**
	 * {@link KeyValuePair}s can be identified either by a free-form String (enclosed in quotes) or by a more restricted
	 * ID (without quotes). This method abstracts aways the decision where to get the final identifier from.
	 * 
	 * @param aPair
	 *            the key-value pair
	 * @return the identifier
	 */
	public static String getIdentifierFromKeyValuePair(KeyValuePair aPair) {
		return aPair.getIdentifier() != null ? aPair.getIdentifier() : aPair.getStringIdentifier();
	}

	/**
	 * {@link ArbitraryParameterOrResultName}s can be identified either by a free-form String (enclosed in quotes) or by
	 * a more restricted ID (without quotes). This method abstracts aways the decision where to get the final identifier
	 * from.
	 * 
	 * @param aName
	 *            the name
	 * @return the identifier
	 */
	public static String getIdentifierFromArbitraryParameterOrResultName(ArbitraryParameterOrResultName aName) {
		return aName.getIdentifier() != null ? aName.getIdentifier() : aName.getStringIdentifier();
	}

	/**
	 * Checks whether the given {@link EObject} is of private visibility.
	 * 
	 * @param anObject
	 *            the object to check
	 * @return true or false (will return false on objects which don't support a visibility modifier)
	 */
	public static boolean isPrivate(EObject anObject) {
		if (anObject instanceof VariableDefinition) {
			return ((VariableDefinition) anObject).getPrivate() != null;
		} else if (anObject instanceof ConstantDefinition) {
			return ((ConstantDefinition) anObject).getPrivate() != null;
		} else if (anObject instanceof SuiteDefinition) {
			return ((SuiteDefinition) anObject).getPrivate() != null;
		} else if (anObject instanceof ForkDefinition) {
			return ((ForkDefinition) anObject).getPrivate() != null;
		}

		return false;
	}

	/**
	 * Checks whether the given {@link EObject} is located inside a suite and is thus of private visibility by default.
	 * 
	 * @param anObject
	 * @return
	 */
	public static boolean isPrivateInsideSuite(EObject anObject) {
		if (anObject instanceof VariableDefinition) {
			return (anObject.eContainer() instanceof SuiteDefinition);
		} else if (anObject instanceof ConstantDefinition) {
			return (anObject.eContainer() instanceof SuiteDefinition);
		}

		return false;
	}

	/**
	 * Attempts to extract a {@link VariableOrConstantEntity} from the provided {@link ValueOrEnumValueOrOperation}.
	 * 
	 * @param anInput
	 *            the input value
	 * @return the entity if one is found, null if the input value was something else
	 */
	public static VariableOrConstantEntity extractVariableOrConstantEntity(ValueOrEnumValueOrOperation anInput) {
		if (anInput instanceof VariableOrConstantEntity) {
			return (VariableOrConstantEntity) anInput;
		} else if (anInput instanceof Variable) {
			return ((Variable) anInput).getName();
		} else if (anInput instanceof Constant) {
			return ((Constant) anInput).getName();
		}

		return null;
	}

	/**
	 * Ensures that a given EObject that is possibly a proxy is resolved, resolving it if necessary.
	 * 
	 * @param anObject
	 */
	public static void ensureResolved(EObject anObject) {
		if (anObject.eIsProxy()) {
			EcoreUtil.resolve(anObject, anObject.eResource());
		}
	}

}
