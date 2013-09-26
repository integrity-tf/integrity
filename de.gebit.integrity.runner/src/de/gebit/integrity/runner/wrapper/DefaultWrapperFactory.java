/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.wrapper;

import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.custom.CustomOperationWrapper;
import de.gebit.integrity.runner.modelcheck.ModelChecker;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The basic wrapper factory.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultWrapperFactory implements WrapperFactory {

	/**
	 * The classloader to use.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * The {@link Injector} to use for injection of dependencies into the new wrapper.
	 */
	@Inject
	protected Injector injector;

	/**
	 * The model checker.
	 */
	@Inject
	protected ModelChecker modelChecker;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public FixtureWrapper<?> newFixtureWrapper(JvmType aFixtureType) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> tempClass = classLoader.loadClass(aFixtureType.getQualifiedName());
		FixtureWrapper<?> tempWrapper = new FixtureWrapper(tempClass, injector);
		return tempWrapper;
	}

	@Override
	public CustomOperationWrapper newCustomOperationWrapper(CustomOperation anOperation) throws ClassNotFoundException {
		// This check is done here because this is the first place in which multiple possible call paths to the creation
		// of a custom operation wrapper do merge. The check is omitted for fixture creation because specialized checks
		// for each fixture type have already been done before in each possible call path.
		modelChecker.check(anOperation);

		CustomOperationWrapper tempWrapper = new CustomOperationWrapper(anOperation, classLoader);
		injector.injectMembers(tempWrapper);
		return tempWrapper;
	}
}
