/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import de.gebit.integrity.DSLStandaloneSetup;
import de.gebit.integrity.runner.modelcheck.ModelChecker;
import de.gebit.integrity.runner.modelcheck.NullModelChecker;

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

	/**
	 * Whether model checking shall be disabled by overriding the model checker.
	 */
	protected boolean disableModelChecks;

	public void setDisableModelChecks(boolean aDisableModelChecksFlag) {
		disableModelChecks = aDisableModelChecksFlag;
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules.override(createGuiceModule(getClassLoader())).with(new Module() {
			@Override
			public void configure(Binder aBinder) {
				overrideBindings(aBinder);
			}
		}));
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

	/**
	 * Overrides certain bindings with non-default classes. This can also be used in subclasses to override bindings, as
	 * an alternative to creating a new module based on the default {@link IntegrityRunnerModule}, although the latter
	 * is the suggested method.
	 * 
	 * @param aBinder
	 */
	protected void overrideBindings(Binder aBinder) {
		if (disableModelChecks) {
			aBinder.bind(ModelChecker.class).to(NullModelChecker.class);
		}
	}

}
