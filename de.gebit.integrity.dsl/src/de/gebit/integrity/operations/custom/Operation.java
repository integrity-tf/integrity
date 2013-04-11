/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.custom;

/**
 * Implement this interface in order to create operation classes. An operation is expected to take zero, one or two
 * parameters (which can be arrays, thus containing multiple values) and return a value (can be an array as well).
 * Operations MUST be side-effect free, since there is no guarantee that a given operation statement leads to any
 * specific number of calls to the underlying operation class!<br />
 * <br/>
 * When an operation is to be executed, its class is instantiated using the default constructor, which must be present
 * and accessible. The resulting instance is used only for a single invocation of the {@link #execute(Object, Object)}
 * method.<br/>
 * <br/>
 * The parameter types supported are similar to those supported for {@link de.gebit.integrity.fixtures.FixtureMethod}
 * parameters, minus enumerations. The same is true for result value types. Integrity will perform autoconversion from
 * values given in test scripts into the types expected by a given operation class.<br/>
 * <br/>
 * Note that an operation must be fine if called with null values, even for expected parameters. This can be the case in
 * various situations. The operation may of course return null as well in that case, if no other behavior is desired.
 * 
 * 
 * 
 * @param <PREFIXPARAM>
 *            the type of the prefix parameter
 * @param <POSTFIXPARAM>
 *            the type of the postfix parameter
 * @param <RESULT>
 *            the result type
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface Operation<PREFIXPARAM extends Object, POSTFIXPARAM extends Object, RESULT extends Object> {

	/**
	 * Executes the operation logic.
	 * 
	 * @param aPrefixParameter
	 *            the prefix parameter, or null if none was given or the value is not available at the time of the call
	 * @param aPostfixParameter
	 *            the postfix parameter, or null if none was given or the value is not available at the time of the call
	 * @return the result value
	 */
	RESULT execute(PREFIXPARAM aPrefixParameter, POSTFIXPARAM aPostfixParameter);

}
