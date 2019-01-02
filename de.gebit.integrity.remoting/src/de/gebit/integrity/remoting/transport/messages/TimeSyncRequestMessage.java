/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.math.BigDecimal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import org.eclipse.xtext.util.Pair;

/**
 * Sent to synchronize the artificial test time on the different systems.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSyncRequestMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = -2752866661789376914L;

	/**
	 * The start date.
	 */
	private Date startDate;

	/**
	 * The time difference.
	 */
	private List<Pair<Long, TemporalUnit>> diffTime;

	/**
	 * The progression factor.
	 */
	private BigDecimal progressionFactor;

	/**
	 * The forks that this update is geared towards.
	 */
	private String[] targetedForks;

	/**
	 * Constructor.
	 */
	public TimeSyncRequestMessage() {
		// no-arg constructor
	}

	/**
	 * Constructs an instance.
	 * 
	 * @param aStartDate
	 * @param aProgressionFactor
	 */
	public TimeSyncRequestMessage(Date aStartDate, List<Pair<Long, TemporalUnit>> aDiffTime,
			BigDecimal aProgressionFactor, String[] someTargetedForks) {
		startDate = aStartDate;
		diffTime = aDiffTime;
		progressionFactor = aProgressionFactor;
		targetedForks = someTargetedForks;
	}

	public Date getStartDate() {
		return startDate;
	}

	public List<Pair<Long, TemporalUnit>> getDiffTime() {
		return diffTime;
	}

	public BigDecimal getProgressionFactor() {
		return progressionFactor;
	}

	public String[] getTargetedForks() {
		return targetedForks;
	}

}
