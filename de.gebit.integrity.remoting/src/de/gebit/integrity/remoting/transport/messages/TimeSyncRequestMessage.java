/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

import java.math.BigDecimal;
import java.util.Date;

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
	private static final long serialVersionUID = -2752866661789676914L;

	/**
	 * The start date.
	 */
	private Date startDate;

	/**
	 * The progression factor.
	 */
	private BigDecimal progressionFactor;

	/**
	 * The forks that this update is geared towards.
	 */
	private String[] targetedForks;

	/**
	 * Constructs an instance.
	 * 
	 * @param aStartDate
	 * @param aProgressionFactor
	 */
	public TimeSyncRequestMessage(Date aStartDate, BigDecimal aProgressionFactor, String[] someTargetedForks) {
		startDate = aStartDate;
		progressionFactor = aProgressionFactor;
		targetedForks = someTargetedForks;
	}

	public Date getStartDate() {
		return startDate;
	}

	public BigDecimal getProgressionFactor() {
		return progressionFactor;
	}

	public String[] getTargetedForks() {
		return targetedForks;
	}

}
