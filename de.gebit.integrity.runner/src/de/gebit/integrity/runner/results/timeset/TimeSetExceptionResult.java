/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.results.timeset;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Pair;

import de.gebit.integrity.dsl.ForkDefinition;

/**
 * Documents a faulty timeset operation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSetExceptionResult extends TimeSetResult {

	/**
	 * The exception message.
	 */
	private String errorMessage;

	/**
	 * The exception stack trace.
	 */
	private String exceptionStackTrace;

	/**
	 * Constructor.
	 * 
	 * @param someForks
	 *            The forks on which the time was set. The null element in the list means the master process.
	 * @param someCurrentDateTimes
	 *            A complete map of fork names (null = master) to their respective currently valid test date/time,
	 *            including the current progression speed (0.0 = static time)
	 * @param anExecutionTime
	 *            the time in msecs it took to execute the timeset
	 * @param anErrorMessage
	 *            The exception message
	 * @param anExceptionStackTrace
	 *            The exception stack trace
	 */
	public TimeSetExceptionResult(List<ForkDefinition> someForks,
			Map<String, Pair<ZonedDateTime, Double>> someCurrentDateTimes, String anErrorMessage,
			String anExceptionStackTrace, Long anExecutionTime) {
		super(someForks, someCurrentDateTimes, anExecutionTime);
		errorMessage = anErrorMessage;
		exceptionStackTrace = anExceptionStackTrace;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

}
