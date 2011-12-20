package de.gebit.integrity;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension registry.
 * 
 * @author Rene Schneider
 */
public class DSLStandaloneSetup extends DSLStandaloneSetupGenerated {

	/**
	 * The classloader to use.
	 */
	ClassLoader classLoader;

	/**
	 * Creates a new instance with the default classloader, which is the one that loaded the setup class.
	 */
	public DSLStandaloneSetup() {
		classLoader = getClass().getClassLoader();
	}

	/**
	 * Creates a new instance with a given classloader.
	 * 
	 * @param aClassLoader
	 */
	public DSLStandaloneSetup(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	/**
	 * Performs the setup.
	 * 
	 * @param aClassLoader
	 */
	public static void doSetup(ClassLoader aClassLoader) {
		new DSLStandaloneSetup(aClassLoader).createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new de.gebit.integrity.DSLRuntimeModule(classLoader));
	}
}
