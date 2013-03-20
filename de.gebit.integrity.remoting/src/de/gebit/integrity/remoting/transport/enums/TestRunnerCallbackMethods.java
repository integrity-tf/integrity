/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport.enums;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public enum TestRunnerCallbackMethods {

	EXECUTION_START,

	SUITE_START,

	SETUP_START,

	SETUP_FINISH,

	TEST_START,

	TEST_FINISH,

	TABLE_TEST_START,

	TABLE_TEST_ROW_START,

	TABLE_TEST_ROW_FINISH,

	TABLE_TEST_FINISH,

	CALL_START,

	CALL_FINISH,

	TEAR_DOWN_START,

	TEAR_DOWN_FINISH,

	SUITE_FINISH,

	EXECUTION_FINISH,

	VARIABLE_DEFINITION,

	VISIBLE_COMMENT,

	VISIBLE_DIVIDER,

}
