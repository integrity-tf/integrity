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

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.forker.ForkerParameter;


/**
 *  Convenience accessment for the {@link FixtureParameter} or {@link ForkerParameter} annotation,
 *  which eagerly load the requested values from the annotation.
 *  @author tilois
 */
public class FixtureParameterAssessment {
	/** Name of the parameter. */
	private final String name;
	/** Is the parameter optional? */
	private final boolean optional;
	
	/** List of acceptable annotation classes. */
	public static final ImmutableList<Class<? extends Annotation>> ACCEPTED_ANNOTATION = ImmutableList.of(
			FixtureParameter.class,
			ForkerParameter.class);
	
	/** Private list of annotation names. */
	private static final ImmutableList<String> ACCEPTED_ANNOTATION_NAMES;
	static {
		ImmutableList.Builder<String> tempBuilder = new ImmutableList.Builder<String>();
		for (Class<? extends Annotation> tempAnnotation : ACCEPTED_ANNOTATION) {
			tempBuilder.add(tempAnnotation.getCanonicalName());
		}
		ACCEPTED_ANNOTATION_NAMES = tempBuilder.build();
	}
	
	/**
	 * Checks if the given annotation is a valid annotation that can be wrapped.
	 * @param anAnnotation Annotation to check.
	 * @return <code>true</code> if it can be wrapped, <code>false</code> otherwise.
	 */
	public static boolean isAssignable(JvmAnnotationReference anAnnotation) {
		return ACCEPTED_ANNOTATION_NAMES.contains(anAnnotation.getAnnotation().getQualifiedName());
	}
	
	/** Predicate to match optional parameters. */
	public static final Predicate<FixtureParameterAssessment> IS_OPTIONAL = new Predicate<FixtureParameterAssessment>() {
		public boolean apply(FixtureParameterAssessment anParameter) {
			return anParameter.isOptional();
		};
	};
	
	/** Function which maps a parameter to its name. */
	public static final Function<FixtureParameterAssessment, String> NAME = new Function<FixtureParameterAssessment, String>() {
		public String apply(FixtureParameterAssessment aParameter) {
			return aParameter.getName();
		};
	};
	
	/**
	 * Wrapps the given annotation with the help of the evalation object.
	 * @param anEvaluation Evaluation which provides access to the annotation.
	 * @param anAnnotation Annotation to wrap.
	 */
	public FixtureParameterAssessment(JvmFixtureEvaluation anEvaluation, JvmAnnotationReference anAnnotation) {
		Preconditions.checkNotNull(anAnnotation);
		Preconditions.checkNotNull(anEvaluation);
		Preconditions.checkArgument(isAssignable(anAnnotation));
		JvmAnnotationValue tempName = anEvaluation.getValueByName(anAnnotation, "name");
		JvmAnnotationValue tempOptional = anEvaluation.getValueByName(anAnnotation, "optional");
		name = anEvaluation.evaluateSingle(tempName, String.class);
		optional = anEvaluation.evaluateSingle(tempOptional, Boolean.class);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isOptional() {
		return optional;
	}
}
