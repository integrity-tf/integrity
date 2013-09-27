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
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;

/**
 * This {@link ModelChecker} implementation does not perform any checks. The normally used checker is replaced with this
 * one if the checks shall be omitted (for example for performance reasons).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class NullModelChecker implements ModelChecker {

	@Override
	public void check(Test aTest) throws ModelRuntimeLinkException {
		// do nothing
	}

	@Override
	public void check(Call aCall) throws ModelRuntimeLinkException {
		// do nothing
	}

	@Override
	public void check(TableTest aTableTest) throws ModelRuntimeLinkException {
		// do nothing
	}

	@Override
	public void check(CustomOperation aCustomOperation) throws ModelRuntimeLinkException {
		// do nothing
	}

	@Override
	public void check(Suite aSuite) throws ModelRuntimeLinkException {
		// do nothing
	}

}
