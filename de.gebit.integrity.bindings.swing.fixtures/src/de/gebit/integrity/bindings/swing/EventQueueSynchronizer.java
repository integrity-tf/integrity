/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

import java.awt.EventQueue;

/**
 * Can be used to synchronize execution of any thread with the AWT Event Queue.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class EventQueueSynchronizer {

	private static class SyncObject {

		/**
		 * Whether this sync object has been touched.
		 */
		private volatile boolean touched;

		public boolean isTouched() {
			return touched;
		}

		public void touch() {
			touched = true;
		}
	}

	/**
	 * Waits for the event queue to be emptied or the specified timeout to elapse.
	 * 
	 * @param aTimeout
	 *            the timeout in milliseconds (0 for infinity)
	 * @return true if the queue emptied in time, false if the timeout was hit
	 */
	public boolean waitForEventQueue(long aTimeout) {
		final SyncObject syncObject = new SyncObject();

		synchronized (syncObject) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					synchronized (syncObject) {
						syncObject.touch();
						syncObject.notifyAll();
					}
				}
			});

			long tempTimeout = aTimeout * 1000000L; // using nanoseconds here
			long tempStart = System.nanoTime();
			long tempLeft = tempTimeout;
			while (!syncObject.isTouched() && (aTimeout == 0 || tempLeft > 0)) {
				try {
					if (aTimeout == 0) {
						syncObject.wait();
					} else {
						syncObject.wait(tempLeft / 1000000L);
					}
				} catch (InterruptedException exc) {
					// ignore
				}
				tempLeft = tempTimeout - (System.nanoTime() - tempStart);
			}

			return syncObject.isTouched();
		}
	}

	/**
	 * Waits for the event queue to be emptied.
	 */
	public void waitForEventQueue() {
		waitForEventQueue(0);
	}

	/**
	 * Waits several times for the event queue to be emptied.
	 * 
	 * @param aNumberOfTimes
	 *            number of times to wait
	 */
	public void waitForEventQueueMultipleTimes(int aNumberOfTimes) {
		waitForEventQueueMultipleTimes(0, aNumberOfTimes);
	}

	/**
	 * Waits several times for the event queue to be emptied.
	 * 
	 * @param aNumberOfTimes
	 *            number of times to wait
	 */
	public boolean waitForEventQueueMultipleTimes(int aTimeout, int aNumberOfTimes) {
		for (int i = 0; i < aNumberOfTimes; i++) {
			if (!waitForEventQueue(aTimeout)) {
				return false;
			}
		}

		return true;
	}

}
