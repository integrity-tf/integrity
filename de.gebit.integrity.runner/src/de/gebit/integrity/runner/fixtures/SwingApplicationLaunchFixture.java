/**
 * 
 */
package de.gebit.integrity.runner.fixtures;

import java.awt.EventQueue;

/**
 * Swing applications are a bit...special. I need a special launching fixture for those...
 * 
 * @author Rene Schneider
 * 
 */
public class SwingApplicationLaunchFixture extends JavaApplicationLaunchFixture {

	@Override
	protected void checkWrapper(ApplicationWrapper aWrapper) throws Throwable {
		super.checkWrapper(aWrapper);

		// Additionally wait for the AWT thread to be started here.
		EventQueue.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				// do nothing
			}
		});

		Thread.sleep(10000);
	}

}
