/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.enums;

import java.io.Serializable;

/**
 * Valid commands for test execution control.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum ExecutionCommands implements Serializable {

	/**
	 * Run/continue the test.
	 */
	RUN,

	/**
	 * Pause test execution.
	 */
	PAUSE,

	/**
	 * Single-step.
	 */
	STEP_INTO;

}
