/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console.intercept;

import com.google.inject.Inject;

/**
 * Default implementation of an interception aggregator. This one uses the {@link ConsoleOutputInterceptor} to do the
 * actual intercepting.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultConsoleInterceptionAggregator implements ConsoleInterceptionAggregator {

	/**
	 * A sync object used to synchronize access to the interception buffer.
	 */
	protected final Object interceptionSync = new Object();

	/**
	 * The currently active interception job.
	 */
	protected Intercept currentIntercept;

	/**
	 * Whether interception is temporarily paused. This flag is used for quick and lightweight interception pauses.
	 */
	protected volatile boolean interceptPaused;

	/**
	 * The interceptor target used to receive intercepted lines.
	 */
	protected ConsoleInterceptorTarget interceptorTarget;

	/**
	 * The interceptor service.
	 */
	@Inject
	protected ConsoleOutputInterceptor interceptor;

	@Override
	public void startIntercept() {
		if (interceptorTarget == null) {
			currentIntercept = new Intercept();
			interceptorTarget = new ConsoleInterceptorTarget() {

				@Override
				public void onLine(String aLine, boolean anStdErrFlag) {
					if (!interceptPaused) {
						synchronized (interceptionSync) {
							currentIntercept.addLine(new InterceptedLine(aLine, anStdErrFlag));
						}
					}
				}
			};
			interceptor.registerTarget(interceptorTarget);
		}
	}

	@Override
	public void stopIntercept() {
		if (interceptorTarget != null) {
			interceptor.unregisterTarget(interceptorTarget);
			interceptorTarget = null;
		}
	}

	@Override
	public void pauseIntercept() {
		interceptPaused = true;
	}

	@Override
	public void resumeIntercept() {
		interceptPaused = false;
	}

	@Override
	public Intercept retrieveIntercept() {
		synchronized (interceptionSync) {
			currentIntercept.setEndTimestamp();

			Intercept tempIntercept = currentIntercept;
			currentIntercept = new Intercept();
			return tempIntercept;
		}
	}

}
