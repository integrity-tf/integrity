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
import de.gebit.integrity.runner.results.Result;

/**
 * Stores the results of a timeset operation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public abstract class TimeSetResult extends Result {

	/**
	 * The forks on which the time was set. The null element in the list means the master process.
	 */
	private List<ForkDefinition> forks;

	/**
	 * A complete map of fork names (null = master) to their respective currently valid test date/time, including the
	 * current progression speed (0.0 = static time)
	 */
	private Map<String, Pair<ZonedDateTime, Double>> currentDateTimes;

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
	 */
	public TimeSetResult(List<ForkDefinition> someForks, Map<String, Pair<ZonedDateTime, Double>> someCurrentDateTimes,
			Long anExecutionTime) {
		super(anExecutionTime);
		forks = someForks;
		currentDateTimes = someCurrentDateTimes;
	}

	public List<ForkDefinition> getForks() {
		return forks;
	}

	public Map<String, Pair<ZonedDateTime, Double>> getCurrentDateTimes() {
		return currentDateTimes;
	}

}
