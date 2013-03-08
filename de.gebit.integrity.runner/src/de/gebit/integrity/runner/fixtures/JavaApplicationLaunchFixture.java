/**
 * 
 */
package de.gebit.integrity.runner.fixtures;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.inject.Inject;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * Generic fixture usable to start, check and kill a Java application class with a static main method.
 * 
 * @author Rene Schneider
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FixtureMethod(description = "Launch Java Application: $mainClass$")
	public ApplicationWrapper launch(@FixtureParameter(name = "mainClass") String aMainClassName,
			@FixtureParameter(name = "arguments") String[] someArguments) throws Throwable {
		if (aMainClassName == null) {
			throw new IllegalArgumentException("A class name has to be provided.");
		}

		Class tempMainClass = classLoader.loadClass(aMainClassName);
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
		ApplicationWrapper tempWrapper = aWrapper != null ? aWrapper : lastApplication;

		if (tempWrapper == null) {
			throw new IllegalArgumentException("No application was provided, and none was stored statically");
		}

		return tempWrapper.isAlive();
	}

	@SuppressWarnings("deprecation")
	// Deprecation is known, but there's no other way in this case...
	@FixtureMethod(description = "Kills the application")
	public boolean kill(@FixtureParameter(name = "application") ApplicationWrapper aWrapper) {
		ApplicationWrapper tempWrapper = aWrapper != null ? aWrapper : lastApplication;

		if (tempWrapper == null) {
			throw new IllegalArgumentException("No application was provided, and none was stored statically");
		}

		if (!tempWrapper.isAlive()) {
			return false;
		}

		tempWrapper.stop();

		try {
			tempWrapper.join(WRAPPER_KILL_TIME);
		} catch (InterruptedException exc) {
			// ignored
		}

		return !tempWrapper.isAlive();
	}

	protected ApplicationWrapper launchMain(Class<?> aMainClass, Method aMainMethod, String[] someArguments)
			throws Throwable {
		ApplicationWrapper tempWrapper = new ApplicationWrapper(aMainClass, aMainMethod, someArguments);

		tempWrapper.start();

		try {
			Thread.sleep(WRAPPER_STARTUP_TIME);
		} catch (InterruptedException exc) {
			// ignored
		}

		checkWrapper(tempWrapper);

		return tempWrapper;
	}

	protected void checkWrapper(ApplicationWrapper aWrapper) throws Throwable {
		if (!aWrapper.isAlive()) {
			Throwable tempException = aWrapper.getException();
			if (tempException != null) {
				throw new RuntimeException("Failed to invoke application main method", tempException);
			} else {
				throw new RuntimeException("The application died immediately");
			}
		}
	}

	/**
	 * This wrapper thread is used to run the actual application.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	protected class ApplicationWrapper extends Thread {

		private Class mainClass;

		private Method mainMethod;

		private String[] arguments;

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
