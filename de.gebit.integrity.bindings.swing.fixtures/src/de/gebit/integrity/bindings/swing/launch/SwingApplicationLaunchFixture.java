/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.launch;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

import de.gebit.integrity.runner.fixtures.JavaApplicationLaunchFixture;

/**
 * Swing applications are a bit...special. I need a special launching fixture for those...
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingApplicationLaunchFixture extends JavaApplicationLaunchFixture {

	/**
	 * The default timeout to wait for the applications' frame to appear.
	 */
	private static final long DEFAULT_FRAME_TIMEOUT = 30000;

	/**
	 * The default number of frames to wait for until the application is considered "alive".
	 */
	private static final int DEFAULT_FRAME_COUNT = 1;

	/**
	 * Synchronization object used to wait for the app to start.
	 */
	private final Object startupSync = new Object();

	/**
	 * Whether the application is considered "started".
	 */
	private boolean startupSuccessful;

	@Override
	protected boolean checkWrapper(ApplicationWrapper aWrapper) throws Throwable {
		FrameWaiter tempWaiter = new FrameWaiter(getFrameTimeout(), getFrameCount());

		synchronized (startupSync) {
			tempWaiter.start();

			startupSync.wait();
		}

		return startupSuccessful;
	}

	@Override
	protected boolean isAliveInternal(ApplicationWrapper aWrapper) {
		// A Swing application is alive if its AWT Eventqueue is alive
		Thread[] tempArray = new Thread[1000];
		Thread.enumerate(tempArray);

		for (Thread tempThread : tempArray) {
			if (tempThread.getName().startsWith("AWT-EventQueue-")) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected boolean killInternal(ApplicationWrapper aWrapper) {
		// A Swing application is killed by closing all frames. This of course
		// leaves the Integrity thread, but
		// that must be allowed to kill itself after finishing all tests and
		// writing all results.
		for (Window tempWindow : Window.getWindows()) {
			if (tempWindow instanceof JFrame) {
				((JFrame) tempWindow).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			tempWindow.dispose();
		}

		return super.killInternal(aWrapper);
	}

	protected long getFrameTimeout() {
		return DEFAULT_FRAME_TIMEOUT;
	}

	protected int getFrameCount() {
		return DEFAULT_FRAME_COUNT;
	}

	/**
	 * Waits for the applications' frame(s) to come up after launch.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class FrameWaiter extends Thread {

		/**
		 * The nanoseconds to wait for.
		 */
		private long timeoutNanos;

		/**
		 * The number of frames to wait for.
		 */
		private int numberOfFrames;

		/**
		 * Creates an instance.
		 */
		public FrameWaiter(long aTimeout, int aNumberOfFrames) {
			timeoutNanos = aTimeout * 1000000L;
			numberOfFrames = aNumberOfFrames;
		}

		@Override
		public void run() {
			long tempStart = System.nanoTime();

			while (tempStart + timeoutNanos > System.nanoTime()) {
				if (areFramesVisible() && isEventThreadReactive()) {
					synchronized (startupSync) {
						startupSuccessful = true;
						startupSync.notifyAll();
						return;
					}
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException exc) {
					// ignored
				}
			}

			synchronized (startupSync) {
				startupSync.notifyAll();
			}
		}

		/**
		 * Checks whether enough frames have become visible.
		 * 
		 * @return true or false
		 */
		protected boolean areFramesVisible() {
			int tempVisibleCount = 0;

			for (Frame tempFrame : Frame.getFrames()) {
				if (tempFrame.isVisible()) {
					tempVisibleCount++;
				}
			}

			return (tempVisibleCount >= numberOfFrames);
		}

		/**
		 * Checks whether the AWT event thread is reacting and processing messages.
		 * 
		 * @return true if it is processing messages, false if not.
		 */
		protected boolean isEventThreadReactive() {
			try {
				EventQueue.invokeAndWait(new Runnable() {

					@Override
					public void run() {
						return;
					}
				});

				return true;
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			} catch (InvocationTargetException exc) {
				exc.printStackTrace();
			}

			return false;
		}

	}

}
