/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.messages;

/**
 * Sent to synchronize the artificial test time on the different systems.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSyncStateMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1953587649682891129L;

	/**
	 * The offset from realtime in msecs.
	 */
	private long realtimeOffset;

	/**
	 * The time at which our test time tracking was decoupled from realtime, in msecs.
	 */
	private long realtimeDecouplingTime;

	/**
	 * The multiplier by which time moves forward.
	 */
	private double progressionFactor;

	/**
	 * Constructor.
	 */
	public TimeSyncStateMessage() {
		// no-arg constructor
	}

	/**
	 * Constructor.
	 * 
	 * @param realtimeOffset
	 * @param realtimeDecouplingTime
	 * @param multiplier
	 */
	public TimeSyncStateMessage(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
		super();
		this.realtimeOffset = aRealtimeOffset;
		this.realtimeDecouplingTime = aRealtimeDecouplingTime;
		this.progressionFactor = aProgressionFactor;
	}

	public double getProgressionFactor() {
		return progressionFactor;
	}

	public long getRealtimeDecouplingTime() {
		return realtimeDecouplingTime;
	}

	public long getRealtimeOffset() {
		return realtimeOffset;
	}

}
