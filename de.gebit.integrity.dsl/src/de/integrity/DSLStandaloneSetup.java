package de.integrity;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class DSLStandaloneSetup extends DSLStandaloneSetupGenerated {

	ClassLoader classLoader;

	public DSLStandaloneSetup() {
		classLoader = getClass().getClassLoader();
	}

	public DSLStandaloneSetup(ClassLoader aClassLoader) {
		classLoader = aClassLoader;
	}

	public static void doSetup(ClassLoader aClassLoader) {
		new DSLStandaloneSetup(aClassLoader).createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new de.integrity.DSLRuntimeModule(classLoader));
	}
}
