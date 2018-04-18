/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import de.gebit.integrity.runner.time.TimeSyncState;

/**
 * A default forking implementation. This should be suitable for most execution environments. If not, it is designed to
 * be easily extensible, or alternatively you can of course create an entirely own {@link Forker} implementation.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultForker implements Forker {

	/**
	 * Name and path of the Java executable to use for starting a new JVM.
	 */
	private static final String JAVA_EXECUTABLE = System.getProperties().getProperty("java.home") + File.separatorChar
			+ "bin" + File.separatorChar + "java";

	@Override
	public ForkedProcess fork(String[] someCommandLineArguments, String aForkName, long aRandomSeed,
			TimeSyncState aTimeSyncState) throws ForkException {
		List<String> tempArgs = createArgumentList(someCommandLineArguments, aForkName, aRandomSeed, aTimeSyncState);
		return createProcess(tempArgs);
	}

	/**
	 * Creates the argument list used to fork the process.
	 * 
	 * @param someCommandLineArguments
	 *            the command line arguments provided to {@link #fork(String[], int, String)}.
	 * @param aForkName
	 *            the name for the new fork
	 * @param aRandomSeed
	 *            the seed for the RNG of the fork
	 * @param aTimeSyncState
	 *            time synchronization state info for this particular fork (will be provided just in case the forker or
	 *            fork wants to do something with it - time synchronization also happens right after the connection to
	 *            the fork was established by the master) or null if no test time sync state is to be set
	 * @return the argument list
	 */
	protected List<String> createArgumentList(String[] someCommandLineArguments, String aForkName, long aRandomSeed,
			TimeSyncState aTimeSyncState) {
		List<String> tempArgs = new ArrayList<String>();

		addJavaExecutable(tempArgs);

		addClassPath(tempArgs);

		addForkInformation(tempArgs, aForkName, aRandomSeed, aTimeSyncState);

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
	 * @param aForkName
	 *            the name for the fork
	 * @param aRandomSeed
	 *            the seed for the RNG of the fork
	 * @param aTimeSyncState
	 *            time synchronization state info for this particular fork (will be provided just in case the fork wants
	 *            to do something with it - time synchronization also happens right after the connection to the fork was
	 *            established by the master) or null if no test time sync state is to be provided
	 */
	protected void addForkInformation(List<String> anArgumentList, String aForkName, long aRandomSeed,
			TimeSyncState aTimeSyncState) {
		if (getForkHost() != null) {
			anArgumentList.add("-D" + Forker.SYSPARAM_FORK_REMOTING_HOST + "=" + getForkHost());
		}
		if (getForkPort() != null) {
			anArgumentList.add("-D" + Forker.SYSPARAM_FORK_REMOTING_PORT + "=" + getForkPort());
		}

		anArgumentList.add("-D" + Forker.SYSPARAM_FORK_NAME + "=" + aForkName);
		anArgumentList.add("-D" + Forker.SYSPARAM_FORK_SEED + "=" + aRandomSeed);

		addTimeSyncInformation(anArgumentList, aTimeSyncState);
	}

	/**
	 * Adds time sync information, if provided for this fork.
	 * 
	 * @param anArgumentList
	 *            the argument list to extend
	 * @param aTimeSyncState
	 *            time synchronization state info for this particular fork (will be provided just in case the fork wants
	 *            to do something with it - time synchronization also happens right after the connection to the fork was
	 *            established by the master) or null if no test time sync state is to be provided
	 */
	protected void addTimeSyncInformation(List<String> anArgumentList, TimeSyncState aTimeSyncState) {
		if (aTimeSyncState != null) {
			anArgumentList.add("-D" + Forker.SYSPARAM_FORK_TIMESTATE + "=" + aTimeSyncState.getValuesAsString());
		}
	}

	/**
	 * The host name / IP to which the fork should be bound.
	 * 
	 * @return
	 */
	protected String getForkHost() {
		return "localhost";
	}

	/**
	 * The port to which the fork should be bound.
	 * 
	 * @return
	 */
	protected Integer getForkPort() {
		return 0;
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
