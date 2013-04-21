/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension registry.
 * 
 * @author Rene Schneider - initial API and implementation
 */
public class DSLStandaloneSetup extends DSLStandaloneSetupGenerated {

	/**
	 * The classloader to use.
	 */
	private ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * Creates a new instance with the default classloader, which is the one that loaded the setup class.
	 */
	public DSLStandaloneSetup() {
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new de.gebit.integrity.DSLRuntimeModule(classLoader));
	}
}
