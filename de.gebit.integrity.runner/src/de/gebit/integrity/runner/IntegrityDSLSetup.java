/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.gebit.integrity.DSLStandaloneSetup;

/**
 * Initialization support for running Xtext languages without equinox extension registry.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityDSLSetup extends DSLStandaloneSetup {

	/**
	 * Creates a new instance.
	 */
	public IntegrityDSLSetup() {
		super();
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(createGuiceModule(getClassLoader()));
	}

	/**
	 * Instantiates the Guice module class. This method is provided to have a nice place to override in subclasses if a
	 * subclassed module class is to be used instead of the default.
	 * 
	 * @param aClassLoader
	 * @return the module instance
	 */
	protected IntegrityRunnerModule createGuiceModule(ClassLoader aClassLoader) {
		return new IntegrityRunnerModule(aClassLoader);
	}

}
