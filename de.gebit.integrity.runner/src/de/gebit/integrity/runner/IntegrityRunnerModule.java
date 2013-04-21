/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import de.gebit.integrity.DSLRuntimeModule;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.runner.comparator.DefaultResultComparator;
import de.gebit.integrity.runner.comparator.ResultComparator;
import de.gebit.integrity.runner.console.intercept.ConsoleInterceptionAggregator;
import de.gebit.integrity.runner.console.intercept.ConsoleOutputInterceptor;
import de.gebit.integrity.runner.console.intercept.DefaultConsoleInterceptionAggregator;
import de.gebit.integrity.runner.console.intercept.DefaultConsoleOutputInterceptor;
import de.gebit.integrity.runner.forking.processes.DefaultProcessTerminator;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.variables.DefaultVariableManager;
import de.gebit.integrity.runner.wrapper.DefaultWrapperFactory;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The module class for registration of runtime modules with Google Guice. Subclass this class in order to override one
 * or more of the default services! If you subclass this, you need to subclass {@link IntegrityDSLSetup} as well and
 * override {@link IntegrityDSLSetup#createGuiceModule(ClassLoader)} to ensure your subclass is actually used.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityRunnerModule extends DSLRuntimeModule {

	/**
	 * Creates a new instance with the default classloader.
	 */
	public IntegrityRunnerModule() {
		super();
	}

	/**
	 * Creates a new instance using the given classloader.
	 * 
	 * @param aClassLoader
	 */
	public IntegrityRunnerModule(ClassLoader aClassLoader) {
		super(aClassLoader);
	}

	/**
	 * Binding of the {@link TestRunner}.
	 */
	public Class<? extends TestRunner> bindTestRunner() {
		return DefaultTestRunner.class;
	}

	/**
	 * Binding of the {@link VariableManager}.
	 */
	public Class<? extends VariableManager> bindVariableManager() {
		return DefaultVariableManager.class;
	}

	/**
	 * Binding of the {@link WrapperFactory}.
	 */
	public Class<? extends WrapperFactory> bindWrapperFactory() {
		return DefaultWrapperFactory.class;
	}

	/**
	 * Binding of the {@link ResultComparator}.
	 */
	public Class<? extends ResultComparator> bindResultComparator() {
		return DefaultResultComparator.class;
	}

	/**
	 * Binding of the {@link ProcessTerminator}.
	 * 
	 * @return
	 */
	public Class<? extends ProcessTerminator> bindProcessWatchdog() {
		return DefaultProcessTerminator.class;
	}

	/**
	 * Binding of the {@link ConsoleInterceptionAggregator}.
	 * 
	 * @return
	 */
	public Class<? extends ConsoleInterceptionAggregator> bindConsoleInterceptionAggregator() {
		return DefaultConsoleInterceptionAggregator.class;
	}

	/**
	 * Binding of the {@link ConsoleOutputInterceptor}.
	 * 
	 * @return
	 */
	public Class<? extends ConsoleOutputInterceptor> bindConsoleOutputInterceptor() {
		return DefaultConsoleOutputInterceptor.class;
	}

}
