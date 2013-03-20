/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.fixtures;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.inject.Inject;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * Generic fixture usable to start, check and kill a Java application class with a static main method.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class JavaApplicationLaunchFixture {

	/**
	 * The classloader to use.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * The fixture will wait this number of milliseconds before first checking whether an exception occurred during that
	 * time.
	 */
	protected static final int WRAPPER_STARTUP_TIME = 1000;

	/**
	 * The fixture will wait this number of milliseconds for the application thread to die.
	 */
	protected static final int WRAPPER_KILL_TIME = 20000;

	/**
	 * The last application that was started is stored here. If the fixture methods are called without the
	 * {@link ApplicationWrapper} parameter, this instance is used.
	 */
	protected static ApplicationWrapper lastApplication;

	/**
	 * Launches the provided application by calling the static main method of the application class.
	 * 
	 * @param aMainClassName
	 *            the name of the application class
	 * @param someArguments
	 *            the arguments to provide to the main method
	 * @return an application wrapper instance which can optionally be saved to handle multiple applications
	 * @throws Throwable
	 */
	@FixtureMethod(description = "Launch Java Application: $mainClass$")
	public ApplicationWrapper launch(@FixtureParameter(name = "mainClass") String aMainClassName,
			@FixtureParameter(name = "arguments") String[] someArguments) throws Throwable {
		return launchInternal(aMainClassName, someArguments);
	}

	/**
	 * Launches the provided main class by calling its main method with the provided arguments.
	 * 
	 * @param aMainClassName
	 *            the main class name
	 * @param someArguments
	 *            the arguments
	 * @return the launched application, contained in an {@link ApplicationWrapper} instance
	 * @throws Throwable
	 *             if something goes wrong
	 */
	protected ApplicationWrapper launchInternal(String aMainClassName, String[] someArguments) throws Throwable {
		if (aMainClassName == null) {
			throw new IllegalArgumentException("A class name has to be provided.");
		}

		Class<?> tempMainClass = classLoader.loadClass(aMainClassName);
		Method tempMainMethod = tempMainClass.getMethod("main", new Class[] { String[].class });

		String[] tempArguments = someArguments != null ? someArguments : new String[0];

		ApplicationWrapper tempApplication = launchMain(tempMainClass, tempMainMethod, tempArguments);
		lastApplication = tempApplication;
		return tempApplication;
	}

	/**
	 * Checks whether the provided application (if none was provided, the last started application is used) is still
	 * alive.
	 * 
	 * @param aWrapper
	 *            the application to check (if null, the last started application is used)
	 * @return
	 */
	@FixtureMethod(description = "Check if the application is still alive")
	public boolean isAlive(@FixtureParameter(name = "application") ApplicationWrapper aWrapper) {
		return isAliveInternal(aWrapper);
	}

	/**
	 * Performs a liveliness check on the given application (or the last started one if none is provided).
	 * 
	 * @param aWrapper
	 *            the application to check
	 * @return true if alive, false if not
	 */
	protected boolean isAliveInternal(ApplicationWrapper aWrapper) {
		ApplicationWrapper tempWrapper = aWrapper != null ? aWrapper : lastApplication;

		if (tempWrapper == null) {
			throw new IllegalArgumentException("No application was provided, and none was stored statically");
		}

		return tempWrapper.isAlive();
	}

	/**
	 * Kills the provided application (or the last started one, if none is explicitly provided).
	 * 
	 * @param aWrapper
	 *            the application to kill
	 * @return true if killing was successful, false otherwise
	 */
	@FixtureMethod(description = "Kills the application")
	public boolean kill(@FixtureParameter(name = "application") ApplicationWrapper aWrapper) {
		return killInternal(aWrapper);
	}

	/**
	 * Actually kills the provided application (or the last started one, if none is explicitly provided).
	 * 
	 * @param aWrapper
	 *            the application to kill
	 * @return true if killing was successful, false otherwise
	 */
	// Deprecation is known, but there's no other way in this case...
	@SuppressWarnings("deprecation")
	protected boolean killInternal(ApplicationWrapper aWrapper) {
		ApplicationWrapper tempWrapper = aWrapper != null ? aWrapper : lastApplication;

		if (tempWrapper == null) {
			throw new IllegalArgumentException("No application was provided, and none was stored statically");
		}

		if (!tempWrapper.isAlive()) {
			// The application is already dead
			return true;
		}

		tempWrapper.stop();

		try {
			tempWrapper.join(WRAPPER_KILL_TIME);
		} catch (InterruptedException exc) {
			// ignored
		}

		return !tempWrapper.isAlive();
	}

	/**
	 * Here the main method in the given class is actually launched and the wrapper is created.
	 * 
	 * @param aMainClass
	 *            the main class of the application
	 * @param aMainMethod
	 *            the main method
	 * @param someArguments
	 *            arguments to be provided to the call
	 * @return the resulting application wrapper
	 * @throws Throwable
	 *             if the shit hits the fan
	 */
	protected ApplicationWrapper launchMain(Class<?> aMainClass, Method aMainMethod, String[] someArguments)
			throws Throwable {
		ApplicationWrapper tempWrapper = new ApplicationWrapper(aMainClass, aMainMethod, someArguments);

		tempWrapper.start();

		try {
			Thread.sleep(WRAPPER_STARTUP_TIME);
		} catch (InterruptedException exc) {
			// ignored
		}

		if (!checkWrapper(tempWrapper)) {
			throw new RuntimeException("The application has not been started successfully");
		}

		return tempWrapper;
	}

	/**
	 * Checks whether a provided application wrapper is considered alive.
	 * 
	 * @param aWrapper
	 *            the wrapped application to check
	 * @return true if it is alive, false otherwise
	 * @throws Throwable
	 */
	protected boolean checkWrapper(ApplicationWrapper aWrapper) throws Throwable {
		if (!aWrapper.isAlive()) {
			Throwable tempException = aWrapper.getException();
			if (tempException != null) {
				throw new RuntimeException("Failed to invoke application main method", tempException);
			} else {
				throw new RuntimeException("The application died immediately");
			}
		}

		return true;
	}

	/**
	 * This wrapper thread is used to run the actual application.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public class ApplicationWrapper extends Thread {

		/**
		 * The main class of the application.
		 */
		private Class<?> mainClass;

		/**
		 * The main method.
		 */
		private Method mainMethod;

		/**
		 * The arguments provided to the main method call.
		 */
		private String[] arguments;

		/**
		 * Any exception which has been thrown.
		 */
		private Throwable exception;

		/**
		 * Creates an instance.
		 */
		public ApplicationWrapper(Class<?> aMainClass, Method aMainMethod, String[] someArguments) {
			mainClass = aMainClass;
			mainMethod = aMainMethod;
			arguments = someArguments;
		}

		@Override
		public String toString() {
			return "Wrapper around " + mainClass.getName();
		}

		public Throwable getException() {
			return exception;
		}

		@Override
		public void run() {
			try {
				mainMethod.invoke(null, (Object) arguments);
			} catch (InvocationTargetException exc) {
				if (exc.getCause() instanceof ThreadDeath) {
					// this one is captured and ignored, since it is expected to occur if kill() is called
				} else {
					exc.printStackTrace();
					exception = exc;
				}
			} catch (Throwable exc) {
				exc.printStackTrace();
				exception = exc;
			}
		}

	}
}
