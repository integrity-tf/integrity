/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures.logging;

/**
 * The fixture logger should be used by fixture classes and methods in order to log stuff that does NOT originate from
 * within the application under test itself, but from within the fixture logic.
 * <p>
 * Fixture log output is collected separately from the applications' log output (from the console), which allows to get
 * both log streams displayed in a separated fashion in the test result.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface FixtureLogger {

	/**
	 * Log the specified message at the specified log level. The message may contain placeholders "{}" which will be
	 * replaced by the respective parameter provided (order of parameters is mapped onto order of placeholders).
	 * Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aLevel
	 *            the log level
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void log(FixtureLogLevel aLevel, String aMessage, Object... someParameters);

	/**
	 * Log the specified message at {@link FixtureLogLevel#ERROR} level. The message may contain placeholders "{}" which
	 * will be replaced by the respective parameter provided (order of parameters is mapped onto order of placeholders).
	 * Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void error(String aMessage, Object... someParameters);

	/**
	 * Log the specified message at {@link FixtureLogLevel#WARNING} level. The message may contain placeholders "{}"
	 * which will be replaced by the respective parameter provided (order of parameters is mapped onto order of
	 * placeholders). Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void warn(String aMessage, Object... someParameters);

	/**
	 * Log the specified message at {@link FixtureLogLevel#INFO} level. The message may contain placeholders "{}" which
	 * will be replaced by the respective parameter provided (order of parameters is mapped onto order of placeholders).
	 * Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void info(String aMessage, Object... someParameters);

	/**
	 * Log the specified message at {@link FixtureLogLevel#DEBUG} level. The message may contain placeholders "{}" which
	 * will be replaced by the respective parameter provided (order of parameters is mapped onto order of placeholders).
	 * Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void debug(String aMessage, Object... someParameters);

	/**
	 * Log the specified message at {@link FixtureLogLevel#TRACE} level. The message may contain placeholders "{}" which
	 * will be replaced by the respective parameter provided (order of parameters is mapped onto order of placeholders).
	 * Non-String parameters are converted to {@link String}s by calling toString().
	 * <p>
	 * An exception is the last parameter: if it is a {@link Throwable}, it is not considered to be a "normal" parameter
	 * for a placeholder. Instead, the stacktrace of the {@link Throwable} is logged as part of the log message.
	 * 
	 * @param aMessage
	 *            the message to log (possibly with placeholders)
	 * @param someParameters
	 *            parameters to insert into placeholders, optionally a {@link Throwable} at the end of the list
	 */
	void trace(String aMessage, Object... someParameters);

}
