/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.classloading;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.JavaConstantReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.exceptions.MethodNotFoundException;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.modelsource.ModelSourceExplorer;

/**
 * Basic implementation of {@link IntegrityClassLoader}. Uses the injected Java classloader internally.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultIntegrityClassLoader implements IntegrityClassLoader {

	/**
	 * The actual classloader used internally.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * The model source explorer.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	@Override
	public Class<?> loadClass(JvmType aType) throws ClassNotFoundException {
		if (aType == null) {
			return null;
		}

		String tempFullyQualifiedName = aType.getQualifiedName();
		return classLoader.loadClass(tempFullyQualifiedName);
	}

	private Class<?> loadClassGuarded(JvmType aType, EObject aSourceObject) throws ClassNotFoundException {
		if (aType == null) {
			throw new ModelRuntimeLinkException("Reference to JVM Type missing", aSourceObject,
					modelSourceExplorer.determineSourceInformation(aSourceObject));
		}

		return loadClass(aType);
	}

	@Override
	public Class<?> loadClass(OperationDefinition anOperationDefinition) throws ClassNotFoundException {
		if (anOperationDefinition == null || anOperationDefinition.getOperationType() == null) {
			return null;
		}

		return loadClassGuarded(anOperationDefinition.getOperationType().getType(), anOperationDefinition);
	}

	@Override
	public Class<?> loadClass(MethodReference aMethodReference) throws ClassNotFoundException {
		if (aMethodReference == null) {
			return null;
		}

		JvmType tempType = aMethodReference.getType();
		return loadClassGuarded(tempType, aMethodReference);
	}

	@Override
	public Class<?> loadClass(JavaConstantReference aConstantReference) throws ClassNotFoundException {
		if (aConstantReference == null) {
			return null;
		}

		JvmType tempType = aConstantReference.getType();
		return loadClassGuarded(tempType, aConstantReference);
	}

	@Override
	public Class<?> loadClass(JavaClassReference aClassReference) throws ClassNotFoundException {
		if (aClassReference == null) {
			return null;
		}

		JvmType tempType = aClassReference.getType();
		return loadClassGuarded(tempType, aClassReference);
	}

	@Override
	public Method loadMethod(MethodReference aMethodReference) throws ClassNotFoundException, MethodNotFoundException {
		if (aMethodReference == null) {
			return null;
		}

		Class<?> tempClassInFocus = loadClass(aMethodReference);

		if (aMethodReference.getMethod() == null) {
			throw new ModelRuntimeLinkException("Method reference missing", aMethodReference,
					modelSourceExplorer.determineSourceInformation(aMethodReference));
		}

		String tempMethodName = aMethodReference.getMethod().getSimpleName();

		if (tempMethodName != null) {
			while (tempClassInFocus != null) {
				for (Method tempMethod : tempClassInFocus.getMethods()) {
					FixtureMethod tempMethodAnnotation = tempMethod.getAnnotation(FixtureMethod.class);
					if (tempMethodAnnotation != null) {
						String tempCandidateMethodName = tempMethod.getName();

						if (tempCandidateMethodName.equals(tempMethodName)) {
							return tempMethod;
						}
					}
				}

				tempClassInFocus = tempClassInFocus.getSuperclass();
			}
		}

		throw new MethodNotFoundException(modelSourceExplorer.determineSourceSnippet(aMethodReference).trim());
	}

}
