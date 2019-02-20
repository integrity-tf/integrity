/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.gebit.integrity.fixtures.logging.FixtureLogLevel;
import de.gebit.integrity.fixtures.logging.FixtureLogger;
import de.gebit.integrity.runner.console.intercept.ConsoleOutputInterceptor;

/**
 * The default implementation of a {@link FixtureLogger} usually used in Integrity.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
@Singleton
public class DefaultFixtureLogger implements AggregatingFixtureLogger {

	/**
	 * All logged lines are collected here.
	 */
	protected List<LogLine> loggedLines = new ArrayList<>();

	/**
	 * Only log messages that equal this level or are coarser than it will be logged.
	 */
	protected FixtureLogLevel thresholdLevel = Boolean.parseBoolean(System.getProperty(LOG_TRACE_PROPERTY, "false"))
			? FixtureLogLevel.DEBUG
			: FixtureLogLevel.TRACE;

	/**
	 * Set this system property to turn on verbose logging of fixture log output. Log output on level
	 * {@link FixtureLogLevel#TRACE} will not be actually logged otherwise, since the default level is
	 * {@link FixtureLogLevel#DEBUG}.
	 */
	public static final String LOG_TRACE_PROPERTY = "integrity.fixtures.logging.verbose";

	/**
	 * The console interceptor.
	 */
	@Inject
	protected ConsoleOutputInterceptor consoleOutputInterceptor;

	/**
	 * The prefix for fixture log lines that are being printed on the console.
	 */
	protected static final String FIXTURE_LOG_CONSOLE_PREFIX = "FIXTURE LOG -> ";

	/**
	 * Sets the threshold level interactively at runtime. Only log messages that equal this level or are coarser than it
	 * will be logged.
	 * 
	 * @param aThresholdLevel
	 *            the level to compare with
	 */
	public void setThresholdLevel(FixtureLogLevel aThresholdLevel) {
		thresholdLevel = aThresholdLevel;
	}

	@Override
	public List<LogLine> peekLines() {
		synchronized (this) {
			if (loggedLines.size() == 0) {
				return Collections.emptyList();
			}

			return new ArrayList<LogLine>(loggedLines);
		}
	}

	@Override
	public List<LogLine> popLines() {
		synchronized (this) {
			if (loggedLines.size() == 0) {
				return Collections.emptyList();
			}

			List<LogLine> tempResult = loggedLines;
			loggedLines = new ArrayList<>();
			return tempResult;
		}
	}

	@Override
	public void log(FixtureLogLevel aLevel, String aMessage, Object... someParameters) {
		if (aLevel == null || aLevel.isFinerThan(thresholdLevel)) {
			return;
		}

		Throwable tempThrowable = null;
		if (someParameters.length > 0) {
			Object tempLastParam = someParameters[someParameters.length - 1];
			if (tempLastParam instanceof Throwable) {
				tempThrowable = (Throwable) tempLastParam;
			}
		}

		LogLine tempNewLine = new LogLine(replaceParameterPlaceholders(aMessage, someParameters), aLevel);
		List<LogLine> tempThrowableLines = null;
		if (tempThrowable != null) {
			tempThrowableLines = stackTraceToLogLines(tempThrowable, aLevel);
		}

		printLogLine(tempNewLine);
		if (tempThrowableLines != null) {
			for (LogLine tempLine : tempThrowableLines) {
				printLogLine(tempLine);
			}
		}

		synchronized (this) {
			loggedLines.add(tempNewLine);
			if (tempThrowableLines != null) {
				loggedLines.addAll(tempThrowableLines);
			}
		}
	}

	/**
	 * Prints the log line on the console.
	 * 
	 * @param aLine
	 */
	protected void printLogLine(LogLine aLine) {
		// We don't want this to be intercepted, so we print it to the "real" stdout stream via the interceptor
		consoleOutputInterceptor.printlnStdOut(FIXTURE_LOG_CONSOLE_PREFIX + aLine);
	}

	/**
	 * Formats a stack trace into a list of log lines. This is more convenient for fixture logging purposes, even though
	 * it breaks with some common conventions regarding stack trace logging.
	 * 
	 * @param anException
	 *            the exception from which to get the stack trace
	 * @return the stack trace as a list of {@link LogLine}s
	 */
	protected List<LogLine> stackTraceToLogLines(Throwable anException, FixtureLogLevel aLevel) {
		StringWriter tempStringWriter = null;
		PrintWriter tempPrintWriter = null;
		String tempResult;
		try {
			tempStringWriter = new StringWriter();
			tempPrintWriter = new PrintWriter(tempStringWriter);
			anException.printStackTrace(tempPrintWriter);
			tempResult = tempStringWriter.toString();
		} finally {
			try {
				if (tempPrintWriter != null) {
					tempPrintWriter.close();
				}
				if (tempStringWriter != null) {
					tempStringWriter.close();
				}
			} catch (IOException exc) {
				// nothing to do, since this cannot happen
			}
		}

		List<LogLine> tempResults = new ArrayList<>();
		for (String tempLine : tempResult.split("[\\r\\n]+")) {
			tempResults.add(new LogLine(tempLine, aLevel));
		}

		return tempResults;
	}

	@Override
	public void error(String aMessage, Object... someParameters) {
		log(FixtureLogLevel.ERROR, aMessage, someParameters);
	}

	@Override
	public void warn(String aMessage, Object... someParameters) {
		log(FixtureLogLevel.WARNING, aMessage, someParameters);
	}

	@Override
	public void info(String aMessage, Object... someParameters) {
		log(FixtureLogLevel.INFO, aMessage, someParameters);
	}

	@Override
	public void debug(String aMessage, Object... someParameters) {
		log(FixtureLogLevel.DEBUG, aMessage, someParameters);
	}

	@Override
	public void trace(String aMessage, Object... someParameters) {
		log(FixtureLogLevel.TRACE, aMessage, someParameters);
	}

	// The following code performs parameter replacement
	// -----------------------------------------------------------------------------------

	/**
	 * Parameter placeholders are started with this char.
	 */
	protected static final char PARAM_START = '{';

	/**
	 * Parameter placeholders end with this char.
	 */
	protected static final char PARAM_STOP = '}';

	/**
	 * This string is the parameter placeholder.
	 */
	protected static final String PARAM_STR = "{}";

	/**
	 * The escape character, which can be used to actually put the {@link #PARAM_STR} pattern into a log message without
	 * it being replaced. It can itself be escaped by prepending it with itself.
	 */
	protected static final char ESCAPE_CHAR = '\\';

	/**
	 * Replaces all parameter placeholders in the given message with the given parameters.
	 * 
	 * @param aMessage
	 *            the message to process
	 * @param someParameters
	 *            the parameters to insert
	 * @return the finished message
	 */
	protected String replaceParameterPlaceholders(String aMessage, Object... someParameters) {
		if (aMessage == null) {
			return null;
		}
		if (someParameters.length == 0) {
			return aMessage;
		}

		int tempLastParamPos = 0;
		int tempNextParamPos;
		StringBuilder tempBuffer = new StringBuilder(aMessage.length() + someParameters.length * 20);

		int tempArrayPos;
		for (tempArrayPos = 0; tempArrayPos < someParameters.length; tempArrayPos++) {
			tempNextParamPos = aMessage.indexOf(PARAM_STR, tempLastParamPos);

			if (tempNextParamPos == -1) {
				if (tempLastParamPos == 0) {
					return aMessage;
				} else {
					tempBuffer.append(aMessage, tempLastParamPos, aMessage.length());
					return tempBuffer.toString();
				}
			} else {
				if (tempNextParamPos > 0 && aMessage.charAt(tempNextParamPos - 1) == ESCAPE_CHAR) {
					// This parameter start character is escaped
					if (!(tempNextParamPos - 1 > 0 && aMessage.charAt(tempNextParamPos - 2) == ESCAPE_CHAR)) {
						// The escape char is not also escaped -> parameter start char is escaped
						tempArrayPos--;
						tempBuffer.append(aMessage, tempLastParamPos, tempNextParamPos - 1);
						tempBuffer.append(PARAM_START);
						tempLastParamPos = tempNextParamPos + 1;
					} else {
						// The escape char is escaped -> parameter start char is NOT escaped
						tempBuffer.append(aMessage, tempLastParamPos, tempNextParamPos - 1);
						appendParameter(tempBuffer, someParameters[tempArrayPos]);
						tempLastParamPos = tempNextParamPos + 2;
					}
				} else {
					// Nothing is escaped -> this is the usual path
					tempBuffer.append(aMessage, tempLastParamPos, tempNextParamPos);
					appendParameter(tempBuffer, someParameters[tempArrayPos]);
					tempLastParamPos = tempNextParamPos + 2;
				}
			}
		}

		// Append remaining chars
		tempBuffer.append(aMessage, tempLastParamPos, aMessage.length());

		return tempBuffer.toString();
	}

	/**
	 * Appends the given parameter (which can be an array or a single object).
	 * 
	 * @param aBuffer
	 *            the buffer to append to
	 * @param aParam
	 *            the parameter
	 */
	protected void appendParameter(StringBuilder aBuffer, Object aParam) {
		if (aParam == null) {
			aBuffer.append("null");
			return;
		}
		if (!aParam.getClass().isArray()) {
			appendSimpleObjectParameter(aBuffer, aParam);
		} else {
			aBuffer.append("[");
			for (int i = 0; i < Array.getLength(aParam); i++) {
				if (i > 0) {
					aBuffer.append(", ");
				}
				appendSimpleObjectParameter(aBuffer, Array.get(aParam, i));
			}
			aBuffer.append("]");
		}
	}

	/**
	 * Appends the given parameter, which at this point must be a single object.
	 * 
	 * @param aBuffer
	 *            the buffer to append to
	 * @param aParam
	 *            the parameter
	 */
	protected void appendSimpleObjectParameter(StringBuilder aBuffer, Object aParam) {
		try {
			aBuffer.append(aParam.toString());
		} catch (Throwable exc) {
			aBuffer.append("[FAILED toString() with " + exc.getClass().toString() + ": " + exc.getMessage() + "]");
		}
	}

}
