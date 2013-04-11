/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import org.eclipse.xtext.common.types.JvmField;

/**
 * Container class that links a named result name to a field.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ResultFieldTuple {

	/**
	 * The result name.
	 */
	private String resultName;

	/**
	 * The field.
	 */
	private JvmField field;

	/**
	 * Creates a new instance.
	 * 
	 * @param aResultName
	 * @param aField
	 */
	public ResultFieldTuple(String aResultName, JvmField aField) {
		super();
		resultName = aResultName;
		field = aField;
	}

	public String getResultName() {
		return resultName;
	}

	public JvmField getField() {
		return field;
	}

}
