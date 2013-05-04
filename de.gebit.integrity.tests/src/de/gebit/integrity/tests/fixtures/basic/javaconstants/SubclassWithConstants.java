/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.javaconstants;

/**
 * A subclass with constant values, inheriting constants from above. Used in the Java constants test.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class SubclassWithConstants extends ClassWithConstants {

	public static final Object BEAN_CONSTANT = new InnerBeanClass();

	public static class InnerBeanClass {

		private String stringValue = "String";

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

		@Override
		public String toString() {
			return "InnerBeanClass: " + stringValue;
		}

	}

}
