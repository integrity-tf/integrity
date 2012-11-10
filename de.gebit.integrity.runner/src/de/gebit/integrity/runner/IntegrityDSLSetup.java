/**
 * 
 */
package de.gebit.integrity.runner;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.gebit.integrity.DSLStandaloneSetup;

/**
 * Initialization support for running Xtext languages without equinox extension registry.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityDSLSetup extends DSLStandaloneSetup {

	/**
	 * Creates a new instance using the given classloader.
	 * 
	 * @param aClassLoader
	 */
	public IntegrityDSLSetup(ClassLoader aClassLoader) {
		super(aClassLoader);
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new IntegrityRunnerModule(getClassLoader()));
	}

}
