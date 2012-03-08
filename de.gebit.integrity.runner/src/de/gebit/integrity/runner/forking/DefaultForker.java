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
 * A default forking implementation. This should be suitable for most execution environments.
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
		List<String> tempArgs = new ArrayList<String>();
		tempArgs.add(JAVA_EXECUTABLE);

		String tempClasspath = System.getProperty("java.class.path");
		if (tempClasspath != null && tempClasspath.length() > 0) {
			tempArgs.add("-cp");
			tempArgs.add(tempClasspath);
		}

		tempArgs.add("-D" + Forker.SYSPARAM_FORK_REMOTING_PORT + "=" + aPortNumber);
		tempArgs.add("-D" + Forker.SYSPARAM_FORK_NAME + "=" + aForkName);

		RuntimeMXBean tempMXBean = ManagementFactory.getRuntimeMXBean();
		for (String tempArg : tempMXBean.getInputArguments()) {
			// filter out Eclipse debug stuff
			if (!tempArg.startsWith("-agentlib:jdwp=transport=dt_socket,suspend=y,address=localhost:")) {
				tempArgs.add(tempArg);
			}
		}

		tempArgs.add(guessMainClassName());

		if (someCommandLineArguments != null) {
			for (String tempCommandLineArgument : someCommandLineArguments) {
				tempArgs.add(tempCommandLineArgument);
			}
		}

		ProcessBuilder tempBuilder = new ProcessBuilder(tempArgs);
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
