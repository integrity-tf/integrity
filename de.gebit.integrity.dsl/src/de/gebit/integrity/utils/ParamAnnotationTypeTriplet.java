/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * Instances of this class are used as containers to link a parameter name (logical name used within Integrity scripts),
 * the matching Java parameter name and a reference to the annotation attached to the parameter.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ParamAnnotationTypeTriplet {

	/**
	 * The name of the parameter, as used in Integrity test scripts.
	 */
	private String paramName;

	/**
	 * The actual name of the parameter in the Java method signature (if applicable and available).
	 */
	private String javaParamName;

	/**
	 * The reference to the {@link de.gebit.integrity.fixtures.FixtureParameter} annotation attached to the parameter.
	 */
	private JvmAnnotationReference annotation;

	/**
	 * The declared parameter type.
	 */
	private JvmTypeReference type;

	/**
	 * Creates a new instance.
	 * 
	 * @param aParamName
	 * @param anAnnotation
	 */
	public ParamAnnotationTypeTriplet(String aParamName, JvmAnnotationReference anAnnotation, JvmTypeReference aType) {
		super();
		paramName = aParamName;
		annotation = anAnnotation;
		type = aType;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aParamName
	 * @param aJavaParamName
	 * @param anAnnotation
	 */
	public ParamAnnotationTypeTriplet(String aParamName, String aJavaParamName, JvmAnnotationReference anAnnotation,
			JvmTypeReference aType) {
		super();
		paramName = aParamName;
		javaParamName = aJavaParamName;
		annotation = anAnnotation;
		type = aType;
	}

	public String getParamName() {
		return paramName;
	}

	public String getJavaParamName() {
		return javaParamName;
	}

	public JvmAnnotationReference getAnnotation() {
		return annotation;
	}

	public JvmTypeReference getType() {
		return type;
	}

}
