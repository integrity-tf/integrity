/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import java.nio.charset.Charset;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * A fixture for byte array conversion tests. See issue #66.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class ByteArrayConversionTestFixture {

	@FixtureMethod(description = "Create a byte array from a string")
	public byte[] createByteArrayFromString(@FixtureParameter(name = "string") String aString) {
		return aString.getBytes(Charset.defaultCharset());
	}

	@FixtureMethod(description = "Create a Byte array from a string")
	public Byte[] createByteWrapperArrayFromString(@FixtureParameter(name = "string") String aString) {
		byte[] tempArray = createByteArrayFromString(aString);
		Byte[] tempWrapperArray = new Byte[tempArray.length];

		for (int i = 0; i < tempArray.length; i++) {
			tempWrapperArray[i] = tempArray[i];
		}

		return tempWrapperArray;
	}

	@FixtureMethod(description = "Checks whether the byte array contains the byte representation of 'Test'")
	public boolean testByteArray(@FixtureParameter(name = "array") byte[] aByteArray) {
		return aByteArray != null && aByteArray.length == 4 && aByteArray[0] == 'T' && aByteArray[1] == 'e'
				&& aByteArray[2] == 's' && aByteArray[3] == 't';
	}

	@FixtureMethod(description = "Checks whether the Byte array contains the byte representation of 'Test'")
	public boolean testByteWrapperArray(@FixtureParameter(name = "array") Byte[] aByteArray) {
		return aByteArray != null && aByteArray.length == 4 && aByteArray[0] == 'T' && aByteArray[1] == 'e'
				&& aByteArray[2] == 's' && aByteArray[3] == 't';
	}

	@FixtureMethod(description = "Checks whether the byte array in the container contains the byte representation of 'Test'")
	public boolean testContainer(@FixtureParameter(name = "container") ByteArrayContainer aContainer) {
		return testByteArray(aContainer.getArray());
	}

	@FixtureMethod(description = "Checks whether the Byte array in the container contains the Byte representation of 'Test'")
	public boolean testWrapperContainer(@FixtureParameter(name = "container") ByteWrapperArrayContainer aContainer) {
		return testByteWrapperArray(aContainer.getArray());
	}

	public static class ByteArrayContainer {

		private byte[] array;

		public byte[] getArray() {
			return array;
		}

		public void setArray(byte[] anArray) {
			this.array = anArray;
		}

	}

	public static class ByteWrapperArrayContainer {

		private Byte[] array;

		public Byte[] getArray() {
			return array;
		}

		public void setArray(Byte[] anArray) {
			this.array = anArray;
		}

	}

}
