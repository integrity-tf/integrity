/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JDialog;

/**
 * Abstract base class for Swing component fixtures.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AbstractSwingFixture extends AbstractSwingComponentHandler {

	/**
	 * The default time to wait for the event thread to become ready.
	 */
	protected static final int DEFAULT_EVENT_QUEUE_WAIT_TIMEOUT = 30000;

	/**
	 * The default number of times to wait for the event thread to become ready.
	 */
	protected static final int DEFAULT_EVENT_QUEUE_WAIT_COUNT = 1;

	/**
	 * Run the provided {@link Runnable} on the event queue.
	 * 
	 * @param aRunnable
	 */
	protected void runOnEventQueue(Runnable aRunnable) {
		EventQueue.invokeLater(aRunnable);
	}

	/**
	 * Run the provided {@link Runnable} on the event queue and then wait for the event queue to settle down.
	 * 
	 * @param aRunnable
	 *            the runnable
	 * @throws EventQueueTimeoutException
	 */
	protected void runOnEventQueueAndWait(Runnable aRunnable) throws EventQueueTimeoutException {
		runOnEventQueue(aRunnable);
		waitForEventQueue();
	}

	/**
	 * Wait for the event queue to process all pending messages.
	 * 
	 * @throws EventQueueTimeoutException
	 */
	protected void waitForEventQueue() throws EventQueueTimeoutException {
		if (!new EventQueueSynchronizer().waitForEventQueueMultipleTimes(getEventQueueWaitTimeout(),
				getEventQueueWaitCount())) {
			throw new EventQueueTimeoutException("Timed out while waiting for event queue ("
					+ getEventQueueWaitTimeout() + " msecs)");
		}
	}

	/**
	 * Returns the number of times to wait for the event queue. In some cases, one might need to wait multiple times,
	 * for example if events being executed add more events on the event queue (waiting for the queue is performed by
	 * pushing an event on the queue and waiting for it to be processed, so events added after that special event was
	 * added will not be waited for).
	 * 
	 */
	protected int getEventQueueWaitCount() {
		return DEFAULT_EVENT_QUEUE_WAIT_COUNT;
	}

	/**
	 * The timeout to use when waiting for the event queue.
	 */
	protected int getEventQueueWaitTimeout() {
		return DEFAULT_EVENT_QUEUE_WAIT_TIMEOUT;
	}

	/**
	 * Finds the currently focused dialog. Returns null if no dialog is in focus.
	 * 
	 * @return the focused dialog or null
	 */
	protected JDialog findFocusedDialog() {
		Window tempFocused = findFocusedWindow();
		if (tempFocused instanceof JDialog) {
			return (JDialog) tempFocused;
		}

		return null;
	}

	/**
	 * Finds the currently focused dialog. This throws an {@link IllegalStateException} if no focused dialog was found.
	 * 
	 * @return the dialog
	 */
	protected JDialog findFocusedDialogGuarded() {
		JDialog tempDialog = findFocusedDialog();
		if (tempDialog == null) {
			throw new IllegalStateException("No focused dialog was found!");
		} else {
			return tempDialog;
		}
	}

	/**
	 * Finds the focused window. This throws an {@link IllegalStateException} if no focused window was found.
	 * 
	 * @return the window
	 */
	protected Window findFocusedWindowGuarded() {
		Window tempWindow = findFocusedWindow();
		if (tempWindow == null) {
			throw new IllegalStateException("No focused window was found!");
		} else {
			return tempWindow;
		}
	}

	/**
	 * Finds the window currently in focus.
	 * 
	 * @return The window or null if no window is currently in focus
	 */
	protected Window findFocusedWindow() {
		return new FocusWindowFinder().findFocusedWindow();
	}

	/**
	 * Finds the window currently in focus.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected static class FocusWindowFinder {

		/**
		 * Used to store the window.
		 */
		private Window window;

		/**
		 * Finds the currently focused window.
		 * 
		 * @return the window or null if none is in focus.
		 */
		public Window findFocusedWindow() {
			try {
				EventQueue.invokeAndWait(new Runnable() {

					@Override
					public void run() {
						window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
					}
				});
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			} catch (InvocationTargetException exc) {
				exc.printStackTrace();
			}

			return window;
		}

	}

}
