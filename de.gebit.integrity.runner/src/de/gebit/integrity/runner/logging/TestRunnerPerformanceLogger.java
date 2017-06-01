/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.logging;

import com.google.inject.Singleton;

import de.gebit.integrity.utils.DateUtil;

/**
 * This performance logging service is used to execute several performance-critical segments of test execution. It
 * allows to print out start/end markers for the performance-relevant sections as well as their (total) duration.<br>
 * <br>
 * By default, this data is NOT logged. You can enable logging by specifying the system property
 * {@link #PERFORMANCE_LOG_ENABLE_PROPERTY} with value "true".
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
@Singleton
public class TestRunnerPerformanceLogger {

	/**
	 * The performance log category used for generic test runner related actions.
	 */
	public static final String PERFORMANCE_LOG_CATEGORY_RUNNER = "Runner";

	/**
	 * The performance log category used for fork related actions.
	 */
	public static final String PERFORMANCE_LOG_CATEGORY_FORK = "Fork";

	/**
	 * The performance log category used for remoting-related actions.
	 */
	public static final String PERFORMANCE_LOG_CATEGORY_REMOTING = "Remoting";

	/**
	 * The performance log category used for (script) loading/init-related actions.
	 */
	public static final String PERFORMANCE_LOG_CATEGORY_INIT = "Init";

	/**
	 * The system property to specify to enable performance logging.
	 */
	public static final String PERFORMANCE_LOG_ENABLE_PROPERTY = "integrity.runner.perflog";

	/**
	 * Whether performance logging has been enabled.
	 */
	private boolean performanceLoggingEnabled = Boolean
			.parseBoolean(System.getProperty(PERFORMANCE_LOG_ENABLE_PROPERTY, "false"));

	/**
	 * Executes the provided runnable and logs the time required to execute it, if performance logging is enabled.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 * @param aRunnable
	 *            the runnable to execute
	 */
	public void executeAndLog(String aCategoryName, String anActionName, Runnable aRunnable) {
		if (performanceLoggingEnabled) {
			long tempStartTime = logActionStart(aCategoryName, anActionName);
			try {
				aRunnable.run();
			} finally {
				logActionEnd(aCategoryName, anActionName, tempStartTime);
			}
		} else {
			aRunnable.run();
		}
	}

	/**
	 * Executes the provided runnable and logs the time required to execute it, if performance logging is enabled.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 * @param aRunnable
	 *            the runnable to execute
	 */
	public <R extends Object> R executeAndLog(String aCategoryName, String anActionName,
			RunnableWithResult<R> aRunnable) {
		if (performanceLoggingEnabled) {
			long tempStartTime = logActionStart(aCategoryName, anActionName);
			try {
				return aRunnable.run();
			} finally {
				logActionEnd(aCategoryName, anActionName, tempStartTime);
			}
		} else {
			return aRunnable.run();
		}
	}

	/**
	 * Executes the provided runnable and logs the time required to execute it, if performance logging is enabled.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 * @param aRunnable
	 *            the runnable to execute
	 */
	public <E extends Exception> void executeAndLog(String aCategoryName, String anActionName,
			RunnableWithException<E> aRunnable) throws E {
		if (performanceLoggingEnabled) {
			long tempStartTime = logActionStart(aCategoryName, anActionName);
			try {
				aRunnable.run();
			} finally {
				logActionEnd(aCategoryName, anActionName, tempStartTime);
			}
		} else {
			aRunnable.run();
		}
	}

	/**
	 * Executes the provided runnable and logs the time required to execute it, if performance logging is enabled.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 * @param aRunnable
	 *            the runnable to execute
	 */
	public <R extends Object, E extends Exception> R executeAndLog(String aCategoryName, String anActionName,
			RunnableWithResultAndException<R, E> aRunnable) throws E {
		if (performanceLoggingEnabled) {
			long tempStartTime = logActionStart(aCategoryName, anActionName);
			try {
				return aRunnable.run();
			} finally {
				logActionEnd(aCategoryName, anActionName, tempStartTime);
			}
		} else {
			return aRunnable.run();
		}
	}

	/**
	 * Logs the start of an action.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 */
	protected long logActionStart(String aCategoryName, String anActionName) {
		log("ACTION START: " + aCategoryName + " - " + anActionName);
		return System.nanoTime();
	}

	/**
	 * Logs the end of an action.
	 * 
	 * @param aCategoryName
	 *            the category name
	 * @param anActionName
	 *            the action name
	 */
	protected void logActionEnd(String aCategoryName, String anActionName, long aStartTime) {
		long tempDuration = System.nanoTime() - aStartTime;
		log("ACTION END: " + aCategoryName + " - " + anActionName + ", DURATION: "
				+ DateUtil.convertNanosecondTimespanToHumanReadableFormat(tempDuration, false, false));
	}

	/**
	 * Logs something.
	 * 
	 * @param aLine
	 *            the textual line to be logged
	 */
	protected void log(String aLine) {
		System.out.println("--PERFLOG--> " + aLine);
	}

	/**
	 * A runnable with a result.
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 * @param <R>
	 *            the result class
	 */
	public interface RunnableWithResult<R extends Object> {

		/**
		 * Runs the stuff.
		 * 
		 */
		R run();

	}

	/**
	 * A runnable with no result that can throw an exception.
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 * @param <E>
	 *            the exception class
	 */
	public interface RunnableWithException<E extends Exception> {

		/**
		 * Runs the stuff.
		 * 
		 * @throws E
		 */
		void run() throws E;

	}

	/**
	 * A runnable with a result that can throw an exception.
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 * @param <R>
	 *            the result class
	 * @param <E>
	 *            the exception class
	 */
	public interface RunnableWithResultAndException<R extends Object, E extends Exception> {

		/**
		 * Runs the stuff.
		 * 
		 * @throws E
		 */
		R run() throws E;

	}

}
