/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.time;

/**
 * An object encapsulating the necessary internal parameters for fake test time generation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TimeSyncState {

	/**
	 * The offset from realtime, in msecs since 1.1.1970.
	 */
	private long realtimeOffset;

	/**
	 * The time at which the fake time was decoupled from realtime, in msecs since 1.1.1970.
	 */
	private long realtimeDecouplingTime;

	/**
	 * A time progression factor (1.0 = realtime, 0.0 = frozen).
	 */
	private double progressionFactor;

	/**
	 * Constructor.
	 * 
	 * @param aRealtimeOffset
	 * @param aRealtimeDecouplingTime
	 * @param aProgressionFactor
	 */
	public TimeSyncState(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
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
