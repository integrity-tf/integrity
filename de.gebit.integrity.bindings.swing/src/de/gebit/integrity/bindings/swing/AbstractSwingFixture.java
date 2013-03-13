/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.EventQueue;

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

}
