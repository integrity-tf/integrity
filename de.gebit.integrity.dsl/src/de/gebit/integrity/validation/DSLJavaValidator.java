/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.validation;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static java.util.Collections.emptySet;

import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.validation.Check;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import de.gebit.integrity.annotation.FixtureParameterAssessment;
import de.gebit.integrity.annotation.JvmFixtureEvaluation;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * These validators perform some more extensive validation on parts of the syntax tree.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG MethodLength
public class DSLJavaValidator extends AbstractDSLJavaValidator {

	/** Evaluates JvmFixtures and provides tooling for handling the abstract types. */
	@Inject
	private JvmFixtureEvaluation evaluator;
	/** Polymorphical dispatches calls to _checkParameter" methods. */
	private PolymorphicDispatcher<Void> checkParameterDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_checkParameter", this);

	/**
	 * Checks whether a given {@link DateValue} is actually correct (finds errors like days which don't exist in the
	 * given month).
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfDatesAreValid(DateValue aValue) {
		try {
			DateUtil.convertDateValue(aValue);
		} catch (ParseException exc) {
			error("The date entered is not valid!", null);
		}
	}

	/**
	 * Checks whether a given {@link TimeValue} is actually correct.
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfTimesAreValid(TimeValue aValue) {
		try {
			DateUtil.convertTimeValue(aValue);
		} catch (ParseException exc) {
			error("The time entered is not valid!", null);
		}
	}

	/**
	 * Checks whether a given {@link DateAndTimeValue} is actually correct.
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfDateAndTimesAreValid(DateAndTimeValue aValue) {
		try {
			DateUtil.convertDateAndTimeValue(aValue);
		} catch (ParseException exc) {
			error("The date and/or time entered is not valid!", null);
		}
	}

	/**
	 * Checks whether a variable definition contains dots, which would be illegal (issue #10).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfVariableDefinitionsAreValid(VariableDefinition anEntity) {
		if (anEntity.getName() != null && anEntity.getName().getName() != null) {
			String tempVariableName = anEntity.getName().getName();
			EStructuralFeature tempFeature = anEntity.eClass()
					.getEStructuralFeature(DslPackage.VARIABLE_DEFINITION__NAME);

			performDotCheck(tempVariableName, "variable", tempFeature);

			performSuiteParameterShadowingCheck(tempVariableName, anEntity.eContainer(), "variable", tempFeature);
		}
	}

	/**
	 * Checks whether a constant definition contains dots, which would be illegal (issue #171).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfConstantDefinitionsAreValid(ConstantDefinition anEntity) {
		if (anEntity.getName() != null) {
			String tempConstantName = anEntity.getName().getName();
			EStructuralFeature tempFeature = anEntity.eClass()
					.getEStructuralFeature(DslPackage.VARIABLE_DEFINITION__NAME);

			performDotCheck(tempConstantName, "constant", tempFeature);

			performSuiteParameterShadowingCheck(tempConstantName, anEntity.eContainer(), "constant", tempFeature);
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfForkDefinitionsAreValid(ForkDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "fork",
					anEntity.eClass().getEStructuralFeature(DslPackage.FORK_DEFINITION__NAME));
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfVariantDefinitionsAreValid(VariantDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "variant",
					anEntity.eClass().getEStructuralFeature(DslPackage.VARIANT_DEFINITION__NAME));
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfSuiteDefinitionsAreValid(SuiteDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "suite",
					anEntity.eClass().getEStructuralFeature(DslPackage.SUITE_DEFINITION__NAME));
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfOperationDefinitionsAreValid(OperationDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "operation",
					anEntity.eClass().getEStructuralFeature(DslPackage.OPERATION_DEFINITION__NAME));
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfCallDefinitionsAreValid(CallDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "call",
					anEntity.eClass().getEStructuralFeature(DslPackage.CALL_DEFINITION__NAME));
		}
	}

	/**
	 * Checks whether a definition contains dots, which would be illegal (issue #174).
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkIfTestDefinitionsAreValid(TestDefinition anEntity) {
		if (anEntity.getName() != null) {
			performDotCheck(anEntity.getName(), "test",
					anEntity.eClass().getEStructuralFeature(DslPackage.TEST_DEFINITION__NAME));
		}
	}

	/**
	 * A generic dot-checking method for entity names. Generates a nice error message.
	 * 
	 * @param aName
	 * @param anEntity
	 */
	protected void performDotCheck(String aName, String anEntity) {
		performDotCheck(aName, anEntity, null);
	}

	/**
	 * A generic dot-checking method for entity names. Generates a nice error message.
	 * 
	 * @param aName
	 * @param anEntityType
	 */
	protected void performDotCheck(String aName, String anEntityType, EStructuralFeature aStructuralFeature) {
		if (aName != null) {
			if (aName.contains(".")) {
				error(anEntityType.substring(0, 1).toUpperCase() + anEntityType.substring(1)
						+ " definitions must not be fully or partly qualified (= contain dots). " + "Please put the "
						+ anEntityType + " in the according packagedef to qualify it, or use some other "
						+ "character in place of the dot!", aStructuralFeature);
			}
		}
	}

	/**
	 * Checks for variable entities that overshadow suite input or return parameters.
	 * 
	 * @param aName
	 * @param aContainer
	 * @param anEntityType
	 * @param aStructuralFeature
	 */
	protected void performSuiteParameterShadowingCheck(String aName, EObject aContainer, String anEntityType,
			EStructuralFeature aStructuralFeature) {
		if (aContainer instanceof SuiteDefinition) {
			SuiteDefinition tempSuite = (SuiteDefinition) aContainer;
			for (SuiteReturnDefinition tempReturn : tempSuite.getReturn()) {
				if (tempReturn.getName() != null && aName.equals(tempReturn.getName().getName())) {
					error(anEntityType.substring(0, 1).toUpperCase() + anEntityType.substring(1)
							+ " definitions within suites must not overshadow suite return "
							+ "variables. The 'returns' declaration already declares a variable named '" + aName
							+ "', it is thus not necessary to create a variable of the same name to hold "
							+ "the value to return.", aStructuralFeature);
				}
			}

			for (SuiteParameterDefinition tempParameter : tempSuite.getParameters()) {
				if (tempParameter.getName() != null && aName.equals(tempParameter.getName().getName())) {
					error(anEntityType.substring(0, 1).toUpperCase() + anEntityType.substring(1)
							+ " definitions within suites must not overshadow suite input "
							+ "parameters. There is already a suite input parameter named '" + aName + "'.",
							aStructuralFeature);
				}
			}
		}
	}

	/**
	 * Checks whether a parameterized constant is defined in a package scope. It is not supported currently within
	 * suites.
	 * 
	 * @param aConstant
	 */
	@Check
	public void checkIfConstantParameterizationIsPossible(ConstantDefinition aConstant) {
		if (aConstant.getParameterized() != null) {
			if (!(aConstant.eContainer() instanceof PackageDefinition)) {
				error("Parameterized constants are only allowed in the scope of a package, not within suites", null);
			}
		}
	}

	/**
	 * Checks for redundant private modifier.
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkForPrivateVariableInSuite(VariableDefinition anEntity) {
		if (anEntity.getPrivate() != null && (anEntity.eContainer() instanceof SuiteDefinition)) {
			warning("Redundant visibility modifier: variable definitions inside suites are always 'private'",
					DslPackage.Literals.VARIABLE_DEFINITION__PRIVATE);
		}
	}

	/**
	 * Checks for redundant private modifier.
	 * 
	 * @param anEntity
	 */
	@Check
	public void checkForPrivateConstantInSuite(ConstantDefinition anEntity) {
		if (anEntity.getPrivate() != null && (anEntity.eContainer() instanceof SuiteDefinition)) {
			warning("Redundant visibility modifier: constant definitions inside suites are always 'private'",
					DslPackage.Literals.CONSTANT_DEFINITION__PRIVATE);
		}
	}

	/**
	 * Checks for redundant suite inline statements.
	 * 
	 * @param aSuiteStatement
	 */
	@Check
	public void checkSuiteStatement(Suite aSuiteStatement) {
		if (aSuiteStatement.getInlined() != null && aSuiteStatement.getDefinition().getInlined() != null) {
			warning("Redundant inline statement: the invoked suite is already defined as 'inlined'",
					DslPackage.Literals.SUITE__INLINED);
		}
	}

	/**
	 * Checks for missing parameters.
	 * 
	 * @param aCall
	 *            Call to be verified.
	 */
	@Check
	public void checkParameter(SuiteStatementWithResult aCall) {
		checkParameterDispatcher.invoke(aCall);
	}

	/** Polymorphic Dispatch of {@link #checkParameter(Call)}. */
	protected void _checkParameter(Call aCall) {
		Set<String> tempMandatoryParameter = getMandatoryParameterNamesOf(aCall.getDefinition().getFixtureMethod());
		Set<String> tempSpecifiedParameter = Sets.newHashSet(transform(aCall.getParameters(), FUNC_PARAMETER_NAME));
		checkForMissingParameter(tempMandatoryParameter, tempSpecifiedParameter);
		checkForNonNullableParameter(aCall.getDefinition().getFixtureMethod(), aCall.getParameters());
	}

	/** Polymorphic Dispatch of {@link #checkParameter(Call)}. */
	protected void _checkParameter(Test aTest) {
		Set<String> tempMandatoryParameter = getMandatoryParameterNamesOf(aTest.getDefinition().getFixtureMethod());
		Set<String> tempSpecifiedParameter = Sets.newHashSet(transform(aTest.getParameters(), FUNC_PARAMETER_NAME));
		checkForMissingParameter(tempMandatoryParameter, tempSpecifiedParameter);
		checkForNonNullableParameter(aTest.getDefinition().getFixtureMethod(), aTest.getParameters());
	}

	/** Polymorphic Dispatch of {@link #checkParameter(Call)}. */
	protected void _checkParameter(TableTest aTableTest) {
		Set<String> tempMandatoryParameter = getMandatoryParameterNamesOf(
				aTableTest.getDefinition().getFixtureMethod());
		Set<String> tempSpecifiedParameter = Sets
				.newHashSet(transform(aTableTest.getParameters(), FUNC_PARAMETER_NAME));
		Iterables.addAll(tempSpecifiedParameter,
				transform(aTableTest.getParameterHeaders(), FUNC_PARAMETER_HEADER_NAME));

		checkForMissingParameter(tempMandatoryParameter, tempSpecifiedParameter);
		Set<String> tempNonNullableParameterNames = checkForNonNullableParameter(
				aTableTest.getDefinition().getFixtureMethod(), aTableTest.getParameters());

		if (tempNonNullableParameterNames != null) {
			Map<ParameterTableHeader, List<ParameterTableValue>> tempMap = IntegrityDSLUtil
					.getTableParameterValuesPerParameter(aTableTest);
			for (Entry<ParameterTableHeader, List<ParameterTableValue>> tempColumn : tempMap.entrySet()) {
				if (tempNonNullableParameterNames.contains(
						IntegrityDSLUtil.getParamNameStringFromParameterName(tempColumn.getKey().getName()))) {
					for (ParameterTableValue tempValue : tempColumn.getValue()) {
						ensureParameterIsNotNullValue(tempValue, tempValue.getValue());
					}
				}
			}
		}
	}

	/** Polymorphic Dispatch Default Case of {@link #checkParameter(Call)}. */
	protected void _checkParameter(SuiteStatementWithResult aCall) { /* Does nothing. */
	}

	/**
	 * Checks for duplicate parameters.
	 * 
	 * @param aParameter
	 *            the parameter to be checked
	 */
	@Check
	protected void checkParameter(Parameter aParameter) {
		EObject tempContainer = aParameter.eContainer();

		List<Parameter> tempParameters = null;

		if (tempContainer instanceof Test) {
			tempParameters = ((Test) tempContainer).getParameters();
		} else if (tempContainer instanceof Call) {
			tempParameters = ((Call) tempContainer).getParameters();
		} else if (tempContainer instanceof TableTest) {
			tempParameters = ((TableTest) tempContainer).getParameters();
		}

		if (tempParameters != null) {
			for (Parameter tempOtherParameter : tempParameters) {
				if (tempOtherParameter != aParameter && tempOtherParameter.getName() != null
						&& aParameter.getName() != null
						&& tempOtherParameter.getName().getClass() == aParameter.getName().getClass()) {
					if (IntegrityDSLUtil.getParamNameStringFromParameterName(tempOtherParameter.getName())
							.equals(IntegrityDSLUtil.getParamNameStringFromParameterName(aParameter.getName()))) {
						error("Duplicate parameter", null);
						return;
					}
				}
			}
		}
	}

	/**
	 * Extracts all mandatory parameter names from the given method reference.
	 * 
	 * @param aMethod
	 *            Method where to get the parameter names from.
	 * @return All mandatory parameter names.
	 */
	protected Set<String> getMandatoryParameterNamesOf(MethodReference aMethod) {
		if (aMethod == null) {
			return emptySet();
		}
		List<Pair<JvmFormalParameter, JvmAnnotationReference>> tempAnnotatedParameter = evaluator
				.getAllAnnotatedParameter(aMethod, FixtureParameterAssessment.ACCEPTED_ANNOTATION);
		List<FixtureParameterAssessment> tempParameter = wrap(tempAnnotatedParameter);
		return collectMandatoryParameterNames(tempParameter);
	}

	/**
	 * Checks if some parameter is missing and reports this.
	 * 
	 * @param someMandatoryParameters
	 *            Mandatory parameter names.
	 * @param someSpecifiedParameter
	 *            Specified parameter names.
	 */
	protected void checkForMissingParameter(Set<String> someMandatoryParameters, Set<String> someSpecifiedParameter) {
		SetView<String> tempDifference = Sets.difference(someMandatoryParameters, someSpecifiedParameter);
		if (!tempDifference.isEmpty()) {
			String tempAllMissing = Joiner.on(", ").join(tempDifference);
			error("Missing mandatory parameter(s): " + tempAllMissing, null);
		}
	}

	/**
	 * Checks if the given method has a parameter that is non-nullable, but for which a null value is statically
	 * provided.
	 * 
	 * @param aMethod
	 *            the method to check
	 * @param someParameters
	 *            the parameters to check
	 * @return the set of non-nullable parameters if any non-nullable parameters are present in the fixture method
	 *         (regardless of whether violations were found), null otherwise
	 */
	protected Set<String> checkForNonNullableParameter(MethodReference aMethod, List<Parameter> someParameters) {
		List<Pair<JvmFormalParameter, JvmAnnotationReference>> tempAnnotatedParameter = evaluator
				.getAllAnnotatedParameter(aMethod, FixtureParameterAssessment.ACCEPTED_ANNOTATION);
		List<FixtureParameterAssessment> tempParameter = wrap(tempAnnotatedParameter);
		Set<String> tempNonNullableParameters = collectNonNullableParameterNames(tempParameter);

		if (tempNonNullableParameters.isEmpty()) {
			return null;
		}

		for (Parameter tempParam : someParameters) {
			if (tempNonNullableParameters
					.contains(IntegrityDSLUtil.getParamNameStringFromParameterName(tempParam.getName()))) {
				ensureParameterIsNotNullValue(tempParam, tempParam.getValue());
			}
		}

		return tempNonNullableParameters;
	}

	/**
	 * If the provided parameter is linked to a static null value, an error is generated.
	 * 
	 * @param aParameter
	 */
	protected void ensureParameterIsNotNullValue(EObject aParameterObject, EObject aParameterValue) {
		if (aParameterValue instanceof ValueOrEnumValueOrOperationCollection) {
			ensureParameterIsNotNullValue(aParameterObject,
					((ValueOrEnumValueOrOperationCollection) aParameterValue).getValue());
			for (ValueOrEnumValueOrOperation tempValue : ((ValueOrEnumValueOrOperationCollection) aParameterValue)
					.getMoreValues()) {
				ensureParameterIsNotNullValue(aParameterObject, tempValue);
			}
		} else {
			if (aParameterValue instanceof NullValue) {
				error("Null value provided for non-nullable parameter!", aParameterObject.eContainer(),
						aParameterObject.eContainingFeature());
			}
		}
	}

	/**
	 * Wraps the parameter/annotation tuples in assessment objects for easier access and caches the processing results.
	 * 
	 * @param someParameters
	 *            Parameters to wrap
	 * @return Assessment classes for easier access.
	 */
	public List<FixtureParameterAssessment> wrap(
			Iterable<Pair<JvmFormalParameter, JvmAnnotationReference>> someParameters) {
		List<FixtureParameterAssessment> tempResult = new LinkedList<FixtureParameterAssessment>();
		for (Pair<JvmFormalParameter, JvmAnnotationReference> tempParameterPair : someParameters) {
			tempResult.add(new FixtureParameterAssessment(evaluator, tempParameterPair));
		}
		return tempResult;
	}

	/**
	 * Collects all mandatory parameter names and returns them.
	 * 
	 * @param aCollection
	 *            Some parameter to get the mandatory names from.
	 * @return
	 */
	protected Set<String> collectMandatoryParameterNames(Collection<FixtureParameterAssessment> aCollection) {
		Iterable<FixtureParameterAssessment> tempMandatory = filter(aCollection,
				FixtureParameterAssessment.IS_MANDATORY);
		Iterable<String> tempMandatoryNames = transform(tempMandatory, FixtureParameterAssessment.NAME);
		return Sets.newLinkedHashSet(tempMandatoryNames);
	}

	/**
	 * Collects all non-nullable parameter names and returns them.
	 * 
	 * @param aCollection
	 *            Some parameter to get the mandatory names from.
	 * @return
	 */
	protected Set<String> collectNonNullableParameterNames(Collection<FixtureParameterAssessment> aCollection) {
		Iterable<FixtureParameterAssessment> tempNonNullable = filter(aCollection,
				FixtureParameterAssessment.IS_NOT_NULLABLE);
		Iterable<String> tempNonNullableNames = transform(tempNonNullable, FixtureParameterAssessment.NAME);
		return Sets.newLinkedHashSet(tempNonNullableNames);
	}

	/**
	 * Maps parameters to their names.
	 */
	private final Function<Parameter, String> FUNC_PARAMETER_NAME = new Function<Parameter, String>() {

		@Override
		public String apply(Parameter aParameter) {
			return evaluator.getParameterNameOf(aParameter.getName());
		};

	};

	/**
	 * Maps parameters to their names.
	 */
	private final Function<ParameterTableHeader, String> FUNC_PARAMETER_HEADER_NAME = new Function<ParameterTableHeader, String>() {

		@Override
		public String apply(ParameterTableHeader aParameterHeader) {
			return evaluator.getParameterNameOf(aParameterHeader.getName());
		};

	};
}
