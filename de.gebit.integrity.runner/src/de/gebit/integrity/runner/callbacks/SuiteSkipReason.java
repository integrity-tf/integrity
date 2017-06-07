/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks;

/**
 * A number of reasons why a suite invocation in a script has been skipped.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public enum SuiteSkipReason {

	/**
	 * The call is only to be made for specific variants and the current variant is not matched.
	 */
	VARIANT_MISMATCH,

	/**
	 * The suite is a single-run suite and has already been invoked.
	 */
	SINGLE_RUN_EXECUTED;

}
