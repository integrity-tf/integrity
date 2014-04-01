/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class EnumTestBean {

	private InnerEnum enumValue;

	public InnerEnum getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(InnerEnum enumValue) {
		this.enumValue = enumValue;
	}

	public static enum InnerEnum {

		VALUE1,

		VALUE2,

		VALUE3;

	}

}
