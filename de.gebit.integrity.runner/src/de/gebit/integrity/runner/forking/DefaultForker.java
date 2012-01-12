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
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class DefaultForker implements Forker {

	private static final String JAVA_EXECUTABLE = System.getProperties().getProperty("java.home") + File.separatorChar
			+ "bin" + File.separatorChar + "java";

	@Override
	public Process fork(String[] someCommandLineArguments, int aPortNumber, String aForkName) throws ForkException {
		List<String> tempArgs = new ArrayList<String>();
		tempArgs.add(JAVA_EXECUTABLE);

		String tempClasspath = System.getProperty("java.class.path");
		if (tempClasspath != null && tempClasspath.length() > 0) {
			tempArgs.add("-cp");
			tempArgs.add(tempClasspath);
		}

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
		tempBuilder.environment().put(Forker.ENV_FORK_REMOTING_PORT, Integer.toString(aPortNumber));
		tempBuilder.environment().put(Forker.ENV_FORK_NAME, aForkName);
		try {
			return tempBuilder.start();
		} catch (IOException exc) {
			throw new ForkException("Error forking process", exc);
		}
	}

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
