/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * A response to {@link TimeSyncRequestMessage}.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSyncResultMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 2543255984131293038L;

	/**
	 * In case of errors during time sync, this contains the error message. If null, time sync is assumed to be
	 * successful.
	 */
	private String errorMessage;

	/**
	 * In case of errors during time sync, this contains the stack trace. Can only be non-null if {@link #errorMessage}
	 * is non-null.
	 */
	private String stackTrace;

	/**
	 * The results in case of a successful timesync application. This field is used in two contexts: either there is
	 * just a single result (in case the {@link TimeSyncResultMessage} documents the execution of a single time syncing
	 * on a fork that is returned to the master) or it contains all results from all forks (in case of the documentation
	 * of the final result of a timesync command execution that is returned from the master to a fork).
	 */
	private List<TimeSyncForkResult> results = new ArrayList<>(0);

	/**
	 * Constructor.
	 */
	public TimeSyncResultMessage() {
		// no-arg constructor
	}

	/**
	 * Constructs an instance.
	 * 
	 * @param aStartDate
	 * @param aProgressionFactor
	 */
	public TimeSyncResultMessage(String anErrorMessage, String aStackTrace) {
		errorMessage = anErrorMessage;
		stackTrace = aStackTrace;
	}

	/**
	 * Constructs an instance with a result collection.
	 * 
	 * @param someResults
	 */
	public TimeSyncResultMessage(Collection<TimeSyncForkResult> someResults) {
		results = new ArrayList<TimeSyncForkResult>(someResults);
	}

	/**
	 * Constructs an instance with a single result.
	 * 
	 * @param aResult
	 */
	public TimeSyncResultMessage(TimeSyncForkResult aResult) {
		results = Collections.singletonList(aResult);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public List<TimeSyncForkResult> getResults() {
		return results;
	}

	/**
	 * Gets the results as a {@link Map}.
	 * 
	 * @return
	 */
	public Map<String, Pair<ZonedDateTime, Double>> getResultMap() {
		Map<String, Pair<ZonedDateTime, Double>> tempResultMap = new HashMap<String, Pair<ZonedDateTime, Double>>();

		for (TimeSyncForkResult tempResult : results) {
			tempResultMap.put(tempResult.getForkName(),
					Tuples.create(tempResult.getTestTime(), tempResult.getProgressionFactor()));
		}

		return tempResultMap;
	}

	/**
	 * Encapsulates the "result" of a successful timesync application for a specific fork.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	public static class TimeSyncForkResult implements Serializable {

		/**
		 * The serial version.
		 */
		private static final long serialVersionUID = 1853118000049342954L;

		/**
		 * The name of the fork (null = master).
		 */
		private String forkName;

		/**
		 * The current test time AFTER applying the timesync command.
		 */
		private ZonedDateTime testTime;

		/**
		 * The progression factor for time (0.0 = fixed test time).
		 */
		private double progressionFactor;

		/**
		 * Constructor.
		 * 
		 * @param aForkName
		 * @param aTestTime
		 * @param aProgressionFactor
		 */
		public TimeSyncForkResult(String aForkName, ZonedDateTime aTestTime, Double aProgressionFactor) {
			forkName = aForkName;
			testTime = aTestTime;
			progressionFactor = aProgressionFactor;
		}

		/**
		 * No-arg constructor.
		 */
		public TimeSyncForkResult() {
			// no-arg constructor
		}

		public String getForkName() {
			return forkName;
		}

		public ZonedDateTime getTestTime() {
			return testTime;
		}

		public double getProgressionFactor() {
			return progressionFactor;
		}

	}

}
