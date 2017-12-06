/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.time;

import java.util.Date;

/**
 * This singleton is designed to make time-sensitive processes testable by allowing to set the "current time" to a
 * certain fixed time or a certain start time from which the "current time" progresses at a configurable speed.
 * <p>
 * Applications which need to operate on date specific data should use
 * <tt>TimeAndDateSingleton.getInstance().getDate()</tt> rather than creating a new Date with
 * <tt>new java.util.Date();</tt>. In order to test that application code later, a fixed date can be used rather than
 * the current date by assigning the date to use with <tt>TimeAndDateSingleton.setDate(aDate)</tt>. <br>
 * <br>
 * This is more a sample implementation than it is intended to be actually used directly as-is in an application. You
 * are better advised at copying this class into your application, so you won't depend on Integrity JARs during runtime.
 * See the {@link SimpleTestTimeAdapter} class and the interface {@link TestTimeAdapter} for more information.
 * 
 * @author Author: Rene Schneider - initial API and implementation
 */
public final class TimeAndDateSingleton implements TestTimeAdapter {

	/**
	 * The singleton instance.
	 */
	protected static volatile TimeAndDateSingleton instance = new TimeAndDateSingleton();

	public static TimeAndDateSingleton getInstance() {
		return instance;
	}

	/**
	 * The timekeeper instance used to calculate the "test time". If null, real time is to be used.
	 */
	private TimeKeeper timeKeeper;

	/**
	 * Ensure that no instance can be created from outside.
	 */
	protected TimeAndDateSingleton() {
		// empty
	}

	/**
	 * <h2>ONLY FOR TEST PURPOSES</h2> Configure a progressing date, starting at a certain start date, which then
	 * progresses at a configurable speed.
	 * 
	 * @param aDate
	 *            the start date
	 * @param aTimeProgressionFactor
	 *            the speed at which time progresses (1.0 is "realtime").
	 */
	public void setProgressingDate(Date aDate, double aTimeProgressionFactor) {
		timeKeeper = new TimeKeeper(aDate.getTime(), aTimeProgressionFactor);
	}

	/**
	 * <h2>ONLY FOR TEST PURPOSES</h2> Change the progression factor of time. This only has an effect if the date was
	 * configured to a progressing date before by calling {@link #setProgressingDate(Date, double)}.
	 * 
	 * @param aTimeProgressionFactor
	 *            the speed at which time progresses (1.0 is "realtime").
	 */
	public void setProgressionFactor(double aTimeProgressionFactor) {
		if (timeKeeper != null) {
			timeKeeper.setMultiplier(aTimeProgressionFactor);
		}
	}

	/**
	 * <h2>ONLY FOR TEST PURPOSES</h2> Sets the "current date" to a static date.
	 * 
	 * @param aDate
	 *            the static date to set (null resets the date to the actual date; see also {@link #reset()})
	 */
	public void setDate(Date aDate) {
		if (aDate == null) {
			reset();
		} else {
			timeKeeper = new TimeKeeper(aDate.getTime(), 0.0);
		}
	}

	/**
	 * <h2>ONLY FOR TEST PURPOSES</h2> Resets any configured static or progressing date. The singleton will then return
	 * the actual date again.
	 */
	public void reset() {
		timeKeeper = null;
	}

	/**
	 * <h2>ONLY FOR TEST PURPOSES</h2> Directly sets the internal values of the timekeeper. Intended to be used by the
	 * Integrity Test Framework.
	 * 
	 * @param aRealtimeOffset
	 * @param aRealtimeDecouplingTime
	 * @param aProgressionFactor
	 */
	@Override
	public void setInternalState(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
		if (aRealtimeOffset == 0 && aProgressionFactor == 1.0) {
			// Special case: fake test time is deactivated
			timeKeeper = null;
		} else {
			timeKeeper = new TimeKeeper(aRealtimeOffset, aRealtimeDecouplingTime, aProgressionFactor);
		}
	}

	/**
	 * Returns the current system date or - if a static or progressing "fake" date was set - this fake date for testing
	 * purposes.
	 * 
	 * @return
	 */
	public Date getDate() {
		return new Date(currentTimeMillis());
	}

	/**
	 * The replacement for {@link System#currentTimeMillis()}. Returns either the actual value or, if the time was
	 * overridden for testing, the "fake testing time".
	 * 
	 * @return
	 */
	public long currentTimeMillis() {
		try {
			if (timeKeeper != null) {
				return timeKeeper.currentTimeMillis();
			}
		} catch (NullPointerException exc) {
			// Can theoretically happen in multithreaded scenarios, if someone nulls the object right after the null
			// check, but before actual usage. In that case, just re-enter the method and evaluate again.
			return currentTimeMillis();
		}

		return System.currentTimeMillis();
	}

	/**
	 * This class is designed to provide basically the same service as {@link System#currentTimeMillis()}, but the time
	 * provided by this class can be "bent" a little ;-).
	 * 
	 * @author Author: Rene Schneider
	 */
	private static class TimeKeeper {

		/**
		 * An offset from realtime that this timekeepers' time has.
		 */
		private long realtimeOffset;

		/**
		 * The time (real) at which the timekeeper was decoupled from actual time.
		 */
		private long realtimeDecouplingTime;

		/**
		 * The current multiplier.
		 */
		private double multiplier;

		/**
		 * Creates a new instance by using the current actual time as decoupling time.
		 * 
		 * @param aMultiplier
		 * @param aStartTime
		 */
		TimeKeeper(long aStartTime, double aMultiplier) {
			realtimeOffset = aStartTime - System.currentTimeMillis();
			realtimeDecouplingTime = System.currentTimeMillis();
			multiplier = aMultiplier;
		}

		/**
		 * Creates an instance from the provided internal state values.
		 * 
		 * @param aMultiplier
		 * @param aStartTime
		 */
		TimeKeeper(long anOffset, long aDecouplingTime, double aMultiplier) {
			realtimeOffset = anOffset;
			realtimeDecouplingTime = aDecouplingTime;
			multiplier = aMultiplier;
		}

		/**
		 * Returns the current time (or: what this timekeeper thinks must be the current time).
		 * 
		 * @return
		 */
		public long currentTimeMillis() {
			long tempTimeSinceDecoupling = System.currentTimeMillis() - realtimeDecouplingTime;
			return realtimeDecouplingTime + realtimeOffset + (long) (tempTimeSinceDecoupling * multiplier);
		}

		/**
		 * Changes the time multiplier. By calling this method, one can alter the speed at which time passes by.
		 * 
		 * @param aMultiplier
		 */
		public void setMultiplier(double aMultiplier) {
			realtimeOffset = currentTimeMillis() - System.currentTimeMillis();
			realtimeDecouplingTime = System.currentTimeMillis();
			multiplier = aMultiplier;
		}
	}
}
