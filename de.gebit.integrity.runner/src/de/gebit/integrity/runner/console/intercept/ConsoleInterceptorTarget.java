/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console.intercept;

/**
 * Implement this interface to be able to receive intercepted console lines from the {@link ConsoleOutputInterceptor}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ConsoleInterceptorTarget {

	/**
	 * Called for each intercepted line.
	 * 
	 * @param aLine
	 *            the line
	 * @param anStdErrFlag
	 *            whether the line was intercepted on stderr
	 */
	void onLine(String aLine, boolean anStdErrFlag);

}
