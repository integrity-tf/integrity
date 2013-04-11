/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.basic;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.bindings.swing.EventQueueSynchronizer;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * Provides some fixture methods which wait a certain time or for the event queue.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingWaitFixture extends AbstractSwingFixture {

	/**
	 * Waits for a fixed time.
	 * 
	 * @param aSecondTime
	 *            the time in seconds to wait
	 */
	@FixtureMethod(description = "Wait for $seconds$ seconds.")
	public void wait(@FixtureParameter(name = "seconds") Double aSecondTime) {
		long tempNanoseconds = (long) (aSecondTime * 1000000000.0);

		long tempStart = System.nanoTime();
		long tempEnd = tempStart + tempNanoseconds;
		do {
			long tempLeft = tempEnd - System.nanoTime();

			if (tempLeft > 0) {
				try {
					Thread.sleep(tempLeft / 1000000L);
				} catch (InterruptedException exc) {
					// ignored
				}
			}
		} while (System.nanoTime() - tempEnd > 0);
	}

	/**
	 * Waits for the AWT event queue to process all pending events.
	 * 
	 * @param aNumberOfTimes
	 *            the number of synchronization events to use for waiting (default is {@link #getEventQueueWaitCount()})
	 * @param aTimeout
	 *            the timeout in seconds (default is {@link #getEventQueueWaitTimeout()})
	 */
	@FixtureMethod(description = "Wait for AWT Event Queue")
	public void waitForEventQueue(@FixtureParameter(name = "count", optional = true) Integer aNumberOfTimes,
			@FixtureParameter(name = "timeout", optional = true) Double aTimeout) {
		int tempNumberOfTimes = getEventQueueWaitCount();
		if (aNumberOfTimes != null) {
			tempNumberOfTimes = aNumberOfTimes;
		}

		int tempTimeout = getEventQueueWaitTimeout();
		if (aTimeout != null) {
			tempTimeout = (int) (aTimeout * 1000.0);
		}

		new EventQueueSynchronizer().waitForEventQueueMultipleTimes(tempNumberOfTimes, tempTimeout);
	}

}
