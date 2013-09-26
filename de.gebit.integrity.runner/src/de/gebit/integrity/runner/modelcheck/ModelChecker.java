/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.modelcheck;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;

/**
 * The model checker is used to validate a test model prior to execution, with the goal being to capture commonly
 * occurring problems before they "crash" the system, thereby usually providing only basic information about the
 * problem. The checks in this checker are supposed to deliver readable, substantial information about erroneous
 * situations in order to aid the user in fixing the problem.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ModelChecker {

	/**
	 * Validates a test.
	 * 
	 * @param aTest
	 *            the test to check
	 * @throws ModelRuntimeLinkException
	 */
	void check(Test aTest) throws ModelRuntimeLinkException;

	/**
	 * Validates a call.
	 * 
	 * @param aCall
	 *            the call to check
	 * @throws ModelRuntimeLinkException
	 */
	void check(Call aCall) throws ModelRuntimeLinkException;

	/**
	 * Validates a tabletest.
	 * 
	 * @param aTableTest
	 *            the tabletest to check
	 * @throws ModelRuntimeLinkException
	 */
	void check(TableTest aTableTest) throws ModelRuntimeLinkException;

	/**
	 * Validates a custom operation.
	 * 
	 * @param aCustomOperation
	 *            the custom operation to check
	 * @throws ModelRuntimeLinkException
	 */
	void check(CustomOperation aCustomOperation) throws ModelRuntimeLinkException;

}
