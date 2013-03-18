/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class SwingWaitFixture extends AbstractSwingFixture {

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

	@FixtureMethod(description = "Wait for AWT Event Queue")
	public void waitForEventQueue(@FixtureParameter(name = "count", optional = true) Integer aNumberOfTimes,
			@FixtureParameter(name = "timeout", optional = true) Integer aTimeout) {
		int tempNumberOfTimes = getEventQueueWaitCount();
		if (aNumberOfTimes != null) {
			tempNumberOfTimes = aNumberOfTimes;
		}

		int tempTimeout = getEventQueueWaitTimeout();
		if (aTimeout != null) {
			tempTimeout = aTimeout;
		}

		waitForEventQueue(tempNumberOfTimes, tempTimeout);
	}

}
