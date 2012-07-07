/**
 * 
 */
package de.gebit.integrity.runner.forking;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * A default forking implementation. This should be suitable for most execution environments. If not, it is designed to
 * be easily extensible, or alternatively you can of course create an entirely own {@link Forker} implementation.
 * 
 * @author Rene Schneider
 * 
 */
public class DefaultForker implements Forker {

	/**
	 * Name and path of the Java executable to use for starting a new JVM.
	 */
	private static final String JAVA_EXECUTABLE = System.getProperties().getProperty("java.home") + File.separatorChar
			+ "bin" + File.separatorChar + "java";

	@Override
	public ForkedProcess fork(String[] someCommandLineArguments, int aPortNumber, String aForkName)
			throws ForkException {

		List<String> tempArgs = createArgumentList(someCommandLineArguments, aPortNumber, aForkName);
		return createProcess(tempArgs);
	}

	/**
	 * Creates the argument list used to fork the process.
	 * 
	 * @param someCommandLineArguments
	 *            the command line arguments provided to {@link #fork(String[], int, String)}.
	 * @param aPortNumber
	 *            the port number to use by the fork
	 * @param aForkName
	 *            the name for the new fork
	 * @return the argument list
	 */
	protected List<String> createArgumentList(String[] someCommandLineArguments, int aPortNumber, String aForkName) {
		List<String> tempArgs = new ArrayList<String>();

		addJavaExecutable(tempArgs);

		addClassPath(tempArgs);

		addForkInformation(tempArgs, aPortNumber, aForkName);

		addJVMArguments(tempArgs);

		addClassName(tempArgs);

		addApplicationArguments(tempArgs, someCommandLineArguments);

		return tempArgs;
	}

	/**
	 * Adds the name of the java executable to the argument list provided. Default implementation tries to determine
	 * this using the system property "java.home".
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 */
	protected void addJavaExecutable(List<String> anArgumentList) {
		anArgumentList.add(JAVA_EXECUTABLE);
	}

	/**
	 * Adds the classpath parameter to the argument list. Default implementation uses the system property
	 * "java.class.path".
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 */
	protected void addClassPath(List<String> anArgumentList) {
		String tempClasspath = System.getProperty("java.class.path");
		if (tempClasspath != null && tempClasspath.length() > 0) {
			anArgumentList.add("-cp");
			anArgumentList.add(tempClasspath);
		}
	}

	/**
	 * Adds the system property definitions telling the fork on which port it should listen and which name it has.
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 * @param aPortNumber
	 *            the port number for the fork
	 * @param aForkName
	 *            the name for the fork
	 */
	protected void addForkInformation(List<String> anArgumentList, int aPortNumber, String aForkName) {
		anArgumentList.add("-D" + Forker.SYSPARAM_FORK_REMOTING_PORT + "=" + aPortNumber);
		anArgumentList.add("-D" + Forker.SYSPARAM_FORK_NAME + "=" + aForkName);
	}

	/**
	 * Adds any random JVM configuration arguments to the argument list. Default implementation asks the
	 * {@link RuntimeMXBean}.
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 */
	protected void addJVMArguments(List<String> anArgumentList) {
		RuntimeMXBean tempMXBean = ManagementFactory.getRuntimeMXBean();
		for (String tempArg : tempMXBean.getInputArguments()) {
			// filter out Eclipse debug stuff
			if (!tempArg.startsWith("-agentlib:jdwp=transport=dt_socket,suspend=y,address=localhost:")) {
				anArgumentList.add(tempArg);
			}
		}
	}

	/**
	 * Adds the name of the main class to the argument list. Default implementation uses {@link #guessMainClassName()}
	 * to search stack traces for the class.
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 */
	protected void addClassName(List<String> anArgumentList) {
		anArgumentList.add(guessMainClassName());
	}

	/**
	 * Adds the application-specific arguments to the argument list.
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 * @param someCommandLineArguments
	 *            the applications' arguments, as provided to Integrity
	 */
	protected void addApplicationArguments(List<String> anArgumentList, String[] someCommandLineArguments) {
		if (someCommandLineArguments != null) {
			for (String tempCommandLineArgument : someCommandLineArguments) {
				anArgumentList.add(tempCommandLineArgument);
			}
		}
	}

	/**
	 * Create a process using the given argument list.
	 * 
	 * @param anArgumentList
	 *            the arguments
	 * @return the forked process
	 * @throws ForkException
	 */
	protected LocalForkedProcess createProcess(List<String> anArgumentList) throws ForkException {
		ProcessBuilder tempBuilder = new ProcessBuilder(anArgumentList);
		try {
			return new LocalForkedProcess(tempBuilder.start());
		} catch (IOException exc) {
			throw new ForkException("Error forking process", exc);
		}
	}

	/**
	 * Tries to determine the fully qualified name of the main class, since you cannot ask the JVM for it unfortunately.
	 * 
	 * @return the name of the main class
	 */
	protected String guessMainClassName() {
		for (Entry<Thread, StackTraceElement[]> tempEntry : Thread.getAllStackTraces().entrySet()) {
			if ("main".equals(tempEntry.getKey().getName().toLowerCase())) {
				return tempEntry.getValue()[tempEntry.getValue().length - 1].getClassName();
			}
		}

		throw new UnsupportedOperationException(
				"Could not determine main class name. You probably need to implement your own Forker in order to use forking!");
	}
}
