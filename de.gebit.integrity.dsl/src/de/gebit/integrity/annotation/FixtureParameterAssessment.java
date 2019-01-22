/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.annotation;

import java.lang.annotation.Annotation;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;

import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.forker.ForkerParameter;

/**
 * Convenience accessment for the {@link FixtureParameter} or {@link ForkerParameter} annotation, which eagerly load the
 * requested values from the annotation.
 * 
 * @author tilois - Initial API and Implementation
 */
public class FixtureParameterAssessment {

	/** Name of the parameter. */
	private final String name;

	/** Is the parameter optional? */
	private final boolean mandatory;

	/**
	 * Is the parameter nullable?
	 */
	private final boolean nullable;

	/** List of acceptable annotation classes. */
	public static final ImmutableSet<Class<? extends Annotation>> ACCEPTED_ANNOTATION = ImmutableSet
			.of(FixtureParameter.class, ForkerParameter.class);

	/** List of annotation names. */
	protected static final ImmutableSet<String> ACCEPTED_ANNOTATION_NAMES;
	static {
		ImmutableSet.Builder<String> tempBuilder = new ImmutableSet.Builder<String>();
		for (Class<? extends Annotation> tempAnnotation : ACCEPTED_ANNOTATION) {
			tempBuilder.add(tempAnnotation.getCanonicalName());
		}
		ACCEPTED_ANNOTATION_NAMES = tempBuilder.build();
	}

	/**
	 * List of types known as primitive types.
	 */
	protected static final ImmutableSet<String> PRIMITIVE_TYPE_NAMES = ImmutableSet.of("byte", "short", "int", "long",
			"boolean", "float", "double", "char");

	/**
	 * Checks if the given annotation is a valid annotation that can be wrapped.
	 * 
	 * @param anAnnotation
	 *            Annotation to check.
	 * @return <code>true</code> if it can be wrapped, <code>false</code> otherwise.
	 */
	public static boolean isAssignable(JvmAnnotationReference anAnnotation) {
		return ACCEPTED_ANNOTATION_NAMES.contains(anAnnotation.getAnnotation().getQualifiedName());
	}

	/** Predicate to match mandatory parameters. */
	public static final Predicate<FixtureParameterAssessment> IS_MANDATORY = new Predicate<FixtureParameterAssessment>() {
		public boolean apply(FixtureParameterAssessment anParameter) {
			return anParameter.isMandatory();
		};
	};

	/** Predicate to match non-nullable parameters. */
	public static final Predicate<FixtureParameterAssessment> IS_NOT_NULLABLE = new Predicate<FixtureParameterAssessment>() {
		public boolean apply(FixtureParameterAssessment anParameter) {
			return !anParameter.isNullable();
		};
	};

	/** Function which maps a parameter to its name. */
	public static final Function<FixtureParameterAssessment, String> NAME = new Function<FixtureParameterAssessment, String>() {
		public String apply(FixtureParameterAssessment aParameter) {
			return aParameter.getName();
		};
	};

	/**
	 * Wraps the given parameter/annotation tuple with the help of the evaluation object.
	 * 
	 * @param anEvaluation
	 *            Evaluation which provides access to the annotation
	 * @param aParameterTuple
	 *            Parameter/annotation to wrap
	 */
	public FixtureParameterAssessment(JvmFixtureEvaluation anEvaluation,
			Pair<JvmFormalParameter, JvmAnnotationReference> aParameterTuple) {
		Preconditions.checkNotNull(aParameterTuple);
		Preconditions.checkNotNull(anEvaluation);

		JvmFormalParameter tempParameter = aParameterTuple.getFirst();
		JvmAnnotationReference tempAnnotation = aParameterTuple.getSecond();

		Preconditions.checkArgument(isAssignable(aParameterTuple.getSecond()));
		JvmAnnotationValue tempName = anEvaluation.getValueByName(tempAnnotation, "name");
		JvmAnnotationValue tempMandatory = anEvaluation.getValueByName(tempAnnotation, "mandatory");
		JvmAnnotationValue tempNullable = anEvaluation.getValueByName(tempAnnotation, "nullable");

		name = anEvaluation.evaluateSingle(tempName, String.class);
		boolean tempMandatoryFlag = anEvaluation.evaluateSingle(tempMandatory, Boolean.class);
		boolean tempNullableFlag = anEvaluation.evaluateSingle(tempNullable, Boolean.class);

		if (!tempMandatoryFlag && tempParameter.getParameterType() != null) {
			// Primitive types are automatically mandatory and non-nullable; they can technically not be made optional.
			boolean tempPrimitiveType = PRIMITIVE_TYPE_NAMES
					.contains(tempParameter.getParameterType().getQualifiedName());
			if (tempPrimitiveType) {
				tempMandatoryFlag = true;
				tempNullableFlag = false;
			}
		}

		mandatory = tempMandatoryFlag;
		nullable = tempNullableFlag;
	}

	public String getName() {
		return name;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public boolean isNullable() {
		return nullable;
	}
}
