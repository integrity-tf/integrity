/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.entities.setlist;

/**
 * The various types of set list entries.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public enum SetListEntryTypes {

	/**
	 * The root entry.
	 */
	EXECUTION,

	/**
	 * Assignment of new value to variable.
	 */
	VARIABLE_ASSIGNMENT,

	/**
	 * Suite call.
	 */
	SUITE,

	/**
	 * Setup suite call.
	 */
	SETUP,

	/**
	 * Teardown suite call.
	 */
	TEARDOWN,

	/**
	 * Test execution.
	 */
	TEST,

	/**
	 * Table test execution.
	 */
	TABLETEST,

	/**
	 * Call execution.
	 */
	CALL,

	/**
	 * Test/Call result.
	 */
	RESULT,

	/**
	 * Variable update inside a call result.
	 */
	VARIABLE_UPDATE,

	/**
	 * Parameter definition.
	 */
	PARAMETER,

	/**
	 * Test comparison.
	 */
	COMPARISON,

	/**
	 * Comment.
	 */
	COMMENT,

	/**
	 * Time setting.
	 */
	TIMESET;

}
