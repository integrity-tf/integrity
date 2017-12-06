/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.time;

/**
 * An interface for a "time adapter" that funnels the parameters for deterministic time and date setting during testing
 * into an application. The idea behind this is that you (as developer of the system-under-test) use a proxy mechanism
 * to get time/date information in your software instead of directly using the data provided by the JVM. This proxy
 * either directly forwards the current date/time from the JVM, or has the ability to modify these values in order to
 * make time/date deterministic in automatic test environments.<br>
 * <br>
 * Of course this proxy and the proxying mechanism become a hard dependency of your software - it must be available
 * during runtime on the production system. This usually prohibits the direct use of an Integrity-provided class for
 * this - most developers don't want to put test automation frameworks onto production installations. Instead, you are
 * encouraged to create a proxy mechanism yourself in your application and then write an "adapter" to make this proxy
 * configurable via Integrity.<br>
 * <br>
 * A sample class for such a proxy is provided in the TestTimeSingleton (you can actually use this directly in an
 * application, but if the class comes from the Integrity jars, you will be dependent on them in production mode).
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface TestTimeAdapter {

	/**
	 * Sets the current date and time that is to be used for the system under test. Depending on the parameters, the
	 * time is intended to be frozen (if no progression factor or one of 0.0 is provided) or to progress at a certain
	 * speed relative to real-time. From the provided parameters, an accurate test time can be calculated.<br>
	 * <br>
	 * If the realtime offset is zero and the progression factor is exactly 1.0, this means that the "fake test time" is
	 * reverted to actual realtime.
	 * 
	 * @param aRealtimeOffset
	 *            the offset of our test time from real system time (wall clock)
	 * @param aRealtimeDecouplingTime
	 *            the point in real time at which our test time was decoupled from system time
	 * @param aProgressionFactor
	 *            the speed at which the test time should progress (1.0 is normal speed, progression factor may be
	 *            negative too, or 0.0, which means time is frozen)
	 */
	void setInternalState(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor);

}
