/**
 * 
 */
package de.gebit.integrity.runner;

import de.gebit.integrity.DSLRuntimeModule;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.runner.comparator.DefaultResultComparator;
import de.gebit.integrity.runner.comparator.ResultComparator;
import de.gebit.integrity.runner.forking.processes.DefaultProcessTerminator;
import de.gebit.integrity.runner.forking.processes.ProcessTerminator;
import de.gebit.integrity.runner.variables.DefaultVariableManager;
import de.gebit.integrity.runner.wrapper.DefaultWrapperFactory;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The module class for registration of runtime modules with Google Guice.
 * 
 * @author Rene Schneider
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

}
