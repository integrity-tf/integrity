/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JDialog;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class AbstractSwingFixture extends AbstractSwingComponentHandler {

	protected static final int DEFAULT_EVENT_QUEUE_WAIT_TIMEOUT = 30000;

	protected static final int DEFAULT_EVENT_QUEUE_WAIT_COUNT = 1;

	protected void runOnEventQueue(Runnable aRunnable) {
		EventQueue.invokeLater(aRunnable);
	}

	protected void runOnEventQueueAndWait(Runnable aRunnable) throws EventQueueTimeoutException {
		runOnEventQueue(aRunnable);
		waitForEventQueue();
	}

	protected void waitForEventQueue() throws EventQueueTimeoutException {
		if (!new EventQueueSynchronizer().waitForEventQueueMultipleTimes(getEventQueueWaitTimeout(),
				getEventQueueWaitCount())) {
			throw new EventQueueTimeoutException("Timed out while waiting for event queue ("
					+ getEventQueueWaitTimeout() + " msecs)");
		}
	}

	protected int getEventQueueWaitCount() {
		return DEFAULT_EVENT_QUEUE_WAIT_COUNT;
	}

	protected int getEventQueueWaitTimeout() {
		return DEFAULT_EVENT_QUEUE_WAIT_TIMEOUT;
	}

	protected JDialog findFocusedDialog() {
		Window tempFocused = findFocusedWindow();
		if (tempFocused instanceof JDialog) {
			return (JDialog) tempFocused;
		}

		return null;
	}

	protected JDialog findFocusedDialogGuarded() {
		JDialog tempDialog = findFocusedDialog();
		if (tempDialog == null) {
			throw new IllegalStateException("No focused dialog was found!");
		} else {
			return tempDialog;
		}
	}

	protected Window findFocusedWindowGuarded() {
		Window tempWindow = findFocusedWindow();
		if (tempWindow == null) {
			throw new IllegalStateException("No focused window was found!");
		} else {
			return tempWindow;
		}
	}

	protected Window findFocusedWindow() {
		return new FocusWindowFinder().findFocusedWindow();
	}

	protected static class FocusWindowFinder {

		public Window window;

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
