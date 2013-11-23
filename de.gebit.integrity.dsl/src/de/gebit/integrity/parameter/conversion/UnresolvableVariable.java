/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

/**
 * This instance is used for variable resolving in case of
 * {@link UnresolvableVariableHandling#RESOLVE_TO_UNRESOLVABLE_OBJECT}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class UnresolvableVariable {

	/**
	 * Singleton instance.
	 */
	private static final UnresolvableVariable INSTANCE = new UnresolvableVariable();

	private UnresolvableVariable() {
		// private constructor
	}

	public static UnresolvableVariable getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "???";
	}

}
