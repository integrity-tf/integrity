/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.classloading;

import java.lang.reflect.Method;

import org.eclipse.xtext.common.types.JvmType;

import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.JavaConstantReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.exceptions.MethodNotFoundException;

/**
 * This service is used by Integrity to internally load classes for test execution.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface IntegrityClassLoader {

	/**
	 * Load the class defined by the provided {@link MethodReference}.
	 * 
	 * @param aMethodReference
	 *            the method reference referring to the class
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	Class<?> loadClass(MethodReference aMethodReference) throws ClassNotFoundException;

	/**
	 * Load the class defined by the provided {@link JavaConstantReference}.
	 * 
	 * @param aConstantReference
	 *            the constant reference referring to the class
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	Class<?> loadClass(JavaConstantReference aConstantReference) throws ClassNotFoundException;

	/**
	 * Load the class defined by the provided {@link JavaClassReference}.
	 * 
	 * @param aClassReference
	 *            the class reference referring to the class
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	Class<?> loadClass(JavaClassReference aClassReference) throws ClassNotFoundException;

	/**
	 * Load the class defined by the provided {@link JvmType}.
	 * 
	 * @param aType
	 *            the type referring to the class
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	Class<?> loadClass(JvmType aType) throws ClassNotFoundException;

	/**
	 * Load the class defined by the provided {@link OperationDefinition}.
	 * 
	 * @param anOperationDefinition
	 *            the operation definition referring to the class
	 * @return the loaded class
	 * @throws ClassNotFoundException
	 */
	Class<?> loadClass(OperationDefinition anOperationDefinition) throws ClassNotFoundException;

	/**
	 * First loads the class defined by the provided {@link MethodReference}, then loads the method.
	 * 
	 * @param aMethodReference
	 *            the method reference referring to class and method
	 * @return the loaded method
	 * @throws ClassNotFoundException
	 * @throws MethodNotFoundException
	 */
	Method loadMethod(MethodReference aMethodReference) throws ClassNotFoundException, MethodNotFoundException;

}
