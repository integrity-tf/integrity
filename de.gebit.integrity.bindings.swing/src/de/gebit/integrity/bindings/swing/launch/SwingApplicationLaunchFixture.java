/**
 * 
 */
package de.gebit.integrity.bindings.swing.launch;

import java.awt.EventQueue;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

import de.gebit.integrity.runner.fixtures.JavaApplicationLaunchFixture;

/**
 * Swing applications are a bit...special. I need a special launching fixture for those...
 * 
 * @author Rene Schneider
 * 
 */
public class SwingApplicationLaunchFixture extends JavaApplicationLaunchFixture {

	private static final long DEFAULT_FRAME_TIMEOUT = 30000;

	private static final int DEFAULT_FRAME_COUNT = 1;

	private final Object startupSync = new Object();

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
		// A Swing application is killed by closing all frames. This of course leaves the Integrity thread, but
		// that must be allowed to kill itself after finishing all tests and writing all results.
		for (Frame tempFrame : Frame.getFrames()) {
			if (tempFrame instanceof JFrame) {
				((JFrame) tempFrame).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tempFrame.dispose();
			} else {
				tempFrame.setVisible(false);
			}
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
	 * 
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	protected class FrameWaiter extends Thread {

		private long timeoutNanos;

		private int numberOfFrames;

		/**
		 * 
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

		protected boolean areFramesVisible() {
			int tempVisibleCount = 0;

			for (Frame tempFrame : Frame.getFrames()) {
				if (tempFrame.isVisible()) {
					tempVisibleCount++;
				}
			}

			return (tempVisibleCount >= numberOfFrames);
		}

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
