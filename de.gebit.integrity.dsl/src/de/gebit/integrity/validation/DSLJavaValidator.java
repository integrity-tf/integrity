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
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
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
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.VariableDefinition;
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
		if (anEntity.getName() != null) {
			String tempName = anEntity.getName().getName();
			if (tempName != null) {
				if (tempName.contains(".")) {
					error("Variable definitions may not be fully or partly qualified (= contain dots). "
							+ "Please put the variable in the according packagedef to qualify it, or use some other "
							+ "character in place of the dot!", null);
				}
			}
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
			String tempName = anEntity.getName().getName();
			if (tempName != null) {
				if (tempName.contains(".")) {
					error("Constant definitions may not be fully or partly qualified (= contain dots). "
							+ "Please put the constant in the according packagedef to qualify it, or use some other "
							+ "character in place of the dot!", null);
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
	}

	/** Polymorphic Dispatch of {@link #checkParameter(Call)}. */
	protected void _checkParameter(Test aTest) {
		Set<String> tempMandatoryParameter = getMandatoryParameterNamesOf(aTest.getDefinition().getFixtureMethod());
		Set<String> tempSpecifiedParameter = Sets.newHashSet(transform(aTest.getParameters(), FUNC_PARAMETER_NAME));
		checkForMissingParameter(tempMandatoryParameter, tempSpecifiedParameter);
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
	protected void checkParameterName(Parameter aParameter) {
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

	/** Maps parameters to their names. */
	private final Function<Parameter, String> FUNC_PARAMETER_NAME = new Function<Parameter, String>() {
		public String apply(Parameter aParameter) {
			return evaluator.getParameterNameOf(aParameter.getName());
		};
	};

	/** Maps parameters to their names. */
	private final Function<ParameterTableHeader, String> FUNC_PARAMETER_HEADER_NAME = new Function<ParameterTableHeader, String>() {
		public String apply(ParameterTableHeader aParameterHeader) {
			return evaluator.getParameterNameOf(aParameterHeader.getName());
		};
	};
}
