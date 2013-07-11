/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.validation;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.validation.Check;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import de.gebit.integrity.annotation.FixtureParameterAssessment;
import de.gebit.integrity.annotation.JvmFixtureEvaluation;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.ParamAnnotationTypeTriplet;

/**
 * These validators perform some more extensive validation on parts of the syntax tree.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLJavaValidator extends AbstractDSLJavaValidator {
	
	/** Evaluates JvmFixtures and provides tooling for handling the abstract types. */
	@Inject
	private JvmFixtureEvaluation evaluator;
	
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
					error("Variable definitions may not be fully or partly qualified. Please put the variable in the according packagedef to qualify it!",
							null);
				}
			}
		}
	}
	
	@Check
	public void checkForMissingParameter(Call aCall) {
		List<JvmAnnotationReference> tempAnnotatedParameter = evaluator.getAllAnnotatedParameter(aCall.getDefinition().getFixtureMethod(), FixtureParameterAssessment.ACCEPTED_ANNOTATION);
		List<FixtureParameterAssessment> tempParameter = wrap(tempAnnotatedParameter);
		Set<String> tempMandatoryParameter = collectMandatoryParameter(tempParameter);
		Set<String> tempSpecifiedParameter = collectParameterNames(aCall.getParameters());
		SetView<String> tempDifference = Sets.difference(tempMandatoryParameter, tempSpecifiedParameter);
		if (!tempDifference.isEmpty()) {
			String tempAllMissing = Joiner.on(", ").join(tempDifference);
			error("Missing mandatory parameter(s): " + tempAllMissing, null);
		}
	}
	
	public List<FixtureParameterAssessment> wrap(Iterable<JvmAnnotationReference> anAnnotation) {
		List<FixtureParameterAssessment> tempResult = new LinkedList<FixtureParameterAssessment>();
		for (JvmAnnotationReference tempAnnotation : anAnnotation) {
			tempResult.add(new FixtureParameterAssessment(evaluator, tempAnnotation));
		}
		return tempResult;
	}
	
	protected Set<String> collectMandatoryParameter(Collection<FixtureParameterAssessment> aCollection) {
		Set<String> tempResult = new HashSet<String>();
		for (FixtureParameterAssessment tempParameter : aCollection) {
			if (!tempParameter.isOptional()) {
				tempResult.add(tempParameter.getName());
			}
		}
		return tempResult;
	}
	
	protected Set<String> collectParameterNamesFromTriplet(Collection<ParamAnnotationTypeTriplet> aCollection) {
		Set<String> tempResult = new HashSet<String>();
		for (ParamAnnotationTypeTriplet tempParamTriplet : aCollection) {
			tempResult.add(tempParamTriplet.getParamName());
		}
		return tempResult;
	}
	
	protected Set<String> collectParameterNames(Collection<Parameter> aCollection) {
		Set<String> tempResult = new HashSet<String>();
		for (Parameter tempParameter : aCollection) {
			tempResult.add(evaluator.getParameterNameOf(tempParameter.getName()));
		}
		return tempResult;
	}
	
	protected List<ParamAnnotationTypeTriplet> collectsMandatory(Collection<ParamAnnotationTypeTriplet> aCollection) {
		List<ParamAnnotationTypeTriplet> tempResult = new LinkedList<ParamAnnotationTypeTriplet>();
		for (ParamAnnotationTypeTriplet tempParamTriplet : aCollection) {
			JvmAnnotationValue tempOptional = evaluator.getValueByName(tempParamTriplet.getAnnotation(), "optional");
			if (!evaluator.evaluateSingle(tempOptional, Boolean.class)) {
				tempResult.add(tempParamTriplet);
			}
		}
		return tempResult;
	}

}
