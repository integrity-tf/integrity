/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.annotation;

import static com.google.common.collect.Iterables.filter;
import static java.util.Collections.emptyList;

import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * Evaluates JvmFixtures reflectively without loading them in the classpath.
 * 
 * @author tilois - Initial API and Implementation
 */
public class JvmFixtureEvaluation {

	/**
	 * Processes the given method and returns a list of all annotated parameters. Only supports one annotation per
	 * parameter.
	 * 
	 * @param aMethod
	 *            Method to be checked.
	 * @param someAnnotationTypes
	 *            Types that should be collected.
	 * @return A list of all parameters linked to the annotation of the given types for this method.
	 */
	public List<Pair<JvmFormalParameter, JvmAnnotationReference>> getAllAnnotatedParameter(MethodReference aMethod,
			Set<Class<? extends Annotation>> someAnnotationTypes) {
		if (aMethod == null) {
			return emptyList();
		}
		final JvmOperation tempOperation = aMethod.getMethod();
		Preconditions.checkArgument(tempOperation != null, "Methodreference did not resolve to a JVM operation!");
		List<Pair<JvmFormalParameter, JvmAnnotationReference>> tempResult = new LinkedList<Pair<JvmFormalParameter, JvmAnnotationReference>>();
		for (JvmFormalParameter tempParameter : tempOperation.getParameters()) {
			try {
				tempResult
						.add(Tuples.create(tempParameter, Iterables.getOnlyElement(filter(
								tempParameter.getAnnotations(), isOneOf(someAnnotationTypes)))));
			} catch (NoSuchElementException exc) {
				// Expected if there's no matching annotation
				continue;
			}
		}
		return tempResult;
	}

	/**
	 * Produces a predicate that matches an annotation if it is one of the specified ones.
	 * 
	 * @param someAnnotationTypes
	 *            Annotations that should match.
	 * @return <code>true</code> if the annotation represents one of the specified ones, <code>false</code> otherwise.
	 */
	protected Predicate<JvmAnnotationReference> isOneOf(final Set<Class<? extends Annotation>> someAnnotationTypes) {
		return new Predicate<JvmAnnotationReference>() {
			public boolean apply(JvmAnnotationReference anAnnotation) {
				if (anAnnotation == null) {
					return false;
				}
				final String tempQualifiedAnnotationName = anAnnotation.getAnnotation().getQualifiedName();
				for (Class<? extends Annotation> tempAnnotation : someAnnotationTypes) {
					if (tempQualifiedAnnotationName.equals(tempAnnotation.getCanonicalName())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Extracts an annotation value by its name.
	 * 
	 * @param anAnnotation
	 *            Annotation where to search.
	 * @param aName
	 *            Name to be searched.
	 * @return annotation value if it got found, <code>null</code> otherwise.
	 */
	public JvmAnnotationValue getValueByName(JvmAnnotationReference anAnnotation, String aName) {
		for (JvmAnnotationValue tempValue : anAnnotation.getValues()) {
			if (aName.equals(tempValue.getValueName())) {
				return tempValue;
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
	public String getParameterNameOf(ParameterName aParameterName) {
		if (aParameterName instanceof FixedParameterName) {
			JvmAnnotationValue tempName = getValueByName(((FixedParameterName) aParameterName).getAnnotation(), "name");
			return evaluateSingle(tempName, String.class);
		} else if (aParameterName instanceof ArbitraryParameterOrResultName) {
			return IntegrityDSLUtil
					.getIdentifierFromArbitraryParameterOrResultName((ArbitraryParameterOrResultName) aParameterName);
		} else {
			throw new UnsupportedOperationException("This subtype of ParameterName ("
					+ aParameterName.getClass().toString() + ") is not supported yet!");
		}
	}

	/**
	 * Evaluates an Jvm annotation value which is expected to hold the specified type.
	 * 
	 * @param anAnnotationValue
	 *            Annotation value to evaluate.
	 * @param anExpectedType
	 *            Expected type of the value.
	 * @return a list of all values
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> evaluateValues(JvmAnnotationValue anAnnotationValue, Class<T> anExpectedType) {
		if (Boolean.class.isAssignableFrom(anExpectedType)) {
			return (List<T>) ((JvmBooleanAnnotationValue) anAnnotationValue).getValues();
		}
		if (String.class.isAssignableFrom(anExpectedType)) {
			return (List<T>) ((JvmStringAnnotationValue) anAnnotationValue).getValues();
		}
		throw new UnsupportedOperationException("Type " + anExpectedType + " is not supported!");
	}

	/**
	 * Evaluates an Jvm annotation value which is expected to hold a single value of the specified type.
	 * 
	 * @param anAnnotationValue
	 *            Annotation value to evaluate.
	 * @param anExpectedType
	 *            Expected type of the value.
	 * @see #evaluateValues(JvmAnnotationValue, Class) does the same for an arbitrary list of values.
	 * @return the value
	 */
	public <T> T evaluateSingle(JvmAnnotationValue anAnnotationValue, Class<T> anExpectedType) {
		List<T> tempValues = evaluateValues(anAnnotationValue, anExpectedType);
		return tempValues.isEmpty() ? null : tempValues.get(0);
	}
}
