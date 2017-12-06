/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.time;

import com.google.inject.Inject;

import de.gebit.integrity.runner.IntegrityRunnerModule;

/**
 * A simple default implementation of a {@link TestTimeAdapter}, which just tries to instantiate the "real" adapter
 * implemented by the system-under-test by resolving the class name of a system property. The adapter shall then forward
 * the parameters to the actual time proxy implementation.<br>
 * <br>
 * You can either use this mechanism to inject your adapter or, if you think it's a little bit dirty to use a system
 * property, you can also override this adapter directly by specifying a different one in a custom subclass of the
 * {@link IntegrityRunnerModule} (the same class where you can basically customize the entire service set of internal
 * Integrity services).
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class SimpleTestTimeAdapter implements TestTimeAdapter {

	/**
	 * The system property used by this adapter to instantiate the actual adapter supplied by the system-under-test,
	 * which has the purpose to forward the fake time parameters to the test time provider in the application.
	 */
	public static final String SUT_TIME_ADAPTER_CLASS_PROPERTY = "integrity.runner.timeadapter";

	/**
	 * The adapter provided by the system-under-test.
	 */
	protected TestTimeAdapter systemUnderTestAdapter;

	/**
	 * The classloader to use when resolving {@link #SUT_TIME_ADAPTER_CLASS_PROPERTY}.
	 */
	@Inject
	protected ClassLoader classLoader;

	@Override
	public void setTestTime(long aRealtimeOffset, long aRealtimeDecouplingTime, double aProgressionFactor) {
		if (systemUnderTestAdapter == null) {
			String tempClass = System.getProperty(SUT_TIME_ADAPTER_CLASS_PROPERTY);
			if (tempClass == null) {
				throw new UnsupportedOperationException("No test time adapter class provided by the application - see '"
						+ getClass().getName() + "' and system property '" + SUT_TIME_ADAPTER_CLASS_PROPERTY
						+ "' for more information regarding deterministic time/date handling.");
			} else {
				try {
					Class<?> tempClazz = classLoader.loadClass(tempClass);

					if (!TestTimeAdapter.class.isAssignableFrom(tempClazz)) {
						throw new IllegalArgumentException("Test time adapter class '" + tempClass
								+ "' does not implement '" + TestTimeAdapter.class.getName() + "' - see '"
								+ getClass().getName() + "' and system property '" + SUT_TIME_ADAPTER_CLASS_PROPERTY
								+ "' for more information regarding deterministic time/date handling.");
					}

					systemUnderTestAdapter = (TestTimeAdapter) tempClazz.newInstance();
				} catch (ClassNotFoundException exc) {
					throw new IllegalArgumentException("Did not find test time adapter " + tempClass, exc);
				} catch (InstantiationException | IllegalAccessException exc) {
					throw new IllegalArgumentException("Failed to instantiate test time adapter " + tempClass, exc);
				}
			}
		}

		systemUnderTestAdapter.setTestTime(aRealtimeOffset, aRealtimeDecouplingTime, aProgressionFactor);
	}

}
