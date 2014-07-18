/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.comparator;


/**
 * The most basic comparison result. This is just a boolean yes/no, without any additional information.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SimpleComparisonResult implements ComparisonResult {

	/**
	 * The boolean value.
	 */
	private boolean isEqual;

	/**
	 * The result value for "equality". Can be used to prevent allocation of new objects.
	 */
	public static final SimpleComparisonResult EQUAL = new SimpleComparisonResult(true);

	/**
	 * The result value for "inequality". Can be used to prevent allocation of new objects.
	 */
	public static final SimpleComparisonResult NOT_EQUAL = new SimpleComparisonResult(false);

	/**
	 * Returns the matching {@link SimpleComparisonResult} for a given boolean value.
	 * 
	 * @param aValue
	 *            the value
	 * @return the {@link SimpleComparisonResult}
	 */
	public static SimpleComparisonResult valueOf(boolean aValue) {
		return aValue ? EQUAL : NOT_EQUAL;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param anEqualityFlag
	 *            whether the result should represent equality or inequality
	 */
	public SimpleComparisonResult(boolean anEqualityFlag) {
		isEqual = anEqualityFlag;
	}

	@Override
	public boolean isSuccessful() {
		return isEqual;
	}

	@Override
	public boolean equals(Object anOther) {
		return (anOther != null && (anOther instanceof SimpleComparisonResult) && ((SimpleComparisonResult) anOther).isEqual == isEqual);
	}

	@Override
	public int hashCode() {
		return (isEqual ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode());
	}

}
